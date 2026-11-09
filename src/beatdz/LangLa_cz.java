package beatdz;import java.util.Vector;

public class LangLa_cz extends XYEntity {
   public short width;
   public short height;
   public int cS = 0;
   private int a;
   private String b;
   private boolean c;
   
   
   
   
   
   
   
   private int d = 0;
   private int e = 0;
   private int f = 10;

   public static void S() {
      if (!LangLa_ep.a()) {
         if (!beatdz.LangLa_cz.$state_LangLa_cz().cY) {
            a();
         }
      } else {
         label28:
         while(true) {
            if (beatdz.LangLa_cz.$state_LangLa_cz().cW.size() <= 0) {
               while(true) {
                  if (beatdz.LangLa_cz.$state_LangLa_cz().cX.size() <= 0) {
                     break label28;
                  }

                  b((LangLa_fb)beatdz.LangLa_cz.$state_LangLa_cz().cX.remove(0));
               }
            }

            a((LangLa_fb)beatdz.LangLa_cz.$state_LangLa_cz().cW.remove(0));
         }
      }

      synchronized(beatdz.LangLa_cz.$state_LangLa_cz().cT) {
         beatdz.LangLa_cz.$state_LangLa_cz().cT.notify();
      }
   }

   private static void a() {
      beatdz.LangLa_cz.$state_LangLa_cz().cY = true;
      (new Thread(new LangLa_da())).start();
      (new Thread(new LangLa_db())).start();
      (new Thread(new LangLa_fg(), "map-assets-1")).start();
      (new Thread(new LangLa_fg(), "map-assets-2")).start();
   }

   public void setSize(int var1, int var2) {
      this.width = (short)var1;
      this.height = (short)var2;
   }

   public void a(Graphics var1, int var2, int var3) {
      var1.a(-var1.a, -var1.b);
      var1.a(var2, var3);
   }

   public void a(Graphics var1, int var2, int var3, int var4, int var5, String var6, byte var7) {
      this.a(var1, var2, var3, var4, var5, var6, (byte)2, false);
      if (this.cS >= 2) {
         var2 = var1.a;
         var3 = var1.b;
         this.a(var1, 6, 33, var4 - 12, var5 - 27 - 12, -11, 55, 56);
         this.a(var1, var2, var3);
      }
   }

   public void a(Graphics var1, int var2, int var3, int var4, int var5, String var6, byte var7, boolean var8) {
      int var9 = var1.a;
      int var10 = var1.b;
      this.b = var6;
      this.a = var7;
      this.c = var8;
      this.a(var1, var2, var3);
      Binary2.a(var1, LangLa_fq.a((int)643), 20, 5, var4 - 6, var5 - 6, 0, 3, 3, (var4 - 6) * DataCenter.gI().zoomLevel, (var5 - 6) * DataCenter.gI().zoomLevel, 20);
      Binary2.a(var1, LangLa_fq.a((int)645), 0, 0, 5, 5, 0, 0, 5, 5 * DataCenter.gI().zoomLevel, (var5 - 10) * DataCenter.gI().zoomLevel, 20);
      Binary2.a(var1, LangLa_fq.a((int)645), 0, 0, 5, 5, 180, var4, 5, 5 * DataCenter.gI().zoomLevel, (var5 - 10) * DataCenter.gI().zoomLevel, 24);
      Binary2.a(var1, LangLa_fq.a((int)646), 0, 0, 5, 5, 0, 20, 0, (var4 - 40) * DataCenter.gI().zoomLevel, 5 * DataCenter.gI().zoomLevel, 20);
      Binary2.a(var1, LangLa_fq.a((int)646), 0, 0, 5, 5, 180, 20, var5, (var4 - 40) * DataCenter.gI().zoomLevel, 5 * DataCenter.gI().zoomLevel, 36);
      LangLa_fq.a(var1, 644, -180, 0, var5 - 20, 20);
      LangLa_fq.a(var1, 644, 180, var4 - 20, var5 - 20, 20);
      LangLa_fq.a(var1, 644, -360, var4 - 20, 0, 20);
      LangLa_fq.a(var1, 644, 0, 0, 0, 20);
      if (var7 == 2) {
         mFont.a((mFont)mFont.f, (Graphics)var1, var6, var4 / 2, 15, 2, -2560, 0);
      } else if (var7 == 0) {
         mFont.a((mFont)mFont.f, (Graphics)var1, var6, 10, 15, 0, -2560, 0);
      }

      var1.c();
      this.a(var1, var9, var10);
   }

