package beatdz;
 class LangLa_kz implements Runnable {
   
   LoginPCScreen a;

   LangLa_kz(LoginPCScreen var1) {
      this.a = var1;
   }

   public void run() {
      Message var1 = null;

      try {
         (var1 = this.a.l()).createSession();
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
