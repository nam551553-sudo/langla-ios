package beatdz;
import java.util.Comparator;

 class LangLa_ll implements Comparator {
   
   public int compare(Object var1, Object var2) {
      LangLa_lk var10000 = (LangLa_lk)var1;
      LangLa_lk var3 = (LangLa_lk)var2;
      return var10000.b.compareTo(var3.b);
   }
}
