package beatdz;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

 class LangLa_dy implements Runnable {
   
   short[] a;
   
   LangLa_dx b;

   LangLa_dy(LangLa_dx var1, short[] var2) {
      this.b = var1;
      this.a = var2;
   }

   public void run() {
      try {
         if (beatdz.LangLa_dt.$state_LangLa_dt().c.length() == 0 || LangLa_dt.c(this.b.a.b) == 0) {
            return;
         }

         byte[] var1;
         ByteBuffer.wrap(var1 = new byte[this.a.length * 2]).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().put(this.a);
         if (Utlis.a(var1, beatdz.LangLa_dt.$state_LangLa_dt().c)) {
            LangLa_dt.b(this.b.a.b, this.b.a.a);
         } else {
            Utlis.sleep(1000L);
            if (Utlis.a(var1, beatdz.LangLa_dt.$state_LangLa_dt().c)) {
               LangLa_dt.b(this.b.a.b, this.b.a.a);
            }
         }

         beatdz.LangLa_dt.$state_LangLa_dt().c = "";
      } catch (Exception var4) {
         return;
      } finally {
         this.b.a.b.dispose();
      }

   }
}
