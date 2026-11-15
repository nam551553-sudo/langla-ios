package beatdz;

/** Stable saved IDs: removing a visible setting must not shift other preferences. */
public final class AutoOptions {
    private static final int[] VISIBLE = {0, 1, 2, 4, 5, 6};
    public static int count() { return VISIBLE.length; }
    public static int idAt(int row) { return VISIBLE[row]; }
    public static int rowOf(int id) {
        for (int row = 0; row < VISIBLE.length; row++) if (VISIBLE[row] == id) return row;
        return -1;
    }
    public static boolean removed(int id) { return id == 3 || id == 7 || id == 8; }
    public static boolean enabled(byte[] saved, int id) {
        return id >= 0 && !removed(id) && saved != null && id < saved.length - 100 && saved[id + 100] == 0;
    }
    public static boolean disableRemoved(byte[] saved) {
        boolean changed = false;
        for (int id : new int[]{3, 7, 8}) {
            if (saved != null && saved.length > id + 100 && saved[id + 100] != -1) {
                saved[id + 100] = -1;
                changed = true;
            }
        }
        return changed;
    }
    private AutoOptions() { }
}
