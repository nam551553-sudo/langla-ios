package beatdz;

import com.tgame.model.Caption;
import java.io.IOException;
import java.util.Comparator;
import java.util.Random;
import java.util.Vector;

public class Item implements Cloneable {

    
    public int shopCurrencyId;
    public int shopIcon = -1;
    public int idBuy;
    public int id;
    private int amount;
    public int amountBuy = -1;
    public int index;
    public int f;
    public int g = -1;
    public byte he;
    public long expiry = -1L;
    public String strOptions = "";
    public int bacBuy;
    public int bacKhoaBuy;
    public int vangBuy;
    public int vangKhoaBuy;
    public int tinhThachBuy;
    public int moneyOld;
    public int moneyNew;
    public byte level;
    public boolean isLock;
    private LangLa_hm v;
    private int[] w;
    public int TYPE_TEMP;
    public boolean rangeNE;

    public Item a() {
        try {
            return (Item) super.clone();
        } catch (Exception var2) {
            Utlis.println(var2);
            return null;
        }
    }

    public Item() {
        this.f = Utlis.nextInt((int) 6);
    }

    public Item(int var1) {
        this.id = var1;
        this.f = Utlis.nextInt((int) 6);
    }

    public Item(int var1, boolean var2) {
        this.id = (short) var1;
        this.isLock = var2;
        this.f = Utlis.nextInt((int) 6);
    }

    public Item(int var1, boolean var2, int var3) {
        this.id = (short) var1;
        this.isLock = true;
        this.amount = var3;
        this.f = Utlis.nextInt((int) 6);
    }

    public String b() {
        return DataCenter.gI().DataNameClass[this.he].name;
    }

    public void a(Graphics var1) {
        short var2 = 0;
        if (this.getItemTemplate() != null) {
            var2 = shopIcon >= 0 ? (short)shopIcon : this.getItemTemplate().idIcon;
            if (this.getItemTemplate().type == 12) {
                switch (this.id) {
                    case 124:
                        this.level = 18;
                        break;
                    case 125:
                        this.level = 2;
                        break;
                    case 126:
                        this.level = 3;
                        break;
                    case 127:
                        this.level = 10;
                        break;
                    case 128:
                        this.level = 5;
                        break;
                    case 129:
                        this.level = 8;
                        break;
                    case 130:
                        this.level = 10;
                        break;
                    case 131:
                        this.level = 12;
                        break;
                    case 132:
                        this.level = 14;
                        break;
                    case 133:
                        this.level = 16;
                        break;
                    case 345:
                        this.level = 19;
                        break;
                    case 535:
                        this.level = 17;
                }
            } else if (this.getItemTemplate().type == 13) {
                ItemOption[] var3 = this.L();
                int var4 = 0;
                if (var3 != null) {
                    if (this.id == 811 && var3[0].f() >= 1600) {
                        var2 = 1095;
                    }

                    for (int var5 = 0; var5 < 2; ++var5) {
                        var4 += var3[var5].a[1];
                    }
                }

                this.level = (byte) Math.min(19, var4 / 200);
            } else if (this.getItemTemplate().id == 570) {
                this.level = 4;
            } else if (this.getItemTemplate().id == 237) {
                this.level = 8;
            } else if (this.getItemTemplate().id == 703) {
                this.level = 12;
            } else if (this.getItemTemplate().id == 284 || this.getItemTemplate().id == 871) {
                this.level = 16;
            }
        }

        if (DataCenter.gI().i % 3 == 0) {
            ++this.f;
            if (this.f > 5) {
                this.f = 0;
            }
        }

        Binary2.a(var1, -5, 0, -12, -13, 25, (int) 25);
        if (this.level == 19) {
            var1.d(10.0F);
        }

        if (this.g > 0 && this.isTypeTrangBi() && this.level >= 17) {
            LangLa_fq.b(var1, this.g + this.f, 0, -14, -15, 0);
        }

        if (this.level == 19) {
            var1.h();
        }

        if (this.getItemTemplate() != null) {
            if (this.id == 435 && this.level == 18) {
                LangLa_fq.a(var1, 1021, 0, 0, 0, 3);
            } else if (this.id == 435 && this.level == 17) {
                LangLa_fq.a(var1, 964, 0, 0, 0, 3);
            } else if (this.id == 48 && this.level >= 8) {
                LangLa_fq.a(var1, 100, 0, 0, 0, 3);
            } else {
                if (rangeNE) {
                    if (DataCenter.gI().i % 40 <= 5) {
                        range = new Random().nextBoolean() ? -1 : 1;
                    } else {
                        range = 0;
                    }

                    LangLa_fq.a(var1, var2, 0, 0+range, 0+range, 3);
                } else {
                    LangLa_fq.a(var1, var2, 0, 0, 0, 3);
                }
            }
        }

        if (this.level == 19) {
            var1.d(10.0F);
        }

        this.ac();
        if (this.g > 0 && this.isTypeTrangBi() && this.level < 17) {
            LangLa_fq.b(var1, this.g + this.f, 0, -14, -15, 0);
        }

        if (this.v != null) {
            this.v.q();
            if (this.level < 10 && this.level >= 8) {
                var1.c(-93738);
            }

            this.v.b(var1, 0, 0);
            if (this.level < 10 && this.level >= 8) {
                var1.c();
            }
        }

        if (this.level == 19) {
            var1.h();
        }

    }
    public int range;
    private void ac() {
        if (this.v == null) {
            this.v = new LangLa_hm(0, 0, 0, -1);
        }

        if (this.level > 0 && this.level <= 3) {
            this.g = 3375;
        } else if (this.level >= 4 && this.level <= 7) {
            this.v.j = 224;
            this.g = 3554;
        } else if (this.level >= 8 && this.level <= 11) {
            this.v.j = 223;
            this.g = 3560;
        } else if (this.level >= 12 && this.level <= 13) {
            this.v.j = 222;
            this.g = 3566;
        } else if (this.level >= 14 && this.level <= 15) {
            this.v.j = 221;
            this.g = 3578;
        } else if (this.level == 16) {
            this.v.j = 220;
            this.g = 3572;
        } else if (this.level == 17) {
            this.v.j = 252;
            this.g = 7021;
        } else if (this.level >= 18) {
            this.v.j = 249;
            this.g = 6588;
        } else {
            this.v = null;
            this.g = -1;
        }
    }

