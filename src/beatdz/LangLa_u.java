package beatdz;

import com.tgame.model.Caption;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Vector;

public class LangLa_u extends LangLa_fn {

    private String[] g;
    
    
    private LangLa_im[] j;
    public LangLa_lu[] a;
    private LangLa_ij o;
    public int b;
    public int c;
    private int s;
    private int t = -1;
    private int u;
    private LangLa_cg v;
    public LangLa_jw d;
    public int e = -1;
    private LangLa_ii[] w;
    private LangLa_ii[] x;
    private Vector y;
    private boolean z;
    private LangLa_hz A;
    private int B;
    private Vector C = new Vector();
    private int[] D = new int[]{99, 100, 45, 21, 47, 97, 102, 32, 59, 98, 28, 93};
    private String[][] E;
    private LangLa_dz F;
    

    public LangLa_u(MainScreen var1) {
        super(var1);
        this.a(320, 235);
        this.r = false;
        beatdz.LangLa_u.$state_LangLa_u().f = this;
        if (DataCenter.gI().MapTemplate[GameSrc.gI().mapID].name.length() <= 13) {
            this.g = new String[]{DataCenter.gI().MapTemplate[GameSrc.gI().mapID].name};
        } else {
            this.g = mFont.a(DataCenter.gI().MapTemplate[GameSrc.gI().mapID].name, 2);
        }

        this.j = new LangLa_im[3];
        LangLa_kd var8;
        (var8 = new LangLa_kd(-1000)).c = Caption.qQ;
        this.a(var8, 255, 72, 4);
        this.a = new LangLa_lu[9];

        for (int var2 = 0; var2 < this.a.length; ++var2) {
            this.a[var2] = new LangLa_lu(0);
        }

        this.e();
        Vector var11 = new Vector();

        for (int var4 = 0; var4 < GameSrc.gI().vNpc.size(); ++var4) {
            Npc var3;
            String var5;
            if ((var3 = (Npc) GameSrc.gI().vNpc.get(var4)).getNpcTemplate().detail.length() > 0) {
                var5 = var3.f() + " (" + var3.getNpcTemplate().detail + ")";
            } else {
                var5 = var3.f();
            }

            if (!var5.isEmpty()) {
                var11.add(new LangLa_lk(var3.idd, var5));
            }
        }

        Collections.sort(var11, beatdz.LangLa_lk.$state_LangLa_lk().d);
        var11.insertElementAt(new LangLa_lk(-1, Caption.op), 0);
        short[] var13 = new short[var11.size()];
        String[] var14 = new String[var11.size()];
        StringBuilder var12 = new StringBuilder();

        for (int var6 = 0; var6 < var11.size(); ++var6) {
            var13[var6] = (short) ((LangLa_lk) var11.get(var6)).a;
            var12.append(var13[var6]).append(", ");
            var14[var6] = ((LangLa_lk) var11.get(var6)).b;
        }

        LangLa_kd var15 = new LangLa_kd(-2000, var13, var14);
        this.v = this.a(6, this.height - 47, 84, 7, var15, this, 1);
        var15.b = 0;
        this.a(this.v, 0);
        var8.b = -1;
        this.a(0);
        LangLa_dp var9;
        if (!(var9 = LangLa_dp.a()).a) {
            try {
                if (var9.b[6] != null) {
                    var9.b[6].play();
                }
            } catch (Exception var7) {
                Utlis.println(var7);
            }
        }

        this.y = new Vector();

        for (int var10 = 0; var10 < this.D.length; ++var10) {
            Vector var10000 = this.y;
            int var10003 = this.D[var10];
            Object[] var10005 = new Object[2];
            int var10009 = this.D[var10];
            var10005[0] = DataCenter.gI().NpcTemplate[var10009].name;
            var10009 = this.D[var10];
            var10005[1] = DataCenter.gI().NpcTemplate[var10009].detail;
            var10000.addElement(new LangLa_lk(var10003, String.format("%s (%s)", var10005)));
        }

        this.E = new String[this.D.length][];
        this.E[0] = Caption.tq;
        this.E[1] = Caption.tr;
        this.E[2] = Caption.ts;
        this.E[3] = Caption.tt;
        this.E[4] = Caption.tu;
        this.E[5] = Caption.tv;
        this.E[6] = Caption.tw;
        this.E[7] = Caption.tx;
        this.E[8] = Caption.ty;
        this.E[9] = Caption.tz;
        this.E[10] = Caption.tA;
        this.E[11] = Caption.tB;
        this.x = new LangLa_ii[3];
        this.x[0] = new LangLa_ii((byte) 1, 13, this.a_() + 9, super.width - 8 - 18, 189, 27, this.y.size());
        this.x[1] = new LangLa_ii((byte) 1, 13, this.a_() + 9, super.width - 8 - 18, 27, 27, 1);
        this.F = this.a(this.width - 75, this.height - 37, Caption.ma, this, 1011, -8);
        this.a(this.F, 3);
        this.g();
        (new Message((byte) -6)).send();
    }

