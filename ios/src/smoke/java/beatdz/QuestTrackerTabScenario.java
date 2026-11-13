package beatdz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import java.nio.ByteBuffer;

public final class QuestTrackerTabScenario {
    private static final int MAP = 0;
    private static final int COLLAPSE_TRACKER = 1101;

    public static void verify() {
        MultiSession.select(0);
        ByteBuffer map = ByteBuffer.allocate(15);
        map.putShort((short) 0).putShort((short) 0).putShort((short) 1200).putShort((short) 600)
                .put((byte) 0).putShort((short) 0).putShort((short) 0).putShort((short) 0);
        Binary.write("arr_map_" + MAP, map.array());

        GameSrc first = openMap(0, 2);
        checkTracker(first, true);
        first.a(COLLAPSE_TRACKER, null, first.S.a());
        checkTracker(first, false);

        selectOrOpenTab(1);
        GameSrc second = openMap(1, 3);
        checkTracker(second, true);
        MultiSession.select(0);
        checkTracker(first, false);
        MultiSession.select(1);
        checkTracker(second, true);
        renderWithTextureOnlyIcons(second);
        check(contains(second.ak, "3/9"), "tab 2 displays its own quest progress");

        second.a(COLLAPSE_TRACKER, null, second.S.a());
        MultiSession.select(0);
        first.a(COLLAPSE_TRACKER, null, first.S.a());
        MultiSession.select(1);
        checkTracker(second, false);
        second.a(COLLAPSE_TRACKER, null, second.S.a());
        checkTracker(second, true);

        for (int slot = 2; slot < MultiSession.LIMIT; slot++) {
            selectOrOpenTab(slot);
            GameSrc game = openMap(0, slot + 2);
            checkTracker(game, true);
        }
        for (int slot = 0; slot < MultiSession.LIMIT; slot++) {
            MultiSession.select(slot);
            GameSrc game = GameSrc.gI();
            checkTracker(game, true);
            int progress = slot == 0 ? 2 : slot == 1 ? 3 : slot + 2;
            check(contains(game.ak, progress + "/9"), "restored quest progress in tab " + (slot + 1));
            checkTapMovement(slot);
        }
        checkSwitchCancelsPress();
    }

    private static void selectOrOpenTab(int slot) {
        if (slot < MultiSession.count()) {
            MultiSession.select(slot);
        } else {
            check(MultiSession.add(), "open tab " + (slot + 1));
        }
    }

    private static Task task(String name) {
        Task task = new Task();
        task.name = name;
        Step step = new Step();
        step.name = "Targets";
        step.require = 9;
        task.vStep.add(step);
        return task;
    }

    private static GameSrc openMap(int task, int progress) {
        DataCenter data = DataCenter.gI();
        data.MapTemplate = new MapTemplate[]{new MapTemplate(MAP)};
        data.MapTemplate[MAP].name = "Test map";
        data.dataWayPoint = new short[0][];
        data.exps = new long[]{1000L};
        data.af = new byte[7][1];
        data.NpcTemplate = new NpcTemplate[]{new NpcTemplate(0)};
        data.NpcTemplate[0].name = "Guide";
        data.Task = new Task[]{task("First mission"), task("Second mission")};
        GameSrc game = GameSrc.gI();
        data.setScreen(game);
        Char player = Char.gI();
        player.hp = player.hpFull = 100;
        player.mp = player.mpFull = 100;
        player.arrItemBag = new Item[0];
        player.speedMove = 5;
        ByteBuffer quest = ByteBuffer.allocate(5);
        quest.putShort((short) task).put((byte) 0).putShort((short) progress);
        Session.gI().handler.a(new Message((byte) 103, quest.array()));
        check(game.Task == task && game.idRequire == progress, "quest packet before HUD creation");
        render(game);
        check(!data.aH, "HUD cache waits for the map controls");
        ByteBuffer map = ByteBuffer.allocate(30);
        map.putShort((short) 1).putShort((short) MAP).putShort((short) 180).putShort((short) 200)
                .putShort((short) 0).put((byte) 0).putShort((short) 0).putShort((short) 0)
                .put((byte) 0).putLong(0L).putInt(0).put((byte) 0).put((byte) 0);
        Session.gI().handler.a(new Message((byte) -103, map.array()));
        check(game.ak != null && game.X != null && game.af != null && game.V == null, "game map HUD");
        return game;
    }