    public void c() {
        switch (this.he) {
            case 1:
                this.g = 3572;
                return;
            case 2:
                this.g = 3578;
                return;
            case 3:
                this.g = 3566;
                return;
            case 4:
                this.g = 3560;
                return;
            case 5:
                this.g = 3554;
                return;
            default:
                this.g = -1;
        }
    }

    private int[] ad() {
        switch (this.getItemTemplate().type) {
            case 0:
                return new int[]{3, 4};
            case 1:
            default:
                return null;
            case 2:
                return new int[]{7, 8};
            case 3:
                return new int[]{0, 4};
            case 4:
                return new int[]{0, 3};
            case 5:
                return new int[]{6, 9};
            case 6:
                return new int[]{5, 9};
            case 7:
                return new int[]{2, 8};
            case 8:
                return new int[]{2, 7};
            case 9:
                return new int[]{6, 5};
        }
    }

    private static Item a(int var0, int var1, Char var2) {
        if (var1 == 0) {
            for (var1 = 0; var1 < var2.arrItemBody.length; ++var1) {
                if (var2.arrItemBody[var1] != null && var2.arrItemBody[var1].getItemTemplate().type == var0) {
                    return var2.arrItemBody[var1];
                }
            }
        } else {
            for (var1 = 0; var1 < var2.arrItemBody2.length; ++var1) {
                if (var2.arrItemBody2[var1] != null && var2.arrItemBody2[var1].getItemTemplate().type == var0) {
                    return var2.arrItemBody2[var1];
                }
            }
        }

        return null;
    }

    public int d() {
        if (this.vangBuy > 0) {
            return this.vangBuy;
        } else if (this.vangKhoaBuy > 0) {
            return this.vangKhoaBuy;
        } else if (this.bacBuy > 0) {
            return this.bacBuy;
        } else if (this.bacKhoaBuy > 0) {
            return this.bacKhoaBuy;
        } else {
            return this.tinhThachBuy > 0 ? this.tinhThachBuy : 0;
        }
    }

