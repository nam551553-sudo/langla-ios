package beatdz;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.lang.reflect.Field;
import java.util.Queue;

public final class BulkItemUseCheck {
    public static void main(String[] args) throws Exception {
        Session session = new Session();
        session.handler = new IMessageHandler() {
            public void a() { }
            public void b() { }
            public void c() { }
            public void a(Message message) { }
        };
        Session.$state_Session().instance = session;
        session.isConnected = true;
        GameSrc game = new GameSrc() {
            @Override public void showMessage(String text, int color) {
                lastMessage = text;
            }
        };
        ItemTemplate box = new ItemTemplate(1);
        box.type = 100;
        DataCenter.gI().ItemTemplate = new ItemTemplate[]{null, box};
        Item stack = new Item(1);
        stack.index = 0;
        stack.setAmount(38);
        Char.gI().arrItemBag = new Item[]{stack};
        BulkItemUse batch = new BulkItemUse();

        batch.start(stack, 38);
        int first = request(batch, game, session, 16);
        require(batch.recordReward("Test reward", 2), "reward coalesced during the request");
        batch.acknowledge(game, first + 99, 16);
        batch.update(game);
        require(session.vMessage.isEmpty(), "wait for the matching acknowledgment");
        stack.setAmount(22);
        batch.acknowledge(game, first, 16);
        int second = request(batch, game, session, 16);
        stack.setAmount(6);
        batch.acknowledge(game, second, 16);
        int last = request(batch, game, session, 6);
        stack.setAmount(3);
        batch.acknowledge(game, last, 3);
        require(!batch.active() && lastMessage.contains("35/38"), "partial use stops and reports the exact count");
        require(!batch.recordReward("Test reward", 2), "ordinary reward feedback resumes");

        batch.start(stack, 3);
        request(batch, game, session, 3);
        session.close();
        session.isConnected = true;
        batch.update(game);
        require(!batch.active() && session.vMessage.isEmpty(), "reconnect cancels the previous request");
        checkBacklog(batch, game, session, stack);
        System.out.println("PASS bounded bulk item use, partial confirmation, reward aggregation, reconnect and 1,024 items under queue pressure.");
    }

    @SuppressWarnings("unchecked")
    private static void checkBacklog(BulkItemUse batch, GameSrc game, Session session, Item stack) throws Exception {
        Field queue = Session.class.getDeclaredField("incoming");
        queue.setAccessible(true);
        Queue<Runnable> incoming = (Queue<Runnable>) queue.get(session);
        Runnable packet = () -> { };
        for (int i = 0; i < 128; i++) require(incoming.offer(packet), "add simulated inbound traffic");
        stack.setAmount(1024);
        batch.start(stack, 1024);
        batch.update(game);
        require(session.vMessage.isEmpty(), "wait for a congested inbound queue");
        for (int i = 0; i < 96; i++) incoming.remove();
        int shortBatch = request(batch, game, session, 8);
        stack.setAmount(stack.getAmount() - 8);
        batch.acknowledge(game, shortBatch, 8);
        incoming.clear();
        while (batch.active()) {
            int quantity = Math.min(16, stack.getAmount());
            int token = request(batch, game, session, quantity);
            if (stack.getAmount() == quantity) Char.gI().arrItemBag[0] = null;
            else stack.setAmount(stack.getAmount() - quantity);
            batch.acknowledge(game, token, quantity);
        }
        require(session.isConnected() && Char.gI().arrItemBag[0] == null && lastMessage.contains("1.024/1.024"),
                "resume at the normal rate and use exactly the requested quantity");
    }

    private static String lastMessage;

    private static int request(BulkItemUse batch, GameSrc game, Session session, int expected) throws Exception {
        Field nextAt = BulkItemUse.class.getDeclaredField("nextAt");
        nextAt.setAccessible(true);
        nextAt.setLong(batch, 0L);
        batch.update(game);
        require(session.vMessage.size() == 1, "send one request at a time");
        byte[] bytes = (byte[]) session.vMessage.remove(0);
        try (DataInputStream input = new DataInputStream(new ByteArrayInputStream(bytes))) {
            require(input.readByte() == 116 && input.readUnsignedShort() == 10
                    && input.readShort() == 0 && input.readShort() == expected, "packet slot and requested quantity");
            int token = input.readInt();
            require(input.readShort() == 1, "packet identifies the selected stack");
            return token;
        }
    }

    private static void require(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }
}
