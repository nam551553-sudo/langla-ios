package beatdz;

import beatdz.tab.LatHinh;
import beatdz.tab.VXMM;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Application.ApplicationType;
import com.tgame.model.Caption;
import java.util.Vector;

public class LoginPCScreen extends ScreenLogin {

    public LangLa_mh a;
    public mTextBox b;
    private LangLa_dz e;
    private LangLa_dz f;
    private int g;
    private int h;
    private int i = 0;
    private int j;
    private int k;
    private boolean l;
    private boolean m;
    public Vector c;
    private Vector n;
    
    private LangLa_ec o;
    private int p;
    private int q;
    private LangLa_dz r;
    private LangLa_dz s;
    private boolean t;
    private long u;
    

    public void onViewChanged(int width, int height) {
        int dx = width / 2 - this.g, dy = height / 2 - this.h;
        setSize(width, height);
        this.g += dx; this.h += dy; this.j += dx; this.k += dy;
        for (Object value : this.cG) {
            LangLa_cs control = (LangLa_cs)value;
            control.setXY(control.cx + (control.cx == AppListener.gI().o ? 0 : dx), control.cy + dy);
        }
        M();
    }

    private void drawLoginLogo(Graphics graphics) {
        if (beatdz.LoginPCScreen.$state_LoginPCScreen().loginLogo == null || beatdz.LoginPCScreen.$state_LoginPCScreen().loginLogo.b == null)
            beatdz.LoginPCScreen.$state_LoginPCScreen().loginLogo = Binary.createImage(Gdx.files.internal("resource/login-logo.png").readBytes());
        float scale = Math.min((float)Math.min(190, this.width - 32) / beatdz.LoginPCScreen.$state_LoginPCScreen().loginLogo.c,
            (float)Math.max(12, this.e.cy - 28) / beatdz.LoginPCScreen.$state_LoginPCScreen().loginLogo.d);
        graphics.a(beatdz.LoginPCScreen.$state_LoginPCScreen().loginLogo, 0, 0, beatdz.LoginPCScreen.$state_LoginPCScreen().loginLogo.c, beatdz.LoginPCScreen.$state_LoginPCScreen().loginLogo.d, 0,
            this.e.cx + this.e.width / 2, this.e.cy - 8,
            Math.round(beatdz.LoginPCScreen.$state_LoginPCScreen().loginLogo.c * scale * DataCenter.gI().zoomLevel),
            Math.round(beatdz.LoginPCScreen.$state_LoginPCScreen().loginLogo.d * scale * DataCenter.gI().zoomLevel), 33);
    }

    public static ScreenLogin getScreenLogin() {
        if (Session.gI().isConnected()) {
            Session.gI().close();
        }

        return gI();
    }

    public static ScreenLogin gI() {
        return (ScreenLogin) (Gdx.app.getType() == ApplicationType.Desktop ? new LoginPCScreen() : new LoginPCScreen());
    }

    public LoginPCScreen() {
        beatdz.LoginPCScreen.$state_LoginPCScreen().instance = this;
        this.o();
        this.g = this.width / 2;
        this.h = this.height / 2;
        this.j = this.g - 50;
        this.k = this.h - 25;
        this.a = new LangLa_mh(this, this.j, this.h - 27 + 25, 122, Caption.qR[1], this, -11, 0);
        this.a((LangLa_cs) this.a);
        byte var2 = 50;
        this.a.a = var2;
        this.b = this.a(this.j, this.h - 27 + 50, 122, Caption.qS[1], this, 1);
        var2 = 50;
        this.b.a = var2;
        this.o();
        if (this.c.size() > 0) {
            this.a(this.a.cx + this.a.width + 2, this.a.cy + 3, "", this, 1013, 12);
            String[] var1 = (String[]) ((String[]) this.c.lastElement());
            this.a(var1);
        }

        AppListener.$state_AppListener().m = beatdz.AutoPro.$state_AutoPro().tk;
        AppListener.$state_AppListener().n = beatdz.AutoPro.$state_AutoPro().mk;
        if (!Utlis.h(AppListener.$state_AppListener().m) && !Utlis.h(AppListener.$state_AppListener().n)) {
            this.a.a(AppListener.$state_AppListener().m);
            this.b.a(AppListener.$state_AppListener().n);
        }

        this.a(this.a.cx + this.a.width / 2 - 50, this.h - 25 + 100, Caption.P, this, 1001, 13);
        this.a(AppListener.gI().o, this.h, "", this, 1002, 59);
        this.e = this.a(this.j, this.h - 25 - 2, "", this, 1004, -10);
        this.e.setSize(this.e.width + 20, this.e.height);
        this.f = this.a(this.e.cx + this.e.width + 2, this.h - 25 + 1, "", this, 1004, 12);
        this.s = this.a(this.a.cx + 26, this.h - 25 + 75, /*Caption.ot*/ "Đăng ký", this, 2002, -17);
        this.n = new Vector();
        this.n();
// a(new LangLa_cd1(this,null));
  
      
    }

