package beatdz;

import com.badlogic.gdx.files.FileHandle;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/** Optional scenery for the existing map 86 coordinate system. */
final class KonohaSchoolScenery {
    private static final int MAP_ID = 86;
    private static final int WIDTH = 2504;
    private static final int HEIGHT = 760;
    private static final String[] PANELS = {"school-west", "school-center", "school-east"};
    private static final int[][] SOURCE_COLUMNS = {
            {0, 1508},
            {0, 1508},
            {0, 106, 169, 316, 598, 748, 785, 875, 1240, 1275, 1509}
    };
    private static final int[][] WORLD_COLUMNS = {
            {0, 833},
            {833, 1680},
            {1680, 1694, 1732, 1811, 1965, 2045, 2067, 2119, 2310, 2334, WIDTH}
    };

    // Map art rows to the original ledge heights and ground line.
    private static final int[][] SOURCE_ROWS = {
            {0, 303, 376, 449, 635, 674, 816, 866, 1043},
            {0, 283, 350, 396, 429, 636, 863, 1043},
            {0, 197, 319, 384, 438, 464, 644, 869, 1042}
    };
    private static final int[][] WORLD_ROWS = {
            {0, 378, 413, 456, 553, 571, 645, 676, HEIGHT},
            {0, 378, 412, 443, 454, 565, 676, HEIGHT},
            {0, 316, 382, 413, 441, 456, 555, 676, HEIGHT}
    };
    private static mImage[] scenery;
    private static final String PATH = "assets/maps/konoha/v1/";
    private static final int MAX_IMAGE_BYTES = 4 * 1024 * 1024;
    private static final String[] HASHES = {
            "c969336f8836a3be22694548c3f4c9535141ea87c0833ca216322eda4c72ec9d",
            "8ae22cebd249b0cae7592c8aaa2ae27dc6f4d63ebf6b374fea27de89455454e4",
            "bc4e6918ad1006777a52ca23de66e9c6db6a3438f13ebf08888c1a86c85e03fb"
    };
    private static volatile byte[][] pendingImages;
    private static volatile boolean fetching;
    private static volatile long retryAfter;

    private KonohaSchoolScenery() {}

    static boolean paint(Graphics graphics, int map, int width, int height,
                         float cameraX, float cameraY, int viewportWidth, int viewportHeight) {
        if (map != MAP_ID || width != WIDTH || height != HEIGHT
                || mConfig.gI().readByte(18) > 1 || !load()) return false;

        float right = cameraX + viewportWidth;
        float bottom = cameraY + viewportHeight;
        for (int panel = 0; panel < PANELS.length; panel++) {
            int[] sourceColumns = SOURCE_COLUMNS[panel];
            int[] worldColumns = WORLD_COLUMNS[panel];
            int[] sourceRows = SOURCE_ROWS[panel];
            int[] worldRows = WORLD_ROWS[panel];
            for (int column = 1; column < worldColumns.length; column++) {
                int left = worldColumns[column - 1];
                int next = worldColumns[column];
                if (next <= cameraX || left >= right) continue;
                for (int row = 1; row < worldRows.length; row++) {
                    int top = worldRows[row - 1];
                    if (worldRows[row] <= cameraY || top >= bottom) continue;
                    graphics.drawMapScenery(scenery[panel], sourceColumns[column - 1], sourceRows[row - 1],
                            sourceColumns[column] - sourceColumns[column - 1],
                            sourceRows[row] - sourceRows[row - 1], left, top, next - left,
                            worldRows[row] - top);
                }
            }
        }
        return true;
    }

    private static boolean load() {
        if (scenery != null) return true;
        byte[][] data = pendingImages;
        if (data == null) {
            if (!fetching && System.currentTimeMillis() >= retryAfter) startFetch();
            return false;
        }
        pendingImages = null;
        mImage[] images = new mImage[PANELS.length];
        try {
            for (int i = 0; i < images.length; i++) {
                images[i] = Binary.createImage(data[i]);
                if (images[i] == null || images[i].c != SOURCE_COLUMNS[i][SOURCE_COLUMNS[i].length - 1]
                        || images[i].d != SOURCE_ROWS[i][SOURCE_ROWS[i].length - 1]
                        || images[i].b() == null) throw new IllegalStateException("Invalid Konoha panel " + PANELS[i]);
                ImageSampling.configure(images[i].a);
            }
            scenery = images;
            return true;
        } catch (RuntimeException error) {
            for (mImage image : images) if (image != null) image.a();
            retryAfter = System.currentTimeMillis() + 30_000L;
            Utlis.println(error, "Konoha school scenery");
            return false;
        }
    }

    private static void startFetch() {
        fetching = true;
        Thread worker = new Thread(MultiSession.bind(() -> {
            try {
                byte[][] data = new byte[PANELS.length][];
                for (int i = 0; i < data.length; i++) data[i] = loadPanel(i);
                pendingImages = data;
            } catch (IOException | RuntimeException error) {
                retryAfter = System.currentTimeMillis() + 30_000L;
                Utlis.println(error, "Konoha school scenery download");
            } finally {
                fetching = false;
            }
        }), "konoha-scenery-download");
        worker.setDaemon(true);
        worker.start();
    }

    private static byte[] loadPanel(int index) throws IOException {
        String path = PATH + PANELS[index] + ".png";
        FileHandle cache = Utlis.external("cache/" + path);
        try {
            if (cache.exists() && cache.length() <= MAX_IMAGE_BYTES) {
                byte[] cached = cache.readBytes();
                if (matchesHash(cached, HASHES[index])) return cached;
            }
        } catch (RuntimeException ignored) {
            // A failed cache read can still use the verified network copy.
        }
        byte[] bytes = MapAssetDownloads.load(ClientConfig.DATA_URL + path);
        if (!matchesHash(bytes, HASHES[index])) throw new IOException("Invalid Konoha image: " + PANELS[index]);
        try {
            FileHandle temp = cache.sibling(cache.name() + ".part");
            temp.writeBytes(bytes, false);
            temp.moveTo(cache);
        } catch (RuntimeException ignored) {
            // Rendering is still possible when storage is unavailable.
        }
        return bytes;
    }

    private static boolean matchesHash(byte[] data, String expected) throws IOException {
        try {
            byte[] digest = MessageDigest.getInstance("SHA-256").digest(data);
            for (int i = 0; i < digest.length; i++) {
                if (Character.forDigit((digest[i] >>> 4) & 15, 16) != expected.charAt(2 * i)
                        || Character.forDigit(digest[i] & 15, 16) != expected.charAt(2 * i + 1)) return false;
            }
            return true;
        } catch (NoSuchAlgorithmException error) {
            throw new IOException(error);
        }
    }

    static void dispose() {
        if (scenery != null) for (mImage image : scenery) image.a();
        scenery = null;

    }
}
