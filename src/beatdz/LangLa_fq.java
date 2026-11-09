package beatdz;import beatdz.*;

import beatdz.DataCenter;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;

public class LangLa_fq {
   
   
   
   
   
   
   
   
   
   
   
   

   private static boolean c(int var0) {
      return var0 == 3 || var0 == 4 || var0 == 24 || var0 == 80 || var0 <= -2 && var0 > -2000;
   }

   public static mImage a(int var0) {
      mImage var1;
      if ((var1 = (mImage)beatdz.LangLa_fq.$state_LangLa_fq().e.get((short)var0)) == null) {
         // New account tabs skip the initial download screen. Read an existing UI
         // image before measuring controls; a 1x1 placeholder corrupts their layout.
         var1 = Binary.createImage("client_icon_" + var0);
         if (var1 != null) {
            beatdz.LangLa_fq.$state_LangLa_fq().e.put((short)var0, var1);
            return var1;
         }
         a(var0, "client", beatdz.LangLa_fq.$state_LangLa_fq().e);
         var1 = beatdz.LangLa_fq.$state_LangLa_fq().a;
      }

      return var1;
   }

   public static mImage b(int var0) {
      return Binary.createImage("client_icon_" + var0);
   }

   public static short[] a(Graphics var0, int var1, int var2, int var3, int var4, int var5) {
      if (var1 == 713) {
         if (DataCenter.gI().i % 7 == 0) {
            if (!beatdz.LangLa_fq.$state_LangLa_fq().k) {
               beatdz.LangLa_fq.$state_LangLa_fq().l += 4;
            } else {
               beatdz.LangLa_fq.$state_LangLa_fq().l -= 4;
            }

            if (beatdz.LangLa_fq.$state_LangLa_fq().l == 0) {
               beatdz.LangLa_fq.$state_LangLa_fq().k = false;
            } else if (beatdz.LangLa_fq.$state_LangLa_fq().l == 40) {
               beatdz.LangLa_fq.$state_LangLa_fq().k = true;
            }
         }

         var0.d(100 - beatdz.LangLa_fq.$state_LangLa_fq().l / 2);
         Binary2.a(var0, var1, var2, var3 + 4, var4 + 4, 100 - beatdz.LangLa_fq.$state_LangLa_fq().l, (byte)3);
         var0.m = 1.0F;
         return new short[]{0, 0};
      } else if (c(var1)) {
         var0.a(var0, var1, var2, var3, var4, 20 * DataCenter.gI().zoomLevel, 20 * DataCenter.gI().zoomLevel);
         return new short[]{20, 20};
      } else {
         return a(var0, var1, var2, var3, var4, 0, 0, var5, "client", beatdz.LangLa_fq.$state_LangLa_fq().e, (byte)0, beatdz.LangLa_fq.$state_LangLa_fq().b, DataCenter.gI().aj);
      }
   }

   public static short[] a(Graphics var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      try {
         Short var9 = new Short((short)var1);
         mImage var10;
         if ((var10 = (mImage)beatdz.LangLa_fq.$state_LangLa_fq().f.get(var9)) != null) {
            var0.a(var10, 0, 0, var10.c, var10.d, var2, var3 - var5 / 2, var4 - var6, var5 * DataCenter.gI().zoomLevel, var6 * DataCenter.gI().zoomLevel, 20);
         } else {
            a(var1, "tree", beatdz.LangLa_fq.$state_LangLa_fq().f);
         }

         return new short[]{(short)var10.c, (short)var10.d};
      } catch (Exception var8) {
         return new short[]{0, 0};
      }
   }

   public static short[] b(Graphics var0, int var1, int var2, int var3, int var4, int var5) {
      return a(var0, var1, var2, var3, var4, 0, 0, var5, "char", beatdz.LangLa_fq.$state_LangLa_fq().g, (byte)2, beatdz.LangLa_fq.$state_LangLa_fq().d, DataCenter.gI().ak);
   }

