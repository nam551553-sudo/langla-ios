package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_ao extends LangLa_kj {
   public Item[] a = new Item[2];
   public Item[] b = new Item[6];
   private LangLa_ij[] g = new LangLa_ij[3];
   private LangLa_dz h;
   public int c;
   public int d = 0;
   public LangLa_jw e;
   public boolean f;

   public LangLa_ao(MainScreen var1) {
      super(var1, new String[]{Caption.ox, Caption.H});
      this.g[0] = new LangLa_ij((byte)1, 124, this.a_() + 20, 30, 30, 30, 1, 1);
      this.g[1] = new LangLa_ij((byte)1, 14, this.a_() + 20, 64, 96, 32, 3, 2);
      this.g[2] = new LangLa_ij((byte)1, 204, this.a_() + 20, 30, 30, 30, 1, 1);
      this.h = this.a(this.width - 70, this.height - 33, Caption.bj, this, 0, -8);
      this.a(this.h, 0);
   }

   public void a() {
      this.t = new Item[Char.gI().arrItemBag.length];
      int var1 = 0;

      for(int var2 = 0; var2 < Char.gI().arrItemBag.length; ++var2) {
         if (Char.gI().arrItemBag[var2] != null && Char.gI().arrItemBag[var2].K()) {
            this.t[var1] = Char.gI().arrItemBag[var2];
            ++var1;
         }
      }

   }

   public void b() {
      super.b();
      if (this.k() == 0) {
         if (!this.f) {
            if (this.a[0] == null) {
               this.a[1] = null;
            } else {
               this.a[1] = this.a[0].a();
               byte var1 = this.a[1].level;
               this.a[1].a(0);
               this.a[1].isLock = true;
               ItemOption[] var2 = this.a[1].L();
               Vector var3 = new Vector();
               String[] var4 = null;
               if (this.a[1].getItemTemplate().type == 0) {
                  var4 = new String[]{"256,4,-1", "173,20,-1", "253,2000,-1", "164,0,-1"};
               } else if (this.a[1].getItemTemplate().type == 4) {
                  var4 = new String[]{"257,4,-1", "173,20,-1", "253,2000,-1", "164,0,-1"};
               } else if (this.a[1].getItemTemplate().type == 3) {
                  var4 = new String[]{"258,25,-1", "173,20,-1", "253,2000,-1", "164,0,-1"};
               }

               boolean var5 = false;
               boolean var6 = false;

               for(int var7 = 0; var7 < var2.length; ++var7) {
                  if (var2[var7].a[0] != 148) {
                     if (var2[var7].getItemOptionTemplate().type == 2 && !var5) {
                        var3.add(new ItemOption(var4[0]));
                        var3.add(new ItemOption(var4[1]));
                        var5 = true;
                     }

                     var3.add(var2[var7]);
                     if (!var6) {
                        if (this.a[1].getItemTemplate().levelNeed / 10 == 4 && var2[var7].getItemOptionTemplate().type == 6) {
                           var3.add(new ItemOption("42,20,-1"));
                           var6 = true;
                        }

                        if (var2[var7].getItemOptionTemplate().type == 7) {
                           if (this.a[1].getItemTemplate().levelNeed / 10 >= 5) {
                              var3.add(new ItemOption(var4[2]));
                           }

                           if (this.a[1].getItemTemplate().levelNeed / 10 >= 6) {
                              this.a[1].b(var3);
                           }

                           var6 = true;
                        }
                     }
                  }
               }

               var3.add(new ItemOption(var4[3]));
               this.a[1].strOptions = Item.a(var3);
               this.a[1].a(var1);
            }
         }

         for(int var9 = 0; var9 < this.g.length; ++var9) {
            this.g[var9].a();
         }
      } else {
         this.a();
      }

      if (this.e != null) {
         this.e.p();
         if (this.e.r()) {
            this.e = null;
         }
      }

      if (this.d > 0) {
         --this.d;
      }

   }

   public void a(int var1) {
      super.a(var1);
      if (var1 != 0 && this.f) {
         this.f = false;
      }

   }

   public void a(Graphics var1) {
      if (this.j() <= 0) {
         this.a(var1, this.cx, this.cy, this.width, this.height, Caption.q, (byte)2, this.r);
      } else {
         super.a(var1);
      }

      if (this.k() == 0) {
         mFont.b(mFont.d, var1, Caption.kt + DataCenter.gI().ItemTemplate[567].name, 14, this.a_() + 9, 0, -10831436, -16777216);
         mFont.b(mFont.d, var1, Caption.oB, 89, this.a_() + 65, 0, -10831436, -16777216);
         int var2;
         int var3;
         if (this.a[0] != null) {
            var2 = 25000000;
            var3 = this.a[0].getItemTemplate().levelNeed / 10 * 100;
            if (this.a[0].getItemTemplate().levelNeed / 10 == 5) {
               var2 = 30000000;
            } else if (this.a[0].getItemTemplate().levelNeed / 10 == 6) {
               var2 = 40000000;
               var3 = 700;
            }

            mFont.b(mFont.d, var1, Utlis.replaceAll(Caption.kr, Utlis.numberFormat(var3)) + DataCenter.gI().ItemTemplate[567].name, 89, this.a_() + 80, 0, -10831436, -16777216);
            mFont.b(mFont.d, var1, Utlis.replaceAll(Caption.oq, Utlis.numberFormat(var2)), 89, this.a_() + 95, 0, -10831436, -16777216);
         }

         a(var1, this.g[0].cx, this.g[0].cy, this.a[0], this.g[0].k >= 0, Caption.H);
         a(var1, this.g[2].cx, this.g[0].cy, this.a[1], this.g[2].k >= 0, Caption.I);
         LangLa_fq.a(var1, 95, 0, 170 - DataCenter.gI().i / 3 % 3, this.a_() + 25, 20);
         if (this.d > 0 && this.d % 14 > 2) {
            mFont.b(mFont.d, var1, Caption.kL + DataCenter.gI().ItemOptionTemplate[164].name, 14, this.a_() + 125, 0, -2560, -16777216);
         }

         this.a(var1, this.g[1]);
         var2 = 0;

         for(var3 = 0; var3 < this.g[1].i; ++var3) {
            for(int var4 = 0; var4 < this.g[1].r; ++var4) {
               b(var1, var4 * this.g[1].h, var3 * this.g[1].h, this.b[var3 * this.g[1].r + var4], var2 == this.g[1].k, Caption.tk[var4]);
               ++var2;
            }
         }

         this.b(var1);
         if (this.e != null) {
            this.e.b(var1, this.g[2].cx + this.g[2].h / 2, this.g[2].cy + this.g[2].h / 2);
         }
      }

   }

   public Vector c() {
      Vector var1 = super.c();
      if (this.k() == 0) {
         for(int var2 = 0; var2 < this.g.length; ++var2) {
            var1.addElement(this.g[var2].a(1001 + var2, this));
         }
      }

      return var1;
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      if (this.k() == this.j() && var1.b == 0) {
         this.d();
      }

      super.a(var1, var2, var3);
      if (this.k() == 0) {
         switch(var1.b) {
         case 0:
            LangLa_ao var5 = this;

            try {
               var2 = 0;

               for(var3 = 0; var3 < var5.b.length; ++var3) {
                  if (var5.b[var3] != null) {
                     ++var2;
                  }
               }

               if (var5.a[0] != null && var2 != 0) {
                  Message var6;
                  (var6 = new Message((byte)-35)).writeByte(var5.a[0].TYPE_TEMP);
                  var6.writeShort(var5.a[0].index);
                  var6.writeByte(var2);

                  for(var2 = 0; var2 < var5.b.length; ++var2) {
                     if (var5.b[var2] != null) {
                        var6.writeShort(var5.b[var2].index);
                     }
                  }

                  var6.send();
               } else {
                  DataCenter.gI().currentScreen.showMessage(Caption.kt + DataCenter.gI().ItemTemplate[567].name, -65536);
               }
               break;
            } catch (Exception var4) {
               Utlis.println(var4);
               return;
            }
         case 1001:
            this.c = 1;
            this.a(var1.j, var1.j.k);
            this.cL = a(var1, this, this.a[0]);
            return;
         case 1002:
            this.c = 2;
            this.a(var1.j, var1.j.k);
            this.cL = a(var1, this, this.b[var1.j.k]);
            return;
         case 1003:
            this.c = 3;
            this.a(var1.j, var1.j.k);
            this.cL = a(var1, this, this.a[1]);
         }
      }

   }

   private void a(LangLa_ii var1, int var2) {
      for(int var3 = 0; var3 < this.g.length; ++var3) {
         this.g[var3].k = -1;
      }

      var1.k = var2;
   }

   public void d() {
      super.d();
      if (this.a[0] != null) {
         Char.gI().h(this.a[0].TYPE_TEMP)[this.a[0].index] = this.a[0];
         this.a[0] = null;
      }

      for(int var1 = 0; var1 < this.b.length; ++var1) {
         if (this.b[var1] != null) {
            int var10001 = this.b[var1].index;
            Char.gI().arrItemBag[var10001] = this.b[var1];
            this.b[var1] = null;
         }
      }

   }
}
