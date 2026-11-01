package beatdz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.GlyphLayout.GlyphRun;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import com.boot.GameM;
import com.tgame.model.Caption;
import java.util.Hashtable;
import java.util.Vector;

public class Graphics {

    public int a = 0;
    public int b = 0;
    // Fractional world motion stays out of legacy integer UI and collision coordinates.
    float motionX, motionY;
    private float motionX() { return motionX * DataCenter.gI().zoomLevel; }
    private float motionY() { return motionY * DataCenter.gI().zoomLevel; }
    public Rectangle c = new Rectangle();
    Rectangle d;
    public SpriteBatch spriteBatch;
    public ShapeRenderer shapeRenderer;
    public Canvas canvas;
    private int r;
    private int s;
    private int t;
    private int u;
    public int h;
    public int i;
    public boolean j;
    private boolean clipPushed;
    public boolean k;
    public boolean l;
    private boolean v = true;
    private int w;
    private Color x;
    public float m;
    private static Hashtable y = new Hashtable();
    private static boolean z = false;
    public static int n = -1;
    private static GlyphLayout A = new GlyphLayout();
    private static Vector B = new Vector();
    private static Vector C = new Vector();
    public static Hashtable o = new Hashtable();
    private static BitmapFont D;
    private static BitmapFont E;
    private static BitmapFont F;
    private static BitmapFont G;
    private static BitmapFont H;
    public static String p = " 0123456789+-*='\"\\/_?.,~:;|<>[]{}!@#$%^&()aáàảãạâấầẩẫậăắằẳẵặbcdđeéèẻẽẹêếềểễệfghiíìỉĩịjklmnoóòỏõọôốồổỗộơớờởỡợpqrstuúùủũụưứừửữựvxyýỳỷỹỵzwAÁÀẢÃẠÂẤẦẨẪẬĂẮẰẲẴẶBCDĐEÉÈẺẼẸÊẾỀỂỄỆFGHIÍÌỈĨỊJKLMNOÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢPQRSTUÚÙỦŨỤƯỨỪỬỮỰVXYÝỲỶỸỴZW";
    public static boolean q;

