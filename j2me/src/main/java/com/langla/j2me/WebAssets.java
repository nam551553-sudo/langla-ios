package com.langla.j2me;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Image;

final class WebAssets {
    private static final String BASE = "https://langlablue.com/langlaapp/";

    static String[][] servers() throws IOException {
        String text = new String(fetch("serverlist.txt", 16384), "UTF-8");
        Vector rows = new Vector();
        int start = 0;
        while (start < text.length()) {
            int end = text.indexOf('\n', start);
            if (end < 0) end = text.length();
            String line = text.substring(start, end).trim();
            int equals = line.indexOf('=');
            if (equals > 0 && !line.substring(0, equals).trim().equals("id")) {
                int first = line.indexOf(':', equals);
                int second = first < 0 ? -1 : line.indexOf(':', first + 1);
                int third = second < 0 ? -1 : line.indexOf(':', second + 1);
                if (third > second && second > first) {
                    rows.addElement(new String[]{line.substring(0, equals).trim(),
                            line.substring(first + 1, second).trim(), line.substring(second + 1, third).trim()});
                }
            }
            start = end + 1;
        }
        if (rows.size() == 0) throw new IOException("Danh sách máy chủ trống.");
        String[][] result = new String[rows.size()][];
        rows.copyInto(result);
        return result;
    }

    static byte[] gameData() throws IOException {
        return fetch("arr_data_game.bin", 524288);
    }

    static Image characterImage(int id) throws IOException {
        String path = new StringBuffer("img/zoom1/iconChar/").append(id).append(".png").toString();
        return decodeImage(fetch(path, 98304));
    }

    static Image mapImage(int id) throws IOException {
        String path = new StringBuffer("img/zoom1/map/").append(id).append(".png").toString();
        try {
            return decodeImage(fetch(path, 262144));
        } catch (IOException unavailable) {
            return Image.createImage(new StringBuffer("/map/").append(id).append(".png").toString());
        }
    }

    static Image terrainImage(int id) throws IOException {
        String path = new StringBuffer("img/zoom1/iconTree/").append(id).append(".png").toString();
        return decodeImage(fetch(path, 1048576));
    }

    static Image decodeImage(byte[] bytes) throws IOException {
        if (!png(bytes) && !jpeg(bytes) && bytes.length >= 51) {
            for (int left = 0, right = 50; left < right; left++, right--) {
                byte value = bytes[left];
                bytes[left] = bytes[right];
                bytes[right] = value;
            }
        }
        int width;
        int height;
        if (png(bytes) && bytes.length >= 24) {
            java.io.DataInputStream header = new java.io.DataInputStream(new java.io.ByteArrayInputStream(bytes, 16, 8));
            width = header.readInt();
            height = header.readInt();
        } else if (jpeg(bytes)) {
            int dimensions = jpegSize(bytes);
            width = dimensions >>> 16;
            height = dimensions & 65535;
        } else {
            throw new IOException("Ảnh web không hợp lệ.");
        }
        if (width < 1 || height < 1 || width > 2048 || height > 2048 || width * height > 786432) {
            throw new IOException("Ảnh vượt giới hạn bộ nhớ.");
        }
        try { return Image.createImage(bytes, 0, bytes.length); }
        catch (IllegalArgumentException unsupported) { throw new IOException("Trình giả lập không đọc được ảnh."); }
    }

    private static boolean png(byte[] bytes) {
        return bytes.length >= 8 && bytes[0] == (byte) 137 && bytes[1] == 80 && bytes[2] == 78 && bytes[3] == 71;
    }

    private static boolean jpeg(byte[] bytes) {
        return bytes.length >= 3 && bytes[0] == (byte) 255 && bytes[1] == (byte) 216 && bytes[2] == (byte) 255;
    }

    private static int jpegSize(byte[] bytes) throws IOException {
        int offset = 2;
        while (offset + 3 < bytes.length && (bytes[offset++] & 255) == 255) {
            while (offset < bytes.length && (bytes[offset] & 255) == 255) offset++;
            if (offset + 2 >= bytes.length) break;
            int marker = bytes[offset++] & 255;
            if (marker == 218 || marker == 217) break;
            int length = unsignedShort(bytes, offset);
            if (length < 2 || length > bytes.length - offset) break;
            if ((marker == 192 || marker == 193 || marker == 194) && length >= 8) {
                return (unsignedShort(bytes, offset + 5) << 16) | unsignedShort(bytes, offset + 3);
            }
            offset += length;
        }
        throw new IOException("Thiếu kích thước JPEG.");
    }

    private static int unsignedShort(byte[] bytes, int offset) {
        return ((bytes[offset] & 255) << 8) | (bytes[offset + 1] & 255);
    }

    private static byte[] fetch(String path, int limit) throws IOException {
        HttpConnection response = (HttpConnection) Connector.open(BASE.concat(path), Connector.READ, true);
        InputStream stream = null;
        try {
            if (response.getResponseCode() != HttpConnection.HTTP_OK || response.getLength() > limit) {
                throw new IOException("Không tải được dữ liệu web.");
            }
            stream = response.openInputStream();
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buffer = new byte[2048];
            int count;
            while ((count = stream.read(buffer)) != -1) {
                if (count > limit - output.size()) throw new IOException("Dữ liệu web vượt giới hạn.");
                output.write(buffer, 0, count);
            }
            return output.toByteArray();
        } finally {
            try { if (stream != null) stream.close(); }
            finally { response.close(); }
        }
    }
}
