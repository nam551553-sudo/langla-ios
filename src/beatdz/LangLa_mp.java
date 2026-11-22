package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_mp extends LangLa_fm {
   private long a;

   public LangLa_mp(int var1, int var2, LangLa_cx var3) {
      this.s = var3;
      this.setSize(190, 90);
      this.setXY(DataCenter.gI().widthScreen - this.width, var2);
      this.a = Utlis.time();
   }

   public void a(Graphics var1) {
      this.b(var1, 0, 0, this.width, this.height, 314, -11657441, -9490898);
      LangLa_fq.a(var1, 366, 0, this.width - 50, 0, 36);
      long var2 = (long)GameSrc.gI().t - (Utlis.time() - GameSrc.gI().q);
      long var4 = 0L;
      if (var2 < 0L) {
         var4 = 0L - var2;
         var2 = 0L;
      }

      long var6;
      if ((var6 = GameSrc.gI().r - var4) < 0L) {
         var6 = 0L;
      }

      mFont.c(mFont.d, var1, Caption.kC + Utlis.k((int)(var2 / 1000L)), 6, 15, 0, -1, -16777216);
      mFont.c(mFont.d, var1, Caption.kD + Utlis.k((int)(var6 / 1000L)), 6, 30, 0, -1, -16777216);
      mFont.c(mFont.d, var1, Caption.kE, 6, 45, 0, -1, -16777216);
      mFont.c(mFont.d, var1, Caption.kF, 6, 60, 0, -1, -16777216);
      mFont.c(mFont.d, var1, Caption.kG, 6, 75, 0, -1, -16777216);
   }

   public void b() {
      if (Utlis.time() - this.a >= 5000L) {
         this.s.b((LangLa_cs)this);
      }

   }

   public void a(LangLa_jz var1, int var2, int var3) {
      this.a = Utlis.time();
   }

   public Vector c() {
      return null;
   }
}
