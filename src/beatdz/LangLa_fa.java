package beatdz;
public class LangLa_fa {
   public int a;
   public String b;
   public String c = "";
   public String d;
   public boolean e;
   public LangLa_gl f;

   public LangLa_fa(int var1, String var2, String var3) {
      this.a = var1;
      this.b = var2;
      this.d = var3;
      if (var1 == 0 || var2.equals(Char.gI().name)) {
         this.e = true;
      }

   }

   public LangLa_fa(int var1, String var2, String var3, String var4) {
      this.a = var1;
      this.b = var2;
      this.d = var3;
      this.c = var4;
      if (var1 == 0 || var4.length() == 0 || var2.equals(Char.gI().name)) {
         this.e = true;
      }

   }
}
