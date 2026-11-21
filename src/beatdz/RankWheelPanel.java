package beatdz;

import java.io.IOException;
import java.util.Vector;

final class RankWheelPanel {
    static final int CHANNEL = 124;
    static final int WELFARE_ID = -104;
    private static final String[] MULTIPLIERS = {"1,1×", "1,2×", "1,3×", "1,4×", "1,5×", "1,8×"};
    private static final int[] MILESTONES = {80, 480, 880, 1880, 3280};
    static final String DETAILS = "Điểm vòng quay tính theo vàng nạp trong tuần.\n"
            + "Lượt quay làm mới lúc 00:00 thứ Hai.\n"
            + "80 điểm: 1 lượt\n480 điểm: 2 lượt\n880 điểm: 3 lượt\n"
            + "1.880 điểm: 4 lượt\n3.280 điểm: 5 lượt\n"
            + "Mỗi lượt nhận vàng khóa bằng mốc điểm của lượt đó nhân với hệ số quay được.\n"
            + "Sáu hệ số có cơ hội bằng nhau.";
    private static final int[] COLORS = {0x255B69, 0x32466D, 0x237B75, 0x414B82, 0x286373, 0x334566};
    private static final int RADIUS = 52;
    private static mImage disk;
    private static int nextRequest;
    private boolean selected;
    private int requestId;
    private long requestedAt;
    private long animationAt;
    private int points, used, available, segment = -1, reward;
    private String status = "";

    void update() {
        if (!selected) {
            selected = true;
            request(0);
        }
        if (requestId != 0 && System.currentTimeMillis() - requestedAt > 5000) {
            requestId = 0;
            status = "Chạm Quay để tải lại";
        }
    }

    void leaveTab() { selected = false; }

    int remaining() { return available; }

    void spin() {
        if (requestId != 0 || System.currentTimeMillis() - animationAt < 1200) return;
        request(available > 0 ? 1 : 0);
    }

    private void request(int action) {
        try {
            Message message = new Message((byte) 122);
            message.writeByte(CHANNEL);
            message.writeByte(action);
            requestId = ++nextRequest;
            message.writeInt(requestId);
            message.writeByte(used);
            requestedAt = System.currentTimeMillis();
            status = action == 1 ? "Đang quay…" : "Đang tải…";
            message.send();
        } catch (Exception e) {
            requestId = 0;
            status = "Chưa gửi được yêu cầu";
        }
    }

    void receive(Message reply) throws IOException {
        if (reply.readInt() != requestId) return;
        points = reply.readInt();
        used = reply.readByte();
        available = reply.readByte();
        int result = reply.readByte();
        int amount = reply.readInt();
        status = reply.readUTF();
        requestId = 0;
        if (result >= 0 && result < MULTIPLIERS.length) {
            segment = result;
            reward = amount;
            animationAt = System.currentTimeMillis();
        }
    }

    void addControls(Vector controls, LangLa_bg panel, int left, int top, int width, int height) {
        int center = (left + width - 8) / 2;
        controls.addElement(new LangLa_jz(1205, center - 24, top + 34, center + 24, top + 68, null, panel));
        controls.addElement(new LangLa_jz(1207, left, height - 29, left + 65, height - 10, null, panel));
    }

    void draw(Graphics graphics, int left, int top, int width, int height) {
        int center = (left + width - 8) / 2;
        int middle = top + 49;
        long elapsed = System.currentTimeMillis() - animationAt;
        boolean spinning = elapsed < 1200;
        int rotation = segment < 0 ? 0 : 360 - segment * 60;
        if (spinning) {
            double remaining = (1200 - elapsed) / 1200.0;
            rotation -= 720 * remaining * remaining;
        }
        rotation = (rotation % 360 + 360) % 360;
        rotation -= rotation % 5;
        if (disk == null) disk = makeDisk();
        boolean previousRotation = graphics.k;
        graphics.k = true;
        graphics.a(disk, 0, 0, disk.c, disk.d, rotation, center, middle, 3);
        graphics.k = previousRotation;
        for (int prize = 0; prize < MULTIPLIERS.length; prize++) {
            double angle = Math.toRadians(prize * 60 + rotation);
            int x = center + (int) Math.round(Math.sin(angle) * 36);
            int y = middle - (int) Math.round(Math.cos(angle) * 36);
            label(graphics, MULTIPLIERS[prize], x, y - 5, 2, -1);
        }
        graphics.f(0xE4BB5B);
        graphics.c(center - 5, middle - RADIUS, 11, 3);
        graphics.c(center - 2, middle - RADIUS + 3, 5, 5);
        graphics.f(0x19796C);
        graphics.c(center - 23, middle - 11, 46, 23);
        label(graphics, "QUAY", center, middle - 4, 2, -1);
        label(graphics, "Điểm tuần: " + Utlis.numberFormat(points) + "   Lượt còn: " + available,
                left, height - 55, 0, -1);
        String prize = reward > 0 ? "+" + Utlis.numberFormat(reward) + " vàng khóa"
                : used < MILESTONES.length ? "Mốc kế: " + Utlis.numberFormat(MILESTONES[used]) : "Đã hoàn tất lượt tuần";
        label(graphics, status.isEmpty() ? (spinning ? "Đang quay…" : prize) : status, left, height - 42, 0, 0xFFFFD27A);
        label(graphics, "Chi tiết", left, height - 25, 0, 0xFF90E7D1);
    }

    private static mImage makeDisk() {
        mImage image = mImage.a(RADIUS * 2 + 1, RADIUS * 2 + 1);
        for (int y = -RADIUS; y <= RADIUS; y++) {
            for (int x = -RADIUS; x <= RADIUS; x++) {
                int squared = x * x + y * y;
                if (squared > RADIUS * RADIUS) continue;
                int wedge = ((int) ((Math.toDegrees(Math.atan2(x, -y)) + 390) / 60)) % 6;
                int color = squared > (RADIUS - 3) * (RADIUS - 3) ? 0xC0D5D4 : COLORS[wedge];
                image.b.drawPixel(x + RADIUS, y + RADIUS, (color << 8) | 0xFF);
            }
        }
        return image;
    }

    private static void label(Graphics graphics, String value, int x, int y, int anchor, int color) {
        mFont.a(mFont.d, graphics, value, x, y, anchor, color, 0);
    }
}