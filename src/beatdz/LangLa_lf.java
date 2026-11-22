package beatdz;import java.util.Vector;

public class LangLa_lf extends LangLa_cz {
   public LangLa_ii a;
   public LangLa_kd b;
   public LangLa_gw c;
   private Vector[] d;
   private LangLa_cx e;
   private short f = 21;

   public LangLa_lf(LangLa_kd var1, int var2, int var3, int var4, int var5, int var6, LangLa_cx var7) {
      this.a(var1, var2, var3, var4, 23, var6, var7, false);
   }

   public LangLa_lf(LangLa_kd var1, int var2, int var3, int var4, int var5, int var6, LangLa_cx var7, boolean var8) {
      this.a(var1, var2, var3, var4, 23, var6, var7, false);
   }

   private void a(LangLa_kd var1, int var2, int var3, int var4, int var5, int var6, LangLa_cx var7, boolean var8) {
      this.setXY(var2, var3);
      this.setSize(var4, var5);
      this.e = var7;
      this.b = var1;
      if (var1.c.length * var6 > var4 - 4) {
         var4 = (var4 - 4) / var6 * var6;
      } else {
         var4 = var1.c.length * var6;
      }

      this.a = new LangLa_ii((byte)0, 2, 2, var4, var5 - 3, var6, var1.c.length);
      if (!var8) {
         this.c = new LangLa_gw(0, 0, 0, 2, (byte)7, var1.c.length);
      } else {
         this.c = new LangLa_gw(0, 0, 25, 2, (byte)7, var1.c.length);
      }

      this.d = new Vector[var1.c.length];

      for(int var9 = 0; var9 < this.d.length; ++var9) {
         this.d[var9] = new Vector();
      }

   }

   public void a() {
      for(int var1 = 0; var1 < this.d.length; ++var1) {
         for(int var2 = 0; var2 < this.d[var1].size(); ++var2) {
            this.e.cG.removeElement(this.d[var1].elementAt(var2));
         }
      }

   }

   public void b() {
      this.a.a();
      this.c.a();
   }

   public LangLa_jz c() {
      return this.a.a(this.b.a, this.cx, this.cy, this.e);
   }

   public void a(int var1) {
      this.b.b = var1;

      for(var1 = 0; var1 < this.d.length; ++var1) {
         for(int var2 = 0; var2 < this.d[var1].size(); ++var2) {
            this.e.cG.removeElement(this.d[var1].elementAt(var2));
         }
      }

      for(var1 = 0; var1 < this.d[this.b.b].size(); ++var1) {
         this.e.cG.addElement(this.d[this.b.b].elementAt(var1));
      }

   }

   public void a(Graphics var1) {
      int var2 = var1.a;
      int var3 = var1.b;
      this.a(var1, this.e.cx + this.cx, this.e.cy + this.cy);
      if (this.b.c.length * this.a.h <= this.width - 4) {
         Binary2.a(var1, 24, 0, 2 + this.b.b * this.a.h, 2, this.a.h, 20, 20, 20);
         Binary2.a(var1, 60, 0, 2, 2, this.width - 4, 20, 20, 20);
      }

      Utlis.a((Graphics)var1, this.width, this.height);
      if (!this.c.a && this.b.c.length * this.a.h <= this.width - 4) {
         this.a.b(var1, this.e.cx + this.cx, this.e.cy + this.cy, this.a.width, this.a.height);
      } else {
         this.a.a(var1, this.e.cx + this.cx, this.e.cy + this.cy, this.a.width, this.a.height);
         if (this.b.c.length * this.a.h > this.width - 4) {
            Binary2.a(var1, 24, 0, this.b.b * this.a.h, 0, this.a.h, 20, 20, 20);
            Binary2.a(var1, 60, 0, 0, 0, this.b.c.length * this.a.h, 20, 20, 20);
         }
      }

      for(int var4 = 0; var4 < this.a.i; ++var4) {
         if (this.a.b(var4)) {
            String var5 = this.b.c[var4];
            if (this.e instanceof LangLa_ko && this.b.d != null && this.b.d[var4] > 0) {
               var5 = var5 + " (" + this.b.d[var4] + ")";
            }

            if (var4 == this.b.b) {
               mFont.b(mFont.e, var1, var5, 1 + var4 * this.a.h + this.a.h / 2 - 1, 11 + this.c.b(var4) - 2, 2, -2560, -11184811);
            } else if (var4 == this.a.l) {
               mFont.b(mFont.e, var1, var5, 1 + var4 * this.a.h + this.a.h / 2, 12 + this.c.b(var4) - 2, 2, -1, -11184811);
            } else {
               mFont.b(mFont.e, var1, var5, 1 + var4 * this.a.h + this.a.h / 2 - 1, 11 + this.c.b(var4) - 2, 2, -1, -11184811);
            }
         }
      }

      if (this.c.a || this.b.c.length * this.a.h > this.width - 4) {
         this.a(var1, 0, 0);
         var1.setClip(0, 0, DataCenter.gI().widthScreen, DataCenter.gI().heightScreen);
      }

      this.a(var1, var2, var3);
   }

   public void a(LangLa_cs var1, int var2) {
      this.d[var2].addElement(var1);
   }

   public void a(Vector var1, int var2) {
      for(var2 = 0; var2 < var1.size(); ++var2) {
         this.d[0].addElement((LangLa_cs)var1.elementAt(var2));
      }

   }

   public void a(Vector var1) {
      for(int var2 = 0; var2 < this.d.length; ++var2) {
         for(int var3 = 0; var3 < this.d[var2].size(); ++var3) {
            var1.addElement(this.d[var2].elementAt(var3));
         }
      }

   }

   public void a(boolean var1) {
      for(int var3 = 0; var3 < this.d.length; ++var3) {
         for(int var4 = 0; var4 < this.d[var3].size(); ++var4) {
            LangLa_cs var2;
            if ((var2 = (LangLa_cs)this.d[var3].elementAt(var4)) instanceof LangLa_dz) {
               ((LangLa_dz)var2).b(var1);
            } else if (var2 instanceof mTextBox) {
               var2.a(var1);
            }
         }
      }

   }

   public int d() {
      return this.cy + this.height;
   }
}