    public int e() {
        if (shopCurrencyId == LucDaoShopUI.CARD) return LucDaoShopUI.BUTTON;
        if (this.vangBuy > 0) {
            return -3;
        } else if (this.vangKhoaBuy > 0) {
            return -4;
        } else if (this.bacBuy > 0) {
            return -5;
        } else if (this.bacKhoaBuy > 0) {
            return -6;
        } else {
            return this.tinhThachBuy > 0 ? -9 : 0;
        }
    }

    public String f() {
        if (shopCurrencyId == LucDaoShopUI.CARD) return Utlis.numberFormat(d()) + " " + LucDaoShopUI.NAME;
        //rs = new String[]{"vàng", "vàng khóa", "bạc", "bạc khóa", "tinh thạch"};
        if (this.vangBuy > 0) {
            return Utlis.numberFormat(this.vangBuy) + " " + Caption.rs[0];
        } else if (this.vangKhoaBuy > 0) {
            return Utlis.numberFormat(this.vangKhoaBuy) + " " + Caption.rs[1];
        } else if (this.bacBuy > 0) {
            return Utlis.numberFormat(this.bacBuy) + " " + Caption.rs[2];
        } else if (this.bacKhoaBuy > 0) {
            return Utlis.numberFormat(this.bacKhoaBuy) + " " + Caption.rs[3];
        } else {
            return this.tinhThachBuy > 0 ? Utlis.numberFormat(this.tinhThachBuy) + " " + Caption.rs[4] : "";
        }
    }

    public String g() {
        ItemOption[] var1 = this.L();
        int var2 = 0;
        if (this.isTypeTrangBi() && var1 != null) {
            var2 = 0 + var1.length;
        }

        if (this.getItemTemplate().type == 34) {
            var2 = 50000;
        }

        return this.isLock ? Utlis.numberFormat(var2) + Caption.cs : Utlis.numberFormat(var2) + Caption.en;
    }

    public ItemTemplate getItemTemplate() {
        try {
            if (this.id >= 0) {
                return DataCenter.gI().ItemTemplate[this.id];
            }
        } catch (Exception var2) {
            Utlis.println(var2);
        }

        return null;
    }

    public boolean isTypeTrangBi() {
        for (int var1 = 0; var1 < DataCenter.gI().DataTypeItemBody.length; ++var1) {
            if (DataCenter.gI().DataTypeItemBody[var1].type == this.getItemTemplate().type) {
                return true;
            }
        }

        return false;
    }

    public boolean j() {
        return !Utlis.h(this.getItemTemplate().detail) && this.getItemTemplate().detail.toLowerCase().equals(Caption.on);
    }

    public boolean k() {
        return this.getItemTemplate().type == 1;
    }

    public boolean l() {
        return this.getItemTemplate().type == 0 || this.getItemTemplate().type == 2 || this.getItemTemplate().type == 4 || this.getItemTemplate().type == 6 || this.getItemTemplate().type == 8;
    }

    public boolean m() {
        return this.getItemTemplate().type == 3 || this.getItemTemplate().type == 5 || this.getItemTemplate().type == 7 || this.getItemTemplate().type == 9;
    }

    public boolean n() {
        return this.getItemTemplate().type == 12;
    }

    public boolean o() {
        try {
            ItemOption[] var1 = this.L();
            ItemOption var2;
            if (this.getItemTemplate().type == 11 && (var2 = var1[0]).a[1] == var1[0].f()) {
                return true;
            }
        } catch (Exception var3) {
        }

        return false;
    }

    public boolean p() {
        try {
            ItemOption[] var1 = this.L();
            ItemOption var2;
            if (this.getItemTemplate().type == 13 && (var2 = var1[0]).a[1] == var1[0].f() && (var2 = var1[1]).a[1] == var1[1].f()) {
                return true;
            }
        } catch (Exception var3) {
        }

        return false;
    }

    public boolean q() {
        return this.getItemTemplate().type == 21;
    }

    public boolean r() {
        return this.getItemTemplate().type == 14 && this.expiry == -1L && this.level == 0 && this.getItemTemplate().levelNeed <= Char.gI().level();
    }

