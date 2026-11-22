package beatdz;
import java.util.Vector;

public class LangLa_ce extends LangLa_cs {
   private String c;
   private int d;
   public boolean a;
   private short e = 8;
   public boolean b;

   public LangLa_ce(int var1, int var2, String var3, LangLa_cx var4, int var5) {
      this.c = var3;
      this.s = var4;
      this.d = var5;
      this.setXY(var1, var2);
      this.setSize(20 + mFont.b(mFont.d, var3), 16);
   }

   public void a(boolean var1) {
      this.u = var1;
   }

   public void b(boolean var1) {
      this.v = var1;
   }

   public void b() {
   }

   public void a(Graphics var1) {
      if (!this.v) {
         short var2 = this.e;
         if (this.a()) {
            var1.e(30);
         }

         LangLa_fq.a(var1, var2, 0, 0, 0, 20);
         if (this.a()) {
            var1.d();
         }

         if (this.a()) {
            mFont.b(mFont.d, var1, this.c, 21, 8, 0, -1, -16777216);
         } else if (this.u) {
            mFont.b(mFont.d, var1, this.c, 20, 7, 0, -3089954, -16777216);
         } else {
            mFont.b(mFont.d, var1, this.c, 20, 7, 0, -1, -16777216);
         }

         if (this.a) {
            LangLa_fq.a(var1, 9, 0, 2, 3, 20);
         }

      }
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      if (!this.u && !this.v) {
         this.a = !this.a;
         this.s.b(var1.b, this.a, this);
         LangLa_dp.a().h();
      }
   }

   public Vector c() {
      Vector var1 = new Vector();
      if (!this.u && !this.v) {
         var1.addElement(new LangLa_jz(this.d, 0, 0, this.width, this.height, (LangLa_ii)null, this));
      }

      return var1;
   }

   private boolean a() {
      if (!this.u && !this.v) {
         return this.b ? true : this.n(0);
      } else {
         return false;
      }
   }
}
