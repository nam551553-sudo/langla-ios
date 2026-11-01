package beatdz;import com.tgame.model.Caption;

public class LangLa_c extends LangLa_fl {
   private String[] c;
   public String a;
   public String b;

   public LangLa_c() {
      this.b = Caption.f;
   }

   public void a(String var1, MainScreen var2) {
      var2.b(var2.cL);
      if (var2.cE != null) {
         var2.cE.b((LangLa_cs)var2.cE.cL);
      }

      var2.I();
      this.cF = 4;
      this.p = var2;
      this.a = var1;
      this.a(200, 140);
      this.cG.clear();
      this.c = var1.split("\n");
      this.b(Caption.eL, 1001);
      this.c(Caption.eM, 1002);
   }

   public void a(int var1, Object var2, LangLa_cy var3) {
   }

   public void a(int var1, Object var2) {
   }

   public void a(Graphics var1) {
      this.a(var1, this.cx, this.cy, this.width, this.height, this.b, (byte)2, this.r);
      this.a(var1, 6, 33, this.width - 12, this.height - 48, -11, 84, 5, 1, 1);
      this.a(var1, this.cx + 4, this.cy + this.a_());

      for(int var2 = 0; var2 < this.c.length; ++var2) {
         mFont.a(var1, this.c[var2], (super.width - 8) / 2, this.G() / 2 - 6 + var2 * 12 - this.c.length * 6, 2, -1);
      }

   }

   public void b() {
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      switch(var1.b) {
      case 1001:
         this.J();
         if (DataCenter.gI().currentScreen instanceof CheckVersionScreen) {
            DataCenter.gI().createSession();
            return;
         }

         beatdz.CheckVersionScreen.$state_CheckVersionScreen().b = beatdz.CheckVersionScreen.$state_CheckVersionScreen().c;
         DataCenter.gI().setScreen((MainScreen)LoginPCScreen.getScreenLogin());
         return;
      case 1002:
         this.J();
         AppListener.gI();
         AppListener.exit();
      default:
      }
   }
}
