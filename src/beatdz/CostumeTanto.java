package beatdz;

/** Positions the Cuu Vi Tanto grip on full-body costume sprites. */
final class CostumeTanto {
    static final int BORUTO_BODY = 974;
    static final int KAWAKI_BODY = 975;
    private static final int KAWAKI_FIRST_TEXTURE = 30400;
    private static final int[][] KAWAKI_HAND = {
        {-10,-11}, {-10,-11}, {-12,-18}, {-13,-17}, {-13,-17}, {-13,-17},
        {-13,-18}, {-12,-17}, {-14,-23}, {7,-12}, {-15,-19}, {7,-18},
        {-13,-17}, {-10,-11}, {1,-7}, {1,-8}, {10,-11}, {-10,-16},
        {-8,-13}, {-15,-21}, {-16,-22}, {-1,-12}, {1,-19}, {-14,-22},
        {-14,-22}, {-9,-15}, {-1,-8}
    };
    private static final int BORUTO_FIRST_TEXTURE = 30300;
    private static final int[][] BORUTO_HAND = {
        {-10,-10}, {-11,-11}, {-12,-17}, {-12,-16}, {-13,-16}, {-13,-16},
        {-13,-16}, {-13,-17}, {-15,-22}, {7,-11}, {-15,-19}, {6,-17},
        {-13,-18}, {3,-13}, {-3,-6}, {-10,-9}, {8,-10}, {-10,-18},
        {-7,-13}, {-16,-23}, {-16,-24}, {-11,-18}, {-12,-21}, {-15,-21},
        {-14,-22}, {-8,-15}, {0,-9}
    };

    private static final int FIRST_TANTO_TEXTURE = 30100;
    private static final int LAST_TANTO_TEXTURE = 30159;

    // Hand coordinates for the shared full-body poses, measured from the
    // sprite's bottom center in percent of its height.
    private static final int[][] HAND = {
        {-5,-24}, {-5,-24}, {-15,-42}, {-16,-41}, {-16,-41}, {-14,-41},
        {-16,-41}, {-22,-40}, {-16,-40}, {-16,-40}, {-16,-40}, {-12,-40},
        {-14,-40}, {-14,-40}, {-13,-35}, {13,-43}, {-22,-38}, {-15,-38},
        {-21,-29}, {-21,-29}, {-11,-38}, {19,-37}, {15,-42}, {-21,-43},
        {-20,-41}, {12,-36}, {-13,-42}, {-12,-41}, {-15,-42}, {-14,-42},
        {-2,-23}, {-5,-25}, {-5,-25}
    };

    private CostumeTanto() {}

    static boolean draw(Graphics graphics, LangLa_jr costume, int bodyPose,
                        LangLa_jr weapon, LangLa_ju tanto, int x, int y, boolean flip) {
        if (costume == null || bodyPose < 0 || bodyPose >= HAND.length
                || bodyPose >= costume.d.length || tanto.a == 0) return false;
        boolean cuuVi = tanto.a >= FIRST_TANTO_TEXTURE && tanto.a <= LAST_TANTO_TEXTURE;
        boolean boruto = costume.a == BORUTO_BODY;
        boolean kawaki = costume.a == KAWAKI_BODY;
        if (!cuuVi && !((boruto || kawaki) && weapon.heldWeapon)) return false;

        DataCenter data = DataCenter.gI();
        LangLa_ju body = costume.d[bodyPose];
        LangLa_et bodySize = CostumeCape.spriteSize(data, body.a);
        if (bodySize == null) return false;

        int handX = body.d + Math.round(bodySize.e * HAND[bodyPose][0] / 100f);
        int handY = body.e + Math.round(bodySize.e * HAND[bodyPose][1] / 100f);
        if (boruto || kawaki) {
            int cel = body.a - (kawaki ? KAWAKI_FIRST_TEXTURE : BORUTO_FIRST_TEXTURE);
            int[][] hand = kawaki ? KAWAKI_HAND : BORUTO_HAND;
            if (cel < 0 || cel >= hand.length) return false;
            handX = body.d + hand[cel][0];
            handY = body.e + hand[cel][1];
        }

        if (!cuuVi) {
            // Preserve the weapon frame's native grip, rotation and layering.
            LangLa_ju reference = data.F[961].d[bodyPose];
            LangLa_et referenceSize = CostumeCape.spriteSize(data, reference.a);
            if (referenceSize == null) return false;
            int dx = handX - reference.d - Math.round(referenceSize.e * HAND[bodyPose][0] / 100f);
            int dy = handY - reference.e - Math.round(referenceSize.e * HAND[bodyPose][1] / 100f);
            // On rear-facing Kawaki frames, the exposed fist sits nearer the
            // body than the stock weapon pivot for the same pose.
            if (kawaki && (bodyPose == 18 || bodyPose == 19 || bodyPose == 21
                    || bodyPose == 22 || bodyPose == 25 || bodyPose == 26 || bodyPose == 29)) {
                dx -= 10;
                dy += 1;
            }
            int center = tanto.d + dx;
            LangLa_fq.b(graphics, tanto.a, flip ? Utlis.b(tanto.b) : Utlis.a(tanto.b),
                    x + (flip ? -center : center), y + tanto.e + dy, 33);
            return true;
        }

        LangLa_et tantoSize = CostumeCape.spriteSize(data, tanto.a);
        if (tantoSize == null) return false;
        int width = tantoSize.d;
        int height = tantoSize.e;
        boolean vertical = width < height;
        // The vertical textures contain the same artwork rotated 90 degrees.
        int gripX = Math.round(width * (vertical ? -.14f : -.12f));
        int gripY = Math.round(height * (vertical ? .12f : -.14f));
        int angle = Utlis.a(tanto.b);
        if (angle < 0) gripX = -gripX;
        switch ((angle + 360) % 360) {
            case 90: {
                int originalX = gripX;
                gripX = -gripY;
                gripY = originalX;
                break;
            }
            case 180:
                gripX = -gripX;
                gripY = -gripY;
                break;
            case 270: {
                int originalX = gripX;
                gripX = gripY;
                gripY = -originalX;
                break;
            }
            default:
                break;
        }
        int drawnHeight = angle % 180 == 0 || graphics.k ? height : width;
        gripY -= drawnHeight / 2;
        int center = handX - gripX;
        int transform = flip ? Utlis.b(tanto.b) : angle;
        LangLa_fq.b(graphics, tanto.a, transform, x + (flip ? -center : center),
                y + handY - gripY, 33);
        return true;
    }
}
