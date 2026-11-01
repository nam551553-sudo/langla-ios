package beatdz;

import com.tgame.model.Caption;
import java.io.IOException;
import java.util.Vector;

public class SelectCharScreen extends MainScreen {

    private LangLa_em[] b;
    private boolean c;
    private short d = 22;
    private int e;
    private int f;
    private int g;
    private LangLa_ii h;
    private LangLa_dz i;
    private LangLa_dz j;
    private LangLa_dz k;
    private mTextBox l;
    private int m;
    private int n;
    private int o;
    private int p;
    private LangLa_kd q;
    private LangLa_gw r;
    private LangLa_gw s;
    private byte[][] t = new byte[][]{{68, 69, 70, 71, 72}, {87, 88, 89, 90}};
    private String[] u = null;
    
    private float w = 1.0F;
    
    private int x;
    private LangLa_dz y;
    private LangLa_dz z;
    private int A;
    private Vector B = new Vector();
    private LangLa_me C = null;
    private int D = 0;
    private long E;
    

    private void drawSelectionBackground(Graphics graphics) {
        if (beatdz.SelectCharScreen.$state_SelectCharScreen().selectionBackground == null || beatdz.SelectCharScreen.$state_SelectCharScreen().selectionBackground.b == null)
            beatdz.SelectCharScreen.$state_SelectCharScreen().selectionBackground = Binary.createImage(com.badlogic.gdx.Gdx.files.internal("resource/character-selection.png").readBytes());
        float scale = Math.max((float)Graphics.e() / beatdz.SelectCharScreen.$state_SelectCharScreen().selectionBackground.c, (float)Graphics.f() / beatdz.SelectCharScreen.$state_SelectCharScreen().selectionBackground.d);
        graphics.a(beatdz.SelectCharScreen.$state_SelectCharScreen().selectionBackground, 0, 0, beatdz.SelectCharScreen.$state_SelectCharScreen().selectionBackground.c, beatdz.SelectCharScreen.$state_SelectCharScreen().selectionBackground.d, 0,
            DataCenter.gI().widthScreen / 2, DataCenter.gI().heightScreen / 2,
            Math.round(beatdz.SelectCharScreen.$state_SelectCharScreen().selectionBackground.c * scale), Math.round(beatdz.SelectCharScreen.$state_SelectCharScreen().selectionBackground.d * scale), 3);
    }
    
    public SelectCharScreen() {
        if (beatdz.DataCenter.$state_DataCenter().ar) {
            this.D = 15;
        }
        
        GameSrc.gI().setSize(AppListener.gI().canvas.getWidth(), AppListener.gI().canvas.getHeight());
        GameSrc.gI().r();
        beatdz.CheckVersionScreen.$state_CheckVersionScreen().c = true;
        this.q = new LangLa_kd(0);
        this.q.c = new String[DataCenter.gI().DataNameChar.length - 1];
        
        int var1;
        for (var1 = 0; var1 < this.q.c.length; ++var1) {
            this.q.c[var1] = DataCenter.gI().DataNameChar[var1 + 1].name;
        }
        
        this.q.d = new short[this.q.c.length];
        this.b = new LangLa_em[5];
        
        for (var1 = 0; var1 < this.b.length; ++var1) {
            this.b[var1] = new LangLa_em(1, 3, 0, 0, var1, this.b.length, DataCenter.gI().widthScreen, DataCenter.gI().heightScreen / 2);
        }
        
        try {
            this.f();
            this.a(false);
            this.z = this.a(this.h.cx - 2, this.h.cy - 27, "", this, 2005, 59);
            short var2 = -360;
            this.z.e = var2;
            this.y = this.a(this.h.cx - 2 + this.h.width - 20, this.h.cy - 27, "", this, 2006, 59);
        } catch (Exception var3) {
        }
    }
    
