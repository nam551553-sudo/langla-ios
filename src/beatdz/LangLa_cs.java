package beatdz;
public abstract class LangLa_cs extends LangLa_cy {
   public LangLa_cx s;
   public boolean t;
   public boolean u;
   public boolean v;
   public LangLa_cj w;
   private int a;
   private int b;
   private int c;
   private int d;
   private int e;
   private int f;

   public int b_() {
      return this.s.cx + this.cx;
   }

   public int c_() {
      return this.s.cy + this.cy;
   }

   public void b(Graphics var1) {
      this.a(var1, this.a, this.b);
      var1.setClip(this.c, this.d, this.e, this.f);
      var1.a(this.b_(), this.c_());
   }

   public void a(Graphics var1, LangLa_ii var2) {
      try {
         this.a = var1.a;
         this.b = var1.b;
         this.c = var1.i();
         this.d = var1.j();
         this.e = var1.h;
         this.f = var1.i;
         int var3 = var2.width;
         int var4 = var2.height;
         if (var3 > this.e) {
            var3 = this.e;
         }

         if (var4 > this.f) {
            var4 = this.f;
         }

         var2.a(var1, this.b_(), this.c_(), var3, var4);
      } catch (Exception var5) {
      }
   }

   public void p() {
   }

   public void a(boolean var1) {
      this.u = var1;
   }

   public void b(boolean var1) {
      this.v = var1;
   }
}
