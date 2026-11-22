package com.langla.j2me;

import java.io.DataInputStream;
import java.io.IOException;

final class MapLayout {
    final int width;
    final int height;
    final short[][] definitions;
    final short[][] scenery;
    private final short[][] obstacles;
    private final short[][] platforms;

    private MapLayout(int width, int height, short[][] definitions, short[][] scenery,
                      short[][] obstacles, short[][] platforms) {
        this.width = width;
        this.height = height;
        this.definitions = definitions;
        this.scenery = scenery;
        this.obstacles = obstacles;
        this.platforms = platforms;
    }

    static MapLayout read(DataInputStream map) throws IOException {
        int tiles = map.readUnsignedShort();
        if (tiles > 4096) throw new IOException("Quá nhiều loại địa hình.");
        short[][] definitions = new short[tiles][3];
        for (int tile = 0; tile < tiles; tile++) {
            definitions[tile][0] = map.readShort();
            definitions[tile][1] = map.readShort();
            definitions[tile][2] = (short) map.readUnsignedByte();
            skip(map, 2);
            skipPolygons(map);
        }
        int groups = map.readUnsignedShort();
        for (int group = 0; group < groups; group++) {
            skip(map, 4);
            skip(map, map.readUnsignedByte() * 7);
            skipPolygons(map);
        }
        int width = map.readShort();
        int height = map.readShort();
        if (width <= 0 || height <= 0) throw new IOException("Kích thước bản đồ không hợp lệ.");
        short[][] obstacles = new short[map.readUnsignedByte()][];
        for (int i = 0; i < obstacles.length; i++) obstacles[i] = points(map, map.readUnsignedByte());
        int paths = map.readUnsignedShort();
        java.util.Vector platforms = new java.util.Vector();
        for (int i = 0; i < paths; i++) {
            boolean surface = map.readBoolean();
            int vertices = map.readUnsignedShort();
            if (surface) platforms.addElement(points(map, vertices));
            else skip(map, vertices * 4);
        }
        skip(map, map.readUnsignedShort() * 2);
        int count = map.readUnsignedShort();
        if (count > 8192) throw new IOException("Quá nhiều ô địa hình.");
        short[][] scenery = new short[count][4];
        for (int i = 0; i < count;) {
            int id = map.readUnsignedShort();
            int copies = map.readUnsignedShort();
            if (id >= tiles || copies == 0 || copies > count - i) {
                throw new IOException("Nhóm địa hình không hợp lệ.");
            }
            while (copies-- > 0) {
                short[] tile = scenery[i++];
                tile[0] = (short) id;
                tile[1] = map.readShort();
                tile[2] = map.readShort();
                tile[3] = map.readByte();
            }
        }
        short[][] surfaces = new short[platforms.size()][];
        platforms.copyInto(surfaces);
        return new MapLayout(width, height, definitions, scenery, obstacles, surfaces);
    }

    private static short[] points(DataInputStream map, int count) throws IOException {
        if (count > 4096) throw new IOException("Quá nhiều điểm va chạm.");
        short[] result = new short[count * 2];
        for (int i = 0; i < result.length; i++) result[i] = map.readShort();
        return result;
    }

    boolean blocked(int x, int y) {
        if (x < 16 || x >= width - 15 || y < 16 || y >= height - 15) return true;
        for (int p = 0; p < obstacles.length; p++) {
            short[] polygon = obstacles[p];
            boolean inside = false;
            for (int i = 0, j = polygon.length - 2; i < polygon.length; j = i, i += 2) {
                int ay = polygon[i + 1], by = polygon[j + 1];
                if ((ay > y) != (by > y)
                        && x < polygon[i] + (long) (polygon[j] - polygon[i]) * (y - ay) / (by - ay)) {
                    inside = !inside;
                }
            }
            if (inside) return true;
        }
        return false;
    }

    boolean platformBetween(int x, int above, int below) {
        for (int p = 0; p < platforms.length; p++) {
            short[] line = platforms[p];
            for (int i = 2; i < line.length; i += 2) {
                int ax = line[i - 2], bx = line[i];
                if (ax == bx || x < Math.min(ax, bx) || x > Math.max(ax, bx)) continue;
                int ay = line[i - 1], by = line[i + 1];
                int y = ay + (int) ((long) (by - ay) * (x - ax) / (bx - ax));
                if (y > above && y <= below) return true;
            }
        }
        return false;
    }

    private static void skipPolygons(DataInputStream map) throws IOException {
        int groups = map.readUnsignedByte();
        for (int group = 0; group < groups; group++) {
            int polygons = map.readUnsignedByte();
            for (int polygon = 0; polygon < polygons; polygon++) {
                int coordinates = map.readUnsignedByte();
                skip(map, coordinates * 2);
            }
        }
    }

    private static void skip(DataInputStream map, int count) throws IOException {
        if (map.skipBytes(count) != count) throw new IOException("Thiếu dữ liệu bản đồ.");
    }
}
