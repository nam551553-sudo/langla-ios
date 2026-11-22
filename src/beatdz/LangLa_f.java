package beatdz;
import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_f extends LangLa_fo {
   private LangLa_kc a;
   private int b;

   public LangLa_f(MainScreen var1, int var2) {
      this.b = var2;
      this.cF = 2;
      this.p = var1;
      this.r = false;
      this.a(190, 137);
      this.a = new LangLa_kc(1000, 0);
      this.a(20, 45, Caption.tD[0], this, this.a);
      this.a(20, 70, Caption.tD[1], this, this.a);
      this.a(this.width / 2 - 25, this.height - 35, Caption.g, this, 1001, -8);
   }

   public void a(int var1, Object var2, LangLa_cy var3) {
   }

   public void a(int var1, Object var2) {
   }

   public void a(Graphics var1) {
      this.a(var1, 0, 0, this.width, this.height, 80, 55, 56);
      mFont.b(mFont.d, var1, Caption.qh, 15, 30, 0, -1, -16777216);
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
         LangLa_f var5 = this;

         try {
            Message var6;
            (var6 = Message.c((byte)-26)).writeByte(var5.b);
            var6.writeBoolean(var5.a.b == 1);
            var6.send();
         } catch (Exception var4) {
         }

         this.J();
         return;
      case 1002:
         this.J();
      default:
      }
   }
}
