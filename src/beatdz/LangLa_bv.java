package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_bv extends LangLa_kj {
   public Item[] a = new Item[2];
   public Item[] b = new Item[16];
   private LangLa_ij[] f = new LangLa_ij[3];
   private LangLa_dz g;
   private int h;
   public int c;
   public boolean d;
   public LangLa_jw e;

   public LangLa_bv(MainScreen var1) {
      super(var1, new String[]{Caption.rx[3], Caption.H});
      this.f[0] = new LangLa_ij((byte)1, 162, this.a_() + 20, 30, 30, 30, 1, 1);
      this.f[1] = new LangLa_ij((byte)1, 242, this.a_() + 20, 30, 30, 30, 1, 1);
      this.f[2] = new LangLa_ij((byte)1, 14, this.a_() + 20, 128, 128, 32, 4, 4);
      this.g = this.a(this.width - 70, this.height - 33, Caption.t, this, 0, -8);
      this.a(this.g, 0);
   }

   public void a() {
      this.t = new Item[Char.gI().arrItemBag.length];
      int var1 = 0;

      for(int var2 = 0; var2 < Char.gI().arrItemBag.length; ++var2) {
         if (Char.gI().arrItemBag[var2] != null && Char.gI().arrItemBag[var2].x()) {
            this.t[var1] = Char.gI().arrItemBag[var2];
            ++var1;
         }
      }

   }

   public void a(int var1) {
      super.a(var1);
      if (this.d) {
         this.d = false;
         this.b[1] = null;
      }

   }

   public void b() {
      super.b();
      if (this.k() == 0) {
         int var1;
         if (!this.d) {
            for(var1 = 0; var1 < this.b.length; ++var1) {
               this.b[var1] = null;
            }

            if (this.a[0] == null) {
               this.a[1] = null;
            } else {
               this.a[1] = this.a[0].a();
               this.a[1].a(0);
               long var7 = 0L;
               int var3 = 0;
               int var4;
               if (this.a[0].k()) {
                  for(var4 = this.a[0].level; var4 > 0; --var4) {
                     var3 += DataCenter.gI().bacKhoaUpgradeVuKhi[var4];
                     var7 += DataCenter.gI().pointUpgradeVuKhi[var4];
                  }
               } else if (this.a[0].l()) {
                  for(var4 = this.a[0].level; var4 > 0; --var4) {
                     var3 += DataCenter.gI().bacKhoaUpgradeTrangBi[var4];
                     var7 += DataCenter.gI().pointUpgradeTrangBi[var4];
                  }
               } else if (this.a[0].m()) {
                  for(var4 = this.a[0].level; var4 > 0; --var4) {
                     var3 += DataCenter.gI().bacKhoaUpgradePhuKien[var4];
                     var7 += DataCenter.gI().pointUpgradePhuKien[var4];
                  }
               }

               var7 /= 3L;
               Vector var8 = new Vector();

               int var5;
               for(var5 = DataCenter.gI().pointGhepDa.length - 1; var5 >= 0 && var7 > 0L; --var5) {
                  if (var7 >= DataCenter.gI().pointGhepDa[var5]) {
                     var7 -= DataCenter.gI().pointGhepDa[var5];
                     Item var6;
                     (var6 = new Item()).id = var5;
                     var6.expiry = -1L;
                     var6.isLock = true;
                     var8.add(var6);
                     var5 = DataCenter.gI().pointGhepDa.length;
                     if (var8.size() >= 16) {
                        break;
                     }
                  }
               }

               for(var5 = 0; var5 < var8.size() && var5 < this.b.length; ++var5) {
                  this.b[var5] = (Item)var8.elementAt(var5);
               }

               this.h = var3 / 3;
            }
         }

         for(var1 = 0; var1 < this.f.length; ++var1) {
            this.f[var1].a();
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

   }

   public void a(Graphics var1) {
      if (this.j() <= 0) {
         this.a(var1, this.cx, this.cy, this.width, this.height, Caption.q, (byte)2, this.r);
      } else {
         super.a(var1);
      }

      if (this.k() == 0) {
         mFont.b(mFont.d, var1, Caption.bd, 14, this.a_() + 9, 0, -10831436, -16777216);
         a(var1, this.f[0].cx, this.f[0].cy, this.a[0], this.f[0].k >= 0, Caption.H);
         a(var1, this.f[1].cx, this.f[1].cy, this.a[1], this.f[1].k >= 0, Caption.I);
         LangLa_fq.a(var1, 95, 0, 210 - DataCenter.gI().i / 3 % 3, this.a_() + 25, 20);
         if (this.a[0] != null) {
            mFont.b(mFont.d, var1, Caption.be + " " + Utlis.numberFormat(this.h), 149, this.a_() + 108, 0, -30976, -16777216);
            mFont.b(mFont.d, var1, Caption.rz[0], 149, this.a_() + 124, 0, -10831436, -16777216);
            mFont.b(mFont.d, var1, Caption.rz[1], 149, this.a_() + 140, 0, -10831436, -16777216);
         }

         this.a(var1, this.f[2]);

         for(int var2 = 0; var2 < this.f[2].i; ++var2) {
            for(int var3 = 0; var3 < this.f[2].r; ++var3) {
               b(var1, var3 * this.f[2].h, var2 * this.f[2].h, this.b[var2 * this.f[2].r + var3], var2 * this.f[2].i + var3 == this.f[2].k, "");
            }
         }

         this.b(var1);
         if (this.e != null) {
            this.e.b(var1, this.f[1].cx + this.f[1].h / 2, this.f[1].cy + this.f[1].h / 2);
         }
      }

   }

   public Vector c() {
      Vector var1 = super.c();
      if (this.k() == 0) {
         for(int var2 = 0; var2 < this.f.length; ++var2) {
            var1.addElement(this.f[var2].a(1001 + var2, this));
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
            this.a(true);
            return;
         case 1001:
            this.c = 1;
            this.a(var1.j, var1.j.k);
            this.cL = a(var1, this, this.a[0]);
            if (this.a[0] == null) {
               this.a(2);
               DataCenter.gI().currentScreen.showMessage(Caption.mu, -1);
               return;
            }
            break;
         case 1002:
            this.c = 0;
            this.a(var1.j, var1.j.k);
            this.cL = a(var1, this, this.a[1]);
            return;
         case 1003:
            this.c = 0;
            this.a(var1.j, var1.j.k);
            this.cL = a(var1, this, this.b[var1.j.k]);
            return;
         case 2001:
            this.a(false);
         }
      }

   }

   private void a(LangLa_ii var1, int var2) {
      for(int var3 = 0; var3 < this.f.length; ++var3) {
         this.f[var3].k = -1;
      }

      var1.k = var2;
   }

   public void d() {
      super.d();
      if (this.a[0] != null) {
         Char.gI().h(this.a[0].TYPE_TEMP)[this.a[0].index] = this.a[0];
         this.a[0] = null;
      }

   }

   private void a(boolean var1) {
      try {
         if (this.d) {
            DataCenter.gI().currentScreen.showMessage(Caption.iE, -1);
         } else if (this.a[0] == null) {
            DataCenter.gI().currentScreen.showMessage(Caption.iF, -65536);
         } else if (var1) {
            DataCenter.gI().currentScreen.a(Caption.iG, 2001, this);
         } else {
            Message var3;
            (var3 = new Message((byte)105)).writeByte(this.a[0].TYPE_TEMP);
            var3.writeShort(this.a[0].index);
            var3.send();
         }
      } catch (Exception var2) {
         Utlis.println(var2);
      }
   }
}
