package beatdz;
import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_he extends LangLa_fm {
   private LangLa_dz[] a = new LangLa_dz[1];
   private LangLa_ii[] b;
   private LangLa_ii c;
   private Vector d;

   public LangLa_he(int var1, int var2, int var3, LangLa_cx var4, Vector var5) {
      this.s = var4;
      this.d = var5;
      int var6 = var5.size();
      this.setXY(var1 - var3 / 2, var2);
      this.setSize(var3, 15 * var6 + 25);
      this.a[0] = new LangLa_dz(var3 - 17, 3, 0, 0, "", var4, 2001, 52);
      this.b = a(this.a);
      this.c = new LangLa_ii((byte)1, 5, 20, var3 - 10, var6 * 15, 15, var5.size());
   }

   public void a(Graphics var1) {
      this.a(var1, 0, 0, this.width, this.height, -14, 84, 5, 1, 1);
      mFont.b(mFont.d, var1, Caption.qm, 5, 10, 0, -6488, -10275328);
      int var2 = var1.a;
      int var3 = var1.b;
      this.a(var1, this.c);

      for(int var4 = 0; var4 < this.d.size(); ++var4) {
         mFont.b(mFont.d, var1, (String)this.d.get(var4), 3, var4 * this.c.h + 6, 0, -1, -16777216);
      }

      this.b(var1);
      this.a(var1, this.a, var2, var3);
      this.a(var1, var2, var3);
      this.c.b(var1, -21, -5);
   }

   public void b() {
      this.c.a();
      a(this.a, this.b);
   }

   public Vector c() {
      Vector var1;
      (var1 = new Vector()).addElement(this.b[0].a(this.a[0].b, this));
      var1.add(this.c.a(2000, this));
      return var1;
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      switch(var1.b) {
      case 2000:
         LangLa_s var10000 = (LangLa_s)this.s;
         String var4 = (String)this.d.get(this.c.k);
         var10000.c.a(var4);
      case 2001:
         this.s.b((LangLa_cs)this);
      default:
      }
   }
}
