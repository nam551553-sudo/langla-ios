package beatdz;
import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_aj extends LangLa_ge {
   private LangLa_ij u;
   private LangLa_ij v;
   private LangLa_dz w;
   private LangLa_dz x;
   private LangLa_dz y;
   public int a = 0;
   public int b = 0;
   public int c = 0;
   public int d = 0;
   private int z = 32;
   public Item[] e = new Item[12];
   public Item[] f = new Item[12];
   public String g = "";
   public long h = Utlis.time() + 6000L;
   public int i;

   public LangLa_aj(MainScreen var1, String var2) {
      super(var1, new String[]{Caption.bA});
      this.g = var2;
      this.w = this.a(this.width / 2 - 29, this.height - 31, Caption.bE, this, 1001, -8);
      this.x = this.a(this.width - 70, this.height - 33, Caption.bB, this, 1002, -8);
      this.u = new LangLa_ij((byte)1, 7, this.a_() + this.z / 2, this.z * 4, this.z * 4, this.z, Utlis.c(this.e.length, 4), 4);
      this.v = new LangLa_ij((byte)1, 7 + 5 * this.z, this.a_() + this.z / 2, this.z * 4, this.z * 4, this.z, Utlis.c(this.f.length, 4), 4);
      this.y = this.a(112, 145, "", this, 1002, 288);
      this.a(this.y, 0);
      this.a(this.w, 0);
      this.a(this.x, this.j());
      this.a(0);
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      super.a(var1, var2, var3);
      if (this.k() == 0) {
         switch(var1.b) {
         case 1001:
            LangLa_aj var6 = this;

            try {
               if (var6.a == 0) {
                  var6.a = 1;
                  Vector var8 = new Vector();

                  int var4;
                  for(var4 = 0; var4 < var6.e.length; ++var4) {
                     if (var6.e[var4] != null) {
                        var8.add(var6.e[var4]);
                     }
                  }

                  Message var7;
                  (var7 = new Message((byte)82)).writeInt(var6.c);
                  var7.writeByte(var8.size());

                  for(var4 = 0; var4 < var8.size(); ++var4) {
                     var7.writeShort(((Item)var8.elementAt(var4)).index);
                  }

                  var7.send();
                  if (var6.a == var6.b) {
                     var6.h = Utlis.time() + 5999L;
                  }

                  return;
               }

               if (var6.a == 1 && var6.b > 0 && var6.h < Utlis.time() + 999L) {
                  var6.a = 2;
                  (new Message((byte)81)).send();
               }
               break;
            } catch (Exception var5) {
               Utlis.println(var5);
               return;
            }
         case 1002:
            if (this.a == 0 && this.c > 0) {
               Char var10000 = Char.gI();
               var10000.bac += this.c;
               this.c = 0;
            }

            return;
         case 5001:
            this.i = 1;
            this.cL = a(var1, this, this.e[var1.j.k]);
            return;
         case 5002:
            this.i = 2;
            this.cL = a(var1, this, this.f[var1.j.k]);
         }

         return;
      } else if (this.k() == this.j()) {
         switch(var1.b) {
         case 1002:
            this.p.a((LangLa_cx)(new LangLa_k(this.p, this)));
         }
      }

   }

   public void a(int var1) {
      super.a(var1);
      this.b(this.x);
      if (var1 == this.j()) {
         if (this.a == 0) {
            this.a(this.x);
         }

         this.b(this.o);
         this.b(this.s);
      }

   }

   public void d() {
      super.d();

      for(int var1 = 0; var1 < this.e.length; ++var1) {
         if (this.e[var1] != null) {
            int var10001 = this.e[var1].index;
            Char.gI().arrItemBag[var10001] = this.e[var1];
            this.e[var1] = null;
         }
      }

      try {
         (new Message((byte)83)).send();
      } catch (Exception var2) {
         Utlis.println(var2);
      }
   }

   public void a(int var1, Object var2) {
   }

   public void a(Graphics var1) {
      super.a(var1);
      if (this.k() == 0) {
         this.b(var1, this.u);

         int var2;
         int var3;
         for(var2 = 0; var2 < this.u.i; ++var2) {
            for(var3 = 0; var3 < this.u.r; ++var3) {
               b(var1, var3 * this.u.h, var2 * this.u.h, this.e[var2 * this.u.r + var3], var2 * this.u.r + var3 == this.u.k);
               if (this.a > 0) {
                  Binary2.a(var1, -13, 0, var3 * this.u.h + 2, var2 * this.u.h + 2, 25, (int)25);
               }
            }
         }

         this.b(var1, this.v);

         for(var2 = 0; var2 < this.v.i; ++var2) {
            for(var3 = 0; var3 < this.v.r; ++var3) {
               b(var1, var3 * this.v.h, var2 * this.v.h, this.f[var2 * this.v.r + var3], var2 * this.v.r + var3 == this.v.k);
               if (this.b > 0) {
                  Binary2.a(var1, -13, 0, var3 * this.v.h + 2, var2 * this.v.h + 2, 25, (int)25);
               }
            }
         }

         this.a(var1, this.cx + 4, this.cy + this.a_());

         for(var2 = 0; var2 < 3; ++var2) {
            LangLa_fq.a(var1, 10, 0, 27 + var2 * 30, this.a_() + this.G() - 64, 6);
            LangLa_fq.a(var1, 10, 0, 188 + var2 * 30, this.a_() + this.G() - 64, 6);
            if (this.a >= var2) {
               LangLa_fq.a(var1, 11, 0, 31 + var2 * 30, this.a_() + this.G() - 64, 6);
            }

            if (this.b >= var2) {
               LangLa_fq.a(var1, 11, 0, 192 + var2 * 30, this.a_() + this.G() - 64, 6);
            }
         }

         LangLa_fq.b(var1, 26, 27, 3, 112, 125, 21);
         a(var1, 3, 122, "", (byte)0);
         mFont.b(mFont.d, var1, Utlis.numberFormat(this.c), 30, 122, 20, -3089954, -16777216);
         LangLa_fq.b(var1, 26, 27, 163, 112, 125, 21);
         a(var1, 163, 122, "", (byte)0);
         mFont.b(mFont.d, var1, Utlis.numberFormat(this.d), 190, 122, 20, -3089954, -16777216);
         mFont.b(mFont.d, var1, Char.gI().name, (super.width - 8) / 4 - 5, 7, 2, -1, -16777216);
         mFont.b(mFont.d, var1, this.g, 3 * (super.width - 8) / 4 - 10 + this.z / 2, 7, 2, -1, -16777216);
      }

   }

   public void b() {
      super.b();
      if (this.k() == 0) {
         if (this.a > 0) {
            this.b(this.y);
            this.b(this.x);
         }

         this.u.a();
         this.v.a();
      }

      if (this.a > 0 && this.b > 0) {
         long var1 = Utlis.time();
         String var2;
         if (this.h > var1 + 1000L) {
            LangLa_dz var10000 = this.w;
            var2 = Utlis.replaceAll(Caption.bF, "" + (this.h - var1) / 1000L);
            var10000.a = var2;
            this.w.a(true);
         } else {
            var2 = Caption.aP;
            this.w.a = var2;
            this.w.a(false);
         }
      } else if (this.a > 0) {
         this.w.a(true);
      }

      if (this.a >= 2) {
         this.w.u = true;
      }

   }

   public Vector c() {
      Vector var1 = super.c();
      if (this.k() == 0) {
         var1.addElement(this.u.a(5001, this));
         var1.addElement(this.v.a(5002, this));
      }

      return var1;
   }

   public int e() {
      return this.k();
   }
}
