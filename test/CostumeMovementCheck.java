package beatdz;

import java.lang.reflect.Method;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.backends.lwjgl.LwjglFiles;
import java.lang.reflect.Proxy;

public final class CostumeMovementCheck {
    public static void main(String[] args) throws Exception {
        Gdx.files = new LwjglFiles();
        Gdx.app = (Application)Proxy.newProxyInstance(Application.class.getClassLoader(),
                new Class[]{Application.class}, (instance,method,values) ->
                        method.getName().equals("getType") ? Application.ApplicationType.Desktop : null);
        FrameRate.select(0);
        GameSrc game = new GameSrc() {
            @Override public void j() { }
            @Override public void b() { }
            @Override public boolean i() { return false; }
        };
        GameSrc.$state_GameSrc().dk = game;
        game.mapID = 0;
        game.maxX = 1200;
        game.h = new XYBlockMap(new BlockMap[0]);
        Char player = Char.gI();
        player.arrItemBody = new Item[17];
        var lastFootstep = Char.class.getDeclaredField("bt");
        lastFootstep.setAccessible(true);
        lastFootstep.setLong(player, System.currentTimeMillis());
        Method tick = Char.class.getDeclaredMethod("Z");
        tick.setAccessible(true);
        for (boolean manual : new boolean[]{false, true}) {
            int normal = distance(player, tick, 500, manual);
            int bonus = distance(player, tick, 510, manual);
            require(normal == 70 && bonus == 71, "10 movement points must add one map unit in ten ticks");
            require(distance(player, tick, 500, manual) == normal, "removing the costume restores movement");
            for (int mode : new int[]{1, 2}) {
                FrameRate.select(mode);
                require(distance(player, tick, 500, manual) == normal, "FPS changed horizontal movement");
                require(distance(player, tick, 510, manual) == bonus, "FPS changed movement bonus");
            }
            FrameRate.select(0);
        }
        for (int x : new int[]{100, 700}) {
            int baseline = pathDistance(player, tick, x);
            require(baseline > 0, "vertical/diagonal route must actually move");
            for (int mode : new int[]{1, 2}) {
                FrameRate.select(mode);
                require(pathDistance(player, tick, x) == baseline, "FPS changed vertical/diagonal movement");
            }
            FrameRate.select(0);
        }
        System.out.println("PASS horizontal, vertical and diagonal movement stays consistent at 60/70/90 FPS.");
    }

    private static int pathDistance(Char player, Method tick, int x) throws Exception {
        player.setXY(100, 400);
        player.setMovementSpeed(500);
        player.pointMove = new PointMove((short) x, (short) 100, player.speedMove);
        for (int step = 0; step < 10; step++) tick.invoke(player);
        return player.cx - 100 + 400 - player.cy;
    }
    private static int distance(Char player, Method tick, int speed, boolean manual) throws Exception {
        player.setXY(100, 200);
        player.setMovementSpeed(speed);
        player.ag = player.dir = 2;
        if (!manual) player.pointMove = new PointMove((short) 1000, (short) 200, player.speedMove);
        for (int step = 0; step < 10; step++) {
            if (manual) player.B();
            tick.invoke(player);
        }
        return player.cx - 100;
    }

    private static void require(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }
}
