package beatdz;
import java.util.Vector;

public class LangLa_ih extends LangLa_cz {
   private long a;
   private String[] b;
   private Vector c = new Vector();
   private int d = 8;

   public LangLa_ih(String var1) {
      this.setSize(80, 20);
      boolean var2 = true;

      int var4;
      while(var2) {
         try {
            String var3 = var1.toLowerCase();
            var2 = false;
            var4 = 0;

            for(int var5 = 0; var5 < beatdz.LangLa_je.$state_LangLa_je().g.length; ++var5) {
               int var6;
               if ((var6 = var3.indexOf(beatdz.LangLa_je.$state_LangLa_je().g[var5].d)) >= 0) {
                  ++var4;
                  if (var4 > 4) {
                     var6 = var1.toLowerCase().indexOf(beatdz.LangLa_je.$state_LangLa_je().g[var5].d);
                     var1 = var1.substring(0, var6) + var1.substring(var6 + beatdz.LangLa_je.$state_LangLa_je().g[var5].d.length(), var1.length());
                     var2 = true;
                     break;
                  }

                  var3 = var3.substring(0, var6) + var3.substring(var6 + beatdz.LangLa_je.$state_LangLa_je().g[var5].d.length(), var3.length());
                  var5 = -1;
               }
            }
         } catch (Exception var7) {
            break;
         }
      }

      int var8 = this.c.size() * 20;
      this.a = Utlis.time();
      this.b = mFont.c(mFont.b, var1, this.width - 10);
      if ((var4 = mFont.a(mFont.b, this.b)) + 10 < this.width) {
         this.width = (short)(var4 + 10);
      }

      if (this.width < var8) {
         this.width = (short)var8;
      }

      this.height = (short)(this.b.length * this.d + this.d);
      if (this.b.length * this.d + this.d > 20) {
         this.height = (short)(this.b.length * this.d + this.d);
      }

      if (this.c.size() > 0) {
         this.height = (short)(this.height + 16);
      }

      if (this.width < 40) {
         this.width = 40;
      }

      if (this.height < 20) {
         this.height = 20;
      }

   }

   public boolean a(int var1, int var2) {
      this.cx = (short)(var1 - this.width / 2);
      this.cy = (short)(var2 - this.height - 7);
      return Utlis.time() - this.a > 10000L;
   }

   public void a(Graphics var1) {
      var1.c(-7056866);
      this.a(var1, this.cx, this.cy, this.width, this.height, -12, 380, -12);
      LangLa_fq.a(var1, 381, 0, this.cx + this.width / 2 + 3, this.cy + this.height + 7, 33);
      var1.c();

      for(int var2 = 0; var2 < this.b.length; ++var2) {
         mFont.c(mFont.b, var1, this.b[var2], this.cx + this.width / 2, this.cy + this.d + var2 * this.d, 2, -1, 0);
      }

   }
}
