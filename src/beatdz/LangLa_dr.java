package beatdz;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.audio.AudioDevice;
import com.badlogic.gdx.utils.Disposable;

public class LangLa_dr implements Disposable {
   private int a = 8000;
   private AudioDevice b;
   private short[] c;
   
   

   public LangLa_dr(short[] var1) {
      beatdz.LangLa_dr.$state_LangLa_dr().d = this;
      this.b = Gdx.audio.newAudioDevice(2000, true);
      this.c = var1;
   }

   public void dispose() {
      try {
         if (Gdx.app.getType() != ApplicationType.iOS) {
            beatdz.LangLa_dr.$state_LangLa_dr().e = false;
            if (this.b != null) {
               this.b.dispose();
            }
         }

      } catch (Exception var1) {
      }
   }

   
   static short[] a(LangLa_dr var0) {
      return var0.c;
   }

   
   static AudioDevice b(LangLa_dr var0) {
      return var0.b;
   }

   
   static boolean a(boolean var0) {
      beatdz.LangLa_dr.$state_LangLa_dr().e = true;
      return true;
   }

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public LangLa_dr d;
public boolean e;
public void initialize() {
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.LangLa_dr");
public static SessionState $state_LangLa_dr() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