    private void a(String[] var1) {
        if (var1 == null) {
            this.a.a("");
            this.b.a("");
        } else {
            this.a.a(var1[0]);
            this.b.a(var1[1]);
        }
    }

    public static LoginPCScreen e() {
        return beatdz.LoginPCScreen.$state_LoginPCScreen().instance;
    }

    public void j() {
    }

    public void b() {
        super.b();
        if (this.q > 0) {
            --this.q;
            if (this.q == 0) {
                this.n();
            }
        }

        LoginPCScreen var1 = this;
        LangLa_dz var2;
        int var3;
        if (this.i == 1) {
            for (var3 = 0; var3 < var1.n.size(); ++var3) {
                if ((var2 = (LangLa_dz) var1.n.elementAt(var3)).v) {
                    var2.b(false);
                }

                if (var2.cy > var1.r.cy - (var3 + 1) * 22) {
                    var2.cy = (short) (var2.cy - 4 * (var3 + 1));
                } else {
                    var2.cy = (short) (var1.r.cy - (var3 + 1) * 22);
                    if (var3 == var1.n.size() - 1) {
                        var1.i = 2;
                    }
                }
            }
        } else if (this.i == -1) {
            for (var3 = 0; var3 < var1.n.size(); ++var3) {
                if ((var2 = (LangLa_dz) var1.n.elementAt(var3)).cy + 4 * (var3 + 1) < var1.r.cy) {
                    var2.cy = (short) (var2.cy + 4 * (var3 + 1));
                } else {
                    var2.cy = var1.r.cy;
                    var2.b(true);
                    if (var3 == var1.n.size() - 1) {
                        var1.i = -2;
                    }
                }
            }
        }

        LangLa_dz var10000 = this.e;
        String var5 = DataCenter.gI().aP.getName();
        var10000.a = var5;
        if (!this.m) {
            this.m = true;
            DataCenter.gI();
            DataCenter.i();
        }

        long var4 = System.currentTimeMillis();
        if (!DataCenter.gI().bc && !DataCenter.gI().INPUT_CAPTCHA) {
            if (this.o != null) {
                if (var4 - this.u > 5000L) {
                    this.u = var4;
                    Char.gI().name = this.o.c;
                    beatdz.DataCenter.$state_DataCenter().aR = 1;
                    beatdz.SettingsTab.$state_SettingsTab().c = this.o.d;
                    beatdz.SettingsTab.$state_SettingsTab().d = this.o.e;
                    beatdz.SettingsTab.$state_SettingsTab().e = this.o.f;
                    this.a.a(this.o.a);
                    this.b.a(this.o.b);
                    g();
                    this.k();
                    this.l(Caption.ps);
                    ++this.p;
                    if (this.p > 10) {
                        this.o = null;
                        return;
                    }
                }
            } else if (beatdz.DataCenter.$state_DataCenter().aR > 0) {
                if (var4 - this.u > 15000L) {
                    this.u = var4;
                    this.k();
                    return;
                }

                if (((var4 - this.u) / 1000L + 2L) % 5L == 0L) {
                    this.a(Caption.oU, (int) (16L - (var4 - this.u) / 1000L));
                }
            }
        }

    }

