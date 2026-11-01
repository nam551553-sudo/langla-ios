package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_ag extends LangLa_kj {
   public Item a;
   public Item[] b = new Item[3];
   private LangLa_ij[] g = new LangLa_ij[3];
   private LangLa_dz h;
   private LangLa_dz i;
   private LangLa_dz u;
   public int c;
   private int v;
   public boolean d;
   public LangLa_jw e;
   public LangLa_cg f;

   public LangLa_ag(MainScreen var1) {
      super(var1, new String[]{Caption.pB, Caption.H});
      this.g[0] = new LangLa_ij((byte)1, this.width / 2 - 79, this.a_() + 20, 30, 30, 30, 1, 1);
      this.g[1] = new LangLa_ij((byte)1, this.width / 2 + 60, this.a_() + 20, 30, 30, 30, 1, 1);
      this.g[2] = new LangLa_ij((byte)1, this.width / 2 - 15, this.a_() + 86, 30, 30, 30, 1, 1);
      this.h = this.a(this.width - 70, this.height - 33, Caption.pE, this, 100, -8);
      this.a(this.h, 0);
      this.i = this.a(this.width - 135, this.height - 33, Caption.pJ, this, 101, -8);
      this.a(this.i, 0);
      this.u = this.a(this.g[2].cx + 35, this.g[2].cy + 4, Caption.jY, this, 102, -8);
      this.a(this.u, 0);
      LangLa_kd var3 = new LangLa_kd(2000, Caption.sE);
      this.f = this.a(this.width / 2 - 79, this.a_() + 60, 168, var3.c.length, var3, this, 0);
      this.f.a(0);
      this.f.b(true);
      this.a(this.f, 0);
   }

   public void a() {
      this.t = new Item[Char.gI().arrItemBag.length];
      int var1 = 0;

      for(int var2 = 0; var2 < Char.gI().arrItemBag.length; ++var2) {
         if (Char.gI().arrItemBag[var2] != null && Char.gI().arrItemBag[var2].B()) {
            this.t[var1] = Char.gI().arrItemBag[var2];
            ++var1;
         }
      }

   }

   public void b() {
      try {
         super.b();
         this.i.b(!this.d);
         if (this.k() == 0) {
            for(int var1 = 0; var1 < this.g.length; ++var1) {
               this.g[var1].a();
            }

            this.f.b(this.b[0] == null);
         } else {
            this.a();
         }

         if (this.e != null) {
            this.e.p();
            if (this.e.r()) {
               this.e = null;
            }
         }

         if (this.v > 0) {
            --this.v;
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
            mFont.b(mFont.d, var1, Caption.pC, 4 + (super.width - 8) / 2, this.a_() + 9, 2, -10831436, -16777216);
            a(var1, this.g[0].cx, this.g[0].cy, this.b[0], this.g[0].k >= 0, Caption.H);
            a(var1, this.g[1].cx, this.g[1].cy, this.b[1], this.g[1].k >= 0, Caption.H);
            a(var1, this.g[2].cx, this.g[2].cy, this.b[2], this.g[2].k >= 0, Caption.pD);
            LangLa_fq.a(var1, 95, 0, 142 - DataCenter.gI().i / 3 % 3, this.a_() + 25, 20);
            if (this.d) {
               if (DataCenter.gI().i / 8 % 2 == 0) {
                  mFont.c(mFont.d, var1, Caption.pF, 24, this.a_() + 140, 0, -2560, -16777216);
               }
            } else {
               mFont.c(mFont.d, var1, Caption.pG, 24, this.a_() + 127, 0, -1, -16777216);
               mFont.c(mFont.d, var1, Caption.pH, 24, this.a_() + 142, 0, -1, -16777216);
               mFont.c(mFont.d, var1, Caption.qo, 24, this.a_() + 157, 0, -1, -16777216);
            }

            if (this.e != null) {
               this.e.b(var1, this.g[1].cx + this.g[1].h / 2, this.g[1].cy + this.g[1].h / 2);
            }
         }

      } catch (Exception var3) {
         Utlis.println(var3);
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
         case 100:
            this.a(true);
            return;
         case 101:
            if (this.d) {
               this.d = false;
               this.b[0] = this.b[1];
               this.b[1] = null;
               return;
            }
            break;
         case 102:
            if (this.d) {
               this.d = false;
               this.b[0] = this.b[1];
               this.b[1] = null;
            }

            if (this.b[2] == null) {
               for(int var4 = 0; var4 < Char.gI().arrItemBag.length; ++var4) {
                  if (Char.gI().arrItemBag[var4] != null && Char.gI().arrItemBag[var4].id == 658) {
                     this.b[2] = Char.gI().arrItemBag[var4];
                     Char.gI().arrItemBag[var4] = null;
                     return;
                  }
               }

               return;
            }
            break;
         case 1001:
            this.c = 1;
            this.a(var1.j, var1.j.k);
            this.cL = a(var1, this, this.b[0]);
            return;
         case 1002:
            this.c = 2;
            this.a(var1.j, var1.j.k);
            this.cL = a(var1, this, this.b[1]);
            return;
         case 1003:
            this.c = 3;
            this.a(var1.j, var1.j.k);
            this.cL = a(var1, this, this.b[2]);
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

   public void a(int var1) {
      super.a(var1);
      if (this.d) {
         this.d = false;

         for(var1 = 0; var1 < this.b.length; ++var1) {
            this.b[var1] = null;
         }
      }

   }

   public void d() {
      super.d();

      for(int var1 = 0; var1 < this.b.length; ++var1) {
         if (this.b[var1] != null) {
            Char.gI().h(this.b[var1].TYPE_TEMP)[this.b[var1].index] = this.b[var1];
            this.b[var1] = null;
         }
      }

   }

   private void a(boolean var1) {
      try {
         if (this.d) {
            DataCenter.gI().currentScreen.showMessage(Caption.pF, -2560);
         } else if (this.b[0] != null && this.b[2] != null) {
            if (var1) {
               DataCenter.gI().currentScreen.a(Caption.pI, 2001, this);
            } else {
               Message var4;
               (var4 = Message.c((byte)-38)).writeByte(this.b[0].TYPE_TEMP);
               var4.writeShort(this.b[0].index);
               var4.writeShort(this.b[2].index);
               var4.writeByte(this.f.b.b);
               var4.send();
            }
         } else {
            DataCenter.gI().currentScreen.showMessage(Caption.pC, -65536);
         }
      } catch (Exception var3) {
         Utlis.println(var3);
      }
   }

   public void e() {
      this.f.b(this.b[0] == null);
      if (this.b[0] != null) {
         try {
            Message var1;
            (var1 = Message.c((byte)-39)).writeByte(this.b[0].TYPE_TEMP);
            var1.writeShort(this.b[0].index);
            var1.send();
         } catch (Exception var4) {
         }

         ItemOption[] var5 = this.b[0].L();
         Vector var2 = new Vector();

         for(int var3 = 0; var3 < var5.length; ++var3) {
            if (var5[var3] != null && var5[var3].getItemOptionTemplate().type <= 2) {
               var2.add(var5[var3]);
            }
         }

         String[] var8 = new String[var2.size()];

         for(int var6 = 0; var6 < var2.size(); ++var6) {
            var8[var6] = ((ItemOption)var2.get(var6)).b();
         }

         LangLa_kd var7 = new LangLa_kd(2000, var8);
         this.f.a(var7, var2.size() > 5 ? 5 : var2.size());
      }

   }
}
