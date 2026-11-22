package beatdz.libForBeatdz;

import java.util.Arrays;
import java.util.Hashtable;

public class GetData {
    
    
    
    public static Data get(String name) {
        if (beatdz.libForBeatdz.GetData.$state_GetData().hash.containsKey(name)) {
            return (Data) beatdz.libForBeatdz.GetData.$state_GetData().hash.get(name);
        }
        Data a = new Data(name);
        beatdz.libForBeatdz.GetData.$state_GetData().hash.put(name, a);
        return a;
    }
    
    public static class Data {
        
        public String name = "";
        public Object[] array = null;
        public String[] text = null;
        public long timeStart = System.currentTimeMillis();
        
        public Data(String str) {
            name = str;
        }
        
        public Object wait = new Object();
        public boolean isWait = false;
        
        public Object[] waitObject(String[] arrazy, long l) {
         System.out.println(name + "waitObject(): " +Arrays.toString(arrazy)+", "+l);
            isWait = true;
            this.text = arrazy;
            synchronized (wait) {
                try {
                    wait.wait(l);
                } catch (Exception var3) {
                }
            }
            isWait = false;
            return array;
        }
        
        public void unlockObject(Object... arrayObject) {
          //  ////System.out.println(name + "unlockObject(): " +Arrays.toString(arrayObject));
            if (isWait) {
                array = arrayObject;
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
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.libForBeatdz.GetData");
public static SessionState $state_GetData() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
