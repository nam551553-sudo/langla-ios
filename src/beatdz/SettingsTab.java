package beatdz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Input.Keys;
import com.tgame.model.Caption;
import java.util.Vector;

public class SettingsTab extends LangLa_fo {

    private LangLa_ce[][] s;
    private LangLa_cg[] t;
    private LangLa_cg[] u;
    private LangLa_cg[] v;
    
    private LangLa_cl[][] x;
    private LangLa_kc[] y;
    private int z;
    private int A;
    private LangLa_lf B;
    public byte[] a;
    private String[][] C = new String[3][];
    
    public short b = -1;
    
    
    
    
    
    
    
    
    private LangLa_ce E;
    private LangLa_ce F;
    private LangLa_ce G;
    private LangLa_ce H;
    private LangLa_ce I;
    private LangLa_cl J;
    private LangLa_cl K;
    private LangLa_cl L;
    private LangLa_kc M;
    private LangLa_kc N;
    
    public int k;
    public int l;
    private LangLa_ii O;
    private LangLa_ii[] P;
    private LangLa_dz[] Q;
    public mTextBox m;
    private short[] R;
    private LangLa_dz S;
    
    public boolean autoTrain;
    private boolean initialized;
    private LangLa_kc zoomKC;
    private LangLa_cl[] zoomRadios;

    public void synchronizeZoomSelection() {
        if (zoomKC == null || zoomRadios == null) return;
        zoomKC.b = Math.max(1, Math.min(4, mConfig.gI().readByte(25))) - 1;
        for (int i = 0; i < zoomRadios.length; i++) zoomRadios[i].a = i == zoomKC.b;
    }
    

