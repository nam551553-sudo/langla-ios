package beatdz;import java.util.Vector;

public class MoveSmart {
   
   
   
   
   
   
   
   
   
   
   

   public static void a() {
      beatdz.MoveSmart.$state_MoveSmart().i = true;
      beatdz.MoveSmart.$state_MoveSmart().g.removeAllElements();

      try {
         (new Thread(new LangLa_hw())).start();
      } catch (Exception var1) {
         Utlis.println(var1);
      }
   }

   public static void b() {
      beatdz.MoveSmart.$state_MoveSmart().i = false;
      beatdz.MoveSmart.$state_MoveSmart().g.removeAllElements();
      n();
   }

   private static void n() {
      if (beatdz.MoveSmart.$state_MoveSmart().k == 1) {
         synchronized(beatdz.MoveSmart.$state_MoveSmart().h) {
            beatdz.MoveSmart.$state_MoveSmart().h.notify();
         }
      } else {
         beatdz.MoveSmart.$state_MoveSmart().k = 2;
      }

   }

   public static Vector a(XYEntity var0, XYEntity var1, boolean var2) {
      Vector var3 = new Vector();
      if ((Char.gI().I() != null || SettingsTab.gI().autoTrain || var2 || true) && !GameSrc.gI().a(var0, var1)) {
         var3.add(var0);
         var3.add(var1);
         return var3;
      } else if ((var0.cx == var1.cx || var0.cy == var1.cy) && !GameSrc.gI().a(var0, var1)) {
         var3.add(var0);
         var3.add(var1);
         return var3;
      } else {
         XYEntity var7 = XYEntity.create(var1.cx, var0.cy);
         if (!GameSrc.gI().a(var0, var7) && !GameSrc.gI().a(var1, var7)) {
            var3.add(var0);
            var3.add(var7);
            var3.add(var1);
            return var3;
         } else {
            var7 = XYEntity.create(var0.cx, var1.cy);
            if (!GameSrc.gI().a(var0, var7) && !GameSrc.gI().a(var1, var7)) {
               var3.add(var0);
               var3.add(var7);
               var3.add(var1);
               return var3;
            } else {
               int var8 = var0.cy;
               if (var1.cy < var8) {
                  var8 = var1.cy;
               }

               for(int var4 = 1; var4 < 200; ++var4) {
                  var8 -= var4 * 10;
                  XYEntity var5 = XYEntity.create(var0.cx, var8);
                  XYEntity var6 = XYEntity.create(var1.cx, var8);
                  if (GameSrc.gI().a(var0, var5) || GameSrc.gI().a(var1, var6)) {
                     return null;
                  }

                  if (!GameSrc.gI().a(var5, var6)) {
                     var3.add(var0);
                     var3.add(var5);
                     var3.add(var6);
                     var3.add(var1);
                     return var3;
                  }
               }

               return var3;
            }
         }
      }
   }

   public static void a(int var0, int var1, int var2) {
      if (beatdz.MoveSmart.$state_MoveSmart().k == 1 || var0 != beatdz.MoveSmart.$state_MoveSmart().a || var1 != beatdz.MoveSmart.$state_MoveSmart().b || var2 != beatdz.MoveSmart.$state_MoveSmart().c || beatdz.MoveSmart.$state_MoveSmart().d != GameSrc.gI().mapID || beatdz.MoveSmart.$state_MoveSmart().e != Char.gI().cx || beatdz.MoveSmart.$state_MoveSmart().f != Char.gI().cy) {
         beatdz.MoveSmart.$state_MoveSmart().a = var0;
         beatdz.MoveSmart.$state_MoveSmart().b = var1;
         beatdz.MoveSmart.$state_MoveSmart().c = var2;
         beatdz.MoveSmart.$state_MoveSmart().g.removeAllElements();
         beatdz.MoveSmart.$state_MoveSmart().d = GameSrc.gI().mapID;
         beatdz.MoveSmart.$state_MoveSmart().e = Char.gI().cx;
         beatdz.MoveSmart.$state_MoveSmart().f = Char.gI().cy;
         beatdz.MoveSmart.$state_MoveSmart().i = true;
         beatdz.MoveSmart.$state_MoveSmart().j = 0;
         n();
      }
   }

   public static Vector c() {
      return beatdz.MoveSmart.$state_MoveSmart().g;
   }

   public static void d() {
      if (!beatdz.MoveSmart.$state_MoveSmart().i) {
         beatdz.MoveSmart.$state_MoveSmart().g.clear();
      } else {
         if (beatdz.MoveSmart.$state_MoveSmart().g.size() > 0 && Char.gI().pointMove == null) {
            beatdz.MoveSmart.$state_MoveSmart().g.removeElementAt(0);
            if (beatdz.MoveSmart.$state_MoveSmart().g.size() > 0) {
               XYEntity var0 = (XYEntity)beatdz.MoveSmart.$state_MoveSmart().g.firstElement();
               Char.gI().pointMove = new PointMove(var0.cx, var0.cy, Char.gI().speedMove, Char.gI().speedMove);
               Char.gI().a(Char.gI().pointMove);
               DataCenter.gI();
            }
         }

      }
   }

   public static boolean e() {
      return beatdz.MoveSmart.$state_MoveSmart().g.size() > 0;
   }

   
   static Object f() {
      return beatdz.MoveSmart.$state_MoveSmart().h;
   }

   
   static int a(int var0) {
      beatdz.MoveSmart.$state_MoveSmart().k = var0;
      return var0;
   }

   
   static boolean g() {
      return beatdz.MoveSmart.$state_MoveSmart().i;
   }

   
   static int h() {
      return beatdz.MoveSmart.$state_MoveSmart().e;
   }

   
   static int i() {
      return beatdz.MoveSmart.$state_MoveSmart().f;
   }

   
   static int j() {
      return beatdz.MoveSmart.$state_MoveSmart().b;
   }

   
   static int k() {
      return beatdz.MoveSmart.$state_MoveSmart().c;
   }

   
   static int b(int var0) {
      beatdz.MoveSmart.$state_MoveSmart().e = var0;
      return var0;
   }

   
   static int c(int var0) {
      beatdz.MoveSmart.$state_MoveSmart().f = var0;
      return var0;
   }

   
   static int d(int var0) {
      beatdz.MoveSmart.$state_MoveSmart().b = var0;
      return var0;
   }

   
   static int e(int var0) {
      beatdz.MoveSmart.$state_MoveSmart().c = var0;
      return var0;
   }

   
   static int l() {
      return beatdz.MoveSmart.$state_MoveSmart().k;
   }

   
   static Vector m() {
      return beatdz.MoveSmart.$state_MoveSmart().g;
   }

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public int a;
public int b;
public int c;
public int d;
public int e;
public int f;
public Vector g;
public Object h;
public boolean i;
public int j;
public int k;
public void initialize() {
this.g = new Vector();
this.h = new Object();
this.j = 0;
this.k = 0;
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.MoveSmart");
public static SessionState $state_MoveSmart() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
