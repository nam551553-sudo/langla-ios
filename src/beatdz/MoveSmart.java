package beatdz;

import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MoveSmart {
   private static final ExecutorService PATH_WORKERS = Executors.newFixedThreadPool(2, action -> {
      Thread worker = new Thread(action, "map-pathfinder");
      worker.setDaemon(true);
      return worker;
   });

   public static void b() {
      SessionState state = $state_MoveSmart();
      synchronized (state) {
         state.request = null;
         state.path.clear();
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

   static void requestPath(int x, int y) {
      SessionState state = $state_MoveSmart();
      PathRequest request = new PathRequest(GameSrc.gI(), Char.gI(), x, y);
      synchronized (state) {
         if (state.request != null && state.request.matches(request)) return;
         state.request = request;
         state.path.clear();
         if (!state.workerScheduled) {
            state.workerScheduled = true;
            PATH_WORKERS.execute(MultiSession.bind(() -> findPendingPath(state)));
         }
      }
   }

   private static void findPendingPath(SessionState state) {
      while (true) {
         PathRequest request;
         synchronized (state) {
            request = state.request;
            if (request == null) {
               state.workerScheduled = false;
               return;
            }
         }
         Vector<XYEntity> route = null;
         try {
            if (request.isOnCurrentMap()) route = LangLa_hw.findPath(request, () -> state.request == request);
         } catch (RuntimeException error) {
            if (state.request == request && request.isOnCurrentMap()) Utlis.println(error, "Map pathfinding");
         }
         synchronized (state) {
            if (state.request == request) {
               if (route != null && request.isOnCurrentMap()) state.path.addAll(route);
               state.request = null;
            }
         }
      }
   }

   public static Vector<XYEntity> c() {
      return $state_MoveSmart().path;
   }

   public static void d() {
      SessionState state = $state_MoveSmart();
      Char player = Char.gI();
      synchronized (state) {
         if (player.pointMove != null || state.path.isEmpty()) return;
         state.path.remove(0);
         if (state.path.isEmpty()) return;
         XYEntity next = state.path.firstElement();
         player.pointMove = new PointMove(next.cx, next.cy, player.speedMove, player.speedMove);
      }
      player.a(player.pointMove);
   }

   public static boolean e() {
      return !c().isEmpty();
   }

   static final class PathRequest {
      final GameSrc game;
      final Char player;
      final int map;
      final XYBlockMap collision;
      final Object[] walkableRoutes;
      final int fromX;
      final int fromY;
      final int toX;
      final int toY;

      PathRequest(GameSrc game, Char player, int toX, int toY) {
         this.game = game;
         this.player = player;
         this.map = game.mapID;
         this.collision = game.h;
         this.walkableRoutes = game.i.toArray();
         this.fromX = player.cx;
         this.fromY = player.cy;
         this.toX = toX;
         this.toY = toY;
      }

      boolean isOnCurrentMap() {
         return collision != null && GameSrc.d() == game && Char.gI() == player
                 && map == game.mapID && collision == game.h;
      }

      boolean matches(PathRequest other) {
         return game == other.game && player == other.player && map == other.map && collision == other.collision
                 && fromX == other.fromX && fromY == other.fromY && toX == other.toX && toY == other.toY;
      }
   }

   public static final class SessionState implements MultiSession.State {
      final Vector<XYEntity> path = new Vector<>();
      volatile PathRequest request;
      boolean workerScheduled;

      public void initialize() { }
   }

   private static final int $SESSION_STATE_ID = MultiSession.register("beatdz.MoveSmart");
   public static SessionState $state_MoveSmart() {
      return MultiSession.state($SESSION_STATE_ID, SessionState::new);
   }
}
