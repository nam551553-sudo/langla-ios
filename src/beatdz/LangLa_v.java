package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_v extends LangLa_ge {
   public LangLa_gl[] a;
   private LangLa_ii h;
   private LangLa_ii i;
   private LangLa_ii u;
   private LangLa_ii[] v;
   private LangLa_ii[] w;
   private LangLa_ii[] x;
   private LangLa_dz[] y;
   private LangLa_dz[] z;
   private LangLa_dz[] A;
   private LangLa_ii B;
   public int b = -1;
   public LangLa_lf c;
   public Item d;
   private String[] C;
   private int[] D;
   private LangLa_cg[] E;
   public LangLa_gd e;
   public int f;
   public int g;
   private LangLa_kc F;
   private LangLa_gl G;

   public LangLa_v(MainScreen var1) {
      super(var1, new String[]{Caption.bw});
      this.C = Caption.rB;
      this.D = new int[]{10, 20, 30, 60, 100};
      this.E = new LangLa_cg[2];
      this.a(this.width, this.height + 20);
      GameSrc.gI().aC = new LangLa_gl[0];
      GameSrc.gI().aB = new LangLa_gl[0];
      this.c = new LangLa_lf(new LangLa_kd(1001, this.C), 4, this.a_(), super.width - 8, 23, 84, this);
      this.E[0] = new LangLa_cg(10, 73, 85, 7, new LangLa_kd(1000, DataCenter.gI().dataTreoCho[DataCenter.gI().n]), this, 0, true);
      this.c.a((LangLa_cs)this.E[0], 0);
      this.F = new LangLa_kc(1000, GameSrc.gI().ax);
      this.c.a((LangLa_cs)(new LangLa_cl(10, 111, Caption.hF, this, this.F)), 0);
      this.c.a((LangLa_cs)(new LangLa_cl(10, 130, Caption.hG, this, this.F)), 0);
      this.c.a((LangLa_cs)(new LangLa_cl(10, 149, Caption.hH, this, this.F)), 0);
      this.c.a((LangLa_cs)(new LangLa_cl(10, 168, Caption.hI, this, this.F)), 0);
      this.c.a((LangLa_cs)(new LangLa_cl(10, 187, Caption.hJ, this, this.F)), 0);
      this.c.a((LangLa_cs)(new LangLa_cl(10, 206, Caption.nU, this, this.F)), 0);
      LangLa_dz var2;
      LangLa_dz var10000 = var2 = new LangLa_dz(171, this.G() + 14, 0, 0, "", this, 1012, 286);
      short var4 = -360;
      var10000.e = var4;
      this.c.a((LangLa_cs)var2, 0);
      var10000 = var2 = new LangLa_dz(146, this.G() + 14, 0, 0, "", this, 1011, 287);
      var4 = -360;
      var10000.e = var4;
      this.c.a((LangLa_cs)var2, 0);
      this.c.a((LangLa_cs)(new LangLa_dz(218, this.G() + 14, 0, 0, "", this, 1013, 286)), 0);
      this.c.a((LangLa_cs)(new LangLa_dz(243, this.G() + 14, 0, 0, "", this, 1014, 287)), 0);
      this.m();
      this.B = new LangLa_ii((byte)0, 11, this.a_() + 32, 28, 28, 28, 1);
      (var2 = new LangLa_dz(45, 64, 0, 0, Caption.ar, this, 1010, 15)).setSize(45, 22);
      this.c.a((LangLa_cs)var2, 1);
      this.e = new LangLa_gd(10, 105, 80, "", this, 0, 2, 0);
      this.c.a((LangLa_cs)this.e, 1);
      LangLa_kd var5;
      (var5 = new LangLa_kd(200)).c = Caption.qX;
      var5.b = 0;
      this.E[1] = new LangLa_cg(10, 165, 80, 5, var5, this, 1, true);
      this.c.a((LangLa_cs)this.E[1], 1);
      this.n();
      this.c.a(this.c(0));
      this.a(0);
      this.e();
      g();
   }

   public void a() {
      this.t = new Item[Char.gI().arrItemBag.length];
      int var1 = 0;

      for(int var2 = 0; var2 < Char.gI().arrItemBag.length; ++var2) {
         if (Char.gI().arrItemBag[var2] != null && !Char.gI().arrItemBag[var2].isLock && Char.gI().arrItemBag[var2].expiry == -1L) {
            this.t[var1] = Char.gI().arrItemBag[var2];
            ++var1;
         }
      }

   }

   public void e() {
      try {
         Message var1;
         (var1 = new Message((byte)101)).writeByte(this.E[0].b.b);
         var1.writeByte(GameSrc.gI().ax);
         var1.writeShort(this.f);
         var1.send();
      } catch (Exception var3) {
         Utlis.println(var3);
      }
   }

   private void b(int var1) {
      try {
         Message var2;
         (var2 = new Message((byte)101)).writeByte(this.E[0].b.b);
         var2.writeByte(this.F.b);
         var2.writeShort(var1);
         var2.send();
      } catch (Exception var4) {
         Utlis.println(var4);
      }
   }

   public static void g() {
      try {
         (new Message((byte)100)).send();
      } catch (Exception var1) {
         Utlis.println(var1);
      }
   }

   public int l() {
      return this.c.b.b;
   }

   public void m() {
      this.h = new LangLa_ii((byte)1, 100, 72, this.width - 104, 136, 34, GameSrc.gI().aC.length);
      this.y = new LangLa_dz[GameSrc.gI().aC.length];
      this.v = new LangLa_in[GameSrc.gI().aC.length];

      for(int var1 = 0; var1 < GameSrc.gI().aC.length; ++var1) {
         this.y[var1] = new LangLa_dz(164, 6 + var1 * this.h.h, 0, 0, "", this, 1000, -5);
         this.y[var1].setSize(26, 20);
         this.v[var1] = new LangLa_in((byte)1, 0, 0, this.y[var1].width, this.y[var1].height, this.y[var1].height, 1, this.h);
      }

      this.o();
   }

   public void n() {
      this.i = new LangLa_ii((byte)1, 100, 72, this.width - 104, 136, 34, GameSrc.gI().aB.length);
      this.z = new LangLa_dz[GameSrc.gI().aB.length];
      this.w = new LangLa_in[GameSrc.gI().aB.length];

      for(int var1 = 0; var1 < GameSrc.gI().aB.length; ++var1) {
         this.z[var1] = new LangLa_dz(164, 6 + var1 * this.i.h, 0, 0, "", this, 1000, -5);
         this.z[var1].setSize(26, 20);
         this.w[var1] = new LangLa_in((byte)1, 0, 0, this.z[var1].width, this.z[var1].height, this.z[var1].height, 1, this.i);
      }

      this.o();
   }

   public void b() {
      try {
         super.b();
         if (this.k() != 0) {
            this.a();
            return;
         }

         this.c.b();
         this.u.a();

         for(int var1 = 0; var1 < this.A.length; ++var1) {
            this.A[var1].b();
            this.x[var1].a();
            if (this.x[var1].l != -1) {
               this.A[var1].h = true;
            } else {
               this.A[var1].h = false;
            }
         }
      } catch (Exception var2) {
         Utlis.println(var2);
      }

   }

   public void a(Graphics var1) {
      try {
         super.a(var1);
         if (this.k() == 0) {
            this.c.a(var1);
            this.a(var1, this.cx + 4, this.cy + this.a_() + 22);
            this.a(var1, -3, 0, 100, this.G() - this.a_() + 10, 4, 55, 56);
            Graphics var3 = var1;
            LangLa_v var2 = this;

            try {
               var2.b(var3, var2.u);
               var3.f(7049372);
               int var4 = var2.a.length;
               int var10000;
               if (var2.c.b.b != 0 || var4 <= 3) {
                  var10000 = var2.c.b.b;
               }

               if (var2.c.b.b == 0) {
                  mFont.b(mFont.e, var3, Caption.hP, 5, -10, 0, -6488, -10275328);
               } else {
                  mFont.b(mFont.e, var3, Caption.hQ, 5, -10, 0, -6488, -10275328);
               }

               mFont.b(mFont.e, var3, Caption.hR, 114, -10, 0, -6488, -10275328);
               mFont.b(mFont.e, var3, Caption.hS, 166, -10, 0, -6488, -10275328);
               if (var2.c.b.b == 0) {
                  mFont.b(mFont.f, var3, "" + (var2.f + 1), 103, 146, 2, -1, -16777216);
               }

               var2.a(var3, var2.u);
               var10000 = var3.a;
               var10000 = var3.b;

               for(int var6 = 0; var6 < var2.u.i; ++var6) {
                  if (var2.u.b(var6)) {
                     var2.a(var3, 2, var6 * var2.u.h, var2.u.width - 4, var2.u.h - 1, -13, 84, 5, 1, 1);
                     b(var3, 5, 2 + var6 * var2.u.h, var2.a[var6].e, var2.b == var6);
                     mFont.b(mFont.d, var3, var2.a[var6].b, 38, 10 + var6 * var2.u.h, 0, -1, -16777216);
                     mFont.b(mFont.d, var3, Caption.ap + " " + Utlis.numberFormat(var2.a[var6].c), 38, 23 + var6 * var2.u.h, 0, -3089954, -16777216);
                     if ((var4 = (int)((long)var2.a[var6].d - Utlis.time() / 1000L)) >= 60) {
                        mFont.b(mFont.d, var3, Caption.by, 137, 9 + var6 * var2.u.h, 2, -6488, -10275328);
                        mFont.b(mFont.d, var3, Utlis.getSTRTimeFormSeconds(var4), 137, 21 + var6 * var2.u.h, 2, -6488, -10275328);
                     } else {
                        mFont.b(mFont.d, var3, Caption.rC[0], 137, 9 + var6 * var2.u.h, 2, -6488, -10275328);
                        mFont.b(mFont.d, var3, Caption.rC[1], 137, 21 + var6 * var2.u.h, 2, -6488, -10275328);
                     }

                     var4 = var3.a;
                     int var5 = var3.b;
                     var2.a(var3, var4 + var2.A[var6].cx, var5 + var2.A[var6].cy);
                     var2.A[var6].a(var3);
                     var2.a(var3, var4, var5);
                  }
               }

               var2.b(var3);
            } catch (Exception var7) {
               Utlis.println(var7);
            }

            this.a(var1, this.cx, this.cy);
            switch(this.c.b.b) {
            case 0:
               this.a(var1, this.cx + 4, this.cy + this.a_());
               mFont.b(mFont.d, var1, Caption.hK, 6, 35, 0, -6488, -10275328);
               mFont.b(mFont.d, var1, Caption.hL, 6, 72, 0, -6488, -10275328);
               return;
            case 1:
               a(var1, this.B.cx, this.B.cy, this.d, false);
               this.a(var1, this.cx + 4, this.cy + this.a_());
               mFont.b(mFont.d, var1, Caption.hM, 6, 67, 0, -6488, -10275328);
               mFont.b(mFont.d, var1, Caption.hN, 6, 127, 0, -6488, -10275328);
               mFont.b(mFont.d, var1, Caption.hO, 6, 167, 0, -6488, -10275328);
               mFont.b(mFont.d, var1, Caption.nR, 6, 179, 0, -3089954, -16777216);
               mFont.b(mFont.d, var1, Caption.nS, 6, 191, 0, -3089954, -16777216);
               mFont.b(mFont.d, var1, Utlis.numberFormat(this.D[this.E[1].b.b]), 26, 167, 0, -3089954, -16777216);
               a(var1, 26, 167, Utlis.numberFormat(this.D[this.E[1].b.b]), (byte)0);
            }
         }

      } catch (Exception var8) {
         Utlis.println(var8);
      }
   }

   public Vector c() {
      Vector var1 = super.c();
      if (this.k() == 0) {
         for(int var4 = 0; var4 < this.A.length; ++var4) {
            int var2 = this.u.cx + this.A[var4].cx;
            int var3 = this.u.cy + this.A[var4].cy - this.u.f;
            if (Utlis.inRange(this.u.cx, this.u.cy, this.u.cx + this.u.width, this.u.cy + this.u.height, var2, var3) && Utlis.inRange(this.u.cx, this.u.cy, this.u.cx + this.u.width, this.u.cy + this.u.height, var2 + this.A[var4].width, var3 + this.A[var4].height)) {
               this.x[var4].cx = (short)var2;
               this.x[var4].cy = (short)var3;
               var1.addElement(new LangLa_jz(7000 + var4, this.x[var4].cx, this.x[var4].cy, this.x[var4].cx + this.x[var4].width, this.x[var4].cy + this.x[var4].height, this.x[var4], this));
               var1.addElement(new LangLa_jz(8000 + var4, var2 - 161, var3 - 4, var2 - 161 + 28, var3 - 4 + 28, this.u, this));
            }
         }

         var1.addElement(this.c.c());
         var1.addElement(this.u.a(1003, this));
         switch(this.c.b.b) {
         case 1:
            var1.addElement(this.B.a(1002, this));
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
         if (var1.b == 2000) {
            this.a(false, this.a[this.b]);
         }

         this.b = -1;
         if (var1.b >= 7000 && var1.b < 8000) {
            this.g = 1;
            this.b = var1.b - 7000;
            this.a(true, this.a[this.b]);
         } else if (var1.b >= 8000 && var1.b < 9000) {
            this.g = 2;
            this.b = var1.b - 8000;
            var2 = this.u.cx + this.A[this.b].cx - 161 + 30;
            var3 = this.u.cy + this.A[this.b].cy - this.u.f - 4;
            this.cL = a(this, var2, var3, 28, this.a[this.b].e);
         }

         switch(var1.b) {
         case 1001:
            if (var1.j.k >= 0) {
               this.c.a(var1.j.k);
               this.o();
               return;
            }
            break;
         case 1002:
            this.g = 3;
            if (this.d == null) {
               this.a(1);
               DataCenter.gI().currentScreen.showMessage(Caption.bx, -1);
               return;
            }

            this.cL = a(this, var1.j.cx + 32, var1.j.cy, 28, this.d);
            return;
         case 1010:
            LangLa_v var5 = this;

            try {
               if (var5.d == null) {
                  var5.a(1);
                  DataCenter.gI().currentScreen.showMessage(Caption.bx, -1);
               } else if (var5.e.e() <= 0) {
                  DataCenter.gI().currentScreen.showMessage(Caption.hT, -65536);
               } else {
                  var2 = var5.D[var5.E[1].b.b];
                  if (Char.gI().bac < var2) {
                     DataCenter.gI().currentScreen.showMessage(Caption.hU, -65536);
                  } else {
                     Message var6;
                     (var6 = new Message((byte)99)).writeShort(var5.d.index);
                     var6.writeByte(var5.E[1].b.b);
                     var6.writeInt(var5.e.e());
                     var6.send();
                  }
               }
               break;
            } catch (Exception var4) {
               Utlis.println(var4);
               return;
            }
         case 1011:
            this.f = 0;
            this.b(0);
            return;
         case 1012:
            if ((var2 = this.f - 1) < 0) {
               var2 = 0;
            }

            this.b(var2);
            return;
         case 1013:
            this.b(this.f + 1);
            return;
         case 1014:
            this.b(32767);
            return;
         case 2010:
            this.b(false, this.G);
         }
      }

   }

   public void a(int var1, Object var2, LangLa_cy var3) {
      super.a(var1, var2, var3);
      switch(var1) {
      case 1000:
         this.f = 0;
         GameSrc.gI().ax = this.F.b;
         this.e();
      default:
      }
   }

   public void a(int var1) {
      super.a(var1);
      if (this.c != null && this.k() == 0) {
         this.c.a(this.c.b.b);
         this.o();
      }

   }

   public void o() {
      if (this.c != null) {
         switch(this.c.b.b) {
         case 0:
            this.a = GameSrc.gI().aC;
            this.u = this.h;
            this.x = this.v;
            this.A = this.y;
            return;
         case 1:
            this.a = GameSrc.gI().aB;
            this.u = this.i;
            this.x = this.w;
            this.A = this.z;
         }
      }

   }

   private void b(boolean var1, LangLa_gl var2) {
      try {
         this.G = var2;
         if (var1) {
            DataCenter.gI().currentScreen.a(Caption.hV, 2010, this);
         } else {
            Message var4;
            (var4 = new Message((byte)-19)).writeLong(var2.a);
            var4.send();
         }
      } catch (Exception var3) {
         Utlis.println(var3);
      }
   }

   public void a(boolean var1, LangLa_gl var2) {
      try {
         if (Char.gI().bac < var2.c) {
            DataCenter.gI().currentScreen.showMessage(Caption.hW, -65536);
         } else if (var1) {
            DataCenter.gI().currentScreen.a(Caption.hX + var2.e.getItemTemplate().name + Caption.hY + var2.c + Caption.hZ, 2000, this);
         } else {
            Message var4;
            (var4 = new Message((byte)98)).writeLong(var2.a);
            var4.send();
         }
      } catch (Exception var3) {
         Utlis.println(var3);
      }
   }

   public void a(boolean var1) {
      this.b(var1, this.a[this.b]);
   }

   public void d() {
      super.d();
      if (this.d != null) {
         Char.gI().arrItemBag[this.d.index] = this.d;
         this.d = null;
      }

   }
}
