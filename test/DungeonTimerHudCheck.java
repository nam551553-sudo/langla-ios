package beatdz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.*;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.beatdz.langlalau.DesktopLauncher;
import com.beatdz.langlalau.SoftwareRenderer;
import com.tgame.model.Caption;
import java.io.*;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.file.*;
import java.util.*;

public final class DungeonTimerHudCheck {
    public static void main(String[] args){
        Caption.loadVN();Gdx.files=new LwjglFiles();SoftwareRenderer.install(args);
        LwjglApplicationConfiguration config=new LwjglApplicationConfiguration();config.title="Dungeon remaining time";config.width=840;config.height=500;
        new LwjglApplication(new AppListener(){@Override public void create(){setAppEventListener(new DesktopLauncher());super.create();Gdx.app.postRunnable(()->{
            try{verify();System.out.println("PASS visible Cam Thuat/training countdown under the map title, real legacy packet decoding, six tabs, both shortcut states, compact displays, elapsed time and map exit.");System.exit(0);}
            catch(Throwable e){e.printStackTrace();System.exit(1);}
        });}},config);
    }
    private static void verify()throws Exception{
        DataCenter root=DataCenter.gI();root.ba=root.bb=true;root.aP=new Server();root.aP.name="Timer fixture";
        root.MapTemplate=new MapTemplate[90];for(int id:new int[]{0,84,89}){root.MapTemplate[id]=new MapTemplate(id);root.MapTemplate[id].name="Timer map "+id;root.MapTemplate[id].type=(byte)(id==84?13:id==89?14:2);}
        root.exps=new long[]{1000000};
        String fixtures=System.getProperty("dungeon.timer.fixtures");
        if(fixtures!=null){Properties p=new Properties();try(InputStream in=Files.newInputStream(Paths.get(fixtures,"map-types.properties"))){p.load(in);}for(int id:new int[]{84,89})root.MapTemplate[id].type=Byte.parseByte(p.getProperty(Integer.toString(id)));}
        MultiSession.select(0);for(int slot=1;slot<6;slot++)require(MultiSession.add(),"create account tab "+slot);
        Method paint=GameSrc.class.getDeclaredMethod("paintHudGroup",Graphics.class,LangLa_cj.class);paint.setAccessible(true);
        Method layout=GameSrc.class.getDeclaredMethod("layoutShortcutDock",boolean.class);layout.setAccessible(true);
        GameSrc[] games=new GameSrc[6];
        Recorder graphics=new Recorder();
        for(int slot=0;slot<6;slot++){
            MultiSession.select(slot);DataCenter data=DataCenter.gI();GameSrc game=games[slot]=GameSrc.gI();data.currentScreen=game;
            Char.gI().idClass=0;int id=slot%2==0?89:84;game.mapID=(short)id;
            byte[] packet=fixtures==null?packet(id==84?18_000_000:360_000):Files.readAllBytes(Paths.get(fixtures,id==84?"training.bin":"cam-thuat.bin"));
            new Controller().a(new Message((byte)-123,packet));
            require(game.timeHoatDong==ByteBuffer.wrap(packet,9,4).getInt()&&!game.isHoatDongTime,"decode the real -80 message in each account");
            require(game.timeStartHoatDong==ByteBuffer.wrap(packet,1,8).getLong(),"server timestamp preserved");
            int initial=(game.timeHoatDong+999)/1000;
            require(DungeonTimerHud.remainingSeconds(game,game.timeStartHoatDong+31_000)==Math.max(0,initial-31),"wall-clock countdown independent of FPS");
            game.Q=new LangLa_cj(game,(byte)-1,-1);game.T=new LangLa_cj(game,(byte)6,2);game.U=new LangLa_cj(game,(byte)6,3);
            LangLa_dz first=new LangLa_dz(0,0,20,20,"",game,9997,0),second=new LangLa_dz(0,0,20,20,"",game,9998,0),toggle=new LangLa_dz(0,0,12,12,"",game,1100,0);
            game.U.a.add(first);game.U.a.add(second);game.U.a.add(toggle);
            for(int width:new int[]{240,320,390,480,640})for(boolean expanded:new boolean[]{false,true}){
                game.setSize(width,180);data.widthScreen=(short)width;data.heightScreen=180;
                layout.invoke(game,expanded);
                require(first.cy==36&&second.cy==61&&toggle.cy==(expanded?88:36),"shortcuts and toggle clear the timer row");
                game.timeStartHoatDong=Utlis.time();graphics.clear();paint.invoke(game,graphics,game.Q);
                require(graphics.labels.stream().anyMatch(s->s.startsWith("Còn lại: ")),"countdown rendered while the minimap is hidden and shortcuts are "+expanded);
                require(graphics.rectangles.stream().anyMatch(r->r[0]>=0&&r[0]+r[2]<=width&&r[1]==16&&r[3]==16),"timer stays below title and inside viewport");
                graphics.clear();paint.invoke(game,graphics,game.T);require(graphics.labels.isEmpty(),"hidden minimap does not duplicate the timer");
            }
            game.timeStartHoatDong=Utlis.time()-game.timeHoatDong-1000L;graphics.clear();paint.invoke(game,graphics,game.Q);
            require(graphics.labels.contains("Còn lại: 00:00:00"),"expired time is clamped at zero");
            game.timeStartHoatDong=Utlis.time();
        }
        MultiSession.select(0);games[0].mapID=0;graphics.clear();paint.invoke(games[0],graphics,games[0].Q);require(graphics.labels.isEmpty(),"timer disappears outside its dungeon");
        layout.invoke(games[0],true);require(((LangLa_dz)games[0].U.a.firstElement()).cy==20,"normal maps keep the original shortcut positions");
        for(int slot=1;slot<6;slot++){MultiSession.select(slot);graphics.clear();paint.invoke(games[slot],graphics,games[slot].Q);require(!graphics.labels.isEmpty(),"another account's map exit does not clear this timer");}
        require(DungeonTimerHud.clock(18000).equals("05:00:00")&&DungeonTimerHud.clock(360).equals("00:06:00")&&DungeonTimerHud.clock(119).equals("00:01:59")&&DungeonTimerHud.clock(-1).equals("00:00:00"),"readable hours/minutes/seconds");
        graphics.dispose();
    }
    private static byte[] packet(int millis)throws IOException{ByteArrayOutputStream bytes=new ByteArrayOutputStream();DataOutputStream out=new DataOutputStream(bytes);out.writeByte(-80);out.writeLong(System.currentTimeMillis());out.writeInt(millis);out.writeBoolean(false);return bytes.toByteArray();}
    private static final class Recorder extends Graphics{
        final List<String> labels=new ArrayList<>();final List<int[]> rectangles=new ArrayList<>();
        Recorder(){super(null);}
        void clear(){labels.clear();rectangles.clear();}
        @Override public void a(int type,BitmapFont font,String text,int x,int y,int anchor,int color,float offset){labels.add(text);}
        @Override public void f(int color){}
        @Override public void c(int x,int y,int width,int height){rectangles.add(new int[]{x,y,width,height});}
        @Override public void clean(){}
        @Override public void setClip(int x,int y,int width,int height){}
    }
    private static void require(boolean value,String text){if(!value)throw new AssertionError(text);}
}