    public void e() {
        this.o = new LangLa_ij((byte) 1, 9, this.a_() + 60, 80, 80, 26, Utlis.c(this.a.length, 3), 3);
        this.o.a(this.b / 3);
    }

    public void f() {
        this.e = 0;
        this.j[0] = null;
    }

    public void b() {
        super.b();
        this.o.a();
        if (this.v != null) {
            this.v.b(GameSrc.gI().E());
        }

        this.F.b(!this.z);
        int var1;
        if (this.x != null) {
            for (var1 = 0; var1 < this.x.length; ++var1) {
                if (this.x[var1] != null) {
                    this.x[var1].a();
                }
            }
        }

        if (this.j[this.k()] != null) {
            if (this.k() == 0 && Char.gI().P() && (this.cP == null || this.cP.b < 0)) {
                this.j[0].j = Char.gI().cx / GameSrc.gI().A - this.j[0].width / 2;
                this.j[0].s = Char.gI().cy / GameSrc.gI().A - this.j[0].height / 2;
            }

            this.j[this.k()].a();
        }

        if (this.s > 0) {
            --this.s;
            if (this.t >= 0 && this.s < 5) {
                GameSrc.gI().aR = new LangLa_eo(DataCenter.gI().E[this.t].a, 0, 0);
                this.t = -1;
            }

            if (this.s == 0) {
                this.J();
                SettingsTab.gI().a(false);
            }
        }

        for (var1 = 0; var1 < this.w.length; ++var1) {
            if (this.w[var1] != null) {
                this.w[var1].a();
            }
        }

        if (this.d != null) {
            this.d.p();
            if (this.d.r()) {
                this.d = null;
            }
        }

    }

    public void a(Graphics var1) {
        super.a(var1);
        int var2 = 0;
        int var3 = 0;
        int var4 = 0;
        int var5 = 0;
        int var7;
        if (this.e == 0) {
            this.e = -1;
            Binary.cleanImage(beatdz.LangLa_u.$state_LangLa_u().h);
            var7 = 1;
            int var8 = 1;
            if (!mConfig.gI().readBoolean(18)) {
                String var9;
                if ((beatdz.LangLa_u.$state_LangLa_u().h = Binary.createImage(var9 = "mapsmall_" + GameSrc.gI().mapID)) == null) {
                    LangLa_fb var10;
                    (var10 = new LangLa_fb()).g = new Hashtable();
                    var10.a = GameSrc.gI().mapID;
                    var10.d = "map/" + GameSrc.gI().mapID + ".png";
                    var10.e = var9;
                    beatdz.LangLa_cz.$state_LangLa_cz().cW.add(var10);
                    LangLa_cz.S();
                } else {
                    Binary.disposeImage(beatdz.LangLa_u.$state_LangLa_u().h);
                    var7 = LangLa_fq.a(beatdz.LangLa_u.$state_LangLa_u().h);
                    var8 = LangLa_fq.b(beatdz.LangLa_u.$state_LangLa_u().h);
                }
            }

            if (this.j[0] == null) {
                int var13 = super.width - 8 - 97;
                int var14 = this.G() - 36;
                int var11 = 95;
                int var12 = this.a_() + 19;
                if (var13 > var7) {
                    var11 = 95 + (var13 - var7) / 2;
                    var13 = var7;
                }

                if (var14 > var8) {
                    var12 += (var14 - var8) / 2;
                    var14 = var8;
                }

                this.j[0] = new LangLa_im((byte) 2, var11, var12, var13, var14, var7, var8);
                this.j[0].j = Char.gI().cx / GameSrc.gI().A - this.j[0].width / 2;
                this.j[0].s = Char.gI().cy / GameSrc.gI().A - this.j[0].height / 2;
            }
        } else if (this.e == 1) {
            this.e = -1;
            Binary.cleanImage(beatdz.LangLa_u.$state_LangLa_u().h);
            this.l();
        }

        if (this.k() < 2 && beatdz.LangLa_u.$state_LangLa_u().h != null) {
            this.a(var1, this.cx + this.j[this.k()].cx, this.cy + this.j[this.k()].cy);
            var2 = this.j[this.k()].f;
            var3 = this.j[this.k()].p;
            if (var2 < 0) {
                var2 = 0;
            }

            if (var3 < 0) {
                var3 = 0;
            }

            var4 = var2 + this.j[this.k()].width;
            var5 = var3 + this.j[this.k()].height;
            if (var4 > LangLa_fq.a(beatdz.LangLa_u.$state_LangLa_u().h)) {
                var2 = (var4 = LangLa_fq.a(beatdz.LangLa_u.$state_LangLa_u().h)) - this.j[this.k()].width;
            }

            if (var5 > LangLa_fq.b(beatdz.LangLa_u.$state_LangLa_u().h)) {
                var3 = (var5 = LangLa_fq.b(beatdz.LangLa_u.$state_LangLa_u().h)) - this.j[this.k()].height;
            }

            int var6 = (var4 - var2) * DataCenter.gI().zoomLevel;
            var7 = (var5 - var3) * DataCenter.gI().zoomLevel;
            if (this.j[this.k()].width * DataCenter.gI().zoomLevel > beatdz.LangLa_u.$state_LangLa_u().h.c) {
                var2 = 0;
                var6 = beatdz.LangLa_u.$state_LangLa_u().h.c;
            }

            if (this.j[this.k()].height * DataCenter.gI().zoomLevel > beatdz.LangLa_u.$state_LangLa_u().h.d) {
                var3 = 0;
                var7 = beatdz.LangLa_u.$state_LangLa_u().h.d;
            }

            var1.a(beatdz.LangLa_u.$state_LangLa_u().h, var2, var3, var6, var7, 0, 0, 0, 0);
            this.a(var1, this.cx, this.cy);
            this.a(var1, this.j[this.k()].cx - 3, this.j[this.k()].cy - 3, this.j[this.k()].width + 6, this.j[this.k()].height + 6, 0, 55, 56);
        }

        switch (this.k()) {
            case 0:
                this.a(var1, var2, var3, var4, var5);
                return;
            case 1:
                mFont.b(mFont.d, var1, Caption.nA, this.width / 2, this.height - 11, 2, -6488, -10275328);
                this.a(var1, this.j[this.k()]);
                this.b(var1, var2, var3, var4, var5);
                this.b(var1);
                return;
            case 2:
                this.e(var1);
                return;
            case 3:
                this.f(var1);
            default:
        }
    }

