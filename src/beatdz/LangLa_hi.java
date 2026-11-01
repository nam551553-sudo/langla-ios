package beatdz;import java.util.Vector;

public class LangLa_hi extends Entity {
   public short j;
   private byte q = -1;
   private int r = 0;
   private Entity s;
   private Entity t;
   private int u;
   private int v;
   private Vector w = new Vector();
   private int x;
   private int y;
   private int z;
   private boolean A;
   private boolean B;
   
   
   
   
   
   

   public LangLa_hj o() {
      return DataCenter.gI().I[this.j];
   }

   public LangLa_hi(int var1, int var2, int var3, Entity var4, int var5, int var6) {
      this.j = (short)var1;
      this.s = var4;
      this.x = var5;
      this.y = var6;
      this.z = this.o().a;
      if (this.z == 7) {
         var2 = var4.cx - (60 - Utlis.nextInt((int)120));
         var3 = var4.cy - 200 - Utlis.nextInt((int)200);
      } else if (this.o().a == 4) {
         this.z = Utlis.nextInt(new int[]{0, 1, 2});
      }

      this.setXY(var2, var3);
      var1 = var4.cx - var2;
      var2 = var4.cy - var3;
      if (this.z == 1 || this.z == 2) {
         var5 = b(-var1, var2);
         this.B = true;
         if (var1 > var2) {
            this.u = b(var1, -var2);
         } else {
            this.u = b(-var1, var2);
         }

         this.t = new Char();
         if (this.z == 1) {
            this.t.setXY(var4.cx, var3 - 100);
            if (var5 >= 90 && var5 < 270) {
               if (var1 > var2) {
                  this.u = b(-var1, var2);
               } else {
                  this.u = b(var1, -var2);
               }

               this.t.setXY(var4.cx, var3 + 100);
               return;
            }
         } else if (this.z == 2) {
            this.t.setXY(var4.cx, var3 + 100);
            if (var5 >= 90 && var5 < 270) {
               if (var1 > var2) {
                  this.u = b(-var1, var2);
               } else {
                  this.u = b(var1, -var2);
               }

               this.t.setXY(var4.cx, var3 - 100);
            }
         }
      }

   }

   public int a() {
      return this.cx - this.width / 2;
   }

   public int b() {
      return this.cx + this.width / 2;
   }

   public int c() {
      return this.cy - this.height / 2;
   }

   public int d() {
      return this.cy + this.height / 2;
   }

   public boolean p() {
      if (this.A) {
         return this.A;
      } else {
         Entity var1 = this.s;
         if (this.B) {
            var1 = this.t;
         }

         if (var1 == null) {
            this.A = true;
            return this.A;
         } else {
            if (Utlis.inRange(this.cx - 10, this.cy - 10, this.cx + 10, this.cy + 10, var1.a(), var1.c(), var1.b(), var1.d())) {
               if (this.x > 0 && !this.B) {
                  LangLa_jw var2 = new LangLa_jw(this.x, var1.cx, var1.cy);
                  if (this.y == 1) {
                     var2 = new LangLa_jw(this.x, var1.m(), var1.n());
                  }

                  GameSrc.gI().I.add(var2);
               }

               this.A = true;
            } else if (Utlis.getRange2(this.cx, this.cy, var1.a(), var1.c()) > 800) {
               this.A = true;
            }

            if (this.A && this.B) {
               this.B = false;
               this.A = false;
            }

            return this.A;
         }
      }
   }

   public void q() {
      this.r();
      this.r += 20;
      if (this.r >= 360) {
         this.r = 0;
      }

      if (this.o().g != null) {
         int var1 = this.o().g.length;
         ++this.q;
         if (this.q >= var1) {
            this.q = 0;
         }
      }

   }