    public SettingsTab() {
        try {
            beatdz.SettingsTab.$state_SettingsTab().D = this;
            this.A();
            this.p = GameSrc.gI();
            this.a(260, 250);
            this.r = false;
            this.z = 16;
            this.A = this.a_() + 9 + 25;
            this.l = 20;
            String[] var1;
            int var2;
            if (Gdx.app.getType() == ApplicationType.Desktop) {
                var1 = Caption.rN;
            } else {
                var1 = new String[Caption.rN.length - 1];

                for (var2 = 0; var2 < var1.length; ++var2) {
                    var1[var2] = Caption.rN[var2];
                }
            }

            this.B = new LangLa_lf(new LangLa_kd(2000, var1), 5, this.a_(), super.width - 8, 23, 60, this);
            this.s = new LangLa_ce[5][];
            this.x = new LangLa_cl[3][];
            this.y = new LangLa_kc[3];
            this.s[0] = new LangLa_ce[Caption.rL.length];

            int var5;
            for (var2 = 0; var2 < this.s[0].length; ++var2) {
                var5 = var2;
                if (var2 <= 1) {
                    var5 = var2 + 1;
                }

                if (var2 == 4) {
                    var5 = var2 - 1;
                    this.s[0][var2] = this.a(129, this.A + var5 * this.l, Caption.rL[var2], this, 300 + var2);
                } else if (var2 == 8) {
                    this.s[0][var2] = this.a(129, this.A + 4 * this.l, Caption.rL[var2], this, 300 + var2);
                } else if (var2 == 9) {
                    this.s[0][var2] = this.a(129, this.A + 5 * this.l, Caption.rL[var2], this, 300 + var2);
                } else if (var2 == 10) {
                    this.s[0][var2] = this.a(129, this.A + 0 * this.l, Caption.rL[var2], this, 300 + var2);
                } else {
                    if (var2 > 4) {
                        var5 = var2 - 1;
                    }

                    this.s[0][var2] = this.a(this.z, this.A + var5 * this.l, Caption.rL[var2], this, 300 + var2);
                }

                this.B.a((LangLa_cs) this.s[0][var2], 0);
            }
            this.s[3] = new LangLa_ce[beatdz.SettingsTab.$state_SettingsTab().arrayAuto.length];
            for (int i = 0; i < beatdz.SettingsTab.$state_SettingsTab().arrayAuto.length; i++) {
                int optionId = AutoOptions.idAt(i);
                this.s[3][i] = this.a(this.z, this.A + i * this.l,
                    beatdz.SettingsTab.$state_SettingsTab().arrayAuto[i], this, 2907 + optionId);
                this.s[3][i].v = beatdz.SettingsTab.$state_SettingsTab().arrayAuto[i].contains("Auto");
                this.B.a((LangLa_cs) this.s[3][i], 3);
            }

            LangLa_ce var10000 = this.s[0][2];
            boolean var6 = true;
            var10000.v = var6;
            var10000 = this.s[0][7];
            var6 = Char.gI().rank < 5;
            var6 = false;
            var10000.v = var6;
            var10000 = this.s[0][9];
            var6 = Char.gI().rank <= 0;
            var6 = false;
            var10000.v = var6;
            this.s[1] = new LangLa_ce[Caption.sb.length];

            for (var2 = 0; var2 < this.s[1].length; ++var2) {
                this.s[1][var2] = this.a(this.z + (var2 > 0 ? 25 : 0), this.A + var2 * this.l, Caption.sb[var2], this, 201 + var2);
                boolean var10001;
                if (var2 == 0) {
                    var10000 = this.s[1][var2];
                    var10001 = this.t();
                } else {
                    var10000 = this.s[1][var2];
                    var10001 = this.a[20 + var2] == 0;
                }

                var6 = var10001;
                var10000.a = var6;
                this.B.a((LangLa_cs) this.s[1][var2], 1);
            }

            (beatdz.SettingsTab.$state_SettingsTab().w = new LangLa_kd[7])[0] = new LangLa_kd(400, new String[]{"5%", "10%", "15%", "20%", "25%", "30%", "35%", "40%", "45%", "50%", "55%", "60%", "65%", "70%", "75%", "80%", "85%", "90%", "95%"});
            beatdz.SettingsTab.$state_SettingsTab().w[1] = new LangLa_kd(401, new String[]{"5%", "10%", "15%", "20%", "25%", "30%", "35%", "40%", "45%", "50%", "55%", "60%", "65%", "70%", "75%", "80%", "85%", "90%", "95%"});
            beatdz.SettingsTab.$state_SettingsTab().w[2] = new LangLa_kd(402, Caption.sZ);
            beatdz.SettingsTab.$state_SettingsTab().w[3] = new LangLa_kd(403, Caption.sY);
            beatdz.SettingsTab.$state_SettingsTab().w[4] = new LangLa_kd(404, Caption.sY);
            beatdz.SettingsTab.$state_SettingsTab().w[5] = new LangLa_kd(405, Caption.tb);
            beatdz.SettingsTab.$state_SettingsTab().w[6] = new LangLa_kd(406, Caption.te);
            this.t = new LangLa_cg[beatdz.SettingsTab.$state_SettingsTab().w.length];

            for (var5 = 0; var5 < this.t.length; ++var5) {
                if (var5 == 0) {
                    this.t[var5] = this.a(super.width - 8 - 180, this.A + var5 * this.l - 1 + this.l, 55, 5, beatdz.SettingsTab.$state_SettingsTab().w[var5], this, 0);
                } else if (var5 == 1) {
                    this.t[var5] = this.a(super.width - 8 - 63, this.A - 1, 55, 5, beatdz.SettingsTab.$state_SettingsTab().w[var5], this, 0);
                    this.t[var5].setXY(super.width - 8 - 180, this.A + this.l - 1 + this.l);
                } else if (var5 == 2) {
                    this.t[var5] = this.a(super.width - 8 - 180, this.A + var5 * this.l - 1 - 2 * this.l, 55, 5, beatdz.SettingsTab.$state_SettingsTab().w[var5], this, 0);
                } else if (var5 == 3) {
                    this.t[var5] = this.a(129, this.A - 1 + this.l, 125, 5, beatdz.SettingsTab.$state_SettingsTab().w[var5], this, 0);
                } else if (var5 == 4) {
                    this.t[var5] = this.a(129, this.A + this.l - 1 + this.l, 125, 5, beatdz.SettingsTab.$state_SettingsTab().w[var5], this, 0);
                } else if (var5 == 5) {
                    this.t[var5] = this.a(129, 181, 125, 5, beatdz.SettingsTab.$state_SettingsTab().w[var5], this, 1);
                } else if (var5 == 6) {
                    this.t[var5] = this.a(190, 181 - this.l, 64, 5, beatdz.SettingsTab.$state_SettingsTab().w[var5], this, 1);
                }

                this.B.a((LangLa_cs) this.t[var5], 0);
            }

            this.u = new LangLa_cg[1];
            LangLa_kd var7 = new LangLa_kd(500, Caption.td);
            this.u[0] = this.a(super.width - 8 - 145, this.A + this.l - 2, 123, 5, var7, this, 0);
            this.u[0].a(this.a[30] > 0 ? this.a[30] : 0);
            this.B.a((LangLa_cs) this.u[0], 1);
            this.E = this.a(this.z, this.A, Caption.bM, 1001);
            var10000 = this.E;
            var6 = mConfig.gI().readBoolean(1);
            var10000.a = var6;
            this.B.a((LangLa_cs) this.E, 2);
            this.F = this.a(this.z, this.A + 20, Caption.bN, 1002);
            var10000 = this.F;
            var6 = mConfig.gI().readBoolean(0);
            var10000.a = var6;
            this.B.a((LangLa_cs) this.F, 2);
            this.H = this.a(130, this.A, Caption.ca, 1004);
            var10000 = this.H;
            var6 = mConfig.gI().readBoolean(11);
            var10000.a = var6;
            this.B.a((LangLa_cs) this.H, 2);
            var5 = this.p instanceof GameSrc ? 20 : 0;
            this.M = new LangLa_kc(1000, mConfig.gI().readByte(9));
            this.J = this.a(this.z, this.A + 45 + var5, Caption.bX, this, this.M);
            this.B.a((LangLa_cs) this.J, 2);
            this.J = this.a(this.z, this.A + 70 + var5, Caption.bY, this, this.M);
            this.B.a((LangLa_cs) this.J, 2);
            if (Gdx.app.getType() == ApplicationType.Desktop) {
                this.J = this.a(this.z, this.A + 95 + var5, Caption.oa, this, this.M);
                this.B.a((LangLa_cs) this.J, 2);
            }

            if (this.p instanceof GameSrc) {
                this.G = this.a(130, this.A + 20, Caption.bZ, 1003);
                var10000 = this.G;
                var6 = mConfig.gI().readBoolean(10);
                var10000.a = var6;
                this.B.a((LangLa_cs) this.G, 2);
                this.v = new LangLa_cg[1];
                if (Gdx.app.getType() == ApplicationType.Desktop) {
                    this.I = this.a(this.z, this.A + 40, Caption.oo, 1006);
                    var10000 = this.I;
                    var6 = mConfig.gI().readBoolean(18);
                    var10000.a = var6;
                    this.B.a((LangLa_cs) this.I, 2);
                    this.A += 20;
                    this.N = new LangLa_kc(1005, mConfig.gI().readBoolean(12) ? 1 : 0);
                    this.K = this.a(130, this.A + 45, Caption.kX, this, this.N);
                    this.B.a((LangLa_cs) this.K, 2);
                    this.L = this.a(130, this.A + 70, Caption.kY, this, this.N);
                    this.B.a((LangLa_cs) this.L, 2);
                    var7 = new LangLa_kd(600, Caption.tp);
                    this.v[0] = this.a(130, this.A + 20, 115, 5, var7, this, 0);
                    this.v[0].a(mConfig.gI().readByte(19) > 0 ? mConfig.gI().readByte(19) : 0);
                    this.B.a((LangLa_cs) this.v[0], 2);
                    this.v[0].b(!this.I.a);
                } else {
                    this.A += 20;
                    this.N = new LangLa_kc(1005, mConfig.gI().readBoolean(12) ? 1 : 0);
                    this.K = this.a(130, this.A + 45, Caption.kX, this, this.N);
                    this.B.a((LangLa_cs) this.K, 2);
                    this.L = this.a(130, this.A + 70, Caption.kY, this, this.N);
                    this.B.a((LangLa_cs) this.L, 2);
                    var7 = new LangLa_kd(700, Caption.tE);
                    this.v[0] = this.a(this.z, this.A + 20, 115, Caption.tE.length, var7, this, 0);
                    this.v[0].a(mConfig.gI().readByte(18) > 0 ? mConfig.gI().readByte(18) : 0);
                    this.B.a((LangLa_cs) this.v[0], 2);
                }
            }

            int currentZoom = mConfig.gI().readByte(25);
            if (currentZoom < 1 || currentZoom > 4) currentZoom = 2;
            this.zoomKC = new LangLa_kc(1007, currentZoom - 1);
            this.zoomRadios = new LangLa_cl[4];
            for (int zoomOption = 0; zoomOption < this.zoomRadios.length; zoomOption++) {
                int zoomX = zoomOption % 2 == 0 ? 130 : 194;
                int zoomY = this.A + 100 + (zoomOption / 2) * 20;
                this.zoomRadios[zoomOption] = this.a(zoomX, zoomY, "Zoom " + (zoomOption + 1), this, this.zoomKC);
                this.B.a((LangLa_cs) this.zoomRadios[zoomOption], 2);
            }
            LangLa_kc fpsChoice = new LangLa_kc(1008, FrameRate.selection());
            for (int option = 0; option < 3; option++) {
                this.B.a((LangLa_cs) this.a(16 + option * 78, this.A + 145,
                        FrameRate.label(option), this, fpsChoice), 2);
            }

            if (Gdx.app.getType() == ApplicationType.Desktop) {
                this.l = 24;
                this.m = this.a(-200, -200, 100, "", this, 1083, 0);
                byte var8 = 1;
                this.m.a = var8;
                this.m.b(true);
                var6 = true;
                this.m.r = true;
                this.P = new LangLa_ii[Caption.ta.length];
                this.O = new LangLa_ii((byte) 1, 9, this.a_() + 30, this.width - 10, this.l * 5, this.l, Caption.ta.length);
                this.Q = new LangLa_dz[this.O.i];
                this.R = Binary.a();
                this.K();
                this.S = this.a(this.width / 2 - 30, this.height - 30, Caption.n, this, 5000, -8);
                this.B.a((LangLa_cs) this.S, 4);
            }

            this.initialized = true;
            this.e();
            this.B.a(beatdz.GameSrc.$state_GameSrc().bd);
        } catch (Exception var4) {
            Utlis.println(var4);
        }
    }