   public void a(Graphics var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      int var11 = var1.a;
      int var12 = var1.b;
      var1.a(var2, var3);
      Binary2.a(var1, var6, 0, var9, var10, var4 - var9 * 2, (int)(var5 - var10 * 2));
      Binary2.a(var1, var8, 0, 6, 0, var4 - 12, (int)20);
      Binary2.a(var1, var8, 180, 6, var5 - 20, var4 - 12, (int)20);
      Binary2.a(var1, var8, -90, 0, 6, 20, (int)(var5 - 12));
      Binary2.a(var1, var8, 90, var4 - 20, 6, 20, (int)(var5 - 12));
      LangLa_fq.a(var1, var7, 0, 0, 0, 20);
      LangLa_fq.a(var1, var7, -360, var4, 0, 24);
      LangLa_fq.a(var1, var7, -180, 0, var5, 36);
      LangLa_fq.a(var1, var7, 180, var4, var5, 40);
      this.a(var1, var11, var12);
   }

   public void a(Graphics var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      this.a(var1, var2, var3, var4, var5, var6, var7, var8, 3, 3);
   }

   public void b(Graphics var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      var2 = var1.a;
      var3 = var1.b;
      var1.a(0, 0);
      Binary2.a(var1, 314, 0, 2, 2, var4 - 3, (int)(var5 - 3));
      var1.f(-11657441);
      var1.b(0, 0, var4 - 1, var5 - 1);
      var1.f(-9490898);
      var1.b(1, 1, var4 - 3, var5 - 3);
      this.a(var1, var2, var3);
   }

   public static void a(Graphics var0, int var1, int var2, String var3, byte var4) {
      var1 = var1 + mFont.b(mFont.d, var3) + 5;
      if (var4 == 7) { LucDaoShopUI.drawCard(var0,var1 - 3,var2 - 7);return; }
      switch(var4) {
      case 0:
      case 1:
         LangLa_fq.a(var0, 35, 0, var1 + 1, var2 - 7, 0);
         break;
      case 2:
      case 3:
         LangLa_fq.a(var0, 25, 0, var1, var2 - 6, 0);
         break;
      case 4:
      case 5:
         LangLa_fq.a(var0, 234, 0, var1 - 3, var2 - 6, 0);
         break;
      case 6:
         LangLa_fq.a(var0, 377, 0, var1 - 3, var2 - 6, 0);
      }

      if (var4 == 7) { LucDaoShopUI.drawCard(var0,var1 - 3,var2 - 7);return; }
      switch(var4) {
      case 1:
      case 5:
         LangLa_fq.a(var0, 44, 0, var1 + 10, var2, 0);
         return;
      case 3:
         LangLa_fq.a(var0, 44, 0, var1 + 10, var2 - 1, 0);
      case 2:
      case 4:
      default:
      }
   }

   public static void a(Graphics var0, int var1, int var2, Item var3, boolean var4, int var5) {
      a(var0, var1, var2, var3, var4, true, var5, (String)null);
   }

   public static void a(Graphics var0, int var1, int var2, Item var3, boolean var4, String var5) {
      a(var0, var1, var2, var3, var4, true, -1, var5);
   }

   public static void a(Graphics var0, int var1, int var2, Item var3, boolean var4) {
      a(var0, var1, var2, var3, var4, true, -1, (String)null);
   }

   public static void b(Graphics var0, int var1, int var2, Item var3, boolean var4) {
      a(var0, var1, var2, var3, var4, false, -1, (String)null);
   }

   public static void b(Graphics var0, int var1, int var2, Item var3, boolean var4, String var5) {
      a(var0, var1, var2, var3, var4, false, -1, var5);
   }

