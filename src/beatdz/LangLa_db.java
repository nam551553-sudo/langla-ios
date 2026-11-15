package beatdz;
 class LangLa_db implements Runnable {
   public void run() {
      while(!LangLa_ep.a()) {
         try {
            synchronized(beatdz.LangLa_cz.$state_LangLa_cz().cT) {
               try {
                  while (beatdz.LangLa_cz.$state_LangLa_cz().cW.isEmpty()) beatdz.LangLa_cz.$state_LangLa_cz().cT.wait(1000L);
               } catch (Exception var4) {
                  Utlis.println(var4);
               }
            }

            while(beatdz.LangLa_cz.$state_LangLa_cz().cW.size() > 0) {
               LangLa_cz.a((LangLa_fb)beatdz.LangLa_cz.$state_LangLa_cz().cW.remove(0));
            }

            synchronized(beatdz.LangLa_cz.$state_LangLa_cz().cU) {
               beatdz.LangLa_cz.$state_LangLa_cz().cU.notifyAll();
            }
         } catch (Exception var6) {
            Utlis.println(var6);
         }
      }

      beatdz.LangLa_cz.$state_LangLa_cz().cY = false;
   }
}
