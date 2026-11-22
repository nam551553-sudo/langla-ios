package beatdz;
import java.util.Vector;

public class LangLa_lj {
   public Vector a = new Vector();
   public boolean b;
   public int c;

   public boolean a() {
      return this.a.size() > 0 && ((LangLa_ey)this.a.firstElement()).a.equals(Char.gI().name);
   }

   public boolean a(String var1) {
      if (this.a.size() > 0) {
         for(int var3 = 0; var3 < this.a.size(); ++var3) {
            if (((LangLa_ey)this.a.elementAt(var3)).a.equals(var1)) {
               return true;
            }
         }
      }

      return false;
   }

   public boolean b(String var1) {
      for(int var2 = 0; var2 < this.a.size(); ++var2) {
         if (((LangLa_ey)this.a.elementAt(var2)).a.equals(var1)) {
            return true;
         }
      }

      return false;
   }

   public boolean b() {
      return this.a.size() == 0;
   }

   public boolean c() {
      return this.c >= 6;
   }
}
