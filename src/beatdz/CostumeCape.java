package beatdz;

import java.util.Vector;

final class CostumeCape {
    private static final int ORIGINAL_MINATO_PART = 388;
    private static final int FIRST_FULL_BODY_PART = 926;
    private static final int LAST_FULL_BODY_PART = 957;

    private CostumeCape() { }

    static boolean isNewBody(LangLa_jr part) {
        return part.a >= FIRST_FULL_BODY_PART && part.a <= LAST_FULL_BODY_PART;
    }

    static boolean showsBack(int pose) {
        switch (pose) {
            case 18: case 19: case 21: case 22: case 25: case 26: case 29:
                return true;
            default:
                return false;
        }
    }

    static void draw(Graphics graphics, Vector parts, LangLa_jr costume, int pose, int x, int y, boolean flip) {
        DataCenter data = DataCenter.gI();
        LangLa_ju base = data.F[ORIGINAL_MINATO_PART].d[pose];
        LangLa_ju body = costume.d[pose];
        int baseHeight = spriteHeight(data, base.a);
        int bodyHeight = spriteHeight(data, body.a);
        // The cape artwork uses the original pose's shoulder and ground anchors.
        int dx = Math.max(-10, Math.min(10, body.d - base.d));
        int shoulderDelta = baseHeight > 0 && bodyHeight > 0 ? Math.round((bodyHeight - baseHeight) * 0.46f) : 0;
        int dy = Math.max(-10, Math.min(10, body.e - base.e - shoulderDelta));

        for (int i = 0; i < parts.size(); i++) {
            LangLa_jr part = (LangLa_jr) parts.elementAt(i);
            if (!part.equippedCape) continue;
            LangLa_ju frame = part.d[pose];
            if (frame.a == 0) continue;
            int frameX = frame.d + dx;
            LangLa_fq.b(graphics, frame.a, flip ? Utlis.b(frame.b) : Utlis.a(frame.b),
                    x + (flip ? -frameX : frameX), y + frame.e + dy, 33);
        }
    }

    private static int spriteHeight(DataCenter data, short iconId) {
        LangLa_et size = (LangLa_et) data.ak.get(iconId);
        if (size == null) size = (LangLa_et) data.am.get(iconId);
        return size == null ? 0 : size.e;
    }
}
