package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_by extends LangLa_ge {
   private LangLa_ij b;
   private LangLa_dz c;
   private LangLa_dz d;
   public Item[] a = new Item[16];

   public LangLa_by(MainScreen var1) {
      super(var1, Caption.sl);
      this.c = this.a(this.width / 2 - 35, this.height - 33, Caption.aP, this, 5002, -8);
      this.a(this.c, 0);
      this.d = this.a(6, this.height - 50, Caption.jY, this, 2002, -8);
      this.a(this.d, 0);
      this.b = new LangLa_ij((byte)1, 7, this.a_() + 3, 128, 128, 32, Utlis.c(this.a.length, 4), 4);
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      if (this.k() == this.j() && var1.b == 0) {
         this.d();
      }

      super.a(var1, var2, var3);
      if (this.k() == 0) {
         int var4;
         LangLa_by var8;
         switch(var1.b) {
         case 2002:
            var8 = this;
            Vector var10 = new Vector();
            int var5;
            int var6;
            Task var11;
            Step var12;
            Step var13;
            if ((var11 = GameSrc.gI().A()).b()) {
               for(var4 = 0; var4 < var11.vStep.size(); ++var4) {
                  if ((var13 = (Step)var11.vStep.elementAt(var4)).a()) {
                     var6 = var13.b();
                     var10.add(var6);
                  }
               }
            } else if ((var12 = GameSrc.gI().B()) != null) {
               var5 = var12.b();
               var10.add(var5);
            }

            for(var4 = 0; var4 < Char.gI().arrItemBag.length; ++var4) {
               if (Char.gI().arrItemBag[var4] != null && var10.contains(Char.gI().arrItemBag[var4].id)) {
                  var8.a(Char.gI().arrItemBag[var4]);
               }
            }

            boolean var10000;
            if (var11.b()) {
               var4 = 0;

               while(true) {
                  if (var4 >= var11.vStep.size()) {
                     var10000 = true;
                     return;
                  }

                  if ((var13 = (Step)var11.vStep.elementAt(var4)).a()) {
                     var6 = 0;

                     for(var2 = 0; var2 < var8.a.length; ++var2) {
                        if (var8.a[var2] != null && var8.a[var2].id == var13.b()) {
                           var6 += var8.a[var2].getAmount();
                        }
                     }

                     if (var6 < var13.require) {
                        break;
                     }
                  }

                  ++var4;
               }
            } else if ((var12 = GameSrc.gI().B()) != null) {
               var5 = 0;

               for(var6 = 0; var6 < var8.a.length; ++var6) {
                  if (var8.a[var6] != null && var8.a[var6].id == var12.b() && (var5 += var8.a[var6].getAmount()) >= var12.require) {
                     var10000 = true;
                     return;
                  }
               }
            }

            var10000 = false;
            break;
         case 5001:
            this.cL = a(var1, this, this.a[var1.j.k]);
            return;
         case 5002:
            var8 = this;

            try {
               Message var9 = new Message((byte)10);
               var3 = 0;

               for(var4 = 0; var4 < var8.a.length; ++var4) {
                  if (var8.a[var4] != null) {
                     ++var3;
                  }
               }

               var9.writeByte(var3);

               for(var4 = 0; var4 < var8.a.length; ++var4) {
                  if (var8.a[var4] != null) {
                     var9.writeShort(var8.a[var4].index);
                  }
               }

               var9.send();
            } catch (Exception var7) {
               Utlis.println(var7);
               return;
            }
         }
      }

   }

   private void a(Item var1) {
      try {
         for(int var2 = 0; var2 < this.a.length; ++var2) {
            if (this.a[var2] == null) {
               this.a[var2] = var1;
               break;
            }
         }

         Char.gI().arrItemBag[var1.index] = null;
      } catch (Exception var3) {
         Utlis.println(var3);
      }
   }

   public void a(int var1, Object var2) {
   }

   public void a(Graphics var1) {
      super.a(var1);
      if (this.k() == 0) {
         this.a(var1, this.b);

         int var2;
         for(var2 = 0; var2 < this.b.i; ++var2) {
            for(int var3 = 0; var3 < this.b.r; ++var3) {
               if (this.b.b(var2)) {
                  b(var1, var3 * this.b.h, var2 * this.b.h, this.a[var2 * this.b.r + var3], var2 * this.b.r + var3 == this.b.k);
               }
            }
         }

         this.b(var1);
         this.a(var1, this.cx + 4, this.cy + this.a_());
         byte var7 = 10;
         int var10003 = this.b.width + 10;
         var2 = var7 + 15;
         mFont.b(mFont.d, var1, Caption.iH, var10003, 25, 0, -1, -16777216);
         Task var8 = GameSrc.gI().A();
         if (GameSrc.gI().idStep >= var8.vStep.size()) {
            for(int var9 = 0; var9 < var8.vStep.size(); ++var9) {
               Step var10;
               if ((var10 = (Step)var8.vStep.elementAt(var9)).a()) {
                  int var6 = var10.b();
                  mFont var10000 = mFont.d;
                  String var10002 = "- " + var10.require + " " + DataCenter.gI().ItemTemplate[var6].name;
                  var10003 = this.b.width + 15;
                  var2 += 15;
                  mFont.b(var10000, var1, var10002, var10003, var2, 0, -1, -16777216);
               }
            }

            return;
         }

         Step var4;
         if ((var4 = GameSrc.gI().B()) != null) {
            int var5 = var4.b();
            mFont.b(mFont.d, var1, "- " + var4.require + " " + DataCenter.gI().ItemTemplate[var5].name, this.b.width + 15, 40, 0, -1, -16777216);
         }
      }

   }

   public void b() {
      super.b();
      if (this.k() == 0) {
         this.b.a();
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
            if (GameSrc.gI().Task == 10 && GameSrc.gI().idStep == 3) {
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
                     var10001 = this.cx + 35;
                     var10002 = this.cy + this.height;
                     DataCenter.gI().aO.a(var10001, var10002 - 40);
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
         int var10002;
         if (this.e(var1) > 0) {
            var10001 = this.cx + this.width / 2;
            var10002 = this.cy + this.height;
            DataCenter.gI().aO.a(var10001, var10002 - 20);
         } else {
            var10001 = this.cx + 35;
            var10002 = this.cy + this.height;
            DataCenter.gI().aO.a(var10001, var10002 - 40);
         }

         DataCenter.gI().aO.a = true;
      } else {
         var10001 = this.cx + 70;
         DataCenter.gI().aO.a(var10001, this.cy + 10);
         DataCenter.gI().aO.a = true;
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