    private void a(int var1) {
        this.n = var1;
        this.u = mFont.c(mFont.d, (beatdz.DataCenter.$state_DataCenter().ar ? Caption.tH : Caption.rh)[this.n - (this.n >= 5 ? 5 : 0)], 110);
        this.h = new LangLa_ii((byte) 1, this.width - 119, 9, 110, 84, 14, this.u.length + 1);
        this.C = new LangLa_me(this, (LangLa_ml) null);
        LangLa_me var10000 = this.C;
        Char var2 = new Char();
        var10000.a = var2;
        this.C.a.idChar = (byte) this.n;
        this.C.a.hp = this.C.a.hpFull = 1;
        this.C.a.status = 0;
    }
    
    public void read(Message var1) throws IOException {
        byte var2;
        byte var3;
        if ((var3 = var2 = var1.reader.dis.readByte()) < 3) {
            var3 = 3;
        }
        
        this.B.clear();
        beatdz.SelectCharScreen.$state_SelectCharScreen().v = new LangLa_me[var3];
        
        try {
            for (int var7 = 0; var7 < var2; ++var7) {
                beatdz.SelectCharScreen.$state_SelectCharScreen().v[var7] = new LangLa_me(this, (LangLa_ml) null);
                LangLa_me var10000 = beatdz.SelectCharScreen.$state_SelectCharScreen().v[var7];
                Char var5 = new Char(var1.reader.dis.readInt());
                var10000.a = var5;
                beatdz.SelectCharScreen.$state_SelectCharScreen().v[var7].a.readSelection(var1);
                beatdz.SelectCharScreen.$state_SelectCharScreen().v[var7].a.hp = beatdz.SelectCharScreen.$state_SelectCharScreen().v[var7].a.hpFull = 1;
                beatdz.SelectCharScreen.$state_SelectCharScreen().v[var7].a.status = 0;
                var10000 = beatdz.SelectCharScreen.$state_SelectCharScreen().v[var7];
                boolean var8 = false;
                var10000.c = var8;
                this.B.add(beatdz.SelectCharScreen.$state_SelectCharScreen().v[var7]);
            }
        } catch (Exception var6) {
            Utlis.println(var6, "Unable to read character selection list");
        }
        
        this.p = 0;
        this.e();
    }
    
    private void d() {
        if (beatdz.SelectCharScreen.$state_SelectCharScreen().v[this.p] != null) {
            this.o = beatdz.SelectCharScreen.$state_SelectCharScreen().v[this.p].a.idClass;
            this.f();
        }
        
    }
    
    private void e() {
        if (!this.c) {
            this.h = new LangLa_ii((byte) 0, 0, DataCenter.gI().heightScreen - 80, 348, 80, 116, beatdz.SelectCharScreen.$state_SelectCharScreen().v.length);
            this.h.setXY((DataCenter.gI().widthScreen - this.h.width) / 2, this.h.cy);
            this.d();
            
            for (int var1 = 0; var1 < beatdz.SelectCharScreen.$state_SelectCharScreen().v.length; ++var1) {
                if (beatdz.SelectCharScreen.$state_SelectCharScreen().v[var1] != null) {
                    LangLa_me var10000 = beatdz.SelectCharScreen.$state_SelectCharScreen().v[var1];
                    boolean var3 = false;
                    var10000.c = var3;
                }
            }
            
        } else {
            this.a(Utlis.nextInt((int) 9));
        }
    }
    
