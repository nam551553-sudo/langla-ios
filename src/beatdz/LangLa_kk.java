package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_kk extends LangLa_fm {
   private int a;
   private Thu b;
   private LangLa_dz[] c;
   private LangLa_ii[] d;
   private LangLa_ii e;
   private LangLa_ii f;
   private String[] g;

   public LangLa_kk(int var1, int var2, int var3, LangLa_cx var4, Thu var5) {
      this.a = var3;
      this.s = var4;
      this.b = var5;
      this.setXY(var1, var2);
      if (var5.a()) {
         var1 = 0;
         if (var5.f > 0) {
            var1 += 15;
         }

         if (var5.g > 0) {
            var1 += 15;
         }

         if (var5.h > 0) {
            var1 += 15;
         }

         if (var5.i > 0) {
            var1 += 15;
         }

         if (var5.j > 0L) {
            var1 += 15;
         }

         if (var1 < 15) {
            var1 = 15;
         }

         this.setSize(230, 160 + var1);
      } else {
         this.setSize(230, 165);
      }

      this.c = new LangLa_dz[4];
      this.c[0] = new LangLa_dz(this.width - 53, this.height - 26, 0, 0, Caption.y, var4, 1000, 7);
      this.c[0].setSize(49, 22);
      this.c[1] = new LangLa_dz(this.width - 17, 3, 0, 0, "", var4, 1001, 52);
      this.c[2] = new LangLa_dz(this.width - 104, this.height - 26, 0, 0, Caption.z, var4, 1002, 7);
      this.c[2].setSize(49, 22);
      if (var5.a()) {
         this.c[3] = new LangLa_dz(8, 148, 0, 0, Caption.bL, var4, 1003, 7);
         this.c[3].setSize(41, 18);
      }

      this.d = a(this.c);
      this.g = mFont.c(mFont.d, var5.d, this.width - 18);
      this.e = new LangLa_ii((byte)1, 2, 40, this.width - 4, 84, 14, this.g.length);
      this.f = new LangLa_ii((byte)1, 54, 137, 28, 28, 28, 1);
   }

   public void a(Graphics var1) {
      int var2 = var1.a;
      int var3 = var1.b;
      this.a(var1, 0, 0, this.width, this.height, -11, 55, 56);
      mFont.a((mFont)mFont.d, (Graphics)var1, Caption.gg, 50, 12, 1, -6488, -10275328);
      mFont.a((mFont)mFont.d, (Graphics)var1, this.b.c, 55, 12, 0, -1, -10275328);
      mFont.a((mFont)mFont.d, (Graphics)var1, Caption.gh, 50, 26, 1, -6488, -10275328);
      mFont.a((mFont)mFont.d, (Graphics)var1, this.b.b, 55, 26, 0, -22360, -10275328);
      int var4;
      if (this.b.a()) {
         mFont.a((mFont)mFont.d, (Graphics)var1, Caption.gi, 8, 140, 0, -10831436, 0);
         var4 = 125;
         mFont var10000;
         String var10002;
         if (this.b.f > 0) {
            var10000 = mFont.d;
            var10002 = Utlis.numberFormat(this.b.f);
            var4 += 15;
            mFont.a((mFont)var10000, (Graphics)var1, var10002, 90, 140, 0, -1, 0);
            a(var1, 90, 138, Utlis.numberFormat(this.b.f), (byte)0);
         }

         if (this.b.g > 0) {
            var10000 = mFont.d;
            var10002 = Utlis.numberFormat(this.b.g);
            var4 += 15;
            mFont.a((mFont)var10000, (Graphics)var1, var10002, 90, var4, 0, -1, 0);
            a(var1, 90, var4 - 2, Utlis.numberFormat(this.b.g), (byte)1);
         }

         if (this.b.h > 0) {
            var10000 = mFont.d;
            var10002 = Utlis.numberFormat(this.b.h);
            var4 += 15;
            mFont.a((mFont)var10000, (Graphics)var1, var10002, 90, var4, 0, -1, 0);
            a(var1, 90, var4 - 2, Utlis.numberFormat(this.b.h), (byte)2);
         }

         if (this.b.i > 0) {
            var10000 = mFont.d;
            var10002 = Utlis.numberFormat(this.b.i);
            var4 += 15;
            mFont.a((mFont)var10000, (Graphics)var1, var10002, 90, var4, 0, -1, 0);
            a(var1, 90, var4 - 2, Utlis.numberFormat(this.b.i), (byte)3);
         }

         if (this.b.j > 0L) {
            var10000 = mFont.d;
            var10002 = Utlis.numberFormat(this.b.j);
            var4 += 15;
            mFont.a((mFont)var10000, (Graphics)var1, var10002, 90, var4, 0, -1, 0);
            a(var1, 90, var4 - 2, Utlis.numberFormat(this.b.j), (byte)6);
         }

         a(var1, this.f.cx, this.f.cy, this.b.e, false);
      }

      this.a(var1, 2, this.e.cy - 5, this.width - 4, this.e.height + 10, 3, 55, 56);
      this.a(var1, this.e);

      for(var4 = 0; var4 < this.g.length; ++var4) {
         if (this.e.b(var4)) {
            mFont.a((mFont)mFont.d, (Graphics)var1, this.g[var4], 10, 7 + var4 * this.e.h, 0, -1, 0);
         }
      }

      this.b(var1);
      this.a(var1, var2, var3);
      this.a(var1, this.c, var2, var3);
   }

   public void b() {
      this.e.a();
      this.f.a();
      if (!this.b.a()) {
         this.c[3] = null;
      }

      a(this.c, this.d);
   }

   public Vector c() {
      Vector var1 = new Vector();

      for(int var2 = 0; var2 < this.d.length; ++var2) {
         if (this.d[var2] != null && this.c[var2] != null) {
            var1.addElement(this.d[var2].a(this.c[var2].b, this));
         }
      }

      var1.addElement(this.e.a(1010, this));
      var1.addElement(this.f.a(1011, this));
      var1.addElement(new LangLa_jz(1500, 0, 0, this.width, this.height, (LangLa_ii)null, this));
      return var1;
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      switch(var1.b) {
      case 1000:
         this.a();
         ((LangLa_t)this.s).a(this.b);
         return;
      case 1001:
         this.a();
         return;
      case 1002:
         this.a();
         this.c(true);
         return;
      case 1003:
         this.a();
         Thu var5 = this.b;

         try {
            if (var5.a()) {
               Message var6;
               (var6 = new Message((byte)95)).writeShort(var5.a);
               var6.send();
            }
            break;
         } catch (Exception var4) {
            return;
         }
      case 1011:
         this.s.cL = a(this.s, var1.j.cx, var1.j.cy - 68, 28, this.b.e);
         return;
      case 2002:
         this.c(false);
      }

   }

   private void c(boolean var1) {
      try {
         if (this.b.a()) {
            DataCenter.gI().currentScreen.showMessage(Caption.gj, -65536);
         } else if (var1) {
            DataCenter.gI().currentScreen.a(Caption.gk, 2002, this);
         } else {
            Vector var3;
            (var3 = new Vector()).add(this.b);
            LangLa_t.c(var3);
         }
      } catch (Exception var2) {
      }
   }

   public void a() {
      this.s.b((LangLa_cs)this);
   }
}
