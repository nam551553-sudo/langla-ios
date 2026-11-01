package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_mo extends LangLa_fm {
   private LangLa_dz[] b = new LangLa_dz[2];
   private LangLa_ii[] c;
   private LangLa_ii d;
   public String[] a;

   public LangLa_mo(int var1, int var2, int var3, LangLa_cx var4, String var5, boolean var6) {
      this.s = var4;
      this.setXY(var1, var2);
      this.a = mFont.c(mFont.d, var5, var3 - 20);
      int var10000 = this.a.length > 10 ? 10 : this.a.length;
      var1 = var10000;
      var2 = var10000 * 13 + 28;
      if (var6) {
         var2 = var1 * 13 + 10;
      }

      this.setSize(var3, var2);
      this.b[0] = new LangLa_dz(var3 - 17, 3, 0, 0, "", var4, 2001, 52);
      this.b[1] = new LangLa_dz(var3 - 55, this.height - 26, 0, 0, Caption.lU, var4, 3001, 7);
      this.b[1].setSize(50, 20);
      this.b[1].b(var6);
      this.c = a(this.b);
      this.d = new LangLa_ii((byte)1, 0, 5, var3, var1 * 13, 13, this.a.length);
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
      this.a(var1, this.b, var2, var3);
      this.a(var1, var2, var3);
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
      case 3001:
         this.s.b((LangLa_cs)this);
         LangLa_ky var5 = (LangLa_ky)this.s;

         try {
            if (var5.d == 5) {
               SkillClan var6 = DataCenter.gI().SkillClan[var5.a[2].k];
               if (var5.c < var6.moneyBuy) {
                  DataCenter.gI().currentScreen.showMessage(Caption.lV, -65536);
                  return;
               }

               if (var5.b < var6.levelNeed) {
                  DataCenter.gI().currentScreen.showMessage(Caption.lX, -65536);
                  return;
               }

               DataCenter.gI().currentScreen.a(Utlis.replaceAll(Caption.lW, Utlis.numberFormat(var6.moneyBuy)), 2003, var5);
            }

            return;
         } catch (Exception var4) {
         }
      default:
      }
   }
}
