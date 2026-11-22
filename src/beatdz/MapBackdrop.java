package beatdz;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/** Loads one optional, versioned panorama per map. The old scenery remains the fallback. */
final class MapBackdrop {
    private static final String PATH = "img/map-backdrops/v1/";
    private int mapId = -1;
    private mImage image;
    private volatile byte[] pending;
    private volatile long retryAt;

    boolean paint(Graphics graphics, int map, int mapWidth, float cameraX, int width, int height) {
        if (map < 0 || width <= 0 || height <= 0 || mConfig.gI().readByte(18) > 1) return false;
        if (mapId != map) select(map);
        byte[] bytes = pending;
        if (bytes != null) {
            pending = null;
            try {
                image = Binary.createImage(bytes);
                if (image != null && image.b() != null) ImageSampling.configure(image.a);
            } catch (RuntimeException error) {
                Utlis.println(error, "Map backdrop " + map);
            }
        }
        if (image == null || image.b() == null) {
            long now = System.currentTimeMillis();
            if (now >= retryAt) {
                retryAt = now + 30_000L;
                long request = retryAt;
                MapAssetDownloads.request(ClientConfig.DATA_URL + PATH + map + ".jpg", data -> {
                    synchronized (this) {
                        if (mapId == map && retryAt == request) pending = data;
                    }
                });
            }
            return false;
        }

        int zoom = DataCenter.gI().zoomLevel;
        float travel = Math.max(1, mapWidth - width);
        float position = Math.max(0f, Math.min(1f, cameraX / travel));
        float drawHeight = height * zoom;
        float drawWidth = Math.max(width * zoom * 1.12f, drawHeight * image.c / image.d);
        SpriteBatch batch = graphics.getSpriteBatch();
        float previous = batch.getPackedColor();
        batch.setColor(Color.WHITE);
        batch.draw(image.b(), (width * zoom - drawWidth) * position, 0f,
                drawWidth, drawHeight, 0, 0, image.c, image.d, false, true);
        batch.setPackedColor(previous);
        return true;
    }

    private synchronized void select(int map) {
        if (image != null) image.a();
        image = null;
        pending = null;
        retryAt = 0;
        mapId = map;
    }

    static boolean replaces(Entity entity) {
        if (!(entity instanceof LangLa_lo)) return false;
        LangLa_lo layer = (LangLa_lo) entity;
        return layer.p >= 7 && layer.p <= 10 && layer.n == null && layer.o == null;
    }

    void dispose() {
        select(-1);
    }
}
