package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_br extends LangLa_ge {
   private LangLa_lf c;
   public Item[][] a;
   private LangLa_ij[] d;
   private LangLa_ii[][] e;
   private LangLa_dz[][] f;
   private int g = 96;
   private int h = 50;
   private int i = -1;
   private int u = -1;
   private String[] v;
   public byte b;
   private byte[] w;
   private boolean[] x;

   public LangLa_br(MainScreen var1, byte var2, String var3, int var4) {
      super(var1, new String[]{var3});
      this.b = var2;
      byte var5 = 87;
      switch(var2) {
      case 0:
      case 1:
         this.v = Caption.rp;
         this.w = new byte[]{0, 1};
         break;
      case 2:
      case 3:
         this.v = Caption.rp;
         this.w = new byte[]{2, 3};
         break;
      case 4:
      case 5:
         this.v = Caption.rp;
         this.w = new byte[]{4, 5};
      case 6:
      case 7:
      case 31:
      default:
         break;
      case 8:
      case 20:
         if (var4 < 0) {
            this.v = Caption.sk;
            var4 = 0;
         } else {
            this.v = Caption.ro;
         }

         var5 = 57;
         this.w = new byte[]{var2, var2, var2, var2, var2};
         break;
      case 9:
      case 10:
      case 11:
      case 12:
      case 13:
      case 14:
      case 15:
      case 16:
      case 17:
      case 21:
      case 22:
      case 23:
      case 24:
      case 25:
      case 26:
      case 27:
      case 28:
      case 29:
      case 32:
      case 33:
      case 34:
      case 35:
      case 36:
         this.v = Caption.ro;
         var5 = 57;
         this.w = new byte[]{var2, var2, var2, var2, var2};
         break;
      case 18:
      case 19:
      case 30:
      case 37:
      case 38:
         this.v = Caption.rn;
         this.w = new byte[]{18, 30, 19, 37, 38};
         var5 = 57;
      }

      this.p = var1;
      this.r = false;
      this.c = new LangLa_lf(new LangLa_kd(1001, this.v), 5, this.a_(), super.width - 8 - 2, 23, var5, this);
      this.x = new boolean[this.v.length];
      this.a = new Item[this.v.length][];
      this.f = new LangLa_dz[this.v.length][];
      this.e = new LangLa_ii[this.v.length][];
      this.d = new LangLa_ij[this.v.length];
      this.c.a(var4);
      this.b(this.c.b.b);
      this.e();
   }

   public void b(int var1) {
      if (this.a[this.c.b.b] == null) {
         this.x[var1] = false;
         this.a[var1] = new Item[GameSrc.gI().l.size()];
         this.d[var1] = new LangLa_ij((byte)1, 7, this.a_() + 3 + 22, this.g * 3, this.h * 3, this.h, Utlis.c(this.a[var1].length, 3), 3);
         this.f[var1] = new LangLa_dz[this.a[var1].length];
         this.e[var1] = new LangLa_ii[this.a[var1].length];
         int var4 = 0;

         for(int var5 = 0; var5 < this.d[var1].i; ++var5) {
            int var3 = var5 * this.h;

            for(int var6 = 0; var6 < this.d[var1].r; ++var6) {
               int var2 = var6 * this.g;
               this.a[var1][var4] = (Item)GameSrc.gI().l.elementAt(var4);
               this.f[var1][var4] = new LangLa_dz(var2 + 40, var3 + 14, 0, 0, "", this, 1000, this.a[var1][var4].e());
               this.e[var1][var4] = new LangLa_in((byte)1, 0, 0, this.f[var1][var5].width, this.f[var1][var5].height, this.f[var1][var5].height, 1, this.d[var1]);
               ++var4;
               if (var4 >= this.f[var1].length) {
                  break;
               }
            }

            if (var4 >= this.f[var1].length) {
               break;
            }
         }
      }

   }

   public void a(int var1) {
      super.a(var1);
      if (this.c != null && this.k() == 0) {
         this.c.a(this.c.b.b);
         this.e();
      }

   }

   private void e() {
      this.i = this.u = -1;
      this.b = this.w[this.c.b.b];
      if (this.a[this.c.b.b] == null) {
         this.x[this.c.b.b] = true;
         switch(this.b) {
         case 8:
         case 9:
         case 10:
         case 11:
         case 12:
         case 13:
         case 14:
         case 15:
         case 16:
         case 17:
         case 20:
         case 21:
         case 22:
         case 23:
         case 24:
         case 25:
         case 26:
         case 27:
         case 28:
         case 29:
         case 32:
         case 33:
         case 34:
         case 35:
         case 36:
            GameSrc.gI();
            GameSrc.b(this.b, this.c.b.b + 1);
            return;
         case 18:
         case 19:
         case 30:
         case 31:
         default:
            GameSrc.gI();
            GameSrc.openFunc(this.b);
         }
      }

   }

   public void a(int var1, Object var2) {
   }

   public void a(Graphics var1) {
      super.a(var1);
      if (this.k() == 0) {
         this.c.a(var1);
         if (this.x[this.c.b.b]) {
            return;
         }

         this.a(var1, this.d[this.c.b.b]);
         int var4 = 0;
         int var10000 = var1.a;
         var10000 = var1.b;

         for(int var7 = 0; var7 < this.d[this.c.b.b].i; ++var7) {
            int var3 = var7 * this.h;

            for(int var8 = 0; var8 < this.d[this.c.b.b].r; ++var8) {
               int var2 = var8 * this.g;
               if (this.d[this.c.b.b].b(var7)) {
                  this.a(var1, var2, var3, this.g - 3, 47, -22, 55, 56);
                  b(var1, var2 + 5, var3 + 5, this.a[this.c.b.b][var4], this.i == var4);
                  int var5 = var1.a;
                  int var6 = var1.b;
                  mFont.a((mFont)mFont.b, (Graphics)var1, Utlis.a(this.a[this.c.b.b][var4].getItemTemplate().name, 28), var2 + 5, var3 + 39, 0, -6488, -10275328);
                  this.a(var1, var5 + this.f[this.c.b.b][var4].cx, var6 + this.f[this.c.b.b][var4].cy);
                  mFont.a((mFont)mFont.b, (Graphics)var1, Caption.ap + " " + Utlis.numberFormat(this.a[this.c.b.b][var4].d()), 0, -6, 0, -1, -11184811);
                  this.f[this.c.b.b][var4].a(var1);
                  this.a(var1, var5, var6);
               }

               ++var4;
               if (var4 >= this.f[this.c.b.b].length) {
                  break;
               }
            }

            if (var4 >= this.f[this.c.b.b].length) {
               break;
            }
         }

         this.b(var1);
      }

   }

   public void b() {
      super.b();
      if (this.k() == 0) {
         this.c.b();
         if (this.x[this.c.b.b]) {
            return;
         }

         this.d[this.c.b.b].a();

         for(int var1 = 0; var1 < this.f[this.c.b.b].length; ++var1) {
            this.f[this.c.b.b][var1].b();
            this.e[this.c.b.b][var1].a();
            if (this.e[this.c.b.b][var1].l != -1) {
               this.f[this.c.b.b][var1].h = true;
            } else {
               this.f[this.c.b.b][var1].h = false;
            }
         }

         if (GameSrc.gI().Task == 3 && (this.b == 4 || this.b == 5)) {
            if (GameSrc.gI().idStep == 0) {
               int var10001 = this.cx + 80;
               DataCenter.gI().aO.a(var10001, this.cy + 80);
            } else if (GameSrc.gI().idStep == 1) {
               DataCenter.gI().aO.a(this.cx + this.width - 10, this.cy + 10);
            }

            DataCenter.gI().aO.a = true;
         }
      }

   }

   public Vector c() {
      Vector var1 = super.c();
      if (this.k() == 0) {
         if (this.x[this.c.b.b]) {
            var1.addElement(this.c.c());
            return var1;
         } else {
            for(int var4 = 0; var4 < this.f[this.c.b.b].length; ++var4) {
               int var2 = this.d[this.c.b.b].cx + this.f[this.c.b.b][var4].cx;
               int var3 = this.d[this.c.b.b].cy + this.f[this.c.b.b][var4].cy - this.d[this.c.b.b].f;
               if (Utlis.inRange(this.d[this.c.b.b].cx, this.d[this.c.b.b].cy, this.d[this.c.b.b].cx + this.d[this.c.b.b].width, this.d[this.c.b.b].cy + this.d[this.c.b.b].height, var2, var3) && Utlis.inRange(this.d[this.c.b.b].cx, this.d[this.c.b.b].cy, this.d[this.c.b.b].cx + this.d[this.c.b.b].width, this.d[this.c.b.b].cy + this.d[this.c.b.b].height, var2 + this.f[this.c.b.b][var4].width, var3 + this.f[this.c.b.b][var4].height)) {
                  this.e[this.c.b.b][var4].cx = (short)var2;
                  this.e[this.c.b.b][var4].cy = (short)var3;
                  var1.addElement(new LangLa_jz(2000 + var4, this.e[this.c.b.b][var4].cx, this.e[this.c.b.b][var4].cy, this.e[this.c.b.b][var4].cx + this.e[this.c.b.b][var4].width, this.e[this.c.b.b][var4].cy + this.e[this.c.b.b][var4].height, this.e[this.c.b.b][var4], this));
                  var1.addElement(new LangLa_jz(3000 + var4, var2 - 35, var3 - 9, var2 - 35 + 28, var3 - 9 + 28, this.d[this.c.b.b], this));
               }
            }

            var1.addElement(this.c.c());
            var1.addElement(new LangLa_jz(1002, this.d[this.c.b.b].cx, this.d[this.c.b.b].cy, this.d[this.c.b.b].cx + this.d[this.c.b.b].width, this.d[this.c.b.b].cy + this.d[this.c.b.b].height, this.d[this.c.b.b], this));
            return var1;
         }
      } else {
         return var1;
      }
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      super.a(var1, var2, var3);
      if (this.k() == 0) {
         this.i = this.u = -1;
         if (!this.x[this.c.b.b]) {
            if (var1.b >= 3000) {
               this.i = var1.b - 3000;
               var2 = this.d[this.c.b.b].cx + this.f[this.c.b.b][this.i].cx - 35 + 30;
               var3 = this.d[this.c.b.b].cy + this.f[this.c.b.b][this.i].cy - this.d[this.c.b.b].f - 9;
               this.cL = a(this, var2, var3, 28, this.a[this.c.b.b][this.i]);
            } else if (var1.b >= 2000) {
               this.u = var1.b - 2000;
               this.p.a((LangLa_cx)(new LangLa_lv(this.p, this.a[this.c.b.b][this.u], this.b)));
            }
         }

         switch(var1.b) {
         case 1001:
            if (var1.j.k >= 0) {
               this.c.a(var1.j.k);
               this.e();
            }
         }
      }

   }
}
