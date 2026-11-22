package beatdz;import com.tgame.model.Caption;
import java.util.Collections;
import java.util.Vector;

public class LangLa_ca extends LangLa_ko {
   private LangLa_ce u;
   private LangLa_ce v;
   private LangLa_ii[][] w;
   public LangLa_dz a;
   public LangLa_dz b;
   public LangLa_ce c;
   public LangLa_ce d;
   private LangLa_lf x;
   private String[] y;
   private boolean z;
   private boolean A;
   public Vector e;
   public Vector f;
   public Vector g;
   public Vector h;
   
   private int C;
   private LangLa_ce[][] D;
   private LangLa_ii[][] E;
   private Vector F;

   public LangLa_ca(MainScreen var1) {
      super(var1, 5, Caption.sj);
      this.y = Caption.sn;
      this.z = true;
      this.e = new Vector();
      this.f = new Vector();
      this.g = new Vector();
      this.h = new Vector();
      this.p = var1;
      this.r = false;
      this.a(300, 220);
      this.x = new LangLa_lf(new LangLa_kd(1001, this.y), 4, this.a_(), super.width - 8, 23, 66, this);
      this.a = this.a(super.width - 8 - 56, this.height - 27, Caption.rG[2], this, 101, 15);
      this.a.setSize(54, 20);
      this.b = this.a(super.width - 8 - 113, this.height - 27, Caption.jb, this, 102, 15);
      this.b.setSize(54, 20);
      this.c = this.a(9, this.height - 26, Caption.jc, this, 104);
      this.d = this.a(79, this.height - 26, Caption.jd, this, 105);
      LangLa_ce var10000 = this.d;
      boolean var2 = GameSrc.gI().bC;
      var10000.a = var2;
      LangLa_dz var3;
      (var3 = this.a(super.width - 8 - 56, this.height - 27, Caption.je, this, 103, 15)).setSize(54, 20);
      this.x.a((LangLa_cs)this.a, 0);
      this.x.a((LangLa_cs)this.b, 0);
      this.x.a((LangLa_cs)this.c, 0);
      this.x.a((LangLa_cs)this.d, 0);
      this.x.a((LangLa_cs)var3, 1);
      this.w = new LangLa_ii[3][0];
      this.w[0] = new LangLa_ii[3];
      this.w[1] = new LangLa_ii[1];
      this.w[2] = new LangLa_ii[1];
      this.D = new LangLa_ce[2][];
      this.E = new LangLa_ii[2][];
      (var3 = this.a(this.width - 70, this.a_() + this.G() - 23, Caption.gx, this, 1004, 7)).setSize(60, 20);
      this.a(var3, 1);
      this.a(var3, 2);
      (var3 = this.a(this.width - 134, this.a_() + this.G() - 23, Caption.po, this, 1005, 7)).setSize(60, 20);
      this.a(var3, 1);
      this.u = this.a(34, this.a_() + this.G() - 20, Caption.fZ, 100);
      var10000 = this.u;
      var2 = Binary.readBoolan("friend" + Char.gI().idEntity);
      var10000.a = var2;
      this.a(this.u, 1);
      this.v = this.a(9, this.a_() + this.G() - 20, Caption.fZ, 100);
      var10000 = this.v;
      var2 = Binary.readBoolan("enermy" + Char.gI().idEntity);
      var10000.a = var2;
      this.a(this.v, 2);
      this.a(this.a(9, this.a_() + this.G() - 22, "", this, 1002, 65), 1);
      this.n();
      this.o();
      this.q();
      this.x.a(this.c(0));
      this.e();
      this.f();
      this.a(0);
      this.g();
      (new Message((byte)43)).send();
   }

   public void e() {
      this.e.clear();
      if (this.u.a) {
         for(int var2 = 0; var2 < GameSrc.gI().vFriend.size(); ++var2) {
            Friend var1;
            if ((var1 = (Friend)GameSrc.gI().vFriend.elementAt(var2)).d) {
               this.e.add(var1);
            }
         }
      } else {
         this.e.addAll(GameSrc.gI().vFriend);
      }

      Binary.writeBoolean("friend" + Char.gI().idEntity, this.u.a);
      Collections.sort(this.e, beatdz.Friend.$state_Friend().a);
      this.C = 21;
      this.w[1][0] = new LangLa_ii((byte)1, 8, this.a_() + 8, super.width - 8 - 10, this.C * 7, this.C, this.e.size());
      this.D[0] = new LangLa_ce[this.e.size()];
      this.E[0] = new LangLa_ii[this.e.size()];

      for(int var3 = 0; var3 < this.e.size(); ++var3) {
         this.D[0][var3] = new LangLa_ce(2, 2 + var3 * this.w[1][0].h, "", this, 0);
         this.E[0][var3] = new LangLa_in((byte)1, 0, 0, this.D[0][var3].width, this.D[0][var3].height, this.D[0][var3].height, 1, this.w[1][0]);
      }

   }

