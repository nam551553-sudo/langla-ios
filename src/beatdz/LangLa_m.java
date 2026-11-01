package beatdz;
import com.tgame.model.Caption;

public class LangLa_m extends LangLa_fo {
   private LangLa_cl a;
   private LangLa_cl b;
   private LangLa_kc c;

   public LangLa_m(MainScreen var1) {
      this.p = var1;
      this.a(180, 100);
      this.c = new LangLa_kc(1000, mConfig.gI().readByte(9));
      this.a = this.a(15, 40, Caption.bX, this, this.c);
      this.b = this.a(15, 65, Caption.bY, this, this.c);
   }

   public void a(int var1, Object var2) {
   }

   public void a(int var1, Object var2, LangLa_cy var3) {
      if (var1 == 1000) {
         mConfig.gI().writeBoolean(9, this.c.b == 0);
      }

   }

   public void a(LangLa_jz var1, int var2, int var3) {
   }

   public void a(Graphics var1) {
      this.a(var1, this.cx, this.cy, this.width, this.height, Caption.rV[1], (byte)2, false);
   }

   public void b() {
   }
}
