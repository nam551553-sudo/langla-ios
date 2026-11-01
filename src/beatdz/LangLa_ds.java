package beatdz;
public class LangLa_ds implements Runnable {
   
   LangLa_dr a;

   public LangLa_ds(LangLa_dr var1) {
      this.a = var1;
   }

   public void run() {
      if (LangLa_dr.a(this.a) != null) {
         try {
            LangLa_dr.b(this.a).setVolume(1.0F);
            LangLa_dr.a(true);
            LangLa_dr.b(this.a).writeSamples(LangLa_dr.a(this.a), 0, LangLa_dr.a(this.a).length);
            this.a.dispose();
            return;
         } catch (Exception var1) {
         }
      }

   }
}
