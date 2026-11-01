package beatdz;
  public class RWaitTimeOut implements Runnable {
   
   public  Session a;

  public RWaitTimeOut(Session var1) {
      this.a = var1;
   }

   public void run() {
      try {
         synchronized(this.a.lockTimeOut) {
            try {
               this.a.lockTimeOut.wait(20000L);
            } catch (Exception var3) {
               Utlis.println(var3);
            }
         }

         if (this.a.isConnecting) {
            this.a.close();
         }

      } catch (Exception var5) {
         Thread.currentThread().interrupt();
      }
   }
}
