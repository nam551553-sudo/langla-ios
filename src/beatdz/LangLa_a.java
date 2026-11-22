package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_a extends LangLa_kj {
   public Item[] a = new Item[3];
   private LangLa_ij[] e = new LangLa_ij[3];
   private LangLa_dz f;
   public int b;
   private int g;
   public boolean c;
   public LangLa_jw d;

   public LangLa_a(MainScreen var1) {
      super(var1, new String[]{Caption.bf, Caption.H});
      this.e[0] = new LangLa_ij((byte)1, 94, this.a_() + 20, 30, 30, 30, 1, 1);
      this.e[1] = new LangLa_ij((byte)1, 174, this.a_() + 20, 30, 30, 30, 1, 1);
      this.e[2] = new LangLa_ij((byte)1, 134, this.a_() + 65, 30, 30, 30, 1, 1);
      this.f = this.a(this.width - 70, this.height - 33, Caption.bf, this, 0, -8);
      this.a(this.f, 0);
   }

   public void a() {
      this.t = new Item[Char.gI().arrItemBag.length];
      int var1 = 0;

      for(int var2 = 0; var2 < Char.gI().arrItemBag.length; ++var2) {
         if (Char.gI().arrItemBag[var2] != null && Char.gI().arrItemBag[var2].A()) {
            this.t[var1] = Char.gI().arrItemBag[var2];
            ++var1;
         }
      }

   }

   public void b() {
      try {
         super.b();
         if (this.k() == 0) {
            for(int var1 = 0; var1 < this.e.length; ++var1) {
               this.e[var1].a();
            }
         } else {
            this.a();
         }

         if (this.d != null) {
            this.d.p();
            if (this.d.r()) {
               this.d = null;
            }
         }

         if (this.g > 0) {
            --this.g;
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
            mFont.b(mFont.d, var1, Caption.bg, 4 + (super.width - 8) / 2, this.a_() + 9, 2, -10831436, -16777216);
            a(var1, this.e[0].cx, this.e[0].cy, this.a[0], this.e[0].k >= 0, Caption.H);
            a(var1, this.e[1].cx, this.e[1].cy, this.a[1], this.e[1].k >= 0, Caption.H);
            a(var1, this.e[2].cx, this.e[2].cy, this.a[2], this.e[2].k >= 0, Caption.bt);
            LangLa_fq.a(var1, 95, 0, 142 - DataCenter.gI().i / 3 % 3, this.a_() + 25, 20);
            if (this.a[0] != null) {
               mFont.b(mFont.d, var1, "(+" + this.a[0].level + ")", 101, this.a_() + 60, 33, -1, -16777216);
            }

            if (this.a[1] != null) {
               mFont.b(mFont.d, var1, "(+" + this.a[1].level + ")", 181, this.a_() + 60, 33, -1, -16777216);
            }

            if (this.c) {
               mFont.c(mFont.d, var1, Caption.es, 24, this.a_() + 108, 0, -2560, -16777216);
               mFont.c(mFont.d, var1, Caption.et, 24, this.a_() + 124, 0, -2560, -16777216);
            } else {
               mFont.c(mFont.d, var1, Caption.eu, 24, this.a_() + 108, 0, -1, -16777216);
               mFont.c(mFont.d, var1, Caption.ev, 24, this.a_() + 124, 0, -1, -16777216);
            }

            if (this.d != null) {
               this.d.b(var1, this.e[1].cx + this.e[1].h / 2, this.e[1].cy + this.e[1].h / 2);
            }
         }

      } catch (Exception var3) {
         Utlis.println(var3);
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
            this.b = 1;
            this.a(var1.j, var1.j.k);
            if (this.a[0] == null) {
               this.cL = b(Caption.ew, this, var1.j.cx + 32, var1.j.cy, 100);
               return;
            }

            this.cL = a(var1, this, this.a[0]);
            return;
         case 1002:
            this.b = 2;
            this.a(var1.j, var1.j.k);
            if (this.a[1] == null) {
               this.cL = b(Caption.ex, this, var1.j.cx + 32, var1.j.cy, 100);
               return;
            }

            this.cL = a(var1, this, this.a[1]);
            return;
         case 1003:
            this.b = 3;
            this.a(var1.j, var1.j.k);
            if (this.a[2] == null) {
               this.cL = b(Caption.ey, this, var1.j.cx + 32, var1.j.cy, 100);
               return;
            }

            this.cL = a(var1, this, this.a[2]);
            return;
         case 2001:
            this.a(false);
         }
      }

   }

   private void a(LangLa_ii var1, int var2) {
      for(int var3 = 0; var3 < this.e.length; ++var3) {
         this.e[var3].k = -1;
      }

      var1.k = var2;
   }

   public void a(int var1) {
      super.a(var1);
      if (this.c) {
         this.c = false;

         for(var1 = 0; var1 < this.a.length; ++var1) {
            this.a[var1] = null;
         }
      }

   }

   public void d() {
      super.d();

      for(int var1 = 0; var1 < this.a.length; ++var1) {
         if (this.a[var1] != null) {
            Char.gI().h(this.a[var1].TYPE_TEMP)[this.a[var1].index] = this.a[var1];
            this.a[var1] = null;
         }
      }

   }

   private void a(boolean var1) {
      try {
         if (this.c) {
            DataCenter.gI().currentScreen.showMessage(Caption.ez, -2560);
         } else if (this.a[0] != null && this.a[1] != null && this.a[2] != null) {
            if (this.a[0].getItemTemplate().type != this.a[1].getItemTemplate().type) {
               DataCenter.gI().currentScreen.showMessage(Caption.eB, -65536);
            } else if (this.a[0].getItemTemplate().levelNeed > this.a[1].getItemTemplate().levelNeed) {
               DataCenter.gI().currentScreen.showMessage(Caption.eC, -65536);
            } else if (this.a[0].level > 14 && this.a[2].id != 158) {
               DataCenter.gI().currentScreen.showMessage(Caption.eD, -65536);
            } else if (this.a[0].level > 10 && this.a[2].id != 158 && this.a[2].id != 157) {
               DataCenter.gI().currentScreen.showMessage(Caption.eE, -65536);
            } else if (var1) {
               DataCenter.gI().currentScreen.a(Caption.eF, 2001, this);
            } else {
               Message var3;
               (var3 = new Message((byte)104)).writeByte(this.a[0].TYPE_TEMP);
               var3.writeShort(this.a[0].index);
               var3.writeByte(this.a[1].TYPE_TEMP);
               var3.writeShort(this.a[1].index);
               var3.writeShort(this.a[2].index);
               var3.send();
            }
         } else {
            DataCenter.gI().currentScreen.showMessage(Caption.eA, -65536);
         }
      } catch (Exception var2) {
         Utlis.println(var2);
      }
   }
}
