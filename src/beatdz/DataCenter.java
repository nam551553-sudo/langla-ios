package beatdz;

import beatdz.*;

import java.util.Iterator;
import com.tgame.model.Caption;
import java.util.Collection;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import java.util.Arrays;
import java.util.Vector;
import java.util.Hashtable;

public class DataCenter {
    public int equipmentBalanceRevision;

    public String ipServer;
    public int portServer;
    public String c;
    public int d;
    public int e;
    public boolean f;
    public boolean INPUT_CAPTCHA;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int widthScreen;
    public int heightScreen;
    public int q;
    public int r;
    public int zoomLevelScreen;
    public int typeArr;
    public int zoomLevel;
    public String v;
    public int typeOS;
    public int VER1;
    public int VER2;
    private boolean bf;
    public float z;
    public int A;
    public int B;
    public int C;
    public int D;
    public LangLa_gv[] E;
    public LangLa_jr[] F;
    public LangLa_jt[] G;
    public LangLa_js[] H;
    public LangLa_hj[] I;
    public LangLa_hn[] J;
    public Hashtable K;
    public LangLa_jy[] L;
    public NpcTemplate[] NpcTemplate;
    public MobTemplate[] MobTemplate;
    public MapTemplate[] MapTemplate;
    public DataTemplateAchievement[] DataTemplateAchievement;
    public DataTaskDay[] DataTaskDay;
    public Task[] Task;
    public DataNameChar[] DataNameChar;
    public DataIconChar[] DataIconChar;
    public DataNameClass[] DataNameClass;
    public ItemTemplate[] ItemTemplate;
    public ItemOptionTemplate[] ItemOptionTemplate;
    public SkillTemplate[] SkillTemplate;
    public SkillClan[] SkillClan;
    public Vector vSkillClan;
    public EffectTemplate[] EffectTemplate;
    public Skill[] Skill;
    public DataTypeItemBody[] DataTypeItemBody;
    public short[][] dataWayPoint;
    public int[][] dataGiftQuaySo;
    public byte[][] af;
    public Vector ag;
    public Vector ah;
    public Vector ai;
    public Hashtable aj;
    public Hashtable ak;
    public Hashtable al;
    public Hashtable am;
    public Hashtable an;
    public ArrayServer[] arrayServers;
    public Server selectServer;
    
    public MainScreen currentScreen;
    
    
    
    
    public int[] au;
    public int[] bacKhoaGhepDa;
    public int[] bacKhoaUpgradeVuKhi;
    public int[] bacKhoaUpgradeTrangBi;
    public int[] bacKhoaUpgradePhuKien;
    public int[] ngocKhamUpgrade;
    public long[] pointGhepDa;
    public long[] pointUpgradeVuKhi;
    public long[] pointUpgradeTrangBi;
    public long[] pointUpgradePhuKien;
    public String[][] dataTreoCho;
    public long[] exps;
    public boolean aG;
    public boolean aH;
    public boolean aI;
    public boolean aJ;
    public boolean aK;
    public boolean aL;
    public boolean aM;
    public boolean aN;
    public LangLa_gg aO;
    public Server aP;
    
    
    public int aS;
    public int aT;
    public String aU;
    public String aV;
    public String aW;
    public String aX;
    public String aY;
    public String aZ;
    public volatile boolean ba;
    public volatile boolean bb;
    public volatile boolean startupWarmupDone;
    public volatile String startupPhase = "Khởi tạo";
    public volatile String startupFailure;
    public boolean bc;
    
    

    public static boolean a() {
        return gI().ba && gI().bb;
    }

    public boolean b() {
        return this.bf || Gdx.app.getType() == Application.ApplicationType.iOS;
    }

    public void c() {
        this.aH = false;
    }

    private static void b(MainScreen mainScreen) {
        synchronized (beatdz.DataCenter.$state_DataCenter().bh) {
            beatdz.DataCenter.$state_DataCenter().bh.notify();
        }
    }

    public DataCenter() {
        this.ipServer = ClientConfig.SERVER_IP;
        this.portServer = 2907;
        this.c = "";
        this.f = false;
        this.v = "abcdefg";
        this.typeOS = 0;
        this.VER1 = 81;
        this.VER2 = 131;
        this.bf = true;
        this.z = 1.0f;
        this.vSkillClan = new Vector();
        this.ag = new Vector();
        this.ah = new Vector();
        this.ai = new Vector();
        this.aj = new Hashtable();
        this.ak = new Hashtable();
        this.al = new Hashtable();
        this.am = new Hashtable();
        this.an = new Hashtable();
        this.dataTreoCho = new String[2][];
       // this.aU = "http://dl.langla.me/";
        this.aU = ClientConfig.DATA_URL;
        this.aV = this.aU + "checkpc.txt";
        this.aW = this.aU + "checkandroid.txt";
        this.aX = this.aU + "checkios.txt";
        this.aY = "img/zoom";
        this.aZ = "";
    }

    public static DataCenter gI() {
        if (beatdz.DataCenter.$state_DataCenter().bg == null) {
            beatdz.DataCenter.$state_DataCenter().bg = new DataCenter();
        }
        return beatdz.DataCenter.$state_DataCenter().bg;
    }

    public void createScreen(int n, int o, int p3) {
        this.n = 0;
        if (Gdx.app.getType() == Application.ApplicationType.Android) {
            this.typeOS = 0;
        } else if (Gdx.app.getType() == Application.ApplicationType.iOS) {
            this.typeOS = 1;
        } else {
            this.typeOS = 2;
        }
        this.widthScreen = o;
        this.heightScreen = p3;
        this.currentScreen = new CheckVersionScreen();
        float n2 = gI().widthScreen / 640.0f;
        float n3 = gI().heightScreen / 360.0f;
        float n4 = (n2 > n3) ? n2 : n3;
        gI().q = (int) (640.0f * n4 * gI().zoomLevel);
        gI().r = (int) (360.0f * n4 * gI().zoomLevel);
        this.aH = false;
        if (this.aO == null) {
            this.aO = new LangLa_gg(this.currentScreen);
        }
        AppListener.b();
    }

    public void a(boolean b) {
        boolean b2 = false;
        this.bb = b2;
        this.ba = b2;
        this.startupWarmupDone = false;
        this.startupFailure = null;
        Runnable warmup = MultiSession.bind(new LangLa_fy(this, b));
        if (Gdx.app.getType() == Application.ApplicationType.iOS) {
            // Cached preparation is local-only. Native image/font state belongs to the render thread.
            Gdx.app.postRunnable(warmup);
        } else new Thread(warmup, "startup-cache").start();
    }