   public void f() {
      this.f.clear();
      if (this.v.a) {
         for(int var2 = 0; var2 < GameSrc.gI().vEnemy.size(); ++var2) {
            Enemy var1;
            if ((var1 = (Enemy)GameSrc.gI().vEnemy.elementAt(var2)).c) {
               this.f.add(var1);
            }
         }
      } else {
         this.f.addAll(GameSrc.gI().vEnemy);
      }

      Binary.writeBoolean("enermy" + Char.gI().idEntity, this.v.a);
      Collections.sort(this.f, beatdz.Enemy.$state_Enemy().a);
      this.C = 21;
      this.w[2][0] = new LangLa_ii((byte)1, 8, this.a_() + 8, super.width - 8 - 10, this.C * 7, this.C, this.f.size());
      this.D[1] = new LangLa_ce[this.f.size()];
      this.E[1] = new LangLa_ii[this.f.size()];

      for(int var3 = 0; var3 < this.f.size(); ++var3) {
         this.D[1][var3] = new LangLa_ce(2, 2 + var3 * this.w[2][0].h, "", this, 0);
         this.E[1][var3] = new LangLa_in((byte)1, 0, 0, this.D[1][var3].width, this.D[1][var3].height, this.D[1][var3].height, 1, this.w[2][0]);
      }

   }

   private void n() {
      this.w[0][0] = new LangLa_ii((byte)1, 8, this.a_() + 26, this.width - 18, 132, 22, GameSrc.gI().aI.a.size());
      LangLa_ce var10000 = this.c;
      boolean var2 = GameSrc.gI().aI.b;
      var10000.a = var2;
   }

   private void o() {
      this.w[0][1] = new LangLa_ii((byte)1, 8, this.a_() + 26, this.width - 18, 132, 22, this.g.size());
   }

   private void q() {
      this.h.clear();
      this.h.add(Char.gI());
      this.h.addAll(GameSrc.gI().vChar);
      this.w[0][2] = new LangLa_ii((byte)1, 8, this.a_() + 26, super.width - 8 - 10, 132, 22, this.h.size());
   }

   public void g() {
      this.n();
      this.o();
      this.q();
      String var2;
      if (GameSrc.gI().aI != null && !GameSrc.gI().aI.b()) {
         if (GameSrc.gI().aI.a.size() == 1) {
            var2 = Caption.jg;
            this.b.a = var2;
         } else {
            var2 = Caption.jb;
            this.b.a = var2;
         }

         this.b.b(false);
         var2 = Caption.jh;
         this.a.a = var2;
      } else {
         this.b.b(true);
         var2 = Caption.jf;
         this.a.a = var2;
      }

      if (this.A && this.g.size() == 0) {
         this.p.showMessage(Caption.bS, -1);
         this.A = false;
      }

   }

   public void d() {
      super.d();
   }

