package beatdz;import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Blending;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import java.util.Hashtable;
import java.util.Vector;

public class LangLa_fw {
   byte a;
   byte b;
   byte c;
   byte d;
   private String i = "";
   private byte[] j = new byte[0];
   public Vector e = new Vector();
   public Hashtable f = new Hashtable();
   private Hashtable k = new Hashtable();
   public Hashtable g = new Hashtable();
   public Hashtable h = new Hashtable();

   private mImage f(String var1) {
      return (mImage)this.k.get(var1);
   }

   private void a(String var1, mImage var2) {
      this.k.put(var1, var2);
      this.e.addElement(var1);
      if (this.k.size() > 300) {
         for(int var3 = this.e.size() - 1; var3 >= 200; --var3) {
            var1 = (String)this.e.remove(var3);
            ((mImage)this.k.remove(var1)).a();
         }
      }

   }

   public LangLa_fw(int var1) {
      this.a = (byte)var1;
      this.i = "";
   }

   public boolean a() {
      try {
         this.i = "";
         Binary2.a(this.f);
         Binary2.a(this.k);
         this.e.clear();
         this.b();
         return true;
      } catch (Exception var2) {
         Utlis.println(var2);
         return false;
      }
   }

   public void b() {
      this.d = (byte)(Graphics.b(this.a, "Ấ") * 2);
   }

   private int a(char var1) {
      int var2;
      if ((var2 = this.i.indexOf(var1)) == -1) {
         var2 = this.i.toLowerCase().indexOf(var1);
      }

      if (var2 == -1) {
         var2 = this.i.toUpperCase().indexOf(var1);
      }

      return var2;
   }

   private int a(int var1) {
      int var2 = this.j[var1];
      if (this.j[var1] < 0) {
         var2 = this.j[var1] + 256;
      }

      return var2;
   }

   public int a(String var1) {
      return this.b(var1);
   }

   private int g(String var1) {
      int var3 = 0;
      var1 = var1.replace("c#kim", "").replace("c#moc", "").replace("c#thuy", "").replace("c#hoa", "").replace("c#tho", "");

      for(int var4 = 0; var4 < var1.length(); ++var4) {
         int var2;
         if ((var2 = this.a(var1.charAt(var4))) < 0) {
            var3 += this.c;
         } else {
            var3 += this.a(var2);
         }
      }

      return var3;
   }

   public int b(String var1) {
      if (this.g.get(var1) != null) {
         return (Integer)this.g.get(var1);
      } else {
         int var2 = 0;
         String var4 = var1;

         int var3;
         for(var3 = 0; var3 < var4.length(); ++var3) {
            int[] var5;
            if ((var5 = d(var4.substring(var3))) != null) {
               LangLa_je var6 = beatdz.LangLa_je.$state_LangLa_je().g[var5[0]];
               var2 += var6.a * DataCenter.gI().zoomLevel + this.b;
               var4 = var4.substring(0, var5[1]) + var4.substring(var5[1] + var6.d.length());
               var3 = -1;
            }
         }

         var3 = Graphics.a(this.a, var4);
         var2 += var3;
         if (var1.length() > 1) {
            var2 -= this.b;
         }

         if (this.g.size() > 500) {
            this.g.clear();
         }

         if (var3 > 0) {
            this.g.put(var1, var2);
         }

         return var2;
      }
   }

   public void a(int var1, int var2, int var3, int var4, Graphics var5, String var6, int var7, int var8, int var9) {
      if (!h(var6)) {
         if (var4 >= 0 && var4 < var6.length()) {
            mImage var10 = this.a(-1, 0, "" + var6.charAt(var4));
            var2 = 0;
            var3 = this.a(var6);
            if (var9 == 1) {
               var2 = -var3;
            } else if (var9 == 2) {
               var2 = -var3 / 2;
            }

            for(var9 = 0; var9 < var6.length(); ++var9) {
               var3 = this.a(var6.charAt(var9));
               if (var9 == var4) {
                  break;
               }

               if (var3 < 0) {
                  var2 += this.c + this.b;
               } else {
                  var2 += this.a(var3) + this.b;
               }
            }

            var9 = var5.a;
            var3 = var5.b;
            var5.a(var7, var8);
            var5.c(-1);
            var5.b(var10, 0, 0, var10.c, var10.d, 0, var2, 0, 6);
            var5.c();
            var5.a(-var5.a, -var5.b);
            var5.a(var9, var3);
         }
      }
   }

