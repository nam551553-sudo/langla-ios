package beatdz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import java.util.*;

/** Account ownership is explicit and inherited by newly created networking/asset threads. */
public final class MultiSession {
    public interface State { void initialize(); }
    public interface Factory<T> { T create(); }
    private static final Map<String, Integer> KEYS = new HashMap<String, Integer>();
    public static synchronized int register(String key) {
        Integer id = KEYS.get(key);
        if (id == null) { id = KEYS.size(); KEYS.put(key, id); }
        return id;
    }
    private static final class Cell {
        State value;
        volatile boolean ready;
        Thread initializing;
    }
    public static final int LIMIT = 6;
    public static final class Context {
        public final int slot;
        private volatile Cell[] states = new Cell[128];
        private boolean initialized;
        Context(int slot) { this.slot = slot; }
        <T extends State> T state(String key, Factory<T> factory) { return state(register(key), factory); }
        @SuppressWarnings("unchecked") <T extends State> T state(int key, Factory<T> factory) {
            Cell[] entries = states;
            Cell cell = key < entries.length ? entries[key] : null;
            if (cell != null && cell.ready) return (T)cell.value;
            synchronized (this) {
                if (key >= states.length) states = Arrays.copyOf(states, Math.max(key + 1, states.length * 2));
                cell = states[key];
                if (cell != null && (cell.ready || cell.initializing == Thread.currentThread())) return (T)cell.value;
                cell = new Cell(); cell.value = factory.create(); cell.initializing = Thread.currentThread(); states[key] = cell;
                try { cell.value.initialize(); cell.ready = true; return (T)cell.value; }
                catch (RuntimeException | Error failure) { states[key] = null; throw failure; }
                finally { cell.initializing = null; }
            }
        }
    }
    private static final Context ROOT = new Context(0);
    private static final List<Context> TABS = new ArrayList<Context>();
    private static final InheritableThreadLocal<Context> OWNER = new InheritableThreadLocal<Context>();
    private static volatile Context active = ROOT;
    private static volatile int tabCount = 1;
    static final java.util.concurrent.Semaphore PREFETCH_NETWORK = new java.util.concurrent.Semaphore(1);
    private static Stage bar;
    private static BitmapFont font;
    private static int barCount = -1;
    private static float lastWidth;
    private static com.badlogic.gdx.graphics.Texture skin;
    static { ROOT.initialized = true; TABS.add(ROOT); }

    public static Context current() { Context value = OWNER.get(); return value == null ? ROOT : value; }
    public static <T extends State> T state(int key, Factory<T> factory) { return current().state(key, factory); }
    public static int count() { return tabCount; }
    public static int selected() { return active.slot; }
    public static boolean visible() { return current() == active; }
    public static void run(Context context, Runnable action) {
        Context before = OWNER.get(); OWNER.set(context);
        try { action.run(); } finally { if (before == null) OWNER.remove(); else OWNER.set(before); }
    }
    public static Runnable bind(Runnable action) { Context owner = current(); return () -> run(owner, action); }
    public static int barHeight() {
        if (Gdx.app.getType() == com.badlogic.gdx.Application.ApplicationType.iOS) return 0;
        return Math.round(28 * Math.max(1f, Math.min(2f, Gdx.graphics.getDensity())));
    }

    public static String storageName(String name) {
        String key = name.endsWith(".beatdz") ? name.substring(0, name.length() - 7) : name;
        if (current().slot == 0 || key.startsWith("tree_") || key.startsWith("char_") || key.startsWith("client_")
            || key.startsWith("font_") || key.startsWith("arr_map_") || key.startsWith("map") || key.startsWith("music") || key.startsWith("sound")
            || key.startsWith("arr_data_game") || key.startsWith("arr_check_") || key.equals("arr_full") || key.equals("arr_savemap")
            || key.equals("arr_keys") || key.equals("arr_screen") || key.equals("arr_iconname")) return name;
        return "profiles/tab" + (current().slot + 1) + "/" + name;
    }

