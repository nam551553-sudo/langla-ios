package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_au extends LangLa_ge {
   public Item a;
   public Item[] b = new Item[16];
   private LangLa_ij[] e = new LangLa_ij[2];
   private LangLa_dz f;
   private LangLa_dz g;
   private long h = 0L;
   private int i = 0;
   private int u = 0;
   private LangLa_cl[] v = new LangLa_cl[2];
   private LangLa_kc w;
   private int x = 0;
   public LangLa_jw c;
   public LangLa_cg d;

   public LangLa_au(MainScreen var1) {
      super(var1, new String[]{Caption.rx[0]});
      this.e[0] = new LangLa_ij((byte)1, 193, this.a_() + 20, 30, 30, 30, 1, 1);
      this.e[1] = new LangLa_ij((byte)1, 14, this.a_() + 20, 128, 128, 32, 4, 4);
      this.f = this.a(this.width - 70, this.height - 33, Caption.bi, this, 0, -8);
      this.a(this.f, 0);
      this.g = this.a(109, this.height - 33, Caption.jY, this, 2002, -8);
      this.a(this.g, 0);
      LangLa_kd var3;
      int var2 = (var3 = new LangLa_kd(2000, Caption.rY)).c.length;
      if (DataCenter.gI().heightScreen <= 240) {
         var2 -= 3;
      }

      this.d = this.a(14, this.height - 32, 90, var2, var3, this, 1);
      this.d.a(mConfig.gI().readByte(7));
      this.a(this.d, 0);
      this.w = new LangLa_kc(0, 1);
      this.v[0] = this.a(149, this.a_() + 58, Caption.br, this, this.w);
      this.v[1] = this.a(149, this.a_() + 78, Caption.bs, this, this.w);
      this.a(this.v[0], 0);
      this.a(this.v[1], 0);
      if (beatdz.SettingsTab.$state_SettingsTab().g) {
         beatdz.SettingsTab.$state_SettingsTab().g = false;
         this.e();
      }

   }

   public void a() {
      this.t = new Item[Char.gI().arrItemBag.length];
      int var1 = 0;

      for(int var2 = 0; var2 < Char.gI().arrItemBag.length; ++var2) {
         if (Char.gI().arrItemBag[var2] != null && Char.gI().arrItemBag[var2].q()) {
            this.t[var1] = Char.gI().arrItemBag[var2];
            ++var1;
         }
      }

   }

   private void e() {
      if (this.a != null) {
         this.d(this.a.index);
      }

      this.a = null;
      int var1 = this.d.b.b;
      int var2 = 0;
      boolean var3 = this.w.b != 0;

      for(int var4 = 0; var4 < Char.gI().arrItemBag.length && var2 < 16; ++var4) {
         if (Char.gI().arrItemBag[var4] != null && Char.gI().arrItemBag[var4].isLock == var3 && Char.gI().arrItemBag[var4].q() && Char.gI().arrItemBag[var4].getItemTemplate().id <= var1) {
            this.a(Char.gI().arrItemBag[var4]);
            ++var2;
         }
      }

      this.b();
   }

   private void a(Item var1) {
      try {
         for(int var2 = 0; var2 < this.b.length; ++var2) {
            if (this.b[var2] == null) {
               this.b[var2] = var1;
               break;
            }
         }

         Char.gI().arrItemBag[var1.index] = null;
      } catch (Exception var3) {
         Utlis.println(var3);
      }
   }

   public void a(int var1) {
      super.a(var1);
      if (var1 == 1) {
         if (this.a != null) {
            this.d(this.a.index);
         }

         this.a = null;
      }

   }

   public void b() {
      try {
         super.b();
         if (this.k() == 0) {
            this.i = this.u = 0;
            this.h = 0L;

            int var1;
            for(var1 = 0; var1 < this.b.length; ++var1) {
               if (this.b[var1] != null) {
                  ++this.u;
                  Item var10003 = this.b[var1];
                  this.h += DataCenter.gI().pointGhepDa[var10003.id];
               }
            }

            if (this.h > 0L) {
               for(this.i = DataCenter.gI().pointGhepDa.length - 1; this.i >= 0 && this.h <= DataCenter.gI().pointGhepDa[this.i]; --this.i) {
               }
            }

            for(var1 = 0; var1 < this.e.length; ++var1) {
               this.e[var1].a();
            }
         } else {
            this.a();
         }

         if (this.c != null) {
            this.c.p();
            if (this.c.r()) {
               this.c = null;
            }
         }

         if (this.x > 0) {
            --this.x;
         }

      } catch (Exception var2) {
         Utlis.println(var2);
      }
   }

   public void a(Graphics var1) {
      try {
         if (this.j() <= 0) {
            this.a(var1, this.cx, this.cy, this.width, this.height, Caption.q, (byte)2, this.r);
         } else {
            super.a(var1);
         }

         if (this.k() == 0) {
            mFont.b(mFont.d, var1, Caption.bh, 14, this.a_() + 9, 0, -10831436, -16777216);
            b(var1, this.e[0].cx, this.e[0].cy, this.a, this.e[0].k >= 0, Caption.I);
            LangLa_fq.a(var1, 95, 0, 158 - DataCenter.gI().i / 3 % 3, this.a_() + 25, 20);
            if (this.h > 0L && this.u > 1) {
               if (this.i + 1 >= DataCenter.gI().pointGhepDa.length) {
                  if (this.x == 0 || this.x % 10 > 5) {
                     mFont.b(mFont.d, var1, Caption.bo, 149, this.a_() + 108, 0, -30976, -16777216);
                  }
               } else {
                  mFont.b(mFont.d, var1, Caption.bm + " " + (this.i + 2), 149, this.a_() + 108, 0, -30976, -16777216);
                  mFont.b(mFont.d, var1, Caption.aX + " " + this.h * 100L / DataCenter.gI().pointGhepDa[this.i + 1] + "%", 149, this.a_() + 124, 0, -30976, -16777216);
                  mFont.b(mFont.d, var1, (this.w.b == 0 ? Caption.aY : Caption.aZ) + " " + Utlis.numberFormat(DataCenter.gI().bacKhoaGhepDa[this.i + 1]), 149, this.a_() + 140, 0, -30976, -16777216);
               }
            }

            this.a(var1, this.e[1]);

            for(int var2 = 0; var2 < this.e[1].i; ++var2) {
               for(int var3 = 0; var3 < this.e[1].r; ++var3) {
                  if (var3 % 2 == 0) {
                     b(var1, var3 * this.e[1].h, var2 * this.e[1].h, this.b[var2 * this.e[1].r + var3], var2 * this.e[1].i + var3 == this.e[1].k, "");
                  } else if (var3 % 2 == 1) {
                     b(var1, var3 * this.e[1].h, var2 * this.e[1].h, this.b[var2 * this.e[1].r + var3], var2 * this.e[1].i + var3 == this.e[1].k, "");
                  } else {
                     b(var1, var3 * this.e[1].h, var2 * this.e[1].h, this.b[var2 * this.e[1].r + var3], var2 * this.e[1].i + var3 == this.e[1].k);
                  }
               }
            }

            this.b(var1);
            if (this.c != null) {
               this.c.b(var1, this.e[0].cx + this.e[0].h / 2, this.e[0].cy + this.e[0].h / 2);
            }
         }

      } catch (Exception var4) {
         Utlis.println(var4);
      }
   }

   public Vector c() {
      Vector var1 = super.c();
      if (this.k() == 0) {
         for(int var2 = 0; var2 < this.e.length; ++var2) {
            var1.addElement(this.e[var2].a(1001 + var2, this));
         }
      }

      return var1;
   }

   public void a(int var1, Object var2, LangLa_cy var3) {
      if (var1 == 2000) {
         mConfig.gI().writeByte(7, this.d.b.b);
      }

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
            this.a(var1.j, var1.j.k);
            this.cL = a(var1, this, this.a);
            if (this.a == null) {
               this.a(1);
               DataCenter.gI().currentScreen.showMessage(Caption.mr, -1);
               return;
            }
            break;
         case 1002:
            this.a(var1.j, var1.j.k);
            this.cL = a(var1, this, this.b[var1.j.k]);
            return;
         case 2001:
            this.a(false);
            return;
         case 2002:
            this.e();
         }
      }

   }

   private void a(LangLa_ii var1, int var2) {
      for(int var3 = 0; var3 < this.e.length; ++var3) {
         this.e[var3].k = -1;
      }

      var1.k = var2;
   }

   public void d() {
      super.d();

      for(int var1 = 0; var1 < this.b.length; ++var1) {
         if (this.b[var1] != null) {
            int var10001 = this.b[var1].index;
            Char.gI().arrItemBag[var10001] = this.b[var1];
            this.b[var1] = null;
         }
      }

   }

   private void a(boolean var1) {
      try {
         if (this.u < 2) {
            DataCenter.gI().currentScreen.showMessage(Caption.bp, -65536);
         } else if (this.i + 1 >= DataCenter.gI().pointGhepDa.length) {
            this.x = 50;
         } else {
            boolean var2 = false;
            int var3;
            if (this.w.b == 0) {
               for(var3 = 0; var3 < this.b.length; ++var3) {
                  if (this.b[var3] != null && this.b[var3].isLock) {
                     var2 = true;
                     break;
                  }
               }
            } else {
               for(var3 = 0; var3 < this.b.length; ++var3) {
                  if (this.b[var3] != null && !this.b[var3].isLock) {
                     var2 = true;
                     break;
                  }
               }
            }

            if (var1 && var2) {
               DataCenter.gI().currentScreen.a(Caption.bq, 2001, this);
            } else {
               Message var7;
               (var7 = new Message((byte)108)).writeBoolean(this.w.b != 0);
               int var5 = 0;

               int var6;
               for(var6 = 0; var6 < this.b.length; ++var6) {
                  if (this.b[var6] != null) {
                     ++var5;
                  }
               }

               var7.writeByte(var5);

               for(var6 = 0; var6 < this.b.length; ++var6) {
                  if (this.b[var6] != null) {
                     var7.writeShort(this.b[var6].index);
                  }
               }

               var7.send();
            }
         }
      } catch (Exception var4) {
         Utlis.println(var4);
      }
   }
}
