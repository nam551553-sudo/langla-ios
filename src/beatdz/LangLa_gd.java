package beatdz;
import com.tgame.model.Caption;

public class LangLa_gd extends mTextBox {
   private byte x;
   private String y = "";

   public LangLa_gd(int var1, int var2, int var3, String var4, LangLa_cx var5, int var6, int var7, int var8) {
      super(var1, var2, var3, var4, var5, 0, 2);
      this.a = 8;
      this.x = (byte)var8;
      this.j = new LangLa_im((byte)0, 5, 2, this.width - 10 - 22, this.height - 4, this.width, 0);
   }

   public void p() {
      super.p();
      this.y = Utlis.numberFormat(this.e());
   }

   public void a(Graphics var1) {
      Binary2.a(var1, 305, 0, 0, 2, this.width, (int)(this.height * 2 - 6));
      super.a(var1);
      if (!(this.s instanceof LangLa_dl)) {
         this.a(var1, this.s.cx + this.cx, this.s.cy + this.cy);
         if (this.x == 2) {
            mFont.b(mFont.d, var1, Utlis.numberFormat(this.e()) + " " + Caption.rs[0], 5, 29, 0, -2560, -16777216);
         } else if (this.x == 3) {
            mFont.b(mFont.d, var1, Utlis.numberFormat(this.e()) + " " + Caption.rs[1], 5, 29, 0, -2560, -16777216);
         } else if (this.x == 0) {
            mFont.b(mFont.d, var1, Utlis.numberFormat(this.e()) + " " + Caption.rs[2], 5, 29, 0, -3089954, -16777216);
         } else {
            if (this.x == 1) {
               mFont.b(mFont.d, var1, Utlis.numberFormat(this.e()) + " " + Caption.rs[3], 5, 29, 0, -3089954, -16777216);
            }

         }
      }
   }
}
