package beatdz;
import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_fc extends LangLa_fo {
   private LangLa_ij a;

   public void a(int var1, Object var2, LangLa_cy var3) {
   }

   public void a(int var1, Object var2) {
   }

   public void a(Graphics var1) {
      this.a(var1, 0, 0, this.width, this.height, 80, 55, 56);
      mFont.b(mFont.d, var1, Caption.qy, 10, 25, 0, -1, -16777216);
      this.a(var1, this.a);

      for(int var2 = 0; var2 < this.a.r; ++var2) {
         for(int var3 = 0; var3 < this.a.i; ++var3) {
            if (this.a.b(var3)) {
               int var10001 = var3 * this.a.h;
               int var10002 = var2 * this.a.h;
               int var10004 = var2 * this.a.i;
               a(var1, var10001, var10002, Char.gI().arrItemExtend[var10004 + var3], var2 * this.a.i + var3 == this.a.k, 54);
            }
         }
      }

      this.b(var1);
   }

   public void b() {
      this.a.a();
   }

   public Vector c() {
      super.c();
      Vector var1;
      (var1 = new Vector()).addElement(this.a.a(1001, this));
      var1.addElement(new LangLa_jz(0, 0, 0, this.width, this.height, this.q, this));
      return var1;
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      switch(var1.b) {
      case 1001:
         this.cL = a(var1, this, Char.gI().arrItemExtend[var1.j.k]);
         return;
      case 1002:
         this.J();
      default:
      }
   }
}