    private void a(Graphics var1, int var2, int var3, int var4, int var5) {
        mFont.b(mFont.e, var1, DataCenter.gI().MapTemplate[GameSrc.gI().mapID].name, this.j[this.k()].cx + this.j[this.k()].width / 2, this.j[this.k()].cy - 12, 2, -1118703, -10275328);
        var1.a(3, this.a_() + 30);
        if (!GameSrc.gI().E() || GameSrc.gI().mapID == 42 || GameSrc.gI().mapID == 43 || GameSrc.gI().mapID == 41 || GameSrc.gI().mapID == 49 || GameSrc.gI().mapID == 101) {
            mFont.b(mFont.d, var1, "XY: " + Char.gI().cx + ", " + Char.gI().cy, 8, -3, 0, -6488, -10275328);
            mFont.b(mFont.d, var1, Caption.hE + this.b + "/" + (this.a.length - 1), 8, 8, 0, -6488, -10275328);
            mFont.b(mFont.d, var1, Caption.ga + this.c, 8, 19, 0, -6488, -10275328);
            this.a(var1, this.o);
            var1.f(15190937);
            var1.c(0, 0, this.o.width - 1, this.o.i * this.o.h + 1);
            var3 = 0;

            for (var4 = 0; var4 < this.o.i; ++var4) {
                for (var5 = 0; var5 < this.o.r; ++var5) {
                    if (this.o.b(var4)) {
                        int var10003 = 1 + var5 * this.o.h;
                        int var10004 = 1 + var4 * this.o.h;
                        boolean var10 = var3 == this.o.k;
                        int var9 = var10004;
                        int var8 = var10003;
                        if (var3 == this.b) {
                            Binary2.a(var1, -7, 0, var8, var9, this.o.h - 2, (int) (this.o.h - 2));
                        }

                        var1.f(8798745);
                        var1.b(var8, var9, this.o.h - 2, this.o.h - 2);
                        if (var10) {
                            var1.f(-1);
                            var1.b(var8, var9, this.o.h - 2, this.o.h - 2);
                        }

                        LangLa_lu var23 = this.a[var3];
                        mFont.b(mFont.e, var1, "" + var3, var8 + this.o.h / 2, var9 + this.o.h / 2, 2, -7812062, -16777216);
                        if (var23.a() == 0) {
                            mFont.b(mFont.b, var1, "" + var23.a, var8 + this.o.h - 3, var9 + this.o.h - 5, 1, -1, -16777216);
                        } else if (var23.a() == 1) {
                            mFont.b(mFont.b, var1, "" + var23.a, var8 + this.o.h - 3, var9 + this.o.h - 5, 1, -2560, -16777216);
                        } else if (var23.a() == 2) {
                            mFont.b(mFont.e, var1, "" + var3, var8 + this.o.h / 2, var9 + this.o.h / 2, 2, -65536, -16777216);
                        }
                    }

                    ++var3;
                }
            }

            this.b(var1);
        }

        this.a(var1, this.b_(), this.c_());
        this.a(var1, this.j[this.k()]);
        this.u = -1;

        Npc var14;
        for (var5 = 0; var5 < GameSrc.gI().vNpc.size(); ++var5) {
            var2 = (var14 = (Npc) GameSrc.gI().vNpc.elementAt(var5)).cx / GameSrc.gI().A;
            var3 = var14.cy / GameSrc.gI().A;
            var1.f(-2560);
            var1.c(var2 - 2, var3 - 2, 4, 4);
        }

        Vector var16 = new Vector();

        int var6;
        LangLa_hb var11;
        for (var6 = 0; var6 < GameSrc.gI().vNpc.size(); ++var6) {
            if ((var14 = (Npc) GameSrc.gI().vNpc.elementAt(var6)).status == 0 || var14.idd == 95) {
                (var11 = new LangLa_hb()).c = var14.cx / GameSrc.gI().A;
                var11.d = var14.cy / GameSrc.gI().A;
                var11.b = var14.getNpcTemplate().name;
                var11.a = var14.idd;
                var11.e = mFont.b(mFont.b, var11.b);
                var11.f = mFont.a(mFont.b) - 1;
                var16.add(var11);
            }
        }

        Collections.sort(var16, beatdz.LangLa_hb.$state_LangLa_hb().g);

        for (var6 = 0; var6 < var16.size(); ++var6) {
            var11 = (LangLa_hb) var16.elementAt(var6);

            for (var4 = var6 + 1; var4 < var16.size() - 1; ++var4) {
                LangLa_hb var13 = (LangLa_hb) var16.elementAt(var4);
                if (var11.c - var11.e / 2 < var13.c + var13.e / 2 && var11.c + var11.e / 2 > var13.c - var13.e / 2 && var11.d < var13.d + var13.f && var11.f + var11.d > var13.d) {
                    var13.d = var11.d - 6;
                }
            }
        }

        for (var6 = 0; var6 < var16.size(); ++var6) {
            var11 = (LangLa_hb) var16.elementAt(var6);
            var4 = mFont.b(mFont.b, var11.b);
            if (var11.c - var4 / 2 < 3) {
                var11.c = 3 + var4 / 2;
            }

            if (var11.c + var4 / 2 + 3 > GameSrc.gI().maxX / GameSrc.gI().A) {
                var11.c = GameSrc.gI().maxX / GameSrc.gI().A - 3 - var4 / 2;
            }

            if (!beatdz.DataCenter.$state_DataCenter().ar && GameSrc.gI().getMapTemplate().type != 9) {
                mFont.a((mFont) mFont.b, (Graphics) var1, var11.b, var11.c, var11.d - 7, 2, -2560, -16777216);
            }
        }

        var1.f(-16647317);

        for (var4 = 0; var4 < GameSrc.gI().vMob.size(); ++var4) {
            Mob var20;
            if ((var20 = (Mob) GameSrc.gI().vMob.elementAt(var4)).isPaintMiniMap || var20.levelBoss > 0) {
                var2 = var20.p / GameSrc.gI().A;
                var3 = var20.q / GameSrc.gI().A;
                var1.c(var2 - 2, var3 - 2, 4, 4);
                mFont.a((mFont) mFont.b, (Graphics) var1, var20.getMobTemplate().name, var2, var3 - 7, 2, -16647317, -13553359);
            }
        }

        var1.c(-65536);

        int var7;
        for (var5 = 0; var5 < GameSrc.gI().vWayPoint.size(); ++var5) {
            WayPoint var17;
            short var12 = (var17 = (WayPoint) GameSrc.gI().vWayPoint.elementAt(var5)).cx;
            short var15 = var17.cy;
            XYEntity var21;
            if ((var21 = Char.c(var12, var15)) != null) {
                var12 = var21.cx;
                var15 = var21.cy;
            }

            if ((var7 = (var15 - 24) / GameSrc.gI().A) < 10) {
                Binary2.a(var1, 95, -270, (var12 - 20) / GameSrc.gI().A, 10, 40);
            } else if (var7 > (GameSrc.gI().maxY - 20) / GameSrc.gI().A) {
                GameSrc.gI();
                GameSrc.gI();
            } else if (var12 > GameSrc.gI().maxX / 2) {
                Binary2.a(var1, 95, 0, (var12 - 40) / GameSrc.gI().A, var7, 40);
            } else {
                Binary2.a(var1, 95, -360, (var12 - 20) / GameSrc.gI().A, var7, 40);
            }

            var2 = var12 / GameSrc.gI().A;
            if ((var3 = (var15 - 48) / GameSrc.gI().A) > GameSrc.gI().maxY / GameSrc.gI().A - 5) {
                var3 = GameSrc.gI().maxY / GameSrc.gI().A - 5;
            }

            String var19 = DataCenter.gI().MapTemplate[var17.mapNext].name;
            if (var2 - mFont.b(mFont.b, var19) / 2 < 5) {
                var2 = 5 + mFont.b(mFont.b, var19) / 2;
            }

            if (var2 > GameSrc.gI().maxX / GameSrc.gI().A - mFont.b(mFont.b, var19) / 2 - 5) {
                var2 = GameSrc.gI().maxX / GameSrc.gI().A - mFont.b(mFont.b, var19) / 2 - 5;
            }

            if (var3 < 12) {
                var3 += 12;
            }

            mFont.a((mFont) mFont.b, (Graphics) var1, var19, var2, var3, 2, -48128, -16777216);
        }

        var1.c();
        var1.f(-16711681);
        Char var18;
        if (GameSrc.gI().aI != null) {
            for (var7 = 0; var7 < GameSrc.gI().aI.a.size(); ++var7) {
                LangLa_ey var22 = (LangLa_ey) GameSrc.gI().aI.a.elementAt(var7);
                if ((var18 = GameSrc.gI().b(var22.a)) != null && !var18.name.equals(Char.gI().name)) {
                    var2 = var18.cx / GameSrc.gI().A;
                    var3 = var18.cy / GameSrc.gI().A;
                    var1.c(var2 - 2, var3 - 2, 4, 4);
                    mFont.b(mFont.b, var1, var18.name, var2, var3 - 7, 2, -16711681, -13553359);
                }
            }
        }

        var1.f(-3407617);

        for (var7 = 0; var7 < GameSrc.gI().vChar.size(); ++var7) {
            if ((var18 = (Char) GameSrc.gI().vChar.get(var7)) != null && GameSrc.gI().a(var18)) {
                var2 = var18.cx / GameSrc.gI().A;
                var3 = var18.cy / GameSrc.gI().A;
                var1.c(var2 - 2, var3 - 2, 4, 4);
                mFont.b(mFont.b, var1, var18.name, var2, var3 - 7, 2, -3407617, -13553359);
            }
        }

        var2 = Char.gI().cx / GameSrc.gI().A;
        var3 = Char.gI().cy / GameSrc.gI().A;
        if (DataCenter.gI().i % 30 < 10) {
            var1.f(-1);
        } else {
            var1.f(-14443265);
        }

        var1.c(var2 - 2, var3 - 2, 4, 4);
        if (this.d != null) {
            this.d.a(var1);
        }

        this.b(var1);
    }

