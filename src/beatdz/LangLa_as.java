package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_as extends LangLa_kj {
   public Item[] a = new Item[2];
   public Item[] b = new Item[6];
   private LangLa_ij[] g = new LangLa_ij[2];
   private LangLa_cl[] h = new LangLa_cl[2];
   private LangLa_dz i;
   private LangLa_dz u;
   public int c;
   private LangLa_kc v;
   public int d = 0;
   public LangLa_jw e;
   public LangLa_cg f;

   public LangLa_as(MainScreen var1) {
      super(var1, new String[]{Caption.rx[2], Caption.H});
      this.g[0] = new LangLa_ij((byte)1, 124, this.a_() + 20, 30, 30, 30, 1, 1);
      this.g[1] = new LangLa_ij((byte)1, 14, this.a_() + 20, 64, 96, 32, 3, 2);
      this.i = this.a(this.width - 70, this.height - 33, Caption.bj, this, 0, -8);
      this.a(this.i, 0);
      this.u = this.a(139, this.height - 33, Caption.jY, this, 2002, -8);
      this.a(this.u, 0);
      LangLa_kd var3 = new LangLa_kd(2000, Caption.sE);
      this.f = this.a(14, this.height - 32, 120, var3.c.length, var3, this, 1);
      this.f.a(0);
      this.a(this.f, 0);
      this.v = new LangLa_kc(0);
      this.h[0] = this.a(89, this.a_() + 77, "", this, this.v);
      this.h[1] = this.a(89, this.a_() + 97, "", this, this.v);
      this.a(this.h[0], 0);
      this.a(this.h[1], 0);
   }

   public void a() {
      this.t = new Item[Char.gI().arrItemBag.length];
      int var1 = 0;

      for(int var2 = 0; var2 < Char.gI().arrItemBag.length; ++var2) {
         if (Char.gI().arrItemBag[var2] != null && Char.gI().arrItemBag[var2].C()) {
            this.t[var1] = Char.gI().arrItemBag[var2];
            ++var1;
         }
      }

   }

   public void b() {
      super.b();
      if (this.k() == 0) {
         int var1 = 0;

         int var2;
         for(var2 = 0; var2 < this.b.length; ++var2) {
            if (this.b[var2] != null) {
               var1 += this.b[var2].getAmount();
            }
         }

         LangLa_cl var10000;
         boolean var5;
         if (this.a[0] != null) {
            ItemOption[] var6 = this.a[0].L();

            for(int var3 = 0; var3 < this.h.length; ++var3) {
               var10000 = this.h[var3];
               var5 = false;
               var10000.v = var5;
               if (this.h[var3].a) {
                  this.h[var3].a(var6[var3].b(var1));
               } else {
                  this.h[var3].a(var6[var3].b(0));
               }
            }
         } else {
            for(var2 = 0; var2 < this.h.length; ++var2) {
               var10000 = this.h[var2];
               var5 = true;
               var10000.v = var5;
            }
         }

         for(var2 = 0; var2 < this.g.length; ++var2) {
            this.g[var2].a();
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
         mFont.b(mFont.d, var1, Caption.bb, 14, this.a_() + 9, 0, -10831436, -16777216);
         if (this.a[0] != null) {
            mFont.b(mFont.d, var1, Caption.bc, 89, this.a_() + 65, 0, -10831436, -16777216);
         }

         a(var1, this.g[0].cx, this.g[0].cy, this.a[0], this.g[0].k >= 0, Caption.aK);
         LangLa_fq.a(var1, 95, 0, 92 - DataCenter.gI().i / 3 % 3, this.a_() + 25, 20);
         if (this.d > 0 && this.d % 14 > 2) {
            mFont.b(mFont.d, var1, Caption.jO, 89, this.a_() + 125, 0, -2560, -16777216);
         }

         this.a(var1, this.g[1]);
         int var2 = 0;

         for(int var3 = 0; var3 < this.g[1].i; ++var3) {
            for(int var4 = 0; var4 < this.g[1].r; ++var4) {
               if (var4 % 2 == 0) {
                  b(var1, var4 * this.g[1].h, var3 * this.g[1].h, this.b[var3 * this.g[1].r + var4], var2 == this.g[1].k, Caption.rg[0]);
               } else {
                  b(var1, var4 * this.g[1].h, var3 * this.g[1].h, this.b[var3 * this.g[1].r + var4], var2 == this.g[1].k, Caption.rg[1]);
               }

               ++var2;
            }
         }

         this.b(var1);
         if (this.e != null) {
            this.e.b(var1, this.g[0].cx + this.g[0].h / 2, this.g[0].cy + this.g[0].h / 2);
         }
      }

   }

   public Vector c() {
      Vector var1 = super.c();
      if (this.k() == 0) {
         for(int var2 = 0; var2 < this.g.length; ++var2) {
            var1.addElement(this.g[var2].a(1001 + var2, this));
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
         switch(var1.b) {
         case 0:
            LangLa_as var7 = this;

            try {
               var2 = 0;

               for(var3 = 0; var3 < var7.b.length; ++var3) {
                  if (var7.b[var3] != null) {
                     ++var2;
                  }
               }

               if (var7.a[0] != null && var2 != 0) {
                  ItemOption var8;
                  if ((var8 = var7.a[0].L()[var7.v.b]).a[1] >= var8.f()) {
                     DataCenter.gI().currentScreen.showMessage(Caption.jQ, -2560);
                  } else {
                     Message var9;
                     (var9 = new Message((byte)106)).writeByte(var7.v.b);
                     var9.writeByte(var7.a[0].TYPE_TEMP);
                     var9.writeShort(var7.a[0].index);
                     var9.writeByte(var2);

                     for(var2 = 0; var2 < var7.b.length; ++var2) {
                        if (var7.b[var2] != null) {
                           var9.writeShort(var7.b[var2].index);
                        }
                     }

                     var9.send();
                  }
               } else {
                  DataCenter.gI().currentScreen.showMessage(Caption.jP, -65536);
               }
               break;
            } catch (Exception var5) {
               Utlis.println(var5);
               return;
            }
         case 1001:
            this.c = 1;
            this.a(var1.j, var1.j.k);
            this.cL = a(var1, this, this.a[0]);
            if (this.a[0] == null) {
               this.a(2);
               DataCenter.gI().currentScreen.showMessage(Caption.mt, -1);
               return;
            }
            break;
         case 1002:
            this.c = 2;
            this.a(var1.j, var1.j.k);
            this.cL = a(var1, this, this.b[var1.j.k]);
            return;
         case 2002:
            boolean var6 = this.f.b.b == 0;

            for(var2 = 0; var2 < Char.gI().arrItemBag.length; ++var2) {
               if (Char.gI().arrItemBag[var2] != null && Char.gI().arrItemBag[var2].id == 160 && Char.gI().arrItemBag[var2].isLock == var6) {
                  for(var3 = 0; var3 < this.b.length; ++var3) {
                     if (this.b[var3] == null) {
                        this.b[var3] = Char.gI().arrItemBag[var2];
                        Char.gI().arrItemBag[var2] = null;
                        break;
                     }
                  }
               }
            }
         }
      }

   }

   private void a(LangLa_ii var1, int var2) {
      for(int var3 = 0; var3 < this.g.length; ++var3) {
         this.g[var3].k = -1;
      }

      var1.k = var2;
   }

   public void d() {
      super.d();
      if (this.a[0] != null) {
         Char.gI().h(this.a[0].TYPE_TEMP)[this.a[0].index] = this.a[0];
         this.a[0] = null;
      }

      for(int var1 = 0; var1 < this.b.length; ++var1) {
         if (this.b[var1] != null) {
            int var10001 = this.b[var1].index;
            Char.gI().arrItemBag[var10001] = this.b[var1];
            this.b[var1] = null;
         }
      }

   }
}
