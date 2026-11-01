package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_al extends LangLa_kj {
   public Item[] a = new Item[2];
   public Item[] b = new Item[6];
   private LangLa_ij[] g = new LangLa_ij[3];
   private LangLa_dz h;
   public int c;
   public int d = 0;
   public LangLa_jw e;
   public boolean f;

   public LangLa_al(MainScreen var1) {
      super(var1, new String[]{Caption.qH, Caption.H});
      this.g[0] = new LangLa_ij((byte)1, 124, this.a_() + 20, 30, 30, 30, 1, 1);
      this.g[1] = new LangLa_ij((byte)1, 14, this.a_() + 20, 64, 96, 32, 3, 2);
      this.g[2] = new LangLa_ij((byte)1, 204, this.a_() + 20, 30, 30, 30, 1, 1);
      this.h = this.a(this.width - 70, this.height - 33, Caption.bj, this, 0, -8);
      this.a(this.h, 0);
   }

   public void a() {
      this.t = new Item[Char.gI().arrItemBag.length];
      int var1 = 0;

      for(int var2 = 0; var2 < Char.gI().arrItemBag.length; ++var2) {
         if (Char.gI().arrItemBag[var2] != null && Char.gI().arrItemBag[var2].G()) {
            this.t[var1] = Char.gI().arrItemBag[var2];
            ++var1;
         }
      }

   }

   public void b() {
      super.b();
      if (this.k() == 0) {
         if (!this.f && this.a[0] == null) {
            this.a[1] = null;
         }

         for(int var1 = 0; var1 < this.g.length; ++var1) {
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

      if (this.d > 0) {
         --this.d;
      }

   }

   public void a(int var1) {
      super.a(var1);
      if (var1 != 0 && this.f) {
         this.f = false;
      }

   }

   public void a(Graphics var1) {
      if (this.j() <= 0) {
         this.a(var1, this.cx, this.cy, this.width, this.height, Caption.q, (byte)2, this.r);
      } else {
         super.a(var1);
      }

      if (this.k() == 0) {
         mFont.b(mFont.d, var1, Caption.qI, 14, this.a_() + 9, 0, -10831436, -16777216);
         mFont.b(mFont.d, var1, Caption.qJ, 89, this.a_() + 65, 0, -10831436, -16777216);
         int var2;
         int var3;
         if (this.a[0] != null) {
            var2 = this.a[0].getItemTemplate().levelNeed / 10 * 100 + 150;
            var3 = this.a[0].getItemTemplate().levelNeed / 10 * 10000000 + 15000000;
            mFont.b(mFont.d, var1, Utlis.replaceAll(Caption.kr, Utlis.numberFormat(var2)) + Caption.qK, 89, this.a_() + 80, 0, -10831436, -16777216);
            mFont.b(mFont.d, var1, Utlis.replaceAll(Caption.oq, Utlis.numberFormat(var3)), 89, this.a_() + 95, 0, -10831436, -16777216);
         }

         a(var1, this.g[0].cx, this.g[0].cy, this.a[0], this.g[0].k >= 0, Caption.H);
         a(var1, this.g[2].cx, this.g[0].cy, this.a[1], this.g[2].k >= 0, Caption.I);
         LangLa_fq.a(var1, 95, 0, 170 - DataCenter.gI().i / 3 % 3, this.a_() + 25, 20);
         if (this.d > 0 && this.d % 14 > 2) {
            mFont.b(mFont.d, var1, Caption.kL + DataCenter.gI().ItemOptionTemplate[165].name, 14, this.a_() + 125, 0, -2560, -16777216);
         }

         this.a(var1, this.g[1]);
         var2 = 0;

         for(var3 = 0; var3 < this.g[1].i; ++var3) {
            for(int var4 = 0; var4 < this.g[1].r; ++var4) {
               b(var1, var4 * this.g[1].h, var3 * this.g[1].h, this.b[var3 * this.g[1].r + var4], var2 == this.g[1].k, "");
               ++var2;
            }
         }

         this.b(var1);
         if (this.e != null) {
            this.e.b(var1, this.g[2].cx + this.g[2].h / 2, this.g[2].cy + this.g[2].h / 2);
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
            LangLa_al var5 = this;

            try {
               var2 = 0;

               for(var3 = 0; var3 < var5.b.length; ++var3) {
                  if (var5.b[var3] != null) {
                     ++var2;
                  }
               }

               if (var5.a[0] != null && var2 != 0) {
                  Message var6;
                  (var6 = Message.c((byte)-17)).writeByte(var5.a[0].TYPE_TEMP);
                  var6.writeShort(var5.a[0].index);
                  var6.writeByte(var2);

                  for(var2 = 0; var2 < var5.b.length; ++var2) {
                     if (var5.b[var2] != null) {
                        var6.writeShort(var5.b[var2].index);
                     }
                  }

                  var6.send();
               } else {
                  DataCenter.gI().currentScreen.showMessage(Caption.qI, -65536);
               }
               break;
            } catch (Exception var4) {
               Utlis.println(var4);
               return;
            }
         case 1001:
            this.c = 1;
            this.a(var1.j, var1.j.k);
            this.cL = a(var1, this, this.a[0]);
            return;
         case 1002:
            this.c = 2;
            this.a(var1.j, var1.j.k);
            this.cL = a(var1, this, this.b[var1.j.k]);
            return;
         case 1003:
            this.c = 3;
            this.a(var1.j, var1.j.k);
            this.cL = a(var1, this, this.a[1]);
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
