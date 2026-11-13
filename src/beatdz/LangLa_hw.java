package beatdz;

import java.util.Vector;
import java.util.function.BooleanSupplier;

final class LangLa_hw {
   static Vector<XYEntity> findPath(MoveSmart.PathRequest request, BooleanSupplier current) {
      XYEntity start = nearestWalkable(request.player, request.fromX, request.fromY);
      XYEntity end = nearestWalkable(request.player, request.toX, request.toY);
      if (!current.getAsBoolean()) return null;

      Vector<XYEntity> direct = MoveSmart.a(start, end, false);
      if (direct != null) return direct;
      for (Object value : request.walkableRoutes) {
         XYEntity[] points = ((BlockMap) value).arrayXY;
         if (!current.getAsBoolean()) return null;
         Connection from = closestConnection(request.game, start, points, current);
         Connection to = closestConnection(request.game, end, points, current);
         if (from == null || to == null || !current.getAsBoolean()) continue;

         Vector<XYEntity> route = new Vector<>();
         route.add(start);
         route.add(from.point);
         if (from.segment < to.segment) {
            for (int index = from.segment + 1; index <= to.segment; index++) route.add(points[index]);
         } else {
            for (int index = from.segment; index > to.segment; index--) route.add(points[index]);
         }
         route.add(to.point);
         route.add(end);
         return route;
      }
      return null;
   }

   private static XYEntity nearestWalkable(Char player, int x, int y) {
      XYEntity point = XYEntity.create(x, y);
      if (!player.a(x, y)) {
         XYEntity nearby = player.a(point, 10, true);
         if (nearby != null) return nearby;
      }
      return point;
   }

   private static Connection closestConnection(GameSrc game, XYEntity origin, XYEntity[] points,
                                                BooleanSupplier current) {
      Connection closest = null;
      for (int index = 0; index < points.length - 1 && current.getAsBoolean(); index++) {
         XYEntity start = points[index];
         XYEntity end = points[index + 1];
         closest = closer(game, origin, Utlis.a(origin, start, end), index, closest);
         closest = closer(game, origin, start, index, closest);
         closest = closer(game, origin, end, index, closest);
      }
      return closest;
   }

   private static Connection closer(GameSrc game, XYEntity origin, XYEntity point, int segment, Connection current) {
      if (point == null) return current;
      int distance = Utlis.getRange2(origin.cx, origin.cy, point.cx, point.cy);
      if ((current == null || distance < current.distance) && !game.a(origin, point)) {
         return new Connection(point, segment, distance);
      }
      return current;
   }

   private static final class Connection {
      final XYEntity point;
      final int segment;
      final int distance;

      Connection(XYEntity point, int segment, int distance) {
         this.point = point;
         this.segment = segment;
         this.distance = distance;
      }
   }
}
