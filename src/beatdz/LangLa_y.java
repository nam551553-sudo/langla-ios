package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_y extends LangLa_kj {
   public Item[] a = new Item[2];
   public Item[] b = new Item[16];
   private LangLa_ij[] h;
   private LangLa_dz i;
   private LangLa_dz u;
   private LangLa_dz v;
   public int c;
   public int d = 0;
   public LangLa_jw e;
   public LangLa_cg f;
   private Vector w;
   private int[] x;
   private int y = 0;
   public int g;

   public LangLa_y(MainScreen var1, int var2) {
      super(var1, new String[]{Caption.rx[5], Caption.H});
      this.g = var2;
      this.h = new LangLa_ij[3];
      this.h[0] = new LangLa_ij((byte)1, 162, this.a_() + 20, 30, 30, 30, 1, 1);
      this.h[1] = new LangLa_ij((byte)1, 242, this.a_() + 20, 30, 30, 30, 1, 1);
      this.h[2] = new LangLa_ij((byte)1, 14, this.a_() + 20, 128, 128, 32, 4, 4);
      this.v = this.a(this.width - 136, this.height - 33, Caption.lQ, this, 1000, -8);
      this.a(this.v, 0);
      this.i = this.a(this.width - 70, this.height - 33, Caption.dm, this, 0, -8);
      this.a(this.i, 0);
      this.u = this.a(89, this.height - 33, Caption.jY, this, 2002, -8);
      this.u.setSize(this.u.width + 1, this.u.height);
      this.a(this.u, 0);
      this.w = new Vector();

      for(int var3 = 0; var3 < DataCenter.gI().ItemTemplate.length; ++var3) {
         if (DataCenter.gI().ItemTemplate[var3].type == 32) {
            this.w.add(DataCenter.gI().ItemTemplate[var3]);
         }
      }

      String[] var4 = new String[this.w.size()];

      for(var2 = 0; var2 < this.w.size(); ++var2) {
         var4[var2] = ((ItemTemplate)this.w.get(var2)).name;
      }

      LangLa_kd var5 = new LangLa_kd(2000, var4);
      this.f = this.a(14, this.height - 32, 70, var5.c.length, var5, this, 1);
      this.f.a(0);
      this.a(this.f, 0);
   }

   public void a() {
      this.t = new Item[Char.gI().arrItemBag.length];
      int var1 = 0;

      for(int var2 = 0; var2 < Char.gI().arrItemBag.length; ++var2) {
         if (Char.gI().arrItemBag[var2] != null && Char.gI().arrItemBag[var2].w()) {
            this.t[var1] = Char.gI().arrItemBag[var2];
            ++var1;
         }
      }

   }

   public void e() {
      for(int var1 = 0; var1 < this.b.length; ++var1) {
         if (this.b[var1] != null) {
            int var10001 = this.b[var1].index;
            Char.gI().arrItemBag[var10001] = this.b[var1];
            this.b[var1] = null;
         }
      }

   }

   public void b() {
      super.b();
      if (this.k() == 0) {
         this.a[1] = null;
         this.x = null;
         this.y = 0;
         if (this.a[0] != null) {
            boolean var1 = true;
            int var2 = -1;

            for(int var3 = 0; var3 < this.b.length; ++var3) {
               if (this.b[var3] != null) {
                  if (var2 == -1) {
                     var2 = this.b[var3].id;
                  } else if (var2 != this.b[var3].id) {
                     var1 = false;
                     break;
                  }

                  this.y += this.b[var3].getAmount();
               }
            }

            this.a[1] = this.a[0].a();
            Vector var7 = new Vector();
            ItemOption var4;
            if ((var4 = this.a[1].a(var7, var2)) != null) {
               if (var4.a(this.a[1])) {
                  var1 = false;
               }
            } else {
               int var8 = this.a[1].Z() + this.g;
               if (var7.size() >= var8) {
                  var1 = false;
               } else {
                  var7 = new Vector();
                  ItemOption[] var9 = this.a[1].L();

                  for(int var5 = 0; var5 < var9.length; ++var5) {
                     var7.add(var9[var5]);
                  }

                  if (this.a[1].V()) {
                     var7.insertElementAt(ItemOption.g(var2), var7.size() - 1);
                  } else {
                     var7.add(ItemOption.g(var2));
                  }

                  this.a[1].strOptions = Item.a(var7);
               }
            }

            if (this.y > 0) {
               this.x = this.a[1].a(this.y, var2);
            } else {
               this.x = null;
            }

            if (!var1 || this.x == null || this.x[1] == this.x[2]) {
               this.a[1] = null;
            }
         }

         for(int var6 = 0; var6 < this.h.length; ++var6) {
            this.h[var6].a();
         }
      } else {
         this.a();
      }

      if (this.e != null) {
         this.e.p();
         if (this.e.r()) {
            this.e = null;
         }
      }

      if (this.d > 0) {
         --this.d;
      }

   }

   public void a(Graphics var1) {
      if (this.j() <= 0) {
         this.a(var1, this.cx, this.cy, this.width, this.height, Caption.q, (byte)2, this.r);
      } else {
         super.a(var1);
      }

      if (this.k() == 0) {
         mFont.b(mFont.d, var1, Caption.cg, 14, this.a_() + 9, 0, -10831436, -16777216);
         a(var1, this.h[0].cx, this.h[0].cy, this.a[0], this.h[0].k >= 0, Caption.H);
         a(var1, this.h[1].cx, this.h[2].cy, this.a[1], this.h[1].k >= 0, Caption.I);
         LangLa_fq.a(var1, 95, 0, 210 - DataCenter.gI().i / 3 % 3, this.a_() + 25, 20);
         if (this.g > 0) {
            mFont.b(mFont.d, var1, "- " + Utlis.replaceAll(Caption.hc, "" + this.g), 150, this.a_() + 60, 0, -2560, -16777216);
         }

         if (this.a[0] != null) {
            mFont.b(mFont.d, var1, "- " + Utlis.replaceAll(Caption.gZ, "" + (this.a[0].Z() + this.g)), 150, this.a_() + 74, 0, -1, -16777216);
         }

         int var2;
         if (this.x != null) {
            if (this.d == 0 || this.d % 12 > 2) {
               var2 = this.a[0].Y();
               if (this.x[1] >= var2) {
                  mFont.b(mFont.d, var1, "- " + Caption.dm + " " + DataCenter.gI().ItemTemplate[this.x[0]].name + " " + Caption.lK, 150, this.a_() + 102, 0, -2560, -16777216);
               } else {
                  if (this.x[1] == this.x[2]) {
                     mFont.b(mFont.d, var1, "- " + Caption.dm + " " + DataCenter.gI().ItemTemplate[this.x[0]].name + " " + Caption.dn + " " + (this.x[1] + 1), 150, this.a_() + 102, 0, -65536, -16777216);
                     mFont var10000 = mFont.d;
                     StringBuilder var10002 = (new StringBuilder("- ")).append(Caption.lL).append(" ");
                     int var10004 = this.x[1];
                     mFont.b(var10000, var1, var10002.append(DataCenter.gI().ngocKhamUpgrade[var10004 + 1]).append(" ").append(Caption.lM).toString(), 150, this.a_() + 116, 0, -65536, -16777216);
                  } else {
                     mFont.b(mFont.d, var1, "- " + Caption.dm + " " + DataCenter.gI().ItemTemplate[this.x[0]].name + " " + Caption.dn + " " + this.x[2], 150, this.a_() + 88, 0, -1, -16777216);
                     mFont.b(mFont.d, var1, "- " + Caption.cZ + this.x[1], 150, this.a_() + 102, 0, -1, -16777216);
                     mFont.b(mFont.d, var1, "- " + Caption.lL + " " + this.x[3] + " " + Caption.lM, 150, this.a_() + 116, 0, -1, -16777216);
                     if (this.y > this.x[3]) {
                        mFont.b(mFont.d, var1, "- " + Caption.lN, 150, this.a_() + 130, 0, -2560, -16777216);
                     }
                  }

                  if (this.x[2] >= 18) {
                     mFont.b(mFont.d, var1, "- " + Caption.qL, 150, this.a_() + 144, 0, -2560, -16777216);
                  }
               }
            }
         } else if (this.d > 0 && this.d % 14 > 2) {
            mFont.b(mFont.d, var1, Caption.kp, 150, this.a_() + 130, 0, -2560, -16777216);
         }

         this.a(var1, this.h[2]);
         var2 = 0;

         for(int var3 = 0; var3 < this.h[2].i; ++var3) {
            for(int var4 = 0; var4 < this.h[2].r; ++var4) {
               if (var4 % 2 == 0) {
                  b(var1, var4 * this.h[2].h, var3 * this.h[2].h, this.b[var3 * this.h[2].r + var4], var2 == this.h[2].k, Caption.rg[2]);
               } else {
                  b(var1, var4 * this.h[2].h, var3 * this.h[2].h, this.b[var3 * this.h[2].r + var4], var2 == this.h[2].k, Caption.rg[3]);
               }

               ++var2;
            }
         }

         this.b(var1);
         if (this.e != null) {
            this.e.b(var1, this.h[0].cx + this.h[0].h / 2, this.h[0].cy + this.h[0].h / 2);
         }
      }

   }

   public Vector c() {
      Vector var1 = super.c();
      if (this.k() == 0) {
         for(int var2 = 0; var2 < this.h.length; ++var2) {
            var1.addElement(this.h[var2].a(1001 + var2, this));
         }
      }

      return var1;
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      if (this.k() == this.j() && var1.b == 0) {
         this.d();
      }

      super.a(var1, var2, var3);
      if (this.k() == 0) {
         LangLa_y var10;
         switch(var1.b) {
         case 0:
            var10 = this;

            try {
               var2 = 0;

               for(var3 = 0; var3 < var10.b.length; ++var3) {
                  if (var10.b[var3] != null) {
                     ++var2;
                  }
               }

               if (var10.a[0] != null && var2 != 0) {
                  var3 = var10.a[0].Y();
                  if (var10.x == null || var10.x[1] < var3 && var10.x[1] != var10.x[2]) {
                     Message var13;
                     (var13 = new Message((byte)-46)).writeByte(var10.a[0].TYPE_TEMP);
                     var13.writeShort(var10.a[0].index);
                     var2 = 0;

                     int var14;
                     for(var14 = 0; var14 < var10.b.length; ++var14) {
                        if (var10.b[var14] != null) {
                           ++var2;
                        }
                     }

                     var13.writeByte(var2);

                     for(var14 = 0; var14 < var10.b.length; ++var14) {
                        if (var10.b[var14] != null) {
                           var13.writeShort(var10.b[var14].index);
                        }
                     }

                     var13.send();
                  } else {
                     var10.d = 100;
                  }
               } else {
                  DataCenter.gI().currentScreen.showMessage(Caption.kA, -65536);
               }
               break;
            } catch (Exception var9) {
               Utlis.println(var9);
               return;
            }
         case 1000:
            if (this.g >= 3) {
               DataCenter.gI().currentScreen.showMessage(Caption.hb, -65536);
               return;
            }

            if (Char.gI().level() < 40) {
               DataCenter.gI().currentScreen.showMessage(Caption.lR, -1);
               return;
            }

            int[] var11 = new int[]{500, 1000, 1500};
            DataCenter.gI().currentScreen.a(Utlis.replaceAll(Caption.ha, Utlis.numberFormat(var11[this.g])), 2001, this);
            return;
         case 1001:
            this.c = 1;
            this.a(var1.j, var1.j.k);
            this.cL = a(var1, this, this.a[0]);
            if (this.a[0] == null) {
               this.a(2);
               DataCenter.gI().currentScreen.showMessage(Caption.ms, -1);
               return;
            }
            break;
         case 1002:
            this.c = 2;
            this.a(var1.j, var1.j.k);
            this.cL = a(var1, this, this.a[1]);
            return;
         case 1003:
            this.c = 3;
            this.a(var1.j, var1.j.k);
            this.cL = a(var1, this, this.b[var1.j.k]);
            return;
         case 2001:
            try {
               Message.c((byte)-69).send();
               break;
            } catch (Exception var7) {
               return;
            }
         case 2002:
            var10 = this;
            this.e();
            short var12 = ((ItemTemplate)this.w.get(this.f.b.b)).id;

            for(var3 = 0; var3 < Char.gI().arrItemBag.length; ++var3) {
               if (Char.gI().arrItemBag[var3] != null && Char.gI().arrItemBag[var3].id == var12) {
                  Item var5 = Char.gI().arrItemBag[var3];
                  LangLa_y var4 = var10;

                  try {
                     for(int var6 = 0; var6 < var4.b.length; ++var6) {
                        if (var4.b[var6] == null) {
                           var4.b[var6] = var5;
                           break;
                        }
                     }

                     Char.gI().arrItemBag[var5.index] = null;
                  } catch (Exception var8) {
                     Utlis.println(var8);
                  }
               }
            }
         }
      }

   }

   private void a(LangLa_ii var1, int var2) {
      for(int var3 = 0; var3 < this.h.length; ++var3) {
         this.h[var3].k = -1;
      }

      var1.k = var2;
   }

   public void d() {
      super.d();
      if (this.a[0] != null) {
         Char.gI().h(this.a[0].TYPE_TEMP)[this.a[0].index] = this.a[0];
         this.a[0] = null;
      }

      this.e();
   }
}