   public void a(int var1, Object var2, LangLa_cy var3) {
      super.a(var1, var2, var3);
      LangLa_ca var14;
      Message var15;
      LangLa_kd var16;
      if (this.k() == 0) {
         Char var17;
         LangLa_ey var23;
         switch(var1) {
         case 51:
            var16 = (LangLa_kd)var2;
            var14 = this;

            try {
               var23 = var14.e(var16.a);
               GameSrc.gI();
               GameSrc.e(var23.a);
               break;
            } catch (Exception var11) {
               Utlis.println(var11);
               return;
            }
         case 52:
            this.f((LangLa_kd)var2);
            return;
         case 53:
            this.g((LangLa_kd)var2);
            return;
         case 54:
            this.e((LangLa_kd)var2);
            return;
         case 55:
            var16 = (LangLa_kd)var2;
            var14 = this;

            try {
               var23 = var14.e(var16.a);
               GameSrc.gI();
               GameSrc.i(var23.a);
               break;
            } catch (Exception var10) {
               Utlis.println(var10);
               return;
            }
         case 56:
            var16 = (LangLa_kd)var2;
            var14 = this;

            try {
               var23 = var14.e(var16.a);
               (var15 = new Message((byte)46)).writeUTF(var23.a);
               var15.send();
               break;
            } catch (Exception var9) {
               Utlis.println(var9);
               return;
            }
         case 57:
            var16 = (LangLa_kd)var2;
            var14 = this;

            try {
               var23 = var14.e(var16.a);
               (var15 = new Message((byte)47)).writeUTF(var23.a);
               var15.send();
               break;
            } catch (Exception var8) {
               Utlis.println(var8);
               return;
            }
         case 104:
            try {
               (new Message((byte)42)).send();
               break;
            } catch (Exception var7) {
               Utlis.println(var7);
               return;
            }
         case 105:
            boolean var19 = this.d.a;
            this.d.a = var19;
            GameSrc.gI().bC = this.d.a;
            return;
         case 106:
            this.n();
            this.o();
            this.q();
            return;
         case 2002:
            var17 = (Char)this.h.get(((LangLa_kd)var2).a);

            try {
               GameSrc.gI();
               GameSrc.d(var17.name);
               break;
            } catch (Exception var6) {
               Utlis.println(var6);
               return;
            }
         case 2003:
            Char var18 = (Char)this.h.get(((LangLa_kd)var2).a);
            var14 = this;

            try {
               var14.z = true;
               var14.m();
               var14.a(var14.j());
               GameSrc.gI().a((String)var18.name, (LangLa_ko)var14);
               break;
            } catch (Exception var5) {
               Utlis.println(var5);
               return;
            }
         case 2004:
            var17 = (Char)this.h.get(((LangLa_kd)var2).a);

            try {
               GameSrc.gI();
               GameSrc.h(var17.name);
               break;
            } catch (Exception var4) {
               Utlis.println(var4);
               return;
            }
         case 2005:
            this.d((LangLa_kd)var2);
            return;
         case 2006:
            this.c((LangLa_kd)var2);
            return;
         case 2007:
            this.b((LangLa_kd)var2);
            return;
         case 2008:
            this.a((LangLa_kd)var2);
            return;
         case 2009:
            this.a((LangLa_kd)var2);
         }

         return;
      } else {
         switch(var1) {
         case 100:
            this.e();
            this.f();
            return;
         case 106:
            return;
         case 2000:
            var16 = (LangLa_kd)var2;
            var14 = this;

            try {
               if (var14.k() != 1) {
                  if (var14.k() == 2) {
                     Char var22 = (Char)var14.h.elementAt(var16.a);
                     (var15 = new Message((byte)79)).writeUTF(var22.name);
                     var15.send();
                  }
                  break;
               }

               Friend var21 = (Friend)var14.e.elementAt(var16.a);
               (var15 = new Message((byte)79)).writeUTF(var21.c);
               var15.send();
            } catch (Exception var13) {
               Utlis.println(var13);
            }

            return;
         case 2001:
            var16 = (LangLa_kd)var2;
            var14 = this;

            try {
               Message var20;
               if (var14.k() != 1) {
                  if (var14.k() == 2) {
                     (var20 = new Message((byte)-18)).writeUTF(var14.d(var16.a));
                     var20.send();
                  }
                  break;
               }

               (var20 = new Message((byte)76)).writeUTF(var14.d(var16.a));
               var20.send();
            } catch (Exception var12) {
               Utlis.println(var12);
            }

            return;
         case 2002:
            this.f((LangLa_kd)var2);
            return;
         case 2003:
            this.g((LangLa_kd)var2);
            return;
         case 2004:
            this.e((LangLa_kd)var2);
            return;
         case 2005:
            this.d((LangLa_kd)var2);
            return;
         case 2006:
            this.c((LangLa_kd)var2);
            return;
         case 2007:
            this.b((LangLa_kd)var2);
            return;
         case 2008:
            this.a((LangLa_kd)var2);
         }
      }

   }

   private void a(LangLa_kd var1) {
      if (this.k() == 0) {
         Char var2 = (Char)this.h.elementAt(var1.a);
         GameSrc.gI();
         GameSrc.g(var2.name);
      } else {
         GameSrc.gI();
         GameSrc.g(this.d(var1.a));
      }
   }

   private void b(LangLa_kd var1) {
      if (this.k() == 0) {
         Char var2 = (Char)this.h.elementAt(var1.a);
         GameSrc.gI();
         GameSrc.f(var2.name);
      } else {
         GameSrc.gI();
         GameSrc.f(this.d(var1.a));
      }
   }

   private void c(LangLa_kd var1) {
      try {
         if (this.k() != 0) {
            GameSrc.gI();
            GameSrc.e(this.d(var1.a));
            return;
         }

         Char var3 = (Char)this.h.elementAt(var1.a);
         GameSrc.gI();
         GameSrc.e(var3.name);
      } catch (Exception var2) {
         Utlis.println(var2);
      }

   }

   private void d(LangLa_kd var1) {
      try {
         if (this.k() != 0) {
            GameSrc.gI();
            GameSrc.c(this.d(var1.a));
            return;
         }

         Char var3 = (Char)this.h.elementAt(var1.a);
         GameSrc.gI();
         GameSrc.c(var3.name);
      } catch (Exception var2) {
         Utlis.println(var2);
      }

   }

