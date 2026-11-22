package beatdz;
public class LangLa_eu {
   public Skill a;
   public Entity b;
   public LangLa_hm c;
   public int d;

   public LangLa_eu(Skill var1, Entity var2) {
      this.a = var1;
      this.b = var2;
      if (var1.idTemplate == 36) {
         this.d = 50;
         this.c = new LangLa_hm(390, 0, -18);
      } else {
         this.d = 20;
      }
   }

   public boolean a() {
      --this.d;
      return this.d <= 0;
   }
}
