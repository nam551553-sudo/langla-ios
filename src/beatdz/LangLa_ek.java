package beatdz;
import java.util.Comparator;

public class LangLa_ek {
   public int a;
   public int b;
   public int c;
   public String d;
   public int e;
   public int f;
   public String[] g;
   

   public LangLa_ek() {
   }

   public LangLa_ek(int var1, String var2, int var3, int var4, int var5, int var6) {
      this.a = var1;
      this.b = var3;
      this.c = var4;
      this.d = var2;
      this.e = var5;
      this.f = var6;
   }

   public boolean a() {
      return Utlis.d(this.b, this.c);
   }

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public Comparator h;
public void initialize() {
this.h = new LangLa_el();
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.LangLa_ek");
public static SessionState $state_LangLa_ek() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
