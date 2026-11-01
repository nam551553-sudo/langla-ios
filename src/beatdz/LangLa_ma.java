package beatdz;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
public class LangLa_ma implements Runnable {
   
 public  Message a;
   
 public  GameSrc b;

 public  LangLa_ma(GameSrc var1, Message var2) {
      this.b = var1;
      this.a = var2;
   }

   public void run() {
      try {
         byte[] var1;
         if ((var1 = Utlis.j(this.a.reader.readUTF())) != null) {
            short[] var2 = new short[var1.length / 2];
            ByteBuffer.wrap(var1).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(var2);
            LangLa_dr var4 = new LangLa_dr(var2);
            (new Thread(new LangLa_ds(var4))).start();
         }

      } catch (Exception var3) {
         Utlis.println(var3);
      }
   }
}
