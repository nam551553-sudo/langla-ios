package beatdz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Base64Coder;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

/** Client for the server's existing bank top-up events; never credits currency locally. */
public final class GoldTopUpPanel extends LangLa_fo {
    private static final Pattern EMBEDDED_PNG = Pattern.compile("href=\"data:image/png;base64,([A-Za-z0-9+/=]+)\"");
    @Override public void a(int event, Object value) { }
    @Override public void a(int event, Object value, LangLa_cy source) { }
    @Override public void b() { tiers.b(); }
    private final LangLa_cg tiers;
    private String details = "Chọn mốc nạp rồi nhấn Tạo QR.\nTiền được cộng vào số dư web theo thông tin server.";
    private String url;
    private String status = "";
    private mImage qr;
    private long requestedAt;
    private int generation;
    private boolean closed;

    public GoldTopUpPanel(MainScreen screen) {
        p = screen;
        cF = 2;
        a(360, 275);
        tiers = a(12, 32, 225, 4, new LangLa_kd(2000, new String[]{
            "10.000 đ", "50.000 đ", "100.000 đ", "200.000 đ", "500.000 đ",
            "1.000.000 đ", "2.000.000 đ", "5.000.000 đ", "10.000.000 đ"}), this, 0);
        tiers.a(0);
        a(250, 32, "Tạo QR", this, 2001, -8).setSize(96, 22);
        a(12, 242, "Mở QR", this, 2002, -8).setSize(96, 22);
        a(121, 242, "Sao chép", this, 2003, -8).setSize(96, 22);
    }

    static boolean validQrUrl(String value) {
        try {
            URI uri = new URI(value);
            return "https".equalsIgnoreCase(uri.getScheme()) && "img.vietqr.io".equalsIgnoreCase(uri.getHost())
                && uri.getUserInfo() == null && (uri.getPort() == -1 || uri.getPort() == 443);
        } catch (Exception e) { return false; }
    }

    public void receive(String title, String text, String imageUrl) {
        requestedAt = 0;
        details = text == null ? "" : text;
        // The legacy compact string encoder replaces newlines with spaces.
        for (String field : new String[]{"MBBank:", "Số tiền:", "Nhận:", "Nội dung:", "Lệnh có hiệu lực", "Chưa bật auto bank"})
            details = details.replace(" " + field, "\n" + field);
        url = validQrUrl(imageUrl) ? imageUrl : null;
        final int ticket = ++generation;
        if (qr != null) { qr.a(); qr = null; }
        status = url == null ? "QR không hợp lệ" : "Đang tải QR...";
        if (url == null) return;
        final String source = url;
        Thread worker = new Thread(() -> {
            byte[] result = null;
            HttpURLConnection connection = null;
            try {
                URI imageUri = new URI(source);
                if (imageUri.getPath().endsWith(".png")) {
                    String svgUrl = source.replaceFirst("\\.png(?=\\?|$)", ".svg");
                    imageUri = new URI(svgUrl);
                }
                connection = (HttpURLConnection)imageUri.toURL().openConnection();
                connection.setConnectTimeout(10000);
                connection.setReadTimeout(10000);
                connection.setInstanceFollowRedirects(false);
                if (connection.getResponseCode() != 200) throw new java.io.IOException();
                try (InputStream input = connection.getInputStream(); ByteArrayOutputStream output = new ByteArrayOutputStream()) {
                    byte[] buffer = new byte[8192];
                    int count;
                    while ((count = input.read(buffer)) != -1) {
                        if (output.size() + count > 2 * 1024 * 1024) throw new java.io.IOException();
                        output.write(buffer, 0, count);
                    }
                    byte[] bytes = output.toByteArray();
                    String contentType = connection.getContentType();
                    if (contentType != null && contentType.startsWith("image/svg+xml")) {
                        java.util.regex.Matcher png = EMBEDDED_PNG.matcher(new String(bytes, StandardCharsets.UTF_8));
                        if (png.find()) result = Base64Coder.decode(png.group(1));
                    } else if (contentType != null && contentType.startsWith("image/png")) {
                        result = bytes;
                    }
                }
            } catch (Exception ignored) {
                // The browser fallback remains available; never log payment references or URLs.
            } finally { if (connection != null) connection.disconnect(); }
            final byte[] image = result;
            Gdx.app.postRunnable(MultiSession.bind(() -> {
                if (closed || generation != ticket) return;
                if (image != null) qr = mImage.a(image, 0, image.length);
                status = qr == null ? "Không tải được QR; chọn Mở QR" : "";
            }));
        }, "topup-qr");
        worker.setDaemon(true);
        worker.start();
    }

    @Override public void a(Graphics graphics) {
        a(graphics, cx, cy, width, height, "Nạp Vàng", (byte)2, false);
        if (qr != null) {
            int size = 142;
            float scale = Math.min((float)size / qr.c, (float)size / qr.d);
            int w = Math.max(1, Math.round(qr.c * scale));
            int h = Math.max(1, Math.round(qr.d * scale));
            graphics.a(qr, 0, 0, qr.c, qr.d, 0, 12 + (size - w) / 2, 66 + (size - h) / 2,
                w * DataCenter.gI().zoomLevel, h * DataCenter.gI().zoomLevel, 0);
        }
        int y = 65;
        for (String paragraph : details.split("\n")) {
            for (String line : mFont.c(mFont.d, paragraph, 187)) {
                if (y > 225) break;
                mFont.b(mFont.d, graphics, line, 163, y, 0, -1, -16777216);
                y += 12;
            }
        }
        String message = requestedAt != 0
            ? (System.currentTimeMillis() - requestedAt < 15000 ? "Đang yêu cầu server..." : "Chưa nhận QR. Kiểm tra thông báo server rồi thử lại.") : status;
        mFont.b(mFont.d, graphics, message, 12, 223, 0, -2560, -16777216);
    }

    @Override public void a(LangLa_jz event, int x, int y) {
        try {
            if (event.b == 2001) {
                if (requestedAt != 0 && System.currentTimeMillis() - requestedAt < 15000) return;
                Message request = new Message((byte)122);
                request.writeByte(127);
                request.writeByte(tiers.b.b);
                request.send();
                requestedAt = System.currentTimeMillis();
            } else if (event.b == 2002 && url != null) Gdx.net.openURI(url);
            else if (event.b == 2003) Gdx.app.getClipboard().setContents(details);
        } catch (Exception ignored) { status = "Không thể gửi yêu cầu. Vui lòng thử lại."; requestedAt = 0; }
    }

    @Override public void d() {
        closed = true;
        ++generation;
        if (qr != null) { qr.a(); qr = null; }
    }
}