   static void drawCapeRows(Graphics graphics, short icon, int transform, int x, int bottom,
                            int width, int height, int firstRow, int endRow) {
      Hashtable images = $state_LangLa_fq().g;
      mImage sprite = (mImage) images.get(icon);
      if (sprite == null) {
         a(icon, "char", images);
         return;
      }
      if (sprite.c <= 1 && sprite.d <= 1) return;

      int sourceTop = Math.round(firstRow * sprite.d / (float) height);
      int sourceBottom = Math.round(endRow * sprite.d / (float) height);
      if (sourceTop >= sourceBottom) return;

      int zoom = DataCenter.gI().zoomLevel;
      graphics.drawImagePixelRows(sprite, sourceTop, sourceBottom - sourceTop,
              transform, x, bottom, width * zoom, (endRow - firstRow) * zoom);
   }

   public static short[] b(Graphics var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      return a(var0, var1, var2, var3, var4, 51, var6, 33, "char", beatdz.LangLa_fq.$state_LangLa_fq().g, (byte)2, beatdz.LangLa_fq.$state_LangLa_fq().d, DataCenter.gI().ak);
   }

   public static short[] c(Graphics var0, int var1, int var2, int var3, int var4, int var5) {
      return a(var0, var1, var2, var3, var4, 3, "char", beatdz.LangLa_fq.$state_LangLa_fq().g, (byte)2, beatdz.LangLa_fq.$state_LangLa_fq().d, DataCenter.gI().ak);
   }

   private static short[] a(Graphics var0, int var1, int var2, int var3, int var4, int var5, String var6, Hashtable var7, byte var8, Hashtable var9, Hashtable var10) {
      try {
         Short var15 = new Short((short)var1);
         mImage var16;
         if ((var16 = (mImage)var7.get(var15)) == null) {
            a(var1, var6, var7);
         }

         if (var0 != null && var16 != null && (var16.c > 1 || var16.d > 1)) {
            if (var6.equals("tree")) {
               var0.a(var16, 0, 0, var16.c, var16.d, var2, var3, var4, 20);
            } else if (var6.equals("char")) {
               LangLa_et var12;
               int var14 = (var12 = (LangLa_et)var10.get(var15)).d * DataCenter.gI().zoomLevel;
               var1 = var12.e * DataCenter.gI().zoomLevel;
               var0.b(var16, 0, 0, var16.c, var16.d, var2, var3, var4, var14, var1, var5);
            } else {
               boolean var13 = true;
               var0.l = var13;
               var0.a(var16, 0, 0, var16.c, var16.d, var2, var3, var4, var5);
               var13 = false;
               var0.l = var13;
            }

            return new short[]{(short)var16.c, (short)var16.d};
         }
      } catch (Exception var11) {
      }

      return new short[]{0, 0};
   }

   private static short[] a(Graphics var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, String var8, Hashtable var9, byte var10, Hashtable var11, Hashtable var12) {
      try {
         Short var20 = new Short((short)var1);
         mImage var22;
         if ((var22 = (mImage)var9.get(var20)) == null) {
            a(var1, var8, var9);
         }

         if (var0 != null && var22 != null && (var22.c > 1 || var22.d > 1)) {
            String var14 = var8;
            byte var17 = -1;
            switch(var14.hashCode()) {
            case -1357712437:
               if (var14.equals("client")) {
                  var17 = 2;
               }
               break;
            case 3052374:
               if (var14.equals("char")) {
                  var17 = 1;
               }
               break;
            case 3568542:
               if (var14.equals("tree")) {
                  var17 = 0;
               }
            }

            switch(var17) {
            case 0:
               var0.a(var22, 0, 0, var22.c, var22.d, var2, var3, var4, 20);
               break;
            case 1:
               LangLa_et var15;
               if ((var15 = (LangLa_et)var12.get(var20)) == null) {
                  var15 = (LangLa_et)DataCenter.gI().am.get(var20);
               }

               int var19 = var15.d * DataCenter.gI().zoomLevel;
               int var18 = var15.e * DataCenter.gI().zoomLevel;
               boolean var21 = var0.k && var2 < 0;
               if ((var5 > 0 || var6 > 0) && var5 <= var15.d && var6 <= var15.e) {
                  var19 = var5 * DataCenter.gI().zoomLevel;
                  var18 = var6 * DataCenter.gI().zoomLevel;
                  if (var21) {
                     var0.b(var22, 0, var15.e - var6, var22.c, var18, var2, var3, var4, var19, var18, var7);
                  } else {
                     var0.a(var22, 0, var15.e - var6, var22.c, var18, var2, var3, var4, var19, var18, var7);
                  }
               } else if (var21) {
                  var0.b(var22, 0, 0, var22.c, var22.d, var2, var3, var4, var19, var18, var7);
               } else {
                  var0.a(var22, 0, 0, var22.c, var22.d, var2, var3, var4, var19, var18, var7);
               }
               break;
            case 2:
               boolean var16 = true;
               var0.l = var16;
               var0.a(var22, 0, 0, var22.c, var22.d, var2, var3, var4, var7);
               var16 = false;
               var0.l = var16;
            }

            return new short[]{(short)var22.c, (short)var22.d};
         }
      } catch (Exception var13) {
      }

      return new short[]{0, 0};
   }

