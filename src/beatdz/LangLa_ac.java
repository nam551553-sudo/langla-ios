package beatdz;
import java.util.Vector;

public class LangLa_ac extends LangLa_fm {
   private int a;
   private int b = 20;
   private LangLa_ij c;
   private int d;
   private int e = 35;

   public LangLa_ac(int var1, int var2, int var3, LangLa_cx var4) {
      this.a = var3;
      this.s = var4;
      this.setXY(var1, var2);
      this.setSize(100, 80);
      this.c = new LangLa_ij((byte)1, 0, 0, this.width, this.height, this.b, Utlis.c(this.e, 5), 5);
   }

   public void a(Graphics var1) {
      this.a(var1, -6, -6, this.width + 12, this.height + 12, -11, 84, 5, 1, 1);
      this.a(var1, this.c);
      int var2 = 0;
      int var3 = 0;

      for(int var4 = 0; var4 < this.e; ++var4) {
         if (this.c.c(var3)) {
            if (var4 == this.c.p) {
               LangLa_fq.a(var1, beatdz.LangLa_je.$state_LangLa_je().g[var4].c, 0, var2 + 2 + 1, var3 + 2 + 1, 0);
            } else {
               LangLa_fq.a(var1, beatdz.LangLa_je.$state_LangLa_je().g[var4].c, 0, var2 + 2, var3 + 2, 0);
            }
         }

         var2 += 20;
         if (var2 > this.width - 20) {
            var2 = 0;
            var3 += 20;
         }
      }

      this.b(var1);
   }

   public void b() {
      this.c.a();
      if (this.d > 0) {
         --this.d;
         if (this.d == 0) {
            this.s.b(this.a, beatdz.LangLa_je.$state_LangLa_je().g[this.c.k].d, this);
            this.s.b((LangLa_cs)this);
         }
      }

   }

   public Vector c() {
      Vector var1;
      (var1 = new Vector()).addElement(new LangLa_jz(-1002, this.c.cx, this.c.cy, this.c.cx + this.c.width, this.c.cy + this.c.height, this.c, this));
      return var1;
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      if (this.d <= 0) {
         if (this.c.k >= 0 && this.c.k < this.e) {
            this.d = 4;
         }

      }
   }
}
