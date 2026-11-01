package beatdz;
import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_bj extends LangLa_fo {
   public void a(int var1, Object var2) {
   }

   public void a(int var1, Object var2, LangLa_cy var3) {
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      switch(var1.b) {
      case 1001:
         this.cL = a(Caption.bT, Caption.kN, this, this.width / 2 - 100, this.height / 2 - 75);
         return;
      case 1002:
         this.p.L();
         Message var8 = null;

         try {
            var8 = Message.c((byte)-114);
            throw null;
         } catch (Exception var6) {
         } finally {
            if (var8 != null) {
               var8.close();
            }

         }

         return;
      case 1003:
         
         return;
      case 1004:
         GameSrc.gI();
         GameSrc.openFunc(58);
      default:
      }
   }

   public void a(Graphics var1) {
      this.a(var1, this.cx, this.cy, this.width, this.height, Caption.bQ, (byte)2, false);
      boolean var10001 = true;
      throw null;
   }

   public Vector c() {
      Vector var1;
      (var1 = super.c()).remove(var1.size() - 1);
      var1.addElement(new LangLa_jz(1001, 10, 140, 60, 150, (LangLa_ii)null, this));
      var1.addElement(new LangLa_jz(1004, 10, 154, 60, 164, (LangLa_ii)null, this));
      var1.addElement(new LangLa_jz(1003, this.width - 38, 140, this.width - 10, 150, (LangLa_ii)null, this));
      return var1;
   }

   public void b() {
   }
}
