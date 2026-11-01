package beatdz;

import java.util.Arrays;

  public  class RSendMessage implements Runnable {
   
   public  Session a;

  public   RSendMessage(Session var1) {
      this.a = var1;
   }

   public void run() {
      while(this.a.isConnected) {
         try {
            boolean var3 = false;

            Session var10000;
            byte[] var1;
            for(this.a.waitThreadSend = false; this.a.vMessage.size() > 0; var10000.countSend += var1.length) {
               var1 = (byte[])((byte[])this.a.vMessage.firstElement());
               
            //   System.out.println("SEND: "+var1.length);
             //  System.out.println(Arrays.toString(var1));
               this.a.vMessage.removeElement(var1);
               byte[] var8 = var1;
               Writer var2 = this.a.writer;

               for(int var4 = 0; var4 < var8.length; ++var4) {
                  var2.dos.writeByte(var8[var4]);
               }

               this.a.writer.dos.flush();
               var10000 = this.a;
            }

            synchronized(this.a.lockSendMessage) {
               try {
                  this.a.lockSendMessage.wait(3600000L);
               } catch (Exception var5) {
                  Utlis.println(var5);
               }
            }
         } catch (Exception var7) {
            this.a.close();
            Thread.currentThread().interrupt();
         }
      }

   }
}
