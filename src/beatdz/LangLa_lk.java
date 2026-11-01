package beatdz;
import java.util.Comparator;
import java.util.Vector;

public class LangLa_lk {
   public int a;
   public String b;
   public Vector c;
   

   public LangLa_lk(int var1, String var2) {
      this.a = var1;
      this.b = var2;
   }

   public LangLa_lk(int var1, String var2, Vector var3) {
      this.a = 1;
      this.b = var2;
      this.c = var3;
   }

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public Comparator d;
public void initialize() {
this.d = new LangLa_ll();
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.LangLa_lk");
public static SessionState $state_LangLa_lk() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