   public static short[] a(Graphics var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      return a(var0, var1, var2, var3, var4, var5, var6, "client", beatdz.LangLa_fq.$state_LangLa_fq().e, (byte)0, beatdz.LangLa_fq.$state_LangLa_fq().b, DataCenter.gI().aj);
   }

   public static short[] a(Graphics var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      if (c(var1)) {
         var0.a(var0, var1, 0, var3, var4, var5, var6);
         return new short[]{20, 20};
      } else {
         return a(var0, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, "client", beatdz.LangLa_fq.$state_LangLa_fq().e, (byte)0, beatdz.LangLa_fq.$state_LangLa_fq().b, DataCenter.gI().aj);
      }
   }

   private static short[] a(Graphics var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, String var12, Hashtable var13, byte var14, Hashtable var15, Hashtable var16) {
      try {
         Short var19 = new Short((short)var1);
         Object var20;
         if ((var20 = var13.get(var19)) != null) {
            Graphics var10000;
            mImage var10001;
            mImage var18;
            int var10002;
            int var10003;
            int var10004;
            int var10005;
            label37: {
               var18 = (mImage)var20;
               if (var1 != 101 && var1 != 102) {
                  var10000 = var0;
                  var10001 = var18;
                  var10002 = var7;
                  var10003 = var8;
                  var10004 = var9 == 0 ? var18.c / DataCenter.gI().zoomLevel : var9;
                  if (var10 == 0) {
                     var10005 = var18.d / DataCenter.gI().zoomLevel;
                     break label37;
                  }
               } else {
                  var10000 = var0;
                  var10001 = var18;
                  var10002 = var7;
                  var10003 = var8;
                  var10004 = var9;
               }

               var10005 = var10;
            }

            Binary2.a(var10000, var10001, var10002, var10003, var10004, var10005, 0, 0, var2, var3, var4, var5, var6, var11);
            return new short[]{(short)var18.c, (short)var18.d};
         }

         a(var1, var12, var13);
      } catch (Exception var17) {
      }

      return new short[]{0, 0};
   }

   private static short[] a(Graphics var0, int var1, int var2, int var3, int var4, int var5, int var6, String var7, Hashtable var8, byte var9, Hashtable var10, Hashtable var11) {
      try {
         Short var15 = new Short((short)var1);
         Object var16;
         if ((var16 = var8.get(var15)) != null) {
            mImage var13 = (mImage)var16;
            boolean var14 = true;
            var0.k = var14;
            Binary2.a(var0, var13, 0, 0, var13.c / DataCenter.gI().zoomLevel, var13.d / DataCenter.gI().zoomLevel, 0, 0, var2, var3, var4, var13.c * var5 / 100, var13.d * var5 / 100, var6);
            var14 = false;
            var0.k = var14;
            return new short[]{(short)var13.c, (short)var13.d};
         }

         a(var1, var7, var8);
      } catch (Exception var12) {
      }

      return new short[]{0, 0};
   }