    private void b(Graphics var1, int var2, int var3, int var4, int var5) {
        for (int var6 = 0; var6 < DataCenter.gI().E.length; ++var6) {
            if (DataCenter.gI().E[var6].a >= 0 && DataCenter.gI().E[var6].a < DataCenter.gI().MapTemplate.length) {
                var1.a(beatdz.LangLa_u.$state_LangLa_u().i, DataCenter.gI().E[var6].b - 2, DataCenter.gI().E[var6].c - 2);
            }

            if (DataCenter.gI().E[var6].a >= 0 && DataCenter.gI().E[var6].a < DataCenter.gI().MapTemplate.length && var2 - 50 <= DataCenter.gI().E[var6].b && DataCenter.gI().E[var6].b <= var4 + 50 && var3 - 14 <= DataCenter.gI().E[var6].c && DataCenter.gI().E[var6].c <= var5 + 14) {
                int var7 = DataCenter.gI().E[var6].b;
                String var8 = DataCenter.gI().MapTemplate[DataCenter.gI().E[var6].a].name;
                int var9;
                if ((var9 = b(DataCenter.gI().E[var6].a)) > 0) {
                    var8 = var8 + " (" + Caption.ag + var9 + ")";
                }

                if (var7 < 2 + mFont.b(mFont.d, var8) / 2) {
                    var7 = 2 + mFont.b(mFont.d, var8) / 2;
                }

                if (var7 > this.j[this.k()].width - mFont.b(mFont.d, var8) / 2 - 2) {
                    var7 = this.j[this.k()].width - mFont.b(mFont.d, var8) / 2 - 2;
                }

                if (var6 == this.t) {
                    mFont.b(mFont.d, var1, var8, var7, DataCenter.gI().E[var6].c - 1, 2, -2560, 0);
                } else if (DataCenter.gI().E[var6].a == GameSrc.gI().mapID && DataCenter.gI().i % 20 < 8) {
                    mFont.b(mFont.d, var1, var8, var7, DataCenter.gI().E[var6].c - 1, 2, -16711681, 0);
                }
            }
        }

    }

