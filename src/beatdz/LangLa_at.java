package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_at extends LangLa_kj {
   public Item a;
   public Item[] b = new Item[2];
   private LangLa_ij[] f = new LangLa_ij[2];
   private LangLa_dz g;
   public int c;
   public int d = 0;
   public LangLa_jw e;

   public LangLa_at(MainScreen var1) {
      super(var1, new String[]{Caption.bW, Caption.H});
      this.f[0] = new LangLa_ij((byte)1, 124, this.a_() + 20, 30, 30, 30, 1, 1);
      this.f[1] = new LangLa_ij((byte)1, 14, this.a_() + 20, 96, 96, 32, 1, 2);
      this.g = this.a(this.width - 70, this.height - 33, Caption.jR, this, 0, -8);
      this.a(this.g, 0);
   }

   public void a(int var1) {
      super.a(var1);
      if (this.a != null) {
         this.a = null;
      }

   }

   public void b() {
      super.b();
      if (this.k() == 0 && this.a == null) {
         Item var1 = null;
         int var2 = 0;

         for(int var3 = 0; var3 < this.b.length; ++var3) {
            if (this.b[var3] != null) {
               ++var2;
               if (var1 == null || this.b[var3].getItemTemplate().levelNeed > var1.getItemTemplate().levelNeed) {
                  var1 = this.b[var3];
               }
            }
         }

         if (var2 >= 2 && Utlis.positive(this.b[0].getItemTemplate().levelNeed - this.b[1].getItemTemplate().levelNeed) == 20) {
            this.a = var1.a();
            ItemOption[] var8 = this.a.L();
            Vector var6 = new Vector();
            ItemOption var7 = null;

            for(int var4 = 0; var4 < var8.length; ++var4) {
               if (var8[var4].a[0] == 128) {
                  var7 = var8[var4];
               }

               var6.add(var8[var4]);
            }

            ItemOption var9 = var8[var8.length - 1];
            if (this.a.getItemTemplate().levelNeed == 35) {
               if (var9.getItemOptionTemplate().type == 3) {
                  var6.add(new ItemOption("144,50,50"));
               } else {
                  var6.add(new ItemOption("143,15,15"));
               }

               if (var9.getItemOptionTemplate().type != 4) {
                  var7.e(var7.f() + 1000);
                  this.a.strOptions = Item.a(var6);
               }
            } else if (this.a.getItemTemplate().levelNeed == 49) {
               if (var9.getItemOptionTemplate().type == 4) {
                  var6.add(new ItemOption("145,10,10"));
               } else if (var9.getItemOptionTemplate().type == 3) {
                  var6.add(new ItemOption("144,80,80"));
               } else {
                  var6.add(new ItemOption("143,25,25"));
               }

               if (var9.getItemOptionTemplate().type != 5) {
                  var7.e(var7.f() + 1000);
                  this.a.strOptions = Item.a(var6);
               }
            }
         }
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

   public void a(Graphics var1) {
      if (this.j() <= 0) {
         this.a(var1, this.cx, this.cy, this.width, this.height, Caption.q, (byte)2, this.r);
      } else {
         super.a(var1);
      }

      if (this.k() == 0) {
         mFont.b(mFont.d, var1, Caption.jS, 14, this.a_() + 9, 0, -10831436, -16777216);
         a(var1, this.f[0].cx, this.f[0].cy, this.a, this.f[0].k >= 0, Caption.aa);
         LangLa_fq.a(var1, 95, 0, 92 - DataCenter.gI().i / 3 % 3, this.a_() + 25, 20);
         if (this.d > 0 && this.d % 14 > 2) {
            mFont.b(mFont.d, var1, Caption.jT, 14, this.a_() + 125, 0, -2560, -16777216);
         }

         mFont.b(mFont.d, var1, Caption.jU, 14, this.a_() + 65, 0, -1, -16777216);
         mFont.b(mFont.d, var1, Caption.jV, 14, this.a_() + 80, 0, -1, -16777216);
         mFont.b(mFont.d, var1, Caption.jW, 14, this.a_() + 95, 0, -1, -16777216);
         this.a(var1, this.f[1]);

         for(int var2 = 0; var2 < this.f[1].i; ++var2) {
            for(int var3 = 0; var3 < this.f[1].r; ++var3) {
               if (var3 % 2 == 0) {
                  b(var1, var3 * this.f[1].h, var2 * this.f[1].h, this.b[var2 * this.f[1].r + var3], var2 * this.f[1].i + var3 == this.f[1].k, Caption.sc[0]);
               } else {
                  b(var1, var3 * this.f[1].h, var2 * this.f[1].h, this.b[var2 * this.f[1].r + var3], var2 * this.f[1].i + var3 == this.f[1].k, Caption.sc[1]);
               }
            }
         }

         this.b(var1);
         if (this.e != null) {
            this.e.b(var1, this.f[0].cx + this.f[0].h / 2, this.f[0].cy + this.f[0].h / 2);
         }
      }

   }

   public Vector c() {
      Vector var1 = super.c();
      if (this.k() == 0) {
         for(int var2 = 0; var2 < this.f.length; ++var2) {
            var1.addElement(this.f[var2].a(1001 + var2, this));
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
            this.c = 0;
            this.a(var1.j, var1.j.k);
            this.cL = a(var1, this, this.a);
            return;
         case 1002:
            this.c = 1;
            this.a(var1.j, var1.j.k);
            this.cL = a(var1, this, this.b[var1.j.k]);
            return;
         case 2001:
            this.a(false);
         }
      }

   }

   private void a(LangLa_ii var1, int var2) {
      for(int var3 = 0; var3 < this.f.length; ++var3) {
         this.f[var3].k = -1;
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
         if (var1) {
            DataCenter.gI().currentScreen.a(Caption.jX, 2001, this);
         } else {
            Message var5 = new Message((byte)-96);
            int var2 = 0;

            int var3;
            for(var3 = 0; var3 < this.b.length; ++var3) {
               if (this.b[var3] != null) {
                  ++var2;
               }
            }

            var5.writeByte(var2);

            for(var3 = 0; var3 < this.b.length; ++var3) {
               if (this.b[var3] != null) {
                  var5.writeByte(this.b[var3].TYPE_TEMP);
                  var5.writeShort(this.b[var3].index);
               }
            }

            var5.send();
         }
      } catch (Exception var4) {
      }
   }
}