   private static void a(Graphics var0, int var1, int var2, Item var3, boolean var4, boolean var5, int var6, String var7) {
      LangLa_fq.a(var0, 53, 0, var1, var2, 0);
      if (var6 >= 0 && var3 == null) {
         LangLa_fq.a(var0, var6, 0, var1 + 14, var2 + 14, 3);
      }

      if (var3 == null && var7 != null) {
         String[] var8;
         if ((var8 = Utlis.split(var7, " ")).length >= 2) {
            mFont.a((mFont)mFont.b, (Graphics)var0, var8[0], var1 + 14, var2 + 10, 2, -1, -10275328);
            mFont.a((mFont)mFont.b, (Graphics)var0, var8[1], var1 + 14, var2 + 18, 2, -1, -10275328);
         } else {
            mFont.a((mFont)mFont.b, (Graphics)var0, var8[0], var1 + 14, var2 + 14, 2, -1, -10275328);
         }
      }

      int var9 = var0.a;
      var6 = var0.b;
      if (var3 != null) {
         var0.a(-var0.a + var9 + var1 + 14, -var0.b + var6 + var2 + 15);
         var3.a(var0);
      }

      var0.a(-var0.a + var9, -var0.b + var6);
      if (var3 != null) {
         if (var3.getAmount() > 1) {
            if (var3.getAmount() >= 1000000000) {
               mFont.d(mFont.b, var0, var3.getAmount() / 1000000 + "M", var1 + 26, var2 + 23, 1, -1, -10275328);
            } else if (var3.getAmount() >= 1000000) {
               mFont.d(mFont.b, var0, var3.getAmount() / 1000 + "K", var1 + 26, var2 + 23, 1, -1, -10275328);
            } else {
               mFont.d(mFont.b, var0, "" + var3.getAmount(), var1 + 26, var2 + 23, 1, -1, -10275328);
            }
         }

         if (var3.isLock) {
            Binary2.a(var0, 44, 0, var1 + 3, var2 + 3, 6, (int)7);
         }
      }

      if (var4) {
         var0.f(-1);
         var0.b(var1, var2, 28, 28);
      }

   }

   public static LangLa_hx a(String var0, LangLa_cx var1, int var2, int var3, int var4) {
      LangLa_hx var5;
      if ((var5 = new LangLa_hx(var2, var3, var4, var1, var0)).cx > DataCenter.gI().widthScreen - var5.width - var1.cx) {
         var5.cx = (short)(DataCenter.gI().widthScreen - var5.width - var1.cx);
      }

      if (var5.cx < var2) {
         var5.cx = (short)(var2 - (var5.width + 3));
      }

      if (var5.cx < -var1.cx) {
         var5.cx = (short)(-var1.cx);
      }

      if (var5.cy > DataCenter.gI().heightScreen - var5.height - var1.cy) {
         var5.cy = (short)(DataCenter.gI().heightScreen - var5.height - var1.cy);
      }

      var1.a(var5);
      return var5;
   }

   public static LangLa_fe a(String var0, String var1, LangLa_cx var2, int var3, int var4) {
      LangLa_fe var5 = new LangLa_fe(var3, var4, var2, var0, var1);
      var2.a(var5);
      return var5;
   }

   public static LangLa_cb b(String var0, LangLa_cx var1, int var2, int var3, int var4) {
      LangLa_cb var5;
      if ((var5 = new LangLa_cb(var2, var3, var1, var0)).cx > DataCenter.gI().widthScreen - var5.width - var1.cx) {
         var5.cx = (short)(DataCenter.gI().widthScreen - var5.width - var1.cx);
      }

      if (var5.cx < var2 - var4 / 2) {
         var5.cx = (short)(var2 - (var5.width + var4 + 3));
      }

      if (var5.cx < -var1.cx) {
         var5.cx = (short)(-var1.cx);
      }

      if (var5.cy > DataCenter.gI().heightScreen - var5.height - var1.cy) {
         var5.cy = (short)(DataCenter.gI().heightScreen - var5.height - var1.cy);
      }

      var1.a(var5);
      return var5;
   }

   public static LangLa_kn a(LangLa_cx var0, int var1, int var2, LangLa_kd var3) {
      LangLa_kn var4;
      if ((var4 = new LangLa_kn(var1, var2, var0, var3)).cx > DataCenter.gI().widthScreen - var4.width - var0.cx) {
         var4.cx = (short)(DataCenter.gI().widthScreen - var4.width - var0.cx);
      }

      if (var4.cx < -var0.cx) {
         var4.cx = (short)(-var0.cx);
      }

      if (var4.cy > DataCenter.gI().heightScreen - var4.height - var0.cy) {
         var4.cy = (short)(DataCenter.gI().heightScreen - var4.height - var0.cy);
      }

      var0.a(var4);
      return var4;
   }

   public static LangLa_mq a(LangLa_cx var0, int var1, int var2, int var3, Item var4) {
      if (var4 == null) {
         return null;
      } else {
         LangLa_mk var6;
         if ((var6 = new LangLa_mk(var1, var2, 1044, var0, var4)).cx > DataCenter.gI().widthScreen - var6.width - var0.cx) {
            var6.cx = (short)(var1 - var3 - 3 - var6.width);
         } else if (var6.cx < var1 - var3 / 2) {
            var6.cx = (short)(var1 - (var6.width + 3));
         }

         if (var6.cx < -var0.cx) {
            var6.cx = (short)(-var0.cx);
         }

         if (var6.cy > DataCenter.gI().heightScreen - var6.height - var0.cy) {
            var6.cy = (short)(DataCenter.gI().heightScreen - var6.height - var0.cy);
         }

         LangLa_mq var5 = new LangLa_mq(var1 - 32, var2 + 32, var6);
         var0.a(var5);
         return var5;
      }
   }

