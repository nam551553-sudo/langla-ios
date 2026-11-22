package beatdz;
import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_ab extends LangLa_fo {
   public LangLa_ln[] a = new LangLa_ln[0];
   public LangLa_ln[] b = new LangLa_ln[0];
   private LangLa_lf c;
   private LangLa_ii d;
   private LangLa_cg e;
   

   public LangLa_ab(MainScreen var1) {
      this.p = var1;
      this.a(316, 213);
      this.r = false;
      this.c = new LangLa_lf(new LangLa_kd(1001, Caption.sd), 4, this.a_(), super.width - 8, 23, 76, this);
      this.e = this.a(225, this.c.d() + 4, 80, 3, new LangLa_kd(1002, Caption.se), this, 0);
      this.a();
      this.a(beatdz.LangLa_ab.$state_LangLa_ab().f);
   }

   public void a() {
      if (this.e.b.b == 0) {
         this.b = this.a;
      } else {
         Vector var1;
         int var2;
         if (this.e.b.b == 1) {
            var1 = new Vector();

            for(var2 = 0; var2 < this.a.length; ++var2) {
               if (this.a[var2].e == 6) {
                  var1.add(this.a[var2]);
               }
            }

            this.b = new LangLa_ln[var1.size()];

            for(var2 = 0; var2 < this.b.length; ++var2) {
               this.b[var2] = (LangLa_ln)var1.get(var2);
            }
         } else if (this.e.b.b == 2) {
            var1 = new Vector();

            for(var2 = 0; var2 < this.a.length; ++var2) {
               if (this.a[var2].e == 7) {
                  var1.add(this.a[var2]);
               }
            }

            this.b = new LangLa_ln[var1.size()];

            for(var2 = 0; var2 < this.b.length; ++var2) {
               this.b[var2] = (LangLa_ln)var1.get(var2);
            }
         }
      }

      this.d = new LangLa_ii((byte)1, 4, this.c.d() + 28, super.width - 8, 126, 18, this.b.length);
   }

   private void a(int var1) {
      this.c.a(var1);
      switch(var1) {
      case 0:
         this.e.v = false;
         break;
      default:
         this.e.v = true;
      }

      this.e();
   }

   private void e() {
      try {
         Message var1;
         (var1 = new Message((byte)-53)).writeByte(this.c.b.b);
         var1.writeByte(this.e.b.b);
         var1.send();
      } catch (Exception var3) {
         Utlis.println(var3);
      }
   }

   public void b() {
      this.c.b();
      this.d.a();
   }

   public void a(int var1, Object var2, LangLa_cy var3) {
      LangLa_ab var7;
      LangLa_kd var8;
      switch(var1) {
      case 1002:
         this.a();
         return;
      case 2002:
         var8 = (LangLa_kd)var2;
         var7 = this;

         try {
            GameSrc.gI();
            GameSrc.h(var7.b[var8.a].b);
            break;
         } catch (Exception var5) {
            return;
         }
      case 2003:
         var8 = (LangLa_kd)var2;
         var7 = this;

         try {
            GameSrc.gI();
            GameSrc.e(var7.b[var8.a].b);
            break;
         } catch (Exception var4) {
            return;
         }
      case 2004:
         var8 = (LangLa_kd)var2;
         var7 = this;

         try {
            beatdz.LangLa_kw.$state_LangLa_kw().d = var7.b[var8.a].b;
            LangLa_kq var9 = new LangLa_kq(GameSrc.gI(), 6);
            GameSrc.gI().a((String)var7.b[var8.a].b, (LangLa_ko)var9);
            return;
         } catch (Exception var6) {
         }
      }

   }

   public void a(int var1, Object var2) {
   }

   public Vector c() {
      Vector var1;
      (var1 = super.c()).addElement(this.c.c());
      var1.addElement(this.d.a(1003, this));
      int var10000 = this.c.b.b;
      return var1;
   }

   public void a(Graphics var1) {
      this.a(var1, this.cx, this.cy, this.width, this.height, Caption.cc, (byte)2, this.r);
      this.c.a(var1);
      this.b(var1, this.d);
      this.a(var1, 0, -28, this.d.width, 28, -11, 55, 56);
      mFont.b(mFont.e, var1, Caption.cd, 20, -15, 2, -6488, -10275328);
      mFont.b(mFont.e, var1, Caption.ce, 70, -15, 2, -6488, -10275328);
      if (this.c.b.b == 0) {
         mFont.b(mFont.e, var1, Caption.cf, 130, -15, 2, -6488, -10275328);
      }

      mFont.b(mFont.e, var1, Caption.E, 190, -15, 2, -6488, -10275328);
      this.a(var1, this.d);

      for(int var2 = 0; var2 < this.d.i; ++var2) {
         if (this.d.b(var2)) {
            if (var2 == this.d.k) {
               var1.f(13136426);
               var1.c(0, var2 * this.d.h, this.d.width, this.d.h);
            }

            LangLa_ln var3 = this.b[var2];
            mFont.b(mFont.d, var1, "" + (var2 + 1), 20, 8 + var2 * this.d.h, 2, -3604601, -16777216);
            mFont.b(mFont.d, var1, var3.b, 70, 8 + var2 * this.d.h, 2, -3604601, -16777216);
            if (this.c.b.b == 0) {
               mFont.b(mFont.d, var1, Utlis.numberFormat(var3.d), 130, 8 + var2 * this.d.h, 2, -3604601, -16777216);
            }

            mFont.b(mFont.d, var1, var3.f, 190, 8 + var2 * this.d.h, 2, -3604601, -16777216);
            if (var3.e == 6) {
               mFont.b(mFont.d, var1, Caption.ch, 255, 8 + var2 * this.d.h, 2, -3604601, -16777216);
            } else if (var3.e == 7) {
               mFont.b(mFont.d, var1, Caption.ci, 255, 8 + var2 * this.d.h, 2, -3604601, -16777216);
            }
         }
      }

      this.b(var1);
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      switch(var1.b) {
      case 1001:
         if (var1.j.k >= 0) {
            beatdz.LangLa_ab.$state_LangLa_ab().f = var1.j.k;
            this.a(var1.j.k);
            return;
         }
         break;
      case 1003:
         if (var1.j.k >= 0) {
            int var4 = var3;
            var3 = var2;
            var2 = var1.j.k;
            Vector var5;
            (var5 = new Vector()).addElement(new LangLa_lk(2002, Caption.cj));
            var5.addElement(new LangLa_lk(2003, Caption.ck));
            var5.addElement(new LangLa_lk(2004, Caption.cl));
            if (var5.size() > 0) {
               String[] var6 = new String[var5.size()];
               short[] var7 = new short[var5.size()];

               for(int var8 = 0; var8 < var5.size(); ++var8) {
                  LangLa_lk var9 = (LangLa_lk)var5.elementAt(var8);
                  var6[var8] = var9.b;
                  var7[var8] = (short)var9.a;
               }

               this.cL = a(this, var3 + 25, var4, new LangLa_kd(var2, var7, var6));
            }
         }
      }

   }

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public int f;
public void initialize() {
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.LangLa_ab");
public static SessionState $state_LangLa_ab() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