   public void a(int var1, Object var2) {
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      super.a(var1, var2, var3);
      if (this.k() == 0) {
         switch(var1.b) {
         case 101:
            if (GameSrc.gI().aI != null && !GameSrc.gI().aI.b()) {
               this.z = true;
               this.m();
               this.a(this.j());
               this.o.b.b = 5;
               super.j.a(3);
               this.l();
               return;
            }

            try {
               (new Message((byte)41)).send();
               break;
            } catch (Exception var11) {
               Utlis.println(var11);
               return;
            }
         case 102:
            try {
               (new Message((byte)44)).send();
               break;
            } catch (Exception var10) {
               Utlis.println(var10);
               return;
            }
         case 103:
            this.A = true;
            v();
            return;
         case 1001:
            if (var1.j.k >= 0) {
               beatdz.LangLa_ca.$state_LangLa_ca().B = var1.j.k;
               this.x.a(var1.j.k);
               this.u();
               return;
            }
            break;
         case 1003:
            if (var1.j.k >= 0) {
               int var4 = var3;
               var3 = var2;
               var2 = var1.j.k;
               Vector var5 = new Vector();
               if (this.x.b.b == 2) {
                  Char var14;
                  if (!(var14 = (Char)this.h.elementAt(var2)).equals(Char.gI())) {
                     if (GameSrc.gI().aI != null && !GameSrc.gI().aI.b()) {
                        if (GameSrc.gI().aI.a() && !GameSrc.gI().aI.a(var14.name)) {
                           var5.addElement(new LangLa_lk(2005, Caption.dF));
                        }
                     } else {
                        var5.addElement(new LangLa_lk(2005, Caption.bI));
                     }

                     var5.addElement(new LangLa_lk(2006, Caption.F));
                     var5.addElement(new LangLa_lk(2002, Caption.B));
                     var5.addElement(new LangLa_lk(2003, Caption.cl));
                     var5.addElement(new LangLa_lk(2004, Caption.db));
                     var5.addElement(new LangLa_lk(2008, Caption.oC));
                  }
               } else {
                  LangLa_ey var6;
                  if (!(var6 = this.e(var2)).a.equals(Char.gI().name)) {
                     if (this.x.b.b == 0 && GameSrc.gI().aI != null && GameSrc.gI().aI.a()) {
                        var5.addElement(new LangLa_lk(56, Caption.jl));
                        var5.addElement(new LangLa_lk(57, Caption.jm));
                     }

                     if (!GameSrc.gI().k(var6.a)) {
                        var5.addElement(new LangLa_lk(51, Caption.dD));
                     }

                     var5.addElement(new LangLa_lk(52, Caption.B));
                     var5.addElement(new LangLa_lk(53, Caption.cl));
                     var5.addElement(new LangLa_lk(54, Caption.db));
                     var5.addElement(new LangLa_lk(2009, Caption.oC));
                     LangLa_lj var7;
                     if (this.x.b.b == 1 && (GameSrc.gI().aI == null || GameSrc.gI().aI.b()) && !(var7 = (LangLa_lj)this.g.elementAt(var2)).c() && !var7.b) {
                        var5.addElement(new LangLa_lk(55, Caption.jn));
                     }
                  }
               }

               if (var5.size() > 0) {
                  String[] var15 = new String[var5.size()];
                  short[] var16 = new short[var5.size()];

                  for(int var8 = 0; var8 < var5.size(); ++var8) {
                     LangLa_lk var9 = (LangLa_lk)var5.elementAt(var8);
                     var15[var8] = var9.b;
                     var16[var8] = (short)var9.a;
                  }

                  this.cL = a(this, var3 + 25, var4, new LangLa_kd(var2, var16, var15));
               }
            }
         }

         return;
      } else {
         if (var1.b >= 8000 && var1.b < 9000) {
            int var12 = var1.b - 8000;
            LangLa_ce var10000 = this.D[this.k() - 1][var12];
            boolean var13 = !this.D[this.k() - 1][var12].a;
            var10000.a = var13;
            return;
         }

         switch(var1.b) {
         case 1001:
            if (var1.j.k >= 0) {
               this.x.a(var1.j.k);
               this.u();
               return;
            }
            break;
         case 1002:
            this.p.a((LangLa_cx)(new LangLa_ms(this.p, this)));
            return;
         case 1003:
            if (var1.j.k >= 0) {
               this.a(var1.j.k, var2, var3);
               return;
            }
            break;
         case 1004:
            this.t();
            return;
         case 1005:
            this.r();
         }
      }

   }

   private void r() {
      int var1 = 0;

      for(int var3 = 0; var3 < this.e.size(); ++var3) {
         if (((Friend)this.e.get(var3)).b == 2) {
            this.b(var3);
            ++var1;
         }
      }

      DataCenter.gI().currentScreen.showMessage(Utlis.replaceAll(Caption.pp, String.valueOf(var1)), -1);
   }

