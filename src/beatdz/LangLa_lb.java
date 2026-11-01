package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_lb extends LangLa_ge {
   private LangLa_ii[] f = new LangLa_ii[4];
   private LangLa_ij g;
   private LangLa_dz h;
   private LangLa_dz i;
   public int a;
   public int b;
   public int c;
   public int d;
   public boolean e;

   public LangLa_lb(MainScreen var1) {
      super(var1, new String[]{Caption.aU});
      this.h = this.a(this.width - 52, this.height - 30, Caption.u, this, 0, -8);
      this.h.setSize(45, this.h.height);
      this.a(this.h, 0);
      this.i = this.a(this.width - 100, this.height - 30, Caption.kM, this, 5003, -8);
      this.i.setSize(45, this.i.height);
      this.a(this.i, 0);
      this.f[0] = new LangLa_ii((byte)0, 7, this.a_() + 131, 93, 21, 93, 1);
      this.f[1] = new LangLa_ii((byte)0, 7, this.a_() + 155, 93, 21, 93, 1);
      this.f[2] = new LangLa_ii((byte)0, 103, this.a_() + 131, 93, 21, 93, 1);
      this.f[3] = new LangLa_ii((byte)0, 103, this.a_() + 155, 93, 21, 93, 1);
      this.g = new LangLa_ij((byte)1, 7, this.a_() + 3, 288, 128, 32, Utlis.c(Char.gI().arrItemBox.length, 9), 9);
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      super.a(var1, var2, var3);
      if (this.k() == 0) {
         switch(var1.b) {
         case 0:
            GameSrc.gI();
            GameSrc.g(1);
            return;
         case 2000:
            try {
               Message.c((byte)-82).send();
               break;
            } catch (Exception var4) {
               return;
            }
         case 5001:
            if (var1.j.k >= 0) {
               this.cL = a(var1, this, Char.gI().arrItemBox[var1.j.k]);
               return;
            }
            break;
         case 5002:
            this.cL = a(var1, this, (Item)null);
            return;
         case 5003:
            DataCenter.gI().currentScreen.a(Caption.kQ, 2000, this);
            return;
         case 5004:
            this.a(var1.j, var1.j.k);
            if (var1.j.k >= 0) {
               this.a(11000, (String)(Caption.pl + " " + Caption.rp[0]), (LangLa_ii)var1.j);
               return;
            }
            break;
         case 5005:
            this.a(var1.j, var1.j.k);
            if (var1.j.k >= 0) {
               this.a(11001, (String)(Caption.pl + " " + Caption.rv[0]), (LangLa_ii)var1.j);
               return;
            }
            break;
         case 5006:
            this.a(var1.j, var1.j.k);
            if (var1.j.k >= 0) {
               this.a(11002, (String)(Caption.pl + " " + Caption.rp[1]), (LangLa_ii)var1.j);
               return;
            }
            break;
         case 5007:
            this.a(var1.j, var1.j.k);
            if (var1.j.k >= 0) {
               this.a(11003, (String)(Caption.pl + " " + Caption.rv[1]), (LangLa_ii)var1.j);
            }
         }
      }

   }

   public void a(int var1, Object var2, LangLa_cy var3) {
      try {
         super.a(var1, var2, var3);
         switch(var1) {
         case 11000:
            GameSrc.gI().a((LangLa_cx)(new LangLa_bm(this.p, (byte)0, this.a, this.b, this.c, this.d)));
            break;
         case 11001:
            GameSrc.gI().a((LangLa_cx)(new LangLa_bm(this.p, (byte)2, this.a, this.b, this.c, this.d)));
            break;
         case 11002:
            GameSrc.gI().a((LangLa_cx)(new LangLa_bm(this.p, (byte)1, this.a, this.b, this.c, this.d)));
            break;
         case 11003:
            GameSrc.gI().a((LangLa_cx)(new LangLa_bm(this.p, (byte)3, this.a, this.b, this.c, this.d)));
         default:
            return;
         }
      } catch (Exception var4) {
         Utlis.println(var4);
      }

   }

   private void a(LangLa_ii var1, int var2) {
      this.g.k = -1;
      var1.k = var2;
   }

   public void a(int var1, Object var2) {
   }

   public void a(Graphics var1) {
      super.a(var1);
      if (this.k() == 0) {
         this.a(var1, this.g);

         int var2;
         int var3;
         for(var2 = 0; var2 < this.g.i; ++var2) {
            for(var3 = 0; var3 < this.g.r; ++var3) {
               if (this.g.b(var2)) {
                  int var10001 = var3 * this.g.h;
                  int var10002 = var2 * this.g.h;
                  int var10004 = var2 * this.g.r;
                  b(var1, var10001, var10002, Char.gI().arrItemBox[var10004 + var3], var2 * this.g.r + var3 == this.g.k);
               }
            }
         }

         this.b(var1);
         this.a(var1, this.cx + 4, this.cy + this.a_());
         var2 = 0;

         for(var3 = 0; var3 < Char.gI().arrItemBox.length; ++var3) {
            if (Char.gI().arrItemBox[var3] != null) {
               ++var2;
            }
         }

         mFont.b(mFont.d, var1, Caption.aV + " " + var2 + "/" + Char.gI().arrItemBox.length, 288, 140, 1, -1, -16777216);
         if (this.e) {
            for(var3 = 0; var3 < this.f.length; ++var3) {
               this.a(var1, this.cx + this.f[var3].cx, this.cy + this.f[var3].cy);
               LangLa_fq.b(var1, 26, 27, 0, 0, this.f[var3].width, this.f[var3].height);
               switch(var3) {
               case 0:
                  a(var1, 0, 12, "", (byte)0);
                  mFont.b(mFont.d, var1, Utlis.numberFormat(this.c), 30, 11, 20, -3089954, -16777216);
                  break;
               case 1:
                  a(var1, 0, 8, "", (byte)2);
                  mFont.b(mFont.d, var1, Utlis.numberFormat(this.a), 30, 11, 20, -2560, -16777216);
                  break;
               case 2:
                  a(var1, 0, 10, "", (byte)1);
                  mFont.b(mFont.d, var1, Utlis.numberFormat(this.d), 30, 11, 20, -3089954, -16777216);
                  break;
               case 3:
                  a(var1, 0, 8, "", (byte)3);
                  mFont.b(mFont.d, var1, Utlis.numberFormat(this.b), 30, 11, 20, -2560, -16777216);
               }
            }
         }
      }

   }

   public void b() {
      super.b();
      if (this.k() == 0) {
         this.g.a();
      }

   }

   public Vector c() {
      Vector var1 = super.c();
      if (this.k() == 0) {
         var1.addElement(this.g.a(5001, this));
         if (this.e) {
            for(int var2 = 0; var2 < this.f.length; ++var2) {
               var1.addElement(this.f[var2].a(5004 + var2, this));
            }
         }
      }

      return var1;
   }

   public int e() {
      return this.k();
   }

   public void a(int var1, String var2, LangLa_ii var3) {
      String[] var6 = new String[]{var2};
      short[] var4 = new short[]{(short)var1};
      LangLa_kn var5;
      (var5 = a(this, var3.cx + 30, var3.cy, new LangLa_kd(0, var4, var6))).a(70);
      this.cL = var5;
   }
}
