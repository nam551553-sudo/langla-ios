package beatdz;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import java.util.WeakHashMap;

/** Reference zoom geometry, adapted to the shared x6 canvas and its reserved tab bar. */
final class DisplayView {
    private final Canvas canvas;
    private final OrthographicCamera popupCamera = new OrthographicCamera();
    private final WeakHashMap<LangLa_cx, Layout> layouts = new WeakHashMap<LangLa_cx, Layout>();
    private float scale = 1f;
    private float passScale = 1f;
    private boolean popupPass;

    DisplayView(Canvas canvas) { this.canvas = canvas; }

    int level() {
        int level = mConfig.gI().readByte(25);
        return level >= 1 && level <= 4 ? level : 2;
    }
    float scale() { return scale; }
    int clipWidth() { return popupPass ? DisplayZoom.logicalExtent(canvas.width, DataCenter.gI().zoomLevelScreen, passScale) : width(); }
    int clipHeight() { return popupPass ? DisplayZoom.logicalExtent(canvas.height, DataCenter.gI().zoomLevelScreen, passScale) : height(); }
    int width() { return DisplayZoom.logicalExtent(canvas.width, DataCenter.gI().zoomLevelScreen, DisplayZoom.levelScale(level())); }
    int height() { return DisplayZoom.logicalExtent(canvas.height, DataCenter.gI().zoomLevelScreen, DisplayZoom.levelScale(level())); }

    void apply() {
        if (canvas.viewport == null || canvas.camera == null) return;
        DataCenter data = DataCenter.gI();
        scale = DisplayZoom.levelScale(level());
        float ratio = data.zoomLevel / (float)Math.max(1, data.zoomLevelScreen);
        canvas.viewport.setCamera(canvas.camera);
        canvas.viewport.setWorldSize(canvas.width * ratio, canvas.height * ratio);
        canvas.viewport.update(canvas.width, canvas.height, true);
        camera(canvas.camera, scale);
        data.widthScreen = width(); data.heightScreen = height();
        // The login/selection background keeps its aspect ratio after zoom or resize.
        float cover = Math.max(data.widthScreen / 640f, data.heightScreen / 360f);
        data.q = Math.round(640f * cover * data.zoomLevel);
        data.r = Math.round(360f * cover * data.zoomLevel);
        layouts.clear();
    }

    private void camera(OrthographicCamera target, float factor) {
        float w = canvas.viewport.getWorldWidth(), h = canvas.viewport.getWorldHeight();
        target.setToOrtho(true, w, h);
        target.zoom = 1f / factor;
        target.position.set(w / (2f * factor), h / (2f * factor), 0);
        target.update();
    }

    float popupScale(LangLa_cx popup) {
        if (popup == null || popup instanceof MainScreen) return scale;
        if (popup instanceof LangLa_x) return Math.min(scale, Math.min(
                canvas.width / (float)(Math.max(1, DataCenter.gI().zoomLevelScreen) * Math.max(1, popup.width)),
                canvas.height / (float)(Math.max(1, DataCenter.gI().zoomLevelScreen) * Math.max(1, popup.height))));
        return DisplayZoom.fitPopupScale(scale, canvas.width, canvas.height,
                DataCenter.gI().zoomLevelScreen, popup.width, popup.height);
    }

    float inputScale() {
        MainScreen screen = DataCenter.gI().currentScreen;
        return screen == null || screen.cE == null ? scale : popupScale(screen.cE);
    }

    void prepareInput() {
        MainScreen screen = DataCenter.gI().currentScreen;
        if (screen != null && screen.cE != null) {
            center(screen.cE, popupScale(screen.cE));
            screen.cE.M();
        }
    }

    void refresh() {
        MainScreen screen = DataCenter.gI().currentScreen;
        if (screen == null) return;
        if (screen instanceof GameSrc) ((GameSrc)screen).onZoomChanged();
        else if (screen instanceof LoginPCScreen) ((LoginPCScreen)screen).onViewChanged(width(), height());
        else screen.setSize(width(), height());
        for (Object value : screen.cD) {
            LangLa_cx popup = (LangLa_cx)value;
            if (popup instanceof SettingsTab) ((SettingsTab)popup).synchronizeZoomSelection();
            if (popup instanceof LangLa_fl) center(popup, popupScale(popup));
        }
        screen.M();
    }

    private void center(LangLa_cx popup, float factor) {
        if (!(popup instanceof LangLa_fl) || popup instanceof LangLa_x || popup.cM != null) return;
        Layout previous = layouts.get(popup);
        if (previous != null && previous.matches(canvas, popup, factor)) return;
        int zl = DataCenter.gI().zoomLevelScreen;
        popup.setXY((DisplayZoom.logicalExtent(canvas.width, zl, factor) - popup.width) / 2,
                (DisplayZoom.logicalExtent(canvas.height, zl, factor) - popup.height) / 2);
        popup.M(); layouts.put(popup, new Layout(canvas, popup, factor));
    }

    void begin(Graphics g, LangLa_cx popup) {
        if (canvas.viewport == null) return;
        float factor = popupScale(popup);
        center(popup, factor);
        if (Math.abs(factor - scale) < .0001f) return;
        popupPass = true; passScale = factor;
        camera(popupCamera, factor);
        project(g, popupCamera);
        g.setClip(-g.a, -g.b, DisplayZoom.logicalExtent(canvas.width, DataCenter.gI().zoomLevelScreen, factor),
                DisplayZoom.logicalExtent(canvas.height, DataCenter.gI().zoomLevelScreen, factor));
    }

    void end(Graphics g) {
        if (!popupPass) return;
        popupPass = false;
        project(g, canvas.camera);
        g.setClip(-g.a, -g.b, width(), height());
    }

    private static final class Layout {
        final int width, height, popupWidth, popupHeight;
        final float scale;
        Layout(Canvas canvas, LangLa_cx popup, float scale) {
            width = canvas.width; height = canvas.height; popupWidth = popup.width; popupHeight = popup.height; this.scale = scale;
        }
        boolean matches(Canvas canvas, LangLa_cx popup, float scale) {
            return width == canvas.width && height == canvas.height && popupWidth == popup.width && popupHeight == popup.height && this.scale == scale;
        }
    }

    private void project(Graphics g, OrthographicCamera camera) {
        canvas.viewport.setCamera(camera);
        if (g.spriteBatch != null) g.spriteBatch.setProjectionMatrix(camera.combined);
        if (g.shapeRenderer != null) {
            ShapeRenderer.ShapeType type = g.shapeRenderer.isDrawing() ? g.shapeRenderer.getCurrentType() : null;
            if (type != null) g.shapeRenderer.end();
            g.shapeRenderer.setProjectionMatrix(camera.combined);
            if (type != null) g.shapeRenderer.begin(type);
        }
    }
}
