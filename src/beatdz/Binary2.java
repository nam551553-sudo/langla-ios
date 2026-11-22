package beatdz;import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Blending;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;


public class Binary2 {
   private static int[] c = new int[]{768, 769, 771, 777, 803};
   private static char[] d = new char[]{'a', 'ă', 'â', 'e', 'ê', 'i', 'y', 'o', 'ô', 'ơ', 'u', 'ư'};
   private static char[][] e = new char[][]{{'à', 'á', 'ã', 'ả', 'ạ'}, {'ằ', 'ắ', 'ẵ', 'ẳ', 'ặ'}, {'ầ', 'ấ', 'ẫ', 'ẩ', 'ậ'}, {'è', 'é', 'ẽ', 'ẻ', 'ẹ'}, {'ề', 'ế', 'ễ', 'ể', 'ệ'}, {'ì', 'í', 'ĩ', 'ỉ', 'ị'}, {'ỳ', 'ý', 'ỹ', 'ỷ', 'ỵ'}, {'ò', 'ó', 'õ', 'ỏ', 'ọ'}, {'ồ', 'ố', 'ỗ', 'ổ', 'ộ'}, {'ờ', 'ớ', 'ỡ', 'ở', 'ợ'}, {'ù', 'ú', 'ũ', 'ủ', 'ụ'}, {'ừ', 'ứ', 'ữ', 'ử', 'ự'}};
   
   private static Object f = new Object();
   

   public static String a(String var0) {
      return Binary.a + MobileAssets.cacheName(MultiSession.storageName(var0)) + ".beatdz";
   }

   public static String a(String var0, String var1) {
      return Binary.a + MobileAssets.cacheName(MultiSession.storageName(var0)) + "." + var1;
   }

   public static Reader b(String var0) {
      var0 = var0.substring(1);
      return new Reader(Utlis.internal(var0).read());
   }

   private static mImage a(mImage var0, int var1) {
      var0 = mImage.a(var0, 0, 0, var0.c, var0.d, 0);
      if (var1 == -1) {
         return var0;
      } else {
         Color var2 = new Color();
         Color var3 = new Color();
         Color.argb8888ToColor(var2, var1);

         for(var1 = 0; var1 < var0.d; ++var1) {
            for(int var4 = 0; var4 < var0.c; ++var4) {
               Color.rgba8888ToColor(var3, var0.b.getPixel(var4, var1));
               if (var3.a > 0.0F) {
                  var2.a = var3.a;
                  a(var0, var4, var1, Color.rgba8888(var2));
               }
            }
         }

         return var0;
      }
   }

   public static mImage a(mImage var0, int var1, int var2) {
      if (mConfig.gI().readByte(18) > 1) {
         return beatdz.LangLa_fq.$state_LangLa_fq().a;
      } else {
         mImage var3;
         mImage var6;
         if (var2 == 0) {
            var3 = Binary.createImage(var0.c, var0.d);
            var6 = a(var0, var1);
            a(var3.b, var6.b, 0, 0, Blending.SourceOver);
            var6.a();
            return var3;
         } else {
            var3 = Binary.createImage(var0.c + 2, var0.d + 2);
            var6 = a(var0, var2);
            var0 = a(var0, var1);
            Pixmap var5;
            a(var5 = var3.b, var6.b, 1, 0, Blending.SourceOver);
            a(var5, var6.b, 0, 1, Blending.SourceOver);
            a(var5, var6.b, 1, 2, Blending.SourceOver);
            a(var5, var6.b, 2, 1, Blending.SourceOver);
            a(var5, var0.b, 1, 1, Blending.SourceOver);
            var6.a();
            var0.a();
            return var3;
         }
      }
   }

   public static mImage b(mImage var0, int var1, int var2) {
      try {
         mImage var3;
         a((var3 = Binary.createImage(var1, var2)).b, var0.b, 0, 0, var0.c, var0.d, 0, 0, var1, var2, Blending.None);
         mImage var9 = var3;
         return var9;
      } catch (Exception var7) {
      } finally {
         var0.a();
      }

      return null;
   }

   public static void a(Graphics var0, mImage var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13) {
      var6 = var4 * DataCenter.gI().zoomLevel;
      var7 = var5 * DataCenter.gI().zoomLevel;
      var0.a(var1, var2, var3, var6, var7, var8, var9, var10, var11, var12, var13);
   }