   public void a(Graphics var1) {
      if (!this.p()) {
         if (!Utlis.f() && !mConfig.gI().readBoolean(11)) {
            if (this.o().a == 6) {
               switch(this.o().d) {
               case 1:
                  var1.c(-2303742);
                  break;
               case 2:
                  var1.c(-16663468);
                  break;
               case 3:
                  var1.c(-16744706);
                  break;
               case 4:
                  var1.c(-2031616);
                  break;
               case 5:
                  var1.c(-9942667);
               }
            }

            int var3;
            int var4;
            boolean var8;
            if (this.o().h != null && this.o().h.length > 0) {
               int var2 = 0;
               var3 = this.o().b + this.o().d;

               for(var4 = this.w.size() - 1; var4 >= 0; --var4) {
                  if (var3 > 0) {
                     var3 -= this.o().c;
                  } else {
                     if (var2 >= this.o().h.length) {
                        break;
                     }

                     int[] var5 = (int[])((int[])this.w.elementAt(var4));
                     int var6 = this.s.m() - var5[0];
                     int var7 = this.s.n() - var5[1];
                     var6 = b(var6, var7);
                     if (this.o().f) {
                        var6 = this.r;
                     }

                     var8 = true;
                     var1.k = var8;
                     short var12 = this.o().h[var2][0];

                     try {
                        var12 = this.o().h[var2][this.q];
                     } catch (Exception var9) {
                     }

                     if (this.z == 3 && var6 >= 91 && var6 <= 269) {
                        LangLa_fq.c(var1, var12, -(360 - var6), var5[0], var5[1], 3);
                     } else {
                        LangLa_fq.b(var1, var12, var6, var5[0], var5[1], 3);
                     }

                     var8 = false;
                     var1.k = var8;
                     ++var2;
                     if (var3 <= 0) {
                        var3 = this.o().b;
                     }
                  }
               }
            }

            if (this.o().g != null && this.o().g.length > 0) {
               short var10 = this.o().g[this.q];
               var3 = this.s.m() - this.cx;
               var4 = this.s.n() - this.cy;
               var8 = true;
               var1.k = var8;
               int var11 = b(var3, var4);
               if (this.o().e) {
                  var11 = this.r;
               }

               short[] var13;
               if (this.z == 3 && var11 >= 91 && var11 <= 269) {
                  var13 = LangLa_fq.c(var1, var10, -(360 - var11), this.cx, this.cy, 3);
               } else {
                  var13 = LangLa_fq.b(var1, var10, var11, this.cx, this.cy, 3);
               }

               var8 = false;
               var1.k = var8;
               this.setSize(var13[0], var13[1]);
            }

            if (this.o().a == 6) {
               var1.c();
            }

         }
      }
   }

   private void r() {
      ++this.v;
      Entity var1 = this.s;
      if (this.B) {
         var1 = this.t;
      }

      if (var1 != null) {
         int var2;
         int var3;
         int var5;
         if (this.z != 1 && this.z != 2) {
            var2 = Utlis.positive(var1.m() - this.cx);
            var3 = Utlis.positive(var1.n() - this.cy);
            byte var8;
            var5 = var8 = this.o().c;
            int var6 = var8;

            try {
               if (var3 > var2) {
                  var5 = var2 / (var3 / var8);
               } else {
                  var6 = var3 / (var2 / var8);
               }
            } catch (Exception var7) {
            }

            if (var5 <= 0) {
               var5 = 1;
            }

            if (var6 <= 0) {
               var6 = 1;
            }

            if (this.cx > var1.m()) {
               this.cx = (short)(this.cx - var5);
            } else if (this.cx < var1.m()) {
               this.cx = (short)(this.cx + var5);
            }

            if (this.cy > var1.n()) {
               this.cy = (short)(this.cy - var6);
            } else if (this.cy < var1.n()) {
               this.cy = (short)(this.cy + var6);
            }
         } else {
            var2 = var1.cx - this.cx;
            var3 = var1.cy - this.cy;
            this.u = this.a(var2, var3, this.u);
            int var4 = this.o().c * this.a(beatdz.LangLa_hi.$state_LangLa_hi().o, this.u, -1) >> 10;
            var5 = this.o().c * this.a(beatdz.LangLa_hi.$state_LangLa_hi().n, this.u, 1) >> 10;
            this.cx = (short)(this.cx + var4);
            this.cy = (short)(this.cy + var5);
         }
      }

      this.w.addElement(new int[]{this.cx, this.cy});
   }

   public static int b(int var0, int var1) {
      int var2;
      if (var0 != 0) {
         var2 = a(Math.abs((var1 << 10) / var0));
         if (var1 >= 0 && var0 < 0) {
            var2 = 180 - var2;
         }

         if (var1 < 0 && var0 < 0) {
            var2 += 180;
         }

         if (var1 < 0 && var0 >= 0) {
            var2 = 360 - var2;
         }
      } else {
         var2 = var1 > 0 ? 90 : 270;
      }

      return var2;
   }