    public void p() {
    }

    public void a(Graphics var1) {
        if (AppListener.$state_AppListener().h > 0) {
            --AppListener.$state_AppListener().h;
            if (AppListener.$state_AppListener().h == 0) {
                DataCenter.gI().g();
                return;
            }
        }

        super.a(var1);
        drawLoginLogo(var1);
        // A newer client version must not hide the server selection on phones.
        this.e.b(false);
        this.f.b(false);
        mFont.b(mFont.d, var1, Caption.qS[2], this.a.cx - 10, this.k + mFont.a(mFont.e) / 2, 1, -6488, -16742145);

//        if (DataCenter.gI().aP != null) {
//            //     mFont.b(mFont.d, var1, "Bạn đang chọn Server Lậu", this.width / 2, this.h - 45, 2, -2560, -16742145);
//
//            if (DataCenter.gI().aP.array != null) {
//                mFont.b(mFont.d, var1, "[+] " + DataCenter.gI().aP.array.nameServers + " [+]", this.width / 2, this.h - 35, 2, -2560, -16742145);
//            }
//        }
            mFont.a(var1, "Làng Lá Test: 0.0.1", 8 + AppListener.gI().o, 8, 0, -1);
        mFont.a(var1, Caption.eQ + Utlis.e(DataCenter.gI().VER2), this.width - 8 - AppListener.gI().o, 8, 1, -1);
        mFont.b(mFont.d, var1, Caption.qR[0], this.a.cx - 10, this.k + mFont.a(mFont.e) / 2 + 25, 1, -6488, -16742145);
        mFont.b(mFont.d, var1, Caption.qS[0], this.a.cx - 10, this.k + 25 + mFont.a(mFont.e) / 2 + 25, 1, -6488, -16742145);
        if (this.i == 2) {
            for (int var2 = 0; var2 < this.n.size(); ++var2) {
                LangLa_dz var3;
                if ((var3 = (LangLa_dz) this.n.elementAt(var2)).a()) {
                    mFont.b(mFont.d, var1, Caption.rV[var2], var3.cx - 4, var3.cy + 9, 1, -1, -16777216);
                } else {
                    mFont.b(mFont.d, var1, Caption.rV[var2], var3.cx - 5, var3.cy + 8, 1, -1, -16777216);
                }
            }
        }

        if (beatdz.LangLa_cz.$state_LangLa_cz().cZ) {
            mFont.a(mFont.d, var1, Caption.qG, DataCenter.gI().widthScreen / 2, DataCenter.gI().heightScreen - 45, 2, -2560, 2, 1);
        }

        LangLa_dp.a().a(-1);

    }
    public int num = 0;

    public Vector c() {
        Vector var1;
        (var1 = super.c()).add(new LangLa_jz(2000, 0, 0, this.width, this.height, (LangLa_ii) null, this));
        return var1;
    }

    public void a(int var1, Object var2, LangLa_cy var3) {
        if (var1 != 1010) {
            this.i = -1;
        }

        switch (var1) {
            case 1001:
                this.t = false;
                g();
                this.k();
                return;
            case 1002:
                short[] var4;

                var4 = new short[]{0, 1, 2, (short) (Caption.sC.length - 2), (short) (Caption.sC.length - 1), 6, (short) (Caption.sC.length - 3)};

                String[] var5 = new String[var4.length];

                for (int var6 = 0; var6 < var5.length; ++var6) {
                    var5[var6] = Caption.sC[var4[var6]];
                }

                this.a((LangLa_cx) (new LangLa_x(this, new LangLa_kd(0, var4, var5), 0)));
                return;
            case 1004:
                this.a((LangLa_cx) (new LangLa_bp(DataCenter.gI().aP, this, 1005)));
                return;
            case 1005:
                if (Session.gI().isConnected()) {
                    DataCenter.gI().aI = true;
                    Session.gI().close();
                }

                DataCenter.gI().setServer((Server) var2);
                return;
            case 1006:
                this.a((LangLa_cx) (new LangLa_kg(this)));
                return;
            case 1007:
                this.a((LangLa_cx) (new LangLa_w(this)));
                return;
            case 1008:
                this.a((LangLa_cx) (new LangLa_bd(this)));
                return;
            case 1010:
                if (this.i > 0) {
                    this.i = -1;
                    return;
                }

                this.i = 1;
                return;
            case 1011:
                DataCenter.gI().currentScreen.a(Caption.bP, 2001, this);
                return;
            case 1012:
                this.a((LangLa_cx) (new LangLa_m(this)));
                return;
            case 1013:
                this.a((LangLa_cx) (new LangLa_mf(this.c, this, 1014)));
                return;
            case 1014:
                this.a((String[]) ((String[]) var2));
                return;
            case 2002:
                Gdx.net.openURI("https://langlaanhhung.vn/");
            default:
        }
    }