    private void e(Graphics var1) {
        Vector var2;
        (var2 = new Vector()).add(71);
        var2.add(72);
        var2.add(70);
        var2.add(87);
        var2.add(80);
        var2.add(78);
        var2.add(81);
        var2.add(79);
        var2.add(74);
        var2.add(88);
        var2.add(76);
        var2.add(73);
        this.a(var1, this.w[0]);

        int var3;
        LangLa_go var4;
        for (var3 = 0; var3 < GameSrc.gI().a.size(); ++var3) {
            var4 = (LangLa_go) GameSrc.gI().a.get(var3);
            mFont.c(mFont.b, var1, DataCenter.gI().MapTemplate[var4.b].name + Utlis.replaceAll(Caption.pP, "" + b(var4.b)) + Utlis.replaceAll(Caption.pN, "c#cyan" + var4.a + "c#yellow"), 9, 7 + var3 * 13, 0, -2560, -10275328);
            var2.remove(var4.b);
        }

        for (var3 = 0; var3 < var2.size(); ++var3) {
            mFont.c(mFont.b, var1, DataCenter.gI().MapTemplate[(Integer) var2.get(var3)].name + Utlis.replaceAll(Caption.pP, "" + b((Integer) var2.get(var3))) + Caption.pO, 9, 7 + GameSrc.gI().a.size() * 13 + var3 * 13, 0, -1, -10275328);
        }

        this.b(var1);
        this.w[0].b(var1, -5, -10);
        this.a(var1, 4 + (super.width - 8) - 90 - 3, this.a_() + 11, 92, this.G() - 27, -11, 22, 23, 1, 1);
        mFont.c(mFont.b, var1, Caption.pR, this.w[1].cx + this.w[1].width / 2, this.a_() + 18, 2, -1, -10275328);
        if (GameSrc.gI().b.size() > 0) {
            this.a(var1, this.w[1]);

            for (var3 = 0; var3 < GameSrc.gI().b.size(); ++var3) {
                var4 = (LangLa_go) GameSrc.gI().b.get(var3);
                mFont.c(mFont.b, var1, var4.a + Utlis.replaceAll(Caption.pQ, "" + var4.b), 3, 6 + var3 * 13, 0, -2560, -10275328);
            }

            this.b(var1);
            this.w[1].b(var1, -12, -10);
        }

        mFont.a((mFont) mFont.b, (Graphics) var1, Caption.dd, 4 + (super.width - 8) - 40, this.a_() + this.G() - 12, 0, -1, -10275328);
        var1.f(-1);
        var1.a(4 + (super.width - 8) - 40, this.a_() + this.G() - 12 + 4, 4 + (super.width - 8) - 40 + mFont.b(mFont.b, Caption.dd), this.a_() + this.G() - 12 + 4);
    }

