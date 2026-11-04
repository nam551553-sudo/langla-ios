package beatdz;

import com.badlogic.gdx.Gdx;
import com.listener.SDKListener;
import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_x extends LangLa_fo {

    private boolean a;
    private LangLa_ii b;
    private LangLa_kd c;
    private int d;
    private String e;
    private mImage f;

    public LangLa_x(MainScreen var1, LangLa_kd var2, int var3) {
        this.p = var1;
        this.c = var2;
        this.d = var3;
        this.setXY(0, 0);
        this.setSize(220, DataCenter.gI().heightScreen);
        this.a(this.width, (byte) 1);
        this.a(this.width - 28, 8, "", this, 1102, 6).setXY(this.width - 28, 8);
        int var8;
        if ((var8 = var2.c.length) > 10) {
            var8 = 10;
        }

        int var9 = (this.height - 50) / var8;
        this.b = new LangLa_ii((byte) 1, 2, 50, this.width - 4, var8 * var9, var9, var8);
        this.cF = 2;
        this.e = Utlis.e(DataCenter.gI().VER2);
        if (var3 == 0) {
            var1 = null;

            try {
                // Bundle the current app logo; downloaded /4.png and old caches carry legacy branding.
                this.f = Binary.createImage(Gdx.files.internal("resource/icons/icon-128.png").readBytes());
                this.f = Binary2.b(this.f, 32 * DataCenter.gI().zoomLevel, 32 * DataCenter.gI().zoomLevel);
                return;
            } catch (Exception var6) {
            } finally {
                ;
            }

            if (var1 != null) {
                return;
            }
        }

    }

    public void a(int var1, Object var2, LangLa_cy var3) {
    }

    public void a(int var1, Object var2) {
    }

    public void a(Graphics var1) {
        LangLa_fq.a(var1, 643, 0, 0, 3, (this.width - 3) * DataCenter.gI().zoomLevel, (this.height - 3) * DataCenter.gI().zoomLevel, 30, 30, this.width - 3, 170, 20);
        boolean var2 = true;
        var2 = true;
        var2 = true;
        short var5 = this.height;
        short var4 = this.width;
        var2 = false;
        var2 = false;
        int var6 = var1.a;
        int var7 = var1.b;
        var1.a(0, 0);
        Binary2.a(var1, 646, 0, 0, 0, var4 - 20, (int) 20);
        Binary2.a(var1, 645, -360, var4 - 20, 20, 20, (int) (var5 - 20));
        LangLa_fq.a(var1, 644, -360, var4, 0, 24);
        this.a(var1, var6, var7);
        var1.c();
        if (this.d == 1) {
            LangLa_fq.a(var1, 92, 0, 37, 27, 3);
            LangLa_fq.a(var1, DataCenter.gI().DataIconChar[Char.gI().idChar].idIcon, 0, 37, 27, 3);
            mFont.a((mFont) mFont.e, (Graphics) var1, Caption.kR + Char.gI().username, 63, 10, 0, -2560, -10275328);
            mFont.a((mFont) mFont.e, (Graphics) var1, Caption.kS + Char.gI().name, 63, 25, 0, -2560, -10275328);
            long var9 = Char.gI().exp;

            int var10;
            for (var10 = 0; var10 < DataCenter.gI().exps.length && var9 >= DataCenter.gI().exps[var10]; ++var10) {
                var9 -= DataCenter.gI().exps[var10];
            }

            int var12 = 0;

            try {
                DataCenter.gI();
                var12 = (int) (var9 * 100L / DataCenter.gI().exps[var10]);
            } catch (Exception var8) {
                Utlis.println(var8);
            }

            mFont.a((mFont) mFont.e, (Graphics) var1, Caption.ef + var10 + " + " + var12 + "%", 63, 40, 0, -2560, -10275328);
        } else {
            var1.a(this.f, 15, 10);
            mFont.a((mFont) mFont.e, (Graphics) var1, Caption.a(), 52, 17, 0, -2560, -10275328);
            mFont.a((mFont) mFont.e, (Graphics) var1, Caption.kT + this.e, 52, 32, 0, -2560, -10275328);
        }

        this.a(var1, this.b);
        int var11 = var1.b;

        for (int var3 = 0; var3 < this.c.c.length; ++var3) {
            if (var3 == this.b.l) {
                mFont.a((mFont) mFont.f, (Graphics) var1, this.c.c[var3], this.width / 2 + 1, this.b.h / 2 + var3 * this.b.h + 1, 2, -1, -10275328);
            } else {
                mFont.a((mFont) mFont.f, (Graphics) var1, this.c.c[var3], this.width / 2, this.b.h / 2 + var3 * this.b.h, 2, -1, -10275328);
            }

            Binary2.a(var1, 5, 0, 13, 1 + var3 * this.b.h, this.b.width - 30, (int) 20);
            if (var3 == 1 && this.d == 1 && GameSrc.gI().at) {
                LangLa_fq.a(var1, 713, 0, this.width / 2 + 50, this.b.h / 2 + var3 * this.b.h - 2, 20);
            }

            int var10001;
            int var10002;
            if (this.c.d[var3] == 12 && GameSrc.gI().Task == 0 && GameSrc.gI().idStep == 1 && !this.O()) {
                var10001 = this.width / 2 + 20;
                var10002 = var11 + this.b.h / 2 + var3 * this.b.h;
                DataCenter.gI().aO.a(var10001, var10002 + 1);
                DataCenter.gI().aO.a = true;
            } else if (this.c.d[var3] == 10 && GameSrc.gI().Task == 14 && GameSrc.gI().idStep == 0 && !this.O()) {
                var10001 = this.width / 2 + 20;
                var10002 = var11 + this.b.h / 2 + var3 * this.b.h;
                DataCenter.gI().aO.a(var10001, var10002 + 1);
                DataCenter.gI().aO.a = true;
            }
        }

        this.b(var1);
    }

    public void b() {
        if (this.a && this.cM == null) {
            this.J();
        }

        this.b.a();
    }

    public Vector c() {
        Vector var1;
        (var1 = new Vector()).add(this.b.a(1100, this));
        var1.add(new LangLa_jz(1103, 15, 5, 58, 48, (LangLa_ii) null, this));
        var1.add(new LangLa_jz(1101, 0, 0, this.width, this.height, (LangLa_ii) null, this));
        var1.add(new LangLa_jz(1102, 0, 0, DataCenter.gI().widthScreen, DataCenter.gI().heightScreen, (LangLa_ii) null, this));
        return var1;
    }

    public void d() {
        if (this.f != null) {
            this.f.a();
        }

        super.d();
    }

    public void a(LangLa_jz var1, int var2, int var3) {
        if (this.cM == null) {
            switch (var1.b) {
                case 1100:
                    var2 = this.b.k;
                    boolean var6;
                    switch (this.c.d[var2]) {
                        case 0:
                            this.p.a((LangLa_cx) (new LangLa_bd(this.p)));
                            var6 = true;
                            break;
                        case 1:
                            this.p.a(Caption.bP, 2001, this);
                            var6 = true;
                            break;
                        case 2:
                            this.p.a((LangLa_cx) (new LangLa_w(this.p)));
                            var6 = true;
                            break;
                        case 3:
                            e();
                            var6 = true;
                            break;
                        case 4:
                            f();
                            var6 = true;
                            break;
                        case 5:
                            this.p.a(Caption.mc, 2003, this);
                            var6 = true;
                            break;
                        case 6:
                            this.p.a(Caption.iw, 2002, this);
                            var6 = true;
                            break;
                        case 7:
                            GameSrc.gI();
                            GameSrc.openFunc(72);
                            var6 = true;
                            break;
                        case 8:
                        default:
                            var6 = false;
                            break;
                        case 9:
                            this.p.a((LangLa_cx) (new LangLa_ca(GameSrc.gI())));
                            var6 = true;
                            break;
                        case 10:
                            GameSrc.gI();
                            GameSrc.openFunc(54);
                            var6 = true;
                            break;
                        case 11:
                            this.p.a((LangLa_cx) (new LangLa_i(this.p)));
                            var6 = true;
                            break;
                        case 12:
                            SettingsTab var5;
                            (var5 = SettingsTab.gI()).A();
                            var5.e();
                            var5.cS = 0;
                            var5.k = 0;
                            var5.a(var5.width, var5.height);
                            this.p.a((LangLa_cx) var5);
                            GameSrc.gI().vItemMapPickUp.clear();
                            var6 = true;
                            break;
                        case 13:
                            this.p.l(Caption.iv).cG.clear();
                            beatdz.CheckVersionScreen.$state_CheckVersionScreen().b = true;
                            AppListener.$state_AppListener().h = 50;
                            var6 = true;
                            break;
                        case 14:
                            this.p.a((LangLa_cx) (new LangLa_be(this.p)));
                            var6 = true;
                            break;
                        case 15:
                            if (AppListener.gI().listener != null) {
                                SDKListener var10000 = AppListener.gI().listener;
                            }

                            var6 = true;
                            break;
                        case 16:
                            this.p.a(new ReleaseNotesDialog(this.p));
                            var6 = true;
                            break;
                        case 17:
                            this.p.l("Mob-By Krin");
                            var6 = true;
                            break;
                        case 18:
//                            this.p.a("Nếu bạn không tìm thấy Server muốn chơi trong phiên bản, hãy liên hệ Tác Giả để thêm Server vào phiên bản nhé.", 2004, this);
                            Gdx.net.openURI("https://langlabue.com/");
                            var6 = false;
                            break;

                    }

                    if (var6) {
                        this.J();
                        return;
                    }
                    break;
                case 1102:
                    this.a = true;
                    this.setXY(-this.width, 0);
                    this.a(-this.width / 2, (byte) 0);
                    LangLa_dp.a().m();
                    return;
                case 1103:
                    this.a = true;
                    this.setXY(-this.width, 0);
                    this.a(-this.width / 2, (byte) 0);
                    (new Message((byte) -95)).send();
                    GameSrc.gI().a((LangLa_cx) (new LangLa_kl(GameSrc.gI(), Char.gI(), GameSrc.gI().p)));
                    LangLa_dp.a().i();
                    return;
                case 2001:
                    Binary.deleteAll();
                    return;
                case 2002:
                    AppListener.gI();
                    AppListener.exit();
                    return;
                case 2003:
                    AppListener.gI();
                    AppListener.i();
                    ScreenLogin var4;
                    (var4 = LoginPCScreen.getScreenLogin()).k(1000);
                    DataCenter.gI().setScreen((MainScreen) var4);
                case 2004:
                    Gdx.net.openURI("https://langlabue.com/");
                    break;
            }

        }
    }

    private static void e() {

    }

    private static void f() {

    }
}
