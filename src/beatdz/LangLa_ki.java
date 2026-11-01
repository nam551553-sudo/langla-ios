package beatdz;import com.tgame.model.Caption;

public class LangLa_ki extends LangLa_cg {
   public LangLa_ki(int var1, int var2, int var3, int var4, int var5, LangLa_kd var6, LangLa_cx var7, boolean var8) {
      super(var1, var2, 20, var5, var6, var7, 1, true);
      this.i = new String[var6.c.length];
      this.setXY(var1, var2);
      this.c = 100;
      this.d = var5 * this.h;

      for(var1 = 0; var1 < this.i.length; ++var1) {
         this.i[var1] = "";
         mFont.b(mFont.d, var6.c[var1]);
      }

   }

   public void a(Graphics var1) {
      if (this.b.b < 0 || this.b.b >= this.b.d.length) {
         this.b.b = 0;
      }

      short var2 = this.b.d[this.b.b];
      if (this.n(0)) {
         var1.e(30);
      }

      LangLa_fq.a(var1, var2, 0, this.d() - 1, 2, 24);
      var1.d();
      if (this.j) {
         Binary2.a(var1, -16, 0, this.a.cx, this.a.cy, this.a.width, (int)this.a.height);
         this.a(var1, this.a);
         byte var5 = 0;

         try {
            for(int var6 = 0; var6 < this.b.c.length; ++var6) {
               if (this.a.b(var6)) {
                  if (var6 == this.a.k) {
                     Binary2.a(var1, -7, 0, 0, var6 * this.a.h, this.a.width, (int)this.a.h);
                  }

                  if (var6 == this.a.l) {
                     LangLa_fq.a(var1, this.b.d[var6], 0, 11, 1 + var6 * this.a.h + this.a.h / 2, 3);
                     mFont.b(mFont.d, var1, this.b.c[var6], 26, 0 + var6 * this.a.h + this.a.h / 2, 0, -1, -11184811);
                  } else {
                     LangLa_fq.a(var1, this.b.d[var6], 0, 10, var6 * this.a.h + this.a.h / 2, 3);
                     mFont.b(mFont.d, var1, this.b.c[var6], 25, -1 + var6 * this.a.h + this.a.h / 2, 0, -1, -11184811);
                  }

                  if (var6 == 8) {
                     LangLa_fq.a(var1, 752 + DataCenter.gI().i / 10 % 4, 0, this.a.width - 3, 2 + var6 * this.a.h + this.a.h / 2 - 3, 10);
                  }
               }
            }
         } catch (Exception var4) {
            Utlis.println("loiiii: " + this.b.d.length + ", " + this.b.c.length + ", iii: " + var5);
            Utlis.println(var4);
         }

         this.b(var1);
      }

   }

   public void a(LangLa_jz var1, int var2, int var3) {
      if (this.e <= 0) {
         try {
            switch(var1.b) {
            case -1002:
               if (var1.j.k >= 0) {
                  this.e = 4;
                  if (this.a.k == 7) {
                     GameSrc.gI().showMessage(Caption.oI, -3407617);
                     break;
                  } else if (this.a.k == 8) {
                     GameSrc.gI().showMessage(Caption.nD, -7812062);
                  }
               }
            default:
               return;
            case -1001:
               this.a();
               break;
            case -1000:
               this.j = true;
               this.setSize(this.c, this.d);
               if (this.a == null) {
                  if (this.f == 0) {
                     this.a = new LangLa_ii((byte)1, 0, 21, this.width, this.height - this.h, this.h, this.b.c.length);
                  } else if (this.f == 1) {
                     this.a = new LangLa_ii((byte)1, 0, 21 - this.height, this.width, this.height - this.h, this.h, this.b.c.length);
                  }
               }

               if (this.a.j < 0 || this.a.j >= this.b.c.length || this.a.j > this.b.b + this.g / 2 + 1 || this.a.j < this.b.b - (this.g / 2 + 1)) {
                  this.a.a(this.b.b);
               }

               this.a.k = this.b.b;
            }
         } catch (Exception var4) {
         }

      }
   }

   public void a(byte var1) {
      this.b.b = var1;
   }

   public byte e() {
      if (this.b.b >= 8) {
         return 9;
      } else {
         return this.b.b >= 7 ? 8 : (byte)this.b.b;
      }
   }
}
