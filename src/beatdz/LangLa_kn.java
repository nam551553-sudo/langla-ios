package beatdz;
import java.util.Vector;

public class LangLa_kn extends LangLa_fm {
   private LangLa_kd b;
   private LangLa_ii c;
   private int d;
   private String[] e;
   private String[][] f;
   public boolean a;

   public LangLa_kn(int var1, int var2, LangLa_cx var3, LangLa_kd var4) {
      this.s = var3;
      this.b = var4;
      this.setXY(var1, var2);
      this.e = new String[var4.c.length];
      this.f = new String[var4.c.length][];

      for(var1 = 0; var1 < var4.c.length; ++var1) {
         String[] var5 = Utlis.split(var4.c[var1], ",");
         this.e[var1] = var5[0];
         if (var5.length > 1) {
            this.f[var1] = new String[var5.length - 1];

            for(int var6 = 1; var6 < var5.length; ++var6) {
               this.f[var1][var6 - 1] = var5[var6];
            }
         }
      }

      this.a();
   }

   public void a(int var1) {
      if ((var1 = this.e.length) > 7) {
         var1 = 7;
      }

      this.setSize(70, this.height);

      for(int var2 = 0; var2 < this.e.length; ++var2) {
         int var3;
         if ((var3 = mFont.b(mFont.d, this.e[var2]) + 20) > this.width) {
            this.width = (short)var3;
         }
      }

      this.c = new LangLa_ii((byte)1, 5, 5, 60, var1 * 18, 18, this.e.length);
      this.a = true;
   }

   private void a() {
      int var1;
      if ((var1 = this.e.length) > 7) {
         var1 = 7;
      }

      this.setSize(110, 10 + var1 * 18);

      for(int var2 = 0; var2 < this.e.length; ++var2) {
         int var3;
         if ((var3 = mFont.b(mFont.d, this.e[var2]) + 20) > this.width) {
            this.width = (short)var3;
         }
      }

      this.c = new LangLa_ii((byte)1, 5, 5, this.width - 10, var1 * 18, 18, this.e.length);
   }

   public void a(Graphics var1) {
      int var2 = var1.a;
      int var3 = var1.b;
      this.a(var1, 0, 0, this.width, this.height, -14, 84, 5, 1, 1);
      this.a(var1, this.c);

      for(int var4 = 0; var4 < this.c.i; ++var4) {
         if (this.c.k == var4) {
            var1.f(8798745);
            var1.c(0, -1 + var4 * this.c.h, this.c.width, this.c.h);
            if (this.a) {
               mFont.c(mFont.d, var1, this.e[var4], 5, 7 + var4 * this.c.h, 0, -1, -16777216);
            } else {
               mFont.c(mFont.d, var1, this.e[var4], 5, 7 + var4 * this.c.h, 0, -1, -16777216);
            }
         } else if (this.c.l == var4) {
            mFont.c(mFont.d, var1, this.e[var4], 6, 8 + var4 * this.c.h, 0, -1, -16777216);
         } else {
            mFont.c(mFont.d, var1, this.e[var4], 5, 7 + var4 * this.c.h, 0, -1, -16777216);
         }
      }

      this.b(var1);
      this.a(var1, var2, var3);
   }

   public void b() {
      this.c.a();
      if (this.d > 0) {
         if (this.d == 1) {
            this.s.b((LangLa_cs)this);
            return;
         }

         --this.d;
      }

   }

   public Vector c() {
      Vector var1;
      (var1 = new Vector()).addElement(this.c.a(this.b.a, this.s));
      return var1;
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      if (var1.j.k >= 0) {
         if (this.b.e == -1 && this.f[var1.j.k] != null && this.f[var1.j.k].length > 0) {
            this.b.e = var1.j.k;
            this.e = this.f[var1.j.k];
            var1.j.k = -1;
            this.a();
            return;
         }

         if (this.b.e == -1) {
            var1.b = this.b.d[var1.j.k];
         } else {
            var1.b = this.b.d[this.b.e];
            this.b.e = var1.j.k;
         }

         this.s.a(var1.b, this.b, this.s);
         this.d = 4;
      }

   }
}
