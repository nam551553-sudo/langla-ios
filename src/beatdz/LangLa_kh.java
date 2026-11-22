package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_kh extends LangLa_kj {
   private LangLa_ij c;
   private LangLa_dz d;
   public Item[] a = new Item[16];
   public byte b;
   private LangLa_cg e;

   public LangLa_kh(MainScreen var1, String[] var2, byte var3) {
      super(var1, var2);
      this.b = var3;
      this.d = this.a(this.width / 2 - 35, this.height - 33, Caption.aP, this, 5002, -8);
      this.a(this.d, 0);
      this.c = new LangLa_ij((byte)1, 7, this.a_() + 3, 128, 128, 32, Utlis.c(this.a.length, 4), 4);
      if (var3 == 68 || var3 == 69 || var3 == 70 || var3 == 71) {
         this.e = this.a(142, 72, 100, 5, new LangLa_kd(5003, Caption.ro), this, 0);
         this.a(this.e, 0);
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
            LangLa_kh var6 = this;

            try {
               Message var7 = null;
               if (var6.b == 78) {
                  var7 = new Message((byte)-20);
               } else if (var6.b != 61 && var6.b != 60 && var6.b != 62 && var6.b != 63) {
                  if (var6.b == 68 || var6.b == 69 || var6.b == 70 || var6.b == 71) {
                     (var7 = new Message((byte)-39)).writeByte(var6.b);
                  }
               } else {
                  (var7 = new Message((byte)-34)).writeByte(var6.b);
               }

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
                     var7.writeByte(var6.a[var4].TYPE_TEMP);
                     var7.writeShort(var6.a[var4].index);
                  }
               }

               if (var6.e != null) {
                  var7.writeByte(var6.e.b.b);
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
         this.a(var1, this.c);

         int var2;
         int var3;
         for(var2 = 0; var2 < this.c.i; ++var2) {
            for(var3 = 0; var3 < this.c.r; ++var3) {
               if (this.c.b(var2)) {
                  b(var1, var3 * this.c.h, var2 * this.c.h, this.a[var2 * this.c.r + var3], var2 * this.c.r + var3 == this.c.k);
               }
            }
         }

         this.b(var1);
         this.a(var1, this.cx + 4, this.cy + this.a_());
         byte var10 = 10;
         var3 = 0;
         int var4 = 0;
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;

         for(int var8 = 0; var8 < this.a.length; ++var8) {
            if (this.a[var8] != null) {
               var3 += this.a[var8].T();
               if (this.a[var8].W() || this.a[var8].X()) {
                  int var9 = this.a[var8].getItemTemplate().levelNeed / 10 * 100 - 100;
                  if (this.a[var8].getItemTemplate().levelNeed / 10 == 6) {
                     var9 = 600;
                  }

                  if (this.a[var8].X()) {
                     var9 *= 2;
                  }

                  if (this.a[var8].k()) {
                     var4 += var9;
                  }

                  if (this.a[var8].D()) {
                     var5 += var9;
                  }

                  if (this.a[var8].E()) {
                     var6 += var9;
                  }

                  if (this.a[var8].F()) {
                     var7 += var9;
                  }
               }
            }
         }

         if (this.b == 78) {
            mFont.b(mFont.d, var1, Caption.kB, this.c.width + 10, 10, 0, -1, -16777216);
         } else if (this.b == 61) {
            mFont.b(mFont.d, var1, Caption.kH, this.c.width + 10, 10, 0, -1, -16777216);
         } else if (this.b == 60) {
            mFont.b(mFont.d, var1, Caption.kI, this.c.width + 10, 10, 0, -1, -16777216);
         } else if (this.b == 62) {
            mFont.b(mFont.d, var1, Caption.kJ, this.c.width + 10, 10, 0, -1, -16777216);
         } else if (this.b == 63) {
            mFont.b(mFont.d, var1, Caption.kK, this.c.width + 10, 10, 0, -1, -16777216);
         } else if (this.b == 68 || this.b == 69 || this.b == 70 || this.b == 71) {
            if (this.b == 69) {
               mFont.b(mFont.d, var1, Caption.ld, this.c.width + 10, 10, 0, -1, -16777216);
               mFont.b(mFont.d, var1, Utlis.replaceAll(Caption.lh, "200"), this.c.width + 10, 22, 0, -1, -16777216);
            } else if (this.b == 71) {
               mFont.b(mFont.d, var1, Caption.le, this.c.width + 10, 10, 0, -1, -16777216);
               mFont.b(mFont.d, var1, Utlis.replaceAll(Caption.lh, "200"), this.c.width + 10, 22, 0, -1, -16777216);
            } else if (this.b == 70) {
               mFont.b(mFont.d, var1, Caption.lf, this.c.width + 10, 10, 0, -1, -16777216);
               mFont.b(mFont.d, var1, Utlis.replaceAll(Caption.lh, "200"), this.c.width + 10, 22, 0, -1, -16777216);
            } else if (this.b == 68) {
               mFont.b(mFont.d, var1, Caption.lg, this.c.width + 10, 10, 0, -1, -16777216);
               mFont.b(mFont.d, var1, Utlis.replaceAll(Caption.lh, "350"), this.c.width + 10, 22, 0, -1, -16777216);
            }

            mFont.b(mFont.d, var1, Caption.li, this.c.width + 10, 34, 0, -1, -16777216);
         }

         if (var3 > 0) {
            int var10003 = this.c.width + 10;
            var2 = var10 + 15;
            mFont.b(mFont.d, var1, Caption.cK, var10003, 25, 0, -1, -16777216);
            mFont var10000 = mFont.d;
            String var10002 = "- " + Utlis.numberFormat(var3) + " ";
            var10003 = this.c.width + 10;
            var2 += 15;
            mFont.b(var10000, var1, var10002, var10003, 40, 0, -1, -16777216);
            a(var1, this.c.width + 10, 40, "- " + Utlis.numberFormat(var3) + " ", (byte)5);
            if (var4 > 0) {
               var10000 = mFont.d;
               var10002 = "- " + Utlis.numberFormat(var4) + " " + DataCenter.gI().ItemTemplate[353].name + " " + Caption.ok;
               var10003 = this.c.width + 10;
               var2 += 15;
               mFont.b(var10000, var1, var10002, var10003, 55, 0, -1, -16777216);
            }

            if (var5 > 0) {
               var10000 = mFont.d;
               var10002 = "- " + Utlis.numberFormat(var5) + " " + DataCenter.gI().ItemTemplate[565].name + " " + Caption.ok;
               var10003 = this.c.width + 10;
               var2 += 15;
               mFont.b(var10000, var1, var10002, var10003, var2, 0, -1, -16777216);
            }

            if (var6 > 0) {
               var10000 = mFont.d;
               var10002 = "- " + Utlis.numberFormat(var6) + " " + DataCenter.gI().ItemTemplate[563].name + " " + Caption.ok;
               var10003 = this.c.width + 10;
               var2 += 15;
               mFont.b(var10000, var1, var10002, var10003, var2, 0, -1, -16777216);
            }

            if (var7 > 0) {
               var10000 = mFont.d;
               var10002 = "- " + Utlis.numberFormat(var7) + " " + DataCenter.gI().ItemTemplate[567].name + " " + Caption.ok;
               var10003 = this.c.width + 10;
               var2 += 15;
               mFont.b(var10000, var1, var10002, var10003, var2, 0, -1, -16777216);
            }
         }
      }

   }

   public void b() {
      super.b();
      if (this.k() == 0) {
         this.c.a();
      }

   }

   public Vector c() {
      Vector var1 = super.c();
      if (this.k() == 0) {
         var1.addElement(this.c.a(5001, this));
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
