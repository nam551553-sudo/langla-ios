package beatdz;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/** Same collar/neck contract on a desktop or native iOS render thread. */
public final class CapeAttachmentScenario {
    private static final int[][] CAPES = {
            {469,470,471},{29},{29},{837,838},{19},{20},{21,25},
            {22,27},{23,28},{24,26},{737,738,739},{414,415,416},{616},{962,963}
    };
    private static final class Draw {
        final mImage image;
        final int x,bottom,width,height;
        Draw(mImage image,int x,int bottom,int width,int height) {
            this.image=image;this.x=x;this.bottom=bottom;this.width=width;this.height=height;
        }
    }
    private static final class Capture extends Graphics {
        final List<Draw> calls=new ArrayList<Draw>();
        Capture() { super(null); }
        @Override public SpriteBatch getSpriteBatch() { return null; }
        @Override public void a(mImage image,int sx,int sy,int sw,int sh,int transform,int x,int y,int w,int h,int anchor) {
            calls.add(new Draw(image,x,y,w,h));
        }
        @Override public void b(mImage image,int sx,int sy,int sw,int sh,int transform,int x,int y,int w,int h,int anchor) {
            calls.add(new Draw(image,x,y,w,h));
        }
        @Override void drawImagePixelRows(mImage image,int top,int rows,int transform,int x,int bottom,int width,int height) {
            require(top>=0 && rows>0 && top+rows<=image.d,"Native cape/idle crop bounds");
            calls.add(new Draw(image,x,bottom,width,height));
        }
    }
    public static void verify() {
        DataCenter data=DataCenter.gI();
        Map<Short,mImage> originals=new HashMap<Short,mImage>();
        Map<Short,mImage> sprites=new HashMap<Short,mImage>();
        int previousZoom=data.zoomLevel;
        Capture graphics=new Capture();
        synchronized(LangLa_fq.$state_LangLa_fq().g) {
            try {
                data.zoomLevel=1;
                for(int[] cape:CAPES)for(int part:cape)prepare(data,part,originals,sprites);
                for(int part:new int[]{22,27,961,974,975,976})prepare(data,part,originals,sprites);
                int checked=0;
                for(int bodyId:new int[]{961,974,975,976}) {
                    LangLa_jr body=data.F[bodyId];LangLa_ju cel=body.d[0];
                    mImage bodyImage=sprites.get(cel.a);
                    require(bodyImage!=null,"Native full-body sprite metadata");
                    for(int pose:new int[]{0,1,31,32})for(boolean flip:new boolean[]{false,true})for(int[] cape:CAPES) {
                        Vector parts=new Vector();parts.add(body.a());
                        for(int id:cape) {LangLa_jr layer=data.F[id].a();layer.equippedCape=true;parts.add(layer);}
                        graphics.calls.clear();Char.gI().a(graphics,0,0,parts,pose,pose,flip);
                        int lastBody=-1;
                        for(int i=0;i<graphics.calls.size();i++)if(graphics.calls.get(i).image==bodyImage)lastBody=i;
                        require(lastBody>=0,"Native body remains visible with a cape");
                        int center=flip?-cel.d:cel.d;
                        for(int i=lastBody+1;i<graphics.calls.size();i++) {
                            Draw draw=graphics.calls.get(i);
                            boolean overlap=draw.x+draw.width/2>center-4 && draw.x-draw.width/2<center+4
                                    && draw.bottom>cel.e-28 && draw.bottom-draw.height<cel.e-20;
                            require(!overlap,"Native front cape obscures the measured chin/neck");
                        }
                        checked++;
                    }
                }
                require(checked==448,"All native measured neck checks ran");
            } finally {
                data.zoomLevel=previousZoom;
                for(Map.Entry<Short,mImage> entry:originals.entrySet()) {
                    if(entry.getValue()==null)LangLa_fq.$state_LangLa_fq().g.remove(entry.getKey());
                    else LangLa_fq.$state_LangLa_fq().g.put(entry.getKey(),entry.getValue());
                }
                if(graphics.shapeRenderer!=null)graphics.shapeRenderer.dispose();
                graphics.dispose();
            }
        }
    }
    private static void prepare(DataCenter data,int part,Map<Short,mImage> originals,Map<Short,mImage> sprites) {
        require(data.F!=null && part<data.F.length && data.F[part]!=null,"Native cape part metadata "+part);
        for(LangLa_ju frame:data.F[part].d) {
            if(frame.a==0 || originals.containsKey(frame.a))continue;
            LangLa_et size=CostumeCape.spriteSize(data,frame.a);if(size==null)continue;
            originals.put(frame.a,(mImage)LangLa_fq.$state_LangLa_fq().g.get(frame.a));
            mImage image=new mImage();image.c=size.d*4;image.d=size.e*4;
            sprites.put(frame.a,image);LangLa_fq.$state_LangLa_fq().g.put(frame.a,image);
        }
    }
    private static void require(boolean ok,String message) { if(!ok)throw new AssertionError(message); }
}