    private void a(Reader reader) throws java.io.IOException {
        byte[][] af = new byte[reader.dis.readByte()][];
        for (int i = 0; i < af.length; ++i) {
            af[i] = new byte[reader.dis.readByte()];
            for (int j = 0; j < af[i].length; ++j) {
                af[i][j] = reader.dis.readByte();
            }
        }
        if (this.af == null || this.af.length == 0) {
            this.af = af;
        }
    }

    private void b(Reader reader) throws java.io.IOException {
        LangLa_hj[] i = new LangLa_hj[reader.dis.readShort()];
        for (int j = 0; j < i.length; ++j) {
            i[j] = new LangLa_hj();
            i[j].a = reader.dis.readByte();
            i[j].b = reader.dis.readByte();
            i[j].c = reader.dis.readByte();
            i[j].d = reader.dis.readByte();
            i[j].e = reader.dis.readBoolean();
            i[j].f = reader.dis.readBoolean();
            i[j].g = new short[reader.dis.readByte()];
            for (int k = 0; k < i[j].g.length; ++k) {
                addVec(i[j].g[k] = reader.dis.readShort());
            }
            i[j].h = new short[reader.dis.readByte()][];
            for (int l = 0; l < i[j].h.length; ++l) {
                i[j].h[l] = new short[reader.dis.readByte()];
                for (int n = 0; n < i[j].h[l].length; ++n) {
                    i[j].h[l][n] = reader.dis.readShort();
                }
            }
        }
        if (this.I == null || this.I.length == 0) {
            this.I = i;
        }
    }

    private void c(Reader reader) throws java.io.IOException {
        Vector<Short> c = new Vector<Short>();
        LangLa_hn[] j = new LangLa_hn[reader.dis.readShort()];
        for (int i = 0; i < j.length; ++i) {
            j[i] = new LangLa_hn();
            j[i].a = reader.dis.readByte();
            j[i].b = new LangLa_ho[reader.readUnsignedByte()];
            for (int k = 0; k < j[i].b.length; ++k) {
                j[i].b[k] = new LangLa_ho();
                j[i].b[k].a = reader.dis.readShort();
                if (!c.contains(j[i].b[k].a)) {
                    c.add(j[i].b[k].a);
                }
                addVec(j[i].b[k].a);
                j[i].b[k].b = reader.dis.readByte();
                if (j[i].b[k].b >= 30) {
                    LangLa_ho langLa_ho = j[i].b[k];
                    langLa_ho.b -= 30;
                    j[i].b[k].c = reader.dis.readShort();
                    j[i].b[k].d = reader.dis.readShort();
                } else if (j[i].b[k].b >= 20) {
                    LangLa_ho langLa_ho2 = j[i].b[k];
                    langLa_ho2.b -= 20;
                    j[i].b[k].d = reader.dis.readShort();
                } else if (j[i].b[k].b >= 10) {
                    LangLa_ho langLa_ho3 = j[i].b[k];
                    langLa_ho3.b -= 10;
                    j[i].b[k].c = reader.dis.readShort();
                }
            }
        }
        if (this.J == null || this.J.length == 0) {
            this.J = j;
            this.ah.clear();
            this.ah.addAll(c);
        }
    }

    private void d(Reader reader) throws java.io.IOException {
        Hashtable<Short, LangLa_iw> k = new Hashtable<Short, LangLa_iw>();
        for (short short1 = reader.dis.readShort(), n = 0; n < short1; ++n) {
            LangLa_iw value;
            (value = new LangLa_iw()).a = reader.dis.readShort();
            value.b = reader.dis.readShort();
            value.c = reader.dis.readByte();
            value.d = new LangLa_ix[reader.readUnsignedByte()][];
            for (int i = 0; i < value.d.length; ++i) {
                value.d[i] = new LangLa_ix[reader.readUnsignedByte()];
                for (int j = 0; j < value.d[i].length; ++j) {
                    value.d[i][j] = new LangLa_ix();
                    value.d[i][j].a = reader.dis.readByte();
                    value.d[i][j].b = reader.dis.readByte();
                    if (value.d[i][j].b >= 30) {
                        LangLa_ix langLa_ix = value.d[i][j];
                        langLa_ix.b -= 30;
                        value.d[i][j].c = reader.dis.readShort();
                        value.d[i][j].d = reader.dis.readByte();
                        value.d[i][j].e = reader.dis.readByte();
                        value.d[i][j].f = reader.dis.readShort();
                        value.d[i][j].g = reader.dis.readByte();
                        value.d[i][j].h = reader.dis.readByte();
                    } else if (value.d[i][j].b >= 20) {
                        LangLa_ix langLa_ix2 = value.d[i][j];
                        langLa_ix2.b -= 20;
                        value.d[i][j].f = reader.dis.readShort();
                        value.d[i][j].g = reader.dis.readByte();
                        value.d[i][j].h = reader.dis.readByte();
                    } else if (value.d[i][j].b >= 10) {
                        LangLa_ix langLa_ix3 = value.d[i][j];
                        langLa_ix3.b -= 10;
                        value.d[i][j].c = reader.dis.readShort();
                        value.d[i][j].d = reader.dis.readByte();
                        value.d[i][j].e = reader.dis.readByte();
                    }
                }
            }
            k.put(value.a, value);
        }
        if (this.K == null || this.K.size() == 0) {
            this.K = k;
        }
    }

    private void e(Reader reader) throws java.io.IOException {
        LangLa_jy[] l = new LangLa_jy[reader.dis.readShort()];
        for (int i = 0; i < l.length; ++i) {
            l[i] = new LangLa_jy();
            l[i].a = reader.dis.readByte();
            l[i].b = new LangLa_jx[reader.readUnsignedByte()];
            for (int j = 0; j < l[i].b.length; ++j) {
                l[i].b[j] = new LangLa_jx();
                l[i].b[j].a = reader.dis.readShort();
                l[i].b[j].b = reader.dis.readByte();
                byte byte1;
                if ((byte1 = reader.dis.readByte()) >= 30) {
                    byte1 -= 30;
                    l[i].b[j].d = reader.dis.readByte();
                    l[i].b[j].e = reader.dis.readByte();
                } else if (byte1 >= 20) {
                    byte1 -= 20;
                    l[i].b[j].e = reader.dis.readByte();
                } else if (byte1 >= 10) {
                    byte1 -= 10;
                    l[i].b[j].d = reader.dis.readByte();
                }
                l[i].b[j].c = (byte1 != 0);
            }
        }
        if (this.L == null || this.L.length == 0) {
            this.L = l;
        }
    }

