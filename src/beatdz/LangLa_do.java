package beatdz;
 public  class LangLa_do implements Runnable {
   
   public  LangLa_fb a;
   
   public  CheckVersionScreen b;

   public LangLa_do(CheckVersionScreen var1, LangLa_fb var2) {
      this.b = var1;
      this.a = var2;
   }

   public void run() {
      try {
         StringBuilder var10000 = (new StringBuilder()).append(DataCenter.gI().aU).append(DataCenter.gI().aY);
         DataCenter.gI();
         String url = var10000.append(DataCenter.a(this.a.d) + 1).append("/").append(this.a.d).toString();
         int downloaded = -1;
         for (int attempt = 0; attempt < 3; attempt++) {
            try { downloaded = AssetArchives.download(url, false); break; }
            catch (java.io.IOException error) { if (attempt == 2) throw error; Utlis.sleep(1000L); }
         }
         if (this.a.d.contains("Client")) {
            LangLa_fq.b();
         } else if (this.a.d.contains("Char")) {
            LangLa_fq.a();
         } else if (this.a.d.contains("font")) {
            mFont.a();
         }

         Binary.writeInt("arr_check_" + this.a.a, downloaded);
         this.a.f = true;
         CheckVersionScreen.b(this.b);
      } catch (Exception var2) {
         CheckVersionScreen.a(this.b);
         CheckVersionScreen.c(this.b).clear();
         beatdz.CheckVersionScreen.$state_CheckVersionScreen().d = true;
      }
   }
}
