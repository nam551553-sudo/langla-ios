package beatdz;
import java.util.Vector;

public class LangLa_cl extends LangLa_cs {
   private String c;
   public boolean a;
   private LangLa_kc d;
   private short e = 10;
   public boolean b;

   public LangLa_cl(int var1, int var2, String var3, LangLa_cx var4, LangLa_kc var5) {
      this.c = var3;
      this.s = var4;
      this.d = var5;
      if (var5.c.size() == var5.b) {
         this.a = true;
      }

      var5.c.addElement(this);
      this.setXY(var1, var2);
      this.setSize(18 + mFont.b(mFont.d, var3), 16);
   }

   public void b(boolean var1) {
      this.v = var1;
   }

   public void a(String var1) {
      this.c = var1;
      this.setSize(18 + mFont.b(mFont.d, var1), 16);
   }

   public void b() {
   }

   public void a(Graphics var1) {
      if (!this.v) {
         short var2 = this.e;
         if (!this.u && this.n(0)) {
            var1.e(30);
         }

         LangLa_fq.a(var1, var2, 0, 0, 0, 20);
         var1.d();
         if (!this.u && !this.v ? (this.b ? true : this.n(0)) : false) {
            mFont.b(mFont.d, var1, this.c, 21, 8, 0, -1, -16777216);
         } else if (this.u) {
            mFont.b(mFont.d, var1, this.c, 20, 7, 0, -3089954, -16777216);
         } else {
            mFont.b(mFont.d, var1, this.c, 20, 7, 0, -1, -16777216);
         }

         if (this.a) {
            LangLa_fq.a(var1, 11, 0, 4, 4, 20);
         }

      }
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      if (!this.u && !this.v) {
         for(var3 = 0; var3 < this.d.c.size(); ++var3) {
            LangLa_cl var4;
            (var4 = (LangLa_cl)this.d.c.elementAt(var3)).a = false;
            if (var4.equals(this)) {
               this.d.b = var3;
            }
         }

         this.a = true;
         this.s.b(var1.b, this.d, this);
         LangLa_dp.a().h();
      }
   }

   public Vector c() {
      Vector var1 = new Vector();
      if (!this.u && !this.v) {
         var1.addElement(new LangLa_jz(this.d.a, 0, 0, this.width, this.height, (LangLa_ii)null, this));
      }

      return var1;
   }
}
