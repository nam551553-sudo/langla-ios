package beatdz;
public class LangLa_ij extends LangLa_ii {
   public int p = -1;
   public int q;
   public int r;

   public LangLa_ij(byte var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      super(var1, var2, var3, var4, var5, var6, var7);
      this.q = var6;
      this.r = var8;
   }

   public void a(int var1, int var2) {
      this.k = -1;
      this.d();
      this.m = this.j;
      if (this.n == 1 && this.h != 0) {
         this.l = (this.f + var2) / this.h;
         this.p = var1 / this.h + (var2 + this.f) / this.h * (this.width / this.h);
      } else {
         if (this.n == 0 && this.h != 0) {
            this.l = (this.f + var1) / this.h;
            this.p = var2 / this.h * this.i + this.l;
         }

      }
   }

   public void c(int var1, int var2) {
      this.d();
      if (!Utlis.inRange(0, 0, this.width, this.height, var1, var2)) {
         this.k = -1;
         this.l = -1;
      } else if (this.m != this.j) {
         this.k = -1;
      } else if (this.n == 1 && this.h != 0 && this.l < this.i && this.l == (this.f + var2) / this.h || this.n == 0 && this.h != 0 && this.l < this.i && this.l == (this.f + var1) / this.h) {
         this.k = this.l;
      }

      this.k = this.p;
      int var3 = -1;
      if (this.n == 1 && this.h != 0) {
         var3 = var1 / this.h + (var2 + this.f) / this.h * (this.width / this.h);
      } else if (this.n == 0 && this.h != 0) {
         var3 = var2 / this.h * this.i + this.l;
      }

      if (this.p != var3) {
         this.k = this.p = -1;
      }

      if (this.k >= 0) {
         LangLa_dp.a().h();
      }

   }

   public void d() {
      try {
         if (this.j < 0) {
            this.j = 0;
         }

         if (this.j > this.e / this.h - 1) {
            this.j = this.e / this.h - 1;
         }

         if (this.n == 1 && this.h != 0 && this.r <= 0) {
            this.j = 0;
         }

      } catch (Exception var2) {
         Utlis.println(var2);
      }
   }
}
