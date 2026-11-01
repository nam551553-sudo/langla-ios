package beatdz;
 class LangLa_fg implements Runnable {
   public void run() {
      while(!LangLa_ep.a()) {
         try {
            synchronized(beatdz.LangLa_cz.$state_LangLa_cz().cU) {
               try {
                  while (beatdz.LangLa_cz.$state_LangLa_cz().cX.isEmpty()) beatdz.LangLa_cz.$state_LangLa_cz().cU.wait(1000L);
               } catch (Exception var3) {
                  Utlis.println(var3);
               }
            }

            while(beatdz.LangLa_cz.$state_LangLa_cz().cX.size() > 0) {
               LangLa_cz.b((LangLa_fb)beatdz.LangLa_cz.$state_LangLa_cz().cX.remove(0));
            }
         } catch (Exception var5) {
            Utlis.println(var5);
         }
      }

      beatdz.LangLa_cz.$state_LangLa_cz().cY = false;
   }
}
