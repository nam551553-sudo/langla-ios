package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_k extends LangLa_fo {
   private LangLa_gd a;
   private LangLa_aj b;

   public LangLa_k(MainScreen var1, LangLa_aj var2) {
      this.cF = 2;
      this.p = var1;
      this.b = var2;
      this.r = false;
      this.a(180, 137);
      this.a = new LangLa_gd(10, 45, 100, "", this, 0, 2, 0);
      byte var3 = 9;
      this.a.a = var3;
      this.a(this.a);
      this.a(26, this.height - 35, Caption.g, this, 1001, -8);
      this.a(this.width - 86, this.height - 35, Caption.v, this, 1002, -8);
   }

   public void a(int var1, Object var2, LangLa_cy var3) {
   }

   public void a(int var1, Object var2) {
   }

   public void a(Graphics var1) {
      this.a(var1, 0, 0, this.width, this.height, 80, 55, 56);
      mFont.b(mFont.d, var1, Caption.bC, 10, 30, 0, -1, -16777216);
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
      case 1001:
         boolean var10000;
         if (this.a.e() <= 0) {
            DataCenter.gI().currentScreen.showMessage(Caption.fs, -65536);
            var10000 = false;
         } else if (this.a.e() > Char.gI().bac) {
            DataCenter.gI().currentScreen.showMessage(Caption.ft, -65536);
            var10000 = false;
         } else {
            Char var4 = Char.gI();
            var4.bac -= this.a.e();
            LangLa_aj var5 = this.b;
            var2 = this.a.e();
            var5.c += var2;
            var10000 = true;
         }

         if (!var10000) {
            break;
         }
      case 1002:
         this.J();
      }

   }
}
