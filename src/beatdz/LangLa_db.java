package beatdz;
 class LangLa_db implements Runnable {
   public void run() {
      LangLa_cz.SessionState state = LangLa_cz.$state_LangLa_cz();
      while (!LangLa_ep.a()) {
         try {
            synchronized (state.cT) {
               if (state.cW.isEmpty()) state.cT.wait(1000L);
            }
            LangLa_fb request;
            while (!LangLa_ep.a() && (request = state.cW.pollFirst()) != null) {
               LangLa_cz.a(request);
            }
            synchronized (state.cU) {
               state.cU.notifyAll();
            }
         } catch (InterruptedException interrupted) {
            Thread.currentThread().interrupt();
            break;
         } catch (RuntimeException failed) {
            Utlis.println(failed);
         }
      }
      state.cY = false;
   }
}
