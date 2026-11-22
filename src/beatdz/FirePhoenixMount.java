package beatdz;

/** Web-backed mount animation, independent of the rider's attack/standing pose. */
final class FirePhoenixMount {
    static final int ITEM = 1152;
    static final int CHARACTER = 246;
    static final int BODY = 1088;
    static final int FIRST_ICON = 30788;
    static final int FRAME_COUNT = 8;
    static final int FRAME_MS = 90;

    private FirePhoenixMount() { }

    static boolean matches(Item item) {
        return item != null && (item.id == ITEM || item.strOptions != null
                && (item.strOptions.equals("340,1152") || item.strOptions.startsWith("340,1152;")));
    }

    static int frameAt(long time) {
        return (int) ((time / FRAME_MS) % FRAME_COUNT);
    }

    static LangLa_ju frame(LangLa_jr part) {
        return part.d[frameAt(Utlis.time())];
    }
}
