package beatdz;
public class LangLa_ba extends LangLa_fl {
   public int a;
   public int b;
   public long c;

   public LangLa_ba(MainScreen var1) {
      var1.b(var1.cL);
      if (var1.cE != null) {
         var1.cE.b((LangLa_cs)var1.cE.cL);
      }

      this.cF = 4;
      this.p = var1;
      this.a(100, 100);
      this.H();
      this.a = 0;
      this.c = Utlis.time();
   }

   public void a(int var1, Object var2, LangLa_cy var3) {
   }

   public void a(int var1, Object var2) {
   }

   public void a(Graphics var1) {
      if (this.b < 10) {
         ++this.b;
      } else if (this.b < 15) {
         ++this.b;
         var1.clean();
         var1.d(65);
         var1.f(0);
         var1.c(0, 0, DataCenter.gI().widthScreen, DataCenter.gI().heightScreen);
         LangLa_fq.a(var1, 459, 0, DataCenter.gI().widthScreen / 2, DataCenter.gI().heightScreen / 2, 3);
         var1.m = 1.0F;
      } else {
         var1.clean();
         var1.d(65);
         var1.f(0);
         var1.c(0, 0, DataCenter.gI().widthScreen, DataCenter.gI().heightScreen);
         var1.m = 1.0F;
         boolean var3 = true;
         var1.k = var3;
         LangLa_fq.a(var1, 459, this.a, DataCenter.gI().widthScreen / 2, DataCenter.gI().heightScreen / 2, 3);
         var3 = false;
         var1.k = var3;
      }
   }

   public void b() {
      if (Utlis.time() - this.c > 10000L) {
         this.p.K();
      } else {
         this.a += 45;
         if (this.a >= 360) {
            this.a = 0;
         }

      }
   }
}
