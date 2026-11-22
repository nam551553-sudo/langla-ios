package beatdz;
import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_ms extends LangLa_fo {
   private mTextBox b;
   public LangLa_ca a;

   public LangLa_ms(MainScreen var1, LangLa_ca var2) {
      this.cF = 2;
      this.p = var1;
      this.r = false;
      this.a = var2;
      this.a(180, 112);
      this.b = this.a(10, 40, 100, "", this, 0);
      this.a(26, this.height - 35, Caption.g, this, 1001, -8);
      this.a(this.width - 86, this.height - 35, Caption.v, this, 1002, -8);
   }

   public void a(int var1, Object var2, LangLa_cy var3) {
   }

   public void a(int var1, Object var2) {
   }

   public void a(Graphics var1) {
      this.a(var1, 0, 0, this.width, this.height, 80, 55, 56);
      mFont.b(mFont.d, var1, Caption.cb, 10, 25, 0, -1, -16777216);
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
         LangLa_ms var5 = this;

         try {
            if (var5.b.f().trim().length() != 0) {
               GameSrc.gI();
               GameSrc.e(var5.b.f());
            }
            break;
         } catch (Exception var4) {
            Utlis.println(var4);
            return;
         }
      case 1002:
         this.J();
      }

   }
}
