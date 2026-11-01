package beatdz;
 public class LangLa_mj implements Runnable {
   
  public  CheckVersionScreen a;

  public  LangLa_mj(CheckVersionScreen var1) {
      this.a = var1;
   }

   public void run() {
      CheckVersionScreen.d(this.a);
   }
}
