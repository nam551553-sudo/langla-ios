package beatdz;import beatdz.*;

import beatdz.DataCenter;
import com.tgame.model.Caption;
import java.util.Vector;

public abstract class MainScreen extends LangLa_cx {

    
    public Vector cD = new Vector();
    public LangLa_cx cE;

    public MainScreen() {
        this.cF = 0;
        this.setXY(0, 0);
        this.setSize(DataCenter.gI().widthScreen, DataCenter.gI().heightScreen);
        this.a((LangLa_cx) this);
    }

    public LangLa_cx H() {
        return this.cE;
    }

    public void a(LangLa_cx var1) {
        for (int var2 = 0; var2 < this.cG.size(); ++var2) {
            if (this.cG.get(var2) instanceof LangLa_dz) {
                LangLa_dz var3;
                (var3 = (LangLa_dz) this.cG.get(var2)).h = false;
                if (var3.cP != null) {
                    var3.cP.b = -1;
                }

                if (this.cG.get(var2) instanceof LangLa_ea) {
                    ((LangLa_ea) this.cG.get(var2)).s();
                }
            }
        }

        if (!this.cD.contains(var1)) {
            if (this.cE != null && this.cE.cF == 5) {
                ((LangLa_fl) this.cE).d();
                this.j(5);
            }

            if (var1.cF != 0) {
                this.j(var1.cF);
            }

            this.cD.addElement(var1);
            this.J();
        }
    }

    private void b(LangLa_cx var1) {
        this.cD.removeElement(var1);
        this.J();
    }

    public void a(mImage var1) {
        LangLa_ch var2;
        (var2 = new LangLa_ch(Caption.ah, this, 0)).f = var1;
        var2.cG.removeElementAt(var2.cG.size() - 1);
        var2.b(Caption.g, 10004);
        var2.c(Caption.ai, 10005);
        mTextBox var10000 = var2.a(74, 75, 50, "", 0);
        byte var3 = 4;
        var10000.a = var3;
        this.a((LangLa_cx) var2);
    }

    public void a(String var1, mImage var2, byte var3) {
        LangLa_lw var4;
        LangLa_lw var10000 = var4 = new LangLa_lw(Caption.ah, this, 0);
        byte var5 = var3;
        String var8 = var1;
        LangLa_lw var6 = var10000;
        var10000.f = var2;
        var6.k = var8;
        var6.j = var5;
        var6.cG.clear();
        var6.a(Caption.g, 190);
        var6.l = var6.a(var6.width / 2 - 25, 75, 50, "", 0);
        byte var7 = 4;
        var6.l.a = var7;
        this.a((LangLa_cx) var4);
    }

    public void a(String var1, int var2, LangLa_cy var3) {
        LangLa_ch var4;
        (var4 = new LangLa_ch(var1, this, 0)).g = var3;
        var4.cG.removeElementAt(var4.cG.size() - 1);
        var4.b(Caption.aP, var2);
        var4.c(Caption.v, 10003);
        this.a((LangLa_cx) var4);
    }

    public void a(String var1, int var2, int var3, LangLa_cy var4) {
        LangLa_ch var5;
        (var5 = new LangLa_ch(var1, this, 0)).g = var4;
        var5.cG.clear();
        var5.b(Caption.aP, var2);
        var5.c(Caption.v, var3);
        this.a((LangLa_cx) var5);
    }

    public void a(String var1, String var2, int var3, int var4, LangLa_cy var5) {
        LangLa_ch var6;
        (var6 = new LangLa_ch(var1, this, 0)).h = var2;
        var6.g = var5;
        var6.cG.removeElementAt(var6.cG.size() - 1);
        var6.b(Caption.aP, var3);
        var6.c(Caption.v, var4);
        this.a((LangLa_cx) var6);
    }

    public LangLa_ch l(String var1) {
        LangLa_ch var2 = new LangLa_ch(var1, this, 0);
        this.a((LangLa_cx) var2);
        return var2;
    }

    public void a(String var1, int var2) {
        LangLa_ch var3;
        (var3 = new LangLa_ch(var1, this, 3)).d = var2;
        var3.cG.clear();
        var3.a(Caption.qb, 10010);
        this.a((LangLa_cx) var3);
    }

    private void a(LangLa_kd var1) {
        this.a((LangLa_cx) (new LangLa_ck(var1, this, (byte) 0, true)));
    }

    public void I() {
        this.j(5);
        this.j(4);
        this.j(3);
        this.j(2);
        this.j(1);
    }

    public void j(int var1) {
        try {
            for (int var3 = this.cD.size() - 1; var3 >= 0; --var3) {
                if (((LangLa_cx) this.cD.elementAt(var3)).cF == var1) {
                    this.cD.removeElementAt(var3);
                }
            }

            this.J();
        } catch (Exception var4) {

        }

    }

    public void J() {
        a((Vector) this.cD);
        this.cE = (LangLa_cx) this.cD.lastElement();
    }

    public void d(int var1, int var2) {
        this.cE.g(var1, var2);
    }

    public void b(int var1, Object var2, LangLa_cy var3) {
        try {
            switch (var1) {
                case -11:
                    this.Q();
                    break;
                case -10:
                case -9:
                default:
                    this.a(var1, var2, var3);
                    return;
                case -8:
                    this.a((LangLa_kd) var2);
                    break;
                case -7:
                    this.b((LangLa_cx) var2);
                    break;
                case -6:
                    this.j(1);
                    break;
                case -5:
                    this.j(2);
                    break;
                case -4:
                    this.j(3);
                    break;
                case -3:
                    this.j(4);
                    break;
                case -2:
                    this.j(5);
                    break;
                case -1:
                    this.I();
            }
        } catch (Exception var4) {
        }

    }

    public void b(int var1, Object var2) {
        this.a(var1, var2);
    }

    public Vector c() {
        return null;
    }

    public void b(String var1, int var2) {
        this.K();
        LangLa_hd.a().a(var1, mFont.f, -2560);
    }

    public void showMessage(String var1, int var2) {
        this.K();
        LangLa_jh.a().a(var1, mFont.d, var2);
    }

    public static void d(String var0, int var1) {
        LangLa_jj.a().a(var0, mFont.d, -7812062);
    }

    public void e(String var1, int var2) {
        this.K();
        LangLa_jl.a().a(var1, mFont.d, -2560);
    }

    public void K() {
        LangLa_cx var1;
        if ((var1 = this.cE) instanceof LangLa_ba) {
            this.b(var1);
        }

    }

    public void L() {
        this.a((LangLa_cx) (new LangLa_ba(this)));
    }

    public abstract void j();

    public abstract void G();

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public Vector cC;
public void initialize() {
this.cC = new Vector();
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.MainScreen");
public static SessionState $state_MainScreen() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
