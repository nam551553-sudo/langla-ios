package beatdz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.tgame.model.Caption;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

public class Char extends Entity {
    public int getZ(int total, int p) {
        return total * p / 100;
    }
    

    public void readNewDanhHieu(Message var1,DanhHieu var2) {
        try {
            int x = var1.readInt();
            int y = var1.readInt();
            int timems = var1.readInt();
            int size = var1.readInt();
            int length = var1.readByte();
            int[] array = new int[length];
            for (int i = 0; i < length; i++) {
                array[i] = var1.readShort();
            }
            var2.data = new DanhHieuByBeatdz(array);
            var2.data.x = x;
            var2.data.y = y;
            var2.data.timeMS = timems;
            var2.data.size = size;
        } catch (Exception ex) {

        }
    }

    public static class DanhHieuByBeatdz {

        public int x;
        public int y = -30;
        public int timeMS = 20;//ms / frame
        public int size = 60;//100%
        public TextureRegion[] array = new TextureRegion[0];
        public int[] array_Id = new int[0];

        public DanhHieuByBeatdz(String url) throws Exception {
            //DanhHieu\0
            // url = "DanhHieu\\0";
            File file = new File(url);
            ArrayList<TextureRegion> listTextureRegion = new ArrayList<TextureRegion>();

            int c = 0;
            for (int i = 0; c < file.listFiles().length; i++) {
                if (new File((url + "\\" + i + ".png")).exists()) {
                    byte[] arrayImg = new Reader(new FileInputStream(url + "\\" + i + ".png")).readFully();
                    mImage m = mImage.a(arrayImg, 0, arrayImg.length);
                    listTextureRegion.add(new TextureRegion(m.b()));
                    Canvas.vImage.remove(m);
                    c++;
                }
            }
            array = listTextureRegion.toArray(new TextureRegion[listTextureRegion.size()]);
        }

        public DanhHieuByBeatdz(int... array) throws Exception {
            array_Id = array;
            this.array = new TextureRegion[array.length];
//            //DanhHieu\0
//            // url = "DanhHieu\\0";
//            File file = new File(url);
//            ArrayList<TextureRegion> listTextureRegion = new ArrayList<TextureRegion>();
//
//            int c = 0;
//            for (int i = 0; c < file.listFiles().length; i++) {
//                if (new File((url + "\\" + i + ".png")).exists()) {
//                    byte[] arrayImg = new Reader(new FileInputStream(url + "\\" + i + ".png")).readFully();
//                    mImage m = mImage.a(arrayImg, 0, arrayImg.length);
//                    listTextureRegion.add(new TextureRegion(m.b()));
//                    Canvas.vImage.remove(m);
//                    c++;
//                }
//            }
//            array = listTextureRegion.toArray(new TextureRegion[listTextureRegion.size()]);
        }
    }

//    static {
//
//        Gdx.app.postRunnable(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    int[] arr = new int[10];
//                    for (int i = 0; i < 10; i++) {
//                        arr[i] = i+673;
//                    }
//                    data = new DanhHieuByBeatdz(arr);
//                    //  data = new DanhHieuByBeatdz("DanhHieu\\0");
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
////                try {
////                    animation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, new FileInputStream("test.gif"));
////                } catch (Exception ex) {
////                    ex.printStackTrace();
////                }
//            }
//        });
//    }
    public String username;
    public byte idChar;
    public byte l;
    public byte m;
    public byte n;
    public byte lvPk;
    public byte typePK;
    public byte q;
    public byte statusGD;
    public short speedMove;
    public static short movementSpeed(int serverUnits) {
        return (short)Math.max(0, Math.min(127, serverUnits / 100));
    }

    public static int horizontalSpeed(int base) {
        return Math.max(0, Math.round(base * 1.30f));
    }
    public boolean isCuuSat;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;
    public boolean A;
    public boolean B;
    public int C;
    public int D;
    public int hoatLuc;
    public int levelCheTao;
    public int sachChienDau;
    public int idCharPk = -1;
    public int I;
    public int J;
    public int K;
    public boolean L;
    public PointMove pointMove;
    public PointMove pointMove2;
    public int hp;
    public int mp;
    public int hpFull;
    public int mpFull;
    public long bac;
    public long bacKhoa;
    public long vangKhoa;
    public long vang;
    public byte professionRank;
    public byte professionPath;
    public String professionName = "";
    public String professionPathName = "";
    public String professionNextRequirement = "";
    public String professionTaskTitle = "";
    public String professionTaskDetail = "";
    public int taiPhu;
    public byte gioiTinh;
    public byte idClass;
    public byte idhe;
    public byte aa = -1;
    public byte selectDanhHieu = -1;
    public byte rank;
    public long exp;
    public String name;
    public byte af;
    public byte ag;
    private int bj;
    private int bk;
    private int bl = -1;
    private int bm = -1;
    private int bn;
    private int bo;
    private int bp;
    public int ah;
    public short ai;
    public short aj;
    public int ak;
    public short al;
    public short am;
    public short an;
    public short ao;
    public Item[] arrItemBag;
    public Item[] arrItemBox;
    public Item[] arrItemBody = new Item[17];
    public Item[] arrItemBody2 = new Item[17];
    public Item[] arrItemExtend = new Item[3];
    public Item[] arrItemSkillViThu = new Item[6];
    public LangLa_iz av;
    public LangLa_iy aw;
    public LangLa_eu ax;
    public Skill ay;
    public LangLa_jw az;
    public LangLa_jw aA;
    public Vector vEffect;
    public Vector aC;
    public Vector vPointMove;
    public Vector aE;
    public Vector aF;
    public DanhHieu[] aG;
    public Vector aH;
    public LangLa_hf aI;
    
    private int br;
    public LangLa_ih aJ;
    private int bs;
    private long bt;
    private long bu;
    public Mob aK;
    public Mob aL;
    public int aM;
    public int aN;
    public int aO;
    private Effect bv;
    private Effect bw;
    private Effect bx;
    public int aP;
    public boolean aQ;
    public boolean aR;
    public boolean aS;
    public boolean aT;
    public int aU;
    public int selectCaiTrang;
    private static final int HIDE_TANTO = 4;
    public int aW;
    public int aX;
    public int aY;
    public int aZ;
    public int ba;
    public int bb;
    public int bc;
    public int bd;
    public int be;
    public int bf;
    private int by;
    private int bz;
    
    public int bg;
    private int bB;
    private int bC;
    private LangLa_eo bD;
    public Char bh;
    
    private byte bE;
    private Vector bF;
    private long bG;

    public Char() {
        this.az = new LangLa_jw(83, this.cx, this.cy, -1);
        this.vEffect = new Vector();
        this.aC = new Vector();
        this.vPointMove = new Vector();
        this.aE = new Vector();
        this.aF = new Vector();
        this.aG = new DanhHieu[0];
        this.aH = new Vector();
        this.br = 0;
        this.bt = 0L;
        this.bu = 0L;
        this.aP = -1;
        this.aZ = 3;
        this.ba = 2;
        this.bb = 1;
        this.bc = 3;
        this.bd = 2;
        this.be = 1;
        this.bf = 10;
        this.by = 0;
        this.bF = new Vector();
        this.setSize(30, 48);
        this.ag = 3;
    }

    public Char(int var1) {
        this.az = new LangLa_jw(83, this.cx, this.cy, -1);
        this.vEffect = new Vector();
        this.aC = new Vector();
        this.vPointMove = new Vector();
        this.aE = new Vector();
        this.aF = new Vector();
        this.aG = new DanhHieu[0];
        this.aH = new Vector();
        this.br = 0;
        this.bt = 0L;
        this.bu = 0L;
        this.aP = -1;
        this.aZ = 3;
        this.ba = 2;
        this.bb = 1;
        this.bc = 3;
        this.bd = 2;
        this.be = 1;
        this.bf = 10;
        this.by = 0;
        this.bF = new Vector();
        this.setSize(30, 48);
        this.idEntity = var1;
    }

    private int V() {
        if (this.arrItemBody[12] != null) {
            if (this.arrItemBody[12].id == 535) {
                return 11;
            } else if (this.arrItemBody[12].id == 124) {
                return 12;
            } else {
                return this.arrItemBody[12].id == 345 ? 13 : this.arrItemBody[12].id - 123;
            }
        } else {
            return 0;
        }
    }

    public static Char gI() {
        if (beatdz.Char.$state_Char().bq == null) {
            beatdz.Char.$state_Char().bq = new Char();
        }

        return beatdz.Char.$state_Char().bq;
    }

    public void p() {
        this.cleanVecMove();
        gI().l();
    }

    public void read(Message var1) throws java.io.IOException {
        this.readCharacter(var1, true);
    }

    public void readSelection(Message message) throws java.io.IOException {
        this.readCharacter(message, false);
    }

    private void readCharacter(Message var1, boolean includeProfession) throws java.io.IOException {
        this.vEffect.clear();
        this.arrItemBag = null;
        this.arrItemBox = null;
        this.arrItemBody = new Item[17];
        this.arrItemBody2 = new Item[17];
        this.arrItemExtend = new Item[3];
        this.status = var1.readByte();
        this.name = var1.reader.readUTF();
        this.idChar = var1.readByte();
        this.gioiTinh = var1.readByte();
        this.idClass = var1.readByte();
        this.typePK = var1.readByte();
        this.lvPk = var1.readByte();
        this.speedMove = Char.movementSpeed(var1.readShort());
        this.hp = var1.readInt();
        this.hpFull = var1.readInt();
        this.mp = var1.readInt();
        this.mpFull = var1.readInt();
        this.exp = var1.readLong();
        this.cx = this.ai = var1.readShort();
        this.cy = this.aj = var1.readShort();
        this.bz = this.cy;
        this.statusGD = var1.readByte();
        this.arrItemBody = readItemBody(var1, this.arrItemBody);
        if (this.status == 4) {
            this.aj();
        }

        byte var2 = var1.readByte();

        for (int var3 = 0; var3 < var2; ++var3) {
            Effect var4 = new Effect(var1.readShort(), var1.readInt(), var1.readLong(), var1.readInt(), this);
            this.addEffect(var4);
        }

        this.readDanhHieu(var1);
        this.selectDanhHieu = (byte) (var1.readByte() + 1);
        this.rank = var1.readByte();
        this.selectCaiTrang = var1.readByte();
        if (includeProfession) this.readProfession(var1);
        this.U();
    }

    public void readMe(Message var1) throws java.io.IOException {
        DataCenter.gI().equipmentBalanceRevision = 0;
        this.vEffect.clear();
        this.username = var1.reader.readUTF();
        this.idEntity = var1.readInt();
        this.name = var1.reader.readUTF();
        this.gioiTinh = var1.readByte();
        this.idChar = var1.readByte();
        this.idhe = var1.readByte();
        this.idClass = var1.readByte();
        this.typePK = var1.readByte();
        this.lvPk = var1.readByte();
        this.taiPhu = var1.readInt();
        this.speedMove = Char.movementSpeed(var1.readShort());
        this.sachChienDau = (byte) Math.max(0, Math.min(18, var1.readByte()));
        this.hp = var1.readInt();
        this.hpFull = var1.readInt();
        this.mp = var1.readInt();
        this.mpFull = var1.readInt();
        this.exp = var1.readLong();
        this.bac = var1.readLong();
        this.bacKhoa = var1.readLong();
        this.vang = var1.readLong();
        this.vangKhoa = var1.readLong();
        GameSrc.gI().Task = var1.readShort();
        GameSrc.gI().idStep = var1.readByte();
        GameSrc.gI().idRequire = var1.readUnsignedShort();
        this.hoatLuc = var1.readInt();
        GameSrc.gI().pointNAP = var1.readInt();
        GameSrc.gI().loadAfterNextMap();
        this.arrItemBag = new Item[var1.readShort()];
        Item[] var3 = this.arrItemExtend;
        Message var2 = var1;

        for (int var4 = 0; var4 < var3.length; ++var4) {
            var3[var4] = null;
        }

        byte var11 = var1.readByte();

        for (int var6 = 0; var6 < var11; ++var6) {
            Item var5;
            (var5 = new Item()).id = var2.readShort();
            var5.isLock = var2.readBoolean();
            var5.index = var2.readByte();
            var3[var5.index] = var5;
        }

        this.arrItemBody = readItemBody(var1, this.arrItemBody);
        this.arrItemBody2 = readItemBody(var1, this.arrItemBody2);
        readWingRenderInfo(var1);
        readWingRenderInfo(var1);
        readItemBag(var1, this.arrItemBag);
        if (this.arrItemBody[10] != null) {
            this.aa = 50;
        }

        byte var8 = var1.readByte();

        int var10;
        for (var10 = 0; var10 < var8; ++var10) {
            Effect var12 = new Effect(var1.readShort(), var1.readInt(), var1.readLong(), var1.readInt(), this);
            this.addEffect(var12);
        }

        GameSrc.gI().vThu.clear();
        short var9 = var1.readShort();

        for (var10 = 0; var10 < var9; ++var10) {
            Thu var13;
            (var13 = new Thu()).a(var1);
            GameSrc.gI().vThu.add(var13);
        }

        GameSrc.gI().vFriend.clear();
        var9 = var1.readShort();

        for (var10 = 0; var10 < var9; ++var10) {
            Friend var14;
            (var14 = new Friend()).c = var1.reader.readUTF();
            var14.b = var1.readByte();
            var14.d = var1.readBoolean();
            GameSrc.gI().vFriend.add(var14);
        }

        GameSrc.gI().u();
        GameSrc.gI().vEnemy.clear();
        var9 = var1.readShort();

        for (var10 = 0; var10 < var9; ++var10) {
            Enemy var15;
            (var15 = new Enemy()).b = var1.reader.readUTF();
            var15.c = var1.readBoolean();
            GameSrc.gI().vEnemy.add(var15);
        }

        this.readSkill(var1);
        this.readDanhHieu(var1);
        this.selectDanhHieu = (byte) (var1.readByte() + 1);
        this.rank = var1.readByte();
        this.selectCaiTrang = var1.readByte();
        this.readProfession(var1);

        try {
            GameSrc.gI().timeChatColor = var1.readInt();
            GameSrc.gI().numTaskDoneKTNG = var1.readByte();
            GameSrc.gI().doneTaskKTNG = var1.readBoolean();
            this.readSkillClan(var1);
            if (var1.reader.dis.available() >= 8 && var1.readInt() == 0x42414C31)
                DataCenter.gI().equipmentBalanceRevision = var1.readInt();
        } catch (Exception var7) {
        }

        this.aF.clear();
        this.aC.clear();
        this.cleanVecMove();
        this.aE.clear();
        this.U();
        this.bh = null;
    }