   private void t() {
      int var1 = 0;

      for(int var2 = 0; var2 < this.D[this.k() - 1].length; ++var2) {
         if (this.D[this.k() - 1][var2].a) {
            this.b(var2);
            ++var1;
         }
      }

      if (var1 == 0) {
         DataCenter.gI().currentScreen.showMessage(Caption.or, -65536);
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
         if (this.k() == 1) {
            return ((Friend)this.F.elementAt(var1)).c;
         }

         if (this.k() == 2) {
            return ((Enemy)this.F.elementAt(var1)).b;
         }
      } catch (Exception var2) {
         Utlis.println(var2);
      }

      return "";
   }

   public void a(int var1) {
      super.a(var1);
      if (this.x != null) {
         if (this.k() == 0) {
            this.x.a(beatdz.LangLa_ca.$state_LangLa_ca().B);
            this.u();
         }

         if (this.k() == 1) {
            this.F = this.e;
         }

         if (this.k() == 2) {
            this.F = this.f;
            return;
         }

         if (this.k() == this.j()) {
            super.j.a(3);
            this.l();
         }
      }

   }

   private void u() {
      if (this.x != null) {
         switch(this.x.b.b) {
         case 1:
            v();
         }
      }

   }

   public Vector c() {
      Vector var1 = super.c();
      if (!this.z) {
         var1.removeElementAt(0);
      }

      if (this.k() == 0) {
         var1.addElement(this.x.c());
         var1.addElement(this.w[this.k()][this.x.b.b].a(1003, this));
      } else if (this.k() < 3) {
         for(int var4 = 0; var4 < this.E[this.k() - 1].length; ++var4) {
            int var2 = this.w[this.k()][0].cx + this.D[this.k() - 1][var4].cx;
            int var3 = this.w[this.k()][0].cy + this.D[this.k() - 1][var4].cy - this.w[this.k()][0].f;
            if (Utlis.inRange(this.w[this.k()][0].cx, this.w[this.k()][0].cy, this.w[this.k()][0].cx + this.w[this.k()][0].width, this.w[this.k()][0].cy + this.w[this.k()][0].height, var2, var3) && Utlis.inRange(this.w[this.k()][0].cx, this.w[this.k()][0].cy, this.w[this.k()][0].cx + this.w[this.k()][0].width, this.w[this.k()][0].cy + this.w[this.k()][0].height, var2 + this.D[this.k() - 1][var4].width, var3 + this.D[this.k() - 1][var4].height)) {
               this.E[this.k() - 1][var4].cx = (short)var2;
               this.E[this.k() - 1][var4].cy = (short)var3;
               var1.addElement(this.E[this.k() - 1][var4].a(8000 + var4, this));
            }
         }

         var1.addElement(this.w[this.k()][0].a(1003, this));
      }

      return var1;
   }

