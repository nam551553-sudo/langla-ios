package beatdz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.Viewport;
import java.util.Vector;

public abstract class Canvas implements Screen {

    public static float elapsed;
    public Graphics graphics;
    public OrthographicCamera camera;
    public int width;
    public int height;
    public Viewport viewport;
    private InputMultiplexer input;
    private mInputProcessor gameInput;
    public Stage stage;
    public int g = 30;
    public static Vector vTexture = new Vector();
    public static Vector vImage = new Vector();
    private boolean l = false;
    private final DisplayView display = new DisplayView(this);
    public float renderAlpha = 1f;
    public static boolean disposeGraphics = false;
    private static long m;
    private static int n;

    public Canvas() {
        try {
            this.create();
        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    public void create() {
        try {
            this.width = Gdx.graphics.getWidth();
            this.height = Gdx.graphics.getHeight();
            this.height -= MultiSession.barHeight();
            Vector2 vector2;
            int x = (int) (vector2 = new Vector2()).x;
            int y = (int) vector2.y;
            this.width -= x * 2;
            this.camera = new OrthographicCamera((float) this.width, (float) this.height);
            this.camera.setToOrtho(true, (float) this.width, (float) this.height);
            this.graphics = new Graphics(this);
            this.setZoomLevel();
            Graphics.createFont();
            this.viewport = new MyViewport(Scaling.fill, (float) (this.width * DataCenter.gI().zoomLevel / DataCenter.gI().zoomLevelScreen - this.width % DataCenter.gI().zoomLevelScreen), (float) (this.height * DataCenter.gI().zoomLevel / DataCenter.gI().zoomLevelScreen - this.height % DataCenter.gI().zoomLevelScreen), this.camera);
            ((MyViewport) this.viewport).x = x;
            ((MyViewport) this.viewport).y = y;
            this.stage = new Stage(this.viewport, this.graphics.getSpriteBatch());
            this.input = new InputMultiplexer();
            this.gameInput = new mInputProcessor(this, -x, 0);
            this.input.addProcessor(this.gameInput);
            this.input.addProcessor(this.stage);
            MultiSession.attach(this.input);
            this.viewport.update(this.width, this.height, true);
            this.applyZoomScreen();
            Gdx.input.setInputProcessor(this.input);
            Gdx.input.setCatchBackKey(true);
            Gdx.input.setCatchMenuKey(true);
        } catch (Exception var5) {
            Utlis.println(var5);
        }
    }

    public void setZoomLevel() {
        if (Gdx.app.getType() != ApplicationType.Android && Gdx.app.getType() != ApplicationType.iOS) {
            if (this.width >= 640 && this.height >= 480) {
                DataCenter.gI().zoomLevel = 2;
            } else {
                DataCenter.gI().zoomLevel = 1;
            }
        } else if (this.width >= 2560 && this.height >= 1440) {
            DataCenter.gI().zoomLevel = 6;
        } else if (this.width >= 1920 && this.height >= 1200) {
            DataCenter.gI().zoomLevel = 5;
        } else if (this.width >= 1280 && this.height >= 960) {
            DataCenter.gI().zoomLevel = 4;
        } else if (this.width >= 960 && this.height >= 720) {
            DataCenter.gI().zoomLevel = 3;
        } else if (this.width >= 640 && this.height >= 480) {
            DataCenter.gI().zoomLevel = 2;
        } else {
            DataCenter.gI().zoomLevel = 1;
        }

        if (mConfig.gI().readBoolean(15)) {
            --DataCenter.gI().zoomLevel;
        }

        DataCenter.gI().zoomLevelScreen = DataCenter.gI().zoomLevel;
        if (DataCenter.gI().zoomLevelScreen == 3 && (mConfig.gI().readByte(2) == 0 || mConfig.gI().readByte(2) == 3)) {
            DataCenter.gI().zoomLevel = 2;
        } else if ((DataCenter.gI().zoomLevelScreen == 4 || DataCenter.gI().zoomLevelScreen == 5 || DataCenter.gI().zoomLevelScreen == 6) && mConfig.gI().readByte(2) == 0) {
            DataCenter.gI().zoomLevel = 3;
        }

        if (DataCenter.gI().zoomLevel > 4) {
            DataCenter.gI().zoomLevel = 4;
        }

    }

    private float logicAccumulator;
    private long nextImageCleanupAt;


    private void render(boolean var1) {
        this.render(var1, 1);
        if (!var1) Utlis.sleep(33L);
    }

    private void render(boolean var1, int logicSteps) {
        if (var1) this.viewport.apply();
        elapsed += Gdx.graphics.getDeltaTime();
        long var2 = System.currentTimeMillis();

        int var15;
        try {
            Graphics var4;
            if (disposeGraphics) {
                disposeGraphics = false;
                var4 = this.graphics;

                try {
                    if (var4.spriteBatch != null) {
                        var4.spriteBatch.dispose();
                        var4.spriteBatch = null;
                    }

                    var4.getSpriteBatch().setProjectionMatrix(var4.canvas.camera.combined);
                    var4.shapeRenderer.dispose();
                    var4.shapeRenderer = new ShapeRenderer();
                    var4.shapeRenderer.setProjectionMatrix(var4.canvas.camera.combined);
                } catch (Exception var12) {
                    Utlis.println(var12);
                }
            }

            for (int step = 0; step < logicSteps; step++) {
                ++DataCenter.gI().i;
                ++DataCenter.gI().h;
                DataCenter.gI().aO.a = false;
                GameSrc motionGame = DataCenter.gI().currentScreen instanceof GameSrc ? (GameSrc)DataCenter.gI().currentScreen : null;
                boolean smooth = smoothMotion() && motionGame != null;
                if (smooth) motionGame.renderMotion.before(motionGame);
                this.update();
                if (smooth) motionGame.renderMotion.after(motionGame);
                MultiSession.updateHidden(this);
            }
            this.camera.update();
            if (var1) {
                if (!Graphics.m()) {
                    Gdx.gl.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
                    Gdx.gl.glClear(16384);
                    Gdx.gl.glEnable(3042);
                    Gdx.gl20.glLineWidth((float) DataCenter.gI().zoomLevel);
                    var4 = this.graphics;

                    try {
                        var4.shapeRenderer.setProjectionMatrix(var4.canvas.camera.combined);
                        var4.getSpriteBatch().setProjectionMatrix(var4.canvas.camera.combined);
                    } catch (Exception var11) {
                        Utlis.println(var11);
                    }

                    var4 = this.graphics;

                    try {
                        if (mConfig.gI().readByte(18) > 1) {
                            if (var4.spriteBatch == null) {
                                var4.dispose();
                            }
                        } else {
                            var4.getSpriteBatch().begin();
                            var4.getSpriteBatch().enableBlending();
                            var4.shapeRenderer.begin(ShapeType.Line);

                        }
                    } catch (Exception var10) {
                        Utlis.println(var10);
                    }

                    this.graphics.clean();
                    this.graphics.setClip(0, 0, DataCenter.gI().widthScreen, DataCenter.gI().heightScreen);
                    this.paint(this.graphics);
                    LangLa_gg var10000 = DataCenter.gI().aO;
                    Graphics var5 = this.graphics;
                    LangLa_gg var16 = var10000;
                    GameSrc var14;
                    if (var10000.a && GameSrc.gI().i() && !GameSrc.gI().bb && ((var14 = GameSrc.gI()).cL == null || !(var14.cL instanceof LangLa_kn))) {
                        if (DataCenter.gI().i % 6 >= 3) {
                            LangLa_fq.a(var5, 419, 0, var16.b + 1, var16.c + 1, 20);
                        } else {
                            LangLa_fq.a(var5, 419, 0, var16.b, var16.c, 20);
                        }

                        if (var16.f && beatdz.LangLa_gg.$state_LangLa_gg().e != null && var16.d <= 4) {
                            var5.a(beatdz.LangLa_gg.$state_LangLa_gg().e, 0, 0, beatdz.LangLa_gg.$state_LangLa_gg().e.c, beatdz.LangLa_gg.$state_LangLa_gg().e.d, 0, var16.b - 25, var16.c - 25, 50 * DataCenter.gI().zoomLevel, 50 * DataCenter.gI().zoomLevel, 0);
                            var5.f(0);
                            var5.d(60);
                            var5.c(0, 0, var16.b - 25, DataCenter.gI().heightScreen);
                            var5.c(var16.b + 25, 0, DataCenter.gI().widthScreen - (var16.b + 25), DataCenter.gI().heightScreen);
                            var5.c(var16.b - 25, 0, 50, var16.c - 25);
                            var5.c(var16.b - 25, var16.c + 25, 50, DataCenter.gI().heightScreen - (var16.c + 25));
                            var5.m = 1.0F;
                            var5.c();
                        }
                    }

                    try {
                        if (mConfig.gI().readByte(18) > 1) {
                            if (var4.spriteBatch == null) {
                                var4.dispose();
                            }
                        } else {
                            var4.j = false;
                            var4.getSpriteBatch().end();
                            var4 = this.graphics;

                            var4.shapeRenderer.end();
                            if (!var4.g()) {
                                var4.getSpriteBatch().flush();
                                ScissorStack.popScissors();
                            }
                        }
                    } catch (Exception var9) {
                    }
                } else {
                    Gdx.gl.glClear(16384);
                }
            }

            while (vTexture.size() > 0) {
                try {
                    ((Texture) vTexture.remove(vTexture.size() - 1)).dispose();
                } catch (Exception var8) {
                    Utlis.println("khong xoa dc textures");
                }
            }

            // Unused image TTL stays 10 seconds; sweeping 4 times/sec avoids a full cache walk on every frame.
            if (var2 >= nextImageCleanupAt) {
                nextImageCleanupAt = var2 + 250L;
            for (var15 = vImage.size() - 1; var15 >= 0; --var15) {
                try {
                    mImage var17 = (mImage) vImage.get(var15);
                    if (var2 - var17.e > 10000L) {
                        vImage.remove(var15);
                        var17.c();
                    }
                } catch (Exception var7) {
                    Utlis.println("khong xoa dc textures");
                }
            }
            }
        } catch (Exception var13) {
            Utlis.println(var13);
        }

        if (beatdz.Session.$state_Session().r > 0) {
            beatdz.Session.$state_Session().r = Math.max(0, beatdz.Session.$state_Session().r - logicSteps);
        }
    }

    public void render(float var1) {
        FrameRate.apply();
        // Scale client simulation by the selected mode, independently of dropped frames.
        this.logicAccumulator += Math.min(var1, 0.1F) * simulationSpeed();
        float logicInterval = RenderMotion.STEP;
        int logicSteps = (int) (this.logicAccumulator / logicInterval);
        this.logicAccumulator -= logicSteps * logicInterval;

        renderAlpha = smoothMotion() ? Math.max(0f, Math.min(1f, this.logicAccumulator / logicInterval)) : 1f;
        this.render(true, logicSteps);
        this.stage.act(Math.min(Gdx.graphics.getDeltaTime(), 0.033333335F));
        this.stage.draw();
        MultiSession.drawBar();
    }

    private float simulationSpeed() {
        if (isMobile()
                && DataCenter.gI().currentScreen instanceof GameSrc) {
            int map = ((GameSrc)DataCenter.gI().currentScreen).mapID;
            // These instances update many monsters at once. Keep their simulation at 30 Hz.
            if (map == 13 || map == 46 || map == 47) return 1f;
        }
        return FrameRate.target() / 60f;
    }

    public int getWidth() {
        return display.width();
    }

    public int getHeight() {
        return display.height();
    }

    public static boolean isMobile() {
        return Gdx.app.getType() == ApplicationType.Android || Gdx.app.getType() == ApplicationType.iOS;
    }
    static boolean smoothMotion() { return isMobile() || FrameRate.target() > 60; }
    public void applyZoomScreen() { display.apply(); }
    public void preparePointerInput() { display.prepareInput(); }
    public void cancelPointer() { }
    public float getPopupZoomScale(LangLa_cx popup) { return display.popupScale(popup); }
    public float getInputUiScale() { return display.inputScale(); }
    public int getFullClipWidth() { return display.clipWidth(); }
    public int getFullClipHeight() { return display.clipHeight(); }
    public void beginPopupPass(Graphics g, LangLa_cx popup) { display.begin(g, popup); }
    public void endPopupPass(Graphics g) { display.end(g); }
    public void setZoom(int level) {
        mConfig.gI().writeByte(25, Math.max(1, Math.min(4, level)));
        cancelViewMotion(); applyZoomScreen(); display.refresh();
    }
    public void activateSession() {
        cancelViewMotion(); applyZoomScreen(); display.refresh();
    }
    private void cancelViewMotion() {
        if (gameInput != null) gameInput.cancelAndroidMovement();
        cancelPointer();
        logicAccumulator = 0f; renderAlpha = 1f;
        if (DataCenter.gI().currentScreen instanceof GameSrc) ((GameSrc)DataCenter.gI().currentScreen).renderMotion.reset();
    }

    public abstract void update();

    public abstract void paint(Graphics var1);

    public abstract void a(int var1);

    public abstract void a(char var1);

    public abstract void b(int var1);

    public abstract void a(int var1, int var2);

    public abstract void b(int var1, int var2);

    public abstract void c(int var1, int var2);

    public void show() {
    }

    public void resize(int var1, int var2) {
        if (var1 <= 0 || var2 <= MultiSession.barHeight()) return;
        cancelViewMotion();
        this.width = var1;
        this.height = var2 - MultiSession.barHeight();
        applyZoomScreen();
        display.refresh();
    }

    public void pause() {
        if (gameInput != null) gameInput.cancelAndroidMovement();
        LangLa_dp var1;
        (var1 = LangLa_dp.a()).a = true;
        var1.b();
        if (GameSrc.gI().cx.size() > 0) {
            for (int var2 = GameSrc.gI().cx.size() - 1; var2 >= 0; --var2) {
                ((LangLa_en) GameSrc.gI().cx.get(var2)).d();
            }
        }

        if (Gdx.app.getType() != ApplicationType.Desktop) {
            this.l = true;
            if (Gdx.app.getType() != ApplicationType.iOS) {
                (new Thread(new LangLa_dj(this))).start();
            }
        }
    }

    public void resume() {
        this.l = false;
        cancelViewMotion();
        applyZoomScreen();
        LangLa_dp var1;
        (var1 = LangLa_dp.a()).a = false;
        var1.c = false;

        try {
            if (mConfig.gI().readBoolean(1)) {
                var1.f();
            }

            if (GameSrc.gI().cx.size() > 0) {
                for (int var3 = GameSrc.gI().cx.size() - 1; var3 >= 0; --var3) {
                    ((LangLa_en) GameSrc.gI().cx.get(var3)).a();
                }
            }

        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    public void hide() {
    }

    public void dispose() {
        LangLa_dp var1;
        (var1 = LangLa_dp.a()).d();
        var1.e();
    }

    static boolean a(Canvas var0) {
        return var0.l;
    }

    static void a(Canvas var0, boolean var1) {
        var0.render(false);
    }
}