   public static void a(Graphics var0, mImage var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      a(var0, var1, var2, var3, var4, var5, 0, 0, var6, var7, var8, var9, var10, var11);
   }

   public static void a(Graphics var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      LangLa_fq.a(var0, var1, var2, var3, var4, var5 * DataCenter.gI().zoomLevel, var6 * DataCenter.gI().zoomLevel, 0, 0, 0, 0, 20);
   }

   public static void b(Graphics var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      LangLa_fq.a(var0, var1, var2, var3, var4, var5 * DataCenter.gI().zoomLevel, var6 * DataCenter.gI().zoomLevel, 0, 0, 0, 0, 20);
   }

   public static void a(Graphics var0, int var1, int var2, int var3, int var4, int var5) {
      LangLa_fq.a(var0, var1, var2, var3, var4, var5, 20);
   }

   public static void a(Graphics var0, int var1, int var2, int var3, int var4, int var5, byte var6) {
      LangLa_fq.a(var0, var1, var2, var3, var4, var5, var6);
   }

   public static void a(Graphics var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      if (var5 != 0) {
         a(var0, var1, 0, var3, var4, var5, (int)20);
      }
   }

   public static void a(mTextBox var0, String var1, String var2, int var3, int var4, boolean var5) {
      if (mConfig.gI().readByte(9) == 1) {
         LangLa_dn var10000 = new LangLa_dn(var0);
         String var10001 = var2;
         String var7 = "";
         var2 = var1;
         var1 = var10001;
         LangLa_dn var6 = var10000;


         LangLa_dd.a.a(var6, var1, var2, var7);
      } else if (mConfig.gI().readByte(9) == 0) {
         beatdz.Binary2.$state_Binary2().a = new LangLa_dl(DataCenter.gI().currentScreen, var0, false, true);
         DataCenter.gI().currentScreen.a((LangLa_cx)beatdz.Binary2.$state_Binary2().a);
      }

   }

   public static void a(mTextBox var0, String var1, String var2, int var3, int var4) {
      beatdz.Binary2.$state_Binary2().a = new LangLa_dl(DataCenter.gI().currentScreen, var0, false, false);
      DataCenter.gI().currentScreen.a((LangLa_cx)beatdz.Binary2.$state_Binary2().a);
   }

   public static mImage a(String var0, MainScreen var1) {
      Reader var15 = null;
      boolean var9 = false;

      mImage var16;
      label114: {
         try {
            var9 = true;
            byte[] var2;
            Utlis.a(var2 = (var15 = b("/" + var0)).readFully());
            var16 = Binary.createImage(var2);
            if (DataCenter.gI().zoomLevel != 4) {
               var16 = b(var16, var16.c * DataCenter.gI().zoomLevel / 4, var16.d * DataCenter.gI().zoomLevel / 4);
            }

            if (var0.equals("a") || var0.equals("d") || var0.equals("e")) {
               beatdz.MainScreen.$state_MainScreen().cC.add(var16);
            }

            var16 = var16;
            var9 = false;
            break label114;
         } catch (Exception var13) {
            Utlis.println("not found: " + var0);
            var9 = false;
         } finally {
            if (var9) {
               try {
                  if (var15 != null) {
                     var15.close();
                  }
               } catch (Exception var10) {
                  Utlis.println(var10);
               }

            }
         }

         try {
            if (var15 != null) {
               var15.close();
            }
         } catch (Exception var11) {
            Utlis.println(var11);
         }

         return beatdz.LangLa_fq.$state_LangLa_fq().a;
      }

      try {
         var15.close();
      } catch (Exception var12) {
         Utlis.println(var12);
      }

      return var16;
   }

   public static void a(Vector var0) {
      try {
         for(int var2 = 0; var2 < var0.size(); ++var2) {
            try {
               mImage var1;
               if ((var1 = (mImage)var0.get(var2)) != null) {
                  var1.a();
               }
            } catch (Exception var3) {
            }
         }

         var0.clear();
      } catch (Exception var4) {
      }
   }

