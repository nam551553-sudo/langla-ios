package beatdz;import com.tgame.model.Caption;
import java.util.Collections;
import java.util.Vector;

public class LangLa_p extends LangLa_ko {
   private String[] d;
   private LangLa_lf e;
   private LangLa_ii[] f;
   private LangLa_ii[][] g;
   private Vector h;
   private boolean u;
   public Vector a;
   public Vector b;
   public Vector c;
   private LangLa_ce v;
   private LangLa_ce w;
   private LangLa_ce x;
   
   private LangLa_ce[][] z;
   private int A;

   public LangLa_p(MainScreen var1, int var2) {
      super(var1, 0, new String[]{Caption.C});
      this.d = Caption.sj;
      this.a = new Vector();
      this.b = new Vector();
      this.c = new Vector();
      this.p = var1;
      this.r = false;
      this.a(300, 220);
      this.e = new LangLa_lf(new LangLa_kd(1001, this.d), 4, this.a_(), super.width - 8, 23, 66, this, false);
      this.v = this.a(34, this.a_() + this.G() - 20, Caption.fZ, 100);
      LangLa_dz var3;
      (var3 = this.a(this.width - 70, this.a_() + this.G() - 23, Caption.gx, this, 1004, 7)).setSize(60, 20);
      this.e.a((LangLa_cs)var3, 0);
      this.e.a((LangLa_cs)var3, 1);
      (var3 = this.a(this.width - 134, this.a_() + this.G() - 23, Caption.po, this, 1005, 7)).setSize(60, 20);
      this.e.a((LangLa_cs)var3, 0);
      LangLa_ce var10000 = this.v;
      boolean var4 = Binary.readBoolan("friend" + Char.gI().idEntity);
      var10000.a = var4;
      this.e.a((LangLa_cs)this.v, 0);
      this.w = this.a(9, this.a_() + this.G() - 20, Caption.fZ, 100);
      var10000 = this.w;
      var4 = Binary.readBoolan("enermy" + Char.gI().idEntity);
      var10000.a = var4;
      this.e.a((LangLa_cs)this.w, 1);
      this.e.a((LangLa_cs)this.a(9, this.a_() + this.G() - 22, "", this, 1002, 65), 0);
      this.x = this.a(59, this.a_() + this.G() - 20, Caption.qn, 106);
      var10000 = this.x;
      var4 = mConfig.gI().readBoolean(24);
      var10000.a = var4;
      this.e.a((LangLa_cs)this.x, 2);
      this.z = new LangLa_ce[2][];
      this.g = new LangLa_ii[2][];
      this.f = new LangLa_ii[3];
      this.e();
      this.f();
      this.g();
      this.e.a(this.c(0));
      this.a(0);
   }

   private void e() {
      this.a.clear();
      if (this.v.a) {
         for(int var2 = 0; var2 < GameSrc.gI().vFriend.size(); ++var2) {
            Friend var1;
            if ((var1 = (Friend)GameSrc.gI().vFriend.elementAt(var2)).d) {
               this.a.add(var1);
            }
         }
      } else {
         this.a.addAll(GameSrc.gI().vFriend);
      }

      Binary.writeBoolean("friend" + Char.gI().idEntity, this.v.a);
      Collections.sort(this.a, beatdz.Friend.$state_Friend().a);
      this.A = 21;
      this.f[0] = new LangLa_ii((byte)1, 8, this.a_() + 30, super.width - 8 - 10, this.A * 6, this.A, this.a.size());
      this.z[0] = new LangLa_ce[GameSrc.gI().vFriend.size()];
      this.g[0] = new LangLa_ii[GameSrc.gI().vFriend.size()];

      for(int var3 = 0; var3 < GameSrc.gI().vFriend.size(); ++var3) {
         this.z[0][var3] = new LangLa_ce(2, 2 + var3 * this.f[0].h, "", this, 0);
         this.g[0][var3] = new LangLa_in((byte)1, 0, 0, this.z[0][var3].width, this.z[0][var3].height, this.z[0][var3].height, 1, this.f[0]);
      }

   }

