package beatdz;
import java.util.Vector;

public class LangLa_hx extends LangLa_fm {
   private LangLa_dz[] b = new LangLa_dz[1];
   private LangLa_ii[] c;
   private LangLa_ii d;
   public String[] a;

   public LangLa_hx(int var1, int var2, int var3, LangLa_cx var4, String var5) {
      this.s = var4;
      this.setXY(var1, var2);
      this.a = mFont.c(mFont.d, var5, var3 - 20);
      int var10000 = this.a.length > 10 ? 10 : this.a.length;
      var1 = var10000;
      if ((var2 = var10000 * 13 + 10) < 100) {
         var2 = 100;
      }

      this.setSize(var3, var2);
      this.b[0] = new LangLa_dz(var3 - 17, 3, 0, 0, "", var4, 2001, 52);
      this.c = a(this.b);
      this.d = new LangLa_ii((byte)1, 0, 5, var3, var1 * 13, 13, this.a.length);
   }

   public void a(Graphics var1) {
      this.a(var1, 0, 0, this.width, this.height, -11, 55, 56);
      int var2 = var1.a;
      int var3 = var1.b;
      this.a(var1, this.d);

      for(int var4 = 0; var4 < this.a.length; ++var4) {
         mFont.b(mFont.d, var1, this.a[var4], 8, var4 * this.d.h + 5, 0, -1, -16777216);
      }

      this.b(var1);
      this.a(var1, this.b, var2, var3);
      this.a(var1, var2, var3);
      this.d.b(var1, -21, -5);
   }

   public void b() {
      this.d.a();
      a(this.b, this.c);
   }

   public Vector c() {
      Vector var1;
      (var1 = new Vector()).addElement(this.c[0].a(this.b[0].b, this));
      var1.add(this.d.a(2000, this));
      return var1;
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      switch(var1.b) {
      case 2000:
         return;
      case 2001:
         this.s.b((LangLa_cs)this);
      default:
      }
   }
}
