package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_ks extends LangLa_fo {
   private int n;
   private int o;
   private LangLa_ku[] s = new LangLa_ku[]{new LangLa_ku(this, 0, 72), new LangLa_ku(this, 73, 144), new LangLa_ku(this, 145, 216), new LangLa_ku(this, 217, 288), new LangLa_ku(this, 289, 360)};
   public int a = 0;
   public int b = 50;
   public int c;
   public int d = 0;
   public int e = 0;
   public int f = 32;
   private boolean t;
   private Item[] u = new Item[8];
   private LangLa_ij[] v = new LangLa_ij[2];
   private LangLa_dz w;
   public int g;
   public int h;
   public int i;
   public int j;
   public int k;
   public int l;
   public int m;

   public LangLa_ks(MainScreen var1) {
      this.cF = 1;
      this.p = var1;
      this.r = false;
      this.a(250, 230);
      this.n = 84;
      this.o = this.a_() + 75;
      this.w = this.a(this.width / 2 - 30, this.height - 36, Caption.rE[1], this, 1001, -8);
      this.v[0] = new LangLa_ij((byte)1, 14, this.a_() + 22, this.f, 4 * this.f, this.f, 4, 1);
      this.v[1] = new LangLa_ij((byte)1, super.width - 8 - 7 - this.f, this.a_() + 22, this.f, 4 * this.f, this.f, 4, 1);
      (new Message((byte)-10)).send();
   }

   public Vector c() {
      Vector var1;
      (var1 = super.c()).addElement(this.v[0].a(5001, this));
      var1.addElement(this.v[1].a(5002, this));
      return var1;
   }

   public void a(int var1, Object var2, LangLa_cy var3) {
   }

   public void a(int var1, Object var2) {
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      switch(var1.b) {
      case 1001:
         if (this.j < 2) {
            this.t = true;
            this.b = 50;
            this.a = 0;
            this.c = -1;
            this.e = Utlis.nextInt(5, 50);
            this.v[0].k = this.v[1].k = -1;
         }

         (new Message((byte)-11)).send();
         return;
      case 5001:
         this.v[1].k = -1;
         if (var1.j.k >= 0) {
            this.cL = a(var1, this, this.u[this.v[0].k]);
            return;
         }
         break;
      case 5002:
         this.v[0].k = -1;
         if (var1.j.k >= 0) {
            this.cL = a(var1, this, this.u[this.v[1].k + 4]);
         }
      }

   }

   public void b() {
      if (this.t) {
         this.w.a(true);
         ++this.d;
         this.a += this.b;
         if (this.a >= 360) {
            this.a = 0;
         }

         if (this.d % 4 == 0 && this.c >= 0) {
            this.b -= 5;
            if (this.b < 5) {
               this.b = 5;
               LangLa_ku var1 = this.s[this.c];
               if (this.a - this.e >= var1.a && this.a <= var1.b) {
                  this.t = false;
               }

               return;
            }
         }
      } else {
         this.h = this.k;
         this.i = this.l;
         this.j = this.m;
         this.w.a(false);
         String var2;
         if (this.j == 1) {
            var2 = Caption.dH;
            this.w.a = var2;
         } else if (this.j == 0) {
            var2 = Caption.cz;
            this.w.a = var2;
            if (this.g == 0) {
               this.w.a(true);
            }
         } else if (this.j == 2) {
            var2 = Caption.dI;
            this.w.a = var2;
         }

         Vector var3 = new Vector();
         if (this.i > 0) {
            var3.add(new Item(164, true, this.i));
         }

         if (this.i > 1) {
            var3.add(new Item(364, true));
            var3.add(new Item(265, true));
            var3.add(new Item(4, true));
         }

         if (this.i > 2) {
            var3.add(new Item(217, false));
         }

         if (this.i > 3) {
            var3.add(new Item(218, false));
         }

         if (this.i > 4) {
            var3.add(new Item(219, false));
         }

         if (this.i > 5) {
            var3.add(new Item(7, false));
         }

         for(int var4 = 0; var4 < this.u.length; ++var4) {
            if (var4 >= var3.size()) {
               this.u[var4] = null;
            } else {
               this.u[var4] = (Item)var3.elementAt(var4);
            }
         }
      }

   }

   public void a(Graphics var1) {
      this.a(var1, this.cx, this.cy, this.width, this.height, Caption.rE[0], (byte)2);
      boolean var3 = true;
      var1.k = var3;
      LangLa_fq.a(var1, 306, this.a, 4 + (super.width - 8) / 2, this.a_() + 85, 3);
      var3 = false;
      var1.k = var3;
      LangLa_fq.a(var1, 301, 0, 4 + (super.width - 8) / 2, this.a_() + 88, 33);
      mFont.a(mFont.d, var1, Caption.dJ + this.g, 15, this.height - 40, 0, -1);
      if (this.j > 0) {
         mFont.a(mFont.d, var1, Caption.dK + DataCenter.gI().DataNameClass[this.h].name, 15, this.height - 28, 0, -1);
         mFont.a(mFont.d, var1, Caption.dL + this.i, 15, this.height - 16, 0, -1);
      }

      this.a(var1, this.v[0]);

      int var2;
      for(var2 = 0; var2 < this.v[0].i; ++var2) {
         b(var1, 2, 1 + var2 * this.v[0].h, this.u[var2], var2 == this.v[0].k, Caption.x);
      }

      this.b(var1);
      this.a(var1, this.v[1]);

      for(var2 = 0; var2 < this.v[1].i; ++var2) {
         b(var1, 2, 1 + var2 * this.v[1].h, this.u[var2 + 4], var2 == this.v[1].k, Caption.x);
      }

      this.b(var1);
      this.a(var1, this.cx + 4, this.cy + this.a_());
   }
}
