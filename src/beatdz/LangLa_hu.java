package beatdz;
import java.util.Comparator;

 class LangLa_hu implements Comparator {
   
   public int compare(Object var1, Object var2) {
      Enemy var10000 = (Enemy)var1;
      Enemy var4 = (Enemy)var2;
      Enemy var3 = var10000;
      if (var4.c == var3.c) {
         return var4.b.compareTo(var3.b);
      } else {
         return var4.c ? 1 : -1;
      }
   }
}