    private void f(Graphics var1) {
        int var2;
        if (!this.z) {
            this.a(var1, this.x[0]);

            for (var2 = 0; var2 < this.x[0].i; ++var2) {
                if (this.x[0].b(var2)) {
                    this.a(var1, 0, var2 * this.x[0].h, this.x[0].width, 26, -17, 84, 5, 1, 1);
                    LangLa_fq.a(var1, 395, 0, 15, var2 * this.x[0].h + 13, 3);
                    if (this.x[0].l == var2) {
                        mFont.a(var1, ((LangLa_lk) this.y.get(var2)).b, 26, 13 + var2 * this.x[0].h, 0, -1);
                    } else {
                        mFont.a(var1, ((LangLa_lk) this.y.get(var2)).b, 26, 12 + var2 * this.x[0].h, 0, -1);
                    }
                }
            }

            this.b(var1);
            this.x[0].b(var1, -5, -10);
        } else {
            this.a(var1, this.x[1]);
            this.a(var1, 0, 0 * this.x[1].h, this.x[1].width, 26, -17, 84, 5, 1, 1);
            if (this.x[1].l == 0) {
                mFont.a(var1, ((LangLa_lk) this.y.get(this.B)).b, 26, 13, 0, -1);
                var1.e(30);
                LangLa_fq.a(var1, 398, 0, this.x[1].width - 21, 5, 20);
                var1.d();
            } else {
                mFont.a(var1, ((LangLa_lk) this.y.get(this.B)).b, 26, 12, 0, -1);
                LangLa_fq.a(var1, 398, 0, this.x[1].width - 22, 4, 20);
            }

            LangLa_fq.a(var1, 396, 0, 15, 13, 3);
            this.b(var1);
            this.a(var1, 12, this.a_() + 40, super.width - 8 - 16, this.G() - 78, 4, 55, 56);
            boolean var3 = true;
            var1.k = var3;

            for (var2 = 0; var2 < this.A.a.length; ++var2) {
                LangLa_fq.b(var1, this.A.a[var2].a, Utlis.a(this.A.a[var2].d), this.width / 2 + this.A.a[var2].b + 90, this.a_() + 130 + this.A.a[var2].c, 33);
            }

            var3 = false;
            var1.k = var3;
            this.a(var1, this.x[2]);

            for (var2 = 0; var2 < this.x[2].i; ++var2) {
                mFont.a(var1, "-  " + (String) this.C.get(var2), 7, 7 + var2 * this.x[2].h, 0, -1);
            }

            this.b(var1);
            this.x[2].b(var1, -12, -10);
        }
    }