    private void K() {
        for (int var1 = 0; var1 < this.O.i; ++var1) {
            switch (this.R[var1]) {
                case 19:
                    this.Q[var1] = new LangLa_dz(this.width - 30 - 80, var1 * this.O.h, 0, 0, "", this, 1000, -19);
                    break;
                case 20:
                    this.Q[var1] = new LangLa_dz(this.width - 30 - 80, var1 * this.O.h, 0, 0, "", this, 1000, -20);
                    break;
                case 21:
                    this.Q[var1] = new LangLa_dz(this.width - 30 - 80, var1 * this.O.h, 0, 0, "", this, 1000, -21);
                    break;
                case 22:
                    this.Q[var1] = new LangLa_dz(this.width - 30 - 80, var1 * this.O.h, 0, 0, "", this, 1000, -22);
                    break;
                default:
                    this.Q[var1] = new LangLa_dz(this.width - 30 - 80, var1 * this.O.h, 0, 0, Keys.toString(this.R[var1]), this, 1000, -23);
            }

            this.Q[var1].setSize(30, this.l - 4);
            this.P[var1] = new LangLa_in((byte) 1, 0, 0, this.Q[var1].width, this.Q[var1].height, this.Q[var1].height, 1, this.O);
        }

    }

    public void e() {
        if (!initialized) return;
        LangLa_ce var10000;
        int var1;
        boolean var3;
        for (var1 = 0; var1 < this.s[0].length; ++var1) {
            if (var1 == 10) {
                var10000 = this.s[0][var1];
                var3 = this.a[40] != -1;
                var10000.a = var3;
            } else {
                var10000 = this.s[0][var1];
                var3 = this.a[var1] != -1;
                var10000.a = var3;
            }
        }

        for (var1 = 0; var1 < this.s[3].length; ++var1) {

            var10000 = this.s[3][var1];
            var3 = AutoOptions.enabled(this.a, AutoOptions.idAt(var1));
            var10000.a = var3;
        }

        for (var1 = 0; var1 < this.t.length; ++var1) {
            byte var2;
            if ((var2 = this.a[var1 + 10]) < 0) {
                var2 = 0;
            }

            this.t[var1].a(var2);
        }

        var10000 = this.s[1][0];
        var3 = this.t();
        var10000.a = var3;
    }

