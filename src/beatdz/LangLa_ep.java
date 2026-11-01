package beatdz;
public class LangLa_ep {
   public int a;
   public boolean b;
   public boolean c;
   public boolean d;
   public boolean e;
   public boolean f;
   

   public static boolean a() {
      return mConfig.gI().readByte(18) > 1;
   }

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public int g;
public void initialize() {
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.LangLa_ep");
public static SessionState $state_LangLa_ep() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
