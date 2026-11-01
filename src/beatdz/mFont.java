package beatdz;import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import java.util.Hashtable;
import java.util.Vector;

public class mFont {
   public byte a = -1;
   public static mFont b;
   public static mFont c;
   public static mFont d;
   public static mFont e;
   public static mFont f;
   public static mFont g;
   public static mFont h;
   public static LangLa_fw[] i = new LangLa_fw[7];
   public static mFont[] j = new mFont[7];
   public static String k = " 0123456789+-*='\"\\/_?.,ˋˊ~ˀ:;|<>[]{}!@#$%^&*()aáàảãạâấầẩẫậăắằẳẵặbcdđeéèẻẽẹêếềểễệfghiíìỉĩịjklmnoóòỏõọôốồổỗộơớờởỡợpqrstuúùủũụưứừửữựvxyýỳỷỹỵzwAÁÀẢÃẠÂẤẦẨẪẬĂẮẰẲẴẶBCDĐEÉÈẺẼẸÊẾỀỂỄỆFGHIÍÌỈĨỊJKLMNOÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢPQRSTUÚÙỦŨỤƯỨỪỬỮỰVXYÝỲỶỸỴZW";
   public Hashtable l = new Hashtable();
   public static Hashtable m = new Hashtable();

   private mFont(byte var1) {
   }

   private LangLa_fw b() {
      return this.a >= 0 && this.a < i.length ? i[this.a] : null;
   }

   public static void a() {
      try {
         for(byte var0 = 0; var0 < i.length; ++var0) {
            if (i[var0].a()) {
               j[var0].a = var0;
            } else {
               j[var0].a = -1;
            }
         }

      } catch (Exception var1) {
      }
   }

   public static int a(mFont var0) {
      return var0.b().d / DataCenter.gI().zoomLevel;
   }

   public static int a(mFont var0, String var1) {
      int var10000;
      LangLa_fw var4;
      if ((var4 = var0.b()).h.get(var1) != null) {
         var10000 = (Integer)var4.h.get(var1);
      } else {
         int var3 = Graphics.a(var4.a, var1);
         int var2 = 0 + var3;
         if (var1.length() > 1) {
            var2 -= var4.b;
         }

         if (var4.h.size() > 500) {
            var4.h.clear();
         }

         if (var3 > 0) {
            var4.h.put(var1, var2);
         }

         var10000 = var2;
      }

      int var5 = var10000;
      return var10000 / DataCenter.gI().zoomLevel + (var5 % DataCenter.gI().zoomLevel != 0 ? 1 : 0);
   }

   public static int b(mFont var0, String var1) {
      int var2;
      return (var2 = var0.b().b(var1)) / DataCenter.gI().zoomLevel + (var2 % DataCenter.gI().zoomLevel != 0 ? 1 : 0);
   }

   public static int c(mFont var0, String var1) {
      int var2;
      return (var2 = var0.b().b(var1)) / DataCenter.gI().zoomLevel + (var2 % DataCenter.gI().zoomLevel != 0 ? 1 : 0);
   }

   public static int a(mFont var0, String[] var1) {
      int var2 = 0;

      for(int var4 = 0; var4 < var1.length; ++var4) {
         int var3;
         if ((var3 = c(var0, var1[var4])) > var2) {
            var2 = var3;
         }
      }

      return var2;
   }

