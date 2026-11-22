package beatdz;
import java.util.Comparator;

 class LangLa_cu implements Comparator {
   
   public int compare(Object var1, Object var2) {
      Entity var10000 = (Entity)var1;
      Entity var5 = (Entity)var2;
      Entity var3 = var10000;
      if (!(var10000 instanceof Mob) || ((Mob)var3).id != GameSrc.gI().bZ || var5 instanceof Mob && ((Mob)var5).id == GameSrc.gI().bZ) {
         if (!(var5 instanceof Mob) || ((Mob)var5).id != GameSrc.gI().bZ || var3 instanceof Mob && ((Mob)var3).id == GameSrc.gI().bZ) {
            int var4 = Utlis.getRange2(Char.gI().cx, Char.gI().cy, var3.cx, var3.cy);
            int var6 = Utlis.getRange2(Char.gI().cx, Char.gI().cy, var5.cx, var5.cy);
            return var4 - var6;
         } else {
            return 1;
         }
      } else {
         return -1;
      }
   }
}
