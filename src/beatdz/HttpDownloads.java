package beatdz;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/** Platform HTTP seam: iOS installs NSURLSession before the game starts. */
public final class HttpDownloads {
    public interface Progress { void received(int bytes); }
    public interface Transport {
        Response open(String url, int timeoutMillis, long maxBytes, Progress progress) throws IOException;
    }
    public static final class Response implements Closeable {
        public final InputStream input;
        public final long length;
        public final boolean progressCounted;
        public Response(InputStream input, long length, boolean progressCounted) {
            this.input = input; this.length = length; this.progressCounted = progressCounted;
        }
        public void close() throws IOException { input.close(); }
    }
    private static volatile Transport transport;
    private static final ThreadLocal<String> ERROR = new ThreadLocal<String>();
    private HttpDownloads() { }
    public static void install(Transport value) { transport = value; }
    public static boolean isNative() { return transport != null; }
    public static String lastError() { return ERROR.get(); }
    public static void received(int bytes) {
        if (bytes <= 0) return;
        Session session = Session.gI();
        synchronized (session) { session.countRecv += bytes; session.k += bytes; }
    }
    public static Response open(String url, int timeoutMillis, long maxBytes) throws IOException {
        ERROR.remove();
        try {
            Transport nativeTransport = transport;
            if (nativeTransport != null) return nativeTransport.open(url, timeoutMillis, maxBytes, HttpDownloads::received);
            final HttpURLConnection connection = (HttpURLConnection)new URL(url).openConnection();
            connection.setConnectTimeout(Math.min(10000, timeoutMillis));
            connection.setReadTimeout(Math.min(30000, timeoutMillis));
            connection.setUseCaches(false);
            connection.setRequestProperty("User-Agent", "LangLaTest");
            try {
                if (connection.getResponseCode() != 200) throw new IOException("HTTP " + connection.getResponseCode());
                long length = connection.getContentLengthLong();
                if (length > maxBytes) throw new IOException("HTTP response is too large");
                return new Response(new FilterInputStream(connection.getInputStream()) {
                    long count;
                    public int read(byte[] bytes, int offset, int length) throws IOException {
                        int read = super.read(bytes, offset, length);
                        if (read > 0 && (count += read) > maxBytes) throw new IOException("HTTP response is too large");
                        return read;
                    }
                    public void close() throws IOException { try { super.close(); } finally { connection.disconnect(); } }
                }, length, false);
            } catch (IOException | RuntimeException failure) { connection.disconnect(); throw failure; }
        } catch (IOException failure) { ERROR.set(failure.getMessage()); throw failure; }
    }
    public static byte[] bytes(String url, int timeoutMillis, int maxBytes) throws IOException {
        try (Response response = open(url, timeoutMillis, maxBytes)) {
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buffer = new byte[16384];
            int read;
            while ((read = response.input.read(buffer)) != -1) {
                if (output.size() + read > maxBytes) throw new IOException("HTTP response is too large");
                output.write(buffer, 0, read);
                if (!response.progressCounted) received(read);
            }
            if (response.length >= 0 && output.size() != response.length) throw new EOFException("Incomplete HTTP response");
            return output.toByteArray();
        }
    }
}