    private void readProfession(Message message) throws java.io.IOException {
        this.professionRank = message.readByte();
        this.professionPath = message.readByte();
        this.professionName = message.readUTF();
        this.professionPathName = message.readUTF();
        this.professionNextRequirement = message.readUTF();
        this.professionTaskTitle = message.readUTF();
        this.professionTaskDetail = message.readUTF();
    }

    public static void readWingRenderInfo(Message message) throws java.io.IOException {
        if (message.readBoolean()) {
            // Keep packet alignment; this client does not render retired wing assets.
            for (int index = 0; index < 5; index++) message.readInt();
        }
    }

    public void readSkill(Message var1) throws java.io.IOException {
        this.ay = DataCenter.gI().Skill[1].cloneSkill();
        short var2 = var1.readShort();
        GameSrc.gI().p = new Skill[var1.readShort()];

        for (int var3 = 0; var3 < GameSrc.gI().p.length; ++var3) {
            short var4 = var1.readShort();
            Skill var5 = DataCenter.gI().Skill[var4].cloneSkill();
            GameSrc.gI().p[var3] = var5;
            if (var2 == var5.id) {
                this.ay = var5;
            }
            //   System.out.println(var5.getSkillTemplate().name+": "+var5.getSkillTemplate().type);
        }

        Arrays.sort(GameSrc.gI().p, beatdz.Skill.$state_Skill().a);
    }

    public boolean isMe() {
        return gI().equals(this);
    }

    public int a() {
        return this.cx - this.width / 2;
    }

    public int b() {
        return this.cx + this.width / 2;
    }

    public int c() {
        return this.j() ? this.cy - this.height - 5 : this.cy - this.height;
    }

    public int d() {
        return this.cy;
    }

    public int a(int var1) {
        int var2 = 0;

        try {
            if ((var2 = this.hp * var1 / this.hpFull) > var1) {
                var2 = var1;
            }
        } catch (Exception var3) {
            Utlis.println(var3);
        }

        if (var2 < 0) {
            var2 = 0;
        }

        return var2;
    }

    public int b(int var1) {
        int var2 = 0;

        try {
            if ((var2 = this.mp * var1 / this.mpFull) > var1) {
                var2 = var1;
            }
        } catch (Exception var3) {
            Utlis.println(var3);
        }

        if (var2 < 0) {
            var2 = 0;
        }

        return var2;
    }

    public boolean r() {
        return this.pointMove != null && this.pointMove.h > 0;
    }

    public int level() {
        long var1 = this.exp;

        int var3;
        for (var3 = 0; var3 < DataCenter.gI().exps.length && var1 >= DataCenter.gI().exps[var3]; ++var3) {
            var1 -= DataCenter.gI().exps[var3];
        }

        return var3;
    }

    public boolean i() {
        return this.ag == 3;
    }

    private void W() {
        this.aF.removeElement(this.az);

        for (int var1 = this.aF.size() - 1; var1 >= 0; --var1) {
            LangLa_jw var2;
            (var2 = (LangLa_jw) this.aF.elementAt(var1)).b((Entity) this);
            if (var2.r()) {
                this.aF.removeElement(var2);
            }
        }

    }

    public void t() {
        if (this.pointMove != null && this.pointMove.d != GameSrc.gI().mapID) {
            this.pointMove = null;
        }

        if (this.isMe() && !this.j()) {
            if (this.w()) {
                if (this.cx == this.bB && this.cy == this.bC) {
                    ++this.bg;
                    if (this.bg >= 40) {
                        this.bg = 0;
                        this.bD = GameSrc.gI().aR;
                        GameSrc.gI().aR = null;
                        this.l();
                    }
                } else {
                    this.bB = this.cx;
                    this.bC = this.cy;
                    this.bg = 0;
                }
            } else if (this.bg >= 40) {
                ++this.bg;
                if (this.bg > 42) {
                    this.bg = 0;
                    if (this.bD != null) {
                        GameSrc.gI().aR = this.bD;
                    }
                }
            }
        }

        try {
            if (this.bF.size() > 0 && System.currentTimeMillis() - this.bG > 1000L) {
                this.ai();
            }

            this.Y();
            this.aQ = this.selectCaiTrang == 1 || this.selectCaiTrang == 3;
            this.aS = this.selectCaiTrang == 2 || this.selectCaiTrang == 3;
            if (this.arrItemBody[10] != null) {
                if (this.arrItemBody[10].getItemTemplate().idMob > 0) {
                    if (this.aK == null) {
                        this.aK = new Mob();
                        this.aK.id = this.arrItemBody[10].getItemTemplate().idMob;
                        this.aK.hp = 1;
                        this.aK.b(this.cx, this.cy);
                        this.aK.speedMove = this.aK.getMobTemplate().speedMoveByte;
                        this.aK.dir = this.ag;
                        this.aK.cx = (short) (this.cx + (this.i() ? 35 : -35));
                        this.aK.cy = this.cy;
                    }

                    this.aK.t();
                    this.aK.p = (short) this.m();
                    this.aK.q = (short) this.n();
                    if (this.aK.getMobTemplate().type == 4) {
                        this.aK.cx = (short) (this.cx + (this.i() ? 35 : -35));
                        this.aK.dir = this.ag;
                    }

                    LangLa_lo var1;
                    (var1 = new LangLa_lo(0)).setXY(this.aK.cx, this.aK.cy);
                    var1.o = this.aK;
                    GameSrc.gI().a((Entity) var1);
                } else if (this.arrItemBody[10].getItemTemplate().idMob < 0) {
                    if (this.aA == null) {
                        this.aA = new LangLa_jw(-this.arrItemBody[10].getItemTemplate().idMob, this.cx, this.cy, -1);
                    }

                    this.aA.b((Entity) this);
                }
            } else {
                this.aK = null;
                this.aA = null;
            }

            this.ak = this.height + 4;
            if (this.aJ != null && this.aJ.a(this.m(), this.cy - this.height - 6)) {
                this.aJ = null;
            }

            int var12 = Utlis.currentTimeSeconds();
            if (this.C < var12) {
                this.q = 0;
            }

            if (this.hp <= 0 && this.status != 4 && this.status != 5) {
                this.aj();
            } else if (this.av != null) {
                this.status = 3;
                this.aa();
            } else if (this.pointMove != null && (this.status == 0 || this.status == 2)) {
                this.status = 2;
            }

            if (this.isMe()) {
                if (SettingsTab.gI().g() > 0 && this.hp < (int) ((float) this.hpFull * ((float) SettingsTab.gI().g() / 100.0F)) && (!this.g(6) || AutoPro.isAuto(10))) {
                    GameSrc.gI().c(false);
                }

                if (SettingsTab.gI().j() > 0 && this.mp < (int) ((float) this.mpFull * ((float) SettingsTab.gI().j() / 100.0F)) && !this.g(7)) {
                    GameSrc.gI().f(false);
                }

                if (SettingsTab.gI().m() && !this.g(0)) {
                    GameSrc.gI().d(false);
                }
            }

            this.aR = this.B = this.A = false;
            this.u = this.v = this.w = this.x = this.y = this.z = false;
            this.bv = this.bw = this.bx = null;
            this.aE.clear();
            this.aU = 0;
            short var13 = 0;
            Effect var2 = null;
            Effect var3 = null;

            for (int var4 = 0; var4 < this.vEffect.size(); ++var4) {
                Effect var5 = (Effect) this.vEffect.elementAt(var4);

                for (int var6 = 0; var6 < var5.g.size(); ++var6) {
                    Effect var7 = (Effect) var5.g.get(var6);
                    this.b(var7);
                }

                this.b(var5);
                if (var5.id == 79) {
                    if (var5.value == 1) {
                        var13 = 282;
                    } else {
                        var13 = 295;
                    }
                }

                if (var5.id == 80) {
                    var13 = 221;
                }

                if (var5.id == 92) {
                    this.bw = var5;
                }

                if (var5.id == 99) {
                    this.bx = var5;
                }

                if (var5.id == 68) {
                    var2 = var5;
                }

                if (var5.id == 101) {
                    var3 = var5;
                }
            }

            if (var2 != null && var3 != null) {
                var2.a();
            } else if (var2 != null) {
                var2.f.k = -1;
            }

            if (var13 > 0) {
                if (this.aL == null) {
                    this.aL = new Mob();
                    this.aL.id = var13;
                    this.aL.hp = 1;
                    this.aL.b(this.cx, this.cy);
                    this.aL.speedMove = this.aL.getMobTemplate().speedMoveByte;
                    this.aL.cx = this.cx;
                    this.aL.cy = this.cy;
                }

                this.aL.r = (short) (this.cx + (this.i() ? 35 : -35));
                this.aL.s = this.cy;
                this.aL.status = 2;
                if (Utlis.getRange(this.aL.cx, this.aL.cy, this.aL.r, this.aL.s) > 300) {
                    ++this.aL.speedMove;
                    this.aL.cx = this.cx;
                    this.aL.cy = this.cy;
                } else if (Utlis.getRange(this.aL.cx, this.aL.cy, this.aL.r, this.aL.s) > 20) {
                    ++this.aL.speedMove;
                } else {
                    this.aL.speedMove = this.aL.getMobTemplate().speedMoveByte;
                }

                short var15 = this.aL.cx;
                short var17 = this.aL.cy;
                this.aL.t();
                this.aL.x = this.aL.cx;
                this.aL.y = this.aL.cy;
                if (this.aL.cx == var15 && this.aL.cy == var17) {
                    this.aL.dir = this.ag;
                }

                LangLa_lo var19;
                (var19 = new LangLa_lo(0)).setXY(this.aL.cx, this.aL.cy);
                var19.o = this.aL;
                GameSrc.gI().a((Entity) var19);
            } else {
                this.aL = null;
            }

            if (this.bx != null) {
                boolean var16 = this.bh == null;
                if (this.bh == null) {
                    this.bh = new Char();
                    this.bh.setXY(this.cx, this.cy);
                    this.bh.speedMove = this.speedMove;
                    this.bh.cx = (short) (this.cx + (this.i() ? -35 : 35));
                    this.bh.cy = this.cy;
                    this.bh.idClass = this.idClass;
                    this.bh.aT = true;
                }

                this.bh.vEffect.clear();
                this.bh.hpFull = 1000000;
                this.bh.hp = 1000000;
                this.bh.mpFull = 1000000;
                this.bh.mp = 1000000;
                if (!this.bh.j()) {
                    if (this.bh.av == null) {
                        if (Utlis.getRange(this.bh.cx, this.bh.cy, this.cx, this.cy) > 40) {
                            if (this.bh.pointMove == null) {
                                this.bh.pointMove = new PointMove(this.cx, this.cy, this.speedMove);
                            }

                            this.bh.pointMove.cx = (short) (this.cx + (this.i() ? 40 : -40));
                            this.bh.pointMove.b = this.cy;
                            this.bh.status = 2;
                            if (Utlis.getRange(this.bh.cx, this.bh.cy, this.bh.pointMove.cx, this.bh.pointMove.cy) > 300) {
                                ++this.bh.speedMove;
                                this.bh.cx = this.cx;
                                this.bh.cy = this.cy;
                            } else if (Utlis.getRange(this.bh.cx, this.bh.cy, this.bh.pointMove.cx, this.bh.pointMove.cy) > 20) {
                                ++this.bh.speedMove;
                            } else {
                                this.bh.speedMove = this.speedMove;
                            }
                        } else if (this.I() == null && this.bh.I() != null) {
                            short var20;
                            if (c(var20 = (short) (this.cx + (this.i() ? 40 : -40)), this.cy) == null) {
                                this.bh.a(var20, this.cy, true);
                            } else if (c(var20 = (short) (this.cx + (this.i() ? -40 : 40)), this.cy) == null) {
                                this.bh.a(var20, this.cy, true);
                            } else {
                                this.bh.a(this.cx, this.cy, true);
                            }
                        } else {
                            this.bh.pointMove = null;
                            this.bh.vPointMove.clear();
                            this.bh.status = 0;
                        }
                    }
                } else if (!var16 && this.bh.hp > 0) {
                    this.bh.N();
                }

                this.bh.t();
                this.bh.aE.clear();
                this.bh.aE.addAll(this.a(this.arrItemBody, false));
                if (!Utlis.f()) {
                    GameSrc.gI().a((Entity) this.bh);
                }
            } else {
                this.bh = null;
            }

            if (!this.x) {
                this.n = -1;
            }

            if (this.aR) {
                this.pointMove = null;
                this.cleanVecMove();
            }

            this.a(this.aR);
            if (this.D > 0) {
                --this.D;
            }

            this.aE.addAll(this.Q());
            this.al();
            if (DataCenter.gI().currentScreen instanceof SelectCharScreen) {
                this.l();
            } else if (!this.isMe() && this.vPointMove.size() > 0 && this.status != 2 && this.status != 7) {
                this.Z();
            }

            switch (this.status) {
                case 0:
                    this.K();
                    this.af = 0;
                    this.ai = this.cx;
                    this.aj = this.cy;
                case 1:
                default:
                    break;
                case 2:
                    if (!this.aR) {
                        this.Z();
                    } else {
                        this.l();
                    }
                    break;
                case 3:
                    this.K();
                    this.ah();
                    this.ai = this.cx;
                    this.aj = this.cy;
                    break;
                case 4:
                    this.ad();
                    this.ai = this.cx;
                    this.aj = this.cy;
                    break;
                case 5:
                    this.ae();
                    if (this.al == this.cx) {
                        this.ai = this.cx;
                    }

                    this.aj = (short) (this.cy + 50);
                    if (this.aj > this.am) {
                        this.aj = this.am;
                    }
                    break;
                case 6:
                    this.ai = this.cx;
                    this.aj = this.cy;
                    break;
                case 7:
                    if (this.r()) {
                        DataCenter.gI();
                    }

                    this.af();
            }

            if (this.status != 5) {
                this.bs = 0;
            }

            MoveSmart.d();
            this.W();
            if (this.aw != null) {
                this.aa = -1;
                LangLa_iy var23 = this.aw;
                throw null;
            }

            if (this.isMe() && Utlis.time() - GameSrc.gI().bF > 5000L && GameSrc.gI().bG != 0 && GameSrc.gI().bH != 0 && GameSrc.gI().bG == this.cx && GameSrc.gI().bH == this.cy) {
                this.pointMove = new PointMove(GameSrc.gI().bG, GameSrc.gI().bH, this.speedMove);
                GameSrc.gI().bG = GameSrc.gI().bH = 0;
            }

            if (this.ax != null && this.ax.a()) {
                this.a(this.ax.a, this.ax.b);
                if (this.isMe()) {
                    GameSrc var22 = GameSrc.gI();
                    boolean var14 = true;
                    var22.ap = var14;
                    GameSrc.gI().aA = this.ax.b;
                    GameSrc.gI().ce = this.ax.b;
                    GameSrc.gI().cf = 100;
                }

                this.ax = null;
            }

            if (!this.a(this.cx, this.cy) && !GameSrc.gI().bN && !AutoPro.isAuto(12)) {
                PointMove var18 = new PointMove(this.cx, this.cy, this.speedMove);
                this.a(var18, 1, false);
                this.cx = var18.cx;
                this.cy = var18.cy;
            }
//            
            return;
        } catch (Exception var10) {
        } finally {
            gI().K();
        }

    }

