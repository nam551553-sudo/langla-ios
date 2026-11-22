package beatdz;
import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_z extends LangLa_fo {
   public LangLa_ln[] a = new LangLa_ln[0];
   private LangLa_lf b;
   private LangLa_ii c;
   

   public LangLa_z(MainScreen var1) {
      this.p = var1;
      this.a(316, 213);
      this.r = false;
      this.b = new LangLa_lf(new LangLa_kd(1001, Caption.sd), 4, this.a_(), super.width - 8, 23, 76, this);
      this.e();
      this.a(beatdz.LangLa_z.$state_LangLa_z().d);
   }

   public void e() {
      this.c = new LangLa_ii((byte)1, 4, this.b.d() + 28, super.width - 8, 126, 18, this.a.length);
   }

   private void a(int var1) {
      this.b.a(var1);
      this.f();
   }

   private void f() {
      try {
         Message var1;
         (var1 = new Message((byte)-22)).writeByte(this.b.b.b);
         var1.writeByte(0);
         var1.send();
      } catch (Exception var3) {
         Utlis.println(var3);
      }
   }

   public void b() {
      this.b.b();
      this.c.a();
   }

   public void a(int var1, Object var2, LangLa_cy var3) {
      LangLa_z var7;
      LangLa_kd var8;
      switch(var1) {
      case 1002:
         this.e();
         return;
      case 2002:
         var8 = (LangLa_kd)var2;
         var7 = this;

         try {
            GameSrc.gI();
            GameSrc.h(var7.a[var8.a].b);
            break;
         } catch (Exception var5) {
            return;
         }
      case 2003:
         var8 = (LangLa_kd)var2;
         var7 = this;

         try {
            GameSrc.gI();
            GameSrc.e(var7.a[var8.a].b);
            break;
         } catch (Exception var4) {
            return;
         }
      case 2004:
         var8 = (LangLa_kd)var2;
         var7 = this;

         try {
            beatdz.LangLa_kw.$state_LangLa_kw().d = var7.a[var8.a].b;
            LangLa_kq var9 = new LangLa_kq(GameSrc.gI(), 6);
            GameSrc.gI().a((String)var7.a[var8.a].b, (LangLa_ko)var9);
            return;
         } catch (Exception var6) {
         }
      }

   }

   public void a(int var1, Object var2) {
   }

   public Vector c() {
      Vector var1;
      (var1 = super.c()).addElement(this.b.c());
      var1.addElement(this.c.a(1003, this));
      int var10000 = this.b.b.b;
      return var1;
   }

   public void a(Graphics var1) {
      this.a(var1, this.cx, this.cy, this.width, this.height, Caption.cc, (byte)2, this.r);
      this.b.a(var1);
      this.b(var1, this.c);
      this.a(var1, 0, -28, this.c.width, 28, -11, 55, 56);
      mFont.b(mFont.e, var1, Caption.cd, 20, -15, 2, -6488, -10275328);
      mFont.b(mFont.e, var1, Caption.ds, 95, -15, 2, -6488, -10275328);
      mFont.b(mFont.e, var1, Caption.ou, 170, -15, 2, -6488, -10275328);
      mFont.b(mFont.e, var1, Caption.E, 245, -15, 2, -6488, -10275328);
      this.a(var1, this.c);

      for(int var2 = 0; var2 < this.c.i; ++var2) {
         if (this.c.b(var2)) {
            if (var2 == this.c.k) {
               var1.f(13136426);
               var1.c(0, var2 * this.c.h, this.c.width, this.c.h);
            }

            LangLa_ln var3 = this.a[var2];
            mFont.b(mFont.d, var1, "" + (var2 + 1), 20, 8 + var2 * this.c.h, 2, -3604601, -16777216);
            mFont.b(mFont.d, var1, var3.b, 95, 8 + var2 * this.c.h, 2, -3604601, -16777216);
            mFont.b(mFont.d, var1, Utlis.numberFormat(var3.d), 170, 8 + var2 * this.c.h, 2, -3604601, -16777216);
            mFont.b(mFont.d, var1, var3.f, 245, 8 + var2 * this.c.h, 2, -3604601, -16777216);
         }
      }

      this.b(var1);
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      switch(var1.b) {
      case 1001:
         if (var1.j.k >= 0) {
            beatdz.LangLa_z.$state_LangLa_z().d = var1.j.k;
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
public int d;
public void initialize() {
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.LangLa_z");
public static SessionState $state_LangLa_z() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
