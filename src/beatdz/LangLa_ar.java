package beatdz;

import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_ar extends LangLa_kj {

    public Item[] a = new Item[3];
    public Item[] b = new Item[16];
    private LangLa_ij[] h = new LangLa_ij[4];
    final EquipmentQuote.Query quote = new EquipmentQuote.Query();
    private final Item[] selection = new Item[18];
    private EquipmentQuote confirmedQuote;
    private long submittedAt;
    public int c;
    public LangLa_jw f;
    private LangLa_cg g;
    private Vector B;

    public LangLa_ar(MainScreen var1) {
        super(var1, new String[]{Caption.rx[1], Caption.H});
        this.h[0] = new LangLa_ij((byte) 1, 162, this.a_() + 16, 30, 30, 30, 1, 1);
        this.h[1] = new LangLa_ij((byte) 1, 242, this.a_() + 16, 30, 30, 30, 1, 1);
        this.h[2] = new LangLa_ij((byte) 1, 202, this.a_() + 53, 30, 30, 30, 1, 1);
        this.h[3] = new LangLa_ij((byte) 1, 14, this.a_() + 20, 128, 128, 32, 4, 4);
        this.a(this.a(this.width - 70, this.height - 33, Caption.rx[1], this, 0, -8), 0);
        this.a(this.a(109, this.height - 33, Caption.jY, this, 2002, -8), 0);
        LangLa_kd var3;
        int var2 = (var3 = new LangLa_kd(2000, Caption.rY)).c.length;
        if (DataCenter.gI().heightScreen <= 240) {
            var2 -= 3;
        }

        this.g = this.a(14, this.height - 32, 90, var2, var3, this, 1);
        this.g.a(mConfig.gI().readByte(7));
        this.a(this.g, 0);

    }

    public void a() {
        this.B = new Vector();
        this.t = new Item[Char.gI().arrItemBag.length];
        int var1 = 0;

        for (int var3 = 0; var3 < Char.gI().arrItemBag.length; ++var3) {
            Item var2;
            if ((var2 = Char.gI().arrItemBag[var3]) != null && var2.t()) {
                this.t[var1] = var2;
                ++var1;
            }

            if (var2 != null && var2.getItemTemplate().type == 21) {
                this.B.add(var2);
            }
        }

    }

    public void b() {
        try {
            refreshQuote();
            if (GameSrc.gI().Task == 9 && GameSrc.gI().idStep == 10) {
                LangLa_ar var1;
                int[] var6;
                int[] var10000;
                int var10001;
                if (this.a[0] == null) {
                    Char var7 = Char.gI();
                    int var9 = Char.gI().arrItemBody.length - 1;

                    Item var11;
                    while (true) {
                        if (var9 < 0) {
                            var11 = null;
                            break;
                        }

                        if (var7.arrItemBody[var9] != null && var7.arrItemBody[var9].getItemTemplate().type == 1) {
                            var11 = var7.arrItemBody[var9];
                            break;
                        }

                        --var9;
                    }

                    Item var8 = var11;
                    if (var11 != null && var8.level > 0) {
                        if (this.k() != this.j()) {
                            var10001 = this.cx + 245;
                            DataCenter.gI().aO.a(var10001, this.cy + 15);
                        } else {
                            var1 = this;
                            var9 = 0;

                            while (true) {
                                if (var9 > var1.t.length - 1) {
                                    var10000 = null;
                                    break;
                                }

                                if (var1.t[var9] != null && var1.t[var9].getItemTemplate().type == 1 && var1.t[var9].level == 0) {
                                    var10000 = new int[]{var9 % 9 * 32, var9 / 9 * 32};
                                    break;
                                }

                                --var9;
                            }

                            var6 = var10000;
                            if (this.cL == null) {
                                var10001 = this.cx + var6[0] + 20;
                                DataCenter.gI().aO.a(var10001, this.cy + 30 + var6[1] + 15);
                            }
                        }
                    } else if (this.k() != 1) {
                        var10001 = this.cx + 170;
                        DataCenter.gI().aO.a(var10001, this.cy + 15);
                    } else if (this.cL == null) {
                        var10001 = this.cx + 270;
                        DataCenter.gI().aO.a(var10001, this.cy + 50);
                    }
                } else if (this.B.size() == 0 || stoneChance() >= 100) {
                    if (this.k() != 0) {
                        var10001 = this.cx + 85;
                        DataCenter.gI().aO.a(var10001, this.cy + 15);
                    } else {
                        var10001 = this.cx + 255;
                        int var10002 = this.cy + this.height;
                        DataCenter.gI().aO.a(var10001, var10002 - 15);
                    }
                } else if (this.k() != this.j()) {
                    var10001 = this.cx + 245;
                    DataCenter.gI().aO.a(var10001, this.cy + 15);
                } else if (this.cL == null) {
                    var1 = this;
                    if (this.B.size() == 0) {
                        var10000 = null;
                    } else {
                        Item var2 = (Item) this.B.elementAt(0);
                        int[] var3 = null;

                        for (int var4 = 0; var4 < var1.t.length; ++var4) {
                            if (var1.t[var4].equals(var2)) {
                                var3 = new int[]{var4 % 9 * 32, var4 / 9 * 32};
                                var1.B.removeElementAt(0);
                                break;
                            }
                        }

                        var10000 = var3;
                    }

                    var6 = var10000;
                    if (var6 == null && stoneChance() < 100) {
                        var10001 = this.cx + 85;
                        DataCenter.gI().aO.a(var10001, this.cy + 10);
                        DataCenter.gI().aO.a = true;
                    } else if (stoneChance() < 100) {
                        var10001 = this.cx + var6[0] + 15;
                        DataCenter.gI().aO.a(var10001, this.cy + 25 + var6[1] + 15);
                    } else {
                        var10001 = this.cx + 85;
                        DataCenter.gI().aO.a(var10001, this.cy + 10);
                    }
                }

                DataCenter.gI().aO.a = true;
            }

            super.b();
            if (this.k() == 0) {

                for (int var10 = 0; var10 < this.h.length; ++var10) {
                    this.h[var10].a();
                }
            } else {
                this.a();
            }

            if (this.f != null) {
                this.f.p();
                if (this.f.r()) {
                    this.f = null;
                }
            }


        } catch (Exception var5) {
            Utlis.println(var5);
        }
    }

    void refreshQuote() throws java.io.IOException {
        if (System.currentTimeMillis() - submittedAt < 1500) return;
        selection[0] = a[0];
        selection[1] = a[2];
        System.arraycopy(b, 0, selection, 2, b.length);
        if (!quote.refresh(selection, a[0] != null, true)) return;
        a[1] = null;
        if (a[0] != null) {
            Message request = EquipmentQuote.request(EquipmentQuote.UPGRADE, quote.requestId);
            writeSelection(request);
            request.send();
        }
    }

    void acceptQuote(EquipmentQuote received) {
        quote.accept(received);
        if (received.valid && a[0] != null) {
            a[1] = a[0].a();
            a[1].isLock = true;
            a[1].a(received.nextLevel);
        }
    }

    private long stoneChance() {
        return quote.value == null ? 0 : quote.value.stonePercent;
    }

    private void writeSelection(Message message) throws java.io.IOException {
        message.writeByte(a[0].TYPE_TEMP);
        message.writeShort(a[0].index);
        message.writeShort(a[2] == null ? -1 : a[2].index);
        int count = 0;
        for (Item stone : b) if (stone != null) count++;
        message.writeByte(count);
        for (Item stone : b) if (stone != null) message.writeShort(stone.index);
    }

    boolean awaitingResult() {
        return System.currentTimeMillis() - submittedAt < 1500;
    }

    void upgradeResult(boolean success) {
        submittedAt = 0;
        confirmedQuote = null;
        quote.clear();
        if (a[0] != null && !a[0].u()) {
            Char.gI().h(a[0].TYPE_TEMP)[a[0].index] = a[0];
            a[0] = null;
        }
        p.showMessage(success ? "Cường hóa thành công." : "Cường hóa thất bại.", success ? -1 : -65536);
    }

    private void drawQuote(Graphics graphics) {
        if (a[0] == null) return;
        EquipmentQuote cost = quote.value;
        if (cost == null || !cost.valid) {
            if (cost == null) {
                mFont.b(mFont.d, graphics, quote.status(), 149, a_() + 89, 0, -2560, -16777216);
            } else {
                Vector lines = mFont.a(mFont.d, cost.problem, width - 158);
                for (int i = 0; i < lines.size(); i++) {
                    mFont.b(mFont.d, graphics, (String) lines.get(i), 149, a_() + 89 + i * 12, 0, -2560, -16777216);
                }
            }
            return;
        }
        int red = -65536;
        int orange = -30976;
        mFont.b(mFont.d, graphics, "Thành công: " + cost.chance + "%", 149, a_() + 89, 0, orange, -16777216);
        mFont.b(mFont.d, graphics, "Bạc: " + Utlis.numberFormat(cost.silver), 149, a_() + 100, 0,
                cost.silver > Char.gI().bac ? red : orange, -16777216);
        mFont.b(mFont.d, graphics, "Bạc khóa: " + Utlis.numberFormat(cost.lockedSilver), 149, a_() + 111, 0, orange, -16777216);
        mFont.b(mFont.d, graphics, "Vàng: " + Utlis.numberFormat(cost.gold), 149, a_() + 122, 0, orange, -16777216);
        mFont.b(mFont.d, graphics, "Điểm đá: " + Utlis.numberFormat(cost.stonePoints), 149, a_() + 133, 0, orange, -16777216);
        mFont.b(mFont.d, graphics, "Mốc 100%: " + Utlis.numberFormat(cost.requiredPoints), 149, a_() + 144, 0, orange, -16777216);
    }

    public void a(Graphics var1) {
        try {
            if (this.j() <= 0) {
                this.a(var1, this.cx, this.cy, this.width, this.height, Caption.q, (byte) 2, this.r);
            } else {
                super.a(var1);
            }

            if (this.k() == 0) {
                mFont.b(mFont.d, var1, Caption.aW, 14, this.a_() + 9, 0, -10831436, -16777216);
                a(var1, this.h[0].cx, this.h[0].cy, this.a[0], this.h[0].k >= 0, Caption.H);
                a(var1, this.h[1].cx, this.h[1].cy, this.a[1], this.h[1].k >= 0, Caption.I);
                a(var1, this.h[2].cx, this.h[2].cy, this.a[2], this.h[2].k >= 0, Caption.bn);
                LangLa_fq.a(var1, 95, 0, 210 - DataCenter.gI().i / 3 % 3, this.a_() + 25, 20);
                if (a[0] != null) {
                    mFont.b(mFont.d, var1, "(+" + a[0].level + ")", 169, a_() + 48, 33, -1, -16777216);
                    if (a[1] != null) {
                        mFont.b(mFont.d, var1, "(+" + a[1].level + ")", 249, a_() + 48, 33, -1, -16777216);
                    }
                }
                drawQuote(var1);
                this.a(var1, this.h[3]);

                for (int var6 = 0; var6 < this.h[3].i; ++var6) {
                    for (int var3 = 0; var3 < this.h[3].r; ++var3) {
                        b(var1, var3 * this.h[3].h, var6 * this.h[3].h, this.b[var6 * this.h[3].r + var3], var6 * this.h[3].i + var3 == this.h[3].k, "");
                    }
                }

                this.b(var1);
                if (this.f != null) {
                    this.f.b(var1, this.h[0].cx + this.h[0].h / 2, this.h[0].cy + this.h[0].h / 2);
                }
            }

        } catch (Exception var5) {
            Utlis.println(var5);
        }
    }

    public Vector c() {
        Vector var1 = super.c();
        if (this.k() == 0) {
            for (int var2 = 0; var2 < this.h.length; ++var2) {
                var1.addElement(this.h[var2].a(1001 + var2, this));
            }
        }

        return var1;
    }

    public void a(LangLa_jz var1, int var2, int var3) {
        if (this.k() == this.j() && var1.b == 0) {
            this.d();
        }

        super.a(var1, var2, var3);
        if (this.k() == 0) {
            switch (var1.b) {
                case 0:
                    this.a(true);
                    return;
                case 1001:
                    this.c = 1;
                    this.a(var1.j, var1.j.k);
                    if (this.a[0] == null) {
                        this.a(2);
                        DataCenter.gI().currentScreen.showMessage(Caption.mk, -1);
                        return;
                    }

                    this.cL = a(var1, this, this.a[0]);
                    return;
                case 1002:
                    this.c = 2;
                    this.a(var1.j, var1.j.k);
                    showUpgradePreview();
                    return;
                case 1003:
                    this.c = 3;
                    this.a(var1.j, var1.j.k);
                    if (this.a[2] == null) {
                        this.cL = b(Caption.oL, this, var1.j.cx - 124, var1.j.cy, 100);
                        return;
                    }

                    this.cL = a(var1, this, this.a[2]);
                    return;
                case 1004:
                    this.c = 4;
                    this.a(var1.j, var1.j.k);
                    this.cL = a(var1, this, this.b[var1.j.k]);
                    return;
                case 2001:
                    this.a(false);
                    return;
                case 2002:
                    if (awaitingResult()) return;
                    LangLa_ar var5 = this;
                    var2 = this.g.b.b;
                    var3 = 0;

                    for (int var4 = 0; var4 < Char.gI().arrItemBag.length && var3 < 16; ++var4) {
                        if (Char.gI().arrItemBag[var4] != null && Char.gI().arrItemBag[var4].q() && Char.gI().arrItemBag[var4].getItemTemplate().id <= var2) {
                            var5.a(Char.gI().arrItemBag[var4]);
                            ++var3;
                        }
                    }

                    var5.b();
            }
        }

    }

    private void showUpgradePreview() {
        if (a[0] == null) return;
        EquipmentQuote cost = quote.value;
        if (cost == null || !cost.valid || a[1] == null) {
            p.showMessage(quote.status(), -65536);
            return;
        }
        p.a((LangLa_cx) new ReleaseNotesDialog(p, "Xem trước nâng cấp", cost.details(a[1])));
    }

    private void a(Item var1) {
        try {
            for (int var2 = 0; var2 < this.b.length; ++var2) {
                if (this.b[var2] == null) {
                    this.b[var2] = var1;
                    break;
                }
            }

            Char.gI().arrItemBag[var1.index] = null;
        } catch (Exception var3) {
            Utlis.println(var3);
        }
    }

    private void a(LangLa_ii var1, int var2) {
        for (int var3 = 0; var3 < this.h.length; ++var3) {
            this.h[var3].k = -1;
        }

        var1.k = var2;
    }

    public void a(int var1) {
        super.a(var1);
        if (this.a != null && this.a[0] != null && !this.a[0].u()) {
            Char.gI().h(this.a[0].TYPE_TEMP)[this.a[0].index] = this.a[0];
            this.a[0] = null;
        }

    }

    public void d() {
        super.d();
        quote.clear();
        confirmedQuote = null;
        if (this.a[0] != null) {
            Char.gI().h(this.a[0].TYPE_TEMP)[this.a[0].index] = this.a[0];
            this.a[0] = null;
        }

        if (this.a[2] != null) {
            Char.gI().arrItemBag[this.a[2].index] = this.a[2];
            this.a[2] = null;
        }

        for (int var1 = 0; var1 < this.b.length; ++var1) {
            if (this.b[var1] != null) {
                int var10001 = this.b[var1].index;
                Char.gI().arrItemBag[var10001] = this.b[var1];
                this.b[var1] = null;
            }
        }

    }

    private void a(boolean confirm) {
        try {
            if (awaitingResult()) return;
            if (a[0] == null) {
                p.showMessage(Caption.jK, -65536);
                return;
            }
            refreshQuote();
            EquipmentQuote cost = quote.value;
            if (cost == null || !cost.valid || !cost.problem.isEmpty()) {
                p.showMessage(quote.status(), -65536);
                return;
            }
            if (confirm) {
                confirmedQuote = cost;
                String warning = cost.stonePercent > 120 ? "\n" + Caption.jM : "";
                p.a(cost.fees() + warning + "\nCường hóa trang bị?", 2001, this);
                return;
            }
            if (confirmedQuote != cost) {
                p.showMessage("Chi phí đã thay đổi. Hãy chọn Cường hóa lại.", -65536);
                return;
            }
            Message request = new Message((byte) 107);
            writeSelection(request);
            request.writeInt(quote.requestId);
            request.send();
            confirmedQuote = null;
            quote.clear();
            submittedAt = System.currentTimeMillis();
        } catch (Exception error) {
            Utlis.println(error);
        }
    }
}