    public Vector c() {
        Vector var1 = super.c();
        int var2;
        if (this.k() < 2) {
            if (this.k() == 0) {
                if (!GameSrc.gI().E() || GameSrc.gI().mapID == 49 || GameSrc.gI().mapID == 101) {
                    var1.addElement(this.o.a(5001, this));
                }
            } else if (this.k() == 1) {
                for (var2 = 0; var2 < DataCenter.gI().E.length; ++var2) {
                    if (DataCenter.gI().E[var2].a >= 0 && DataCenter.gI().E[var2].a < DataCenter.gI().MapTemplate.length) {
                        int var3 = DataCenter.gI().E[var2].b + this.j[this.k()].cx - 8;
                        int var4 = DataCenter.gI().E[var2].c + this.j[this.k()].cy - 8;
                        int var5 = var3 + 16;
                        int var6 = var4 + 16;
                        if (Utlis.inRange(var3, var4, var5, var6, 4, this.a_(), 4 + (super.width - 8), this.a_() + this.G())) {
                            if (var3 < 4) {
                                var3 = 4;
                            }

                            if (var4 < this.a_()) {
                                var4 = this.a_();
                            }

                            if (var5 > 4 + (super.width - 8)) {
                                var5 = 4 + (super.width - 8);
                            }

                            if (var6 > this.a_() + this.G()) {
                                var6 = this.a_() + this.G();
                            }

                            var1.addElement(new LangLa_jz(4000 + var2, var3, var4, var5, var6, this.j[this.k()], this));
                        }
                    }
                }
            }

            if (this.j[this.k()] != null) {
                var1.addElement(new LangLa_jz(-1001, this.j[this.k()].cx, this.j[this.k()].cy, this.j[this.k()].cx + this.j[this.k()].width, this.j[this.k()].cy + this.j[this.k()].height, this.j[this.k()], this));
            }
        } else if (this.k() == 2) {
            var1.addElement(new LangLa_jz(-2001, 4 + (super.width - 8) - 42, this.a_() + this.G() - 17, 4 + (super.width - 8) - 8, this.a_() + this.G() - 7, (LangLa_ii) null, this));

            for (var2 = 0; var2 < this.w.length; ++var2) {
                var1.addElement(this.w[var2].a(8880, this));
            }
        } else if (this.k() == 3) {
            if (!this.z) {
                var1.addElement(this.x[0].a(9980, this));
            } else {
                var1.addElement(this.x[1].a(9981, this));
                if (this.x[2] != null) {
                    var1.addElement(this.x[2].a(9982, this));
                }
            }
        }

        return var1;
    }

    public void a(LangLa_jz var1, int var2, int var3) {
        try {
            super.a(var1, var2, var3);
            if (DataCenter.gI().E != null && var1.b >= 4000 && var1.b < 4000 + DataCenter.gI().E.length) {
                int var12;
                if ((var12 = var1.b - 4000) == this.t) {
                    this.s = 12;
                }

                this.t = var12;
                Char.gI().l();
                GameSrc.gI().aR = null;
            } else {
                switch (var1.b) {
                    case -2001:
                        LangLa_dp.a().h();
                        this.cL = a(Caption.pS, this, 296, this.G(), 205);
                        return;
                    case -1001:
                        if (this.k() == 0) {
                            this.s = 12;
                            GameSrc.gI().aR = null;
                            Char.gI().l();
                            LangLa_im var11 = (LangLa_im) var1.j;
                            var2 = var2 - var1.j.cx + var11.f;
                            int var9 = var3 - var1.j.cy + var11.p;
                            this.d = new LangLa_jw(146, var2, var9, 1);
                            Char.gI().b(var2 * GameSrc.gI().A, var9 * GameSrc.gI().A);
                            return;
                        }
                        break;
                    case 1011:
                        if (Char.gI().idhe != 0) {
                            GameSrc.gI();
                            GameSrc.a(this.D[this.B]);
                            this.J();
                            return;
                        }

                        LangLa_jh.a().a(Caption.pM, mFont.d, -2560);
                        break;
                    case 5001:
                        if (var1.j.k >= 0) {
                            var2 = var1.j.k;
                            LangLa_u var7 = this;

                            try {
                                if (var2 != var7.b) {
                                    beatdz.GameSrc.$state_GameSrc().an = true;
                                    Message var8;
                                    (var8 = new Message((byte) -7)).writeByte(var2);
                                    var8.send();
                                }

                                return;
                            } catch (Exception var5) {
                                Utlis.println(var5);
                            }
                        }
                        break;
                    case 9980:
                        if (var1.j.k >= 0) {
                            this.B = var1.j.k;
                            String[] var4 = this.E[this.B];
                            this.C.clear();
                            if (var4 == null) {
                                this.x[2] = null;
                            } else {
                                for (var2 = 0; var2 < var4.length; ++var2) {
                                    this.C.addAll(mFont.a(mFont.d, var4[var2], super.width - 8 - 160));
                                }

                                this.x[2] = new LangLa_ii((byte) 1, 18, this.a_() + 48, super.width - 8 - 132, 105, 15, this.C.size());
                            }

                            Npc var10 = new Npc((byte) 0, this.D[this.B], 0, 0);
                            this.A = var10.getNpcTemplate().b[0];
                            this.z = true;
                            return;
                        }
                        break;
                    case 9981:
                        this.z = false;
                        return;
                }

            }
        } catch (Exception var6) {
        }
    }