    public static boolean add() {
        if (TABS.size() >= LIMIT) return false;
        Context previous = active;
        DataCenter template = ROOT.state("beatdz.DataCenter", DataCenter.SessionState::new).bg;
        mConfig config = mConfig.gI();
        // Wait for the first account's asset initialization; don't start six competing downloads.
        if (template == null || template.MapTemplate == null || !template.ba || !template.bb) return false;
        Context context = new Context(TABS.size());
        TABS.add(context);
        tabCount = TABS.size();
        for (Context tab : TABS) run(tab, MapAssetPrefetch::trimBudget);
        try {
            run(context, () -> {
                DataCenter data = DataCenter.gI();
                data.initializeAccountView(template);
                mConfig.gI().copySettingsFrom(config);
                AppListener.gI().canvas.applyZoomScreen();
                Session session = Session.gI(); session.keyApp = AppListener.keyApp;
                Controller.$state_Controller().instance = new Controller();
                session.handler = Controller.$state_Controller().instance;
                data.setScreen(new LoginPCScreen());
                context.initialized = true;
            });
            select(context.slot); return true;
        } catch (RuntimeException error) {
            TABS.remove(context); tabCount = TABS.size(); active = previous; OWNER.set(previous);
            Gdx.app.error("MultiSession", "Cannot initialize account tab", error); return false;
        }
    }

    public static void select(int slot) {
        if (slot < 0 || slot >= TABS.size() || TABS.get(slot) == active) return;
        run(active, () -> {
            DataCenter data = DataCenter.gI();
            if (data.currentScreen != null) for (Object item : data.currentScreen.cD) ((LangLa_cx)item).cO.a();
            Char.gI().cleanMove();
            if (LangLa_dp.$state_LangLa_dp().f != null) LangLa_dp.a().b();
        });
        active = TABS.get(slot); OWNER.set(active);
        AppListener.gI().canvas.cancelPointer();
        AppListener.gI().canvas.activateSession();
        Gdx.input.setOnscreenKeyboardVisible(false);
    }

    /** Hidden accounts keep the original 30 Hz simulation; no paint, stage or effect upload. */
    public static void updateHidden(Canvas canvas) {
        Context selected = active;
        for (Context context : TABS) if (context != selected && context.initialized) {
            run(context, () -> {
                DataCenter data = DataCenter.gI();
                if (data.currentScreen == null || data.aO == null) return;
                data.i++; data.h++; data.aO.a = false;
                if (AppListener.$state_AppListener().h > 0 && --AppListener.$state_AppListener().h == 0) data.g();
                canvas.update();
            });
        }
    }

    public static void attach(InputMultiplexer input) {
        if (Gdx.app.getType() == com.badlogic.gdx.Application.ApplicationType.iOS) return;
        if (bar == null) { bar = new Stage(new ScreenViewport()); font = new BitmapFont(); }
        bar.getViewport().update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);
        input.addProcessor(0, bar);
        barCount = -1;
    }

    public static void drawBar() {
        if (Gdx.app.getType() == com.badlogic.gdx.Application.ApplicationType.iOS) return;
        if (bar == null) return;
        float scale = Math.max(1f, Math.min(2f, Gdx.graphics.getDensity()));
        float width = Gdx.graphics.getWidth();
        if (barCount != TABS.size() || width != lastWidth) {
            bar.clear(); font.getData().setScale(.85f * scale);
            for (int i = 0; i <= TABS.size() && i < LIMIT + 1; i++) {
                if (i == TABS.size() && TABS.size() == LIMIT) break;
                final int slot = i;
                TextButton.TextButtonStyle style = new TextButton.TextButtonStyle(); style.font = font;
                style.fontColor = Color.WHITE;
                TextButton button = new TextButton(i == TABS.size() ? "+" : String.valueOf(i + 1), style);
                button.setBounds(6 * scale + i * 38 * scale, Gdx.graphics.getHeight() - barHeight() + 3 * scale, 34 * scale, 22 * scale);
                button.addListener(new ClickListener() { @Override public void clicked(InputEvent event, float x, float y) { if (slot == TABS.size()) add(); else select(slot); } });
                bar.addActor(button);
            }
            barCount = TABS.size(); lastWidth = width;
            skin = null;
        }
        mImage image = LangLa_fq.a(7);
        com.badlogic.gdx.graphics.Texture nextSkin = image != null && image.c > 1 && image.d > 1 ? image.b() : null;
        for (int i = 0; i < bar.getActors().size; i++) {
            TextButton button = (TextButton)bar.getActors().get(i);
            if (nextSkin != null && nextSkin != skin) {
                TextButton.TextButtonStyle style = new TextButton.TextButtonStyle(button.getStyle());
                style.up = new TextureRegionDrawable(new TextureRegion(nextSkin)); button.setStyle(style);
            }
            button.getLabel().setColor(i == active.slot ? Color.YELLOW : Color.WHITE);
        }
        skin = nextSkin;
        bar.getViewport().apply();
        bar.act(Math.min(Gdx.graphics.getDeltaTime(), .033f)); bar.draw();
    }
}
