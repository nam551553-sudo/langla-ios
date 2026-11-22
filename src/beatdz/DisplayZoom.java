package beatdz;

/** Shared view geometry; asset resolution stays fixed when the view is zoomed. */
public final class DisplayZoom {
    private DisplayZoom() { }

    public static float levelScale(int level) {
        int normalized = Math.max(1, Math.min(4, level));
        return 0.5f + normalized * 0.25f;
    }

    public static int logicalExtent(int pixels, int assetScale, float viewScale) {
        return Math.max(1, (int) (pixels / (Math.max(1, assetScale) * viewScale)));
    }

    public static int inputCoordinate(int pixels, int offset, int assetScale, float viewScale) {
        return Math.round((pixels + offset) / (Math.max(1, assetScale) * viewScale));
    }

    public static float fitPopupScale(float requested, int pixelWidth, int pixelHeight,
                                      int assetScale, int popupWidth, int popupHeight) {
        if (popupWidth <= 0 || popupHeight <= 0) return requested;
        float base = Math.max(1, assetScale);
        float horizontal = pixelWidth / (base * (popupWidth + 16));
        float vertical = pixelHeight / (base * (popupHeight + 16));
        return Math.min(requested, Math.min(horizontal, vertical));
    }
}
