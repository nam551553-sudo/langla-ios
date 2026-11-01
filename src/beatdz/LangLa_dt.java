package beatdz;
import com.badlogic.gdx.audio.AudioRecorder;
import com.badlogic.gdx.utils.Disposable;
import com.listener.VoiceRecordCallback;
import com.listener.VoiceRecordPermissionCallback;
import com.tgame.model.Caption;
import java.io.IOException;
import java.util.Arrays;

public class LangLa_dt implements Disposable {
   private int f = 8000;
   AudioRecorder a;
   
   
   private int g;
   public boolean d;
   
   
   VoiceRecordCallback e;

   public static boolean a() {
      if (beatdz.LangLa_dt.$state_LangLa_dt().i == 0) {
         boolean var0;
         if (var0 = AppListener.gI().app.b()) {
            beatdz.LangLa_dt.$state_LangLa_dt().i = 1;
         } else {
            beatdz.LangLa_dt.$state_LangLa_dt().i = 2;
         }

         return var0;
      } else {
         return beatdz.LangLa_dt.$state_LangLa_dt().i == 1;
      }
   }

   public static LangLa_dt b() {
      if (beatdz.LangLa_dt.$state_LangLa_dt().h == null) {
         beatdz.LangLa_dt.$state_LangLa_dt().h = new LangLa_dt();
      }

      return beatdz.LangLa_dt.$state_LangLa_dt().h;
   }

   public void c() {
      boolean var1 = false;
      boolean var6 = false;

      label107: {
         label102: {
            try {
               var6 = true;
               if (GameSrc.gI().ck <= 0L) {
                  var6 = false;
                  break label102;
               }

               if (Utlis.time() - GameSrc.gI().ck >= 1000L) {
                  var1 = true;
                  this.g = (int)((Utlis.time() - GameSrc.gI().ck) / 1000L) + 2;
                  this.d();
                  var6 = false;
                  break label102;
               }

               if (beatdz.LangLa_dt.$state_LangLa_dt().c.length() > 0) {
                  if (AppListener.gI().app.b()) {
                     GameSrc.gI().showMessage(Caption.pY, -1);
                     var6 = false;
                  } else {
                     var6 = false;
                  }
               } else {
                  var6 = false;
               }
            } catch (Exception var7) {
               var6 = false;
               break label107;
            } finally {
               if (var6) {
                  if (!var1) {
                     this.g = 0;
                     this.d();
                  }

                  GameSrc.gI().ck = 0L;
                  LangLa_jh.a().c = true;
               }
            }

            this.g = 0;
            this.d();
            GameSrc.gI().ck = 0L;
            LangLa_jh.a().c = true;
            return;
         }

         if (!var1) {
            this.g = 0;
            this.d();
         }

         GameSrc.gI().ck = 0L;
         LangLa_jh.a().c = true;
         return;
      }

      if (!var1) {
         this.g = 0;
         this.d();
      }

      GameSrc.gI().ck = 0L;
      LangLa_jh.a().c = true;
   }

   public void dispose() {
      try {
         beatdz.LangLa_dt.$state_LangLa_dt().h = null;
         if (this.a != null) {
            this.a.dispose();
         }

      } catch (Exception var1) {
      }
   }

   private void d() {
      try {
         this.d = false;
         if (this.a != null) {
            this.a.dispose();
            this.a = null;
         } else {
            this.dispose();
         }
      } catch (Exception var1) {
      }
   }

   public static void a(boolean var0, String var1) {
      beatdz.LangLa_dt.$state_LangLa_dt().c = var1;
      beatdz.LangLa_dt.$state_LangLa_dt().b = Utlis.time();
      a(var0);
   }

   public static void a(boolean var0) {
      if (beatdz.LangLa_dt.$state_LangLa_dt().h != null) {
         beatdz.LangLa_dt.$state_LangLa_dt().h.dispose();
      }

      b().b(var0);
   }

   private void b(boolean var1) {
      if (GameSrc.gI().ck != 0L) {
         try {
            AppListener.gI().app.a((VoiceRecordPermissionCallback)(new LangLa_dw(this, var1)));
         } catch (Exception var3) {
            GameSrc.gI().showMessage(Caption.pX, -65536);
            this.dispose();
         }
      }
   }

   
   static void a(LangLa_dt var0, short[] var1, boolean var2) {
      var2 = var2;
      var1 = var1;
      var0 = var0;

      try {
         if (var2) {
            var0.d = false;
            var1 = Arrays.copyOf(var1, 8000 * var0.g);
            if (var0.e != null) {
               var0.e.a(var1);
               return;
            }
         }

         var0.dispose();
      } catch (Exception var3) {
      }
   }

   
   static AudioRecorder a(LangLa_dt var0) {
      return var0.a;
   }

   
   static boolean b(LangLa_dt var0) {
      return var0.d;
   }

   
   static boolean a(LangLa_dt var0, boolean var1) {
      return var0.d = false;
   }

   
   static int c(LangLa_dt var0) {
      return var0.g;
   }

   
   static void b(LangLa_dt var0, boolean var1) throws IOException {
      boolean var2 = var1;
      Message var3;
      (var3 = Message.c((byte)-33)).writeBoolean(var2);
      var3.send();
   }

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public long b;
public String c;
public LangLa_dt h;
public int i;
public void initialize() {
this.c = "";
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.LangLa_dt");
public static SessionState $state_LangLa_dt() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
