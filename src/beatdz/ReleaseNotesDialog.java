package beatdz;

import com.badlogic.gdx.Gdx;
import java.util.Vector;

/** Fetch notes without blocking rendering; all platforms share the same published text. */
public final class ReleaseNotesDialog extends LangLa_fo {
    private Vector lines = new Vector();
    private LangLa_ii scroll;
    private boolean closed;
    private boolean busy;
    private String title = "Phiên bản có gì mới?";
    public ReleaseNotesDialog(MainScreen screen) {
        p = screen; a(310,220); r=false;
        this.a(width-79,height-29,"Tải lại",this,100,-8);
        setText("Đang tải thông tin cập nhật...");
        load();
    }
    public ReleaseNotesDialog(MainScreen screen, String title, String text) {
        p = screen;
        this.title = title;
        a(310,220);
        r = false;
        setText(text);
    }
    private void setText(String text) {
        lines.clear();
        for (String line : text.replace("\r","").split("\n",-1)) {
            if(line.isEmpty()) lines.add(" ");
            else lines.addAll(mFont.a(mFont.d,line,width-28));
        }
        scroll=new LangLa_ii((byte)1,12,a_()+7,width-24,height-a_()-45,15,Math.max(1,lines.size()));
        R();
    }
    private void load() {
        if(busy) return; busy=true;
        Thread worker=new Thread(MultiSession.bind(() -> {
            String text;
            try {
                byte[] data=HttpDownloads.bytes(com.langla.config.Endpoints.UPDATE_BASE+"release-notes.txt?t="+System.currentTimeMillis(),10000,65536);
                text=new String(data,"UTF-8").replace("\uFEFF","").trim();
                if(text.isEmpty()||text.startsWith("<"))throw new java.io.IOException("Invalid notes");
            } catch(Exception error) {
                text="Chưa tải được thông tin cập nhật. Kiểm tra kết nối và nhấn Tải lại.";
            }
            final String result=text;
            Gdx.app.postRunnable(MultiSession.bind(() -> {busy=false;if(!closed)setText(result);}));
        }),"release-notes");
        worker.setDaemon(true);worker.start();
    }
    public void a(Graphics graphics) {
        a(graphics,cx,cy,width,height,title,(byte)2,false);
        a(graphics,scroll);
        for(int n=0;n<lines.size();n++)mFont.a(mFont.d,graphics,(String)lines.get(n),0,n*15,0,-1);
        b(graphics);
    }
    public void b(){scroll.a();}
    public Vector c(){Vector regions=super.c();if(scroll!=null)regions.add(scroll.a(5001,this));return regions;}
    public void a(LangLa_jz event,int x,int y){if(event.b==100)load();}
    public void a(int id,Object value){}
    public void a(int id,Object value,LangLa_cy source){}
    public void d(){closed=true;super.d();}
}
