package beatdz;
import java.util.Vector;

public class LangLa_cb extends LangLa_fm {
   private LangLa_ii b;
   public String[] a;

   public LangLa_cb(int var1, int var2, LangLa_cx var3, String var4) {
      this.s = var3;
      this.setXY(var1, var2);
      this.a = mFont.c(mFont.d, var4, 106);
      var1 = this.a.length > 8 ? 8 : this.a.length;
      this.setSize(120, (this.a.length > 8 ? 8 : this.a.length) * 13 + 10);
      this.b = new LangLa_ii((byte)1, 0, 5, this.width, var1 * 13, 13, this.a.length);
   }

   public void a(Graphics var1) {
      this.a(var1, 0, 0, this.width, this.height, -12, 380, -12);
      this.a(var1, this.b);

      for(int var2 = 0; var2 < this.a.length; ++var2) {
         mFont.a((mFont)mFont.d, (Graphics)var1, this.a[var2], 8, var2 * this.b.h + 5, 0, -6488, 0);
      }

      this.b(var1);
   }

   public void b() {
      this.b.a();
   }

   public Vector c() {
      return new Vector();
   }

   public void a(LangLa_jz var1, int var2, int var3) {
   }
}
