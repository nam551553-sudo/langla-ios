package beatdz;
import com.tgame.model.Caption;

public class LangLa_bl extends LangLa_fo {
   

   public static LangLa_bl e() {
      return beatdz.LangLa_bl.$state_LangLa_bl().a;
   }

   public void a(int var1, Object var2) {
   }

   public void a(int var1, Object var2, LangLa_cy var3) {
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      switch(var1.b) {
      case 1002:
         throw null;
      case 1003:
         this.cL = a(Caption.O, Caption.Z, this, this.width / 2 - 100, this.height / 2 - 75);
         return;
      default:
      }
   }

   public void a(Graphics var1) {
      this.a(var1, this.cx, this.cy, this.width, this.height, Caption.U, (byte)2, true);
      mFont var10000 = mFont.d;
      String var10002 = Caption.qR[0];
      boolean var10003 = true;
      throw null;
   }

   public void b() {
   }

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public LangLa_bl a;
public void initialize() {
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.LangLa_bl");
public static SessionState $state_LangLa_bl() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