   public void a(Graphics var1) {
      int var2 = var1.a;
      int var3 = var1.b;
      if (this.z) {
         super.a(var1);
      } else {
         this.a(var1, this.cx, this.cy, this.width, this.height, "", (byte)2, this.r);
         this.a(var1, this.cx, this.cy);
         mFont.a((mFont)mFont.f, (Graphics)var1, Caption.bI, this.width / 2, 15, 2, -2560, 0);
         this.a(var1, var2, var3);
      }

      Graphics var4;
      int var5;
      int var8;
      LangLa_ca var12;
      if (this.k() == 0) {
         this.x.a(var1);
         this.a(var1, this.cx + 4, this.cy + this.a_() + 22);
         this.a(var1, -1, 0, super.width - 8 + 1, this.G() - 48, 4, 55, 56);
         this.a(var1, this.w[this.k()][this.x.b.b]);
         label113:
         switch(this.x.b.b) {
         case 0:
            var4 = var1;
            var12 = this;
            int var6 = 0;

            while(true) {
               if (var6 >= var12.w[var12.k()][var12.x.b.b].i) {
                  break label113;
               }

               if (var12.w[var12.k()][var12.x.b.b].b(var6)) {
                  try {
                     if (var6 == var12.w[var12.k()][var12.x.b.b].k) {
                        var4.f(-3640790);
                        var4.c(1, 1 + var6 * var12.w[var12.k()][var12.x.b.b].h, var12.w[var12.k()][var12.x.b.b].width - 2, var12.w[var12.k()][var12.x.b.b].h - 3);
                     }

                     LangLa_ey var7 = (LangLa_ey)GameSrc.gI().aI.a.elementAt(var6);
                     var12.a(var4, 0, var6 * var12.w[var12.k()][var12.x.b.b].h, var12.w[var12.k()][var12.x.b.b].width, var12.w[var12.k()][var12.x.b.b].h - 2, -13, 84, 5, 1, 1);
                     Binary2.a(var4, var7.a(), 0, 6, var6 * var12.w[var12.k()][var12.x.b.b].h + 3, 40);
                     var5 = var6 == var12.w[var12.k()][var12.x.b.b].k ? -2560 : -1;
                     var8 = 25;
                     var2 = var6 * var12.w[var12.k()][var12.x.b.b].h + 9;
                     if (var6 == var12.w[var12.k()][var12.x.b.b].l && !var7.a.equals(Char.gI().name)) {
                        ++var8;
                        ++var2;
                     }

                     mFont.a(mFont.d, var4, Caption.rG[3] + " " + var7.a + ", " + Caption.rG[5] + " " + var7.d + ", " + Caption.rG[4] + " " + DataCenter.gI().DataNameChar[var7.b].name, var8, var2, 0, var5);
                     if (var6 == 0) {
                        mFont.a(mFont.d, var4, "(" + Caption.ji + ")", var12.width - 8 - 18, var6 * var12.w[var12.k()][var12.x.b.b].h + 10, 1, -7812062);
                     }
                  } catch (Exception var11) {
                  }
               }

               ++var6;
            }
         case 1:
            this.e(var1);
            break;
         case 2:
            this.f(var1);
         }

         this.b(var1);
         this.a(var1, this.cx + 4, this.cy + this.a_());
         if (this.x.b.b == 2) {
            mFont.a(mFont.d, var1, Caption.ga + this.h.size(), 10, this.G() - 10, 0, -1);
            return;
         }
      } else if (this.k() <= 2) {
         this.a(var1, this.cx + 4, this.cy + this.a_());
         this.a(var1, -1, 0, super.width - 8 + 1, this.G() - 26, 4, 55, 56);
         this.a(var1, this.w[this.k()][0]);

         for(var2 = 0; var2 < this.w[this.k()][0].i; ++var2) {
            if (this.w[this.k()][0].b(var2)) {
               if (var2 == this.w[this.k()][0].k) {
                  var1.f(13136426);
                  var1.c(0, var2 * this.w[this.k()][0].h, this.w[this.k()][0].width, this.w[this.k()][0].h - 1);
                  var1.c(0, var2 * this.w[this.k()][0].h, this.w[this.k()][0].width, this.w[this.k()][0].h - 1);
               }

               int var15;
               switch(this.k()) {
               case 1:
                  Friend var14 = (Friend)this.F.elementAt(var2);
                  var5 = var2;
                  var4 = var1;
                  var12 = this;

                  try {
                     if (var14.d) {
                        LangLa_fq.a(var4, 302, 0, 22, 6 + var5 * var12.w[var12.k()][0].h, 20);
                     } else if (var14.b == 1) {
                        LangLa_fq.a(var4, 304, 0, 22, 6 + var5 * var12.w[var12.k()][0].h, 20);
                     } else {
                        LangLa_fq.a(var4, 303, 0, 22, 6 + var5 * var12.w[var12.k()][0].h, 20);
                     }

                     if (var5 == var12.w[var12.k()][0].l) {
                        mFont.b(mFont.d, var4, var14.c + (var14.b == 2 ? Caption.gb : ""), 35, 10 + var5 * var12.w[var12.k()][0].h, 0, -3089954, -16777216);
                     } else {
                        mFont.b(mFont.d, var4, var14.c + (var14.b == 2 ? Caption.gb : ""), 34, 11 + var5 * var12.w[var12.k()][0].h, 0, -3089954, -16777216);
                     }

                     var15 = var4.a;
                     var8 = var4.b;
                     var12.a(var4, var15 + var12.D[0][var5].cx, var8 + var12.D[0][var5].cy);
                     var12.D[0][var5].a(var4);
                     var12.a(var4, var15, var8);
                  } catch (Exception var10) {
                     Utlis.println(var10);
                  }
                  break;
               case 2:
                  Enemy var13 = (Enemy)this.F.elementAt(var2);
                  if (var13.c) {
                     LangLa_fq.a(var1, 302, 0, 22, 6 + var2 * this.w[this.k()][0].h, 20);
                  } else {
                     LangLa_fq.a(var1, 304, 0, 22, 6 + var2 * this.w[this.k()][0].h, 20);
                  }

                  if (var2 == this.w[this.k()][0].l) {
                     mFont.b(mFont.d, var1, var13.b, 35, 10 + var2 * this.w[this.k()][0].h, 0, -1, -16777216);
                  } else {
                     mFont.b(mFont.d, var1, var13.b, 34, 11 + var2 * this.w[this.k()][0].h, 0, -1, -16777216);
                  }

                  var15 = var1.a;
                  var8 = var1.b;
                  this.a(var1, var15 + this.D[1][var2].cx, var8 + this.D[1][var2].cy);
                  this.D[1][var2].a(var1);
                  this.a(var1, var15, var8);
               }
            }
         }

         this.b(var1);
         this.a(var1, this.cx + 4, this.cy + this.a_());
         switch(this.k()) {
         case 1:
            mFont.a(mFont.d, var1, Caption.ob + this.F.size(), 112, this.G() - 13, 0, -1);
            this.w[this.k()][0].b(var1, -17, -40);
            return;
         case 2:
            mFont.a(mFont.d, var1, Caption.ob + this.F.size(), 112, this.G() - 13, 0, -1);
            this.w[this.k()][0].b(var1, -17, -40);
         }
      }

   }

