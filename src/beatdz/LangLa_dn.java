package beatdz;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Input.TextInputListener;
import com.badlogic.gdx.utils.StringBuilder;

 class LangLa_dn implements TextInputListener {
   
   mTextBox a;

   LangLa_dn(mTextBox var1) {
      this.a = var1;
   }

   public void input(String var1) {
      if (Gdx.app.getType() == ApplicationType.Android && !var1.equals(this.a.f())) {
         StringBuilder var4 = new StringBuilder();

         for(int var5 = 0; var5 < var1.length(); ++var5) {
            int var3 = -1;
            int var2 = -1;

            int var6;
            for(var6 = 0; var6 < Binary2.a().length; ++var6) {
               if (var1.charAt(var5) == Binary2.a()[var6]) {
                  var2 = var6;
                  break;
               }
            }

            try {
               if (var2 >= 0) {
                  for(var6 = 0; var6 < Binary2.b().length; ++var6) {
                     if (var1.charAt(var5 + 1) == Binary2.b()[var6]) {
                        var3 = var6;
                     }
                  }
               }

               if (var2 != -1 && var3 != -1) {
                  var4.append(Binary2.c()[var2][var3]);
                  ++var5;
               } else {
                  var4.append(var1.charAt(var5));
               }
            } catch (Exception var8) {
               var4.append(var1.charAt(var1.length() - 1));
            }
         }

         var1 = var4.toString();
      }

      this.a.a(var1);
      if (this.a.q) {
         GameSrc.gI();
         mTextBox var9 = this.a;

         try {
            if ((var1 = var9.f()).length() > 0) {
               var9.a("");
               GameSrc.a(var1);
            }

            return;
         } catch (Exception var7) {
            Utlis.println(var7);
         }
      }

   }

   public void canceled() {
   }
}
