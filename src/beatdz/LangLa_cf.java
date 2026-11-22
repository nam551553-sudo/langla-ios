package beatdz;
import java.util.Vector;

public class LangLa_cf extends LangLa_fm {
   private int a = 6010;
   private int b = 20;
   private LangLa_ij c;
   private int d;
   private int[] e;
   private String[] f;

   public LangLa_cf(int var1, int var2, int var3, LangLa_cx var4) {
      this.s = var4;
      this.setXY(var1, var2);
      this.setSize(80, 80);
      this.e = new int[]{-1, -16742145, -16777216, -7812062, -2560, -48128, -3407617, -9942667, -16711681, -11184811, -3089954, -65536, -11393019, -10831436, -223233, -3842196};
      this.f = new String[]{"c#white", "c#blue", "c#black", "c#green", "c#yellow", "c#orange", "c#pink", "c#purple", "c#cyan", "c#grey", "c#silver", "c#red", "c#brown", "c#5ab9b4", "c#fc97ff", "c#55f6c"};
      this.c = new LangLa_ij((byte)1, 0, 0, this.width, this.height, this.b, Utlis.c(this.e.length, 4), 4);
   }

   public void a(Graphics var1) {
      this.a(var1, -4, -4, this.width + 9, this.height + 9, -11, 84, 5, 1, 1);
      var1.f(-3180235);
      var1.c(-1, -1, this.width + 3, this.height + 3);
      this.a(var1, this.c);
      int var2 = 0;
      int var3 = 0;

      for(int var4 = 0; var4 < this.e.length; ++var4) {
         if (this.c.c(var3)) {
            var1.f(this.e[var4]);
            if (var4 == this.c.p) {
               var1.c(var2 + 4, var3 + 4, 13, 13);
               var1.f(-1);
               var1.b(var2 + 1, var3 + 1, 18, 18);
            } else {
               var1.c(var2 + 3, var3 + 3, 15, 15);
               var1.f(-11184811);
               var1.b(var2 + 1, var3 + 1, 18, 18);
            }

            var1.c();
         }

         var2 += 20;
         if (var2 > this.width - 20) {
            var2 = 0;
            var3 += 20;
         }
      }

      this.b(var1);
   }

   public void b() {
      this.c.a();
      if (this.d > 0) {
         --this.d;
         if (this.d == 0) {
            GameSrc.gI().ci = this.e[this.c.k];
            GameSrc.gI().cj = this.f[this.c.k];
            this.s.b((LangLa_cs)this);
         }
      }

   }

   public Vector c() {
      Vector var1;
      (var1 = new Vector()).addElement(new LangLa_jz(-1002, this.c.cx, this.c.cy, this.c.cx + this.c.width, this.c.cy + this.c.height, this.c, this));
      return var1;
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      if (this.d <= 0) {
         if (this.c.k >= 0 && this.c.k < this.b) {
            this.d = 4;
         }

      }
   }
}