   private void f() {
      this.b.clear();
      if (this.w.a) {
         for(int var2 = 0; var2 < GameSrc.gI().vEnemy.size(); ++var2) {
            Enemy var1;
            if ((var1 = (Enemy)GameSrc.gI().vEnemy.elementAt(var2)).c) {
               this.b.add(var1);
            }
         }
      } else {
         this.b.addAll(GameSrc.gI().vEnemy);
      }

      Binary.writeBoolean("enermy" + Char.gI().idEntity, this.w.a);
      Collections.sort(this.b, beatdz.Enemy.$state_Enemy().a);
      this.A = 21;
      this.f[1] = new LangLa_ii((byte)1, 8, this.a_() + 30, super.width - 8 - 10, this.A * 6, this.A, this.b.size());
      this.z[1] = new LangLa_ce[GameSrc.gI().vEnemy.size()];
      this.g[1] = new LangLa_ii[GameSrc.gI().vEnemy.size()];

      for(int var3 = 0; var3 < GameSrc.gI().vEnemy.size(); ++var3) {
         this.z[1][var3] = new LangLa_ce(2, 2 + var3 * this.f[1].h, "", this, 0);
         this.g[1][var3] = new LangLa_in((byte)1, 0, 0, this.z[1][var3].width, this.z[1][var3].height, this.z[1][var3].height, 1, this.f[1]);
      }

   }

   private void g() {
      this.c.clear();
      this.c.add(Char.gI());
      this.c.addAll(GameSrc.gI().vChar);
      if (this.x.a) {
         this.f[2] = new LangLa_ii((byte)1, 8, this.a_() + 26, super.width - 8 - 10, 132, 22, this.c.size());
      } else {
         this.f[2] = new LangLa_ii((byte)1, 8, this.a_() + 30, super.width - 8 - 10, 126, 42, this.c.size());
      }
   }

   public void d() {
      super.d();
   }

   public void a(int var1, Object var2, LangLa_cy var3) {
      super.a(var1, var2, var3);
      if (this.k() == 0) {
         LangLa_p var11;
         LangLa_kd var12;
         switch(var1) {
         case 100:
            this.e();
            this.f();
            return;
         case 106:
            mConfig.gI().writeBoolean(24, this.x.a);
            this.g();
            return;
         case 2000:
            var12 = (LangLa_kd)var2;
            var11 = this;

            try {
               Message var14;
               if (var11.e.b.b != 0) {
                  if (var11.e.b.b == 2) {
                     Char var16 = (Char)var11.c.elementAt(var12.a);
                     (var14 = new Message((byte)79)).writeUTF(var16.name);
                     var14.send();
                  }
                  break;
               }

               Friend var15 = (Friend)var11.a.elementAt(var12.a);
               (var14 = new Message((byte)79)).writeUTF(var15.c);
               var14.send();
            } catch (Exception var10) {
               Utlis.println(var10);
            }

            return;
         case 2001:
            var12 = (LangLa_kd)var2;
            var11 = this;

            try {
               Message var13;
               if (var11.e.b.b == 0) {
                  (var13 = new Message((byte)76)).writeUTF(var11.d(var12.a));
                  var13.send();
                  return;
               }

               if (var11.e.b.b == 1) {
                  (var13 = new Message((byte)-18)).writeUTF(var11.d(var12.a));
                  var13.send();
               }
               break;
            } catch (Exception var9) {
               Utlis.println(var9);
               return;
            }
         case 2002:
            var12 = (LangLa_kd)var2;
            var11 = this;

            try {
               GameSrc.gI();
               GameSrc.d(var11.d(var12.a));
               break;
            } catch (Exception var8) {
               Utlis.println(var8);
               return;
            }
         case 2003:
            var12 = (LangLa_kd)var2;
            var11 = this;

            try {
               var11.u = true;
               var11.m();
               var11.a(var11.j());
               GameSrc.gI().a((String)var11.d(var12.a), (LangLa_ko)var11);
               break;
            } catch (Exception var7) {
               Utlis.println(var7);
               return;
            }
         case 2004:
            var12 = (LangLa_kd)var2;
            var11 = this;

            try {
               GameSrc.gI();
               GameSrc.h(var11.d(var12.a));
               break;
            } catch (Exception var6) {
               Utlis.println(var6);
               return;
            }
         case 2005:
            var12 = (LangLa_kd)var2;
            var11 = this;

            try {
               GameSrc.gI();
               GameSrc.c(var11.d(var12.a));
               break;
            } catch (Exception var5) {
               Utlis.println(var5);
               return;
            }
         case 2006:
            var12 = (LangLa_kd)var2;
            var11 = this;

            try {
               GameSrc.gI();
               GameSrc.e(var11.d(var12.a));
               break;
            } catch (Exception var4) {
               Utlis.println(var4);
               return;
            }
         case 2007:
            var12 = (LangLa_kd)var2;
            GameSrc.gI();
            GameSrc.f(this.d(var12.a));
            return;
         case 2008:
            var12 = (LangLa_kd)var2;
            GameSrc.gI();
            GameSrc.g(this.d(var12.a));
         }
      }

   }

