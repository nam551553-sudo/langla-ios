package beatdz;
 class LangLa_cc implements Runnable {
   
   LangLa_kt a;

   LangLa_cc(LangLa_kt var1) {
      this.a = var1;
   }

   public void run() {
      Message var1 = null;

      try {
         (var1 = LangLa_kt.d()).createSession();
         return;
      } catch (Exception var5) {
         Utlis.println(var5);
      } finally {
         if (var1 != null) {
            var1.close();
         }

      }

   }
}
