package beatdz;import java.util.Vector;

public class LangLa_gx extends LangLa_cz {
   public LangLa_ii a;
   public LangLa_kd b;
   private LangLa_gw e;
   private Vector[] f;
   private LangLa_cx g;
   private short h = 307;
   private int i;
   private String[][] j;
   public boolean[] c;
   public boolean[] d;

   public LangLa_gx(LangLa_kd var1, int var2, int var3, int var4, int var5, int var6, int var7, LangLa_cx var8) {
      boolean var10 = false;
      byte var16 = 33;
      byte var15 = 87;
      byte var13 = 1;
      LangLa_kd var12 = var1;
      LangLa_gx var11 = this;
      this.setXY(var13, var4);
      DataCenter.gI();
      this.setSize(var15, var6);
      this.i = var2;
      this.g = var8;
      this.b = var1;
      if (var1.c.length * var16 > var6 - 20) {
         var7 = (var6 - 20) / var16 * var16;
      } else {
         var7 = var1.c.length * var16;
      }

      DataCenter.gI();
      this.a = new LangLa_ii((byte)1, 10, 10, var15 - 18, var7, var16, var1.c.length);
      this.e = new LangLa_gw(0, 0, 0, 16, (byte)0, var1.c.length);
      this.f = new Vector[var1.c.length];
      this.j = new String[var1.c.length][];
      this.c = new boolean[var1.c.length];
      this.d = new boolean[var1.c.length];

      for(var3 = 0; var3 < var11.f.length; ++var3) {
         var11.f[var3] = new Vector();
         String[] var14;
         if ((var14 = var12.c[var3].trim().split(" ")).length >= 3 && !var12.c[var3].contains("\n")) {
            var11.j[var3] = new String[2];
            StringBuilder var10000;
            String[] var10002;
            if (var14.length >= 4) {
               var11.j[var3][0] = var14[0] + " " + var14[1];
               var11.j[var3][1] = "";

               for(var5 = 2; var5 < var14.length; ++var5) {
                  var10000 = new StringBuilder();
                  var10002 = var11.j[var3];
                  var10002[1] = var10000.append(var10002[1]).append(var14[var5]).append(" ").toString();
               }

               var11.j[var3][1] = var11.j[var3][1].trim();
            } else {
               var11.j[var3][0] = var14[0];
               var11.j[var3][1] = "";

               for(var5 = 1; var5 < var14.length; ++var5) {
                  var10000 = new StringBuilder();
                  var10002 = var11.j[var3];
                  var10002[1] = var10000.append(var10002[1]).append(var14[var5]).append(" ").toString();
               }

               var11.j[var3][1] = var11.j[var3][1].trim();
            }
         } else {
            var11.j[var3] = mFont.c(mFont.e, var12.c[var3], var15 - 10);
         }
      }

   }

   public void a() {
      this.a.a();
      this.e.a();
   }

   public LangLa_jz b() {
      return this.a.a(this.b.a, this.cx, this.cy, this.g);
   }

   public int c() {
      return this.cx + this.width;
   }

   public void a(int var1) {
      if (!this.d[var1]) {
         this.b.b = var1;

         for(var1 = 0; var1 < this.f.length; ++var1) {
            for(int var2 = 0; var2 < this.f[var1].size(); ++var2) {
               this.g.cG.removeElement(this.f[var1].elementAt(var2));
            }
         }

         for(var1 = 0; var1 < this.f[this.b.b].size(); ++var1) {
            this.g.cG.addElement(this.f[this.b.b].elementAt(var1));
         }

      }
   }

   public void a(Graphics var1, int var2) {
      DataCenter.gI();
      int var3 = var1.a;
      int var4 = var1.b;
      this.a(var1, this.g.cx + this.cx, this.g.cy + this.cy);
      this.a(var1, this.width + 1, 6, this.i - this.width - 8, this.height - 12, var2, 55, 56);
      if (!this.e.a && this.b.c.length * this.a.h <= this.height - 20) {
         this.a.b(var1, this.g.cx + this.cx, this.g.cy + this.cy, this.a.width + 6, this.a.height);
      } else {
         this.a.a(var1, this.g.cx + this.cx, this.g.cy + this.cy, this.a.width + 6, this.a.height);
      }

      for(var2 = 0; var2 < this.b.c.length; ++var2) {
         if (this.a.b(var2) && !this.d[var2]) {
            if (var2 == this.b.b) {
               var1.c(-2908119);
            }

            LangLa_fq.a(var1, this.h, 0, this.e.a(var2) + this.a.width / 2 + 1, var2 * this.a.h + this.a.h / 2, 3);
            var1.c();
            int var5 = var2 * this.a.h + this.a.h / 2 - 1;
            if (this.j[var2].length >= 2) {
               var5 -= 5;
            }

            for(int var6 = 0; var6 < this.j[var2].length; ++var6) {
               if (var2 == this.b.b) {
                  mFont.a((mFont)mFont.f, (Graphics)var1, this.j[var2][var6], this.a.width / 2, var5 + var6 * 10, 2, -16427443, 0);
               } else if (this.a.l == var2) {
                  mFont.a((mFont)mFont.f, (Graphics)var1, this.j[var2][var6], this.a.width / 2 + 1, var5 + var6 * 10 + 1, 2, -11131643, 0);
               } else {
                  mFont.a((mFont)mFont.f, (Graphics)var1, this.j[var2][var6], this.a.width / 2, var5 + var6 * 10, 2, -11131643, 0);
               }
            }

            if (this.c[var2]) {
               LangLa_fq.a(var1, 713, 0, this.e.a(var2) + this.width - 28, var2 * this.a.h + 3, 0);
            }
         }
      }

      if (this.e.a || this.b.c.length * this.a.h > this.height - 20) {
         this.a(var1, 0, 0);
         var1.setClip(0, 0, DataCenter.gI().widthScreen, DataCenter.gI().heightScreen);
      }

      this.a(var1, var3, var4);
   }

   public void a(LangLa_cs var1, int var2) {
      this.f[var2].addElement(var1);
   }

   public void a(Vector var1, int var2) {
      for(int var3 = 0; var3 < var1.size(); ++var3) {
         this.f[var2].addElement((LangLa_cs)var1.elementAt(var3));
      }

   }

   public void d() {
      for(int var1 = 0; var1 < this.f.length; ++var1) {
         for(int var2 = 0; var2 < this.f[var1].size(); ++var2) {
            this.g.cG.removeElement(this.f[var1].elementAt(var2));
         }
      }

   }

   public void a(boolean var1) {
      for(int var3 = 0; var3 < this.f.length; ++var3) {
         for(int var4 = 0; var4 < this.f[var3].size(); ++var4) {
            LangLa_cs var2;
            if ((var2 = (LangLa_cs)this.f[var3].elementAt(var4)) instanceof LangLa_dz) {
               ((LangLa_dz)var2).b(var1);
            } else if (var2 instanceof mTextBox) {
               var2.a(var1);
            } else if (var2 instanceof LangLa_cl) {
               var2.b(var1);
            }
         }
      }

   }
}
