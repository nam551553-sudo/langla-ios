package beatdz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;

/** Native-density images are sampled once; linear magnification avoids shimmer at fractional zoom. */
public final class ImageSampling {
    private ImageSampling() { }
    private static boolean mobile() {
        if (Gdx.app == null) return false;
        ApplicationType type = Gdx.app.getType();
        return type == ApplicationType.Android || type == ApplicationType.iOS;
    }
    public static void configure(Texture texture) {
        if (texture == null) return;
        TextureFilter min = TextureFilter.Linear;
        TextureFilter mag = TextureFilter.Linear;
        if (texture.getMinFilter() != min || texture.getMagFilter() != mag) texture.setFilter(min, mag);
    }
    public static void resize(Pixmap destination, int sourceWidth, int sourceHeight, int width, int height) {
        boolean enlarge = width > sourceWidth || height > sourceHeight;
        destination.setFilter(mobile() && enlarge ? Pixmap.Filter.NearestNeighbour : Pixmap.Filter.BiLinear);
    }
}
