package beatdz;

/** Positions the Cuu Vi Tanto grip on full-body costume sprites. */
final class CostumeTanto {
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
                        LangLa_ju tanto, int x, int y, boolean flip) {
        if (costume == null || bodyPose < 0 || bodyPose >= HAND.length
                || bodyPose >= costume.d.length || tanto.a < FIRST_TANTO_TEXTURE
                || tanto.a > LAST_TANTO_TEXTURE) {
            return false;
        }

        DataCenter data = DataCenter.gI();
        LangLa_ju body = costume.d[bodyPose];
        LangLa_et bodySize = CostumeCape.spriteSize(data, body.a);
        LangLa_et tantoSize = CostumeCape.spriteSize(data, tanto.a);
        if (bodySize == null || tantoSize == null) return false;

        int handX = body.d + Math.round(bodySize.e * HAND[bodyPose][0] / 100f);
        int handY = body.e + Math.round(bodySize.e * HAND[bodyPose][1] / 100f);
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