    public boolean f() {
        return this.autoTrain;
    }

    public void a(boolean var1) {
        GameSrc.gI().bZ = -1;
        this.autoTrain = var1;
        if (var1) {
            this.b = GameSrc.gI().mapID;
            beatdz.SettingsTab.$state_SettingsTab().c = GameSrc.gI().mapID;
            beatdz.SettingsTab.$state_SettingsTab().d = Char.gI().cx;
            beatdz.SettingsTab.$state_SettingsTab().e = Char.gI().cy;
            GameSrc.gI().n();
            this.z();
        } else {
            this.b = -1;
        }

        beatdz.SettingsTab.$state_SettingsTab().j = this.autoTrain;
        GameSrc.gI().vItemMapPickUp.clear();
    }

    public int g() {
        if (this.a[0] == -1) {
            return 0;
        } else {
            if (this.a[10] < 0 || this.a[10] >= beatdz.SettingsTab.$state_SettingsTab().w[0].c.length) {
                this.a[10] = 0;
            }

            return Integer.parseInt(beatdz.SettingsTab.$state_SettingsTab().w[0].c[this.a[10]].replaceAll("%", ""));
        }
    }

    public int j() {
        if (this.a[1] == -1) {
            return 0;
        } else {
            if (this.a[11] < 0 || this.a[11] >= beatdz.SettingsTab.$state_SettingsTab().w[1].c.length) {
                this.a[11] = 0;
            }

            return Integer.parseInt(beatdz.SettingsTab.$state_SettingsTab().w[1].c[this.a[11]].replaceAll("%", ""));
        }
    }

