package beatdz;
import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_av extends LangLa_fo {
   private mTextBox a;
   private Item b;

   public LangLa_av(MainScreen var1, Item var2) {
      this.cF = 2;
      this.p = var1;
      this.b = var2;
      this.r = false;
      this.a(180, 120);
      this.a = this.a(54, 5 + 38, 60, "", this, 2);
      byte var4 = 1;
      this.a.n = var4;
      this.a.a("1");
      this.a(this.a);
      this.a(119, 5 + 41, "", this, 1001, 58);
      this.a(140, 5 + 41, "", this, 1002, 57);
      LangLa_dz var3;
      (var3 = this.a(Caption.g, 1003)).a(-8);
      var3.setXY(var3.cx - 27, var3.cy);
      (var3 = this.a(Caption.v, -7)).a(-8);
      var3.setXY(var3.cx + 40, var3.cy);
   }

   public void b(int var1, Object var2) {
   }

   public void a(int var1, Object var2) {
   }

   public void a(int var1, Object var2, LangLa_cy var3) {
   }

   public int a_() {
      return 5;
   }

   public void a(Graphics var1) {
      this.a(var1, 0, 0, this.width, this.height, 80, 55, 56);
      mFont.b(mFont.f, var1, Caption.mf, 9, 5 + 15, 0, -1, -16777216);
      mFont.b(mFont.d, var1, Caption.at, 9, 5 + 50, 0, -10831436, -16777216);
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
         int var6;
         if ((var6 = this.a.e() - 1) <= 0) {
            var6 = 1;
         }

         this.a.a(var6);
         return;
      case 1002:
         this.a.a(this.a.e() + 1);
         return;
      case 1003:
         LangLa_av var5 = this;

         try {
            if (var5.a.e() >= 0 && var5.a.e() <= var5.b.getAmount()) {
               var5.J();

               for(var2 = 0; var2 < var5.a.e(); ++var2) {
                  GameSrc.gI();
                  GameSrc.a(var5.b);
               }

               return;
            }

            GameSrc.gI().showMessage(Caption.mh, -65536);
            return;
         } catch (Exception var4) {
            Utlis.println(var4);
         }
      default:
      }
   }
}