   public static int a(mImage var0) {
      return var0 == null ? 0 : var0.c / DataCenter.gI().zoomLevel;
   }

   public static int b(mImage var0) {
      return var0 == null ? 0 : var0.d / DataCenter.gI().zoomLevel;
   }

   public static void a() {
      try {
         while(!DataCenter.gI().ba) {
            Thread.sleep(100L);
         }

         Iterator var0 = beatdz.LangLa_fq.$state_LangLa_fq().d.keySet().iterator();

         while(var0.hasNext()) {
            Object var1 = var0.next();
            Binary.delete("char_" + var1 + ".beatdz");
         }

         Binary2.a(beatdz.LangLa_fq.$state_LangLa_fq().d);
         c();
      } catch (Exception var2) {
      }
   }

   public static void b() {
      try {
         while(!DataCenter.gI().ba) {
            Thread.sleep(100L);
         }

         Iterator var0 = beatdz.LangLa_fq.$state_LangLa_fq().b.keySet().iterator();

         while(var0.hasNext()) {
            Object var1 = var0.next();
            Binary.delete("client_" + var1 + ".beatdz");
         }

         Binary2.a(beatdz.LangLa_fq.$state_LangLa_fq().b);
         a(true);
      } catch (Exception var2) {
      }
   }

   public static void a(boolean var0) {
      try {
         beatdz.LangLa_fq.$state_LangLa_fq().i.clear();
         Binary2.a(beatdz.LangLa_fq.$state_LangLa_fq().e);
         short[] var1 = new short[]{1, 2, 5, 14, 17, 20, 34, 36, 38, 49, 55, 56, 59, 67, 68, 69, 70, 71, 72, 73, 75, 76, 77, 78, 81, 82, 84, 87, 88, 89, 90, 94, 98, 99, 305, 375, 376, 553, 554, 643, 644, 645, 646, 504, 505, 506, 647, 648, 660, 687, 705, 706, 751, 752, 1023, 1024, 1025, 1026, 460, 329, 330, 331, 332, 333, 334, 335, 336, 337, 338, 339, 340, 341, 342, 343, 344, 345, 346, 347, 348, 349, 350, 351, 352, 353, 354, 355, 356, 357, 358, 359, 620, 621, 622, 623, 624, 625, 626, 627, 628, 924, 925, 926, 927, 928, 929, 930, 931, 932, 979, 980, 981, 982, 983, 984};

         for(int var2 = 0; var2 < 114; ++var2) {
            beatdz.LangLa_fq.$state_LangLa_fq().i.add(var1[var2]);
         }

         for(short var9 = 461; var9 <= 503; ++var9) {
            beatdz.LangLa_fq.$state_LangLa_fq().i.add(var9);
         }

         String var10 = "iconClient";

         for(int var8 = 0; var8 < beatdz.LangLa_fq.$state_LangLa_fq().i.size(); ++var8) {
            try {
               short var3 = (Short)beatdz.LangLa_fq.$state_LangLa_fq().i.get(var8);
               String var4;
               byte[] var5;
               if ((var5 = Binary.read(var4 = "client_icon_" + var3)) == null) {
                  if (var0) {
                     StringBuilder var10000 = (new StringBuilder()).append(DataCenter.gI().aU).append("img/zoom");
                     DataCenter.gI();
                     if ((var5 = Binary.b(var10000.append(DataCenter.a(var10) + 1).append("/iconClient/").append(var3).append(".png").toString())) != null) {
                        Binary.write(var4, var5);
                        beatdz.LangLa_fq.$state_LangLa_fq().e.put(var3, Binary.createImage(Utlis.a(var5)));
                     } else {
                        beatdz.LangLa_fq.$state_LangLa_fq().e.put(var3, beatdz.LangLa_fq.$state_LangLa_fq().a);
                     }
                  } else {
                     beatdz.LangLa_fq.$state_LangLa_fq().e.put(var3, beatdz.LangLa_fq.$state_LangLa_fq().a);
                  }
               } else {
                  beatdz.LangLa_fq.$state_LangLa_fq().e.put(var3, Binary.createImage(var5));
               }
            } catch (Exception var6) {
            }
         }

         Binary2.a(beatdz.LangLa_fq.$state_LangLa_fq().b);
      } catch (Exception var7) {
      }

      DataCenter.gI().bb = true;
   }

