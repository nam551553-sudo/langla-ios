package beatdz;
import com.badlogic.gdx.Input.Keys;
import com.listener.IKeyboard;
import com.tgame.model.Caption;

 class LangLa_eb implements IKeyboard {
   
   LangLa_jz a;
   
   SettingsTab b;

   LangLa_eb(SettingsTab var1, LangLa_jz var2) {
      this.b = var1;
      this.a = var2;
   }

   public void a(mTextBox var1) {
   }

   public void b(mTextBox var1) {
      if (var1.f().trim() != "") {
         char var2;
         if ((var2 = var1.f().toUpperCase().charAt(0)) < 'A' || var2 > 'Z') {
            LangLa_jh.a().a(Caption.nT, mFont.d, -2560);
            return;
         }

         SettingsTab.b(this.b)[this.a.b] = (short)Keys.valueOf(var1.f().toUpperCase());
         LangLa_dz var10000 = SettingsTab.c(this.b)[this.a.b];
         String var3 = var1.f().toUpperCase();
         var10000.a = var3;
         SettingsTab.d(this.b);
         mInputProcessor.a(SettingsTab.b(this.b));
         SettingsTab.e(this.b);
      }

   }
}