   private void n() {
      int var1 = 0;

      for(int var2 = 0; var2 < this.z[this.e.b.b].length; ++var2) {
         if (this.z[this.e.b.b][var2].a) {
            this.b(var2);
            ++var1;
         }
      }

      if (var1 == 0) {
         DataCenter.gI().currentScreen.showMessage(Caption.or, -65536);
      }

   }

   public void a(int var1, Object var2) {
   }

   public void a(Graphics var1) {
      int var2 = var1.a;
      int var3 = var1.b;
      if (this.u) {
         super.a(var1);
      } else {
         this.a(var1, this.cx, this.cy, this.width, this.height, "", (byte)2, this.r);
         this.a(var1, this.cx, this.cy);
         mFont.a((mFont)mFont.f, (Graphics)var1, Caption.C, this.width / 2, 15, 2, -2560, 0);
         this.a(var1, var2, var3);
      }

      if (this.k() == 0) {
         try {
            this.e.a(var1);
            this.a(var1, this.cx + 4, this.cy + this.a_() + 22);
            this.a(var1, -1, 0, super.width - 8 + 1, this.G() - 48, 4, 55, 56);
            this.a(var1, this.f[this.e.b.b]);

            for(var2 = 0; var2 < this.f[this.e.b.b].i; ++var2) {
               if (this.f[this.e.b.b].b(var2)) {
                  if (var2 == this.f[this.e.b.b].k && this.e.b.b != 2) {
                     var1.f(13136426);
                     var1.c(0, var2 * this.f[this.e.b.b].h, this.f[this.e.b.b].width, this.f[this.e.b.b].h - 1);
                     var1.c(0, var2 * this.f[this.e.b.b].h, this.f[this.e.b.b].width, this.f[this.e.b.b].h - 1);
                  }

                  int var8;
                  int var16;
                  switch(this.e.b.b) {
                  case 0:
                     Friend var15 = (Friend)this.h.elementAt(var2);
                     int var5 = var2;
                     Graphics var4 = var1;
                     LangLa_p var13 = this;

                     try {
                        if (var15.d) {
                           LangLa_fq.a(var4, 302, 0, 22, 6 + var5 * var13.f[var13.e.b.b].h, 20);
                        } else if (var15.b == 1) {
                           LangLa_fq.a(var4, 304, 0, 22, 6 + var5 * var13.f[var13.e.b.b].h, 20);
                        } else {
                           LangLa_fq.a(var4, 303, 0, 22, 6 + var5 * var13.f[var13.e.b.b].h, 20);
                        }

                        if (var5 == var13.f[var13.e.b.b].l) {
                           mFont.b(mFont.d, var4, var15.c + (var15.b == 2 ? Caption.gb : ""), 35, 10 + var5 * var13.f[var13.e.b.b].h, 0, -3089954, -16777216);
                        } else {
                           mFont.b(mFont.d, var4, var15.c + (var15.b == 2 ? Caption.gb : ""), 34, 11 + var5 * var13.f[var13.e.b.b].h, 0, -3089954, -16777216);
                        }

                        var16 = var4.a;
                        var8 = var4.b;
                        var13.a(var4, var16 + var13.z[var13.e.b.b][var5].cx, var8 + var13.z[var13.e.b.b][var5].cy);
                        var13.z[var13.e.b.b][var5].a(var4);
                        var13.a(var4, var16, var8);
                     } catch (Exception var11) {
                        Utlis.println(var11);
                     }
                     break;
                  case 1:
                     Enemy var14 = (Enemy)this.h.elementAt(var2);
                     if (var14.c) {
                        LangLa_fq.a(var1, 302, 0, 22, 6 + var2 * this.f[this.e.b.b].h, 20);
                     } else {
                        LangLa_fq.a(var1, 304, 0, 22, 6 + var2 * this.f[this.e.b.b].h, 20);
                     }

                     if (var2 == this.f[this.e.b.b].l) {
                        mFont.b(mFont.d, var1, var14.b, 35, 10 + var2 * this.f[this.e.b.b].h, 0, -1, -16777216);
                     } else {
                        mFont.b(mFont.d, var1, var14.b, 34, 11 + var2 * this.f[this.e.b.b].h, 0, -1, -16777216);
                     }

                     var16 = var1.a;
                     var8 = var1.b;
                     this.a(var1, var16 + this.z[this.e.b.b][var2].cx, var8 + this.z[this.e.b.b][var2].cy);
                     this.z[this.e.b.b][var2].a(var1);
                     this.a(var1, var16, var8);
                     break;
                  case 2:
                     Char var10003 = (Char)this.h.elementAt(var2);
                     boolean var7 = var2 == this.f[this.e.b.b].k;
                     Char var6 = var10003;
                     if (var7) {
                        var1.f(-3640790);
                        var1.c(1, 1 + var2 * this.f[this.e.b.b].h, this.f[this.e.b.b].width - 2, this.f[this.e.b.b].h - 2);
                     }

                     this.a(var1, 0, var2 * this.f[this.e.b.b].h, this.f[this.e.b.b].width, this.f[this.e.b.b].h - 2, -13, 84, 5, 1, 1);
                     int var9;
                     int var10004;
                     if (!this.x.a) {
                        var10004 = var2 * this.f[this.e.b.b].h;
                        Binary2.a(var1, DataCenter.gI().DataIconChar[var6.idChar].idIcon, 0, 10, var10004 + 5, 83);
                        var8 = var2 == this.f[this.e.b.b].k ? -2560 : -1;
                        var16 = 46;
                        var9 = var2 * this.f[this.e.b.b].h + 10;
                        if (var2 == this.f[this.e.b.b].l && !var6.name.equals(Char.gI().name)) {
                           ++var16;
                           ++var9;
                        }

                        mFont.a(mFont.d, var1, Caption.rG[3] + " " + var6.name, var16, var9, 0, var8);
                        mFont.a(mFont.d, var1, Caption.rG[5] + " " + var6.level(), var16, var9 + 10, 0, var8);
                        mFont.a(mFont.d, var1, Caption.rG[4] + " " + DataCenter.gI().DataNameChar[var6.idClass].name, var16, var9 + 20, 0, var8);
                     } else {
                        var10004 = var2 * this.f[this.e.b.b].h;
                        Binary2.a(var1, DataCenter.gI().DataIconChar[var6.idChar].idIcon, 0, 6, var10004 + 3, 40);
                        var8 = var2 == this.f[this.e.b.b].k ? -2560 : -1;
                        var16 = 25;
                        var9 = var2 * this.f[this.e.b.b].h + 10;
                        if (var2 == this.f[this.e.b.b].l && !var6.name.equals(Char.gI().name)) {
                           ++var16;
                           ++var9;
                        }

                        mFont.a(mFont.d, var1, Caption.rG[3] + " " + var6.name + ", " + Caption.rG[5] + " " + var6.level() + ", " + Caption.rG[4] + " " + DataCenter.gI().DataNameChar[var6.idClass].name, var16, var9, 0, var8);
                     }
                  }
               }
            }
         } catch (Exception var12) {
         }

         this.b(var1);
         this.a(var1, this.cx + 4, this.cy + this.a_());
         switch(this.e.b.b) {
         case 0:
            mFont.a(mFont.d, var1, Caption.ob + this.h.size(), 112, this.G() - 13, 0, -1);
            this.f[this.e.b.b].b(var1, -17, -40);
            return;
         case 1:
            mFont.a(mFont.d, var1, Caption.ob + this.h.size(), 97, this.G() - 13, 0, -1);
            this.f[this.e.b.b].b(var1, -17, -40);
            return;
         case 2:
            mFont.a(mFont.d, var1, Caption.ga + this.c.size(), 10, this.G() - 10, 0, -1);
         }
      }

   }

