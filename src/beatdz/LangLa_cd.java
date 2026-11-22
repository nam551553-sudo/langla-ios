package beatdz;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.tgame.model.Caption;
import java.util.Collections;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class LangLa_cd extends LangLa_fn {
    static final int SCHEDULE_CHANNEL = 104;

    
    
    
    
    
    private LangLa_ii[][] f;
    private LangLa_ij g;
    private int h;
    private int i;
    private int j;
    private int o;
    private int s;
    private int t;
    private int u;
    private Vector v = new Vector();
    private Vector w = new Vector();
    private Vector x = new Vector();
    private String[][] y;
    private String[][] z;
    private boolean A;
    private boolean B;
    private int C;
    private int D;
    private LangLa_dz E;
    private Item[][] F;
    private LangLa_ii[][] G;
    private Item H;

    public LangLa_cd(MainScreen var1, Message var2) {
        super(var1);

        try {
            LangLa_kd var9;
            (var9 = new LangLa_kd(5000)).c = Caption.sI;
            this.a(var9, 170, 74, 4);
            this.r = false;
            this.a(348, 216);
            this.h = Utlis.getDay();
            this.i = (this.width - 10) / 7;
            this.j = this.G() - 30;
            this.o = 35;
            this.s = 6;
            this.t = this.a_() + 2;
            this.f = new LangLa_ii[4][];
            this.f[0] = new LangLa_ii[1];
            this.f[0][0] = new LangLa_ii((byte) 0, this.s, this.t, this.i * 7, 18, this.i, 7);

            int var3;
            for (List<LangLa_ek> day : $state_LangLa_cd().week) {
                for (LangLa_ek activity : day) {
                    activity.g = mFont.c(mFont.b, activity.d, this.i - 6);
                }
            }

            this.g();

            try {
                String[] var11 = Utlis.split(var2.readUTF(), "\\n");
                this.v.clear();

                for (int var12 = 0; var12 < var11.length; ++var12) {
                    this.v.addAll(mFont.a(mFont.d, var11[var12], super.width - 8 - 46));
                }

                this.f[1] = new LangLa_ii[1];
                this.f[1][0] = new LangLa_ii((byte) 1, 14, this.a_() + 14, super.width - 8 - 20, 154, 14, this.v.size());
            } catch (Exception var7) {
            }

            this.y = new String[2][var2.reader.dis.readByte()];

            for (var3 = 0; var3 < this.y[0].length; ++var3) {
                this.y[0][var3] = var2.readUTF();
                this.y[1][var3] = var2.readUTF();
            }

            this.f();
            this.f[2] = new LangLa_ii[3];
            this.f[2][0] = new LangLa_ii((byte) 1, 13, this.a_() + 11, super.width - 8 - 18, 162, 27, this.y[0].length);
            this.f[2][1] = new LangLa_ii((byte) 1, 13, this.a_() + 45, super.width - 8 - 18, 105, 15, 0);
            this.f[2][2] = new LangLa_ii((byte) 1, 13, this.a_() + 11, super.width - 8 - 18, 27, 27, 1);
            this.z = Caption.qP;
            this.f[3] = new LangLa_ii[3];
            this.f[3][0] = new LangLa_ii((byte) 1, 13, this.a_() + 11, super.width - 8 - 18, 162, 27, this.z[0].length);
            this.f[3][1] = new LangLa_ii((byte) 1, 13, this.a_() + 45, super.width - 8 - 18, 120, 15, 0);
            this.f[3][2] = new LangLa_ii((byte) 1, 13, this.a_() + 11, super.width - 8 - 18, 27, 27, 1);
            GameSrc.gI().bO = e() == null;
            this.E = this.a(this.width - 75, this.height - 37, Caption.ma, this, 1011, -8);
            this.a(this.E, 2);
            this.a(0);
        } catch (Exception var8) {
            Utlis.println(var8);
        }
    }

    private void f() {
        int[][] var1 = new int[Math.max(18, this.y[0].length)][];
        var1[3] = new int[]{164, 174, 5};
        var1[4] = new int[]{164, 175, 4};
        var1[5] = new int[]{164, 248, 6};
        var1[6] = new int[]{564, 428, 218};
        var1[7] = new int[]{164, 562, 5};
        var1[8] = new int[]{163, 5};
        var1[9] = new int[]{7, 163};
        var1[10] = new int[]{164, 310, 6};
        var1[11] = new int[]{216, 4, 163};
        var1[12] = new int[]{191, 599, 218};
        var1[13] = new int[]{163, 192};
        var1[14] = new int[]{163, 476};
        var1[15] = new int[]{6, 163};
        var1[16] = new int[]{8, 163, 354};
        var1[17] = new int[]{6, 163};
        this.F = new Item[var1.length][];
        this.G = new LangLa_ii[var1.length][];

        for (int var2 = 0; var2 < var1.length; ++var2) {
            if (var1[var2] != null) {
                this.F[var2] = new Item[var1[var2].length];
                this.G[var2] = new LangLa_ii[var1[var2].length];

                for (int var3 = 0; var3 < var1[var2].length; ++var3) {
                    this.F[var2][var3] = new Item(var1[var2][var3], true);
                    if ((var2 == 3 || var2 == 6) && var3 < 4 || var2 == 8 || this.F[var2][var3].id == 685 || this.F[var2][var3].id == 164 || this.F[var2][var3].id == 698) {
                        this.F[var2][var3].isLock = false;
                    }

                    this.G[var2][var3] = new LangLa_ii((byte) 1, 75 + var3 * 35, this.a_() + this.height - 63, 28, 28, 1, 1);
                }
            }
        }

    }

    public static LangLa_ek e() {
        long second = Utlis.activitySeconds();
        SessionState state = $state_LangLa_cd();
        if (state.checkedSecond != second) {
            state.active = null;
            int now = Utlis.activitySecondOfDay(second);
            List<LangLa_ek> today = b(Utlis.activityDay(second));
            for (int i = 0; i < today.size(); i++) {
                LangLa_ek activity = today.get(i);
                if (activity.b <= now && now < activity.c) {
                    state.active = activity;
                    break;
                }
            }
            state.checkedSecond = second;
        }
        return state.active;
    }

    private static List<LangLa_ek> b(int day) {
        return $state_LangLa_cd().week.get(day);
    }

    static void readSchedule(Message message) throws IOException {
        long serverTime = message.readLong();
        int count = message.reader.dis.readUnsignedByte();
        List<List<LangLa_ek>> week = emptyWeek();
        for (int i = 0; i < count; i++) {
            int days = message.reader.dis.readUnsignedByte();
            int start = message.readInt();
            int end = message.readInt();
            String name = message.readUTF();
            int map = message.readShort();
            int npc = message.readShort();
            if (days == 0 || days >= 128 || start < 0 || start >= end || end > 86400) {
                throw new IOException("Invalid weekly activity slot");
            }
            for (int day = 0; day < 7; day++) {
                if ((days & (1 << day)) != 0) week.get(day).add(new LangLa_ek(day, name, start, end, map, npc));
            }
        }
        SessionState state = $state_LangLa_cd();
        state.setWeek(week);
        Utlis.$state_Utlis().timeAdd = serverTime - System.currentTimeMillis();
    }

    private static List<List<LangLa_ek>> emptyWeek() {
        List<List<LangLa_ek>> week = new ArrayList<>(7);
        for (int day = 0; day < 7; day++) week.add(new ArrayList<>());
        return week;
    }

    private static boolean isOpen(int map, int npc) {
        long second = Utlis.activitySeconds();
        int now = Utlis.activitySecondOfDay(second);
        for (LangLa_ek slot : b(Utlis.activityDay(second))) {
            if (slot.e == map && slot.f == npc && slot.b <= now && now < slot.c) return true;
        }
        return false;
    }

    public Vector c() {
        Vector var1 = super.c();
        int var2;
        switch (this.k()) {
            case 0:
                for (var2 = 0; var2 < this.f[this.k()].length; ++var2) {
                    var1.addElement(this.f[this.k()][var2].a(1020 + var2, this));
                }

                if (this.g != null) {
                    var1.addElement(this.g.a(1010, this));
                }
                break;
            case 1:
                for (var2 = 0; var2 < this.f[this.k()].length; ++var2) {
                    var1.addElement(this.f[this.k()][var2].a(1030, this));
                }

                return var1;
            case 2:
                if (!this.A) {
                    var1.addElement(this.f[this.k()][0].a(9980, this));
                } else {
                    var1.addElement(this.f[this.k()][2].a(9981, this));
                    var1.addElement(this.f[this.k()][1].a(1030, this));
                    if (this.G[this.C] != null) {
                        for (var2 = 0; var2 < this.G[this.C].length; ++var2) {
                            if (this.G[this.C][var2] != null) {
                                var1.addElement(this.G[this.C][var2].a(3000, this, this.F[this.C][var2]));
                            }
                        }
                    }
                }
                break;
            case 3:
                if (!this.B) {
                    var1.addElement(this.f[this.k()][0].a(8980, this));
                } else {
                    var1.addElement(this.f[this.k()][2].a(8981, this));
                    var1.addElement(this.f[this.k()][1].a(2030, this));
                }
        }

        return var1;
    }

    public void a(Graphics var1) {
        super.a(var1);
        switch (this.k()) {
            case 0:
                Graphics var2 = var1;
                LangLa_cd var13 = this;
                this.a(var1, this.f[this.k()][0]);

                for (int var5 = 0; var5 < var13.f[var13.k()][0].i; ++var5) {
                    int var3 = var13.h == var5 ? -1 : -6488;
                    var13.u = var5 * var13.i + 2;
                    var13.a(var2, var13.u, 0, var13.i - 4, 18, var5 == var13.h ? -20 : -19, 84, 5, 1, 1);
                    mFont.b(mFont.d, var2, Caption.sG[var5], var13.u + var13.i / 2 - 2, 2 + mFont.a(mFont.d) / 2, 2, var3, -10275328);
                }

                var13.b(var2);
                List<LangLa_ek> var15 = b(var13.h);
                int var7 = 0;
                long second = Utlis.activitySeconds();
                int day = Utlis.activityDay(second);
                int now = Utlis.activitySecondOfDay(second);
                if (var15.size() > 0) {
                    var13.a(var2, var13.g);

                    for (int var8 = 0; var8 < var13.g.i; ++var8) {
                        for (int var9 = 0; var9 < var13.g.r; ++var9) {
                            if (var7 < var15.size()) {
                                LangLa_ek var6 = (LangLa_ek) var15.get(var7);
                                if (var13.g.b(var8)) {
                                    try {
                                        short var14 = -6488;
                                        if (var6.a == day && var6.b <= now && now < var6.c) {
                                            var14 = -2560;
                                            var13.a(var2, 2 + var9 * var13.g.h, 7 + var8 * var13.g.h, var13.i - 6, var13.o + 5, -21, 84, 5, 1, 1);
                                        } else {
                                            var13.a(var2, 2 + var9 * var13.g.h, 7 + var8 * var13.g.h, var13.i - 6, var13.o + 5, -14, 84, 5, 1, 1);
                                        }

                                        int var4 = var6.g.length;

                                        for (int var10 = 0; var10 < var4; ++var10) {
                                            mFont.a((BitmapFont) Graphics.b(75), (Graphics) var2, var6.g[var10], var9 * var13.g.h + var13.i / 2 - 1, 15 + var8 * var13.g.h + var10 * mFont.a(mFont.b), 2, var14, -10275328);
                                        }

                                        mFont.a((BitmapFont) Graphics.b(75), (Graphics) var2, var6.timeLabel, var9 * var13.g.h + var13.i / 2 - 1, 15 + var8 * var13.g.h + var4 * mFont.a(mFont.b), 2, var14, -10275328);
                                        if (var7 == var13.g.k) {
                                            var2.f(-1);
                                            var2.b(2 + var9 * var13.g.h - 1, 7 + var8 * var13.g.h - 1, var13.i - 6 + 1, var13.o + 5 + 1);
                                        }
                                    } catch (Exception var12) {
                                    }
                                }
                            }

                            ++var7;
                        }
                    }

                    var13.b(var2);
                }

                return;
            case 1:
                this.e(var1);
                return;
            case 2:
                this.f(var1);
                return;
            case 3:
                this.g(var1);
            default:
        }
    }

    private void e(Graphics var1) {
        this.a(var1, 9, this.a_() + 5, super.width - 8 - 10, this.G() - 10, 4, 55, 56);
        this.a(var1, this.f[this.k()][0]);

        for (int var2 = 0; var2 < this.f[this.k()][0].i; ++var2) {
            if (this.f[this.k()][0].b(var2)) {
                mFont.a(var1, (String) this.v.get(var2), 5, var2 * this.f[this.k()][0].h + 6, 0, -1);
            }
        }

        this.b(var1);
    }

    private void f(Graphics var1) {
        this.a(var1, 7, this.a_() + 5, super.width - 8 - 6, this.G() - 10, 4, 55, 56);
        int var2;
        if (!this.A) {
            this.a(var1, this.f[this.k()][0]);

            for (var2 = 0; var2 < this.f[this.k()][0].i; ++var2) {
                if (this.f[this.k()][0].b(var2)) {
                    this.a(var1, 0, var2 * this.f[this.k()][0].h, this.f[this.k()][0].width, 26, -17, 84, 5, 1, 1);
                    LangLa_fq.a(var1, 395, 0, 6, var2 * this.f[this.k()][0].h + 8, 20);
                    if (this.f[this.k()][0].l == var2) {
                        mFont.a(var1, this.y[0][var2], 22, 13 + var2 * this.f[this.k()][0].h, 0, -1);
                    } else {
                        mFont.a(var1, this.y[0][var2], 22, 12 + var2 * this.f[this.k()][0].h, 0, -1);
                    }

                    if (this.F != null && this.F[var2] != null) {
                        for (int var3 = 0; var3 < this.F[var2].length; ++var3) {
                            if (this.F[var2][var3] != null) {
                                int var10004 = this.F[var2].length;
                                Binary2.a(var1, 53, 0, this.f[this.k()][0].width - var10004 * 25 + var3 * 25, 2 + var2 * this.f[this.k()][0].h, 22, (int) 22);
                                var10004 = this.F[var2].length;
                                Binary2.a(var1, this.F[var2][var3].getItemTemplate().idIcon, 0, this.f[this.k()][0].width - var10004 * 25 + var3 * 25 + 12, 1 + var2 * this.f[this.k()][0].h + 12, 95, (byte) 3);
                                if (this.F[var2][var3].isLock) {
                                    var10004 = this.F[var2].length;
                                    Binary2.a(var1, 44, 0, this.f[this.k()][0].width - var10004 * 25 + var3 * 25 + 2, 2 + var2 * this.f[this.k()][0].h + 2, 80);
                                }
                            }
                        }
                    }
                }
            }

            this.b(var1);
            this.f[this.k()][0].b(var1, -4, -10);
        } else {
            this.a(var1, this.f[this.k()][2]);
            this.a(var1, 0, 0 * this.f[this.k()][2].h, this.f[this.k()][2].width, 26, -17, 84, 5, 1, 1);
            if (this.f[this.k()][2].l == 0) {
                mFont.a(var1, this.y[0][this.C], 22, 13, 0, -1);
                var1.e(30);
                LangLa_fq.a(var1, 398, 0, this.f[this.k()][2].width - 21, 5, 20);
                var1.d();
            } else {
                mFont.a(var1, this.y[0][this.C], 22, 12, 0, -1);
                LangLa_fq.a(var1, 398, 0, this.f[this.k()][2].width - 22, 4, 20);
            }

            LangLa_fq.a(var1, 396, 0, 6, 0 * this.f[this.k()][2].h + 8, 20);
            this.b(var1);
            this.a(var1, this.f[this.k()][1]);

            for (var2 = 0; var2 < this.f[this.k()][1].i; ++var2) {
                mFont.c(mFont.d, var1, (String) this.w.get(var2), 2, 6 + var2 * this.f[this.k()][1].h, 0, -1, 0);
            }

            this.b(var1);
            this.f[this.k()][1].b(var1, -12, -10);
            if (this.F != null && this.F.length > 0 && this.F[this.C] != null) {
                mFont.a(var1, Caption.mN, 16, this.a_() + this.height - 52, 0, -1);

                for (var2 = 0; var2 < this.F[this.C].length; ++var2) {
                    if (this.F[this.C][var2] != null) {
                        b(var1, 75 + var2 * 35, this.a_() + this.height - 72, this.F[this.C][var2], this.H != null && this.H.equals(this.F[this.C][var2]));
                    }
                }
            }

        }
    }

    private void g(Graphics var1) {
        this.a(var1, 7, this.a_() + 5, super.width - 8 - 6, this.G() - 10, 4, 55, 56);
        int var2;
        if (!this.B) {
            this.a(var1, this.f[this.k()][0]);

            for (var2 = 0; var2 < this.f[this.k()][0].i; ++var2) {
                if (this.f[this.k()][0].b(var2)) {
                    this.a(var1, 0, var2 * this.f[this.k()][0].h, this.f[this.k()][0].width, 26, -17, 84, 5, 1, 1);
                    LangLa_fq.a(var1, 395, 0, 6, var2 * this.f[this.k()][0].h + 8, 20);
                    if (this.f[this.k()][0].l == var2) {
                        mFont.a(var1, this.z[0][var2], 22, 13 + var2 * this.f[this.k()][0].h, 0, -1);
                    } else {
                        mFont.a(var1, this.z[0][var2], 22, 12 + var2 * this.f[this.k()][0].h, 0, -1);
                    }
                }
            }

            this.b(var1);
        } else {
            this.a(var1, this.f[this.k()][2]);
            this.a(var1, 0, 0 * this.f[this.k()][2].h, this.f[this.k()][2].width, 26, -17, 84, 5, 1, 1);
            if (this.f[this.k()][2].l == 0) {
                mFont.a(var1, this.z[0][this.D], 22, 13, 0, -1);
                var1.e(30);
                LangLa_fq.a(var1, 398, 0, this.f[this.k()][2].width - 21, 5, 20);
                var1.d();
            } else {
                mFont.a(var1, this.z[0][this.D], 22, 12, 0, -1);
                LangLa_fq.a(var1, 398, 0, this.f[this.k()][2].width - 22, 4, 20);
            }

            LangLa_fq.a(var1, 396, 0, 6, 0 * this.f[this.k()][2].h + 8, 20);
            this.b(var1);
            this.a(var1, this.f[this.k()][1]);

            for (var2 = 0; var2 < this.f[this.k()][1].i; ++var2) {
                mFont.c(mFont.d, var1, (String) this.x.get(var2), 2, 6 + var2 * this.f[this.k()][1].h, 0, -1, 0);
            }

            this.b(var1);
            this.f[this.k()][1].b(var1, -12, -10);
        }
    }

    public void b() {
        for (int var1 = 0; var1 < this.f.length; ++var1) {
            for (int var2 = 0; var2 < this.f[var1].length; ++var2) {
                if (this.f[var1][var2] != null) {
                    this.f[var1][var2].a();
                }
            }
        }

        if (this.g != null) {
            this.g.a();
        }

        if (this.A && this.C > 1 && this.C < 12) {
            this.E.b(false);
        } else {
            this.E.b(true);
        }
    }

    public void a(LangLa_jz var1, int var2, int var3) {
        super.a(var1, var2, var3);
        if (var1.b >= 1020 && var1.b < 1030 && var1.j.k >= 0) {
            this.h = var1.j.k;
            this.g();
        }

        List<LangLa_ek> var4 = b(this.h);
        String[] var9;
        LangLa_ek var10;
        switch (var1.b) {
            case 1010:
                if (this.g.k >= 0 && this.g.k < var4.size()) {
                    if (Char.gI().idClass <= 0) {
                        this.cL = a(Caption.lZ, this, var2, var3, 180);
                        return;
                    }

                    if ((var10 = var4.get(this.g.k)).f == -2) {
                        this.cL = a(Caption.qc, this, var2, var3, 180);
                    } else {
                        if (var10.e != 57 || var10.f >= 0) {
                            DataCenter.gI().currentScreen.a(Utlis.replaceAll(Caption.lY, var10.d), 2001, this);
                            return;
                        }

                        Vector var13;
                        (var13 = new Vector()).addElement(new LangLa_lk(2001, Caption.sS[0]));
                        var13.addElement(new LangLa_lk(2002, Caption.sS[1]));
                        var13.addElement(new LangLa_lk(2003, Caption.sS[2]));
                        var13.addElement(new LangLa_lk(2004, Caption.sS[3]));
                        var13.addElement(new LangLa_lk(2005, Caption.sS[4]));
                        if (var13.size() > 0) {
                            String[] var5 = new String[var13.size()];
                            short[] var6 = new short[var13.size()];

                            for (int var7 = 0; var7 < var13.size(); ++var7) {
                                LangLa_lk var8 = (LangLa_lk) var13.elementAt(var7);
                                var5[var7] = var8.b;
                                var6[var7] = (short) var8.a;
                            }

                            this.cL = a(this, var2, var3, new LangLa_kd(3000, var6, var5));
                        }
                    }
                }
                break;
            case 1011:
                if (Char.gI().idClass == 0) {
                    GameSrc.gI().showMessage(Caption.mb, -1);
                    return;
                }

                switch (this.C) {
                    case 2:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        GameSrc.gI();
                        GameSrc.a(32);
                        break;
                    case 3:
                        GameSrc.gI();
                        GameSrc.a(102);
                        break;
                    case 4:
                        GameSrc.gI();
                        GameSrc.a(98);
                        break;
                    case 5:
                        GameSrc.gI();
                        GameSrc.a(59);
                        break;
                    case 10:
                        GameSrc.gI();
                        GameSrc.a(99);
                        break;
                    case 11:
                        if (GameSrc.gI().mapID == 86) {
                            GameSrc.gI().showMessage(Caption.mm, -2560);
                        } else {
                            GameSrc.gI().aR = new LangLa_eo(86, 0, 0);
                        }
                }

                this.J();
                return;
            case 2001:
                if (this.g.k < 0 || this.g.k >= var4.size()) return;
                if ((var10 = var4.get(this.g.k)).e >= 0 && var10.f >= 0) {
                    GameSrc.gI().aR = new LangLa_eo(var10.f, -1, -1, var10.e, 0, 0);
                } else if (var10.f >= 0) {
                    if (var10.f == 30) {
                        if (GameSrc.gI().mapID == 86) {
                            GameSrc.gI().showMessage(Caption.mm, -2560);
                        } else {
                            GameSrc.gI().aR = new LangLa_eo(86, 0, 0);
                        }
                    } else {
                        GameSrc.gI();
                        GameSrc.a(var10.f);
                    }
                }

                this.J();
                break;
            case 3000:
                this.H = (Item) var1.k;
                Item var11 = this.H;
                this.cL = LangLa_cz.a(this, var1.e + 2, var1.d, 32, var11);
                LangLa_dp.a().h();
                return;
            case 8980:
                if (var1.j.k >= 0) {
                    this.D = var1.j.k;
                    var9 = Utlis.split(this.z[1][this.D], "\\n");
                    this.x.clear();

                    for (var2 = 0; var2 < var9.length; ++var2) {
                        this.x.addAll(mFont.a(mFont.d, var9[var2], super.width - 8 - 40));
                    }

                    this.f[3][1] = new LangLa_ii((byte) 1, 13, this.a_() + 45, super.width - 8 - 18, 120, 15, this.x.size());
                    this.B = true;
                    return;
                }
                break;
            case 8981:
                this.B = false;
                return;
            case 9980:
                if (var1.j.k >= 0) {
                    this.C = var1.j.k;
                    var9 = Utlis.split(this.y[1][this.C], "\\n");
                    this.w.clear();

                    for (var2 = 0; var2 < var9.length; ++var2) {
                        this.w.addAll(mFont.a(mFont.d, var9[var2], super.width - 8 - 40));
                    }

                    this.f[2][1] = new LangLa_ii((byte) 1, 13, this.a_() + 45, super.width - 8 - 18, 105, 15, this.w.size());
                    this.A = true;
                    return;
                }
                break;
            case 9981:
                this.A = false;
                return;
        }

    }

    private void g() {
        int rows = Utlis.c(b(this.h).size(), 7);
        this.g = new LangLa_ij((byte) 1, 6, this.a_() + 25, this.i * 7, this.i * 3, this.i, rows, 7);
    }

    public void a(int var1, Object var2, LangLa_cy var3) {
        switch (var1) {
            case 2001:
                a(57, 958, 443);
                this.J();
                return;
            case 2002:
                a(65, 906, 137);
                this.J();
                return;
            case 2003:
                a(87, 969, 150);
                this.J();
                return;
            case 2004:
                a(79, 1036, 141);
                this.J();
                return;
            case 2005:
                a(73, 751, 178);
                this.J();
            default:
        }
    }

    public void a(int var1, Object var2) {
    }

    private static void a(int var0, int var1, int var2) {
        if (!isOpen(57, -1)) {
            GameSrc.gI().showMessage(Caption.mn, -1);
        } else if (GameSrc.gI().mapID == var0) {
            GameSrc.gI().showMessage(Caption.mo, -2560);
        } else {
            GameSrc.gI().aR = new LangLa_eo(var0, var1, var2);
        }
    }

    

    public static final class SessionState implements MultiSession.State {
        List<List<LangLa_ek>> week;
        long checkedSecond = Long.MIN_VALUE;
        LangLa_ek active;

        public void initialize() {
            List<List<LangLa_ek>> defaults = emptyWeek();
            for (int day = 0; day < 7; day++) {
                List<LangLa_ek> slots = defaults.get(day);
                for (int hour : new int[]{9, 10, 11, 14, 19, 21}) {
                    slots.add(new LangLa_ek(day, Caption.sT[1], hour * 3600, (hour + 1) * 3600, 57, -1));
                }
                for (int hour : new int[]{6, 9, 12, 15, 18}) {
                    slots.add(new LangLa_ek(day, Caption.sT[2], hour * 3600 + 3000, (hour + 1) * 3600, -1, 99));
                }
                slots.add(new LangLa_ek(day, "Hỏi đáp nhận thưởng", 66600, 70200, -1, 71));
                slots.add(new LangLa_ek(day, "Chiếm map 58", 71400, 72300, -1, 99));
                if (day == 0 || day == 2 || day == 4) {
                    slots.add(new LangLa_ek(day, Caption.sT[3], 73200, 73800, -1, 32));
                    slots.add(new LangLa_ek(day, Caption.sT[7], 77400, 78000, -1, 105));
                    slots.add(new LangLa_ek(day, "Chiến trường", 72000, 72600, -1, 99));
                } else if (day == 6) {
                    slots.add(new LangLa_ek(day, "Chiến trường", 72000, 72600, -1, 99));
                    slots.add(new LangLa_ek(day, "Gia tộc chiến", 72000, 75600, 85, 32));
                } else {
                    slots.add(new LangLa_ek(day, Caption.sT[4], 72000, 72600, -1, 32));
                }
            }
            setWeek(defaults);
        }

        private void setWeek(List<List<LangLa_ek>> schedule) {
            for (List<LangLa_ek> slots : schedule) Collections.sort(slots, LangLa_ek.$state_LangLa_ek().h);
            week = schedule;
            checkedSecond = Long.MIN_VALUE;
            active = null;
        }
    }

    private static final int $SESSION_STATE_ID = MultiSession.register("beatdz.LangLa_cd");
    public static SessionState $state_LangLa_cd() { return MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