    private void a(boolean var1) {
        this.c = var1;
        this.x = 0;
        this.f();
        if (this.i == null) {
            this.i = this.a(0, 0, Caption.ab, this, 2007, 15);
            this.i.setSize(48, 20);
        }
        
        if (this.j == null) {
            this.j = this.a(this.f + 17, this.height - 28, Caption.ac, this, 2008, 15);
            this.j.setSize(48, 20);
        }
        
        if (!var1) {
            this.p = 0;
            this.e = 20 + AppListener.gI().o;
            if (DataCenter.gI().widthScreen < 350) {
                this.e = 5;
            }
            
            this.g = 8;
            this.i.setXY(this.e, this.height - 23);
            this.j.setXY(this.e + 82, this.height - 23);
            this.r = new LangLa_gw(0, 0, DataCenter.gI().heightScreen + 100, 1, (byte) 7, beatdz.SelectCharScreen.$state_SelectCharScreen().v.length, 80);
            if (this.l != null) {
                this.b(this.l);
                this.l = null;
            }
            
            this.e();
        } else {
            this.d = 16;
            this.o = Utlis.nextInt(this.q.c.length);
            this.m = this.o == 2 ? 0 : 1;
            this.f();
            this.g = 20;
            this.e = 15 + AppListener.gI().o;
            this.f = this.width - 110;
            this.l = this.a(DataCenter.gI().widthScreen / 2 - 50, this.height - 29, 100, Caption.ad, this, 0);
            byte var2 = 12;
            this.l.a = var2;
            this.i.setXY(DataCenter.gI().widthScreen - 57, this.height - 26);
            this.j.setXY(9 + AppListener.gI().o, this.height - 26);
            this.r = new LangLa_gw(0, 0, DataCenter.gI().heightScreen + 100, 1, (byte) 7, 1, 80);
            this.s = new LangLa_gw(AppListener.gI().o, 0, 0, 2, (byte) 1, 5, 34);
            this.e();
        }
    }
    
    public void j() {
    }
    
    public void a(int var1, Object var2) {
    }
    
    public Vector c() {
        Vector var1 = new Vector();
        int var2;
        if (!this.c) {
            var1.addElement(new LangLa_jz(4000, 5, DataCenter.gI().heightScreen - (123 - this.D), 60, DataCenter.gI().heightScreen - (103 - this.D), (LangLa_ii) null, this, (Object) null));
            if (!this.r.a) {
                int center = this.h.cx + this.h.width / 2;
                var1.addElement(new LangLa_jz(3000, center - 46, this.h.cy - 80,
                    center + 46, this.h.cy + this.h.height, (LangLa_ii)null, this, (Object)null));
            }
        } else {
            var1.addElement(new LangLa_jz(2001, this.h.cx, this.h.cy, this.h.cx + this.h.width, this.h.cy + this.h.height, this.h, this));
            if (!this.s.a) {
                for (var2 = 0; var2 < this.s.b.size(); ++var2) {
                    LangLa_cz var5 = (LangLa_cz) this.s.b.elementAt(var2);
                    var1.addElement(new LangLa_jz(1000 + var2, 5 + var5.cx, 4, AppListener.gI().o + 5 + var5.width, 5 + var5.cy + var5.height, (LangLa_ii) null, this));
                    var1.addElement(new LangLa_jz(1005 + var2, 42 + var5.cx, 4, AppListener.gI().o + 42 + var5.width, 5 + var5.cy + var5.height, (LangLa_ii) null, this));
                }
            }
        }
        
        return var1;
    }
    
    public void a(LangLa_jz var1, int var2, int var3) {
        if (var1.b == 4000) {
            this.l(Caption.iv).cG.clear();
            beatdz.CheckVersionScreen.$state_CheckVersionScreen().b = true;
            AppListener.$state_AppListener().h = 50;
            LangLa_dp.a().h();
        } else {
            int var5;
            if (var1.b >= 1000 && var1.b < 2000) {
                if ((var5 = var1.b - 1000) < 9) {
                    this.a(var5);
                    this.x = 0;
                }
                
                LangLa_dp.a().h();
            } else {
                switch (var1.b) {
                    case 3000:
                        if (this.B.size() == 0) this.a(true);
                        else this.b(((this.A % this.B.size()) + this.B.size()) % this.B.size());
                        break;
                    case 3001:
                        LangLa_me var4 = (LangLa_me) var1.k;
                        this.b(this.B.indexOf(var4));
                }
                
            }
        }
    }
    
    private void f() {
        if (!this.c && beatdz.SelectCharScreen.$state_SelectCharScreen().v[this.p] != null) {
            Char var10000 = beatdz.SelectCharScreen.$state_SelectCharScreen().v[this.p].a;
            var10000 = beatdz.SelectCharScreen.$state_SelectCharScreen().v[this.p].a;
        }
        
    }
    