   public static LangLa_mq a(LangLa_jz var0, LangLa_cx var1, Item var2) {
      if (var2 == null) {
         return null;
      } else {
         LangLa_ij var5;
         if ((var5 = (LangLa_ij)var0.j).k >= 0 && var5.k < var5.i * var5.r) {
            var5.d();
            int var3 = var5.k % var5.r;
            int var4 = var5.k / var5.r - (var5.j >= 0 ? var5.j : 0);
            if (var5.n == 0) {
               var3 = var5.k % var5.i - (var5.j >= 0 ? var5.j : 0);
               var4 = var5.k / var5.i;
            }

            var3 = var3 * var5.h + var5.h + var5.cx;
            var4 = var4 * var5.h + var5.cy;
            return a(var1, var3, var4, var5.h, var2);
         } else {
            return null;
         }
      }
   }

   public static LangLa_mq b(LangLa_jz var0, LangLa_cx var1, Item var2) {
      if (var2 == null) {
         return null;
      } else {
         LangLa_ij var5;
         if ((var5 = (LangLa_ij)var0.j).k >= 0) {
            var5.d();
            int var3 = var5.k % var5.r;
            int var4 = var5.k / var5.r - (var5.j >= 0 ? var5.j : 0);
            if (var5.n == 0) {
               var3 = var5.k % var5.i - (var5.j >= 0 ? var5.j : 0);
               var4 = var5.k / var5.i;
            }

            var3 = var3 * var5.h + var5.h + var5.cx;
            var4 = var4 * var5.h + var5.cy;
            return a(var1, var3, var4, var5.h, var2);
         } else {
            return null;
         }
      }
   }

   public static void a(LangLa_fb var0) {
      mImage var1 = null;

      try {
         if ((var1 = Binary.createImage(var0.e)) != null) {
            var0.g.put(var0.a, var1);
            return;
         }

         beatdz.LangLa_cz.$state_LangLa_cz().cX.add(var0);
         synchronized(beatdz.LangLa_cz.$state_LangLa_cz().cU) { beatdz.LangLa_cz.$state_LangLa_cz().cU.notifyAll(); }
      } catch (Exception var4) {
         return;
      } finally {
         if (var1 != null) {
            GameSrc.gI().cb.add(var1);
         }

      }

   }

   public static void b(LangLa_fb var0) {
      mImage var1 = null;

      try {
         DataCenter.gI();
         if (!DataCenter.a()) {
            return;
         }

         StringBuilder var10000 = (new StringBuilder()).append(DataCenter.gI().aU).append(DataCenter.gI().aY);
         DataCenter.gI();
         byte[] var2;
         if ((var2 = MapAssetDownloads.load(var10000.append(DataCenter.a(var0.d) + 1).append("/").append(var0.d).toString())) != null) {

            if (var0.e.startsWith("mapscale_")) {
               Binary.write(var0.e, var2);
               GameSrc.gI().al.a(GameSrc.gI().mapID);
               return;
            }

            if (var0.e.startsWith("mapsmall_") && GameSrc.gI().cE instanceof LangLa_u) {
               Binary.write(var0.e, var2);
               ((LangLa_u)((LangLa_u)GameSrc.gI().cE)).f();
               return;
            }

            var1 = Binary.createImage(Utlis.a(var2));
            if (var1 == null) return;
            Binary.write(var0.e, var2);
            var0.g.put(var0.a, var1);
            return;
         }
      } catch (Exception var6) {
         return;
      } finally {
         if (var1 != null) {
            GameSrc.gI().cb.add(var1);
         }

      }

   }

   public static void T() {
      if (!beatdz.LangLa_cz.$state_LangLa_cz().cZ && DataCenter.j()) {
         if (!beatdz.LangLa_cz.$state_LangLa_cz().cZ) {
            beatdz.LangLa_cz.$state_LangLa_cz().cZ = true;
            (new Thread(new LangLa_fh())).start();
         }
      }
   }

   

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public Object cT;
public Object cU;
public Vector cV;
public Vector cW;
public Vector cX;
public boolean cY;
public boolean cZ;
public void initialize() {
this.cT = new Object();
this.cU = new Object();
this.cV = new Vector();
this.cW = new Vector();
this.cX = new Vector();
{
      a();
   }
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.LangLa_cz");
public static SessionState $state_LangLa_cz() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