   public void b() {
      super.b();
      if (this.k() == 0) {
         this.e.b();

         for(int var1 = 0; var1 < this.f.length; ++var1) {
            this.f[this.e.b.b].a();
         }
      }

   }

   public Vector c() {
      Vector var1 = super.c();
      if (!this.u) {
         var1.removeElementAt(0);
      }

      if (this.k() == 0) {
         if (this.e.b.b < 2) {
            for(int var4 = 0; var4 < this.g[this.e.b.b].length; ++var4) {
               int var2 = this.f[this.e.b.b].cx + this.z[this.e.b.b][var4].cx;
               int var3 = this.f[this.e.b.b].cy + this.z[this.e.b.b][var4].cy - this.f[this.e.b.b].f;
               if (Utlis.inRange(this.f[this.e.b.b].cx, this.f[this.e.b.b].cy, this.f[this.e.b.b].cx + this.f[this.e.b.b].width, this.f[this.e.b.b].cy + this.f[this.e.b.b].height, var2, var3) && Utlis.inRange(this.f[this.e.b.b].cx, this.f[this.e.b.b].cy, this.f[this.e.b.b].cx + this.f[this.e.b.b].width, this.f[this.e.b.b].cy + this.f[this.e.b.b].height, var2 + this.z[this.e.b.b][var4].width, var3 + this.z[this.e.b.b][var4].height)) {
                  this.g[this.e.b.b][var4].cx = (short)var2;
                  this.g[this.e.b.b][var4].cy = (short)var3;
                  var1.addElement(this.g[this.e.b.b][var4].a(8000 + var4, this));
               }
            }
         }

         var1.addElement(this.e.c());
         var1.addElement(this.f[this.e.b.b].a(1003, this));
      }

      return var1;
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      super.a(var1, var2, var3);
      if (var1.b >= 8000 && var1.b < 9000) {
         int var10 = var1.b - 8000;
         LangLa_ce var10000 = this.z[this.e.b.b][var10];
         boolean var11 = !this.z[this.e.b.b][var10].a;
         var10000.a = var11;
      } else {
         if (this.k() == 0) {
            switch(var1.b) {
            case 1001:
               if (var1.j.k >= 0) {
                  beatdz.LangLa_p.$state_LangLa_p().y = var1.j.k;
                  this.e.a(var1.j.k);
                  this.q();
                  return;
               }
               break;
            case 1002:
               return;
            case 1003:
               if (var1.j.k >= 0) {
                  int var4 = var3;
                  var3 = var2;
                  var2 = var1.j.k;
                  Vector var5 = new Vector();
                  if (this.e.b.b == 0) {
                     Friend var6;
                     if ((var6 = (Friend)this.a.elementAt(var2)).b == 2) {
                        var5.addElement(new LangLa_lk(2000, Caption.gc));
                        var5.addElement(new LangLa_lk(2001, Caption.gd));
                     }

                     if (var6.b < 2) {
                        var5.addElement(new LangLa_lk(2001, Caption.ge));
                     }

                     if (GameSrc.gI().aI != null && !GameSrc.gI().aI.b()) {
                        if (GameSrc.gI().aI.a() && !GameSrc.gI().aI.a(var6.c)) {
                           var5.addElement(new LangLa_lk(2005, Caption.dF));
                        }
                     } else {
                        var5.addElement(new LangLa_lk(2005, Caption.dE));
                     }

                     var5.addElement(new LangLa_lk(2002, Caption.dG));
                     var5.addElement(new LangLa_lk(2003, Caption.cl));
                     var5.addElement(new LangLa_lk(2004, Caption.cj));
                     var5.addElement(new LangLa_lk(2008, Caption.oC));
                  } else if (this.e.b.b == 1) {
                     Enemy var12 = (Enemy)this.h.elementAt(var2);
                     var5.addElement(new LangLa_lk(2001, Caption.gf));
                     if (GameSrc.gI().aI != null && !GameSrc.gI().aI.b()) {
                        if (GameSrc.gI().aI.a() && !GameSrc.gI().aI.a(var12.b)) {
                           var5.addElement(new LangLa_lk(2005, Caption.dF));
                        }
                     } else {
                        var5.addElement(new LangLa_lk(2005, Caption.bI));
                     }

                     var5.addElement(new LangLa_lk(2002, Caption.dG));
                     var5.addElement(new LangLa_lk(2003, Caption.cl));
                     var5.addElement(new LangLa_lk(2004, Caption.cj));
                     var5.addElement(new LangLa_lk(2008, Caption.oC));
                  } else {
                     Char var13;
                     if (this.e.b.b == 2 && !(var13 = (Char)this.h.elementAt(var2)).equals(Char.gI())) {
                        if (GameSrc.gI().aI != null && !GameSrc.gI().aI.b()) {
                           if (GameSrc.gI().aI.a() && !GameSrc.gI().aI.a(var13.name)) {
                              var5.addElement(new LangLa_lk(2005, Caption.dF));
                           }
                        } else {
                           var5.addElement(new LangLa_lk(2005, Caption.bI));
                        }

                        var5.addElement(new LangLa_lk(2006, Caption.F));
                        var5.addElement(new LangLa_lk(2002, Caption.dG));
                        var5.addElement(new LangLa_lk(2003, Caption.cl));
                        var5.addElement(new LangLa_lk(2004, Caption.cj));
                        var5.addElement(new LangLa_lk(2008, Caption.oC));
                     }
                  }

                  if (var5.size() > 0) {
                     String[] var14 = new String[var5.size()];
                     short[] var7 = new short[var5.size()];

                     for(int var8 = 0; var8 < var5.size(); ++var8) {
                        LangLa_lk var9 = (LangLa_lk)var5.elementAt(var8);
                        var14[var8] = var9.b;
                        var7[var8] = (short)var9.a;
                     }

                     this.cL = a(this, var3 + 25, var4, new LangLa_kd(var2, var7, var14));
                  }

                  return;
               }
               break;
            case 1004:
               this.n();
               return;
            case 1005:
               this.o();
            }
         }

      }
   }

