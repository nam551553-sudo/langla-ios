package beatdz;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/** One background worker. No map/world mutation, server movement requests, or GL calls. */
public final class MapAssetPrefetch {
    
    
    private static final long BUDGET = 12L * 1024 * 1024;
    private static long budget() { return BUDGET / Math.max(1, MultiSession.count()); }
    public static void trimBudget() {
        synchronized (beatdz.MapAssetPrefetch.$state_MapAssetPrefetch().LOCK) {
            while (!beatdz.MapAssetPrefetch.$state_MapAssetPrefetch().READY.isEmpty() && beatdz.MapAssetPrefetch.$state_MapAssetPrefetch().bytes > budget()) {
                Map.Entry<String, mImage> oldest = beatdz.MapAssetPrefetch.$state_MapAssetPrefetch().READY.entrySet().iterator().next();
                beatdz.MapAssetPrefetch.$state_MapAssetPrefetch().bytes -= 4L * oldest.getValue().c * oldest.getValue().d;
                oldest.getValue().a(); beatdz.MapAssetPrefetch.$state_MapAssetPrefetch().READY.remove(oldest.getKey());
            }
        }
    }
    
    
    
    
    

    private static Set<Short> hintedTrees(int map) throws IOException {
        if (beatdz.MapAssetPrefetch.$state_MapAssetPrefetch().hints == null) {
            beatdz.MapAssetPrefetch.$state_MapAssetPrefetch().hints = new LinkedHashMap<Integer, Set<Short>>();
            try (DataInputStream input = new DataInputStream(com.badlogic.gdx.Gdx.files.internal("resource/map-prefetch.bin").read())) {
                if (input.readInt() != 0x4d415031) throw new IOException("Invalid map hints");
                int count = input.readUnsignedShort();
                for (int i = 0; i < count; i++) {
                    int id = input.readUnsignedShort(), size = input.readUnsignedShort();
                    Set<Short> trees = new LinkedHashSet<Short>();
                    for (int j = 0; j < size; j++) trees.add(input.readShort());
                    beatdz.MapAssetPrefetch.$state_MapAssetPrefetch().hints.put(id, trees);
                }
            }
        }
        Set<Short> result = beatdz.MapAssetPrefetch.$state_MapAssetPrefetch().hints.get(map);
        return result == null ? new LinkedHashSet<Short>() : result;
    }

    static Set<Short> treeIds(byte[] data) throws IOException {
        LinkedHashSet<Short> ids = new LinkedHashSet<Short>();
        DataInputStream in = new DataInputStream(new ByteArrayInputStream(data));
        int definitions = in.readUnsignedShort();
        for (int i = 0; i < definitions; i++) { skip(in, 7); polygons(in); }
        int groups = in.readUnsignedShort();
        for (int i = 0; i < groups; i++) {
            skip(in, 4);
            int count = in.readUnsignedByte();
            for (int j = 0; j < count; j++) { ids.add(in.readShort()); skip(in, 5); }
            polygons(in);
        }
        skip(in, 4);
        int edges = in.readUnsignedByte();
        for (int i = 0; i < edges; i++) skip(in, in.readUnsignedByte() * 4);
        int paths = in.readUnsignedShort();
        for (int i = 0; i < paths; i++) { skip(in, 1); skip(in, in.readUnsignedShort() * 4); }
        skip(in, in.readUnsignedShort() * 2);
        int placements = in.readUnsignedShort();
        int remaining = 0;
        for (int i = 0; i < placements; i++) {
            if (remaining == 0) {
                ids.add(in.readShort());
                remaining = in.readUnsignedShort();
                if (remaining == 0 || remaining > placements - i) throw new IOException("Invalid map run");
            }
            skip(in, 5);
            remaining--;
        }
        return ids;
    }

    private static void polygons(DataInputStream in) throws IOException {
        int groups = in.readUnsignedByte();
        for (int i = 0; i < groups; i++) {
            int count = in.readUnsignedByte();
            for (int j = 0; j < count; j++) skip(in, (in.readUnsignedByte() / 2) * 4);
        }
    }