    private void f(Reader reader) throws java.io.IOException {
        short[][] dataWayPoint = new short[reader.dis.readShort()][14];
        for (int index = 0; index < dataWayPoint.length; ++index) {
            dataWayPoint[index][0] = reader.dis.readShort();
            dataWayPoint[index][1] = reader.dis.readShort();
            dataWayPoint[index][2] = reader.dis.readShort();
            dataWayPoint[index][3] = reader.dis.readShort();
            dataWayPoint[index][4] = reader.dis.readShort();
            dataWayPoint[index][10] = reader.dis.readShort();
            dataWayPoint[index][11] = reader.dis.readShort();
            dataWayPoint[index][5] = reader.dis.readShort();
            dataWayPoint[index][6] = reader.dis.readShort();
            dataWayPoint[index][7] = reader.dis.readShort();
            dataWayPoint[index][8] = reader.dis.readShort();
            dataWayPoint[index][9] = reader.dis.readShort();
            dataWayPoint[index][12] = reader.dis.readShort();
            dataWayPoint[index][13] = reader.dis.readShort();
        }
        if (this.dataWayPoint == null || this.dataWayPoint.length == 0) {
            this.dataWayPoint = dataWayPoint;
        }
    }

    private static Hashtable getHashtable1(Reader reader) throws java.io.IOException {
        Hashtable<Short, LangLa_et> hashtable = new Hashtable<Short, LangLa_et>();
        for (short short1 = reader.dis.readShort(), n = 0; n < short1; ++n) {
            for (short short2 = reader.dis.readShort(), n2 = 0; n2 < short2; ++n2) {
                hashtable.put(new Short(reader.dis.readShort()), new LangLa_et(n, reader.readUnsignedByte(), reader.readUnsignedByte(), reader.dis.readShort(), reader.dis.readShort()));
            }
        }
        return hashtable;
    }

    private static Hashtable getHashtable2(Reader reader) throws java.io.IOException {
        Hashtable<Short, LangLa_et> hashtable = new Hashtable<Short, LangLa_et>();
        for (short short1 = reader.dis.readShort(), n = 0; n < short1; ++n) {
            hashtable.put(new Short(reader.dis.readShort()), new LangLa_et((short) (-1), (short) 0, (short) 0, reader.dis.readShort(), reader.dis.readShort()));
        }
        return hashtable;
    }

    private static void addVec(short n) {
        if (!beatdz.DataCenter.$state_DataCenter().be.contains(n)) {
            beatdz.DataCenter.$state_DataCenter().be.addElement(n);
        }
    }

    public void readArrDataGame2(Message msg) {
        try {
            ItemOptionTemplate[] ItemOptionTemplate = new ItemOptionTemplate[msg.readShort()];
            for (int index = 0; index < ItemOptionTemplate.length; ++index) {
                ItemOptionTemplate[index] = new ItemOptionTemplate(index);
                ItemOptionTemplate[index].name = Caption.check(msg.reader.readUTF());
                ItemOptionTemplate[index].type = msg.readByte();
                ItemOptionTemplate[index].level = msg.readByte();
                ItemOptionTemplate[index].strOption = msg.reader.readUTF();
            }
            this.ItemOptionTemplate = ItemOptionTemplate;
            EffectTemplate[] EffectTemplate = new EffectTemplate[msg.readByte()];
            for (int index = 0; index < EffectTemplate.length; ++index) {
                EffectTemplate[index] = new EffectTemplate(index);
                EffectTemplate[index].name = msg.reader.readUTF();
                EffectTemplate[index].detail = msg.reader.readUTF();
                EffectTemplate[index].type = msg.reader.readUnsignedByte();
                EffectTemplate[index].idIcon = msg.readShort();
                EffectTemplate[index].idMob = msg.readShort();
            }
            this.EffectTemplate = EffectTemplate;
            ItemTemplate[] ItemTemplate = new ItemTemplate[msg.readShort()];
            for (int index = 0; index < ItemTemplate.length; ++index) {
                ItemTemplate[index] = new ItemTemplate(index);
                ItemTemplate[index].name = Caption.check(msg.reader.readUTF());
                ItemTemplate[index].detail = msg.reader.readUTF();
                ItemTemplate[index].isXepChong = msg.readBoolean();
                ItemTemplate[index].gioiTinh = msg.readByte();
                ItemTemplate[index].type = msg.readByte();
                ItemTemplate[index].idClass = msg.readByte();
                ItemTemplate[index].idIcon = msg.readShort();
                ItemTemplate[index].levelNeed = msg.reader.readUnsignedByte();
                ItemTemplate[index].taiPhuNeed = msg.readUnsignedShort();
                ItemTemplate[index].idMob = msg.readShort();
                ItemTemplate[index].idChar = msg.readShort();
//                System.out.println( ItemTemplate[index]);
            }
            this.ItemTemplate = ItemTemplate;
            this.a(msg.reader);
            this.b(msg.reader);
            this.c(msg.reader);
            this.e(msg.reader);
            this.d(msg.reader);
            this.f(msg.reader);
        } catch (Exception ex) {
            Utlis.println(ex);
        } finally {
            if (msg != null) {
                msg.close();
            }
        }
    }

    public void readArrDataGame(boolean b) {
        readArrDataGame(b, 0);
    }

    public void readCachedGameData(boolean b) {
        // A bad cache must not perform HTTP recovery on the render thread.
        readArrDataGame(b, 1);
    }

