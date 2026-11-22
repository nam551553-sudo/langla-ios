package beatdz;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;

public class LangLa_cr {
   
   
   
   
 
     
   
   
   
   
   
   
   

   

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public String h;
public String i;
public String j;
public String k;
public String dz;
public ShaderProgram a;
public ShaderProgram b;
public ShaderProgram c;
public ShaderProgram d;
public ShaderProgram e;
public ShaderProgram f;
public ShaderProgram g;
public ShaderProgram d2;
public void initialize() {
this.h = "#ifdef GL_ES\nprecision mediump float;\n#endif\n\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\nuniform sampler2D u_texture;\nuniform mat4 u_projTrans;\n\nvoid main() {\n    vec4 color = texture2D(u_texture, v_texCoords).rgba;\n    if (color.r < 0.5 && color.g < 0.5&& color.b < 0.5){\n        color.rgb = vec3(0.3, 0.3, 0.3);\n    } else if (color.r > 0.5){\n        color.rgb = vec3(0.0, 0.0, 0.0);\n    }\n    gl_FragColor = color;\n}";
this.i = "#ifdef GL_ES\n#define LOWP lowp\nprecision mediump float;\n#else\n#define LOWP\n#endif\nvarying LOWP vec4 v_color;\nvarying vec2 v_texCoords;\nuniform sampler2D u_texture;\nuniform float hue;\n\n\nvec3 applyHue(vec3 rgb, float hue)\n{\n    float d = radians(hue);\n    vec3 k = vec3(0.57735);\n    float c = cos(hue);\n    return rgb * c + cross(k, rgb) * sin(d) + k * dot(k, rgb) * (1.0 - c);\n}\n\nvoid main(){\n    vec4 color = texture2D(u_texture, v_texCoords).rgba;\n    color.rgb = applyHue(color.rgb, hue);\n    gl_FragColor = color;\n}";
this.j = "#ifdef GL_ES\n#define LOWP lowp\nprecision mediump float;\n#else\n#define LOWP\n#endif\nvarying LOWP vec4 v_color;\nvarying vec2 v_texCoords;\nuniform sampler2D u_texture;\nuniform float hue_value;\nuniform vec3 hue_color;\n\nvec3 applyHue(vec3 rgb, float hue)\n{\n    float d = radians(hue);\n    vec3 k = vec3(0.57735);\n    float c = cos(hue);\n    return rgb * c + cross(k, rgb) * sin(d) + k * dot(k, rgb) * (1.0 - c);\n}\n\nvoid main(){\n    vec4 color = texture2D(u_texture, v_texCoords).rgba;\n    color = vec4(vec3(0.299 * color.r + 0.587 * color.g + 0.114 * color.b), color.a);\n    vec4 colorized  = vec4(hue_color,color.a);\n    color = color*colorized;\n    color.rgb = applyHue(color.rgb, hue_value);\n    gl_FragColor = color;\n}";
this.k = "#ifdef GL_ES\n#define LOWP lowp\nprecision mediump float;\n#else\n#define LOWP\n#endif\nvarying LOWP vec4 v_color;\nvarying vec2 v_texCoords;\nuniform sampler2D u_texture;\nuniform float hue;\n\n\nvec3 applyHue(vec3 rgb, float hue)\n{\n    float d = radians(hue);\n    vec3 k = vec3(0.57735);\n    float c = cos(hue);\n    return rgb * c + cross(k, rgb) * sin(d) + k * dot(k, rgb) * (1.0 - c);\n}\n\nvoid main(){\n    vec4 color = texture2D(u_texture, v_texCoords).rgba;\n    color = vec4(vec3(0.299 * color.r + 0.587 * color.g + 0.114 * color.b), color.a);\n    color.rgb = vec3(1, color.g, color.b);\n    color.rgb = applyHue(color.rgb, hue);\n    gl_FragColor = color;\n}";
this.dz = "#ifdef GL_ES\n#define LOWP lowp\nprecision mediump float;\n#else\n#define LOWP\n#endif\nvarying LOWP vec4 v_color;\nvarying vec2 v_texCoords;\nuniform sampler2D u_texture;\nuniform float brightness;\nuniform float contrast;\n\nvec3 applyContrast(vec3 color, float contrast)\n{\n    return color * contrast;\n}\n\nvec3 applyBrightness(vec3 color, float brightness)\n{\n    return color + vec3(brightness, brightness, brightness);\n}\n\nvoid main(){\n    vec4 color = texture2D(u_texture, v_texCoords).rgba;\n    vec3 vctr = applyContrast(color.rgb, contrast);\n    vec3 vbrt = applyBrightness(vctr, brightness);\n    gl_FragColor = vec4(vbrt, color.a);\n}";
{
      this.a = new ShaderProgram("attribute vec4 a_position;\nattribute vec4 a_color;\nattribute vec2 a_texCoord0;\n\nuniform mat4 u_projTrans;\n\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\n\nvoid main() {\n    v_color = a_color;\n    v_texCoords = a_texCoord0;\n    gl_Position = u_projTrans * a_position;\n}", this.h);
      this.b = new ShaderProgram("attribute vec4 a_position;\nattribute vec4 a_color;\nattribute vec2 a_texCoord0;\n\nuniform mat4 u_projTrans;\n\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\n\nvoid main() {\n    v_color = a_color;\n    v_texCoords = a_texCoord0;\n    gl_Position = u_projTrans * a_position;\n}", this.i);
      this.c = new ShaderProgram("attribute vec4 a_position;\nattribute vec4 a_color;\nattribute vec2 a_texCoord0;\n\nuniform mat4 u_projTrans;\n\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\n\nvoid main() {\n    v_color = a_color;\n    v_texCoords = a_texCoord0;\n    gl_Position = u_projTrans * a_position;\n}", this.j);
      this.d = new ShaderProgram("attribute vec4 a_position;\nattribute vec4 a_color;\nattribute vec2 a_texCoord0;\n\nuniform mat4 u_projTrans;\n\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\n\nvoid main() {\n    v_color = a_color;\n    v_texCoords = a_texCoord0;\n    gl_Position = u_projTrans * a_position;\n}", this.k);
      this.d2 = new ShaderProgram("attribute vec4 a_position;\nattribute vec4 a_color;\nattribute vec2 a_texCoord0;\n\nuniform mat4 u_projTrans;\n\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\n\nvoid main() {\n    v_color = a_color;\n    v_texCoords = a_texCoord0;\n    gl_Position = u_projTrans * a_position;\n}", this.dz);
      this.e = new ShaderProgram("attribute vec4 a_position;\nattribute vec4 a_color;\nattribute vec2 a_texCoord0;\n\nuniform mat4 u_projTrans;\n\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\n\nvoid main() {\n    v_color = a_color;\n    v_texCoords = a_texCoord0;\n    gl_Position = u_projTrans * a_position;\n}", "#ifdef GL_ES\nprecision mediump float;\n#endif\n\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\nuniform sampler2D u_texture;\nuniform mat4 u_projTrans;\n\nvoid main() {\n    vec4 color = texture2D(u_texture, v_texCoords).rgba;\n    color = vec4(vec3(0.299 * color.r + 0.587 * color.g + 0.114 * color.b), color.a);\n    gl_FragColor = color;\n}");
      this.f = new ShaderProgram("attribute vec4 a_position;\nattribute vec4 a_color;\nattribute vec2 a_texCoord0;\nuniform mat4 u_projTrans;\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\nvarying float v_lightFix;\n\nvoid main()\n{\n   v_color = a_color;\n   v_texCoords = a_texCoord0;\n   v_color.a = pow(v_color.a * (255.0/254.0) + 0.5, 1.709);\n   v_lightFix = 1.0 + pow(v_color.a, 1.41421356);\n   gl_Position =  u_projTrans * a_position;\n}\n", "#ifdef GL_ES\n#define LOWP lowp\nprecision mediump float;\n#else\n#define LOWP \n#endif\nvarying vec2 v_texCoords;\nvarying float v_lightFix;\nvarying LOWP vec4 v_color;\nuniform sampler2D u_texture;\nvec3 applyHue(vec3 rgb, float hue)\n{\n    vec3 k = vec3(0.57735);\n    float c = cos(hue);\n    //Rodrigues' rotation formula\n    return rgb * c + cross(k, rgb) * sin(hue) + k * dot(k, rgb) * (1.0 - c);\n}\nvoid main()\n{\n    float hue = 6.2831853 * (v_color.x - 0.5);\n    float saturation = v_color.y * 2.0;\n    float brightness = v_color.z - 0.5;\n    vec4 tgt = texture2D( u_texture, v_texCoords );\n    tgt.rgb = applyHue(tgt.rgb, hue);\n    tgt.rgb = vec3(\n     (0.5 * pow(dot(tgt.rgb, vec3(0.375, 0.5, 0.125)), v_color.w) * v_lightFix + brightness),\n     ((tgt.r - tgt.b) * saturation),\n     ((tgt.g - tgt.b) * saturation));\n    gl_FragColor = clamp(vec4(\n     dot(tgt.rgb, vec3(1.0, 0.625, -0.5)),\n     dot(tgt.rgb, vec3(1.0, -0.375, 0.5)),\n     dot(tgt.rgb, vec3(1.0, -0.375, -0.5)),\n     tgt.a), 0.0, 1.0);\n}");
      boolean var0 = true;
      Color var1 = new Color(-1);
      this.g = new ShaderProgram("attribute vec4 a_position;\nattribute vec4 a_color;\nattribute vec2 a_texCoord0;\nuniform mat4 u_projTrans;\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\nvarying float v_lightFix;\n\nvoid main()\n{\n   v_color = a_color;\n   v_texCoords = a_texCoord0;\n   v_color.a = pow(v_color.a * (255.0/254.0) + 0.5, 1.709);\n   v_lightFix = 1.0 + pow(v_color.a, 1.41421356);\n   gl_Position =  u_projTrans * a_position;\n}\n", "#ifdef GL_ES\n#define LOWP lowp\nprecision mediump float;\n#else\n#define LOWP\n#endif\nvarying LOWP vec4 v_color;\nvarying vec2 v_texCoords;\nuniform sampler2D u_texture;\n\nvoid main(){\n    vec4 color = texture2D(u_texture, v_texCoords).rgba;\n    gl_FragColor = vec4(vec3(" + var1.r + ", " + var1.g + ", " + var1.b + "), color.a);\n\n}");
   }
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.LangLa_cr");
public static SessionState $state_LangLa_cr() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
