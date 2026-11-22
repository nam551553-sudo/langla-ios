package beatdz;
import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_bb extends LangLa_fo {
   private LangLa_gd a;

   public LangLa_bb(MainScreen var1) {
      this.cF = 2;
      this.p = var1;
      this.r = false;
      this.a(220, 140);
      this.a = new LangLa_gd(110, 45, 100, "", this, 0, 2, 2);
      this.a(this.a);
      this.a(Caption.aP, 100);
   }

   public void a(int var1, Object var2, LangLa_cy var3) {
   }

   public void a(int var1, Object var2) {
   }

   public void a(Graphics var1) {
      this.a(var1, 0, 0, this.width, this.height, 80, 55, 56);
      mFont.c(mFont.d, var1, Caption.ig, 9, this.a_() + 3, 0, -1, -16777216);
      mFont.c(mFont.d, var1, Caption.ih, 104, this.a_() + 25, 1, -1, -16777216);
      mFont.c(mFont.d, var1, Caption.ii, 104, this.a_() + 65, 1, -1, -16777216);
      mFont.c(mFont.d, var1, Utlis.numberFormat(Char.gI().vang) + Caption.cw, 109, this.a_() + 65, 0, -1, -16777216);
   }

   public void b() {
   }

   public Vector c() {
      super.c();
      Vector var1;
      (var1 = new Vector()).addElement(new LangLa_jz(0, 0, 0, this.width, this.height, this.q, this));
      return var1;
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      switch(var1.b) {
      case 100:
         LangLa_bb var5 = this;

         try {
            Message var6;
            (var6 = Message.c((byte)-88)).writeInt(var5.a.e());
            var6.send();
            return;
         } catch (Exception var4) {
         }
      default:
      }
   }
}
