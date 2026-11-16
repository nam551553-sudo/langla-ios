package beatdz;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.*;
import java.io.InputStream;
import java.util.*;

/** Real character composition with the exported, shipped costume/cape metadata. */
public final class CapeAttachmentCheck {
    record Draw(mImage image, int x, int bottom, int width, int height) { }
    static final class Capture extends Graphics {
        final List<Draw> calls = new ArrayList<>();
        Capture() { super(null); }
        @Override public SpriteBatch getSpriteBatch() { return null; }
        @Override public void a(mImage image,int sx,int sy,int sw,int sh,int transform,int x,int y,int w,int h,int anchor) {
            calls.add(new Draw(image,x,y,w,h));
        }
        @Override public void b(mImage image,int sx,int sy,int sw,int sh,int transform,int x,int y,int w,int h,int anchor) {
            calls.add(new Draw(image,x,y,w,h));
        }
        @Override void drawImagePixelRows(mImage image,int top,int rows,int transform,int x,int bottom,int width,int height) {
            check(top>=0 && rows>0 && top+rows<=image.d && width>0 && height>0,"Valid cape/idle source rows and size");
            calls.add(new Draw(image,x,bottom,width,height));
        }
    }
    public static void main(String[] args) throws Exception {
        GdxNativesLoader.load();
        JsonValue fixture;
        try(InputStream in=CapeAttachmentCheck.class.getResourceAsStream("/cape-attachments.json")) {
            if(in==null) throw new AssertionError("Cape fixture is missing");
            fixture=new JsonReader().parse(in);
        }
        DataCenter data=DataCenter.gI();data.zoomLevel=1;data.F=new LangLa_jr[977];data.widthScreen=800;data.heightScreen=600;
        Map<Short,mImage> sprites=new HashMap<>();
        for(JsonValue p:fixture.get("parts")) {
            LangLa_jr part=new LangLa_jr();part.a=p.getInt("id");part.b=p.getInt("type");part.d=new LangLa_ju[33];int pose=0;
            for(JsonValue f:p.get("frames")) {
                int[] v=f.asIntArray();LangLa_ju frame=new LangLa_ju((short)v[0]);frame.b=(byte)v[1];frame.c=(byte)v[2];frame.d=(byte)v[3];frame.e=(byte)v[4];part.d[pose++]=frame;
                if(frame.a!=0) {
                    data.am.put(frame.a,new LangLa_et((short)-1,(short)0,(short)0,(short)v[5],(short)v[6]));
                    mImage image=new mImage();image.c=Math.max(2,v[5]*4);image.d=Math.max(2,v[6]*4);
                    sprites.put(frame.a,image);LangLa_fq.$state_LangLa_fq().g.put(frame.a,image);
                }
            }
            data.F[part.a]=part;
        }
        Capture graphics=new Capture();Char character=Char.gI();int cases=0,neckCases=0;
        Set<Integer> costumes=new TreeSet<>();
        for(int id=926;id<=976;id++) {
            LangLa_jr body=data.F[id];if(body==null||!CostumeCape.isNewBody(body)) continue;
            for(int pose=0;pose<33;pose++) for(boolean flip:new boolean[]{false,true}) {
                boolean standing=pose<=1||pose>=31;
                LangLa_ju cel=body.d[standing?0:pose];mImage bodyImage=sprites.get(cel.a);
                if(bodyImage==null) continue;
                costumes.add(id);
                Vector baseParts=new Vector();baseParts.add(body.a());graphics.calls.clear();
                character.a(graphics,0,0,baseParts,pose,pose,flip);
                List<Draw> expected=graphics.calls.stream().filter(d->d.image==bodyImage).toList();
                for(JsonValue cape:fixture.get("capes")) {
                    Vector parts=new Vector();parts.add(body.a());
                    for(JsonValue value:cape.get("parts")) {
                        if(value.asInt()==0) continue;
                        LangLa_jr part=data.F[value.asInt()].a();part.equippedCape=true;parts.add(part);
                    }
                    graphics.calls.clear();character.a(graphics,0,0,parts,pose,pose,flip);
                    List<Draw> actual=graphics.calls.stream().filter(d->d.image==bodyImage).toList();
                    check(actual.equals(expected),"Cape must preserve the body, face, idle breath and feet: body="+id+" pose="+pose);
                    if(standing&&(id==961||id>=974)) {
                        int lastBody=-1;
                        for(int i=0;i<graphics.calls.size();i++)if(graphics.calls.get(i).image==bodyImage)lastBody=i;
                        int center=flip?-cel.d:cel.d;
                        // These four supplied 47px cels have their visible chin/neck
                        // within this measured rectangle above the chest.
                        int neckTop=cel.e-28,neckBottom=cel.e-20;
                        for(int i=lastBody+1;i<graphics.calls.size();i++) {
                            Draw draw=graphics.calls.get(i);
                            boolean overlaps=draw.x+draw.width/2>center-4 && draw.x-draw.width/2<center+4
                                    && draw.bottom>neckTop && draw.bottom-draw.height<neckBottom;
                            check(!overlaps,"Front cape covers the face/neck: costume="+id+" cape="+cape.getInt("id"));
                        }
                        neckCases++;
                    }
                    cases++;
                }
            }
        }
        check(costumes.size()==16 && cases==14_784 && neckCases==448,
                "All sixteen retained full-body costumes, fourteen capes, 33 poses and both directions; cases="+cases+", neck="+neckCases);
        CapeAttachmentScenario.verify();
        System.out.println("PASS "+cases+" cape/costume pose and direction combinations; "+neckCases
                +" measured neck checks, intact body/idle breathing and valid sprite crops.");
    }
    private static void check(boolean ok,String message) { if(!ok) throw new AssertionError(message); }
}
