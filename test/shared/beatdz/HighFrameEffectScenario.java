package beatdz;

/** Checks visual interpolation without changing the simulation clock. */
public final class HighFrameEffectScenario {
    private HighFrameEffectScenario() { }

    public static void verify() {
        LangLa_hm effect = new LangLa_hm(0, 0, 0);
        check(effect.rotationAt(0.5f) == 0, "New effect has a stable angle");
        for (int tick = 0; tick < 12; tick++) {
            effect.q();
            int start = tick % 3 * 30;
            check(effect.rotationAt(0f) == start, "Rotation starts at the previous tick");
            check(effect.rotationAt(1f / 3f) == start + 10, "90 FPS has an intermediate angle");
            check(effect.rotationAt(2f / 3f) == start + 20, "90 FPS advances evenly between ticks");
            check(effect.rotationAt(1f) == start + 30, "Visual interpolation reaches the next angle");
        }
        check(Math.abs(RenderMotion.STEP - 1f / 30f) < 0.00001f,
                "Changing display FPS keeps movement and cooldown simulation at the original rate");
    }

    private static void check(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }
}
