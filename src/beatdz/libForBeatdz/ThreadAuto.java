package beatdz.libForBeatdz;

import java.util.Hashtable;

public class ThreadAuto {

    

    public static void stop(String name) {
        if (beatdz.libForBeatdz.ThreadAuto.$state_ThreadAuto().hash.containsKey(name)) {
            Thread thread = (Thread) beatdz.libForBeatdz.ThreadAuto.$state_ThreadAuto().hash.get(name);
            try {
                thread.interrupt();
            } catch (Exception ex) {

            }

            ////System.out.println("ThreadAuto stop ["+name+"] = "+thread.getName());
            beatdz.libForBeatdz.ThreadAuto.$state_ThreadAuto().hash.remove(name);
        }
    }

    public static void start(String name, Runnable run) {
        if (!beatdz.libForBeatdz.ThreadAuto.$state_ThreadAuto().hash.containsKey(name) || !((Thread) beatdz.libForBeatdz.ThreadAuto.$state_ThreadAuto().hash.get(name)).isAlive()) {
            Thread thread = new Thread(run, name);
            thread.start();
            System.out.println("ThreadAuto open [" + name + "] = " + thread.getName());
            beatdz.libForBeatdz.ThreadAuto.$state_ThreadAuto().hash.put(name, thread);
        }

    }

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public Hashtable hash;
public void initialize() {
this.hash = new Hashtable();
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.libForBeatdz.ThreadAuto");
public static SessionState $state_ThreadAuto() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
