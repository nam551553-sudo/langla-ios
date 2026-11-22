package beatdz;
import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_ko extends LangLa_fn {
   public mTextBox i;
   public LangLa_lf j;
   public LangLa_ki o;
   public LangLa_ce s;
   public LangLa_kw[] t;
   
   private LangLa_dz b;

   public LangLa_ko(MainScreen var1, int var2, String[] var3) {
      super(var1);
      GameSrc.gI().aM = this;
      this.r = false;
      this.a(300, 220);
      LangLa_kd var5;
      (var5 = new LangLa_kd(5000)).c = new String[1];
      if (var3 != null) {
         var5.c = new String[var3.length + 1];

         for(int var4 = 0; var4 < var3.length; ++var4) {
            var5.c[var4] = var3[var4];
         }
      }

      var5.c[var5.c.length - 1] = Caption.l;
      if (var5.c.length <= 3) {
         this.a(var5, 170, 88, var5.c.length);
      } else {
         this.a(var5, 170, 66, var5.c.length);
         this.l = 4;
      }

      this.j = new LangLa_lf(new LangLa_kd(5005, Caption.ra), 4, this.height - 49, super.width - 8, 23, 50, this, false);
      this.i = this.a(25, this.height - 25, this.width - 111, "", this, 5002, 0);
      byte var6 = 80;
      this.i.a = var6;
      this.i.height = 20;
      this.i.d(false);
      this.i.p = true;
      this.a(this.i, this.j());
      this.o = a(5, this.height - 24, 10, this, 6001);
      this.o.b.b = var2;
      this.a(this.o);
      this.a(this.o, this.j());
      LangLa_dz var9 = this.a(this.width - 23, this.height - 23, "", this, 5002, 33);
      this.a(var9, this.j());
      var9 = this.a(this.width - 43, this.height - 23, "", this, 5003, 38);
      this.a(var9, this.j());
      var9 = this.a(this.width - 23, this.height - 45, "", this, 5004, 39);
      this.a(var9, this.j());
      var9 = this.a(this.width - 83, this.height - 23, "", this, 5006, -25);
      this.a(var9, this.j());
      if (Utlis.currentTimeSeconds() > GameSrc.gI().timeChatColor) {
         GameSrc.gI().ci = -1;
         GameSrc.gI().cj = "";
      }

      this.b = this.a(this.width - 63, this.height - 23, "", this, 5555, 942);
      this.a(this.b, this.j());
      this.s = this.a(this.width - 43, this.height - 45, "", this, 6002);
      LangLa_ce var10000 = this.s;
      boolean var7 = GameSrc.gI().aZ;
      var10000.a = var7;
      this.a(this.s, this.j());
      this.t = new LangLa_kw[5];
      this.t[0] = new LangLa_kw(4, this.a_() + 6, super.width - 8, 128, this, (byte)0, 5006, 16);
      this.t[1] = new LangLa_kw(4, this.a_() + 6, super.width - 8, 128, this, (byte)1, 5006, 16);
      this.t[2] = new LangLa_kw(4, this.a_() + 6, super.width - 8, 128, this, (byte)2, 5006, 16);
      this.t[3] = new LangLa_kw(4, this.a_() + 6, super.width - 8, 128, this, (byte)3, 5006, 16);
      this.t[4] = new LangLa_kw(4, this.a_() + 6, super.width - 8, 128, this, (byte)4, 5006, 16);

      for(int var8 = 0; var8 < this.t.length; ++var8) {
         this.a(this.t[var8]);
      }

      this.a(0);
   }

   public void a(int var1, Object var2) {
   }

   public void a(Graphics var1) {
      if (this.j() <= 0) {
         this.a(var1, this.cx, this.cy, this.width, this.height, Caption.l, (byte)2, this.r);
      } else {
         super.a(var1);
      }

      if (this.k() == this.j()) {
         this.j.a(var1);
      }

   }

   public Vector c() {
      Vector var1 = super.c();
      if (this.j() <= 0) {
         var1.removeElementAt(0);
      }

      if (this.k() == this.j()) {
         var1.addElement(this.j.c());
      }

      return var1;
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      super.a(var1, var2, var3);
      if (this.k() == this.j()) {
         switch(var1.b) {
         case 5000:
            return;
         case 5001:
            return;
         case 5002:
            GameSrc.gI().a(this.i);
            return;
         case 5003:
            this.cL = new LangLa_ac(var1.a.cx - 86, var1.a.cy - 88, 6003, this);
            this.a(this.cL);
            return;
         case 5004:
            this.p.a((LangLa_cx)(new LangLa_km(5001, this.p)));
            return;
         case 5005:
            if (var1.j.k >= 0) {
               this.j.a(var1.j.k);
               this.e();
               if (this.j.b.b == 1) {
                  LangLa_kw var4 = this.t[this.j.b.b];
                  var3 = 0;

                  while(true) {
                     if (var3 >= var4.c.size()) {
                        if (var4.c.size() > 0) {
                           beatdz.LangLa_kw.$state_LangLa_kw().d = ((LangLa_lk)var4.c.firstElement()).b;
                           var4.a(beatdz.LangLa_kw.$state_LangLa_kw().d);
                        }
                        break;
                     }

                     if (((LangLa_lk)var4.c.elementAt(var3)).b.equals(beatdz.LangLa_kw.$state_LangLa_kw().d)) {
                        break;
                     }

                     ++var3;
                  }

                  return;
               }
            }
            break;
         case 5006:
            if (Utlis.currentTimeSeconds() > GameSrc.gI().timeChatColor) {
               GameSrc.gI().ci = -1;
               GameSrc.gI().cj = "";
               this.p.showMessage(Caption.pV, -1);
               return;
            }

            this.cL = new LangLa_cf(var1.a.cx - 40, var1.a.cy - 88, 6010, this);
            this.a(this.cL);
            return;
         case 5555:
            LangLa_dt.b().c();
         }
      }

   }

   public void a(int var1, Object var2, LangLa_cy var3) {
      if (this.k() == this.j()) {
         if (var1 != 6002 && var1 != 6009) {
            this.c(this.i);
         }

         switch(var1) {
         case 6001:
            if (this.j.b.b != 0 || this.o.b.b != 1 && this.o.b.b != 8 && this.o.b.b != 7 && this.o.b.b != 0 && this.o.b.b != 2) {
               break;
            }

            GameSrc.gI().bV = (byte)this.o.b.b;
            return;
         case 6002:
            mConfig.gI().writeBoolean(6, this.s.a);
            if (this.s.a) {
               this.t[this.j.b.b].e();
               this.p.showMessage(Caption.o, -1);
            } else {
               this.p.showMessage(Caption.p, -1);
            }

            GameSrc.gI().aZ = this.s.a;
            return;
         case 6003:
            this.i.c(var2.toString());
            return;
         case 6004:
            try {
               GameSrc.gI();
               GameSrc.e(beatdz.LangLa_kw.$state_LangLa_kw().e.b);
               break;
            } catch (Exception var6) {
               Utlis.println(var6);
               return;
            }
         case 6005:
            try {
               GameSrc.gI();
               GameSrc.d(beatdz.LangLa_kw.$state_LangLa_kw().e.b);
               break;
            } catch (Exception var5) {
               Utlis.println(var5);
               return;
            }
         case 6006:
            LangLa_ko var8 = this;

            try {
               GameSrc.gI().a(beatdz.LangLa_kw.$state_LangLa_kw().e.b, var8);
               break;
            } catch (Exception var4) {
               Utlis.println(var4);
               return;
            }
         case 6007:
            GameSrc.gI();
            GameSrc.h(beatdz.LangLa_kw.$state_LangLa_kw().e.b);
            return;
         case 6008:
            try {
               GameSrc.gI();
               GameSrc.c(beatdz.LangLa_kw.$state_LangLa_kw().e.b);
               return;
            } catch (Exception var7) {
               Utlis.println(var7);
            }
         }
      }

   }

   public void b() {
      super.b();

      for(int var1 = 0; var1 < this.t.length; ++var1) {
         this.t[var1].v = true;
         this.t[var1].b();
      }

      if (this.k() == this.j()) {
         this.j.b();
         this.t[this.j.b.b].v = false;
      }

   }

   public void d() {
      GameSrc.gI().aM = null;
   }

   private void e() {
      this.t[this.j.b.b].a();
      this.j.b.d = new short[this.j.b.c.length];
      this.f();
      if (this.s.a) {
         this.t[this.j.b.b].e();
      }

      if (this.j.b.b == 0) {
         this.o.a(GameSrc.gI().bV);
      } else {
         this.b(this.j.b.b);
      }

      beatdz.LangLa_ko.$state_LangLa_ko().a = this.j.b.b;
   }

   private void f() {
      for(int var1 = 0; var1 < this.j.b.c.length; ++var1) {
         this.j.b.d[var1] = this.t[var1].d();
      }

   }

   private void b(int var1) {
      if (var1 == 1) {
         this.o.a((byte)6);
      } else if (var1 == 2) {
         this.o.a((byte)4);
      } else if (var1 == 3) {
         this.o.a((byte)5);
      } else {
         if (var1 == 4) {
            this.o.a((byte)3);
         }

      }
   }

   public void l() {
      this.j.a(this.j.b.b);
      this.e();
   }

   public void a(int var1) {
      super.a(var1);
      if (this.k() == this.j()) {
         this.j.a(beatdz.LangLa_ko.$state_LangLa_ko().a);
         this.e();
      }

   }

   public void m() {
      this.q = null;
      LangLa_lf var1;
      (var1 = this.j).c = new LangLa_gw(0, 0, 0, 0, (byte)7, var1.b.c.length);
   }

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public int a;
public void initialize() {
this.a = 0;
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.LangLa_ko");
public static SessionState $state_LangLa_ko() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
