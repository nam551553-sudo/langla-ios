package beatdz;

/** Display-rate divisors keep 90/120/144 Hz surfaces at a uniform cadence below the 60 FPS cap. */
public final class FrameCadence {
    private int divider = 1, frame;
    public boolean next(float displayHz) {
        if (Float.isNaN(displayHz) || displayHz < 1f) displayHz = 60f;
        int desired = Math.max(1, (int)Math.ceil((displayHz - .5f) / 60f));
        if (desired != divider) { divider = desired; frame = 0; }
        boolean draw = frame == 0;
        frame = (frame + 1) % divider;
        return draw;
    }
    public void reset() { frame = 0; }
}
