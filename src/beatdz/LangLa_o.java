package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_o extends LangLa_ge {
   private LangLa_ij b;
   private LangLa_dz c;
   public Item[] a = new Item[16];

   public LangLa_o(MainScreen var1) {
      super(var1, Caption.tg);
      this.c = this.a(this.width / 2 - 35, this.height - 33, Caption.aP, this, 5002, -8);
      this.a(this.c, 0);
      this.b = new LangLa_ij((byte)1, 7, this.a_() + 3, 128, 128, 32, Utlis.c(this.a.length, 4), 4);
   }

   public void a() {
      this.t = new Item[Char.gI().arrItemBag.length];
      int var1 = 0;

      for(int var2 = 0; var2 < Char.gI().arrItemBag.length; ++var2) {
         Item var3;
         if ((var3 = Char.gI().arrItemBag[var2]) != null && (var3.id == 171 || var3.id == 172 || var3.id == 173 || var3.id == 355 || var3.id == 356 || var3.id == 357 || var3.id == 358 || var3.id == 359 || var3.id == 360 || var3.id == 361 || var3.id == 362 || var3.id == 363)) {
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
            LangLa_o var6 = this;

            try {
               Message var7 = Message.c((byte)-53);
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
         mFont.b(mFont.d, var1, Caption.og, 144, this.a_() + 20, 0, -1, -16777216);
         mFont.b(mFont.d, var1, Caption.oh, 144, this.a_() + 36, 0, -1, -16777216);
         mFont.b(mFont.d, var1, Caption.oi, 144, this.a_() + 52, 0, -1, -16777216);
         mFont.b(mFont.d, var1, Caption.oj, 144, this.a_() + 68, 0, -1, -16777216);
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
      }

   }

   public void b() {
      super.b();
      if (this.k() == 0) {
         this.b.a();
      } else {
         this.a();
      }

      if (GameSrc.gI().Task <= 12 && this.p.cD.lastElement().equals(this)) {
         if (GameSrc.gI().Task == 1 && GameSrc.gI().idStep == 1) {
            this.b(378);
            return;
         }

         if (GameSrc.gI().Task == 2 && GameSrc.gI().idStep == 1) {
            this.b(194);
            return;
         }

         if (GameSrc.gI().Task == 3 && GameSrc.gI().idStep == 4) {
            this.b(379);
            return;
         }

         if (GameSrc.gI().Task == 6 && GameSrc.gI().idStep == 3) {
            this.b(201);
            return;
         }

         boolean var1;
         int var10001;
         int var10002;
         if (GameSrc.gI().Task == 7 && GameSrc.gI().idStep == 3) {
            var1 = true;
            var1 = true;
            if (this.k() != 0) {
               if (this.cL == null) {
                  int[] var2;
                  if (Char.gI().f(207) > 0) {
                     if ((var2 = Char.gI().c(207)) != null) {
                        var10001 = this.cx + var2[0] + 15;
                        DataCenter.gI().aO.a(var10001, this.cy + 25 + var2[1] + 15);
                     }
                  } else if (Char.gI().f(208) > 0) {
                     if ((var2 = Char.gI().c(208)) != null) {
                        var10001 = this.cx + var2[0] + 15;
                        DataCenter.gI().aO.a(var10001, this.cy + 25 + var2[1] + 15);
                     }
                  } else {
                     var10001 = this.cx + 70;
                     DataCenter.gI().aO.a(var10001, this.cy + 10);
                  }

                  DataCenter.gI().aO.a = true;
               }

               return;
            }

            if (this.e(207) > 0) {
               var10001 = this.cx + this.width / 2;
               var10002 = this.cy + this.height;
               DataCenter.gI().aO.a(var10001, var10002 - 20);
            } else {
               var10001 = this.cx + 160;
               DataCenter.gI().aO.a(var10001, this.cy + 10);
            }

            DataCenter.gI().aO.a = true;
         } else {
            if (GameSrc.gI().Task == 10 && GameSrc.gI().idStep == 5) {
               this.b(381);
               return;
            }

            if (GameSrc.gI().Task == 11 && GameSrc.gI().idStep == 5) {
               var1 = true;
               if (this.k() == 0) {
                  if (this.e(382) == 0) {
                     var10001 = this.cx + 40;
                     var10002 = this.cy + this.height;
                     DataCenter.gI().aO.a(var10001, var10002 - 35);
                  } else {
                     var10001 = this.cx + this.width / 2;
                     var10002 = this.cy + this.height;
                     DataCenter.gI().aO.a(var10001, var10002 - 20);
                  }

                  DataCenter.gI().aO.a = true;
                  return;
               }

               var10001 = this.cx + 70;
               DataCenter.gI().aO.a(var10001, this.cy + 10);
               DataCenter.gI().aO.a = true;
            }
         }
      }

   }

   private void b(int var1) {
      int var10001;
      if (this.k() == 0) {
         if (this.e(var1) > 0) {
            var10001 = this.cx + this.width / 2;
            int var10002 = this.cy + this.height;
            DataCenter.gI().aO.a(var10001, var10002 - 20);
         } else {
            var10001 = this.cx + 160;
            DataCenter.gI().aO.a(var10001, this.cy + 10);
         }

         DataCenter.gI().aO.a = true;
      } else {
         if (this.cL == null) {
            if (Char.gI().f(var1) > 0) {
               int[] var2;
               if ((var2 = Char.gI().c(var1)) != null) {
                  var10001 = this.cx + var2[0] + 15;
                  DataCenter.gI().aO.a(var10001, this.cy + 25 + var2[1] + 15);
               }
            } else {
               var10001 = this.cx + 70;
               DataCenter.gI().aO.a(var10001, this.cy + 10);
            }

            DataCenter.gI().aO.a = true;
         }

      }
   }

   private int e(int var1) {
      int var2 = 0;

      for(int var3 = 0; var3 < this.a.length; ++var3) {
         if (this.a[var3] != null && this.a[var3].id == var1) {
            var2 += this.a[var3].getAmount();
         }
      }

      return var2;
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