    public int k() {
        return this.a[7] == -1 ? 0 : this.a[15] + 1;
    }

    public int l() {
        if (!this.autoTrain) {
            return 0;
        } else {
            if (this.a[12] < 0 || this.a[12] >= beatdz.SettingsTab.$state_SettingsTab().w[2].c.length) {
                this.a[12] = 0;
            }

            return this.a[12] == beatdz.SettingsTab.$state_SettingsTab().w[2].c.length - 1 ? 100000 : Integer.parseInt(beatdz.SettingsTab.$state_SettingsTab().w[2].c[this.a[12]].replaceAll("%", ""));
        }
    }

    public boolean m() {
        return this.a[4] != -1;
    }

    public boolean n() {
        return this.a[5] != -1;
    }

    public int o() {
        return this.a[13] < 0 ? 0 : this.a[13];
    }

    public int q() {
        return this.a[14] < 0 ? 0 : this.a[14];
    }

    public int r() {
        return this.a[30] < 0 ? 0 : this.a[30];
    }

    public boolean t() {
        return this.a[17] >= 0;
    }

    public boolean u() {
        return this.a[21] >= 0;
    }

    public boolean v() {
        return this.a[22] >= 0;
    }

    public boolean w() {
        return this.a[23] >= 0;
    }

    public boolean x() {
        return this.a[24] >= 0;
    }

    public boolean y() {
        return this.a[25] >= 0;
    }

    public void z() {
        AutoOptions.disableRemoved(this.a);
        Binary.write("arr_auto_" + Char.gI().idEntity, this.a);
    }

    public void A() {
        this.a = Binary.read("arr_auto_" + Char.gI().idEntity);
        if (this.a == null || this.a.length < 1024) {
            this.a = new byte[1024];
            for (int var1 = 0; var1 < this.a.length; ++var1) {
                this.a[var1] = -1;
                if (var1 == 3 || var1 == 6) {
                    this.a[var1] = 0;
                }

                if (var1 != 10 && var1 != 11) {
                    if (var1 == 12) {
                        this.a[var1] = 3;
                    } else if (var1 == 15) {
                        this.a[var1] = 0;
                    } else if (var1 >= 10 && var1 <= 16) {
                        this.a[var1] = 0;
                    } else if (var1 == 17) {
                        this.a[var1] = 0;
                    } else if (var1 == 19) {
                        this.a[var1] = 0;
                    } else if (var1 >= 21 && var1 <= 25) {
                        this.a[var1] = 0;
                    } else if (var1 == 30) {
                        this.a[var1] = 0;
                    }
                } else {
                    this.a[var1] = 9;
                }
            }
        }
        if (AutoOptions.disableRemoved(this.a)) this.z();
    }

    public void a(LangLa_jz var1, int var2, int var3) {
        if (var1.b >= 4000 && var1.b < 5000) {
            var1.b -= 4000;
            this.m.a("");
            this.m.b(false);
            this.m.setXY((super.width - 8) / 2 - this.m.width / 2, DataCenter.gI().heightScreen - 122);
            Binary2.a(this.m, "", "", this.m.a, this.m.b);
            LangLa_dl var10000 = beatdz.Binary2.$state_Binary2().a;
            LangLa_eb var4 = new LangLa_eb(this, var1);
            var10000.b = var4;
        } else {
            switch (var1.b) {
                case 2000:
                    if (var1.j.k >= 0) {
                        this.B.a(var1.j.k);
                        return;
                    }
                    break;
                case 3000:
                    if (Char.gI().level() < 10) {
                        DataCenter.gI().currentScreen.b(Caption.cm, -2560);
                        return;
                    }

                    this.a(false);
                    beatdz.SettingsTab.$state_SettingsTab().f = true;
                    GameSrc.gI();
                    GameSrc.a(99);
                    this.J();
                    return;
                case 3001:
                    if (Char.gI().level() < 10) {
                        DataCenter.gI().currentScreen.b(Caption.cm, -2560);
                        return;
                    }

                    this.a(false);
                    beatdz.SettingsTab.$state_SettingsTab().g = true;
                    GameSrc.gI();
                    GameSrc.a(28);
                    this.J();
                    return;
                case 3002:
                    if (Char.gI().level() < 10) {
                        DataCenter.gI().currentScreen.b(Caption.cm, -2560);
                        return;
                    }

                    this.a(false);
                    beatdz.SettingsTab.$state_SettingsTab().h = true;
                    GameSrc.gI();
                    GameSrc.a(99);
                    this.J();
                    return;
                case 5000:
                    this.R = new short[]{45, 51, 33, 46, 48, 19, 20, 21, 22, 34};
                    this.K();
                    mInputProcessor.a(this.R);
                    this.L();
            }

        }
    }

