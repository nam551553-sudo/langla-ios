package beatdz;
public class LangLa_em extends Entity {
   public LangLa_hm j;
   private byte o;
   public byte k;
   public byte l;
   public byte m;
   public byte n;
   private int p;
   private int q;
   private int r;
   private int s;
   private int t;
   private int u;
   private int v;
   private int w;
   private int x;

   public LangLa_em(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      this.j = new LangLa_hm(var1, Utlis.nextInt(var7), Utlis.nextInt(var8), -1);
      if (var4 == 1) {
         if (var1 == 2) {
            this.r = 269;
            this.s = 150;
         } else if (var1 == 229) {
            this.r = 112;
            this.s = 10;
         }

         this.j.cx = (short)(var5 * this.r - this.r / 2);
         this.j.cy = (short)(var8 - this.s / 2);
      } else if (var4 == 4) {
         if (var1 == 242) {
            this.r = 32;
            this.s = 146;
         }

         this.j.cx = (short)(GameSrc.gI().maxX / 2);
         this.j.cy = (short)(var5 * this.s);
      }

      this.k = (byte)var2;
      this.l = (byte)var3;
      this.o = (byte)var4;
      this.p = var7;
      this.q = var8;
      this.t = var6;
      this.a(true);
   }

   public LangLa_em(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      this.j = new LangLa_hm(var1, var7 + Utlis.nextInt(var8), Utlis.nextInt(var9), -1);
      this.k = 8;
      this.l = 8;
      this.o = 8;
      this.p = var8;
      this.q = var9;
      this.t = 95;
      this.a(true);
   }

   public void a(int var1, int var2, int var3, int var4) {
      this.u = var1;
      this.v = var2;
      this.w = var3;
      this.x = var4;
   }

   public void a(int var1) {
      this.j.cx = (short)var1;
   }

   public void b(int var1) {
      this.j.cy = (short)var1;
   }

   private void a(boolean var1) {
      if (this.o == 0) {
         this.m = (byte)Utlis.nextInt(1, this.k);
         this.n = 0;
         if (!var1) {
            this.j.setXY(this.p + 100, Utlis.nextInt(this.q));
         } else {
            this.j.setXY(Utlis.nextInt(this.p), Utlis.nextInt(this.q));
         }
      } else {
         LangLa_hm var10000;
         if (this.o == 1) {
            this.m = this.k;
            this.n = 0;
            if (!var1) {
               var10000 = this.j;
               var10000.cx += (short)(this.t * this.r - this.m);
               return;
            }
         } else if (this.o == 4) {
            this.m = 0;
            this.n = this.l;
            if (!var1) {
               var10000 = this.j;
               var10000.cy -= (short)(this.t * this.s - this.n);
               return;
            }
         } else {
            if (this.o == 2) {
               this.m = (byte)Utlis.nextInt(1, this.k);
               this.n = (byte)Utlis.nextInt(1, this.l);
               if (!var1) {
                  this.j.setXY(Utlis.nextInt(this.p), 0);
                  return;
               }

               this.j.setXY(Utlis.nextInt(this.p), Utlis.nextInt(this.q));
               return;
            }

            if (this.o == 3 || this.o == 6) {
               this.m = (byte)Utlis.nextInt(1, this.k);
               this.n = (byte)(this.l + Utlis.nextInt(1, 5));
               if (!var1) {
                  this.j.setXY(Utlis.nextInt(this.p), 0);
                  return;
               }

               this.j.setXY(Utlis.nextInt(this.p), Utlis.nextInt(this.q));
               return;
            }

            if (this.o == 8) {
               this.m = (byte)Utlis.nextInt(-this.k, this.k);
               this.n = (byte)(this.l + Utlis.nextInt(1, 5));
               if (!var1) {
                  this.j.setXY(Utlis.nextInt(this.p), 0);
                  return;
               }

               this.j.setXY(Utlis.nextInt(this.p), Utlis.nextInt(this.q));
               return;
            }

            if (this.o == 7) {
               this.n = (byte)(this.l + Utlis.nextInt(1, 15));
               if (!var1) {
                  this.j.setXY(Utlis.nextInt(this.p), 0);
                  return;
               }

               this.j.setXY(Utlis.nextInt(this.p), Utlis.nextInt(this.q));
               return;
            }

            if (this.o == 5) {
               this.m = (byte)Utlis.nextInt(1, this.k);
               this.n = (byte)(this.l + Utlis.nextInt(1, 3));
               if (!var1) {
                  this.j.setXY(Utlis.nextInt(this.p), 0);
                  return;
               }

               this.j.setXY(Utlis.nextInt(this.p), Utlis.nextInt(this.q));
            }
         }

      }
   }

   public int a() {
      return this.o == 1 ? this.j.cx - this.r : this.j.a();
   }

   public int c() {
      return this.o == 4 ? this.j.cy - this.s : this.j.c();
   }

   public int b() {
      return this.o == 1 ? this.j.cx + this.r : this.j.b();
   }

   public int d() {
      return this.o == 4 ? this.j.cy + this.s : this.j.d();
   }

   public void o() {
      this.j.q();
      if (this.j.b() >= 0 && this.j.c() <= this.q) {
         LangLa_hm var10000 = this.j;
         var10000.cx = (short)(var10000.cx - this.m);
         var10000 = this.j;
         var10000.cy = (short)(var10000.cy + this.n);
      } else {
         this.a(false);
      }
   }

   public void a(Graphics var1) {
      int var2 = var1.a;
      int var3 = var1.b;
      if (this.w != 0 || this.x != 0) {
         var1.setClip(this.u, this.v, this.w, this.x);
      }

      this.j.b(var1, 0, 0);
      if (this.w != 0 || this.x != 0) {
         var1.a(-var1.a, -var1.b);
         var1.a(0, 0);
         var1.setClip(0, 0, DataCenter.gI().widthScreen, DataCenter.gI().heightScreen);
         var1.a(var2, var3);
      }

   }

   public void b(Graphics var1) {
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

   public int e() {
      return this.j.o().a;
   }
}
