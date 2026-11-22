package beatdz;
public class LangLa_ii extends LangLa_cz {
   public int a;
   public int b;
   public int c;
   public int d;
   public int e;
   public int f;
   public int g;
   public int h;
   public int i;
   public int j;
   public int k = -1;
   public int l = -1;
   public int m = -1;
   public byte n;
   public boolean o;
   private int p;
   private int q;
   private int r;
   private long s;

   public LangLa_ii(byte var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.n = var1;
      this.setXY(var2, var3);
      this.setSize(var4, var5);
      this.a(1, var6, var7);
      this.r = var5 - 20;
   }

   public void a(int var1, int var2, int var3) {
      this.g = var1;
      if (this.n == 1) {
         this.h = var2;
         this.i = var3;
         if (this.height < var3 * var2) {
            this.d = -(var2 * this.g);
            this.e = var3 * var2 - this.height;
            if (this.e % var2 != 0) {
               this.e = this.e / var2 * var2 + var2;
            }

            this.e += var2 * this.g;
         } else {
            this.d = 0;
            this.e = var3 * var2 - this.height;
         }

         if (this.e < 0) {
            this.e = 0;
         }

      } else {
         if (this.n == 0) {
            this.d(var2, var3);
         }

      }
   }

   public void a() {
      try {
         if (this.j < this.d / this.h) {
            this.j = this.d / this.h;
         }

         if (this.j > this.e / this.h) {
            this.j = this.e / this.h;
         }

         this.c = this.j * this.h;
         if (this.c < this.d) {
            this.c = this.d;
         }

         if (this.c > this.e) {
            this.c = this.e;
         }

         if (this.f != this.c) {
            this.a = this.c - this.f << 2;
            this.b += this.a;
            this.f += this.b >> 4;
            this.b &= 15;
            this.s = System.currentTimeMillis();
         }

      } catch (Exception var2) {
         Utlis.println(var2);
      }
   }

   public void a(int var1, int var2) {
      this.k = -1;
      this.d();
      this.m = this.j;
      if (this.n == 1 && this.h != 0) {
         this.l = (this.f + var2) / this.h;
      } else {
         if (this.n == 0 && this.h != 0) {
            this.l = (this.f + var1) / this.h;
         }

      }
   }

   public void b(int var1, int var2) {
      if (this.h > 30) {
         int var3;
         if ((var3 = this.h) > 55) {
            var3 = 55;
         }

         int var4;
         if ((var4 = 30 - (var3 - 30) / 2) <= 0) {
            var4 = 1;
         }

         var1 = var1 * var3 / var4;
         var2 = var2 * var3 / var4;
      }

      if (this.n == 1 && this.h != 0) {
         this.j = this.m - var2 / this.h;
      } else {
         if (this.n == 0 && this.h != 0) {
            this.j = this.m - var1 / this.h;
         }

      }
   }

   public void c(int var1, int var2) {
      this.d();
      if (this.m != this.j) {
         this.k = -1;
      } else if (this.n == 1 && this.h != 0 && this.l < this.i && this.l == (this.f + var2) / this.h || this.n == 0 && this.h != 0 && this.l < this.i && this.l == (this.f + var1) / this.h) {
         this.k = this.l;
      }

      if (this.k >= 0) {
         LangLa_dp.a().h();
      }

   }

   public boolean b() {
      if (this.m != this.j) {
         this.m = this.l = -1;
         return true;
      } else {
         this.m = this.l = -1;
         return false;
      }
   }

   public void c() {
      this.d();
      this.k = -1;
      this.l = -1;
   }

   public void a(int var1) {
      try {
         this.j = var1;
         this.d();
      } catch (Exception var2) {
         Utlis.println(var2);
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

      } catch (Exception var2) {
         Utlis.println(var2);
      }
   }

   public void d(int var1, int var2) {
      this.h = var1;
      this.i = var2;
      if (this.width < var2 * var1) {
         this.d = -(var1 * this.g);
         this.e = var2 * var1 - this.width;
         if (this.e % var1 != 0) {
            this.e = this.e / var1 * var1 + var1;
         }

         this.e += var1 * this.g;
      } else {
         this.d = 0;
         this.e = var2 * var1 - this.width;
      }

      if (this.e < 0) {
         this.e = 0;
      }

   }

   public void a(Graphics var1, int var2, int var3, int var4, int var5) {
      this.a(var1, var2 + this.cx, var3 + this.cy);
      var1.setClip(0, 0, var4, var5);
      if (this.n == 1) {
         var1.a(0, -this.f);
      } else {
         if (this.n == 0) {
            var1.a(-this.f, 0);
         }

      }
   }

   public void b(Graphics var1, int var2, int var3, int var4, int var5) {
      this.a(var1, var2 + this.cx, var3 + this.cy);
   }

   public LangLa_jz a(int var1, LangLa_cy var2) {
      return new LangLa_jz(var1, this.cx, this.cy, this.cx + this.width, this.cy + this.height, this, var2);
   }

   public LangLa_jz a(int var1, LangLa_cy var2, Object var3) {
      return new LangLa_jz(var1, this.cx, this.cy, this.cx + this.width, this.cy + this.height, this, var2, var3);
   }

   public LangLa_jz a(int var1, int var2, int var3, LangLa_cy var4) {
      return new LangLa_jz(var1, this.cx + var2, this.cy + var3, this.cx + var2 + this.width, this.cy + var3 + this.height, this, var4);
   }

   public boolean b(int var1) {
      int var2;
      if (this.n == 1) {
         var2 = this.height / this.h;
      } else {
         var2 = this.width / this.h;
      }

      return -1 + this.j <= var1 && var1 <= 1 + this.j + var2;
   }

   public boolean c(int var1) {
      return this.f - this.h <= var1 && var1 <= this.f + this.h + this.height;
   }

   public void a(Graphics var1) {
      if (this.n == 1 && this.i * this.h > this.height) {
         float var2;
         if ((var2 = (float)this.f / (float)(this.e - this.h)) < 0.0F) {
            var2 = 0.0F;
         }

         if (var2 > 1.0F - (float)this.h / (float)this.r) {
            var2 = 1.0F - (float)this.h / (float)this.r;
         }

         short var10000 = this.cy < 0 ? 0 : this.cy;
         short var3 = var10000;
         int var5;
         if ((var5 = (int)((float)var10000 + var2 * (float)this.r)) < 0) {
            var5 = 0;
         }

         int var4;
         if ((var4 = (int)(100.0F - (float)(System.currentTimeMillis() - this.s) / 1000.0F * 100.0F)) < 30) {
            var4 = 30;
         }

         var1.d(var4);
         var1.f(1345395720);
         var1.c(this.cx + this.width + 10 + this.p, var3 + 20 + this.q, 2, this.r);
         var1.m = 1.0F;
         var1.f(1358542432);
         var1.c(this.cx + this.width + 10 + this.p, var5 + 20 + this.q, 2, this.h);
      }

   }

   public void b(Graphics var1, int var2, int var3) {
      this.p = var2;
      this.q = var3;
      this.a(var1);
   }
}
