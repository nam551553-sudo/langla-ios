package beatdz;

public final class FrameRate {
    @FunctionalInterface
    public interface Listener {
        void apply(int fps);
    }

    private static final int[] OPTIONS = {60, 70, 90};
    private static volatile int target = 60;
    private static Listener platform = fps -> {};

    private FrameRate() {}

    public static int target() { return target; }

    public static void install(Listener callback) { platform = callback; }

    static int selection() {
        int option = mConfig.gI().readByte(26);
        return option >= 0 && option < OPTIONS.length ? option : 0;
    }

    static void select(int option) {
        mConfig.gI().writeByte(26, option);
        apply();
    }

    static String label(int option) { return OPTIONS[option] + " FPS"; }

    static void apply() {
        int fps = OPTIONS[selection()];
        if (target != fps) {
            target = fps;
            platform.apply(fps);
        }
    }
}
