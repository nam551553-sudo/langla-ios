package beatdz;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MyViewport extends Viewport {
   private Scaling c;
   int x;
   int y;

   public MyViewport(Scaling var1, float var2, float var3, Camera var4) {
      this.c = var1;
      this.setWorldSize(var2, var3);
      this.setCamera(var4);
   }

   public void update(int var1, int var2, boolean var3) {
      Vector2 var4;
      int var5 = Math.round((var4 = this.c.apply(this.getWorldWidth(), this.getWorldHeight(), (float)var1, (float)var2)).x);
      int var6 = Math.round(var4.y);
      // Stage may first size this viewport to the full window, including the tab bar.
      // Recalculate from the new bounds instead of accumulating that old offset.
      var1 = (var1 - var5) / 2;
      var2 = (var2 - var6) / 2;
      if (this.x > 0) {
         var1 = this.x;
      }

      super.setScreenBounds(var1, var2, var5, var6);
      this.apply(var3);
   }

   public void setScreenBounds(int var1, int var2, int var3, int var4) {
      super.setScreenBounds(var1, var2, var3, var4);
   }
}
