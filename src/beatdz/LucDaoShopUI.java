package beatdz;

/** Shared rendering/payment metadata for the card shop on every client platform. */
public final class LucDaoShopUI {
    public static final int TYPE = 119, CARD = 548, BUTTON = -120;
    public static final String NAME = "Thẻ Lục Đạo";
    public static long balance() {
        long total = 0;
        Item[] bag = Char.gI().arrItemBag;
        if (bag != null) for (Item item : bag) if (item != null && item.id == CARD) total += Math.max(0,item.getAmount());
        return total;
    }
    public static void drawCard(Graphics graphics, int x, int y) {
        int icon = state().icon;
        mImage image = (mImage)LangLa_fq.$state_LangLa_fq().e.get(Short.valueOf((short)icon));
        if (image == null || image.c <= 1) { LangLa_fq.a(graphics,icon,0,x,y,20);return; }
        graphics.a(image,0,0,image.c,image.d,0,x,y,16*DataCenter.gI().zoomLevel,16*DataCenter.gI().zoomLevel,20);
    }
    public static final class State implements MultiSession.State {
        public int icon = 842;
        public void initialize() { }
    }
    private static final int KEY = MultiSession.register("beatdz.LucDaoShopUI");
    public static State state() { return MultiSession.state(KEY,State::new); }
    private LucDaoShopUI() { }
}
