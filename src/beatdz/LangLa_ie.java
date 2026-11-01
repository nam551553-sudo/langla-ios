package beatdz;
import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_ie extends LangLa_fm {
   private LangLa_dz[] b = new LangLa_dz[3];
   private LangLa_ii[] c;
   private LangLa_ii d;
   public String[] a;

   public LangLa_ie(int var1, int var2, int var3, LangLa_cx var4, String var5, boolean var6, boolean var7, boolean var8) {
      this.s = var4;
      this.setXY(var1, var2);
      this.a = mFont.c(mFont.d, var5, var3 - 20);
      int var10000 = this.a.length > 10 ? 10 : this.a.length;
      var1 = var10000;
      if ((var2 = var10000 * 13 + 10) < 100) {
         var2 = 100;
      }

      this.setSize(var3, var2);
      this.b[0] = new LangLa_dz(var3 - 17, 3, 0, 0, "", var4, 2001, 52);
      this.b[1] = new LangLa_dz(var3 - 45, this.height - 26, 0, 0, Caption.cP, var4, 3001, 7);
      this.b[1].setSize(40, 20);
      this.b[1].a(var7);
      this.b[2] = new LangLa_dz(var3 - 90, this.height - 26, 0, 0, Caption.bk, var4, 3000, 7);
      this.b[2].setSize(40, 20);
      this.b[2].a(var6);
      this.c = a(this.b);
      this.d = new LangLa_ii((byte)1, 0, 5, var3, var1 * 13 - 26, 13, this.a.length);
      if (!var8) {
         this.b[1] = null;
         this.b[2] = null;
         this.setSize(var3, this.height - 26);
      }

   }

   public void a(Graphics var1) {
      this.a(var1, 0, 0, this.width, this.height, -11, 55, 56);
      int var2 = var1.a;
      int var3 = var1.b;
      this.a(var1, this.d);

      for(int var4 = 0; var4 < this.a.length; ++var4) {
         mFont.c(mFont.d, var1, this.a[var4], 8, var4 * this.d.h + 5, 0, -1, -16777216);
      }

      this.b(var1);
      this.a(var1, var2, var3);
      this.d.b(var1, -21, 0);
      this.a(var1, this.b, var2, var3);
   }

   public void b() {
      this.d.a();
      a(this.b, this.c);
   }

   public Vector c() {
      Vector var1 = new Vector();

      for(int var2 = 0; var2 < this.b.length; ++var2) {
         if (this.b[var2] != null && !this.b[var2].v && !this.b[var2].u) {
            var1.addElement(this.c[var2].a(this.b[var2].b, this));
         }
      }

      var1.add(this.d.a(2000, this));
      var1.addElement(new LangLa_jz(1011, 0, 0, this.width, this.height, this.d, this));
      return var1;
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      switch(var1.b) {
      case 2000:
         return;
      case 2001:
         this.s.b((LangLa_cs)this);
         return;
      case 3000:
         if (!this.b[2].u) {
            LangLa_kl.l().r();
            this.s.b((LangLa_cs)this);
            return;
         }
         break;
      case 3001:
         if (!this.b[1].u) {
            LangLa_kl.l().q();
            this.s.b((LangLa_cs)this);
         }
      }

   }
}
