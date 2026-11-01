package com.beatdz.langlalau;

import beatdz.HttpDownloads;
import java.io.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.robovm.apple.foundation.*;

/** NSURLSession downloads to disk, with a caller deadline independent of socket timeouts. */
public final class IOSHttpTransport implements HttpDownloads.Transport {
    private static final class Result {
        final CountDownLatch done = new CountDownLatch(1);
        IOException error;
        boolean closed;
    }
    @Override public HttpDownloads.Response open(String url, int timeoutMillis, long maxBytes,
                                                 HttpDownloads.Progress progress) throws IOException {
        final File downloaded = File.createTempFile("langla-http-", ".download");
        final Result result = new Result();
        boolean success = false;
        try (NSAutoreleasePool pool = new NSAutoreleasePool()) {
            NSURLSessionConfiguration configuration = NSURLSessionConfiguration.getEphemeralSessionConfiguration();
            configuration.setTimeoutIntervalForRequest(Math.min(30.0, timeoutMillis / 1000.0));
            configuration.setTimeoutIntervalForResource(timeoutMillis / 1000.0);
            configuration.setWaitsForConnectivity(false);
            NSURLRequest request = new NSURLRequest(new NSURL(url), NSURLRequestCachePolicy.ReloadIgnoringLocalCacheData,
                    Math.min(30.0, timeoutMillis / 1000.0));
            NSURLSession session = new NSURLSession(configuration);
            try {
                NSURLSessionDownloadTask task = session.newDownloadTask(request, (location, response, error) -> {
                    try (NSAutoreleasePool callbackPool = new NSAutoreleasePool()) {
                        synchronized (result) {
                            if (result.closed) return;
                            try {
                                if (error != null) throw new IOException("NSURLSession " + error.getCode() + ": " + error.getLocalizedDescription());
                                if (!(response instanceof NSHTTPURLResponse)) throw new IOException("Invalid HTTP response");
                                long status = ((NSHTTPURLResponse)response).getStatusCode();
                                if (status != 200) throw new IOException("HTTP " + status);
                                if (location == null) throw new IOException("Empty HTTP download");
                                File source = new File(location.getPath());
                                if (source.length() > maxBytes) throw new IOException("HTTP response is too large");
                                try (InputStream input = new FileInputStream(source); OutputStream output = new FileOutputStream(downloaded)) {
                                    byte[] buffer = new byte[32768]; int read; long total = 0;
                                    while ((read = input.read(buffer)) != -1) {
                                        if ((total += read) > maxBytes) throw new IOException("HTTP response is too large");
                                        output.write(buffer, 0, read);
                                    }
                                }
                            } catch (Throwable failure) {
                                result.error = new IOException(failure.getMessage(), failure);
                            } finally { result.done.countDown(); }
                        }
                    }
                });
                long deadline = System.nanoTime() + TimeUnit.MILLISECONDS.toNanos(timeoutMillis + 1000L);
                long counted = 0;
                task.resume();
                try {
                    while (!result.done.await(200, TimeUnit.MILLISECONDS)) {
                        long received = task.getCountOfBytesReceived();
                        if (received > maxBytes) throw new IOException("HTTP response is too large");
                        if (received > counted) { progress.received((int)(received - counted)); counted = received; }
                        if (System.nanoTime() >= deadline) throw new java.net.SocketTimeoutException("NSURLSession download timed out");
                    }
                } catch (InterruptedException interrupted) {
                    Thread.currentThread().interrupt(); throw new IOException("HTTP download interrupted", interrupted);
                }
                if (result.error != null) throw result.error;
                long length = downloaded.length();
                if (length > counted) progress.received((int)(length - counted));
                InputStream input = new FileInputStream(downloaded) {
                    public void close() throws IOException { try { super.close(); } finally { downloaded.delete(); } }
                };
                success = true;
                return new HttpDownloads.Response(input, length, true);
            } finally { session.invalidateAndCancel(); }
        } finally {
            synchronized (result) { result.closed = true; if (!success) downloaded.delete(); }
        }
    }
}