   private void e(Graphics var1) {
      for(int var3 = 0; var3 < this.w[this.k()][this.x.b.b].i; ++var3) {
         if (this.w[this.k()][this.x.b.b].b(var3)) {
            try {
               if (var3 == this.w[this.k()][this.x.b.b].k) {
                  var1.f(-3640790);
                  var1.c(1, 1 + var3 * this.w[this.k()][this.x.b.b].h, this.w[this.k()][this.x.b.b].width - 2, this.w[this.k()][this.x.b.b].h - 3);
               }

               LangLa_lj var4;
               LangLa_ey var5 = (LangLa_ey)(var4 = (LangLa_lj)this.g.elementAt(var3)).a.firstElement();
               this.a(var1, 0, var3 * this.w[this.k()][this.x.b.b].h, this.w[this.k()][this.x.b.b].width, this.w[this.k()][this.x.b.b].h - 2, -13, 84, 5, 1, 1);
               Binary2.a(var1, var5.a(), 0, 6, var3 * this.w[this.k()][this.x.b.b].h + 3, 40);
               int var2 = var3 == this.w[this.k()][this.x.b.b].k ? -2560 : -1;
               int var6 = 25;
               int var7 = var3 * this.w[this.k()][this.x.b.b].h + 9;
               if (var3 == this.w[this.k()][this.x.b.b].l && !var5.a.equals(Char.gI().name)) {
                  ++var6;
                  ++var7;
               }

               mFont.a(mFont.d, var1, Caption.rG[3] + " " + var5.a + ", " + Caption.rG[5] + " " + var5.d + ", " + Caption.rG[4] + " " + DataCenter.gI().DataNameChar[var5.b].name, var6, var7, 0, var2);
               if (var4.c()) {
                  mFont.a(mFont.d, var1, Caption.jj, var6 = super.width - 8 - 18, var3 * this.w[this.k()][this.x.b.b].h + 10, 1, -65536);
                  var6 -= mFont.b(mFont.d, Caption.jj);
               } else {
                  mFont.a(mFont.d, var1, "(" + var4.c + Caption.jk, var6 = super.width - 8 - 18, var3 * this.w[this.k()][this.x.b.b].h + 10, 1, -1);
                  var6 -= mFont.b(mFont.d, Caption.jk);
               }

               if (var4.b) {
                  LangLa_fq.a(var1, 44, 0, var6 - 18, var7 - 4, 0);
               }
            } catch (Exception var9) {
            }
         }
      }

   }

   private void f(Graphics var1) {
      try {
         for(int var2 = 0; var2 < this.w[this.k()][this.x.b.b].i; ++var2) {
            if (this.w[this.k()][this.x.b.b].b(var2)) {
               if (var2 == this.w[this.k()][this.x.b.b].k) {
                  var1.f(-3640790);
                  var1.c(1, 1 + var2 * this.w[this.k()][this.x.b.b].h, this.w[this.k()][this.x.b.b].width - 2, this.w[this.k()][this.x.b.b].h - 3);
               }

               Char var3 = (Char)this.h.get(var2);
               this.a(var1, 0, var2 * this.w[this.k()][this.x.b.b].h, this.w[this.k()][this.x.b.b].width, this.w[this.k()][this.x.b.b].h - 2, -13, 84, 5, 1, 1);
               Binary2.a(var1, DataCenter.gI().DataIconChar[var3.idChar].idIcon, 0, 6, var2 * this.w[this.k()][this.x.b.b].h + 3, 40);
               int var4 = var2 == this.w[this.k()][this.x.b.b].k ? -2560 : -1;
               int var5 = 25;
               int var6 = var2 * this.w[this.k()][this.x.b.b].h + 9;
               if (var2 == this.w[this.k()][this.x.b.b].l && !var3.name.equals(Char.gI().name)) {
                  ++var5;
                  ++var6;
               }

               mFont.a(mFont.d, var1, Caption.rG[3] + " " + var3.name + ", " + Caption.rG[5] + " " + var3.level() + ", " + Caption.rG[4] + " " + DataCenter.gI().DataNameChar[var3.idClass].name, var5, var6, 0, var4);
            }
         }

      } catch (Exception var8) {
      }
   }

