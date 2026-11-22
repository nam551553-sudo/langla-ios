package beatdz;import beatdz.*;

public class LangLa_gg {
   public boolean a = true;
   public int b;
   public int c;
   private int g;
   public int d;
   private int h;
   private int i;
   
   public boolean f;

   public LangLa_gg(MainScreen var1) {
      beatdz.LangLa_gg.$state_LangLa_gg().e = Binary2.a("n", var1);
   }

   public void a(int var1, int var2) {
      int var3 = var1 + GameSrc.gI().Task + GameSrc.gI().idStep;
      if (this.d == 2) {
         var3 = var1 + GameSrc.gI().Task + GameSrc.gI().idStep + GameSrc.gI().idRequire;
      }

      if (this.g != var3 && (GameSrc.gI().Task <= 12 || GameSrc.gI().Task == 14) && (GameSrc.gI().Task != this.d || GameSrc.gI().idStep != this.h || GameSrc.gI().Task == 2 && GameSrc.gI().idRequire != this.i || GameSrc.gI().Task == this.d && GameSrc.gI().idStep == this.h && this.b != var1 && this.c != var2)) {
         this.f = true;
         this.g = var3;
         this.d = GameSrc.gI().Task;
         this.h = GameSrc.gI().idStep;
         this.i = GameSrc.gI().idRequire;
      }

      this.b = var1;
      this.c = var2;
   }

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public mImage e;
public void initialize() {
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.LangLa_gg");
public static SessionState $state_LangLa_gg() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