   public static void c() {
      beatdz.LangLa_fq.$state_LangLa_fq().j.clear();
      Binary2.a(beatdz.LangLa_fq.$state_LangLa_fq().g);
      Binary2.a(beatdz.LangLa_fq.$state_LangLa_fq().d);
   }

   public static void b(Graphics var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      a(var0, var1, 0, var3, var4, 20);
      a(var0, var1, -360, var3 + var5 - 4, var4, 20);
      Binary2.a(var0, var2, 0, var3 + 4, var4, var5 - 8, (int)var6);
   }

   public static void a(short var0) {
      mImage var1;
      if ((var1 = Binary.createImage("client_icon_" + var0)) != null) {
         beatdz.LangLa_fq.$state_LangLa_fq().e.put(var0, var1);
      }

   }

   public static void d() {
      Binary2.a(beatdz.LangLa_fq.$state_LangLa_fq().b);
      Binary2.a(beatdz.LangLa_fq.$state_LangLa_fq().e);
      Binary2.a(beatdz.LangLa_fq.$state_LangLa_fq().d);
      Binary2.a(beatdz.LangLa_fq.$state_LangLa_fq().g);
      e();
   }

   public static void e() {
      Binary2.a(beatdz.LangLa_fq.$state_LangLa_fq().c);
      Binary2.a(beatdz.LangLa_fq.$state_LangLa_fq().f);
   }

   private static void a(int var0, String var1, Hashtable var2) {
      if ("tree".equals(var1)) {
         mImage ready = MapAssetPrefetch.take((short)var0);
         if (ready != null) { var2.put((short)var0, ready); GameSrc.gI().cb.add(ready); return; }
      }
      mImage var3 = beatdz.LangLa_fq.$state_LangLa_fq().a;
      var2.put(new Short((short)var0), var3);
      if (!mConfig.gI().readBoolean(18) || !(DataCenter.gI().currentScreen instanceof GameSrc) || !var1.toLowerCase().contains("char") && !var1.toLowerCase().contains("tree")) {
         LangLa_fb var4;
         (var4 = new LangLa_fb()).g = var2;
         var4.a = (short)var0;
         var4.d = "icon" + var1.substring(0, 1).toUpperCase() + var1.substring(1, var1.length()) + "/" + var0 + ".png";
         if (var1.toLowerCase().contains("tree")) {
            var4.e = var1 + "_" + var0;
         } else {
            var4.e = var1 + "_icon_" + var0;
         }

         beatdz.LangLa_cz.$state_LangLa_cz().cW.add(var4);
         LangLa_cz.S();
      }

   }

   public static Vector f() {
      Vector var0 = new Vector();

      try {
         Iterator var2 = beatdz.LangLa_fq.$state_LangLa_fq().f.keySet().iterator();

         while(var2.hasNext()) {
            Object var1 = var2.next();

            try {
               mImage var5;
               if ((var5 = (mImage)beatdz.LangLa_fq.$state_LangLa_fq().f.get(var1)) != null) {
                  var0.add(var5);
               }
            } catch (Exception var3) {
            }
         }
      } catch (Exception var4) {
      }

      return var0;
   }

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public mImage a;
public Hashtable b;
public Hashtable c;
public Hashtable d;
public Hashtable e;
public Hashtable f;
public Hashtable g;
public Vector h;
public Vector i;
public Vector j;
public boolean k;
public int l;
public void initialize() {
this.a = Binary.createImage(1, 1);
this.b = new Hashtable();
this.c = new Hashtable();
this.d = new Hashtable();
this.e = new Hashtable();
this.f = new Hashtable();
this.g = new Hashtable();
this.h = new Vector();
this.i = new Vector();
this.j = new Vector();
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.LangLa_fq");
public static SessionState $state_LangLa_fq() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
