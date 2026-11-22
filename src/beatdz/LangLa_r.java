package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_r extends LangLa_fl {
   public int a;
   public int b;
   public boolean c;

   public LangLa_r(MainScreen var1) {
      this.p = var1;
      this.setSize((DataCenter.gI().widthScreen - 240) / 14 * 14 + 192, 26);
      this.setXY(DataCenter.gI().widthScreen / 2 - this.width / 2, DataCenter.gI().heightScreen - 35);
      this.a = 0;
      this.b = 120;
   }

   public void e() {
      ++this.a;
      if (this.a > this.b * 99 / 100) {
         this.a = this.b * 99 / 100;
      }

   }

   private int a(int var1) {
      int var2 = 0;

      try {
         if ((var2 = this.a * var1 / this.b) > var1) {
            var2 = var1;
         }
      } catch (Exception var3) {
      }

      if (var2 < 0) {
         var2 = 0;
      }

      return var2;
   }

   public void a(Graphics var1) {
      var1.clean();
      if (beatdz.GameSrc.$state_GameSrc().bR != null) {
         var1.a(beatdz.GameSrc.$state_GameSrc().bR, 0, 0, beatdz.GameSrc.$state_GameSrc().bR.c, beatdz.GameSrc.$state_GameSrc().bR.d, 0, DataCenter.gI().widthScreen / 2, DataCenter.gI().heightScreen / 2, DataCenter.gI().widthScreen * DataCenter.gI().zoomLevel, DataCenter.gI().heightScreen * DataCenter.gI().zoomLevel, 3);
      }

      this.b(var1, this.cx, this.cy);
   }

   public void b(Graphics var1, int var2, int var3) {
      var1.clean();
      this.a(var1, var2, var3 - AppListener.gI().o / 2);
      var1.f(-16777216);
      var1.c(38, 13, this.width - 76, LangLa_fq.b(AppListener.d));
      Binary2.a(var1, AppListener.d, 0, 0, LangLa_fq.a(AppListener.d), LangLa_fq.b(AppListener.d), 0, 38, 13, this.a(this.width - 76) * DataCenter.gI().zoomLevel, AppListener.d.d, 20);
      mImage var10001 = AppListener.e;
      Binary2.a(var1, var10001, LangLa_fq.a(var10001) - 1, 0, 1, LangLa_fq.b(AppListener.e), 0, LangLa_fq.a(AppListener.e), 0, (this.width - LangLa_fq.a(AppListener.e) * 2) * DataCenter.gI().zoomLevel, AppListener.e.d, 20);
      var1.a(AppListener.e, 0, 0, AppListener.e.c, AppListener.e.d, 0, 0, 0, 20);
      var1.a(AppListener.e, 0, 0, AppListener.e.c, AppListener.e.d, -360, this.width, 0, 24);
      mFont.a(mFont.d, var1, Caption.c + this.f() + "%", this.width / 2, 19, 2, -16711681);
   }

   public int f() {
      return this.a * 100 / this.b;
   }

   public void b() {
      if (this.a < this.b / 2) {
         ++this.a;
      }

      if (this.a >= this.b) {
         if (this.p instanceof GameSrc) {
            ((GameSrc)this.p).V = null;
         }

      } else {
         if (this.c) {
            this.a += this.b / 10;
         }

         if (this.a > this.b) {
            this.a = this.b;
         }

      }
   }

   public Vector c() {
      return new Vector();
   }

   public void a(LangLa_jz var1, int var2, int var3) {
   }

   public void a(int var1, Object var2, LangLa_cy var3) {
   }

   public void a(int var1, Object var2) {
   }
}
