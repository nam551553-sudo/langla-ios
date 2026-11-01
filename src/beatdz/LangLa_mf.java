package beatdz;
import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_mf extends LangLa_fo {
   public LangLa_dz[] a;
   private LangLa_ii[] b;
   private int c;
   private LangLa_ii d;
   private Vector e;
   private int f;

   public LangLa_mf(Vector var1, MainScreen var2, int var3) {
      this.p = var2;
      this.c = 1014;
      this.r = false;
      this.a(200, 200);
      this.e = var1;
      this.d = new LangLa_ii((byte)1, 10, this.a_() + 5, this.width - 18, 156, 26, var1.size());
      this.a = new LangLa_dz[var1.size()];
      this.b = new LangLa_ii[var1.size()];

      for(int var4 = 0; var4 < this.a.length; ++var4) {
         this.a[var4] = new LangLa_dz(this.width - 52, var4 * this.d.h + 4, 0, 0, Caption.os, this, 3000 + var4, 15);
         this.a[var4].setSize(30, 18);
         this.b[var4] = new LangLa_in((byte)1, this.a[var4].cx, this.a[var4].cy, this.a[var4].width, this.a[var4].height, this.a[var4].height, 1, this.d);
      }

   }

   public void d() {
      super.d();
   }

   public Vector c() {
      Vector var1 = super.c();

      for(int var4 = 0; var4 < this.a.length; ++var4) {
         int var2 = this.d.cx + this.a[var4].cx;
         int var3 = this.d.cy + this.a[var4].cy - this.d.f;
         if (Utlis.inRange(this.d.cx, this.d.cy, this.d.cx + this.d.width, this.d.cy + this.d.height, var2, var3) && Utlis.inRange(this.d.cx, this.d.cy, this.d.cx + this.d.width, this.d.cy + this.d.height, var2 + this.a[var4].width, var3 + this.a[var4].height)) {
            this.b[var4].cx = (short)var2;
            this.b[var4].cy = (short)var3;
            var1.addElement(new LangLa_jz(3000 + var4, this.b[var4].cx, this.b[var4].cy, this.b[var4].cx + this.b[var4].width, this.b[var4].cy + this.b[var4].height, this.b[var4], this));
         }
      }

      var1.addElement(this.d.a(1002, this));
      return var1;
   }

   public void a(Graphics var1) {
      this.a(var1, this.cx, this.cy, this.width, this.height, Caption.om, (byte)2, this.r);
      this.a(var1, this.d);
      int var2 = var1.a;
      int var3 = var1.b;

      for(int var4 = 0; var4 < this.d.i; ++var4) {
         if (this.d.b(var4)) {
            try {
               String[] var5 = (String[])((String[])this.e.elementAt(var4));
               this.a(var1, 0, var4 * this.d.h + 1, this.d.width, 24, -13, 84, 5, 1, 1);
               int var6 = 8;
               int var7 = var4 * this.d.h + 12;
               if (var4 == this.d.l) {
                  ++var6;
                  ++var7;
               }

               String[] var8;
               if (!(var8 = mFont.c(mFont.d, var5[0], this.d.width - 60))[0].equals(var5[0])) {
                  mFont.a(mFont.d, var1, var8[0] + "...", var6, var7, 0, -1);
               } else {
                  mFont.a(mFont.d, var1, var8[0], var6, var7, 0, -1);
               }

               this.a(var1, var2 + this.a[var4].cx, var3 + this.a[var4].cy);
               this.a[var4].a(var1);
               this.a(var1, var2, var3);
            } catch (Exception var9) {
            }
         }
      }

      this.b(var1);
   }

   public void b() {
      this.d.a();
      if (this.f > 0) {
         --this.f;
         if (this.f == 0) {
            this.J();
            if (this.c == -1) {
               this.p.b(1014, (Object)null, this);
            } else {
               this.p.b(1014, this.e.get(this.c), this);
            }
         }
      }

      for(int var1 = 0; var1 < this.a.length; ++var1) {
         this.a[var1].b();
         this.a[var1].b();
         if (this.b[var1].l != -1) {
            this.a[var1].h = true;
         } else {
            this.a[var1].h = false;
         }
      }

   }

   public void a(LangLa_jz var1, int var2, int var3) {
      if (this.f <= 0) {
         super.a(var1, var2, var3);
         if (var1.b >= 3000 & var1.b < 4000) {
            this.e.remove(var1.b - 3000);
            LangLa_mf var10 = this;
            Writer var11 = null;
            boolean var7 = false;

            label123: {
               label122: {
                  try {
                     var7 = true;
                     (var11 = new Writer()).writeShort(var10.e.size());

                     for(var3 = 0; var3 < var10.e.size(); ++var3) {
                        String[] var4 = (String[])((String[])var10.e.elementAt(var3));
                        var11.writeUTF(Utlis.encodeString(var4[0]));
                        var11.writeUTF(Utlis.encodeString(var4[1]));
                     }

                     var11.close("arr_acc");
                     var7 = false;
                     break label122;
                  } catch (Exception var8) {
                     Utlis.println(var8);
                     var7 = false;
                  } finally {
                     if (var7) {
                        if (var11 != null) {
                           var11.close();
                        }

                     }
                  }

                  if (var11 != null) {
                     var11.close();
                  }
                  break label123;
               }

               var11.close();
            }

            if (this.e.size() == 0) {
               this.f = 4;
               this.c = -1;
            }

         } else {
            switch(var1.b) {
            case 1002:
               if (var1.j.k >= 0) {
                  this.f = 4;
                  this.c = var1.j.k;
               }
            default:
            }
         }
      }
   }

   public void a(int var1, Object var2, LangLa_cy var3) {
   }

   public void a(int var1, Object var2) {
   }
}
