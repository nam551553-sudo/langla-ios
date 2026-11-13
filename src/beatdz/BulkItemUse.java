package beatdz;

import com.tgame.model.Caption;
import java.util.LinkedHashMap;
import java.util.Map;

final class BulkItemUse {
    private static final int CHUNK_SIZE = 8;
    private final Map<String, Long> rewards = new LinkedHashMap<>();
    private int remaining, requested, completed, itemId, token, inFlight;
    private int connectionVersion;
    private int slot;
    private long received;
    private long nextAt, deadline;
    private Session session;

    boolean active() { return remaining > 0; }

    void start(Item item, int amount) {
        slot = item.index;
        itemId = item.id;
        remaining = requested = amount;
        completed = 0;
        received = 0;
        rewards.clear();
        inFlight = 0;
        nextAt = 0;
        session = Session.gI();
        connectionVersion = session.connectionVersion();
    }

    void acknowledge(GameSrc game, int request, int used) {
        if (!active() || inFlight == 0 || request != token) return;
        int sent = inFlight;
        inFlight = 0;
        if (used >= 0 && used <= sent) completed += used;
        remaining -= sent;
        if (used != sent || remaining == 0) {
            finish(game);
        } else {
            nextAt = Utlis.time() + 75;
        }
    }

    boolean recordReward(String name, int amount) {
        if (inFlight == 0 || amount <= 0) return false;
        rewards.merge(name, (long) amount, Long::sum);
        received += amount;
        return true;
    }

    void update(GameSrc game) {
        if (!active()) return;
        long now = Utlis.time();
        if (session != Session.gI() || session.connectionVersion() != connectionVersion
                || !session.isConnected() || (inFlight != 0 && now >= deadline)) {
            remaining = 0;
            inFlight = 0;
            publishRewards();
            game.showMessage("Lượt dùng vật phẩm đã dừng. Kiểm tra túi trước khi thử lại.", -65536);
            return;
        }
        if (inFlight != 0 || now < nextAt) return;
        Item[] bag = Char.gI().arrItemBag;
        Item item = slot >= 0 && slot < bag.length ? bag[slot] : null;
        if (item == null || item.id != itemId || item.getAmount() <= 0) {
            finish(game);
            return;
        }
        try {
            inFlight = Math.min(item.getItemTemplate().type == 100 ? CHUNK_SIZE : 32,
                    Math.min(remaining, item.getAmount()));
            deadline = now + 30000;
            Message message = new Message((byte) 116);
            message.writeShort(slot);
            message.writeShort(inFlight);
            message.writeInt(++token);
            message.writeShort(itemId);
            message.send();
        } catch (Exception error) {
            remaining = 0;
            inFlight = 0;
            publishRewards();
            Utlis.println(error);
        }
    }

    private void finish(GameSrc game) {
        remaining = 0;
        publishRewards();
        String summary = "Đã dùng " + Utlis.numberFormat(completed) + "/" + Utlis.numberFormat(requested) + " vật phẩm.";
        if (received > 0) summary += " Nhận " + Utlis.numberFormat(received) + " vật phẩm.";
        game.showMessage(summary, -1);
    }

    private void publishRewards() {
        rewards.forEach((name, amount) -> LangLa_kw.a(7, Caption.bz,
                Caption.k + " " + Utlis.numberFormat(amount) + " " + name));
        rewards.clear();
    }
}
