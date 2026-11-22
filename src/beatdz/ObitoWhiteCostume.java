package beatdz;

/** Full-body frame order and Tanto grip for Obito White Mask (item 1094). */
final class ObitoWhiteCostume {
    static final int BODY = 952;
    static final int FIRST_TEXTURE = 29387;
    static final int LAST_TEXTURE = 29413;
    private static final short[] POSES = {
        29413, 29412, 29411, 29410, 29409, 29408, 29407, 29406,
        29405, 29390, 29389, 29404, 29388, 29403, 29402, 29402,
        29401, 29400, 29399, 29398, 29397, 29396, 29395, 29394,
        29393, 29392, 29391, 29393, 29392, 29391, 29387, 29413,
        29412
    };
    private static final int[][] PALMS = {
        {-1, -7}, {-1, -7}, {-5, -8}, {-5, -8}, {-5, -8}, {-6, -9},
        {-5, -8}, {-5, -8}, {-6, -11}, {-7, -8}, {-7, -15}, {-7, -13},
        {-10, -19}, {-7, -16}, {-9, -14}, {-8, -15}, {-7, -13}, {-9, -19},
        {-10, -19}, {-11, -22}, {-9, -16}, {-9, -15}, {-7, -11}, {-5, -9},
        {6, -18}, {-7, -12}, {-2, -7}
    };

    private ObitoWhiteCostume() {}

    static void apply(LangLa_jr[] parts) {
        if (parts.length <= BODY) return;
        LangLa_ju[] frames = parts[BODY].d;
        if (frames.length != POSES.length || frames[0].a != LAST_TEXTURE) return;
        for (int pose = 0; pose < frames.length; pose++) {
            frames[pose].a = POSES[pose];
        }
    }

    static int[] palm(short icon) {
        if (icon < FIRST_TEXTURE || icon > LAST_TEXTURE) return null;
        return PALMS[LAST_TEXTURE - icon];
    }
}
