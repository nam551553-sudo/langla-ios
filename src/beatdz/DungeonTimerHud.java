package beatdz;

/** A timer independent of the hidden minimap and the shortcut menu's expanded state. */
public final class DungeonTimerHud {
    public static final int HEIGHT = 16;
    private int cachedSeconds = -1;
    private String cachedLabel = "";

    public static boolean isTimedMap(GameSrc game) {
        return game != null && (game.mapID == 84 || game.mapID == 89);
    }

    public static int remainingSeconds(GameSrc game, long now) {
        long elapsed = Math.max(0L, now - game.timeStartHoatDong);
        long remaining = Math.max(0L, (long) game.timeHoatDong - elapsed);
        return (int) ((remaining + 999L) / 1000L);
    }

    public static String clock(int seconds) {
        seconds = Math.max(0, seconds);
        return twoDigits(seconds / 3600) + ":" + twoDigits(seconds / 60 % 60) + ":" + twoDigits(seconds % 60);
    }

    private static String twoDigits(int value) {
        return (value < 10 ? "0" : "") + value;
    }

    public void paint(Graphics graphics, GameSrc game, long now) {
        if (!isTimedMap(game)) return;
        int seconds = remainingSeconds(game, now);
        if (seconds != cachedSeconds) {
            cachedSeconds = seconds;
            cachedLabel = "Còn lại: " + clock(seconds);
        }
        int width = Math.min(128, game.width);
        int left = Math.max(0, game.width - width);
        graphics.f(0x4b2c20);
        graphics.c(left, 16, width, HEIGHT);
        mFont.a(graphics, cachedLabel, left + width / 2, 24, 2, -2560);
    }
}
