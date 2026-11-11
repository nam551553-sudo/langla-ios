package beatdz;

import java.io.*;
import java.util.Hashtable;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

/** Extract compressed artwork as it arrives; never retain a whole 100 MB archive in the mobile heap. */
final class AssetArchives {
    interface EntrySink { void write(String name, byte[] bytes) throws IOException; }
    private static final Pattern CACHE_NAME = Pattern.compile("[a-zA-Z0-9_.-]+");
    private static final int MAX_ENTRY_BYTES = 32 * 1024 * 1024;
    private AssetArchives() { }

    static int download(String url, boolean refreshImages) throws IOException {
        return download(url, refreshImages, -1);
    }

    static int download(String url, boolean refreshImages, int revisionSize) throws IOException {
        FileHandle bundled = refreshImages ? null : bundledIcons(url, revisionSize);
        if (bundled != null) {
            try (InputStream input = bundled.read()) {
                extract(input, bundled.length(), true, false);
                return revisionSize;
            } catch (IOException | RuntimeException failure) {
                Gdx.app.error("Assets", "Cannot read bundled startup icons", failure);
            }
        }
        int timeoutMillis = HttpDownloads.isNative() ? 1200000 : 300000;
        try (HttpDownloads.Response response = HttpDownloads.open(Utlis.i(url), timeoutMillis, 192L * 1024 * 1024)) {
            return extract(response.input, response.length, !response.progressCounted, refreshImages);
        }
    }

    static long startupBytes(String name, int revisionSize) {
        FileHandle bundled = bundledIcons(name, revisionSize);
        return bundled == null ? revisionSize : bundled.length();
    }

    private static FileHandle bundledIcons(String name, int revisionSize) {
        if (!HttpDownloads.isNative() || revisionSize <= 0
                || !(name.equals("iconClient.zip") || name.endsWith("/iconClient.zip"))) return null;
        int density = DataCenter.a("iconClient.zip") + 1;
        FileHandle directory = Gdx.files.internal("data/ios-hd/zoom" + density);
        FileHandle archive = directory.child("iconClient.zip");
        if (!archive.exists() || archive.length() <= 0) return null;
        if (archive.length() == revisionSize) return archive;

        // The compact pack uses the source archive's manifest revision. A new server revision
        // takes the ordinary download path, and missing icons use the existing per-image loader.
        FileHandle sourceSize = directory.child("source-size.txt");
        try {
            return sourceSize.exists() && Integer.parseInt(sourceSize.readString("UTF-8").trim()) == revisionSize
                    ? archive : null;
        } catch (RuntimeException invalidRevision) {
            return null;
        }
    }

    private static int extract(InputStream stream, long expected, boolean countProgress, boolean refreshImages) throws IOException {
        CountingInputStream counter = new CountingInputStream(stream, countProgress);
        try (BufferedInputStream input = new BufferedInputStream(counter, 32768)) {
            unpack(input, (name, bytes) -> cache(name, bytes, refreshImages));
            // ZipInputStream stops at the central directory. Count the rest for the archive revision marker.
            byte[] buffer = new byte[16384];
            while (input.read(buffer) != -1) { }
            if (expected >= 0 && counter.count != expected) throw new EOFException("Incomplete image archive");
            if (counter.count > Integer.MAX_VALUE) throw new IOException("Image archive is too large");
            return (int)counter.count;
        }
    }

    static void unpack(InputStream input, EntrySink sink) throws IOException {
        // Release the inflater while leaving the HTTP stream open for the central-directory drain.
        try (ZipInputStream zip = new ZipInputStream(new FilterInputStream(input) {
            @Override public void close() { }
        })) {
        byte[] buffer = new byte[16384];
            DataInputStream entriesStream = new DataInputStream(zip);
        int entries = 0;
        ZipEntry entry;
        while ((entry = zip.getNextEntry()) != null) {
            if (entry.isDirectory()) { zip.closeEntry(); continue; }
            String name = entry.getName().replace("\\", "/").replace("bitmapC", "c")
                    .replace("iconTree", "tree").replace("iconChar", "char_icon").replace("iconClient", "client_icon")
                    .replace("/", "_").replace(".png", "").replace(".beatdz", "");
            if (!CACHE_NAME.matcher(name).matches()) throw new IOException("Invalid image cache name");
            long size = entry.getSize();
            if (size > MAX_ENTRY_BYTES) throw new IOException("Image archive entry is too large");
            byte[] image;
            if (size >= 0) {
                image = new byte[(int)size];
                entriesStream.readFully(image);
                if (zip.read() != -1) throw new IOException("Unexpected image archive entry length");
            } else {
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                int read;
                while ((read = zip.read(buffer)) != -1) {
                    if (bytes.size() + read > MAX_ENTRY_BYTES) throw new IOException("Image archive entry is too large");
                    bytes.write(buffer, 0, read);
                }
                image = bytes.toByteArray();
            }
            zip.closeEntry(); // Enforce CRC and truncation checks before committing an entry.
            if (image.length > 0) sink.write(name, image);
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
        final boolean countNetwork;
        CountingInputStream(InputStream input, boolean countNetwork) { super(input); this.countNetwork = countNetwork; }
        private void received(int bytes) {
            if (bytes <= 0) return;
            count += bytes;
            if (countNetwork) HttpDownloads.received(bytes);
        }
        @Override public int read() throws IOException { int value = in.read(); if (value != -1) received(1); return value; }
        @Override public int read(byte[] bytes, int offset, int length) throws IOException {
            int read = in.read(bytes, offset, length); received(read); return read;
        }
    }
}
