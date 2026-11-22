package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_bo extends LangLa_fl {
   private Vector a;
   private LangLa_jb[] b = new LangLa_jb[2];
   private LangLa_cz[] c = new LangLa_cz[2];
   private int d = -1;
   private int e;
   private int f;
   private int g;
   private LangLa_dz h;
   private LangLa_dz i;
   private LangLa_dz j;
   private boolean k;

   public LangLa_bo(MainScreen var1, Vector var2, int var3) {
      this.p = var1;
      this.a = var2;
      this.r = false;
      this.g = var3;
      this.setSize(DataCenter.gI().widthScreen, DataCenter.gI().heightScreen);
      this.c[0] = new LangLa_cz();
      this.c[0].setSize(this.width, 50);
      this.c[0].setXY(0, -this.c[0].height + 20);
      this.b[0] = new LangLa_jb(this.c[0], (byte)1, 0);
      this.c[1] = new LangLa_cz();
      this.c[1].setSize(this.width, 100);
      this.c[1].setXY(0, this.height);
      this.b[1] = new LangLa_jb(this.c[1], (byte)1, this.height - this.c[1].height);
      this.h = this.a(this.width / 2 - 33, this.height - 28, Caption.iA, this, 202, 15);
      this.i = this.a(this.width / 2 - 30 - 25, this.height - 28, Caption.iB, this, 201, 15);
      this.j = this.a(this.width / 2 + 30 - 25, this.height - 28, Caption.iC, this, 200, 15);
      this.h.setSize(66, this.h.height);
      this.i.setSize(50, this.i.height);
      this.j.setSize(50, this.i.height);
   }

   public void a(Graphics var1) {
      for(int var2 = 0; var2 < this.c.length; ++var2) {
         Binary2.a(var1, -6, 0, this.c[var2].cx, this.c[var2].cy, this.c[var2].width, (int)this.c[var2].height);
      }

      if (this.d >= 0 && this.a != null && this.a.size() > 0 && this.d < this.a.size()) {
         LangLa_ke var7 = (LangLa_ke)this.a.elementAt(this.d);
         int var4 = this.height - 60;
         int var3;
         int var6;
         String var8;
         if (var7.d == 2) {
            var3 = this.width / 2;

            for(var6 = 0; var6 < var7.c.size(); ++var6) {
               var8 = var7.c.elementAt(var6).toString();
               if (var6 == this.f) {
                  mFont.c(mFont.d, var1, var8.substring(0, this.e), var3, var4 + var6 * 12, 2, -1, 0);
               } else if (var6 < this.f) {
                  mFont.c(mFont.d, var1, var8, var3, var4 + var6 * 12, 2, -1, 0);
               }
            }

            return;
         }

         int var5;
         if (var7.d == 0) {
            if (var7.a != null) {
               Char.gI().a(var1, this.cx + 30, this.height - 20, var7.a, 0, 0, false);
            } else if (var7.b != null) {
               for(var5 = 0; var5 < var7.b.a.length; ++var5) {
                  LangLa_fq.b(var1, var7.b.a[var5].a, Utlis.b(var7.b.a[var5].d), this.cx + 30 - var7.b.a[var5].b, this.height - 20 + var7.b.a[var5].c, 33);
               }
            }

            var3 = this.cx + 60;

            for(var6 = 0; var6 < var7.c.size(); ++var6) {
               var8 = var7.c.elementAt(var6).toString();
               if (var6 == this.f) {
                  mFont.c(mFont.d, var1, var8.substring(0, this.e), var3, var4 + var6 * 12, 0, -1, 0);
               } else if (var6 < this.f) {
                  mFont.c(mFont.d, var1, var8, var3, var4 + var6 * 12, 0, -1, 0);
               }
            }

            return;
         }

         if (var7.d == 1) {
            if (var7.a != null) {
               Char.gI().a(var1, this.width - 30, this.height - 20, var7.a, 0, 0, true);
            } else if (var7.b != null) {
               for(var5 = 0; var5 < var7.b.a.length; ++var5) {
                  LangLa_fq.b(var1, var7.b.a[var5].a, Utlis.a(var7.b.a[var5].d), this.width - 30 + var7.b.a[var5].b, this.height - 20 + var7.b.a[var5].c, 33);
               }
            }

            var3 = this.width - 60;

            for(var6 = 0; var6 < var7.c.size(); ++var6) {
               var8 = var7.c.elementAt(var6).toString();
               if (var6 == this.f) {
                  mFont.c(mFont.d, var1, var8.substring(0, this.e), var3, var4 + var6 * 12, 1, -1, 0);
               } else if (var6 < this.f) {
                  mFont.c(mFont.d, var1, var8, var3, var4 + var6 * 12, 1, -1, 0);
               }
            }
         }
      }

   }

   public Vector c() {
      super.c();
      Vector var1;
      (var1 = new Vector()).addElement(new LangLa_jz(1000, 0, 0, this.width, this.height, (LangLa_ii)null, this));
      return var1;
   }

   public void b() {
      int var1 = 0;

      for(int var2 = 0; var2 < this.c.length; ++var2) {
         this.b[var2].a();
         if (this.b[var2].b()) {
            ++var1;
         }
      }

      if (this.d >= this.a.size() && var1 == 0) {
         this.J();
      } else if (var1 <= 1 && this.d < 0) {
         this.d = 0;
      }

      if (this.d >= 0 && this.d < this.a.size()) {
         LangLa_ke var8 = (LangLa_ke)this.a.elementAt(this.d);
         if (this.f < var8.c.size()) {
            this.e += 10;
            String var3 = var8.c.elementAt(this.f).toString();
            if (this.e >= var3.length()) {
               this.e = 0;
               ++this.f;
               this.k = this.f == var8.c.size();
            } else {
               this.k = false;
               String var9 = var3.substring(0, this.e + 10 > var3.length() ? var3.length() : this.e + 10);
               int[] var10 = null;

               while(true) {
                  int var5 = var10 == null ? 0 : var10[0] + var10[1];
                  String var4 = var9.toLowerCase();
                  String var6 = "";

                  int var7;
                  for(var7 = 0; var7 < var5; ++var7) {
                     var6 = var6 + " ";
                  }

                  var6 = var6 + var4.substring(var5, var4.length());
                  var7 = 0;

                  int[] var10000;
                  while(true) {
                     if (var7 >= beatdz.LangLa_je.$state_LangLa_je().g.length) {
                        var10000 = null;
                        break;
                     }

                     if (var6.indexOf(beatdz.LangLa_je.$state_LangLa_je().g[var7].d) != -1) {
                        var10000 = new int[]{var6.indexOf(beatdz.LangLa_je.$state_LangLa_je().g[var7].d), beatdz.LangLa_je.$state_LangLa_je().g[var7].d.length()};
                        break;
                     }

                     ++var7;
                  }

                  int[] var11 = var10000;
                  if (var10000 == null) {
                     if (var10 != null && var10[0] + var10[1] > this.e) {
                        this.e = var10[0] + var10[1];
                     }
                     break;
                  }

                  var10 = var11;
               }
            }
         }
      }

      boolean var12 = var1 > 0;
      this.h.v = this.i.v = this.j.v = true;
      if (!var12 && this.d == this.a.size() - 1) {
         LangLa_ke var13 = (LangLa_ke)this.a.elementAt(this.d);
         if (this.f == var13.c.size()) {
            if (this.g == -1) {
               this.i.v = this.j.v = false;
            } else if (this.g == -2) {
               this.h.v = false;
            }
         }
      }

      DataCenter.gI().aO.a = false;
      int var10001;
      if (this.p instanceof LangLa_md) {
         if (((LangLa_md)this.p).a == 0 && this.d < 5 && this.k) {
            var10001 = this.width - 100;
            DataCenter.gI().aO.a(var10001, this.height - 30);
            DataCenter.gI().aO.a = true;
         }

      } else {
         if (this.p instanceof GameSrc && this.p.cD.lastElement().equals(this) && (GameSrc.gI().Task <= 12 || GameSrc.gI().Task == 14)) {
            if (!this.h.v) {
               var10001 = this.width / 2;
               DataCenter.gI().aO.a(var10001, this.height - 15);
               DataCenter.gI().aO.a = true;
            }

            if (!this.i.v) {
               DataCenter.gI().aO.a(this.width / 2 - 30, this.height - 15);
               DataCenter.gI().aO.a = true;
            }
         }

      }
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      switch(var1.b) {
      case 200:
         this.d = this.a.size();
         this.e = this.f = 0;
         if (this.d >= this.a.size()) {
            this.b[0] = new LangLa_jb(this.c[0], (byte)1, -this.c[0].height);
            this.b[1] = new LangLa_jb(this.c[1], (byte)1, this.height);
            return;
         }
         break;
      case 201:
         this.J();
         (new Message((byte)11)).send();
         return;
      case 202:
         this.J();
         (new Message((byte)10)).send();
         return;
      case 1000:
         boolean var4 = true;
         LangLa_ke var5 = (LangLa_ke)this.a.elementAt(this.d);
         if (this.f < var5.c.size() - 1) {
            var4 = false;
            this.k = true;
         } else if (this.f == var5.c.size() - 1) {
            String var6 = var5.c.elementAt(this.f).toString();
            if (this.e < var6.length() - 1) {
               var4 = false;
               this.k = true;
            }
         }

         if (!var4) {
            this.e = 0;
            this.f = var5.c.size();
         } else {
            if (this.d >= this.a.size() - 1 && (this.g == -1 || this.g == -2)) {
               return;
            }

            ++this.d;
            this.e = this.f = 0;
            if (this.d >= this.a.size()) {
               this.b[0] = new LangLa_jb(this.c[0], (byte)1, -this.c[0].height);
               this.b[1] = new LangLa_jb(this.c[1], (byte)1, this.height);
               return;
            }
         }
      }

   }

   public void a(int var1, Object var2, LangLa_cy var3) {
   }

   public void a(int var1, Object var2) {
   }

   public void d() {
      super.d();
      Task var1;
      if ((var1 = GameSrc.gI().A()) != null && this.g >= 0 && this.g < var1.vStep.size() && ((Step)var1.vStep.elementAt(this.g)).id == 5) {
         (new Message((byte)12)).send();
      }

      try {
         if (this.g == -10) {
            Message.c((byte)-51).send();
         }

      } catch (Exception var2) {
      }
   }
}