    private void b(Effect var1) {
        var1.a(this);
        switch (var1.id) {
            case 8:
                this.u = true;
                return;
            case 9:
                this.v = true;
                return;
            case 10:
                this.w = true;
                return;
            case 12:
            case 35:
            case 36:
            case 71:
            case 106:
                this.aR = true;
                return;
            case 31:
                DataCenter.gI().G[450].a(this.aE);
                this.aQ = true;
                return;
            case 38:
                this.aR = true;
                this.x = true;
                if (this.n == -1) {
                    this.n = this.l;
                    return;
                }
                break;
            case 51:
                this.y = true;
                return;
            case 53:
                this.z = true;
                return;
            case 59:
            case 100:
                this.bv = var1;
                return;
            case 64:
                DataCenter.gI().G[383].a(this.aE);
                // The current server uses 64 for the Sage Manual aura, not a disguise.
                // Keep the player's costume visibility setting while drawing the aura.
                return;
            case 68:
                DataCenter.gI().G[451].a(this.aE);
                this.aQ = this.aS = true;
                this.A = true;
                return;
            case 69:
                DataCenter.gI().G[448].a(this.aE);
                this.aQ = true;
                return;
            case 72:
                DataCenter.gI().G[449].a(this.aE);
                this.aQ = true;
                return;
            case 74:
                DataCenter.gI().G[447].a(this.aE);
                this.aQ = true;
                this.B = true;
                return;
            case 82:
                this.aU += var1.value;
                break;
            case 101:
                this.A = true;
                return;
        }

    }

    public int[] c(int var1) {
        Object var2 = null;

        for (int var3 = 0; var3 < gI().arrItemBag.length; ++var3) {
            if (this.arrItemBag[var3] != null && this.arrItemBag[var3].id == var1) {
                return new int[]{var3 % 9 * 32, var3 / 9 * 32};
            }
        }

        return (int[]) var2;
    }

    public int[] u() {
        Vector var1 = new Vector();

        for (int var2 = gI().arrItemBag.length - 1; var2 >= 0; --var2) {
            if (this.arrItemBag[var2] != null && this.arrItemBag[var2].getItemTemplate().type == 1 && this.arrItemBag[var2].getItemTemplate().levelNeed <= this.level() && this.arrItemBag[var2].getItemTemplate().idClass == this.idClass) {
                var1.add(this.arrItemBag[var2]);
            }
        }

        if (var1.size() == 0) {
            return null;
        } else {
            Collections.sort(var1, beatdz.Item.$state_Item().a);
            Item var4 = (Item) var1.get(0);

            for (int var3 = gI().arrItemBag.length - 1; var3 >= 0; --var3) {
                if (this.arrItemBag[var3] != null && this.arrItemBag[var3] == var4) {
                    return new int[]{var3 % 9 * 32, var3 / 9 * 32};
                }
            }

            return null;
        }
    }

    public Item v() {
        for (int var1 = gI().arrItemBag.length - 1; var1 >= 0; --var1) {
            if (this.arrItemBag[var1] != null && this.arrItemBag[var1].getItemTemplate().type == 1) {
                Item var10001 = this.arrItemBag[var1];
                if (gI().idhe == var10001.he) {
                    return this.arrItemBag[var1];
                }
            }
        }

        return null;
    }

    public boolean a(ItemMap var1) {
        for (int var3 = 0; var3 < this.arrItemBag.length; ++var3) {
            Item var2;
            if ((var2 = this.arrItemBag[var3]) == null || var1 != null && var1.item.id == var2.id && var2.getItemTemplate().isXepChong && var2.expiry == var1.item.expiry) {
                return false;
            }
        }

        return true;
    }

    public Item d(int var1) {
        Item var2 = null;

        for (int var3 = 0; var3 < this.arrItemBag.length; ++var3) {
            if ((var2 = this.arrItemBag[var3]) != null && var2.id == var1) {
                return var2;
            }
        }

        return null;
    }

    public Item e(int var1) {
        Item var3 = null;

        for (int var2 = 0; var2 < this.arrItemBody.length; ++var2) {
            if ((var3 = this.arrItemBody[var2]) != null && var3.id == var1) {
                return var3;
            }
        }

        return null;
    }

    public void a(Graphics var1) {
        try {
            if ((this.ax == null || this.ax.d > 10) && !Utlis.f()) {
                if (this.status != 3) {
                    DataCenter.gI();
                }

                if (this.isMe() || !(DataCenter.gI().currentScreen instanceof GameSrc) || !mConfig.gI().readBoolean(10) || GameSrc.gI().aA != null && GameSrc.gI().aA.equals(this) || GameSrc.gI().getMapTemplate().type == 10 && this.typePK != 0) {
                    Graphics var2 = var1;
                    Char var8 = this;
                    byte var3 = this.l;
                    if (this.x) {
                        var3 = this.n;
                    } else if (this.aN > 0) {
                        --this.aN;
                        var3 = 15;
                    }

                    int var4 = 0;
                    if (this.y) {
                        for (int var5 = 0; var5 < var8.aC.size(); ++var5) {
                            Char var6;
                            if ((var6 = (Char) var8.aC.get(var5)).cx != var8.cx || var6.cy != var8.cy) {
                                ++var4;
                                var2.d(80);
                                var6.a(var2, var6.cx, var6.cy, var8.aE, var8.l, var6.m, var8.i());
                                var2.m = 1.0F;
                            }
                        }

                        if (var4 > 0) {
                            var8.aO = 0;
                        }
                    }

                    if (var8.u) {
                        var2.c(-1090781674);
                    } else if (var8.v) {
                        var2.c(-419606318);
                    } else if (var8.w || var8.x) {
                        var2.c(-263996674);
                    }

                    if (var8.ax != null) {
                        if (var8.ax.c == null) {
                            if (var8.ax.d <= 15) {
                                if (var8.ax.c != null) {
                                    var8.ax.c.b(var2, var8.cx, var8.cy);
                                    var8.ax.c.q();
                                }

                                LangLa_fq.b(var2, 4336, var8.i() ? -360 : 0, var8.cx, var8.cy, 33);
                                return;
                            }

                            var3 = 2;
                        } else if (var8.ax.c.p()) {
                            return;
                        }
                    }

                    if (var8.z) {
                        if (!var8.isMe()) {
                            return;
                        }

                        var2.d(40);
                    }

                    var8.a(var2, var8.cx, var8.cy, var8.aE, var3, var8.m, var8.i());
                    if (var4 == 0 && var8.aO > 0) {
                        if (var8.ag == 2) {
                            if (var8.aO < 95) {
                                var8.a(var2, var8.cx + 40, var8.cy, var8.aE, var3, var8.m, var8.i());
                            }

                            if (var8.aO < 90) {
                                var8.a(var2, var8.cx - 40, var8.cy, var8.aE, var3, var8.m, var8.i());
                            }
                        } else {
                            if (var8.aO < 95) {
                                var8.a(var2, var8.cx - 40, var8.cy, var8.aE, var3, var8.m, var8.i());
                            }

                            if (var8.aO < 90) {
                                var8.a(var2, var8.cx + 40, var8.cy, var8.aE, var3, var8.m, var8.i());
                            }
                        }
                    }

                    var2.m = 1.0F;
                    var2.c();
                    if (var8.ax != null && var8.ax.c != null) {
                        var8.ax.c.b(var2, var8.cx, var8.cy);
                        var8.ax.c.q();
                    }
                }

            }
        } catch (Exception var7) {
            Utlis.println(var7);
        }
    }

    public boolean w() {
        return this.isMe() && GameSrc.gI().aR != null;
    }