   public static void a(Hashtable var0) {
      try {
         Iterator var2 = var0.keySet().iterator();

         while(var2.hasNext()) {
            Object var1 = var2.next();

            try {
               mImage var5;
               if ((var5 = (mImage)var0.get(var1)) != null) {
                  var5.a();
               }
            } catch (Exception var3) {
            }
         }

         var0.clear();
      } catch (Exception var4) {
      }
   }

   public static void a(mImage var0, int var1, int var2, int var3) {
      if (!beatdz.Binary2.$state_Binary2().b) {
         synchronized(f) {
            var0.b.setBlending(Blending.None);
            var0.b.drawPixel(var1, var2, var3);
         }
      } else {
         var0.b.drawPixel(var1, var2, var3);
      }

   }

   public static void a(Pixmap var0, Pixmap var1, int var2, int var3, Blending var4) {
      if (!beatdz.Binary2.$state_Binary2().b) {
         synchronized(f) {
            var0.setBlending(var4);
            var0.drawPixmap(var1, var2, var3, 0, 0, var1.getWidth(), var1.getHeight());
         }
      } else {
         var0.drawPixmap(var1, var2, var3, 0, 0, var1.getWidth(), var1.getHeight());
      }

   }

   public static void a(Pixmap var0, Pixmap var1, int var2, int var3, int var4, int var5, int var6, int var7, Blending var8) {
      if (!beatdz.Binary2.$state_Binary2().b) {
         synchronized(f) {
            var0.setBlending(var8);
            var0.drawPixmap(var1, var2, var3, var4, var5, var6, var7);
         }
      } else {
         var0.drawPixmap(var1, var2, var3, var4, var5, var6, var7);
      }

   }

   public static void a(Pixmap var0, Pixmap var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, Blending var10) {
      if (!beatdz.Binary2.$state_Binary2().b) {
         synchronized(f) {
            ImageSampling.resize(var0, var4, var5, var8, var9);
            var0.setBlending(var10);
            var0.drawPixmap(var1, 0, 0, var4, var5, var6, var7, var8, var9);
         }
      } else {
         ImageSampling.resize(var0, var4, var5, var8, var9);
         var0.drawPixmap(var1, 0, 0, var4, var5, var6, var7, var8, var9);
      }

   }

   public static void a(Pixmap var0, Pixmap var1, int var2, int var3, int var4, int var5, Blending var6) {
      if (!beatdz.Binary2.$state_Binary2().b) {
         synchronized(f) {
            var0.setBlending(var6);
            int var9;
            if (var4 == 0) {
               for(var9 = var3; var9 < var5 + var3; var9 += var1.getHeight()) {
                  if (var9 + var1.getHeight() >= var5 + var3) {
                     var9 = var5 + var3 - var1.getHeight();
                     var0.drawPixmap(var1, var2, var9);
                     break;
                  }

                  var0.drawPixmap(var1, var2, var9);
               }
            } else {
               for(var9 = var2; var9 < var4 + var2; var9 += var1.getWidth()) {
                  if (var9 + var1.getWidth() >= var4 + var2) {
                     var9 = var4 + var2 - var1.getWidth();
                     var0.drawPixmap(var1, var9, var3);
                     break;
                  }

                  var0.drawPixmap(var1, var9, var3);
               }
            }
         }
      } else {
         int var7;
         if (var4 == 0) {
            var7 = var3;

            while(true) {
               if (var7 >= var5 + var3) {
                  return;
               }

               if (var7 + var1.getHeight() >= var5 + var3) {
                  var7 = var5 + var3 - var1.getHeight();
                  var0.drawPixmap(var1, var2, var7);
                  break;
               }

               var0.drawPixmap(var1, var2, var7);
               var7 += var1.getHeight();
            }
         } else {
            for(var7 = var2; var7 < var4 + var2; var7 += var1.getWidth()) {
               if (var7 + var1.getWidth() >= var4 + var2) {
                  var7 = var4 + var2 - var1.getWidth();
                  var0.drawPixmap(var1, var7, var3);
                  return;
               }

               var0.drawPixmap(var1, var7, var3);
            }
         }
      }

   }

   
   static char[] a() {
      return d;
   }

   
   static int[] b() {
      return c;
   }

   
   static char[][] c() {
      return e;
   }

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public LangLa_dl a;
public boolean b;
public void initialize() {
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.Binary2");
public static SessionState $state_Binary2() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