   public void a(int var1, int var2, Pixmap var3, String var4, int var5, int var6, int var7, boolean var8) {
      if (!h(var4)) {
         int var9 = 0;
         int var10 = this.b(var4);
         int var11 = var4.length();
         if (var7 == 1) {
            var9 = -var10;
         } else if (var7 == 2) {
            var9 = -var10 / 2;
         }

         for(var10 = 0; var10 < var11; ++var10) {
            if ((var7 = this.a(var4.charAt(var10))) < 0) {
               var9 += this.c + this.b;
            } else {
               mImage var12 = Binary2.a((mImage)this.f.get(var7), var1, var2);
               if (var8) {
                  Binary2.a(var3, var12.b, var9 + var5 * DataCenter.gI().zoomLevel, 0 - var12.d / 2 + var6 * DataCenter.gI().zoomLevel, Blending.SourceOver);
               } else {
                  Binary2.a(var3, var12.b, var9 + var5, 0 - var12.d / 2 + var6, Blending.SourceOver);
               }

               var9 += this.a(var7) + this.b;
               var12.a();
            }
         }

      }
   }

   public void a(int var1, int var2, Graphics var3, String var4, int var5, int var6, int var7) {
      if (!h(var4)) {
         try {
            int var8 = this.b(var4);
            mImage var11;
            if ((var11 = this.a(var1, var2, var4)) != null) {
               var2 = 0;
               if (var7 == 1) {
                  var2 = -var8;
               } else if (var7 == 2) {
                  var2 = -var8 / 2;
               }

               var7 = var3.a;
               var8 = var3.b;
               var3.a(var5, var6);
               var3.c(var1);
               var3.b(var11, 0, 0, var11.c, var11.d, 0, var2, 0, 6);
               var3.c();
               var3.a(-var3.a, -var3.b);
               var3.a(var7, var8);
            }
         } catch (Exception var10) {
            Utlis.println(var10);
         }
      }
   }

   public void a(BitmapFont var1, int var2, int var3, Graphics var4, String var5, int var6, int var7, int var8) {
      if (var1 != null) {
         var4.a(this.a, var1, var5, var6, var7, var8, var2, 0.0F);
      } else {
         this.a(var2, var3, var4, var5, var6, var7, var8);
      }
   }

   public int a(mFont var1, BitmapFont var2, int var3, int var4, Graphics var5, String var6, int var7, int var8, int var9) {
      if (h(var6)) {
         return -1;
      } else {
         int var13;
         if (var2 == null) {
            int var15 = 0;
            int var17 = this.b(var6);
            String var19 = var6 + Integer.toHexString(var3);
            if (var4 != 0) {
               var19 = var19 + Integer.toHexString(var4);
            }

            mImage var18;
            if ((var18 = this.f(var19)) == null) {
               Binary.disposeImage(var18 = this.b(var17, var3, var4, var6));
               this.a(var19, var18);
            }

            if (var9 == 1) {
               var15 = -var17;
            } else if (var9 == 2) {
               var15 = -var17 / 2;
            }

            var9 = var5.a;
            var13 = var5.b;
            var5.a(var7, var8);
            var5.b(var18, 0, 0, var18.c, var18.d, 0, var15, 0, 6);
            var5.a(-var5.a, -var5.b);
            var5.a(var9, var13);
            return this.a(var17, var3, var4, var6);
         } else {
            LangLa_ev var14 = var1.a(var6, var3, var2);
            var3 = -1;
            float var10 = 0.0F;
            float var11 = var14.b;
            if (var9 == 2) {
               var11 = -var11 / 2.0F;
            } else if (var9 == 1) {
               var11 = -var11;
            } else {
               var11 = 0.0F;
            }

            for(int var12 = 0; var12 < var14.c.size(); ++var12) {
               LangLa_la var16;
               if ((var16 = (LangLa_la)var14.c.get(var12)).c > 0) {
                  if (var16.c == 752) {
                     LangLa_fq.a(var5, 752 + DataCenter.gI().i % 24 / 6, 0, var7 + (int)((var10 + var11) / (float)DataCenter.gI().zoomLevel) + DataCenter.gI().zoomLevel / 2, var8, 6);
                  } else {
                     LangLa_fq.a(var5, var16.c, 0, var7 + (int)((var10 + var11) / (float)DataCenter.gI().zoomLevel) + DataCenter.gI().zoomLevel / 2, var8, 6);
                  }
               } else {
                  var5.a(this.a, var2, var16.a, var7, var8, 0, var16.b, var10 + var11);
                  if (var16.b == -16320832 || var16.b == -1771516 || var16.b == -7812045 || var16.b == -1675165) {
                     var5.f(var16.b);
                     var13 = var7 + (int)((var10 + var11) / (float)DataCenter.gI().zoomLevel);
                     var5.a(var13, var8 + 4, var13 + (int)var16.d / DataCenter.gI().zoomLevel, var8 + 5);
                  }
               }

               var10 += var16.d;
               var3 = var16.b;
            }

            return var3;
         }
      }
   }