   public void b() {
      super.b();
      if (this.k() == 0) {
         this.x.b();
         boolean var2 = true;
         this.c.v = var2;
         var2 = true;
         this.d.v = var2;
         if (GameSrc.gI().aI != null && !GameSrc.gI().aI.b() && GameSrc.gI().aI.a()) {
            var2 = false;
            this.c.v = var2;
            var2 = false;
            this.d.v = var2;
         }
      }

      for(int var1 = 0; var1 < this.w.length; ++var1) {
         for(int var3 = 0; var3 < this.w[var1].length; ++var3) {
            this.w[var1][var3].a();
         }
      }

   }

   private LangLa_ey e(int var1) {
      LangLa_ey var2 = null;
      if (var1 >= 0) {
         if (this.x.b.b == 1) {
            var2 = (LangLa_ey)((LangLa_lj)this.g.elementAt(var1)).a.firstElement();
         } else {
            var2 = (LangLa_ey)GameSrc.gI().aI.a.elementAt(var1);
         }
      }

      return var2;
   }

   private void a(int var1, int var2, int var3) {
      Vector var4 = new Vector();
      if (this.k() == 1) {
         Friend var5;
         if ((var5 = (Friend)this.e.elementAt(var1)).b == 2) {
            var4.addElement(new LangLa_lk(2000, Caption.gc));
            var4.addElement(new LangLa_lk(2001, Caption.gd));
         }

         if (var5.b < 2) {
            var4.addElement(new LangLa_lk(2001, Caption.ge));
         }

         if (GameSrc.gI().aI != null && !GameSrc.gI().aI.b()) {
            if (GameSrc.gI().aI.a() && !GameSrc.gI().aI.a(var5.c)) {
               var4.addElement(new LangLa_lk(2005, Caption.dF));
            }
         } else {
            var4.addElement(new LangLa_lk(2005, Caption.dE));
         }

         var4.addElement(new LangLa_lk(2002, Caption.dG));
         var4.addElement(new LangLa_lk(2003, Caption.cl));
         var4.addElement(new LangLa_lk(2004, Caption.cj));
         var4.addElement(new LangLa_lk(2008, Caption.oC));
      } else if (this.k() == 2) {
         Enemy var9 = (Enemy)this.F.elementAt(var1);
         var4.addElement(new LangLa_lk(2001, Caption.gf));
         if (GameSrc.gI().aI != null && !GameSrc.gI().aI.b()) {
            if (GameSrc.gI().aI.a() && !GameSrc.gI().aI.a(var9.b)) {
               var4.addElement(new LangLa_lk(2005, Caption.dF));
            }
         } else {
            var4.addElement(new LangLa_lk(2005, Caption.bI));
         }

         var4.addElement(new LangLa_lk(2002, Caption.dG));
         var4.addElement(new LangLa_lk(2003, Caption.cl));
         var4.addElement(new LangLa_lk(2004, Caption.cj));
         var4.addElement(new LangLa_lk(2008, Caption.oC));
      }

      if (var4.size() > 0) {
         String[] var10 = new String[var4.size()];
         short[] var6 = new short[var4.size()];

         for(int var7 = 0; var7 < var4.size(); ++var7) {
            LangLa_lk var8 = (LangLa_lk)var4.elementAt(var7);
            var10[var7] = var8.b;
            var6[var7] = (short)var8.a;
         }

         this.cL = a(this, var2 + 25, var3, new LangLa_kd(var1, var6, var10));
      }

   }

   private static void v() {
      try {
         (new Message((byte)45)).send();
      } catch (Exception var1) {
         Utlis.println(var1);
      }
   }

   private void e(LangLa_kd var1) {
      try {
         if (this.k() != 0) {
            GameSrc.gI();
            GameSrc.h(this.d(var1.a));
            return;
         }

         LangLa_ey var3 = this.e(var1.a);
         GameSrc.gI();
         GameSrc.h(var3.a);
      } catch (Exception var2) {
         Utlis.println(var2);
      }

   }

   private void f(LangLa_kd var1) {
      try {
         if (this.k() != 0) {
            GameSrc.gI();
            GameSrc.d(this.d(var1.a));
            return;
         }

         LangLa_ey var3 = this.e(var1.a);
         GameSrc.gI();
         GameSrc.d(var3.a);
      } catch (Exception var2) {
         Utlis.println(var2);
      }

   }

   private void g(LangLa_kd var1) {
      try {
         this.z = true;
         this.m();
         if (this.k() == 0) {
            LangLa_ey var3 = this.e(var1.a);
            GameSrc.gI().a((String)var3.a, (LangLa_ko)this);
         } else {
            GameSrc.gI().a((String)this.d(var1.a), (LangLa_ko)this);
         }

         this.a(this.j());
      } catch (Exception var2) {
         Utlis.println(var2);
      }
   }

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public int B;
public void initialize() {
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.LangLa_ca");
public static SessionState $state_LangLa_ca() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
