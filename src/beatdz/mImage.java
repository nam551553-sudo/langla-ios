package beatdz;import beatdz.*;

import beatdz.*;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Pixmap.Blending;
import com.badlogic.gdx.graphics.Pixmap.Format;

public class mImage {
   public Texture a;
   public Pixmap b;
   public int c;
   public int d;
   public long e;

   public static mImage a(mImage var0, int var1, int var2, int var3, int var4, int var5) {
      try {
         mImage var7;
         (var7 = new mImage()).b = new Pixmap(var3, var4, Format.RGBA8888);
         var7.e();
         Binary2.a(var7.b, var0.b, 0, 0, 0, 0, var3, var4, Blending.None);
         return var7;
      } catch (Exception var6) {
         return null;
      }
   }

   public static mImage a(byte[] var0, int var1, int var2) {
      try {
         mImage var4;
         (var4 = new mImage()).b = new Pixmap(var0, 0, var0.length);
         var4.e();
         return var4;
      } catch (Exception var3) {
         return null;
      }
   }

   public static mImage a(int var0, int var1) {
      try {
         mImage var2;
         (var2 = new mImage()).b = new Pixmap(var0, var1, Format.RGBA8888);
         var2.e();
         return var2;
      } catch (Exception var3) {
         return null;
      }
   }

   public synchronized void a() {
      try {
         if (!this.equals(beatdz.LangLa_fq.$state_LangLa_fq().a)) {
            if (this.b != null) {
               this.b.dispose();
               this.b = null;
            }

            if (this.a != null) {
               Canvas.vTexture.addElement(this.a);
               this.a = null;
            }

         }
      } catch (Exception var1) {
      }
   }

   private void e() {
      this.c = this.b.getWidth();
      this.d = this.b.getHeight();
   }

   public synchronized Texture b() {
      try {
         if (mConfig.gI().readByte(18) > 1) {
            return null;
         } else {
            if (this.a == null) {
               this.a = new Texture(this.b);
               if (Canvas.isMobile()) ImageSampling.configure(this.a);
               Canvas.vImage.add(this);
            }

            this.e = System.currentTimeMillis();
            return this.a;
         }
      } catch (Exception var1) {
         return null;
      }
   }

   public synchronized boolean c() {
      if (this.b == null) {
         return false;
      } else {
         try {
            this.a.dispose();
         } catch (Exception var1) {
         }

         this.a = null;
         return true;
      }
   }

   public synchronized void d() {
      try {
         if (!this.equals(beatdz.LangLa_fq.$state_LangLa_fq().a)) {
            if (this.b != null) {
               if (this.a == null) {
                  this.a = new Texture(this.b);
               if (Canvas.isMobile()) ImageSampling.configure(this.a);
               }

               this.b.dispose();
               this.b = null;
            }

         }
      } catch (Exception var2) {
         Utlis.println(var2);
      }
   }

   public static mImage b(mImage var0, int var1, int var2, int var3, int var4, int var5) {
      var1 = 0;
      var2 = 0;
      mImage var6 = null;
      if (var5 == 0) {
         Binary2.a((var6 = a(var3, var4)).b, var0.b, 0, 0, 0, 0, var3, var4, Blending.None);
         return var6;
      } else {
         int var7;
         if (var5 == -360) {
            var6 = a(var3, var4);

            for(var5 = 0; var5 < var4; ++var5) {
               for(var7 = var3 - 1; var7 >= 0; --var7) {
                  Binary2.a(var6, var1, var2, var0.b.getPixel(0 + var7, 0 + var5));
                  ++var1;
               }

               var1 = 0;
               ++var2;
            }
         } else if (var5 == -180) {
            var6 = a(var3, var4);

            for(var5 = 0; var5 < var4; ++var5) {
               for(var7 = 0; var7 < var3; ++var7) {
                  Binary2.a(var6, var1, var2, var0.b.getPixel(0 + var7, 0 + var4 - 1 - var5));
                  ++var1;
               }

               var1 = 0;
               ++var2;
            }
         } else if (var5 == 180) {
            var6 = a(var3, var4);

            for(var5 = 0; var5 < var4; ++var5) {
               for(var7 = 0; var7 < var3; ++var7) {
                  Binary2.a(var6, var1, var2, var0.b.getPixel(0 + var3 - 1 - var7, 0 + var4 - 1 - var5));
                  ++var1;
               }

               var1 = 0;
               ++var2;
            }
         } else if (var5 == 270) {
            var6 = a(var4, var3);

            for(var5 = 0; var5 < var3; ++var5) {
               for(var7 = 0; var7 < var4; ++var7) {
                  Binary2.a(var6, var1, var2, var0.b.getPixel(0 + var3 - 1 - var5, 0 + var7));
                  ++var1;
               }

               var1 = 0;
               ++var2;
            }
         } else if (var5 == -270) {
            var6 = a(var4, var3);

            for(var5 = 0; var5 < var3; ++var5) {
               for(var7 = 0; var7 < var4; ++var7) {
                  Binary2.a(var6, var1, var2, var0.b.getPixel(0 + var3 - 1 - var5, 0 + var4 - 1 - var7));
                  ++var1;
               }

               var1 = 0;
               ++var2;
            }
         } else if (var5 == 90) {
            var6 = a(var4, var3);

            for(var5 = 0; var5 < var3; ++var5) {
               for(var7 = 0; var7 < var4; ++var7) {
                  Binary2.a(var6, var1, var2, var0.b.getPixel(0 + var5, 0 + var4 - 1 - var7));
                  ++var1;
               }

               var1 = 0;
               ++var2;
            }
         } else if (var5 == -270) {
            var6 = a(var4, var3);

            for(var5 = 0; var5 < var3; ++var5) {
               for(var7 = 0; var7 < var4; ++var7) {
                  Binary2.a(var6, var1, var2, var0.b.getPixel(0 + var5, 0 + var4 - 1 - var7));
                  ++var1;
               }

               var1 = 0;
               ++var2;
            }
         } else if (var5 == -90) {
            var6 = a(var4, var3);

            for(var5 = 0; var5 < var3; ++var5) {
               for(var7 = 0; var7 < var4; ++var7) {
                  Binary2.a(var6, var1, var2, var0.b.getPixel(0 + var5, 0 + var7));
                  ++var1;
               }

               var1 = 0;
               ++var2;
            }
         }

         return var6;
      }
   }
}