    public Graphics(Canvas var1) {
        this.x = Color.CLEAR;
        this.m = 1.0F;

        try {
            this.canvas = var1;
            this.getSpriteBatch();
            this.shapeRenderer = new ShapeRenderer();
        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    public static BitmapFont a(int var0) {
        BitmapFont var1 = E;
        switch (var0) {
            case 0:
                return c(var1);
            case 1:
                return d(var1);
            case 2:
                return n();
            case 3:
                return p();
            case 4:
                return o();
            case 5:
                return a(var1);
            case 6:
                return b(var1);
            default:
                return c(var1);
        }
    }

    public static BitmapFont b(int var0) {
        switch (DataCenter.gI().zoomLevel) {
            case 1:
                a(E, (float) var0 / 100.0F, (float) var0 / 100.0F);
                break;
            case 2:
                a(E, (float) var0 / 100.0F, (float) var0 / 100.0F);
                break;
            case 3:
                a(E, (float) var0 / 100.0F, (float) var0 / 100.0F);
                break;
            case 4:
                a(E, (float) var0 / 100.0F, (float) var0 / 100.0F);
        }

        return E;
    }

    private static BitmapFont a(BitmapFont var0) {
        switch (DataCenter.gI().zoomLevel) {
            case 1:
                a(var0, 0.84F, 0.84F);
                break;
            case 2:
                a(var0, 0.84F, 0.84F);
                break;
            case 3:
                a(var0, 0.84F, 0.84F);
                break;
            case 4:
                a(var0, 0.84F, 0.84F);
        }

        return var0;
    }

    private static BitmapFont b(BitmapFont var0) {
        switch (DataCenter.gI().zoomLevel) {
            case 1:
                a(var0, 0.94F, 0.94F);
                break;
            case 2:
                a(var0, 0.94F, 0.94F);
                break;
            case 3:
                a(var0, 0.94F, 0.94F);
                break;
            case 4:
                a(var0, 0.94F, 0.94F);
        }

        return var0;
    }

    private static BitmapFont c(BitmapFont var0) {
        switch (DataCenter.gI().zoomLevel) {
            case 1:
                a(var0, 0.96F, 0.96F);
                break;
            case 2:
                a(var0, 0.96F, 0.96F);
                break;
            case 3:
                a(var0, 0.96F, 0.96F);
                break;
            case 4:
                a(var0, 0.96F, 0.96F);
        }

        return var0;
    }

    private static void a(BitmapFont var0, float var1, float var2) {
        if (DataCenter.gI().zoomLevel == 1) {
            var0.getData().setScale(1.0F, 1.0F);
        } else {
            var0.getData().setScale(var1, var2);
        }
    }

    private static BitmapFont d(BitmapFont var0) {
        switch (DataCenter.gI().zoomLevel) {
            case 1:
                a(var0, 1.06F, 1.06F);
                break;
            case 2:
                a(var0, 1.06F, 1.06F);
                break;
            case 3:
                a(var0, 1.06F, 1.06F);
                break;
            case 4:
                a(var0, 1.06F, 1.06F);
        }

        return var0;
    }

    private static BitmapFont n() {
        switch (DataCenter.gI().zoomLevel) {
            case 1:
                F.getData().setScale(0.25F, 0.25F);
                break;
            case 2:
                F.getData().setScale(0.5F, 0.5F);
                break;
            case 3:
                F.getData().setScale(0.75F, 0.75F);
                break;
            case 4:
                F.getData().setScale(1.0F, 1.0F);
        }

        return F;
    }

    public static BitmapFont a(float var0) {
        F.getData().setScale(var0 * (float) DataCenter.gI().zoomLevel / 100.0F, var0 * (float) DataCenter.gI().zoomLevel / 100.0F);
        return F;
    }

    private static BitmapFont o() {
        switch (DataCenter.gI().zoomLevel) {
            case 1:
                G.getData().setScale(0.25F, 0.25F);
                break;
            case 2:
                G.getData().setScale(0.5F, 0.5F);
                break;
            case 3:
                G.getData().setScale(0.75F, 0.75F);
                break;
            case 4:
                G.getData().setScale(1.0F, 1.0F);
        }

        return G;
    }

    public static BitmapFont b(float var0) {
        G.getData().setScale(var0 * (float) DataCenter.gI().zoomLevel / 100.0F, var0 * (float) DataCenter.gI().zoomLevel / 100.0F);
        return G;
    }

    private static BitmapFont p() {
        switch (DataCenter.gI().zoomLevel) {
            case 1:
                H.getData().setScale(0.25F, 0.23F);
                break;
            case 2:
                H.getData().setScale(0.5F, 0.46F);
                break;
            case 3:
                H.getData().setScale(0.75F, 0.69F);
                break;
            case 4:
                H.getData().setScale(1.0F, 0.92F);
        }

        return H;
    }

    public static BitmapFont c(float var0) {
        H.getData().setScale(var0 * (float) DataCenter.gI().zoomLevel / 100.0F, var0 * (float) DataCenter.gI().zoomLevel / 100.0F);
        return H;
    }

    public static int a(int var0, String var1) {
        try {
            BitmapFont var2 = D;
            BitmapFont var10001;
            switch (var0) {
                case 0:
                    var10001 = c(var2);
                    break;
                case 1:
                    var10001 = d(var2);
                    break;
                case 2:
                    var10001 = n();
                    break;
                case 3:
                    var10001 = p();
                    break;
                case 4:
                    var10001 = o();
                    break;
                case 5:
                    var10001 = a(var2);
                    break;
                case 6:
                    var10001 = b(var2);
                    break;
                default:
                    var10001 = c(var2);
            }

            return (int) a(var0, var10001, var1).width;
        } catch (Exception var3) {
            return 0;
        }
    }

    public static int b(int var0, String var1) {
        try {
            return (int) a(var0, a(var0), var1).height;
        } catch (Exception var2) {
            return 0;
        }
    }

    private static String a(String var0) {
        String var1 = "";

        for (int var2 = 0; var2 < var0.length(); ++var2) {
            if (p.indexOf(var0.charAt(var2)) >= 0) {
                var1 = var1 + var0.charAt(var2);
            }
        }

        if (o.size() > 5000) {
            o.clear();
        }

        o.put(var0, var1);
        return var1;
    }

    public static GlyphLayout a(int var0, BitmapFont var1, String var2) {
        return a(var0, var1, var2, (Vector) B.get(var0));
    }

    private static GlyphLayout a(int var0, BitmapFont var1, String var2, Vector var3) {
        String var7;
        if ((var7 = (String) o.get(var2)) != null) {
            var2 = var7;
        }

        if (var2.length() == 0) {
            return A;
        } else {
            while (true) {
                GlyphLayout var4 = null;

                try {
                    if (var3.size() == 0) {
                        var4 = new GlyphLayout();
                    } else {
                        (var4 = (GlyphLayout) var3.remove(0)).reset();
                    }

                    var4.setText(var1, var2);
                    String var5;
                    if ((var5 = ((GlyphRun) var4.runs.get(0)).toString()).length() > var2.length()) {
                        if (var5.substring(0, var2.length()).equals(var2)) {
                            var3.add(var4);

                            for (int var8 = var3.size(); var8 < 5; ++var8) {
                                var3.add(new GlyphLayout());
                            }

                            return var4;
                        }

                        if (var7 == null && (var2 = a(var2)).length() == 0) {
                            return A;
                        }
                    }
                } catch (Exception var6) {
                    if (var7 == null && (var2 = a(var2)).length() == 0) {
                        return A;
                    }
                }

                if (var4 != null) {
                    var4.reset();
                }
            }
        }
    }

    public SpriteBatch getSpriteBatch() {
        try {
            if (this.spriteBatch == null && DataCenter.gI().b()) {
                this.spriteBatch = new SpriteBatch();
            }
        } catch (Exception var2) {
            Utlis.println(var2);
        }

        return this.spriteBatch;
    }

    private static void a(Vector var0) {
        int var1;
        for (var1 = 0; var1 < var0.size(); ++var1) {
            for (int var2 = 0; var2 < ((Vector) var0.get(var1)).size(); ++var2) {
                ((GlyphLayout) ((Vector) var0.get(var1)).get(var2)).reset();
            }
        }

        var0.clear();

        for (var1 = 0; var1 < 7; ++var1) {
            Vector var4 = new Vector();

            for (int var3 = 0; var3 < 5; ++var3) {
                var4.add(new GlyphLayout());
            }

            var0.add(var4);
        }

    }

    public static void createFont() {
        if (n != DataCenter.gI().zoomLevel) {
            try {
                if (E != null) {
                    E.dispose();
                }
            } catch (Exception var5) {
            }

            try {
                if (F != null) {
                    F.dispose();
                }
            } catch (Exception var4) {
            }

            try {
                if (H != null) {
                    H.dispose();
                }
            } catch (Exception var3) {
            }

            try {
                if (G != null) {
                    G.dispose();
                }
            } catch (Exception var2) {
            }

            G = null;
            H = null;
            E = null;
        }

        Gdx.app.postRunnable(new Runnable() {
            @Override
            public void run() {
                if (E == null || F == null || H == null || G == null) {
                    a(B);
                    a(C);
                    n = DataCenter.gI().zoomLevel;
                    FreeTypeFontParameter var0;
                    (var0 = new FreeTypeFontParameter()).characters = p;
                    var0.flip = true;
                    var0.borderColor = Utlis.createColor(-10275328L);
                    float var1 = (float) DataCenter.gI().zoomLevel / 2.0F;
                    var0.borderWidth = var1 < 1.0F ? 1.0F : var1;
                    var0.spaceX = 0;
                    var0.color = Color.WHITE;
                    var0.borderColor = Utlis.createColor(-14013910L);
                    var0.size = 7 * DataCenter.gI().zoomLevel;
                    FreeTypeFontGenerator var7;
                    if (DataCenter.gI().zoomLevel == 1) {
                        var7 = new FreeTypeFontGenerator(Utlis.internal("font6.ttf"));
                        var0.size = 9;
                    } else {
                        var7 = new FreeTypeFontGenerator(Utlis.internal("font3.ttf"));
                        var0.size = DataCenter.gI().zoomLevel * 10;
                    }

                    E = var7.generateFont(var0);
                    if (D == null) {
                        D = var7.generateFont(var0);
                    }

                    var7.dispose();
                    F = new BitmapFont(Utlis.internal("font8.fnt"), true);
                    G = new BitmapFont(Utlis.internal("font9.fnt"), true);
                    H = new BitmapFont(Utlis.internal("font9b.fnt"), true);

                    for (int var6 = 0; var6 < mFont.i.length; ++var6) {
                        mFont.i[var6].b();
                    }
                }
            }
        });

    }

    public void c(int var1) {
        this.x = Utlis.createColor((long) var1);
    }

    public void c() {
        try {
            this.x = Color.CLEAR;
            this.getSpriteBatch().setColor(Color.WHITE);
        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    public void d(int var1) {
        if (var1 > 100) {
            this.m = 1.0F;
        } else {
            this.m = (float) var1 / 100.0F;
        }
    }

    public void e(int var1) {
        try {
            if (!DataCenter.gI().b()) {
                LangLa_cq var10000 = (LangLa_cq) this.getSpriteBatch();
                boolean var10001 = true;
                throw null;
            } else {
                this.c(-6645094);
            }
        } catch (Exception var2) {
        }
    }

    public void d() {
        try {
            if (!DataCenter.gI().b()) {
                LangLa_cq var10000 = (LangLa_cq) this.getSpriteBatch();
                throw null;
            } else {
                this.c();
            }
        } catch (Exception var1) {
        }
    }

    public static int e() {
        return Gdx.graphics.getWidth();
    }

    public static int f() {
        return Gdx.graphics.getHeight();
    }

    public boolean g() {
        if (m()) {
            return true;
        } else {
            return this.h == 0 || this.i == 0;
        }
    }

    private void q() {
        try {
            if (mConfig.gI().readByte(18) > 1) {
                if (this.spriteBatch == null) {
                    this.dispose();
                }

            } else {
                if (this.getSpriteBatch().isDrawing()) this.getSpriteBatch().flush();
                this.canvas.viewport.calculateScissors(this.getSpriteBatch().getTransformMatrix(), this.d, this.c);
                this.clipPushed = ScissorStack.pushScissors(this.c);
            }
        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    private void r() {
        try {
            if (mConfig.gI().readByte(18) > 1) {
                if (this.spriteBatch == null) {
                    this.dispose();
                }

            } else if (this.clipPushed) {
                if (this.getSpriteBatch().isDrawing()) this.getSpriteBatch().flush();
                ScissorStack.popScissors();
                this.clipPushed = false;
            }
        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    public void a(int var1, int var2, int var3, int var4) {
        try {
            if (mConfig.gI().readByte(18) > 1) {
                if (this.spriteBatch == null) {
                    this.dispose();
                }

            } else {
                this.v = false;
                if (!this.g()) {
                    mImage var5 = g(this.w);
                    if (var1 == var3) {
                        this.a(var5, 0, 0, 1, 1, 0, var1, var2, DataCenter.gI().zoomLevel, (var4 - var2) * DataCenter.gI().zoomLevel, 0);
                    } else {
                        this.a(var5, 0, 0, 1, 1, 0, var1, var2, (var3 - var1) * DataCenter.gI().zoomLevel, DataCenter.gI().zoomLevel, 0);
                    }

                    this.v = true;
                }
            }
        } catch (Exception var6) {
        }
    }

    private static mImage g(int var0) {
        mImage var1 = null;

        try {
            if ((var1 = (mImage) y.get(var0)) == null) {
                Pixmap var2;
                (var2 = (var1 = Binary.createImage(1, 1)).b).setColor(Utlis.createColor((long) var0));
                var2.fill();
                var1.d();
                y.put(var0, var1);
            }
        } catch (Exception var3) {
        }

        return var1;
    }

    public void a(Graphics var1, int var2, int var3, int var4, int var5, int var6, int var7) {
        if (mConfig.gI().readByte(18) > 1) {
            if (this.spriteBatch == null) {
                this.dispose();
            }

        } else {
            this.v = false;
            int var8 = var2;
            var2 = -1;
            switch (var8) {
                case -23:
                    var2 = -1427649639;
                    break;
                case -22:
                    var2 = -1278446549;
                    break;
                case -21:
                    var2 = -851931;
                    break;
                case -20:
                    var2 = -11456235;
                    break;
                case -19:
                    var2 = -6200792;
                    break;
                case -18:
                    var2 = -429507045;
                    break;
                case -17:
                    var2 = -3640790;
                    break;
                case -16:
                    var2 = -10076645;
                    break;
                case -15:
                    var2 = -7978471;
                    break;
                case -14:
                    var2 = -4824797;
                    break;
                case -13:
                    var2 = 1525140377;
                    break;
                case -12:
                    var2 = -1;
                    break;
                case -11:
                case 80:
                    var2 = -7978471;
                    break;
                case -10:
                    var2 = -518501300;
                    break;
                case -9:
                    var2 = -16762824;
                    break;
                case -8:
                    var2 = -15323092;
                    break;
                case -7:
                case -5:
                    var2 = 1677721600;
                    break;
                case -6:
                    var2 = -1290201339;
                    break;
                case -4:
                    var2 = -868916617;
                    break;
                case -3:
                    var2 = -934343646;
                    break;
                case -2:
                    var2 = -1290123955;
                    break;
                case -1:
                    var2 = 0;
                case 0:
                case 1:
                case 2:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                case 69:
                case 70:
                case 71:
                case 72:
                case 73:
                case 74:
                case 75:
                case 76:
                case 77:
                case 78:
                case 79:
                default:
                    break;
                case 3:
                    var2 = -1586279;
                    break;
                case 4:
                    var2 = -7978471;
                    break;
                case 24:
                    var2 = -868019200;
            }

            mImage var9 = g(var2);
            this.a(var9, 0, 0, 1, 1, 0, var4, var5, var6, var7, 0);
            this.v = true;
        }
    }

    public void b(int var1, int var2, int var3, int var4) {
        if (mConfig.gI().readByte(18) > 1) {
            if (this.spriteBatch == null) {
                this.dispose();
            }

        } else if (!this.g() && var3 != 0 && var4 != 0) {
            this.v = false;
            int var5 = var3;
            int var6 = var4;
            var3 *= DataCenter.gI().zoomLevel;
            var4 *= DataCenter.gI().zoomLevel;
            mImage var7 = g(this.w);
            this.a(var7, 0, 0, 1, 1, 0, var1, var2, var3, DataCenter.gI().zoomLevel, 0);
            this.a(var7, 0, 0, 1, 1, 0, var1, var2, DataCenter.gI().zoomLevel, var4, 0);
            this.a(var7, 0, 0, 1, 1, 0, var1, var2 + var6, var3 + DataCenter.gI().zoomLevel, DataCenter.gI().zoomLevel, 0);
            this.a(var7, 0, 0, 1, 1, 0, var1 + var5, var2, DataCenter.gI().zoomLevel, var4 + DataCenter.gI().zoomLevel, 0);
            this.v = true;
        }
    }

    public void c(int var1, int var2, int var3, int var4) {
        if (mConfig.gI().readByte(18) > 1) {
            if (this.spriteBatch == null) {
                this.dispose();
            }

        } else if (!this.g() && var3 != 0 && var4 != 0) {
            try {
                this.v = false;
                var3 *= DataCenter.gI().zoomLevel;
                var4 *= DataCenter.gI().zoomLevel;
                mImage var5 = g(this.w);
                this.a(var5, 0, 0, 1, 1, 0, var1, var2, var3, var4, 0);
                this.v = true;
            } catch (Exception var6) {
                Utlis.println(var6);
            }
        }
    }

    public void a(mImage var1, int var2, int var3) {
        if (var1 != null) {
            this.a(var1, 0, 0, var1.c, var1.d, 0, var2, var3, 0);
        }
    }

    public void a(mImage var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
        this.a(var1, var2, var3, var4, var5, var6, var7, var8, var4, var5, var9);
    }

    public void a(mImage var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
        if (mConfig.gI().readByte(18) > 1) {
            if (this.spriteBatch == null) {
                this.dispose();
            }

        } else {
            try {
                if (var1 == null || var1.c == 1 && var1.d == 1 && !y.contains(var1) || this.g()) {
                    return;
                }

                var6 = var6 / 5 * 5;
                var7 += this.a;
                var8 += this.b;
                var7 *= DataCenter.gI().zoomLevel;
                var8 *= DataCenter.gI().zoomLevel;
                if (var4 > 1 && var5 > 1) {
                    var2 *= DataCenter.gI().zoomLevel;
                    var3 *= DataCenter.gI().zoomLevel;
                }

                if ((var11 & 2) != 0) {
                    if (this.k || var6 != 90 && var6 != 270 && var6 != -270 && var6 != -90) {
                        var8 -= var10 / 2;
                    } else {
                        var8 -= var9 / 2;
                    }
                } else if ((var11 & 32) != 0) {
                    if (this.k || var6 != 90 && var6 != 270 && var6 != -270 && var6 != -90) {
                        var8 -= var10;
                    } else {
                        var8 -= var9;
                    }
                }

                if ((var11 & 8) != 0) {
                    if (this.k || var6 != 90 && var6 != 270 && var6 != -270 && var6 != -90) {
                        var7 -= var9;
                    } else {
                        var7 -= var10;
                    }
                } else if ((var11 & 1) != 0) {
                    if (this.k || var6 != 90 && var6 != 270 && var6 != -270 && var6 != -90) {
                        var7 -= var9 / 2;
                    } else {
                        var7 -= var10 / 2;
                    }
                }

                var9 = var9 == 0 ? var4 : var9;
                var10 = var10 == 0 ? var5 : var10;
                Texture var16;
                if ((var16 = var1.b()) == null) {
                    return;
                }

                Color var15;
                TextureFilter var10001;
                if (this.k) {
                    if (var16 != null) {
                        var15 = this.getSpriteBatch().getColor();
                        this.getSpriteBatch().setColor(var15.r, var15.g, var15.b, this.m);
                        if (!this.x.equals(Color.CLEAR)) {
                            this.getSpriteBatch().setColor(this.x.r, this.x.g, this.x.b, this.x.a);
                        }

                        if (this.v) {
                            var10001 = TextureFilter.Linear;
                            ImageSampling.configure(var16);
                        }

                        this.getSpriteBatch().draw(var16, (float) var7 + motionX(), (float) var8 + motionY(), (float) (var9 / 2), (float) (var10 / 2), (float) var9, (float) var10, 1.0F, 1.0F, (float) var6, var2, var3, var4, var5, var6 < 0, true);
                    }

                    return;
                }

                if (var6 != 180 && var6 != -180) {
                    if (var6 == 270) {
                        var8 += var9;
                    } else {
                        int var14;
                        if (var6 == -90) {
                            if (var1.c == this.h(var9) && var1.d == this.h(var10)) {
                                var8 += var9;
                            } else {
                                var14 = var9;
                                var9 = var10;
                                var10 = var14;
                                var8 += var9;
                            }
                        } else if (var6 == 90) {
                            if (var1.c == this.h(var9) && var1.d == this.h(var10)) {
                                var7 += var10;
                            } else {
                                var14 = var9;
                                var9 = var10;
                                var10 = var14;
                                var7 += var14;
                            }
                        } else if (var6 == -270) {
                            if (var1.c == this.h(var9) && var1.d == this.h(var10)) {
                                var7 += var10;
                            } else {
                                var14 = var9;
                                var9 = var10;
                                var10 = var14;
                                var7 += var14;
                            }
                        }
                    }
                } else {
                    var7 += var9;
                    var8 += var10;
                }

                var15 = this.getSpriteBatch().getColor();
                this.getSpriteBatch().setColor(var15.r, var15.g, var15.b, this.m);
                if (!this.x.equals(Color.CLEAR)) {
                    this.getSpriteBatch().setColor(this.x.r, this.x.g, this.x.b, this.x.a);
                }

                if (var16 != null) {
                    if (this.v) {
                        var10001 = TextureFilter.Linear;
                        ImageSampling.configure(var16);
                    }

                    this.getSpriteBatch().draw(var16, (float) var7 + motionX(), (float) var8 + motionY(), 0.0F, 0.0F, (float) var9, (float) var10, 1.0F, 1.0F, (float) var6, var2, var3, var4, var5, var6 < 0, true);
                }
            } catch (Exception var13) {
                Utlis.println(var13);
            }

        }
    }

    public void b(mImage var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
        if (mConfig.gI().readByte(18) > 1) {
            if (this.spriteBatch == null) {
                this.dispose();
            }

        } else {
            try {
                if (var1 != null && !this.g()) {
                    var6 = var6 / 5 * 5;
                    var7 += this.a;
                    var8 += this.b;
                    var7 *= DataCenter.gI().zoomLevel;
                    var8 *= DataCenter.gI().zoomLevel;
                    if (var4 > 1 && var5 > 1) {
                        var2 = 0 * DataCenter.gI().zoomLevel;
                        var3 *= DataCenter.gI().zoomLevel;
                    }

                    if ((var11 & 2) != 0) {
                        if (this.k || var6 != 90 && var6 != 270 && var6 != -270 && var6 != -90) {
                            var8 -= var10 / 2;
                        } else {
                            var8 -= var9 / 2;
                        }
                    } else if ((var11 & 32) != 0) {
                        if (this.k || var6 != 90 && var6 != 270 && var6 != -270 && var6 != -90) {
                            var8 -= var10;
                        } else {
                            var8 -= var9;
                        }
                    }

                    if ((var11 & 8) != 0) {
                        if (this.k || var6 != 90 && var6 != 270 && var6 != -270 && var6 != -90) {
                            var7 -= var9;
                        } else {
                            var7 -= var10;
                        }
                    } else if ((var11 & 1) != 0) {
                        if (this.k || var6 != 90 && var6 != 270 && var6 != -270 && var6 != -90) {
                            var7 -= var9 / 2;
                        } else {
                            var7 -= var10 / 2;
                        }
                    }

                    var9 = var9 == 0 ? var4 : var9;
                    var10 = var10 == 0 ? var5 : var10;
                    Texture var13;
                    if ((var13 = var1.b()) != null) {
                        Color var14 = this.getSpriteBatch().getColor();
                        this.getSpriteBatch().setColor(var14.r, var14.g, var14.b, this.m);
                        if (!this.x.equals(Color.CLEAR)) {
                            this.getSpriteBatch().setColor(this.x.r, this.x.g, this.x.b, this.x.a);
                        }

                        TextureFilter var10001 = TextureFilter.Linear;
                        ImageSampling.configure(var13);
                        this.getSpriteBatch().draw(var13, (float) var7 + motionX(), (float) var8 + motionY(), (float) (var9 / 2), (float) (var10 / 2), (float) var9, (float) var10, 1.0F, 1.0F, (float) (180 + var6), var2, var3, var4, var5, false, false);
                    }

                }
            } catch (Exception var12) {
                Utlis.println(var12);
            }
        }
    }

    private int h(int var1) {
        return this.l ? var1 : (int) ((float) var1 * (1.0F / DataCenter.gI().z));
    }

    public void b(mImage var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
        try {
            if (mConfig.gI().readByte(18) > 1) {
                if (this.spriteBatch == null) {
                    this.dispose();
                }

            } else if (var1 != null && !this.g()) {
                var7 += this.a * DataCenter.gI().zoomLevel;
                var8 = 0 + this.b * DataCenter.gI().zoomLevel - var5 / 2;
                Color var12 = this.getSpriteBatch().getColor();
                this.getSpriteBatch().setColor(var12.r, var12.g, var12.b, this.m);
                if (!this.x.equals(Color.CLEAR)) {
                    this.getSpriteBatch().setColor(this.x.r, this.x.g, this.x.b, this.x.a);
                }

                Texture var11;
                if ((var11 = var1.b()) != null) {
                    TextureFilter var10001 = TextureFilter.Linear;
                    ImageSampling.configure(var11);
                    this.getSpriteBatch().draw(var11, (float) var7 + motionX(), (float) var8 + motionY(), 0.0F, 0.0F, (float) var4, (float) var5, 1.0F, 1.0F, 0.0F, 0, 0, var4, var5, false, true);
                }

            }
        } catch (Exception var10) {
            Utlis.println(var10);
        }
    }

    public void a(int var1, BitmapFont var2, String var3, int var4, int var5, int var6, int var7, float var8) {
        var3 = Caption.check(var3);

        try {
            if (mConfig.gI().readByte(18) > 1) {
                if (this.spriteBatch == null) {
                    this.dispose();
                }

            } else if (!this.g()) {
                if (var3 == null) {
                    var3 = "";
                }

                var3 = var3.replace("\n", "").trim();
                if (var7 == Color.BLACK.toIntBits()) {
                    Graphics var9 = this;

                    try {
                        ShaderProgram var10;
                        if ((var10 = beatdz.LangLa_cr.$state_LangLa_cr().a) != null) {
                            var9.getSpriteBatch().end();
                            var9.getSpriteBatch().setShader(var10);
                            var9.getSpriteBatch().begin();
                        }
                    } catch (Exception var11) {
                    }
                } else {
                    var2.setColor(Utlis.createColor((long) var7));
                }

                GlyphLayout var13;
                int var14 = (int) (var13 = a(var1, var2, var3, (Vector) C.get(var1))).width;
                int var16 = (int) var13.height;
                var4 = (var4 + this.a) * DataCenter.gI().zoomLevel;
                var5 = (var5 + this.b) * DataCenter.gI().zoomLevel;
                if (var6 == 1) {
                    var4 -= var14;
                } else if (var6 == 2) {
                    var4 -= var14 / 2;
                }

                var5 -= var16 / 2;
                if (var7 != Color.BLACK.toIntBits()) {
                    var2.setColor(Utlis.createColor((long) var7));
                    Color var15 = this.getSpriteBatch().getColor();
                    this.getSpriteBatch().setColor(var15.r, var15.g, var15.b, this.m);
                    if (!this.x.equals(Color.CLEAR)) {
                        this.getSpriteBatch().setColor(this.x.r, this.x.g, this.x.b, this.x.a);
                    }
                }

                Texture var10000 = var2.getRegion().getTexture();
                TextureFilter var10001 = TextureFilter.Linear;
                ImageSampling.configure(var10000);

                var2.draw(this.getSpriteBatch(), var13, (float) var4 + var8 + motionX(), (float) var5 + motionY());
                if (var7 == Color.BLACK.toIntBits()) {
                    this.h();
                }

            }
        } catch (Exception var12) {
        }
    }

    public final void a(float var1, float var2) {
        try {
            ShaderProgram var3;
            if ((var3 = beatdz.LangLa_cr.$state_LangLa_cr().d2) != null) {
                this.getSpriteBatch().end();
                var3.begin();
                var3.setUniformf("contrast", var1);
                var3.setUniformf("brightness", var2);
                var3.end();
                this.getSpriteBatch().setShader(var3);
                this.getSpriteBatch().begin();
            }

        } catch (Exception var4) {
            var4.printStackTrace();
        }
    }

    public void d(float var1) {
        try {
            ShaderProgram var2;
            if ((var2 = beatdz.LangLa_cr.$state_LangLa_cr().b) != null) {
                this.getSpriteBatch().end();
                var2.begin();
                var2.setUniformf("hue", var1);
                var2.end();
                this.getSpriteBatch().setShader(var2);
                this.getSpriteBatch().begin();
            }
        } catch (Exception var3) {
        }
    }

    public void h() {
        this.getSpriteBatch().end();
        this.getSpriteBatch().setShader((ShaderProgram) null);
        this.getSpriteBatch().begin();
    }

    public int i() {
        return this.r - this.a;
    }

    public int j() {
        return this.s - this.b;
    }

    public void setClip(int var1, int var2, int var3, int var4) {
        try {
            // Legacy widgets restore a full-screen clip with the world's logical
            // size. Fitted popups have their own camera and a larger logical area.
            if (var1 + this.a == 0 && var2 + this.b == 0 &&
                    var3 == DataCenter.gI().widthScreen && var4 == DataCenter.gI().heightScreen) {
                var3 = this.canvas.getFullClipWidth();
                var4 = this.canvas.getFullClipHeight();
            }
            if (this.j) this.r();
            this.r = var1 + this.a;
            this.s = var2 + this.b;
            this.t = var1;
            this.u = var2;
            var1 += this.a;
            var2 += this.b;
            this.h = var3;
            this.i = var4;
            var1 *= DataCenter.gI().zoomLevel;
            var2 *= DataCenter.gI().zoomLevel;
            var3 *= DataCenter.gI().zoomLevel;
            var4 *= DataCenter.gI().zoomLevel;
            if (this.d == null) this.d = new Rectangle();
            this.d.set((float) var1 + motionX(), (float) var2 + motionY(), (float) var3, (float) var4);
            this.q();
            this.j = true;
        } catch (Exception var5) {
        }
    }

    public void f(int var1) {
        this.w = -16777216 | var1;
    }

    public void a(int var1, int var2) {
        this.a += var1;
        this.b += var2;
        this.t = -var1;
        this.u = -var2;
    }

    public void clean() {
        this.motionX = this.motionY = 0f;
        this.a = 0;
        this.b = 0;
    }

    public void dispose() {
        try {
            if (this.spriteBatch != null) {
                this.spriteBatch.dispose();
                this.spriteBatch = null;
            }

        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    public static boolean m() {
        return q || AppListener.gI().app.c();
    }

    public void a2(Graphics var1, TextureRegion var2, int var3, int var4, int var5, int var6, int var7) {
        if (mConfig.gI().readByte(18) > 1) {
            if (this.spriteBatch == null) {
                this.dispose();
            }

        } else {
            this.v = false;
            var4 += this.a;
            var5 += this.b;
            int width = var6;
            int height = var7;
            var4 *= DataCenter.gI().zoomLevel;
            var5 *= DataCenter.gI().zoomLevel;
            var4 -= width / 2;
            var5 -= height / 2;
            Vector2 v = new Vector2(var4 + motionX(), var5 + motionY());
            drawPortionFromButtom(this.getSpriteBatch(), var2, v, width, height, 1);
//            ByteBuffer byteBuffer = myTexture.getTextureData().consumePixmap().getPixels();
//            byte[] pixelDataByteArray = new byte[byteBuffer.remaining()];
//            byteBuffer.get(pixelDataByteArray);
//            this.a(mImage.a(pixelDataByteArray,0,pixelDataByteArray.length), 0, 0, 1, 1, 0, var4, var5, var6, var7, 0);
//public void draw(TextureRegion region, float x, float y, float originX, float originY, float width, float height, float scaleX, float scaleY, float rotation) {
            // this.getSpriteBatch().draw(Char.animation.getKeyFrame(Canvas.elapsed), var4, var5, 0, 0, Char.animation.getKeyFrame(Canvas.elapsed).getRegionWidth(), Char.animation.getKeyFrame(Canvas.elapsed).getRegionHeight(), 0, 0, 3);
            //this.a(Char.animation.getKeyFrame(0), 0, 0, 1, 1, 0, var4, var5, var6, var7, 0);
            this.v = true;
        }
    }
    public static void
    drawPortionFromButtom(
            SpriteBatch batcher, TextureRegion textureRegion,
            Vector2 position, float width, float height, float portionToDraw) {
        batcher.draw(textureRegion.getTexture(),
                position.x,
                position.y + height * (1 - portionToDraw),
                width,
                (height * portionToDraw),
                textureRegion.getU(),
                textureRegion.getV(),
                textureRegion.getU2(),
                textureRegion.getV2() + (textureRegion.getV() - textureRegion.getV2()) * (1 - portionToDraw)
        );
    }

}
