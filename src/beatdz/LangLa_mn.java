package beatdz;
import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_mn extends LangLa_fm {
   private LangLa_ii a;
   private Effect b;
   private LangLa_lk[] c;
   private long d;

   public LangLa_mn(int var1, int var2, LangLa_cx var3, Effect var4) {
      this.s = var3;
      this.b = var4;
      this.setXY(var1, var2);
      this.d = Utlis.time();
      Vector var8;
      (var8 = new Vector()).addElement("c#yellow" + var4.getEffectTemplate().name);
      if (var4.id != 37 && var4.id != 67) {
         var8.addElement("c#white" + Caption.rI[0]);
         var8.addElement("c#white" + Caption.rI[1]);
      }

      var8.addElement("c#white" + var4.d());

      for(var2 = 0; var2 < var4.g.size(); ++var2) {
         var8.addElement("c#white" + ((Effect)var4.g.get(var2)).d());
      }

      this.setSize(150, 62);
      Vector var9 = new Vector();

      int var5;
      for(var5 = 0; var5 < var8.size(); ++var5) {
         String var10 = String.valueOf(var8.elementAt(var5));
         if (var5 == 0) {
            Vector var13 = mFont.a(mFont.e, var10, this.width - 10);

            for(int var12 = 0; var12 < var13.size(); ++var12) {
               var9.add(new LangLa_lk(0, (String)var13.elementAt(var12)));
            }
         } else {
            byte var6 = 1;
            if (var4.id != 37 && var4.id != 67) {
               if (var5 == 1) {
                  var6 = 2;
               } else if (var5 == 2) {
                  var6 = 3;
               }
            }

            Vector var11 = mFont.a(mFont.d, var10, this.width - 10);

            for(int var7 = 0; var7 < var11.size(); ++var7) {
               var9.add(new LangLa_lk(var6, (String)var11.elementAt(var7)));
            }
         }
      }

      this.c = new LangLa_lk[var9.size()];

      for(var5 = 0; var5 < var9.size(); ++var5) {
         this.c[var5] = (LangLa_lk)var9.elementAt(var5);
      }

      if (this.c.length < 4) {
         this.setSize(150, 49);
      }

      this.a = new LangLa_ii((byte)1, 0, 5, this.width, this.height - 10, 13, this.c.length);
   }

   public void a(Graphics var1) {
      this.b(var1, 0, 0, this.width, this.height, 314, -11657441, -9490898);
      LangLa_fq.a(var1, 366, 0, 3, 0, 36);
      this.a(var1, this.a);

      for(int var2 = 0; var2 < this.c.length; ++var2) {
         if (this.c[var2].a == 0) {
            mFont.c(mFont.e, var1, this.c[var2].b, 6, 5 + var2 * this.a.h, 0, -1, -16777216);
         } else if (this.c[var2].a == 2) {
            mFont.c(mFont.d, var1, this.c[var2].b + " " + Utlis.k(this.b.maintain / 1000), 6, 5 + var2 * this.a.h, 0, -1, -16777216);
         } else if (this.c[var2].a == 3) {
            Effect var3;
            mFont.c(mFont.d, var1, this.c[var2].b + " " + Utlis.k(((var3 = this.b).maintain - (int)(Utlis.time() - var3.timeStart)) / 1000), 6, 5 + var2 * this.a.h, 0, -1, -16777216);
         } else {
            mFont.c(mFont.d, var1, this.c[var2].b, 6, 5 + var2 * this.a.h, 0, -1, -16777216);
         }
      }

      this.b(var1);
   }

   public void b() {
      this.a.a();
      if (Utlis.time() - this.d >= 5000L) {
         this.s.b((LangLa_cs)this);
      }

   }

   public Vector c() {
      Vector var1;
      (var1 = new Vector()).addElement(new LangLa_jz(1001, this.a.cx, this.a.cy, this.a.cx + this.a.width, this.a.cy + this.a.height, this.a, this));
      return var1;
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      this.d = Utlis.time();
   }
}
