package com.langla.j2me;

import java.io.IOException;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

final class LoginCanvas extends Canvas {
    private final ConnectionMidlet app;
    private final Image background = image("/login/background.png");
    private final Image logo = image("/login/logo.png");
    private int focus;

    LoginCanvas(ConnectionMidlet app) {
        this.app = app;
        setFullScreenMode(true);
    }

    private static Image image(String path) {
        try { return Image.createImage(path); }
        catch (IOException missing) { return null; }
    }

    private int step() { return Math.min(38, Math.max(21, (getHeight() - 78) / 6)); }
    private int top() { return Math.max(40, (getHeight() - 6 * step()) / 2 + 10); }

    protected void paint(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        g.setColor(0x372019);
        g.fillRect(0, 0, width, height);
        if (background != null) g.drawImage(background, width / 2, height / 2, Graphics.HCENTER | Graphics.VCENTER);
        if (logo != null) g.drawImage(logo, width / 2, top() - 7, Graphics.HCENTER | Graphics.BOTTOM);
        g.setFont(Font.getFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
        String[] rows = app.loginRows();
        int left = Math.max(8, (width - 260) / 2);
        for (int i = 0; i < rows.length; i++) {
            int y = top() + i * step();
            int rowWidth = width - left * 2;
            g.setColor(i == 4 ? 0x8e400f : 0xa75616);
            g.fillRoundRect(left, y, rowWidth, step() - 3, 7, 7);
            g.setColor(i == focus ? 0xffedaa : 0xcda360);
            g.drawRoundRect(left, y, rowWidth, step() - 3, 7, 7);
            g.setColor(0xffffff);
            g.drawString(rows[i], width / 2, y + 3, Graphics.TOP | Graphics.HCENTER);
        }
        g.setColor(0x44230f);
        g.fillRect(0, height - 18, width, 18);
        g.setColor(0xffffff);
        g.drawString(app.loginStatus(), width / 2, height - 16, Graphics.TOP | Graphics.HCENTER);
    }

    protected void pointerReleased(int x, int y) {
        if (y >= top() && y < top() + 6 * step()) {
            focus = (y - top()) / step();
            repaint();
            app.loginAction(focus);
        }
    }

    protected void keyPressed(int key) {
        int action = getGameAction(key);
        if (action == UP) focus = (focus + 5) % 6;
        if (action == DOWN) focus = (focus + 1) % 6;
        if (action == FIRE) app.loginAction(focus);
        repaint();
    }
}
