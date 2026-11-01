package beatdz;import com.badlogic.gdx.graphics.g2d.BitmapFont;
import java.util.Vector;

public abstract class LangLa_fn extends LangLa_fo {
   public LangLa_kd k;
   private LangLa_ii a;
   private Vector[] b;
   public int l = 10;
   public boolean[] m;
   public boolean[] n;

   public LangLa_fn(MainScreen var1) {
      this.p = var1;
      this.a(DataCenter.gI().widthScreen - 20, DataCenter.gI().heightScreen - 20);
   }

   public void a(LangLa_kd var1, int var2, int var3, int var4) {
      if ((var2 = var1.c.length) > var4) {
         var2 = var4;
      }

      this.k = var1;
      this.a = new LangLa_ii((byte)0, 20, 3, var3 * var2, 25, var3, var1.c.length);
      this.b = new Vector[var1.c.length];
      this.m = new boolean[var1.c.length];
      this.n = new boolean[var1.c.length];

      for(int var5 = 0; var5 < this.b.length; ++var5) {
         this.b[var5] = new Vector();
      }

   }

   public int j() {
      return this.k.c.length - 1;
   }

   public void a(LangLa_cs var1, int var2) {
      this.b[var2].addElement(var1);
   }

   public void b() {
      this.a.a();
   }

   private void a(Graphics var1, int var2, int var3, int var4, String var5, boolean var6) {
      Binary2.a(var1, var4, 0, var2, 3, var3 - this.l, (int)19);
      if (var6) {
         mFont.a((BitmapFont)Graphics.a(23.0F), (Graphics)var1, var5, var2 + (var3 - this.l) / 2 + 1, 12, 2, -2560, 0);
      } else {
         mFont.a((BitmapFont)Graphics.a(23.0F), (Graphics)var1, var5, var2 + (var3 - this.l) / 2, 11, 2, -2560, 0);
      }
   }

   public void a(Graphics var1) {
      this.a(var1, this.cx, this.cy, this.width, this.height, "", (byte)20, this.r);
      this.a(var1, this.a);

      for(int var2 = 0; var2 < this.k.c.length; ++var2) {
         if (!this.n[var2]) {
            if (var2 == this.k.b) {
               this.a(var1, var2 * this.a.h, this.a.h, 78, this.k.c[var2], var2 == this.a.l);
            } else {
               this.a(var1, var2 * this.a.h, this.a.h, 76, this.k.c[var2], var2 == this.a.l);
            }

            if (this.m[var2]) {
               LangLa_fq.a(var1, 713, 0, (var2 + 1) * this.a.h - this.l - 4, 2, 0);
            }
         }
      }

      this.b(var1);
   }

   public Vector c() {
      Vector var1;
      (var1 = new Vector()).addElement(this.a.a(-9997, this));
      super.b(var1);
      return var1;
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      try {
         switch(var1.b) {
         case -9997:
            if (var1.j.k >= 0 && this.k.b != var1.j.k) {
               if (this instanceof LangLa_ky) {
                  GameSrc.gI().bU = (byte)var1.j.k;
               }

               this.a(var1.j.k);
               return;
            }
            break;
         default:
            super.a(var1, var2, var3);
         }

      } catch (Exception var4) {
      }
   }

   public int k() {
      return this.k.b;
   }

   public void a(int var1) {
      this.k.b = var1;

      for(var1 = 0; var1 < this.b.length; ++var1) {
         for(int var2 = 0; var2 < this.b[var1].size(); ++var2) {
            this.cG.removeElement(this.b[var1].elementAt(var2));
         }
      }

      for(var1 = 0; var1 < this.b[this.k.b].size(); ++var1) {
         this.cG.addElement(this.b[this.k.b].elementAt(var1));
      }

   }

   public Vector c(int var1) {
      return this.b[0];
   }
}