    public void a(int var1, Object var2, LangLa_cy var3) {
        switch (var1) {
            case 2005:
                ++this.A;
                if (this.A >= this.B.size()) {
                    this.A = 0;
                    return;
                }
                break;
            case 2006:
                --this.A;
                if (this.A < 0) {
                    this.A = this.B.size() - 1;
                    return;
                }
                break;
            case 2007:
                try {
                    if (!this.c) {
                        var1 = 0;
                        
                        for (int var5 = 0; var5 < beatdz.SelectCharScreen.$state_SelectCharScreen().v.length; ++var5) {
                            if (beatdz.SelectCharScreen.$state_SelectCharScreen().v[var5] != null) {
                                ++var1;
                            }
                        }
                        
                        if (var1 != beatdz.SelectCharScreen.$state_SelectCharScreen().v.length) {
                            this.a(true);
                            break;
                        }
                        
                        DataCenter.gI().currentScreen.showMessage(Caption.cN, -65536);
                    } else {
                        if (this.l.f().length() == 0) {
                            Binary2.a(this.l, "", "", this.l.a, this.l.b, false);
                            break;
                        }
                        
                        this.a();
                    }
                    
                    return;
                } catch (Exception var4) {
                    return;
                }
            case 2008:
                if (!this.c) {
                    this.l(Caption.cO).cG.clear();
                    beatdz.CheckVersionScreen.$state_CheckVersionScreen().b = true;
                    AppListener.$state_AppListener().h = 50;
                    return;
                }
                
                this.a(false);
        }
        
    }
    
