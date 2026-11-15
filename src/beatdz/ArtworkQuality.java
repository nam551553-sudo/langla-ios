package beatdz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;

final class ArtworkQuality {
    private static final String PRECISION =
            "#ifdef GL_ES\n#define LOWP lowp\n#define MEDIUMP mediump\n"
            + "#else\n#define LOWP\n#define MEDIUMP\n#endif\n";
    private static final String VERTEX =
            PRECISION + "attribute vec4 a_position;\n"
            + "attribute vec4 a_color;\n"
            + "attribute vec2 a_texCoord0;\n"
            + "uniform mat4 u_projTrans;\n"
            + "varying LOWP vec4 v_color;\n"
            + "varying MEDIUMP vec2 v_texCoords;\n"
            + "void main() {\n"
            + "    v_color = a_color;\n"
            + "    v_color.a *= 255.0 / 254.0;\n"
            + "    v_texCoords = a_texCoord0;\n"
            + "    gl_Position = u_projTrans * a_position;\n"
            + "}\n";

    // One lookup per pixel. Lift midtones and enrich color before applying the game's tint.
    private static final String FRAGMENT =
            PRECISION + "#ifdef GL_ES\nprecision mediump float;\n#endif\n"
            + "uniform sampler2D u_texture;\n"
            + "varying LOWP vec4 v_color;\n"
            + "varying MEDIUMP vec2 v_texCoords;\n"
            + "void main() {\n"
            + "    vec4 sampleColor = texture2D(u_texture, v_texCoords);\n"
            + "    vec3 lit = sampleColor.rgb + 0.19 * sampleColor.rgb * (1.0 - sampleColor.rgb);\n"
            + "    float luma = dot(lit, vec3(0.2126, 0.7152, 0.0722));\n"
            + "    vec3 richer = clamp(lit + 0.12 * (lit - vec3(luma)), 0.0, 1.0);\n"
            + "    gl_FragColor = vec4(richer, sampleColor.a) * v_color;\n"
            + "}\n";

    private ArtworkQuality() { }

    static int assetScale(int base, int pixelWidth, int pixelHeight, boolean mobile, boolean reduced) {
        int nativeScale = Math.max(1, Math.min(4, base));
        if (reduced) return nativeScale;
        int longSide = Math.max(pixelWidth, pixelHeight);
        int shortSide = Math.min(pixelWidth, pixelHeight);
        if (longSide >= (mobile ? 2200 : 2300) && shortSide >= 1080) return 4;
        if (!mobile && longSide >= 1500 && shortSide >= 900) return Math.max(3, nativeScale);
        return nativeScale;
    }

    static ShaderProgram createShader() {
        ShaderProgram shader = new ShaderProgram(VERTEX, FRAGMENT);
        if (shader.isCompiled()) return shader;
        Gdx.app.log("Đồ họa", shader.getLog());
        shader.dispose();
        return null;
    }
}
