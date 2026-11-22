package beatdz;

import com.badlogic.gdx.Gdx;

/** Mobile textures use their native density; low-density downloads cannot be sharpened by a filter. */
final class MobileAssets {
    private MobileAssets() { }

    static int quality(int screenDensity) { return screenDensity <= 2 ? 1 : 2; }

    static String cacheName(String name) {
        boolean imageArchive = name.startsWith("arr_check_") && !name.equals("arr_check_0");
        if (Gdx.app == null || !Canvas.isMobile() || (!isTexture(name) && !imageArchive)) return name;
        // Do not reuse the old zoom-1 images or invalidate accounts, settings and map packets.
        return "images-hd1/z" + Math.max(1, Math.min(4, DataCenter.gI().zoomLevel)) + "/" + name;
    }

    private static boolean isTexture(String name) {
        return !name.contains("size") && (name.startsWith("char_") || name.startsWith("tree_")
                || name.startsWith("client_") || name.startsWith("font_")
                || name.startsWith("mapmini_") || name.startsWith("mapsmall_") || name.startsWith("mapscale_"));
    }
}