    public void a(Graphics var1, int var2, int var3, Vector var4, int var5, int var6, boolean var7) {
        a(var4, var5);
        int var10 = Integer.MIN_VALUE;
        boolean var9 = false;
        LangLa_jr customCostume = null;
        boolean hasCape = false;

        LangLa_jr var8;
        int var11;
        for (var11 = 0; var11 < var4.size(); ++var11) {
            var8 = (LangLa_jr) var4.elementAt(var11);
            if (CostumeCape.isNewBody(var8)) customCostume = var8;
            hasCape |= var8.equippedCape;
            if (var8.b()) {
                if (this.idClass == 3 && this.gioiTinh == 1) {
                    var10 = 34;
                } else {
                    var10 = 35;
                }
            }

            if (var8.c()) {
                if (this.idClass == 3 && this.gioiTinh == 1) {
                    var10 = 34;
                } else {
                    var10 = 22;
                }
            }

            if (var8.a == 713 || var8.a == 787) {
                var9 = true;
            }
        }

        if (var9) {
            var10 = Integer.MIN_VALUE;
        }

        boolean fitCape = customCostume != null && hasCape;
        boolean backPose = fitCape && CostumeCape.showsBack(var5);
        if (fitCape && !backPose) CostumeCape.draw(var1, var4, customCostume, var5, var2, var3, var7);

        for (var11 = 0; var11 < var4.size(); ++var11) {
            var8 = (LangLa_jr) var4.elementAt(var11);
            if (fitCape && var8.equippedCape) continue;
            int var15 = var5;
            if (var8.e()) {
                var15 = var6;
            }

            int var12 = var1.a;
            int var13 = var1.b;
            if (var8.d() && var10 != Integer.MIN_VALUE) {
                var1.setClip(var2 - 50, var3 + var8.d[var15].e - var10, 100, 200);
            }

            if (var8.c != 0) {
                var1.d((float) var8.c);
            }

            if (var7) {
                LangLa_fq.b(var1, var8.d[var15].a, Utlis.b(var8.d[var15].b), var2 - var8.d[var15].d, var3 + var8.d[var15].e, 33);
            } else {
                LangLa_fq.b(var1, var8.d[var15].a, Utlis.a(var8.d[var15].b), var2 + var8.d[var15].d, var3 + var8.d[var15].e, 33);
            }

            if (var8.c != 0) {
                var1.h();
            }

            if (var8.d() && var10 != Integer.MIN_VALUE) {
                var1.a(-var1.a, -var1.b);
                var1.a(0, 0);
                var1.setClip(0, 0, DataCenter.gI().widthScreen, DataCenter.gI().heightScreen);
                var1.a(var12, var13);
            }
            if (fitCape && backPose && var8 == customCostume) {
                CostumeCape.draw(var1, var4, customCostume, var5, var2, var3, var7);
            }
        }

    }

    private void X() {
        this.status = 7;
        this.an = this.cx;
        this.ao = this.cy;
        this.ah = 1;
    }

    private void Y() {
        if (DataCenter.gI().i % 4 == 0) {
            if (this.aC.size() >= 3) {
                this.aC.remove(0);
            }

            Char var1;
            (var1 = new Char()).setXY(this.cx, this.cy);
            var1.status = this.status;
            var1.dir = this.dir;
            var1.ag = this.ag;
            var1.l = this.l;
            var1.aE.addAll(this.aE);
            this.aC.add(var1);
        }

        if (this.aO > 0) {
            --this.aO;
        }

    }

    private boolean Z() {
        try {
            this.bj = this.cx;
            this.bk = this.cy;
            int var1 = 0;
            int var2 = 0;
            boolean var5 = false;
            if (this.arrItemBody[10] != null && this.aa <= 50) {
                ++this.aa;
            }

            if (this.pointMove != null) {
                this.a(this.pointMove);
                int var3;
                int var4;
                if (this.pointMove.c != 0) {
                    var3 = this.pointMove.c + this.vPointMove.size();
                    var4 = this.pointMove.c + this.vPointMove.size();
                } else {
                    var3 = this.pointMove.a;
                    var4 = this.pointMove.b;
                }

                // Accelerate ground travel only; keep jump/fall and server stats unchanged.
                if (this.pointMove.h <= 0 && this.cy == this.pointMove.cy && this.aw == null)
                    var3 = horizontalSpeed(var3);

                if (this.aw != null) {
                    var3 = 11;
                    var4 = 11;
                    var5 = true;
                }

                int var6;
                int var7;
                if (this.pointMove.h <= 0) {
                    if (this.cx != this.pointMove.cx && this.cy != this.pointMove.cy) {
                        var5 = true;
                        var6 = Utlis.getRange(this.cx, this.pointMove.cx);
                        var7 = Utlis.getRange(this.cy, this.pointMove.cy);
                        if (var6 < var3) {
                            var3 = var6;
                        }

                        if (var7 < var4) {
                            var4 = var7;
                        }

                        if (var6 > var7) {
                            var1 = var3;
                            var2 = var7 / (var6 / var3);
                        } else if (var7 > var6) {
                            var2 = var4;
                            var1 = var6 / (var7 / var4);
                        } else {
                            var1 = var3;
                            var2 = var4;
                        }

                        if (this.pointMove.cx < this.cx) {
                            var1 = -var1;
                        }

                        if (this.pointMove.cy < this.cy) {
                            var2 = -var2;
                        }
                    } else {
                        if (Utlis.getRange(this.cx, this.cy, this.pointMove.cx, this.pointMove.cy) < 20) {
                            if (this.cy < this.pointMove.cy) {
                                var2 = var4;
                            } else if (this.cy > this.pointMove.cy) {
                                var2 = -var4;
                            } else if (this.cx < this.pointMove.cx) {
                                var1 = var3;
                            } else if (this.cx > this.pointMove.cx) {
                                var1 = -var3;
                            }
                        } else if (this.cy < this.pointMove.cy) {
                            var2 = var4;
                        } else if (this.cy > this.pointMove.cy) {
                            var2 = -var4;
                        } else if (this.cx < this.pointMove.cx) {
                            var1 = var3;
                        } else if (this.cx > this.pointMove.cx) {
                            var1 = -var3;
                        }

                        var6 = Utlis.getRange(this.cx, this.pointMove.cx);
                        var7 = Utlis.getRange(this.cy, this.pointMove.cy);
                        if (var6 < Utlis.positive(var1)) {
                            var1 = var1 > 0 ? var6 : -var6;
                        }

                        if (var7 < Utlis.positive(var2)) {
                            var2 = var2 > 0 ? var7 : -var7;
                        }
                    }
                } else {
                    PointMove var10 = this.pointMove;
                    var6 = 0;
                    if (var10.h > 0) {
                        var10.e = var10.cy;
                        if (SettingsTab.gI().autoTrain && !var10.l) {
                            var10.h = 0;
                        } else {
                            var7 = var10.cx - this.cx;
                            if (var10.a()) {
                                var10.f = var10.e - this.cy << 2;
                                var10.g += var10.f;
                                var6 = var10.g >> 4;
                                var10.g &= 15;
                                byte var8 = 10;
                                if (Utlis.positive(var10.i - this.cy) > var10.j) {
                                    var8 = var10.c;
                                }

                                if (var6 < -var8) {
                                    var6 = -var8;
                                }

                                if (var6 >= 0) {
                                    var6 = -1;
                                }

                                if (this.cy + var6 <= var10.e) {
                                    if (var10.k) {
                                        var10.h = 0;
                                    } else {
                                        var6 = 0;
                                        var10.m = 8;
                                        var10.e = var10.cy;
                                        var10.f = var10.g = 0;
                                        var10.f = 0;
                                        ++var10.h;
                                    }
                                }
                            } else {
                                XYEntity var12;
                                if (var10.b()) {
                                    if ((var12 = c(this.cx, this.cy + 0)) != null) {
                                        var10.cy = (short) (var12.cy - 1);
                                    }

                                    ++var10.f;
                                    var6 = var10.f;
                                    if (this.cy + var6 >= var10.cy) {
                                        var6 = var10.cy - this.cy;
                                        var10.h = 0;
                                        GameSrc.gI().I.add(new LangLa_jw(131, this.cx, this.cy));
                                        if (this.isMe()) {
                                            LangLa_dp.a().k();
                                        }
                                    }
                                } else if (var10.c()) {
                                    if (var10.m > 0) {
                                        --var10.m;
                                        var6 = 4 - var10.m;
                                    } else {
                                        var6 = var10.e - this.cy;
                                        if ((var12 = c(this.cx, this.cy + var6)) != null) {
                                            var10.cy = (short) (var12.cy - 1);
                                            var10.a(var10.i, var10.j);
                                        } else {
                                            var10.h = 0;
                                        }
                                    }
                                }
                            }

                            int var10001 = this.cx + var7;
                            short var10002 = this.cy;
                            if (GameSrc.gI().h.a(var10001, var10002 + var6)) {
                                var7 = 0;
                            }

                            this.cx = (short) (this.cx + var7);
                            if (this.cx <= 16) {
                                this.cx = 16;
                            } else if (this.cx >= GameSrc.gI().maxX - 16) {
                                this.cx = (short) (GameSrc.gI().maxX - 16);
                            }

                            this.cy = (short) (this.cy + var6);
                        }
                    }

                    this.y();
                }
            }

            this.cx = (short) (this.cx + var1);
            this.cy = (short) (this.cy + var2);
            this.ai = this.cx;
            this.aj = this.cy;
            if (var2 < 0 && var1 == 0) {
                this.af = 2;
                this.ac();
                if (!this.isMe()) {
                    this.dir = 1;
                }
            } else if (var2 > 0 && var1 == 0) {
                DataCenter.gI();
                this.af = 4;
                if (!this.isMe()) {
                    this.dir = 0;
                }

                if (this.I() == null) {
                    GameSrc.gI().I.add(new LangLa_jw(131, this.cx, this.cy));
                    this.ab();
                }
            } else {
                XYEntity var13 = this.I();
                DataCenter.gI();
                if (var13 != null) {
                    this.af = 3;
                    this.ac();
                } else {
                    this.af = 1;
                    this.ab();
                }
            }

            if (this.pointMove != null && this.cx == this.pointMove.cx && this.cy == this.pointMove.cy || this.pointMove == null && this.vPointMove.size() == 0) {
                this.pointMove = null;
                this.l();
            }

            if (this.pointMove == null && this.vPointMove.size() > 0) {
                this.pointMove = (PointMove) this.vPointMove.firstElement();
                if (this.cx == this.pointMove.cx && this.pointMove.cy > this.cy) {
                    if (this.bE < this.pointMove.c) {
                        this.bE = this.pointMove.c;
                    }

                    if (Utlis.nextInt((int) 3) < 2) {
                        ++this.bE;
                    }

                    this.pointMove.c = this.bE;
                } else {
                    this.bE = 0;
                }

                this.vPointMove.removeElement(this.pointMove);
                this.a(this.pointMove);
            }

            ++this.f;
            if (this.f >= 20) {
                this.f = 0;
                if (this.w) {
                    LangLa_ls var11 = new LangLa_ls(this);
                    this.h.addElement(var11);
                }
            }

            if (!var5 && this.isMe() && this.cx != beatdz.SessionMove.$state_SessionMove().x && this.cy != beatdz.SessionMove.$state_SessionMove().y) {
                return true;
            }
        } catch (Exception var9) {
        }

        return false;
    }

    private void aa() {
        if (this.isMe()) {
            GameSrc.gI().bP = true;
        }

    }

    private void ab() {
        if (Utlis.time() - this.bt > 400L && !this.R()) {
            this.bt = Utlis.time();
            if (this.isMe()) {
                LangLa_dp.a().a(0.7F);
            }
        }

    }

    private void ac() {
        if (Utlis.time() - this.bu > 850L && !this.R()) {
            this.bu = Utlis.time();
            if (this.isMe()) {
                LangLa_dp.a().b(0.7F);
            }
        }

    }

    public void a(PointMove var1) {
        byte var2 = this.ag;
        if (this.cx < var1.cx) {
            this.ag = this.dir = 2;
        } else if (this.cx > var1.cx) {
            this.ag = this.dir = 3;
        }

        if (var2 != this.ag) {
            for (int var3 = 0; var3 < this.vEffect.size(); ++var3) {
                ((Effect) this.vEffect.elementAt(var3)).b();
            }
        }

    }

    private void a(boolean var1) {
        if (this.status != 0 && !var1) {
            if (this.status == 2) {
                XYEntity var2 = this.I();
                DataCenter.gI();
                if (var2 != null) {
                    if (this.dir == 1) {
                        this.af = 2;
                    } else if (this.dir == 0) {
                        this.af = 4;
                    } else {
                        this.af = 3;
                    }
                } else {
                    this.af = 1;
                }

                this.y();
            } else if (this.status == 1) {
                this.af = 5;
                this.y();
            } else if (this.status == 4) {
                this.af = 6;
                this.y();
            }
        } else {
            if (this.I() != null) {
                this.af = 2;
            } else {
                this.af = 0;
            }

            this.y();
        }

        this.H();
    }

