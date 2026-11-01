package beatdz;
public class LangLa_jb {
   private LangLa_cz a;
   private byte b;
   private byte c;
   private int d;
   private int e;
   private int f;
   private int g;

   public LangLa_jb(LangLa_cz var1, byte var2, int var3) {
      this.a = var1;
      this.b = var2;
      this.d = this.e = var3;
   }

   public boolean a() {
      LangLa_cz var10000;
      switch(this.b) {
      case 0:
         if (this.a.cx != this.d) {
            this.f = this.d - this.a.cx << 2;
            this.g += this.f;
            var10000 = this.a;
            var10000.cx = (short)(var10000.cx + (this.g >> 4));
            this.g &= 15;
            this.c = 1;
         } else if (this.e != 0 && this.e != this.d) {
            this.d = this.e;
         } else if (this.c > 0) {
            this.c = 2;
         }
         break;
      case 1:
         if (this.a.cy != this.d) {
            this.f = this.d - this.a.cy << 2;
            this.g += this.f;
            var10000 = this.a;
            var10000.cy = (short)(var10000.cy + (this.g >> 4));
            this.g &= 15;
            this.c = 1;
         } else if (this.e != 0 && this.e != this.d) {
            this.d = this.e;
         } else if (this.c > 0) {
            this.c = 2;
         }
         break;
      case 2:
         if (this.a.width != this.d) {
            this.f = this.d - this.a.width << 2;
            this.g += this.f;
            var10000 = this.a;
            var10000.width = (short)(var10000.width + (this.g >> 4));
            this.g &= 15;
            this.c = 1;
         } else if (this.c > 0) {
            this.c = 2;
         }
         break;
      case 3:
         if (this.a.height != this.d) {
            this.f = this.d - this.a.height << 2;
            this.g += this.f;
            var10000 = this.a;
            var10000.height = (short)(var10000.height + (this.g >> 4));
            this.g &= 15;
            this.c = 1;
         } else if (this.c > 0) {
            this.c = 2;
         }
      }

      if (this.c == 2) {
         this.c = 0;
         return true;
      } else {
         return false;
      }
   }

   public void a(int var1) {
      this.f = this.g = 0;
      this.c = 0;
      this.d = this.e = var1;
   }

   public boolean b() {
      switch(this.b) {
      case 0:
         if (this.a.cx != this.d) {
            return true;
         }
         break;
      case 1:
         if (this.a.cy != this.d) {
            return true;
         }
         break;
      case 2:
         if (this.a.width != this.d) {
            return true;
         }
         break;
      case 3:
         if (this.a.height != this.d) {
            return true;
         }
      }

      return this.c == 1;
   }
}