   private int a(int var1, int var2, int var3, String var4) {
      var3 = var4.length();

      for(int var5 = 0; var5 < var3; ++var5) {
         LangLa_je var6;
         if ((var6 = c(var4.substring(var5))) == null) {
            if ((var1 = this.a(var4.charAt(var5))) >= 0) {
               this.a(var1);
            }
         } else {
            if (var6.d.equals("c#task") || var6.d.equals("c#item") || var6.d.equals("c#select")) {
               DataCenter.gI();
            }

            if (var6.a > 0) {
               DataCenter.gI();
            } else {
               var2 = var6.b;
            }

            var5 += var6.d.length() - 1;
         }
      }

      return var2;
   }

   private mImage b(int var1, int var2, int var3, String var4) {
      var1 = var1;
      int var5 = this.d;
      int var6 = var4.length();
      int var7 = -1;
      int var8 = 0;
      if (var3 != 0) {
         var1 += 2;
         var5 += 2;
      }

      LangLa_je var9;
      for(int var10 = 0; var10 < var6; ++var10) {
         mImage var11;
         if ((var9 = c(var4.substring(var10))) != null && var9.c > 0 && (var11 = LangLa_fq.a(var9.c)).d > var5) {
            var5 = var11.d;
         }
      }

      Color var15 = new Color();
      mImage var14 = Binary.createImage(var1, var5);

      for(int var16 = 0; var16 < var6; ++var16) {
         if ((var9 = c(var4.substring(var16))) == null) {
            var1 = this.a(var4.charAt(var16));
            this.a(var2, var3, var14.b, "" + var4.charAt(var16), var8, 0 + var14.d / 2, 20, false);
            if (var1 < 0) {
               var8 += this.c + this.b;
            } else {
               var8 += this.a(var1) + this.b;
            }
         } else {
            if (!var9.d.equals("c#task") && !var9.d.equals("c#item") && !var9.d.equals("c#select")) {
               if (var7 >= 0) {
                  Color.argb8888ToColor(var15, var2);
                  var14.b.setColor(var15);
                  var14.b.fillRectangle(var7 * DataCenter.gI().zoomLevel, var14.d - 1 * DataCenter.gI().zoomLevel, var8 - var7 * DataCenter.gI().zoomLevel, 1 * DataCenter.gI().zoomLevel);
               }

               var7 = -1;
            } else {
               var7 = var8 / DataCenter.gI().zoomLevel;
            }

            if (var9.a > 0) {
               mImage var13 = LangLa_fq.a(var9.c);
               Binary2.a(var14.b, var13.b, var8 + (var8 % DataCenter.gI().zoomLevel != 0 ? 1 : 0), 2, 0, 0, var13.c, var13.d, Blending.SourceOver);
               var8 += var9.a * DataCenter.gI().zoomLevel + this.b;
            } else {
               var2 = var9.b;
            }

            var16 += var9.d.length() - 1;
         }
      }

      if (var7 >= 0) {
         Color.argb8888ToColor(var15, var2);
         var14.b.setColor(var15);
         var14.b.fillRectangle(var7 * DataCenter.gI().zoomLevel, var14.d - 1 * DataCenter.gI().zoomLevel, var8 - var7 * DataCenter.gI().zoomLevel, 1 * DataCenter.gI().zoomLevel);
      }

      return var14;
   }

