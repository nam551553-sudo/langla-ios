package beatdz.tab;

import beatdz.Binary2;
import beatdz.Char;
import beatdz.DataCenter;
import beatdz.Graphics;
import beatdz.Item;
import beatdz.ItemTemplate;
import beatdz.LangLa_cy;
import beatdz.LangLa_dz;
import beatdz.LangLa_fo;
import beatdz.LangLa_fq;
import beatdz.LangLa_jz;
import beatdz.MainScreen;
import beatdz.Message;
import beatdz.Session;
import beatdz.Utlis;

import java.io.IOException;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

public class LatHinh extends LangLa_fo {
    private static final int CARD_COUNT = 40;
    private static final int COVER_ITEM = 774;
    private static final int TICKET_ITEM = 932;
    private static final int FIRST_CARD = 2907;
    private static final int AUTO_FLIP = 9999;
    private static final int SHUFFLE = 10000;
    private static final int RESET = 10001;
    private static final int MOVE_MS = 180;
    private static final int RESPONSE_TIMEOUT_MS = 10_000;
    private static final AtomicInteger REQUESTS = new AtomicInteger();

    private enum Phase { COVERED, WAITING, REVEALED }

    private final int[] x = new int[CARD_COUNT];
    private final int[] y = new int[CARD_COUNT];
    private final int[] oldX = new int[CARD_COUNT];
    private final int[] oldY = new int[CARD_COUNT];
    private final int[] results = new int[CARD_COUNT];
    private final int[] rewardIcons = new int[CARD_COUNT];
    private final LangLa_jz[] cardButtons = new LangLa_jz[CARD_COUNT];
    private final int coverIcon;
    private final LangLa_dz autoFlip;
    private final LangLa_dz shuffle;
    private final LangLa_dz reset;

    private Phase phase = Phase.COVERED;
    private int selected = -1;
    private Item prize;
    private boolean haveResult;
    private boolean shuffling;
    private long started;
    private Session pendingSession;
    private int connectionVersion;
    private int request;

    public LatHinh(MainScreen owner) {
        this.a(320, 240);
        this.p = owner;
        this.r = false;
        this.cF = 2;
        int bottom = height * 87 / 100;
        autoFlip = this.a(width / 2 - 120, bottom, "Tự Lật", this, AUTO_FLIP, -8);
        shuffle = this.a(width / 2 - 30, bottom, "Thay Đổi", this, SHUFFLE, -8);
        reset = this.a(width / 2 + 60, bottom, "Thử Lại", this, RESET, -8);
        coverIcon = icon(COVER_ITEM);
        resetBoard();
    }

    public void read(Message message) {
        if (phase != Phase.WAITING || haveResult) return;
        try {
            int bytes = message.reader.dis.available();
            if (bytes == Integer.BYTES) {
                if (message.reader.dis.readInt() == request) resetBoard();
                return;
            }
            int boardBytes = CARD_COUNT * Short.BYTES;
            if (bytes != boardBytes && bytes != boardBytes + Integer.BYTES) return;
            for (int i = 0; i < CARD_COUNT; i++) results[i] = message.readShort() & 0xffff;
            if (bytes > boardBytes && message.reader.dis.readInt() != request) return;

            for (int i = 0; i < CARD_COUNT; i++) rewardIcons[i] = icon(results[i]);
            prize = rewardIcons[selected] >= 0 ? new Item(results[selected]) : null;
            haveResult = true;
        } catch (IOException error) {
            Utlis.println(error);
        }
    }

    @Override public void a(int action, Object payload, LangLa_cy source) { }

    @Override public void a(int action, Object payload) { }

    @Override public void a(Graphics graphics) {
        long now = now();
        advance(now);
        this.a(graphics, cx, cy, width, height, "Lật hình", (byte)2, r);
        float progress = fraction(now);
        if (phase == Phase.WAITING && progress >= 1f) {
            drawCard(graphics, selected, x[selected], y[selected]);
        } else {
            for (int i = 0; i < CARD_COUNT; i++) {
                if (i != selected) drawMovingCard(graphics, i, progress);
            }
            if (selected >= 0) drawMovingCard(graphics, selected, progress);
        }
        this.b(graphics);
    }

    private void drawMovingCard(Graphics graphics, int index, float progress) {
        int left = x[index], top = y[index];
        if (shuffling) {
            left = interpolate(oldX[index], left, progress);
            top = interpolate(oldY[index], top, progress);
        } else if (phase == Phase.WAITING) {
            left = interpolate(left, x[selected], progress);
            top = interpolate(top, y[selected], progress);
        } else if (phase == Phase.REVEALED) {
            left = interpolate(x[selected], left, progress);
            top = interpolate(y[selected], top, progress);
        }
        drawCard(graphics, index, left, top);
    }