    public void a(int var1, Object var2, LangLa_cy var3) {
        if (var1 == -2000 && this.v.b.b > 0) {
            GameSrc.gI();
            if (GameSrc.b(this.v.b.d[this.v.b.b])) {
                this.J();
                return;
            }

            GameSrc.gI().showMessage(Utlis.replaceAll(Caption.oT, this.v.b.c[this.v.b.b]), -1);
        }

    }

    public void a(int var1, Object var2) {
    }

    public void a(int var1) {
        if (this.k() == var1) {
            super.a(var1);
        } else {
            super.a(var1);
            switch (var1) {
                case 0:
                    this.e = 0;
                    return;
                case 1:
                    this.e = 1;
                default:
            }
        }
    }

    private void l() {
        int var1 = this.width;
        int var2 = this.height - this.G();

        try {
            beatdz.LangLa_u.$state_LangLa_u().h = Binary.createImage("mapmini_0");
            beatdz.LangLa_u.$state_LangLa_u().i = Binary.createImage("mapmini_1");
            Binary.disposeImage(beatdz.LangLa_u.$state_LangLa_u().h);
            var1 = LangLa_fq.a(beatdz.LangLa_u.$state_LangLa_u().h);
            var2 = LangLa_fq.b(beatdz.LangLa_u.$state_LangLa_u().h);
        } catch (Exception var4) {
        }

        if (this.j[1] == null) {
            this.j[1] = new LangLa_im((byte) 2, 10, this.a_() + 4, super.width - 8 - 12, this.G() - 22, var1, var2);
            this.j[1].j = var1 / 2;
            this.j[1].s = var2 / 2;

            for (var1 = 0; var1 < DataCenter.gI().E.length; ++var1) {
                if (DataCenter.gI().E[var1].a == GameSrc.gI().mapID) {
                    this.j[1].j = DataCenter.gI().E[var1].b - this.j[1].width / 2;
                    this.j[1].s = DataCenter.gI().E[var1].c - this.j[1].height / 2;
                    return;
                }
            }
        }

    }

    public void d() {
        if (beatdz.LangLa_u.$state_LangLa_u().h != null) {
            beatdz.LangLa_u.$state_LangLa_u().h.a();
            beatdz.LangLa_u.$state_LangLa_u().h = null;
        }

        if (beatdz.LangLa_u.$state_LangLa_u().i != null) {
            beatdz.LangLa_u.$state_LangLa_u().i.a();
            beatdz.LangLa_u.$state_LangLa_u().i = null;
        }

    }

    private static int b(int var0) {
        byte var1 = 0;
        switch (var0) {
            case 56:
                var1 = 46;
                break;
            case 57:
                var1 = 20;
            case 58:
            case 59:
            case 60:
            case 67:
            case 68:
            case 69:
            case 84:
            case 85:
            case 86:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
            case 102:
            default:
                break;
            case 61:
                var1 = 16;
                break;
            case 62:
                var1 = 10;
                break;
            case 63:
                var1 = 28;
                break;
            case 64:
                var1 = 22;
                break;
            case 65:
                var1 = 30;
                break;
            case 66:
                var1 = 14;
                break;
            case 70:
                var1 = 36;
                break;
            case 71:
                var1 = 32;
                break;
            case 72:
                var1 = 34;
                break;
            case 73:
                var1 = 60;
                break;
            case 74:
                var1 = 52;
                break;
            case 75:
                var1 = 1;
                break;
            case 76:
                var1 = 58;
                break;
            case 77:
                var1 = 24;
                break;
            case 78:
                var1 = 44;
                break;
            case 79:
                var1 = 50;
                break;
            case 80:
                var1 = 42;
                break;
            case 81:
                var1 = 48;
                break;
            case 82:
                var1 = 5;
                break;
            case 83:
                var1 = 9;
                break;
            case 87:
                var1 = 40;
                break;
            case 88:
                var1 = 56;
                break;
            case 103:
                var1 = 62;
                break;
            case 104:
                var1 = 66;
                break;
            case 105:
                var1 = 68;
                break;
            case 106:
                var1 = 70;
        }

        return var1;
    }

    public void g() {
        this.w = new LangLa_ii[2];
        this.w[0] = new LangLa_ii((byte) 1, 6, this.a_() + 9, super.width - 8 - 108, 182, 13, 12);
        this.w[1] = new LangLa_ii((byte) 1, 4 + (super.width - 8) - 90, this.a_() + 27, 85, 156, 13, GameSrc.gI().b.size());
    }

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public mImage h;
public mImage i;
public LangLa_u f;
public void initialize() {
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.LangLa_u");
public static SessionState $state_LangLa_u() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
