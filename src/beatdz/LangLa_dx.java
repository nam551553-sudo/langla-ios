package beatdz;
import com.listener.VoiceRecordCallback;

 class LangLa_dx implements VoiceRecordCallback {
   
   LangLa_dw a;

   LangLa_dx(LangLa_dw var1) {
      this.a = var1;
   }

   public void a(short[] var1) {
      if (var1 != null) {
         (new Thread(new LangLa_dy(this, var1))).start();
      }

   }
}