    public boolean s() {
        return this.getItemTemplate().type == 14 && this.expiry == -1L && this.level > 0;
    }

    public boolean t() {
        return this.q() || this.u() || this.id == 162;
    }

//    public boolean u() {
//        if (this.getItemTemplate().type >= 0 && this.getItemTemplate().type <= 9) { //nâng cấp
//            if (this.X()) { //lục đạo
//                if (this.getItemTemplate().levelNeed >= 60 && this.level < 30 || this.getItemTemplate().levelNeed >= 50 && this.level < 25 || this.getItemTemplate().levelNeed >= 20 && this.level < 19) {
//                    return true;
//                }
//            } else if (this.W()) { // hiền nhân
//                if (this.getItemTemplate().levelNeed >= 60 && this.level < 25 || this.getItemTemplate().levelNeed >= 50 && this.level < 19 || this.getItemTemplate().levelNeed >= 20 && this.level < 16) {
//                    return true;
//                }
//            } else if (this.getItemTemplate().levelNeed >= 50 && this.level < 16 || this.getItemTemplate().levelNeed >= 40 && this.level < 14 || this.getItemTemplate().levelNeed >= 30 && this.level < 12 || this.getItemTemplate().levelNeed >= 20 && this.level < 8 || this.level < 4) {
//                return true;
//            }
//        }
//
//        return false;
//    }

    public boolean u() {
        if (this.getItemTemplate().type >= 0 && this.getItemTemplate().type <= 9) {
            return this.level < getMaxCuongHoaLevel();
        }

        return false;
    }

    public boolean v() {
        return this.l() || this.m() || this.k();
    }

    public boolean w() {
        return this.getItemTemplate().type == 32 || this.v();
    }

    public int a(int var1, Char var2) {
        int var3 = 0;
        if (this.getItemTemplate().type == 1) {
            if (var2.idhe == this.he || var2.arrItemBody[15] != null && var1 == 0 && (var2.arrItemBody[15].he == this.he || var2.arrItemBody[15].id == 881)) {
                var3 = 3;
            }
        } else if (this.getItemTemplate().type == 15) {
            if (var2.arrItemBody[1] != null && var2.arrItemBody[1].he == this.he) {
                var3 = 3;
            }
        } else {
            this.w = this.ad();
            if (this.w != null) {
                for (int var4 = 0; var4 < this.w.length; ++var4) {
                    Item var5;
                    if ((var5 = a(this.w[var4], var1, var2)) != null && (var5.he == this.he || var5.id == 881)) {
                        ++var3;
                    }
                }
            }
        }

        return var3;
    }

    public boolean x() {
        return this.getItemTemplate().type >= 0 && this.getItemTemplate().type <= 9 && this.level > 0;
    }

