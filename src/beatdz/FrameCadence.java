package beatdz;

/** Keeps frame requests an equal number of display pulses apart. */
public final class FrameCadence {
    private float displayRate;
    private int targetRate;
    private long minimumSpacingNanos;
    private long lastFrameNanos = Long.MIN_VALUE;

    public boolean next(long frameTimeNanos, float displayHz, int targetFps) {
        displayHz = validRate(displayHz);
        if (displayRate != displayHz || targetRate != targetFps) {
            displayRate = displayHz;
            targetRate = targetFps;
            // Allow timestamp jitter within a pulse. A missed callback still counts as elapsed time.
            minimumSpacingNanos = Math.round((pulsesPerFrame(displayHz, targetFps) - 0.25)
                    * 1_000_000_000.0 / displayHz);
        }
        if (lastFrameNanos != Long.MIN_VALUE && frameTimeNanos - lastFrameNanos < minimumSpacingNanos) return false;
        lastFrameNanos = frameTimeNanos;
        return true;
    }

    public static float steadyRate(float displayHz, int targetFps) {
        displayHz = validRate(displayHz);
        return displayHz / pulsesPerFrame(displayHz, targetFps);
    }

    private static int pulsesPerFrame(float displayHz, int targetFps) {
        // Nominal display rates can be slightly above or below the advertised FPS.
        return (int) Math.ceil(displayHz / (Math.max(1, targetFps) + 0.5f));
    }

    private static float validRate(float displayHz) {
        return displayHz >= 1f && !Float.isInfinite(displayHz) ? displayHz : 60f;
    }

    public void reset() { lastFrameNanos = Long.MIN_VALUE; }
}
