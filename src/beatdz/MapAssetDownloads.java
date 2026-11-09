package beatdz;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Semaphore;

/** Shared limits and in-flight deduplication for foreground and speculative image downloads. */
final class MapAssetDownloads {
    private static final Semaphore NETWORK = new Semaphore(4, true);
    private static final Map<String, FutureTask<byte[]>> IN_FLIGHT = new HashMap<String, FutureTask<byte[]>>();

    static byte[] load(final String url) throws IOException {
        FutureTask<byte[]> task;
        synchronized (IN_FLIGHT) {
            task = IN_FLIGHT.get(url);
            if (task == null) {
                task = new FutureTask<byte[]>(() -> {
                    NETWORK.acquire();
                    try {
                        byte[] data;
                        try { data = HttpDownloads.bytes(url, 6000, 4 * 1024 * 1024); }
                        catch (IOException transientFailure) {
                            // Keep the foreground loader's previous retry behavior without its long legacy timeout.
                            Thread.sleep(150);
                            data = HttpDownloads.bytes(url, 6000, 4 * 1024 * 1024);
                        }
                        if (!Binary.isImageData(data)) throw new IOException("Invalid map image: " + url);
                        return data;
                    } finally { NETWORK.release(); }
                });
                IN_FLIGHT.put(url, task);
            }
        }
        try {
            task.run(); // Only its first caller executes the request; other callers join it.
            return task.get().clone(); // Legacy image decoding mutates the first bytes in-place.
        } catch (InterruptedException interrupted) {
            Thread.currentThread().interrupt();
            throw new IOException("Map image download interrupted", interrupted);
        } catch (ExecutionException failed) {
            throw new IOException("Map image download failed", failed.getCause());
        } finally {
            synchronized (IN_FLIGHT) {
                if (task.isDone() && IN_FLIGHT.get(url) == task) IN_FLIGHT.remove(url);
            }
        }
    }

    private MapAssetDownloads() { }
}