    public void a(int var1, Object var2) {
    }

    public void G() {
        this.a(Caption.iw, 2002, this);
    }

    public void a(LangLa_jz var1, int var2, int var3) {
        switch (var1.b) {
            case 2000:
                this.i = -1;
            default:
        }
    }

    private void n() {
        Reader reader = null;
        if (!DataCenter.gI().bc) {
            try {
                Reader a2 = Binary.createReader("arr_reset");
                if (a2 != null) {
                    LangLa_ec langLa_ec = new LangLa_ec(this, null);
                    langLa_ec.a = Utlis.decodeString(a2.readUTF());
                    langLa_ec.b = Utlis.decodeString(a2.readUTF());
                    langLa_ec.c = Utlis.decodeString(a2.readUTF());
                    langLa_ec.g = a2.readUTF();
                    langLa_ec.h = a2.dis.readShort();
                    langLa_ec.d = a2.dis.readInt();
                    langLa_ec.e = a2.dis.readInt();
                    langLa_ec.f = a2.dis.readInt();
                    short readShort = a2.dis.readShort();
                    this.t = true;
                    if (readShort == 0) {
                        Binary.delete("arr_reset.beatdz");
                        this.o = langLa_ec;
                        try {
                            if (a2.dis.readShort() > 0) {
                                Server server = new Server();
                                server.ip = langLa_ec.g;
                                server.port = langLa_ec.h;
                                server.name = a2.readUTF();
                                DataCenter.gI().setServer(server);
                                if (a2 != null) {
                                    a2.close();
                                    return;
                                }
                                return;
                            }
                        } catch (Exception e2) {
                        }
                        for (int i2 = 0; i2 < DataCenter.gI().arrayServers.length; i2++) {
                            try {
                                for (int i3 = 0; i3 < DataCenter.gI().arrayServers[i2].servers.length; i3++) {
                                    Server server2 = DataCenter.gI().arrayServers[i2].servers[i3];
                                    if (server2.ip.toLowerCase().equals(langLa_ec.g.toLowerCase()) && server2.port == langLa_ec.h) {
                                        DataCenter.gI().setServer(server2);
                                        if (a2 != null) {
                                            a2.close();
                                            return;
                                        }
                                        return;
                                    }
                                }
                            } catch (Exception e3) {
                            }
                        }
                    } else {
                        this.q = 20;
                    }
                }
                if (a2 != null) {
                    a2.close();
                }
            } catch (Exception e4) {
                Utlis.println(e4);
                if (0 != 0) {
                    reader.close();
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    reader.close();
                }
                throw th;
            }
        }
    }

    private void o() {
        this.c = new Vector();
        Reader var1 = null;

        try {
            if ((var1 = Binary.createReader("arr_acc")) != null) {
                short var2 = var1.dis.readShort();

                for (int var3 = 0; var3 < var2; ++var3) {
                    String[] var4;
                    (var4 = new String[2])[0] = Utlis.decodeString(var1.readUTF());
                    var4[1] = Utlis.decodeString(var1.readUTF());
                    this.c.add(var4);
                }
            }
        } catch (Exception var7) {
            Utlis.println(var7);
        } finally {
            if (var1 != null) {
                var1.close();
            }

        }

    }

