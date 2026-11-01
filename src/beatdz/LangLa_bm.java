package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_bm extends LangLa_fo {
   private LangLa_gd e;
   public int a;
   public int b;
   public int c;
   public int d;
   private byte f;

   public LangLa_bm(MainScreen var1, byte var2, int var3, int var4, int var5, int var6) {
      this.f = var2;
      this.a = var3;
      this.b = var4;
      this.c = var5;
      this.d = var6;
      this.cF = 2;
      this.p = var1;
      this.r = false;
      this.a(220, 125);
      this.e = new LangLa_gd(85, 40, 100, "", this, 0, 2, var2);
      byte var7 = 12;
      this.e.a = var7;
      this.a(this.e);
      this.a(Caption.aP, 100);
   }

   public void a(int var1, Object var2, LangLa_cy var3) {
   }

   public void a(int var1, Object var2) {
   }

   public void a(Graphics var1) {
      this.a(var1, 0, 0, this.width, this.height, 80, 55, 56);
      switch(this.f) {
      case 0:
         mFont.b(mFont.d, var1, Caption.fj + Utlis.numberFormat(this.c) + " " + Caption.rs[2], 10, 28, 0, -1, -16777216);
         mFont.b(mFont.d, var1, Utlis.replaceAll(Caption.pm, Caption.rs[2]), 10, 50, 0, -1, -16777216);
         return;
      case 1:
         mFont.b(mFont.d, var1, Caption.fj + Utlis.numberFormat(this.d) + " " + Caption.rs[3], 10, 28, 0, -1, -16777216);
         mFont.b(mFont.d, var1, Utlis.replaceAll(Caption.pm, Caption.rs[3]), 10, 50, 0, -1, -16777216);
      default:
         return;
      case 2:
         mFont.b(mFont.d, var1, Caption.fj + Utlis.numberFormat(this.a) + " " + Caption.rs[0], 10, 28, 0, -1, -16777216);
         mFont.b(mFont.d, var1, Utlis.replaceAll(Caption.pm, Caption.rs[0]), 10, 50, 0, -1, -16777216);
         return;
      case 3:
         mFont.b(mFont.d, var1, Caption.fj + Utlis.numberFormat(this.b) + " " + Caption.rs[1], 10, 28, 0, -1, -16777216);
         mFont.b(mFont.d, var1, Utlis.replaceAll(Caption.pm, Caption.rs[1]), 10, 50, 0, -1, -16777216);
      }
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
            LangLa_bm var6 = this;

            try {
               Message var7;
               (var7 = Message.c((byte)-45)).writeByte(var6.f);
               var7.writeInt(var6.e.e());
               var7.send();
               var6.J();
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
