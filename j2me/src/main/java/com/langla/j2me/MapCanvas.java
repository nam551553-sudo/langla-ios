package com.langla.j2me;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

final class MapCanvas extends Canvas {
    private final String title;
    private final String name;
    private volatile int x;
    private volatile int y;
    private volatile int direction;
    private volatile boolean jump;
    private volatile int facing = 1;
    private final int width;
    private final int height;
    private final MapLayout layout;
    private Image[] terrain;
    final int mapId;
    private Image map;
    private String status = "Đang tải ảnh bản đồ...";

    MapCanvas(String name, int zone, int mapId, int x, int y, MapLayout layout) {
        title = new StringBuffer(name).append(" · Bản đồ ").append(mapId).append(" · Khu ").append(zone).toString();
        this.name = name;
        this.x = x;
        this.y = y;
        this.mapId = mapId;
        this.layout = layout;
        width = layout == null ? 0 : layout.width;
        height = layout == null ? 0 : layout.height;
    }

    void play(LoginSession session) {
        if (layout == null) return;
        int velocity = 0;
        boolean sentMoving = false;
        try {
            while (!session.isClosed()) {
                int oldX = x, oldY = y;
                int walk = direction;
                if (walk != 0) facing = walk;
                for (int i = 0; i < 4 && walk != 0 && !layout.blocked(x + walk, y - 1); i++) x += walk;
                boolean grounded = layout.blocked(x, y + 1) || layout.platformBetween(x, y - 1, y + 1);
                if (jump && grounded) velocity = -10;
                jump = false;
                if (grounded && velocity >= 0) velocity = 0;
                else velocity = Math.min(12, velocity + 1);
                int sign = velocity < 0 ? -1 : 1;
                for (int i = 0; i < Math.abs(velocity); i++) {
                    if (layout.blocked(x, y + sign)
                            || (sign > 0 && layout.platformBetween(x, y, y + 1))) {
                        velocity = 0;
                        break;
                    }
                    y += sign;
                }
                boolean moved = oldX != x || oldY != y;
                if (moved || sentMoving) session.move(x, y, moved);
                sentMoving = moved;
                if (moved) repaint();
                Thread.sleep(50);
            }
        } catch (Exception stopped) {
            session.close();
        }
    }

    protected void keyPressed(int key) {
        int action = getGameAction(key);
        if (action == LEFT) direction = -1;
        if (action == RIGHT) direction = 1;
        if (action == UP || action == FIRE) jump = true;
    }

    protected void keyReleased(int key) {
        int action = getGameAction(key);
        if (action == LEFT && direction < 0 || action == RIGHT && direction > 0) direction = 0;
    }

    protected void hideNotify() { direction = 0; jump = false; }

    Image[] loadTerrain(int screenWidth, int screenHeight) {
        if (layout == null) return null;
        Image[] images = new Image[layout.definitions.length];
        boolean[] requested = new boolean[images.length];
        int pixelBudget = 2097152;
        int requests = 0;
        int loaded = 0;
        for (int i = 0; i < layout.scenery.length && requests < 32 && pixelBudget > 0; i++) {
            short[] tile = layout.scenery[i];
            int id = tile[0];
            short[] definition = layout.definitions[id];
            if (requested[id] || id == 303 || !visible(tile, definition, screenWidth + 256, screenHeight + 160)) continue;
            requested[id] = true;
            requests++;
            try {
                Image image = WebAssets.terrainImage(id);
                int pixels = image.getWidth() * image.getHeight();
                if (pixels <= pixelBudget) {
                    images[id] = image;
                    pixelBudget -= pixels;
                    loaded++;
                }
            } catch (Exception unavailable) { }
        }
        return loaded == 0 ? null : images;
    }

    void setTerrain(Image[] images) {
        terrain = images;
        status = "Địa hình từ máy chủ";
        repaint();
    }

    private boolean visible(short[] tile, short[] definition, int w, int h) {
        int left = tile[1] - definition[0] / 2;
        return left < x + w / 2 && left + definition[0] > x - w / 2
                && tile[2] > y - h / 2 && tile[2] - definition[1] < y + h / 2;
    }

    void setMap(Image image) {
        map = image;
        status = image == null ? "Thiếu ảnh bản đồ" : "Bản đồ thu nhỏ";
        repaint();
    }

    protected void paint(Graphics g) {
        g.setColor(terrain == null ? 0x182824 : 0x88b8cb);
        g.fillRect(0, 0, getWidth(), getHeight());
        if (terrain != null) {
            int centerX = getWidth() / 2;
            int centerY = getHeight() / 2;
            for (int i = 0; i < layout.scenery.length; i++) {
                short[] tile = layout.scenery[i];
                Image image = terrain[tile[0]];
                if (image == null) continue;
                short[] definition = layout.definitions[tile[0]];
                int w = Math.min(image.getWidth(), definition[0]);
                int h = Math.min(image.getHeight(), definition[1]);
                if (w < 1 || h < 1) continue;
                int transform = tile[3] == 7 ? javax.microedition.lcdui.game.Sprite.TRANS_MIRROR : 0;
                g.drawRegion(image, 0, 0, w, h, transform,
                        centerX + tile[1] - x, centerY + tile[2] - y, Graphics.HCENTER | Graphics.BOTTOM);
            }
            drawPlayer(g, centerX, centerY);
        } else if (map != null) {
            int mx = width == 0 ? map.getWidth() / 2 : Math.max(0, Math.min(map.getWidth() - 1, x * map.getWidth() / width));
            int my = height == 0 ? map.getHeight() / 2 : Math.max(0, Math.min(map.getHeight() - 1, y * map.getHeight() / height));
            int centerX = getWidth() / 2;
            int centerY = getHeight() / 2;
            g.drawImage(map, centerX - mx, centerY - my, Graphics.TOP | Graphics.LEFT);
            if (width != 0 && height != 0) {
                g.setColor(0x151515);
                g.fillArc(centerX - 6, centerY - 6, 12, 12, 0, 360);
                g.setColor(0xffdc62);
                g.fillArc(centerX - 4, centerY - 4, 8, 8, 0, 360);
            }
        }
        g.setColor(0x182824);
        g.fillRect(0, 0, getWidth(), 38);
        g.fillRect(0, getHeight() - 20, getWidth(), 20);
        g.setColor(0xffffff);
        g.drawString(title, 4, 2, Graphics.TOP | Graphics.LEFT);
        g.drawString(new StringBuffer("Tọa độ ").append(x).append(", ").append(y).toString(),
                4, 20, Graphics.TOP | Graphics.LEFT);
        g.drawString(status, 4, getHeight() - 19, Graphics.TOP | Graphics.LEFT);
    }

    private void drawPlayer(Graphics g, int x, int y) {
        int stride = direction == 0 ? 0 : ((this.x / 4) & 1) * 3;
        g.setColor(0x1d2536);
        g.fillRoundRect(x - 7, y - 21, 14, 15, 4, 4);
        g.fillRect(x - 5, y - 8, 4, 7 - stride);
        g.fillRect(x + 1, y - 8, 4, 4 + stride);
        g.fillArc(x - 8, y - 34, 16, 16, 0, 360);
        g.setColor(0xf3c199);
        g.fillRoundRect(x - 5, y - 29, 10, 8, 3, 3);
        g.setColor(0xc9d7e2);
        g.fillRect(x - 6, y - 30, 12, 3);
        g.setColor(0x283142);
        g.fillRect(x + facing * 2, y - 25, 2, 2);
        g.setColor(0xffffff);
        g.drawString(name, x, y - 36, Graphics.BOTTOM | Graphics.HCENTER);
    }
}