    private void drawCard(Graphics graphics, int index, int left, int top) {
        boolean focus = index == selected;
        if (focus && phase == Phase.REVEALED && prize != null) {
            b(graphics, left, top, prize, true);
            return;
        }
        b(graphics, left, top, null, focus);
        Binary2.a(graphics, -5, 0, left + 2, top + 2, 25, (int)25);
        int iconId = phase == Phase.REVEALED ? rewardIcons[index] : coverIcon;
        if (iconId >= 0) LangLa_fq.a(graphics, iconId, 0, left + 14, top + 15, 3);
    }

    @Override public void a(LangLa_jz button, int px, int py) {
        int action = button.b;
        if (action == RESET && phase == Phase.REVEALED) {
            resetBoard();
        } else if (phase == Phase.COVERED && !shuffling) {
            if (action == SHUFFLE) {
                shuffleBoard();
            } else if (action == AUTO_FLIP || (action >= FIRST_CARD && action < FIRST_CARD + CARD_COUNT)) {
                requestFlip(action == AUTO_FLIP ? Utlis.nextInt(CARD_COUNT) : action - FIRST_CARD);
            }
        }
    }

    private void requestFlip(int index) {
        if (!checkVeMayMan()) {
            DataCenter.gI().currentScreen.showMessage("Bạn không có vé may mắn để tham gia", -65536);
            return;
        }
        try {
            pendingSession = Session.gI();
            if (!pendingSession.isConnected()) return;
            connectionVersion = pendingSession.connectionVersion();
            request = REQUESTS.incrementAndGet();
            if (request == 0) request = REQUESTS.incrementAndGet();
            selected = index;
            haveResult = false;
            phase = Phase.WAITING;
            started = now();
            updateButtons();
            Message message = new Message((byte)122);
            message.writeByte(102);
            message.writeByte(index);
            message.writeInt(request);
            message.send();
        } catch (IOException error) {
            resetBoard();
            Utlis.println(error);
        }
    }

    public boolean checkVeMayMan() {
        Item[] bag = Char.gI().arrItemBag;
        if (bag == null) return false;
        for (Item item : bag) {
            if (item != null && item.id == TICKET_ITEM && item.getAmount() > 0) return true;
        }
        return false;
    }

    private void shuffleBoard() {
        System.arraycopy(x, 0, oldX, 0, CARD_COUNT);
        System.arraycopy(y, 0, oldY, 0, CARD_COUNT);
        for (int i = CARD_COUNT - 1; i > 0; i--) {
            int j = Utlis.nextInt(i + 1);
            int left = x[i], top = y[i];
            x[i] = x[j]; y[i] = y[j];
            x[j] = left; y[j] = top;
        }
        shuffling = true;
        started = now();
        updateCardButtons();
        updateButtons();
    }

    private void resetBoard() {
        selected = -1;
        prize = null;
        haveResult = false;
        shuffling = false;
        pendingSession = null;
        phase = Phase.COVERED;
        int columns = Math.max(1, width * 90 / 100 / 35);
        for (int i = 0; i < CARD_COUNT; i++) {
            x[i] = 6 + width / 20 + (i % columns) * 35;
            y[i] = 35 + (i / columns) * 35;
        }
        updateCardButtons();
        updateButtons();
    }

    private void updateCardButtons() {
        for (int i = 0; i < CARD_COUNT; i++) {
            cardButtons[i] = new LangLa_jz(FIRST_CARD + i, x[i], y[i], x[i] + 35, y[i] + 35, null, this);
        }
    }

    private void updateButtons() {
        boolean ready = phase == Phase.COVERED && !shuffling;
        autoFlip.a(!ready);
        shuffle.a(!ready);
        reset.a(phase != Phase.REVEALED);
    }

    @Override public Vector c() {
        Vector buttons = super.c();
        if (phase == Phase.COVERED && !shuffling) {
            for (LangLa_jz card : cardButtons) buttons.add(card);
        }
        return buttons;
    }

    @Override public void b() {
        advance(now());
    }

    private void advance(long now) {
        if (shuffling && now - started >= MOVE_MS) {
            shuffling = false;
            updateButtons();
        }
        if (phase != Phase.WAITING) return;
        if (haveResult && now - started >= MOVE_MS) {
            phase = Phase.REVEALED;
            started = now;
            pendingSession = null;
            updateButtons();
        } else if (pendingSession != Session.gI() || pendingSession.connectionVersion() != connectionVersion
                || !pendingSession.isConnected() || now - started >= RESPONSE_TIMEOUT_MS) {
            resetBoard();
            DataCenter.gI().currentScreen.showMessage("Lượt lật vé đã dừng. Kiểm tra túi trước khi thử lại.", -65536);
        }
    }

    private float fraction(long now) {
        return Math.max(0f, Math.min(1f, (now - started) / (float) MOVE_MS));
    }

    private static int interpolate(int start, int end, float progress) {
        return start + Math.round((end - start) * progress);
    }

    private static long now() {
        return System.nanoTime() / 1_000_000L;
    }

    private static int icon(int id) {
        ItemTemplate[] templates = DataCenter.gI().ItemTemplate;
        return templates != null && id >= 0 && id < templates.length && templates[id] != null
                ? templates[id].idIcon : -1;
    }
}
