package beatdz;

final class BulkItemUse {
    private static final int CHUNK_SIZE = 32;
    private int remaining, itemId, token, inFlight;
    private int slot;
    private long nextAt, deadline;
    private Session session;

    boolean active() { return remaining > 0; }

    void start(Item item, int amount) {
        slot = item.index;
        itemId = item.id;
        remaining = amount;
        inFlight = 0;
        nextAt = 0;
        session = Session.gI();
    }

    void acknowledge(int request, int used) {
        if (!active() || inFlight == 0 || request != token) return;
        remaining = used == inFlight ? remaining - used : 0;
        inFlight = 0;
        nextAt = Utlis.time() + 150;
    }

    void update(GameSrc game) {
        if (!active()) return;
        long now = Utlis.time();
        if (session != Session.gI() || !session.isConnected() || (inFlight != 0 && now >= deadline)) {
            remaining = 0;
            game.showMessage("Lượt dùng vật phẩm đã dừng. Kiểm tra túi trước khi thử lại.", -65536);
            return;
        }
        if (inFlight != 0 || now < nextAt) return;
        Item[] bag = Char.gI().arrItemBag;
        Item item = slot >= 0 && slot < bag.length ? bag[slot] : null;
        if (item == null || item.id != itemId || item.getAmount() <= 0) {
            remaining = 0;
            return;
        }
        try {
            inFlight = Math.min(CHUNK_SIZE, Math.min(remaining, item.getAmount()));
            deadline = now + 30000;
            Message message = new Message((byte) 116);
            message.writeShort(slot);
            message.writeShort(inFlight);
            message.writeInt(++token);
            message.writeShort(itemId);
            message.send();
        } catch (Exception error) {
            remaining = 0;
            Utlis.println(error);
        }
    }
}
