package beatdz;
import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_d extends LangLa_ge {
   private LangLa_ij b;
   private LangLa_dz c;
   public Item[] a = new Item[16];

   public LangLa_d(MainScreen var1) {
      super(var1, Caption.si);
      this.c = this.a(this.width / 2 - 35, this.height - 33, Caption.aP, this, 5002, -8);
      this.a(this.c, 0);
      this.b = new LangLa_ij((byte)1, 7, this.a_() + 3, 128, 128, 32, Utlis.c(this.a.length, 4), 4);
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
            LangLa_d var6 = this;

            try {
               Message var7 = Message.c((byte)-86);
               var3 = 0;

               int var4;
               for(var4 = 0; var4 < var6.a.length; ++var4) {
                  if (var6.a[var4] != null) {
                     ++var3;
                  }
               }

               var7.writeByte(var3);

               for(var4 = 0; var4 < var6.a.length; ++var4) {
                  if (var6.a[var4] != null) {
                     var7.writeShort(var6.a[var4].index);
                  }
               }

               var7.send();
               return;
            } catch (Exception var5) {
               Utlis.println(var5);
            }
         }
      }

   }

   public void a(int var1, Object var2) {
   }

   public void a(Graphics var1) {
      super.a(var1);
      if (this.k() == 0) {
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
         mFont.b(mFont.d, var1, Caption.eN, this.b.width + 10, 25, 0, -1, -16777216);
         mFont.b(mFont.d, var1, Utlis.replaceAll(Caption.eO, Utlis.numberFormat(500000)), this.b.width + 10, 40, 0, -1, -16777216);
         mFont.b(mFont.d, var1, Caption.nr, this.b.width + 10, 55, 0, -2560, -16777216);
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
            int var10001 = this.a[var1].index;
            Char.gI().arrItemBag[var10001] = this.a[var1];
            this.a[var1] = null;
         }
      }

   }
}
