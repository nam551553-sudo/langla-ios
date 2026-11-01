package beatdz;import com.tgame.model.Caption;

 class LangLa_fh implements Runnable {
   public void run() {
      try {
         for(int var1 = 0; var1 < DataCenter.gI().ai.size(); ++var1) {
            String var2 = (String)DataCenter.gI().ai.get(var1);
            StringBuilder var10000 = (new StringBuilder()).append(DataCenter.gI().aU).append("img/zoom");
            DataCenter.gI();
            AssetArchives.download(var10000.append(DataCenter.a(var2) + 1).append("/").append(var2).toString(), true);
         }

         beatdz.LangLa_cz.$state_LangLa_cz().cZ = false;
         Binary.writeBoolean("arr_full", true);
         DataCenter.gI().a(false);
         beatdz.DataCenter.$state_DataCenter().bd = 1;
         Caption.loadVN();
         GameSrc var5 = GameSrc.gI();

         try {
            var5.al.a(var5.mapID);
         } catch (Exception var3) {
         }

         DataCenter.gI().aH = false;
      } catch (Exception var4) {
         com.badlogic.gdx.Gdx.app.error("Assets", "Bulk assets incomplete; individual image loading remains available", var4);
      } finally {
         beatdz.LangLa_cz.$state_LangLa_cz().cZ = false;
      }
   }
}