   public static Vector a(mFont var0, String var1, int var2) {
      LangLa_fw var13 = var0.b();
      var1 = var1.replaceAll("\\n", " \n ");
      String var3 = "";

      for(int var4 = 0; var4 < var1.length(); ++var4) {
         if (var1.charAt(var4) == '\\' && var4 + 1 < var1.length() && var1.charAt(var4 + 1) == 'n') {
            var3 = var3 + " \n ";
            ++var4;
         } else {
            var3 = var3 + var1.charAt(var4);
         }
      }

      var2 *= DataCenter.gI().zoomLevel;
      Vector var15 = new Vector();
      String[] var14 = Utlis.split(var3, " ");
      Vector var5 = new Vector();

      int var6;
      int var9;
      for(var6 = 0; var6 < var14.length; ++var6) {
         String var7 = var14[var6];
         if (var13.b(var7) < var2) {
            var5.add(var7);
         } else {
            String var8 = "";

            for(var9 = 0; var9 < var7.length(); ++var9) {
               var8 = var8 + var7.charAt(var9);
               if (var13.b(var8) >= var2) {
                  if (var8.length() > 1) {
                     var5.add(var8.substring(0, var8.length() - 1));
                     var8 = "" + var7.charAt(var9);
                  } else {
                     var5.add(var8);
                     var8 = "";
                  }
               }
            }

            if (var8.length() > 0) {
               var5.add(var8);
            }
         }
      }

      var14 = new String[var5.size()];
      var1 = "";

      for(var6 = 0; var6 < var5.size(); ++var6) {
         var14[var6] = (String)var5.get(var6);
         var1 = var1 + (String)var5.get(var6);
         if (var6 < var5.size() - 1) {
            var1 = var1 + " ";
         }
      }

      LangLa_je var17 = null;
      int var20 = 0;
      var9 = 0;
      int var16 = 0;
      boolean var10 = false;

      for(int var11 = 0; var11 < var14.length; ++var11) {
         if (var14[var11].equals("\n") || var16 + var13.b(var14[var11]) > var2) {
            if (var10) {
               var15.addElement(var1.substring(var9, var20).trim());
               var10 = false;
            } else {
               var15.addElement(Utlis.e(var1.substring(var9, var20)));
            }

            var9 = var20;
            var16 = 0;
            if (var17 != null) {
               if (var14[var11].equals("\n")) {
                  var1 = var1.substring(0, var20) + var1.substring(var20, var20 + 1) + var17.d + var1.substring(var20 + 2, var1.length());
               } else {
                  var1 = var1.substring(0, var20) + var17.d + var1.substring(var20, var1.length());
               }

               var14 = Utlis.split(var1, " ");
               var17 = null;
            }

            if (var14[var11].startsWith("\n")) {
               var10 = true;
            }
         }

         for(int var12 = 0; var12 < var14[var11].length(); ++var12) {
            LangLa_je var18;
            if ((var18 = LangLa_fw.c(var1.substring(var20))) == null) {
               int[] var19;
               if ((var19 = LangLa_fw.d(var1.substring(var20).split("\n")[0])) != null) {
                  var17 = beatdz.LangLa_je.$state_LangLa_je().g[var19[0]];
               }

               var6 = var20 + var14[var11].length() - var12;
               var16 += var13.b(var1.substring(var20, var6) + " ");
               var20 = var6;
               break;
            }

            var16 += var18.a * DataCenter.gI().zoomLevel + var13.b;
            var12 += var18.d.length() - 1;
            var20 += var18.d.length() - 1;
            if (var18.a <= 0) {
               var17 = var18;
            }

            ++var20;
         }

         var16 += var13.c + var13.b;
         ++var20;
         if (var11 == var14.length - 1) {
            var15.addElement(Utlis.e(var1.substring(var9, var1.length())));
         }
      }

      return var15;
   }

   public static Vector b(mFont var0, String var1, int var2) {
      return var0.b().a(var1, var2);
   }

   public static String[] c(mFont var0, String var1, int var2) {
      Vector var3;
      String[] var4 = new String[(var3 = var0.b().a(var1, var2)).size()];
      var3.copyInto(var4);
      return var4;
   }

   public static void a(mFont var0, Graphics var1, String var2, int var3, int var4, int var5, int var6, int var7) {
      if (!c()) {
         var0.b().a(Graphics.a(var0.a), var6, var7, var1, var2, var3, var4, var5);
      }
   }

   public static void a(mFont var0, Pixmap var1, String var2, int var3, int var4, int var5, int var6, int var7) {
      if (!c()) {
         var0.b().a(-3476028, -16777216, var1, var2, var3, 8, 2, true);
      }
   }

   public static void a(mFont var0, Graphics var1, String var2, int var3, int var4, int var5, int var6) {
      if (!c()) {
         var0.b().a(Graphics.a(var0.a), var6, 0, var1, var2, var3, var4, var5);
      }
   }

