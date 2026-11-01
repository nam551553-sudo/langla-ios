package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_bt extends LangLa_kj {
   public Item[] a = new Item[1];
   public Item[] b = new Item[20];
   public Item[] c;
   private LangLa_ij[] g = new LangLa_ij[3];
   private LangLa_dz h;
   public int d;
   public LangLa_jw e;
   public boolean f;

   public LangLa_bt(MainScreen var1) {
      super(var1, new String[]{Caption.rx[8], Caption.H});
      this.g[0] = new LangLa_ij((byte)1, 202, this.a_() + 20, 30, 30, 30, 1, 1);
      this.g[1] = new LangLa_ij((byte)1, 242, this.a_() + 20, 30, 30, 30, 1, 1);
      this.g[2] = new LangLa_ij((byte)0, 14, this.a_() + 20, 128, 160, 32, 5, 4);
      this.h = this.a(this.width - 70, this.height - 33, Caption.t, this, 0, -8);
      this.a(this.h, 0);
   }

   public void a() {
      this.t = new Item[Char.gI().arrItemBag.length];
      int var1 = 0;

      for(int var2 = 0; var2 < Char.gI().arrItemBag.length; ++var2) {
         if (Char.gI().arrItemBag[var2] != null && Char.gI().arrItemBag[var2].s()) {
            this.t[var1] = Char.gI().arrItemBag[var2];
            ++var1;
         }
      }

   }

   public void a(int var1) {
      super.a(var1);
      if (this.f) {
         this.a[0] = null;
      }

      this.f = false;
   }

   public void b() {
      super.b();
      if (this.k() == 0) {
         int var1;
         for(var1 = 0; var1 < this.b.length; ++var1) {
            this.b[var1] = null;
         }

         if (!this.f) {
            if (this.a[0] == null) {
               this.c = null;
            } else if (this.c != null) {
               for(var1 = 0; var1 < this.c.length; ++var1) {
                  this.b[var1] = this.c[var1];
                  this.b[var1].isLock = true;
               }
            } else {
               this.b[0] = new Item(this.a[0].id);
               ItemOption[] var5;
               if ((var5 = this.a[0].L()) != null) {
                  label80:
                  for(int var2 = 0; var2 < var5.length; ++var2) {
                     if (var5[var2].getItemOptionTemplate().type == 14) {
                        for(int var3 = 0; var3 < this.b.length; ++var3) {
                           if (this.b[var3] == null) {
                              int var4 = 0;

                              while(true) {
                                 if (var4 >= DataCenter.gI().ItemTemplate.length) {
                                    continue label80;
                                 }

                                 if (DataCenter.gI().ItemTemplate[var4].name.trim().toLowerCase().equals(var5[var2].getItemOptionTemplate().name.trim().toLowerCase())) {
                                    this.b[var3] = new Item(DataCenter.gI().ItemTemplate[var4].id);
                                    this.b[var3].isLock = true;
                                    continue label80;
                                 }

                                 ++var4;
                              }
                           }
                        }
                     }
                  }
               }
            }
         }

         for(var1 = 0; var1 < this.g.length; ++var1) {
            this.g[var1].a();
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
         mFont.b(mFont.d, var1, Caption.nL, 14, this.a_() + 9, 0, -10831436, -16777216);
         LangLa_fq.a(var1, 95, -360, this.g[0].cx - 40 - DataCenter.gI().i / 3 % 3, this.a_() + 25, 20);
         if (this.f) {
            if (DataCenter.gI().i % 20 > 12) {
               mFont.b(mFont.d, var1, Caption.nP, 149, this.a_() + 108, 0, -2560, -16777216);
            }
         } else {
            mFont.b(mFont.d, var1, Caption.nQ, 149, this.a_() + 68, 0, -30976, -16777216);
         }

         a(var1, this.g[0].cx, this.g[0].cy, this.a[0], this.g[0].k >= 0, Caption.rS[0]);
         this.a(var1, this.g[2]);

         for(int var2 = 0; var2 < this.g[2].i; ++var2) {
            for(int var3 = 0; var3 < this.g[2].r; ++var3) {
               b(var1, var3 * this.g[2].h, var2 * this.g[2].h, this.b[var2 * this.g[2].r + var3], var2 * this.g[2].i + var3 == this.g[2].k, "");
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
            if (var2 != 1) {
               var1.addElement(this.g[var2].a(1001 + var2, this));
            }
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
            if (this.a[0] == null) {
               this.a(2);
               DataCenter.gI().currentScreen.showMessage(Caption.nN, -1);
               return;
            }

            this.d = 1;
            this.a(var1.j, var1.j.k);
            this.cL = a(var1, this, this.a[0]);
            return;
         case 1002:
            this.d = 0;
            this.a(var1.j, var1.j.k);
            this.cL = a(var1, this, this.a[1]);
            return;
         case 1003:
            this.d = 0;
            this.a(var1.j, var1.j.k);
            var2 = var1.j.k / 5;
            var3 = var1.j.k % 5;
            this.cL = b(var1, this, this.b[var2 * 4 + var3]);
            return;
         case 2001:
            this.a(false);
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

      for(int var1 = 0; var1 < this.a.length; ++var1) {
         if (this.a[var1] != null && this.a[var1].index >= 0) {
            Char.gI().h(this.a[var1].TYPE_TEMP)[this.a[var1].index] = this.a[var1];
            this.a[var1] = null;
         }
      }

   }

   private void a(boolean var1) {
      try {
         if (this.a[0] != null && this.a[0].level > 0) {
            if (var1) {
               DataCenter.gI().currentScreen.a(Caption.nM, 2001, this);
            } else {
               Message var3;
               (var3 = new Message((byte)-51)).writeByte(this.a[0].TYPE_TEMP);
               var3.writeShort(this.a[0].index);
               var3.send();
            }
         } else {
            DataCenter.gI().currentScreen.showMessage(Caption.nL, -65536);
         }
      } catch (Exception var2) {
         Utlis.println(var2);
      }
   }

   public void e() {
      try {
         Message var1;
         (var1 = new Message((byte)-52)).writeByte(this.a[0].TYPE_TEMP);
         var1.writeShort(this.a[0].index);
         var1.send();
      } catch (Exception var2) {
      }
   }
}
