package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_g extends LangLa_fo {
   public Item[] a;
   private LangLa_ij b;
   private LangLa_dz c;
   private LangLa_dz d;
   private int e = -1;
   private int f = 0;

   public LangLa_g(MainScreen var1, Message var2) {
      try {
         this.p = var1;
         this.a(208, 200);
         this.r = false;
         this.c = this.c(Caption.od, 100);
         this.d = this.b(Caption.oS, 101);
         this.d.a(true);
         this.a = new Item[var2.reader.dis.readShort()];

         for(int var3 = 0; var3 < this.a.length; ++var3) {
            Item var5;
            (var5 = new Item()).read(var2);
            var5.index = var3;
            this.a[var5.index] = var5;
         }

         this.b = new LangLa_ij((byte)1, 9, this.a_() + 5, 192, 128, 32, 6, 4);
      } catch (Exception var4) {
      }
   }

   public void b(int var1, int var2) {
      this.e = var1;
      this.f = var2;
      this.c.a(true);
      this.d.a(false);
   }

   public void a(int var1, Object var2, LangLa_cy var3) {
   }

   public void a(int var1, Object var2) {
   }

   public void a(Graphics var1) {
      this.a(var1, this.cx, this.cy, this.width, this.height, Caption.eR, (byte)2, this.r);
      this.a(var1, this.b);
      int var2 = 0;
      boolean var3 = false;

      for(int var4 = 0; var4 < this.b.r; ++var4) {
         for(int var5 = 0; var5 < this.b.i; ++var5) {
            if (var2 < this.a.length) {
               a(var1, var5 * this.b.h, var4 * this.b.h, this.a[var2], var4 * this.b.i + var5 == this.b.k, 0);
            } else {
               a(var1, var5 * this.b.h, var4 * this.b.h, (Item)null, var4 * this.b.i + var5 == this.b.k, 0);
            }

            if (!var3 && this.a[var2].id == this.e && this.a[var2].getAmount() == this.f && DataCenter.gI().i % 10 > 5) {
               var3 = true;
               var1.f(-2560);
               var1.b(var5 * this.b.h, var4 * this.b.h, 28, 28);
            }

            ++var2;
         }
      }

      this.b(var1);
   }

   public void b() {
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      super.a(var1, var2, var3);
      switch(var1.b) {
      case 100:
         try {
            Message.c((byte)-85).send();
            break;
         } catch (Exception var6) {
            return;
         }
      case 101:
         this.e = -1;
         this.f = 0;
         this.c.a(false);
         this.d.a(true);
         break;
      case 5001:
         int var4 = var1.j.k;
         LangLa_ii var8 = var1.j;
         this.b.k = -1;
         var8.k = var4;
         if (var1.j.k >= 0) {
            Item var9 = this.a[var1.j.k];
            LangLa_mq var10001;
            LangLa_ij var7;
            if (var9 != null && (var7 = (LangLa_ij)var1.j).k >= 0 && var7.k < var7.i * var7.r) {
               var7.d();
               var2 = var7.k % var7.i;
               int var5 = var7.k / var7.i - (var7.j >= 0 ? var7.j : 0);
               if (var7.n == 0) {
                  var2 = var7.k % var7.i - (var7.j >= 0 ? var7.j : 0);
                  var5 = var7.k / var7.i;
               }

               var2 = var2 * var7.h + var7.h + var7.cx;
               var5 = var5 * var7.h + var7.cy;
               var10001 = LangLa_cz.a(this, var2, var5, var7.h, var9);
            } else {
               var10001 = null;
            }

            this.cL = var10001;
            return;
         }
      }

   }

   public Vector c() {
      Vector var1;
      (var1 = super.c()).addElement(this.b.a(5001, this));
      return var1;
   }
}
