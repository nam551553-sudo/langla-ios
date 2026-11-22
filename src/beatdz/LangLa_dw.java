package beatdz;
import com.badlogic.gdx.Gdx;
import com.listener.VoiceRecordPermissionCallback;

 class LangLa_dw implements VoiceRecordPermissionCallback {
   
   boolean a;
   
   LangLa_dt b;

   LangLa_dw(LangLa_dt var1, boolean var2) {
      this.b = var1;
      this.a = var2;
   }

   public void a() {
      LangLa_dt var10000 = LangLa_dt.b();
      LangLa_dx var2 = new LangLa_dx(this);
      LangLa_dt var1 = var10000;
      if (!var10000.d) {
         var1.a = Gdx.audio.newAudioRecorder(2000, true);
         var1.e = var2;
         var1.d = true;
         (new Thread(new LangLa_du(var1))).start();
      }

   }
}
