package beatdz;

import java.io.IOException;

final class EquipmentQuote {
    static final int CHANNEL = 103;
    static final int UPGRADE = 82;
    static final int COSTUME_FUSION = 94;
    private static int nextRequestId;

    final boolean valid;
    final String problem;
    final long silver, lockedSilver, gold;
    int nextLevel, chance, originalCount;
    long stonePoints, requiredPoints, stonePercent;
    String[] materials = new String[0];
    Item result;

    private EquipmentQuote(boolean valid, String problem, long silver, long lockedSilver, long gold) {
        this.valid = valid;
        this.problem = problem;
        this.silver = silver;
        this.lockedSilver = lockedSilver;
        this.gold = gold;
    }

    static Message request(int operation, int requestId) throws IOException {
        Message request = new Message((byte) 122);
        request.writeByte(CHANNEL);
        request.writeByte(operation);
        request.writeInt(requestId);
        return request;
    }

    static void receive(GameSrc game, Message message) throws IOException {
        int operation = message.readByte();
        int requestId = message.readInt();
        for (int i = game.cD.size() - 1; i >= 0; i--) {
            Object panel = game.cD.get(i);
            if (operation == UPGRADE && panel instanceof LangLa_ar) {
                LangLa_ar upgrade = (LangLa_ar) panel;
                if (upgrade.quote.requestId == requestId) upgrade.acceptQuote(read(operation, message));
                return;
            }
            if (operation == COSTUME_FUSION && panel instanceof LangLa_am) {
                LangLa_am fusion = (LangLa_am) panel;
                if (fusion.quote.requestId == requestId) fusion.acceptQuote(read(operation, message));
                return;
            }
        }
    }

    static EquipmentQuote read(int operation, Message message) throws IOException {
        boolean valid = message.readBoolean();
        String problem = message.readUTF();
        if (!valid) return new EquipmentQuote(false, problem, 0, 0, 0);
        EquipmentQuote quote = new EquipmentQuote(true, problem, message.readLong(), message.readLong(), message.readLong());
        if (operation == UPGRADE) {
            quote.nextLevel = message.readByte();
            quote.stonePoints = message.readLong();
            quote.requiredPoints = message.readLong();
            quote.stonePercent = message.readLong();
            quote.chance = message.readByte();
        } else {
            quote.originalCount = message.readByte();
        }
        int count = message.reader.dis.readUnsignedByte();
        quote.materials = new String[count];
        for (int i = 0; i < count; i++) {
            String name = message.readUTF();
            if (operation == UPGRADE) {
                quote.materials[i] = Utlis.numberFormat(message.reader.dis.readLong()) + " x " + name;
            } else {
                int level = message.readByte();
                quote.materials[i] = "1 x " + name + " (+" + level + ")" + (i == 0 ? " (ngoại hình)" : "");
            }
        }
        if (operation == COSTUME_FUSION) {
            quote.result = new Item();
            quote.result.read(message);
        }
        return quote;
    }

    String fees() {
        return "Bạc: " + Utlis.numberFormat(silver)
                + "\nBạc khóa: " + Utlis.numberFormat(lockedSilver)
                + "\nVàng: " + Utlis.numberFormat(gold);
    }

    String details(Item result) {
        StringBuilder text = new StringBuilder(result.getItemTemplate().name)
                .append(" +").append(result.level).append("\n\n").append(fees()).append('\n');
        if (requiredPoints > 0) {
            text.append("Tỉ lệ thành công: ").append(chance).append("%\n")
                .append("Điểm đá: ").append(Utlis.numberFormat(stonePoints)).append(" / ")
                .append(Utlis.numberFormat(requiredPoints)).append('\n')
                .append("Tối thiểu 10% điểm đá. Bùa cường hóa tùy chọn.\n");
        } else {
            text.append("Số cải trang gốc: ").append(originalCount).append('\n');
        }
        if (!problem.isEmpty()) text.append(problem).append('\n');
        text.append("\nNguyên liệu sẽ dùng\n");
        if (materials.length == 0) text.append("Chưa chọn nguyên liệu.\n");
        for (String material : materials) text.append(material).append('\n');
        text.append("\nChỉ số dự kiến\n");
        ItemOption[] options = result.L();
        if (options != null) {
            for (ItemOption option : options) {
                String label = option.a(Char.gI().idChar);
                text.append(label != null ? label : option.getItemOptionTemplate().name + " " + option.a[1]).append('\n');
            }
        }
        return text.toString();
    }

    static final class Query {
        private Item[] selected;
        private long silver, lockedSilver, requestedAt;
        int requestId;
        EquipmentQuote value;

        boolean refresh(Item[] items, boolean hasSelection, boolean trackWallet) {
            Char player = Char.gI();
            boolean changed = !java.util.Arrays.equals(selected, items)
                    || (trackWallet && (silver != player.bac || lockedSilver != player.bacKhoa));
            if (!hasSelection) {
                if (requestId == 0 && selected == null) return false;
                clear();
                return true;
            }
            long now = System.currentTimeMillis();
            if (!changed && (value != null || now - requestedAt < 2500)) return false;
            selected = items.clone();
            silver = player.bac;
            lockedSilver = player.bacKhoa;
            requestId = ++nextRequestId;
            requestedAt = now;
            value = null;
            return true;
        }

        void accept(EquipmentQuote quote) { value = quote; }

        void clear() {
            selected = null;
            requestId = 0;
            value = null;
        }

        String status() {
            if (value != null) return value.problem;
            if (requestId == 0) return "Đang lấy chi phí...";
            return System.currentTimeMillis() - requestedAt > 1500
                    ? "Chưa nhận dữ liệu máy chủ." : "Đang lấy chi phí...";
        }
    }
}
