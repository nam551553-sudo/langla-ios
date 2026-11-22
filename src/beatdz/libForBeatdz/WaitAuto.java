package beatdz.libForBeatdz;

import java.util.ArrayList;
import java.util.Hashtable;

public class WaitAuto {

    

    public static Wait get(String name, boolean b) {
        name = name.toLowerCase();
        if (beatdz.libForBeatdz.WaitAuto.$state_WaitAuto().hash.containsKey(name)) {
            Wait a = ((Wait) beatdz.libForBeatdz.WaitAuto.$state_WaitAuto().hash.get(name));
            a.debug = b;
            return a;
        }
        Wait a = new Wait(name, b);
        beatdz.libForBeatdz.WaitAuto.$state_WaitAuto().hash.put(name, a);
        return a;
    }

    public static Wait get(String name) {
        name = name.toLowerCase();
        if (beatdz.libForBeatdz.WaitAuto.$state_WaitAuto().hash.containsKey(name)) {
            return (Wait) beatdz.libForBeatdz.WaitAuto.$state_WaitAuto().hash.get(name);
        }
        Wait a = new Wait(name, false);
        beatdz.libForBeatdz.WaitAuto.$state_WaitAuto().hash.put(name, a);
        return a;
    }

    public static class Wait {

        public String name = "";
        public boolean debug = false;
        public long timeLast;
        public Object mydata;

        public Wait(String str) {
            name = str;
        }

        public Wait(String str, boolean debug) {
            name = str;
            this.debug = debug;
        }

        public Object wait = new Object();
        public boolean isWait = false;

        public boolean waitObject(long l) {
            mydata = null;
            //debug = true;
            if (debug) {
                System.out.println("Wait[" + name + "] waitObject() = [" + l + "], thread = " + Thread.currentThread().getName());
            }
            isWait = true;
            long lz = System.currentTimeMillis();
            synchronized (wait) {
                try {
                    wait.wait(l);
                } catch (Exception var3) {
                }
            }
            isWait = false;
            long newTime = timeLast = (System.currentTimeMillis() - lz);
            if (debug) {
                System.out.println(name + ": " + (newTime));
            }
            return newTime < l;
        }

        public void unlockObject() {
            if (isWait) {
                isWait = false;
                synchronized (wait) {
                    try {
                        wait.notifyAll();
                    } catch (Exception var3) {
                    }
                }
            }
        }    public void unlockObject(Object data) {
            if (isWait) {
                mydata = data;
                isWait = false;
                synchronized (wait) {
                    try {
                        wait.notifyAll();
                    } catch (Exception var3) {
                    }
                }
            }
        }

    }

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public Hashtable hash;
public void initialize() {
this.hash = new Hashtable();
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.libForBeatdz.WaitAuto");
public static SessionState $state_WaitAuto() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
