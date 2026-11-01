package beatdz;
import java.util.Comparator;

public class Friend {
   
   public byte b;
   public String c;
   public boolean d;

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public Comparator a;
public void initialize() {
this.a = new LangLa_ic();
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.Friend");
public static SessionState $state_Friend() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