    private static void checkTapMovement(int slot) {
        int x = 138 + slot * 6;
        int y = 109;
        DataCenter data = DataCenter.gI();
        data.j = 200 + slot * 10;
        data.k = 48;
        Char player = Char.gI();
        player.stopMove();
        tap(x, y);
        long deadline = System.nanoTime() + 2_000_000_000L;
        while (player.pointMove == null && System.nanoTime() < deadline) {
            MoveSmart.d();
            if (player.pointMove == null) {
                try {
                    Thread.sleep(2);
                } catch (InterruptedException error) {
                    Thread.currentThread().interrupt();
                    throw new AssertionError(error);
                }
            }
        }
        PointMove target = player.pointMove;
        check(target != null && target.cx == x + data.j && target.cy == y + data.k,
                "tap creates the correct movement target in tab " + (slot + 1));
        int startX = player.cx;
        for (int tick = 0; tick < 4; tick++) player.t();
        check(player.cx > startX, "character advances after a tap in tab " + (slot + 1));
    }

    private static void checkSwitchCancelsPress() {
        MultiSession.select(1);
        check(pointer(142, 109, true), "touch begins in tab 2");
        MultiSession.select(2);
        pointer(142, 109, false);
        check(Char.gI().pointMove == null && MoveSmart.c().isEmpty(), "old press cannot move tab 3");
        checkTapMovement(2);
    }

    private static void tap(int x, int y) {
        check(pointer(x, y, true), "world accepts touch down");
        check(pointer(x, y, false), "world accepts touch up");
    }

    private static boolean pointer(int x, int y, boolean down) {
        float scale = DataCenter.gI().zoomLevelScreen * AppListener.gI().canvas.getInputUiScale();
        int screenX = Math.round(x * scale);
        int screenY = Math.round(y * scale) + MultiSession.barHeight();
        return down ? Gdx.input.getInputProcessor().touchDown(screenX, screenY, 0, Input.Buttons.LEFT)
                : Gdx.input.getInputProcessor().touchUp(screenX, screenY, 0, Input.Buttons.LEFT);
    }

    private static void renderWithTextureOnlyIcons(GameSrc game) {
        for (int id : new int[]{17, 59, 84, 5}) {
            mImage icon = Binary.createImage(22, 22);
            Binary.disposeImage(icon);
            check(icon.b == null && icon.a != null, "texture-only test asset");
            LangLa_fq.$state_LangLa_fq().e.put((short) id, icon);
        }
        check(LangLa_mg.$state_LangLa_mg().g == null, "HUD has yet to render");
        render(game);
        mImage panel = LangLa_mg.$state_LangLa_mg().g;
        check(DataCenter.gI().aH && panel != null && panel.a != null, "quest HUD draws when icons have no pixmap");
    }

    private static void render(GameSrc game) {
        Graphics graphics = AppListener.gI().canvas.graphics;
        graphics.getSpriteBatch().begin();
        try {
            graphics.clean();
            graphics.setClip(0, 0, game.width, game.height);
            game.a(graphics);
        } finally {
            graphics.getSpriteBatch().end();
        }
    }

    private static void checkTracker(GameSrc game, boolean expanded) {
        LangLa_dz toggle = (LangLa_dz) game.S.a();
        check(game.S.c() == expanded && toggle.e == (expanded ? 0 : 180),
                "quest tracker state and arrow after switching tabs");
    }

    private static boolean contains(LangLa_mg tracker, String text) {
        for (LangLa_lk line : tracker.b) {
            if (line.b.contains(text)) return true;
        }
        return false;
    }

    private static void check(boolean result, String description) {
        if (!result) throw new AssertionError(description);
    }
}