    private void readArrDataGame(boolean b, int retries) {
        Reader reader = null;
        try {
            if ((reader = Binary.createReader("arr_data_game")) == null) {
                return;
            }
            this.DataIconChar = new DataIconChar[reader.dis.readByte()];
            for (int i = 0; i < this.DataIconChar.length; ++i) {
                this.DataIconChar[i] = new DataIconChar(i);
                this.DataIconChar[i].idIcon = reader.dis.readShort();
            }
            this.DataNameClass = new DataNameClass[reader.dis.readByte()];
            for (int j = 0; j < this.DataNameClass.length; ++j) {
                this.DataNameClass[j] = new DataNameClass(j);
                this.DataNameClass[j].name = reader.readUTF();
            }
            this.DataNameChar = new DataNameChar[reader.dis.readByte()];
            for (int k = 0; k < this.DataNameChar.length; ++k) {
                this.DataNameChar[k] = new DataNameChar(k);
                this.DataNameChar[k].name = reader.readUTF();
                this.DataNameChar[k].b = reader.dis.readByte();
                this.DataNameChar[k].d = reader.dis.readShort();
            }
            this.DataTemplateAchievement = new DataTemplateAchievement[reader.readUnsignedByte()];
            for (int l = 0; l < this.DataTemplateAchievement.length; ++l) {
                this.DataTemplateAchievement[l] = new DataTemplateAchievement();
                this.DataTemplateAchievement[l].id = reader.dis.readByte();
                this.DataTemplateAchievement[l].name = reader.readUTF();
                this.DataTemplateAchievement[l].c = reader.dis.readInt();
                this.DataTemplateAchievement[l].amountExp = reader.dis.readInt();
                this.DataTemplateAchievement[l].amountVangKhoa = reader.dis.readInt();
                this.DataTemplateAchievement[l].amountBac = reader.dis.readInt();
                this.DataTemplateAchievement[l].amountBacKhoa = reader.dis.readInt();
                this.DataTemplateAchievement[l].strItem = reader.readUTF();
            }
            this.Task = new Task[reader.dis.readShort()];
            for (int a2 = 0; a2 < this.Task.length; ++a2) {
                this.Task[a2] = new Task();
                this.Task[a2].id = a2;
                this.Task[a2].name = reader.readUTF();
                this.Task[a2].levelNeed = reader.dis.readShort();
                this.Task[a2].idNpc = reader.dis.readShort();
                this.Task[a2].idMap = reader.dis.readShort();
                this.Task[a2].x = reader.dis.readShort();
                this.Task[a2].y = reader.dis.readShort();
                this.Task[a2].STR1 = reader.readUTF();
                this.Task[a2].STR2 = reader.readUTF();
                this.Task[a2].STR3 = reader.readUTF();
                this.Task[a2].amountExp = reader.dis.readInt();
                this.Task[a2].amountVangKhoa = reader.dis.readInt();
                this.Task[a2].amountBac = reader.dis.readInt();
                this.Task[a2].amountBacKhoa = reader.dis.readInt();
                this.Task[a2].strItem = reader.readUTF();
                for (byte byte1 = reader.dis.readByte(), b2 = 0; b2 < byte1; ++b2) {
                    Step obj;
                    (obj = new Step()).id = reader.dis.readByte();
                    obj.name = reader.readUTF();
                    obj.idItem = reader.dis.readShort();
                    obj.idNpc = reader.dis.readShort();
                    obj.idMob = reader.dis.readShort();
                    obj.idMap = reader.dis.readShort();
                    obj.x = reader.dis.readShort();
                    obj.y = reader.dis.readShort();
                    obj.require = reader.dis.readShort();
                    obj.STR = reader.readUTF();
                    obj.STR_ITEM = reader.readUTF();
                    this.Task[a2].vStep.addElement(obj);
                }
            }
            this.DataTaskDay = new DataTaskDay[reader.readUnsignedByte()];
            for (int n = 0; n < this.DataTaskDay.length; ++n) {
                this.DataTaskDay[n] = new DataTaskDay();
                this.DataTaskDay[n].id = reader.dis.readByte();
                this.DataTaskDay[n].name = reader.readUTF();
                this.DataTaskDay[n].c = reader.dis.readShort();
            }
            MapTemplate[] o = new MapTemplate[reader.dis.readShort()];
            for (int n2 = 0; n2 < o.length; ++n2) {
                o[n2] = new MapTemplate(n2);
                o[n2].name = reader.readUTF();
                o[n2].typeBlockMap = reader.readUnsignedByte();
                o[n2].type = reader.dis.readByte();
            }
            this.MapTemplate = o;
            ItemOptionTemplate[] w = new ItemOptionTemplate[reader.dis.readShort()];
            for (int n3 = 0; n3 < w.length; ++n3) {
                w[n3] = new ItemOptionTemplate(n3);
                w[n3].name = Caption.check(reader.readUTF());
                w[n3].type = reader.dis.readByte();
                w[n3].level = reader.dis.readByte();
                w[n3].strOption = reader.readUTF();
            }
            if (this.ItemOptionTemplate == null || this.ItemOptionTemplate.length == 0) {
                this.ItemOptionTemplate = w;
            }
            EffectTemplate[] aa = new EffectTemplate[reader.dis.readByte()];
            for (int n4 = 0; n4 < aa.length; ++n4) {
                aa[n4] = new EffectTemplate(n4);
                aa[n4].name = reader.readUTF();
                aa[n4].detail = reader.readUTF();
                aa[n4].type = reader.readUnsignedByte();
                aa[n4].idIcon = reader.dis.readShort();
                aa[n4].idMob = reader.dis.readShort();
            }
            if (this.EffectTemplate == null || this.EffectTemplate.length == 0) {
                this.EffectTemplate = aa;
            }
            ItemTemplate[] v = new ItemTemplate[reader.dis.readShort()];
            for (int n5 = 0; n5 < v.length; ++n5) {
                v[n5] = new ItemTemplate(n5);
                v[n5].name = Caption.check(reader.readUTF());
                v[n5].detail = reader.readUTF();
                v[n5].isXepChong = reader.dis.readBoolean();
                v[n5].gioiTinh = reader.dis.readByte();
                v[n5].type = reader.dis.readByte();
                v[n5].idClass = reader.dis.readByte();
                v[n5].idIcon = reader.dis.readShort();
                v[n5].levelNeed = reader.readUnsignedByte();
                v[n5].taiPhuNeed = reader.dis.readUnsignedShort();
                v[n5].idMob = reader.dis.readShort();
                v[n5].idChar = reader.dis.readShort();
            }
            if (this.ItemTemplate == null || this.ItemTemplate.length == 0) {
                this.ItemTemplate = v;
            }
            this.MobTemplate = new MobTemplate[reader.dis.readShort()];
            for (int n6 = 0; n6 < this.MobTemplate.length; ++n6) {
                this.MobTemplate[n6] = new MobTemplate(n6);
                this.MobTemplate[n6].g = reader.dis.readShort();
                this.MobTemplate[n6].name = reader.readUTF();
                this.MobTemplate[n6].detail = reader.readUTF();
                this.MobTemplate[n6].speedMove = reader.readUnsignedByte();
                this.MobTemplate[n6].type = reader.dis.readByte();
                this.MobTemplate[n6].speedMoveByte = reader.dis.readByte();
                this.MobTemplate[n6].p = reader.dis.readByte();
                this.MobTemplate[n6].indexData = reader.dis.readShort();
                this.MobTemplate[n6].timeThuHoach = reader.dis.readShort();
                //     this.MobTemplate[n6].speedMove = 0;
                //     this.MobTemplate[n6].speedMoveByte=0;
                MobTemplate mobTemplate = this.MobTemplate[n6];
                String utf = reader.readUTF();
                String utf2 = reader.readUTF();
                String s = utf;
                MobTemplate mobTemplate2 = mobTemplate;
                String[] a3 = Utlis.split(s, ",");
                mobTemplate2.k = new int[a3.length];
                for (int n7 = 0; n7 < a3.length; ++n7) {
                    mobTemplate2.k[n7] = Integer.parseInt(a3[n7]);
                }
                String[] a4 = Utlis.split(utf2, ",");
                mobTemplate2.l = new int[a4.length];
                for (int n8 = 0; n8 < a4.length; ++n8) {
                    mobTemplate2.l[n8] = Integer.parseInt(a4[n8]);
                }
            }
            this.NpcTemplate = new NpcTemplate[reader.dis.readShort()];
            for (int n9 = 0; n9 < this.NpcTemplate.length; ++n9) {
                this.NpcTemplate[n9] = new NpcTemplate(n9);
                this.NpcTemplate[n9].name = Caption.check(reader.readUTF());
                this.NpcTemplate[n9].detail = reader.readUTF();
                this.NpcTemplate[n9].indexData = reader.dis.readShort();
                this.NpcTemplate[n9].hp = reader.dis.readInt();
                this.NpcTemplate[n9].mp = reader.dis.readInt();
                this.NpcTemplate[n9].g = reader.dis.readShort();
            }
            this.SkillTemplate = new SkillTemplate[reader.dis.readShort()];
            for (int n10 = 0; n10 < this.SkillTemplate.length; ++n10) {
                this.SkillTemplate[n10] = new SkillTemplate(n10);
                this.SkillTemplate[n10].name = reader.readUTF();
                this.SkillTemplate[n10].detail = reader.readUTF();
                this.SkillTemplate[n10].levelNeed = reader.dis.readShort();
                this.SkillTemplate[n10].idChar = reader.dis.readByte();
                this.SkillTemplate[n10].levelMax = reader.dis.readByte();
                this.SkillTemplate[n10].type = reader.dis.readByte();
                this.SkillTemplate[n10].idIcon = reader.dis.readShort();
            }
            this.Skill = new Skill[reader.dis.readShort()];
            for (int n11 = 0; n11 < this.Skill.length; n11 = (short) (n11 + 1)) {
                Skill skill;
                (skill = new Skill()).id = reader.dis.readShort();
                skill.idTemplate = reader.dis.readShort();
                skill.level = reader.dis.readByte();
                skill.levelNeed = reader.readUnsignedByte();
                skill.mpUse = reader.dis.readShort();
                skill.coolDown = reader.dis.readInt();
                skill.rangeNgang = reader.dis.readShort();
                skill.rangeDoc = reader.dis.readShort();
                skill.maxTarget = reader.dis.readByte();
                skill.strOptions = reader.readUTF();
                this.Skill[skill.id] = skill;

                //   System.out.println(skill.id+" - "+skill.getSkillTemplate().name);
            }
            this.SkillClan = new SkillClan[reader.readUnsignedByte()];
            for (int a5 = 0; a5 < this.SkillClan.length; a5 = (short) (a5 + 1)) {
                SkillClan skillClan;
                (skillClan = new SkillClan()).id = a5;
                skillClan.name = reader.readUTF();
                skillClan.detail = reader.readUTF();
                skillClan.levelNeed = reader.readUnsignedByte();
                skillClan.strOptions = reader.readUTF();
                skillClan.idIcon = reader.dis.readShort();
                skillClan.moneyBuy = reader.dis.readInt();
                this.SkillClan[a5] = skillClan;
            }
            this.DataTypeItemBody = new DataTypeItemBody[reader.dis.readByte()];
            for (int n12 = 0; n12 < this.DataTypeItemBody.length; ++n12) {
                this.DataTypeItemBody[n12] = new DataTypeItemBody();
                this.DataTypeItemBody[n12].type = reader.dis.readByte();
            }
            this.aj = getHashtable1(reader);
            this.al = getHashtable2(reader);
            this.ak = getHashtable1(reader);
            this.am = getHashtable2(reader);
            LangLa_gv[] e = new LangLa_gv[reader.readUnsignedByte()];
            for (int n13 = 0; n13 < e.length; ++n13) {
                e[n13] = new LangLa_gv();
                e[n13].a = reader.dis.readShort();
                e[n13].b = reader.dis.readShort();
                e[n13].c = reader.dis.readShort();
                e[n13].d = reader.dis.readByte();
            }
            this.E = e;
            this.a(reader);
            Reader reader2 = reader;
            short unsignedByte = reader2.readUnsignedByte();
            LangLa_jr[] f = new LangLa_jr[reader2.dis.readShort()];
            for (int a6 = 0; a6 < f.length; ++a6) {
                f[a6] = new LangLa_jr();
                f[a6].a = a6;
                f[a6].b = reader2.dis.readByte();
                f[a6].d = new LangLa_ju[unsignedByte];
                for (short n14 = 0; n14 < unsignedByte; ++n14) {
                    f[a6].d[n14] = new LangLa_ju(reader2.dis.readShort());
                    if (f[a6].d[n14].a != 0) {
                        f[a6].d[n14].b = reader2.dis.readByte();
                        f[a6].d[n14].c = reader2.dis.readByte();
                        f[a6].d[n14].d = reader2.dis.readByte();
                        f[a6].d[n14].e = reader2.dis.readByte();
                        addVec(f[a6].d[n14].a);
                    }
                }
            }
            this.F = f;
            LangLa_jt[] g = new LangLa_jt[reader2.dis.readShort()];
            for (int n15 = 0; n15 < g.length; ++n15) {
                g[n15] = new LangLa_jt();
                byte byte2 = reader2.dis.readByte();
                g[n15].a = new short[byte2];
                for (byte b3 = 0; b3 < byte2; ++b3) {
                    g[n15].a[b3] = reader2.dis.readShort();
                }
            }
            this.G = g;
            LangLa_js[] h = new LangLa_js[reader2.dis.readShort()];
            for (int n16 = 0; n16 < h.length; ++n16) {
                h[n16] = new LangLa_js();
                String[] split = reader2.readUTF().split(",");
                h[n16].a[0] = new short[split.length];
                for (int n17 = 0; n17 < split.length; ++n17) {
                    try {
                        h[n16].a[0][n17] = Short.parseShort(split[n17]);
                    } catch (Exception ex) {
                        h[n16].a[0][n17] = 0;
                    }
                }
                String[] split2 = reader2.readUTF().split(",");
                h[n16].a[1] = new short[split2.length];
                for (int n18 = 0; n18 < split2.length; ++n18) {
                    try {
                        h[n16].a[1][n18] = Short.parseShort(split2[n18]);
                    } catch (Exception ex2) {
                        h[n16].a[1][n18] = 0;
                    }
                }
                String[] split3 = reader2.readUTF().split(",");
                h[n16].a[2] = new short[split3.length];
                for (int n19 = 0; n19 < split3.length; ++n19) {
                    try {
                        h[n16].a[2][n19] = Short.parseShort(split3[n19]);
                    } catch (Exception ex3) {
                        h[n16].a[2][n19] = 0;
                    }
                }
            }
            this.H = h;
            this.b(reader);
            this.c(reader);
            this.e(reader);
            this.d(reader);
            this.f(reader);
            Reader reader3 = reader;
            short short1 = reader3.dis.readShort();
            this.ag.clear();
            for (short i = 0; i < short1; ++i) {
                short short2 = reader3.dis.readShort();
                short short3 = reader3.dis.readShort();
                if (i == 235) {
                    short2 = 40;
                }
                byte[][] array = new byte[reader3.dis.readByte()][];
                for (int index = 0; index < array.length; ++index) {
                    array[index] = new byte[reader3.dis.readByte()];
                    for (int index2 = 0; index2 < array[index].length; ++index2) {
                        array[index][index2] = reader3.dis.readByte();
                    }
                }
                LangLa_hz[] array2 = new LangLa_hz[reader3.dis.readByte()];
                for (int index = 0; index < array2.length; ++index) {
                    array2[index] = new LangLa_hz();
                    array2[index].a = new LangLa_ia[reader3.dis.readByte()];
                    for (int index2 = 0; index2 < array2[index].a.length; ++index2) {
                        array2[index].a[index2] = new LangLa_ia();
                        addVec(array2[index].a[index2].a = reader3.dis.readShort());
                        if (!this.ag.contains(array2[index].a[index2].a)) {
                            this.ag.add(array2[index].a[index2].a);
                        }
                        array2[index].a[index2].d = reader3.dis.readByte();
                        if (array2[index].a[index2].d >= 30) {
                            LangLa_ia langLa_ia = array2[index].a[index2];
                            langLa_ia.d -= 30;
                            array2[index].a[index2].b = reader3.dis.readShort();
                            array2[index].a[index2].c = reader3.dis.readShort();
                        } else if (array2[index].a[index2].d >= 20) {
                            LangLa_ia langLa_ia2 = array2[index].a[index2];
                            langLa_ia2.d -= 20;
                            array2[index].a[index2].c = reader3.dis.readShort();
                        } else if (array2[index].a[index2].d >= 10) {
                            LangLa_ia langLa_ia3 = array2[index].a[index2];
                            langLa_ia3.d -= 10;
                            array2[index].a[index2].b = reader3.dis.readShort();
                        }
                    }
                }
                for (int index = 0; index < this.NpcTemplate.length; ++index) {
                    if (this.NpcTemplate[index].indexData == i) {
                        this.NpcTemplate[index].width = short2;
                        this.NpcTemplate[index].height = short3;
                        this.NpcTemplate[index].b = array2;
                        this.NpcTemplate[index].a = array;
                    }
                }
                for (int index = 0; index < this.MobTemplate.length; ++index) {
                    if (this.MobTemplate[index].indexData == i) {
                        this.MobTemplate[index].width = short2;
                        this.MobTemplate[index].height = short3;
                        switch (this.MobTemplate[index].indexData) {
                            case 47: {
                                MobTemplate mobTemplate3 = this.MobTemplate[index];
                                mobTemplate3.height -= 5;
                                break;
                            }
                            case 48: {
                                MobTemplate mobTemplate4 = this.MobTemplate[index];
                                mobTemplate4.height -= 50;
                                break;
                            }
                            case 49:
                            case 151:
                            case 193: {
                                MobTemplate mobTemplate5 = this.MobTemplate[index];
                                mobTemplate5.height -= 22;
                                break;
                            }
                            case 52:
                            case 227: {
                                MobTemplate mobTemplate6 = this.MobTemplate[index];
                                mobTemplate6.height -= 7;
                                break;
                            }
                            case 28:
                            case 53: {
                                MobTemplate mobTemplate7 = this.MobTemplate[index];
                                mobTemplate7.height -= 9;
                                break;
                            }
                            case 54:
                            case 59:
                            case 177: {
                                MobTemplate mobTemplate8 = this.MobTemplate[index];
                                mobTemplate8.height -= 65;
                                break;
                            }
                            case 55:
                            case 190: {
                                MobTemplate mobTemplate9 = this.MobTemplate[index];
                                mobTemplate9.height -= 20;
                                break;
                            }
                            case 56: {
                                MobTemplate mobTemplate10 = this.MobTemplate[index];
                                mobTemplate10.height += 3;
                                break;
                            }
                            case 57: {
                                MobTemplate mobTemplate11 = this.MobTemplate[index];
                                mobTemplate11.height += 2;
                                break;
                            }
                            case 60: {
                                MobTemplate mobTemplate12 = this.MobTemplate[index];
                                mobTemplate12.height += 5;
                                break;
                            }
                            case 63: {
                                MobTemplate mobTemplate13 = this.MobTemplate[index];
                                mobTemplate13.height -= 34;
                                break;
                            }
                            case 26: {
                                MobTemplate mobTemplate14 = this.MobTemplate[index];
                                mobTemplate14.height -= 20;
                                break;
                            }
                            case 9:
                            case 123: {
                                MobTemplate mobTemplate15 = this.MobTemplate[index];
                                mobTemplate15.height -= 4;
                                break;
                            }
                            case 157:
                            case 169:
                            case 170: {
                                MobTemplate mobTemplate16 = this.MobTemplate[index];
                                mobTemplate16.height -= 8;
                                break;
                            }
                            case 154:
                            case 155:
                            case 156:
                            case 158:
                            case 195:
                            case 220:
                            case 224:
                            case 226: {
                                MobTemplate mobTemplate17 = this.MobTemplate[index];
                                mobTemplate17.height -= 2;
                                break;
                            }
                            case 58:
                            case 124: {
                                MobTemplate mobTemplate18 = this.MobTemplate[index];
                                mobTemplate18.height -= 10;
                                break;
                            }
                            case 178:
                            case 192:
                            case 197:
                            case 198: {
                                MobTemplate mobTemplate19 = this.MobTemplate[index];
                                mobTemplate19.height -= 5;
                                break;
                            }
                            case 191:
                            case 196:
                            case 212:
                            case 225: {
                                MobTemplate mobTemplate20 = this.MobTemplate[index];
                                mobTemplate20.height -= 15;
                                break;
                            }
                            case 217: {
                                MobTemplate mobTemplate21 = this.MobTemplate[index];
                                mobTemplate21.height += 13;
                                break;
                            }
                        }
                        this.MobTemplate[index].b = array2;
                        this.MobTemplate[index].a = array;
                    }
                }
            }
            this.ai.clear();
            this.ai.add("iconClient.zip");
            // This CDN serves character sprites individually; iconChar.zip is an HTML page.
            Reader reader4;
            ArrayServer[] arrayServer = new ArrayServer[(reader4 = reader).dis.readByte()];
            for (int index = 0; index < arrayServer.length; ++index) {
                arrayServer[index] = new ArrayServer();
                arrayServer[index].nameServers = reader4.readUTF();
                arrayServer[index].servers = new Server[reader4.dis.readByte()];
                for (int index2 = 0; index2 < arrayServer[index].servers.length; ++index2) {
                    arrayServer[index].servers[index2] = new Server();
                    arrayServer[index].servers[index2].id = reader4.dis.readShort();
                    arrayServer[index].servers[index2].name = reader4.readUTF();
                    arrayServer[index].servers[index2].ip = reader4.readUTF();
                    arrayServer[index].servers[index2].port = reader4.dis.readShort();
                    arrayServer[index].servers[index2].portCheck = reader4.dis.readShort();
                }
            }
            Reader reader5;
            int[] au = new int[(reader5 = reader).dis.readInt()];
            for (int index = 0; index < au.length; ++index) {
                au[index] = reader5.dis.readShort();
            }
            this.au = au;
            this.bacKhoaGhepDa = readArrayInt(reader);
            this.bacKhoaUpgradeVuKhi = readArrayInt(reader);
            this.bacKhoaUpgradeTrangBi = readArrayInt(reader);
            this.bacKhoaUpgradePhuKien = readArrayInt(reader);
            this.pointGhepDa = readArrayLong(reader);
            this.pointUpgradeVuKhi = readArrayLong(reader);
            this.pointUpgradeTrangBi = readArrayLong(reader);
            this.pointUpgradePhuKien = readArrayLong(reader);
            this.ngocKhamUpgrade = readArrayInt(reader);
            this.dataTreoCho[0] = readArrayString(reader);
            this.dataTreoCho[1] = readArrayString(reader);
            this.exps = readArrayLong(reader);
         //  System.out.println(Arrays.toString(  this.pointUpgradeVuKhi ));
         //   System.out.println(Arrays.toString(  this.pointGhepDa ));
            this.dataGiftQuaySo = new int[reader.dis.readByte()][];
            for (int index = 0; index < this.dataGiftQuaySo.length; ++index) {
                this.dataGiftQuaySo[index] = readArrayInt(reader);
            }
            this.vSkillClan.clear();
            try {
                for (byte size = reader.dis.readByte(), index = 0; index < size; ++index) {
                    SkillClan skillClan;
                    (skillClan = new SkillClan()).id = reader.dis.readByte();
                    skillClan.name = reader.readUTF();
                    skillClan.detail = reader.readUTF();
                    skillClan.levelNeed = reader.readUnsignedByte();
                    skillClan.strOptions = reader.readUTF();
                    skillClan.idIcon = reader.dis.readShort();
                    this.vSkillClan.add(skillClan);
                }
            } catch (Exception ex4) {
            }
            this.typeArr = reader.dis.readByte();
            System.out.println(this.typeArr);
        } catch (Exception ex5) {
            if (retries >= 1) throw new IllegalStateException("Invalid game data after retry", ex5);
            byte[] c;
            if ((c = Binary.c(gI().aU + "arr_data_game.beatdz")) != null) {
                Binary.write("arr_data_game", c);
                this.readArrDataGame(b, retries + 1);
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
            this.ba = true;
        }
    }

    private static int[] readArrayInt(Reader reader) throws java.io.IOException {
        int[] array = new int[reader.dis.readInt()];
        for (int i = 0; i < array.length; ++i) {
            array[i] = reader.dis.readInt();
        }
        return array;
    }

    private static long[] readArrayLong(Reader reader) throws java.io.IOException {
        long[] array = new long[reader.dis.readInt()];
        for (int i = 0; i < array.length; ++i) {
            array[i] = reader.dis.readLong();
        }
        return array;
    }

    private static String[] readArrayString(Reader reader) throws java.io.IOException {
        String[] array = new String[reader.dis.readInt()];
        for (int i = 0; i < array.length; ++i) {
            array[i] = reader.readUTF();
        }
        return array;
    }

    public void setScreen(MainScreen aq) {
        if (this.currentScreen != null && this.currentScreen instanceof ScreenLogin) {
            ((ScreenLogin) this.currentScreen).m();
        }
        b(this.currentScreen);
        this.currentScreen = aq;
    }

    public MainScreen getScreen() {
        return this.currentScreen;
    }

    public void createSession() {
        Session.gI().connect(this.ipServer, this.portServer);
    }

    public void setServer(Server ap) {
        this.aP = ap;
        if (ap.version1 >= 0) {
            this.VER1 = ap.version1;
        } else {
            this.VER1 = 999;
        }
        if (ap.version2 >= 0) {
            this.VER2 = ap.version2;
        } else {
            this.VER2 = 999;
        }
        if(ap.arrayData !=null && ap.arrayData.length>2){
            Session.gI().keyApp = ap.arrayData[2];
        }
        Binary.writeUTF("arr_server", this.aP.ip + ":" + this.aP.port);
        this.ipServer = this.aP.ip;
        this.portServer = this.aP.port;
//        if (Utlis.b(this.aP.ip, this.aP.port)) {
//            this.aP.STR_STATUS = Caption.mj;
//            return;
//        }
//        this.aP.STR_STATUS = Caption.mi;
    }

    public void g() {
        try {
            this.aI = true;
            Message.c((byte) (-126)).send();
            this.currentScreen.L();
        } catch (Exception ex) {
        }
    }

    public static Vector h() {
        Vector<short[]> vector = new Vector<short[]>();
        for (int i = 0; i < gI().dataWayPoint.length; ++i) {
            vector.add(gI().dataWayPoint[i]);
        }
        return vector;
    }

    public static void i() {
        AppListener.c();
        for (Object obj : gI().aj.keySet()) {
            if (((LangLa_et) gI().aj.get((Short) obj)).a <= 1 && ((mImage) beatdz.LangLa_fq.$state_LangLa_fq().e.get((Short) obj)) == null) {
                LangLa_fq.a(((Short) obj).shortValue());
            }
        }
    }

    public static int a(String lowerCase) {
        if (Canvas.isMobile()) return Math.max(0, Math.min(3, gI().zoomLevel - 1));
        lowerCase = lowerCase.toLowerCase();
        byte b = mConfig.gI().readByte(2);
        int n;
        if ((n = gI().zoomLevelScreen - 1) > 3) {
            n = 3;
        }
        int n2;
        if ((n2 = n) == 0) {
            return 0;
        }
        if (n == 2 && (b == 0 || b == 3)) {
            if (lowerCase.contains("tree") && b == 3) {
                return 0;
            }
            return 1;
        } else {
            if (n == 3 && b == 0) {
                return 2;
            }
            if (lowerCase.contains("char")) {
                if (n == 1 && (b == 0 || b == 2)) {
                    n2 = 0;
                } else if (n == 2 && b != 2) {
                    n2 = 1;
                } else if (n == 3 && b != 2) {
                    n2 = 2;
                }
            } else if (lowerCase.contains("tree") && n == 1 && b == 2) {
                n2 = 0;
            }
            return n2;
        }
    }

    public static boolean j() {
        return Gdx.app.getType() != Application.ApplicationType.Desktop && !k();
    }

    public static boolean k() {
        if (GameSrc.gI().bb) {
            return true;
        }
        if (beatdz.DataCenter.$state_DataCenter().bd == 0) {
            if (Binary.readBoolan("arr_full")) {
                beatdz.DataCenter.$state_DataCenter().bd = 1;
            } else {
                beatdz.DataCenter.$state_DataCenter().bd = 2;
            }
        }
        return beatdz.DataCenter.$state_DataCenter().bd == 1;
    }

    


    // Reuse immutable definitions; all live characters, worlds, screens and sockets remain private.
    void initializeAccountView(DataCenter source) {
        this.widthScreen = source.widthScreen;
        this.heightScreen = source.heightScreen;
        this.q = source.q;
        this.r = source.r;
        this.zoomLevelScreen = source.zoomLevelScreen;
        this.zoomLevel = source.zoomLevel;
        this.typeArr = source.typeArr;
        this.typeOS = source.typeOS;
        this.VER1 = source.VER1;
        this.VER2 = source.VER2;
        this.A = source.A;
        this.B = source.B;
        this.C = source.C;
        this.D = source.D;
        this.E = source.E;
        this.F = source.F;
        this.G = source.G;
        this.H = source.H;
        this.I = source.I;
        this.J = source.J;
        this.K = source.K;
        this.L = source.L;
        this.NpcTemplate = source.NpcTemplate;
        this.MobTemplate = source.MobTemplate;
        this.MapTemplate = source.MapTemplate;
        this.DataTemplateAchievement = source.DataTemplateAchievement;
        this.DataTaskDay = source.DataTaskDay;
        this.Task = source.Task;
        this.DataNameChar = source.DataNameChar;
        this.DataIconChar = source.DataIconChar;
        this.DataNameClass = source.DataNameClass;
        this.ItemTemplate = source.ItemTemplate;
        this.ItemOptionTemplate = source.ItemOptionTemplate;
        this.SkillTemplate = source.SkillTemplate;
        this.SkillClan = source.SkillClan;
        this.EffectTemplate = source.EffectTemplate;
        this.Skill = source.Skill;
        this.DataTypeItemBody = source.DataTypeItemBody;
        this.dataWayPoint = source.dataWayPoint;
        this.dataGiftQuaySo = source.dataGiftQuaySo;
        this.af = source.af;
        this.aj = source.aj;
        this.ak = source.ak;
        this.al = source.al;
        this.am = source.am;
        this.an = source.an;
        this.arrayServers = source.arrayServers;
        this.au = source.au;
        this.bacKhoaGhepDa = source.bacKhoaGhepDa;
        this.bacKhoaUpgradeVuKhi = source.bacKhoaUpgradeVuKhi;
        this.bacKhoaUpgradeTrangBi = source.bacKhoaUpgradeTrangBi;
        this.bacKhoaUpgradePhuKien = source.bacKhoaUpgradePhuKien;
        this.ngocKhamUpgrade = source.ngocKhamUpgrade;
        this.pointGhepDa = source.pointGhepDa;
        this.pointUpgradeVuKhi = source.pointUpgradeVuKhi;
        this.pointUpgradeTrangBi = source.pointUpgradeTrangBi;
        this.pointUpgradePhuKien = source.pointUpgradePhuKien;
        this.dataTreoCho = source.dataTreoCho;
        this.exps = source.exps;
        this.aU = source.aU;
        this.aV = source.aV;
        this.aW = source.aW;
        this.aX = source.aX;
        this.aY = source.aY;
        this.aZ = source.aZ;
        this.ipServer = source.ipServer;
        this.portServer = source.portServer;
        this.aP = source.aP;
        this.f = source.f;
        this.v = source.v;
        this.ba = source.ba; this.bb = source.bb;
        this.aJ = source.aJ; this.aK = source.aK; this.aL = source.aL;
        this.aM = source.aM; this.aN = source.aN;
        this.ag.addAll(source.ag); this.ah.addAll(source.ah); this.ai.addAll(source.ai);
        beatdz.DataCenter.$state_DataCenter().at = true;
        beatdz.AppListener.$state_AppListener().g = true;
        this.aO = new LangLa_gg(null);
    }
// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public DataCenter bg;
public Object bh;
public boolean ar;
public boolean as;
public volatile boolean at;
public int aQ;
public int aR;
public int bd;
public Vector be;
public void initialize() {
{
        this.bg = null;
        this.bh = new Object();
        this.be = new Vector();
    }
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.DataCenter");
public static SessionState $state_DataCenter() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
