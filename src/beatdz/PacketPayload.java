package beatdz;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

final class PacketPayload {
    static final int MAX_BYTES = 16 * 1024 * 1024;
    private PacketPayload() { }

    static byte[] inflate(byte[] bytes) throws IOException {
        Inflater inflater = new Inflater();
        inflater.setInput(bytes);
        try (ByteArrayOutputStream output = new ByteArrayOutputStream(Math.min(bytes.length * 2, 8192))) {
            byte[] buffer = new byte[8192];
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                if (count > 0) {
                    if (output.size() > MAX_BYTES - count) throw new IOException("Server payload is too large");
                    output.write(buffer, 0, count);
                } else if (!inflater.finished()) {
                    if (inflater.needsInput()) throw new EOFException("Incomplete compressed server packet");
                    throw new IOException("Invalid compressed server packet");
                }
            }
            if (inflater.getRemaining() != 0) throw new IOException("Trailing compressed server data");
            return output.toByteArray();
        } catch (DataFormatException invalid) {
            throw new IOException("Invalid compressed server packet", invalid);
        } finally { inflater.end(); }
    }
}
