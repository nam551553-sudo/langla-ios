package beatdz;
public class LangLa_mh extends mTextBox {
   
   LoginPCScreen x;

   public LangLa_mh(LoginPCScreen var1, int var2, int var3, int var4, String var5, LangLa_cx var6, int var7, int var8) {
      super(var2, var3, 122, var5, var6, -11, 0);
      this.x = var1;
   }

   public void g() {
      LoginPCScreen var10000 = this.x;
      String var2 = LoginPCScreen.a(this.x).f();
      LoginPCScreen var1 = var10000;

      for(int var3 = 0; var3 < var1.c.size(); ++var3) {
         String[] var4;
         if ((var4 = (String[])((String[])var1.c.elementAt(var3)))[0].equals(var2)) {
            var1.b.a(var4[1]);
            return;
         }
      }

   }
}