    private void ad() {
        this.cx = this.al;
        this.cy = this.am;
        if (this.isMe()) {
            GameSrc.gI().aR = null;
        }

        XYEntity var1;
        if ((var1 = this.I()) != null) {
            this.cx = this.al = var1.cx;
            this.cy = this.am = var1.cy;
        } else if (this.isMe()) {
            if (!SettingsTab.gI().n() || GameSrc.gI().getMapTemplate().type == 10 || gI().vangKhoa <= 0 && gI().vang <= 0) {
                if (GameSrc.gI().cc || SettingsTab.gI().D() && SettingsTab.gI().autoTrain && !GameSrc.gI().E()) {
                    GameSrc.gI().cc = true;
                    GameSrc.gI().cd = 120;
                    LangLa_b.e();
                }
            } else {
                LangLa_b.f();
            }
        }
    }

    public static void x() {
        if (GameSrc.gI().cE instanceof GameSrc && GameSrc.gI().getMapTemplate().type != 10) {
            GameSrc.gI().a((LangLa_cx) (new LangLa_b(GameSrc.gI())));
        }

    }

    private void ae() {
        ++this.bs;
        if (this.bp == 0) {
            int var1 = this.am - 60;
            int var2 = Utlis.positive(this.al - this.cx);
            int var3 = Utlis.positive(var1 - this.cy);
            this.bo = var2 / 4;
            this.bn = var3 / 4;
            if (this.bo <= 0) {
                this.bo = 1;
            }

            if (this.bn <= 0) {
                this.bn = 1;
            }

            if (this.cx > this.al) {
                this.cx = (short) (this.cx - this.bo);
            } else if (this.cx < this.al) {
                this.cx = (short) (this.cx + this.bo);
            }

            if (this.cy > var1) {
                this.cy = (short) (this.cy - this.bn);
            } else if (this.cy < var1) {
                this.cy = (short) (this.cy + this.bn);
            }

            if (this.cx == this.al && this.cy == var1 || this.bs > 10) {
                this.bp = 1;
                this.bn = 0;
            }

        } else {
            this.cy = (short) (this.cy + this.bn);
            ++this.bn;
            this.cx = this.al;
            if (this.cy > this.am) {
                this.cy = this.am;
            }

            if (this.cy == this.am) {
                this.D = 10;
                this.aj();
                GameSrc.gI().H.addElement(new LangLa_hm(206, this.m(), this.cy));
            }

        }
    }

    private void af() {
        this.ac();
        if (this.ah == 1) {
            this.d(this.an, this.ao);
            if (this.pointMove != null || this.vPointMove.size() > 0) {
                this.status = 2;
            }

            this.af = 2;
        } else if (this.ah == 2) {
            this.cy = (short) (this.cy + this.bn);
            ++this.bn;
            if (this.cy > this.ao) {
                this.cy = this.ao;
            }

            this.af = 4;
            if (this.cx == this.an && this.cy == this.ao) {
                GameSrc.gI().I.add(new LangLa_jw(131, this.cx, this.cy));
                this.ab();
                this.ah = 0;
                this.l();
                this.aa();
            }
        }

        this.y();
    }

    public void y() {
        if (!this.j() && this.pointMove != null) {
            if (this.pointMove.a()) {
                this.af = 2;
            } else if (this.pointMove.b()) {
                this.af = 4;
            } else if (this.pointMove.c()) {
                this.af = 6;
            }
        }

        ++this.e;
        if (this.R()) {
            this.af = 0;
        }

        if (this.e >= DataCenter.gI().af[this.af].length) {
            this.e = 0;
        }

        this.l = this.m = DataCenter.gI().af[this.af][this.e];
    }

    private void ag() {
        ++this.e;
        if (this.R()) {
            this.af = 0;
        }

        if (this.e >= DataCenter.gI().af[this.af].length) {
            this.e = 0;
        }

        this.m = DataCenter.gI().af[this.af][this.e];
    }

    private void ah() {
        if (this.pointMove2 != null) {
            this.pointMove = this.pointMove2;
            this.pointMove2 = null;
            this.Z();
        } else {
            if (this.av != null) {
                this.av.a();
            } else {
                this.l();
            }

            this.ag();
        }
    }

    public void b(int var1, int var2) {
        if (GameSrc.gI().getMapTemplate().type == 10) {
            BlockMap var3;
            (var3 = new BlockMap()).arrayXY = new XYEntity[5];
            var3.arrayXY[0] = new XYEntity();
            var3.arrayXY[0].setXY(481, 674);
            var3.arrayXY[1] = new XYEntity();
            var3.arrayXY[1].setXY(1029, 395);
            var3.arrayXY[2] = new XYEntity();
            var3.arrayXY[2].setXY(1029, 446);
            var3.arrayXY[3] = new XYEntity();
            var3.arrayXY[3].setXY(489, 705);
            var3.arrayXY[4] = new XYEntity();
            var3.arrayXY[4].setXY(481, 674);
            if (var3.a(var1, var2)) {
                return;
            }
        }

        if (!this.b(false) && this.ax == null) {
            this.l();
            if (AutoPro.isAuto(12)) {
                this.pointMove = new PointMove((short) var1, (short) var2, speedMove);
            }
            else
            {
                
               MoveSmart.a(GameSrc.gI().mapID, var1, var2);
            }
        }
    }

    public boolean z() {
        return this.av != null && this.ay.idTemplate == 11;
    }

    public boolean A() {
        MoveSmart.b();
        if (this.r()) {
            PointMove var10000 = this.pointMove;
            var10000.cx = (short) (var10000.cx - 5);
            return false;
        } else {
            return this.a(this.cx - horizontalSpeed(this.speedMove), this.cy, (byte) 3);
        }
    }

    public boolean B() {
        MoveSmart.b();
        if (this.r()) {
            PointMove var10000 = this.pointMove;
            var10000.cx = (short) (var10000.cx + 5);
            return false;
        } else {
            return this.a(this.cx + horizontalSpeed(this.speedMove), this.cy, (byte) 2);
        }
    }

    public boolean a(int var1, int var2, byte var3) {
        byte var4 = this.ag;
        boolean var9 = false;

        label363:
        {
            int var14;
            label364:
            {
                label384:
                {
                    int var5;
                    label385:
                    {
                        label365:
                        {
                            try {
                                label380:
                                {
                                    var9 = true;
                                    if (!GameSrc.gI().isTimeHoatDong && (var1 <= 15 || var1 >= GameSrc.gI().maxX - 15)) {
                                        for (var5 = 0; var5 < GameSrc.gI().vWayPoint.size(); ++var5) {
                                            WayPoint var6;
                                            if ((var6 = (WayPoint) GameSrc.gI().vWayPoint.elementAt(var5)) != null && var6.cy - 50 <= this.cy && this.cy <= var6.cy + 5 && Utlis.getRange(var6.cx, var1) < 300) {
                                                GameSrc.gI().a(this.cx, this.cy);
                                                var9 = false;
                                                break label363;
                                            }
                                        }
                                    }

                                    GameSrc.gI().aR = null;
                                    GameSrc.gI().aq = false;
                                    if (gI().j()) {
                                        gI();
                                        x();
                                        var9 = false;
                                        break label384;
                                    }

                                    if (this.av == null) {
                                        if (this.b(false)) {
                                            var9 = false;
                                            break label364;
                                        }

                                        if (this.ah != 1) {
                                            if (this.ax != null) {
                                                var9 = false;
                                                break label364;
                                            }

                                            gI().l();
                                            if (var3 != 3 && var3 != 2 || this.ag == var3) {
                                                this.dir = var3;
                                                this.status = 2;
                                                boolean var12 = true;
                                                GameSrc.gI().cO.e = var12;
                                                if (this.ah == 0) {
                                                    DataCenter.gI();
                                                }

                                                PointMove var13 = new PointMove((short) var1, (short) var2, this.speedMove, this.speedMove);
                                                this.pointMove = this.b(var13);
                                                var9 = false;
                                                break label385;
                                            }

                                            this.ag = var3;
                                            var9 = false;
                                            break label380;
                                        }

                                        var9 = false;
                                        break label364;
                                    }

                                    var9 = false;
                                    break label364;
                                }
                            } catch (Exception var10) {
                                var9 = false;
                                break label365;
                            } finally {
                                if (var9) {
                                    if (var4 != this.ag) {
                                        for (var2 = 0; var2 < this.vEffect.size(); ++var2) {
                                            ((Effect) this.vEffect.elementAt(var2)).b();
                                        }
                                    }

                                }
                            }

                            if (var4 != this.ag) {
                                for (var14 = 0; var14 < this.vEffect.size(); ++var14) {
                                    ((Effect) this.vEffect.elementAt(var14)).b();
                                }
                            }

                            return true;
                        }

                        if (var4 != this.ag) {
                            for (var5 = 0; var5 < this.vEffect.size(); ++var5) {
                                ((Effect) this.vEffect.elementAt(var5)).b();
                            }
                        }

                        return true;
                    }

                    if (var4 != this.ag) {
                        for (var5 = 0; var5 < this.vEffect.size(); ++var5) {
                            ((Effect) this.vEffect.elementAt(var5)).b();
                        }
                    }

                    return true;
                }

                if (var4 != this.ag) {
                    for (var14 = 0; var14 < this.vEffect.size(); ++var14) {
                        ((Effect) this.vEffect.elementAt(var14)).b();
                    }
                }

                return false;
            }

            if (var4 != this.ag) {
                for (var14 = 0; var14 < this.vEffect.size(); ++var14) {
                    ((Effect) this.vEffect.elementAt(var14)).b();
                }
            }

            return false;
        }

        if (var4 != this.ag) {
            for (var1 = 0; var1 < this.vEffect.size(); ++var1) {
                ((Effect) this.vEffect.elementAt(var1)).b();
            }
        }

        return false;
    }

