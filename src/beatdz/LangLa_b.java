package beatdz;import com.tgame.model.Caption;

public class LangLa_b extends LangLa_fo {
   public LangLa_b(MainScreen var1) {
      this.p = var1;
      this.a(240, 170);
      this.r = false;
      if (GameSrc.gI().getMapTemplate().type == 4) {
         this.a(this.a(this.width / 2 - 37, 70, Caption.pu, this, 103, 7));
      } else {
         this.a(this.a(this.width / 2 - 37, 70, Caption.rK[0], this, 100, 7));
      }

      if (GameSrc.gI().E()) {
         this.a(this.a(this.width / 2 - 37, 100, Caption.rK[2], this, 101, 7));
      } else {
         this.a(this.a(this.width / 2 - 37, 100, Caption.rK[1], this, 101, 7));
      }

      this.a(this.a(this.width / 2 - 37, 130, Caption.rK[3], this, 102, 7));
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      switch(var1.b) {
      case 100:
         this.J();
         return;
      case 101:
         this.J();
         e();
         SettingsTab.gI().a(false);
         return;
      case 102:
         DataCenter.gI().currentScreen.a(Caption.eG, 2003, this);
         return;
      case 103:
         try {
            if (!(GameSrc.gI().cE instanceof LangLa_lw)) {
               Message.c((byte)-41).send();
            }
            break;
         } catch (Exception var4) {
            return;
         }
      case 2003:
         SettingsTab.gI().a(false);
         f();
      }

   }

   public void a(int var1, Object var2, LangLa_cy var3) {
   }

   public void a(int var1, Object var2) {
   }

   public void a(Graphics var1) {
      this.a(var1, this.cx, this.cy, this.width, this.height, Caption.dA, (byte)2, this.r);
      if (beatdz.GameSrc.$state_GameSrc().aK.length() > 0) {
         mFont.b(mFont.d, var1, Caption.eH + beatdz.GameSrc.$state_GameSrc().aK + Caption.eI, this.width / 2, 44, 2, -2560, -16777216);
      } else {
         mFont.b(mFont.d, var1, Caption.eJ, this.width / 2, 44, 2, -2560, -16777216);
      }

      mFont.b(mFont.d, var1, Caption.eK, this.width / 2, 57, 2, -2560, -16777216);
   }

   public void b() {
   }

   public static void e() {
      if (!(GameSrc.gI().cE instanceof LangLa_lw)) {
         (new Message((byte)48)).send();
      }
   }

   public static void f() {
      if (!(GameSrc.gI().cE instanceof LangLa_lw)) {
         (new Message((byte)49)).send();
      }
   }
}