    public boolean y() {
        ItemOption[] var1;
        if ((var1 = this.L()) != null) {
            for (int var2 = 0; var2 < var1.length; ++var2) {
                if (var1[var2].getItemOptionTemplate().type == 8) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean z() {
        return this.id == 127;
    }

    public boolean A() {
        return this.getItemTemplate().type >= 0 && this.getItemTemplate().type <= 9 || this.getItemTemplate().type == 25;
    }

    public boolean B() {
        return this.getItemTemplate().type >= 0 && this.getItemTemplate().type <= 9 && this.T() > 0 || this.getItemTemplate().id == 658;
    }

    public boolean C() {
        return this.getItemTemplate().type == 13 || this.id == 160;
    }

    public boolean D() {
        return this.getItemTemplate().type == 2 || this.getItemTemplate().type == 8 || this.getItemTemplate().type == 7;
    }

    public boolean E() {
        return this.getItemTemplate().type == 6 || this.getItemTemplate().type == 5 || this.getItemTemplate().type == 9;
    }

    public boolean F() {
        return this.getItemTemplate().type == 0 || this.getItemTemplate().type == 4 || this.getItemTemplate().type == 3;
    }

    public boolean G() {
        return this.W() || this.id == 353 || this.id == 565 || this.id == 563 || this.id == 567;
    }

    public boolean H() {
        return this.getItemTemplate().type == 1 && this.getItemTemplate().levelNeed >= 40 && this.ae() || this.id == 353;
    }

    public boolean I() {
        return this.D() && this.getItemTemplate().levelNeed >= 40 && this.ae() || this.id == 565;
    }

    public boolean J() {
        return this.E() && this.getItemTemplate().levelNeed >= 40 && this.ae() || this.id == 563;
    }

    public boolean K() {
        return this.F() && this.getItemTemplate().levelNeed >= 40 && this.ae() || this.id == 567;
    }

    public void a(int var1) {
        var1 = Math.max(0, Math.min(19, var1));
        ItemOption[] var2;
        if ((var2 = this.L()) != null) {
            int var3;
            int var4;
            int[] var5;
            if (var1 >= this.level) {
                for (var3 = this.level + 1; var3 <= var1; ++var3) {
                    for (var4 = 0; var4 < var2.length; ++var4) {
                        if (var2[var4].getItemOptionTemplate().type != 8) {
                            var5 = var2[var4].getItemOptionTemplate().a();
                            if (var3 <= var5.length) {
                                var2[var4].d(var5[var3 - 1]);
                            }
                        }
                    }
                }
            } else {
                for (var3 = this.level; var3 > var1; --var3) {
                    for (var4 = 0; var4 < var2.length; ++var4) {
                        if (var2[var4].getItemOptionTemplate().type != 8) {
                            var5 = var2[var4].getItemOptionTemplate().a();
                            if (var3 <= var5.length) {
                                var2[var4].d(-var5[var3 - 1]);
                            }
                        }
                    }
                }
            }
        }

        this.level = (byte) var1;
        this.strOptions = a(var2);
    }

    public ItemOption[] L() {
        if (this.strOptions != null && this.strOptions.length() > 0) {
            String[] var1;
            ItemOption[] var2 = new ItemOption[(var1 = Utlis.split(this.strOptions, ";")).length];

            for (int var3 = 0; var3 < var1.length; ++var3) {
                var2[var3] = new ItemOption(var1[var3]);
                if (DataCenter.gI().equipmentBalanceRevision >= 1) {
                    var2[var3].balanceItemId = this.id;
                    var2[var3].balanceItemType = this.getItemTemplate().type;
                    var2[var3].balanceRevision = DataCenter.gI().equipmentBalanceRevision;
                    var2[var3].balanceOwner = this;
                }
            }

            if(DataCenter.gI().equipmentBalanceRevision>=1 && com.langla.balance.EquipmentBalance.tails(id)>0){
                java.util.ArrayList<ItemOption> unique=new java.util.ArrayList<ItemOption>();
                boolean found=false;
                for(ItemOption option:var2){if(option.d()==149){if(found)continue;found=true;}unique.add(option);}
                if(!found)unique.add(new ItemOption("149,"+com.langla.balance.EquipmentBalance.tails(id)));
                var2=unique.toArray(new ItemOption[0]);
            }
            return var2;
        } else {
            if(DataCenter.gI().equipmentBalanceRevision>=1 && com.langla.balance.EquipmentBalance.tails(id)>0)
                return new ItemOption[]{new ItemOption("149,"+com.langla.balance.EquipmentBalance.tails(id))};
            return null;
        }
    }

    public static String a(Vector var0) {
        ItemOption[] var1 = new ItemOption[var0.size()];

        for (int var2 = 0; var2 < var1.length; ++var2) {
            var1[var2] = (ItemOption) var0.get(var2);
        }

        return a(var1);
    }

    public static String a(ItemOption[] var0) {
        String var1 = "";
        if (var0 != null) {
            for (int var2 = 0; var2 < var0.length; ++var2) {
                var1 = var1 + var0[var2].g();
                if (var2 < var0.length - 1) {
                    var1 = var1 + ";";
                }
            }
        }

        return var1;
    }

    public int getAmount() {
        return this.amount <= 0 ? 1 : this.amount;
    }

    public void setAmount(int amount) {
        if (amount <= 0) {
            amount = 1;
        }

        this.amount = amount;
    }

    public String N() {
        if (this.expiry >= 2592000000L) {
            return this.expiry / 2592000000L + " " + Caption.rw[0];
        } else if (this.expiry >= 604800000L) {
            return this.expiry / 604800000L + " " + Caption.rw[1];
        } else if (this.expiry >= 86400000L) {
            return this.expiry / 86400000L + " " + Caption.rw[2];
        } else if (this.expiry >= 3600000L) {
            return this.expiry / 3600000L + " " + Caption.rw[3];
        } else {
            return this.expiry >= 60000L ? this.expiry / 60000L + " " + Caption.rw[4] : this.expiry / 1000L + " " + Caption.rw[5];
        }
    }

    public String O() {
        return Utlis.f(this.expiry);
    }

    public void read(Message var1) throws IOException {
        this.id = var1.readShort();
        if (this.id >= 0) {
            this.isLock = var1.readBoolean();
            this.expiry = var1.readLong();
            if (this.isTypeTrangBi()) {
                this.he = var1.readByte();
                this.level = (byte) Math.max(0, Math.min(19, var1.readByte()));
                this.strOptions = var1.reader.readUTF();
            } else {
                this.setAmount(var1.readInt());
            }

            if (this.getItemTemplate().type == 99) {
                this.strOptions = var1.reader.readUTF();
            }

            this.index = var1.readShort();
        }
    }

    public boolean P() {
        ItemOption[] var1;
        if ((var1 = this.L()) != null) {
            for (int var2 = 0; var2 < var1.length; ++var2) {
                if (var1[var2].a[0] == 159) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean Q() {
        ItemOption[] var1;
        if ((var1 = this.L()) != null) {
            for (int var2 = 0; var2 < var1.length; ++var2) {
                if (var1[var2].a[0] == 165) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean R() {
        ItemOption[] var1;
        if ((var1 = this.L()) != null) {
            for (int var2 = 0; var2 < var1.length; ++var2) {
                if (var1[var2].a[0] == 163) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean S() {
        ItemOption[] var1;
        if ((var1 = this.L()) != null) {
            for (int var2 = 0; var2 < var1.length; ++var2) {
                if (var1[var2].a[0] == 164) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean ae() {
        ItemOption[] var1;
        if ((var1 = this.L()) != null) {
            for (int var2 = 0; var2 < var1.length; ++var2) {
                if (var1[var2].a[0] == 148) {
                    return true;
                }
            }
        }

        return false;
    }

    public int T() {
        if (this.id >= 125 && this.id <= 133 || this.id == 535) {
            short var1 = 0;
            switch (this.id) {
                case 125:
                    var1 = 120;
                    break;
                case 126:
                    var1 = 240;
                    break;
                case 127:
                    var1 = 360;
                    break;
                case 128:
                    var1 = 480;
                    break;
                case 129:
                    var1 = 600;
                    break;
                case 130:
                    var1 = 720;
                    break;
                case 131:
                    var1 = 800;
                    break;
                case 132:
                    var1 = 1000;
                    break;
                case 133:
                    var1 = 1200;
                    break;
                case 535:
                    var1 = 1600;
            }

            long var2;
            int var4;
            if ((var2 = (this.expiry - Utlis.time()) / 86400000L) > 0L && (var4 = (int) (30L - var2) * var1 / 30) > 0 && var4 < var1) {
                return var1 - var4;
            }
        }

        if (this.getItemTemplate().type == 10 && this.expiry == -1L) {
            try {
                return Integer.parseInt(this.getItemTemplate().detail);
            } catch (Exception var7) {
                return 0;
            }
        } else {
            int var10 = 0;
            int var8 = 0;
            int var3 = 0;
            ItemOption[] var9;
            if ((var9 = this.L()) != null) {
                float var5 = 1.0F;

                for (int var6 = 0; var6 < var9.length; ++var6) {
                    if (var9[var6].getItemOptionTemplate().type <= 0) {
                        ++var10;
                    } else if (var9[var6].getItemOptionTemplate().type == 2) {
                        ++var8;
                    } else if (var9[var6].getItemOptionTemplate().type > 2 && var9[var6].getItemOptionTemplate().type <= 7) {
                        ++var3;
                    }

                    if (var9[var6].getItemOptionTemplate().id == 148) {
                        var5 = 1.2F;
                    } else if (var9[var6].getItemOptionTemplate().type == 9) {
                        var5 = 1.4F;
                    }
                }

                if (var10 >= 2 && var8 >= 2) {
                    byte var11 = 2;
                    if (this.getItemTemplate().levelNeed >= 50) {
                        var11 = 5;
                    } else if (this.getItemTemplate().levelNeed >= 40) {
                        var11 = 4;
                    } else if (this.getItemTemplate().levelNeed >= 30) {
                        var11 = 3;
                    } else if (this.getItemTemplate().levelNeed >= 20) {
                        var11 = 2;
                    } else if (this.getItemTemplate().levelNeed >= 10) {
                        var11 = 1;
                    }

                    if (var3 >= var11) {
                        if (this.getItemTemplate().levelNeed < 20) {
                            return (int) (1.0F * var5);
                        }

                        if (this.getItemTemplate().levelNeed < 30) {
                            return (int) (3.0F * var5);
                        }

                        return (int) ((float) (var10 + var8 + var3) * var5);
                    }
                }
            }

            return 0;
        }
    }

    public boolean U() {
        return this.getItemTemplate().type != 21 && this.getItemTemplate().type != 32 && this.getItemTemplate().type != 98 && this.getItemTemplate().type != 25 && this.id != 162 && this.id != 176;
    }

    public ItemOption a(Vector var1, int var2) {
        var2 = ItemOption.f(var2);
        ItemOption[] var3 = this.L();
        ItemOption var4 = null;
        if (var3 != null) {
            for (int var5 = 0; var5 < var3.length; ++var5) {
                if (var3[var5].getItemOptionTemplate().type == 8) {
                    var1.add(var3[var5]);
                    if (var3[var5].a[0] == var2) {
                        var4 = var3[var5];
                    }
                }
            }
        }

        return var4;
    }

    public int[] a(int var1, int var2) {
        ItemOption[] var3;
        if ((var3 = this.L()) == null) {
            return null;
        } else {
            int var4 = ItemOption.f(var2);
            int[] var5 = null;
            int var6 = this.Y();

            for (int var7 = 0; var7 < var3.length; ++var7) {
                if (var3[var7].getItemOptionTemplate().type == 8 && var3[var7].a[0] == var4) {
                    int var8 = var3[var7].i();
                    (var5 = new int[4])[0] = var2;
                    var5[1] = var8;
                    var5[2] = var8;
                    int[] var9 = var3[var7].getItemOptionTemplate().a();

                    for (int var10 = var8 + 1; var10 <= var9.length; ++var10) {
                        if (var1 >= DataCenter.gI().ngocKhamUpgrade[var10] && var10 <= var6) {
                            var5[1] = var8;
                            var5[2] = var10;
                            var5[3] += DataCenter.gI().ngocKhamUpgrade[var10];
                            var1 -= DataCenter.gI().ngocKhamUpgrade[var10];
                            var3[var7].d(var9[var10 - 1]);
                            var3[var7].a[3] = var10;
                        }
                    }
                }
            }

            this.strOptions = a(var3);
            return var5;
        }
    }

    public boolean V() {
        ItemOption[] var1;
        if ((var1 = this.L()) != null) {
            for (int var2 = 0; var2 < var1.length; ++var2) {
                if (var1[var2].a[0] == 148 || var1[var2].j()) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean W() {
        ItemOption[] var1;
        if ((var1 = this.L()) != null) {
            for (int var2 = 0; var2 < var1.length; ++var2) {
                if (var1[var2].j()) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean X() {
        ItemOption[] var1;
        if ((var1 = this.L()) != null) {
            for (int var2 = 0; var2 < var1.length; ++var2) {
                if (var1[var2].k()) {
                    return true;
                }
            }
        }

        return false;
    }

    public int Y() {
        ItemOption[] var1;
        if ((var1 = this.L()) != null) {
            for (int var2 = 0; var2 < var1.length; ++var2) {
                if (var1[var2].k()) {
                    return 18;
                }

                if (var1[var2].j()) {
                    return 17;
                }
            }
        }

        return 16;
    }

    public int Z() {
        if (this.getItemTemplate().levelNeed >= 50) {
            return 4;
        } else if (this.getItemTemplate().levelNeed >= 40) {
            return 3;
        } else {
            return this.getItemTemplate().levelNeed >= 30 ? 2 : 1;
        }
    }

    public boolean aa() {
        return this.expiry == -1L && this.id >= 476 && this.id <= 484;
    }

    public void b(Vector var1) {
        switch (this.getItemTemplate().type) {
            case 6:
                var1.add(new ItemOption("323,200,-1"));
                return;
            case 7:
                var1.add(new ItemOption("324,250,-1"));
            default:
                return;
            case 8:
                var1.add(new ItemOption("304,300,-1"));
                return;
            case 9:
                var1.add(new ItemOption("310,250,-1"));
        }
    }

    public boolean ab() {
        return this.id == 813 || this.id == 863;
    }

    public Object clone() {
        return this.a();
    }

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public Comparator a;
public void initialize() {
this.a = new LangLa_gj();
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.Item");
public static SessionState $state_Item() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }


    public int getMaxCuongHoaLevel() {
        int maxCuongHoaLevel = this.getBaseMaxCuongHoaLevel();
        ItemOption[] options = this.L();
        for (int i = 0; options != null && i < options.length; i++) {
            int optionLevel = getCuongHoaLevelByOptionId(options[i].d());
            if (optionLevel > maxCuongHoaLevel) {
                maxCuongHoaLevel = optionLevel;
            }
        }
        return Math.min(19, maxCuongHoaLevel);
    }


    private int getBaseMaxCuongHoaLevel() {
        int levelNeed = this.getItemTemplate().levelNeed;
        if (this.X() || this.WLD()) {
            if (levelNeed >= 60) {
                return 19;
            }
            if (levelNeed >= 50) {
                return 18;
            }
            if (levelNeed >= 40) {
                return 17;
            }
            return 0;
        }
        if (this.W()) {
            if (levelNeed >= 60) {
                return 18;
            }
            if (levelNeed >= 50) {
                return 17;
            }
            if (levelNeed >= 40) {
                return 16;
            }
            return 0;
        }
        if (levelNeed >= 50) {
            return 16;
        }
        if (levelNeed >= 40) {
            return 14;
        }
        if (levelNeed >= 30) {
            return 12;
        }
        if (levelNeed >= 20) {
            return 8;
        }
        return 4;
    }


    private static int getCuongHoaLevelByOptionId(int optionId) {
        switch (optionId) {
            case 374:
            case 381:
                return 20;
            case 375:
            case 382:
                return 22;
            case 376:
            case 383:
                return 24;
            case 377:
            case 384:
                return 26;
            case 378:
            case 385:
                return 28;
            case 386:
            case 392:
                return 30;
            case 387:
            case 393:
                return 32;
            case 388:
            case 394:
                return 34;
            case 389:
                return 36;
            case 390:
                return 38;
            case 391:
                return 40;
            default:
                return 0;
        }
    }




    /** Shared activation rule: explicit (+N) labels take priority over legacy type defaults. */
    public boolean isOptionActive(ItemOption option) {
        if (option == null || option.getItemOptionTemplate() == null) return false;
        ItemOptionTemplate template = option.getItemOptionTemplate();
        int cachedGrade = template.activationGrade;
        if (cachedGrade != Integer.MIN_VALUE) return cachedGrade <= 19 && level >= cachedGrade;
        int needed = getCuongHoaLevelByOptionId(option.d());
        if (needed == 0 && template.name != null) {
            java.util.regex.Matcher match = java.util.regex.Pattern.compile("\\(\\+(\\d+)\\)").matcher(template.name);
            if (match.find()) needed = Integer.parseInt(match.group(1));
        }
        if (needed == 0) {
            switch (template.type) {
                case 3: needed=4; break; case 4: needed=8; break; case 5: needed=12; break;
                case 6: needed=14; break; case 7: needed=16; break; case 10: needed=17; break;
                case 11: needed=18; break; case 15: needed=2; break; case 16: needed=19; break;
                default: template.activationGrade = 0; return true;
            }
        }
        template.activationGrade = needed;
        return needed <= 19 && level >= needed;
    }
    public boolean WLD() { return X(); }

}
