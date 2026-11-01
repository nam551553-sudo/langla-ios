package beatdz;
 public class LangLa_ez implements Runnable {
   
  public   LangLa_fb a;
   
  public   CheckVersionScreen b;

   public  LangLa_ez(CheckVersionScreen var1, LangLa_fb var2) {
      this.b = var1;
      this.a = var2;
   }

   public void run() {
      try {
         byte[] var1;
         if ((var1 = Binary.c(DataCenter.gI().aU + this.a.d)) == null) {
            if ("arr_data_game.bin".equals(this.a.d)) {
               var1 = Binary.c(DataCenter.gI().aU + "arr_data_game.beatdz");
            }
         }
         if (var1 == null) {
            Utlis.sleep(1000L);
            if ((var1 = Binary.c(DataCenter.gI().aU + this.a.d)) == null) {
               Utlis.sleep(1000L);
               if ((var1 = Binary.c(DataCenter.gI().aU + this.a.d)) == null) {
                  CheckVersionScreen.a(this.b);
                  return;
               }
            }
         }

         if (!Binary.readBoolan("arr_savemap")) {
            Binary.write(this.a.e, var1);
         }

         Binary.writeInt("arr_check_" + this.a.a, var1.length);
         DataCenter.gI().readArrDataGame(true);
         this.a.f = true;
         CheckVersionScreen.b(this.b);
      } catch (Exception var2) {
         CheckVersionScreen.a(this.b);
         CheckVersionScreen.c(this.b).clear();
         beatdz.CheckVersionScreen.$state_CheckVersionScreen().d = true;
      }
   }
}