    public void a(Graphics var1) {
        if (AppListener.$state_AppListener().h > 0) {
            --AppListener.$state_AppListener().h;
            if (AppListener.$state_AppListener().h == 0) {
                DataCenter.gI().g();
                return;
            }
        }
        
        drawSelectionBackground(var1);
        
        int var2;
        // Keep the supplied background unobstructed by the old animated cloud layer.
        
        int var3;
        int var4;
        int var5;
        LangLa_me var6;
        LangLa_cz var8;
        boolean var9;
        if (!this.c) {
            LangLa_fq.a(var1, 29, -360, 32, DataCenter.gI().heightScreen - (60 - this.D), 33);
            mFont.b(mFont.d, var1, "Exit", 36, DataCenter.gI().heightScreen - (112 - this.D), 2, -1, -2560);
            this.a(var1, this.h.cx, this.h.cy);
            
            var8 = (LangLa_cz)this.r.b.firstElement();
            var4 = this.h.width / 2;
            var2 = var8.cy + 8;
            LangLa_fq.a(var1, 16, 0, var4, var8.cy + this.h.height, 33);
            if (!this.r.a) {
                if (this.B.size() > 0) {
                    var6 = (LangLa_me)this.B.get(((this.A % this.B.size()) + this.B.size()) % this.B.size());
                    var6.a.setXY(var4, var2);
                    if (!var6.c) { var6.c = true; var6.a(); }
                    if (var6.b.p()) {
                        mFont.b(mFont.e, var1, var6.a.name, var4, var6.a.cy - 56, 2, -1, -16777216);
                        mFont.b(mFont.d, var1, Caption.ag + var6.a.level(), var4, var6.a.cy - 66, 2, -2560, -16777216);
                        LangLa_fq.a(var1, 642, 0, var6.a.cx, var6.a.cy, 3);
                        var6.a.a(var1);
                    } else var6.b.a(var1);
                } else {
                    LangLa_fq.a(var1, 57, 0, var4, var2 + 40, 3);
                    mFont.b(mFont.e, var1, Caption.M, var4, var2 + 55, 2, -1, -16777216);
                }
            }
        } else {
            var8 = (LangLa_cz) this.r.b.firstElement();
            LangLa_fq.a(var1, 16, 0, DataCenter.gI().widthScreen / 2, DataCenter.gI().heightScreen + var8.cy, 33);
            
            for (var3 = 0; var3 < this.s.b.size(); ++var3) {
                var8 = (LangLa_cz) this.s.b.elementAt(var3);
                LangLa_fq.a(var1, this.t[0][var3], 0, 5 + var8.cx, 6 + var8.cy, 20);
                if (var3 < 4) {
                    LangLa_fq.a(var1, this.t[1][var3], 0, 45 + var8.cx, 6 + var8.cy, 20);
                }
            }
            
            if (this.n < 5) {
                var8 = (LangLa_cz) this.s.b.get(this.n);
                LangLa_fq.a(var1, 97, 0, 4 + var8.cx, 5 + var8.cy, 20);
            } else {
                var8 = (LangLa_cz) this.s.b.get(this.n - 5);
                LangLa_fq.a(var1, 97, 0, 44 + var8.cx, 5 + var8.cy, 20);
            }
            
            if (this.x < this.h.width + 10 || this.x < this.h.height + 10) {
                this.x += 10;
            }
            
            var3 = this.x;
            var4 = this.x;
            if (var3 > this.h.width + 10) {
                var3 = this.h.width + 10;
            }
            
            if (var4 > this.h.height + 10) {
                var4 = this.h.height + 10;
            }
            
            this.a(var1, this.h.cx - 5, this.h.cy - 5, var3, var4, 61, 55, 56);
            if (!this.r.a && !this.s.a && this.x >= this.h.width + 10 && this.x >= this.h.height + 10) {
                var2 = DataCenter.gI().widthScreen / 2;
                var5 = DataCenter.gI().heightScreen - 72;
                (var6 = this.C).a.setXY(var2, var5);
                if (!var6.c) {
                    var9 = true;
                    var6.c = var9;
                    var6.a();
                }
                
                if (var6.b.p()) {
                    LangLa_fq.a(var1, 642, 0, var6.a.cx, var6.a.cy, 3);
                    var6.a.a(var1);
                } else {
                    var6.b.a(var1);
                }
                
                this.a(var1, this.h);
                mFont.a((mFont) mFont.e, (Graphics) var1, (beatdz.DataCenter.$state_DataCenter().ar ? Caption.tG : Caption.su)[this.n], 3, this.h.h / 2, 0, -3407617, 0);
                
                for (var2 = 0; var2 < this.u.length; ++var2) {
                    if (this.h.b(var2)) {
                        mFont.a((mFont) mFont.d, (Graphics) var1, this.u[var2], 3, (var2 + 1) * this.h.h + this.h.h / 2, 0, -6488, 0);
                    }
                }
                
                this.b(var1);
            }
        }
        
        if (beatdz.LangLa_cz.$state_LangLa_cz().cZ) {
            mFont.a(mFont.d, var1, Caption.qG, DataCenter.gI().widthScreen / 2, DataCenter.gI().heightScreen - 52, 2, -2560, 2, 1);
        }
        
        LangLa_dp.a().a(-1);
    }
    
