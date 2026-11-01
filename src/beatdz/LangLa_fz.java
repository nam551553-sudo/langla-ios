package beatdz;
import java.util.Vector;

public class LangLa_fz {
   public boolean[] a = new boolean[21];
   public boolean[] b = new boolean[21];
   public long c;
   public int d;
   private int f;
   private int g;
   public boolean e = false;
   private Vector h = new Vector();

   public LangLa_fz() {
      this.b();
   }

   public void a(int var1) {
      this.c = Utlis.time();
      this.c(var1);
   }

   public void a(char var1) {
      this.h.add(Integer.valueOf(var1));
   }

   private void c(int var1) {
      this.d = var1;
      this.f = var1;
      switch(var1) {
      case -39:
      case -12:
      case -2:
      case 56:
         this.b[8] = true;
         this.a[8] = true;
         return;
      case -38:
      case -11:
      case -1:
      case 50:
         this.b[2] = true;
         this.a[2] = true;
         return;
      case -37:
      case -36:
      case -35:
      case -34:
      case -33:
      case -32:
      case -31:
      case -30:
      case -29:
      case -28:
      case -27:
      case -26:
      case -25:
      case -24:
      case -23:
      case -20:
      case -19:
      case -18:
      case -17:
      case -10:
      case -9:
      case -8:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
      case 11:
      case 12:
      case 13:
      case 14:
      case 21:
      case 22:
      case 23:
      case 24:
      case 25:
      case 26:
      case 27:
      case 28:
      case 29:
      case 30:
      case 31:
      case 32:
      case 33:
      case 34:
      case 36:
      case 37:
      case 38:
      case 39:
      case 40:
      case 41:
      case 43:
      case 44:
      case 45:
      case 46:
      case 47:
      case 48:
      default:
         return;
      case -22:
      case -7:
         this.b[13] = true;
         this.a[13] = true;
         return;
      case -21:
      case -6:
         this.b[12] = true;
         this.a[12] = true;
         return;
      case -16:
      case -5:
      case 0:
      case 10:
      case 53:
         this.b[5] = true;
         this.a[5] = true;
         return;
      case -15:
         this.b[14] = true;
         this.a[14] = true;
         return;
      case -14:
      case -4:
      case 54:
         this.b[6] = true;
         this.a[6] = true;
         return;
      case -13:
      case -3:
      case 52:
         this.b[4] = true;
         this.a[4] = true;
         return;
      case 15:
         this.b[15] = true;
         this.a[15] = true;
         return;
      case 16:
         this.b[16] = true;
         this.a[16] = true;
         return;
      case 17:
         this.b[17] = true;
         this.a[17] = true;
         return;
      case 18:
         this.b[18] = true;
         this.a[18] = true;
         return;
      case 19:
         this.b[19] = true;
         this.a[19] = true;
         return;
      case 20:
         this.b[20] = true;
         this.a[20] = true;
         return;
      case 35:
         this.b[11] = true;
         this.a[11] = true;
         return;
      case 42:
         this.b[10] = true;
         this.a[10] = true;
         return;
      case 49:
         this.b[1] = true;
         this.a[1] = true;
         return;
      case 51:
         this.b[3] = true;
         this.a[3] = true;
         return;
      case 55:
         this.b[7] = true;
         this.a[7] = true;
         return;
      case 57:
         this.b[9] = true;
         this.a[9] = true;
      }
   }

   public void b(int var1) {
      this.c = 0L;
      this.e = false;
      if (var1 >= 15 && var1 < this.b.length) {
         this.b[var1] = false;
      } else {
         switch(var1) {
         case -39:
         case -12:
         case -2:
         case 56:
            this.b[8] = false;
            return;
         case -38:
         case -11:
         case -1:
         case 50:
            this.b[2] = false;
            return;
         case -22:
         case -7:
            this.b[13] = false;
            return;
         case -21:
         case -6:
            this.b[12] = false;
            return;
         case -16:
         case -5:
         case 10:
         case 53:
            this.b[5] = false;
         case -37:
         case -36:
         case -35:
         case -34:
         case -33:
         case -32:
         case -31:
         case -30:
         case -29:
         case -28:
         case -27:
         case -26:
         case -25:
         case -24:
         case -23:
         case -20:
         case -19:
         case -18:
         case -17:
         case -10:
         case -9:
         case -8:
         case 0:
         case 1:
         case 2:
         case 3:
         case 4:
         case 5:
         case 6:
         case 7:
         case 8:
         case 9:
         case 11:
         case 12:
         case 13:
         case 14:
         case 20:
         case 21:
         case 22:
         case 23:
         case 24:
         case 25:
         case 26:
         case 27:
         case 28:
         case 29:
         case 30:
         case 31:
         case 32:
         case 33:
         case 34:
         case 36:
         case 37:
         case 38:
         case 39:
         case 40:
         case 41:
         case 43:
         case 44:
         case 45:
         case 46:
         case 47:
         case 48:
         default:
            return;
         case -15:
            this.b[14] = false;
            return;
         case -14:
         case -4:
         case 54:
            this.b[6] = false;
            return;
         case -13:
         case -3:
         case 52:
            this.b[4] = false;
            return;
         case 15:
            this.b[15] = false;
            return;
         case 16:
            this.b[16] = false;
            return;
         case 17:
            this.b[17] = false;
            return;
         case 18:
            this.b[18] = false;
            return;
         case 19:
            this.b[19] = false;
            return;
         case 35:
            this.b[11] = false;
            return;
         case 42:
            this.b[10] = false;
            return;
         case 49:
            this.b[1] = false;
            return;
         case 51:
            this.b[3] = false;
            return;
         case 55:
            this.b[7] = false;
            return;
         case 57:
            this.b[9] = false;
         }
      }
   }

   public void a() {
      try {
         this.d();
         if (this.c != 0L && Utlis.time() - this.c >= 500L) {
            this.c(this.f);
         }

      } catch (Exception var2) {
         Utlis.println(var2);
      }
   }

   public void b() {
      this.d();
      this.e();
      this.d = this.f = this.g = Integer.MIN_VALUE;
      this.c = 0L;
   }

   private void d() {
      for(int var1 = 0; var1 < this.a.length; ++var1) {
         this.a[var1] = false;
      }

      this.d = Integer.MIN_VALUE;
   }

   private void e() {
      for(int var1 = 0; var1 < this.b.length; ++var1) {
         this.b[var1] = false;
      }

   }

   public int c() {
      if (this.g == Integer.MIN_VALUE && this.h.size() > 0) {
         this.g = (Integer)this.h.remove(0);
      }

      return this.g;
   }
}