   public static void b(mFont var0, Graphics var1, String var2, int var3, int var4, int var5, int var6, int var7) {
      if (!c()) {
         var0.b().a(Graphics.a(var0.a), var6, var7, var1, var2, var3, var4, var5);
      }
   }

   public static void a(BitmapFont var0, Graphics var1, String var2, int var3, int var4, int var5, int var6, int var7) {
      if (!c()) {
         b.b().a(var0, var6, var7, var1, var2, var3, var4, 2);
      }
   }

   public static void a(mFont var0, Graphics var1, String var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      if (!c()) {
         a(var0, var1, var2, var3, var4, var5, var6, var7, var8, 0, 1);
      }
   }

   public static void a(mFont var0, Graphics var1, String var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      if (!c()) {
         a(var0, var1, var2, var3, var4, 2, -2560, 2, 1, 0, 3);
      }
   }

   public static void a(mFont var0, Graphics var1, String var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      if (!c()) {
         var7 = a(var2, var7, var9);
         BitmapFont var11;
         if ((var11 = Graphics.a(var0.a)) == null) {
            var0.b().a(var6, 0, var1, var2, var3, var4, var5);

            for(int var18 = 0; var18 < var10; ++var18) {
               var0.b().a(var6, -1, 0, var9 == 0 ? var7 - var18 : var7 + var18, var1, var2, var3, var4, var5);
            }

         } else {
            int[] var12 = new int[var10];

            for(var10 = 0; var10 < var12.length; ++var10) {
               if (var9 == 0) {
                  var12[var10] = var7 - var10;
               } else {
                  var12[var10] = var7 + var10;
               }
            }

            String var17 = var0.a + "#" + var2;
            LangLa_fv var16 = (LangLa_fv)m.get(var17);
            var3 = var3;
            if (var5 == 2) {
               if (var16 == null) {
                  var3 -= b(var0, var2) / 2;
               } else {
                  var3 -= var16.c / 2;
               }
            }

            var5 = 0;

            for(var9 = 0; var9 < var2.length(); ++var9) {
               String var13 = var2.substring(var9, var9 + 1);
               boolean var14 = false;

               for(int var15 = 0; var15 < var12.length; ++var15) {
                  if (var9 == var12[var15]) {
                     var1.a(var0.a, var11, var13, var3 + var5, var4 + var8, 0, -1, 0.0F);
                     var14 = true;
                  }
               }

               if (!var14) {
                  var1.a(var0.a, var11, var13, var3 + var5, var4, 0, var6, 0.0F);
               }

               var5 += b(var0, var13);
            }

            if (var16 == null) {
               var16 = new LangLa_fv(var0.a, var17, var5);
            }

            if (m.size() > 500) {
               m.clear();
            }

            m.put(var16.b, var16);
         }
      }
   }

   public static void a(Graphics var0, String var1, int var2, int var3, int var4, int var5) {
      if (!c()) {
         var0.a(0, Graphics.a(0), var1, var2, var3, var4, var5, 0.0F);
      }
   }

   public static int c(mFont var0, Graphics var1, String var2, int var3, int var4, int var5, int var6, int var7) {
      return c() ? 0 : var0.b().a(var0, Graphics.a(var0.a), var6, var7, var1, var2, var3, var4, var5);
   }

   public static int d(mFont var0, Graphics var1, String var2, int var3, int var4, int var5, int var6, int var7) {
      return c() ? 0 : var0.b().a(var0, Graphics.b(75), var6, var7, var1, var2, var3, var4, var5);
   }

   public static void b(mFont var0, Graphics var1, String var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      if (!c()) {
         if (Utlis.positive(DataCenter.gI().i % var9) >= var9 / 2) {
            var0.b().a(Graphics.a(var0.a), -1, 0, var1, var2, var3, var4, 2);
         } else {
            var0.b().a(Graphics.a(var0.a), var7, 0, var1, var2, var3, var4, 2);
         }
      }
   }

