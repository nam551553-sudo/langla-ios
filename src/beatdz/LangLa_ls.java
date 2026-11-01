package beatdz;
public class LangLa_ls extends Entity {
   public int j;
   public int k;
   public int l;

   public LangLa_ls(Entity var1) {
      this.setXY(var1.cx, var1.cy);
      this.k = var1.dir;
      this.j = 100;
      this.l = 553;
   }

   public void a(Graphics var1) {
      var1.d(this.j);
      LangLa_fq.b(var1, this.l, 0, this.cx, this.cy, 3);
      var1.m = 1.0F;
   }

   public int a() {
      return 0;
   }

   public int b() {
      return 0;
   }

   public int c() {
      return 0;
   }

   public int d() {
      return 0;
   }

   public void o() {
      if (this.j > 0) {
         if (Utlis.time() % 2L == 1L) {
            this.j -= 2;
            return;
         }
      } else {
         this.h.remove(this);
      }

   }

   public String f() {
      return null;
   }

   public String g() {
      return null;
   }

   public String h() {
      return null;
   }

   public void b(Graphics var1) {
   }

   public int e() {
      return 4;
   }
}
