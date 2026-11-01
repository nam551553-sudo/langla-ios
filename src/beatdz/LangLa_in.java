package beatdz;
public class LangLa_in extends LangLa_ii {
   private LangLa_ii p;

   public LangLa_in(byte var1, int var2, int var3, int var4, int var5, int var6, int var7, LangLa_ii var8) {
      super((byte)1, var2, var3, var4, var5, var6, 1);
      this.p = var8;
   }

   public void a() {
      super.a();
   }

   public void a(int var1, int var2) {
      super.a(var1, var2);
      this.p.a(var1, var2);
   }

   public void b(int var1, int var2) {
      super.b(var1, var2);
      this.p.b(var1, var2);
      this.l = -1;
   }

   public void c(int var1, int var2) {
      super.a(var1, var2);
      this.p.a(var1, var2);
      this.l = -1;
   }
}