    private static void skip(DataInputStream in, int count) throws IOException {
        if (count < 0 || count > in.available()) throw new IOException("Truncated map");
        in.skipBytes(count);
    }

    static Set<Integer> neighbours(int map, short[][] links) {
        Set<Integer> result = new LinkedHashSet<Integer>();
        if (links != null) for (short[] link : links) {
            if (link == null || link.length < 6) continue;
            if (link[0] == map && link[5] >= 0 && link[5] != map) result.add((int)link[5]);
            else if (link[5] == map && link[0] >= 0 && link[0] != map) result.add((int)link[0]);
        }
        return result;
    }

    public static void schedule(int map) {
        synchronized (beatdz.MapAssetPrefetch.$state_MapAssetPrefetch().LOCK) {
            beatdz.MapAssetPrefetch.$state_MapAssetPrefetch().pendingMap = map;
            beatdz.MapAssetPrefetch.$state_MapAssetPrefetch().revision++;
            if (beatdz.MapAssetPrefetch.$state_MapAssetPrefetch().worker == null) {
                beatdz.MapAssetPrefetch.$state_MapAssetPrefetch().worker = new Thread(MapAssetPrefetch::run, "map-prefetch");
                beatdz.MapAssetPrefetch.$state_MapAssetPrefetch().worker.setDaemon(true);
                beatdz.MapAssetPrefetch.$state_MapAssetPrefetch().worker.start();
            }
            beatdz.MapAssetPrefetch.$state_MapAssetPrefetch().LOCK.notifyAll();
        }
    }

    private static void run() {
        while (true) {
            int map, ticket;
            synchronized (beatdz.MapAssetPrefetch.$state_MapAssetPrefetch().LOCK) {
                while (beatdz.MapAssetPrefetch.$state_MapAssetPrefetch().pendingMap < 0) try { beatdz.MapAssetPrefetch.$state_MapAssetPrefetch().LOCK.wait(); } catch (InterruptedException e) { return; }
                map = beatdz.MapAssetPrefetch.$state_MapAssetPrefetch().pendingMap; beatdz.MapAssetPrefetch.$state_MapAssetPrefetch().pendingMap = -1; ticket = beatdz.MapAssetPrefetch.$state_MapAssetPrefetch().revision;
            }
            try {
                Set<Integer> maps = neighbours(map, DataCenter.gI().dataWayPoint);
                // Current map first fills off-screen tiles as well, then the adjacent maps.
                LinkedHashSet<Integer> order = new LinkedHashSet<Integer>();
                order.add(map); order.addAll(maps);
                for (int next : order) {
                    if (stale(ticket)) break;
                    byte[] layout = Binary.read("arr_map_" + next);
                    // Hints contain only image IDs, never collision, character or monster state.
                    // They allow first-visit prefetch before the server sends that map's layout.
                    Set<Short> trees;
                    try { trees = layout == null ? hintedTrees(next) : treeIds(layout); }
                    catch (IOException invalidLayout) { trees = hintedTrees(next); }
                    for (short id : trees) {
                        if (stale(ticket)) break;
                        while (!beatdz.LangLa_cz.$state_LangLa_cz().cX.isEmpty() || !beatdz.LangLa_cz.$state_LangLa_cz().cW.isEmpty()) {
                            if (stale(ticket)) break;
                            Thread.sleep(150);
                        }
                        if (stale(ticket)) break;
                        prefetch(id, ticket);
                    }
                }
            } catch (Exception ignored) {
                // Foreground loading remains the fallback for missing or newer map formats.
            }
        }
    }

    private static boolean stale(int ticket) {
        synchronized (beatdz.MapAssetPrefetch.$state_MapAssetPrefetch().LOCK) { return ticket != beatdz.MapAssetPrefetch.$state_MapAssetPrefetch().revision; }
    }

    private static String key(short id) {
        return Binary2.a("tree_" + id) + ":" + DataCenter.a("iconTree/" + id + ".png");
    }

