package beatdz;
import java.util.Comparator;

public class LangLa_hb {
   public int a;
   public String b;
   public int c;
   public int d;
   public int e;
   public int f;
   

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public Comparator g;
public void initialize() {
this.g = new LangLa_hc();
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.LangLa_hb");
public static SessionState $state_LangLa_hb() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