   private void o() {
      int var1 = 0;

      for(int var3 = 0; var3 < this.a.size(); ++var3) {
         if (((Friend)this.a.get(var3)).b == 2) {
            this.b(var3);
            ++var1;
         }
      }

      DataCenter.gI().currentScreen.showMessage(Utlis.replaceAll(Caption.pp, String.valueOf(var1)), -1);
   }

   public void a(int var1) {
      super.a(var1);
      if (this.e != null && this.k() == 0) {
         this.e.a(beatdz.LangLa_p.$state_LangLa_p().y);
         this.q();
      }

   }

   private void q() {
      if (this.e != null) {
         switch(this.e.b.b) {
         case 0:
            this.h = this.a;
            return;
         case 1:
            this.h = this.b;
            return;
         case 2:
            this.h = this.c;
         }
      }

   }

   private void b(int var1) {
      try {
         Message var2;
         if (this.k() != 1) {
            if (this.k() == 2) {
               (var2 = new Message((byte)-18)).writeUTF(this.d(var1));
               var2.send();
            }

            return;
         }

         (var2 = new Message((byte)76)).writeUTF(this.d(var1));
         var2.send();
      } catch (Exception var3) {
         Utlis.println(var3);
      }

   }

   private String d(int var1) {
      try {
         if (this.e.b.b == 0) {
            return ((Friend)this.h.elementAt(var1)).c;
         }

         if (this.e.b.b == 1) {
            return ((Enemy)this.h.elementAt(var1)).b;
         }

         if (this.e.b.b == 2) {
            return ((Char)this.c.elementAt(var1)).name;
         }
      } catch (Exception var3) {
         Utlis.println(var3);
      }

      return "";
   }

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public int y;
public void initialize() {
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.LangLa_p");
public static SessionState $state_LangLa_p() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
