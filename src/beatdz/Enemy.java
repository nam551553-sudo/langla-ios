package beatdz;
import java.util.Comparator;

public class Enemy {
   
   public String b;
   public boolean c;

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public Comparator a;
public void initialize() {
this.a = new LangLa_hu();
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.Enemy");
public static SessionState $state_Enemy() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
