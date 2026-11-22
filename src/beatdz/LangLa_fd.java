package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_fd extends LangLa_ge {
   private int h = 7;
   private int i = 6;
   private int u = 32;
   private int v = 0;
   private int w = 2;
   private int x = 4;
   private LangLa_ed[] y = new LangLa_ed[]{new LangLa_ed(this, 0, 0), new LangLa_ed(this, 1, 0), new LangLa_ed(this, 2, 0), new LangLa_ed(this, 3, 0), new LangLa_ed(this, 4, 0), new LangLa_ed(this, 5, 0), new LangLa_ed(this, 6, 0), new LangLa_ed(this, 6, 1), new LangLa_ed(this, 6, 2), new LangLa_ed(this, 6, 3), new LangLa_ed(this, 6, 4), new LangLa_ed(this, 6, 5), new LangLa_ed(this, 5, 5), new LangLa_ed(this, 4, 5), new LangLa_ed(this, 3, 5), new LangLa_ed(this, 2, 5), new LangLa_ed(this, 1, 5), new LangLa_ed(this, 0, 5), new LangLa_ed(this, 0, 4), new LangLa_ed(this, 0, 3), new LangLa_ed(this, 0, 2), new LangLa_ed(this, 0, 1)};
   private int[] z = new int[]{295, 294, 292, 220, 296, 292, 291, 289, 298, 295, 293, 289, 300, 298, 220, 290, 298, 297, 295, 292, 289, 299};
   private int A;
   private int B;
   private int C = 0;
   private int D = 0;
   private int E = 10;
   private boolean F = false;
   private boolean G;
   private boolean H;
   public LangLa_cl[] a = new LangLa_cl[3];
   private LangLa_dz I;
   private LangLa_dz J;
   private LangLa_dz K;
   public LangLa_kc b;
   public int c = -1;
   public int d = -1;
   public int e;
   public int f;
   private LangLa_cg L;
   public Char g;
   private Item M;

   public static long shellCount() {
      long count = 0;
      for (Item item : Char.gI().arrItemBag)
         if (item != null && item.id == 176) count += Math.max(0, item.getAmount());
      return count;
   }

   private static String shellAmount(long amount) {
      if (amount >= 1000000000L) return amount / 1000000000L + "." + amount / 100000000L % 10 + "B";
      if (amount >= 1000000L) return amount / 1000000L + "." + amount / 100000L % 10 + "M";
      return Utlis.numberFormat(amount);
   }

   private void drawRewardText(Graphics graphics, String text, int color) {
      String[] lines = mFont.c(mFont.d, text, 154);
      for (int index = 0; index < Math.min(2, lines.length); index++) {
         String line = lines[index];
         if (index == 1 && lines.length > 2) {
            while (line.length() > 0 && mFont.a(mFont.d, line + "...") > 154)
               line = line.substring(0, line.length() - 1);
            line += "...";
         }
         mFont.b(mFont.d, graphics, line, this.A + 110, this.B + 34 + index * 12, 2, color, -16777216);
      }
   }

   public LangLa_fd(MainScreen var1) {
      super(var1, Caption.sP);
      this.a(350, 230);
      this.r = false;
      this.A = 6;
      this.B = this.a_() + 2;
      this.M = new Item(-1);
      int right = this.A + 7 * this.u + 13;
      this.J = this.a(right, this.B + 166, Caption.rD[4], this, 1002, 15);
      this.J.setSize(45, 22);
      this.a(this.J, 0);
      this.f = -1;
      this.K = this.a(right + 49, this.B + 166, Caption.rD[5], this, 1003, 15);
      this.K.setSize(45, 22);
      this.a(this.K, 0);
      this.I = this.a(right, this.B + 136, Caption.rD[2], this, 1001, -8);
      this.I.setSize(94, 22);
      this.a(this.I, 0);
      this.b = new LangLa_kc(0);
      this.a[0] = this.a(this.A + 7 * this.u + 16, this.a_() + 70, "2 " + Caption.rD[3], this, this.b);
      this.a[1] = this.a(this.A + 7 * this.u + 16, this.a_() + 90, "10 " + Caption.rD[3], this, this.b);
      this.a[2] = this.a(this.A + 7 * this.u + 16, this.a_() + 110, "50 " + Caption.rD[3], this, this.b);
      this.a(this.a[0], 0);
      this.a(this.a[1], 0);
      this.a(this.a[2], 0);
      this.a[0].a(false);
      this.a[1].a(false);
      this.a[2].a(false);
      this.I.a(false);
      this.J.a(true);
      this.K.a(true);
      if (GameSrc.gI().aD.a >= 0 || GameSrc.gI().aD.d) {
         this.G = true;
         this.w = GameSrc.gI().aD.b;
      }

      String[] var2 = new String[0];
      this.L = this.a(this.width / 2 - 60, 90, 120, 0, new LangLa_kd(100000, var2), this, 0);
      this.L.k = -7;
      this.a(this.L, 1);
      LangLa_dz var3 = this.a(139, this.height - 41, Caption.cS, this, 200, -8);
      this.a(var3, 1);
      this.g = Char.gI();
      this.a(0);
      this.e();
   }

   public void a(int var1) {
      super.a(var1);
      this.f = -1;
   }

   public void e() {
      String[] var1 = Caption.th;
      this.L.a(new LangLa_kd(100000, var1), 6);
   }

   public void b() {
      super.b();
      LangLa_fd var1 = this;
      GameSrc.gI();
      int var2 = GameSrc.v();

      for(int var3 = 0; var3 < var1.m.length - 1; ++var3) {
         var1.m[var3] = false;
      }

      if (var2 == 1 || var2 == 3) {
         var1.m[0] = true;
      }

      if (var2 == 2 || var2 == 3) {
         var1.m[1] = true;
      }

      LangLa_cl var10000;
      boolean var5;
      for(int var4 = 0; var4 < this.a.length; ++var4) {
         var10000 = this.a[var4];
         var5 = false;
         var10000.a = var5;
      }

      var10000 = this.a[this.b.b];
      var5 = true;
      var10000.a = var5;
      if (this.F) {
         this.e = 0;
         if (this.c == -2) {
            this.c = this.d = -1;
         }

         if (this.H && this.w == this.E) {
            this.G = true;
            this.F = false;
         }

         ++this.C;
         if (this.C > this.v) {
            this.C = 0;
            ++this.D;
            if (this.D >= (this.v < 2 ? Utlis.nextInt(30, 45) : (this.v < 4 ? 5 : (this.v < 5 ? 3 : 2)))) {
               this.D = 0;
               ++this.v;
               if (this.v >= 6) {
                  this.v = 7;
                  this.H = true;
               }
            }

            ++this.w;
            if (this.w >= this.y.length) {
               this.w = 0;
            }

            --this.x;
            if (this.x < 0) {
               this.x = 0;
            }
         }

      } else {
         if (this.e < 3) {
            ++this.e;
         } else if (GameSrc.gI().aD != null && GameSrc.gI().aD.a >= 0) {
            this.c = GameSrc.gI().aD.a;
            this.d = GameSrc.gI().aD.c;
         } else if (this.c >= 0) {
            this.c = this.d = -2;
         }

         String var6;
         if (GameSrc.gI().aD.d) {
            var6 = Caption.cx;
            this.I.a = var6;
            this.I.a(false);
            this.J.a(true);
            this.K.a(true);
            this.a[0].a(true);
            this.a[1].a(true);
            this.a[2].a(true);
         } else if (GameSrc.gI().aD.a >= 6) {
            var6 = Caption.cy;
            this.I.a = var6;
            this.I.a(true);
            this.J.a(false);
            this.K.a(false);
            this.a[0].a(true);
            this.a[1].a(true);
            this.a[2].a(true);
         } else if (GameSrc.gI().aD.a < 0) {
            var6 = Caption.cz;
            this.I.a = var6;
            this.I.a(false);
            this.J.a(true);
            this.K.a(true);
            this.a[0].a(false);
            this.a[1].a(false);
            this.a[2].a(false);
         } else {
            var6 = Caption.cA;
            this.I.a = var6;
            this.I.a(false);
            this.J.a(false);
            this.K.a(false);
            this.a[0].a(true);
            this.a[1].a(true);
            this.a[2].a(true);
         }
      }
   }

   public void a(int var1, Object var2, LangLa_cy var3) {
   }

   public void a(int var1, Object var2) {
   }

   private void a(boolean var1) {
      this.I.a(true);
      this.J.a(true);
      this.K.a(true);
      this.a[0].a(true);
      this.a[1].a(true);
      this.a[2].a(true);
   }

   public void b(int var1) {
      if (GameSrc.gI().aD.a == -1) {
         this.w = 2;
      }

      this.F = true;
      this.G = this.H = false;
      this.E = var1;
      this.v = this.D = this.C = 0;
      this.x = 4;
      this.a(true);
   }

   public Vector c() {
      Vector var1 = super.c();
      if (this.k() == 0) {
         for(int var2 = 0; var2 < this.y.length; ++var2) {
            LangLa_ed var3 = this.y[var2];
            var1.add(new LangLa_jz(3000 + var2, this.A + var3.a * this.u, this.B + var3.b * this.u, this.A + var3.a * this.u + this.u, this.B + var3.b * this.u + this.u, (LangLa_ii)null, this));
         }
      }

      return var1;
   }

   public void a(Graphics var1) {
      super.a(var1);
      Graphics var2;
      LangLa_fd var8;
      switch(this.k()) {
      case 0:
         var2 = var1;
         var8 = this;
         long var4 = Utlis.time();

         int var3;
         int var10;
         for(var3 = 0; var3 < var8.y.length; ++var3) {
            LangLa_ed var6 = var8.y[var3];
            b(var2, var8.A + var6.a * var8.u, var8.B + var6.b * var8.u, var8.M, var8.f == var3);
            LangLa_fq.a(var2, var8.z[var3], 0, var6.a * var8.u + var8.u / 2 + 5, var8.B + var6.b * var8.u + 15, 3);
            if (var8.w == var3) {
               if (var8.F) {
                  if (var4 % 5L > 2L) {
                     LangLa_fq.b(var2, 891, 0, var8.A + var6.a * var8.u, var8.B + var6.b * var8.u, 20);
                  } else {
                     LangLa_fq.b(var2, 893, 0, var8.A + var6.a * var8.u, var8.B + var6.b * var8.u, 20);
                  }

                  if (var8.v < 2) {
                     if ((var10 = var3 - 1) < 0) {
                        var10 = var8.y.length - 1;
                     }

                     if (var8.x < 3) {
                        var6 = var8.y[var10];
                        LangLa_fq.b(var2, 893, 0, var8.A + var6.a * var8.u, var8.B + var6.b * var8.u, 20);
                     }

                     if (var8.x < 2) {
                        if ((var10 = var3 - 2) < 0) {
                           var10 = var8.y.length - 1;
                        }

                        var6 = var8.y[var10];
                        LangLa_fq.b(var2, 892, 0, var8.A + var6.a * var8.u, var8.B + var6.b * var8.u, 20);
                     }

                     if (var8.x <= 0) {
                        if ((var10 = var3 - 3) < 0) {
                           var10 = var8.y.length - 1;
                        }

                        var6 = var8.y[var10];
                        LangLa_fq.b(var2, 891, 0, var8.A + var6.a * var8.u, var8.B + var6.b * var8.u, 20);
                     }
                  }
               } else if (var8.G) {
                  LangLa_fq.b(var2, 893, 0, var8.A + var6.a * var8.u, var8.B + var6.b * var8.u, 20);
               }
            }
         }

         if (!var8.F && GameSrc.gI().aD != null && GameSrc.gI().aD.d) {
            if (DataCenter.gI().i % 10 > 5) {
               var8.drawRewardText(var2, Caption.cB, -1);
            } else {
               var8.drawRewardText(var2, Caption.cB, -2560);
            }
         } else if (var8.c >= 0) {
            String var9 = "";
            if (var8.c < 2 && var8.d != 3) {
               var9 = Caption.cC;
            }

            if (var8.d == 0) {
               var9 = var9 + " " + Utlis.numberFormat(DataCenter.gI().dataGiftQuaySo[var8.d][var8.c]) + Caption.cD + Utlis.numberFormat(DataCenter.gI().dataGiftQuaySo[4][var8.c]) + Caption.cE;
            } else if (var8.d == 1) {
               var9 = var9 + " " + Utlis.numberFormat(DataCenter.gI().dataGiftQuaySo[var8.d][var8.c]) + Caption.cF + Utlis.numberFormat(DataCenter.gI().dataGiftQuaySo[4][var8.c]) + Caption.cE;
            } else if (var8.d == 2) {
               var9 = var9 + " " + Utlis.numberFormat(DataCenter.gI().dataGiftQuaySo[var8.d][var8.c]) + Caption.cG + Utlis.numberFormat(DataCenter.gI().dataGiftQuaySo[4][var8.c]) + Caption.cE;
            } else if (var8.d == 3) {
               var9 = var9 + Caption.cI + (DataCenter.gI().dataGiftQuaySo[var8.d][var8.c] + 1) + Caption.cH + Utlis.numberFormat(DataCenter.gI().dataGiftQuaySo[4][var8.c]) + Caption.cE;
            }

            var8.drawRewardText(var2, var9, -1);
            var2.f(-2560);
            var2.b(var8.A + 35, var8.B + 59 + var8.c * 12, 150, 12);
         } else if (var8.c == -2) {
            var8.drawRewardText(var2, Caption.cJ, -1);
         }

         for(var3 = 1; var3 <= 7; ++var3) {
            for(var10 = 0; var10 < var3; ++var10) {
               LangLa_fq.a(var2, 51, 0, var8.A + 36 + var10 * 14, var8.B + 48 + var3 * 12, 0);
            }
         }

         mFont.b(mFont.d, var2, Caption.rD[8], var8.A + var8.u + 3, var8.B + var8.u + 5, 0, -1, -16777216);
         mFont.b(mFont.d, var2, Caption.rD[0], var8.A + 7 * var8.u + 13, var8.B + 5, 0, -1, -16777216);
         LangLa_fq.b(var2, 26, 27, var8.A + 7 * var8.u + 13 + 2, var8.B + 35 - 21, 88, 21);
         Binary2.a(var2, 228, 0, var8.A + 7 * var8.u + 18, var8.B + 17, 80);
         mFont.b(mFont.d, var2, shellAmount(shellCount()), var8.A + 7 * var8.u + 43, var8.B + 24, 0, -1, -16777216);
         mFont.b(mFont.d, var2, Caption.rD[1], var8.A + 7 * var8.u + 13, var8.B + 55, 0, -1, -16777216);
         return;
      case 1:
         var2 = var1;
         var8 = this;

         try {
            var8.a(var2, var8.width / 2 - 110, var8.a_() + 3, 220, var8.G() - 6, 61, 55, 56);
            mFont.a((mFont)mFont.d, (Graphics)var2, Caption.dh + (var8.g.levelCheTao / 100 + 1), 100, 55, 0, -6488, 0);
            mFont.a((mFont)mFont.d, (Graphics)var2, Caption.di + var8.g.levelCheTao % 100 + "/100", 100, 70, 0, -6488, 0);
            mFont.a((mFont)mFont.d, (Graphics)var2, Caption.dj, 100, var8.height - 74, 0, -6488, 0);
            mFont.a((mFont)mFont.d, (Graphics)var2, "- " + Utlis.numberFormat(var8.g.hoatLuc) + Caption.dk, 100, var8.height - 62, 0, -6488, 0);
            if (var8.L.b.b >= 5 && var8.L.b.b <= 8) {
               short var5 = 0;
               switch(var8.L.b.b) {
               case 5:
                  var5 = 562;
                  break;
               case 6:
                  var5 = 564;
                  break;
               case 7:
                  var5 = 566;
                  break;
               case 8:
                  var5 = 354;
               }

               mFont.a((mFont)mFont.d, (Graphics)var2, "- " + Utlis.numberFormat(var8.g.f(var5)) + " " + DataCenter.gI().ItemTemplate[var5].name, 100, var8.height - 50, 0, -6488, 0);
            } else {
               mFont.a((mFont)mFont.d, (Graphics)var2, "- " + Utlis.numberFormat(var8.g.a(160, false)) + Caption.dl, 100, var8.height - 50, 0, -6488, 0);
            }

            mFont.a((mFont)mFont.d, (Graphics)var2, Caption.sr[var8.L.b.b], 100, 125, 0, -6488, 0);
            return;
         } catch (Exception var7) {
            this.J();
         }
      default:
      }
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      if (!this.F) {
         super.a(var1, var2, var3);
         if (this.k() == 0 && var1.b >= 3000 && var1.b < 4000) {
            this.f = var1.b - 3000;
            int var10002 = this.y[this.f].a * this.u + 27;
            int var10003 = this.y[this.f].b * this.u + 27;
            int var4 = this.z[this.f];
            boolean var9 = true;
            var3 = var10003;
            var2 = var10002;
            LangLa_mb var11;
            if ((var11 = new LangLa_mb(var2, var3, 180, this, var4)).cx > DataCenter.gI().widthScreen - var11.width - super.cx) {
               var11.cx = (short)(DataCenter.gI().widthScreen - var11.width - super.cx);
            }

            if (var11.cx < var2) {
               var11.cx = (short)(var2 - (var11.width + 3));
            }

            if (var11.cx < -super.cx) {
               var11.cx = (short)(-super.cx);
            }

            if (var11.cy > DataCenter.gI().heightScreen - var11.height - super.cy) {
               var11.cy = (short)(DataCenter.gI().heightScreen - var11.height - super.cy);
            }

            this.a(var11);
            this.cL = var11;
         } else {
            switch(this.k()) {
            case 0:
               Message var10;
               switch(var1.b) {
               case 200:
                  this.g();
                  break;
               case 1001:
                  LangLa_fd var8 = this;

                  try {
                     if (GameSrc.gI().aD.d) {
                        (new Message((byte)74)).send();
                        return;
                     }

                     (var10 = new Message((byte)72)).writeByte(var8.b.b);
                     var10.send();
                     break;
                  } catch (Exception var7) {
                     Utlis.println(var7);
                     return;
                  }
               case 1002:
                  try {
                     (var10 = new Message((byte)74)).writeByte(0);
                     var10.send();
                     break;
                  } catch (Exception var6) {
                     Utlis.println(var6);
                     return;
                  }
               case 1003:
                  try {
                     (var10 = new Message((byte)74)).writeByte(1);
                     var10.send();
                  } catch (Exception var5) {
                     Utlis.println(var5);
                     return;
                  }
               }

               return;
            case 1:
               switch(var1.b) {
               case 200:
                  this.g();
               }
            }

         }
      }
   }

   private void g() {
      try {
         Message var1;
         (var1 = new Message((byte)-24)).writeByte(this.L.b.b);
         var1.send();
      } catch (Exception var3) {
         Utlis.println(var3);
      }
   }
}