   private static int a(String var0, int var1, int var2) {
      int var3 = DataCenter.gI().i / var1 % var0.length();
      switch(var2) {
      case 1:
         var3 = DataCenter.gI().i / var1 % (var0.length() * 2) % var0.length();
         if (DataCenter.gI().i / var1 % (var0.length() * 2) >= var0.length()) {
            var3 = var0.length() - 1 - var3;
         }
      default:
         return var3;
      }
   }

   public static String[] a(String var0, int var1) {
      Vector var6 = new Vector();

      for(int var2 = 0; var2 < var0.length(); ++var2) {
         if (var0.charAt(var2) == ' ') {
            var6.addElement(var0.substring(0, var2).trim());
            var0 = var0.substring(var2);
            var2 = 0;
         }
      }

      var6.addElement(var0.trim());
      String[] var7 = new String[2];
      int var5 = 0;
      int var3 = 0;

      for(int var4 = 0; var4 < var6.size(); ++var4) {
         if (var7[var5] == null) {
            var7[var5] = "";
         }

         var7[var5] = var7[var5] + var6.elementAt(var4).toString() + " ";
         ++var3;
         if (var3 == var6.size() / 2) {
            var7[var5] = var7[var5].trim();
            var3 = 0;
            ++var5;
            if (var5 >= 2) {
               var5 = 1;
               var7[1] = var7[1] + " ";
            }
         }
      }

      return var7;
   }

   private static boolean c() {
      if (mConfig.gI().readByte(18) > 1) {
         return true;
      } else {
         try {
            if (AppListener.gI().app.c()) {
               return true;
            }

            if (DataCenter.gI().currentScreen instanceof GameSrc) {
               return Graphics.q;
            }

            Graphics.q = false;
         } catch (Exception var1) {
         }

         return false;
      }
   }

   public LangLa_ev a(String var1, int var2, BitmapFont var3) {
      String var4 = var3.getScaleX() + "_" + var2 + "_" + var1;
      LangLa_ev var5;
      if ((var5 = (LangLa_ev)this.l.get(var4)) == null) {
         (var5 = new LangLa_ev()).a = var4;
         var5.b = 0.0F;
         String var6 = var1.toLowerCase();

         for(int var8 = 0; var8 < var6.length() - 1 && var5.c.size() <= 10; ++var8) {
            for(int var7 = 2; var7 <= 8; ++var7) {
               int var9;
               if ((var9 = var8 + var7) > var1.length()) {
                  var9 = var1.length();
               }

               LangLa_je var13;
               if ((var13 = (LangLa_je)beatdz.LangLa_je.$state_LangLa_je().h.get(var6.substring(var8, var9))) != null) {
                  String var11 = var13.d;
                  String var10;
                  LangLa_la var14;
                  if ((var10 = var1.substring(0, var8)).length() > 0) {
                     var14 = new LangLa_la(this.a, var3, var10, var2);
                     var5.b += var14.d;
                     var5.c.add(var14);
                  }

                  if (var13.c > 0) {
                     var14 = new LangLa_la(var13.c, var13.a);
                     var5.b += var14.d;
                     var5.c.add(var14);
                  } else {
                     var2 = var13.b;
                  }

                  var1 = var1.substring(var8 + var11.length(), var1.length());
                  var6 = var6.substring(var8 + var13.d.length(), var6.length());
                  var8 = -1;
                  break;
               }
            }
         }

         if (var1.length() > 0) {
            LangLa_la var12 = new LangLa_la(this.a, var3, var1.substring(0, var1.length()), var2);
            var5.b += var12.d;
            var5.c.add(var12);
         }

         if (this.l.size() > 500) {
            this.l.clear();
         }

         this.l.put(var4, var5);
      }

      return var5;
   }

   static {
      for(int var0 = 0; var0 < j.length; ++var0) {
         j[var0] = new mFont((byte)-1);
         switch(var0) {
         case 0:
            d = j[var0];
            break;
         case 1:
            e = j[var0];
            break;
         case 2:
            f = j[var0];
            break;
         case 3:
            h = j[var0];
            break;
         case 4:
            g = j[var0];
            break;
         case 5:
            b = j[var0];
            break;
         case 6:
            c = j[var0];
         }

         i[var0] = new LangLa_fw(var0);
      }

   }
}
