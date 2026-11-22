package beatdz;
public class LangLa_lh {
   public int a;
   public int b;
   public boolean c;

   public LangLa_lh(int var1) {
      this.a = var1;
   }

   public DataTaskDay a() {
      return DataCenter.gI().DataTaskDay[this.a];
   }

   public boolean b() {
      return this.b >= this.a().c;
   }
}
