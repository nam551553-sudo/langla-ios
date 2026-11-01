package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_bu extends LangLa_kj {
   public Item[] a = new Item[2];
   public Item[] b = new Item[16];
   private LangLa_ij[] g = new LangLa_ij[3];
   private LangLa_dz h;
   public int c;
   public boolean d;
   public LangLa_jw e;
   private int i;
   public LangLa_cg f;
   private Vector u = new Vector();
   private String v = "";

   public LangLa_bu(MainScreen var1) {
      super(var1, new String[]{Caption.rx[6], Caption.H});
      this.g[0] = new LangLa_ij((byte)1, 162, this.a_() + 20, 30, 30, 30, 1, 1);
      this.g[1] = new LangLa_ij((byte)1, 242, this.a_() + 20, 30, 30, 30, 1, 1);
      this.g[2] = new LangLa_ij((byte)1, 14, this.a_() + 20, 128, 128, 32, 4, 4);
      this.h = this.a(this.width - 70, this.height - 33, Caption.t, this, 0, -8);
      this.a(this.h, 0);
      LangLa_kd var3 = new LangLa_kd(1004, new String[]{""});
      this.f = this.a(149, this.a_() + 125, 100, var3.c.length, var3, this, 1);
      this.f.b(true);
      this.f.a(0);
      this.a(this.f, 0);
   }

   public void a() {
      this.t = new Item[Char.gI().arrItemBag.length];
      int var1 = 0;

      for(int var2 = 0; var2 < Char.gI().arrItemBag.length; ++var2) {
         if (Char.gI().arrItemBag[var2] != null && Char.gI().arrItemBag[var2].y()) {
            this.t[var1] = Char.gI().arrItemBag[var2];
            ++var1;
         }
      }

   }

   public void a(int var1) {
      super.a(var1);
      if (this.d) {
         this.d = false;
         this.b[1] = null;
      }

   }

   public void b() {
      super.b();
      if (this.k() == 0) {
         int var1;
         if (!this.d) {
            for(var1 = 0; var1 < this.b.length; ++var1) {
               this.b[var1] = null;
            }

            this.i = 0;
            if (this.a[0] == null) {
               this.a[1] = null;
            } else {
               this.a[1] = this.a[0].a();
               ItemOption[] var11;
               if ((var11 = this.a[1].L()) != null) {
                  Vector var2 = new Vector();
                  Vector var3 = new Vector();
                  int var4 = 0;
                  ItemOption var5 = null;

                  int var6;
                  for(var6 = 0; var6 < var11.length; ++var6) {
                     if (var11[var6].a[0] == 298) {
                        var5 = var11[var6];
                     }

                     int var7;
                     if ((var7 = var11[var6].h()) < 0 || this.f.b.b != 0 && (Integer)this.u.get(this.f.b.b) != var7) {
                        if (var11[var6].getItemOptionTemplate().type == 8) {
                           ++var4;
                        }

                        var2.add(var11[var6]);
                     } else {
                        int var8 = var11[var6].a[3];
                        int var9 = 0;

                        for(int var10 = 0; var10 <= var8; ++var10) {
                           var9 += DataCenter.gI().ngocKhamUpgrade[var10];
                        }

                        var3.add(new Item(var7, true, var9));
                     }
                  }

                  if (var5 != null) {
                     var5.c(var4);
                  }

                  this.a[1].strOptions = Item.a(var2);

                  for(var6 = 0; var6 < var3.size(); ++var6) {
                     this.i += ((Item)var3.get(var6)).getAmount();
                     if (var6 >= this.b.length) {
                        break;
                     }

                     this.b[var6] = (Item)var3.elementAt(var6);
                  }
               }

               if (this.f.b.b != 0) {
                  this.i = (int)((double)this.i * 1.3D);
               }

               if (this.i > 600) {
                  this.i = 600;
               }
            }
         }

         for(var1 = 0; var1 < this.g.length; ++var1) {
            this.g[var1].a();
         }
      }

      if (this.e != null) {
         this.e.p();
         if (this.e.r()) {
            this.e = null;
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
         mFont.b(mFont.d, var1, Caption.do_, 14, this.a_() + 9, 0, -10831436, -16777216);
         a(var1, this.g[0].cx, this.g[0].cy, this.a[0], this.g[0].k >= 0, Caption.H);
         a(var1, this.g[1].cx, this.g[1].cy, this.a[1], this.g[1].k >= 0, Caption.I);
         LangLa_fq.a(var1, 95, 0, 210 - DataCenter.gI().i / 3 % 3, this.a_() + 25, 20);
         if (this.a[0] != null) {
            mFont.b(mFont.d, var1, Caption.cu + this.i + Caption.cw, 149, this.a_() + 108, 0, -30976, -16777216);
         }

         this.a(var1, this.g[2]);

         for(int var2 = 0; var2 < this.g[2].i; ++var2) {
            for(int var3 = 0; var3 < this.g[2].r; ++var3) {
               b(var1, var3 * this.g[2].h, var2 * this.g[2].h, this.b[var2 * this.g[2].r + var3], var2 * this.g[2].i + var3 == this.g[2].k, "");
            }
         }

         this.b(var1);
         if (this.e != null) {
            this.e.b(var1, this.g[1].cx + this.g[1].h / 2, this.g[1].cy + this.g[1].h / 2);
            return;
         }
      } else {
         this.a();
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
            this.a(true);
            return;
         case 1001:
            this.c = 1;
            this.a(var1.j, var1.j.k);
            this.cL = a(var1, this, this.a[0]);
            if (this.a[0] == null) {
               this.a(2);
               DataCenter.gI().currentScreen.showMessage(Caption.mv, -1);
               return;
            }
            break;
         case 1002:
            this.c = 0;
            this.a(var1.j, var1.j.k);
            this.cL = a(var1, this, this.a[1]);
            return;
         case 1003:
            this.c = 0;
            this.a(var1.j, var1.j.k);
            this.cL = a(var1, this, this.b[var1.j.k]);
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
      if (this.a[0] != null) {
         Char.gI().h(this.a[0].TYPE_TEMP)[this.a[0].index] = this.a[0];
         this.a[0] = null;
      }

   }

   public void e() {
      if (this.a[0] == null) {
         this.f.b(true);
      } else {
         this.u.clear();
         this.u.add(-1);
         ItemOption[] var1 = this.a[0].L();
         Vector var2 = new Vector();

         for(int var3 = 0; var3 < var1.length; ++var3) {
            if (var1[var3].getItemOptionTemplate().type == 8) {
               this.u.add(var1[var3].h());
               var2.add(DataCenter.gI().ItemTemplate[var1[var3].h()].name);
            }
         }

         String[] var6;
         (var6 = new String[var2.size() + 1])[0] = Caption.pq;

         int var4;
         for(var4 = 0; var4 < var2.size(); ++var4) {
            var6[var4 + 1] = (String)var2.get(var4);
         }

         if ((var4 = var6.length) > 5) {
            var4 = 5;
         }

         LangLa_kd var5 = new LangLa_kd(1004, var6);
         this.f.a(var5, var4);
         this.f.a(0);
         this.f.b(false);
      }
   }

   private void a(boolean var1) {
      try {
         if (this.d) {
            DataCenter.gI().currentScreen.showMessage(Caption.iE, -1);
         } else if (this.a[0] == null) {
            DataCenter.gI().currentScreen.showMessage(Caption.iF, -65536);
         } else if (var1) {
            DataCenter.gI().currentScreen.a(Utlis.replaceAll(Caption.iO, "" + this.i), 2001, this);
         } else {
            Message var4;
            (var4 = new Message((byte)-47)).writeByte(this.a[0].TYPE_TEMP);
            var4.writeShort(this.a[0].index);
            var4.writeShort((Integer)this.u.get(this.f.b.b));
            var4.send();
         }
      } catch (Exception var3) {
         Utlis.println(var3);
      }
   }
}