    private void L() {
        Writer var1 = null;
        boolean var5 = false;

        label60:
        {
            try {
                var5 = true;
                (var1 = new Writer()).writeShort(this.R[0]);
                var1.writeShort(this.R[1]);
                var1.writeShort(this.R[2]);
                var1.writeShort(this.R[3]);
                var1.writeShort(this.R[4]);
                var1.writeShort(this.R[5]);
                var1.writeShort(this.R[6]);
                var1.writeShort(this.R[7]);
                var1.writeShort(this.R[8]);
                var1.writeShort(this.R[9]);
                Binary.write("arr_keys", var1.baos.toByteArray());
                Binary.a();
                var5 = false;
                break label60;
            } catch (Exception var6) {
                Utlis.println(var6);
                var5 = false;
            } finally {
                if (var5) {
                    if (var1 != null) {
                        var1.close();
                    }

                }
            }

            if (var1 != null) {
                var1.close();
                return;
            }

            return;
        }

        var1.close();
    }

    public static boolean autoEnabled(int id) {
        if (AutoOptions.removed(id)) return false;
        SettingsTab settings = $state_SettingsTab().D;
        if (settings == null) settings = gI();
        return AutoOptions.enabled(settings.a, id);
    }

    public static SettingsTab gI() {
        if (beatdz.SettingsTab.$state_SettingsTab().D == null) {
            beatdz.SettingsTab.$state_SettingsTab().D = new SettingsTab();
        }

        beatdz.SettingsTab.$state_SettingsTab().D.e();
        return beatdz.SettingsTab.$state_SettingsTab().D;
    }

    public static void a(SettingsTab var0) {
        beatdz.SettingsTab.$state_SettingsTab().D = var0;
    }

    public void a(int var1, Object var2, LangLa_cy var3) {
        try {
            if (var1 >= 2907) {
                int optionId = var1 - 2907;
                int row = AutoOptions.rowOf(optionId);
                if (row < 0) return;
                this.a[optionId + 100] = (byte) (this.s[3][row].a ? 0 : -1);
                this.z();
                DataCenter.gI().currentScreen.showMessage((this.s[3][row].a ? "Bật " : "Tắt ") + beatdz.SettingsTab.$state_SettingsTab().arrayAuto[row], -2560);
            } else if (var1 == 100) {
                try {
                    Message var7;
                    (var7 = new Message((byte) -15)).writeByte(this.y[2].a() == 0 ? 0 : this.y[2].a() + 1);
                    var7.send();
                } catch (Exception var4) {
                }

                this.J();
            } else {
                if (var1 == 200) {
                    LangLa_kc var6 = (LangLa_kc) var2;
                    this.a[16] = (byte) var6.b;
                } else if (var1 >= 201 && var1 < 300) {
                    var1 -= 201;
                    switch (var1) {
                        case 0:
                            this.a[17] = (byte) (this.s[1][0].a ? 0 : -1);
                            break;
                        default:
                            this.a[20 + var1] = (byte) (this.s[1][var1].a ? 0 : -1);
                            if (this.s[1][var1].a) {
                                this.a[30] = (byte) this.u[0].b.b;
                            }
                    }

                    GameSrc.gI().vItemMapPickUp.clear();
                } else if (var1 >= 300 && var1 < 400) {
                    var1 -= 300;
                    if (var1 == 10) {
                        this.a[40] = (byte) (this.s[0][var1].a ? 0 : -1);
                    } else {
                        this.a[var1] = (byte) (this.s[0][var1].a ? 0 : -1);
                    }

                    if (var1 == 2) {
                        this.a(this.s[0][var1].a);
                    }

                    if (var1 == 7 && this.s[0][var1].a) {
                        DataCenter.gI().currentScreen.showMessage(Caption.nY, -2560);
                    }

                    if (var1 == 9 && this.s[0][var1].a) {
                        DataCenter.gI().currentScreen.showMessage(Caption.nZ, -2560);
                    }

                    LangLa_ce var10000;
                    boolean var8;
                    if (var1 == 8 && this.s[0][var1].a) {
                        var10000 = this.s[0][5];
                        var8 = false;
                        var10000.a = var8;
                        this.a[5] = -1;
                    }

                    if (var1 == 5 && this.s[0][var1].a) {
                        var10000 = this.s[0][8];
                        var8 = false;
                        var10000.a = var8;
                        this.a[8] = -1;
                    }
                } else if (var1 >= 400 && var1 < 500) {
                    var1 -= 400;
                    this.a[var1 + 10] = (byte) this.t[var1].b.b;
                } else if (var1 >= 500 && var1 < 600) {
                    var1 -= 500;
                    this.a[var1 + 30] = (byte) this.u[var1].b.b;
                    GameSrc.gI().vItemMapPickUp.clear();
                } else if (var1 == 600) {
                    mConfig.gI().writeByte(19, this.v[0].b.b);
                } else if (var1 == 700) {
                    mConfig.gI().writeByte(18, this.v[0].b.b);
                    if (this.v[0].b.b == 2) {
                        this.J();
                    }

                    beatdz.SettingsTab.$state_SettingsTab().n = true;
                } else {
                    switch (var1) {
                        case 1000:
                            mConfig.gI().writeByte(9, this.M.b);
                            break;
                        case 1001:
                            LangLa_dp.a().b(this.E.a);
                            break;
                        case 1002:
                            LangLa_dp.a().a(this.F.a);
                            break;
                        case 1003:
                            mConfig.gI().writeBoolean(10, this.G.a);
                            break;
                        case 1004:
                            mConfig.gI().writeBoolean(11, this.H.a);
                            break;
                        case 1005:
                            mConfig.gI().writeBoolean(12, this.N.b == 1);
                            GameSrc.gI().X.d();
                            break;
                        case 1006:
                            if (Gdx.app.getType() == ApplicationType.Desktop) {
                                this.v[0].b(!this.I.a);
                            }

                            mConfig.gI().writeBoolean(18, this.I.a);
                            beatdz.SettingsTab.$state_SettingsTab().n = true;
                            break;
                        case 1007:
                            AppListener.gI().canvas.setZoom(((LangLa_kc)var2).b + 1);
                            break;
                        case 1008:
                            FrameRate.select(((LangLa_kc)var2).b);
                            break;
                    }
                }

                if (this.B.b.b == 0 || this.B.b.b == 1 || this.B.b.b == 3) {
                    this.z();
                }

            }
        } catch (Exception var5) {
            var5.printStackTrace();
        }
    }

