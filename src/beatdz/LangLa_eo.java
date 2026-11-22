package beatdz;
import java.util.Vector;

public class LangLa_eo implements Cloneable {
   public int a = -1;
   public int b = -1;
   public int c = -1;
   public int d = -1;
   public int e;
   public int f;
   public Vector g;
   public int h = -1;
   public int i = 0;
   public int j = -1;

   public LangLa_eo a() {
      try {
         return (LangLa_eo)super.clone();
      } catch (Exception var2) {
         Utlis.println(var2);
         return null;
      }
   }

   public LangLa_eo(int var1, int var2, int var3) {
      this.h = var1;
      this.d = var1;
      this.e = var2;
      this.f = var3;
   }

   public LangLa_eo(int var1, int var2, int var3, int var4, int var5, int var6) {
      this.h = var4;
      this.b = var2;
      this.a = var1;
      this.c = var3;
      this.d = var4;
      this.e = var5;
      this.f = var6;
   }

   public LangLa_eo(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.h = var4;
      this.b = -1;
      this.a = var1;
      this.c = -1;
      this.d = var4;
      this.e = 0;
      this.f = 0;
      this.i = var7;
   }

   
   public Object clone() {
      return this.a();
   }
}
