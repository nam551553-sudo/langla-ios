package beatdz;
 class LangLa_dj implements Runnable {
   
   Canvas a;

   LangLa_dj(Canvas var1) {
      this.a = var1;
   }

   public void run() {
      try {
         while(Canvas.a(this.a)) {
            Canvas.a(this.a, false);
         }

      } catch (Exception var2) {
         Utlis.println(var2);
      }
   }
}
