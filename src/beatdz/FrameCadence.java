package beatdz;

/** Distributes frame requests across display pulses, including fractional ratios. */
public final class FrameCadence {
    private float displayRate;
    private int targetRate;
    private double phase;

    public boolean next(float displayHz, int targetFps) {
        if (Float.isNaN(displayHz) || displayHz < 1f) displayHz = 60f;
        if (displayRate != displayHz || targetRate != targetFps) {
            displayRate = displayHz;
            targetRate = targetFps;
            phase = Math.max(0, displayHz - targetFps);
        }
        phase += Math.min(displayHz, targetFps);
        if (phase < displayHz) return false;
        phase -= displayHz;
        return true;
    }

    public void reset() { displayRate = 0; }
}
