package beatdz;
   public class TRecvMessage extends Thread {
   
    public Session a;

    public TRecvMessage(Session var1) {
      this.a = var1;
   }

   public void run() {
      while(this.a.isConnected) {
         try {
            if (this.a.reader != null) {
               boolean var1 = false;
               this.a.waitThreadRecv = false;
               Session.a(this.a, this.a.reader, false);
            } else {
               Utlis.sleep(500L);
            }
         } catch (Exception var2) {//var2.printStackTrace();
            this.a.close();
            Thread.currentThread().interrupt();
         }
      }

   }
}
