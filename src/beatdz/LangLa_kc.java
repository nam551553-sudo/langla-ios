package beatdz;
import java.util.Vector;

public class LangLa_kc {
   public int a;
   public int b;
   public Vector c = new Vector();

   public LangLa_kc(int var1) {
      this.a = var1;
   }

   public LangLa_kc(int var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

   public int a() {
      for(int var1 = 0; var1 < this.c.size(); ++var1) {
         if (((LangLa_cl)this.c.elementAt(var1)).a) {
            return var1;
         }
      }

      return -1;
   }
}
