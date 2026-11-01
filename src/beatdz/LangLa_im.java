package beatdz;
public class LangLa_im extends LangLa_ii {
   private int w;
   private int x;
   private int y;
   private int z;
   private int A;
   public int p;
   public int q;
   public int r;
   public int s;
   public int t = -1;
   public int u = -1;
   public int v = -1;

   public LangLa_im(byte var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      super(var1, var2, var3, var4, var5, var6, var7);
      this.a(0, var6, var7);
   }

   public void a(int var1, int var2, int var3) {
      this.g = var1;
      if (this.n == 1) {
         this.d(0, 0);
         this.f(1, var3);
      } else if (this.n == 0) {
         this.d(1, var2);
         this.f(0, 0);
      } else {
         if (this.n == 2) {
            this.d(1, var2);
            this.f(1, var3);
         }

      }
   }

   public void a() {
      try {
         super.a();
         if (this.s < this.z / this.q) {
            this.s = this.z / this.q;
         }

         if (this.s > this.A / this.q) {
            this.s = this.A / this.q;
         }

         this.y = this.s * this.q;
         if (this.y < this.z) {
            this.y = this.z;
         }

         if (this.y > this.A) {
            this.y = this.A;
         }

         if (this.p != this.y) {
            this.w = this.y - this.p << 2;
            this.x += this.w;
            this.p += this.x >> 4;
            this.x &= 15;
         }

      } catch (Exception var1) {
      }
   }

   public void a(int var1, int var2) {
      this.k = this.t = -1;
      this.d();
      this.m = this.j;
      this.v = this.s;
      if (this.h != 0) {
         this.l = (this.f + var1) / this.h;
      }

      if (this.q != 0) {
         this.u = (this.x + var2) / this.q;
      }

   }

   public void b(int var1, int var2) {
      if (this.h != 0) {
         this.j = this.m - var1 / this.h;
      }

      if (this.q != 0) {
         this.s = this.v - var2 / this.q;
      }

   }

   public void c(int var1, int var2) {
      this.d();
      if (!Utlis.inRange(0, 0, this.width, this.height, var1, var2)) {
         this.k = this.l = -1;
         this.t = this.u = -1;
      } else if (this.m == this.j && this.v == this.s) {
         if (this.h != 0 && this.l < this.i && this.l == (this.f + var1) / this.h || this.q != 0 && this.u < this.r && this.u == (this.p + var2) / this.q) {
            this.k = this.l;
            this.t = this.u;
         }
      } else {
         this.k = this.t = -1;
      }

      if (this.k >= 0 && this.t >= 0) {
         LangLa_dp.a().h();
      }

   }

   public boolean b() {
      if (this.m == this.j && this.v == this.s) {
         this.m = this.l = -1;
         this.v = this.u = -1;
         return false;
      } else {
         this.m = this.l = -1;
         this.v = this.u = -1;
         return true;
      }
   }

   public void d() {
      try {
         super.d();
         if (this.s < 0) {
            this.s = 0;
         }

         if (this.s > this.A / this.q - 1) {
            this.s = this.A / this.q - 1;
         }

      } catch (Exception var1) {
      }
   }

   private void f(int var1, int var2) {
      this.q = var1;
      this.r = var2;
      if (this.height < var2 * var1) {
         this.z = -(var1 * this.g);
         this.A = var2 * var1 - this.height;
         if (this.A % var1 != 0) {
            this.A = this.A / var1 * var1 + var1;
         }

         this.A += var1 * this.g;
      } else {
         this.z = 0;
         this.A = var2 * var1 - this.height;
      }

      if (this.A < 0) {
         this.A = 0;
      }

   }

   public void a(Graphics var1, int var2, int var3, int var4, int var5) {
      super.a(var1, var2, var3, var4, var5);
      if (this.n == 2) {
         var1.a(-this.f, -this.p);
      }

   }
}
