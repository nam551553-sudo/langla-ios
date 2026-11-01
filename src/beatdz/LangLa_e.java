package beatdz;
import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_e extends LangLa_kj {
   private LangLa_ij b;
   private LangLa_dz c;
   public Item[] a = new Item[16];

   public LangLa_e(MainScreen var1) {
      super(var1, Caption.tm);
      this.c = this.a(this.width / 2 - 35, this.height - 33, Caption.aP, this, 5002, -8);
      this.a(this.c, 0);
      this.b = new LangLa_ij((byte)1, 7, this.a_() + 3, 128, 128, 32, Utlis.c(this.a.length, 4), 4);
   }

   public void a() {
      this.t = new Item[Char.gI().arrItemBag.length];
      int var1 = 0;

      for(int var2 = 0; var2 < Char.gI().arrItemBag.length; ++var2) {
         if (Char.gI().arrItemBag[var2] != null && Char.gI().arrItemBag[var2].p()) {
            this.t[var1] = Char.gI().arrItemBag[var2];
            ++var1;
         }
      }

   }

   public void a(LangLa_jz var1, int var2, int var3) {
      if (this.k() == this.j() && var1.b == 0) {
         this.d();
      }

      super.a(var1, var2, var3);
      if (this.k() == 0) {
         switch(var1.b) {
         case 5001:
            this.cL = a(var1, this, this.a[var1.j.k]);
            return;
         case 5002:
            LangLa_e var6 = this;

            Exception var10000;
            label39: {
               boolean var10001;
               Message var7;
               try {
                  var7 = Message.c((byte)-48);
                  var3 = 0;
               } catch (Exception var5) {
                  var10000 = var5;
                  var10001 = false;
                  break label39;
               }

               while(true) {
                  try {
                     if (var3 >= var6.a.length) {
                        return;
                     }

                     if (var6.a[var3] != null) {
                        var7.writeByte(var6.a[var3].TYPE_TEMP);
                        var7.writeShort(var6.a[var3].index);
                        var7.send();
                        return;
                     }
                  } catch (Exception var4) {
                     var10000 = var4;
                     var10001 = false;
                     break;
                  }

                  ++var3;
               }
            }

            Utlis.println(var10000);
         }
      }

   }

   public void a(int var1, Object var2) {
   }

   public void a(Graphics var1) {
      super.a(var1);
      if (this.k() != 0) {
         this.a();
      } else {
         this.a(var1, this.b);

         for(int var2 = 0; var2 < this.b.i; ++var2) {
            for(int var3 = 0; var3 < this.b.r; ++var3) {
               if (this.b.b(var2)) {
                  b(var1, var3 * this.b.h, var2 * this.b.h, this.a[var2 * this.b.r + var3], var2 * this.b.r + var3 == this.b.k);
               }
            }
         }

         this.b(var1);
         this.a(var1, this.cx + 4, this.cy + this.a_());
         mFont.b(mFont.d, var1, Caption.oN, this.b.width + 10, 25, 0, -1, -16777216);
         mFont.b(mFont.d, var1, Utlis.replaceAll(Caption.eO, Utlis.numberFormat(1000000)), this.b.width + 10, 40, 0, -1, -16777216);
         mFont.b(mFont.d, var1, Caption.oO, this.b.width + 10, 55, 0, -2560, -16777216);
      }
   }

   public void b() {
      super.b();
      if (this.k() == 0) {
         this.b.a();
      }

   }

   public Vector c() {
      Vector var1 = super.c();
      if (this.k() == 0) {
         var1.addElement(this.b.a(5001, this));
      }

      return var1;
   }

   public void d() {
      super.d();

      for(int var1 = 0; var1 < this.a.length; ++var1) {
         if (this.a[var1] != null) {
            Char.gI().h(this.a[var1].TYPE_TEMP)[this.a[var1].index] = this.a[var1];
            this.a[var1] = null;
         }
      }

   }
}
