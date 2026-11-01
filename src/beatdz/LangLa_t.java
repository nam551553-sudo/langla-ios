package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_t extends LangLa_s {
   private LangLa_ii h;
   private LangLa_ii[] i;
   private LangLa_ce[] u;
   private LangLa_ce v;
   private boolean w;

   public LangLa_t(MainScreen var1) {
      super(var1, new String[]{Caption.A});
      this.p = var1;
      this.a(320, 222);
      this.r = false;
      this.v = this.a(5, this.a_() + 5, Caption.gw, 1000);
      this.a(this.v, 0);
      LangLa_dz var2;
      (var2 = this.a(68, this.a_() + 2, Caption.gx, this, 1001, 7)).setSize(55, 20);
      this.a(var2, 0);
      (var2 = this.a(128, this.a_() + 2, Caption.gy, this, 1002, 7)).setSize(55, 20);
      this.a(var2, 0);
      (var2 = this.a(188, this.a_() + 2, Caption.gz, this, 1003, 7)).setSize(55, 20);
      this.a(var2, 0);
      (var2 = this.a(248, this.a_() + 2, Caption.oM, this, 1004, 7)).setSize(55, 20);
      this.a(var2, 0);
      this.g();
      this.a(0);
   }

   public void g() {
      this.h = new LangLa_ii((byte)1, 4, this.a_() + 25, super.width - 8 - 5, 150, 30, GameSrc.gI().vThu.size());
      this.u = new LangLa_ce[GameSrc.gI().vThu.size()];
      this.i = new LangLa_ii[GameSrc.gI().vThu.size()];

      for(int var1 = 0; var1 < GameSrc.gI().vThu.size(); ++var1) {
         this.u[var1] = new LangLa_ce(1, 7 + var1 * this.h.h, "", this, 0);
         this.i[var1] = new LangLa_in((byte)1, 0, 0, this.u[var1].width, this.u[var1].height, this.u[var1].height, 1, this.h);
      }

   }

   public void a(int var1, Object var2, LangLa_cy var3) {
      if (this.k() == 0) {
         switch(var1) {
         case 1000:
            var1 = 0;

            for(int var5 = 0; var5 < this.u.length; ++var5) {
               if (this.u[var5].a) {
                  ++var1;
               }
            }

            boolean var6 = var1 != this.u.length;

            for(var1 = 0; var1 < this.u.length; ++var1) {
               this.u[var1].a = var6;
            }
         }
      }

   }

   public void a(int var1, Object var2) {
   }

   public void a(Graphics var1) {
      try {
         int var2 = var1.a;
         int var3 = var1.b;
         if (this.w) {
            super.a(var1);
         } else {
            this.a(var1, this.cx, this.cy, this.width, this.height, "", (byte)2, this.r);
            this.a(var1, this.cx, this.cy);
            mFont.a((mFont)mFont.f, (Graphics)var1, Caption.A, this.width / 2, 15, 2, -2560, 0);
            this.a(var1, var2, var3);
         }

         if (this.k() == 0) {
            this.a(var1, this.h);

            for(int var4 = 0; var4 < this.u.length; ++var4) {
               try {
                  Thu var7 = (Thu)GameSrc.gI().vThu.elementAt(var4);
                  if (this.h.b(var4)) {
                     label47: {
                        this.a(var1, 20, var4 * this.h.h, this.h.width - 20, this.h.h - 1, -13, 84, 5, 1, 1);
                        if (var4 == this.h.k) {
                           var1.f(-3640790);
                           var1.c(22, 2 + var4 * this.h.h, this.h.width - 24, this.h.h - 5);
                        } else if (var4 == this.h.l) {
                           mFont.a((mFont)mFont.d, (Graphics)var1, var7.c, 61, 8 + var4 * this.h.h, 0, -1, -10275328);
                           break label47;
                        }

                        mFont.a((mFont)mFont.d, (Graphics)var1, var7.c, 60, 7 + var4 * this.h.h, 0, -1, -10275328);
                     }

                     if (var7.k) {
                        LangLa_fq.a(var1, 418, 0, 40, var4 * this.h.h + this.h.h / 2 - 1, 3);
                     } else {
                        LangLa_fq.a(var1, 83, 0, 40, var4 * this.h.h + this.h.h / 2 - 1, 3);
                     }

                     mFont.a((mFont)mFont.d, (Graphics)var1, var7.b, 60, 20 + var4 * this.h.h, 0, -22360, -10275328);
                     mFont.a((mFont)mFont.b, (Graphics)var1, Caption.gA + Utlis.getTextTimeFormSeconds((int)((long)var7.l - Utlis.time() / 1000L)), this.h.width - 6, 20 + var4 * this.h.h, 1, -6488, -10275328);
                     if (var7.a()) {
                        mFont.b(mFont.d, var1, Caption.gB, this.h.width - 8, 8 + var4 * this.h.h, 1, -2560, -10275328);
                     }

                     var2 = var1.a;
                     var3 = var1.b;
                     this.a(var1, var2 + this.u[var4].cx, var3 + this.u[var4].cy);
                     this.u[var4].a(var1);
                     this.a(var1, var2, var3);
                  }
               } catch (Exception var5) {
               }
            }

            this.b(var1);
            mFont.a(mFont.d, var1, Caption.ob + GameSrc.gI().vThu.size() + " " + Caption.oe, 12, this.height - 11, 0, -1);
            this.h.b(var1, -8, -10);
         }

      } catch (Exception var6) {
         Utlis.println(var6);
      }
   }

   public void b() {
      try {
         super.b();
         if (this.k() == 0) {
            this.h.a();

            for(int var1 = 0; var1 < this.u.length; ++var1) {
               this.u[var1].b();
               this.i[var1].a();
               if (this.i[var1].l != -1) {
                  this.u[var1].b = true;
               } else {
                  this.u[var1].b = false;
               }
            }
         }

      } catch (Exception var2) {
         Utlis.println(var2);
      }
   }

   public Vector c() {
      Vector var1 = super.c();

      try {
         if (!this.w) {
            var1.removeElementAt(0);
         }

         if (this.k() == 0) {
            for(int var4 = 0; var4 < this.i.length; ++var4) {
               int var2 = this.h.cx + this.u[var4].cx;
               int var3 = this.h.cy + this.u[var4].cy - this.h.f;
               if (Utlis.inRange(this.h.cx, this.h.cy, this.h.cx + this.h.width, this.h.cy + this.h.height, var2, var3) && Utlis.inRange(this.h.cx, this.h.cy, this.h.cx + this.h.width, this.h.cy + this.h.height, var2 + this.u[var4].width, var3 + this.u[var4].height)) {
                  this.i[var4].cx = (short)var2;
                  this.i[var4].cy = (short)var3;
                  var1.addElement(this.i[var4].a(8000 + var4, this));
               }
            }

            var1.addElement(this.h.a(1005, this));
         }
      } catch (Exception var5) {
         Utlis.println(var5);
      }

      return var1;
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      super.a(var1, var2, var3);
      if (this.k() == 0) {
         if (var1.b >= 8000 && var1.b < 9000) {
            var2 = var1.b - 8000;
            LangLa_ce var10000 = this.u[var2];
            boolean var11 = !this.u[var2].a;
            var10000.a = var11;
            var2 = 0;

            for(var3 = 0; var3 < this.u.length; ++var3) {
               if (this.u[var3].a) {
                  ++var2;
               }
            }

            if (var2 == this.u.length) {
               var11 = true;
               this.v.a = var11;
            } else {
               var11 = false;
               this.v.a = var11;
            }
         }

         switch(var1.b) {
         case 1001:
            this.a(true);
            return;
         case 1002:
            this.b(true);
            return;
         case 1003:
            this.a((Thu)null);
            return;
         case 1004:
            this.p.a(Caption.pK, 2003, this);
            return;
         case 1005:
            if (var1.j.k >= 0) {
               var2 = var1.j.k;
               LangLa_t var8 = this;

               try {
                  Thu var14 = (Thu)GameSrc.gI().vThu.elementAt(var2);
                  LangLa_t var15 = var8;
                  int var10002 = var8.cx + 30;
                  boolean var9 = false;
                  short var4 = var8.cy;
                  var3 = var10002;
                  var8 = var8;
                  LangLa_kk var12;
                  if ((var12 = new LangLa_kk(var3, var4, 0, var8, var14)).cx > DataCenter.gI().widthScreen - var12.width - var8.cx) {
                     var12.cx = (short)(DataCenter.gI().widthScreen - var12.width - var8.cx);
                  }

                  if (var12.cx < -var8.cx) {
                     var12.cx = (short)(-var8.cx);
                  }

                  if (var12.cy > DataCenter.gI().heightScreen - var12.height - var8.cy) {
                     var12.cy = (short)(DataCenter.gI().heightScreen - var12.height - var8.cy);
                  }

                  for(int var13 = var8.cG.size() - 1; var13 >= 0; --var13) {
                     LangLa_cs var5;
                     if ((var5 = (LangLa_cs)var8.cG.get(var13)) instanceof LangLa_kk) {
                        var8.b(var5);
                     }
                  }

                  var8.a(var12);
                  var15.cL = var12;
                  if (!var14.k) {
                     var14.k = true;
                     Message var10;
                     (var10 = new Message((byte)96)).writeShort(var14.a);
                     var10.send();
                  }
               } catch (Exception var6) {
                  Utlis.println(var6);
                  return;
               }
            }
            break;
         case 2001:
            this.a(false);
            return;
         case 2002:
            this.b(false);
            return;
         case 2003:
            try {
               Message.c((byte)-50).send();
               return;
            } catch (Exception var7) {
            }
         }
      }

   }

   public void a(Thu var1) {
      this.w = true;
      this.a(this.j() - 1);
      if (var1 != null) {
         this.c.a(var1.b);
         if (!var1.c.contains("Re: ")) {
            this.b.a("Re: " + var1.c);
         }
      }

   }

   private void a(boolean var1) {
      Vector var2 = new Vector();
      int var4 = 0;

      for(int var5 = 0; var5 < GameSrc.gI().vThu.size(); ++var5) {
         Thu var3 = (Thu)GameSrc.gI().vThu.elementAt(var5);
         if (this.u[var5].a) {
            if (!var3.a()) {
               var2.add(var3);
            } else {
               ++var4;
            }
         }
      }

      if (var4 > 0) {
         DataCenter.gI().currentScreen.showMessage(Caption.gC, -65536);
      } else if (var2.size() <= 0) {
         DataCenter.gI().currentScreen.showMessage(Caption.gD, -65536);
      } else if (var1) {
         DataCenter.gI().currentScreen.a(Caption.gk, 2001, this);
      } else {
         c(var2);
      }
   }

   private void b(boolean var1) {
      Vector var2 = new Vector();

      for(int var4 = 0; var4 < GameSrc.gI().vThu.size(); ++var4) {
         Thu var3;
         if ((var3 = (Thu)GameSrc.gI().vThu.elementAt(var4)).k && !var3.a()) {
            var2.add(var3);
         }
      }

      if (var2.size() <= 0) {
         DataCenter.gI().currentScreen.showMessage(Caption.gD, -65536);
      } else if (var1) {
         DataCenter.gI().currentScreen.a(Caption.gk, 2002, this);
      } else {
         c(var2);
      }
   }

   public void d() {
      super.d();
   }

   public static void c(Vector var0) {
      try {
         Message var1;
         (var1 = new Message((byte)88)).writeShort(var0.size());

         for(int var3 = 0; var3 < var0.size(); ++var3) {
            Thu var2 = (Thu)var0.elementAt(var3);
            var1.writeShort(var2.a);
         }

         var1.send();
      } catch (Exception var4) {
         Utlis.println(var4);
      }
   }

   public void a(String var1) {
      this.a((Thu)null);
      this.c.a(var1);
   }
}