   private mImage a(int var1, int var2, String var3) {
      int var4 = 0;
      String var5 = var3 + Integer.toHexString(var1);
      if (var2 != 0) {
         var5 = var5 + Integer.toHexString(var2);
      }

      mImage var6 = this.f(var5);

      try {
         if (var3.length() == 1) {
            var1 = this.g(var3);
         } else {
            var1 = this.a(var3);
         }

         int var7 = this.d;
         if (var6 == null) {
            if (var2 != 0) {
               var1 += 2;
               var7 += 2;
            }

            Pixmap var11 = (var6 = Binary.createImage(var1, var7)).b;

            for(int var8 = 0; var8 < var3.length(); ++var8) {
               if ((var1 = this.a(var3.charAt(var8))) < 0) {
                  var4 += this.c + this.b;
               } else {
                  mImage var9;
                  if (var2 != 0) {
                     var9 = (mImage)this.f.get(var1 + 1000);
                  } else {
                     var9 = (mImage)this.f.get(var1);
                  }

                  Binary2.a(var11, var9.b, var4, 0, Blending.None);
                  var4 += this.a(var1) + this.b;
               }
            }

            this.a(var5, var6);
         }

         return var6;
      } catch (Exception var10) {
         if (var6 != null) {
            var6.a();
         }

         return beatdz.LangLa_fq.$state_LangLa_fq().a;
      }
   }

   public static LangLa_je c(String var0) {
      var0 = var0.toLowerCase();

      for(int var2 = 0; var2 < beatdz.LangLa_je.$state_LangLa_je().g.length; ++var2) {
         LangLa_je var1 = beatdz.LangLa_je.$state_LangLa_je().g[var2];
         if (var0.startsWith(var1.d)) {
            return var1;
         }
      }

      return null;
   }

   public static int[] d(String var0) {
      var0 = var0.toLowerCase();

      for(int var2 = 0; var2 < beatdz.LangLa_je.$state_LangLa_je().g.length; ++var2) {
         LangLa_je var1 = beatdz.LangLa_je.$state_LangLa_je().g[var2];
         int var3;
         if ((var3 = var0.indexOf(var1.d)) >= 0) {
            return new int[]{var2, var3};
         }
      }

      return null;
   }

   public static LangLa_je e(String var0) {
      var0 = var0.toLowerCase();
      LangLa_je var1 = null;

      for(int var2 = 0; var2 < beatdz.LangLa_je.$state_LangLa_je().g.length; ++var2) {
         int var3;
         if ((var3 = var0.indexOf(beatdz.LangLa_je.$state_LangLa_je().g[var2].d)) >= 0 && (var1 == null || var3 < var0.indexOf(var1.d))) {
            var1 = beatdz.LangLa_je.$state_LangLa_je().g[var2];
         }
      }

      return var1;
   }

   public Vector a(String var1, int var2) {
      var2 *= DataCenter.gI().zoomLevel;
      Vector var3 = new Vector();
      String var4 = "";

      for(int var5 = 0; var5 < var1.length(); ++var5) {
         if (var1.charAt(var5) == '\\' && var5 + 1 < var1.length() && var1.charAt(var5 + 1) == 'n') {
            ++var5;
            var3.addElement(var4);
            var4 = "";
         } else if (var1.charAt(var5) == '\n') {
            var3.addElement(var4);
            var4 = "";
         } else {
            var4 = var4 + var1.charAt(var5);
            if (this.a(var4) > var2) {
               String var7 = "";

               int var6;
               for(var6 = var4.length() - 1; var6 >= 0; --var6) {
                  var7 = var7 + var4.charAt(var6);
                  if (var4.charAt(var6) == ' ') {
                     break;
                  }

                  if (this.b(var7) > var2) {
                     --var6;
                     break;
                  }
               }

               if (var6 < 0) {
                  var6 = var4.length() - 1;
               }

               var3.addElement(var4.substring(0, var6));
               var5 = var5 - (var4.length() - var6) + 1;
               var4 = "";
            }

            if (var5 == var1.length() - 1 && !var4.trim().equals("")) {
               var3.addElement(var4);
            }
         }
      }

      return var3;
   }

   private static boolean h(String var0) {
      return var0 == null || var0.length() == 0;
   }
}