    public boolean C() {
        GameSrc.gI().aR = null;
        GameSrc.gI().aq = false;
        this.dir = 1;
        if (gI().j()) {
            gI();
            x();
            return false;
        } else if (this.av == null && !this.b(false) && this.ax == null) {
            DataCenter.gI();
            if (this.ah == 0) {
                this.X();
                return true;
            } else if (this.ah == 2) {
                this.status = 2;
                boolean var2 = true;
                GameSrc.gI().cO.e = var2;
                PointMove var1 = new PointMove(this.cx, (short) (this.cy - this.speedMove), this.speedMove, this.speedMove);
                this.pointMove = this.b(var1);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean D() {
        GameSrc.gI().aR = null;
        GameSrc.gI().aq = false;
        this.dir = 0;
        if (gI().j()) {
            gI();
            x();
            return false;
        } else if (this.av == null && !this.b(false) && this.ah != 1 && this.ax == null) {
            gI().l();
            if (this.dir != 0) {
                this.dir = 0;
                return true;
            } else {
                boolean var3;
                if (this.R()) {
                    this.status = 2;
                    var3 = true;
                    GameSrc.gI().cO.e = var3;
                    PointMove var4 = new PointMove(this.cx, (short) (this.cy + this.speedMove), this.speedMove, this.speedMove);
                    this.pointMove = var4;
                    return true;
                } else {
                    XYEntity var1;
                    if ((var1 = this.I()) != null) {
                        this.status = 2;
                        var3 = true;
                        GameSrc.gI().cO.e = var3;
                        PointMove var2 = new PointMove(this.cx, (short) (this.cy + this.speedMove), this.speedMove, this.speedMove);
                        if (!this.a(var2.cx, var2.cy)) {
                            var2 = new PointMove(var1.cx, var1.cy, this.speedMove);
                        }

                        this.pointMove = var2;
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }
    }

    private void ai() {
        this.vPointMove.addAll(this.bF);
        this.status = 2;
        this.bF.clear();
    }

    public void a(short var1, short var2, boolean var3) {
        try {
            if (!this.isMe()) {
                DataCenter.gI();
            }

            this.bF.addElement(new PointMove(var1, var2, this.speedMove));
            this.bG = System.currentTimeMillis();
            if (this.bF.size() > 5 || var3) {
                this.ai();
            }

        } catch (Exception var4) {
        }
    }

    public void cleanVecMove() {
        this.bF.clear();
        this.vPointMove.clear();
    }

    public void stopMove() {
        if (this.isMe()) {
            this.pointMove = null;
            this.cleanVecMove();
            this.l();
            MoveSmart.b();
        }

    }

    public void cleanMove() {
        GameSrc.gI().aA = null;
        GameSrc.gI().aq = false;
        this.stopMove();
    }

    public void l() {
        if (this.av != null) {
            this.status = 3;
            this.aa();
        } else {
            this.status = 0;
            this.pointMove = null;
        }
    }

    private static void a(Vector var0, int var1) {
        try {
            for (int var5 = 0; var5 < var0.size() - 1; ++var5) {
                LangLa_jr var2 = (LangLa_jr) var0.elementAt(var5);

                for (int var6 = var5 + 1; var6 < var0.size(); ++var6) {
                    LangLa_jr var3 = (LangLa_jr) var0.elementAt(var6);
                    LangLa_jr var4;
                    if (var2.d[var1].c > var3.d[var1].c) {
                        var4 = var3;
                        var3 = var2;
                        var2 = var4;
                        var0.setElementAt(var4, var5);
                        var0.setElementAt(var3, var6);
                    } else if (var2.d[var1].c == var3.d[var1].c) {
                        if (var2.d[var1].e < var3.d[var1].e) {
                            var4 = var3;
                            var3 = var2;
                            var2 = var4;
                            var0.setElementAt(var4, var5);
                            var0.setElementAt(var3, var6);
                        } else if (var2.d[var1].e == var3.d[var1].e && var2.d[var1].d < var3.d[var1].d) {
                            var4 = var3;
                            var3 = var2;
                            var2 = var4;
                            var0.setElementAt(var4, var5);
                            var0.setElementAt(var3, var6);
                        }
                    }
                }
            }

        } catch (Exception var7) {
        }
    }

    public void H() {
        try {
            if (!this.P() && !this.ak() && this.status != 7 && this.status != 4 && this.status != 5 && this.av == null && this.ax == null && !this.R() && this.isMe() && !GameSrc.gI().bN && !SettingsTab.gI().autoTrain && !GameSrc.gI().cl.b) {
                XYEntity var1;
                if ((var1 = this.I()) != null) {
                    ++this.br;
                    if (this.br > 10 || Utlis.positive(this.cy - var1.cy) < 40) {
                        this.br = 0;
                        this.d(this.cx, var1.cy - 1);
                    }

                    return;
                }

                this.ah = 0;
            }

            this.br = 0;
        } catch (Exception var2) {
        }
    }

    public static XYEntity c(int var0, int var1) {
        try {
            XYEntity var3;
            if ((var3 = GameSrc.gI().h.c(var0, var1)) != null && Utlis.positive(var1 - var3.cy) > 1) {
                return var3;
            }
        } catch (Exception var2) {
        }

        return null;
    }

    public XYEntity I() {
        return c(this.cx, this.cy);
    }

    private void d(int var1, int var2) {
        this.an = (short) var1;
        this.ao = (short) var2;
        this.ah = 2;
        this.bn = 0;
        this.status = 7;
    }

    private PointMove b(PointMove var1) {
        XYEntity var2;
        if ((var2 = GameSrc.gI().b((XYEntity) var1, (XYEntity) this)) != null) {
            PointMove var3 = new PointMove(var1.cx, this.cy, var1.c);
            if (GameSrc.gI().b((XYEntity) var3, (XYEntity) this) == null) {
                return var3;
            }

            var3 = new PointMove(this.cx, var1.cy, var1.c);
            if (GameSrc.gI().b((XYEntity) var3, (XYEntity) this) == null) {
                return var3;
            }

            this.a(var2, 1, false);
            var1.setXY(var2.cx, var2.cy);
        }

        return var1;
    }

    public XYEntity a(XYEntity xyEntity, int n, boolean b) {
        try {
            for (int i = 1; i < 500; ++i) {
                int n2 = xyEntity.cx + i * n;
                short dd = xyEntity.cy;
                if (this.a(n2, dd)) {
                    xyEntity.setXY(n2, dd);
                    return xyEntity;
                }
                int n3 = xyEntity.cx - i * n;
                short dd2 = xyEntity.cy;
                if (this.a(n3, dd2)) {
                    xyEntity.setXY(n3, dd2);
                    return xyEntity;
                }
                short dc = xyEntity.cx;
                int n4 = xyEntity.cy + i * n;
                if (this.a(dc, n4)) {
                    xyEntity.setXY(dc, n4);
                    return xyEntity;
                }
                short dc2 = xyEntity.cx;
                int n5 = xyEntity.cy - i * n;
                if (this.a(dc2, n5)) {
                    xyEntity.setXY(dc2, n5);
                    return xyEntity;
                }
                int n6 = xyEntity.cx + i * n;
                int n7 = xyEntity.cy - i * n;
                if (this.a(n6, n7)) {
                    xyEntity.setXY(n6, n7);
                    return xyEntity;
                }
                int n8 = xyEntity.cx + i * n;
                int n9 = xyEntity.cy + i * n;
                if (this.a(n8, n9)) {
                    xyEntity.setXY(n8, n9);
                    return xyEntity;
                }
                int n10 = xyEntity.cx - i * n;
                int n11 = xyEntity.cy - i * n;
                if (this.a(n10, n11)) {
                    xyEntity.setXY(n10, n11);
                    return xyEntity;
                }
                int n12 = xyEntity.cx - i * n;
                int n13 = xyEntity.cy + i * n;
                if (this.a(n12, n13)) {
                    xyEntity.setXY(n12, n13);
                    return xyEntity;
                }
            }
        } catch (Exception ex) {
        } finally {
            XYEntity c;
            if (b && (c = c(xyEntity.cx, xyEntity.cy)) != null) {
                xyEntity.setXY(c.cx, c.cy - 1);
            }
        }
        return null;
    }

    public String f() {
        return this.name + " (Lv " + this.level() + ")";
    }

    public String g() {
        return this.hp + "/" + this.hpFull;
    }

    public String h() {
        return this.mp + "/" + this.mpFull;
    }

    public static Item[] readItemBody(Message var0, Item[] var1) throws java.io.IOException {
        for (int var2 = 0; var2 < var1.length; ++var2) {
            var1[var2] = null;
        }

        int var6 = var0.reader.dis.readUnsignedByte();

        for (int var4 = 0; var4 < var6; ++var4) {
            Item var3;
            (var3 = new Item()).id = var0.readShort();
            var3.isLock = var0.readBoolean();
            var3.expiry = var0.readLong();
            var3.he = var0.readByte();
            var3.level = (byte) Math.max(0, Math.min(19, var0.readByte()));
            var3.index = var3.getItemTemplate().type;
            var3.strOptions = var0.reader.readUTF();
            if (var3.index < 0) {
                throw new java.io.IOException("Invalid equipment type: item=" + var3.id + " type=" + var3.index);
            }
            if (var3.index >= var1.length) {
                Utlis.println("Extending equipment slots: item=" + var3.id + " type=" + var3.index);
                var1 = Arrays.copyOf(var1, var3.index + 1);
            }
            var1[var3.index] = var3;
        }
        return var1;
    }

    public static void readItemBag(Message var0, Item[] var1) throws java.io.IOException {
        for (int var2 = 0; var2 < var1.length; ++var2) {
            var1[var2] = null;
        }

        short var6 = var0.readShort();

        for (int var4 = 0; var4 < var6; ++var4) {
            Item var3;
            (var3 = new Item()).read(var0);

            try {
                var1[var3.index] = var3;
            } catch (Exception var5) {
                Utlis.println(var5);
            }
        }

    }

    public int f(int var1) {
        int var2 = 0;

        for (int var3 = 0; var3 < this.arrItemBag.length; ++var3) {
            if (this.arrItemBag[var3] != null && this.arrItemBag[var3].id == var1) {
                var2 += this.arrItemBag[var3].getAmount();
            }
        }

        return var2;
    }

    public int a(int var1, boolean var2) {
        var1 = 0;

        for (int var3 = 0; var3 < this.arrItemBag.length; ++var3) {
            if (this.arrItemBag[var3] != null && this.arrItemBag[var3].id == 160 && !this.arrItemBag[var3].isLock) {
                var1 += this.arrItemBag[var3].getAmount();
            }
        }

        return var1;
    }

    public static boolean J() {
        return !(GameSrc.gI().cE instanceof LangLa_t) && !(GameSrc.gI().cE instanceof LangLa_ae) && !(GameSrc.gI().cE instanceof LangLa_fd) && !(GameSrc.gI().cE instanceof LangLa_bw);
    }

    public void a(long var1, boolean var2, boolean var3) {
        String var4;
        if (var1 - gI().bac > 0) {
            var4 = Caption.k + " " + Utlis.numberFormat(var1 - gI().bac) + " " + Caption.rs[2];
            if (J()) {
                LangLa_kw.a(7, Caption.bz, var4);
            }

            if (var2) {
                DataCenter.gI().currentScreen.showMessage(var4, -1);
            }

            if (var3) {
                LangLa_hy.a("+" + (var1 - gI().bac), gI(), gI().ak, 7);
            }
        } else if (var1 - gI().bac < 0) {
            var4 = Caption.cL + " " + Utlis.numberFormat(-(var1 - gI().bac)) + " " + Caption.rs[2];
            if (J()) {
                LangLa_kw.a(7, Caption.bz, var4);
            }

            if (var2) {
                DataCenter.gI().currentScreen.showMessage(var4, -1);
            }

            if (var3) {
                LangLa_hy.a("" + (var1 - gI().bac), gI(), gI().ak, 7);
            }
        }

        gI().bac = var1;
    }

    public void b(long var1, boolean var2, boolean var3) {
        String var4;
        if (var1 - gI().bacKhoa > 0) {
            var4 = Caption.k + " " + Utlis.numberFormat(var1 - gI().bacKhoa) + " " + Caption.rs[3];
            if (J()) {
                LangLa_kw.a(7, Caption.bz, var4);
            }

            if (var2) {
                DataCenter.gI().currentScreen.showMessage(var4, -1);
            }

            if (var3) {
                LangLa_hy.a("+" + (var1 - gI().bacKhoa), gI(), gI().ak, 8);
            }
        } else if (var1 - gI().bacKhoa < 0) {
            var4 = Caption.cL + " " + Utlis.numberFormat(-(var1 - gI().bacKhoa)) + " " + Caption.rs[3];
            if (J()) {
                LangLa_kw.a(7, Caption.bz, var4);
            }

            if (var2) {
                DataCenter.gI().currentScreen.showMessage(var4, -1);
            }

            if (var3) {
                LangLa_hy.a("" + (var1 - gI().bacKhoa), gI(), gI().ak, 8);
            }
        }

        gI().bacKhoa = var1;
    }

    public void c(long var1, boolean var2, boolean var3) {
        String var4;
        if (var1 - gI().vang > 0) {
            var4 = Caption.k + " " + Utlis.numberFormat(var1 - gI().vang) + " " + Caption.rs[0];
            if (J()) {
                LangLa_kw.a(7, Caption.bz, var4);
            }

            if (var2) {
                DataCenter.gI().currentScreen.showMessage(var4, -1);
            }

            if (var3) {
                LangLa_hy.a("+" + (var1 - gI().vang), gI(), gI().ak, 9);
            }
        } else if (var1 - gI().vang < 0) {
            var4 = Caption.cL + " " + Utlis.numberFormat(-(var1 - gI().vang)) + " " + Caption.rs[0];
            if (J()) {
                LangLa_kw.a(7, Caption.bz, var4);
            }

            if (var2) {
                DataCenter.gI().currentScreen.showMessage(var4, -1);
            }

            if (var3) {
                LangLa_hy.a("" + (var1 - gI().vang), gI(), gI().ak, 9);
            }
        }

        gI().vang = var1;
    }

    public void K() {
        if (this.isMe()) {
            SessionMove.update(true);
        }

    }

    public void a(Skill var1, Entity var2) {
        try {
            if (!this.isMe() && this.pointMove != null) {
                this.vPointMove.indexOf(this.pointMove, 0);
                this.pointMove = null;
            }

            if (!this.b(true)) {//&& (this.status != 3 || var1 != null && var1.myUse)
                if (var1 != null) {
                    var1.myUse = false;
                    if (var1.a(this)) {
                        this.l();
                        this.setDir(var2);
                        if (var1.h() && this.ax == null) {
                            if (var2 == null) {
                                return;
                            }

                            this.ax = new LangLa_eu(var1, var2);
                            if (var1.idTemplate == 36) {
                                this.a(var1);
                            }

                            return;
                        }

                        this.av = new LangLa_iz(var1, this.dir, this, var2);
                        if (this.isMe() && this.bw == null && (var1.idTemplate == 28 || var1.idTemplate == 5 || var1.idTemplate == 10 || var1.idTemplate == 23 || var1.idTemplate == 29)) {
                            GameSrc.gI();
                            aJ = new LangLa_ih(var1.getSkillTemplate().name);
                        }

                        if (var1.idTemplate == 28) {
                            this.aO = 100;
                        }

                        this.status = 3;
                        this.aa();
                        var1.e();
                        this.aa = -1;
                        if (var1.idTemplate != 36) {
                            this.a(var1);
                        }

                        if (!this.isMe() && !this.isMe() && Utlis.inRange(this.a(), this.c(), this.b(), this.cy, DataCenter.gI().j, DataCenter.gI().k, DataCenter.gI().l, DataCenter.gI().m)) {
                            return;
                        }
                    }
                } else if (this.isMe()) {
                    DataCenter.gI().currentScreen.showMessage(Caption.cM, -2560);
                }
            }

        } catch (Exception var3) {
            Utlis.println(var3);
        }
    }

    private void a(Skill var1) {
        if (this.isMe()) {
            LangLa_dp.a().a(this.idClass, var1.idTemplate, this.isMe());
        } else {
            if (Utlis.inRange(this.a(), this.c(), this.b(), this.cy, DataCenter.gI().j, DataCenter.gI().k, DataCenter.gI().l, DataCenter.gI().m)) {
                LangLa_dp.a().a(this.idClass, var1.idTemplate, this.isMe());
            }

        }
    }

    public int L() {
        switch (this.idhe) {
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 1;
            default:
                return 0;
        }
    }

    public int M() {
        switch (this.idhe) {
            case 1:
                return 5;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            default:
                return 0;
        }
    }

    public void a(String var1) {
        GameSrc.gI().aq = false;
        if (this.isMe()) {
            beatdz.GameSrc.$state_GameSrc().aK = var1;
        }

        this.status = 5;
        this.l = 0;
        this.bp = 0;
        this.pointMove = null;
        this.cleanVecMove();
        this.aa = -1;
    }

    public void k() {
        if (Utlis.nextInt((int) 5) == 0) {
            this.aN = 6;
        }

    }

    private void aj() {
        this.status = 4;
        this.al = this.cx;
        this.am = this.cy;
        this.ai = this.al;
        this.aj = this.am;
        if (this.isMe() && (!SettingsTab.gI().n() || gI().vangKhoa <= 0 && gI().vang <= 0)) {
            x();
        }

    }

    public void N() {
        this.status = 0;
        this.aa();
        this.aF.addElement(new LangLa_jw(142, this.m(), this.n(), 4));
    }

    public void setDir(Entity var1) {
        if (!this.b(false)) {
            super.setDir(var1);
            this.ag = this.dir;
        }

    }

    private boolean ak() {
        int var1 = 0;

        while (var1 < this.vEffect.size()) {
            switch (((Effect) this.vEffect.elementAt(var1)).id) {
                case 12:
                case 35:
                case 36:
                case 38:
                case 106:
                    return true;
                default:
                    ++var1;
            }
        }

        return false;
    }

    private boolean b(boolean var1) {
        if (!this.j() && (!GameSrc.gI().ca || !this.isMe())) {
            int var2 = 0;

            while (var2 < this.vEffect.size()) {
                switch (((Effect) this.vEffect.elementAt(var2)).id) {
                    case 12:
                    case 36:
                    case 38:
                    case 75:
                        return true;
                    case 78:
                        if (var1) {
                            return true;
                        }
                    default:
                        ++var2;
                }
            }

            return false;
        } else {
            return true;
        }
    }

    public boolean g(int var1) {
        for (int var2 = 0; var2 < this.vEffect.size(); ++var2) {
            if (((Effect) this.vEffect.elementAt(var2)).getEffectTemplate().type == var1) {
                return true;
            }
        }

        return false;
    }

    public boolean P() {
        return this.vPointMove.size() != 0 || this.pointMove != null || MoveSmart.e();
    }

    public Vector Q() {
        return this.a(this.arrItemBody, this.B);
    }

    public Vector a(Item[] var1, boolean var2) {
        Vector var3 = new Vector();
        if (this.bw != null) {
            this.a(var3, 114, 0);
            return var3;
        } else {
            if (var1[16] != null && var1[16].getItemTemplate().idMob > 0 && !this.aS) {
                if (!this.aQ && var1[14] != null && var1[14].getItemTemplate().idChar > 0) {
                    this.a((Vector) var3, var1[16].getItemTemplate().idMob, 0, var1[14] != null && var1[14].ab() ? 10 : 9);
                } else {
                    this.a(var3, var1[16].getItemTemplate().idMob, 0);
                }
            } else if (var1[14] != null && var1[14].getItemTemplate().idMob > 0) {
                this.a(var3, var1[14].getItemTemplate().idMob, 0);
            }

            if (var1[16] != null && var1[16].getItemTemplate().idChar > 0 && !this.aS) {
                this.a(var3, var1[16].getItemTemplate().idChar, 0);
            } else if (!this.aQ && var1[14] != null && var1[14].getItemTemplate().idChar > 0) {
                this.a(var3, var1[14].getItemTemplate().idChar, 0);
            } else if (var1[2] != null) {
                if (!var2) {
                    this.a(var3, var1[2].getItemTemplate().idChar, 0);
                }
            } else if (!var2) {
                this.a(var3, 0, 0);
            }

            if (var1[10] != null && var1[10].getItemTemplate().idChar > 0) {
                this.a(var3, var1[10].getItemTemplate().idChar, 0);
            }

            Item tanto = this.selectCaiTrang == HIDE_TANTO ? null : var1[15];
            Item reserveTanto = this.selectCaiTrang == HIDE_TANTO ? null : this.arrItemBody2[15];
            if (this.aP >= 0 && DataCenter.gI().ItemTemplate[this.aP].idChar > 0) {
                this.a(var3, DataCenter.gI().ItemTemplate[this.aP].idChar, 0);
            } else if (tanto != null && tanto.id >= 908 && tanto.id <= 911) {
                this.a(var3, tanto.getItemTemplate().idMob, 0);
            } else if (reserveTanto != null && reserveTanto.id >= 908 && reserveTanto.id <= 911) {
                this.a(var3, reserveTanto.getItemTemplate().idMob, 0);
            } else if (tanto != null && tanto.getItemTemplate().idMob > 0) {
                if (var1[16] != null && var1[16].getItemTemplate().idChar > 0) {
                    this.a(var3, tanto.getItemTemplate().idMob, 9);
                } else if (!this.aQ && var1[14] != null && var1[14].getItemTemplate().idChar > 0) {
                    this.a(var3, tanto.getItemTemplate().idMob, 9);
                } else {
                    this.a(var3, tanto.getItemTemplate().idMob, 0);
                }
            } else if (var1[1] != null) {
                if (var1[16] != null && var1[16].getItemTemplate().idChar > 0) {
                    this.a(var3, var1[1].getItemTemplate().idChar, var1[1].level, 9, var1[1].getItemTemplate().levelNeed);
                } else if (!this.aQ && var1[14] != null && var1[14].getItemTemplate().idChar > 0) {
                    this.a(var3, var1[1].getItemTemplate().idChar, var1[1].level, 9, var1[1].getItemTemplate().levelNeed);
                } else {
                    this.a(var3, var1[1].getItemTemplate().idChar, var1[1].level, 0, var1[1].getItemTemplate().levelNeed);
                }
            }

            if (this.arrItemBody2[12] != null && this.arrItemBody2[12].id == 127) {
                this.addEquippedCape(var3, this.arrItemBody2[12]);
            } else if (var1[12] != null && (this.aS || var1[16] == null || var1[16].id != 861)) {
                this.addEquippedCape(var3, var1[12]);
            }

            return var3;
        }
    }

    private void addEquippedCape(Vector parts, Item cape) {
        int first = parts.size();
        this.a(parts, cape.getItemTemplate().idChar, 0);
        for (int i = first; i < parts.size(); i++) {
            ((LangLa_jr) parts.elementAt(i)).equippedCape = true;
        }
    }

    private void al() {
        if (this.R()) {
            if (this.bv.id == 59) {
                this.a(this.aE, 46, 0);
                return;
            }

            if (this.bv.id == 100) {
                if (this.bv.e == 1056) {
                    this.a(this.aE, 132, 0);
                    return;
                }

                if (this.bv.e == 1031) {
                    this.a(this.aE, 129, 0);
                    return;
                }

                if (this.bv.e == 1094) {
                    this.a(this.aE, 146, 0);
                    return;
                }

                if (this.bv.e == 1117) {
                    if (this.bv.g.size() == 2) {
                        this.a(this.aE, 156, 0);
                        return;
                    }

                    this.a(this.aE, 152, 0);
                }
            }
        }

    }

    public boolean R() {
        return this.bv != null;
    }

    private void a(Vector var1, int var2, int var3, int var4, int var5) {
        try {
            var5 /= 10;
            short var7 = LangLa_js.a(var2, this.gioiTinh, this.idClass, this.idChar, var3, var4);
            if (var3 == 19 && var5 == 6) {
                DataCenter.gI().G[var7].a(var1, 10);
            } else if (var3 == 18 && var5 == 5) {
                DataCenter.gI().G[var7].a(var1, 70);
            } else {
                if (var3 != 17 || var5 != 4) {
                    DataCenter.gI().G[var7].a(var1);
                    return;
                }

                DataCenter.gI().G[var7].a(var1, -130);
            }
        } catch (Exception var6) {
        }

    }

    private void a(Vector var1, int var2, int var3) {
        this.a((Vector) var1, var2, var3, 0);
    }

    private void a(Vector var1, int var2, int var3, int var4) {
        try {
            short var6 = LangLa_js.a(var2, this.gioiTinh, this.idClass, this.idChar, var3, var4);
            DataCenter.gI().G[var6].a(var1);
        } catch (Exception var5) {
        }
    }

    public void U() {
        this.aM = mFont.b(mFont.d, this.name);
    }

    public void b(Graphics var1) {
        try {
            if (!this.A && (this.isMe() || !this.z) && !GameSrc.gI().bb && !this.aT) {
                short var3 = this.cx;
                byte var7 = -12;
                if (this.status == 4 && this.D == 0) {
                    var7 = -20;
                }

                int var10000;
                if (this.isMe()) {
                    var10000 = this.cy - var7 - 65;
                } else {
                    var1.f(-16777216);
                    var1.c(var3 - 15, this.cy - var7 - 68, 30, 4);
                    if (GameSrc.gI().a(this)) {
                        var1.f(-3407617);
                    } else if (this.typePK == 2) {
                        if (GameSrc.gI().aI != null && GameSrc.gI().aI.b(this.name)) {
                            var1.f(-16711681);
                        } else {
                            var1.f(-9942667);
                        }
                    } else if (this.typePK != 3 && gI().typePK != 3) {
                        var1.f(-65536);
                    } else if (GameSrc.gI().aI != null && GameSrc.gI().aI.b(this.name)) {
                        var1.f(-16711681);
                    } else {
                        var1.f(-9942667);
                    }

                    var1.c(var3 - 14, this.cy - var7 - 67, this.a(28), 2);
                    var10000 = this.cy - var7 - 70;
                }

                int var4 = var10000;
                var4 = this.a((Graphics) var1, var3, var4, 2);
                if (this.typePK == 2) {
                    LangLa_fq.a(var1, 722 + DataCenter.gI().i / 3 % 6, 0, var3 + this.aM / 2 + 2, var4, 6);
                } else if (this.typePK == 3) {
                    LangLa_fq.a(var1, 728 + DataCenter.gI().i / 3 % 6, 0, var3 + this.aM / 2 + 2, var4, 6);
                }

                var4 -= this.c(var1, var3, var4);
                if (this.rank > 0 && this.rank <= 10) {
                    int[] var5 = new int[]{661, 662, 663, 664, 665, 666, 667, 668, 669, 670};
                    int var10001 = var5[this.rank - 1];
                    var4 -= 9;
                    LangLa_fq.a(var1, var10001, 0, var3, var4, 3);
                }

                var4 = this.d(var1, var3, var4);
                var4 = this.e(var1, var3, var4);
                Vector var10 = new Vector();

                int var6;
                for (var6 = 0; var6 < this.vEffect.size(); ++var6) {
                    Effect var11;
                    if ((var11 = (Effect) this.vEffect.elementAt(var6)).c()) {
                        var10.add(var11);
                    }
                }

                if (var10.size() > 0) {
                    int var9 = -(var10.size() - 1) * 17 / 2;

                    for (var6 = 0; var6 < var10.size(); ++var6) {
                        ((Effect) var10.elementAt(var6)).a(var1, this.cx + var9 - 7 + var6 * 17, var4 - 7, this);
                    }

                    var4 -= 16;
                }

                if (GameSrc.gI().aA != null && GameSrc.gI().aA.equals(this)) {
                    GameSrc.gI().aF.setXY(this.cx, var4 + 4);
                    GameSrc.gI().aF.a(var1);
                }

                if (this.aJ != null) {
                    this.aJ.a(var1);
                }

            }
        } catch (Exception var8) {
            Utlis.println(var8);
        }
    }

    public void b(Graphics var1, int var2, int var3) {
        try {
            var3 = (var3 = this.a((Graphics) var1, var2, var3, 2)) - this.c(var1, var2, var3);
            var3 = this.d(var1, var2, var3);
            this.e(var1, var2, var3);
        } catch (Exception var4) {
            Utlis.println(var4);
        }
    }

    public int a(Graphics var1, int var2, int var3, int var4) {
        if (isMe()) {

            // System.out.println(var2 + " " + var3);
        }
        mFont.b(mFont.d, var1, this.name, var2, var3 - 3, 2, -1, -16777216);
        return var3 - 3;
    }

    private int c(Graphics var1, int var2, int var3) {
        if (this.aI != null) {
            String var4 = "";
            if (this.aI.c == 5) {
                var4 = "TT-";
            } else if (this.aI.c == 4) {
                var4 = "TP-";
            } else if (this.aI.c == 3) {
                var4 = "TL-";
            }

            mFont.b(mFont.d, var1, var4 + this.aI.a, var2, var3 - 10, 2, -2560, -16777216);
            return 10;
        } else {
            return 0;
        }
    }

    private int d(Graphics var1, int var2, int var3) {//paintDanhHieu
        if (beatdz.Char.$state_Char().animation != null) {
            var1.a2(var1, beatdz.Char.$state_Char().animation.getKeyFrame(Canvas.elapsed), 0, var2, var3 - 20, getZ(beatdz.Char.$state_Char().animation.getKeyFrame(Canvas.elapsed).getRegionWidth(), 40), getZ(beatdz.Char.$state_Char().animation.getKeyFrame(Canvas.elapsed).getRegionHeight(), 40));
            return var3 - 20;
        }
        if (this.selectDanhHieu == 0) {
            if (this.arrItemBody[12] != null) {
                String var4 = this.arrItemBody[12].getItemTemplate().name.replaceAll(Caption.kU, "").trim().replaceAll(Caption.oc, "").trim();
                switch (this.V()) {
                    case 1:
                    case 2:
                    case 3:
                        mFont.a(mFont.g, var1, var4, var2, var3 - 10, 2, -16609665, 5, 0);
                        break;
                    case 4:
                        mFont.a(mFont.g, var1, var4, var2, var3 - 10, 2, -16609665, 5, 0);
                        break;
                    case 5:
                        mFont.a(mFont.g, var1, var4, var2, var3 - 10, 2, -37888, 4, 0);
                        break;
                    case 6:
                        mFont.a(mFont.g, var1, var4, var2, var3 - 10, 2, -1506443, 4, 0);
                        break;
                    case 7:
                        mFont.a(mFont.g, var1, var4, var2, var3 - 10, 2, -65536, 4, 0);
                        break;
                    case 8:
                        mFont.a(mFont.g, var1, var4, var2, var3 - 10, 2, -16733953, 3, 0);
                        break;
                    case 9:
                        mFont.a(mFont.g, var1, var4, var2, var3 - 10, 2, -16711774, 3, 0);
                        break;
                    case 10:
                        mFont.a(mFont.g, var1, "<<" + var4 + ">>", var2, var3 - 10, 2, -590080, 3, 0);
                        break;
                    case 11:
                        mFont.a(mFont.g, var1, ">>" + var4 + "<<", var2, var3 - 10, 2, -2161936, 2, 0);
                        break;
                    case 12:
                        mFont.a(mFont.g, var1, "*" + var4 + "*", var2, var3 - 10, 2, -4390367, 3, 0);
                        break;
                    case 13:
                        mFont.a(mFont.h, var1, "+" + var4 + "+", var2 + 1, var3 - 10 + 1, 2, -16569312, 2, 0);
                        mFont.a(mFont.h, var1, "+" + var4 + "+", var2, var3 - 10, 2, -16004447, 3, 0);
                        break;
                    default:
                        mFont.a(mFont.g, var1, var4, var2, var3 - 10, 2, -6487297, 2, 0);
                }

                if (this.V() > 0) {
                    return var3 - 10;
                }
            }
        } else if (this.selectDanhHieu >= 0 && this.selectDanhHieu < this.aG.length) {
            if(this.aG[this.selectDanhHieu].isNew){
                if (this.aG[this.selectDanhHieu].data != null) {
                    var2 += this.aG[this.selectDanhHieu].data.x;
                    var3 += this.aG[this.selectDanhHieu].data.y;
                    int index = ((int) ((System.currentTimeMillis() / this.aG[this.selectDanhHieu].data.timeMS) % this.aG[this.selectDanhHieu].data.array.length));
                    TextureRegion data = this.aG[this.selectDanhHieu].data.array[index];
                    if (data != null) {
                        var1.a2(var1, data, 0, var2, var3, getZ(data.getRegionWidth(), this.aG[this.selectDanhHieu].data.size), getZ(data.getRegionHeight(), this.aG[this.selectDanhHieu].data.size));
                    } else {
                        mImage var23 = LangLa_fq.a((int) this.aG[this.selectDanhHieu].data.array_Id[index]); // => iconClient
                        //mImage var23 = LangLa_fq.a2((int) this.data.array_Id[index]); => iconChar
                        if (var23 != beatdz.LangLa_fq.$state_LangLa_fq().a) {
                            this.aG[this.selectDanhHieu].data.array[index] = (new TextureRegion(var23.b()));
                            Canvas.vImage.remove(var23);
                        }
                    }
                    return var3;
                }
            }else {
                if (this.aG[this.selectDanhHieu].c > 0) {
                    mFont.a(mFont.h, var1, this.aG[this.selectDanhHieu].a.trim(), var2, var3 - 10, 2, -this.aG[this.selectDanhHieu].c, 3, 1, 1, 3);
                    return var3 - 12;
                }

                mFont.a(mFont.g, var1, this.aG[this.selectDanhHieu].a.trim(), var2, var3 - 10, 2, this.aG[this.selectDanhHieu].c, 3, 0);
                return var3 - 10;
            }
        }

        return var3 + 2;
    }

    private int e(Graphics var1, int var2, int var3) {
        LangLa_jw var4 = null;
        LangLa_jw var5 = null;

        for (int var6 = 0; var6 < this.aF.size(); ++var6) {
            LangLa_jw var7;
            if ((var7 = (LangLa_jw) this.aF.elementAt(var6)).j == 84) {
                var4 = var7;
                break;
            }

            if (var7.j == 85) {
                var5 = var7;
                break;
            }
        }

        if (var5 != null) {
            if (var5.l > 24) {
                mFont.b(mFont.g, var1, Caption.iA, var2, var3 - 15, 2, -1, -6817632, 0, 8);
            } else if (var5.l > 19) {
                mFont.b(mFont.g, var1, Caption.iA, var2, var3 - 10, 2, -1, -6817632, 0, 8);
            } else if (var5.l > 14) {
                mFont.b(mFont.g, var1, Caption.iA, var2, var3 - 5, 2, -1, -6817632, 0, 8);
            }
        } else if (var4 != null) {
            if (var4.l > 24) {
                mFont.b(mFont.g, var1, Caption.jq + " " + this.level(), var2, var3 - 15, 2, -1, -16711681, 0, 8);
            } else if (var4.l > 19) {
                mFont.b(mFont.g, var1, Caption.jq + " " + this.level(), var2, var3 - 10, 2, -1, -16711681, 0, 8);
            } else if (var4.l > 14) {
                mFont.b(mFont.g, var1, Caption.jq + " " + this.level(), var2, var3 - 5, 2, -1, -16711681, 0, 8);
            }
        } else if (this.q != 0) {
            if (this.q == 1) {
                mFont.b(mFont.g, var1, Caption.jr, var2, var3 - 14, 2, -1, -2560, 0, 20);
            } else if (this.q == 2) {
                mFont.b(mFont.g, var1, Caption.js, var2, var3 - 14, 2, -1, -2560, 0, 20);
            } else if (this.q == 3) {
                mFont.b(mFont.g, var1, Caption.jt, var2, var3 - 5, 2, -1, -2560, 0, 20);
            }
        } else if (this.isCuuSat) {
            mFont.a(mFont.f, var1, Caption.kW, var2, var3 - 13, 2, -52295, 4, 1);
        } else if (this.typePK == 1) {
            mFont.a(mFont.f, var1, Caption.kV, var2, var3 - 13, 2, -52225, 4, 1);
        } else if (this.statusGD > 0) {
            mFont.a(mFont.f, var1, Caption.bA, var2, var3 - 13, 2, -1, 4, 1);
        }

        return var3 - 13;
    }

    public int e() {
        return 3;
    }

    public void addEffect(Effect var1) {
        int[][] var2 = new int[][]{{51, 52}, {53, 54}, {55, 56, 76}, {57, 58}, {59, 60}, {34, 61}, {62, 63}, {64, 65}, {69, 70}, {68, 70}, {72, 73}, {31, 73}, {74, 77}, {100, 104, 105}};

        for (int var3 = 0; var3 < 14; ++var3) {
            for (int var4 = 0; var4 < var2[var3].length; ++var4) {
                if (var2[var3][var4] == var1.getEffectTemplate().id) {
                    for (int var5 = 0; var5 < this.vEffect.size(); ++var5) {
                        Effect var6 = (Effect) this.vEffect.get(var5);

                        for (int var7 = 0; var7 < var2[var3].length; ++var7) {
                            if (var2[var3][var7] == var6.getEffectTemplate().id) {
                                var6.g.add(var1);
                                return;
                            }
                        }
                    }
                }
            }
        }

        this.vEffect.add(var1);
    }

    public Item[] h(int var1) {
        switch (var1) {
            case 0:
                return this.arrItemBag;
            case 1:
                return this.arrItemBox;
            case 2:
                return this.arrItemBody;
            case 3:
                return this.arrItemBody2;
            case 4:
                return this.arrItemExtend;
            default:
                return null;
        }
    }

    public void readSkillClan(Message var1) {
        try {
            this.aH.clear();
            byte var2 = var1.readByte();
            int var3 = 0;

            while (var3 < var2) {
                byte var4 = var1.readByte();
                byte var5 = var1.readByte();
                int var6 = 0;

                while (true) {
                    if (var6 < DataCenter.gI().vSkillClan.size()) {
                        SkillClan var7;
                        if ((var7 = (SkillClan) DataCenter.gI().vSkillClan.get(var6)).id != var4) {
                            ++var6;
                            continue;
                        }

                        (var7 = var7.a()).a(var5);
                        this.aH.add(var7);
                    }

                    ++var3;
                    break;
                }
            }

            if (LangLa_kl.l() != null) {
                LangLa_kl.l().g();
                if (LangLa_kl.l().E == 0) {
                    LangLa_kl.l().o();
                    return;
                }

                if (LangLa_kl.l().E == 1) {
                    LangLa_kl.l().o();
                }
            }

        } catch (Exception var8) {
        }
    }

    public void readDanhHieu(Message var1) throws java.io.IOException {
        DanhHieu[] var2;
        (var2 = new DanhHieu[var1.readByte() + 1])[0] = new DanhHieu();
        var2[0].a = Caption.lm;

        for (int var3 = 1; var3 < var2.length; ++var3) {
            var2[var3] = new DanhHieu();
            String var4 = var1.reader.readUTF();
            var2[var3].a = var4;
            var2[var3].b = var1.readInt();
            var2[var3].isNew = var1.readBoolean();
            if(var2[var3].isNew){
                readNewDanhHieu(var1, var2[var3]);
            }
            var2[var3].a();
            if (var4.startsWith(" ")) {
                var2[var3].c = var1.readInt();
            }
        }

        this.aG = var2;
    }

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public Animation<TextureRegion> animation;
public Char bq;
public int[] bA;
public int bi;
public void initialize() {
this.bA = new int[]{-10, -10, -10, -10, -10, -8, -5, -5, -3, -2, -2, -1, -1, -1, -1, -1};
this.bi = 0;
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.Char");
public static SessionState $state_Char() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
