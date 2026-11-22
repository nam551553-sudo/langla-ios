package beatdz;
import java.util.Vector;

public class LangLa_gw extends XYEntity {
   public boolean a;
   public Vector b = new Vector();
   public int c;
   private int d;
   private int e;
   private int f;
   private int g;
   private int h = 5;
   private int i;

   public LangLa_gw(int var1, int var2, int var3, int var4, byte var5, int var6) {
      for(var1 = 0; var1 < var6; ++var1) {
         this.b.addElement(new LangLa_cz());
      }

      this.setXY(0, 0);
      this.g = var3;
      this.e = var5;
      this.c = var4;
      this.b();
   }

   public LangLa_gw(int var1, int var2, int var3, int var4, byte var5, int var6, int var7) {
      for(int var8 = 0; var8 < var6; ++var8) {
         LangLa_cz var9;
         (var9 = new LangLa_cz()).setSize(var7, var7);
         this.b.addElement(var9);
      }

      this.setXY(var1, 0);
      this.g = var3;
      this.e = var5;
      this.c = var4;
      this.b();
   }

   private void b() {
      this.d = 0;
      this.f = 0;
      this.a = true;
      this.i = 0;

      for(int var2 = 0; var2 < this.b.size(); ++var2) {
         LangLa_cz var1 = (LangLa_cz)this.b.elementAt(var2);
         switch(this.e) {
         case 0:
            var1.setXY(this.cx - this.g, this.cy + var2 * (var1.height + this.h));
            break;
         case 1:
            var1.setXY(this.cx + this.g, this.cy + var2 * (var1.height + this.h));
            break;
         case 2:
         case 4:
            var1.setXY(this.cx - this.g, this.cy);
            break;
         case 3:
         case 5:
            var1.setXY(this.cx + this.g, this.cy);
         case 6:
         default:
            break;
         case 7:
            var1.setXY(this.cx + var2 * (var1.width + this.h), this.cy - this.g);
            break;
         case 8:
            var1.setXY(this.cx + var2 * (var1.width + this.h), this.cy + this.g);
         }
      }

   }

   public int a(int var1) {
      return ((LangLa_cz)this.b.elementAt(var1)).cx;
   }

   public int b(int var1) {
      return ((LangLa_cz)this.b.elementAt(var1)).cy;
   }

   public void a() {
      if (this.a) {
         this.d += this.c;
         ++this.i;
         if (this.i > 100) {
            for(int var1 = 0; var1 < this.b.size(); ++var1) {
               LangLa_cz var2;
               (var2 = (LangLa_cz)this.b.elementAt(var1)).cx = this.cx;
               var2.cy = this.cy;
            }

            this.d = 0;
            this.f = this.b.size();
            this.a = false;
         }

         switch(this.e) {
         case 0:
            this.c();
            return;
         case 1:
            this.d();
            return;
         case 2:
         case 5:
            this.e();
            return;
         case 3:
         case 4:
            this.f();
            return;
         case 6:
         default:
            break;
         case 7:
            this.g();
            return;
         case 8:
            this.h();
         }
      }

   }

   private void c() {
      LangLa_cz var1;
      LangLa_cz var10000 = var1 = (LangLa_cz)this.b.elementAt(this.f);
      var10000.cx = (short)(var10000.cx + this.d);
      if (var1.cx >= this.cx) {
         var1.cx = this.cx;
         this.d = 0;
         ++this.f;
         if (this.f >= this.b.size()) {
            this.a = false;
         }
      }

   }

   private void d() {
      LangLa_cz var1;
      LangLa_cz var10000 = var1 = (LangLa_cz)this.b.elementAt(this.f);
      var10000.cx = (short)(var10000.cx - this.d);
      if (var1.cx <= this.cx) {
         var1.cx = this.cx;
         this.d = 0;
         ++this.f;
         if (this.f >= this.b.size()) {
            this.a = false;
         }
      }

   }

   private void e() {
      LangLa_cz var1 = (LangLa_cz)this.b.elementAt(this.f);
      int var2 = this.cx;
      if (this.f > 0) {
         LangLa_cz var3;
         var2 = (var3 = (LangLa_cz)this.b.elementAt(this.f - 1)).cx - var3.width - this.h;
      }

      var1.cx = (short)(var1.cx + this.d);
      if (var1.cx >= var2) {
         var1.cx = (short)var2;
         this.d = 0;
         ++this.f;
         if (this.f >= this.b.size()) {
            this.a = false;
         }
      }

   }

   private void f() {
      LangLa_cz var1 = (LangLa_cz)this.b.elementAt(this.f);
      int var2 = this.cx;
      if (this.f > 0) {
         LangLa_cz var3;
         var2 = (var3 = (LangLa_cz)this.b.elementAt(this.f - 1)).cx + var3.width + this.h;
      }

      var1.cx = (short)(var1.cx - this.d);
      if (var1.cx <= var2) {
         var1.cx = (short)var2;
         this.d = 0;
         ++this.f;
         if (this.f >= this.b.size()) {
            this.a = false;
         }
      }

   }

   private void g() {
      LangLa_cz var1;
      LangLa_cz var10000 = var1 = (LangLa_cz)this.b.elementAt(this.f);
      var10000.cy = (short)(var10000.cy + this.d);
      if (var1.cy >= this.cy) {
         var1.cy = this.cy;
         this.d = 0;
         ++this.f;
         if (this.f >= this.b.size()) {
            this.a = false;
         }
      }

   }

   private void h() {
      LangLa_cz var1;
      LangLa_cz var10000 = var1 = (LangLa_cz)this.b.elementAt(this.f);
      var10000.cy = (short)(var10000.cy - this.d);
      if (var1.cy <= this.cy) {
         var1.cy = this.cy;
         this.d = 0;
         ++this.f;
         if (this.f >= this.b.size()) {
            this.a = false;
         }
      }

   }
}
