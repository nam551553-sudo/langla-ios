package beatdz;
import com.tgame.model.Caption;

public class LangLa_lt extends LangLa_fo {
   private String[] a;

   public LangLa_lt(String var1, MainScreen var2) {
      this.cF = 1;
      this.a(230, 150);
      this.p = var2;
      this.a = mFont.c(mFont.d, var1, 200);
      this.a(Caption.g, -7);
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      switch(var1.b) {
      case 100:
         this.J();
      default:
      }
   }

   public void a(int var1, Object var2) {
   }

   public void a(Graphics var1) {
      this.a(var1, this.cx, this.cy, this.width, this.height, Caption.dA, (byte)2, this.r);
      this.a(var1, 6, 33, this.width - 12, this.height - 48, -11, 55, 56);

      for(int var2 = 0; var2 < this.a.length; ++var2) {
         mFont.c(mFont.d, var1, this.a[var2], 14, this.G() / 2 + 20 + var2 * 12 - this.a.length * 6, 0, -1, -16777216);
      }

   }

   public void b() {
   }

   public void a(int var1, Object var2, LangLa_cy var3) {
   }
}
