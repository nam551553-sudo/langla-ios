package beatdz;

import java.util.Vector;

public class LangLa_az extends LangLa_fo {

    public int a;
    public int b;
    public int c;
    public long d;
    public String e;
    public LangLa_cx f;

    public LangLa_az(MainScreen var1, int var2, String var3, int var4) {
        this.p = var1;
        this.e = var3;
        this.c = var4;
        this.f = this.p.cE;
        this.setSize(150, 16);
        this.setXY(DataCenter.gI().widthScreen / 2 - 75, DataCenter.gI().heightScreen - 100);
        this.r = false;
        this.b = var2;
        this.d = Utlis.time();
    }

    public void a(int var1, Object var2, LangLa_cy var3) {
    }

    public void a(int var1, Object var2) {
    }

    public void a(Graphics var1) {

        int var2 = this.a * 100 / this.b;
        int var3 = this.width - 2;
        int var4 = this.height - 2;
        int var5 = var2 * var3 / 100;
        var1.f(-16777216);
        var1.c(2, 2, var3, var4);
        Binary2.a(var1, 93, 0, 2, 2, var5, (int) var4);
        mFont.a(var1, this.e + ": " + var2 + "%", this.width / 2, this.height / 2, 2, -7079423);
        LangLa_fq.a(var1, 376, 0, this.width, this.height, 0);
        LangLa_fq.a(var1, 376, -180, this.width, 0, 0);
        LangLa_fq.a(var1, 376, -360, 0, this.height, 0);
        LangLa_fq.a(var1, 376, 180, 0, 0, 0);
        Binary2.a(var1, 375, 90, 2, this.height, this.width - 2, (int) 2);
        Binary2.a(var1, 375, -270, 2, 0, this.width - 2, (int) 2);
        Binary2.a(var1, 375, 0, this.width, 2, 2, (int) (this.height - 2));
        Binary2.a(var1, 375, -360, 0, 2, 2, (int) (this.height - 2));
    }

    public void b() {
        this.a = (int) (Utlis.time() - this.d);
        if (this.a > this.b) {
            this.a = this.b;
        }

    }

    public Vector c() {
        Vector var1;
        (var1 = new Vector()).add(new LangLa_jz(1000, -this.cx, -this.cy, DataCenter.gI().widthScreen - this.cx, DataCenter.gI().heightScreen - this.cy, (LangLa_ii) null, this));
        return var1;
    }

    public void a(LangLa_jz var1, int var2, int var3) {
        try {
            (new Message((byte) 7)).send();
        } catch (Exception var4) {
        }
    }
}