   private static int a(int var0) {
      for(int var1 = 0; var1 <= 90; ++var1) {
         if (beatdz.LangLa_hi.$state_LangLa_hi().p[var1] >= var0) {
            return var1;
         }
      }

      return 0;
   }

   private static int b(int var0) {
      if (var0 >= 360) {
         var0 -= 360;
      }

      if (var0 < 0) {
         var0 += 360;
      }

      return var0;
   }

   private int a(int[] var1, int var2, int var3) {
      if ((var2 = b(var2)) >= 0 && var2 < 90) {
         return var1[var2];
      } else if (var2 >= 90 && var2 < 180) {
         return var3 * var1[180 - var2];
      } else {
         return var2 >= 180 && var2 < 270 ? -var1[var2 - 180] : var3 * -var1[360 - var2];
      }
   }

   private int a(int var1, int var2, int var3) {
      int var4;
      if (var1 != 0) {
         var4 = a(Math.abs((var2 << 10) / var1));
         if (var2 >= 0 && var1 < 0) {
            var4 = 180 - var4;
         }

         if (var2 < 0 && var1 < 0) {
            var4 += 180;
         }

         if (var2 < 0 && var1 >= 0) {
            var4 = 360 - var4;
         }
      } else {
         var4 = var2 > 0 ? 90 : 270;
      }

      if (Math.abs(var4 - var3) >= 90 && var1 * var1 + var2 * var2 <= 4096) {
         return var4;
      } else if (Math.abs(var4 - var3) < 15) {
         return var4;
      } else {
         return (var4 - var3 < 0 || var4 - var3 >= 180) && var4 - var3 >= -180 ? b(var3 - 15) : b(var3 + 15);
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
      return 2;
   }

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public byte[] k;
public int[] l;
public int[] m;
public int[] n;
public int[] o;
public int[] p;
public void initialize() {
this.k = new byte[]{0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1};
this.l = new int[]{0, 15, 37, 52, 75, 105, 127, 142, 165, 195, 217, 232, 255, 285, 307, 322, 345, 370};
this.m = new int[]{0, 0, 0, 7, 6, 6, 6, 2, 2, 3, 3, 4, 5, 5, 5, 1};
this.n = new int[]{0, 17, 34, 52, 69, 87, 104, 121, 139, 156, 173, 190, 207, 224, 241, 258, 275, 292, 309, 325, 342, 358, 374, 390, 406, 422, 438, 453, 469, 484, 499, 515, 529, 544, 559, 573, 587, 601, 615, 629, 642, 656, 669, 681, 694, 707, 719, 731, 743, 754, 766, 777, 788, 798, 809, 819, 829, 838, 848, 857, 866, 874, 882, 891, 898, 906, 913, 920, 927, 933, 939, 945, 951, 956, 961, 965, 970, 974, 978, 981, 984, 987, 990, 992, 994, 996, 997, 998, 999, 999, 1000};
this.o = new int[]{1000, 999, 999, 998, 997, 996, 994, 992, 990, 987, 984, 981, 978, 974, 970, 965, 961, 956, 951, 945, 939, 933, 927, 920, 913, 906, 898, 891, 882, 874, 866, 857, 848, 838, 829, 819, 809, 798, 788, 777, 766, 754, 743, 731, 719, 707, 694, 681, 669, 656, 642, 629, 615, 601, 587, 573, 559, 544, 529, 515, 500, 484, 469, 453, 438, 422, 406, 390, 374, 358, 342, 325, 309, 292, 275, 258, 241, 224, 207, 190, 173, 156, 139, 121, 104, 87, 69, 52, 34, 17, 0};
this.p = new int[]{0, 17, 34, 52, 69, 87, 105, 122, 140, 158, 176, 194, 212, 230, 249, 267, 286, 305, 324, 344, 363, 383, 404, 424, 445, 466, 487, 509, 531, 554, 577, 600, 624, 649, 674, 700, 726, 753, 781, 809, 839, 869, 900, 932, 965, 999, 1035, 1072, 1110, 1150, 1191, 1234, 1279, 1327, 1376, 1428, 1482, 1539, 1600, 1664, 1732, 1804, 1880, 1962, 2050, 2144, 2246, 2355, 2475, 2605, 2747, 2904, 3077, 3270, 3487, 3732, 4010, 4331, 4704, 5144, 5671, 6313, 7115, 8144, 9514, 11430, 14300, 19081, 28636, 57289, Integer.MAX_VALUE};
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.LangLa_hi");
public static SessionState $state_LangLa_hi() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
