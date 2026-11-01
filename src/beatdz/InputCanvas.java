package beatdz;

public class InputCanvas extends Canvas {
    private MainScreen pointerScreen;
    private LangLa_cx pointerView;
    private MultiSession.Context pointerOwner;

    public void cancelPointer() {
        this.m = false;
        LangLa_cx view = pointerView;
        pointerScreen = null; pointerView = null; pointerOwner = null;
        if (view != null) {
            if (view.cP != null) view.cP.cancel();
            for (Object value : view.cG) {
                LangLa_cs control = (LangLa_cs)value;
                if (control.cP != null) control.cP.cancel();
                control.s();
            }
            if (view.cK != null) view.cK.c();
            view.cH = null; view.cK = null;
            view.cO.b();
        }
    }

    public static long k = System.currentTimeMillis();
    private XYEntity l = new XYEntity();
    private boolean m;

    public void a(char var1) {
        try {
            k = System.currentTimeMillis();
            if (DataCenter.gI().currentScreen != null) {
                MainScreen var10000 = DataCenter.gI().currentScreen;
                char var2 = var1;
                MainScreen var4 = var10000;
                if (!var10000.cE.a(var2)) {
                    var4.cE.cO.a(var2);
                }
            }

        } catch (Exception var3) {
            Utlis.println(var3);
        }
    }

    public void a(int var1) {
        try {
            k = System.currentTimeMillis();
            if (DataCenter.gI().currentScreen != null) {
                MainScreen var10000 = DataCenter.gI().currentScreen;
                int var2 = var1;
                MainScreen var4 = var10000;
                if (!var10000.cE.l(var2)) {
                    var4.cE.cO.a(var2);
                }
            }

        } catch (Exception var3) {
            Utlis.println(var3);
        }
    }

    public void b(int var1) {
        try {
            k = System.currentTimeMillis();
            if (DataCenter.gI().currentScreen != null) {
                MainScreen var10000 = DataCenter.gI().currentScreen;
                int var2 = var1;
                MainScreen var4 = var10000;
                if (!var10000.cE.m(var2)) {
                    var4.cE.cO.b(var2);
                }
            }

        } catch (Exception var3) {
            Utlis.println(var3);
        }
    }

    public void update() {
        try {
            if (DataCenter.gI().currentScreen != null) {
                MainScreen var1 = DataCenter.gI().currentScreen;

                try {
                    LangLa_hd.a().b();
                    LangLa_jh.a().b();
                    LangLa_jj.a().b();
                    LangLa_jl.a().b();
                    var1.j();

                    for (int var3 = 0; var3 < var1.cD.size(); ++var3) {
                        LangLa_cx var2;
                        (var2 = (LangLa_cx) var1.cD.elementAt(var3)).M();
                        var2.N();
                        var2.P();
                    }

                    if (!(var1.cE instanceof LangLa_dl) && beatdz.Binary2.$state_Binary2().a != null) {
                        beatdz.Binary2.$state_Binary2().a.J();
                    }

                    return;
                } catch (Exception var4) {
                    Utlis.println(var4);
                }
            }

        } catch (Exception var5) {
            Utlis.println(var5);
        }
    }

    public int num;

    public void paint(Graphics var1) {
        try {
            if (DataCenter.gI().currentScreen != null) {
                Graphics var2 = var1;
                MainScreen var10 = DataCenter.gI().currentScreen;

                try {
                    for (int var3 = 0; var3 < var10.cD.size(); ++var3) {
                        LangLa_cx var10000 = (LangLa_cx) var10.cD.elementAt(var3);
                        Graphics var5 = var2;
                        LangLa_cx var4 = var10000;
                        beginPopupPass(var2, var4);
                        try {
                        var10000.c(var2);
                        if (!beatdz.LangLa_cx.$state_LangLa_cx().cN) {
                            for (int var7 = 0; var7 < var4.cG.size(); ++var7) {
                                LangLa_cs var6;
                                if ((var6 = (LangLa_cs) var4.cG.elementAt(var7)).w == null && !(var6.s instanceof LangLa_dl)) {
                                    var6.c(var5);
                                }
                            }
                        }
                        } finally { endPopupPass(var2); }
                    }
                    String s = "Bạn đang sử dụng phiên bản của Làng Lá Test - By Kirin. Chúc bạn chơi game vui vẻ";
                    //String s = "Bạn đang sử dụng phiên bản ClientLangLa dành riêng cho các server Làng Lá Lậu - By Beatdz. Chúc bạn chơi game vui vẻ.";
                    num += 2;
                    mFont.a(var1, s, var10.width - num, var10.height - 8, 0, -1);
                    if (num % (s.length() * 50) == 0 || (System.currentTimeMillis() / 1000) % 60 == 0) {
                        num = 0;
                    }

                    if (!(var10 instanceof GameSrc)) {
                        if (!(var10 instanceof LangLa_md)) {
                            LangLa_hd.a().a(var2);
                            LangLa_jh.a().a(var2);
                            LangLa_jj.a().a(var2);
                        }

                        return;
                    }

                    if (!GameSrc.gI().i()) {
                        return;
                    }

                    LangLa_hd.a().a(var2);
                    LangLa_jh.a().a(var2);
                    LangLa_jj.a().a(var2);
                    LangLa_jl.a().a(var2);
                } catch (Exception var8) {
                    Utlis.println(var8);
                }
            }

        } catch (Exception var9) {
            Utlis.println(var9);
        }
    }

    public void a(int x, int y) {
        if (!ownsPointer()) { cancelPointer(); return; }
        k = System.currentTimeMillis();
        pointerView.h(x, y);
    }

    private boolean ownsPointer() {
        return m && pointerOwner == MultiSession.current() && pointerScreen == DataCenter.gI().currentScreen
                && pointerScreen != null && pointerScreen.cE == pointerView;
    }

    public void b(int x, int y) {
        cancelPointer();
        k = System.currentTimeMillis();
        pointerScreen = DataCenter.gI().currentScreen;
        pointerView = pointerScreen == null ? null : pointerScreen.cE;
        pointerOwner = MultiSession.current();
        if (pointerView == null) return;
        // New tab contents must be clickable before their first 30 Hz update.
        pointerView.M();
        m = true;
        l.setXY(x, y);
        pointerView.f(x, y);
    }

    public void c(int x, int y) {
        k = System.currentTimeMillis();
        if (!ownsPointer()) { cancelPointer(); return; }
        LangLa_cx target = pointerView;
        m = false; pointerView = null; pointerScreen = null; pointerOwner = null;
        target.g(x, y);
    }
}
