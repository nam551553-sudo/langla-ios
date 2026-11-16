package beatdz;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/** Shared limits and in-flight deduplication for foreground and speculative image downloads. */
final class MapAssetDownloads {
    interface Ready { void accept(byte[] source); }
    private static final int PARALLELISM = 4;
    private static final Semaphore NETWORK = new Semaphore(PARALLELISM, true);
    private static final ThreadPoolExecutor DOWNLOADS = new ThreadPoolExecutor(PARALLELISM, PARALLELISM,
            0, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(192), action -> {
                Thread worker = new Thread(action, "map-image-download");
                worker.setDaemon(true);
                return worker;
            }, new ThreadPoolExecutor.CallerRunsPolicy());
    private static final Map<String, Download> IN_FLIGHT = new HashMap<>();
    private static final int CACHE_BYTES = 8 * 1024 * 1024;
    private static final int CACHE_ENTRIES = 512;
    private static final LinkedHashMap<String, byte[]> READY = new LinkedHashMap<String, byte[]>(64, .75f, true);
    private static int cachedBytes;

    // Queue unique URLs. Accounts waiting on the same image never occupy another download worker.
    static FutureTask<byte[]> request(String url) {
        Download task;
        synchronized (IN_FLIGHT) {
            byte[] ready = READY.get(url);
            if (ready != null) {
                FutureTask<byte[]> cached = new FutureTask<>(() -> ready);
                cached.run();
                return cached;
            }
            task = IN_FLIGHT.get(url);
            if (task != null) return task;
            task = new Download(url);
            IN_FLIGHT.put(url, task);
        }
        DOWNLOADS.execute(MultiSession.bind(task));
        return task;
    }

    static void request(String url, Ready callback) {
        FutureTask<byte[]> task = request(url);
        if (task instanceof Download) ((Download)task).listen(callback);
        else deliver(task, callback);
    }

    private static final class Download extends FutureTask<byte[]> {
        private final String url;
        private final List<Ready> listeners = new ArrayList<>();

        Download(String url) {
            super(() -> fetch(url));
            this.url = url;
        }

        void listen(Ready callback) {
            synchronized (this) {
                if (!isDone()) {
                    listeners.add(callback);
                    return;
                }
            }
            deliver(this, callback);
        }

        @Override protected void done() {
            synchronized (IN_FLIGHT) { IN_FLIGHT.remove(url); }
            List<Ready> callbacks;
            synchronized (this) {
                callbacks = new ArrayList<>(listeners);
                listeners.clear();
            }
            for (Ready callback : callbacks) deliver(this, callback);
        }
    }

    private static void deliver(FutureTask<byte[]> task, Ready callback) {
        try {
            callback.accept(task.get());
        } catch (InterruptedException interrupted) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException failed) {
            // A failed request is removed from IN_FLIGHT and remains retryable.
        } catch (RuntimeException failed) {
            if (com.badlogic.gdx.Gdx.app != null) com.badlogic.gdx.Gdx.app.error("MapImage", "Image callback failed", failed);
        }
    }

    static boolean hasQueuedDownloads() {
        return !DOWNLOADS.getQueue().isEmpty();
    }

    private static byte[] fetch(String url) throws IOException, InterruptedException {
        byte[] data;
        NETWORK.acquire();
        try {
            try { data = HttpDownloads.bytes(url, 6000, 4 * 1024 * 1024); }
            catch (IOException transientFailure) {
                Thread.sleep(150);
                data = HttpDownloads.bytes(url, 6000, 4 * 1024 * 1024);
            }
        } finally { NETWORK.release(); }
        if (!Binary.isImageData(data)) throw new IOException("Invalid map image: " + url);
        synchronized (IN_FLIGHT) {
            READY.put(url, data);
            cachedBytes += data.length;
            while (cachedBytes > CACHE_BYTES || READY.size() > CACHE_ENTRIES) {
                Map.Entry<String, byte[]> oldest = READY.entrySet().iterator().next();
                cachedBytes -= oldest.getValue().length;
                READY.remove(oldest.getKey());
            }
        }
        return data;
    }

    static byte[] load(String url) throws IOException {
        try {
            // The asynchronous source bytes are immutable. Legacy readers can modify this copy.
            return request(url).get().clone();
        } catch (InterruptedException interrupted) {
            Thread.currentThread().interrupt();
            throw new IOException("Map image download interrupted", interrupted);
        } catch (ExecutionException failed) {
            throw new IOException("Map image download failed", failed.getCause());
        }
    }

    private MapAssetDownloads() { }
}
