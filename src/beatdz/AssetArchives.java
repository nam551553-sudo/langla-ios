package beatdz;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Hashtable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/** Extract compressed artwork as it arrives; never retain a whole 100 MB archive in the mobile heap. */
final class AssetArchives {
    interface EntrySink { void write(String name, byte[] bytes) throws IOException; }
    private AssetArchives() { }

    static int download(String url, boolean refreshImages) throws IOException {
        HttpURLConnection connection = (HttpURLConnection)new URL(Utlis.i(url)).openConnection();
        connection.setConnectTimeout(beatdz.Utlis.$state_Utlis().timeOut);
        connection.setReadTimeout(beatdz.Utlis.$state_Utlis().timeOut * 2);
        try {
            if (connection.getResponseCode() != 200) throw new IOException("Image archive HTTP " + connection.getResponseCode());
            int expected = connection.getContentLength();
            CountingInputStream counter = new CountingInputStream(connection.getInputStream());
            try (BufferedInputStream input = new BufferedInputStream(counter, 32768)) {
                unpack(input, (name, bytes) -> cache(name, bytes, refreshImages));
                // ZipInputStream stops at the central directory. Count the rest for the archive revision marker.
                byte[] buffer = new byte[16384];
                while (input.read(buffer) != -1) { }
                if (expected >= 0 && counter.count != expected) throw new EOFException("Incomplete image archive");
                if (counter.count > Integer.MAX_VALUE) throw new IOException("Image archive is too large");
                return (int)counter.count;
            }
        } finally { connection.disconnect(); }
    }

    static void unpack(InputStream input, EntrySink sink) throws IOException {
        // Release the inflater while leaving the HTTP stream open for the central-directory drain.
        try (ZipInputStream zip = new ZipInputStream(new FilterInputStream(input) {
            @Override public void close() { }
        })) {
        byte[] buffer = new byte[16384];
        int entries = 0;
        ZipEntry entry;
        while ((entry = zip.getNextEntry()) != null) {
            if (entry.isDirectory()) { zip.closeEntry(); continue; }
            String name = entry.getName().replace("\\", "/").replace("bitmapC", "c")
                    .replace("iconTree", "tree").replace("iconChar", "char_icon").replace("iconClient", "client_icon")
                    .replace("/", "_").replace(".png", "").replace(".beatdz", "");
            if (!name.matches("[a-zA-Z0-9_.-]+")) throw new IOException("Invalid image cache name");
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            int read;
            while ((read = zip.read(buffer)) != -1) {
                if (bytes.size() + read > 32 * 1024 * 1024) throw new IOException("Image archive entry is too large");
                bytes.write(buffer, 0, read);
            }
            zip.closeEntry(); // Enforce CRC and truncation checks before committing an entry.
            if (bytes.size() > 0) sink.write(name, bytes.toByteArray());
            entries++;
        }
        if (entries == 0) throw new IOException("Invalid or empty image ZIP");
        }
    }

    private static void cache(String name, byte[] bytes, boolean refresh) {
        Binary.write(name, bytes);
        if (!refresh) return;
        Hashtable images;
        if (name.startsWith("char_")) images = beatdz.LangLa_fq.$state_LangLa_fq().g;
        else if (name.startsWith("client_")) images = beatdz.LangLa_fq.$state_LangLa_fq().e;
        else if (name.startsWith("tree_")) images = beatdz.LangLa_fq.$state_LangLa_fq().f;
        else return;
        try {
            short id = (short)Integer.parseInt(name.substring(name.lastIndexOf('_') + 1));
            if (images.get(id) != null) {
                mImage image = Binary.createImage(Utlis.a(bytes));
                if (image != null) images.put(id, image);
            }
        } catch (NumberFormatException ignored) { }
    }

    private static final class CountingInputStream extends FilterInputStream {
        long count;
        CountingInputStream(InputStream input) { super(input); }
        private void received(int bytes) {
            if (bytes <= 0) return;
            count += bytes;
            Session session = Session.gI(); session.countRecv += bytes; session.k += bytes;
        }
        @Override public int read() throws IOException { int value = in.read(); if (value != -1) received(1); return value; }
        @Override public int read(byte[] bytes, int offset, int length) throws IOException {
            int read = in.read(bytes, offset, length); received(read); return read;
        }
    }
}