    public void b(boolean var1) {
        this.a[17] = (byte) (var1 ? 0 : -1);
        this.z();
    }

    public boolean C() {
        if (GameSrc.gI().E()) {
            return false;
        } else {
            return this.autoTrain && this.a[40] == 0;
        }
    }

    public boolean D() {
        return this.a[8] == 0;
    }

    public void a(int var1, Object var2) {
    }

    public Vector c() {
        Vector var1;
        (var1 = super.c()).addElement(this.B.c());
        if (this.B.b.b == 4) {
            for (int var4 = 0; var4 < this.Q.length; ++var4) {
                int var2 = this.O.cx + this.Q[var4].cx;
                int var3 = this.O.cy + this.Q[var4].cy - this.O.f;
                if (Utlis.inRange(this.O.cx, this.O.cy, this.O.cx + this.O.width, this.O.cy + this.O.height, var2, var3) && Utlis.inRange(this.O.cx, this.O.cy, this.O.cx + this.O.width, this.O.cy + this.O.height, var2 + this.Q[var4].width, var3 + this.Q[var4].height)) {
                    this.P[var4].cx = (short) var2;
                    this.P[var4].cy = (short) var3;
                    var1.addElement(new LangLa_jz(4000 + var4, this.P[var4].cx, this.P[var4].cy, this.P[var4].cx + this.P[var4].width, this.P[var4].cy + this.P[var4].height, this.P[var4], this));
                }
            }

            var1.addElement(new LangLa_jz(1002, this.O.cx, this.O.cy, this.O.cx + this.O.width, this.O.cy + this.O.height, this.O, this));
        }

        return var1;
    }

