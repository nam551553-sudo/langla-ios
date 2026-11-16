package beatdz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.backends.lwjgl.LwjglFiles;
import com.beatdz.langlalau.DesktopLauncher;
import com.beatdz.langlalau.SoftwareRenderer;
import com.tgame.model.Caption;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public final class EquipmentTapCheck {
    public static void main(String[] args) {
        Caption.loadVN();
        Gdx.files = new LwjglFiles();
        SoftwareRenderer.install(args);
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Làng Lá Blue - kiểm tra trang bị và tải bản đồ";
        config.width = 1024;
        config.height = 576;
        new LwjglApplication(new AppListener() {
            @Override public void create() {
                setAppEventListener(new DesktopLauncher());
                super.create();
                Gdx.app.postRunnable(() -> {
                    try {
                        EquipmentTapScenario.verify();
                        checkMapLayout();
                        checkTextureBudget();
                        System.out.println("PASS first tap in character and bag, cached layouts with invalidation, and bounded texture uploads.");
                        System.exit(0);
                    } catch (Throwable error) {
                        error.printStackTrace();
                        System.exit(1);
                    }
                });
            }
        }, config);
    }

    private static void checkMapLayout() {
        int map = 32000;
        String name = "arr_map_" + map;
        byte[] trial = {0, 1, 2};
        try {
            Binary.write(name, trial);
            byte[] cached = Binary.readMapLayout(map);
            require(Arrays.equals(trial, cached) && Binary.readMapLayout(map) == cached, "cached map bytes are reused");
            trial[1] = 7;
            Binary.write(name, trial);
            byte[] revised = Binary.readMapLayout(map);
            require(Arrays.equals(trial, revised) && revised != cached, "server map update invalidates the layout cache");
        } finally {
            Binary.delete(name + ".beatdz");
        }
        require(Binary.readMapLayout(map) == null, "deleted map must not remain in the layout cache");
    }

    private static void checkTextureBudget() {
        GameSrc game = new GameSrc();
        AtomicInteger uploads = new AtomicInteger();
        for (int i = 0; i < 12; i++) game.cb.add(new mImage() {
            @Override public void d() { uploads.incrementAndGet(); }
        });
        game.prepareTextures();
        require(uploads.get() <= 4, "one frame must not upload a whole backlog");
        for (int i = 0; i < 12 && !game.cb.isEmpty(); i++) game.prepareTextures();
        require(uploads.get() == 12 && game.cb.isEmpty(), "the queue should finish across frames");
    }

    private static void require(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }
}
