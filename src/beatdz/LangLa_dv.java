package beatdz;
import com.badlogic.gdx.audio.AudioRecorder.AudioRecorderDataDelegate;

 class LangLa_dv implements AudioRecorderDataDelegate {
   
   LangLa_du a;

   LangLa_dv(LangLa_du var1) {
      this.a = var1;
   }

   public void didFinishRecording(short[] var1, boolean var2) {
      LangLa_dt.a(this.a.a, var1, var2);
   }
}
