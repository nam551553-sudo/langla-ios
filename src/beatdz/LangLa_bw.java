package beatdz;
import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_bw extends LangLa_fo {
   public LangLa_lf a;
   public Item[][] b;
   public LangLa_kb[] c;
   private LangLa_ij[] g;
   private LangLa_ii[][] h;
   private LangLa_dz[][] i;
   private int j = 102;
   private int k = 50;
   private int l;
   private int m = 50;
   private int n = -1;
   private int o = -1;
   private int s = -1;
   private boolean[] t;
   private LangLa_dz u;
   public LangLa_dz d;
   public long e = -1L;
   public long f = -1L;

   public LangLa_bw(MainScreen var1) {
      this.p = var1;
      this.r = false;
      this.a(323, 220);
      this.l = super.width - 8 - 5;
      this.a = new LangLa_lf(new LangLa_kd(1001, Caption.rA), 4, this.a_(), super.width - 8, 23, 62, this);
      this.b = new Item[this.a.b.c.length][];
      this.i = new LangLa_dz[this.a.b.c.length][];
      this.h = new LangLa_ii[this.a.b.c.length][];
      this.g = new LangLa_ij[this.a.b.c.length];
      this.t = new boolean[this.a.b.c.length];
      this.a.a(0);
      this.a(this.a.b.b, (Item[][])((Item[][])null), (boolean[])null);
      this.e();
   this.u = this.a(this.width - 100, 3, "Nạp Vàng", this, 999, -8);
      this.u.setSize(80, 22);
   }

   public void a(int var1, Item[][] var2, boolean[] var3) {
      if (this.b[var1] == null) {
         this.t[var1] = false;
         this.b[var1] = new Item[GameSrc.gI().l.size()];
         int var4 = this.j;
         int var5 = this.k;
         byte var6 = 3;
         if (var1 == 3) {
            var6 = 2;
            var5 = 75;
         }

         this.g[var1] = new LangLa_ij((byte)1, 7, this.a_() + 3 + 22, var4 * 3, var5 * var6, var5, Utlis.c(this.b[var1].length, 3), 3);
         this.i[var1] = new LangLa_dz[this.b[var1].length];
         this.h[var1] = new LangLa_ii[this.b[var1].length];
         int var8 = 0;

         int var7;
         int var9;
         int var10;
         int var11;
         for(var9 = 0; var9 < this.g[var1].i; ++var9) {
            var7 = var9 * var5;

            for(var10 = 0; var10 < this.g[var1].r; ++var10) {
               var11 = var10 * var4;
               this.b[var1][var8] = (Item)GameSrc.gI().l.elementAt(var8);
               if (var1 == 3) {
                  this.i[var1][var8] = new LangLa_dz(var11 + 38, var7 + 47, 0, 0, "", this, 1000, this.b[var1][var8].e());
                  this.h[var1][var8] = new LangLa_in((byte)1, 0, 0, this.i[var1][var9].width, this.i[var1][var9].height, this.i[var1][var9].height, 1, this.g[var1]);
               } else {
                  this.i[var1][var8] = new LangLa_dz(var11 + 40, var7 + 14, 0, 0, "", this, 1000, this.b[var1][var8].e());
                  this.h[var1][var8] = new LangLa_in((byte)1, 0, 0, this.i[var1][var9].width, this.i[var1][var9].height, this.i[var1][var9].height, 1, this.g[var1]);
               }

               ++var8;
               if (var8 >= this.i[var1].length) {
                  break;
               }
            }

            if (var8 >= this.i[var1].length) {
               break;
            }
         }

         if (var1 == 2) {
            this.c = new LangLa_kb[this.b[var1].length];

            for(var9 = 0; var9 < var2.length; ++var9) {
               this.c[var9] = new LangLa_kb(Caption.R + (var9 + 1), var2[var9], var3[var9]);
            }

            this.t[var1] = false;
            this.g[var1] = new LangLa_ij((byte)1, 7, this.a_() + 3 + 22, this.l, this.m * 3, this.m, this.c.length, 1);
            this.h[var1] = new LangLa_ii[this.c.length];
            var8 = 0;

            for(var9 = 0; var9 < this.g[var1].i; ++var9) {
               var7 = var9 * this.m;

               for(var10 = 0; var10 < this.g[var1].r; ++var10) {
                  var11 = var10 * this.l;
                  this.i[var1][var8].setXY(var11 + this.l - 60, var7 + 19);
                  this.i[var1][var8].a(this.c[var8].c);
                  this.h[var1][var8] = new LangLa_in((byte)1, 0, 0, this.i[var1][var9].width, this.i[var1][var9].height, this.i[var1][var9].height, 1, this.g[var1]);
                  ++var8;
                  if (var8 >= this.i[var1].length) {
                     break;
                  }
               }

               if (var8 >= this.i[var1].length) {
                  break;
               }
            }
         }
      }

   }

   private void e() {
      this.n = this.o = this.s = -1;
      if (this.b[this.a.b.b] == null) {
         this.t[this.a.b.b] = true;
         switch(this.a.b.b) {
         case 0:
            GameSrc.gI();
            GameSrc.openFunc(6);
            return;
         case 1:
            GameSrc.gI();
            GameSrc.openFunc(7);
            return;
         case 2:
            GameSrc.gI();
            GameSrc.openFunc(39);
            return;
         case 3:
            GameSrc.gI();
            GameSrc.openFunc(40);
            return;
         case 4:
            GameSrc.openFunc(LucDaoShopUI.TYPE);
            return;
         }
      }

   }

   public void a(int var1, Object var2, LangLa_cy var3) {
   }

   public void a(int var1, Object var2) {
   }

   public void a(Graphics var1) {
      this.a(var1, this.cx, this.cy, this.width, this.height, Caption.bv, (byte)2, this.r);
      this.a.a(var1);
      if (!this.t[this.a.b.b]) {
         if (this.a.b.b == 3) {
            Graphics var2 = var1;
            LangLa_bw var10 = this;
            if (this.b[this.a.b.b].length != 0) {
               String var4 = "";
               String var5 = "";
               if (this.e >= 0L) {
                  var4 = Caption.nn + Utlis.e(this.e);
               }

               if (this.f >= 0L) {
                  var5 = Caption.no + Utlis.e(this.f);
               }

               String var3;
               if (this.e >= 0L && this.f >= 0L) {
                  var3 = var4 + " - " + var5;
               } else {
                  var3 = var4 + var5;
               }

               mFont.a(var1, var3, this.width / 2, this.height - 10, 2, -2560);
               this.a(var1, this.g[this.a.b.b]);
               int var13 = 0;
               int var10000 = var1.a;
               var10000 = var1.b;

               for(int var7 = 0; var7 < var10.g[var10.a.b.b].i; ++var7) {
                  int var12 = var7 * 75;

                  for(int var8 = 0; var8 < var10.g[var10.a.b.b].r; ++var8) {
                     int var11 = var8 * var10.j;
                     if (var10.g[var10.a.b.b].b(var7)) {
                        var10.a(var2, var11, var12, var10.j - 3, 72, -22, 55, 56);
                        mFont.a((mFont)mFont.b, (Graphics)var2, Utlis.a(var10.b[var10.a.b.b][var13].getItemTemplate().name, 30), var11 + 5, var12 + 8, 0, -6488, -10275328);
                        mFont.a((mFont)mFont.b, (Graphics)var2, Caption.ry[0] + Utlis.numberFormat(var10.b[var10.a.b.b][var13].moneyOld), var11 + 38, var12 + 19, 0, -1, -10275328);
                        mFont.a((mFont)mFont.b, (Graphics)var2, Caption.ry[1] + Utlis.numberFormat(var10.b[var10.a.b.b][var13].d()), var11 + 38, var12 + 28, 0, -1, -10275328);
                        if (var10.b[var10.a.b.b][var13].amountBuy == 0) {
                           mFont.a((mFont)mFont.d, (Graphics)var2, Caption.ry[3], var11 + 38, var12 + 39, 0, -65536, -11184811);
                        } else if (var10.b[var10.a.b.b][var13].amountBuy > 0) {
                           mFont.a((mFont)mFont.b, (Graphics)var2, Utlis.replaceAll(Caption.ry[2], "" + var10.b[var10.a.b.b][var13].amountBuy), var11 + 38, var12 + 37, 0, -16711681, -10275328);
                        }

                        b(var2, var11 + 5, var12 + 15, var10.b[var10.a.b.b][var13], var10.n == var13);
                        LangLa_fq.a(var2, 757, 0, var11 + 9, var12 + 43, 20);
                        mFont.a((mFont)mFont.b, (Graphics)var2, "-" + (100 - var10.b[var10.a.b.b][var13].d() * 100 / var10.b[var10.a.b.b][var13].moneyOld) + "%", var11 + 18, var12 + 52, 2, -1, -10275328);
                        var11 = var2.a;
                        int var6 = var2.b;
                        var10.a(var2, var11 + var10.i[var10.a.b.b][var13].cx, var6 + var10.i[var10.a.b.b][var13].cy);
                        if (var10.b[var10.a.b.b][var13].amountBuy == 0) {
                           var10.i[var10.a.b.b][var13].v = true;
                        } else {
                           var10.i[var10.a.b.b][var13].a(var2);
                        }

                        var10.a(var2, var11, var6);
                     }

                     ++var13;
                     if (var13 >= var10.i[var10.a.b.b].length) {
                        break;
                     }
                  }

                  if (var13 >= var10.i[var10.a.b.b].length) {
                     break;
                  }
               }

               var10.b(var2);
               var10.g[var10.a.b.b].b(var2, -10, -12);
               return;
            }

            mFont.a(mFont.e, var1, Caption.nq, this.width / 2, this.height / 2 + 10, 2, -2560, 2, 1, 3);
         } else {
            if (this.a.b.b == 2) {
               this.f(var1);
               return;
            }

            this.e(var1);
         }

      }
   }

   private void e(Graphics var1) {
      this.a(var1, this.g[this.a.b.b]);
      int var4 = 0;
      int var10000 = var1.a;
      var10000 = var1.b;

      for(int var7 = 0; var7 < this.g[this.a.b.b].i; ++var7) {
         int var3 = var7 * this.k;

         for(int var8 = 0; var8 < this.g[this.a.b.b].r; ++var8) {
            int var2 = var8 * this.j;
            if (this.g[this.a.b.b].b(var7)) {
               this.a(var1, var2, var3, this.j - 3, 47, -22, 55, 56);
               b(var1, var2 + 5, var3 + 5, this.b[this.a.b.b][var4], this.n == var4);
               int var5 = var1.a;
               int var6 = var1.b;
               mFont.d(mFont.b, var1, Utlis.a(this.b[this.a.b.b][var4].getItemTemplate().name, 30), var2 + 5, var3 + 39, 0, -6488, -10275328);
               this.a(var1, var5 + this.i[this.a.b.b][var4].cx, var6 + this.i[this.a.b.b][var4].cy);
               mFont.a((mFont)mFont.b, (Graphics)var1, Caption.ap + " " + Utlis.numberFormat(this.b[this.a.b.b][var4].d()), 0, -6, 0, -1, -11184811);
               this.i[this.a.b.b][var4].a(var1);
               this.a(var1, var5, var6);
            }

            ++var4;
            if (var4 >= this.i[this.a.b.b].length) {
               break;
            }
         }

         if (var4 >= this.i[this.a.b.b].length) {
            break;
         }
      }

      this.b(var1);
      this.g[this.a.b.b].b(var1, -10, -12);
   }

   private void f(Graphics var1) {
      try {
         this.a(var1, this.g[this.a.b.b]);
         int var3 = 0;
         int var10000 = var1.a;
         var10000 = var1.b;

         for(int var6 = 0; var6 < this.g[this.a.b.b].i; ++var6) {
            int var2 = var6 * this.m;

            for(int var7 = 0; var7 < this.g[this.a.b.b].r; ++var7) {
               if (this.g[this.a.b.b].b(var3)) {
                  this.a(var1, 125, var2, this.l - 3 - 130, this.m - 3, -22, 55, 56);
                  switch(var3 + 1) {
                  case 1:
                     mFont.a(mFont.f, var1, this.c[var3].a, 10, var2 + 25, 0, -3089954, 5, 0);
                     break;
                  case 2:
                     mFont.a(mFont.f, var1, this.c[var3].a, 10, var2 + 25, 0, -5389736, 5, 0);
                     break;
                  case 3:
                     mFont.a(mFont.f, var1, this.c[var3].a, 10, var2 + 25, 0, -16609665, 5, 0);
                     break;
                  case 4:
                     mFont.a(mFont.f, var1, this.c[var3].a, 10, var2 + 25, 0, -37888, 4, 0);
                     break;
                  case 5:
                     mFont.a(mFont.f, var1, this.c[var3].a, 10, var2 + 25, 0, -3407617, 5, 0);
                     break;
                  case 6:
                     mFont.a(mFont.f, var1, this.c[var3].a, 10, var2 + 25, 0, -1506443, 4, 0);
                     break;
                  case 7:
                     mFont.a(mFont.f, var1, this.c[var3].a, 10, var2 + 25, 0, -65536, 4, 0);
                     break;
                  case 8:
                     mFont.a(mFont.f, var1, this.c[var3].a, 10, var2 + 25, 0, -16733953, 3, 0);
                     break;
                  case 9:
                     mFont.a(mFont.f, var1, this.c[var3].a, 10, var2 + 25, 0, -16711774, 3, 0);
                     break;
                  case 10:
                     mFont.a(mFont.f, var1, this.c[var3].a, 10, var2 + 25, 0, -590080, 3, 0);
                  }

                  int var4;
                  for(var4 = 0; var4 < this.c[var3].b.length; ++var4) {
                     b(var1, 134 + var4 * 35, var2 + 10, this.c[var3].b[var4], this.n == var3 && this.s == var4);
                  }

                  var4 = var1.a;
                  int var5 = var1.b;
                  this.a(var1, var4 + this.i[this.a.b.b][var3].cx, var5 + this.i[this.a.b.b][var3].cy);
                  mFont.a(mFont.d, var1, Caption.ap + " " + Utlis.numberFormat(this.b[this.a.b.b][var3].d()), 0, -8, 0, -1);
                  this.i[this.a.b.b][var3].a(var1);
                  this.a(var1, var4, var5);
               }

               ++var3;
               if (var3 >= this.i[this.a.b.b].length) {
                  break;
               }
            }

            if (var3 >= this.i[this.a.b.b].length) {
               break;
            }
         }

         this.b(var1);
         this.g[this.a.b.b].b(var1, -15, -12);
      } catch (Exception var9) {
      }
   }

   public void b() {
      this.a.b();
      if (!this.t[this.a.b.b]) {
         this.g[this.a.b.b].a();

         for(int var1 = 0; var1 < this.i[this.a.b.b].length; ++var1) {
            this.i[this.a.b.b][var1].b();
            this.h[this.a.b.b][var1].a();
            if (this.h[this.a.b.b][var1].l != -1) {
               this.i[this.a.b.b][var1].h = true;
            } else {
               this.i[this.a.b.b][var1].h = false;
            }
         }

      }
   }

   public Vector c() {
      Vector var1 = super.c();
      if (this.t[this.a.b.b]) {
         var1.addElement(this.a.c());
         return var1;
      } else {
         int var4 = 0;

         for(int var5 = 0; var5 < this.i[this.a.b.b].length; ++var5) {
            int var2 = this.g[this.a.b.b].cx + this.i[this.a.b.b][var5].cx;
            int var3 = this.g[this.a.b.b].cy + this.i[this.a.b.b][var5].cy - this.g[this.a.b.b].f;
            if (Utlis.inRange(this.g[this.a.b.b].cx, this.g[this.a.b.b].cy, this.g[this.a.b.b].cx + this.g[this.a.b.b].width, this.g[this.a.b.b].cy + this.g[this.a.b.b].height, var2, var3) && Utlis.inRange(this.g[this.a.b.b].cx, this.g[this.a.b.b].cy, this.g[this.a.b.b].cx + this.g[this.a.b.b].width, this.g[this.a.b.b].cy + this.g[this.a.b.b].height, var2 + this.i[this.a.b.b][var5].width, var3 + this.i[this.a.b.b][var5].height)) {
               this.h[this.a.b.b][var5].cx = (short)var2;
               this.h[this.a.b.b][var5].cy = (short)var3;
               if (!this.i[this.a.b.b][var5].u && !this.i[this.a.b.b][var5].v) {
                  var1.addElement(new LangLa_jz(2000 + var5, this.h[this.a.b.b][var5].cx, this.h[this.a.b.b][var5].cy, this.h[this.a.b.b][var5].cx + this.h[this.a.b.b][var5].width, this.h[this.a.b.b][var5].cy + this.h[this.a.b.b][var5].height, this.h[this.a.b.b][var5], this));
               }

               if (this.a.b.b == 2) {
                  for(int var6 = 0; var6 < this.c[var4].b.length; ++var6) {
                     var1.addElement(new LangLa_jz(3000 + var5, var2 - 35 - 70 + var6 * 35, var3 - 9, var2 - 35 - 70 + 28 + var6 * 35, var3 - 9 + 28, this.g[this.a.b.b], this, var6));
                  }
               } else {
                  if (this.a.b.b == 3) {
                     var2 += 2;
                     var3 -= 23;
                  }

                  var1.addElement(new LangLa_jz(3000 + var5, var2 - 35, var3 - 9, var2 - 35 + 28, var3 - 9 + 28, this.g[this.a.b.b], this));
               }
            }

            ++var4;
         }

         var1.addElement(this.a.c());
         var1.addElement(new LangLa_jz(1002, this.g[this.a.b.b].cx, this.g[this.a.b.b].cy, this.g[this.a.b.b].cx + this.g[this.a.b.b].width, this.g[this.a.b.b].cy + this.g[this.a.b.b].height, this.g[this.a.b.b], this));
         return var1;
      }
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      this.d = null;
      this.n = this.o = this.s = -1;
      if (!this.t[this.a.b.b]) {
         if (var1.b >= 3000) {
            this.n = var1.b - 3000;
            if (this.a.b.b == 2) {
               this.s = (Integer)var1.k;
               if (this.s >= 0) {
                  var2 = this.g[this.a.b.b].cx + this.i[this.a.b.b][this.n].cx - 35 - 70 + this.s * 35 + 30;
                  var3 = this.g[this.a.b.b].cy + this.i[this.a.b.b][this.n].cy - this.g[this.a.b.b].f - 9 + 5;
                  this.cL = a(this, var2, var3, 28, this.c[this.n].b[this.s]);
               }
            } else {
               var2 = this.g[this.a.b.b].cx + this.i[this.a.b.b][this.n].cx - 35 + 30;
               var3 = this.g[this.a.b.b].cy + this.i[this.a.b.b][this.n].cy - this.g[this.a.b.b].f - 9;
               this.cL = a(this, var2, var3, 28, this.b[this.a.b.b][this.n]);
            }
         } else if (var1.b >= 2000) {
            this.o = var1.b - 2000;
            LangLa_dp.a().h();
            if (this.a.b.b == 2) {
               try {
                  Message var5;
                  (var5 = new Message((byte)121)).writeShort(this.b[this.a.b.b][this.o].idBuy);
                  var5.writeShort(1);
                  var5.send();
                  this.d = this.i[this.a.b.b][this.o];
               } catch (Exception var4) {
               }
            } else if (this.a.b.b == 3) {
               this.p.a((LangLa_cx)(new LangLa_lv(this.p, this.b[this.a.b.b][this.o], (byte)40)));
            } else {
               this.p.a((LangLa_cx)(new LangLa_lv(this.p, this.b[this.a.b.b][this.o], (byte)6)));
            }
         }
      }

      switch(var1.b) {
      case 998:
         GameSrc.gI();
         GameSrc.openFunc(86);
         break;
      case 999:
         GameSrc.gI();
         GameSrc.F();
         return;
      case 1000:
      default:
         break;
      case 1001:
         if (var1.j.k >= 0) {
            this.a.a(var1.j.k);
            this.e();
            return;
         }
      }

   }
}
