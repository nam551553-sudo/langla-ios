package beatdz;
import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_ck extends LangLa_fl {
   private LangLa_ii a;
   private byte b;
   private LangLa_kd c;
   private int d;
   private LangLa_jz e;
   private boolean f;

   public LangLa_ck(LangLa_kd var1, MainScreen var2, byte var3, boolean var4) {
      this.p = var2;
      this.c = var1;
      this.b = 0;
      this.f = true;
      this.a(200, 200);
      this.a = new LangLa_ii((byte)1, 3, 29, this.width - 6, this.height - 62, 35, var1.c.length);
   }

   public void a(Graphics var1) {
      this.a(var1, this.cx, this.cy, this.width, this.height, Caption.h, this.b, this.r);
      this.a(var1, this.a);

      for(int var2 = 0; var2 < this.c.c.length; ++var2) {
         if (var2 == this.a.k) {
            var1.f(7173754);
            var1.c(0, 2 + var2 * this.a.h, this.a.width, this.a.h - 2);
         }

         if (this.b == 2) {
            if (var2 == this.a.l) {
               mFont.a(mFont.d, var1, this.c.c[var2], 1 + this.width / 2, 1 + var2 * this.a.h + this.a.h / 2, 2, -1);
            } else {
               mFont.a(mFont.d, var1, this.c.c[var2], this.width / 2, var2 * this.a.h + this.a.h / 2, 2, -1);
            }
         } else if (this.b == 0) {
            if (var2 == this.a.l) {
               mFont.a(mFont.d, var1, this.c.c[var2], 21, 1 + var2 * this.a.h + this.a.h / 2, 0, -1);
            } else {
               mFont.a(mFont.d, var1, this.c.c[var2], 20, var2 * this.a.h + this.a.h / 2, 0, -1);
            }
         }

         var1.f(1585983);
         var1.c(15, var2 * this.a.h + this.a.h, this.a.width - 30, 1);
         var1.f(7173754);
         var1.c(15, var2 * this.a.h + this.a.h + 1, this.a.width - 30, 1);
      }

      this.b(var1);
   }

   public void b() {
      this.a.a();
      if (this.d > 0) {
         --this.d;
         if (this.d == 0) {
            this.c.b = this.e.j.k;
            if (this.f) {
               this.p.b(-7, this, this);
               this.p.b(this.c.a, this.c, this);
            }

            this.e = null;
         }
      }

   }

   public void a(LangLa_jz var1, int var2, int var3) {
      if (this.d <= 0) {
         try {
            switch(var1.b) {
            case -1001:
               if (var1.j.k >= 0) {
                  this.d = 4;
                  this.e = var1;
                  return;
               }
               break;
            case -1000:
               this.p.b(-7, this, this);
               this.p.b(this.c.a, this.c, this);
               return;
            default:
               super.a(var1, var2, var3);
            }

         } catch (Exception var4) {
         }
      }
   }

   public Vector c() {
      Vector var1;
      (var1 = super.c()).addElement(new LangLa_jz(-1001, this.a.cx, this.a.cy, this.a.cx + this.a.width, this.a.cy + this.a.height, this.a, this));
      return var1;
   }

   public void a(int var1, Object var2, LangLa_cy var3) {
   }

   public void a(int var1, Object var2) {
   }
}
