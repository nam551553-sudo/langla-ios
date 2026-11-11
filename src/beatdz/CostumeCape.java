package beatdz;

import java.util.Vector;

final class CostumeCape {
    static final int CUU_VI_ITEM_ID = 1128;
    private static final int FIRST_FULL_BODY_PART = 926;
    private static final int HOKAGE_CAPE_FABRIC = 22;
    private static final int HOKAGE_CAPE_COLLAR = 27;
    private static final int CUU_VI_FABRIC = 962;
    private static final int CUU_VI_COLLAR = 963;
    private static final int FRONT_COLLAR_SCALE = 86;

    // Shoulder offsets in game pixels for full-body parts starting at 926.
    // These account for asymmetry from hair, hats and auras in the full-body images.
    private static final int[][] SHOULDER_OFFSETS = {
        {1, -2}, {-1, 0}, {0, -1}, {0, -2}, {2, -1}, {3, -1}, {2, -1}, {2, -2},
        {0, -1}, {1, -2}, {2, -2}, {1, 1}, {1, 1}, {2, -1}, {2, 1}, {2, -3},
        {2, -3}, {1, -1}, {1, 0}, {-1, 0}, {1, 0}, {1, -1}, {1, -1}, {2, 0},
        {1, -1}, {2, -1}, {0, -1}, {3, -1}, {2, -1}, {-1, -2}, {1, -1}, {0, -2},
        {1, 2}, {3, 3}, // Buroto and Sunade Xinh V
        {1, 0}, // Han
        {3, -1} // Naruto Cửu Vĩ Hồ
    };
    private static final int[] SHOULDER_POSE_X = {
        0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, -1,
        -3, -1, 0, -2, 0, 2, -1, -1, -1, 0, 0, 0, 2, 2, 0, 0
    };
    // Shoulder height as a percentage of the full-body frame, measured up from its baseline.
    private static final int[] SHOULDER_POSE_HEIGHT = {
        46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46,
        47, 46, 46, 47, 46, 45, 49, 48, 47, 47, 49, 48, 49, 39, 46, 46
    };

    private CostumeCape() { }

    static boolean isNewBody(LangLa_jr part) {
        return part.a >= FIRST_FULL_BODY_PART && part.a < FIRST_FULL_BODY_PART + SHOULDER_OFFSETS.length;
    }

    private static boolean showsBack(int pose) {
        switch (pose) {
            case 18: case 19: case 21: case 22: case 25: case 26: case 29:
                return true;
            default:
                return false;
        }
    }

    static boolean canFit(LangLa_jr costume, int pose) {
        return costume != null && pose >= 0 && pose < SHOULDER_POSE_HEIGHT.length
                && pose < costume.d.length && spriteSize(DataCenter.gI(), costume.d[pose].a) != null;
    }

    static void draw(Graphics graphics, Vector parts, LangLa_jr costume, int pose, int x, int y,
                     boolean flip, boolean behindBody) {
        boolean back = showsBack(pose);
        if (behindBody && back) return;
        DataCenter data = DataCenter.gI();
        LangLa_ju body = costume.d[pose];
        int bodyHeight = spriteSize(data, body.a).e;
        int[] shoulder = SHOULDER_OFFSETS[costume.a - FIRST_FULL_BODY_PART];
        int shoulderX = body.d + shoulder[0] + SHOULDER_POSE_X[pose];
        int shoulderY = body.e + shoulder[1] - Math.round(bodyHeight * SHOULDER_POSE_HEIGHT[pose] / 100f);

        // The existing cape styles share the Hokage cape's attachment. The cape
        // artwork has no separate collar in the three turning poses.
        LangLa_ju reference = data.F[HOKAGE_CAPE_COLLAR].d[pose];
        int referenceX = reference.d;
        int referenceY = reference.e - 10;
        if (reference.a == 0) {
            reference = data.F[HOKAGE_CAPE_FABRIC].d[pose];
            LangLa_et size = spriteSize(data, reference.a);
            if (size == null) return;
            referenceX = reference.d + 4;
            referenceY = reference.e - size.e + 4;
        }

        int dx = shoulderX - referenceX;
        int dy = shoulderY - referenceY;
        boolean standing = pose <= 1 || pose >= 31;
        boolean onGround = pose == 30 && bodyHeight < 33;
        for (int i = 0; i < parts.size(); i++) {
            LangLa_jr part = (LangLa_jr) parts.elementAt(i);
            if (!part.equippedCape) continue;
            LangLa_ju frame = part.d[pose];
            LangLa_et size = spriteSize(data, frame.a);
            if (size == null) continue;

            boolean collar = isCollar(part.a);
            int width = size.d;
            int bottom = frame.e + dy;
            int top = bottom - size.e;
            if (standing && isFabric(part.a)) bottom = Math.min(bottom, body.e + 1);
            if (onGround) {
                if (!isFabric(part.a)) continue;
                bottom = Math.min(bottom, body.e + 2);
                top = Math.max(top, bottom - 12);
            }

            if (collar && !back && part.a != CUU_VI_COLLAR) {
                // Fit the collar around the narrower front shoulders. The upper
                // ornament sits behind the hair and the clasp crosses the chest.
                width = fitCollar(width);
                top = shoulderY + fitCollar(top - shoulderY);
                bottom = shoulderY + fitCollar(bottom - shoulderY);
            }
            int height = bottom - top;
            if (height <= 0) continue;
            int split = back ? 0 : height;
            if (collar && !back) split = Math.max(0, Math.min(height, shoulderY + 1 - top));
            int start = behindBody ? 0 : split;
            int end = behindBody ? split : height;
            if (end <= start) continue;

            int center = frame.d + dx;
            int transform = flip ? Utlis.b(frame.b) : Utlis.a(frame.b);
            LangLa_fq.drawCapeRows(graphics, frame.a, transform, x + (flip ? -center : center),
                    y + top + end, width, height, start, end);
        }
    }

    private static int fitCollar(int value) {
        return Math.round(value * FRONT_COLLAR_SCALE / 100f);
    }

    private static boolean isCollar(int part) {
        switch (part) {
            case 25: case 26: case 27: case 28: case 414: case 469: case 737: case 837: case CUU_VI_COLLAR:
                return true;
            default:
                return false;
        }
    }

    private static boolean isFabric(int part) {
        switch (part) {
            case 19: case 20: case 21: case 22: case 23: case 24: case 29:
            case 415: case 470: case 616: case 738: case 838: case CUU_VI_FABRIC:
                return true;
            default:
                return false;
        }
    }

    static LangLa_et spriteSize(DataCenter data, short iconId) {
        if (iconId == 0) return null;
        LangLa_et size = (LangLa_et) data.ak.get(iconId);
        if (size == null) size = (LangLa_et) data.am.get(iconId);
        return size != null && size.d > 0 && size.e > 0 ? size : null;
    }
}
