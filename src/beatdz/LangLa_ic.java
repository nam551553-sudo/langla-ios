package beatdz;
import java.util.Comparator;

 class LangLa_ic implements Comparator {
   
   public int compare(Object var1, Object var2) {
      Friend var10000 = (Friend)var1;
      Friend var4 = (Friend)var2;
      Friend var3 = var10000;
      if (var4.b == var3.b) {
         if (var4.d == var3.d) {
            return var4.c.compareTo(var3.c);
         } else {
            return var4.d ? 1 : -1;
         }
      } else {
         return var4.b - var3.b;
      }
   }
}