    public void f() {
        String var1 = this.a.f().trim().toLowerCase();
        String var2 = this.b.f().trim();
        this.a(var1, var2, this.l);
    }

    public void a(String var1, String var2, boolean var3) {
        if (var3) {
            try {
                if (var1.length() > 0 && var2.length() > 0) {
                    var3 = false;

                    for (int var4 = 0; var4 < this.c.size(); ++var4) {
                        String[] var5;
                        if ((var5 = (String[]) ((String[]) this.c.elementAt(var4)))[0].equals(var1)) {
                            this.c.removeElementAt(var4);
                            var5[0] = var1;
                            var5[1] = var2;
                            this.c.addElement(var5);
                            var3 = true;
                            break;
                        }
                    }

                    if (!var3) {
                        this.c.addElement(new String[]{var1, var2});
                    }
                }
            } catch (Exception var6) {
                Utlis.println(var6);
            }

            this.q();
        }

    }

    private void q() {
        Writer var1 = null;
        boolean var6 = false;

        label76:
        {
            try {
                var6 = true;
                (var1 = new Writer()).writeShort(this.c.size());

                for (int var2 = 0; var2 < this.c.size(); ++var2) {
                    String[] var3 = (String[]) ((String[]) this.c.elementAt(var2));
                    var1.writeUTF(Utlis.encodeString(var3[0]));
                    var1.writeUTF(Utlis.encodeString(var3[1]));
                }

                var1.close("arr_acc");
                var6 = false;
                break label76;
            } catch (Exception var7) {
                Utlis.println(var7);
                var6 = false;
            } finally {
                if (var6) {
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

    public static void g() {
        try {
            Session.gI().close();
//            for (int var0 = 0; var0 < 10; ++var0) {
//                if (Session.gI().isConnected()) {
//                    Utlis.sleep(100L);
//                }
//            }
//
//            if (Session.gI().isConnected()) {
//                return;
//            }

            String var2;
            if ((var2 = beatdz.LoginPCScreen.$state_LoginPCScreen().instance.a.f()) == null || !var2.contains("@")) {
                DataCenter.gI().ipServer = DataCenter.gI().aP.ip;
                DataCenter.gI().portServer = DataCenter.gI().aP.port;
                return;
            }

            String[] var3;
            if ((var3 = var2.split("@"))[0] != null && Utlis.k(var3[0]).equals("112246a1a984f3f6a0d2239be249d085")) {
                Server var4;
                (var4 = new Server()).id = 100;
                var4.name = "Làng Lá";
                var4.ip = ClientConfig.SERVER_IP;
                var4.port = 2907;
                DataCenter.gI().aP = var4;
                DataCenter.gI().ipServer = var4.ip;
                DataCenter.gI().portServer = var4.port;
            }
        } catch (Exception var1) {
        }

    }

    public void k() {
        if (!Utlis.g()) {
            this.l(Caption.j);
        } else {
            beatdz.AutoPro.$state_AutoPro().tk = this.a.f();
            beatdz.AutoPro.$state_AutoPro().mk = this.b.f();
            this.L();
            this.l = true;
            (new Thread(new LangLa_kz(this))).start();
        }
    }

    public Message l() {
        Message var1 = null;

        try {
            (var1 = Message.c((byte) -127)).writeUTF(this.a.f());
            var1.writeUTF(this.b.f());
            if (DataCenter.gI().aP.typeServer == 5) {
                var1.writeUTF(DataCenter.gI().aP.arrayData[0]);
            }
            var1.writeInt(DataCenter.gI().VER1);
            var1.writeInt(DataCenter.gI().VER2);
            var1.writeBoolean(this.t);
        } catch (Exception var3) {
            Utlis.println(var3);
        }

        return var1;
    }

    public void a(String var1) {
        this.a.a(var1);
        Utlis.sleep(1000L);
        this.b.a("");
    }

    static LangLa_mh a(LoginPCScreen var0) {
        return var0.a;
    }

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public LoginPCScreen instance;
public mImage loginLogo;
public void initialize() {
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.LoginPCScreen");
public static SessionState $state_LoginPCScreen() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
