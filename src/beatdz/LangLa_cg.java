package beatdz;
import java.util.Vector;

public class LangLa_cg extends LangLa_cs {
   private boolean l;
   private int m;
   public LangLa_ii a;
   public LangLa_kd b;
   public int c;
   public int d;
   public int e;
   public int f;
   public int g;
   public int h = 20;
   public String[] i;
   public boolean j;
   private short n = 12;
   public int k = -1;

   public LangLa_cg(int var1, int var2, int var3, int var4, LangLa_kd var5, LangLa_cx var6, int var7, boolean var8) {
      this.setXY(var1, var2);
      this.s = var6;
      this.m = var3;
      this.l = var8;
      this.f = var7;
      this.a(var5, var4);
   }

   public void a(LangLa_kd var1, int var2) {
      this.g = var2;
      this.d = var2 * this.h + this.h + 1;
      this.b = var1;
      this.i = new String[var1.c.length];

      int var3;
      for(var3 = 0; var3 < var1.c.length; ++var3) {
         if ((var2 = mFont.b(mFont.d, var1.c[var3])) + 30 > this.c) {
            this.c = var2 + 30;
         }

         if (var2 > this.m - 30) {
            this.i[var3] = mFont.b(mFont.d, var1.c[var3], this.m - 30).firstElement().toString() + "...";
         } else {
            this.i[var3] = var1.c[var3];
         }
      }

      if (this.c < this.m) {
         this.c = this.m;
      }

      this.a();
      if (this.a != null) {
         var3 = this.a.k;
         this.setSize(this.c, this.d);
         if (this.f == 0) {
            this.a = new LangLa_ii((byte)1, 0, 21, this.width, this.height - this.h - 1, this.h, var1.c.length);
         } else if (this.f == 1) {
            this.a = new LangLa_ii((byte)1, 0, 21 - this.height, this.width, this.height - this.h - 1, this.h, var1.c.length);
         }

         var1.b = var3;
         this.a.a(var1.b);
         this.a.k = var1.b;
      }

   }

   public void a(int var1) {
      this.b.b = var1;
   }

   public void a(Graphics var1) {
      if (!this.v) {
         short var2 = this.n;
         LangLa_fq.b(var1, 14, 67, 0, 0, this.d() - 18, 20);
         if (this.n(0)) {
            var1.e(30);
         }

         if (this.f == 0) {
            LangLa_fq.a(var1, var2, 0, this.d(), 2, 24);
         } else if (this.f == 1) {
            LangLa_fq.a(var1, var2, 180, this.d(), 2, 24);
         }

         var1.d();
         if (this.b.b >= 0 && this.b.b < this.b.c.length) {
            if (this.u) {
               mFont.b(mFont.d, var1, this.i[this.b.b], 5, 9, 0, -3089954, 0);
            } else {
               mFont.b(mFont.d, var1, this.i[this.b.b], 5, 9, 0, -1, -16777216);
            }
         }

         if (this.j) {
            Binary2.a(var1, -16, 0, this.a.cx, this.a.cy, this.a.width, (int)this.a.height);
            this.a(var1, this.a);

            for(int var3 = 0; var3 < this.b.c.length; ++var3) {
               if (this.a.b(var3)) {
                  if (var3 == this.a.k) {
                     Binary2.a(var1, -7, 0, 0, var3 * this.a.h, this.a.width, (int)this.a.h);
                  }

                  if (var3 == this.a.l) {
                     mFont.b(mFont.d, var1, this.b.c[var3], 6, 1 + var3 * this.a.h + this.a.h / 2, 0, -1, -11184811);
                  } else {
                     mFont.b(mFont.d, var1, this.b.c[var3], 5, var3 * this.a.h + this.a.h / 2, 0, -1, -11184811);
                  }
               }
            }

            if (this.f == 0) {
               this.a.b(var1, -15, this.a.f - 30);
            }

            this.b(var1);
         }

      }
   }

   public void b() {
      if (!this.u) {
         if (this.j) {
            this.a.a();
         }

         if (this.e > 0) {
            --this.e;
            if (this.e == 0 && this.a.k >= 0) {
               this.b.b = this.a.k;
               this.a();
               if (this.l) {
                  this.s.b(this.b.a, this.b, this);
               }
            }
         }

      }
   }

   public void a() {
      this.j = false;
      this.setSize(this.d(), 20);
   }

   public int d() {
      return this.c > this.m ? this.m : this.c;
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      if (!this.u && !this.v) {
         if (this.e <= 0) {
            try {
               switch(var1.b) {
               case -1002:
                  if (var1.j.k >= 0) {
                     // Commit on this release, without waiting four gameplay ticks.
                     this.e = 0;
                     this.b.b = var1.j.k;
                     this.a();
                     if (this.l) this.s.b(this.b.a, this.b, this);
                  }

                  LangLa_dp.a().h();
               default:
                  return;
               case -1001:
                  this.a();
                  break;
               case -1000:
                  this.j = true;
                  this.setSize(this.c, this.d);
                  if (this.a == null) {
                     if (this.f == 0) {
                        this.a = new LangLa_ii((byte)1, 0, 21, this.width, this.height - this.h - 1, this.h, this.b.c.length);
                     } else if (this.f == 1) {
                        this.a = new LangLa_ii((byte)1, 0, 21 - this.height, this.width, this.height - this.h - 1, this.h, this.b.c.length);
                     }
                  }

                  if (this.a.j < 0 || this.a.j >= this.b.c.length || this.a.j > this.b.b + this.g / 2 + 1 || this.a.j < this.b.b - (this.g / 2 + 1)) {
                     this.a.a(this.b.b);
                  }

                  this.a.k = this.b.b;
                  LangLa_dp.a().h();
               }
            } catch (Exception var4) {
            }

         }
      }
   }

   public Vector c() {
      if (!this.u && !this.v) {
         Vector var1 = new Vector();
         if (!this.j) {
            var1.addElement(new LangLa_jz(-1000, 0, 0, this.d(), 20, (LangLa_ii)null, this));
         } else {
            var1.addElement(new LangLa_jz(-1001, 0, 0, this.d(), 20, (LangLa_ii)null, this));
            var1.addElement(new LangLa_jz(-1002, this.a.cx, this.a.cy, this.a.cx + this.a.width, this.a.cy + this.a.height, this.a, this));
         }

         return var1;
      } else {
         return null;
      }
   }
}