    private static void prefetch(short id, int ticket) throws Exception {
        if (id < 0) return;
        String key = key(id);
        synchronized (beatdz.MapAssetPrefetch.$state_MapAssetPrefetch().LOCK) { if (beatdz.MapAssetPrefetch.$state_MapAssetPrefetch().READY.containsKey(key)) return; }
        String path = "iconTree/" + id + ".png";
        byte[] data = Binary.read("tree_" + id);
        if (data == null) {
            if (!DataCenter.a() || mConfig.isGDL() != 0) return;
            data = download(DataCenter.gI().aU + DataCenter.gI().aY + (DataCenter.a(path) + 1) + "/" + path);
            if (!Binary.isImageData(data) || stale(ticket) || !key.equals(key(id))) return;
            Binary.write("tree_" + id, data);
            data = Utlis.a(data);
        }
        if (!Binary.isImageData(data) || stale(ticket)) return;
        mImage image = mImage.a(data, 0, data.length);
        if (image == null) return;
        long size = 4L * image.c * image.d;
        synchronized (beatdz.MapAssetPrefetch.$state_MapAssetPrefetch().LOCK) {
            if (ticket != beatdz.MapAssetPrefetch.$state_MapAssetPrefetch().revision || !key.equals(key(id)) || size > budget() || beatdz.MapAssetPrefetch.$state_MapAssetPrefetch().READY.containsKey(key)) { image.a(); return; }
            while (!beatdz.MapAssetPrefetch.$state_MapAssetPrefetch().READY.isEmpty() && beatdz.MapAssetPrefetch.$state_MapAssetPrefetch().bytes + size > budget()) {
                Map.Entry<String, mImage> oldest = beatdz.MapAssetPrefetch.$state_MapAssetPrefetch().READY.entrySet().iterator().next();
                beatdz.MapAssetPrefetch.$state_MapAssetPrefetch().bytes -= 4L * oldest.getValue().c * oldest.getValue().d;
                oldest.getValue().a(); beatdz.MapAssetPrefetch.$state_MapAssetPrefetch().READY.remove(oldest.getKey());
            }
            beatdz.MapAssetPrefetch.$state_MapAssetPrefetch().READY.put(key, image); beatdz.MapAssetPrefetch.$state_MapAssetPrefetch().bytes += size;
        }
    }

    /** Transfer ownership to the normal map cache; a prefetched image is never disposed twice. */
    static mImage take(short id) {
        synchronized (beatdz.MapAssetPrefetch.$state_MapAssetPrefetch().LOCK) {
            mImage image = beatdz.MapAssetPrefetch.$state_MapAssetPrefetch().READY.remove(key(id));
            if (image != null) beatdz.MapAssetPrefetch.$state_MapAssetPrefetch().bytes -= 4L * image.c * image.d;
            return image;
        }
    }

    private static byte[] download(String url) throws IOException {
        if (!MultiSession.PREFETCH_NETWORK.tryAcquire()) return null;
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection)new URL(url).openConnection();
            connection.setConnectTimeout(2500); connection.setReadTimeout(3500);
            if (connection.getResponseCode() != 200) return null;
            try (InputStream input = connection.getInputStream(); ByteArrayOutputStream output = new ByteArrayOutputStream()) {
                byte[] buffer = new byte[8192]; int count;
                while ((count = input.read(buffer)) != -1) {
                    if (output.size() + count > 4 * 1024 * 1024) return null;
                    output.write(buffer, 0, count);
                }
                return output.toByteArray();
            }
        } finally {
            if (connection != null) connection.disconnect();
            MultiSession.PREFETCH_NETWORK.release();
        }
    }

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public Object LOCK;
public LinkedHashMap<String, mImage> READY;
public long bytes;
public int revision;
public int pendingMap;
public Thread worker;
public Map<Integer, Set<Short>> hints;
public void initialize() {
this.LOCK = new Object();
this.READY = new LinkedHashMap<String, mImage>(32, .75f, true);
this.pendingMap = -1;
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.MapAssetPrefetch");
public static SessionState $state_MapAssetPrefetch() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
