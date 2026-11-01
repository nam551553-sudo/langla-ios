package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_kx extends LangLa_fo {
   public LangLa_dz[] a;
   public LangLa_ln[] b = new LangLa_ln[0];
   private LangLa_ii c;
   private LangLa_ii[] d;

   public LangLa_kx(MainScreen var1, Message var2) {
      try {
         this.p = var1;
         this.a(315, 218);
         this.r = false;
         this.b = new LangLa_ln[var2.reader.dis.readShort()];

         for(int var5 = 0; var5 < this.b.length; ++var5) {
            this.b[var5] = new LangLa_ln();
            this.b[var5].a = var5 + 1;
            this.b[var5].b = var2.reader.readUTF();
            this.b[var5].c = var2.reader.dis.readInt();
            this.b[var5].g = var2.reader.dis.readInt() + "%";
            this.b[var5].d = (long)var2.reader.dis.readInt();
            this.b[var5].e = var2.reader.dis.readInt();
            this.b[var5].f = var2.readUTF();
         }

         this.e();
      } catch (Exception var4) {
      }
   }

   private void e() {
      this.c = new LangLa_ii((byte)1, 4, this.a_() + 28, super.width - 8, 154, 22, this.b.length);
      this.a = new LangLa_dz[this.b.length];
      this.d = new LangLa_ii[this.b.length];

      for(int var1 = 0; var1 < this.a.length; ++var1) {
         this.a[var1] = new LangLa_dz(261, var1 * this.c.h, 0, 0, Caption.me, this, 3000 + var1, 15);
         this.a[var1].setSize(37, 18);
         this.d[var1] = new LangLa_in((byte)1, this.a[var1].cx, this.a[var1].cy, this.a[var1].width, this.a[var1].height, this.a[var1].height, 1, this.c);
      }

   }

   public void b() {
      this.c.a();

      for(int var1 = 0; var1 < this.a.length; ++var1) {
         this.a[var1].b();
         this.a[var1].b();
         if (this.d[var1].l != -1) {
            this.a[var1].h = true;
         } else {
            this.a[var1].h = false;
         }
      }

      if (GameSrc.gI().Task == 14 && GameSrc.gI().idStep == 0) {
         DataCenter.gI().aO.a(this.cx + this.width - 5, this.cy + 5);
         DataCenter.gI().aO.a = true;
      }

   }

   public void a(int var1, Object var2, LangLa_cy var3) {
      LangLa_kx var7;
      LangLa_kd var8;
      switch(var1) {
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
      Vector var1 = super.c();

      for(int var4 = 0; var4 < this.a.length; ++var4) {
         int var2 = this.c.cx + this.a[var4].cx;
         int var3 = this.c.cy + this.a[var4].cy - this.c.f;
         if (Utlis.inRange(this.c.cx, this.c.cy, this.c.cx + this.c.width, this.c.cy + this.c.height, var2, var3) && Utlis.inRange(this.c.cx, this.c.cy, this.c.cx + this.c.width, this.c.cy + this.c.height, var2 + this.a[var4].width, var3 + this.a[var4].height)) {
            this.d[var4].cx = (short)var2;
            this.d[var4].cy = (short)var3;
            var1.addElement(new LangLa_jz(3000 + var4, this.d[var4].cx, this.d[var4].cy, this.d[var4].cx + this.d[var4].width, this.d[var4].cy + this.d[var4].height, this.d[var4], this));
         }
      }

      var1.addElement(this.c.a(1003, this));
      return var1;
   }

   public void a(Graphics var1) {
      this.a(var1, this.cx, this.cy, this.width, this.height, Caption.gY, (byte)2, this.r);
      this.b(var1, this.c);
      this.a(var1, 0, -28, this.c.width, 28, -11, 55, 56);
      mFont.b(mFont.e, var1, Caption.ce, 40, -15, 2, -6488, -10275328);
      mFont.b(mFont.e, var1, Caption.ju, 90, -15, 2, -6488, -10275328);
      mFont.b(mFont.e, var1, Caption.dr, 158, -15, 2, -6488, -10275328);
      mFont.b(mFont.e, var1, Caption.ds, 224, -15, 2, -6488, -10275328);
      mFont.b(mFont.e, var1, Caption.md, 279, -15, 2, -6488, -10275328);
      this.a(var1, this.c);
      int var2 = var1.a;
      int var3 = var1.b;

      for(int var4 = 0; var4 < this.c.i; ++var4) {
         if (this.c.b(var4)) {
            if (var4 == this.c.k) {
               var1.f(13136426);
               var1.c(0, var4 * this.c.h, this.c.width - 50, this.c.h);
            }

            LangLa_ln var5 = this.b[var4];
            mFont.b(mFont.d, var1, var5.f, 40, 8 + var4 * this.c.h, 2, -3604601, -16777216);
            mFont.b(mFont.d, var1, var5.c + "+" + var5.g, 90, 8 + var4 * this.c.h, 2, -3604601, -16777216);
            mFont.b(mFont.d, var1, var5.d + "/" + var5.e, 158, 8 + var4 * this.c.h, 2, -3604601, -16777216);
            mFont.b(mFont.d, var1, var5.b, 224, 8 + var4 * this.c.h, 2, -3604601, -16777216);
            this.a(var1, var2 + this.a[var4].cx, var3 + this.a[var4].cy);
            this.a[var4].a(var1);
            this.a(var1, var2, var3);
         }
      }

      this.b(var1);
      this.c.b(var1, -15, -10);
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      super.a(var1, var2, var3);
      if (var1.b >= 3000 & var1.b < 4000) {
         try {
            LangLa_dp.a().h();
            Message var11;
            (var11 = Message.c((byte)-92)).writeUTF(this.b[var1.b - 3000].f);
            var11.send();
            this.J();
            return;
         } catch (Exception var10) {
         }
      }

      switch(var1.b) {
      case 1001:
         return;
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
      default:
      }
   }

   public void d() {
      try {
         if (GameSrc.gI().B() != null && GameSrc.gI().B().id == 44) {
            GameSrc.gI();
            GameSrc.openFunc(93);
         }
      } catch (Exception var1) {
      }

      super.d();
   }
}
