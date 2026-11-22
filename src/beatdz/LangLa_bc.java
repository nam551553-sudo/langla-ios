package beatdz;
import java.util.Vector;

public class LangLa_bc extends LangLa_fo {
   private LangLa_ii[] a = new LangLa_ii[4];
   private Item[] b = new Item[4];
   private int c = -1;

   public LangLa_bc(MainScreen var1, Message var2) {
      this.p = var1;
      this.cF = 2;
      this.a(269, 170);
      this.H();
      this.I().setXY(this.width - 22, 20);
      this.a(this.width / 2 - 33, this.height - 33, "", this, 1000, 672);
      this.q = new LangLa_il((byte)0, 0, 0, this.width, this.height, 1, 1);
      this.q.p = this;

      int var5;
      for(var5 = 0; var5 < this.a.length; ++var5) {
         this.a[var5] = new LangLa_ii((byte)1, 20 + var5 * 34, 100, 30, 30, 1, 1);
      }

      try {
         for(var5 = 0; var5 < this.b.length; ++var5) {
            this.b[var5] = new Item();
            this.b[var5].read(var2);
            switch(var5) {
            case 0:
               this.b[var5].level = 8;
               break;
            case 1:
               this.b[var5].level = 12;
               break;
            case 2:
               this.b[var5].level = 14;
               break;
            case 3:
               this.b[var5].level = 16;
            }
         }

      } catch (Exception var4) {
      }
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      this.c = -1;
      super.a(var1, var2, var3);
      switch(var1.b) {
      case 300:
         this.c = (Integer)var1.k;
         Item var4;
         (var4 = this.b[this.c].a()).level = 0;
         this.cL = a(this, this.a[this.c].cx + 32, this.a[this.c].cy, 30, var4);
         return;
      case 1000:
         this.J();
         GameSrc.gI();
         GameSrc.F();
      default:
      }
   }

   public Vector c() {
      Vector var1 = new Vector();

      for(int var2 = 0; var2 < this.a.length; ++var2) {
         var1.addElement(this.a[var2].a(300, this, var2));
      }

      var1.addElement(this.q.a(-9999, this));
      return var1;
   }

   public void a(int var1, Object var2, LangLa_cy var3) {
   }

   public void a(int var1, Object var2) {
   }

   public void a(Graphics var1) {
      LangLa_fq.a(var1, 671, 0, 0, 0, 20);

      for(int var2 = 0; var2 < this.a.length; ++var2) {
         b(var1, this.a[var2].cx, this.a[var2].cy, this.b[var2], this.c == var2);
      }

   }

   public void b() {
      for(int var1 = 0; var1 < this.a.length; ++var1) {
         this.a[var1].a();
      }

   }
}
