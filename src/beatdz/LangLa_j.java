package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_j extends LangLa_fo {
   private LangLa_gd a;

   public LangLa_j(MainScreen var1) {
      this.cF = 2;
      this.p = var1;
      this.r = false;
      this.a(220, 125);
      this.a = new LangLa_gd(85, 40, 100, "", this, 0, 2, 0);
      byte var2 = 12;
      this.a.a = var2;
      this.a(this.a);
      this.a(Caption.aP, 100);
   }

   public void a(int var1, Object var2, LangLa_cy var3) {
   }

   public void a(int var1, Object var2) {
   }

   public void a(Graphics var1) {
      this.a(var1, 0, 0, this.width, this.height, 80, 55, 56);
      mFont.b(mFont.d, var1, Caption.fj + Utlis.numberFormat(Char.gI().bac) + Caption.en, 10, 28, 0, -1, -16777216);
      mFont.b(mFont.d, var1, Caption.fk, 10, 50, 0, -1, -16777216);
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
      try {
         switch(var1.b) {
         case 100:
            LangLa_j var6 = this;

            try {
               Message var7;
               (var7 = Message.c((byte)-95)).writeInt(var6.a.e());
               var7.send();
               break;
            } catch (Exception var4) {
               DataCenter.gI().currentScreen.showMessage(Caption.fl, -1);
            }
         default:
            return;
         }
      } catch (Exception var5) {
      }

   }
}
