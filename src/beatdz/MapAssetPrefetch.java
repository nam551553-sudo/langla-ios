package beatdz;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;




import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/** Bounded background image preparation. No world mutation, movement requests, or GL calls. */
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
    
    
    
    
    

    private static synchronized Set<Short> hintedTrees(int map) throws IOException {
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
        SessionState state = $state_MapAssetPrefetch();
        String view = Binary2.a("tree_0") + ":" + DataCenter.a("iconTree/0.png");
        synchronized (state.LOCK) {
            if (state.scheduledMap == map && view.equals(state.scheduledView)) return;
            state.scheduledView = view;
            state.tasks.clear();
            state.scheduledMap = map;
            state.priorityMap = -1;
            state.pendingMap = map;
            state.revision++;
            if (state.worker == null) {
                // Two speculative requests globally leave room for visible-map downloads.
                for (int i = 0; i < 2; i++) {
                    Thread worker = new Thread(MultiSession.bind(MapAssetPrefetch::run), "map-prefetch-" + i);
                    worker.setDaemon(true);
                    if (state.worker == null) state.worker = worker;
                    worker.start();
                }
            }
            state.LOCK.notifyAll();
        }
    }

    /** Reorder speculation near a portal; never move the character or request a map change. */
    public static void approach(int map, int x, int y, short[][] links) {
        SessionState state = $state_MapAssetPrefetch();
        long now = System.currentTimeMillis();
        if (now < state.nextPortalCheck) return;
        state.nextPortalCheck = now + 500;
        int target = nearest(map, x, y, links);
        if (target < 0) return;
        synchronized (state.LOCK) {
            if (state.scheduledMap != map || state.priorityMap == target) return;
            state.priorityMap = target;
            state.pendingMap = map;
            state.tasks.clear();
            state.LOCK.notifyAll();
        }
    }

    static int nearest(int map, int x, int y, short[][] links) {
        int target = -1;
        long best = 360L * 360L;
        if (links != null) for (short[] link : links) {
            if (link == null || link.length < 10) continue;
            int other, px, py;
            if (link[0] == map) { other = link[5]; px = (link[1] + link[3]) / 2; py = link[4]; }
            else if (link[5] == map) { other = link[0]; px = (link[6] + link[8]) / 2; py = link[9]; }
            else continue;
            long dx = (long)x - px, dy = (long)y - py, distance = dx*dx + dy*dy;
            if (other >= 0 && other != map && distance < best) { best = distance; target = other; }
        }
        return target;
    }

    static Set<Integer> order(int map, int priority, short[][] links) {
        LinkedHashSet<Integer> result = new LinkedHashSet<Integer>();
        if (priority >= 0) result.add(priority);
        result.add(map);
        result.addAll(neighbours(map, links));
        return result;
    }
    private static LinkedHashSet<Short> plan(int map, int priority) {
        LinkedHashSet<Short> unique = new LinkedHashSet<Short>();
        for (int next : order(map, priority, DataCenter.gI().dataWayPoint)) {
            try {
                byte[] layout = Binary.read("arr_map_" + next);
                Set<Short> trees;
                try { trees = layout == null ? hintedTrees(next) : treeIds(layout); }
                catch (IOException invalidLayout) { trees = hintedTrees(next); }
                unique.addAll(trees);
            } catch (Exception missingHints) {
                com.badlogic.gdx.Gdx.app.debug("MapPrefetch", "No hints for map " + next);
            }
        }
        return unique;
    }

    private static void run() {
        SessionState state = $state_MapAssetPrefetch();
        while (true) {
            short id = -1;
            int map = -1, priority = -1, ticket;
            synchronized (state.LOCK) {
                while (state.pendingMap < 0 && state.tasks.isEmpty()) {
                    try { state.LOCK.wait(); } catch (InterruptedException interrupted) { return; }
                }
                ticket = state.revision;
                if (state.pendingMap >= 0) {
                    map = state.pendingMap;
                    priority = state.priorityMap;
                    state.pendingMap = -1;
                } else id = state.tasks.removeFirst();
            }
            if (map >= 0) {
                // File IO and layout parsing must never hold the lock used by the rendering thread's take().
                LinkedHashSet<Short> tasks = plan(map, priority);
                synchronized (state.LOCK) {
                    if (ticket == state.revision && priority == state.priorityMap && state.pendingMap < 0) {
                        state.tasks.addAll(tasks);
                        state.LOCK.notifyAll();
                    }
                }
                continue;
            }
            try {
                // Foreground traffic has its own workers: do not wait for its entire queue to empty.
                prefetch(id, ticket);
            } catch (Exception failed) {
                // One unavailable image must not abort the rest of the next map.
                com.badlogic.gdx.Gdx.app.debug("MapPrefetch", "Image " + id + ": " + failed.getMessage());
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
        if (id < 0 || stale(ticket)) return;
        mImage current = (mImage)LangLa_fq.$state_LangLa_fq().f.get(Short.valueOf(id));
        if (current != null && (current.b != null || current.a != null) && current.c > 1 && current.d > 1) return;
        String key = key(id);
        synchronized (beatdz.MapAssetPrefetch.$state_MapAssetPrefetch().LOCK) { if (beatdz.MapAssetPrefetch.$state_MapAssetPrefetch().READY.containsKey(key)) return; }
        String path = "iconTree/" + id + ".png";
        boolean downloaded = false;
        byte[] data = Binary.read("tree_" + id);
        if (data == null) {
            if (!DataCenter.a() || mConfig.isGDL() != 0) return;
            data = download(DataCenter.gI().aU + DataCenter.gI().aY + (DataCenter.a(path) + 1) + "/" + path, ticket);
            if (!Binary.isImageData(data) || stale(ticket) || !key.equals(key(id))) return;
            downloaded = true;
            data = Utlis.a(data);
        }
        if (!Binary.isImageData(data) || stale(ticket)) return;
        mImage image = mImage.a(data, 0, data.length);
        if (image == null) return;
        if (downloaded) Binary.write("tree_" + id, data);
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

    private static byte[] download(String url, int ticket) throws Exception {
        MultiSession.PREFETCH_NETWORK.acquire();
        try {
            if (stale(ticket)) return null;
            return MapAssetDownloads.load(url);
        } finally { MultiSession.PREFETCH_NETWORK.release(); }
    }
// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public int scheduledMap = -1;
public String scheduledView;
public int priorityMap = -1;
public long nextPortalCheck;
public java.util.LinkedList<Short> tasks = new java.util.LinkedList<Short>();
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
