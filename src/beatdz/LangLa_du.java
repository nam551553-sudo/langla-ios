package beatdz;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Application.ApplicationType;
import java.util.Vector;

 class LangLa_du implements Runnable {
   
   LangLa_dt a;

   LangLa_du(LangLa_dt var1) {
      this.a = var1;
   }

   public void run() {
      try {
         if (Gdx.app.getType() != ApplicationType.iOS) {
            Vector var1 = new Vector();
            int var2 = 0;

            short[] var3;
            while(LangLa_dt.b(this.a)) {
               try {
                  if (GameSrc.gI().ck == 0L) {
                     LangLa_dt.a(this.a, false);
                     break;
                  }

                  var3 = new short[4000];
                  LangLa_dt.a(this.a).read(var3, 0, 4000);
                  var1.add(var3);
                  var2 += 4000;
               } catch (Exception var6) {
               }
            }

            var3 = new short[var2];
            var2 = 0;

            for(int var4 = 0; var4 < var1.size(); ++var4) {
               for(int var5 = 0; var5 < ((short[])var1.get(var4)).length; ++var5) {
                  var3[var2] = ((short[])var1.get(var4))[var5];
                  ++var2;
               }
            }

            LangLa_dt.a(this.a, var3, true);
            return;
         }

         Gdx.app.error("Audio", "iOS recording requires a native recording implementation");
      } catch (Exception var7) {
      }

   }
}
