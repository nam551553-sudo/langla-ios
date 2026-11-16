package beatdz;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/** Shared limits and in-flight deduplication for foreground and speculative image downloads. */
final class MapAssetDownloads {
    private static final int PARALLELISM = 4;
    private static final Semaphore NETWORK = new Semaphore(PARALLELISM, true);
    private static final ThreadPoolExecutor DOWNLOADS = new ThreadPoolExecutor(PARALLELISM, PARALLELISM,
            0, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(192), action -> {
                Thread worker = new Thread(action, "map-image-download");
                worker.setDaemon(true);
                return worker;
            }, new ThreadPoolExecutor.CallerRunsPolicy());
    private static final Map<String, CompletableFuture<byte[]>> IN_FLIGHT = new HashMap<>();
    private static final int CACHE_BYTES = 8 * 1024 * 1024;
    private static final int CACHE_ENTRIES = 512;
    private static final LinkedHashMap<String, byte[]> READY = new LinkedHashMap<String, byte[]>(64, .75f, true);
    private static int cachedBytes;

    // Queue unique URLs. Accounts waiting on the same image never occupy another download worker.
    static CompletableFuture<byte[]> request(String url) {
        CompletableFuture<byte[]> task;
        synchronized (IN_FLIGHT) {
            byte[] ready = READY.get(url);
            if (ready != null) return CompletableFuture.completedFuture(ready);
            task = IN_FLIGHT.get(url);
            if (task != null) return task;
            task = new CompletableFuture<>();
            IN_FLIGHT.put(url, task);
        }
        CompletableFuture<byte[]> download = task;
        DOWNLOADS.execute(MultiSession.bind(() -> fetch(url, download)));
        return task;
    }

    static boolean hasQueuedDownloads() {
        return !DOWNLOADS.getQueue().isEmpty();
    }

    private static void fetch(String url, CompletableFuture<byte[]> task) {
        try {
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
                IN_FLIGHT.remove(url);
            }
            task.complete(data);
        } catch (InterruptedException interrupted) {
            Thread.currentThread().interrupt();
            fail(url, task, interrupted);
        } catch (IOException | RuntimeException failed) {
            fail(url, task, failed);
        }
    }

    private static void fail(String url, CompletableFuture<byte[]> task, Exception error) {
        synchronized (IN_FLIGHT) { IN_FLIGHT.remove(url); }
        task.completeExceptionally(error);
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
