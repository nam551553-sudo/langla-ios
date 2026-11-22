package beatdz;import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

public class LangLa_la {
   public String a;
   public int b;
   public int c;
   public float d;

   public LangLa_la(int var1, BitmapFont var2, String var3, int var4) {
      this.a = var3;
      this.b = var4;
      GlyphLayout var5 = Graphics.a(var1, var2, var3);
      this.d = var5.width + (float)DataCenter.gI().zoomLevel;
   }

   public LangLa_la(int var1, int var2) {
      this.c = var1;
      this.d = (float)((var2 + 2) * DataCenter.gI().zoomLevel);
   }
}
