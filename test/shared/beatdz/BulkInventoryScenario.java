package beatdz;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

public final class BulkInventoryScenario {
    private BulkInventoryScenario() { }

    public static void verify() throws Exception {
        DataCenter data = DataCenter.gI();
        ItemTemplate[] templates = data.ItemTemplate;
        Char player = Char.gI();
        Item[] savedBag = player.arrItemBag;
        try {
            ItemTemplate box = new ItemTemplate(161);
            box.type = 100;
            box.isXepChong = true;
            data.ItemTemplate = new ItemTemplate[278];
            data.ItemTemplate[161] = box;
            Item chest = new Item(161);
            chest.index = 0;
            chest.setAmount(3);
            player.arrItemBag = new Item[]{chest};
            GameSrc game = GameSrc.gI();
            game.n(consumed(0, 2));
            check(player.arrItemBag[0] == chest && chest.getAmount() == 2, "Partial use retains the exact count");
            game.n(consumed(0, 0));
            check(player.arrItemBag[0] == null, "Zero remaining removes the chest rather than creating a ghost item");
            game.n(consumed(0, 0));
            game.n(consumed(5, 0));
            check(player.arrItemBag[0] == null, "Stale consumption cannot restore a removed item");
        } finally {
            player.arrItemBag = savedBag;
            data.ItemTemplate = templates;
        }
    }

    private static Message consumed(int slot, int remaining) throws Exception {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(bytes);
        out.writeShort(slot);
        out.writeBoolean(true);
        out.writeInt(remaining);
        return new Message((byte)116, bytes.toByteArray());
    }

    private static void check(boolean condition, String text) {
        if (!condition) throw new AssertionError(text);
    }
}