    public void a(Graphics var1) {
        this.a(var1, this.cx, this.cy, this.width, this.height, Caption.bG, (byte) 2, this.r);
        this.B.a(var1);
        if (this.B.b.b == 0) {
            mFont.b(mFont.d, var1, Caption.rL[2], 16, 70, 0, -1, -16777216);
        } else if (this.B.b.b == 2) {
            int zoom = Math.max(1, Math.min(4, mConfig.gI().readByte(25)));
            mFont.b(mFont.d, var1, "Zoom: " + (50 + zoom * 25) + "%", 130, this.A + 88, 0, -1, -16777216);
            mFont.b(mFont.d, var1, "FPS thực tế: " + Gdx.graphics.getFramesPerSecond(), 16, this.A + 124, 0, -1, -16777216);
        } else {
            if (this.B.b.b == 4) {
                Graphics var2 = var1;
                SettingsTab var6 = this;
                this.a(var1, 30, this.a_() + 25, super.width - 8 - 60, this.height - 72, -22, 84, 5, 1, 1);
                this.a(var1, this.O);
                int var3 = var1.a;
                int var4 = var1.b;

                for (int var5 = 0; var5 < var6.O.i; ++var5) {
                    LangLa_ii var10002 = var6.O;
                    if (var10002.c(var5 * var10002.h)) {
                        mFont.b(mFont.d, var2, Caption.ta[var5], 50, var5 * var6.O.h + 10, 0, -1, -16777216);
                        var6.a(var2, var3 + var6.Q[var5].cx, var4 + var6.Q[var5].cy);
                        var6.Q[var5].a(var2);
                        var6.a(var2, var3, var4);
                    }
                }

                var6.b(var2);
                var6.O.b(var2, -57, -12);
            }

        }
    }

    public void b() {
        this.B.b();
        beatdz.GameSrc.$state_GameSrc().bd = this.B.b.b;
        if (this.O != null) {
            this.O.a();
        }

        if (GameSrc.gI().Task == 0 && GameSrc.gI().idStep == 1) {
            if (this.s[0][0].a && this.s[0][1].a) {
                DataCenter.gI().aO.a(this.cx + this.width - 5, this.cy + 5);
                DataCenter.gI().aO.a = true;
            } else {
                int var10001;
                if (this.B.b.b != 0) {
                    var10001 = this.cx + 60;
                    DataCenter.gI().aO.a(var10001, this.cy + 42);
                    DataCenter.gI().aO.a = true;
                } else {
                    if (this.k == 0) {
                        this.k = 1;
                    }

                    SettingsTab var1 = this;
                    int var2 = 0;

                    boolean var10000;
                    while (true) {
                        if (var2 >= var1.t.length) {
                            var10000 = false;
                            break;
                        }

                        if (var1.t[var2].j) {
                            var10000 = true;
                            break;
                        }

                        ++var2;
                    }

                    if (!var10000) {
                        if (!this.s[0][0].a) {
                            var10001 = this.cx + 23;
                            DataCenter.gI().aO.a(var10001, this.cy + 90);
                            DataCenter.gI().aO.a = true;
                        } else if (!this.s[0][1].a) {
                            var10001 = this.cx + 23;
                            DataCenter.gI().aO.a(var10001, this.cy + 110);
                            DataCenter.gI().aO.a = true;
                        }
                    }
                }
            }
        }

        LangLa_ce var4 = this.s[0][7];
        boolean var3 = Char.gI().rank < 5;
        var3 = false;
        var4.v = var3;
        var4 = this.s[0][9];
        var3 = Char.gI().rank <= 0;
        var3 = false;
        var4.v = var3;
        this.t[5].b(false);
        this.t[6].b(false);
    }

    public void d() {
        try {
            if (GameSrc.gI().B() != null && GameSrc.gI().B().id == 43) {
                GameSrc.gI();
                GameSrc.openFunc(92);
            }
        } catch (Exception var1) {
        }

        super.d();
    }

    public static void E() {
        beatdz.SettingsTab.$state_SettingsTab().h = false;
        beatdz.SettingsTab.$state_SettingsTab().g = false;
        beatdz.SettingsTab.$state_SettingsTab().f = false;
    }

    public void F() {
        LangLa_ce var10000 = this.E;
        boolean var2 = mConfig.gI().readBoolean(1);
        var10000.a = var2;
        var10000 = this.F;
        var2 = mConfig.gI().readBoolean(0);
        var10000.a = var2;
    }

    static short[] b(SettingsTab var0) {
        return var0.R;
    }

    static LangLa_dz[] c(SettingsTab var0) {
        return var0.Q;
    }

    static void d(SettingsTab var0) {
        var0.K();
    }

    static void e(SettingsTab var0) {
        var0.L();
    }

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public LangLa_kd[] w;
public SettingsTab D;
public int c;
public int zone;
public int d;
public int e;
public boolean f;
public boolean g;
public boolean h;
public boolean i;
public boolean j;
public boolean n;
public String[] arrayAuto;
public void initialize() {
this.c = -1;
this.zone = -1;
this.d = -1;
this.e = -1;
this.arrayAuto = new String[]{
        "Nhận phúc lợi",
        "Ưu tiên đánh tinh anh",
        "Ưu tiên đánh thủ lĩnh",
        "Hiện đường khẽ Người",
        "Hiện đường khẽ Vật Phẩm",
        "Hiện đường khẽ Npc"
    };
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.SettingsTab");
public static SessionState $state_SettingsTab() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
