package beatdz;

import java.util.Comparator;

public class XYEntity {

    
    
    public short cx;
    public short cy;

    public static XYEntity create(int var0, int var1) {
        XYEntity var2;
        (var2 = new XYEntity()).setXY(var0, var1);
        return var2;
    }

    public void setXY(int var1, int var2) {
        this.cx = (short) var1;
        this.cy = (short) var2;
    }

    public int getRe() {
        return Utlis.getRange(this, Char.gI());
    }
    
    public String xySTR()
    {
        return cx+", "+cy;
    }

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public Comparator da;
public Comparator db;
public void initialize() {
this.da = new LangLa_fj();
this.db = new LangLa_fk();
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.XYEntity");
public static SessionState $state_XYEntity() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
