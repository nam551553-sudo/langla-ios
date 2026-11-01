package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_am extends LangLa_kj {
   public Item[] a = new Item[1];
   public Item[] b = new Item[20];
   private LangLa_ij[] g = new LangLa_ij[3];
   private LangLa_dz h;
   public int c;
   public LangLa_jw d;
   public Item e;
   public boolean f;

   public LangLa_am(MainScreen var1) {
      super(var1, new String[]{Caption.rx[7], Caption.H});
      this.g[0] = new LangLa_ij((byte)1, 202, this.a_() + 20, 30, 30, 30, 1, 1);
      this.g[1] = new LangLa_ij((byte)1, 242, this.a_() + 20, 30, 30, 30, 1, 1);
      this.g[2] = new LangLa_ij((byte)0, 14, this.a_() + 20, 128, 160, 32, 5, 4);
      this.h = this.a(this.width - 70, this.height - 33, Caption.bi, this, 0, -8);
      this.a(this.h, 0);
   }

   public void a() {
      this.t = new Item[Char.gI().arrItemBag.length];
      int var1 = 0;

      for(int var2 = 0; var2 < Char.gI().arrItemBag.length; ++var2) {
         if (Char.gI().arrItemBag[var2] != null && Char.gI().arrItemBag[var2].r()) {
            this.t[var1] = Char.gI().arrItemBag[var2];
            ++var1;
         }
      }

   }

   public void a(int var1) {
      super.a(var1);
      this.f = false;
   }

   public void b() {
      super.b();
      if (this.k() == 0) {
         int var3;
         if (!this.f) {
            if (this.a[0] == null) {
               for(var3 = 0; var3 < this.b.length; ++var3) {
                  if (this.b[var3] != null) {
                     this.a(this.b[var3]);
                     break;
                  }
               }
            } else {
               boolean var1 = false;

               for(int var2 = 0; var2 < this.b.length; ++var2) {
                  if (this.b[var2] != null && this.b[var2].equals(this.a[0])) {
                     var1 = true;
                     break;
                  }
               }

               if (!var1) {
                  this.a((Item)null);
               } else {
                  boolean var4 = false;

                  for(var3 = 0; var3 < this.b.length; ++var3) {
                     if (this.b[var3] != null) {
                        var4 = true;
                     }
                  }

                  if (!var4) {
                     this.a((Item)null);
                  }
               }
            }
         }

         for(var3 = 0; var3 < this.g.length; ++var3) {
            this.g[var3].a();
         }
      } else {
         this.a();
      }

      if (this.d != null) {
         this.d.p();
         if (this.d.r()) {
            this.d = null;
         }
      }

   }

   public void a(Graphics var1) {
      if (this.j() <= 0) {
         this.a(var1, this.cx, this.cy, this.width, this.height, Caption.q, (byte)2, this.r);
      } else {
         super.a(var1);
      }

      if (this.k() == 0) {
         mFont.b(mFont.d, var1, Caption.nE, 14, this.a_() + 9, 0, -10831436, -16777216);
         if (this.f) {
            if (DataCenter.gI().i % 20 > 12) {
               mFont.b(mFont.d, var1, Caption.nI, 149, this.a_() + 108, 0, -2560, -16777216);
            }
         } else if (this.e != null) {
            mFont.b(mFont.d, var1, Utlis.replaceAll(Caption.nG, "" + this.e.level * 6), 149, this.a_() + 108, 0, -30976, -16777216);
            mFont.b(mFont.d, var1, Caption.nJ, 149, this.a_() + 124, 0, -10831436, -16777216);
            mFont.b(mFont.d, var1, Caption.nK, 149, this.a_() + 140, 0, -10831436, -16777216);
         }

         a(var1, this.g[0].cx, this.g[0].cy, this.e, this.g[0].k >= 0, Caption.I);
         this.a(var1, this.g[2]);

         for(int var2 = 0; var2 < this.g[2].i; ++var2) {
            for(int var3 = 0; var3 < this.g[2].r; ++var3) {
               b(var1, var3 * this.g[2].h, var2 * this.g[2].h, this.b[var2 * this.g[2].r + var3], var2 * this.g[2].i + var3 == this.g[2].k, "");
            }
         }

         this.b(var1);
         if (this.d != null) {
            this.d.b(var1, this.g[0].cx + this.g[0].h / 2, this.g[0].cy + this.g[0].h / 2);
         }
      }

   }

   public Vector c() {
      Vector var1 = super.c();
      if (this.k() == 0) {
         for(int var2 = 0; var2 < this.g.length; ++var2) {
            if (var2 != 1) {
               var1.addElement(this.g[var2].a(1001 + var2, this));
            }
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
            this.a(true);
            return;
         case 1001:
            if (this.a[0] == null) {
               this.a(2);
               DataCenter.gI().currentScreen.showMessage(Caption.nF, -1);
               return;
            }

            this.c = 1;
            this.a(var1.j, var1.j.k);
            this.cL = a(var1, this, this.e);
            return;
         case 1002:
            this.c = 0;
            this.a(var1.j, var1.j.k);
            this.cL = a(var1, this, this.a[1]);
            return;
         case 1003:
            this.c = 0;
            this.a(var1.j, var1.j.k);
            var2 = var1.j.k / 5;
            var3 = var1.j.k % 5;
            this.cL = b(var1, this, this.b[var2 * 4 + var3]);
            return;
         case 2001:
            this.a(false);
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

      for(int var1 = 0; var1 < this.b.length; ++var1) {
         if (this.b[var1] != null) {
            Char.gI().h(this.b[var1].TYPE_TEMP)[this.b[var1].index] = this.b[var1];
            this.b[var1] = null;
         }
      }

   }

   private void a(boolean var1) {
      try {
         if (this.e != null && this.e.level > 0) {
            if (var1) {
               DataCenter.gI().currentScreen.a(Caption.nH, 2001, this);
            } else {
               Message var5 = new Message((byte)-50);
               Vector var2 = new Vector();

               int var3;
               for(var3 = 0; var3 < this.b.length; ++var3) {
                  if (this.b[var3] != null) {
                     if (this.b[var3].id == this.e.id) {
                        var2.insertElementAt(this.b[var3], 0);
                     } else {
                        var2.add(this.b[var3]);
                     }
                  }
               }

               var5.writeByte(var2.size());

               for(var3 = 0; var3 < var2.size(); ++var3) {
                  var5.writeByte(((Item)var2.get(var3)).TYPE_TEMP);
                  var5.writeShort(((Item)var2.get(var3)).index);
               }

               var5.send();
            }
         } else {
            DataCenter.gI().currentScreen.showMessage(Caption.nE, -65536);
         }
      } catch (Exception var4) {
         Utlis.println(var4);
      }
   }

   public void a(Item var1) {
      this.a[0] = var1;
      if (this.a[0] == null) {
         this.e = null;
      } else {
         this.e = this.a[0].a();
         this.e.level = -1;

         for(int var9 = 0; var9 < this.b.length; ++var9) {
            if (this.b[var9] != null) {
               ++this.e.level;
            }
         }

         if (this.e.level < 0) {
            this.e.level = 0;
         }

         Vector var10 = new Vector();
         Vector var2 = new Vector();

         for(int var3 = 0; var3 < this.b.length; ++var3) {
            ItemOption[] var4;
            if (this.b[var3] != null && (var4 = this.b[var3].L()) != null) {
               int var5;
               if (!this.b[var3].equals(this.a[0])) {
                  for(var5 = 0; var5 < DataCenter.gI().ItemOptionTemplate.length; ++var5) {
                     if (DataCenter.gI().ItemOptionTemplate[var5].name.trim().toLowerCase().equals(this.b[var3].getItemTemplate().name.trim().toLowerCase())) {
                        var2.add(new ItemOption(DataCenter.gI().ItemOptionTemplate[var5].id + ",0,0"));
                        break;
                     }
                  }
               }

               for(var5 = 0; var5 < var4.length; ++var5) {
                  boolean var6 = true;

                  for(int var7 = 0; var7 < var10.size(); ++var7) {
                     if (((ItemOption)var10.get(var7)).a[0] == var4[var5].a[0]) {
                        ((ItemOption)var10.get(var7)).c(((ItemOption)var10.get(var7)).a[1] + var4[var5].a[1]);
                        var6 = false;
                        break;
                     }
                  }

                  if (var6) {
                     var10.add(var4[var5]);
                  }
               }
            }
         }

         var10.addAll(var2);
         this.e.strOptions = Item.a(var10);
         this.e.level = (byte)var2.size();
         this.e.isLock = true;
      }
   }
}
