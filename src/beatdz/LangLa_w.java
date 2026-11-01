package beatdz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Application.ApplicationType;
import com.tgame.model.Caption;
import java.util.Arrays;
import java.util.Vector;

public class LangLa_w extends LangLa_fo {

    private LangLa_ce a;
    private LangLa_ce b;
    private LangLa_ce c;
    private LangLa_kc d;
    private LangLa_kc e;
    private LangLa_lf f;
    private int g = 2;

    public LangLa_w(MainScreen var1) {
        this.p = var1;
        byte var8 = 0;
        if (Gdx.app.getType() == ApplicationType.Desktop) {
            this.a(240, 186);
            var8 = 15;
        } else {
            this.a(240, 166);
        }

        this.f = new LangLa_lf(new LangLa_kd(2000, Caption.sU), 4, this.a_(), super.width - 8, 23, 60, this);
        this.a = this.a(15, 45 + var8, Caption.bM, 1001);
        LangLa_ce var10000 = this.a;
        boolean var3 = mConfig.gI().readBoolean(1);
        var10000.a = var3;
        this.b = this.a(15, 65 + var8, Caption.bN, 1002);
        var10000 = this.b;
        var3 = mConfig.gI().readBoolean(0);
        var10000.a = var3;
        this.c = this.a(130, 45 + var8, Caption.ca, 1004);
        var10000 = this.c;
        var3 = mConfig.gI().readBoolean(11);
        var10000.a = var3;
        this.d = new LangLa_kc(1000, mConfig.gI().readByte(9));
        this.e = new LangLa_kc(1005, 1);
        short[] var2;
        byte var11;
        if ((var2 = Binary.b())[0] == 400 && var2[1] == 240) {
            var11 = 0;
            this.e.b = var11;
        } else if ((var2)[0] == 800 && var2[1] == 480) {
            var11 = 1;
            this.e.b = var11;
        } else if (var2[0] == 960 && var2[1] == 640) {
            var11 = 2;
            this.e.b = var11;
        } else if (var2[0] == 1024 && var2[1] == 600) {
            var11 = 3;
            this.e.b = var11;
        } else if (var2[0] == 1200 && var2[1] == 720) {
            var11 = 4;
            this.e.b = var11;
        }
        System.out.println(Arrays.toString(var2));

        LangLa_cl var9 = this.a(15, 90 + var8, Caption.bX, this, this.d);
        LangLa_cl var12 = this.a(15, 115 + var8, Caption.bY, this, this.d);
        LangLa_cl var4 = null;
        if (Gdx.app.getType() == ApplicationType.Desktop) {
            var4 = this.a(15, 140 + var8, Caption.oa, this, this.d);
        }

        LangLa_cl var5 = this.a(15, 60 + var8, Caption.sV[0], this, this.e);
        LangLa_cl var6 = this.a(15, 82 + var8, Caption.sV[1], this, this.e);
        LangLa_cl var7 = this.a(15, 104 + var8, Caption.sV[2], this, this.e);
        LangLa_cl var10 = this.a(15, 126 + var8, Caption.sV[3], this, this.e);
        LangLa_cl var101 = this.a(15, 148 + var8, Caption.sV[4], this, this.e);
        this.g = this.e.b;
        if (this.f != null) {
            this.f.a((LangLa_cs) this.a, 0);
            this.f.a((LangLa_cs) this.b, 0);
            this.f.a((LangLa_cs) this.c, 0);
            this.f.a((LangLa_cs) var9, 0);
            this.f.a((LangLa_cs) var12, 0);
            if (var4 != null) {
                this.f.a((LangLa_cs) var4, 0);
            }

            this.f.a((LangLa_cs) var5, 1);
            this.f.a((LangLa_cs) var6, 1);
            this.f.a((LangLa_cs) var7, 1);
            this.f.a((LangLa_cs) var10, 1);
            this.f.a((LangLa_cs) var101, 1);
            this.f.a(0);
        }

    }

    public void a(int var1, Object var2) {
    }

    public void a(LangLa_jz var1, int var2, int var3) {
        switch (var1.b) {
            case 2000:
                if (var1.j.k >= 0) {
                    this.f.a(var1.j.k);
                }
            default:
        }
    }

    public void a(int var1, Object var2, LangLa_cy var3) {
        switch (var1) {
            case 1000:
                mConfig.gI().writeByte(9, this.d.b);
                return;
            case 1001:
                LangLa_dp.a().b(this.a.a);
                return;
            case 1002:
                LangLa_dp.a().a(this.b.a);
                return;
            case 1004:
                mConfig.gI().writeBoolean(11, this.c.a);
                return;
            case 1005:
                if (this.g != this.e.b) {
                    this.g = this.e.b;
                    short[] var10 = new short[]{1024, 600};
                    switch (this.e.a() - 1) {
                        case -1:
                            Gdx.graphics.setWindowedMode(400, 240);
                            var10 = new short[]{400, 240};
                            break;
                        case 0:
                            Gdx.graphics.setWindowedMode(800, 480);
                            var10 = new short[]{800, 480};
                            break;
                        case 1:
                            Gdx.graphics.setWindowedMode(960, 640);
                            var10 = new short[]{960, 640};
                            break;
                        case 2:
                            Gdx.graphics.setWindowedMode(1024, 600);
                            var10 = new short[]{1024, 600};
                            break;
                        case 3:
                            Gdx.graphics.setWindowedMode(1200, 720);
                            var10 = new short[]{1200, 720};
                            break;
                        case 4:
                            break;
                    }

                    Writer var9 = null;
                    boolean var6 = false;

                    label94:
                    {
                        label93:
                        {
                            try {
                                var6 = true;
                                (var9 = new Writer()).writeShort(var10[0]);
                                var9.writeShort(var10[1]);
                                Binary.write("arr_screen", var9.baos.toByteArray());
                                AppListener.gI().k();
                                var6 = false;
                                break label93;
                            } catch (Exception var7) {
                                var6 = false;
                            } finally {
                                if (var6) {
                                    if (var9 != null) {
                                        var9.close();
                                    }

                                }
                            }

                            if (var9 != null) {
                                var9.close();
                            }
                            break label94;
                        }

                        var9.close();
                    }

                    AppListener var10000 = AppListener.gI();
                    short var10001 = var10[0];
                    short var12 = var10[1];
                    short var13 = var10001;
                    AppListener var11 = var10000;
                    var10000.width = var13;
                    var11.height = var12;
                    AppListener.gI().createCanvas();
                    if (GameSrc.d() != null) {
                        GameSrc.gI().aj = null;
                    }
                }
            case 1003:
            default:
        }
    }

    public void a(Graphics var1) {
        this.a(var1, this.cx, this.cy, this.width, this.height, Caption.rV[3], (byte) 2, false);
        if (Gdx.app.getType() == ApplicationType.Desktop) {
            this.f.a(var1);
            if (this.f.b.b == 1) {
                mFont.b(mFont.d, var1, Caption.sV[this.e.a()], 14, 65, 0, -1, -16777216);
            }
        }

    }

    public void b() {
        if (this.f != null) {
            this.f.b();
        }

    }

    public Vector c() {
        Vector var1 = super.c();
        if (Gdx.app.getType() == ApplicationType.Desktop) {
            var1.addElement(this.f.c());
        }

        return var1;
    }
}
