package com.langla.j2me;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.SocketConnection;

final class LoginSession {
    private static final String ALPHABET = " 0123456789+-*='\"\\/_?.,ˋˊ~ˀ:;|<>[]{}!@#$%^&*()aáàảãạâấầẩẫậăắằẳẵặbcdđeéèẻẽẹêếềểễệfghiíìỉĩịjklmnoóòỏõọôốồổỗộơớờởỡợpqrstuúùủũụưứừửữựvxyýỳỷỹỵzwAÁÀẢÃẠÂẤẦẨẪẬĂẮẰẲẴẶBCDĐEÉÈẺẼẸÊẾỀỂỄỆFGHIÍÌỈĨỊJKLMNOÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢPQRSTUÚÙỦŨỤƯỨỪỬỮỰVXYÝỲỶỸỴZW";
    private SocketConnection socket;
    private DataInputStream input;
    private DataOutputStream output;
    private boolean closed;
    private int layoutId = -1;
    private MapLayout layout;

    String[] login(String endpoint, String username, String password) throws IOException {
        SocketConnection connection = (SocketConnection) Connector.open(endpoint, Connector.READ_WRITE, true);
        synchronized (this) {
            if (closed) {
                connection.close();
                throw new IOException("Đã hủy kết nối.");
            }
            socket = connection;
            input = socket.openDataInputStream();
            output = socket.openDataOutputStream();
        }
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        DataOutputStream hello = new DataOutputStream(bytes);
        hello.writeShort(0);
        hello.writeShort(240);
        hello.writeShort(320);
        hello.writeByte(1);
        hello.writeByte(0);
        hello.writeInt(0);
        hello.writeByte(0);
        for (int index = 0; index < 4; index++) {
            hello.writeInt(0);
        }
        hello.writeShort(2);
        send(-113, bytes.toByteArray());

        bytes.reset();
        hello.writeByte(-127);
        hello.writeByte(0);
        hello.writeUTF(username);
        hello.writeByte(0);
        hello.writeUTF(password);
        send(-123, bytes.toByteArray());
        DataInputStream roster = await(-128);
        int count = roster.readUnsignedByte();
        if (count > 9) {
            throw new IOException("Danh sách nhân vật không hợp lệ.");
        }
        String[] names = new String[count];
        for (int index = 0; index < count; index++) {
            roster.readInt();
            roster.readByte();
            names[index] = decode(roster);
            if (roster.skipBytes(36) != 36) throw new IOException("Thiếu dữ liệu nhân vật.");
            int equipment = roster.readUnsignedByte();
            for (int item = 0; item < equipment; item++) {
                if (roster.skipBytes(13) != 13) throw new IOException("Thiếu dữ liệu trang bị.");
                decode(roster);
            }
            if (roster.skipBytes(5) != 5) throw new IOException("Thiếu dữ liệu nhân vật.");
        }
        return names;
    }

    String selectCharacter(int index) throws IOException {
        send(-122, new byte[]{-127, (byte) index});
        DataInputStream character = await(-127);
        decode(character);
        character.readInt();
        return decode(character);
    }

    void keepReceiving() throws IOException {
        await(0);
    }

    void move(int x, int y, boolean moving) throws IOException {
        output.writeByte(moving ? 123 : -84);
        output.writeShort(x);
        output.writeShort(y);
        output.flush();
    }

    synchronized boolean isClosed() { return closed; }

    MapCanvas openMap(String name) throws IOException {
        DataInputStream snapshot = await(-103);
        int zone = snapshot.readUnsignedShort();
        int map = snapshot.readUnsignedShort();
        int x = snapshot.readShort();
        int y = snapshot.readShort();
        return new MapCanvas(name, zone, map, x, y, layoutId == map ? layout : null);
    }

    private void send(int command, byte[] data) throws IOException {
        output.writeByte(command);
        output.writeShort(data.length);
        output.write(data);
        output.flush();
    }

    private DataInputStream await(int wanted) throws IOException {
        for (int frame = 0; wanted == 0 || frame < 128; frame++) {
            int command = input.readByte();
            if (wanted == 0 && command == -103) {
                throw new IOException("Máy chủ đã chuyển bản đồ. Đăng nhập lại để tải khu mới.");
            }
            if (command == -86) {
                throw new IOException("Máy chủ yêu cầu đăng nhập lại.");
            }
            if (command == -84 || command == 123) {
                skip(8);
                continue;
            }
            int length;
            if (command == -128 || command == -80) {
                boolean compressed = command == -80;
                command = input.readByte();
                length = compressed ? input.readUnsignedShort() : input.readInt();
                if (compressed) {
                    skip(length);
                    continue;
                }
            } else {
                if (command == -79) {
                    input.readUnsignedShort();
                }
                length = input.readUnsignedShort();
            }
            if (length < 0 || length > 4194304) {
                throw new IOException("Gói dữ liệu máy chủ không hợp lệ.");
            }
            if (wanted != 0 && wanted != -103 && (command == -110 || command == -107) && length > 0 && length <= 4096) {
                byte[] message = new byte[length];
                input.readFully(message);
                throw new IOException(decode(new DataInputStream(new java.io.ByteArrayInputStream(message))));
            }
            if (wanted == -103 && command == -111 && length >= 3) {
                int kind = input.readUnsignedByte();
                if (kind == 3 && length <= 262144) {
                    layoutId = input.readUnsignedShort();
                    byte[] data = new byte[length - 3];
                    input.readFully(data);
                    try {
                        layout = MapLayout.read(new DataInputStream(new java.io.ByteArrayInputStream(data)));
                    } catch (IOException unsupported) {
                        layout = null;
                    }
                    continue;
                }
                length--;
            }
            if (wanted == -103 && command == -103 && length >= 8) {
                byte[] header = new byte[8];
                input.readFully(header);
                skip(length - header.length);
                return new DataInputStream(new java.io.ByteArrayInputStream(header));
            }
            if (wanted != 0 && command == -122 && length > 0) {
                if (input.readByte() == wanted) {
                    byte[] message = new byte[length - 1];
                    input.readFully(message);
                    return new DataInputStream(new java.io.ByteArrayInputStream(message));
                }
                length--;
            }
            skip(length);
        }
        throw new IOException("Chưa nhận được phản hồi phù hợp từ máy chủ.");
    }

    private static String decode(DataInputStream stream) throws IOException {
        int length = stream.readUnsignedByte();
        if (length == 0) {
            return stream.readUTF();
        }
        StringBuffer text = new StringBuffer(length);
        for (int i = 0; i < length; i++) {
            int code = stream.readUnsignedByte();
            text.append(code < ALPHABET.length() ? ALPHABET.charAt(code) : '?');
        }
        return text.toString();
    }

    private final byte[] discard = new byte[1024];

    private void skip(int length) throws IOException {
        while (length > 0) {
            int count = Math.min(discard.length, length);
            input.readFully(discard, 0, count);
            length -= count;
        }
    }

    synchronized void close() {
        closed = true;
        if (socket != null) {
            try { socket.close(); } catch (IOException ignored) { }
        }
        if (input != null) {
            try { input.close(); } catch (IOException ignored) { }
        }
        if (output != null) {
            try { output.close(); } catch (IOException ignored) { }
        }
    }

}