    public void b() {
        int var5;
        try {
            long var1 = Utlis.time();
            if (beatdz.DataCenter.$state_DataCenter().aR > 0 && var1 - this.E > 5000L) {
                this.E = var1;
                if (Char.gI().name.length() == 0 && this.B.size() > 0) {
                    beatdz.DataCenter.$state_DataCenter().aR = 2;
                    this.b(0);
                } else {
                    for (var5 = 0; var5 < this.B.size(); ++var5) {
                        if (((LangLa_me) this.B.get(var5)).a.name.toLowerCase().equals(Char.gI().name.toLowerCase())) {
                            beatdz.DataCenter.$state_DataCenter().aR = 2;
                            this.b(var5);
                            break;
                        }
                    }
                }
            }
        } catch (Exception var4) {
        }
        
        for (var5 = 0; var5 < this.b.length; ++var5) {
            this.b[var5].o();
        }
        
        if (this.h != null) {
            this.h.a();
        }
        
        if (this.r != null) {
            this.r.c = 5;
            this.r.a();
        }
        
        if (this.s != null) {
            this.s.c = 5;
            this.s.a();
        }
        
        if (!this.c && this.r != null && !this.r.a) {
            if (this.B.size() > 1) {
                this.z.b(false);
                this.y.b(false);
            } else {
                this.z.b(true);
                this.y.b(true);
            }
        } else {
            this.z.b(true);
            this.y.b(true);
        }
        
        if (this.r != null && !this.r.a && this.s != null && !this.s.a) {
            if (this.l != null) {
                this.l.b(false);
            }
            
            if (this.j != null) {
                this.j.b(!this.c);
            }
            
            if (this.i != null) {
                this.i.b(!this.c);
            }
            
            if (this.k != null) {
                this.k.b(this.c);
            }
        } else {
            if (this.l != null) {
                this.l.b(true);
            }
            
            if (this.j != null) {
                this.j.b(true);
            }
            
            if (this.i != null) {
                this.i.b(true);
            }
            
            if (this.k != null) {
                this.k.b(this.c);
            }
        }
        
        for (var5 = 0; var5 < beatdz.SelectCharScreen.$state_SelectCharScreen().v.length; ++var5) {
            if (beatdz.SelectCharScreen.$state_SelectCharScreen().v[var5] != null) {
                beatdz.SelectCharScreen.$state_SelectCharScreen().v[var5].a.setXY(-100, -100);
                beatdz.SelectCharScreen.$state_SelectCharScreen().v[var5].a(var5);
            }
        }
        
        if (this.C != null) {
            byte var3 = 3;
            this.C.a(var3);
            this.C.a.ag = 2;
        }
        
    }
    
    public void p() {
        if (this.cO.a[12]) {
            this.a(!this.c);
        }
        
    }
    
    public void a() {
        Message var1 = null;
        boolean var5 = false;
        
        label76:
        {
            try {
                var5 = true;
                
                String var2;
                for (var2 = this.l.f().trim(); var2.contains("  "); var2 = var2.replaceAll("  ", " ")) {
                }
                
                this.l.a(var2);
                (var1 = Message.b((byte) -128)).writeByte(this.n);
                var1.writeUTF(var2);
                var1.send();
                this.L();
                var5 = false;
                break label76;
            } catch (Exception var6) {
                Utlis.println(var6);
                var5 = false;
            } finally {
                if (var5) {
                    if (var1 != null) {
                        var1.close();
                    }
                    
                }
            }
            
            if (var1 != null) {
                var1.close();
                return;
            }
            
            return;
        }
        
        var1.close();
    }
    
    private void b(int var1) {
        Message var2 = null;
        
        while (true) {
            boolean var5 = false;
            
            try {
                var5 = true;
                DataCenter.gI();
                if (!DataCenter.a()) {
                    Thread.sleep(100L);
                    continue;
                }
                
                if (DataCenter.gI().aG) {
                    DataCenter.gI().aG = false;
                    LangLa_cz.T();
                }
                
                (var2 = Message.d((byte) -127)).writeByte(var1);
                if (DataCenter.gI().aP.typeServer == 5) {
                    var2.writeInt(Integer.parseInt(DataCenter.gI().aP.arrayData[1].trim()));
                }
                var2.send();
                this.L();
                var5 = false;
                break;
            } catch (Exception var6) {
                Utlis.println(var6);
                var5 = false;
            } finally {
                if (var5) {
                    if (var2 != null) {
                        var2.close();
                    }
                    
                }
            }
            
            if (var2 != null) {
                var2.close();
                return;
            }
            
            return;
        }
        
        var2.close();
    }
    
    public void G() {
        if (!this.c) {
            this.l(Caption.cO).cG.clear();
            beatdz.CheckVersionScreen.$state_CheckVersionScreen().b = true;
            AppListener.$state_AppListener().h = 50;
        } else {
            this.a(false);
        }
    }

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public LangLa_me[] v;
public String a;
public mImage selectionBackground;
public void initialize() {
this.v = new LangLa_me[3];
this.a = "";
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.SelectCharScreen");
public static SessionState $state_SelectCharScreen() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
