package beatdz;

import beatdz.*;

import beatdz.DataCenter;
import beatdz.libForBeatdz.WaitAuto;
import beatdz.tab.LatHinh;
import beatdz.tab.VXMM;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Blending;
import com.boot.GameM;
import com.listener.SDKListener;
import com.tgame.model.Caption;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class GameSrc extends MainScreen {

    

    public static void Char_O() {
        try {
            GameSrc var0 = GameSrc.gI();
            int var2;
            try {
                if (SettingsTab.gI().t() && !Char.gI().j() && !(var0.cD.lastElement() instanceof LangLa_b)) {
                    for (var2 = 0; var2 < var0.vItemMap.size(); ++var2) {
                        ItemMap var1;
                        if ((var1 = (ItemMap) var0.vItemMap.elementAt(var2)) != null && var1.item.id != 223 && Utlis.getRange((XYEntity) Char.gI(), (XYEntity) var1) < 50) {
                            var0.pickUpItemMap(var1);
                        }
                    }
                }
            } catch (Exception ex) {

            }
            var0 = GameSrc.gI();
            if (GameSrc.gI().cc && beatdz.SettingsTab.$state_SettingsTab().c >= 0 && !Char.gI().j()) {
                if (GameSrc.gI().aR == null || GameSrc.gI().aR.d != beatdz.SettingsTab.$state_SettingsTab().c) {
                    SettingsTab.gI().a(false);
                    GameSrc.gI().aR = new LangLa_eo(beatdz.SettingsTab.$state_SettingsTab().c, beatdz.SettingsTab.$state_SettingsTab().d, beatdz.SettingsTab.$state_SettingsTab().e);
                }
                if (var0.cd > 0) {
                    --var0.cd;
                }
                if (var0.cd == 0) {
                    if (beatdz.SettingsTab.$state_SettingsTab().c == var0.mapID && XYEntity.create(beatdz.SettingsTab.$state_SettingsTab().d, beatdz.SettingsTab.$state_SettingsTab().e).getRe() < 40) {
                        SettingsTab.gI().a(true);
                        GameSrc.gI().cc = false;
                    } else {
                        SettingsTab.gI().a(false);
                    }
                } else {
                    SettingsTab.gI().a(false);
                }
            } else if (Char.gI().ax == null) {
                int var15 = var0.ay - SettingsTab.gI().l();
                var2 = var0.ay + SettingsTab.gI().l();
                int var3 = var0.az - SettingsTab.gI().l();
                int var4 = var0.az + SettingsTab.gI().l();
                if (SettingsTab.gI().autoTrain && !Char.gI().j() && !(var0.cD.lastElement() instanceof LangLa_b) && var0.bl >= 1000) {
                    label474:
                    {
                        try {
                            if (var0.cD.lastElement() instanceof LangLa_az && var0.bl == 1000 && SettingsTab.gI().y()) {
                                if (var0.vItemMapPickUp.lastElement() == null || ((ItemMap) var0.vItemMapPickUp.lastElement()).item.id != 223) {
                                    SettingsTab.gI().a(false);
                                    break label474;
                                }
                                ((LangLa_az) var0.cD.lastElement()).J();
                            }
                        } catch (Exception ex) {

                        }
                        if (!var0.cO.e && (SettingsTab.gI().b < 0 || SettingsTab.gI().b == var0.mapID)) {
                            try {
                                if (SettingsTab.gI().a[3] != -1) {
                                    for (int var5 = 0; var5 < var0.aE.size(); ++var5) {
                                        Skill var6;
                                        if ((var6 = (Skill) var0.aE.elementAt(var5)) != null && (var6.d() || var6.idTemplate == 4 || var6.getSkillTemplate().type == 0 && AutoPro.isAuto(7) || var6.idTemplate == 7 || var6.idTemplate == 31 || var6.idTemplate == 1 || var6.idTemplate == 32 || var6.idTemplate == 13 || var6.idTemplate == 34 || var6.idTemplate == 19 || var6.idTemplate == 33 || var6.idTemplate == 25) && Char.gI().level() >= var6.getSkillTemplate().levelNeed && var6.a(Char.gI()) && var6.getSkillTemplate().levelNeed < 60) {
                                            var0.a(var6, false);

                                        }
                                    }
                                }
                            } catch (Exception var14) {
                                Utlis.println(var14);
                            }
                            boolean var9 = true;
                            var0.ap = var9;
                            Vector var17 = new Vector();
                            int var19 = 0;
                            int var7 = 0;
                            int var8 = 0;
                            int var20 = 0;
                            if (Char.gI().ay != null) {
                                short var10000 = Char.gI().cx;
                                Skill var10001 = Char.gI().ay;
                                var20 = Char.gI().aU;
                                var19 = var10000 - (short) (var10001.rangeNgang + var20) + 0;
                                var10000 = Char.gI().cx;
                                var10001 = Char.gI().ay;
                                var20 = Char.gI().aU;
                                var7 = var10000 + (short) (var10001.rangeNgang + var20) - 0;
                                int var26 = Char.gI().n();
                                var10001 = Char.gI().ay;
                                var20 = Char.gI().aU;
                                var8 = var26 - (short) (var10001.rangeNgang + var20) + 0;
                                var26 = Char.gI().n();
                                var10001 = Char.gI().ay;
                                var20 = Char.gI().aU;
                                var20 = var26 + (short) (var10001.rangeNgang + var20) - 0;
                            }
                            if (var0.aA == null || !(var0.aA instanceof Char) || var0.aA instanceof Char && !var0.a((Char) var0.aA)) {
                                for (int var10 = 0; var10 < var0.vChar.size(); ++var10) {
                                    Char var11;
                                    if ((var11 = (Char) var0.vChar.elementAt(var10)) != null && var0.a(var11) && Utlis.inRange(var11.a(), var11.c(), var11.b(), var11.cy, var15, var3, var2, var4)) {
                                        var0.aA = var11;
                                        break;
                                    }
                                }
                            }
                            if (var0.aA != null && var0.aA instanceof Char) {
                                Char var21 = (Char) var0.aA;
                                for (int var23 = 0; var23 < var21.vEffect.size(); ++var23) {
                                    if (((Effect) var21.vEffect.elementAt(var23)).id == 46) {
                                        var0.aA = null;
                                        var0.b(true);
                                        break;
                                    }
                                }
                            }
                            Mob mob1 = findMobWithLevelBoss(1);
                            Mob mob2 = findMobWithLevelBoss(2);
                            if (var0.aA != null) {
                                if (var0.aA instanceof ItemMap) {
                                    ItemMap var22 = (ItemMap) var0.aA;
                                    if (Char.gI().a(var22) && var22.item.id != 223) {
                                        var0.aA = null;
                                    } else if (Utlis.getRange(var0.aA.cx, var0.aA.cy, Char.gI().cx, Char.gI().cy) > 50) {
                                        if (AutoPro.isAuto(8)) {
                                            Char.gI().cx = var0.aA.cx;
                                            Char.gI().cy = var0.aA.cy;
                                        }

                                        Char.gI().setDir(var0.aA);
                                        Char.gI().pointMove = new PointMove(var0.aA.cx, var0.aA.cy, Char.gI().speedMove);
                                    } else {
                                        var0.pickUpItemMap(var22);
                                        var0.aA = null;
                                    }
                                } else {
                                    label485:
                                    {
                                        if (!(var0.aA instanceof Char) || var0.a((Char) var0.aA)) {
                                            if (Char.gI().ay == null) {
                                                break label485;
                                            }
                                            if (var0.aA instanceof Mob) {
                                                Mob mob = ((Mob) var0.aA);
                                                if (AutoPro.isAuto(2) && mob2 != null && mob.levelBoss == 0) {
                                                    DataCenter.gI().currentScreen.showMessage("Tìm thấy thủ lĩnh [" + mob2.getMobTemplate().name + "] tại [" + mob2.xySTR() + "]", -2560);
                                                    var0.aA = mob2;
                                                }
                                                if (AutoPro.isAuto(1) && mob1 != null && mob.levelBoss == 0) {
                                                    DataCenter.gI().currentScreen.showMessage("Tìm thấy tinh anh [" + mob1.getMobTemplate().name + "] tại [" + mob1.xySTR() + "]", -2560);
                                                    var0.aA = mob1;
                                                }
                                            }
                                            if (Utlis.inRange(Char.gI().a(), Char.gI().c(), Char.gI().b(), Char.gI().cy, var19, var8, var7, var20)) {
                                                boolean var28;
                                                label231:
                                                {
                                                    Skill var27 = Char.gI().ay;
                                                    Char var16 = Char.gI();
                                                    Skill var18 = var27;
                                                    if (var27.getSkillTemplate().levelNeed < 60) {
                                                        if (var18.time < Utlis.time() && var16.mp >= var18.mpUse) {
                                                            var28 = true;
                                                            break label231;
                                                        }
                                                        if (var16.mpFull < var18.mpUse && var16.isMe()) {
                                                            DataCenter.gI().currentScreen.showMessage(Caption.lj + " " + var18.getSkillTemplate().name, -65536);
                                                        } else if (beatdz.SettingsTab.$state_SettingsTab().j && var16.mp < var18.mpUse && var16.isMe()) {
                                                            beatdz.SettingsTab.$state_SettingsTab().j = false;
                                                            DataCenter.gI().currentScreen.showMessage(Caption.lj + " " + var18.getSkillTemplate().name, -65536);
                                                        }
                                                    }
                                                    var28 = false;
                                                }
                                                if (var28) {
                                                    var0.a(Char.gI().ay, true);
                                                }
                                                break label485;
                                            }
                                            if (Utlis.inRange(Char.gI().a(), Char.gI().c(), Char.gI().b(), Char.gI().cy, var15, var3, var2, var4)) {
                                                Char.gI().pointMove = new PointMove(var0.aA.cx, var0.aA.cy, Char.gI().speedMove);
                                                break label485;
                                            }
                                        }
                                        var0.aA = null;
                                    }
                                }
                            } else {
                                var0.aA = null;
                                Vector var12 = new Vector();
                                if (SettingsTab.gI().t() && !Char.gI().j()) {
                                    for (var19 = 0; var19 < var0.vItemMap.size(); ++var19) {
                                        ItemMap var25;
                                        if (Utlis.inRange((var25 = (ItemMap) var0.vItemMap.elementAt(var19)).a(), var25.c(), var25.b(), var25.cy, var15, var3, var2, var4)) {
                                            if (var25.item.id == 224) {
                                                if (var25.idChar == Char.gI().idEntity || var25.idChar == -1 || var0.d(var25.idChar)) {
                                                    var0.e(false);
                                                }
                                            } else if (!var0.a((XYEntity) var25) && !var0.vItemMapPickUp.contains(var25) && !Char.gI().a(var25) && (var25.idChar == Char.gI().idEntity || var25.idChar == -1) && (var0.c(var25.item.id) || var25.item.getItemTemplate().isXepChong && var25.item.expiry == -1L && !var25.item.j() || var25.item.T() > 0 || SettingsTab.gI().u() && var25.item.q() && (SettingsTab.gI().r() == 0 || var25.item.id >= SettingsTab.gI().r()) || SettingsTab.gI().v() && var25.item.isTypeTrangBi() || SettingsTab.gI().w() && var25.item.j() || SettingsTab.gI().x() && !var25.item.q() && !var25.item.isTypeTrangBi() && !var25.item.j())) {
                                                var12.add(var25);
                                            }
                                        }
                                    }
                                }
                                if (var12.size() > 0) {
                                    Collections.sort(var12, beatdz.Entity.$state_Entity().i);
                                    var0.aA = (Entity) var12.firstElement();
                                } else {
                                    if (AutoPro.isAuto(2) && mob2 != null) {
                                        DataCenter.gI().currentScreen.showMessage("Tìm thấy thủ lĩnh [" + mob2.getMobTemplate().name + "] tại [" + mob2.xySTR() + "]", -2560);
                                        var17.add(mob2);
                                    }
                                    if (AutoPro.isAuto(1) && mob1 != null) {
                                        DataCenter.gI().currentScreen.showMessage("Tìm thấy tinh anh [" + mob1.getMobTemplate().name + "] tại [" + mob1.xySTR() + "]", -2560);
                                        var17.add(mob1);
                                    }

                                    if (var17.size() == 0) {
                                        for (var19 = 0; var19 < var0.vMob.size(); ++var19) {
                                            Mob var24;
                                            if ((var24 = (Mob) var0.vMob.elementAt(var19)).status != 4 && var24.status != 6 && var24.status != 5 && !var24.q()) {
                                                Utlis.getRange((XYEntity) var24, (XYEntity) Char.gI());
                                                if (Utlis.inRange(var24.a(), var24.c(), var24.b(), var24.s(), var15, var3, var2, var4) && var24.x() && !var0.a((XYEntity) var24)) {
                                                    var17.add(var24);
                                                }
                                            }
                                        }
                                    } else {

                                        var0.aA = (Entity) var17.firstElement();
                                        return;
                                    }
                                    if (var0.aA == null && var17.size() > 0) {
                                        Collections.sort(var17, beatdz.Entity.$state_Entity().i);
                                        var0.aA = (Entity) var17.firstElement();
                                    }
                                }
                                if ((var0.aA == null || var0.aA != null && (var0.aA.status == 4 || var0.aA.status == 6 || var0.aA.status == 5)) && Char.gI().cx != var0.ay && Char.gI().cy != var0.az) {
                                    Char.gI().b(var0.ay, var0.az);
                                }

                            }
                        } else {
                            SettingsTab.gI().a(false);
                        }
                    }
                } else if (SettingsTab.gI().autoTrain && Char.gI().P() && var0.aA != null && var0.aA instanceof Char && !Utlis.inRange(var0.aA.a(), var0.aA.c(), var0.aA.b(), var0.aA.d(), var15, var3, var2, var4)) {
                    var0.aA = null;
                }
            }
        } catch (Exception ex) {

        }
        GameSrc.gI().o();
    }

    public static Mob findMobWithLevelBoss(int lv) {
        GameSrc var0 = GameSrc.gI();
        ArrayList<Mob> listMob = new ArrayList<Mob>();
        for (int var19 = 0; var19 < var0.vMob.size(); ++var19) {
            Mob var24;
            if ((var24 = (Mob) var0.vMob.elementAt(var19)).status != 4 && var24.status != 6 && var24.status != 5 && !var24.q()) {
                if (var24.levelBoss == lv) {

                }

                listMob.add(var24);
            }
        }
        if (listMob.size() > 0) {
            List<Mob> list = listMob.stream().filter(mob -> mob.levelBoss == lv).collect(Collectors.toList());
            if (list.size() > 0) {
                Collections.sort(list, new Comparator() {
                    @Override
                    public int compare(Object o1, Object o2) {
                        return ((Mob) o1).getRe() - ((Mob) o2).getRe();
                    }
                });
                return list.get(0);
            }
        }
        return null;
    }
    public Vector a = new Vector();
    public Vector b = new Vector();
    public Vector c = new Vector();
    public Vector d = new Vector();
    public Vector e = new Vector();
    public DataBlockMap[] f;
    public LangLa_gf[] g;
    public XYBlockMap h;
    public Vector i = new Vector();
    public Vector j = new Vector();
    public Vector k = new Vector();
    public Vector l = new Vector();
    public Vector vThu;
    public Vector vFriend;
    public Vector vEnemy;
    public Skill[] p = new Skill[0];
    public long q;
    public long r;
    public long s;
    public int t;
    public int pointNAP;
    public int timeChatColor;
    public short mapID;
    public short maxX;
    public short maxY;
    public short zoneID;
    public short A = 4;
    public Vector vCharWaitRemove = new Vector();
    public Vector vChar = new Vector();
    public Vector vMob = new Vector();
    public Vector vNpc = new Vector();
    public Vector vItemMap = new Vector();
    public Vector G;
    public Vector H;
    public Vector I;
    public Vector vWayPoint;
    public Vector K;
    public Vector L;
    private Vector de;
    public Vector M;
    public Vector vItemMapPickUp;
    private Vector df;
    public LangLa_cj O;
    public LangLa_cj P;
    public LangLa_cj Q;
    public LangLa_cj R;
    public LangLa_cj S;
    public LangLa_cj T;
    public LangLa_cj U;
    public LangLa_r V;
    public int W;
    public LangLa_ea X;
    private LangLa_dz[] dg = new LangLa_dz[4];
    private LangLa_dz[] dh = new LangLa_dz[3];
    public LangLa_dz Y;
    private LangLa_dz di;
    private LangLa_dz dj;
    public LangLa_dz Z;
    public LangLa_dz aa;
    public LangLa_dz ab;
    public LangLa_dz ac;
    public LangLa_dz ad;
    public LangLa_dz ae;
    public LangLa_dz af;
    public LangLa_dz ag;
    public mTextBox ah;
    public LangLa_ki ai;
    public LangLa_kw aj;
    public LangLa_mg ak;
    public LangLa_mi al;
    public boolean am;
    
    
    public boolean ap;
    public boolean aq;
    public boolean ar;
    public boolean as;
    public boolean at;
    
    private int dl;
    private int dm;
    private int dn;
    private int do_;
    public int au = 33;
    public int av = 40;
    public int aw;
    public int ax;
    public int ay;
    public int az;
    public Entity aA;
    public LangLa_gl[] aB;
    public LangLa_gl[] aC;
    public LangLa_er aD = new LangLa_er();
    public Vector aE = new Vector();
    public LangLa_hm aF = new LangLa_hm(208, 0, 0, -1);
    public LangLa_hm aG = new LangLa_hm(0, 0, 0, -1);
    public Skill aH;
    public LangLa_lj aI = new LangLa_lj();
    
    
    
    public LangLa_ko aM;
    public int Task;
    public int idStep;
    public int idRequire;
    public int aQ = -1;
    public LangLa_eo aR;
    public LangLa_jd aS;
    public LangLa_jd aT;
    public LangLa_jd aU;
    public LangLa_jd aV;
    public LangLa_jd aW;
    public LangLa_lh aX;
    public boolean aY;
    public boolean aZ;
    public boolean ba;
    public boolean bb = false;
    
    
    public Vector be;
    public int bf;
    public int bg;
    public int bh;
    public int bi;
    
    
    public int bl = 1000;
    public int bm;
    public int bn;
    public long timeStartHoatDong;
    public long bp;
    public long bq;
    public long br;
    public int timeHoatDong;
    public int bt;
    public int bu;
    public int bv;
    public int bw;
    public int bx;
    public int by;
    public int bz = Integer.MIN_VALUE;
    private int dp = 0;
    public boolean isHoatDongTime;
    public boolean isTimeHoatDong;
    public boolean bC;
    public boolean bD;
    public boolean bE;
    public long bF;
    public short bG;
    public short bH;
    public int bI;
    public int bJ;
    public int bK;
    public int bL;
    public String bM = "";
    public boolean bN;
    public boolean bO = true;
    public boolean bP;
    public byte bQ;
    
    private LangLa_em[] dq;
    private LangLa_em[] dr;
    protected long bS = 0L;
    public byte bT;
    public byte bU;
    public byte bV;
    public byte bW;
    public int diemTiemNang;
    public int diemKyNang;
    public int bZ = -1;
    private LangLa_dz ds;
    private LangLa_dz dt;
    private LangLa_dz du;
    private LangLa_dz dv;
    private LangLa_dz dw;
    private boolean dx;
    private int dy = 30;
    public boolean ca;
    private int dz = 1;
    private long dA;
    public Vector cb = new Vector();
    public boolean cc;
    public int cd = 0;
    
    
    public Entity ce;
    public int cf;
    public String cg = "";
    public int ch;
    public int ci = -1;
    public String cj = "";
    public long ck;
    public LangLa_ep cl = new LangLa_ep();
    public int cm = 50;
    public Vector cn = new Vector();
    public int co = -1;
    public int cp = -1;
    public int cq;
    public boolean doneTaskKTNG;
    public boolean cs;
    public byte numTaskDoneKTNG;
    public byte cu;
    public byte cv = 17;
    public int cw;
    private LangLa_dz dD;
    private LangLa_mm dE;
    private LangLa_dz dF;
    private boolean dG;
    private Vector dH;
    public Vector cx;
    private int dI;
    private LangLa_dz dJ;
    public LangLa_jw cy = null;
    public int cz = 0;
    
    public boolean cB;
    private int dK = 0;
    final RenderMotion renderMotion = new RenderMotion();

    public GameSrc() {
        this.vItemMap = new Vector();
        this.G = new Vector();
        this.H = new Vector();
        this.I = new Vector();
        this.vWayPoint = new Vector();
        this.K = new Vector();
        this.L = new Vector();
        this.de = new Vector();
        this.vThu = new Vector();
        this.vFriend = new Vector();
        this.vEnemy = new Vector();
        this.M = new Vector();
        this.be = new Vector();
        this.vItemMapPickUp = new Vector();
        this.dH = new Vector();
        this.cx = new Vector();
        this.aB = new LangLa_gl[0];
        this.aC = new LangLa_gl[0];
        int[] var1 = new int[]{223, 177, 189, 276, 156, 157, 158, 166, 168, 185, 186, 162, 169, 170, 301, 159, 281, 182, 183, 184, 300, 161, 277, 285, 265, 274, 267, 266, 307};
        this.df = new Vector();

        for (int var2 = 0; var2 < 29; ++var2) {
            this.df.add(var1[var2]);
        }

        this.br = this.bp = this.bq = System.currentTimeMillis();
    }

    public static GameSrc gI() {
        if (beatdz.GameSrc.$state_GameSrc().dk == null) {
            beatdz.GameSrc.$state_GameSrc().dk = new GameSrc();
        }

        return beatdz.GameSrc.$state_GameSrc().dk;
    }

    public static GameSrc d() {
        return beatdz.GameSrc.$state_GameSrc().dk;
    }

    private void readBlockMap(Reader var1) throws java.io.IOException {
        this.f = new DataBlockMap[var1.dis.readUnsignedShort()];
        Vector var4 = new Vector();

        short var2;
        short var3;
        BlockMap blockMap;
        int var7;
        int var8;
        int var9;
        BlockMap[] var11;
        for (short var6 = 0; var6 < this.f.length; ++var6) {
            var4.removeAllElements();
            this.f[var6] = new DataBlockMap();
            this.f[var6].width = var1.dis.readShort();
            this.f[var6].height = var1.dis.readShort();
            this.f[var6].type = var1.dis.readByte();
            this.f[var6].idEff = var1.dis.readShort();
            var2 = var1.readUnsignedByte();

            for (var7 = 0; var7 < var2; ++var7) {
                var3 = var1.readUnsignedByte();

                for (var8 = 0; var8 < var3; ++var8) {
                    (blockMap = new BlockMap()).arrayXY = new XYEntity[var1.dis.readByte() / 2];

                    for (var9 = 0; var9 < blockMap.arrayXY.length; ++var9) {
                        blockMap.arrayXY[var9] = new XYEntity();
                        blockMap.arrayXY[var9].setXY(var1.dis.readShort(), var1.dis.readShort());
                        if (var9 == 0) {
                            blockMap.minX = blockMap.maxX = blockMap.arrayXY[var9].cx;
                            blockMap.minY = blockMap.maxY = blockMap.arrayXY[var9].cy;
                        } else {
                            if (blockMap.arrayXY[var9].cx < blockMap.minX) {
                                blockMap.minX = blockMap.arrayXY[var9].cx;
                            }

                            if (blockMap.arrayXY[var9].cx > blockMap.maxX) {
                                blockMap.maxX = blockMap.arrayXY[var9].cx;
                            }

                            if (blockMap.arrayXY[var9].cy < blockMap.minY) {
                                blockMap.minY = blockMap.arrayXY[var9].cy;
                            }

                            if (blockMap.arrayXY[var9].cy > blockMap.maxY) {
                                blockMap.maxY = blockMap.arrayXY[var9].cy;
                            }
                        }
                    }

                    var4.addElement(blockMap);
                }
            }

            if (var4.size() > 0) {
                var11 = new BlockMap[var4.size()];

                for (var7 = 0; var7 < var4.size(); ++var7) {
                    var11[var7] = (BlockMap) var4.elementAt(var7);
                }

                this.f[var6].XYBlockMap = new XYBlockMap(var11);
            }
        }

        this.g = new LangLa_gf[var1.dis.readUnsignedShort()];

        for (int var12 = 0; var12 < this.g.length; ++var12) {
            var4.removeAllElements();
            this.g[var12] = new LangLa_gf();
            this.g[var12].a = var1.dis.readShort();
            this.g[var12].b = var1.dis.readShort();
            this.g[var12].c = new LangLa_lo[var1.readUnsignedByte()];

            for (var7 = 0; var7 < this.g[var12].c.length; ++var7) {
                this.g[var12].c[var7] = new LangLa_lo(var1.dis.readShort());
                this.g[var12].c[var7].cx = this.g[var12].c[var7].l = var1.dis.readShort();
                this.g[var12].c[var7].cy = this.g[var12].c[var7].m = var1.dis.readShort();
                this.g[var12].c[var7].j = var1.dis.readByte();
                if (this.g[var12].c[var7].o().XYBlockMap != null) {
                    for (var8 = 0; var8 < this.g[var12].c[var7].o().XYBlockMap.a.length; ++var8) {
                        blockMap = this.g[var12].c[var7].o().XYBlockMap.a[var8].a();
                        if (this.g[var12].c[var7].j == 7) {
                            blockMap.arrayXY = Utlis.a(blockMap.arrayXY);
                        }

                        for (var9 = 0; var9 < blockMap.arrayXY.length; ++var9) {
                            XYEntity var10000 = blockMap.arrayXY[var9];
                            var10000.cx += this.g[var12].c[var7].cx;
                            var10000 = blockMap.arrayXY[var9];
                            var10000.cy += this.g[var12].c[var7].cy;
                            if (var9 == 0) {
                                blockMap.minX = blockMap.maxX = blockMap.arrayXY[var9].cx;
                                blockMap.minY = blockMap.maxY = blockMap.arrayXY[var9].cy;
                            } else {
                                if (blockMap.arrayXY[var9].cx < blockMap.minX) {
                                    blockMap.minX = blockMap.arrayXY[var9].cx;
                                }

                                if (blockMap.arrayXY[var9].cx > blockMap.maxX) {
                                    blockMap.maxX = blockMap.arrayXY[var9].cx;
                                }

                                if (blockMap.arrayXY[var9].cy < blockMap.minY) {
                                    blockMap.minY = blockMap.arrayXY[var9].cy;
                                }

                                if (blockMap.arrayXY[var9].cy > blockMap.maxY) {
                                    blockMap.maxY = blockMap.arrayXY[var9].cy;
                                }
                            }
                        }

                        var4.addElement(blockMap);
                    }
                }
            }

            var2 = var1.readUnsignedByte();

            for (var7 = 0; var7 < var2; ++var7) {
                var3 = var1.readUnsignedByte();

                for (var8 = 0; var8 < var3; ++var8) {
                    (blockMap = new BlockMap()).arrayXY = new XYEntity[var1.dis.readByte() / 2];

                    for (var9 = 0; var9 < blockMap.arrayXY.length; ++var9) {
                        blockMap.arrayXY[var9] = new XYEntity();
                        blockMap.arrayXY[var9].setXY(var1.dis.readShort(), var1.dis.readShort());
                        if (var9 == 0) {
                            blockMap.minX = blockMap.maxX = blockMap.arrayXY[var9].cx;
                            blockMap.minY = blockMap.maxY = blockMap.arrayXY[var9].cy;
                        } else {
                            if (blockMap.arrayXY[var9].cx < blockMap.minX) {
                                blockMap.minX = blockMap.arrayXY[var9].cx;
                            }

                            if (blockMap.arrayXY[var9].cx > blockMap.maxX) {
                                blockMap.maxX = blockMap.arrayXY[var9].cx;
                            }

                            if (blockMap.arrayXY[var9].cy < blockMap.minY) {
                                blockMap.minY = blockMap.arrayXY[var9].cy;
                            }

                            if (blockMap.arrayXY[var9].cy > blockMap.maxY) {
                                blockMap.maxY = blockMap.arrayXY[var9].cy;
                            }
                        }
                    }

                    var4.addElement(blockMap);
                }
            }

            if (var4.size() > 0) {
                var11 = new BlockMap[var4.size()];

                for (var7 = 0; var7 < var4.size(); ++var7) {
                    var11[var7] = (BlockMap) var4.elementAt(var7);
                }

                this.g[var12].d = new XYBlockMap(var11);
            }
        }

    }

    public void createMap() {
        if (this.cx.size() > 0) {
            for (int var1 = this.cx.size() - 1; var1 >= 0; --var1) {
                ((LangLa_en) this.cx.get(var1)).d();
                this.cx.removeElementAt(var1);
            }
        }

        this.br = this.bp = this.bq = System.currentTimeMillis();
        this.s = Utlis.time();
        Reader var27 = null;

        try {
            beatdz.LangLa_cx.$state_LangLa_cx().cN = true;
            this.ba = false;
            LangLa_dp.a().b();
            if ((var27 = Binary.createReader("arr_map_" + this.mapID)) == null) {
                return;
            }

            Vector var2 = new Vector();
            this.cz = 0;
            this.readBlockMap(var27);
            this.c.clear();
            new Vector();
            this.maxX = var27.dis.readShort();
            this.maxY = var27.dis.readShort();
            BlockMap[] var3;
            (var3 = new BlockMap[var27.readUnsignedByte() + 6])[var3.length - 1] = crateBlockMap(-50, -50, 128, 70);
            var3[var3.length - 2] = crateBlockMap(this.maxX - 100, -50, this.maxX + 50, 110);
            var3[var3.length - 3] = crateBlockMap(-50, -50, this.maxX + 50, 15);
            var3[var3.length - 4] = crateBlockMap(-50, -50, 15, this.maxY + 50);
            var3[var3.length - 5] = crateBlockMap(-50, this.maxY - 15, this.maxX + 50, this.maxY + 50);
            var3[var3.length - 6] = crateBlockMap(this.maxX - 15, -50, this.maxX + 50, this.maxY + 50);

            int var4;
            int var5;
            for (var4 = 0; var4 < var3.length - 6; ++var4) {
                var3[var4] = new BlockMap();
                var3[var4].arrayXY = new XYEntity[var27.readUnsignedByte()];

                for (var5 = 0; var5 < var3[var4].arrayXY.length; ++var5) {
                    var3[var4].arrayXY[var5] = new XYEntity();
                    var3[var4].arrayXY[var5].setXY(var27.dis.readShort(), var27.dis.readShort());
                    if (var5 == 0) {
                        var3[var4].minX = var3[var4].maxX = var3[var4].arrayXY[var5].cx;
                        var3[var4].minY = var3[var4].maxY = var3[var4].arrayXY[var5].cy;
                    } else {
                        if (var3[var4].arrayXY[var5].cx < var3[var4].minX) {
                            var3[var4].minX = var3[var4].arrayXY[var5].cx;
                        }

                        if (var3[var4].arrayXY[var5].cx > var3[var4].maxX) {
                            var3[var4].maxX = var3[var4].arrayXY[var5].cx;
                        }

                        if (var3[var4].arrayXY[var5].cy < var3[var4].minY) {
                            var3[var4].minY = var3[var4].arrayXY[var5].cy;
                        }

                        if (var3[var4].arrayXY[var5].cy > var3[var4].maxY) {
                            var3[var4].maxY = var3[var4].arrayXY[var5].cy;
                        }
                    }
                }
            }

            this.h = new XYBlockMap(var3);
            LangLa_gr[] var32 = new LangLa_gr[var27.dis.readShort()];
            Vector var34 = new Vector();
            Vector var30 = new Vector();

            int var7;
            for (int var6 = 0; var6 < var32.length; ++var6) {
                var32[var6] = new LangLa_gr();
                var32[var6].a = var27.dis.readBoolean();
                if (var32[var6].a) {
                    var30.add(var32[var6]);
                } else {
                    var34.add(var32[var6]);
                }

                var32[var6].arrayXY = new XYEntity[var27.dis.readShort()];

                for (var7 = 0; var7 < var32[var6].arrayXY.length; ++var7) {
                    var32[var6].arrayXY[var7] = new XYEntity();
                    var32[var6].arrayXY[var7].setXY(var27.dis.readShort(), var27.dis.readShort());
                }
            }

            Vector var37 = new Vector();
            var32 = new LangLa_gr[var34.size()];

            int var8;
            int var9;
            for (var7 = 0; var7 < var34.size(); ++var7) {
                var32[var7] = (LangLa_gr) var34.get(var7);

                for (var8 = 0; var8 < var32[var7].arrayXY.length; ++var8) {
                    if (var37.size() == 0) {
                        var37.add(var32[var7].arrayXY[var8]);
                    } else {
                        for (var9 = 0; var9 < var37.size(); ++var9) {
                            if (Utlis.getRange((XYEntity) var37.get(var9), var32[var7].arrayXY[var8]) < 10) {
                                var32[var7].arrayXY[var8] = (XYEntity) var37.get(var9);
                            }
                        }

                        var37.add(var32[var7].arrayXY[var8]);
                    }
                }
            }

            this.a(var32);

            LangLa_gr var40;
            for (var7 = 0; var7 < var30.size(); ++var7) {
                var40 = (LangLa_gr) var30.get(var7);

                for (var9 = 0; var9 < var40.arrayXY.length; ++var9) {
                    XYEntity var10 = var40.arrayXY[var9];
                    if (gI().h.a(var10.cx, var10.cy)) {
                        XYEntity var33 = gI().h.b(var10.cx, var10.cy);
                        var40.arrayXY[var9].cx = var33.cx;
                        var40.arrayXY[var9].cy = var33.cy;
                    }
                }
            }

            this.j.clear();

            for (var7 = 0; var7 < var30.size(); ++var7) {
                var40 = (LangLa_gr) var30.get(var7);

                for (var9 = 0; var9 < var40.arrayXY.length - 1; ++var9) {
                    BlockMap var45;
                    (var45 = new BlockMap()).arrayXY = new XYEntity[2];
                    var45.arrayXY[0] = var40.arrayXY[var9];
                    var45.arrayXY[1] = var40.arrayXY[var9 + 1];
                    this.j.add(var45);
                }
            }

            short var43 = var27.dis.readShort();
            for (var8 = 0; var8 < var43; ++var8) {
                var27.dis.readShort();
            }

            this.d.removeAllElements();
            var43 = var27.dis.readShort();
            Short var44 = null;
            int var46 = 0;
            Vector var35 = new Vector();

            int var31;
            for (var31 = 0; var31 < var43; ++var31) {
                if (var46 == 0) {
                    var44 = new Short(var27.dis.readShort());
                    this.c.addElement(var44);
                    var46 = var27.dis.readShort();
                }

                LangLa_lo var47;
                (var47 = new LangLa_lo(var44)).cx = var47.l = var27.dis.readShort();
                var47.cy = var47.m = var27.dis.readShort();
                var47.j = var27.dis.readByte();
                if (var47.k == 303) {
                    var35.add(var47.k);
                } else {
                    this.d.addElement(var47);
                }

                if (var46 > 0) {
                    --var46;
                }
            }
            this.ba = true;
            beatdz.GameSrc.$state_GameSrc().bk = beatdz.LangLa_fq.$state_LangLa_fq().f;
            beatdz.LangLa_fq.$state_LangLa_fq().f = new Hashtable();
            var31 = var2.size() - 1;
            if (var31 >= 0) {
                LangLa_gh var42 = (LangLa_gh) var2.remove(var31);
                throw null;
            }

            GameSrc var28 = this;
            if (!mConfig.gI().readBoolean(18)) {
                try {
                    var30 = var28.c;
                    Vector var11 = var28.d;
                    beatdz.GameSrc.$state_GameSrc().bj = true;
                } catch (Exception var23) {
                    Binary.deleteStartsWith("mapsmall_" + this.mapID + "_");
                    Vector var10000 = this.d;
                    var30 = this.c;
                    beatdz.GameSrc.$state_GameSrc().bj = true;
                }
            }

            for (var31 = 0; var31 < this.vMob.size(); ++var31) {
                ((Mob) this.vMob.get(var31)).o();
            }

            for (var31 = 0; var31 < this.vNpc.size(); ++var31) {
                ((Npc) this.vNpc.get(var31)).p();
            }

            this.dq = null;
            this.dr = null;
            int var29;
            byte var38;
            short var41;
            if (this.getMapTemplate().typeBlockMap == 1) {
                this.dr = new LangLa_em[30];

                for (var29 = 0; var29 < this.dr.length; ++var29) {
                    var41 = 185;
                    if (var29 % 4 == 0) {
                        var41 = 186;
                    } else if (var29 % 5 == 0) {
                        var41 = 184;
                    }

                    this.dr[var29] = new LangLa_em(var41, 5, 5, 2, var29, this.dr.length, this.maxX, this.maxY);
                }
            } else if (this.getMapTemplate().typeBlockMap == 2) {
                this.dr = new LangLa_em[25];

                for (var29 = 0; var29 < this.dr.length; ++var29) {
                    var41 = 181;
                    if (var29 % 4 == 0) {
                        var41 = 182;
                    } else if (var29 % 5 == 0) {
                        var41 = 180;
                    }

                    this.dr[var29] = new LangLa_em(var41, 4, 4, 2, var29, this.dr.length, this.maxX, this.maxY);
                }
            } else if (this.getMapTemplate().typeBlockMap == 3) {
                this.dr = new LangLa_em[100];

                for (var29 = 0; var29 < this.dr.length; ++var29) {
                    var41 = 187;
                    if (var29 % 2 == 0) {
                        var41 = 188;
                    } else if (var29 % 3 == 0) {
                        var41 = 189;
                    }

                    this.dr[var29] = new LangLa_em(var41, 2, 7, 3, var29, 95, this.maxX, this.maxY);
                }
            } else if (this.getMapTemplate().typeBlockMap == 6) {
                this.dr = new LangLa_em[250];

                for (var29 = 0; var29 < this.dr.length; ++var29) {
                    var41 = 187;
                    if (var29 % 2 == 0) {
                        var41 = 188;
                    } else if (var29 % 3 == 0) {
                        var41 = 189;
                    }

                    this.dr[var29] = new LangLa_em(var41, 3, 8, 6, var29, 95, this.maxX, this.maxY);
                }
            } else if (this.getMapTemplate().typeBlockMap == 4) {
                this.dr = new LangLa_em[300];

                for (var29 = 0; var29 < this.dr.length; ++var29) {
                    var41 = 407;
                    if (var29 % 2 == 0) {
                        var41 = 408;
                    } else if (var29 % 3 == 0) {
                        var41 = 409;
                    }

                    this.dr[var29] = new LangLa_em(var41, 4, 1, 5, var29, this.dr.length, this.maxX, this.maxY);
                }
            } else if (this.getMapTemplate().typeBlockMap == 5) {
                this.dr = new LangLa_em[150];

                for (var29 = 0; var29 < this.dr.length; ++var29) {
                    var38 = 4;
                    if (var29 % 30 == 0) {
                        var38 = 8;
                    } else if (var29 % 20 == 0) {
                        var38 = 6;
                    } else if (var29 % 10 == 0) {
                        var38 = 7;
                    } else if (var29 % 2 == 0) {
                        var38 = 5;
                    }

                    this.dr[var29] = new LangLa_em(var38, 4, 1, 5, var29, this.dr.length, this.maxX, this.maxY);
                }
            }

            if (this.mapID == 69) {
                this.dq = new LangLa_em[15];

                for (var31 = 0; var31 < this.dq.length; ++var31) {
                    this.dq[var31] = new LangLa_em(1, 3, 0, 0, var31, this.dq.length, this.maxX, this.maxY);
                }
            } else if (this.mapID == 60) {
                this.dq = new LangLa_em[20];

                for (var31 = 0; var31 < this.dq.length; ++var31) {
                    this.dq[var31] = new LangLa_em(2, 1, 0, 1, var31, this.dq.length, this.maxX, this.maxY);
                }
            } else if (this.mapID == 68) {
                this.dq = new LangLa_em[60];

                for (var31 = 0; var31 < this.dq.length; ++var31) {
                    if (var31 >= 45) {
                        this.dq[var31] = new LangLa_em(242, 0, 2, 4, var31 - 45, 15, this.maxX, this.maxY);
                        this.dq[var31].a(this.dq[var31 - 45].j.cx + 96);
                        this.dq[var31].b(this.dq[var31 - 45].j.cy);
                    } else if (var31 >= 30) {
                        this.dq[var31] = new LangLa_em(242, 0, 2, 4, var31 - 30, 15, this.maxX, this.maxY);
                        this.dq[var31].a(this.dq[var31 - 30].j.cx + 64);
                        this.dq[var31].b(this.dq[var31 - 30].j.cy);
                    } else if (var31 >= 15) {
                        this.dq[var31] = new LangLa_em(242, 0, 2, 4, var31 - 15, 15, this.maxX, this.maxY);
                        this.dq[var31].a(this.dq[var31 - 15].j.cx + 32);
                        this.dq[var31].b(this.dq[var31 - 15].j.cy);
                    } else {
                        this.dq[var31] = new LangLa_em(242, 0, 2, 4, var31, 15, this.maxX, this.maxY);
                        this.dq[var31].a(280);
                    }
                }
            } else if (this.mapID == 83) {
                this.dq = new LangLa_em[105];

                for (var31 = 0; var31 < this.dq.length; ++var31) {
                    if (var31 >= 75) {
                        this.dq[var31] = new LangLa_em(242, 0, 2, 4, var31 - 45, 15, this.maxX, this.maxY);
                        this.dq[var31].a(this.dq[var31 - 75].j.cx + 160);
                        this.dq[var31].b(this.dq[var31 - 75].j.cy);
                    } else if (var31 >= 60) {
                        this.dq[var31] = new LangLa_em(242, 0, 2, 4, var31 - 45, 15, this.maxX, this.maxY);
                        this.dq[var31].a(this.dq[var31 - 60].j.cx + 128);
                        this.dq[var31].b(this.dq[var31 - 60].j.cy);
                    } else if (var31 >= 45) {
                        this.dq[var31] = new LangLa_em(242, 0, 2, 4, var31 - 45, 15, this.maxX, this.maxY);
                        this.dq[var31].a(this.dq[var31 - 45].j.cx + 96);
                        this.dq[var31].b(this.dq[var31 - 45].j.cy);
                    } else if (var31 >= 30) {
                        this.dq[var31] = new LangLa_em(242, 0, 2, 4, var31 - 30, 15, this.maxX, this.maxY);
                        this.dq[var31].a(this.dq[var31 - 30].j.cx + 64);
                        this.dq[var31].b(this.dq[var31 - 30].j.cy);
                    } else if (var31 >= 15) {
                        this.dq[var31] = new LangLa_em(242, 0, 2, 4, var31 - 15, 15, this.maxX, this.maxY);
                        this.dq[var31].a(this.dq[var31 - 15].j.cx + 32);
                        this.dq[var31].b(this.dq[var31 - 15].j.cy);
                    } else {
                        this.dq[var31] = new LangLa_em(242, 0, 2, 4, var31, 15, this.maxX, this.maxY);
                        this.dq[var31].a(562);
                    }

                    this.dq[var31].a(546, 212, 224, 520);
                }
            } else if (this.mapID == 85) {
                this.dq = new LangLa_em[25];

                for (var31 = 0; var31 < this.dq.length; ++var31) {
                    this.dq[var31] = new LangLa_em(229, 2, 0, 1, var31, 25, this.maxX, this.maxY);
                }
            } else if (this.mapID == 86) {
                this.dq = new LangLa_em[60];

                for (var31 = 0; var31 < this.dq.length; ++var31) {
                    if (var31 >= 50) {
                        this.dq[var31] = new LangLa_em(242, 0, 1, 4, var31 - 50, 10, this.maxX, this.maxY);
                        this.dq[var31].a(this.dq[var31 - 50].j.cx + 128);
                        this.dq[var31].b(this.dq[var31 - 50].j.cy);
                    }

                    if (var31 >= 40) {
                        this.dq[var31] = new LangLa_em(242, 0, 1, 4, var31 - 40, 10, this.maxX, this.maxY);
                        this.dq[var31].a(this.dq[var31 - 40].j.cx + 96);
                        this.dq[var31].b(this.dq[var31 - 40].j.cy);
                    }

                    if (var31 >= 30) {
                        this.dq[var31] = new LangLa_em(242, 0, 1, 4, var31 - 30, 10, this.maxX, this.maxY);
                        this.dq[var31].a(this.dq[var31 - 30].j.cx + 64);
                        this.dq[var31].b(this.dq[var31 - 30].j.cy);
                    }

                    if (var31 >= 20) {
                        this.dq[var31] = new LangLa_em(242, 0, 1, 4, var31 - 20, 10, this.maxX, this.maxY);
                        this.dq[var31].a(this.dq[var31 - 20].j.cx + 64);
                        this.dq[var31].b(this.dq[var31 - 20].j.cy);
                    } else if (var31 >= 10) {
                        this.dq[var31] = new LangLa_em(242, 0, 1, 4, var31 - 10, 10, this.maxX, this.maxY);
                        this.dq[var31].a(this.dq[var31 - 10].j.cx + 32);
                        this.dq[var31].b(this.dq[var31 - 10].j.cy);
                    } else {
                        this.dq[var31] = new LangLa_em(242, 0, 1, 4, var31, 10, this.maxX, this.maxY);
                        this.dq[var31].a(1230);
                    }

                    this.dq[var31].a(1200, 453, 220, 400);
                }
            }

            if (var35.size() > 0) {
                LangLa_em[] var48;
                if (this.dq == null) {
                    var48 = new LangLa_em[var35.size()];

                    for (var29 = 0; var29 < var35.size(); ++var29) {
                        var48[var29] = new LangLa_em(1, 3, 0, 0, var29, 0, this.maxX, this.maxY);
                    }
                } else {
                    var48 = new LangLa_em[var35.size() + this.dq.length];

                    for (var29 = 0; var29 < this.dq.length; ++var29) {
                        var48[var29] = this.dq[var29];
                    }

                    for (var29 = 0; var29 < var35.size(); ++var29) {
                        var48[var29 + this.dq.length] = new LangLa_em(3, 3, 0, 0, var29, this.dq.length, this.maxX, this.maxY);
                    }
                }

                this.dq = var48;
            }

            var28 = this;

            try {
                var28.S.a.removeAllElements();
                var28.O.a.removeAllElements();
                var28.P.a.removeAllElements();
                var28.T.a.removeAllElements();
                var28.U.a.removeAllElements();
                var28.cG.removeAllElements();
                var28.I();
                if (var28.ak != null) {
                    var28.b((LangLa_cs) var28.ak);
                }

                if (var28.dE != null) {
                    var28.b((LangLa_cs) var28.dE);
                }

                var28.ak = new LangLa_mg(AppListener.gI().o, DataCenter.gI().heightScreen / 2 - 40, 90, 31, var28);
                var28.dE = new LangLa_mm(AppListener.gI().o, DataCenter.gI().heightScreen / 2 - 40, 80, 32, var28);
                var28.S.b((LangLa_cs) (var28.dF = var28.a(var28.ak.cx, var28.ak.cy - 14, "", var28, 1101, 715)));
                var28.S.b((LangLa_cs) (var28.dD = var28.a(var28.ak.cx + 16, var28.ak.cy - 14, "", var28, 1102, 245)));
                if (var28.cw != 0 && var28.cw != 1) {
                    if (var28.cw == 2) {
                        var28.a((LangLa_cs) var28.dE);
                        var28.S.b((LangLa_cs) var28.dE);
                    }
                } else {
                    var28.a((LangLa_cs) var28.ak);
                    var28.S.b((LangLa_cs) var28.ak);
                }

                var28.c((LangLa_cs) var28.S.a());
                var28.j(mConfig.gI().readBoolean(14));
                var28.ag = var28.a(AppListener.gI().o, var28.ak.cy + 46, "", var28, 1012, -11);
                LangLa_dz var53 = var28.ag;
                DataCenter.gI();
                var53.b(false);
                var28.O.b((LangLa_cs) var28.ag);
                int var10002 = 25 + AppListener.gI().o;
                int var10003 = var28.height - 80;
                boolean var49 = true;
                var49 = true;
                var49 = true;
                String var39 = "";
                var5 = var10003;
                var4 = var10002;
                LangLa_ea var36 = new LangLa_ea(var4, var5, 0, 0, var39, var28, 1011, 20, 19);
                var28.a(var36);
                var28.X = var36;
                if (mConfig.gI().readBoolean(15)) {
                    var28.X.setXY(var28.X.cx + 5, var28.height - var28.X.height - 25);
                } else {
                    var28.X.setXY(var28.X.cx, var28.height - var28.X.height - 20);
                }

                var28.X.d();
                var28.O.b((LangLa_cs) var28.X);
                var28.c((LangLa_cs) var28.O.a());
                var28.g();
                var28.ah = var28.a(-200, -200, 100, "", var28, 1083, 0);
                var38 = 80;
                var28.ah.a = var38;
                var28.ah.b(true);
                var28.ah.p = var28.ah.q = true;
                var4 = DataCenter.gI().widthScreen - 86;
                DataCenter.gI();
                LangLa_dz var50;
                var28.U.b((LangLa_cs) (var50 = var28.a(var4 - 14, 54, "", var28, 1100, 715)));
                var41 = 180;
                var50.e = var41;
                var4 -= 25;
                var28.U.b((LangLa_cs) var28.a(var4, 5, "", var28, 1063, 687));
                var28.U.b((LangLa_cs) var28.a(var4, 30, "", var28, 1034, 82));
                var4 -= 25;
                var28.U.b((LangLa_cs) var28.a(var4, 5, "", var28, 1032, 36));
                var28.U.b((LangLa_cs) var28.a(var4, 30, "", var28, 1035, 648));
                var4 -= 25;
                var28.U.b((LangLa_cs) (var28.dt = var28.a(var4, 5, "", var28, 1033, 49)));
                var28.U.b((LangLa_cs) var28.a(var4, 30, "", var28, 1036, 647));
                var4 -= 25;
                var28.U.b((LangLa_cs) (var28.ds = var28.a(var4, 5, "", var28, 1067, 81)));
                var28.U.b((LangLa_cs) (var28.dw = var28.a(var4, 30, "", var28, 1037, 660)));
                var4 -= 25;
                var28.U.b((LangLa_cs) var28.a(var4, 5, "", var28, 9997, 1172));
                var28.U.b((LangLa_cs) var28.a(var4, 30, "", var28, 9998, 1171));
                var28.k(mConfig.gI().readBoolean(23));
                var28.di = var28.a(0, var28.height - 186, "", var28, 1040, 712);
                var28.dj = var28.a(0, 0, "", var28, 7000, -16);
                var28.dh[0] = var28.a(0, 0, Caption.sQ[0], var28, 7001, 734);
                var28.dh[1] = var28.a(0, 0, Caption.sQ[1], var28, 7002, 722);
                var28.dh[2] = var28.a(0, 0, Caption.sQ[2], var28, 7003, 728);
                short var51 = -270;
                var28.di.e = var51;
                var28.dg[0] = var28.a(18, var28.height - 186, "", var28, 1049, 373);
                var28.dg[1] = var28.a(70, var28.height - 186, "", var28, 1050, 374);
                var28.dg[2] = var28.a(82, var28.height - 186 + 84, "", var28, 1043, 38);
                var28.dg[3] = var28.a(101, var28.height - 186 + 84, "", var28, 1042, 33);
                if (var28.aj == null) {
                    LangLa_cz var52;
                    (var52 = new LangLa_cz()).setSize(220, 24);
                    var52.setXY(var28.width / 2 - var52.width / 2 - 5, var28.height - var52.height - 8);
                    if (var52.cx < var28.X.cx + var28.X.width + 5) {
                        var52.cx = (short) (var28.X.cx + var28.X.width + 5);
                    }

                    if (var52.cx + var52.width + 18 > var28.af.cx) {
                        var52.width = (short) (var28.af.cx - var52.cx - 18);
                    }

                    var28.aj = new LangLa_kw(var52.cx, var52.cy, var52.width, var52.height, var28, (byte) 0, 1048, 12);
                }

                if (var28.al == null) {
                    var28.al = new LangLa_mi(0, var28.height - 184 + 16, 84, 50, var28);
                }

                var28.O.b((LangLa_cs) (var28.du = var28.a(var28.aj.cx + var28.aj.width - 6, var28.aj.cy + var28.aj.height / 2 - 9, "", var28, 1083, 73)));
                var28.a((LangLa_cs) var28.aj);
                var28.O.b((LangLa_cs) var28.aj);
                var28.ai = a(2, var28.height - 184 + 80, 4, var28, 1047);
                var28.o(0);
                var28.U();
                var28.o(mConfig.gI().readByte(4));
                if (mConfig.gI().readBoolean(5)) {
                    boolean var54 = var28.U.e;
                }

                if (mConfig.gI().readBoolean(6)) {
                    var28.aZ = true;
                } else {
                    var28.aZ = false;
                }

                var28.T.a(var28.T.c());
            } catch (Exception var24) {
                Utlis.println(var24);
            }

            this.bD = false;
            this.al.a(this.mapID);
            if (this.V == null) {
                this.V = new LangLa_r(this);
            }

            this.V.c = true;
            this.V = null;
            beatdz.LangLa_cx.$state_LangLa_cx().cN = false;
            MapAssetPrefetch.schedule(this.mapID);
            return;
        } catch (Exception var25) {
            Utlis.println(var25, "createMap failed: map=" + this.mapID);
            try {
                Message.f((byte) 4).send();
            } catch (Exception var22) {
            }
        } finally {
            try {
                if (var27 != null) {
                    var27.close();
                }
            } catch (Exception var21) {
            }

        }

    }

    public void f() {
        if (this.V != null) {
            this.V.e();
        }

    }

    private void U() {
        mConfig.gI().writeBoolean(3, true);
        this.T.a(this.width - 16, 0, true);
        LangLa_dz var10000 = (LangLa_dz) this.T.a();
        short var2 = 270;
        var10000.e = var2;
    }

    private void o(int var1) {
        this.W = 2;
        this.T.a.clear();
        this.Q.a.clear();
        this.b((LangLa_cs) this.di);
        this.b((LangLa_cs) this.ah);

        for (var1 = 0; var1 < this.dg.length; ++var1) {
            this.b((LangLa_cs) this.dg[var1]);
        }

        this.b((LangLa_cs) this.al);
        this.b((LangLa_cs) this.ai);
        this.dj.setXY(36, 37);
        this.dh[0].setXY(61, 37);
        this.dh[1].setXY(86, 37);
        this.dh[2].setXY(111, 37);
        this.Q.b((LangLa_cs) this.dj);
        this.Q.b((LangLa_cs) this.dh[0]);
        this.Q.b((LangLa_cs) this.dh[1]);
        this.Q.b((LangLa_cs) this.dh[2]);
        this.Q.a(false);
        this.di.setXY(this.width - 16, 0);
        short var3 = this.di.cx;
        short var2 = this.di.cy;
        this.dg[0].setXY(var3 - 70, var2);
        this.dg[1].setXY(var3 - 18, var2);
        this.dg[2].setXY(var3 + 82 - 106, var2 + 84);
        this.dg[3].setXY(var3 + 101, var2 + 84);
        this.ah.setXY(var3 + 20, var2 + 82 - 1);
        this.ai.setXY(var3 + 2, var2 + 80);
        this.al.setXY(var3 - 68, var2 + 16);
        this.di.b(true);
        this.dg[1].b(true);
        this.dg[0].b(true);
        this.W = 2;
        this.T.b((LangLa_cs) this.di);
        this.T.b((LangLa_cs) this.dg[0]);
        this.T.b((LangLa_cs) this.dg[1]);
        String var4 = gI().getMapTemplate().name;
        String var5 = "";
        if (!var4.trim().equals("") && !(var5 = mFont.b(mFont.b, var4, 43).firstElement().toString()).equals(var4)) {
            var5 = var5 + " ...";
        }

        this.dg[0].a = var5;
        DataCenter.gI();
        this.T.b((LangLa_cs) this.al);

        for (var1 = 0; var1 < this.T.a.size(); ++var1) {
            this.a((LangLa_cs) ((LangLa_cs) this.T.a.elementAt(var1)));
        }

        this.c((LangLa_cs) this.T.a());
    }

    public void g() {
        if (this.P != null) {
            for (int var1 = 0; var1 < this.P.a.size(); ++var1) {
                this.b((LangLa_cs) ((LangLa_cs) this.P.a.elementAt(var1)));
            }

            this.P.a.clear();
            this.aE.clear();
            Vector var2 = new Vector();
            Vector var8 = new Vector();
            this.Z = this.a(this.width - 52, this.height - 56, "", this, 1020, 17);
            this.Z.setXY(this.width - this.Z.width - 8, this.height - this.Z.height - 14);
            this.P.b((LangLa_cs) this.Z);
            this.ab = this.a(this.Z.cx - 68, DataCenter.gI().heightScreen - 35, "", this, 1084, 554);
            var8.add(this.ab);
            this.P.b((LangLa_cs) this.ab);
            this.ac = this.a(this.P.width - 35, this.Z.cy - 73, "", this, 1080, -13);
            var8.add(this.ac);
            this.P.b((LangLa_cs) this.ac);
            this.ad = this.a(this.Z.cx - 20, this.Z.cy - 52, "", this, 1081, -14);
            var8.add(this.ad);
            this.P.b((LangLa_cs) this.ad);
            this.ae = this.a(this.Z.cx - 34, DataCenter.gI().heightScreen - 65, "", this, 1082, -12);
            var8.add(this.ae);
            this.P.b((LangLa_cs) this.ae);
            this.bz = Binary.readInt("shortcutItem");
            byte var3 = 5;
            if (mConfig.gI().readBoolean(15)) {
                this.P.a(var8, this.Z.cx + this.Z.width / 2, this.Z.cy + this.Z.height / 2, 64, 78, 38);
                var3 = 7;
            } else {
                this.P.a(var8, this.Z.cx + this.Z.width / 2, this.Z.cy + this.Z.height / 2, 48, 78, 38);
            }

            this.aa = this.a(this.ab.cx, this.ab.cy - this.ab.height - var3, "", this, 1085, -15);
            this.P.b((LangLa_cs) this.aa);
            this.af = this.a(this.ae.cx - this.ae.width - var3, this.ae.cy, "", this, 7004, -12);
            this.P.b((LangLa_cs) this.af);
            this.P.b((LangLa_cs) (this.dv = this.a(super.cx + 35, 50, "", this, 6009, 716)));
            if (DataCenter.gI().heightScreen <= 240) {
                this.dv.setXY(this.dv.cx, this.dv.cy - 12);
            }

            this.dv.a(true);
            int var10 = this.X.cx + this.X.width + (this.af.cx - (this.X.cx + this.X.width)) / 2;
            if (DataCenter.gI().widthScreen > 400) {
                var10 = DataCenter.gI().widthScreen / 2 + 6;
            }

            gI().aE.clear();

            int var4;
            for (var4 = 0; var4 < gI().p.length; ++var4) {
                if (gI().p[var4].level > 0 && gI().p[var4].c()) {
                    gI().aE.addElement(gI().p[var4]);
                }
            }

            Collections.sort(gI().aE, beatdz.Skill.$state_Skill().b);
            var4 = Char.gI().e(127) != null ? 6 : 5;

            for (int var5 = 0; var5 < var4; ++var5) {
                LangLa_dz var9 = this.a(var10 - var4 / 2 * 32 - 16 + var5 * 31, DataCenter.gI().heightScreen - 62, "", this, 1021 + var5, 460);
                if (DataCenter.gI().widthScreen <= 400) {
                    var9.setXY(var10 - var4 / 2 * 32 - 16 + var5 * 31 + (var4 % 2 == 0 ? 28 : 0), var9.cy);
                }

                if (var5 < gI().aE.size()) {
                    Skill var6 = (Skill) gI().aE.elementAt(var5);
                    short var7 = var6.getSkillTemplate().idIcon;
                    var9.d = (short) var7;
                }

                this.P.b((LangLa_cs) var9);
                var2.addElement(var9);
            }

            if (DataCenter.gI().widthScreen <= 400 && var4 == 6) {
                this.dJ = this.a(var10 - 30 - 23 + 155, DataCenter.gI().heightScreen - 72, "", this, 1090, 620);
            } else {
                this.dJ = this.a(var10 - 64 - 16 + 155, DataCenter.gI().heightScreen - 62, "", this, 1090, 620);
            }

            this.P.b((LangLa_cs) this.dJ);
            var2.addElement(this.dJ);
            this.P.c = var2;
        }

        DataCenter.gI().aH = false;
    }

    public MapTemplate getMapTemplate() {
        return DataCenter.gI().MapTemplate[this.mapID];
    }

    public boolean i() {
        if (!beatdz.GameSrc.$state_GameSrc().an && this.V == null) {
            if (this.aY) {
                this.aY = false;
                this.e(this.getMapTemplate().name + "\n" + Caption.gG + this.zoneID, -2560);
            }

            return true;
        } else {
            return false;
        }
    }

    private void applyRenderMotion(Graphics g, Entity entity) {
        if (!Canvas.isMobile()) return;
        Entity subject = entity instanceof LangLa_ir ? ((LangLa_ir)entity).renderSubject() : entity;
        if (subject == null) return;
        float alpha = AppListener.gI().canvas.renderAlpha;
        g.motionX += renderMotion.exactX(subject, alpha);
        g.motionY += renderMotion.exactY(subject, alpha);
    }

    public void onZoomChanged() {
        int dx = DataCenter.gI().widthScreen - this.width;
        int dy = DataCenter.gI().heightScreen - this.height;
        setSize(DataCenter.gI().widthScreen, DataCenter.gI().heightScreen);
        if (U == null || O == null || X == null) return;
        // Finish panel animations once. Old animation targets must not drag icons back.
        for (Object value : U.a) { LangLa_cs control = (LangLa_cs)value; control.setXY(control.cx + dx, control.cy); }
        U.relayout(mConfig.gI().readBoolean(23));
        if (ak != null) ak.setXY(ak.cx, ak.cy + dy / 2);
        if (dE != null) dE.setXY(dE.cx, dE.cy + dy / 2);
        if (dF != null) dF.setXY(dF.cx, dF.cy + dy / 2);
        if (dD != null) dD.setXY(dD.cx, dD.cy + dy / 2);
        if (ag != null) ag.setXY(ag.cx, ag.cy + dy / 2);
        if (S != null) S.relayout(!mConfig.gI().readBoolean(14));
        o(0); g();
        X.setXY(X.cx, height - X.height - (mConfig.gI().readBoolean(15) ? 25 : 20)); X.d();
        if (aj != null) {
            int left = Math.max(0, X.cx + X.width + 5);
            int right = af == null ? width - 10 : af.cx - 18;
            aj.setSize(Math.max(30, Math.min(220, right - left)), aj.height);
            aj.setXY(Math.max(left, width / 2 - aj.width / 2 - 5), height - aj.height - 8);
            if (du != null) du.setXY(aj.cx + aj.width - 6, aj.cy + aj.height / 2 - 9);
        }
        O.relayout(O.c());
        DataCenter.gI().aH = false;
        renderMotion.reset(); M();
        // Layout changes may happen before the next logic tick; keep culling bounds valid.
        DataCenter.gI().l = DataCenter.gI().j + width;
        DataCenter.gI().m = DataCenter.gI().k + height;
    }

    public void j() {
        try {
            int var1 = Char.gI().cx - DataCenter.gI().widthScreen / 2;
            int var2 = Char.gI().cy - DataCenter.gI().heightScreen / 2 - Char.gI().height / 2;
            int var3 = Char.gI().cx + DataCenter.gI().widthScreen / 2;
            int var4 = Char.gI().cy + DataCenter.gI().heightScreen / 2 - Char.gI().height / 2;
            if (this.dI > 0) {
                --this.dI;
                var1 -= Utlis.nextInt(this.dI / 2);
                var2 -= Utlis.nextInt(this.dI / 2);
                var3 += Utlis.nextInt(this.dI / 2);
                var4 += Utlis.nextInt(this.dI / 2);
            }

            if (var1 < 0) {
                var1 = 0;
                var3 = DataCenter.gI().widthScreen;
            }

            if (var2 < 0) {
                var2 = 0;
                var4 = DataCenter.gI().heightScreen;
            }

            if (var3 > this.maxX) {
                var1 = (short) (this.maxX - DataCenter.gI().widthScreen);
            }

            if (var4 > this.maxY) {
                var2 = (short) (this.maxY - DataCenter.gI().heightScreen);
            }

            DataCenter var10000;
            if (DataCenter.gI().j != var1) {
                this.dl = var1 - DataCenter.gI().j << 2;
                this.dm += this.dl;
                var10000 = DataCenter.gI();
                var10000.j += this.dm >> 5;
                this.dm &= 15;
            }

            if (DataCenter.gI().k != var2) {
                this.dn = var2 - DataCenter.gI().k << 2;
                this.do_ += this.dn;
                var10000 = DataCenter.gI();
                var10000.k += this.do_ >> 5;
                this.do_ &= 15;
            }

            DataCenter.gI().l = DataCenter.gI().j + DataCenter.gI().widthScreen;
            DataCenter.gI().m = DataCenter.gI().k + DataCenter.gI().heightScreen;

            for (var2 = 0; var2 < this.d.size(); ++var2) {
                LangLa_lo var6;
                if ((var6 = (LangLa_lo) this.d.get(var2)).o().type == 7) {
                    var6.cx = (short) (var6.l + DataCenter.gI().j * 20 / 23);
                } else if (var6.o().type == 8) {
                    var6.cx = (short) (var6.l + DataCenter.gI().j * 10 / 13);
                } else if (var6.o().type == 9) {
                    var6.cx = (short) (var6.l + DataCenter.gI().j * 20 / 22);
                } else if (var6.o().type == 10) {
                    var6.cx = (short) (var6.l + DataCenter.gI().j * 10 / 12);
                }
            }

        } catch (Exception var5) {
        }
    }

    public static void k() {
        Writer var0 = null;
        boolean var4 = false;

        label70:
        {
            try {
                var4 = true;
                Message.c((byte) -23).send();
                var0 = new Writer();
                LoginPCScreen var1;
                String[] var7 = (var1 = beatdz.LoginPCScreen.$state_LoginPCScreen().instance).c.size() > 0 ? (String[]) ((String[]) var1.c.lastElement()) : new String[]{var1.a.f().trim(), var1.b.f().trim()};
                var0.writeUTF(Utlis.encodeString(var7[0]));
                var0.writeUTF(Utlis.encodeString(var7[1]));
                var0.writeUTF(Utlis.encodeString(Char.gI().name));
                var0.writeUTF(DataCenter.gI().ipServer);
                var0.writeShort(DataCenter.gI().portServer);
                var0.writeInt(beatdz.SettingsTab.$state_SettingsTab().c);
                var0.writeInt(beatdz.SettingsTab.$state_SettingsTab().d);
                var0.writeInt(beatdz.SettingsTab.$state_SettingsTab().e);
                var0.writeShort(0);
                var0.close("arr_reset");
                Utlis.sleep(1500L);
                var4 = false;
                break label70;
            } catch (Exception var5) {
                Utlis.println(var5);
                var4 = false;
            } finally {
                if (var4) {
                    if (var0 != null) {
                        var0.close();
                    }

                }
            }

            if (var0 != null) {
                var0.close();
                return;
            }

            return;
        }

        var0.close();
    }

    public void a(Message var1) {
        try {
            if (!LangLa_ep.a()) {
                int var2 = var1.reader.dis.readInt();
                boolean var3;
                if ((!(var3 = var1.reader.dis.readBoolean()) || !mConfig.gI().readBoolean(22)) && (var3 || !mConfig.gI().readBoolean(21)) && (var2 != Char.gI().idEntity || !mConfig.gI().readBoolean(20))) {
                    (new Thread(new LangLa_ma(this, var1))).start();
                }
            }
        } catch (Exception var4) {
        }
    }

    public void b() {
        //AutoPro.update();
//        if (System.currentTimeMillis() - InputCanvas.k > 900000L && !Char.gI().j()) {
//            if (!Graphics.q) {
//                gI().cq = 2;
//            }
//
//            Graphics.q = true;
//        } else {
//            if (Graphics.q) {
//                gI().cq = 2;
//            }
//
//            Graphics.q = false;
//        }

        if (this.i()) {
            this.bP = false;
        } else {
            this.bP = true;
        }

        if (gI().bN) {
            ++this.dp;
            if (this.dp > 50) {
                gI().bN = false;
                Char.gI().stopMove();
            }
        } else {
            this.dp = 0;
        }

        if (this.dv != null) {
            if (!beatdz.DataCenter.$state_DataCenter().ar && this.pointNAP <= 0) {
                this.dv.b(false);
            } else {
                this.dv.b(true);
            }
        }

        byte var1 = 0;

        try {
            if (Utlis.time() / 1000L - (long) this.bm > 300L) {
                this.bm = (int) (Utlis.time() / 1000L);
                (new Message((byte) -87)).send();
            }

            if (this.bl < 1000) {
                --this.bl;
                if (this.bl < 0) {
                    this.bl = 1000;
                }
            }

            GameSrc var6 = this;
            this.bt = this.bu = this.bw = this.by = this.bv = this.bx = 0;
            this.bE = false;

            int var2;
            int var3;
            boolean var4;
            Item var5;
            try {
                var4 = System.currentTimeMillis() - var6.dA > 1000L;
                var2 = 0;

                while (true) {
                    if (var2 >= Char.gI().arrItemBag.length) {
                        if (Char.gI().level() < 10) {
                            break;
                        }
                        AutoPro.isBuyHPMP = var6.bu == 0 || var6.bw == 0;
                        AutoPro.isBuyTA = var6.bx == 0;

                        if (var6.bu == 0 && System.currentTimeMillis() - var6.bp >= 800000L) {
                            LangLa_jh.a().a(Caption.py, mFont.d, -2560);
                            var6.bp = System.currentTimeMillis();
                            break;
                        }

                        if (var6.bw == 0 && System.currentTimeMillis() - var6.bq >= 900000000L) {
                            LangLa_jh.a().a(Caption.pz, mFont.d, -2560);
                            var6.bq = System.currentTimeMillis();
                            break;
                        }

                        if (var6.bx == 0 && System.currentTimeMillis() - var6.br >= 1000000000L && !Char.gI().g(0)) {
                            LangLa_jh.a().a(Caption.pA, mFont.d, -2560);
                            var6.br = System.currentTimeMillis();
                        }
                        break;
                    }

                    if ((var5 = Char.gI().arrItemBag[var2]) != null) {
                        if (var5.id == 601) {
                            var6.bE = true;
                        }

                        if (var6.mapID == 45) {
                            if (var5.id == 659) {
                                var6.bu += var5.getAmount();
                            }
                        } else if (var5.getItemTemplate().type == 22) {
                            var6.bu += var5.getAmount();
                        } else if (var5.getItemTemplate().type == 23) {
                            var6.bw += var5.getAmount();
                        } else if (var5.getItemTemplate().type == 24) {
                            var6.bx += var5.getAmount();
                        } else if (var5.id == 720) {
                            var6.bt += var5.getAmount();
                        }

                        if (var5.id == var6.bz) {
                            var6.by += var5.getAmount();
                        } else if (var5.id == 160) {
                            var6.bv += var5.getAmount();
                        }

                        if (var4 && SettingsTab.gI().a[9] == 0 && Char.gI().rank > 0 && var5.v() && var5.level == 0 && var5.T() == 0) {
                            var3 = 0;
                            ItemOption[] var7;
                            if ((var7 = var5.L()) != null) {
                                var3 = var7.length;
                            }

                            byte var27;
                            if ((var27 = SettingsTab.gI().a[16]) <= 0 || var3 <= var27) {
                                a(var5, true);
                                var6.dA = System.currentTimeMillis();
                            }
                        }
                    }

                    ++var2;
                }
            } catch (Exception var10) {
            }

            if (this.V != null) {
                this.D();

                try {
                    this.V.b();
                    if (DataCenter.gI().i % 2 == 0 && this.V.a < 90) {
                        this.V.e();
                    }
                } catch (Exception var9) {
                }

                if (!this.ba) {
                    return;
                }
            }

            if (mConfig.gI().readBoolean(18) && SettingsTab.gI().f() && Gdx.app.getType() == ApplicationType.Desktop) {
                if (beatdz.GameSrc.$state_GameSrc().dC == 0L) {
                    beatdz.GameSrc.$state_GameSrc().dC = System.currentTimeMillis();
                }

                if (mConfig.gI().readByte(19) > 0) {
                    byte var14;
                    long var18;
                    if ((var14 = mConfig.gI().readByte(19)) == 1) {
                        var18 = 1800000L;
                    } else {
                        var18 = (long) (var14 - 1) * 3600000L;
                    }

                    if (System.currentTimeMillis() - beatdz.GameSrc.$state_GameSrc().dC > var18) {
                        k();
                        AppListener.gI().k();
                    }
                } else {
                    beatdz.GameSrc.$state_GameSrc().dC = 0L;
                }
            } else {
                beatdz.GameSrc.$state_GameSrc().dC = 0L;
            }

            if (this.bn > 0) {
                --this.bn;
                if (this.bn == 0) {
                    this.D();
                }
            }

            if (beatdz.DataCenter.$state_DataCenter().aR == 2) {
                beatdz.DataCenter.$state_DataCenter().aR = 0;
                if (beatdz.SettingsTab.$state_SettingsTab().c >= 0) {
                    this.cc = true;
                }
            }

            if (gI().ck > 0L && this.cD.size() == 1) {
                LangLa_dt.b().c();
            }

            boolean var13 = true;
            this.K.removeAllElements();
            this.M.removeAllElements();
            this.L.removeAllElements();
            if (this.aA != null && (this.aA instanceof Mob && !((Mob) this.aA).x() || this.aA instanceof ItemMap && ((ItemMap) this.aA).item.id == 224 || !this.vItemMap.contains(this.aA) && !this.vChar.contains(this.aA) && !this.vNpc.contains(this.aA) && !this.vMob.contains(this.aA))) {
                this.l();
            }

            var13 = true;
            if (!this.isTimeHoatDong) {
                for (var3 = 0; var3 < gI().vWayPoint.size(); ++var3) {
                    WayPoint var15;
                    if ((var15 = (WayPoint) gI().vWayPoint.elementAt(var3)) != null && Utlis.inRange(var15.a() - 60, var15.c() - 60, var15.b() + 60, var15.d() + 60, DataCenter.gI().j, DataCenter.gI().k, DataCenter.gI().l, DataCenter.gI().m)) {
                        this.K.addElement(var15);
                    }
                }
            }

            int var19;
            int var21;
            for (var3 = 0; var3 < gI().d.size(); ++var3) {
                LangLa_lo var16;
                if ((var16 = (LangLa_lo) gI().d.elementAt(var3)) != null) {
                    LangLa_lo var24 = var16;

                    try {
                        if (var24.o().idEff != 152 && var24.o().idEff != 162 && var24.o().idEff != 163 && var24.o().idEff != 164 && var24.o().idEff != 165 && var24.o().idEff != 166 && var24.o().idEff != 167 && var24.o().idEff != 168 && var24.o().idEff != 169 && var24.o().idEff != 268) {
                            if (var24.o().idEff >= 0 && var24.n == null) {
                                if (var24.o().idEff == 181) {
                                    if (Utlis.nextInt((int) 100) == 0) {
                                        var19 = var24.cx + Utlis.nextInt(-100, 100);
                                        var21 = var24.cy + Utlis.nextInt(-10, 10);
                                        if (var19 < 10) {
                                            var19 = 10;
                                        }

                                        if (var19 > gI().maxX - 10) {
                                            var19 = gI().maxX - 10;
                                        }

                                        if (var21 < 720) {
                                            var21 = 720;
                                        }

                                        if (var21 > gI().maxY - 5) {
                                            var21 = gI().maxY - 5;
                                        }

                                        var24.n = new LangLa_jw(var24.o().idEff, var19, var21, 1);
                                        var24.n.m = var24.j == 7;
                                    }
                                } else {
                                    var24.n = new LangLa_jw(var24.o().idEff, var24.cx, var24.cy, -1);
                                    var24.n.m = var24.j == 7;
                                }
                            }
                        } else if (var24.o == null) {
                            var24.o = new Mob();
                            switch (var24.o().idEff) {
                                case 152:
                                    var24.o.id = 204;
                                    break;
                                case 162:
                                    var24.o.id = 206;
                                    break;
                                case 163:
                                    var24.o.id = 205;
                                    break;
                                case 164:
                                    var24.o.id = 209;
                                    break;
                                case 165:
                                    var24.o.id = 207;
                                    break;
                                case 166:
                                    var24.o.id = 212;
                                    break;
                                case 167:
                                    var24.o.id = 208;
                                    break;
                                case 168:
                                    var24.o.id = 210;
                                    break;
                                case 169:
                                    var24.o.id = 211;
                                    break;
                                case 190:
                                    var24.o.id = 247;
                                    break;
                                case 268:
                                    var24.o.id = 272;
                            }

                            var24.o.hp = 1;
                            var24.o.b(var24.cx, var24.cy);
                            var24.setSize(var24.o.getMobTemplate().width, var24.o.getMobTemplate().height);
                            var24.o.speedMove = var24.o.getMobTemplate().speedMoveByte;
                            var24.o.dir = (byte) (Utlis.nextBoolean() ? 2 : 3);
                        }

                        if (var24.o != null) {
                            var24.o.t();
                            var24.width = var24.o.width;
                            var24.height = var24.o.height;
                            var24.setXY(var24.o.cx, var24.o.cy);
                        } else if (var24.n != null) {
                            var24.n.o();
                            var24.width = var24.n.width;
                            var24.height = var24.n.height;
                            if (var24.o().idEff != 181) {
                                var24.setXY(var24.n.cx, var24.n.cy);
                            }

                            if (var24.n.r()) {
                                var24.n = null;
                            }
                        }
                    } catch (Exception var11) {
                        Utlis.println(var11);
                    }

                    if (Utlis.inRange(var16.a(), var16.c(), var16.b(), var16.d(), DataCenter.gI().j, DataCenter.gI().k, DataCenter.gI().l, DataCenter.gI().m)) {
                        this.K.addElement(var16);
                    }
                }
            }

            var13 = true;
            Item var17;
            Char var23 = Char.gI();
            if (this.dJ != null) {
                if ((var17 = (var23).arrItemBody[14]) == null || var17.id != 788 && (var17.strOptions == null || !var17.strOptions.contains(";333,0"))) {
                    this.dJ.v = true;
                } else {
                    this.dJ.v = false;
                }
            }

            if (!Graphics.m()) {
                updateMove();
            }

            this.K.addElement(var23);
            if (var23.status != 6 && var23.D == 0) {
                this.K.addElement(new LangLa_ir(var23.i(), var23.ai, var23.aj, var23));
                if (var23.aL != null) {
                    this.K.addElement(new LangLa_ir(var23.aL.i(), var23.aL.x, var23.aL.y, var23.aL));
                }

                if (var23.bh != null) {
                    this.K.addElement(new LangLa_ir(var23.bh.i(), var23.bh.ai, var23.bh.aj, var23.bh));
                }
            }

            var13 = true;

            for (var2 = 0; var2 < var23.h.size(); ++var2) {
                LangLa_ls var31;
                (var31 = (LangLa_ls) var23.h.elementAt(var2)).o();
                this.K.addElement(var31);
            }

            var13 = true;
            var2 = 0;

            for (var19 = 0; var19 < this.vChar.size(); ++var19) {
                (var23 = (Char) this.vChar.elementAt(var19)).t();
                if (Utlis.inRange(var23.a(), var23.c(), var23.b(), var23.d(), DataCenter.gI().j, DataCenter.gI().k, DataCenter.gI().l, DataCenter.gI().m)) {
                    var23.g = false;
                    ++var2;
                    if (var2 > 30 && !var23.equals(this.aA) && !var23.equals(Char.gI())) {
                        var23.g = true;
                    }

                    this.K.addElement(var23);
                    if (var23.status != 6 && var23.D == 0) {
                        this.K.addElement(new LangLa_ir(var23.i(), var23.ai, var23.aj, var23));
                        if (var23.aL != null) {
                            this.K.addElement(new LangLa_ir(var23.aL.i(), var23.aL.x, var23.aL.y, var23.aL));
                        }
                    }

                    this.M.add(var23);
                }

                for (var21 = 0; var21 < var23.h.size(); ++var21) {
                    LangLa_ls var29;
                    (var29 = (LangLa_ls) var23.h.elementAt(var21)).o();
                    this.K.addElement(var29);
                }
            }

            var13 = true;

            for (var19 = this.vCharWaitRemove.size() - 1; var19 >= 0; --var19) {
                var23 = (Char) this.vCharWaitRemove.elementAt(var19);
                if (!this.vChar.contains(var23)) {
                    this.vCharWaitRemove.removeElementAt(var19);
                } else if (var23.pointMove == null && var23.vPointMove.size() == 0) {
                    this.vCharWaitRemove.removeElementAt(var19);
                    this.vChar.remove(var23);
                }
            }

            var13 = true;
            this.ca = false;

            Mob var36;
            for (var21 = 0; var21 < this.vMob.size(); ++var21) {
                (var36 = (Mob) this.vMob.elementAt(var21)).t();
                boolean var10000;
                if (var36.id != 293 && var36.id != 294) {
                    if ((gI().Task == 4 || gI().Task == 14) && var36.nameChar.equals(Char.gI().name) && !Char.gI().j()) {
                        label1152:
                        {
                            if (var36.dir == 3) {
                                if (Utlis.getRange((XYEntity) Char.gI(), (XYEntity) var36) > 15) {
                                    Char.gI().a(var36.cx + 15, var36.cy, var36.dir);
                                    var10000 = true;
                                    break label1152;
                                }
                            } else if (Utlis.getRange((XYEntity) Char.gI(), (XYEntity) var36) > 15) {
                                Char.gI().a(var36.cx - 15, var36.cy, var36.dir);
                                var10000 = true;
                                break label1152;
                            }

                            if (Utlis.getRange((XYEntity) Char.gI(), (XYEntity) var36) > 15) {
                                Char.gI().a(var36.cx, var36.cy, var36.dir);
                            }

                            var10000 = true;
                        }
                    } else {
                        var10000 = false;
                    }
                } else {
                    var10000 = false;
                }

                if (var10000) {
                    this.ca = true;
                }

                if (Utlis.inRange(var36.a(), var36.c(), var36.b(), var36.s(), DataCenter.gI().j, DataCenter.gI().k, DataCenter.gI().l, DataCenter.gI().m)) {
                    this.K.addElement(var36);
                    if (var36.status != 4 && var36.status != 6) {
                        this.K.addElement(new LangLa_ir(var36.i(), var36.x, var36.y, var36));
                    }

                    if (var36.status == 4 || var36.status == 6 || var36.status == 5) {
                        continue;
                    }

                    this.M.add(var36);
                }

                for (int var32 = 0; var32 < var36.h.size(); ++var32) {
                    LangLa_ls var30;
                    (var30 = (LangLa_ls) var36.h.elementAt(var32)).o();
                    this.K.addElement(var30);
                }
            }

            for (var2 = this.dH.size() - 1; var2 >= 0; --var2) {
                (var36 = (Mob) this.dH.elementAt(var2)).status = 2;
                var36.t();
                --var36.W;
                if (var36.W < 0) {
                    this.dH.removeElement(var36);
                } else if (Utlis.inRange(var23.a(), var23.c(), var23.b(), var23.d(), DataCenter.gI().j, DataCenter.gI().k, DataCenter.gI().l, DataCenter.gI().m)) {
                    this.K.addElement(var36);
                } else {
                    this.dH.removeElement(var36);
                }
            }

            var13 = true;

            for (var3 = 0; var3 < this.vNpc.size(); ++var3) {
                Npc var34;
                (var34 = (Npc) this.vNpc.elementAt(var3)).q();
                if (Utlis.inRange(var34.a(), var34.c(), var34.b(), var34.cy + var34.height, DataCenter.gI().j, DataCenter.gI().k, DataCenter.gI().l, DataCenter.gI().m)) {
                    this.K.addElement(var34);
                    if (var34.status != 6) {
                        this.K.addElement(new LangLa_ir(var34.i(), var34.cx, var34.cy, var34));
                    }

                    if (var34.status != 4 && var34.status != 6 && var34.status != 5) {
                        this.M.add(var34);
                    }
                }
            }

            var13 = true;

            for (var2 = this.vItemMap.size() - 1; var2 >= 0; --var2) {
                ItemMap var33;
                (var33 = (ItemMap) this.vItemMap.elementAt(var2)).o();
                if (Utlis.inRange(var33.a(), var33.c(), var33.b(), var33.d(), DataCenter.gI().j, DataCenter.gI().k, DataCenter.gI().l, DataCenter.gI().m)) {
                    this.K.addElement(var33);
                    if (var33.item.id != 224) {
                        this.M.add(var33);
                    }
                }
            }

            var13 = true;

            for (var3 = this.G.size() - 1; var3 >= 0; --var3) {
                LangLa_hi var37;
                (var37 = (LangLa_hi) this.G.elementAt(var3)).q();
                if (var37.p()) {
                    this.G.removeElement(var37);
                } else if (Utlis.inRange(var37.a(), var37.c(), var37.b(), var37.d(), DataCenter.gI().j, DataCenter.gI().k, DataCenter.gI().l, DataCenter.gI().m)) {
                    this.K.addElement(var37);
                }
            }

            var13 = true;

            for (var2 = this.I.size() - 1; var2 >= 0; --var2) {
                LangLa_jw var35;
                if ((var35 = (LangLa_jw) this.I.elementAt(var2)) != null) {
                    var35.o();
                    if (var35.r()) {
                        this.I.removeElement(var35);
                    } else if (Utlis.inRange(var35.a() - 50, var35.c() - 50, var35.b() + 50, var35.d() + 50, DataCenter.gI().j, DataCenter.gI().k, DataCenter.gI().l, DataCenter.gI().m)) {
                        this.K.addElement(var35);
                    }
                }
            }

            var13 = true;

            for (var3 = this.H.size() - 1; var3 >= 0; --var3) {
                LangLa_hm var38;
                (var38 = (LangLa_hm) this.H.elementAt(var3)).q();
                if (var38.p()) {
                    this.H.removeElement(var38);
                } else if (Utlis.inRange(var38.a() - 50, var38.c() - 50, var38.b() + 50, var38.d() + 50, DataCenter.gI().j, DataCenter.gI().k, DataCenter.gI().l, DataCenter.gI().m)) {
                    this.K.addElement(var38);
                }
            }

            var13 = true;
            if (!this.aG.p()) {
                this.K.addElement(this.aG);
            }

            this.aF.q();
            this.aG.q();
            if (this.bf > 0) {
                --this.bf;
            }

            if (this.bg > 0) {
                --this.bg;
            }

            if (this.bh > 0) {
                --this.bh;
            }

            if (this.bi > 0) {
                --this.bi;
            }

            Char.gI();
            if (!Graphics.m()) {
                Char_O();
            }
            if (this.dq != null) {
                for (var3 = 0; var3 < this.dq.length; ++var3) {
                    if (this.dq[var3] != null) {
                        this.dq[var3].o();
                        if (this.dq[var3] != null && Utlis.inRange(this.dq[var3].a() - 50, this.dq[var3].c() - 50, this.dq[var3].b() + 50, this.dq[var3].d() + 50, DataCenter.gI().j, DataCenter.gI().k, DataCenter.gI().l, DataCenter.gI().m)) {
                            this.K.add(this.dq[var3]);
                        }
                    }
                }
            }

            if (this.dr != null) {
                for (var3 = 0; var3 < this.dr.length; ++var3) {
                    if (this.dr[var3] != null) {
                        this.dr[var3].o();
                        if (this.dr[var3] != null && Utlis.inRange(this.dr[var3].a() - 50, this.dr[var3].c() - 50, this.dr[var3].b() + 50, this.dr[var3].d() + 50, DataCenter.gI().j, DataCenter.gI().k, DataCenter.gI().l, DataCenter.gI().m)) {
                            this.K.add(this.dr[var3]);
                        }
                    }
                }
            }

            if (this.cx.size() > 0) {
                for (var3 = this.cx.size() - 1; var3 >= 0; --var3) {
                    if (((LangLa_en) this.cx.get(var3)).c()) {
                        this.cx.removeElementAt(var3);
                    } else {
                        LangLa_em[] var39 = ((LangLa_en) this.cx.get(var3)).a;

                        for (var19 = 0; var19 < var39.length; ++var19) {
                            if (var39[var19] != null) {
                                var39[var19].o();
                                if (var39[var19] != null && Utlis.inRange(var39[var19].a() - 50, var39[var19].c() - 50, var39[var19].b() + 50, var39[var19].d() + 50, ((LangLa_en) this.cx.get(var3)).b() - 3 * DataCenter.gI().widthScreen / 2, DataCenter.gI().k, ((LangLa_en) this.cx.get(var3)).b() + 3 * DataCenter.gI().widthScreen / 2, DataCenter.gI().m)) {
                                    this.K.add(var39[var19]);
                                }
                            }
                        }
                    }
                }
            }

            try {
                Collections.sort(this.K, beatdz.XYEntity.$state_XYEntity().db);
            } catch (Exception var8) {
                Utlis.println(var8);
            }

            if (this.T != null) {
                this.T.b();
            }

            if (this.U != null) {
                this.U.b();
            }

            if (this.S != null) {
                this.S.b();
                if (!this.dG && this.ak != null) {
                    this.dG = true;
                    this.p(mConfig.gI().readByte(13));
                }

                if (!this.S.d() && this.dD != null) {
                    this.dD.b(!this.S.c());
                }
            }

            if (this.O != null) {
                this.O.b();
            }

            if (this.P != null) {
                this.P.b();
            }

            var13 = true;
            LangLa_hy.b();
            if (this.cf > 0) {
                --this.cf;
                this.aA = this.ce;
            } else if (this.aq && this.aA != null) {
                this.aa();
            } else {
                this.ab();
            }

            this.am = false;

            for (var2 = 0; var2 < this.vThu.size(); ++var2) {
                if (!((Thu) this.vThu.elementAt(var2)).k) {
                    this.am = true;
                    break;
                }
            }

            if (this.bM.length() > 0 && this.cD.size() == 1 && DataCenter.gI().aH) {
                this.a((LangLa_cx) (new LangLa_aw(this.bM, this)));
            }

            if (this.bN && (Char.gI().cx >= gI().maxX || Char.gI().cx <= 0)) {
                Char.gI().K();
                this.X();
                return;
            }

            if (this.bP) {
                this.bP = false;
                LangLa_dp.a().k();
            }

            this.V();
        } catch (Exception var12) {
            Utlis.println(var12);
        }

        this.W();
    }

    public void l() {
        this.aA = null;
    }

    private void V() {
        if (!(this.cD.lastElement() instanceof LangLa_az) && this.V == null && !(this.cD.lastElement() instanceof LangLa_fl)) {
            if ((this.Task == 0 && this.idStep == 1 || this.Task == 14 && this.idStep == 0 && Char.gI().level() >= 15) && this.cD.lastElement().equals(this)) {
                DataCenter.gI().aO.a(5 + AppListener.gI().o, this.height / 2 + 20);
                DataCenter.gI().aO.a = true;
            } else {
                if (this.B() != null && this.B().id == 2 && this.aA != null && this.aA instanceof Mob && this.cD.lastElement().equals(this)) {
                    if (this.aA instanceof Mob && ((Mob) this.aA).id == this.B().idMob && Utlis.getRange(Char.gI().cx, this.aA.cx) < 40) {
                        int var10001 = this.width - 30;
                        DataCenter.gI().aO.a(var10001, this.height - 30);
                        DataCenter.gI().aO.a = true;
                        return;
                    }
                } else {
                    if (this.Task == 3 && this.idStep == 1 || this.Task == 0 && this.idStep == 0 || this.Task == 8 && (this.idStep == 9 || this.idStep == 10 || this.idStep == 11)) {
                        DataCenter.gI().aO.a(20, 20);
                        DataCenter.gI().aO.a = true;
                        return;
                    }

                    Step var1;
                    if (this.Task == 6 && this.idStep >= 0 || this.Task == 9 && (this.idStep == 1 || this.idStep == 2)) {
                        if ((var1 = this.B()) != null && Char.gI().cx == var1.x && Char.gI().cy == var1.y) {
                            DataCenter.gI().aO.a(20, 20);
                            DataCenter.gI().aO.a = true;
                        }

                        return;
                    }

                    if (this.Task == 11 && (var1 = this.B()) != null && Char.gI().cx == var1.x && Char.gI().cy == var1.y) {
                        DataCenter.gI().aO.a(20, 20);
                        DataCenter.gI().aO.a = true;
                    }
                }

            }
        } else {
            DataCenter.gI().aO.a = false;
        }
    }

    private void W() {
        LangLa_dp.a().a(this.mapID);
        switch (this.mapID) {
            case 59:
            case 60:
            case 62:
            case 69:
            case 75:
            case 87:
                boolean var1 = false;

                for (int var2 = 0; var2 < this.K.size(); ++var2) {
                    if (this.K.get(var2) instanceof Mob) {
                        Mob var4;
                        if ((var4 = (Mob) this.K.get(var2)).id == 157 || var4.id == 173 || var4.id == 154 || var4.id == 158 || var4.id == 184) {
                            var1 = true;
                            break;
                        }
                    } else {
                        LangLa_lo var3;
                        if (this.K.get(var2) instanceof LangLa_lo && ((var3 = (LangLa_lo) this.K.get(var2)).k == 216 || var3.k == 217 || var3.k == 210)) {
                            var1 = true;
                            break;
                        }
                    }
                }

                if (var1) {
                    LangLa_dp.a().g();
                    return;
                } else {
                    LangLa_dp.a().c();
                }
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 84:
            default:
                return;
            case 61:
                if (Char.gI().cx >= 700) {
                    LangLa_dp.a().g();
                    return;
                }

                LangLa_dp.a().c();
                return;
            case 68:
                if (Char.gI().cx <= 600) {
                    LangLa_dp.a().g();
                    return;
                }

                LangLa_dp.a().c();
                return;
            case 83:
                if (330 <= Char.gI().cx && Char.gI().cx <= 990) {
                    LangLa_dp.a().g();
                    return;
                }

                LangLa_dp.a().c();
                return;
            case 85:
                if (Char.gI().cy >= 550) {
                    LangLa_dp.a().g();
                    return;
                }

                LangLa_dp.a().c();
                return;
            case 86:
                if (Char.gI().cx >= 1000 && Char.gI().cx <= 1620 && Char.gI().cy >= 140) {
                    LangLa_dp.a().g();
                } else {
                    LangLa_dp.a().c();
                }
        }
    }

    private void X() {
        try {
            long var1 = Utlis.time();
            this.L();
            if (!beatdz.GameSrc.$state_GameSrc().an) {//&& var1 - cA >= 500L
                beatdz.GameSrc.$state_GameSrc().an = true;
                beatdz.GameSrc.$state_GameSrc().cA = var1;
                (new Message((byte) 127)).send();
            }
        } catch (Exception var3) {
        }
    }

    private void a(Vector var1, Vector var2, int var3) {
        Vector var4 = new Vector();

        for (int var5 = var1.size() - 3; var5 >= 0; --var5) {
            WayPoint var6 = (WayPoint) var1.elementAt(var5);
            var4.clear();
            var4.addAll(var2);
            Vector var8;
            if ((var8 = this.a(var4, var6.mapHere, var3, false)).size() > 0 && var8.size() < var1.size() - var5) {
                for (int var7 = var1.size() - 1; var7 >= var5; --var7) {
                    var1.removeElementAt(var7);
                }

                var1.addAll(var8);
                var5 = var1.size() - 2;
            }
        }

    }

    private Vector a(Vector var1, int var2, int var3, boolean var4) {
        Vector var5;
        (var5 = new Vector()).addAll(var1);
        Vector var6 = new Vector();

        while (true) {
            Vector var7 = new Vector();
            if (!this.a(var2, var3, var1, var7)) {
                var1 = new Vector();

                for (var2 = 0; var2 < var6.size(); ++var2) {
                    var7 = (Vector) var6.elementAt(var2);
                    if (var4) {
                        this.a(var7, var5, var3);
                    }

                    if (var1.size() == 0 || var7.size() < var1.size()) {
                        var1 = var7;
                    }
                }

                return var1;
            }

            var6.add(var7);
            var1.remove(beatdz.GameSrc.$state_GameSrc().bc);
        }
    }

    public int m() {
        try {
            return Char.gI().d(this.bz).index;
        } catch (Exception var2) {
            Utlis.println(var2);
            return -1;
        }
    }

    private boolean a(int var1, int var2, Vector var3, Vector var4) {
        if (var1 == var2) {
            return true;
        } else {
            for (int var5 = 0; var5 < var3.size(); ++var5) {
                short[] var6;
                Vector var7;
                WayPoint var8;
                if ((var6 = (short[]) ((short[]) var3.elementAt(var5)))[0] == var1) {
                    (var7 = new Vector()).addAll(var3);
                    var7.remove(var5);
                    if (this.a(var6[5], var2, var7, var4)) {
                        beatdz.GameSrc.$state_GameSrc().bc = var5;
                        (var8 = new WayPoint(0, 0)).a(var6[0], var6[5], var6[1], var6[2], var6[3], var6[4]);
                        var4.insertElementAt(var8, 0);
                        return true;
                    }
                } else if (var6[5] == var1) {
                    (var7 = new Vector()).addAll(var3);
                    var7.remove(var5);
                    if (this.a(var6[0], var2, var7, var4)) {
                        beatdz.GameSrc.$state_GameSrc().bc = var5;
                        (var8 = new WayPoint(0, 0)).a(var6[5], var6[0], var6[6], var6[7], var6[8], var6[9]);
                        var4.insertElementAt(var8, 0);
                        return true;
                    }
                }
            }

            return false;
        }
    }

    public void a(boolean var1) {
        this.ap = var1;
    }

    private void Y() {
        if (!this.ae()) {
            boolean var2 = true;
            this.ap = var2;
            Collections.sort(this.M, beatdz.Entity.$state_Entity().i);
            if (this.M.size() <= 0) {
                this.aA = null;
            } else {
                int var1 = this.M.size();
                int var5 = -1;
                if (this.aA != null) {
                    var5 = this.M.indexOf(this.aA);
                }

                int var3 = 0;

                while (true) {
                    if (var3 < var1) {
                        ++var5;
                        if (var5 >= this.M.size()) {
                            var5 = 0;
                        }

                        Entity var4;
                        if ((var4 = (Entity) this.M.elementAt(var5)) instanceof Mob && !((Mob) var4).x()) {
                            ++var3;
                            continue;
                        }

                        this.aA = var4;
                        break;
                    }

                    return;
                }
            }

        }
    }

    private void Z() {
        Vector var1;
        if ((var1 = MoveSmart.a(Char.gI(), XYEntity.create(this.aA.cx, this.aA.cy - 2), true)) != null && var1.size() > 1) {
            XYEntity var2 = (XYEntity) var1.get(1);
            Char.gI().setDir(this.aA);
            Char.gI().pointMove = new PointMove(var2.cx, var2.cy, Char.gI().speedMove);
        } else {
            Char.gI().setDir(this.aA);
            Char.gI().pointMove = new PointMove(this.aA.cx, this.aA.cy, Char.gI().speedMove);
        }
        if (AutoPro.isAuto(8)) {
            Char.gI().cx = this.aA.cx;
            Char.gI().cy = this.aA.cy;
        }
    }

    private void g(boolean var1) {
        int var5 = Utlis.getRange(Char.gI().cx, Char.gI().cy, this.aA.cx, this.aA.cy);
        if (this.a((XYEntity) this.aA)) {
            this.aq = false;
            this.aA = null;
        } else {
            if (this.aA instanceof Mob) {
                Mob var2 = (Mob) this.aA;
                if (gI().aH != null) {
                    int num = var2.getMobTemplate().speedMove;
                    if (!AutoPro.isAuto(11)) {
                        num = 0;
                    }
                    if (var2.getMobTemplate().type != 9 && var2.getMobTemplate().type != 10 && var2.getMobTemplate().type != 11 && var5 <= gI().aH.rangeNgang + num && var5 <= gI().aH.rangeDoc + num) {
                        this.aq = false;
                        //   Char.gI().stopMove();
                        Char.gI().K();
                        Char.gI().a(gI().aH, this.aA);
                    } else {
                        if ((var2.getMobTemplate().type == 9 || var2.getMobTemplate().type == 10 || var2.getMobTemplate().type == 11) && var5 <= 40) {
                            this.aq = false;
                            Char.gI().stopMove();
                            Char.gI().K();
                            if (var2.getMobTemplate().type == 10) {
                                if (!(this.H() instanceof LangLa_az)) {
                                    b(var2);
                                    this.a((LangLa_cx) (new LangLa_az(this, var2.getMobTemplate().timeThuHoach, var2.getMobTemplate().detail, 0)));
                                    return;
                                }
                            } else if (var2.getMobTemplate().type == 9) {
                                if (Utlis.getRange(Char.gI().cx, var2.cx) < 20) {
                                    if (var2.cx >= Char.gI().cx) {
                                        Char.gI().cx = (short) (var2.cx - 20);
                                    } else {
                                        Char.gI().cx = (short) (var2.cx + 20);
                                    }
                                }

                                Char.gI().cy = var2.cy;
                                a(var2);
                            }

                            return;
                        }

                        this.Z();
                    }
                } else {
                    if (var5 > this.au) {
                        this.Z();
                        return;
                    }

                    this.aq = false;
                    Char.gI().stopMove();
                    if (var2.getMobTemplate().type != 9) {
                        return;
                    }

                    a(var2);
                }
            } else {
                if (this.aA instanceof Char) {
                    Char var8 = (Char) this.aA;
                    if (this.a(var8) && gI().aH != null) {
                        if (var5 <= gI().aH.rangeNgang && var5 <= gI().aH.rangeDoc) {
                            this.aq = false;
                            Char.gI().stopMove();
                            Char.gI().K();
                            Char.gI().a(gI().aH, this.aA);
                            return;
                        }

                        this.Z();
                        return;
                    }
                }

                int var9 = this.au;
                if (this.aA instanceof ItemMap) {
                    var9 = this.av;
                }

                if (var5 <= var9) {
                    this.aq = false;
                    Char.gI().stopMove();
                    Char.gI().K();
                    if (this.aA instanceof Npc) {
                        if (!SettingsTab.gI().autoTrain) {
                            Npc var6;
                            (var6 = (Npc) this.aA).setDir(Char.gI());
                            Char.gI().setDir(this.aA);
                            Char.gI().cy = this.aA.cy;
                            a(var6);
                            return;
                        }
                    } else if (this.aA instanceof ItemMap) {
                        if (!SettingsTab.gI().autoTrain) {
                            try {
                                Char.gI().K();
                                ItemMap var7 = (ItemMap) this.aA;
                                Message var10;
                                (var10 = new Message((byte) 59)).writeShort(var7.idEntity);
                                var10.send();
                                return;
                            } catch (IOException var4) {
                                return;
                            }
                        }
                    } else if (this.aA instanceof Char && gI().aH != null) {
                        this.b((Char) this.aA);
                        return;
                    }
                } else {
                    this.Z();
                }
            }

        }
    }

    private void aa() {
        this.g(false);
    }

    private static void b(ItemMap var0) {
        try {
            Char.gI().K();
            Message var1;
            (var1 = new Message((byte) 59)).writeShort(var0.idEntity);
            var1.send();
        } catch (IOException var2) {
        }
    }

    private void ab() {
        if (this.aA == null) {
            this.b(false);
        } else if (this.a((XYEntity) this.aA) || this.aA instanceof ItemMap && ((ItemMap) this.aA).item.id == 224 || SettingsTab.gI().autoTrain && (this.aA instanceof Npc || this.aA instanceof Mob && ((Mob) this.aA).id == 30)) {
            this.aA = null;
        } else {
            int var2;
            if (this.aA instanceof Char) {
                Char var4;
                if ((var4 = (Char) this.aA).z) {
                    this.aA = null;
                } else if (this.getMapTemplate().id == 45 && var4.typePK != 2) {
                    this.aA = null;
                } else {
                    if (this.getMapTemplate().type == 6 || this.getMapTemplate().type == 5 || this.getMapTemplate().type == 10) {
                        if (var4.j()) {
                            this.aA = null;
                            return;
                        }

                        for (var2 = 0; var2 < var4.vEffect.size(); ++var2) {
                            if (((Effect) var4.vEffect.elementAt(var2)).id == 46) {
                                this.aA = null;
                                return;
                            }
                        }
                    }

                }
            } else if (this.M.indexOf(this.aA) < 0 && !this.ap || this.aA instanceof Mob && this.aA.j()) {
                this.aA = null;
            } else {
                int var1 = Utlis.getRange(Char.gI().cx, Char.gI().cy, this.aA.cx, this.aA.cy);
                var2 = DataCenter.gI().widthScreen;
                if (SettingsTab.gI().autoTrain && SettingsTab.gI().l() > var2) {
                    var2 = SettingsTab.gI().l();
                }

                if (var1 > var2) {
                    this.aA = null;
                }

            }
        }
    }

    public void n() {
        this.ay = Char.gI().cx;
        this.az = Char.gI().cy;
    }

    public static void a(int var0) {
        LangLa_eo var3;
        if ((var3 = new LangLa_eo(var0, -1, -1, -1, 0, 0)).a >= 0) {
            for (int var1 = 0; var1 < gI().vNpc.size(); ++var1) {
                if (((Npc) gI().vNpc.elementAt(var1)).idd == var3.a) {
                    var3.d = gI().mapID;
                    break;
                }
            }

            if (var3.d < 0) {
                gI();
                c(var3);
            }
        }

        gI().aR = var3;
    }

    public static boolean b(int var0) {
        LangLa_eo var4 = new LangLa_eo(var0, -1, -1, -1, 0, 0);
        boolean var1 = false;
        if (var4.a >= 0) {
            for (int var2 = 0; var2 < gI().vNpc.size(); ++var2) {
                Npc var3;
                if ((var3 = (Npc) gI().vNpc.elementAt(var2)).idd == var4.a) {
                    if (var3.status != 6) {
                        var4.d = gI().mapID;
                        break;
                    }

                    var1 = true;
                }
            }

            if (var4.d < 0) {
                gI();
                c(var4);
            }
        }

        if (var1) {
            return false;
        } else {
            gI().aR = var4;
            return true;
        }
    }

    public boolean c(int var1) {
        return this.df.contains(var1);
    }

    public void pickUpItemMap(ItemMap var1) {
        if (this.bl >= 1000) {
            if (var1 != null && !this.vItemMapPickUp.contains(var1)) {
                this.vItemMapPickUp.add(var1);
                if (var1.item.id == 244) {
                    return;
                }

                if (!Char.gI().a(var1) && (var1.idChar == Char.gI().idEntity || var1.idChar == -1) && (this.c(var1.item.id) || var1.item.getItemTemplate().isXepChong && var1.item.expiry == -1L && !var1.item.j() || SettingsTab.gI().y() && var1.item.T() > 0 || SettingsTab.gI().u() && var1.item.q() && (SettingsTab.gI().r() == 0 || var1.item.id >= SettingsTab.gI().r()) || SettingsTab.gI().v() && var1.item.isTypeTrangBi() || SettingsTab.gI().w() && var1.item.j() || SettingsTab.gI().x() && !var1.item.q() && !var1.item.isTypeTrangBi() && !var1.item.j())) {
                    if (!SettingsTab.gI().y() && var1.item.id == 223) {
                        this.vItemMapPickUp.add(var1);
                        return;
                    }

                    if (var1.item.id == 223) {
                        this.bl = 999;
                    }

                    b(var1);
                }
            }

        }
    }

    public boolean d(int var1) {
        for (int var3 = 0; var3 < gI().aI.a.size(); ++var3) {
            LangLa_ey var2 = (LangLa_ey) gI().aI.a.elementAt(var3);
            Char var4;
            if ((var4 = this.b(var2.a)) != null && var4.idEntity == var1) {
                return true;
            }
        }

        return false;
    }

    public void o() {
        try {
            if (System.currentTimeMillis() - this.dA >= 100L && (!(gI().H() instanceof LangLa_ar) || ((LangLa_ar) gI().H()).isAutoCuongHoa) && !(gI().H() instanceof LangLa_au)) {
                int var1;
                if ((var1 = SettingsTab.gI().k()) > 0) {
                    for (var1 = var1; var1 >= 0 && !this.t(var1); --var1) {
                    }

                }
            }
        } catch (Exception var2) {
        }
    }

    public boolean b(boolean var1) {
        if (SettingsTab.gI().autoTrain) {
            return false;
        } else {
            boolean var2 = false;
            this.ap = var2;
            Collections.sort(this.M, beatdz.Entity.$state_Entity().i);
            Skill var10000 = Char.gI().ay;
            int var8 = Char.gI().aU;
            if ((short) (var10000.rangeNgang + var8) > 200) {
                var10000 = Char.gI().ay;
                var8 = Char.gI().aU;
                short var13 = (short) (var10000.rangeNgang + var8);
            }

            for (int var4 = 0; var4 < this.M.size(); ++var4) {
                Entity var9 = (Entity) this.M.elementAt(var4);
                if (!this.a((XYEntity) var9)) {
                    if (!var1) {
                        if (var9 instanceof Npc) {
                            continue;
                        }

                        if (var9 instanceof Char) {
                            Char var10;
                            if ((var10 = (Char) var9).z) {
                                this.aA = null;
                                continue;
                            }

                            if (this.getMapTemplate().id == 45 && var10.typePK != 2) {
                                this.aA = null;
                                continue;
                            }

                            if (this.getMapTemplate().type == 6 || gI().getMapTemplate().type == 10) {
                                boolean var3 = false;
                                if (var10.status == 4 || this.aI.b(var10.name)) {
                                    this.aA = null;
                                    continue;
                                }

                                for (int var12 = 0; var12 < var10.vEffect.size(); ++var12) {
                                    if (((Effect) var10.vEffect.elementAt(var12)).id == 46) {
                                        this.aA = null;
                                        var3 = true;
                                        break;
                                    }
                                }

                                if (var3) {
                                    continue;
                                }
                            }
                        } else if (var9 instanceof Mob) {
                            Mob var5 = (Mob) var9;
                            Step var6 = this.B();
                            if (gI().mapID == 41 || var5.getMobTemplate().type == 11) {
                                continue;
                            }

                            if (var5.getMobTemplate().type == 10) {
                                if ((this.aS == null || this.aS.b != 2 || this.aS.f != var5.id) && (var6 == null || var6.id != 2 || var6.idMob != var5.id)) {
                                    continue;
                                }
                            } else if (SettingsTab.gI().C() && var5.levelBoss == 3) {
                                continue;
                            }
                        }
                    }

                    int var11 = Utlis.getRange(var9.cx, var9.cy, Char.gI().cx, Char.gI().n());
                    if ((var9 instanceof Mob && ((Mob) var9).x() && !((Mob) var9).p() || var9 instanceof Char && this.a((Char) var9)) && !var9.j() && Char.gI().ay != null) {
                        this.aA = var9;
                        return true;
                    }

                    if (var9 instanceof ItemMap && var11 < 50) {
                        this.aA = var9;
                        return true;
                    }
                }
            }

            return false;
        }
    }

    public void p() {
        if (this.i() && !this.bN) {
            if (this.cO.a[5]) {
                if (Utlis.time() - this.bS < 200L) {
                    beatdz.SettingsTab.$state_SettingsTab().i = true;
                    SettingsTab.gI().a(true);
                    gI().aA = null;
                } else {
                    this.bS = Utlis.time();
                    beatdz.SettingsTab.$state_SettingsTab().i = false;
                    SettingsTab.gI().a(false);
                    this.a(Char.gI().ay, false);
                    this.cO.b();
                }
            } else {
                if (this.cO.a[14]) {
                    this.Y();
                }

                boolean var1 = false;
                if (this.cO.b[2]) {
                    Char.gI().C();
                    this.cB = true;
                } else if (this.cO.b[8]) {
                    DataCenter.gI();
                    Char.gI().D();
                    this.cB = true;
                } else if (this.cO.b[4]) {
                    var1 = true;
                    Char.gI().A();
                    this.cB = true;
                } else if (this.cO.b[6]) {
                    var1 = true;
                    Char.gI().B();
                    this.cB = true;
                } else if (this.cB) {
                    this.cB = false;
                }

                if (!var1 && Char.gI().r()) {
                    if (this.cO.b[4]) {
                        Char.gI().A();
                        this.cB = true;
                    } else if (this.cO.b[6]) {
                        Char.gI().B();
                        this.cB = true;
                    }
                }

                if (this.cD.lastElement() instanceof GameSrc && Gdx.app.getType() == ApplicationType.Desktop) {
                    if (this.cO.a[15]) {
                        this.q(0);
                    } else if (this.cO.a[16]) {
                        this.q(1);
                    } else if (this.cO.a[17]) {
                        this.q(2);
                    } else if (this.cO.a[18]) {
                        this.q(3);
                    } else if (this.cO.a[19]) {
                        this.q(4);
                    } else if (this.cO.a[20]) {
                        this.Y();
                    }
                }

                this.b((LangLa_cs) this.du);
                this.a((LangLa_cs) this.du);
            }
        } else {
            if (this.cP != null) {
                this.cP.b = -1;
            }

        }
    }

    public void a(Graphics var1) {
        try {
            AppListener.gI().setWindowedMode();
            if (AppListener.$state_AppListener().h > 0) {
                --AppListener.$state_AppListener().h;
                if (AppListener.$state_AppListener().h == 0) {
                    DataCenter.gI().g();
                    return;
                }
            }

            GameSrc var3 = this;

            int var4;
            for (var4 = this.cb.size() - 1; var4 >= 0; --var4) {
                Binary.disposeImage((mImage) var3.cb.remove(var4));
            }

            int var14;
            int var30;
            if (beatdz.SettingsTab.$state_SettingsTab().n) {
                beatdz.SettingsTab.$state_SettingsTab().n = false;
                Vector var19 = new Vector();
                Iterator var2 = beatdz.LangLa_fq.$state_LangLa_fq().e.keySet().iterator();

                short var6;
                while (var2.hasNext()) {
                    var6 = (Short) var2.next();
                    if (!beatdz.LangLa_fq.$state_LangLa_fq().i.contains(var6)) {
                        var19.add(var6);
                    }
                }

                for (var14 = 0; var14 < var19.size(); ++var14) {
                    ((mImage) beatdz.LangLa_fq.$state_LangLa_fq().e.remove(var19.get(var14))).a();
                }

                var19.clear();
                var2 = beatdz.LangLa_fq.$state_LangLa_fq().g.keySet().iterator();

                while (var2.hasNext()) {
                    var6 = (Short) var2.next();
                    if (!beatdz.LangLa_fq.$state_LangLa_fq().j.contains(var6)) {
                        var19.add(var6);
                    }
                }

                for (var14 = 0; var14 < var19.size(); ++var14) {
                    ((mImage) beatdz.LangLa_fq.$state_LangLa_fq().g.remove(var19.get(var14))).a();
                }

                LangLa_fq.e();
            } else {
                Binary2.a(beatdz.MainScreen.$state_MainScreen().cC);
                if (mConfig.gI().readBoolean(18)) {
                    if (beatdz.LangLa_fq.$state_LangLa_fq().f.size() > 0) {
                        LangLa_fq.e();
                    }
                } else {
                    Vector var5;
                    short var17;
                    Iterator var27;
                    if (beatdz.LangLa_fq.$state_LangLa_fq().e.size() > 600) {
                        var5 = new Vector();
                        var27 = beatdz.LangLa_fq.$state_LangLa_fq().e.keySet().iterator();

                        while (var27.hasNext()) {
                            var17 = (Short) var27.next();
                            if (!beatdz.LangLa_fq.$state_LangLa_fq().i.contains(var17)) {
                                var5.add(var17);
                            }
                        }

                        for (var30 = 0; var30 < var5.size(); ++var30) {
                            ((mImage) beatdz.LangLa_fq.$state_LangLa_fq().e.remove(var5.get(var30))).a();
                            if (beatdz.LangLa_fq.$state_LangLa_fq().e.size() <= 350) {
                                break;
                            }
                        }
                    }

                    if (beatdz.LangLa_fq.$state_LangLa_fq().g.size() > 750) {
                        var5 = new Vector();
                        var27 = beatdz.LangLa_fq.$state_LangLa_fq().g.keySet().iterator();

                        while (var27.hasNext()) {
                            var17 = (Short) var27.next();
                            if (!beatdz.LangLa_fq.$state_LangLa_fq().j.contains(var17)) {
                                var5.add(var17);
                            }
                        }

                        for (var30 = 0; var30 < var5.size(); ++var30) {
                            ((mImage) beatdz.LangLa_fq.$state_LangLa_fq().g.remove(var5.get(var30))).a();
                            if (beatdz.LangLa_fq.$state_LangLa_fq().g.size() <= 350) {
                                break;
                            }
                        }
                    }
                }
            }

            if (!var3.dx) {
                beatdz.SettingsTab.$state_SettingsTab().n = true;
                var3.dx = true;

                Binary.disposeImage(AppListener.d);
                Binary.disposeImage(AppListener.e);
            }

            if (beatdz.GameSrc.$state_GameSrc().bk != null && beatdz.GameSrc.$state_GameSrc().bk.size() > 0) {
                beatdz.GameSrc.$state_GameSrc().bk.size();
                Binary2.a(beatdz.GameSrc.$state_GameSrc().bk);
            }

            int var18;
            short var25;
            if (beatdz.GameSrc.$state_GameSrc().bj) {
                for (var14 = 0; var14 < DataCenter.gI().ag.size(); ++var14) {
                    short var15 = (Short) DataCenter.gI().ag.elementAt(var14);
                    if (beatdz.LangLa_fq.$state_LangLa_fq().g.get(var15) != null) {
                        Binary.cleanImage((mImage) beatdz.LangLa_fq.$state_LangLa_fq().g.remove(var15));
                    }
                }

                Iterator var16 = beatdz.LangLa_fq.$state_LangLa_fq().f.keySet().iterator();

                while (var16.hasNext()) {
                    var25 = (Short) var16.next();
                    Binary.disposeImage((mImage) beatdz.LangLa_fq.$state_LangLa_fq().f.get(var25));
                }

                for (var18 = 0; var18 < this.d.size(); ++var18) {
                    LangLa_lo var21;
                    if ((var21 = (LangLa_lo) this.d.get(var18)).o().idEff > 0) {
                        try {
                            Binary.cleanImage((mImage) beatdz.LangLa_fq.$state_LangLa_fq().f.remove(var21.k));
                        } catch (Exception var11) {
                        }
                    }
                }

                beatdz.GameSrc.$state_GameSrc().bj = false;
            }

            this.a(var1, 0, 0);
            if (this.V != null) {
                this.V.a(var1);
                if (Utlis.time() - this.s >= 3000L) {
                    this.s = Utlis.time();
                    (new Message((byte) -38)).send();
                    this.s = Utlis.time();
                }

            } else {
                if (this.i()) {
                    this.V = null;
                } else if (beatdz.GameSrc.$state_GameSrc().an) {
                    beatdz.GameSrc.$state_GameSrc().ao = false;
                    if (beatdz.GameSrc.$state_GameSrc().bR != null) {
                        var1.a(beatdz.GameSrc.$state_GameSrc().bR, 0, 0, beatdz.GameSrc.$state_GameSrc().bR.c, beatdz.GameSrc.$state_GameSrc().bR.d, 0, DataCenter.gI().widthScreen / 2, DataCenter.gI().heightScreen / 2, Graphics.e(), Graphics.f(), 3);
                    }

                    return;
                }

                if (!beatdz.GameSrc.$state_GameSrc().ao) {
                    beatdz.GameSrc.$state_GameSrc().ao = true;
                    this.r();
                }

                this.a(var1, -DataCenter.gI().j, -DataCenter.gI().k);
                if (Canvas.isMobile()) {
                    var1.motionX = -renderMotion.cameraOffsetX(AppListener.gI().canvas.renderAlpha);
                    var1.motionY = -renderMotion.cameraOffsetY(AppListener.gI().canvas.renderAlpha);
                }

                for (var14 = 0; var14 < this.K.size(); ++var14) {
                    Entity var20;
                    var20 = (Entity)this.K.elementAt(var14);
                    int savedX = var1.a, savedY = var1.b;
                    float savedMotionX = var1.motionX, savedMotionY = var1.motionY;
                    applyRenderMotion(var1, var20);
                    try {
                    if (var20 instanceof LangLa_hm) {
                        LangLa_hm var22 = (LangLa_hm) var20;
                        if (!Utlis.f()) {
                            var22.a(var1);
                        }
                    } else if (var20.g) {
                        var20.b(var1);
                    } else {
                        var20.a(var1);
                    }
                    } finally { var1.a = savedX; var1.b = savedY; var1.motionX = savedMotionX; var1.motionY = savedMotionY; }
                }
                for (var14 = 0; var14 < this.K.size(); ++var14) {
                    Entity entity = ((Entity) this.K.elementAt(var14));
                    int savedX = var1.a, savedY = var1.b;
                    float savedMotionX = var1.motionX, savedMotionY = var1.motionY;
                    applyRenderMotion(var1, entity);
                    try { entity.b(var1); } finally { var1.a = savedX; var1.b = savedY; var1.motionX = savedMotionX; var1.motionY = savedMotionY; }
//                    if (entity instanceof Char || entity instanceof Mob || entity instanceof Npc || entity instanceof ItemMap) {
//                        GameM.gI().canvas.graphics.shapeRenderer.setColor(1, 0, 0, 1); // Red line
//                        GameM.gI().canvas.graphics.shapeRenderer.line(
//                                (Char.gI().cx + var1.a) * DataCenter.gI().zoomLevel,
//                                (Char.gI().c() + (Char.gI().height / 2) + var1.b) * DataCenter.gI().zoomLevel,
//                                (((Entity) this.K.elementAt(var14)).cx + var1.a) * DataCenter.gI().zoomLevel,
//                                (((Entity) this.K.elementAt(var14)).c() + (((Entity) this.K.elementAt(var14)).height / 2) + var1.b) * DataCenter.gI().zoomLevel
//                        );
//                    }
                }

                LangLa_hy.a(var1);
                int var7;
                int var8;
                int var26;
                if (!this.bb && !DataCenter.gI().aH && this.cD.lastElement().equals(this) && beatdz.LangLa_cz.$state_LangLa_cz().cV.size() == 0) {
                    Binary.cleanImage(beatdz.GameSrc.$state_GameSrc().dB);
                    Pixmap var28;
                    (var28 = (beatdz.GameSrc.$state_GameSrc().dB = Binary.createImage(this.width * DataCenter.gI().zoomLevel, this.height * DataCenter.gI().zoomLevel)).b).setColor(new Color(0.0F, 0.0F, 0.0F, 0.0F));
                    var28.fill();
                    DataCenter.gI();
                    mImage var23 = LangLa_fq.a((int) 17);
                    Binary2.a(var28, var23.b, 0, 0, 44 * DataCenter.gI().zoomLevel, 44 * DataCenter.gI().zoomLevel, this.Z.cx * DataCenter.gI().zoomLevel, this.Z.cy * DataCenter.gI().zoomLevel, this.Z.width * DataCenter.gI().zoomLevel, this.Z.height * DataCenter.gI().zoomLevel, Blending.None);
                    var25 = this.aj.cx;
                    var30 = this.aj.cy - 3;
                    var28.setColor(Utlis.createColor(-1278446549L));
                    var28.setBlending(Blending.SourceOver);
                    var28.fillRectangle((var25 + 1) * DataCenter.gI().zoomLevel, (var30 + 1) * DataCenter.gI().zoomLevel, (this.aj.width - 2) * DataCenter.gI().zoomLevel, (this.aj.height + 6 - 2) * DataCenter.gI().zoomLevel);
                    var23 = LangLa_fq.a((int) 84);
                    Binary2.a(var28, var23.b, var25 * DataCenter.gI().zoomLevel, var30 * DataCenter.gI().zoomLevel, Blending.SourceOver);
                    mImage var24 = mImage.b(var23, 0, 0, var23.c, var23.d, -360);
                    Binary2.a(var28, var24.b, (var25 + this.aj.width - 6) * DataCenter.gI().zoomLevel, var30 * DataCenter.gI().zoomLevel, Blending.SourceOver);
                    var24.a();
                    var24 = mImage.b(var23, 0, 0, var23.c, var23.d, -180);
                    Binary2.a(var28, var24.b, var25 * DataCenter.gI().zoomLevel, (var30 + this.aj.height + 6 - 6) * DataCenter.gI().zoomLevel, Blending.SourceOver);
                    var24.a();
                    var24 = mImage.b(var23, 0, 0, var23.c, var23.d, -270);
                    Binary2.a(var28, var24.b, (var25 + this.aj.width - 6) * DataCenter.gI().zoomLevel, (var30 + this.aj.height + 6 - 6) * DataCenter.gI().zoomLevel, Blending.SourceOver);
                    var24.a();
                    var23 = LangLa_fq.a((int) 5);
                    Binary2.a(var28, var23.b, (var25 + 6) * DataCenter.gI().zoomLevel, var30 * DataCenter.gI().zoomLevel, (this.aj.width - 12) * DataCenter.gI().zoomLevel, 0, Blending.SourceOver);
                    var24 = mImage.b(var23, 0, 0, var23.c, var23.d, 180);
                    Binary2.a(var28, var24.b, (var25 + 6) * DataCenter.gI().zoomLevel, (var30 + this.aj.height + 6 - 20) * DataCenter.gI().zoomLevel, (this.aj.width - 12) * DataCenter.gI().zoomLevel, 0, Blending.SourceOver);
                    var24.a();
                    var24 = mImage.b(var23, 0, 0, var23.c, var23.d, 270);
                    Binary2.a(var28, var24.b, var25 * DataCenter.gI().zoomLevel, (var30 + 6) * DataCenter.gI().zoomLevel, 0, (this.aj.height + 6 - 12) * DataCenter.gI().zoomLevel, Blending.SourceOver);
                    var24.a();
                    var24 = mImage.b(var23, 0, 0, var23.c, var23.d, 90);
                    Binary2.a(var28, var24.b, (var25 + this.aj.width - 20) * DataCenter.gI().zoomLevel, (var30 + 6) * DataCenter.gI().zoomLevel, 0, (this.aj.height + 6 - 12) * DataCenter.gI().zoomLevel, Blending.SourceOver);
                    var24.a();
                    var23 = LangLa_fq.a((int) 73);
                    Binary2.a(var28, var23.b, this.du.cx * DataCenter.gI().zoomLevel, this.du.cy * DataCenter.gI().zoomLevel, Blending.SourceOver);
                    var26 = AppListener.gI().o;
                    DataCenter.gI();
                    var23 = LangLa_fq.a((int) 59);
                    Binary2.a(var28, var23.b, var26 * DataCenter.gI().zoomLevel, (this.ak.cy + 46) * DataCenter.gI().zoomLevel, Blending.SourceOver);
                    if (!mConfig.gI().readBoolean(12)) {
                        var23 = LangLa_fq.a((int) 20);
                        Binary2.a(var28, var23.b, 0, 0, 60 * DataCenter.gI().zoomLevel, 60 * DataCenter.gI().zoomLevel, this.X.cx * DataCenter.gI().zoomLevel, this.X.cy * DataCenter.gI().zoomLevel, this.X.width * DataCenter.gI().zoomLevel, this.X.height * DataCenter.gI().zoomLevel, Blending.None);
                    }

                    var23 = LangLa_fq.a((int) 554);
                    Binary2.a(var28, var23.b, 0, 0, 25 * DataCenter.gI().zoomLevel, 25 * DataCenter.gI().zoomLevel, this.ab.cx * DataCenter.gI().zoomLevel, this.ab.cy * DataCenter.gI().zoomLevel, this.ab.width * DataCenter.gI().zoomLevel, this.ab.height * DataCenter.gI().zoomLevel, Blending.None);
                    var23 = LangLa_fq.a((int) 554);
                    Binary2.a(var28, var23.b, 0, 0, 25 * DataCenter.gI().zoomLevel, 25 * DataCenter.gI().zoomLevel, this.ac.cx * DataCenter.gI().zoomLevel, this.ac.cy * DataCenter.gI().zoomLevel, this.ac.width * DataCenter.gI().zoomLevel, this.ac.height * DataCenter.gI().zoomLevel, Blending.None);
                    var23 = LangLa_fq.a((int) 554);
                    Binary2.a(var28, var23.b, 0, 0, 25 * DataCenter.gI().zoomLevel, 25 * DataCenter.gI().zoomLevel, this.ad.cx * DataCenter.gI().zoomLevel, this.ad.cy * DataCenter.gI().zoomLevel, this.ad.width * DataCenter.gI().zoomLevel, this.ad.height * DataCenter.gI().zoomLevel, Blending.None);
                    var23 = LangLa_fq.a((int) 554);
                    Binary2.a(var28, var23.b, 0, 0, 25 * DataCenter.gI().zoomLevel, 25 * DataCenter.gI().zoomLevel, this.ae.cx * DataCenter.gI().zoomLevel, this.ae.cy * DataCenter.gI().zoomLevel, this.ae.width * DataCenter.gI().zoomLevel, this.ae.height * DataCenter.gI().zoomLevel, Blending.None);
                    var23 = LangLa_fq.a((int) 554);
                    Binary2.a(var28, var23.b, 0, 0, 25 * DataCenter.gI().zoomLevel, 25 * DataCenter.gI().zoomLevel, this.af.cx * DataCenter.gI().zoomLevel, this.af.cy * DataCenter.gI().zoomLevel, this.af.width * DataCenter.gI().zoomLevel, this.af.height * DataCenter.gI().zoomLevel, Blending.None);
                    var23 = LangLa_fq.a((int) 553);
                    Binary2.a(var28, var23.b, (this.ae.cx + this.ae.width / 2 - 5) * DataCenter.gI().zoomLevel, (this.ae.cy + this.ae.height / 2 - 8) * DataCenter.gI().zoomLevel, Blending.SourceOver);
                    var23 = LangLa_fq.a((int) 751);
                    Binary2.a(var28, var23.b, (this.af.cx + this.af.width / 2 - 8) * DataCenter.gI().zoomLevel, (this.af.cy + this.af.height / 2 - 8) * DataCenter.gI().zoomLevel, Blending.SourceOver);
                    DataCenter.gI();
                    if (DataCenter.gI().widthScreen > 400) {
                        DataCenter.gI();
                    }

                    int var9;
                    for (var8 = 0; var8 < this.P.c.size(); ++var8) {
                        if (this.P.c.get(var8) instanceof LangLa_dz) {
                            LangLa_dz var29 = (LangLa_dz) this.P.c.get(var8);

                            for (var9 = 0; var9 < this.aE.size(); ++var9) {
                                if (((Skill) this.aE.get(var9)).getSkillTemplate().idIcon == var29.d) {
                                    var23 = LangLa_fq.b(var29.d);
                                    Binary2.a(var28, var23.b, var29.cx * DataCenter.gI().zoomLevel, var29.cy * DataCenter.gI().zoomLevel, Blending.None);
                                    var23.a();
                                }
                            }
                        }
                    }

                    var23 = LangLa_fq.a((int) 34);
                    Binary2.a(var28, var23.b, 0 * DataCenter.gI().zoomLevel, 0 * DataCenter.gI().zoomLevel, Blending.SourceOver);
                    var23 = LangLa_fq.a((int) DataCenter.gI().DataIconChar[Char.gI().idChar].idIcon);
                    Binary2.a(var28, var23.b, 3 * DataCenter.gI().zoomLevel, 7 * DataCenter.gI().zoomLevel, Blending.SourceOver);

                    for (var9 = 0; var9 < 10; ++var9) {
                        var26 = var9 * (this.width / 10);
                        if (var9 == 9) {
                            var7 = this.width - var26;
                        } else {
                            var7 = this.width / 10;
                        }

                        var30 = this.height - 4;
                        var28.setColor(Utlis.createColor(-16777216L));
                        var28.setBlending(Blending.SourceOver);
                        var28.fillRectangle((var26 + 1) * DataCenter.gI().zoomLevel, (var30 + 1) * DataCenter.gI().zoomLevel, (var7 - 2) * DataCenter.gI().zoomLevel, 2 * DataCenter.gI().zoomLevel);
                        var23 = LangLa_fq.a((int) 705);
                        Binary2.a(var28, var23.b, var26 * DataCenter.gI().zoomLevel, var30 * DataCenter.gI().zoomLevel, Blending.SourceOver);
                        var24 = mImage.b(var23, 0, 0, var23.c, var23.d, -360);
                        Binary2.a(var28, var24.b, (var26 + var7 - 2) * DataCenter.gI().zoomLevel, var30 * DataCenter.gI().zoomLevel, Blending.SourceOver);
                        var24.a();
                        var23 = LangLa_fq.a((int) 706);

                        for (var4 = 2; var4 < var7 - 2; ++var4) {
                            Binary2.a(var28, var23.b, (var26 + var4) * DataCenter.gI().zoomLevel, var30 * DataCenter.gI().zoomLevel, Blending.SourceOver);
                        }
                    }

                    // The former minimap frame is not part of the cached HUD anymore.
                    Binary.disposeImage(beatdz.GameSrc.$state_GameSrc().dB);
                    DataCenter.gI().aH = true;
                }

                if (this.cD.size() > 0 && this.cD.lastElement().equals(this) || this.cD.size() == 2 && this.cD.lastElement() instanceof LangLa_dl) {

                    var14 = var1.a;
                    var18 = var1.b;
                    var1.motionX = var1.motionY = 0f;
                    this.a(var1, 0, 0);
                    var1.setClip(0, 0, this.width, this.height);
                    var1.m = 1.0F;
                    if (!this.bb) {
                        var1.a(beatdz.GameSrc.$state_GameSrc().dB, 0, 0);
                        if (beatdz.LangLa_cz.$state_LangLa_cz().cZ) {
                            mFont.a(mFont.d, var1, Caption.qG, DataCenter.gI().widthScreen / 2, DataCenter.gI().heightScreen - 74, 2, -2560, 2, 1);
                        } else if (this.ca) {
                            mFont.a(mFont.d, var1, Caption.nC, DataCenter.gI().widthScreen / 2, DataCenter.gI().heightScreen - 74, 2, -32576, 4, 1);
                        } else if (Char.gI().w()) {
                            mFont.a(mFont.d, var1, Caption.L, DataCenter.gI().widthScreen / 2, DataCenter.gI().heightScreen - 74, 2, -2560, 4, 1);
                        } else if (SettingsTab.gI().autoTrain) {
                            mFont.a(mFont.d, var1, Caption.K, DataCenter.gI().widthScreen / 2, DataCenter.gI().heightScreen - 74, 2, -16711808, 4, 1);
                        }
                    }

                    long var31 = Char.gI().exp;

                    for (var30 = 0; var30 < DataCenter.gI().exps.length && var31 >= DataCenter.gI().exps[var30]; ++var30) {
                        var31 -= DataCenter.gI().exps[var30];
                    }

                    try {
                        var7 = (int) (var31 * 100L / DataCenter.gI().exps[var30]);

                        for (var30 = 0; var30 < 10; ++var30) {
                            var4 = var30 * (this.width / 10);
                            if (var30 == 9) {
                                var26 = this.width - var4;
                            } else {
                                var26 = this.width / 10;
                            }

                            if (var7 <= 0) {
                                break;
                            }

                            if (var7 >= 10) {
                                Binary2.a(var1, 707, 0, 1 + var4, this.height - 3, var26 - 2, (int) 2);
                            } else {
                                var8 = var7 * 10;
                                Binary2.a(var1, 707, 0, 1 + var4, this.height - 3, var8 * var26 / 100 - 2, (int) 2);
                            }

                            var7 -= 10;
                        }
                    } catch (Exception var12) {
                    }

                    if (!this.bb) {
                        this.e(var1);
                    }

                    if (this.ds != null) this.ds.b(beatdz.DataCenter.$state_DataCenter().ar);
                    if (this.dw != null) this.dw.b(Char.gI().rank < 0);
                    this.a(var1, var14, var18);
                    if (!this.bb) {
                        this.paintHudGroup(var1, this.O);
                        this.paintHudGroup(var1, this.Q);
                        this.paintHudGroup(var1, this.S);
                        this.paintHudGroup(var1, this.P);
                        this.paintHudGroup(var1, this.R);
                        this.paintHudGroup(var1, this.T);
                        this.paintHudGroup(var1, this.U);
                    }
                    if (AutoPro.isAuto(4) || AutoPro.isAuto(5) || AutoPro.isAuto(6)) {
                    Vector K = new Vector();
                    K.addAll(vMob);
                    K.addAll(vChar);
                    K.addAll(vNpc);
                    K.addAll(vItemMap);
                    //  K.addAll(vWayPoint);
                    for (var14 = 0; var14 < K.size(); ++var14) {
                        Entity entity = ((Entity) K.elementAt(var14));
                        if (entity instanceof Mob) {
//                            if (!AutoPro.isAuto(3)) {
                            continue;
                            //  }
                            //  GameM.gI().canvas.graphics.shapeRenderer.setColor(Color.YELLOW); // Red line
                        } else if (entity instanceof Char) {
                            if (!AutoPro.isAuto(4)) {
                                continue;
                            }
                            GameM.gI().canvas.graphics.shapeRenderer.setColor(Color.BLUE); // Red line
                        } else if (entity instanceof Npc) {
                            if (!AutoPro.isAuto(6)) {
                                continue;
                            }
                            GameM.gI().canvas.graphics.shapeRenderer.setColor(Color.RED); // Red line
                        } else if (entity instanceof ItemMap) {
                            if (!AutoPro.isAuto(5)) {
                                continue;
                            }
                            GameM.gI().canvas.graphics.shapeRenderer.setColor(Color.BLACK); // Red line
                        } else if (entity instanceof WayPoint) {
                            GameM.gI().canvas.graphics.shapeRenderer.setColor(Color.WHITE); // Red line
                        }
                        if (!entity.j()) {
                            GameM.gI().canvas.graphics.shapeRenderer.line(
                                    (Char.gI().cx + var1.a) * DataCenter.gI().zoomLevel,
                                    (Char.gI().c() + (Char.gI().height / 2) + var1.b) * DataCenter.gI().zoomLevel,
                                    (entity.cx + var1.a) * DataCenter.gI().zoomLevel,
                                    (entity.c() + (entity.height / 2) + var1.b) * DataCenter.gI().zoomLevel
                            );
                        }
                    }
                    }

                }

            }

        } catch (Exception var13) {
            Utlis.println(var13);
        } finally {
            var1.motionX = var1.motionY = 0f;
        }
    }

    private long lastHudErrorLog;

    private void paintHudGroup(Graphics graphics, LangLa_cj group) {
        // T contains the minimap, position markers, coordinates and its collapse control.
        // The location name is painted independently by the main HUD (Q).
        if (group == this.T) return;
        graphics.clean();
        graphics.setClip(0, 0, this.width, this.height);
        graphics.m = 1.0F;
        try {
            if (group != null) group.a(graphics);
        } catch (Exception error) {
            long now = System.currentTimeMillis();
            if (now - this.lastHudErrorLog >= 5000L) {
                this.lastHudErrorLog = now;
                Utlis.println(error, "Unable to draw HUD group");
            }
        } finally {
            graphics.clean();
            graphics.setClip(0, 0, this.width, this.height);
            graphics.m = 1.0F;
        }
    }

    private void e(Graphics var1) {
        try {
            long var2 = Char.gI().exp;

            int var4;
            for (var4 = 0; var4 < DataCenter.gI().exps.length && var2 >= DataCenter.gI().exps[var4]; ++var4) {
                var2 -= DataCenter.gI().exps[var4];
            }

            float var6 = (float) var2 * 100.0F / (float) DataCenter.gI().exps[var4];
            DataCenter.gI();
            mFont.a((mFont) mFont.d, (Graphics) var1, Caption.ef + var4 + " + " + String.format("%.2f", var6) + "%", 5, this.height - 12, 0, -2560, -10275328);
            mFont.a((mFont) mFont.d, (Graphics) var1, Caption.eg + Utlis.numberFormat(var2) + "/" + Utlis.numberFormat(DataCenter.gI().exps[var4]), this.width - 12, this.height - 12, 1, -2560, -10275328);
        } catch (Exception var5) {
            Utlis.println(var5);
        }
    }

    public Vector c() {
        Vector var1 = new Vector();

        try {
            var1.addElement(new LangLa_jz(1001, 0, 0, 40, 40, (LangLa_ii) null, this));
            var1.addElement(new LangLa_jz(1001, 40, 0, 110, 34, (LangLa_ii) null, this));
            // Keep the original map menu on the title only, without the old minimap hit area.
            var1.addElement(new LangLa_jz(9002, this.width - 86, 0, this.width, 16, (LangLa_ii)null, this));

            if (this.aA != null && !(this.aA instanceof ItemMap) && (!(this.aA instanceof Mob) || ((Mob) this.aA).getMobTemplate().type != 10)) {
                var1.addElement(new LangLa_jz(1002, 130, 10, 159, 37, (LangLa_ii) null, this));
                var1.addElement(new LangLa_jz(1002, 159, 11, 218, 35, (LangLa_ii) null, this));
            }

            for (int var3 = 0; var3 < Char.gI().vEffect.size(); ++var3) {
                Effect var2 = (Effect) Char.gI().vEffect.elementAt(var3);
                var1.addElement(new LangLa_jz(6000 + var3, var2.cx - 2, var2.cy - 2, var2.cx + 15, var2.cy + 15, (LangLa_ii) null, this));
            }

            if (this.dv != null && !this.dv.v) {
                var1.addElement(new LangLa_jz(9003, this.dv.cx, this.dv.cy, this.dv.cx + this.dv.width, this.dv.cy + this.dv.height, (LangLa_ii) null, this));
            }

            var1.addElement(new LangLa_jz(9000, 0, 0, DataCenter.gI().widthScreen, DataCenter.gI().heightScreen, (LangLa_ii) null, this));
        } catch (Exception var4) {
        }

        return var1;
    }

    public void a(int var1, int var2) {
        if (!this.bN) {
            if (var1 >= DataCenter.gI().widthScreen - 200) {
                this.bQ = 2;
                this.bN = true;
                Char.gI().pointMove = new PointMove((short) (gI().maxX + 20), Char.gI().cy, Char.gI().speedMove);
            } else if (var1 <= 200) {
                this.bQ = 3;
                this.bN = true;
                Char.gI().pointMove = new PointMove((short) -20, Char.gI().cy, Char.gI().speedMove);
            } else {
                Char.gI().K();
                this.X();
            }
        }
    }

    public void a(LangLa_jz var1, int var2, int var3) {
        if (this.i() && !this.bN) {
            this.Q.a(false);
            this.I.add(new LangLa_jw(146, var2 + DataCenter.gI().j, var3 + DataCenter.gI().k, 1));
            boolean var11;
            Char var18;
            boolean var19;
            int var10003;
            WayPoint var20;
            if (var1.b >= 2000 && var1.b < 6000) {
                try {
                    Message var22;
                    switch (var1.b) {
                        case 2100:
                            this.ak.a();
                            return;
                        case 2101:
                            this.l(Caption.iv).cG.clear();
                            beatdz.CheckVersionScreen.$state_CheckVersionScreen().b = true;
                            AppListener.$state_AppListener().h = 50;
                            return;
                        case 2102:
                            return;
                        case 2985:
                            (var22 = Message.c((byte) -100)).writeUTF(beatdz.GameSrc.$state_GameSrc().aJ);
                            var22.send();
                            return;
                        case 2986:
                            (var22 = Message.c((byte) -102)).writeUTF(beatdz.GameSrc.$state_GameSrc().aJ);
                            var22.send();
                            return;
                        case 2987:
                            (var22 = Message.c((byte) -101)).writeUTF(beatdz.GameSrc.$state_GameSrc().aJ);
                            var22.send();
                            return;
                        case 2988:
                            (var22 = Message.c((byte) -103)).writeUTF(beatdz.GameSrc.$state_GameSrc().aJ);
                            var22.send();
                            return;
                        case 2989:
                            (var22 = new Message((byte) -90)).writeUTF(beatdz.GameSrc.$state_GameSrc().aJ);
                            var22.send();
                            return;
                        case 2990:
                            (var22 = new Message((byte) -91)).writeUTF(beatdz.GameSrc.$state_GameSrc().aJ);
                            var22.send();
                            return;
                        case 2991:
                            AppListener.gI();
                            AppListener.exit();
                            return;
                        case 2992:
                            (var22 = new Message((byte) 30)).writeUTF(beatdz.GameSrc.$state_GameSrc().aJ);
                            var22.send();
                            return;
                        case 2993:
                            (var22 = new Message((byte) 31)).writeUTF(beatdz.GameSrc.$state_GameSrc().aJ);
                            var22.send();
                            return;
                        case 2994:
                            (var22 = new Message((byte) 40)).writeUTF(beatdz.GameSrc.$state_GameSrc().aJ);
                            var22.send();
                            return;
                        case 2995:
                            (var22 = new Message((byte) 41)).writeUTF(beatdz.GameSrc.$state_GameSrc().aJ);
                            var22.send();
                            return;
                        case 2996:
                            (var22 = new Message((byte) 38)).writeUTF(beatdz.GameSrc.$state_GameSrc().aJ);
                            var22.send();
                            return;
                        case 2997:
                            (var22 = new Message((byte) 39)).writeUTF(beatdz.GameSrc.$state_GameSrc().aJ);
                            var22.send();
                            return;
                        case 2998:
                            (new Message((byte) 85)).send();
                            return;
                        case 2999:
                            (new Message((byte) 84)).send();
                            return;
                        default:
                            if (this.ae()) {
                                return;
                            }

                            if (var1.k != null) {
                                this.aA = (Entity) var1.k;
                                if (var1.k instanceof Char) {
                                    if (this.mapID != 41) {
                                        this.aH = null;
                                        var19 = true;
                                        this.ap = var19;
                                        this.aq = true;
                                        this.g(false);
                                        return;
                                    }

                                    if ((var18 = (Char) var1.k).status == 4 || var18.status == 6 || this.aI.b(var18.name)) {
                                        this.aA = null;
                                        return;
                                    }

                                    this.aH = null;
                                    var19 = true;
                                    this.ap = var19;
                                    this.aq = true;
                                    this.g(false);
                                } else {
                                    if (var1.k instanceof Npc) {
                                        SettingsTab.gI().a(false);
                                        var19 = true;
                                        this.ap = var19;
                                        this.aq = true;
                                        this.g(false);
                                        return;
                                    }

                                    if (var1.k instanceof Mob && ((Mob) var1.k).x()) {
                                        if (SettingsTab.gI().autoTrain && ((Mob) this.aA).q()) {
                                            this.aA = null;
                                            this.aH = null;
                                            return;
                                        }

                                        this.aH = null;
                                        var19 = true;
                                        this.ap = var19;
                                        this.aq = true;
                                        this.g(false);
                                        return;
                                    }

                                    if (var1.k instanceof ItemMap) {
                                        SettingsTab.gI().a(false);
                                        var19 = true;
                                        this.ap = var19;
                                        this.aq = true;
                                        this.g(false);
                                        return;
                                    }

                                    if (var1.k instanceof WayPoint && !this.isTimeHoatDong && Char.gI().status == 0) {
                                        if (Utlis.getRange((var20 = (WayPoint) var1.k).p, var20.q, Char.gI().cx, Char.gI().cy) > 80 && Utlis.getRange(var20.cx, var20.cy, Char.gI().cx, Char.gI().cy) > 80) {
                                            this.k(var20.cx, var20.cy);
                                            return;
                                        }

                                        this.a(var2, var3);
                                        return;
                                    }
                                }
                            }

                            return;
                    }
                } catch (Exception var6) {
                    Utlis.println(var6);
                }
            } else if (var1.b >= 6000 && var1.b < 7000) {
                int var7 = var1.b - 6000;
                Effect var4 = (Effect) Char.gI().vEffect.elementAt(var7);
                LangLa_dp.a().h();
                var10003 = var4.cy + 20;
                var11 = true;
                var3 = var10003;
                short var9 = var4.cx;
                LangLa_mn var13;
                if ((var13 = new LangLa_mn(var9, var3, this, var4)).cx > DataCenter.gI().widthScreen - var13.width - super.cx) {
                    var13.cx = (short) (DataCenter.gI().widthScreen - var13.width - super.cx);
                }

                if (var13.cx < var9 - 100) {
                    var13.cx = (short) (var9 - (var13.width + 200 + 3));
                }

                if (var13.cx < -super.cx) {
                    var13.cx = (short) (-super.cx);
                }

                if (var13.cy > DataCenter.gI().heightScreen - var13.height - super.cy) {
                    var13.cy = (short) (DataCenter.gI().heightScreen - var13.height - super.cy);
                }

                this.a(var13);
                this.cL = var13;
                return;
            }

            label231:
            switch (var1.b) {
                case 1000:
                default:
                    break;
                case 1001:
                    (new Message((byte) -95)).send();
                    this.a((LangLa_cx) (new LangLa_kl(this, Char.gI(), gI().p)));
                    LangLa_dp.a().i();
                    break;
                case 1002:
                    this.aR = null;
                    if (this.aA != null) {
                        LangLa_dp.a().i();
                        if (this.aA instanceof Npc) {
                            this.a((Skill) null, false);
                        } else if (this.aA instanceof Char) {
                            this.b((Char) this.aA);
                        } else if (this.aA instanceof Mob) {
                            Mob var23 = (Mob) this.aA;
                            var11 = true;
                            boolean var12 = true;
                            boolean var10 = true;
                            LangLa_lc var21;
                            if ((var21 = new LangLa_lc(122, 45, this, var23)).cx > DataCenter.gI().widthScreen - var21.width - super.cx) {
                                var21.cx = (short) (DataCenter.gI().widthScreen - var21.width - super.cx);
                            }

                            if (var21.cx < 22) {
                                var21.cx = (short) (122 - (var21.width + 200 + 3));
                            }

                            if (var21.cx < -super.cx) {
                                var21.cx = (short) (-super.cx);
                            }

                            if (var21.cy > DataCenter.gI().heightScreen - var21.height - super.cy) {
                                var21.cy = (short) (DataCenter.gI().heightScreen - var21.height - super.cy);
                            }

                            this.a(var21);
                            this.cL = var21;
                        }
                    }
                    break;
                case 9000:
                    if (Gdx.app.getType() == ApplicationType.Desktop && !this.ah.v && this.ah.cx != -200 && this.ah.cy != -200) {
                        this.ah.setXY(-200, -200);
                        this.ah.b(true);
                    } else {
                        int var15 = var2 + DataCenter.gI().j;
                        int var16 = var3 + DataCenter.gI().k;
                        var3 = var16;
                        var2 = var15;
                        GameSrc var8 = this;

                        for (var15 = this.K.size() - 1; var15 >= 0; --var15) {
                            Entity var17;
                            if (!(var17 = (Entity) var8.K.elementAt(var15)).j() && (var17 instanceof Char && (Char) var17 != Char.gI() || var17 instanceof Npc || var17 instanceof Mob || var17 instanceof ItemMap || var17 instanceof WayPoint) && Utlis.inRange(var17.a(), var17.c(), var17.b(), var17.d(), var2, var3)) {
                                var8.aA = var17;
                                if (var17 instanceof Char) {
                                    if (var8.mapID == 41) {
                                        if ((var18 = (Char) var17).status != 4 && var18.status != 6 && !var8.aI.b(var18.name)) {
                                            var8.aH = null;
                                            var19 = true;
                                            var8.ap = var19;
                                            var8.aq = true;
                                            var8.g(false);
                                        } else {
                                            var8.aA = null;
                                        }
                                    } else {
                                        var8.aH = null;
                                        var19 = true;
                                        var8.ap = var19;
                                        var8.aq = true;
                                        var8.g(false);
                                    }
                                } else if (var17 instanceof Npc) {
                                    SettingsTab.gI().a(false);
                                    var19 = true;
                                    var8.ap = var19;
                                    var8.aq = true;
                                    var8.g(false);
                                } else if (var17 instanceof Mob && ((Mob) var17).x()) {
                                    if (SettingsTab.gI().autoTrain && ((Mob) var8.aA).q()) {
                                        var8.aA = null;
                                        var8.aH = null;
                                    } else {
                                        var8.aH = null;
                                        var19 = true;
                                        var8.ap = var19;
                                        var8.aq = true;
                                        var8.g(false);
                                    }
                                } else if (var17 instanceof ItemMap) {
                                    SettingsTab.gI().a(false);
                                    var19 = true;
                                    var8.ap = var19;
                                    var8.aq = true;
                                    var8.g(false);
                                } else if (var17 instanceof WayPoint && !var8.isTimeHoatDong && Char.gI().status == 0) {
                                    if (Utlis.getRange((var20 = (WayPoint) var17).p, var20.q, Char.gI().cx, Char.gI().cy) > 80 && Utlis.getRange(var20.cx, var20.cy, Char.gI().cx, Char.gI().cy) > 80) {
                                        var8.k(var20.cx, var20.cy);
                                    } else {
                                        var8.a(var2, var3);
                                    }
                                }
                                break label231;
                            }
                        }

                        var8.k(var2, var3);
                        var8.b((LangLa_cs) var8.ah);
                    }
                    break;
                case 9001:
                    LangLa_dp.a().i();
                    var10003 = this.T.height + 32;
                    var11 = true;
                    var3 = var10003;
                    LangLa_mp var14 = new LangLa_mp(var2, var3, this);
                    this.a(var14);
                    this.cL = var14;
                    break;
                case 9002:
                    this.a((LangLa_cx) (new LangLa_u(this)));
                    break;
                case 9003:
                    LangLa_dp.a().h();
                    openFunc(89);
            }

            this.cO.b();
        }
    }

    private void k(int var1, int var2) {
        DataCenter.gI();
        this.X.d();
        SettingsTab.E();
        this.aq = false;
        this.aR = null;
        DataCenter.gI();
        XYEntity var3;
        if ((var3 = gI().h.c(var1, var2)) != null && Utlis.positive(var2 - var3.cy) > 1 && Utlis.positive(var2 - var3.cy) < 50) {
            var2 = var3.cy;
        }

        Char.gI().b(var1, var2);
        SettingsTab.gI().a(false);
        this.bG = Char.gI().cx;
        this.bH = Char.gI().cy;
        this.bF = Utlis.time();
        this.bl = 1000;
        this.cc = false;
        if (this.cl.c && this.aA != null && this.aA instanceof Mob) {
            this.aA = null;
        }

    }

    public void a(int var1, Object var2, LangLa_cy var3) {
        if (this.i() && !this.bN) {
            if (var1 != 7000) {
                this.Q.a(false);
            }

            if (var1 >= 1021 && var1 < 1029) {
                this.aR = null;
                var1 -= 1021;
                this.q(var1);
            } else {
                String[] var6;
                short[] var7;
                label204:
                switch (var1) {
                    case 1000:
                    case 1001:
                    case 1002:
                    case 1003:
                    case 1004:
                    case 1010:
                    case 1025:
                    case 1026:
                    case 1041:
                    case 1049:
                    default:
                        break;
                    case 1012:
                        if (beatdz.DataCenter.$state_DataCenter().ar) {
                            var7 = new short[]{7, 9, 10, 12, 13, 6};
                        } else {
                            var7 = new short[]{7, 9, 10, 11, 12, 13, 6};
                        }

                        var6 = new String[var7.length];

                        for (int var15 = 0; var15 < var6.length; ++var15) {
                            var6[var15] = Caption.sC[var7[var15]];
                        }

                        this.a((LangLa_cx) (new LangLa_x(this, new LangLa_kd(0, var7, var6), 1)));
                        break;
                    case 1020:
                        if (beatdz.SettingsTab.$state_SettingsTab().i) {
                            beatdz.SettingsTab.$state_SettingsTab().i = false;
                        } else {
                            SettingsTab.gI().a(false);
                        }

                        this.a(Char.gI().ay, false);
                        break;
                    case 1030:
                        boolean var16 = this.U.e;
                        mConfig.gI().writeBoolean(5, this.U.e);
                        break;
                    case 1031:
                        this.a((LangLa_cx) (new LangLa_u(this)));
                        break;
                    case 1032:
                        this.a((LangLa_cx) (new LangLa_t(this)));
                        break;
                    case 1033:
                        openFunc(88);
                        break;
                    case 1034:
                        openFunc(6);
                        break;
                    case 1035:
                        this.a((LangLa_cx) (new LangLa_v(this)));
                        break;
                    case 1036:
                        switch (this.getMapTemplate().type) {
                            case 6:
                                this.a((LangLa_cx) (new LangLa_ab(this)));
                                break label204;
                            case 10:
                            case 16:
                                this.a((LangLa_cx) (new LangLa_ai(this)));
                                break label204;
                            case 18:
                                this.a((LangLa_cx) (new LangLa_z(this)));
                                break label204;
                            default:
                                this.a((LangLa_cx) (new LangLa_ah(this)));
                                break label204;
                        }
                    case 1037:
                        String var9 = Caption.np;
                        String[] var14 = Caption.sJ;
                        this.a((LangLa_cx) (new LangLa_bk(this, var9, var14, new int[]{1, 207, 0, 2, 201, 206})));
                        break;
                    case 1040:
                        if (this.T.c()) {
                            mConfig.gI().writeBoolean(3, false);
                            this.T.a(this.width - 16, 0, false);
                            this.T.e();
                            LangLa_dz var10000 = (LangLa_dz) this.T.a();
                            byte var13 = 90;
                            var10000.e = var13;
                        } else {
                            this.U();
                        }
                        break;
                    case 1042:
                        this.a(this.ah);
                        break;
                    case 1043:
                        this.cL = new LangLa_ac(var3.cx - 44, var3.cy - 88, 1044, this);
                        this.a((LangLa_cs) this.cL);
                        break;
                    case 1044:
                        this.ah.c(var2.toString());
                        this.c((LangLa_cs) this.ah);
                        break;
                    case 1045:
                        this.a((LangLa_cx) (new LangLa_km(1046, this)));
                        break;
                    case 1046:
                        Utlis.println("1046");
                        break;
                    case 1047:
                        this.c((LangLa_cs) this.ah);
                        break;
                    case 1048:
                        Utlis.println("1048");
                        break;
                    case 1050:
                        if (this.W == 0) {
                            this.o(1);
                        } else if (this.W == 1) {
                            this.o(2);
                        } else if (this.W == 2) {
                            this.o(0);
                            this.ak.d();
                        }

                        this.T.k = true;
                        mConfig.gI().writeByte(4, this.W);
                        break;
                    case 1060:
                        this.ac();
                        break;
                    case 1061:
                        this.a((LangLa_cx) (new LangLa_kl(this, Char.gI(), gI().p)));
                        break;
                    case 1062:
                        this.a((LangLa_cx) (new LangLa_p(this, 0)));
                        break;
                    case 1063:
                        openFunc(56);
                        break;
                    case 1064:
                        if (this.getMapTemplate().type == 6) {
                            this.a((LangLa_cx) (new LangLa_ab(this)));
                        } else {
                            this.a((LangLa_cx) (new LangLa_ah(this)));
                        }
                        break;
                    case 1065:
                        this.a((LangLa_cx) (new LangLa_ca(this)));
                        break;
                    case 1067:
                        gI();
                        openFunc(86);
                        break;
                    case 1068:
                        this.af();
                        break;
                    case 1069:
                        openFunc(54);
                        break;
                    case 1070:
                        Char.gI().idChar = Byte.valueOf(var2.toString());
                        break;
                    case 1080:
                        this.c(true);
                        break;
                    case 1081:
                        this.f(true);
                        break;
                    case 1082:
                        this.Y();
                        break;
                    case 1083:
                        if (mConfig.gI().readByte(9) == 0) {
                            this.ah.a("");
                            this.ah.b(false);
                            this.ah.setXY(DataCenter.gI().widthScreen / 2 - this.ah.width / 2, DataCenter.gI().heightScreen - 122);
                        } else if (mConfig.gI().readByte(9) == 2) {
                            this.ah.a("");
                            this.ah.b(false);
                            this.ah.setXY(DataCenter.gI().widthScreen / 2 - this.ah.width / 2, DataCenter.gI().heightScreen - 85);
                            boolean var12 = true;
                            this.ah.t = var12;
                            this.a((LangLa_cs) this.ah);
                        }

                        Binary2.a(this.ah, this.ah.f(), Caption.gm, this.ah.a, this.ah.b, false);
                        break;
                    case 1084:
                        if (Char.gI().w() && gI().bE) {
                            d(gI().aR);
                        } else {
                            Item var8;
                            if ((var8 = Char.gI().d(this.bz)) != null) {
                                a(var8);
                            }
                        }
                        break;
                    case 1085:
                        SettingsTab.gI().a(!SettingsTab.gI().autoTrain);
                        break;
                    case 1086:
                        this.a((LangLa_cx) (new LangLa_u(this)));
                        break;
                    case 1087:
                        gI();
                        openFunc(54);
                        break;
                    case 1088:
                        SettingsTab var11;
                        (var11 = SettingsTab.gI()).A();
                        var11.e();
                        var11.cS = 0;
                        var11.k = 0;
                        var11.a(var11.width, var11.height);
                        gI().a((LangLa_cx) var11);
                        gI().vItemMapPickUp.clear();
                        break;
                    case 1089:
                        gI().a((LangLa_cx) (new LangLa_ca(gI())));
                        break;
                    case 1090:
                        i(14);
                        break;
                    case 1100:
                        this.k(!this.U.c());
                        break;
                    case 1101:
                        this.dD.b(false);
                        this.j(!this.S.c());
                        DataCenter.gI().aH = false;
                        break;
                    case 1102:
                        Vector var10 = new Vector();
                        DataCenter.gI();
                        if (this.Task < DataCenter.gI().Task.length) {
                            var10.addElement(new LangLa_lk(3000, "c#cyan" + Caption.iI + "c#white" + DataCenter.gI().Task[this.Task].name));
                        } else {
                            var10.addElement(new LangLa_lk(3000, "c#cyan" + Caption.iI + "c#white" + Caption.iK));
                        }

                        if (Char.gI().I > 0) {
                            var10.addElement(new LangLa_lk(3001, "c#yellow" + Caption.ll + "c#white" + Caption.iN + (10 - Char.gI().I) + "/10"));
                        }

                        if (Char.gI().J > 0) {
                            var10.addElement(new LangLa_lk(3002, "c#yellow" + Caption.ll + "c#white" + Caption.iQ + (Char.gI().K - Char.gI().J) + "/" + Char.gI().K));
                        }

                        if (Char.gI().level() >= 20 && Char.gI().idClass > 0 && (gI().aX == null || !gI().aX.c)) {
                            var10.addElement(new LangLa_lk(3003, "c#yellow" + Caption.ll + "c#white" + Caption.lT));
                        }

                        var1 = 0;
                        if (this.aI != null) {
                            var1 = this.aI.a.size();
                        }

                        var10.addElement(new LangLa_lk(3010, Utlis.replaceAll(Caption.qj, Utlis.numberFormat(var1))));
                        var6 = new String[var10.size()];
                        var7 = new short[var10.size()];

                        for (int var4 = 0; var4 < var10.size(); ++var4) {
                            LangLa_lk var5 = (LangLa_lk) var10.elementAt(var4);
                            var6[var4] = var5.b;
                            var7[var4] = (short) var5.a;
                        }

                        this.cL = a(this, this.dD.cx + 16, this.dD.cy, new LangLa_kd(0, var7, var6));
                        break;
                    case 1103:
                        DataCenter.gI().currentScreen.a(Caption.qz, Caption.bz, 2101, 2102, this);
                        break;
                    case 3000:
                        this.p(0);
                        break;
                    case 3001:
                        beatdz.LangLa_mg.$state_LangLa_mg().d = 0;
                        this.p(1);
                        break;
                    case 3002:
                        beatdz.LangLa_mg.$state_LangLa_mg().d = 1;
                        this.p(1);
                        break;
                    case 3003:
                        beatdz.LangLa_mg.$state_LangLa_mg().d = 2;
                        this.p(1);
                        break;
                    case 3006:
                        gI();
                        openFunc(72);
                        break;
                    case 3010:
                        this.p(2);
                        break;
                    case 6004:
                        e(beatdz.LangLa_kw.$state_LangLa_kw().e.b);
                        break;
                    case 6005:
                        d(beatdz.LangLa_kw.$state_LangLa_kw().e.b);
                        break;
                    case 6006:
                        beatdz.LangLa_kw.$state_LangLa_kw().d = beatdz.LangLa_kw.$state_LangLa_kw().e.b;
                        this.a((String) beatdz.LangLa_kw.$state_LangLa_kw().e.b, (LangLa_ko) (new LangLa_kq(gI(), 6)));
                        break;
                    case 6007:
                        h(beatdz.LangLa_kw.$state_LangLa_kw().e.b);
                        break;
                    case 6008:
                        c(beatdz.LangLa_kw.$state_LangLa_kw().e.b);
                        break;
                    case 6009:
                        openFunc(89);
                        break;
                    case 7000:
                        this.Q.a(!this.Q.c());
                        break;
                    case 7001:
                        u(0);
                        break;
                    case 7002:
                        u(2);
                        break;
                    case 7003:
                        u(3);
                        break;
                    case 9997:
                        LangLa_i gift = new LangLa_i(GameSrc.gI());
                        this.a(gift);
                        break;
                    case 9998:
                        openFunc(54);
                        break;
                    case 7004:
                        this.ac();

                }

                this.cO.b();
            }
        }
    }

    public void q() {
        for (int var2 = 0; var2 < 25; ++var2) {
            Mob var1;
            (var1 = new Mob()).id = 290;
            var1.hp = 1;
            var1.aa = true;
            var1.W = 100;
            var1.dir = (byte) Utlis.nextInt((int) 4);
            var1.status = 2;
            var1.b(Utlis.nextInt(Char.gI().cx - 100, Char.gI().cx + 100), Utlis.nextInt(Char.gI().cy - 100, Char.gI().cy + 100));
            var1.r = (short) (var1.cx + var1.getMobTemplate().speedMove - Utlis.nextInt(var1.getMobTemplate().speedMove * 2));
            var1.s = (short) (var1.cy + var1.getMobTemplate().speedMove - Utlis.nextInt(var1.getMobTemplate().speedMove * 2));
            var1.speedMove = var1.getMobTemplate().speedMoveByte;
            this.dH.add(var1);
        }

    }

    private void p(int var1) {
        try {
            if (this.ak != null && this.dE != null) {
                this.cw = var1;
                mConfig.gI().writeByte(13, var1);
                this.S.a((LangLa_cs) this.ak);
                this.b((LangLa_cs) this.ak);
                this.S.a((LangLa_cs) this.dE);
                this.b((LangLa_cs) this.dE);
                switch (var1) {
                    case 0:
                    case 1:
                        this.a((LangLa_cs) this.ak);
                        this.S.b((LangLa_cs) this.ak);
                        break;
                    case 2:
                        this.a((LangLa_cs) this.dE);
                        this.S.b((LangLa_cs) this.dE);
                }

                this.ak.d();
                DataCenter.gI().aH = false;
            }

        } catch (Exception var2) {
        }
    }

    private void ac() {
        this.a((LangLa_cx) (new LangLa_jf(this)));
    }

    private void q(int var1) {
        Skill var2;
        if (!(var2 = (Skill) gI().aE.elementAt(var1)).d() && this.aA != null && !(this.aA instanceof Mob)) {
            if (this.aA instanceof Char && this.a((Char) this.aA)) {
                var2.myUse = true;
                this.a(var2, false);
            }

        } else {
            var2.myUse = true;
            this.a(var2, false);
        }
    }

    public void a(int var1, short var2, short var3, boolean var4) {
        try {
            Char var6;
            if ((var6 = this.s(var1)) != null) {
                var6.a(var2, var3, var4);
            }

        } catch (Exception var5) {
        }
    }

    public void b(Message var1) throws java.io.IOException {
        Char var2;
        if ((var2 = this.s(var1.reader.dis.readInt())) != null) {
            var2.a(var1.reader.dis.readShort(), var1.reader.dis.readShort(), false);
        }

    }

    public void addChar(Message var1) throws java.io.IOException {
        Char var2;
        (var2 = new Char(var1.reader.dis.readInt())).read(var1);

        for (int var3 = 0; var3 < this.vChar.size(); ++var3) {
            if (((Char) this.vChar.elementAt(var3)).idEntity == var2.idEntity) {
                this.vChar.removeElementAt(var3);
                break;
            }
        }

        this.vChar.addElement(var2);
    }

    public void d(Message var1) throws java.io.IOException {
        Char var2;
        if ((var2 = this.f(var1.reader.dis.readInt())) != null) {
            var2.read(var1);
            if (var2.isMe()) {
                DataCenter.gI().aH = false;
            }
        }

    }

    public void r() {
        if (!LangLa_ep.a()) {
            (new Thread(new LangLa_aa(this))).start();
        }
    }

    public static void a(String var0) {
        try {
            Message var1;
            (var1 = new Message((byte) 21)).writeUTF(var0);
            var1.send();
        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    public void a(mTextBox var1) {
        try {
            String var2 = var1.f();
            if (this.cj.length() > 0) {
                var2 = this.cj + var2;
            }

            if (var2.length() > 0) {
                if (var2.startsWith("/") && var2.contains(": ")) {
                    this.ai.a((byte) 6);
                    if (this.aM != null) {
                        this.aM.o.a((byte) 6);
                    }
                }

                var1.a("");
                byte var6 = this.ai.e();
                if (this.aM != null) {
                    switch (var6 = this.aM.o.e()) {
                        case 0:
                            this.bV = 0;
                            this.aM.j.a(0);
                            break;
                        case 1:
                            this.bV = 1;
                            this.aM.j.a(0);
                            break;
                        case 2:
                            this.bV = 2;
                            this.aM.j.a(0);
                            break;
                        case 3:
                            this.aM.j.a(4);
                            break;
                        case 4:
                            this.aM.j.a(2);
                            break;
                        case 5:
                            this.aM.j.a(3);
                            break;
                        case 6:
                            this.aM.j.a(1);
                            break;
                        case 7:
                            this.aM.j.a(0);
                            break;
                        case 8:
                            this.bV = 7;
                            this.aM.j.a(0);
                            break;
                        case 9:
                            this.bV = 9;
                            this.aM.j.a(0);
                    }
                }

                Message var3 = null;
                switch (var6) {
                    case 0:
                        var3 = new Message((byte) 21);
                        break;
                    case 1:
                        (var3 = new Message((byte) 22)).writeBoolean(false);
                        break;
                    case 2:
                        var3 = new Message((byte) 23);
                        break;
                    case 3:
                        var3 = new Message((byte) 24);
                        break;
                    case 4:
                        var3 = new Message((byte) 25);
                        break;
                    case 5:
                        var3 = new Message((byte) 26);
                        break;
                    case 6:
                        var3 = new Message((byte) 28);

                        try {
                            beatdz.GameSrc.$state_GameSrc().aL = (beatdz.GameSrc.$state_GameSrc().aL = var2.split(": ")[0]).replaceAll("/", "");
                        } catch (Exception var4) {
                            beatdz.GameSrc.$state_GameSrc().aL = "";
                        }
                        break;
                    case 7:
                        var3 = new Message((byte) 27);
                        break;
                    case 8:
                        this.ai.b.b = var6;
                        var3 = new Message((byte) -59);
                        break;
                    case 9:
                        (var3 = new Message((byte) 22)).writeBoolean(true);
                }

                var3.writeUTF(var2);
                var3.send();
            }

        } catch (Exception var5) {
            Utlis.println(var5);
        }
    }

    public void a(int var1, Object var2) {
        if (this.i()) {
            switch (var1) {
                case 1011:
                    SettingsTab.E();
                    if (Char.gI().ah == 2) {
                        if (this.X.l.p >= 15 && this.X.l.p <= 345) {
                            if (this.X.l.p > 75 && this.X.l.p < 115) {
                                if (!Char.gI().C()) {
                                    this.cO.b();
                                    return;
                                }
                            } else if (this.X.l.p > 165 && this.X.l.p < 195) {
                                if (!Char.gI().A()) {
                                    this.cO.b();
                                    return;
                                }
                            } else if (this.X.l.p > 255 && this.X.l.p < 285) {
                                if (!Char.gI().D()) {
                                    this.cO.b();
                                    return;
                                }
                            } else {
                                Char var3;
                                if (this.X.l.p >= 15 && this.X.l.p <= 75) {
                                    if (!(var3 = Char.gI()).a(var3.cx + var3.speedMove, var3.cy - var3.speedMove, (byte) 2)) {
                                        this.cO.b();
                                        return;
                                    }

                                    DataCenter.gI();
                                    return;
                                } else if (this.X.l.p >= 115 && this.X.l.p <= 165) {
                                    if (!(var3 = Char.gI()).a(var3.cx - var3.speedMove, var3.cy - var3.speedMove, (byte) 3)) {
                                        this.cO.b();
                                        return;
                                    }

                                    DataCenter.gI();
                                    return;
                                } else if (this.X.l.p >= 195 && this.X.l.p <= 255) {
                                    if (!(var3 = Char.gI()).a(var3.cx - var3.speedMove, var3.cy + var3.speedMove, (byte) 3)) {
                                        this.cO.b();
                                        return;
                                    }
                                } else if (this.X.l.p >= 285 && this.X.l.p <= 345 && !(var3 = Char.gI()).a(var3.cx + var3.speedMove, var3.cy + var3.speedMove, (byte) 2)) {
                                    this.cO.b();
                                    return;
                                }
                            }
                        } else if (!Char.gI().B()) {
                            this.cO.b();
                            return;
                        }
                    } else if (this.X.l.p >= 35 && this.X.l.p < 145) {
                        Char.gI().C();
                        return;
                    } else if (this.X.l.p >= 145 && this.X.l.p < 260) {
                        Char.gI().A();
                        return;
                    } else if (this.X.l.p >= 260 && this.X.l.p < 280) {
                        Char.gI().D();
                        return;
                    } else {
                        Char.gI().B();
                    }
                default:
            }
        }
    }

    public void s() {
        this.X.d();
    }

    public void e(Message var1) throws java.io.IOException {
        Vector var2 = new Vector();
        short var3 = var1.reader.dis.readShort();

        for (int var4 = 0; var4 < var3; ++var4) {
            ItemMap var5;
            (var5 = new ItemMap()).idChar = var1.reader.dis.readInt();
            var5.idEntity = var1.reader.dis.readShort();
            var5.cx = var5.k = var1.reader.dis.readShort();
            var5.cy = var5.l = var1.reader.dis.readShort();
            var5.item = new Item();
            var5.item.read(var1);
            var2.addElement(var5);
        }

        this.vItemMap.clear();
        this.vItemMap.addAll(var2);
    }

    public void f(Message msg) throws java.io.IOException {
        Char.gI().cleanMove();
        Char.gI().idCharPk = -1;
        this.zoneID = msg.reader.dis.readShort();
        this.mapID = msg.reader.dis.readShort();
        Char.gI().cx = beatdz.SessionMove.$state_SessionMove().x = msg.reader.dis.readShort();
        Char.gI().cy = beatdz.SessionMove.$state_SessionMove().y = msg.reader.dis.readShort();
        this.vItemMap.clear();
        this.vChar.clear();
        this.vMob.clear();
        this.vNpc.clear();
        this.vWayPoint.clear();
        this.vItemMapPickUp.clear();
        short size = msg.reader.dis.readShort();

        int index;
        for (index = 0; index < size; ++index) {
            ItemMap itemMap;
            (itemMap = new ItemMap()).idChar = msg.reader.dis.readInt();
            itemMap.idEntity = msg.reader.dis.readShort();
            itemMap.cx = itemMap.k = msg.reader.dis.readShort();
            itemMap.cy = itemMap.l = msg.reader.dis.readShort();
            itemMap.item = new Item();
            itemMap.item.read(msg);
            this.vItemMap.addElement(itemMap);
        }

        size = msg.reader.readUnsignedByte();

        for (index = 0; index < size; ++index) {
            this.addChar(msg);
        }

        size = msg.reader.dis.readShort();

        for (index = 0; index < size; ++index) {
            Mob mob;
            (mob = new Mob()).read(msg);
            this.vMob.addElement(mob);
        }

        size = msg.reader.dis.readShort();

        for (index = 0; index < size; ++index) {
            Npc npc;
            (npc = new Npc(msg.reader.dis.readByte(), msg.reader.dis.readShort(), msg.reader.dis.readShort(), msg.reader.dis.readShort())).idEntity = index;
            this.vNpc.addElement(npc);
        }

        for (index = 0; index < DataCenter.gI().dataWayPoint.length; ++index) {
            WayPoint waypoint;
            if (DataCenter.gI().dataWayPoint[index][0] == this.mapID) {
                (waypoint = new WayPoint(0, 0)).create(DataCenter.gI().dataWayPoint[index][0], DataCenter.gI().dataWayPoint[index][5], DataCenter.gI().dataWayPoint[index][1], DataCenter.gI().dataWayPoint[index][2], DataCenter.gI().dataWayPoint[index][3], DataCenter.gI().dataWayPoint[index][4], DataCenter.gI().dataWayPoint[index][10], DataCenter.gI().dataWayPoint[index][11]);
                this.vWayPoint.addElement(waypoint);
            } else if (DataCenter.gI().dataWayPoint[index][5] == this.mapID) {
                (waypoint = new WayPoint(0, 0)).create(DataCenter.gI().dataWayPoint[index][5], DataCenter.gI().dataWayPoint[index][0], DataCenter.gI().dataWayPoint[index][6], DataCenter.gI().dataWayPoint[index][7], DataCenter.gI().dataWayPoint[index][8], DataCenter.gI().dataWayPoint[index][9], DataCenter.gI().dataWayPoint[index][12], DataCenter.gI().dataWayPoint[index][13]);
                this.vWayPoint.addElement(waypoint);
            }
        }

        this.createMap();
        this.loadAfterNextMap();
        this.stopLoadMap();
        Char.gI().typePK = msg.reader.dis.readByte();
        this.timeStartHoatDong = msg.reader.dis.readLong();
        this.timeHoatDong = msg.reader.dis.readInt();
        this.isHoatDongTime = msg.reader.dis.readBoolean();
        this.isTimeHoatDong = msg.reader.dis.readBoolean();
        if (this.bQ != 0) {
            Char.gI().ag = Char.gI().dir = this.bQ;
        } else {
            Char.gI().ag = Char.gI().dir = 2;
        }
    }

    private void stopLoadMap() {
        this.K();
        beatdz.GameSrc.$state_GameSrc().an = false;
        this.bN = false;
    }

    public void g(Message msg) throws java.io.IOException {
        int id = msg.reader.dis.readInt();

        for (int var3 = 0; var3 < this.vChar.size(); ++var3) {
            Char c;
            if ((c = (Char) this.vChar.elementAt(var3)).idEntity == id) {
                if (c.pointMove == null && c.vPointMove.size() <= 0) {
                    this.vChar.removeElementAt(var3);
                    return;
                }

                this.vCharWaitRemove.addElement(c);
                return;
            }
        }

    }

    private static BlockMap crateBlockMap(int var0, int var1, int var2, int var3) {
        BlockMap var4;
        (var4 = new BlockMap()).arrayXY = new XYEntity[5];
        var4.arrayXY[0] = XYEntity.create(var0, var1);
        var4.arrayXY[1] = XYEntity.create(var2, var1);
        var4.arrayXY[2] = XYEntity.create(var2, var3);
        var4.arrayXY[3] = XYEntity.create(var0, var3);
        var4.arrayXY[4] = XYEntity.create(var0, var1);
        return var4;
    }

    private Mob r(int var1) {
        for (int var3 = 0; var3 < this.vMob.size(); ++var3) {
            Mob var2;
            if ((var2 = (Mob) this.vMob.elementAt(var3)).idEntity == var1) {
                return var2;
            }
        }

        return null;
    }

    private boolean ae() {
        Char var1;
        return this.aA != null && this.aA instanceof Char && (var1 = (Char) this.aA).idEntity == Char.gI().idCharPk && this.s(var1.idEntity) != null;
    }

    private Char s(int var1) {
        for (int var3 = 0; var3 < this.vChar.size(); ++var3) {
            Char var2;
            if ((var2 = (Char) this.vChar.elementAt(var3)).idEntity == var1) {
                return var2;
            }
        }

        return null;
    }

    public Npc e(int var1) {
        for (int var2 = 0; var2 < this.vNpc.size(); ++var2) {
            Npc var3;
            if ((var3 = (Npc) this.vNpc.elementAt(var2)).idd == var1) {
                return var3;
            }
        }

        return null;
    }

    public Char f(int var1) {
        return var1 == Char.gI().idEntity ? Char.gI() : this.s(var1);
    }

    public Char b(String var1) {
        for (int var3 = 0; var3 < this.vChar.size(); ++var3) {
            Char var2;
            if ((var2 = (Char) this.vChar.elementAt(var3)).name.equals(var1)) {
                return var2;
            }
        }

        return null;
    }

    private void b(Char var1) {
        Vector var2 = new Vector();
        if (this.aI != null && !this.aI.b()) {
            if (this.aI.a() && !this.aI.a(var1.name)) {
                var2.addElement(new LangLa_lk(50, Caption.dF));
            }
        } else {
            var2.addElement(new LangLa_lk(50, Caption.bI));
        }

        if (!this.k(var1.name)) {
            var2.addElement(new LangLa_lk(51, Caption.F));
        }

        var2.addElement(new LangLa_lk(54, Caption.bA));
        var2.addElement(new LangLa_lk(53, Caption.cl));
        var2.addElement(new LangLa_lk(55, Caption.db));
        var2.addElement(new LangLa_lk(59, Caption.dG));
        if (Char.gI().typePK == 0 && var1.typePK == 0 && Char.gI().idCharPk == -1 && !var1.isCuuSat) {
            var2.addElement(new LangLa_lk(52, Caption.gI));
        }

        if (Char.gI().typePK != 1 && Char.gI().idCharPk == -1 && !var1.isCuuSat) {
            var2.addElement(new LangLa_lk(58, Caption.gJ));
        }

        if (Char.gI().aI == null && var1.aI != null && var1.aI.c >= 3) {
            var2.addElement(new LangLa_lk(60, Caption.gK));
        }

        if (Char.gI().aI != null && Char.gI().aI.c >= 3 && var1.aI == null) {
            var2.addElement(new LangLa_lk(61, Caption.gL));
        }

        String[] var3 = new String[var2.size()];
        int[] var4 = new int[var2.size()];

        for (int var6 = 0; var6 < var2.size(); ++var6) {
            LangLa_lk var5 = (LangLa_lk) var2.elementAt(var6);
            var3[var6] = var5.b;
            var4[var6] = var5.a;
        }

        this.a((LangLa_cx) (new LangLa_bk(this, var1.name + Caption.kP, var3, var4, var1)));
    }

    public static void a(Npc var0) {
        try {
            Char.gI().K();
            Message var1;
            (var1 = new Message((byte) 54)).writeShort(var0.idEntity);
            var1.send();
        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    private void af() {
        String[] var1 = Caption.rX;
        if (beatdz.DataCenter.$state_DataCenter().ar) {
            var1 = new String[Caption.rX.length - 1];
            int var2 = 0;

            for (int var3 = 0; var3 < Caption.rX.length; ++var3) {
                if (var3 != 2) {
                    var1[var2] = Caption.rX[var3];
                    ++var2;
                }
            }

            this.a((LangLa_cx) (new LangLa_bk(this, "", var1, new int[]{903, 900, 901, 905, 902})));
        } else {
            this.a((LangLa_cx) (new LangLa_bk(this, "", var1, new int[]{903, 900, 904, 901, 905, 902})));
        }
    }

    public void t() {
        String var1 = Caption.gM;
        String[] var2 = Caption.rW;
        this.a((LangLa_cx) (new LangLa_bk(this, var1, var2, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 12, 13, 14, 15, 904})));
    }

    public void h(Message var1) {
        byte var2 = -1;
        try {
            if (Boolean.getBoolean("langla.diagnostics")) {
                var1.reader.dis.mark(Integer.MAX_VALUE);
                Utlis.println("OPEN_PANEL=" + var1.reader.dis.readUnsignedByte());
                var1.reader.dis.reset();
            }
            int var10;
            GameSrc var25;
            Message var26;
            MainScreen var27;
            int var28;
            int var33;
            Message var46;
            switch (var2 = var1.reader.dis.readByte()) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 18:
                case 19:
                case 30:
                case 37:
                case 38:
                case 39:
                case 40:
                    var46 = var1;
                    var2 = var2;
                    var25 = this;

                    try {
                        var25.l.clear();
                        short var43;
                        Item[][] var38 = new Item[var43 = var46.reader.dis.readShort()][3];
                        boolean[] var44 = new boolean[var43];

                        Item var34;
                        for (var10 = 0; var10 < var43; ++var10) {
                            (var34 = new Item()).idBuy = var46.reader.dis.readShort();
                            var34.id = var46.reader.dis.readShort();
                            var34.isLock = var46.reader.dis.readBoolean();
                            var34.expiry = var46.reader.dis.readLong();
                            var34.strOptions = var46.reader.readUTF();
                            var34.tinhThachBuy = var46.reader.dis.readInt();
                            var34.vangBuy = var46.reader.dis.readInt();
                            var34.vangKhoaBuy = var46.reader.dis.readInt();
                            var34.bacKhoaBuy = var46.reader.dis.readInt();
                            var34.bacBuy = var46.reader.dis.readInt();
                            var25.l.add(var34);
                            if (var2 == 39) {
                                var44[var10] = var46.reader.dis.readBoolean();

                                for (int var49 = 0; var49 < var38[var10].length; ++var49) {
                                    var38[var10][var49] = new Item();
                                    var38[var10][var49].read(var46);
                                }
                            } else if (var2 == 40) {
                                var34.moneyOld = var46.reader.dis.readInt();
                                var34.amountBuy = var46.reader.dis.readInt();
                            }
                        }
                        if (WaitAuto.get("OpenFunc" + var2).isWait) {
                            return;
                        }

                        long var55 = -1L;
                        long var51 = -1L;
                        if (var2 == 40) {
                            var55 = var46.reader.dis.readLong();
                            var51 = var46.reader.dis.readLong();
                        }
                        applyShopUpgradeTrailer(var46);

                        byte var47 = 0;
                        String var45 = "";
                        switch (var2) {
                            case 0:
                                var45 = Caption.rk[0];
                                break;
                            case 1:
                                var45 = Caption.rk[0];
                                var47 = 1;
                                break;
                            case 2:
                                var45 = Caption.rl[0];
                                break;
                            case 3:
                                var45 = Caption.rl[0];
                                var47 = 1;
                                break;
                            case 4:
                                var45 = Caption.rm[0];
                                break;
                            case 5:
                                var45 = Caption.rm[0];
                                var47 = 1;
                            case 6:
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                            case 13:
                            case 14:
                            case 15:
                            case 16:
                            case 17:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            default:
                                break;
                            case 7:
                                var47 = 1;
                                break;
                            case 18:
                                var45 = Caption.ao;
                                var47 = 0;
                                break;
                            case 19:
                                var45 = Caption.ao;
                                var47 = 2;
                                break;
                            case 30:
                                var45 = Caption.ao;
                                var47 = 1;
                                break;
                            case 37:
                                var45 = Caption.ao;
                            case 40:
                                var47 = 3;
                                break;
                            case 38:
                                var45 = Caption.ao;
                                var47 = 4;
                                break;
                            case 39:
                                var47 = 2;
                        }
                        if (WaitAuto.get("OpenFunc" + var2).isWait) {
                            return;
                        }
                        LangLa_cx var36 = var25.H();
                        if (var2 != 6 && var2 != 7 && var2 != 39 && var2 != 40) {
                            LangLa_br var52;
                            if (var36 instanceof LangLa_br) {
                                (var52 = (LangLa_br) var36).b(var47);
                            } else {
                                var52 = new LangLa_br(var25, var2, var45, var47);
                                var25.a((LangLa_cx) var52);
                            }

                            if (beatdz.SettingsTab.$state_SettingsTab().f) {
                                beatdz.SettingsTab.$state_SettingsTab().f = false;
                                Char var30 = Char.gI();
                                var28 = 0;

                                for (var33 = 0; var33 < var30.arrItemBag.length; ++var33) {
                                    if (var30.arrItemBag[var33] == null) {
                                        ++var28;
                                    }
                                }

                                int var32 = var28;
                                if (var28 > 3) {
                                    var32 = 3;
                                } else if (var28 <= 0) {
                                    var32 = 1;
                                }

                                int var53 = Char.gI().level() / 5 * 5;

                                for (var28 = 0; var28 < var25.l.size(); ++var28) {
                                    if ((var34 = (Item) var25.l.get(var28)).getItemTemplate().type == 24 && var34.getItemTemplate().levelNeed == var53) {
                                        (var46 = new Message((byte) 121)).writeShort(var34.idBuy);
                                        var46.writeShort(var32);
                                        var46.send();
                                        return;
                                    }
                                }

                                return;
                            } else {
                                if (beatdz.SettingsTab.$state_SettingsTab().h) {
                                    beatdz.SettingsTab.$state_SettingsTab().h = false;

                                    for (var28 = 0; var28 < Char.gI().arrItemBag.length; ++var28) {
                                        Item var54;
                                        if ((var54 = Char.gI().arrItemBag[var28]) != null && var54.v() && var54.T() == 0) {
                                            a(var54, true);
                                        }
                                    }

                                    var25.bn = 10;
                                }
                                break;
                            }
                        }

                        if (var36 instanceof LangLa_bw) {
                            LangLa_bw var50 = (LangLa_bw) var36;
                            if (var2 == 40) {
                                var50.e = var55;
                                var50.f = var51;
                            }

                            var50.a(var47, (Item[][]) var38, (boolean[]) var44);
                        } else {
                            var25.a((LangLa_cx) (new LangLa_bw(var25)));
                        }

                        return;
                    } catch (Exception var23) {
                        Utlis.println(var23);
                        return;
                    }
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                    var46 = var1;
                    var2 = var2;
                    var25 = this;

                    try {
                        var25.l.clear();
                        byte var41;
                        var33 = (var41 = var46.reader.dis.readByte()) - 1;
                        short var37 = var46.reader.dis.readShort();
                        var10 = 0;

                        while (var10 < var37) {
                            Item var42;
                            (var42 = new Item()).he = var41;
                            var42.idBuy = var46.reader.dis.readShort();
                            var42.id = var46.reader.dis.readShort();
                            var42.expiry = var46.reader.dis.readLong();
                            var42.strOptions = var46.reader.readUTF();
                            var42.tinhThachBuy = var46.reader.dis.readInt();
                            var42.vangBuy = var46.reader.dis.readInt();
                            var42.vangKhoaBuy = var46.reader.dis.readInt();
                            var42.bacKhoaBuy = var46.reader.dis.readInt();
                            var42.bacBuy = var46.reader.dis.readInt();
                            var42.moneyNew = var46.reader.dis.readInt();
                            switch (var2) {
                                case 20:
                                case 21:
                                case 22:
                                case 23:
                                case 24:
                                case 25:
                                case 26:
                                case 27:
                                case 28:
                                case 29:
                                case 32:
                                case 35:
                                case 36:
                                    var42.isLock = true;
                                case 30:
                                case 31:
                                case 33:
                                case 34:
                                default:
                                    var25.l.add(var42);
                                    ++var10;
                            }
                        }

                        String var48 = "";
                        switch (var2) {
                            case 8:
                            case 20:
                                var48 = Caption.an;
                                break;
                            case 9:
                            case 21:
                                var48 = Caption.ax;
                                break;
                            case 10:
                            case 22:
                                var48 = Caption.ay;
                                break;
                            case 11:
                            case 23:
                                var48 = Caption.az;
                                break;
                            case 12:
                            case 24:
                                var48 = Caption.aA;
                                break;
                            case 13:
                            case 25:
                                var48 = Caption.aB;
                                break;
                            case 14:
                            case 26:
                                var48 = Caption.aD;
                                break;
                            case 15:
                            case 27:
                                var48 = Caption.aE;
                                break;
                            case 16:
                            case 28:
                                var48 = Caption.aF;
                                break;
                            case 17:
                            case 29:
                                var48 = Caption.aG;
                            case 18:
                            case 19:
                            case 30:
                            case 31:
                            default:
                                break;
                            case 32:
                                var48 = Caption.ss[0];
                                break;
                            case 33:
                                var48 = Caption.ss[1];
                                break;
                            case 34:
                                var48 = Caption.ss[2];
                                break;
                            case 35:
                                var48 = Caption.ss[3];
                                break;
                            case 36:
                                var48 = Caption.aI;
                        }

                        LangLa_cx var11;
                        if (!((var11 = var25.H()) instanceof LangLa_br)) {
                            var25.a((LangLa_cx) (new LangLa_br(var25, var2, var48, var33)));
                            return;
                        }

                        LangLa_br var12;
                        (var12 = (LangLa_br) var11).b(var33);
                    } catch (Exception var21) {
                    }
                case 41:
                    GoldTopUpPanel topup = H() instanceof GoldTopUpPanel ? (GoldTopUpPanel)H() : new GoldTopUpPanel(this);
                    if (H() != topup) a((LangLa_cx)topup);
                    topup.receive(var1.readUTF(), var1.readUTF(), var1.readUTF());
                    return;
                case 31:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 92:
                case 93:
                default:
                    break;
                case 49:
                    this.a((LangLa_cx) (new LangLa_ax(this, var1)));
                    return;
                case 50:
                    var26 = var1;
                    var25 = this;

                    try {
                        Char.gI().arrItemBox = new Item[var26.reader.dis.readShort()];
                        Char.gI();
                        Char.readItemBag(var26, Char.gI().arrItemBox);
                        LangLa_cx var39;
                        LangLa_lb var40;
                        if ((var39 = var25.H()) instanceof LangLa_lb) {
                            var40 = (LangLa_lb) var39;
                        } else {
                            var40 = new LangLa_lb(var25);
                        }

                        try {
                            var40.e = var26.reader.dis.readBoolean();
                            var40.c = var26.reader.dis.readInt();
                            var40.d = var26.reader.dis.readInt();
                            var40.a = var26.reader.dis.readInt();
                            var40.b = var26.reader.dis.readInt();
                        } catch (Exception var14) {
                        }

                        var25.a((LangLa_cx) var40);
                        break;
                    } catch (Exception var15) {
                        Utlis.println(var15);
                        return;
                    }
                case 51:
                    this.a((LangLa_cx) (new LangLa_l(this, Caption.gO, 0, 100)));
                    return;
                case 52:
                    this.a((LangLa_cx) (new LangLa_l(this, Caption.gP, 2, 101)));
                    return;
                case 53:
                    this.a((LangLa_cx) (new LangLa_n(this)));
                    return;
                case 54:
                    var25 = this;
                    LangLa_ky var35 = null;

                    for (var28 = 0; var28 < var25.cD.size(); ++var28) {
                        if (var25.cD.get(var28) instanceof LangLa_ky) {
                            var35 = (LangLa_ky) var25.cD.get(var28);
                            break;
                        }
                    }

                    if (var35 == null) {
                        var25.a((LangLa_cx) (new LangLa_ky(var25, var1)));
                        return;
                    }

                    for (var28 = var25.cD.size() - 1; var28 >= 0; --var28) {
                        if (!var25.cD.get(var28).equals(var35) && var25.cD.get(var28) instanceof LangLa_fo) {
                            var25.cD.remove(var28);
                        }
                    }

                    var35.a(var1);
                    var25.J();
                    break;
                case 55:
                    this.a((LangLa_cx) (new LangLa_l(this, Caption.gN, 0, 102)));
                    return;
                case 56:
                    this.a((LangLa_cx) (new LangLa_cd(this, var1)));
                    return;
                case 57:
                    var25 = this;
                    LangLa_h var31 = null;

                    for (var28 = 0; var28 < var25.cD.size(); ++var28) {
                        if (var25.cD.get(var28) instanceof LangLa_h) {
                            var31 = (LangLa_h) var25.cD.get(var28);
                            break;
                        }
                    }

                    if (var31 == null) {
                        var25.a((LangLa_cx) (new LangLa_h(var25, var1)));
                        return;
                    }

                    for (var28 = var25.cD.size() - 1; var28 >= 0; --var28) {
                        if (!var25.cD.get(var28).equals(var31) && var25.cD.get(var28) instanceof LangLa_fo) {
                            var25.cD.remove(var28);
                        }
                    }

                    var31.a(var1);
                    var25.J();
                    break;
                case 58:
                    var1 = var1;

                    try {
                        (var27 = DataCenter.gI().currentScreen).K();
                        var27.a((LangLa_cx) (new LangLa_ae(var27, var1)));
                        break;
                    } catch (Exception var20) {
                        return;
                    }
                case 59:
                    var26 = var1;
                    var25 = this;

                    try {
                        String var29 = var26.reader.readUTF();
                        var25.a((LangLa_cx) (new LangLa_aj(var25, var29)));
                        break;
                    } catch (Exception var16) {
                        return;
                    }
                case 60:
                    this.a((LangLa_cx) (new LangLa_kh(this, new String[]{Caption.lb, Caption.H}, var2)));
                    return;
                case 61:
                    this.a((LangLa_cx) (new LangLa_kh(this, new String[]{Caption.lb, Caption.H}, var2)));
                    return;
                case 62:
                    this.a((LangLa_cx) (new LangLa_kh(this, new String[]{Caption.lb, Caption.H}, var2)));
                    return;
                case 63:
                    this.a((LangLa_cx) (new LangLa_kh(this, new String[]{Caption.lb, Caption.H}, var2)));
                    return;
                case 64:
                    this.a((LangLa_cx) (new LangLa_an(this)));
                    return;
                case 65:
                    this.a((LangLa_cx) (new LangLa_ak(this)));
                    return;
                case 66:
                    this.a((LangLa_cx) (new LangLa_ap(this)));
                    return;
                case 67:
                    this.a((LangLa_cx) (new LangLa_ao(this)));
                    return;
                case 68:
                    this.a((LangLa_cx) (new LangLa_kh(this, new String[]{Caption.lc, Caption.H}, var2)));
                    return;
                case 69:
                    this.a((LangLa_cx) (new LangLa_kh(this, new String[]{Caption.lc, Caption.H}, var2)));
                    return;
                case 70:
                    this.a((LangLa_cx) (new LangLa_kh(this, new String[]{Caption.lc, Caption.H}, var2)));
                    return;
                case 71:
                    this.a((LangLa_cx) (new LangLa_kh(this, new String[]{Caption.lc, Caption.H}, var2)));
                    return;
                case 72:
                    this.a((LangLa_cx) (new LangLa_bz(gI(), var1)));
                    return;
                case 73:
                    var1 = var1;

                    try {
                        (var27 = DataCenter.gI().currentScreen).K();
                        LangLa_l var4;
                        (var4 = new LangLa_l(var27, var1.readUTF(), 0, 300)).a = var1.reader.dis.readShort();
                        var27.a((LangLa_cx) var4);
                        break;
                    } catch (Exception var19) {
                        return;
                    }
                case 74:
                    this.a((LangLa_cx) (new LangLa_g(this, var1)));
                    return;
                case 75:
                    this.a((LangLa_cx) (new LangLa_d(this)));
                    return;
                case 76:
                    this.a((LangLa_cx) (new LangLa_at(this)));
                    return;
                case 77:
                    if (Gdx.app.getType() != ApplicationType.Android && Gdx.app.getType() != ApplicationType.iOS) {
                        break;
                    }

                    return;
                case 78:
                    this.a((LangLa_cx) (new LangLa_kh(this, Caption.sg, var2)));
                    return;
                case 79:
                    this.a((LangLa_cx) (new LangLa_ks(this)));
                    return;
                case 80:
                    var25 = this;

                    try {
                        var25.a((LangLa_cx) (new LangLa_by(var25)));
                        break;
                    } catch (Exception var17) {
                        Utlis.println(var17);
                        return;
                    }
                case 81:
                    this.a((LangLa_cx) (new LangLa_au(this)));
                    return;
                case 82:
                    this.a((LangLa_cx) (new LangLa_ar(this)));
                    return;
                case 83:
                    this.a((LangLa_cx) (new LangLa_as(this)));
                    return;
                case 84:
                    this.a((LangLa_cx) (new LangLa_bv(this)));
                    return;
                case 85:
                    this.a((LangLa_cx) (new LangLa_a(this)));
                    return;
                case 86:
                    var26 = var1;
                    var25 = this;

                    try {
                        byte var3 = 0;
                        if (var26.reader.dis.readBoolean()) {
                            var3 = var26.reader.dis.readByte();
                            var25.aD.a = var26.reader.dis.readByte();
                            var25.aD.b = var26.reader.dis.readByte();
                            var25.aD.c = var26.reader.dis.readByte();
                            var25.aD.d = var26.reader.dis.readBoolean();
                        } else {
                            var25.aD = new LangLa_er();
                        }

                        Char.gI().levelCheTao = var26.reader.dis.readInt();
                        LangLa_fd var5;
                        LangLa_fd var10000 = var5 = new LangLa_fd(var25);
                        byte var7 = var3;
                        LangLa_fd var6 = var10000;
                        var10000.b.b = var3;

                        boolean var9;
                        LangLa_cl var56;
                        for (var10 = 0; var10 < var6.a.length; ++var10) {
                            var56 = var6.a[var10];
                            var9 = false;
                            var56.a = var9;
                        }

                        var56 = var6.a[var7];
                        var9 = true;
                        var56.a = var9;
                        var25.a((LangLa_cx) var5);
                        break;
                    } catch (Exception var22) {
                        Utlis.println(var22);
                        return;
                    }
                case 87:
                    this.a((LangLa_cx) (new LangLa_y(this, var1.reader.dis.readByte())));
                    return;
                case 88:
                    if (WaitAuto.get("OpenFunc" + var2).isWait) {
                        AutoPro.srcPL = new LangLa_bg(this, var1);
                        return;
                    }
                    this.a((LangLa_cx) (new LangLa_bg(this, var1)));
                    return;
                case 89:
                    this.a((LangLa_cx) (new LangLa_bc(this, var1)));
                    return;
                case 90:
                    this.a((LangLa_cx) (new LangLa_bu(this)));
                    return;
                case 91:
                    this.a((LangLa_cx) (new LangLa_kx(this, var1)));
                    return;
                case 94:
                    this.a((LangLa_cx) (new LangLa_am(this)));
                    return;
                case 95:
                    this.a((LangLa_cx) (new LangLa_bt(this)));
                    return;
                case 96:
                    var25 = this;

                    try {
                        var25.a((LangLa_cx) (new LangLa_o(var25)));
                        break;
                    } catch (Exception var18) {
                        Utlis.println(var18);
                        return;
                    }
                case 97:
                    this.a((LangLa_cx) (new LangLa_e(this)));
                    return;
                case 98:
                    if (this.i()) {
                        this.a((LangLa_cx) (new LangLa_bi(gI(), var1)));
                        return;
                    }
                    break;
                case 99:
                    this.a((LangLa_cx) (new LangLa_ag(this)));
                    return;
                case 100:
                    this.a((LangLa_cx) (new LangLa_al(this)));
                    return;
                case 101:
                    Controller.readVXMM(var1);
                    return;
                case 102:
                    Controller.readLatHinh(var1);
                    return;
            }

        } catch (Exception var24) {
            Utlis.println(var24);
        } finally {
            WaitAuto.get("OpenFunc" + var2).unlockObject();
        }
    }

    public static void g(int var0) {
        try {
            Message var1;
            (var1 = new Message((byte) 117)).writeByte(var0);
            var1.send();
        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    public static void a(Item var0, boolean var1) {
        try {
            Message var2;
            (var2 = new Message((byte) 119)).writeShort(var0.index);
            var2.writeBoolean(var1);
            var2.send();
        } catch (Exception var3) {
            Utlis.println(var3);
        }
    }

    public static void openFunc(int var0) {
        try {
            if (Boolean.getBoolean("langla.diagnostics")) Utlis.println("OPEN_FUNC=" + var0);
            Message var1;
            (var1 = new Message((byte) 122)).writeByte(var0);
            var1.send();
        } catch (Exception var2) {
        }
    }

    public static void b(int var0, int var1) {
        try {
            Message var2;
            (var2 = new Message((byte) 122)).writeByte(var0);
            var2.writeByte(var1);
            var2.send();
        } catch (Exception var3) {
        }
    }

    public static void i(Message var0) {
        try {
            short var1 = var0.reader.dis.readShort();

            for (int var2 = 0; var2 < var1; ++var2) {
                Item var3;
                (var3 = new Item()).read(var0);
                int var4 = var3.getAmount();
                if (Char.gI().arrItemBag[var3.index] != null) {
                    var4 -= Char.gI().arrItemBag[var3.index].getAmount();
                }

                Char.gI().arrItemBag[var3.index] = var3;
                if (var3.expiry == 0L) {
                    Char.gI().arrItemBag[var3.index] = null;
                } else {
                    LangLa_kw.a(7, Caption.bz, Caption.k + " " + var4 + " " + var3.getItemTemplate().name);
                    DataCenter.gI().currentScreen.showMessage(Caption.k + " " + var4 + " " + var3.getItemTemplate().name, -1);
                }
            }

        } catch (Exception var6) {
        }
    }

    public void j(Message var1) {
        try {
            Char.gI().bac = var1.reader.dis.readLong();
            Char.gI().bacKhoa = var1.reader.dis.readLong();
            Char.gI().vang = var1.reader.dis.readLong();
            Char.gI().vangKhoa = var1.reader.dis.readLong();
            short var2 = var1.reader.dis.readShort();

            for (int var3 = 0; var3 < var2; ++var3) {
                Item var4;
                (var4 = new Item()).read(var1);
                int var5 = var4.getAmount();
                if (Char.gI().arrItemBag[var4.index] != null) {
                    var5 -= Char.gI().arrItemBag[var4.index].getAmount();
                }

                Char.gI().arrItemBag[var4.index] = var4;
                if (var4.expiry == 0L) {
                    Char.gI().arrItemBag[var4.index] = null;
                } else if (var4.id != 160) {
                    LangLa_kw.a(7, Caption.bz, Caption.k + " " + var5 + " " + var4.getItemTemplate().name);
                    DataCenter.gI().currentScreen.showMessage(Caption.k + " " + var5 + " " + var4.getItemTemplate().name, -1);
                }
            }

            LangLa_cx var8;
            if (!((var8 = this.H()) instanceof LangLa_lv)) {
                LangLa_bw var9;
                if (var8 instanceof LangLa_bw && (var9 = (LangLa_bw) var8).d != null) {
                    var9.d.a(true);
                }

                return;
            }

            this.j(var8.cF);
        } catch (Exception var7) {
        }

    }

    public static void k(Message var0) {
        try {
            Char.gI().b(var0.reader.dis.readLong(), false, true);
            Char.gI().a(var0.reader.dis.readLong(), false, true);
            Char.gI().arrItemBag[var0.reader.dis.readShort()] = null;
        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    public static void l(Message var0) {
        try {
            short var1 = var0.reader.dis.readShort();
            int var2 = var0.reader.dis.readInt();
            Char.gI().arrItemBag[var1].setAmount(var2);
            Char.gI().arrItemBag[var1].index = var1;
            short var6 = var0.reader.dis.readShort();
            int var5 = var0.reader.dis.readInt();
            Char.gI().arrItemBag[var6] = Char.gI().arrItemBag[var1].a();
            Char.gI().arrItemBag[var6].setAmount(var5);
            Char.gI().arrItemBag[var6].index = var6;
        } catch (Exception var4) {
        }
    }

    public void m(Message var1) {
        try {
            byte var3;
            if ((var3 = var1.reader.dis.readByte()) != 0) {
                if (var3 == 1) {
                    a(Char.gI().arrItemBox);
                }

                return;
            }

            a(Char.gI().arrItemBag);
        } catch (Exception var2) {
        }

    }

    public void n(Message var1) {
        try {
            short var2 = var1.reader.dis.readShort();
            Item var3;
            (var3 = Char.gI().arrItemBag[var2]).isLock = var1.reader.dis.readBoolean();
            Char.gI().arrItemBag[var2] = null;
            if (var3.isTypeTrangBi()) {
                Item var6;
                if ((var6 = Char.gI().arrItemBody[var3.getItemTemplate().type]) != null) {
                    var6.index = var3.index;
                    Char.gI().arrItemBag[var2] = var6;
                }

                var3.index = var3.getItemTemplate().type;
                Char.gI().arrItemBody[var3.index] = var3;
                Char.gI().aa = (byte) (Char.gI().arrItemBody[10] != null ? 50 : -1);
                if (var3.getItemTemplate().type == 10) {
                    Char.gI().aK = null;
                }
            } else if (var3.getItemTemplate().type == 28) {
                Item[] var7 = new Item[var1.reader.dis.readShort()];

                int var9;
                for (var9 = 0; var9 < Char.gI().arrItemBag.length; ++var9) {
                    var7[var9] = Char.gI().arrItemBag[var9];
                }

                Char.gI().arrItemBag = var7;

                for (var9 = 0; var9 < Char.gI().arrItemExtend.length; ++var9) {
                    if (Char.gI().arrItemExtend[var9] == null) {
                        var3.index = var9;
                        Char.gI().arrItemExtend[var9] = var3;
                        break;
                    }
                }
            } else {
                var3.setAmount(var1.reader.dis.readInt());
                Char.gI().arrItemBag[var2] = var3;
            }

            LangLa_cx var8;
            if ((var8 = this.H()) instanceof LangLa_kl) {
                LangLa_kl var10;
                (var10 = (LangLa_kl) var8).d = false;
                var10.e(0);
            }

            if (var3.z()) {
                this.g();
                DataCenter.gI().aH = false;
            }

        } catch (Exception var5) {
            Utlis.println(var5);
        }
    }

    public void o(Message var1) {
        try {
            short var5 = var1.reader.dis.readShort();
            Item var2;
            (var2 = Char.gI().arrItemBag[var5]).isLock = true;
            Char.gI().arrItemBag[var5] = null;
            if (var2.isTypeTrangBi()) {
                Item var3;
                if ((var3 = Char.gI().arrItemBody2[var2.getItemTemplate().type]) != null) {
                    var3.index = var2.index;
                    Char.gI().arrItemBag[var5] = var3;
                }

                var2.index = var2.getItemTemplate().type;
                Char.gI().arrItemBody2[var2.index] = var2;
            }

            LangLa_cx var7;
            if ((var7 = this.H()) instanceof LangLa_kl) {
                LangLa_kl var6;
                (var6 = (LangLa_kl) var7).e(1);
            }

        } catch (Exception var4) {
            Utlis.println(var4);
        }
    }

    public void p(Message var1) {
        try {
            LangLa_cx var2 = this.H();
            byte var3 = var1.reader.dis.readByte();
            short var7 = var1.reader.dis.readShort();
            Item var4 = Char.gI().arrItemBody[var3];
            Char.gI().arrItemBody[var3] = null;
            Char.gI().arrItemBag[var7] = var4;
            Char.gI().arrItemBag[var7].index = var7;
            Char.gI();
            if (var2 instanceof LangLa_kl) {
                LangLa_kl var8;
                (var8 = (LangLa_kl) var2).d = false;
                var8.e(var8.b.b.b);
            }

            if (var4.z()) {
                DataCenter.gI().aH = false;
                gI().g();
            }

        } catch (Exception var6) {
        }
    }

    public void q(Message var1) {
        try {
            byte var2 = var1.reader.dis.readByte();
            short var5 = var1.reader.dis.readShort();
            Item var3 = Char.gI().arrItemBody2[var2];
            Char.gI().arrItemBody2[var2] = null;
            Char.gI().arrItemBag[var5] = var3;
            Char.gI().arrItemBag[var5].index = var5;
            Char.gI();
            LangLa_cx var6;
            if ((var6 = this.H()) instanceof LangLa_kl) {
                LangLa_kl var7;
                (var7 = (LangLa_kl) var6).e(var7.b.b.b);
            }

        } catch (Exception var4) {
            Utlis.println(var4);
        }
    }

    public void r(Message var1) {
        try {
            Char.gI();
            Char.gI().arrItemBody = Char.readItemBody(var1, Char.gI().arrItemBody);
            Char.gI();
            Char.gI().arrItemBody2 = Char.readItemBody(var1, Char.gI().arrItemBody2);
            Char.readWingRenderInfo(var1);
            Char.readWingRenderInfo(var1);
            LangLa_cx var3;
            if ((var3 = this.H()) instanceof LangLa_kl) {
                LangLa_kl var4;
                (var4 = (LangLa_kl) var3).d = false;
                var4.e(var4.b.b.b);
            }

        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    public void s(Message var1) {
        try {
            byte var2 = var1.reader.dis.readByte();
            Item[] var5 = new Item[var1.reader.dis.readShort()];
            Item var3 = Char.gI().arrItemExtend[var2];
            Char.gI().arrItemExtend[var2] = null;
            a(Char.gI().arrItemBag);

            for (int var6 = 0; var6 < var5.length; ++var6) {
                if (Char.gI().arrItemBag[var6] == null) {
                    var3.index = var6;
                    var5[var6] = var3;
                    break;
                }

                var5[var6] = Char.gI().arrItemBag[var6];
            }

            Char.gI().arrItemBag = var5;
        } catch (Exception var4) {
        }
    }

    public static void t(Message var0) {
        try {
            short var1 = var0.reader.dis.readShort();
            short var4 = var0.reader.dis.readShort();
            Item var2 = Char.gI().arrItemBag[var1];
            Char.gI().arrItemBag[var1] = null;
            if (Char.gI().arrItemBox[var4] == null) {
                Char.gI().arrItemBox[var4] = var2;
                Char.gI().arrItemBox[var4].index = var4;
                return;
            }

            Char.gI().arrItemBox[var4].setAmount(Char.gI().arrItemBox[var4].getAmount() + var2.getAmount());
        } catch (Exception var3) {
        }

    }

    public static void u(Message var0) {
        try {
            short var1 = var0.reader.dis.readShort();
            short var4 = var0.reader.dis.readShort();
            Item var2 = Char.gI().arrItemBox[var1];
            Char.gI().arrItemBox[var1] = null;
            if (Char.gI().arrItemBag[var4] == null) {
                Char.gI().arrItemBag[var4] = var2;
                Char.gI().arrItemBag[var4].index = var4;
                return;
            }

            Char.gI().arrItemBag[var4].setAmount(Char.gI().arrItemBag[var4].getAmount() + var2.getAmount());
        } catch (Exception var3) {
        }

    }

    public static void v(Message var0) {
        try {
            Item var1;
            (var1 = new Item()).read(var0);
            int var4 = var1.getAmount();
            if (Char.gI().arrItemBag[var1.index] != null) {
                var4 -= Char.gI().arrItemBag[var1.index].getAmount();
            }

            Char.gI().arrItemBag[var1.index] = var1;
            if (var1.expiry != 0L) {
                if (var1.id < 269 || var1.id > 273) {
                    LangLa_kw.a(7, Caption.bz, Caption.k + " " + var4 + " " + var1.getItemTemplate().name);
                    DataCenter.gI().currentScreen.showMessage(Caption.k + " " + var4 + " " + var1.getItemTemplate().name, -1);
                }

                return;
            }

            Char.gI().arrItemBag[var1.index] = null;
        } catch (Exception var3) {
        }

    }

    public void a(Message var1, boolean var2) {
        try {
            Char var3;
            if ((var3 = this.f(var1.reader.dis.readInt())).bh == null) {
                return;
            }

            int var4;
            switch (var3.idClass) {
                case 1:
                    var4 = var3.level() > 40 ? 51 : 3;
                    break;
                case 2:
                    var4 = var3.level() > 40 ? 112 : 64;
                    break;
                case 3:
                    var4 = var3.level() > 40 ? 173 : 125;
                    break;
                case 4:
                    var4 = var3.level() > 40 ? 233 : 186;
                    break;
                case 5:
                    var4 = var3.level() > 40 ? 287 : 246;
                    break;
                default:
                    return;
            }

            var3 = var3.bh;
            Skill var9;
            if ((var9 = DataCenter.gI().Skill[var4].cloneSkill()) == null) {
                return;
            }

            if (!var2) {
                Mob var8;
                if ((var8 = this.r(var1.reader.dis.readShort())) != null) {
                    var8.H = var3;
                }

                if (var3.idEntity != Char.gI().idEntity) {
                    if (var3.vPointMove.size() > 0) {
                        var3.pointMove2 = var3.pointMove = (PointMove) var3.vPointMove.lastElement();
                        var3.vPointMove.clear();
                    } else {
                        var3.pointMove2 = var3.pointMove;
                    }

                    var3.a((Skill) var9, (Entity) var8);
                }

                return;
            }

            Char var7 = this.f(var1.reader.dis.readInt());
            if (var3.idEntity != Char.gI().idEntity) {
                var3.a((Skill) var9, (Entity) var7);
            }
        } catch (Exception var6) {
            Utlis.println(var6);
        }

    }

    public void w(Message var1) {
        try {
            Char var2 = this.f(var1.reader.dis.readInt());
            ItemMap var3;
            (var3 = new ItemMap()).idChar = var1.reader.dis.readInt();
            var3.idEntity = var1.reader.dis.readShort();
            var3.a(var1.reader.dis.readShort(), var1.reader.dis.readShort(), var2.m(), var2.n());
            var3.item = new Item();
            var3.item.read(var1);
            this.vItemMap.addElement(var3);
            LangLa_dp var7;
            if (!(var7 = LangLa_dp.a()).a) {
                try {
                    if (var7.b[21] != null) {
                        var7.b[21].play();
                    }

                    return;
                } catch (Exception var5) {
                    Utlis.println(var5);
                }
            }

        } catch (Exception var6) {
            Utlis.println(var6);
        }
    }

    public void x(Message var1) {
        try {
            short var5 = var1.reader.dis.readShort();
            GameSrc var4 = this;
            int var3 = 0;

            ItemMap var2;
            ItemMap var10000;
            while (true) {
                if (var3 >= var4.vItemMap.size()) {
                    var10000 = null;
                    break;
                }

                if ((var2 = (ItemMap) var4.vItemMap.elementAt(var3)).idEntity == var5) {
                    var10000 = var2;
                    break;
                }

                ++var3;
            }

            var2 = var10000;
            if (var10000 == null) {
                return;
            }
            var10000.o = true;
            Char var9;
            if ((var9 = this.f(var1.reader.dis.readInt())) != null) {
                if (var9.idEntity == Char.gI().idEntity) {
                    Item var10;
                    (var10 = new Item()).read(var1);
                    int var8 = var10.getAmount();
                    if (var9.arrItemBag[var10.index] != null) {
                        var8 -= var9.arrItemBag[var10.index].getAmount();
                    }

                    var9.arrItemBag[var10.index] = var10;
                    LangLa_kw.a(7, Caption.bz, Caption.k + " " + var8 + " " + var10.getItemTemplate().name);
                    DataCenter.gI().currentScreen.showMessage(Caption.k + " " + var8 + " " + var10.getItemTemplate().name, -1);
                    LangLa_dp var11;
                    if (!(var11 = LangLa_dp.a()).a) {
                        try {
                            if (var11.b[22] != null) {
                                var11.b[22].play();
                            }
                        } catch (Exception var6) {
                            Utlis.println(var6);
                        }
                    }
                }

                var2.p = 20;
                var2.a(var9.m(), var9.n(), var2.cx, var2.cy);
            }
        } catch (Exception var7) {
            Utlis.println(var7);
        }
    }

    public void y(Message var1) {
        try {
            short var5 = var1.reader.dis.readShort();
            int var2 = 0;

            while (true) {
                if (var2 >= this.vItemMap.size()) {
                    return;
                }

                if (((ItemMap) this.vItemMap.elementAt(var2)).idEntity == var5) {
                    this.vItemMap.remove(var2);
                    break;
                }

                ++var2;
            }
        } catch (Exception var4) {
            Utlis.println(var4);
        }

    }

    public void z(Message var1) {
        try {
            for (int var2 = 0; var2 < Char.gI().arrItemBag.length; ++var2) {
                Char.gI().arrItemBag[var2] = null;
            }

            Char.gI().bac = var1.reader.dis.readLong();
            short var6 = var1.reader.dis.readShort();

            for (int var3 = 0; var3 < var6; ++var3) {
                Item var4;
                (var4 = new Item()).read(var1);
                Char.gI().arrItemBag[var4.index] = var4;
            }

            Char.gI().aW = var1.reader.dis.readByte();
            Char.gI().aX = var1.reader.dis.readByte();
            Char.gI().aY = var1.reader.dis.readInt();
            LangLa_cx var8;
            if ((var8 = this.H()) instanceof LangLa_kl) {
                LangLa_kl var7;
                (var7 = (LangLa_kl) var8).C = null;
            }

        } catch (Exception var5) {
            Utlis.println(var5);
        }
    }

    public void A(Message var1) {
        try {
            byte var2 = var1.reader.dis.readByte();

            for (int var3 = 0; var3 < var2; ++var3) {
                byte var4 = var1.reader.dis.readByte();

                try {
                    Char.gI().h(var4)[var1.reader.dis.readShort()] = null;
                } catch (Exception var5) {
                }
            }

            Item var9;
            (var9 = new Item()).read(var1);
            var9.TYPE_TEMP = var1.reader.dis.readByte();
            if (var9.TYPE_TEMP == 2 || var9.TYPE_TEMP == 3) {
                var9.index = var9.getItemTemplate().type;
            }

            Char.gI().h(var9.TYPE_TEMP)[var9.index] = var9;
            LangLa_cx var10;
            if ((var10 = this.H()) instanceof LangLa_at) {
                LangLa_at var7;
                (var7 = (LangLa_at) var10).e = new LangLa_jw(114, 0, 0, 1);

                for (int var8 = 0; var8 < var7.b.length; ++var8) {
                    var7.b[var8] = null;
                }

                var7.a = var9;
            }

        } catch (Exception var6) {
        }
    }

    public void B(Message var1) {
        try {
            Char.gI().a(var1.reader.dis.readLong(), false, false);
            Char.gI().b(var1.reader.dis.readLong(), false, false);
            byte var2 = var1.reader.dis.readByte();

            for (int var3 = 0; var3 < var2; ++var3) {
                Char.gI().arrItemBag[var1.reader.dis.readShort()] = null;
            }

            Item var9;
            (var9 = new Item()).read(var1);
            Char.gI().arrItemBag[var9.index] = var9;
            LangLa_cx var6 = this.H();
            this.dz = 1;
            if (!(var6 instanceof LangLa_au)) {
                DataCenter.gI().currentScreen.showMessage(Caption.nW + " " + var9.getItemTemplate().name, -2560);
                return;
            }

            LangLa_au var7;
            (var7 = (LangLa_au) var6).c = new LangLa_jw(114, 0, 0, 1);

            for (int var8 = 0; var8 < var7.b.length; ++var8) {
                var7.b[var8] = null;
            }

            var7.a = var9;
        } catch (Exception var5) {
        }

    }

    public void C(Message var1) {
        try {
            boolean var2 = var1.reader.dis.readBoolean();
            boolean var3 = var1.reader.dis.readBoolean();
            Char.gI().a(var1.reader.dis.readLong(), false, false);
            Char.gI().b(var1.reader.dis.readLong(), false, false);
            byte var4 = var1.reader.dis.readByte();

            for (int var5 = 0; var5 < var4; ++var5) {
                Char.gI().arrItemBag[var1.reader.dis.readShort()] = null;
            }

            short var12;
            if ((var12 = var1.reader.dis.readShort()) >= 0) {
                Char.gI().arrItemBag[var12] = null;
            }

            Item var11;
            (var11 = new Item()).read(var1);
            var11.TYPE_TEMP = var1.reader.dis.readByte();
            if (var11.TYPE_TEMP == 2 || var11.TYPE_TEMP == 3) {
                var11.index = var11.getItemTemplate().type;
            }

            Char.gI().h(var11.TYPE_TEMP)[var11.index] = var11;
            LangLa_cx var8;
            if ((var8 = this.H()) instanceof LangLa_ar) {
                LangLa_ar var9;
                (var9 = (LangLa_ar) var8).d = 100;
                var9.f = new LangLa_jw(114, 0, 0);
                if (var2) {
                    var9.e = 1;
                } else if (!var3) {
                    var9.e = 2;
                } else {
                    var9.e = 3;
                }

                int var10;
                for (var10 = 0; var10 < var9.b.length; ++var10) {
                    var9.b[var10] = null;
                }

                for (var10 = 0; var10 < var9.a.length; ++var10) {
                    var9.a[var10] = null;
                }

                var9.a[0] = var11;
                Char.gI().h(var11.TYPE_TEMP)[var11.index] = null;
            }

        } catch (Exception var7) {
        }
    }

    public void D(Message var1) {
        try {
            byte var2 = var1.reader.dis.readByte();

            for (int var3 = 0; var3 < var2; ++var3) {
                Char.gI().arrItemBag[var1.reader.dis.readShort()] = null;
            }

            Item var9;
            (var9 = new Item()).read(var1);
            var9.TYPE_TEMP = var1.reader.dis.readByte();
            if (var9.TYPE_TEMP == 2 || var9.TYPE_TEMP == 3) {
                var9.index = var9.getItemTemplate().type;
            }

            Char.gI().h(var9.TYPE_TEMP)[var9.index] = var9;
            LangLa_cx var6;
            if ((var6 = this.H()) instanceof LangLa_y) {
                LangLa_y var7;
                (var7 = (LangLa_y) var6).d = 100;
                var7.e = new LangLa_jw(114, 0, 0);

                int var8;
                for (var8 = 0; var8 < var7.b.length; ++var8) {
                    var7.b[var8] = null;
                }

                for (var8 = 0; var8 < var7.a.length; ++var8) {
                    var7.a[var8] = null;
                }

                var7.a[0] = var9;
                Char.gI().h(var9.TYPE_TEMP)[var9.index] = null;
            }

        } catch (Exception var5) {
            Utlis.println(var5);
        }
    }

    public void E(Message var1) {
        try {
            Item var2;
            (var2 = new Item()).read(var1);
            var2.TYPE_TEMP = var1.reader.dis.readByte();
            if (var2.TYPE_TEMP == 2 || var2.TYPE_TEMP == 3) {
                var2.index = var2.getItemTemplate().type;
            }

            Char.gI().h(var2.TYPE_TEMP)[var2.index] = var2;
            LangLa_cx var5;
            if ((var5 = this.H()) instanceof LangLa_bv) {
                LangLa_bv var6;
                (var6 = (LangLa_bv) var5).d = true;
                var6.e = new LangLa_jw(114, 0, 0);

                int var3;
                for (var3 = 0; var3 < var6.b.length; ++var3) {
                    var6.b[var3] = null;
                }

                for (var3 = 0; var3 < var6.a.length; ++var3) {
                    var6.a[var3] = null;
                }

                var6.a[1] = var2;
            }

        } catch (Exception var4) {
        }
    }

    public void F(Message var1) {
        try {
            Item var2;
            (var2 = new Item()).read(var1);
            var2.TYPE_TEMP = var1.reader.dis.readByte();
            if (var2.TYPE_TEMP == 2 || var2.TYPE_TEMP == 3) {
                var2.index = var2.getItemTemplate().type;
            }

            Char.gI().h(var2.TYPE_TEMP)[var2.index] = var2;
            LangLa_cx var5;
            if ((var5 = this.H()) instanceof LangLa_bu) {
                LangLa_bu var6;
                (var6 = (LangLa_bu) var5).d = true;
                var6.e = new LangLa_jw(114, 0, 0);

                int var3;
                for (var3 = 0; var3 < var6.b.length; ++var3) {
                    var6.b[var3] = null;
                }

                for (var3 = 0; var3 < var6.a.length; ++var3) {
                    var6.a[var3] = null;
                }

                var6.a[1] = var2;
            }

        } catch (Exception var4) {
        }
    }

    public void G(Message var1) {
        try {
            Item var2;
            (var2 = new Item()).read(var1);
            var2.TYPE_TEMP = var1.reader.dis.readByte();
            if (var2.TYPE_TEMP == 2 || var2.TYPE_TEMP == 3) {
                var2.index = var2.getItemTemplate().type;
            }

            Char.gI().h(var2.TYPE_TEMP)[var2.index] = var2;
            Item var3;
            (var3 = new Item()).read(var1);
            var3.TYPE_TEMP = var1.reader.dis.readByte();
            if (var3.TYPE_TEMP == 2 || var3.TYPE_TEMP == 3) {
                var3.index = var3.getItemTemplate().type;
            }

            Char.gI().h(var3.TYPE_TEMP)[var3.index] = var3;
            Char.gI().arrItemBag[var1.reader.dis.readShort()] = null;
            LangLa_cx var6;
            if ((var6 = this.H()) instanceof LangLa_a) {
                LangLa_a var7;
                (var7 = (LangLa_a) var6).c = true;
                var7.d = new LangLa_jw(114, 0, 0);

                for (int var4 = 0; var4 < var7.a.length; ++var4) {
                    var7.a[var4] = null;
                }

                var7.a[0] = var2;
                var7.a[1] = var3;
            }

        } catch (Exception var5) {
        }
    }

    public void H(Message var1) {
        try {
            Item var2;
            (var2 = new Item()).read(var1);
            var2.TYPE_TEMP = var1.reader.dis.readByte();
            if (var2.TYPE_TEMP == 2 || var2.TYPE_TEMP == 3) {
                var2.index = var2.getItemTemplate().type;
            }

            Char.gI().h(var2.TYPE_TEMP)[var2.index] = var2;
            byte var3 = var1.reader.dis.readByte();

            for (int var4 = 0; var4 < var3; ++var4) {
                Char.gI().arrItemBag[var1.reader.dis.readShort()] = null;
            }

            LangLa_cx var9;
            if ((var9 = this.H()) instanceof LangLa_as) {
                LangLa_as var7;
                (var7 = (LangLa_as) var9).d = 100;
                var7.e = new LangLa_jw(114, 0, 0);

                for (int var8 = 0; var8 < var7.b.length; ++var8) {
                    var7.b[var8] = null;
                }

                var7.a[0] = var2;
                Char.gI().h(var2.TYPE_TEMP)[var2.index] = null;
            }

        } catch (Exception var6) {
        }
    }

    public void I(Message var1) {
        try {
            Item var2;
            (var2 = new Item()).read(var1);
            var2.TYPE_TEMP = var1.reader.dis.readByte();
            if (var2.TYPE_TEMP == 2 || var2.TYPE_TEMP == 3) {
                var2.index = var2.getItemTemplate().type;
            }

            Char.gI().h(var2.TYPE_TEMP)[var2.index] = var2;
            byte var3 = var1.reader.dis.readByte();

            for (int var4 = 0; var4 < var3; ++var4) {
                Char.gI().arrItemBag[var1.reader.dis.readShort()] = null;
            }

            int var12;
            LangLa_cx var13;
            if ((var13 = this.H()) instanceof LangLa_an) {
                LangLa_an var7;
                (var7 = (LangLa_an) var13).e = new LangLa_jw(114, 0, 0);
                var7.d = 200;
                var7.f = true;

                for (var12 = 0; var12 < var7.b.length; ++var12) {
                    var7.b[var12] = null;
                }

                var7.a[0] = null;
                var7.a[1] = var2;
            } else if (var13 instanceof LangLa_ak) {
                LangLa_ak var8;
                (var8 = (LangLa_ak) var13).e = new LangLa_jw(114, 0, 0);
                var8.d = 200;
                var8.f = true;

                for (var12 = 0; var12 < var8.b.length; ++var12) {
                    var8.b[var12] = null;
                }

                var8.a[0] = null;
                var8.a[1] = var2;
            } else if (var13 instanceof LangLa_ap) {
                LangLa_ap var9;
                (var9 = (LangLa_ap) var13).e = new LangLa_jw(114, 0, 0);
                var9.d = 200;
                var9.f = true;

                for (var12 = 0; var12 < var9.b.length; ++var12) {
                    var9.b[var12] = null;
                }

                var9.a[0] = null;
                var9.a[1] = var2;
            } else {
                if (!(var13 instanceof LangLa_ao)) {
                    if (var13 instanceof LangLa_al) {
                        LangLa_al var11;
                        (var11 = (LangLa_al) var13).e = new LangLa_jw(114, 0, 0);
                        var11.d = 200;
                        var11.f = true;

                        for (var12 = 0; var12 < var11.b.length; ++var12) {
                            var11.b[var12] = null;
                        }

                        var11.a[0] = null;
                        var11.a[1] = var2;
                    }

                    return;
                }

                LangLa_ao var10;
                (var10 = (LangLa_ao) var13).e = new LangLa_jw(114, 0, 0);
                var10.d = 200;
                var10.f = true;

                for (var12 = 0; var12 < var10.b.length; ++var12) {
                    var10.b[var12] = null;
                }

                var10.a[0] = null;
                var10.a[1] = var2;
            }
        } catch (Exception var6) {
        }

    }

    public void J(Message var1) {
        try {
            int var2 = gI().aC.length;
            short var3 = var1.reader.dis.readShort();
            gI().aC = new LangLa_gl[var1.reader.dis.readShort()];

            int var4;
            for (var4 = 0; var4 < gI().aC.length; ++var4) {
                gI().aC[var4] = new LangLa_gl();
                gI().aC[var4].a = var1.reader.dis.readLong();
                gI().aC[var4].b = var1.reader.readUTF();
                gI().aC[var4].c = var1.reader.dis.readInt();
                gI().aC[var4].d = var1.reader.dis.readInt();
                gI().aC[var4].e = new Item();
                gI().aC[var4].e.read(var1);
            }

            var4 = 0;

            while (true) {
                if (var4 >= this.cD.size()) {
                    return;
                }

                if (this.cD.get(var4) instanceof LangLa_v) {
                    LangLa_v var7 = (LangLa_v) this.cD.get(var4);
                    if (gI().aC.length > 0) {
                        var7.f = var3;
                    } else if (var2 != gI().aC.length) {
                        var7.f = var3;
                    }

                    var7.m();
                    break;
                }

                ++var4;
            }
        } catch (Exception var6) {
        }

    }

    public void K(Message var1) {
        try {
            gI().aB = new LangLa_gl[var1.reader.dis.readShort()];

            int var2;
            for (var2 = 0; var2 < gI().aB.length; ++var2) {
                gI().aB[var2] = new LangLa_gl();
                gI().aB[var2].a = var1.reader.dis.readLong();
                gI().aB[var2].b = Char.gI().name;
                gI().aB[var2].c = var1.reader.dis.readInt();
                gI().aB[var2].d = var1.reader.dis.readInt();
                gI().aB[var2].e = new Item();
                gI().aB[var2].e.read(var1);
            }

            var2 = 0;

            while (true) {
                if (var2 >= this.cD.size()) {
                    return;
                }

                if (this.cD.get(var2) instanceof LangLa_v) {
                    ((LangLa_v) this.cD.get(var2)).n();
                    break;
                }

                ++var2;
            }
        } catch (Exception var4) {
        }

    }

    public void L(Message var1) {
        try {
            Char.gI().a(var1.reader.dis.readLong(), false, true);
            int var3 = 0;

            while (true) {
                if (var3 >= this.cD.size()) {
                    return;
                }

                if (this.cD.get(var3) instanceof LangLa_v) {
                    LangLa_v var4 = (LangLa_v) this.cD.get(var3);
                    LangLa_v.g();
                    var4.e();
                    break;
                }

                ++var3;
            }
        } catch (Exception var2) {
        }

    }

    public void M(Message var1) {
        try {
            gI().vThu.clear();
            short var2 = var1.reader.dis.readShort();

            for (int var3 = 0; var3 < var2; ++var3) {
                Thu var4;
                (var4 = new Thu()).a(var1);
                gI().vThu.add(var4);
            }

            LangLa_cx var6;
            if ((var6 = this.H()) instanceof LangLa_t) {
                LangLa_t var7;
                (var7 = (LangLa_t) var6).g();
            }

        } catch (Exception var5) {
        }
    }

    public static void N(Message var0) {
        try {
            Char.gI().c(var0.reader.dis.readLong(), false, false);
            Char.gI().a(var0.reader.dis.readLong(), false, true);
            Char.gI().b(var0.reader.dis.readLong(), false, false);
        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    public static void O(Message var0) {
        try {
            Char.gI().c(var0.reader.dis.readLong(), false, false);
            Char.gI().a(var0.reader.dis.readLong(), false, false);
            Char.gI().b(var0.reader.dis.readLong(), false, true);
        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    public static void P(Message var0) {
        try {
            Char.gI().a(var0.reader.dis.readLong(), var0.reader.dis.readBoolean(), true);
        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    public static void Q(Message var0) {
        try {
            Char.gI().b(var0.reader.dis.readLong(), var0.reader.dis.readBoolean(), true);
        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    public static void R(Message var0) {
        try {
            Char.gI().c(var0.reader.dis.readLong(), var0.reader.dis.readBoolean(), true);
        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    public static void S(Message var0) {
        try {
            Char.gI();
            long var10001 = var0.reader.dis.readLong();
            boolean var10002 = var0.reader.dis.readBoolean();
            boolean var4 = true;
            boolean var2 = var10002;
            long var1 = var10001;
            String var5;
            if (var1 - Char.gI().vangKhoa > 0) {
                var5 = Caption.k + " " + Utlis.numberFormat(var1 - Char.gI().vangKhoa) + " " + Caption.rs[1];
                if (Char.J()) {
                    LangLa_kw.a(7, Caption.bz, var5);
                }

                if (var2) {
                    DataCenter.gI().currentScreen.showMessage(var5, -1);
                }

                LangLa_hy.a("+" + (var1 - Char.gI().vangKhoa), Char.gI(), Char.gI().ak, 10);
            } else if (var1 - Char.gI().vangKhoa < 0) {
                var5 = Caption.cL + " " + Utlis.numberFormat(-(var1 - Char.gI().vangKhoa)) + " " + Caption.rs[1];
                if (Char.J()) {
                    LangLa_kw.a(7, Caption.bz, var5);
                }

                if (var2) {
                    DataCenter.gI().currentScreen.showMessage(var5, -1);
                }

                LangLa_hy.a("" + (var1 - Char.gI().vangKhoa), Char.gI(), Char.gI().ak, 10);
            }

            Char.gI().vangKhoa = var1;
        } catch (Exception var3) {
            Utlis.println(var3);
        }
    }

    public static void T(Message var0) {
        try {
            int var3 = var0.reader.dis.readInt();
            Char var1 = Char.gI();
            LangLa_hy.a("+" + var3, var1, var1.ak, 6);
        } catch (Exception var2) {
        }
    }

    public void U(Message var1) {
        try {
            long var2 = var1.reader.dis.readLong();
            Char var4 = Char.gI();

            try {
                var4 = this.f(var1.reader.dis.readInt());
            } catch (Exception var10) {
            }

            int var12 = var4.level();
            if (var4.isMe()) {
                if (var2 - var4.exp > 0L) {
                    if (Char.J() && var2 - var4.exp > 1000000L) {
                        LangLa_kw.a(7, Caption.bz, Caption.k + " " + Utlis.numberFormat(var2 - var4.exp) + " " + Caption.bJ);
                    }

                    LangLa_hy.a("+" + (var2 - var4.exp), var4, var4.ak, 6);
                } else if (var2 - var4.exp < 0L) {
                    if (Char.J()) {
                        LangLa_kw.a(7, Caption.bz, Caption.cL + " " + Utlis.numberFormat(var2 - var4.exp) + " " + Caption.bJ);
                    }

                    LangLa_hy.a("" + (var2 - var4.exp), var4, var4.ak, 6);
                }
            }

            var4.exp = var2;
            if (var4.level() != var12 && var4.isMe()) {
                var4.aF.addElement(new LangLa_jw(84, var4.cx, var4.cy));
                LangLa_dp var13;
                if (!(var13 = LangLa_dp.a()).a) {
                    try {
                        if (var13.b[23] != null) {
                            var13.b[23].play();
                        }
                    } catch (Exception var9) {
                        Utlis.println(var9);
                    }
                }

                if (AppListener.gI().listener != null) {
                    SDKListener var10000 = AppListener.gI().listener;
                    (new StringBuilder()).append(DataCenter.gI().aS);
                    (new StringBuilder()).append(DataCenter.gI().aP.name);
                    (new StringBuilder()).append(DataCenter.gI().aT);
                    (new StringBuilder()).append(var4.level());
                }
            }

            this.ak.d();
        } catch (Exception var11) {
        }
    }

    public static void V(Message var0) {
        try {
            GameSrc var10000 = gI();
            short var1 = var0.reader.dis.readShort();
            GameSrc var5 = var10000;
            int var3 = 0;

            Thu var7;
            while (true) {
                if (var3 >= var5.vThu.size()) {
                    var7 = null;
                    break;
                }

                Thu var2;
                if ((var2 = (Thu) var5.vThu.get(var3)).a == var1) {
                    var7 = var2;
                    break;
                }

                ++var3;
            }

            Thu var6 = var7;
            var7.e = null;
            var6.f = 0;
            var6.g = 0;
            var6.h = 0;
            var6.i = 0;
            var6.j = 0L;
            if (gI().H().cL != null && gI().H().cL instanceof LangLa_kk) {
                ((LangLa_kk) gI().H().cL).a();
            }

        } catch (Exception var4) {
        }
    }

    private static void a(Item[] var0) {
        try {
            Vector var1 = new Vector();

            for (int var2 = 0; var2 < var0.length; ++var2) {
                if (var0[var2] != null) {
                    var1.add(var0[var2]);
                }

                var0[var2] = null;
            }

            for (int var4 = 0; var4 < var1.size(); ++var4) {
                Item var7;
                if ((var7 = (Item) var1.get(var4)).getItemTemplate().isXepChong) {
                    for (int var5 = var1.size() - 1; var5 > var4; --var5) {
                        Item var3;
                        if ((var3 = (Item) var1.get(var5)).id == var7.id && var3.isLock == var7.isLock && var3.expiry == var7.expiry) {
                            var7.setAmount(var7.getAmount() + var3.getAmount());
                            var1.remove(var5);
                        }
                    }
                }
            }

            for (short var8 = 0; var8 < var1.size(); var0[var8].index = var8++) {
                var0[var8] = (Item) var1.get(var8);
            }

        } catch (Exception var6) {
        }
    }

    public void W(Message var1) {
        try {
            Char.gI().a(var1.reader.dis.readLong(), false, false);
            Char.gI().b(var1.reader.dis.readLong(), false, true);
            short var6;
            if ((var6 = var1.reader.dis.readShort()) >= 0) {
                Char.gI().arrItemBag[var6] = null;
            }

            LangLa_cx var7;
            if ((var7 = this.H()) instanceof LangLa_s) {
                LangLa_s var8;
                LangLa_s var2 = var8 = (LangLa_s) var7;

                try {
                    String var3;
                    if ((var3 = var2.c.f().trim()).length() > 0) {
                        var2.f.remove(var3);
                        var2.f.insertElementAt(var3, 0);

                        for (int var9 = var2.f.size() - 1; var9 > 10; --var9) {
                            var2.f.removeElementAt(var9);
                        }
                    }
                } catch (Exception var4) {
                    Utlis.println(var4);
                }

                var2.g.b(var2.f.size() == 0);
                var2.e();
                var8.c.a("");
                var8.b.a("");
                var8.a.a("");
                var8.d.a("");
                var8.e = null;
            }

            DataCenter.gI().currentScreen.showMessage(Caption.gS, -2560);
        } catch (Exception var5) {
        }
    }

    public void X(Message var1) {
        try {
            LangLa_cx var2;
            if ((var2 = this.H()) instanceof LangLa_aj) {
                LangLa_aj var6;
                (var6 = (LangLa_aj) var2).J();
            }

            Char.gI().a(var1.reader.dis.readLong(), false, true);
            short var7 = var1.reader.dis.readShort();

            int var3;
            for (var3 = 0; var3 < Char.gI().arrItemBag.length; ++var3) {
                Char.gI().arrItemBag[var3] = null;
            }

            for (var3 = 0; var3 < var7; ++var3) {
                Item var4;
                (var4 = new Item()).read(var1);
                Char.gI().arrItemBag[var4.index] = var4;
            }

            DataCenter.gI().currentScreen.showMessage(Caption.gU, -2560);
        } catch (Exception var5) {
        }
    }

    public void Y(Message var1) {
        try {
            LangLa_cx var2;
            if ((var2 = this.H()) instanceof LangLa_aj) {
                LangLa_aj var6;
                (var6 = (LangLa_aj) var2).b = 1;
                var6.d = var1.reader.dis.readInt();
                byte var3 = var1.reader.dis.readByte();

                for (int var4 = 0; var4 < var3; ++var4) {
                    var6.f[var4] = new Item();
                    var6.f[var4].read(var1);
                }

                if (var6.a == var6.b) {
                    var6.h = Utlis.time() + 5999L;
                }
            }

        } catch (Exception var5) {
        }
    }

    public void Z(Message var1) {
        try {
            Enemy var2;
            (var2 = new Enemy()).b = var1.reader.readUTF();
            var2.c = var1.reader.dis.readBoolean();
            gI().vEnemy.add(var2);
            LangLa_cx var5;
            if ((var5 = this.H()) instanceof LangLa_ca) {
                ((LangLa_ca) var5).f();
            }

        } catch (Exception var4) {
            Utlis.println(var4);
        }
    }

    public void aa(Message var1) {
        try {
            String var5 = var1.reader.readUTF();

            for (int var3 = 0; var3 < gI().vEnemy.size(); ++var3) {
                Enemy var2;
                if ((var2 = (Enemy) gI().vEnemy.elementAt(var3)).b.equals(var5)) {
                    gI().vEnemy.remove(var2);
                    break;
                }
            }

            LangLa_cx var6;
            if ((var6 = this.H()) instanceof LangLa_ca) {
                ((LangLa_ca) var6).f();
            }

        } catch (Exception var4) {
            Utlis.println(var4);
        }
    }

    public void ab(Message var1) {
        try {
            String var2 = var1.reader.readUTF();

            for (int var4 = 0; var4 < gI().vEnemy.size(); ++var4) {
                Enemy var3;
                if ((var3 = (Enemy) gI().vEnemy.elementAt(var4)).b.equals(var2)) {
                    var3.c = var1.reader.dis.readBoolean();
                    break;
                }
            }

            LangLa_cx var6;
            if ((var6 = this.H()) instanceof LangLa_ca) {
                ((LangLa_ca) var6).f();
            }

        } catch (Exception var5) {
            Utlis.println(var5);
        }
    }

    public void ac(Message var1) {
        try {
            Friend var2;
            (var2 = new Friend()).c = var1.reader.readUTF();
            var2.b = var1.reader.dis.readByte();
            var2.d = var1.reader.dis.readBoolean();
            gI().vFriend.add(var2);
            this.u();
            LangLa_cx var5;
            if (!((var5 = this.H()) instanceof LangLa_ms)) {
                if (var5 instanceof LangLa_ca) {
                    ((LangLa_ca) var5).e();
                }

                return;
            }

            LangLa_ms var6;
            (var6 = (LangLa_ms) var5).J();
            var6.a.e();
        } catch (Exception var4) {
            Utlis.println(var4);
        }

    }

    public void ad(Message var1) {
        try {
            String var2 = var1.reader.readUTF();

            for (int var4 = 0; var4 < gI().vFriend.size(); ++var4) {
                Friend var3;
                if ((var3 = (Friend) gI().vFriend.get(var4)).c.equals(var2)) {
                    var3.b = var1.reader.dis.readByte();
                    var3.d = var1.reader.dis.readBoolean();
                    break;
                }
            }

            LangLa_cx var7;
            if ((var7 = this.H()) instanceof LangLa_ms) {
                LangLa_ms var6;
                (var6 = (LangLa_ms) var7).J();
                var6.a.e();
            } else if (var7 instanceof LangLa_ca) {
                ((LangLa_ca) var7).e();
            }

            this.u();
        } catch (Exception var5) {
            Utlis.println(var5);
        }
    }

    public void u() {
        this.at = false;

        for (int var1 = 0; var1 < this.vFriend.size(); ++var1) {
            if (((Friend) this.vFriend.get(var1)).b == 2) {
                this.at = true;
                return;
            }
        }

    }

    public void ae(Message var1) {
        try {
            Friend var2;
            (var2 = new Friend()).c = var1.reader.readUTF();
            var2.b = var1.reader.dis.readByte();
            gI().vFriend.add(var2);
            this.u();
            DataCenter.gI().currentScreen.showMessage(var2.c + Caption.gV, -2560);
            LangLa_cx var5;
            if ((var5 = gI().H()) instanceof LangLa_ca) {
                ((LangLa_ca) var5).e();
            }

        } catch (Exception var4) {
            Utlis.println(var4);
        }
    }

    public void af(Message var1) {
        try {
            String var5 = var1.reader.readUTF();

            for (int var3 = 0; var3 < gI().vFriend.size(); ++var3) {
                Friend var2;
                if ((var2 = (Friend) gI().vFriend.get(var3)).c.equals(var5)) {
                    gI().vFriend.remove(var2);
                    break;
                }
            }

            LangLa_cx var6;
            if ((var6 = gI().H()) instanceof LangLa_ca) {
                ((LangLa_ca) var6).e();
            }

            this.u();
        } catch (Exception var4) {
            Utlis.println(var4);
        }
    }

    public void ag(Message var1) {
        try {
            this.aD.a = var1.reader.dis.readByte();
            this.aD.b = var1.reader.dis.readByte();
            this.aD.c = var1.reader.dis.readByte();
            this.aD.d = var1.reader.dis.readBoolean();
            short var2 = var1.reader.dis.readShort();

            for (int var3 = 0; var3 < var2; ++var3) {
                Item var4;
                (var4 = new Item()).read(var1);
                if (var4.expiry == 0L) {
                    Char.gI().arrItemBag[var4.index] = null;
                } else {
                    Char.gI().arrItemBag[var4.index] = var4;
                }
            }

            LangLa_cx var6;
            if ((var6 = gI().H()) instanceof LangLa_fd) {
                LangLa_fd var7;
                (var7 = (LangLa_fd) var6).b(this.aD.b);
            }

        } catch (Exception var5) {
            Utlis.println(var5);
        }
    }

    public void a(Skill var1, boolean var2) {
        this.aR = null;
        if (Char.gI().j()) {
            Char.gI();
            Char.x();
        } else {
            this.aq = false;
            if (var1 == null) {
                if (this.aA != null) {
                    this.aq = true;
                    this.aH = var1;
                    this.g(false);
                }

            } else if (var1.d()) {
                Char.gI().av = null;
                Char.gI().p();
                Char.gI().a((Skill) var1, (Entity) null);
            } else if (var1.getSkillTemplate().type == 6) {
                this.showMessage(Caption.gW, -1);
            } else if (this.aA != null) {
                this.aq = true;
                this.aH = var1;
                if (var1.idTemplate == 11) {
                    Char.gI().av = null;
                    Char.gI().p();
                }

                this.g(var2);
            } else {
                this.b(false);
            }
        }
    }

    public static void updateHpFull(Message var0, Char var1) {
        try {
            if (var1 == null) {
                var1 = gI().s(var0.reader.dis.readInt());
            }

            var1.hpFull = var0.reader.dis.readInt();
            var1.hp = var0.reader.dis.readInt();
        } catch (Exception var3) {
            Utlis.println(var3);
        }
    }

    public static void updateHp(Message var0, Char var1) {
        try {
            byte var2 = 3;
            if (var1 == null) {
                var1 = gI().s(var0.reader.dis.readInt());
                var2 = 0;
            }

            if (var1 != null) {
                int var3;
                if ((var3 = var0.reader.dis.readInt()) < var1.hp) {
                    LangLa_hy.a("" + (var1.hp - var3), var1, var1.height + 28, var2);
                }

                var1.hp = var3;
                if (var1.hp <= 0) {
                    var1.al = var0.reader.dis.readShort();
                    var1.am = var0.reader.dis.readShort();
                    var1.a(var0.readUTF());
                }

            }
        } catch (Exception var4) {
            Utlis.println(var4);
        }
    }

    public static void updateMpFull(Message var0, Char var1) {
        try {
            if (var1 == null) {
                var1 = gI().s(var0.reader.dis.readInt());
            }

            var1.mpFull = var0.reader.dis.readInt();
            var1.mp = var0.reader.dis.readInt();
        } catch (Exception var3) {
            Utlis.println(var3);
        }
    }

    public static void updateMp(Message var0, Char var1) {
        try {
            if (var1 == null) {
                var1 = gI().s(var0.reader.dis.readInt());
            }

            if (var1 != null) {
                var1.mp = var0.reader.dis.readInt();
            }
        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    public static void ah(Message var0) {
        try {
            LangLa_cx var1;
            if ((var1 = gI().H()) instanceof LangLa_kl) {
                LangLa_kl var7;
                LangLa_kl var10000 = var7 = (LangLa_kl) var1;
                Message var8 = var0;
                LangLa_kl var6 = var10000;

                try {
                    var6.y.levelCheTao = var8.reader.dis.readInt();
                    var6.y.hoatLuc = var8.reader.dis.readInt();
                    var6.y.sachChienDau = var8.reader.dis.readByte();
                    var6.v = var8.reader.dis.readShort();
                    var6.i = var6.u = var8.reader.dis.readShort();
                    LangLa_ce var10 = var6.B;
                    boolean var3 = var8.reader.dis.readBoolean();
                    var10.a = var3;
                    var6.A.a(var8.reader.dis.readByte());
                    var6.e = var8.reader.dis.readShort();
                    var6.f = var8.reader.dis.readShort();
                    var6.h = var8.reader.dis.readShort();
                    var6.g = var8.reader.dis.readShort();
                    var6.w[0] = var8.reader.dis.readInt();
                    var6.w[1] = var8.reader.dis.readInt();
                    var6.w[2] = var8.reader.dis.readShort();
                    var6.w[3] = var8.reader.dis.readShort();
                    var6.w[4] = var8.reader.dis.readShort();
                    var6.w[5] = var8.reader.dis.readShort();
                    var6.w[6] = var8.reader.dis.readShort();
                    var6.w[7] = var8.reader.dis.readShort();
                    var6.w[8] = var8.reader.dis.readShort();
                    var6.w[9] = var8.reader.dis.readShort();
                    var6.w[10] = var8.reader.dis.readShort();
                    var6.w[11] = var8.reader.dis.readShort();
                    var6.w[12] = var8.reader.dis.readShort();
                    var6.w[13] = var8.reader.dis.readShort();
                    var6.w[14] = var8.reader.dis.readShort();
                    var6.w[15] = var8.reader.dis.readShort();
                    var6.w[16] = var8.reader.dis.readShort();
                    var6.x[0] = var8.reader.dis.readShort();
                    var6.x[1] = var8.reader.dis.readShort();
                    var6.x[2] = var8.reader.dis.readShort();
                    var6.x[3] = var8.reader.dis.readShort();
                    var6.x[4] = var8.reader.dis.readShort();
                    var6.x[5] = var8.reader.dis.readShort();
                    var6.x[6] = var8.reader.dis.readShort();
                    var6.y.speedMove = Char.movementSpeed(var6.x[6]);
                    var6.x[7] = var8.reader.dis.readShort();
                    var6.x[8] = var8.reader.dis.readShort();
                    var6.x[9] = var8.reader.dis.readShort();
                    var6.x[10] = var8.reader.dis.readShort();
                    var6.x[11] = var8.reader.dis.readShort();
                    var6.x[12] = var8.reader.dis.readShort();
                    var6.x[13] = var8.reader.dis.readShort();
                    var6.x[14] = var8.reader.dis.readShort();
                    var6.x[15] = var8.reader.dis.readShort();
                    var6.x[16] = var8.reader.dis.readShort();
                    var6.x[17] = var8.reader.dis.readShort();
                    var6.readPotentialTail(var8);
                    var6.c[0].a("" + var6.e);
                    var6.c[1].a("" + var6.f);
                    var6.c[2].a("" + var6.h);
                    var6.c[3].a("" + var6.g);
                    mTextBox var11 = var6.c[0];
                    int var9 = var6.e;
                    var11.n = var9;
                    var11 = var6.c[1];
                    var9 = var6.f;
                    var11.n = var9;
                    var11 = var6.c[2];
                    var9 = var6.h;
                    var11.n = var9;
                    var11 = var6.c[3];
                    var9 = var6.g;
                    var11.n = var9;
                    var6.d = true;
                    var6.b(var6.a);
                    return;
                } catch (Exception var4) {
                    Utlis.println(var4);
                }
            }

        } catch (Exception var5) {
            Utlis.println(var5);
        }
    }

    public static void ai(Message var0) {
        try {
            LangLa_cx var1;
            if ((var1 = gI().H()) instanceof LangLa_kl) {
                LangLa_kl var9;
                LangLa_kl var10000 = var9 = (LangLa_kl) var1;
                Message var10 = var0;
                LangLa_kl var8 = var10000;
                long[] var2 = new long[29];

                try {
                    var8.y.hpFull = var10.reader.dis.readInt();
                    var8.y.hp = var10.reader.dis.readInt();
                    var8.y.mpFull = var10.reader.dis.readInt();
                    var8.y.mp = var10.reader.dis.readInt();
                    var8.y.lvPk = var10.reader.dis.readByte();
                    var2[0] = (long) var10.reader.dis.readShort();
                    var2[1] = (long) var10.reader.dis.readInt();
                    var2[2] = (long) var10.reader.dis.readShort();
                    var2[3] = (long) var10.reader.dis.readShort();
                    var2[4] = var10.reader.dis.readLong();
                    var2[5] = (long) var10.reader.dis.readInt();
                    var2[6] = (long) var10.reader.dis.readInt();
                    var2[7] = (long) var10.reader.dis.readInt();
                    var2[8] = (long) var10.reader.dis.readShort();
                    var2[9] = var10.reader.dis.readLong();
                    var2[10] = (long) var10.reader.dis.readInt();
                    var2[11] = (long) var10.reader.dis.readShort();
                    var2[12] = (long) var10.reader.dis.readShort();
                    var2[13] = (long) var10.reader.dis.readShort();
                    var2[14] = (long) var10.reader.dis.readShort();
                    var2[15] = (long) var10.reader.dis.readShort();
                    var2[16] = (long) var10.reader.dis.readShort();
                    var2[17] = (long) var10.reader.dis.readShort();
                    var2[18] = (long) var10.reader.dis.readShort();
                    var2[19] = (long) var10.reader.dis.readShort();
                    var2[20] = (long) var10.reader.dis.readShort();
                    var2[21] = (long) var10.reader.dis.readByte();
                    var2[22] = (long) var10.reader.dis.readByte();
                    var2[23] = (long) var10.reader.dis.readByte();
                    var2[24] = (long) var10.reader.dis.readByte();
                    var2[25] = (long) var10.reader.dis.readByte();
                    var2[26] = (long) var10.reader.dis.readByte();
                    var2[27] = (long) var10.reader.dis.readByte();
                    var2[28] = (long) var10.reader.dis.readByte();
                    var8.y.bd = var10.reader.dis.readByte();
                    var8.y.ba = var10.reader.dis.readByte();
                } catch (Exception var6) {
                }

                String var11 = "";
                var11 = var11 + Caption.rG[3] + " " + var8.y.name + "\n";
                var11 = var11 + Caption.ag + var8.y.level() + Caption.dp + var8.y.lvPk + "\n";
                var11 = var11 + Caption.w + ": " + DataCenter.gI().DataNameChar[var8.y.idClass].name + " (" + DataCenter.gI().DataNameClass[var8.y.idhe].name + ")\n";
                var11 = var11 + Caption.de + var8.y.hp + "/" + var8.y.hpFull + "\n";
                var11 = var11 + Caption.df + var8.y.mp + "/" + var8.y.mpFull + "\n";
                if (var8.y.aI != null) {
                    var11 = var11 + Caption.dq + var8.y.aI.a + "\n";
                    String var3 = Caption.dr;
                    if (var8.y.aI.c == 5) {
                        var3 = Caption.ds;
                    } else if (var8.y.aI.c == 4) {
                        var3 = Caption.dt;
                    } else if (var8.y.aI.c == 3) {
                        var3 = Caption.du;
                    }

                    var11 = var11 + Caption.dv + var3 + "\n";
                } else {
                    var11 = var11 + Caption.dw + "\n";
                }

                int[] var12 = new int[]{0, 4, 8, 12, 14, 16};
                int var4 = 0;

                int var5;
                for (var5 = 5; var5 >= 0; --var5) {
                    if (var8.f(var12[var5])) {
                        var4 = var5;
                        break;
                    }
                }

                if ((var5 = var12[var4]) < 4) {
                    var11 = var11 + Caption.ls + "\n";
                } else {
                    var11 = var11 + Caption.lr + " " + var5 + "\n" + Caption.lu + " " + var5 + Caption.lt + "\n";
                }

                for (int var13 = 0; var13 < Caption.rf.length; ++var13) {
                    if (var13 == 0) {
                        var11 = var11 + Caption.rf[var13] + ": +" + Utlis.numberFormat(var2[var13]) + "%\n";
                    } else if (var13 == 21) {
                        var11 = var11 + Caption.rf[var13] + ": " + Utlis.numberFormat(var2[var13]) + "/" + var8.y.bc + "\n";
                    } else if (var13 == 22) {
                        var11 = var11 + Caption.rf[var13] + ": " + Utlis.numberFormat(var2[var13]) + "/" + var8.y.bd + "\n";
                    } else if (var13 == 23) {
                        var11 = var11 + Caption.rf[var13] + ": " + Utlis.numberFormat(var2[var13]) + "/" + var8.y.be + "\n";
                    } else if (var13 == 24) {
                        var11 = var11 + Caption.rf[var13] + ": " + Utlis.numberFormat(var2[var13]) + "/" + var8.y.aZ + "\n";
                    } else if (var13 == 25) {
                        var11 = var11 + Caption.rf[var13] + ": " + Utlis.numberFormat(var2[var13]) + "/" + var8.y.ba + "\n";
                    } else if (var13 == 26) {
                        var11 = var11 + Caption.rf[var13] + ": " + Utlis.numberFormat(var2[var13]) + "/" + var8.y.bb + "\n";
                    } else if (var13 == 27) {
                        var11 = var11 + Caption.rf[var13] + ": " + Utlis.numberFormat(var2[var13]) + "/" + var8.y.bf + "\n";
                    } else {
                        var11 = var11 + Caption.rf[var13] + ": " + Utlis.numberFormat(var2[var13]) + "\n";
                    }
                }

                DataCenter.gI();
                DataCenter.gI();
                DataCenter.gI();
                var8.cL = LangLa_kl.a(var11, var8, 296, 55, 205);
            }

        } catch (Exception var7) {
            Utlis.println(var7);
        }
    }

    public void aj(Message var1) {
        try {
            Char.gI().mp = var1.reader.dis.readInt();
            short var2 = var1.reader.dis.readShort();
            long var3 = var1.reader.dis.readLong();

            for (int var11 = 0; var11 < this.aE.size(); ++var11) {
                Skill var5;
                if ((var5 = (Skill) this.aE.elementAt(var11)) != null && var5.idTemplate == var2) {
                    if (var3 <= 0L) {
                        var5.time = Utlis.time();
                        return;
                    }

                    var5.time = Utlis.time() + var3;
                    break;
                }
            }

        } catch (Exception var10) {
            Utlis.println(var10);
        }
    }

    public void ak(Message var1) {
        try {
            Char var2;
            if ((var2 = this.f(var1.reader.dis.readInt())) != null) {
                var2.mp = var1.reader.dis.readInt();
                short var3 = var1.reader.dis.readShort();
                Skill var7;
                if ((var7 = DataCenter.gI().Skill[var3].cloneSkill()).idTemplate == 11) {
                    var2.cleanVecMove();
                }

                Mob var6;
                if ((var6 = this.r(var1.reader.dis.readShort())) != null) {
                    var6.H = var2;
                }

                if (var2.idEntity != Char.gI().idEntity) {
                    if (var2.vPointMove.size() > 0) {
                        var2.pointMove2 = var2.pointMove = (PointMove) var2.vPointMove.lastElement();
                        var2.vPointMove.clear();
                    } else {
                        var2.pointMove2 = var2.pointMove;
                    }

                    var2.a((Skill) var7, (Entity) var6);
                }

            }
        } catch (Exception var5) {
            Utlis.println(var5);
        }
    }

    public void al(Message var1) {
        try {
            Char var2;
            if ((var2 = this.f(var1.reader.dis.readInt())) != null) {
                var2.mp = var1.reader.dis.readInt();
                Skill var3 = DataCenter.gI().Skill[var1.reader.dis.readShort()].cloneSkill();
                Char var6 = this.f(var1.reader.dis.readInt());
                if (var2.idEntity != Char.gI().idEntity) {
                    var2.a((Skill) var3, (Entity) var6);
                }

            }
        } catch (Exception var5) {
            Utlis.println(var5);
        }
    }

    public void am(Message var1) {
        try {
            this.r(var1.reader.dis.readShort()).hp = var1.reader.dis.readInt();
        } catch (Exception var3) {
            Utlis.println(var3);
        }
    }

    public void an(Message var1) {
        try {
            Mob var2 = this.r(var1.reader.dis.readShort());
            int var3 = var1.reader.dis.readInt();
            boolean var4 = false;

            try {
                var4 = var1.reader.dis.readBoolean();
            } catch (Exception var6) {
                Utlis.println(var6);
            }

            if (var2 != null) {
                if (var3 == var2.hp) {
                    if (var2.getMobTemplate().type != 8) {
                        LangLa_hy.a("", var2, var2.height + 10, 2);
                    }
                } else if (var4) {
                    LangLa_hy.a("" + (var2.hp - var3), var2, var2.height + 10, 1);
                } else {
                    LangLa_hy.a("" + Utlis.positive(var2.hp - var3), var2, var2.height + 10, 0);
                }

                var2.hp = var3;
                if (var2.hp == 0) {
                    Mob var10000 = var2;
                    Char var9 = var2.H;
                    Mob var8 = var10000;
                    var10000.v = var8.u = var8.z = 0;
                    var8.status = 5;
                    var8.t = var8.cx;
                    byte var10001;
                    if (var9 == null) {
                        var10001 = 3;
                    } else {
                        switch (var9.dir) {
                            case 0:
                                var8.r = var8.cx;
                                var8.s = (short) (var8.cy + var8.w);
                                var8.A = var8.cx < var9.cx;
                                var8.u = -4;
                                var10001 = 1;
                                break;
                            case 1:
                                var8.r = var8.cx;
                                var8.s = (short) (var8.cy - var8.w);
                                var8.A = var8.cx < var9.cx;
                                var8.u = -4;
                                var10001 = 0;
                                break;
                            case 2:
                                var8.r = (short) (var8.cx + var8.w);
                                var8.s = var8.cy;
                                var10001 = 3;
                                break;
                            case 3:
                                var8.r = (short) (var8.cx - var8.w);
                                var8.s = var8.cy;
                                var10001 = 2;
                                break;
                            default:
                                var10001 = var8.dir;
                        }
                    }

                    var8.dir = var10001;
                    if (Utlis.inRange(var8.a(), var8.c(), var8.b(), var8.cy, DataCenter.gI().j, DataCenter.gI().k, DataCenter.gI().l, DataCenter.gI().m)) {
                        LangLa_dp.a().l();
                    }

                    if (var8.u()) {
                        gI().I.add(new LangLa_jw(190, var8.cx, var8.cy, 1));
                        var8.z = 30;
                    }
                }
            }

        } catch (Exception var7) {
            Utlis.println(var7);
        }
    }

    public void ao(Message var1) {
        try {
            Mob var2 = this.r(var1.reader.dis.readShort());
            ItemMap var3;
            (var3 = new ItemMap()).idChar = var1.reader.dis.readInt();
            var3.idEntity = var1.reader.dis.readShort();
            var3.cx = var3.k = var1.reader.dis.readShort();
            var3.cy = var3.l = var1.reader.dis.readShort();
            var3.item = new Item();
            var3.item.read(var1);
            var2.G.addElement(var3);
        } catch (Exception var5) {
            Utlis.println(var5);
        }
    }

    public void ap(Message var1) {
        try {
            Mob var2;
            (var2 = this.r(var1.reader.dis.readShort())).vEffect.clear();
            var2.b(var2.p, var2.q);
            var2.Z = true;
            var2.level = var1.reader.dis.readShort();
            var2.he = var1.reader.dis.readByte();
            var2.hp = var1.reader.dis.readInt();
            var2.hpFull = var1.reader.dis.readInt();
            var2.exp = var1.reader.dis.readInt();
            var2.levelBoss = var1.reader.dis.readByte();
            var2.status = var1.reader.dis.readByte();
            if (var2.status == 0) {
                var2.J = 14;
                gI().H.addElement(new LangLa_hm(143, var2.cx, var2.n()));
            }

        } catch (Exception var4) {
            //       Utlis.println(var4);
        }
    }

    public void aq(Message var1) {
        try {
            Mob var2;
            (var2 = this.r(var1.reader.dis.readShort())).hp = var1.reader.dis.readInt();
            var2.hpFull = var1.reader.dis.readInt();
            var2.exp = var1.reader.dis.readInt();
            var2.levelBoss = var1.reader.dis.readByte();
            var2.status = var1.reader.dis.readByte();
        } catch (Exception var4) {
            Utlis.println(var4);
        }
    }

    public void ar(Message var1) {
        try {
            Mob var2 = this.r(var1.reader.dis.readShort());
            Char var5;
            if ((var5 = this.f(var1.reader.dis.readInt())) != null) {
                var2.b((Entity) var5);
            }
        } catch (Exception var4) {
            Utlis.println(var4);
        }
    }

    public void as(Message var1) {
        try {
            Char var2;
            if ((var2 = this.f(var1.reader.dis.readInt())) != null) {
                Mob var6 = this.r(var1.reader.dis.readShort());

                for (int var3 = 0; var3 < var2.vEffect.size(); ++var3) {
                    Effect var4;
                    if ((var4 = (Effect) var2.vEffect.get(var3)).h != null) {
                        var4.h.b((Entity) var6);
                    }
                }

            }
        } catch (Exception var5) {
            Utlis.println(var5);
        }
    }

    public void at(Message var1) {
        try {
            Char var2 = this.f(var1.reader.dis.readInt());
            Char var6 = this.f(var1.reader.dis.readInt());
            if (var2 != null && var6 != null) {
                for (int var3 = 0; var3 < var2.vEffect.size(); ++var3) {
                    Effect var4;
                    if ((var4 = (Effect) var2.vEffect.get(var3)).h != null) {
                        var4.h.b((Entity) var6);
                    }
                }

            }
        } catch (Exception var5) {
            Utlis.println(var5);
        }
    }

    public void au(Message var1) {
        try {
            Mob var2 = this.r(var1.reader.dis.readShort());
            Mob var5 = this.r(var1.reader.dis.readShort());
            var2.b((Entity) var5);
        } catch (Exception var4) {
            Utlis.println(var4);
        }
    }

    public void av(Message var1) {
        try {
            Char var2;
            if ((var2 = this.f(var1.reader.dis.readInt())) == null) {
                return;
            }

            int var3 = var1.reader.dis.readInt();
            int var4 = var1.reader.dis.readInt();
            boolean var5 = var1.reader.dis.readBoolean();
            if (var4 <= var2.hp) {
                if (var4 == var2.hp) {
                    LangLa_hy.a("", var2, var2.height + 10, 5);
                } else if (var5) {
                    LangLa_hy.a("" + (var2.hp - var4), var2, var2.height + 10, 4);
                } else {
                    LangLa_hy.a("" + (var2.hp - var4), var2, var2.height + 10, 3);
                }
            }

            if (var3 <= var2.mp - 1000) {
                if (var3 < 0) {
                    var3 = 0;
                }

                LangLa_hy.a("" + (var3 - var2.mp), var2, var2.height + 10, 13);
            }

            var2.hp = var4;
            var2.mp = var3;
            if (var2.hp > 0) {
                var2.k();
                return;
            }

            var2.hp = 0;
            var2.al = var1.reader.dis.readShort();
            var2.am = var1.reader.dis.readShort();
            var2.a(var1.readUTF());
        } catch (Exception var6) {
            Utlis.println(var6);
        }

    }

    public static void a(Item var0) {
        try {
            Message var1;
            (var1 = new Message((byte) 116)).writeShort(var0.index);
            var1.send();
        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    private Item h(boolean var1) {
        Item var2 = null;

        try {
            Vector var3 = new Vector();

            for (int var4 = 0; var4 < Char.gI().arrItemBag.length; ++var4) {
                if (Char.gI().arrItemBag[var4] != null) {
                    if (this.mapID == 45) {
                        if (Char.gI().arrItemBag[var4].id == 659) {
                            var3.add(Char.gI().arrItemBag[var4]);
                        }
                    } else if (Char.gI().arrItemBag[var4].getItemTemplate().type == 22) {
                        var3.add(Char.gI().arrItemBag[var4]);
                    }
                }
            }

            Collections.sort(var3, beatdz.Item.$state_Item().a);
            Item var5;
            int var7;
            if (!var1) {
                byte var8 = 60;
                if (SettingsTab.gI().o() >= 0) {
                    switch (SettingsTab.gI().o()) {
                        case 0:
                            var8 = 60;
                            break;
                        case 1:
                            var8 = 55;
                            break;
                        case 2:
                            var8 = 50;
                            break;
                        case 3:
                            var8 = 40;
                            break;
                        case 4:
                            var8 = 30;
                            break;
                        case 5:
                            var8 = 20;
                            break;
                        case 6:
                            var8 = 10;
                    }
                }

                for (var7 = var3.size() - 1; var7 >= 0; --var7) {
                    if ((var5 = (Item) var3.elementAt(var7)).getItemTemplate().levelNeed <= Char.gI().level() && var5.getItemTemplate().levelNeed <= var8) {
                        var2 = var5;
                    }
                }
            } else {
                boolean var9 = true;

                for (var7 = var3.size() - 1; var7 >= 0; --var7) {
                    if ((var5 = (Item) var3.elementAt(var7)).getItemTemplate().levelNeed <= Char.gI().level()) {
                        var2 = var5;
                        var9 = false;
                    }
                }

                if (var3.size() > 0 && var9) {
                    this.showMessage(Caption.gX, -1);
                }
            }
        } catch (Exception var6) {
        }

        return var2;
    }

    public static int v() {
        long var0 = 0;
        int var1 = 0;

        int var2;
        for (var2 = 0; var2 < Char.gI().arrItemBag.length; ++var2) {
            if (Char.gI().arrItemBag[var2] != null) {
                if (Char.gI().arrItemBag[var2].id == 176) {
                    var0 += Char.gI().arrItemBag[var2].getAmount();
                }

                if (Char.gI().arrItemBag[var2].id == 160 && !Char.gI().arrItemBag[var2].isLock) {
                    var1 += Char.gI().arrItemBag[var2].getAmount();
                }
            }
        }

        var2 = 0;
        if (var0 >= 2) {
            ++var2;
        }

        if (Char.gI().hoatLuc >= 5 && var1 > 0) {
            var2 += 2;
        }

        return var2;
    }

    public static int w() {
        short var0 = -1;

        try {
            Vector var1 = new Vector();

            int var2;
            for (var2 = 0; var2 < Char.gI().arrItemBag.length; ++var2) {
                if (Char.gI().arrItemBag[var2] != null && Char.gI().arrItemBag[var2].getItemTemplate().type == 22) {
                    var1.add(Char.gI().arrItemBag[var2]);
                }
            }

            Collections.sort(var1, beatdz.Item.$state_Item().a);
            if (var1.size() > 0) {
                var0 = ((Item) var1.firstElement()).getItemTemplate().idIcon;
            }

            for (var2 = var1.size() - 1; var2 >= 0; --var2) {
                Item var3;
                if ((var3 = (Item) var1.elementAt(var2)).getItemTemplate().levelNeed <= Char.gI().level()) {
                    var0 = var3.getItemTemplate().idIcon;
                }
            }
        } catch (Exception var4) {
        }

        return var0;
    }

    private Item i(boolean var1) {
        Item var2 = null;

        try {
            Vector var3 = new Vector();

            for (int var4 = 0; var4 < Char.gI().arrItemBag.length; ++var4) {
                if (Char.gI().arrItemBag[var4] != null && Char.gI().arrItemBag[var4].getItemTemplate().type == 23) {
                    var3.add(Char.gI().arrItemBag[var4]);
                }
            }

            Collections.sort(var3, beatdz.Item.$state_Item().a);
            Item var5;
            int var7;
            if (!var1) {
                byte var8 = 60;
                if (SettingsTab.gI().q() >= 0) {
                    switch (SettingsTab.gI().q()) {
                        case 0:
                            var8 = 60;
                            break;
                        case 1:
                            var8 = 55;
                            break;
                        case 2:
                            var8 = 50;
                            break;
                        case 3:
                            var8 = 40;
                            break;
                        case 4:
                            var8 = 30;
                            break;
                        case 5:
                            var8 = 20;
                            break;
                        case 6:
                            var8 = 10;
                    }
                }

                for (var7 = var3.size() - 1; var7 >= 0; --var7) {
                    if ((var5 = (Item) var3.elementAt(var7)).getItemTemplate().levelNeed <= Char.gI().level() && var5.getItemTemplate().levelNeed <= var8) {
                        var2 = var5;
                    }
                }
            } else {
                boolean var9 = true;

                for (var7 = var3.size() - 1; var7 >= 0; --var7) {
                    if ((var5 = (Item) var3.elementAt(var7)).getItemTemplate().levelNeed <= Char.gI().level()) {
                        var2 = var5;
                        var9 = false;
                    }
                }

                if (var3.size() > 0 && var9) {
                    this.showMessage(Caption.gX, -1);
                }
            }
        } catch (Exception var6) {
        }

        return var2;
    }

    public static int x() {
        short var0 = -1;

        try {
            Vector var1 = new Vector();

            int var2;
            for (var2 = 0; var2 < Char.gI().arrItemBag.length; ++var2) {
                if (Char.gI().arrItemBag[var2] != null && Char.gI().arrItemBag[var2].getItemTemplate().type == 23) {
                    var1.add(Char.gI().arrItemBag[var2]);
                }
            }

            Collections.sort(var1, beatdz.Item.$state_Item().a);
            if (var1.size() > 0) {
                var0 = ((Item) var1.firstElement()).getItemTemplate().idIcon;
            }

            for (var2 = var1.size() - 1; var2 >= 0; --var2) {
                Item var3;
                if ((var3 = (Item) var1.elementAt(var2)).getItemTemplate().levelNeed <= Char.gI().level()) {
                    var0 = var3.getItemTemplate().idIcon;
                }
            }
        } catch (Exception var4) {
        }

        return var0;
    }

    public void c(boolean var1) {
        if (Char.gI().j()) {
            if (var1) {
                Char.gI();
                Char.x();
            }

        } else if (this.bf <= 0 && !Char.gI().j() && (!Char.gI().g(6) || AutoPro.isAuto(10))) {
            Item var2;
            if ((var2 = this.h(var1)) != null) {
                this.bf = AutoPro.isAuto(10) ? 0 : 50;
                a(var2);
                if (Char.gI().hp < Char.gI().hpFull) {
                    LangLa_dp.a().j();
                }
            }

        }
    }

    public void d(boolean var1) {
        if (this.bh <= 0 && !Char.gI().j() && !Char.gI().g(0)) {
            Vector var4 = new Vector();

            int var2;
            for (var2 = 0; var2 < Char.gI().arrItemBag.length; ++var2) {
                if (Char.gI().arrItemBag[var2] != null && Char.gI().arrItemBag[var2].getItemTemplate().type == 24) {
                    var4.add(Char.gI().arrItemBag[var2]);
                }
            }

            Collections.sort(var4, beatdz.Item.$state_Item().a);

            for (var2 = 0; var2 < var4.size(); ++var2) {
                Item var3;
                if ((var3 = (Item) var4.elementAt(var2)).getItemTemplate().levelNeed <= Char.gI().level()) {
                    this.bh = 50;
                    a(var3);
                    return;
                }
            }

            var4.size();
        }
    }

    public void e(boolean var1) {
        if (this.bi <= 0 && !Char.gI().j()) {
            Char var10000 = Char.gI();
            var1 = true;
            Char var3 = var10000;
            int var4 = 0;

            boolean var7;
            while (true) {
                if (var4 >= var3.vEffect.size()) {
                    var7 = false;
                    break;
                }

                if (((Effect) var3.vEffect.elementAt(var4)).id == 47) {
                    var7 = true;
                    break;
                }

                ++var4;
            }

            if (!var7 && SettingsTab.gI().a[6] != -1) {
                Vector var5 = new Vector();

                int var2;
                Item var6;
                for (var2 = 0; var2 < Char.gI().arrItemBag.length; ++var2) {
                    if (Char.gI().arrItemBag[var2] != null && ((var6 = Char.gI().arrItemBag[var2]).id == 265 || var6.id == 285)) {
                        var5.add(Char.gI().arrItemBag[var2]);
                    }
                }

                Collections.sort(var5, beatdz.Item.$state_Item().a);

                for (var2 = 0; var2 < var5.size(); ++var2) {
                    if ((var6 = (Item) var5.elementAt(var2)).getItemTemplate().levelNeed <= Char.gI().level()) {
                        this.bi = 50;
                        a(var6);
                        return;
                    }
                }

                return;
            }
        }

    }

    public void f(boolean var1) {
        if (Char.gI().j()) {
            if (var1) {
                Char.gI();
                Char.x();
            }

        } else if (this.bg <= 0 && !Char.gI().j() && !Char.gI().g(7)) {
            Item var2;
            if ((var2 = this.i(var1)) != null) {
                this.bg = 50;
                a(var2);
                if (Char.gI().mp < Char.gI().mpFull) {
                    LangLa_dp.a().j();
                }
            }

        }
    }

    public void aw(Message var1) {
        try {
            Char var2;
            if ((var2 = this.f(var1.reader.dis.readInt())) != null) {
                short var3 = var1.reader.dis.readShort();
                EffectTemplate var5 = DataCenter.gI().EffectTemplate[var3];

                for (int var6 = 0; var6 < var2.vEffect.size(); ++var6) {
                    if (((Effect) var2.vEffect.elementAt(var6)).getEffectTemplate().type == var5.type) {
                        var2.vEffect.remove(var6);
                        break;
                    }
                }

                Effect var4 = new Effect(var3, var1.reader.dis.readInt(), var1.reader.dis.readLong(), var1.reader.dis.readInt(), var2);
                var2.addEffect(var4);
                if (var4.getEffectTemplate().type == 6) {
                    this.bf = 0;
                }

                if (var4.getEffectTemplate().type == 7) {
                    this.bg = 0;
                }

                if (var4.getEffectTemplate().type == 0) {
                    this.bh = 0;
                }

                if (var4.id == 59) {
                    var2.cy = (short) (var2.cy - 20);
                }

            }
        } catch (Exception var7) {
            Utlis.println(var7);
        }
    }

    public void ax(Message var1) {
        try {
            Char var2;
            if ((var2 = this.f(var1.reader.dis.readInt())) == null) {
                return;
            }

            short var6 = var1.reader.dis.readShort();
            int var4 = 0;

            while (true) {
                if (var4 >= var2.vEffect.size()) {
                    return;
                }

                if (((Effect) var2.vEffect.elementAt(var4)).id == var6) {
                    var2.vEffect.remove(var4);
                    break;
                }

                ++var4;
            }
        } catch (Exception var5) {
            Utlis.println(var5);
        }

    }

    public void ay(Message var1) {
        try {
            Mob var2 = this.r(var1.reader.dis.readShort());
            short var3 = var1.reader.dis.readShort();
            EffectTemplate var5 = DataCenter.gI().EffectTemplate[var3];

            for (int var6 = 0; var6 < var2.vEffect.size(); ++var6) {
                if (((Effect) var2.vEffect.elementAt(var6)).getEffectTemplate().type == var5.type) {
                    var2.vEffect.remove(var6);
                    break;
                }
            }

            Effect var4 = new Effect(var3, var1.reader.dis.readInt(), var1.reader.dis.readLong(), var1.reader.dis.readInt(), var2);
            var2.vEffect.add(var4);
        } catch (Exception var7) {
            Utlis.println(var7);
        }
    }

    public void az(Message var1) {
        try {
            Mob var2 = this.r(var1.reader.dis.readShort());
            if (gI().cL != null && gI().cL instanceof LangLa_lc) {
                LangLa_lc var3 = (LangLa_lc) gI().cL;

                for (int var4 = 0; var4 < var3.a.length; ++var4) {
                    var3.a[var4] = var1.reader.dis.readShort();
                }

                var3.a(var2);
            }

        } catch (Exception var6) {
            Utlis.println(var6);
        }
    }

    public void aA(Message var1) {
        try {
            this.r(var1.reader.dis.readShort()).status = 4;
        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    public Vector a(String[] var1) {
        Vector var2 = new Vector();
        byte var3 = 0;

        for (int var5 = 0; var5 < var1.length; ++var5) {
            String var4;
            String[] var6;
            if ((var6 = var1[var5].split("@")).length == 1) {
                var4 = var1[var5].replaceAll("#", Char.gI().name).replaceAll("\\$", DataCenter.gI().DataNameChar[Char.gI().idClass].name).replaceAll("\\*", Caption.sw[Char.gI().gioiTinh]).replaceAll("\\&", Caption.sx[Char.gI().gioiTinh]).replaceAll("\\^", Caption.sy[Char.gI().gioiTinh]).replaceAll("\\%", Caption.sz[Char.gI().gioiTinh]).replaceAll("\\~", Caption.sA[Char.gI().gioiTinh]).replaceAll("\\_", Caption.sB[var3]);
                var2.addElement(new LangLa_ke(Char.gI().aE, var4, (byte) 1));
            } else {
                var4 = (var4 = var6[1]).replaceAll("#", Char.gI().name).replaceAll("\\$", DataCenter.gI().DataNameChar[Char.gI().idClass].name).replaceAll("\\*", Caption.sw[Char.gI().gioiTinh]).replaceAll("\\&", Caption.sx[Char.gI().gioiTinh]).replaceAll("\\^", Caption.sy[Char.gI().gioiTinh]).replaceAll("\\%", Caption.sz[Char.gI().gioiTinh]).replaceAll("\\~", Caption.sA[Char.gI().gioiTinh]).replaceAll("\\_", Caption.sB[var3]);
                int var7 = -1;
                if (var6[0].equals("%")) {
                    switch (Char.gI().idClass) {
                        case 1:
                            var7 = 4;
                            var3 = 1;
                            break;
                        case 2:
                            var7 = 7;
                            var3 = 1;
                            break;
                        case 3:
                            var7 = 6;
                            var3 = 0;
                            break;
                        case 4:
                            var7 = 8;
                            var3 = 1;
                            break;
                        case 5:
                            var7 = 5;
                            var3 = 1;
                    }
                } else {
                    var7 = Integer.parseInt(var6[0]);
                }

                Npc var8 = this.e(var7);
                var2.addElement(new LangLa_ke(var8.getNpcTemplate().b[0], var4, (byte) 0));
            }
        }

        return var2;
    }

    public void aB(Message var1) {
        try {
            String var3 = var1.reader.readUTF();
            this.a((LangLa_cx) (new LangLa_bo(this, this.a(Utlis.split(var3, "\\n")), -10)));
        } catch (Exception var2) {
        }
    }

    public static void aC(Message var0) {
        try {
            LangLa_cx var1;
            if ((var1 = gI().H()) instanceof LangLa_by) {
                ((LangLa_by) var1).J();
            } else if (var1 instanceof LangLa_kh) {
                ((LangLa_kh) var1).J();
            }

            byte var5 = var0.reader.dis.readByte();

            for (int var2 = 0; var2 < var5; ++var2) {
                Char.gI().arrItemBag[var0.reader.dis.readShort()] = null;
            }

        } catch (Exception var4) {
            Utlis.println(var4);
        }
    }

    public void aD(Message var1) {
        try {
            Char var6;
            if ((var6 = this.f(var1.reader.dis.readInt())) != null) {
                var6.aP = -1;
                this.bl = 1000;
                if (var6.isMe()) {
                    for (int var7 = gI().cD.size() - 1; var7 >= 0; --var7) {
                        LangLa_cx var2;
                        if ((var2 = (LangLa_cx) gI().cD.get(var7)) instanceof LangLa_az) {
                            LangLa_az var8;
                            (var8 = (LangLa_az) var2).J();
                            if (var8.c == 4 && var8.f instanceof LangLa_fd) {
                                LangLa_fd var3 = (LangLa_fd) var8.f;
                                DataCenter.gI().aH = false;
                                var3.e();
                                this.a((LangLa_cx) var8.f);
                            }
                        }
                    }

                    gI().J();
                    DataCenter.gI().aH = false;
                }

            }
        } catch (Exception var5) {
            Utlis.println(var5);
        }
    }

    public void aE(Message var1) {
        try {
            Mob var2 = this.r(var1.reader.dis.readShort());
            short var6 = var1.reader.dis.readShort();
            int var4 = 0;

            while (true) {
                if (var4 >= var2.vEffect.size()) {
                    return;
                }

                if (((Effect) var2.vEffect.elementAt(var4)).id == var6) {
                    var2.vEffect.remove(var4);
                    break;
                }

                ++var4;
            }
        } catch (Exception var5) {
            Utlis.println(var5);
        }

    }

    public void aF(Message var1) {
        try {
            Char var2;
            if ((var2 = this.f(var1.reader.dis.readInt())) != null) {
                var2.hp = var2.hpFull = var1.reader.dis.readInt();
                var2.mp = var2.mpFull = var1.reader.dis.readInt();
                var2.N();
                LangLa_cx var5;
                if ((var5 = gI().H()) instanceof LangLa_b) {
                    ((LangLa_b) var5).J();
                }

            }
        } catch (Exception var4) {
            Utlis.println(var4);
        }
    }

    public void aG(Message var1) {
        try {
            Char var2 = this.s(var1.reader.dis.readInt());
            var2.arrItemBody = Char.readItemBody(var1, var2.arrItemBody);
            var2.aK = null;
        } catch (Exception var3) {
            Utlis.println(var3);
        }
    }

    public static void c(String var0) {
        try {
            Message var1;
            (var1 = new Message((byte) 41)).writeUTF(var0);
            var1.send();
        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    public static void d(String var0) {
        try {
            LangLa_t var1;
            (var1 = new LangLa_t(gI())).a(var0);
            gI().a((LangLa_cx) var1);
        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    public static void e(String var0) {
        try {
            Message var1;
            (var1 = new Message((byte) 79)).writeUTF(var0);
            var1.send();
        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    public static void f(String var0) {
        try {
            Message var1;
            (var1 = Message.c((byte) -54)).writeUTF(var0);
            var1.send();
        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    private static void d(LangLa_eo var0) {
        try {
            Message var1;
            (var1 = Message.c((byte) -49)).writeShort(var0.d);
            var1.writeShort(var0.a);
            if (var0.b >= 0) {
                var1.writeShort(var0.b);
            } else {
                var1.writeShort(var0.c);
            }

            var1.writeShort(var0.e);
            var1.writeShort(var0.f);
            var1.send();
        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    public static void g(String var0) {
        try {
            Message var1;
            (var1 = Message.c((byte) -52)).writeUTF(var0);
            var1.send();
        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    public static void h(String var0) {
        try {
            Message var1;
            (var1 = new Message((byte) 34)).writeUTF(var0);
            var1.send();
        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    public static void i(String var0) {
        try {
            Message var1;
            (var1 = new Message((byte) 39)).writeUTF(var0);
            var1.send();
        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    public void j(String var1) {
        try {
            if (!(this.cD.lastElement() instanceof LangLa_az) || this.vItemMapPickUp.lastElement() == null || ((ItemMap) this.vItemMapPickUp.lastElement()).item.id != 223 || !SettingsTab.gI().y()) {
                Message var2;
                (var2 = new Message((byte) 86)).writeUTF(var1);
                var2.send();
            }
        } catch (Exception var3) {
            Utlis.println(var3);
        }
    }

    public void aH(Message var1) {
        try {
            this.aI.a.clear();
            this.aI.b = var1.reader.dis.readBoolean();
            short var2 = var1.reader.readUnsignedByte();

            for (int var3 = 0; var3 < var2; ++var3) {
                LangLa_ey var4;
                (var4 = new LangLa_ey()).b = var1.reader.dis.readByte();
                byte var6 = var1.reader.dis.readByte();
                var4.c = var6;
                var4.d = var1.reader.dis.readShort();
                var4.a = var1.reader.readUTF();
                this.aI.a.addElement(var4);
            }

            LangLa_cx var8;
            if ((var8 = this.H()) instanceof LangLa_ca) {
                LangLa_ca var9;
                (var9 = (LangLa_ca) var8).g();
            }

            if (this.Y != null && this.aI != null) {
                this.Y.b(this.aI.b());
            }

        } catch (Exception var7) {
            Utlis.println(var7);
        }
    }

    public void aI(Message var1) {
        try {
            Char var2;
            if ((var2 = this.f(var1.reader.dis.readInt())) == null) {
                return;
            }

            Char var10000 = var2;
            Message var7 = var1;
            Char var6 = var10000;

            try {
                String var3;
                if ((var3 = var7.reader.readUTF()).length() > 0) {
                    var6.aI = new LangLa_hf();
                    var6.aI.a = var3;
                    var6.aI.b = var7.reader.readUTF();
                    var6.aI.c = var7.reader.dis.readByte();
                } else {
                    var6.aI = null;
                }

                var6.U();
            } catch (Exception var4) {
                return;
            }
        } catch (Exception var5) {
            Utlis.println(var5);
        }

    }

    public void aJ(Message var1) {
        try {
            beatdz.GameSrc.$state_GameSrc().aJ = var1.reader.readUTF();
            short var2 = var1.reader.dis.readShort();
            int var5 = var1.reader.dis.readInt();
            DataCenter.gI().currentScreen.a(beatdz.GameSrc.$state_GameSrc().aJ + Caption.hn + var2 + Caption.ho + Utlis.numberFormat(var5) + Caption.la, Caption.bz, 2987, 2988, this);
        } catch (Exception var4) {
            Utlis.println(var4);
        }
    }

    public void aK(Message var1) {
        try {
            if (!(this.cD.lastElement() instanceof LangLa_az) || this.vItemMapPickUp.lastElement() == null || ((ItemMap) this.vItemMapPickUp.lastElement()).item.id != 223 || !SettingsTab.gI().y()) {
                beatdz.GameSrc.$state_GameSrc().aJ = var1.reader.readUTF();
                String var2 = var1.reader.readUTF();
                byte var6 = var1.reader.dis.readByte();
                String var3 = "";
                if (var6 == 5) {
                    var3 = Caption.ds;
                } else if (var6 == 4) {
                    var3 = Caption.dt;
                } else if (var6 == 3) {
                    var3 = Caption.du;
                }

                DataCenter.gI().currentScreen.a(beatdz.GameSrc.$state_GameSrc().aJ + Caption.hp + var3 + Caption.hq + var2 + Caption.hr, Caption.bz, 2985, 2986, this);
            }
        } catch (Exception var5) {
            Utlis.println(var5);
        }
    }

    public void aL(Message var1) {
        try {
            Char var2;
            if ((var2 = this.f(var1.reader.dis.readInt())) == null) {
                return;
            }

            var2.typePK = var1.reader.dis.readByte();
            Char var3;
            if ((var3 = this.f(var1.reader.dis.readInt())) == null) {
                return;
            }

            var3.typePK = var1.reader.dis.readByte();
            boolean var5;
            if (var2.idEntity != Char.gI().idEntity) {
                if (var3.idEntity == Char.gI().idEntity) {
                    var3.idCharPk = var2.idEntity;
                    DataCenter.gI().currentScreen.showMessage(var2.name + Caption.hs, -2560);
                    this.aA = var2;
                    var5 = true;
                    this.ap = var5;
                }

                return;
            }

            var2.idCharPk = var3.idEntity;
            DataCenter.gI().currentScreen.showMessage(var3.name + Caption.hs, -2560);
            this.aA = var3;
            var5 = true;
            this.ap = var5;
        } catch (Exception var6) {
            Utlis.println(var6);
        }

    }

    public void aM(Message var1) {
        try {
            Char var2 = this.f(var1.reader.dis.readInt());
            Char var6 = this.f(var1.reader.dis.readInt());
            if (var2 == null || var6 == null) {
                return;
            }

            String var3;
            boolean var7;
            if (var2.idEntity != Char.gI().idEntity) {
                if (var6.idEntity == Char.gI().idEntity) {
                    var2.isCuuSat = true;
                    var3 = var2.name + Caption.hu;
                    LangLa_kw.a(7, Caption.bz, var3);
                    DataCenter.gI().currentScreen.showMessage(var3, -2560);
                    this.aA = var2;
                    var7 = true;
                    this.ap = var7;
                }

                return;
            }

            var2.idCharPk = var6.idEntity;
            var3 = Caption.ht + var6.name + ".";
            LangLa_kw.a(7, Caption.bz, var3);
            DataCenter.gI().currentScreen.showMessage(var3, -2560);
            this.aA = var6;
            var7 = true;
            this.ap = var7;
        } catch (Exception var5) {
            Utlis.println(var5);
        }

    }

    public static void aN(Message var0) {
        try {
            short var4 = var0.reader.dis.readShort();
            int var1 = 0;

            while (true) {
                if (var1 >= gI().aE.size()) {
                    return;
                }

                Skill var2;
                if ((var2 = (Skill) gI().aE.elementAt(var1)).id == var4) {
                    var2.e();
                    break;
                }

                ++var1;
            }
        } catch (Exception var3) {
            Utlis.println(var3);
        }

    }

    public void aO(Message var1) {
        try {
            Char.gI().readSkill(var1);
            gI().g();
            LangLa_cx var3;
            if ((var3 = this.H()) instanceof LangLa_kl) {
                LangLa_kl var4;
                (var4 = (LangLa_kl) var3).z = gI().p;
            }

        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    public void aP(Message var1) {
        try {
            Char var2 = this.f(var1.reader.dis.readInt());
            boolean var5 = var1.reader.dis.readBoolean();
            String var6;
            if (var2.idEntity == Char.gI().idEntity) {
                var2.idCharPk = -1;
                if (var5) {
                    var6 = Caption.hv;
                    LangLa_kw.a(7, Caption.bz, var6);
                    this.showMessage(var6, -2560);
                    return;
                }
            } else {
                var2.isCuuSat = false;
                if (var5) {
                    var6 = var2.name + Caption.hw;
                    LangLa_kw.a(7, Caption.bz, var6);
                    this.showMessage(var6, -2560);
                }
            }

        } catch (Exception var4) {
            Utlis.println(var4);
        }
    }

    public void aQ(Message var1) {
        try {
            byte var2 = var1.reader.dis.readByte();
            Char var3 = this.f(var1.reader.dis.readInt());
            Char var6 = this.f(var1.reader.dis.readInt());
            String var4 = "";
            if (var2 == 1) {
                var3.q = var6.q = var2;
                if (var3 != null && var6 != null) {
                    var4 = var3.name + Caption.hx + var6.name + Caption.hy;
                }
            } else if (var2 == 2) {
                var3.q = 2;
                var6.q = 3;
                if (var3 != null && var6 != null) {
                    var4 = var3.name + Caption.hz + var6.name + ".";
                }
            } else if (var2 == 3) {
                var3.q = 3;
                var6.q = 2;
                if (var3 != null && var6 != null) {
                    var4 = var6.name + Caption.hz + var3.name + ".";
                }
            }

            if (var3 != null) {
                var3.C = Utlis.currentTimeSeconds() + 5;
                var3.typePK = 0;
                var3.idCharPk = -1;
            }

            if (var6 != null) {
                var6.C = Utlis.currentTimeSeconds() + 5;
                var6.typePK = 0;
                var6.idCharPk = -1;
            }

            if (var3 != null && var6 != null) {
                LangLa_kw.a(0, Caption.bz, var4);
            }

        } catch (Exception var5) {
            Utlis.println(var5);
        }
    }

    public void aR(Message var1) {
        try {
            LangLa_cx var2;
            if ((var2 = this.H()) instanceof LangLa_ca) {
                LangLa_ca var10;
                (var10 = (LangLa_ca) var2).g.clear();
                byte var3 = var1.reader.dis.readByte();

                for (int var4 = 0; var4 < var3; ++var4) {
                    LangLa_lj var5;
                    (var5 = new LangLa_lj()).b = var1.reader.dis.readBoolean();
                    var5.c = var1.reader.dis.readByte();
                    LangLa_ey var6;
                    (var6 = new LangLa_ey()).b = var1.reader.dis.readByte();
                    byte var8 = var1.reader.dis.readByte();
                    var6.c = var8;
                    var6.d = var1.reader.dis.readShort();
                    var6.a = var1.reader.readUTF();
                    var5.a.addElement(var6);
                    var10.g.addElement(var5);
                }

                var10.g();
            }

        } catch (Exception var9) {
        }
    }

    public boolean k(String var1) {
        for (int var3 = 0; var3 < this.vFriend.size(); ++var3) {
            Friend var2;
            if ((var2 = (Friend) this.vFriend.elementAt(var3)).b != 2 && var2.c.equals(var1)) {
                return true;
            }
        }

        return false;
    }

    public void aS(Message var1) {
        try {
            Char var2;
            (var2 = new Char()).name = var1.reader.readUTF();
            var2.exp = var1.reader.dis.readLong();
            var2.idChar = var1.reader.dis.readByte();
            var2.idhe = var1.reader.dis.readByte();
            var2.idClass = var1.reader.dis.readByte();
            var2.gioiTinh = var1.reader.dis.readByte();
            var2.sachChienDau = var1.reader.dis.readByte();
            var2.arrItemBody = Char.readItemBody(var1, var2.arrItemBody);
            var2.arrItemBody2 = Char.readItemBody(var1, var2.arrItemBody2);
            Skill[] var3 = new Skill[var1.reader.dis.readShort()];

            for (int var4 = 0; var4 < var3.length; ++var4) {
                short var5 = var1.reader.dis.readShort();
                Skill var9 = DataCenter.gI().Skill[var5].cloneSkill();
                var3[var4] = var9;
            }

            String var8;
            if ((var8 = var1.reader.readUTF()).length() > 0) {
                var2.aI = new LangLa_hf();
                var2.aI.a = var8;
                var2.aI.b = var1.reader.readUTF();
                var2.aI.c = var1.reader.dis.readByte();
            }

            var2.readDanhHieu(var1);
            var2.selectDanhHieu = (byte) (var1.reader.dis.readByte() + 1);
            var2.selectCaiTrang = var1.reader.dis.readByte();
            var2.readSkillClan(var1);

            try {
                var2.aW = var1.reader.dis.readByte();
                var2.aX = var1.reader.dis.readByte();
                var2.aY = var1.reader.dis.readInt();
                var2.bd = var1.reader.dis.readByte();
                var2.ba = var1.reader.dis.readByte();
            } catch (Exception var6) {
            }

            var2.t();
            Arrays.sort(var3, beatdz.Skill.$state_Skill().a);
            this.a((LangLa_cx) (new LangLa_kl(this, var2, var3)));
        } catch (Exception var7) {
            Utlis.println(var7);
        }
    }

    public void aT(Message var1) {
        try {
            Char var2;
            (var2 = this.f(var1.reader.dis.readInt())).lvPk = var1.reader.dis.readByte();
            var2.taiPhu = var1.reader.dis.readInt();
            var2.speedMove = Char.movementSpeed(var1.reader.dis.readShort());
            var2.statusGD = var1.reader.dis.readByte();
        } catch (Exception var4) {
            Utlis.println(var4);
        }
    }

    public void aU(Message var1) {
        try {
            Char var2 = Char.gI();
            gI().diemTiemNang = var1.reader.dis.readShort();
            gI().diemKyNang = var1.reader.dis.readShort();
            var2.I = var1.reader.dis.readByte();
            var2.J = var1.reader.dis.readByte();
            var2.K = var1.reader.dis.readByte();
            var2.L = var1.reader.dis.readBoolean();
            gI().pointNAP = var1.reader.dis.readInt();
            if (this.ak != null) {
                this.ak.d();
            }

        } catch (Exception var4) {
            Utlis.println(var4);
        }
    }

    public void aV(Message var1) {
        try {
            String var2 = var1.reader.readUTF();
            String var7 = var1.reader.readUTF();
            LangLa_kw.a(0, var2, var7);
            String var3 = var2;
            GameSrc var8 = this;
            Char var10000;
            if (Char.gI().name.equals(var2)) {
                var10000 = Char.gI();
            } else {
                int var5 = 0;

                while (true) {
                    if (var5 >= var8.vChar.size()) {
                        var10000 = null;
                        break;
                    }

                    Char var4;
                    if ((var4 = (Char) var8.vChar.elementAt(var5)).name.equals(var3)) {
                        var10000 = var4;
                        break;
                    }

                    ++var5;
                }
            }

            Char var9 = var10000;
            if (var10000 != null) {
                var9.aJ = new LangLa_ih(var7);
            }

        } catch (Exception var6) {
        }
    }

    public static void aW(Message var0) {
        try {
            String var1 = var0.reader.readUTF();
            String var4 = var0.reader.readUTF();
            var4 = ":-loa" + var4;
            MainScreen var10000;
            if (var1.toLowerCase().equals(Caption.bK.toLowerCase())) {
                var10000 = DataCenter.gI().currentScreen;
                MainScreen.d("c#yellow" + var4, -7812062);
            } else {
                var10000 = DataCenter.gI().currentScreen;
                MainScreen.d(var1 + ": c#white" + var4, -7812062);
            }

            LangLa_kw.a(8, var1, var4);
        } catch (Exception var3) {
        }
    }

    public static void aX(Message var0) {
        try {
            String var1 = var0.reader.readUTF();
            String var4 = var0.reader.readUTF();
            LangLa_kw.a(2, var1, var4);
        } catch (Exception var3) {
        }
    }

    public static void aY(Message var0) {
        try {
            String var1 = var0.reader.readUTF();
            String var4 = var0.reader.readUTF();
            LangLa_kw.a(3, var1, var4);
        } catch (Exception var3) {
        }
    }

    public static void aZ(Message var0) {
        try {
            String var1 = var0.reader.readUTF();
            String var4 = var0.reader.readUTF();
            LangLa_kw.a(4, var1, var4);
        } catch (Exception var3) {
        }
    }

    public static void ba(Message var0) {
        try {
            String var1 = var0.reader.readUTF();
            String var4 = var0.reader.readUTF();
            LangLa_kw.a(5, var1, var4);
        } catch (Exception var3) {
        }
    }

    public static void bb(Message var0) {
        try {
            String var1 = var0.reader.readUTF();
            String var4 = var0.reader.readUTF();
            LangLa_kw.a(7, var1, var4);
        } catch (Exception var3) {
        }
    }

    public static void bc(Message var0) {
        try {
            String var1 = var0.reader.readUTF();
            String var2 = var0.reader.readUTF();
            String var3 = "";

            try {
                var3 = var0.reader.readUTF();
            } catch (Exception var5) {
                beatdz.GameSrc.$state_GameSrc().aL = "";
                beatdz.LangLa_kw.$state_LangLa_kw().d = "";
            }

            if (var3.length() > 0 && beatdz.GameSrc.$state_GameSrc().aL.length() > 0 && (var3.equals(beatdz.GameSrc.$state_GameSrc().aL) || var1.equals(beatdz.GameSrc.$state_GameSrc().aL))) {
                beatdz.LangLa_kw.$state_LangLa_kw().d = beatdz.GameSrc.$state_GameSrc().aL;
            }

            LangLa_kw.a(6, var1, var2, (String) var3);
        } catch (Exception var6) {
        }
    }

    public void y() {
        try {
            this.aj.a();
            this.aj.e();
            this.ai.b.b = this.ai.e();
            if (this.aM != null) {
                this.aM.l();
            }

        } catch (Exception var1) {
        }
    }

    public boolean a(Char var1) {
        boolean var2 = this.E();

        int var3;
        Effect var4;
        for (var3 = 0; var3 < Char.gI().vEffect.size(); ++var3) {
            if ((var4 = (Effect) Char.gI().vEffect.elementAt(var3)).id == 46 || !var2 && var4.id == 66) {
                return false;
            }
        }

        for (var3 = 0; var3 < var1.vEffect.size(); ++var3) {
            if ((var4 = (Effect) var1.vEffect.elementAt(var3)).id == 46 || !var2 && var4.id == 66 && var1.typePK == 0) {
                return false;
            }
        }

        if (var1.status != 4 && var1.status != 6 && var1.status != 5) {
            if (!var1.isCuuSat && Char.gI().idCharPk != var1.idEntity) {
                if ((var1.typePK == 2 && Char.gI().typePK == 2 || var1.typePK == 3 || Char.gI().typePK == 3) && (this.aI == null || !this.aI.b(var1.name))) {
                    if (gI().getMapTemplate().type == 6 || gI().getMapTemplate().type == 7 || gI().getMapTemplate().type == 10) {
                        return true;
                    }

                    if (var1.aI == null || Char.gI().aI == null || !var1.aI.a.equals(Char.gI().aI.a)) {
                        if (Utlis.positive(Char.gI().level() - var1.level()) <= 10 && Char.gI().idClass != 0 && var1.idClass != 0 && Char.gI().level() >= 15 && var1.level() >= 15) {
                            return true;
                        }

                        return false;
                    }
                }

                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public void a(Entity var1) {
        this.K.add(var1);
    }

    public void a(String var1, LangLa_ko var2) {
        try {
            beatdz.LangLa_kw.$state_LangLa_kw().d = var1;
            var2.j.a(1);
            var2.l();
            LangLa_cx var3;
            if ((var3 = this.H()) != null && !var3.equals(var2)) {
                gI().a((LangLa_cx) var2);
            }

            var2.i.a((LangLa_jz) (new LangLa_jz(-1001, 0, 0, 0, 0, (LangLa_ii) null, (LangLa_cy) null)), var2.i.width, 0);
            var2.i.a("/" + var1 + ": ");
        } catch (Exception var4) {
            Utlis.println(var4);
        }
    }

    public void bd(Message var1) {
        DataCenter.gI();

        try {
            Char var2;
            if ((var2 = this.f(var1.reader.dis.readInt())) != null) {
                short var3 = var1.reader.dis.readShort();
                short var4 = var1.reader.dis.readShort();
                var2.cleanVecMove();
                var2.l();
                if (var2.isMe()) {
                    var2.cleanMove();
                    beatdz.SessionMove.$state_SessionMove().x = var3;
                    beatdz.SessionMove.$state_SessionMove().y = var4;
                }

                var2.cx = var3;
                var2.cy = var4;
                if (var2.isMe()) {
                    this.stopLoadMap();
                }

            }
        } catch (Exception var5) {
            Utlis.println(var5);
        }
    }

    public void loadAfterNextMap() {
        try {
            if (gI().B().id == 17) {
                if (Char.gI().idChar != 0 && Char.gI().idChar != 5) {
                    if (Char.gI().idChar != 1 && Char.gI().idChar != 6) {
                        if (Char.gI().idChar != 2 && Char.gI().idChar != 7) {
                            if (Char.gI().idChar != 3 && Char.gI().idChar != 8) {
                                if (Char.gI().idChar == 4) {
                                    gI().B().idNpc = 5;
                                }
                            } else {
                                gI().B().idNpc = 8;
                            }
                        } else {
                            gI().B().idNpc = 6;
                        }
                    } else {
                        gI().B().idNpc = 7;
                    }
                } else {
                    gI().B().idNpc = 4;
                }
            }
        } catch (Exception var6) {
        }

        try {
            Npc var2;
            for (int var1 = 0; var1 < this.vNpc.size(); ++var1) {
                for (int var3 = (var2 = (Npc) this.vNpc.elementAt(var1)).l.size() - 1; var3 >= 0; --var3) {
                    LangLa_jw var4;
                    if ((var4 = (LangLa_jw) var2.l.get(var3)).j == 112 || var4.j == 113) {
                        var2.l.remove(var4);
                    }
                }
            }

            Task var7;
            if ((var7 = this.A()) != null) {
                if (this.idStep < 0) {
                    if ((var2 = this.e(var7.idNpc)) != null) {
                        var2.l.addElement(new LangLa_jw(112, 0, 0, -1));
                        return;
                    }
                } else if (this.idStep >= var7.vStep.size()) {
                    if ((var2 = this.e(var7.idNpc)) != null) {
                        var2.l.addElement(new LangLa_jw(113, 0, 0, -1));
                        return;
                    }
                } else {
                    Step var8;
                    if ((var8 = this.B()) != null && var8.idNpc > 0 && (var2 = this.e(var8.idNpc)) != null) {
                        var2.l.addElement(new LangLa_jw(112, 0, 0, -1));
                    }
                }
            }

        } catch (Exception var5) {
        }
    }

    public void be(Message var1) {
        try {
            byte var2 = var1.reader.dis.readByte();
            byte var3 = var1.reader.dis.readByte();
            LangLa_jd var4;
            switch (var2) {
                case 0:
                    if (var3 < 0) {
                        this.aS = null;
                        Char.gI().aF.addElement(new LangLa_jw(105, 0, 0, 2));
                    } else {
                        if (this.aS == null) {
                            Char.gI().aF.addElement(new LangLa_jw(105, 0, 0, 2));
                        }

                        (var4 = new LangLa_jd(var2)).b = var3;
                        var4.c = var1.reader.dis.readShort();
                        var4.d = var1.reader.dis.readShort();
                        var4.e = var1.reader.dis.readShort();
                        var4.f = var1.reader.dis.readShort();
                        var4.g = var1.reader.dis.readShort();
                        var4.h = var1.reader.dis.readShort();
                        var4.i = var1.reader.dis.readShort();
                        var4.j = var1.reader.dis.readShort();
                        var4.k = var1.reader.readUTF();
                        var4.l = var1.reader.readUTF();
                        var4.m = var1.reader.readUTF();
                        this.aS = var4;
                        if (var4.a()) {
                            Char.gI().aF.addElement(new LangLa_jw(85, 0, 0));
                        }
                    }

                    if (this.aS != null) {
                        beatdz.LangLa_mg.$state_LangLa_mg().d = var2;
                        this.ak.c(true);
                        if (this.aS.a()) {
                            gI();
                        }
                    }
                    break;
                case 1:
                    if (var3 < 0) {
                        this.aT = null;
                        Char.gI().aF.addElement(new LangLa_jw(105, 0, 0, 2));
                    } else {
                        if (this.aT == null) {
                            Char.gI().aF.addElement(new LangLa_jw(105, 0, 0, 2));
                        }

                        (var4 = new LangLa_jd(var2)).b = var3;
                        var4.c = var1.reader.dis.readByte();
                        var4.f = var1.reader.dis.readShort();
                        var4.g = var1.reader.dis.readShort();
                        var4.h = var1.reader.dis.readShort();
                        var4.i = var1.reader.dis.readShort();
                        var4.m = var1.reader.readUTF();
                        this.aT = var4;
                        if (var4.a()) {
                            Char.gI().aF.addElement(new LangLa_jw(85, 0, 0));
                        }
                    }

                    if (this.aT != null) {
                        beatdz.LangLa_mg.$state_LangLa_mg().d = var2;
                        this.ak.c(true);
                        if (this.aT.a()) {
                            gI();
                        }
                    }
                    break;
                case 2:
                    if (var3 < 0) {
                        this.aX = null;
                        Char.gI().aF.addElement(new LangLa_jw(105, 0, 0, 2));
                    } else {
                        if (this.aX == null) {
                            Char.gI().aF.addElement(new LangLa_jw(105, 0, 0, 2));
                        }

                        LangLa_lh var6;
                        (var6 = new LangLa_lh(var3)).b = var1.reader.dis.readShort();
                        var6.c = var1.reader.dis.readBoolean();
                        this.aX = var6;
                        if (var6.b() && !var6.c) {
                            Char.gI().aF.addElement(new LangLa_jw(85, 0, 0));
                        }
                    }

                    if (this.aX != null) {
                        beatdz.LangLa_mg.$state_LangLa_mg().d = var2;
                        this.ak.c(true);
                        if (this.aX.b()) {
                            gI();
                        }
                    }
                    break;
                case 3:
                    if (var3 < 0) {
                        this.aU = null;
                        Char.gI().aF.addElement(new LangLa_jw(105, 0, 0, 2));
                    } else {
                        (var4 = new LangLa_jd(var2)).g = 86;
                        var4.j = var1.reader.dis.readByte();
                        var4.c = var1.reader.dis.readByte();
                        var4.e = var1.reader.dis.readShort();
                        this.aU = var4;
                        if (var4.a()) {
                            Char.gI().aF.addElement(new LangLa_jw(85, 0, 0));
                        } else {
                            Char.gI().aF.addElement(new LangLa_jw(105, 0, 0, 2));
                        }
                    }

                    if (this.aU != null) {
                        beatdz.LangLa_mg.$state_LangLa_mg().d = var2;
                        this.ak.c(true);
                        if (this.aU.a()) {
                            gI();
                        }
                    }
                    break;
                case 4:
                    if (var3 < 0) {
                        this.aV = null;
                        Char.gI().aF.addElement(new LangLa_jw(105, 0, 0, 2));
                    } else {
                        (var4 = new LangLa_jd(var2)).j = var1.reader.dis.readByte();
                        var4.c = var1.reader.dis.readByte();
                        var4.e = var1.reader.dis.readShort();
                        this.aV = var4;
                        if (var4.a()) {
                            Char.gI().aF.addElement(new LangLa_jw(85, 0, 0));
                        } else {
                            Char.gI().aF.addElement(new LangLa_jw(105, 0, 0, 2));
                        }
                    }

                    if (this.aV != null) {
                        beatdz.LangLa_mg.$state_LangLa_mg().d = var2;
                        this.ak.c(true);
                        if (this.aV.a()) {
                            gI();
                        }
                    }
                    break;
                case 5:
                    if (var3 < 0) {
                        this.aW = null;
                        Char.gI().aF.addElement(new LangLa_jw(105, 0, 0, 2));
                    } else {
                        (var4 = new LangLa_jd(var2)).j = 1;
                        var4.c = var1.reader.dis.readByte();
                        var4.f = var1.reader.dis.readShort();
                        this.aW = var4;
                        if (var4.a()) {
                            Char.gI().aF.addElement(new LangLa_jw(85, 0, 0));
                        } else {
                            Char.gI().aF.addElement(new LangLa_jw(105, 0, 0, 2));
                        }
                    }

                    if (this.aW != null) {
                        beatdz.LangLa_mg.$state_LangLa_mg().d = var2;
                        this.ak.c(true);
                        if (this.aW.a()) {
                            gI();
                        }
                    }
            }

            this.ak.d();
        } catch (Exception var5) {
        }
    }

    public void bf(Message var1) {
        try {
            LangLa_cx var2;
            if ((var2 = this.H()) instanceof LangLa_u) {
                LangLa_u var11;
                LangLa_u var10000 = var11 = (LangLa_u) var2;
                Message var12 = var1;
                LangLa_u var10 = var10000;

                try {
                    short var3 = var12.reader.readUnsignedByte();
                    var10.b = var12.reader.readUnsignedByte();
                    var10.c = var12.reader.readUnsignedByte();
                    LangLa_lu[] var13 = new LangLa_lu[var3];

                    for (int var4 = 0; var4 < var13.length; ++var4) {
                        var13[var4] = new LangLa_lu(0);
                    }

                    short var14 = var12.reader.readUnsignedByte();

                    for (int var5 = 0; var5 < var14; ++var5) {
                        try {
                            var13[var12.reader.readUnsignedByte()].a = var12.reader.readUnsignedByte();
                        } catch (Exception var7) {
                        }
                    }

                    var10.a = var13;
                    var10.e();
                    return;
                } catch (Exception var8) {
                }
            }

        } catch (Exception var9) {
        }
    }

    public void bg(Message var1) {
        try {
            this.ak.c(false);
            int var2 = this.idStep;
            this.Task = var1.reader.dis.readShort();
            this.idStep = var1.reader.dis.readByte();
            this.idRequire = var1.reader.dis.readUnsignedShort();
            this.loadAfterNextMap();
            if (var2 != this.idStep) {
                Task var5;
                if ((var5 = this.A()) != null && this.idStep >= var5.vStep.size()) {
                    Char.gI().aF.addElement(new LangLa_jw(85, 0, 0));
                } else {
                    Char.gI().aF.addElement(new LangLa_jw(105, 0, 0, 2));
                }
            }

            Step var6 = gI().B();
            LangLa_cx var7;
            if ((var7 = this.H()) instanceof LangLa_bz) {
                LangLa_bz var8;
                (var8 = (LangLa_bz) var7).e();
                var8.f();
            }

            this.ak.d();
            if (AppListener.gI().listener != null && this.Task == 15 && this.idStep == -1) {
                SDKListener var10000 = AppListener.gI().listener;
            }

            if (var6 != null) {
                gI();
            }

        } catch (Exception var4) {
        }
    }

    public Task A() {
        try {
            if (this.Task < DataCenter.gI().Task.length) {
                return DataCenter.gI().Task[gI().Task];
            }
        } catch (Exception var2) {
            Utlis.println(var2);
        }

        return null;
    }

    public Step B() {
        try {
            Task var1;
            if ((var1 = this.A()) != null && Char.gI().level() >= var1.levelNeed && gI().idStep >= 0 && gI().idStep < var1.vStep.size()) {
                return (Step) var1.vStep.elementAt(gI().idStep);
            }
        } catch (Exception var2) {
            Utlis.println(var2);
        }

        return null;
    }

    private static void a(Mob var0) {
        try {
            Message var1;
            (var1 = new Message((byte) -8)).writeShort(var0.idEntity);
            var1.send();
        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    private static void b(Mob var0) {
        try {
            Message var1;
            (var1 = new Message((byte) 8)).writeShort(var0.idEntity);
            var1.send();
        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    public static void a(LangLa_eo var0) {
        for (int var1 = 0; var1 < gI().vNpc.size(); ++var1) {
            if (((Npc) gI().vNpc.elementAt(var1)).idd == var0.a) {
                var0.d = gI().mapID;
                return;
            }
        }

    }

    public void b(LangLa_eo var1) {
        Char.gI().cleanMove();
        Step var2 = gI().B();
        int var3 = -1;
        if (var1.d >= 0) {
            var3 = var1.d;
        } else {
            Task var4 = this.A();
            if (var2 != null) {
                var3 = var2.idMap;
            } else if (var4 != null) {
                var3 = var4.idMap;
            }
        }

        if (var3 >= 0 && (this.getMapTemplate().isMapLang() || this.getMapTemplate().b())) {
            if (DataCenter.gI().MapTemplate[var3].b() && var3 != this.mapID) {
                var1.a = 45;
                a(var1);
            } else if (DataCenter.gI().MapTemplate[var3].isMapLang() && var3 != this.mapID) {
                if (gI().e(var1.a) != null) {
                    var1.d = gI().mapID;
                } else {
                    var1.a = 101;
                    a(var1);
                }
            }
        }

        if (var2 != null) {
            if (var2.id == 21) {
                this.showMessage(Caption.hB, -2560);
                return;
            }

            if (var2.id == 22) {
                this.showMessage(Caption.hC, -2560);
                return;
            }

            if (var2.id != 10) {
                gI().aR = var1;
                return;
            }

            Item var8 = Char.gI().d(var2.idItem);
            boolean var7 = false;
            ItemOption[] var9;
            if (var8 != null && (var9 = var8.L()) != null) {
                for (int var5 = 0; var5 < var9.length; ++var5) {
                    if (var9[var5].a[0] == 105) {
                        var7 = true;
                        break;
                    }
                }
            }

            if (var7 || var8 == null) {
                gI().aR = new LangLa_eo(var2.idMap, var2.x, var2.y);
                return;
            }

            b(var8);
        } else {
            gI().aR = var1;
        }

    }

    public void bh(Message var1) {
        try {
            Char var2 = Char.gI();
            LangLa_az var3 = new LangLa_az(this, var1.reader.dis.readInt(), var1.readUTF(), var1.reader.dis.readByte());

            try {
                (var2 = this.f(var1.reader.dis.readInt())).aP = var1.reader.dis.readShort();
            } catch (Exception var5) {
            }

            if (var2.isMe()) {
                this.a((LangLa_cx) var3);
            }

        } catch (Exception var6) {
            Utlis.println(var6);
        }
    }

    public void bi(Message var1) {
        try {
            Char var2;
            if ((var2 = this.f(var1.reader.dis.readInt())) == null) {
                return;
            }

            short var3;
            int var4;
            LangLa_jw var6;
            GameSrc var7;
            LangLa_em[] var8;
            if ((var6 = new LangLa_jw(var1.reader.dis.readShort(), 0, 0)).j == 322) {
                var7 = this;
                var8 = new LangLa_em[3000];

                for (var4 = 0; var4 < 3000; ++var4) {
                    var3 = 187;
                    if (var4 % 2 == 0) {
                        var3 = 188;
                    } else if (var4 % 3 == 0) {
                        var3 = 189;
                    }

                    var8[var4] = new LangLa_em(var3, 8, 8, 8, var4, 95, Char.gI().cx, 3 * DataCenter.gI().widthScreen, var7.maxY);
                }

                var7.cx.addElement(new LangLa_en(Char.gI().cx, System.currentTimeMillis(), var8, 8));
            } else {
                if (var6.j != 323) {
                    var2.aF.addElement(var6);
                    return;
                }

                var7 = this;
                this.dI = 120;
                var8 = new LangLa_em[600];

                for (var4 = 0; var4 < 600; ++var4) {
                    var3 = 407;
                    if (var4 % 2 == 0) {
                        var3 = 408;
                    } else if (var4 % 3 == 0) {
                        var3 = 409;
                    }

                    var8[var4] = new LangLa_em(var3, 1, 5, 7, var4, 95, var7.maxX, var7.maxY);
                }

                var7.cx.addElement(new LangLa_en(Char.gI().cx, System.currentTimeMillis(), var8, 7));
            }
        } catch (Exception var5) {
            Utlis.println(var5);
        }

    }

    public void bj(Message var1) {
        try {
            Mob var2;
            (var2 = new Mob()).read(var1);
            var2.b(var2.cx, var2.cy);
            var2.Z = true;
            if (var2.id == 236) {
                var2.V = 60;
            }

            this.vMob.addElement(var2);
        } catch (Exception var3) {
            Utlis.println(var3);
        }
    }

    public void bk(Message var1) {
        try {
            short var5 = var1.reader.dis.readShort();

            for (int var3 = 0; var3 < this.vMob.size(); ++var3) {
                if (((Mob) this.vMob.elementAt(var3)).idEntity == var5) {
                    this.vMob.remove(var3);
                }
            }

        } catch (Exception var4) {
            Utlis.println(var4);
        }
    }

    public void bl(Message var1) {
        try {
            Mob var2;
            if ((var2 = this.r(var1.reader.dis.readShort())).speedMove <= 0) {
                var2.speedMove = 1;
            }

            var2.status = 2;
            var2.r = var1.reader.dis.readShort();
            var2.s = var1.reader.dis.readShort();
            XYEntity var5;
            if ((var5 = Char.c(var2.r, var2.s)) != null) {
                var2.r = var5.cx;
                var2.s = var5.cy;
            }

        } catch (Exception var4) {
            Utlis.println(var4);
        }
    }

    public void bm(Message var1) {
        try {
            Mob var2;
            (var2 = this.r(var1.reader.dis.readShort())).status = var1.reader.dis.readByte();
            var2.b(var1.reader.dis.readShort(), var1.reader.dis.readShort());
            var2.Z = true;
        } catch (Exception var4) {
            Utlis.println(var4);
        }
    }

    public void bn(Message var1) {
        try {
            Mob var10000 = this.r(var1.reader.dis.readShort());
            String var2 = var1.reader.readUTF();
            var10000.S = new LangLa_ih(var2);
        } catch (Exception var3) {
            Utlis.println(var3);
        }
    }

    public void bo(Message var1) {
        try {
            short var3 = var1.reader.dis.readShort();
            Npc var10000 = (Npc) this.vNpc.elementAt(var3);
            String var5 = var1.reader.readUTF();
            var10000.m = new LangLa_ih(var5);
        } catch (Exception var4) {
            Utlis.println(var4);
        }
    }

    public void bp(Message var1) {
        try {
            int var2 = var1.reader.dis.readInt();
            short var3 = var1.reader.dis.readShort();
            short var7 = var1.reader.dis.readShort();

            for (int var4 = 0; var4 < this.vItemMap.size(); ++var4) {
                ItemMap var5;
                if ((var5 = (ItemMap) this.vItemMap.elementAt(var4)).idEntity == var3) {
                    var5.idChar = var2;
                    var5.item.id = var7;
                    this.vItemMapPickUp.remove(var5);
                    break;
                }
            }

            if (var7 == 224) {
                this.bl = 1000;
                if (this.cD.lastElement() instanceof LangLa_az) {
                    this.cD.remove(this.cD.lastElement());
                }
            }

        } catch (Exception var6) {
            Utlis.println(var6);
        }
    }

    public void bq(Message var1) {
        try {
            this.f(var1.reader.dis.readInt()).typePK = var1.reader.dis.readByte();
        } catch (Exception var3) {
            Utlis.println(var3);
        }
    }

    public void C() {
        try {
            for (int var1 = this.cD.size() - 1; var1 >= 0; --var1) {
                if (this.cD.get(var1) instanceof LangLa_fl) {
                    ((LangLa_fl) this.cD.get(var1)).J();
                } else if (!(this.cD.get(var1) instanceof MainScreen)) {
                    this.cD.remove(var1);
                }
            }

        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    public void D() {
        try {
            LangLa_cx var1;
            if ((var1 = this.H()) instanceof LangLa_fo) {
                ((LangLa_fo) var1).J();
            }

        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    public void br(Message var1) {
        try {
            int var3 = var1.reader.dis.readInt();
            Char var4;
            if ((var4 = this.f(var3)) != null) {
                LangLa_hy.a("", var4, 40, 14);
            }
        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    public void bs(Message var1) {
        try {
            Item var2;
            (var2 = new Item()).read(var1);
            LangLa_cx var6;
            if ((var6 = this.H()) instanceof LangLa_ag) {
                LangLa_ag var7;
                (var7 = var7 = (LangLa_ag) var6).a = var2;
                ItemOption[] var8 = var7.a.L();
                Vector var3 = new Vector();

                for (int var4 = 0; var4 < var8.length; ++var4) {
                    if (var8[var4] != null && var8[var4].getItemOptionTemplate().type <= 2) {
                        var3.add(var8[var4]);
                    }
                }

                String[] var11 = new String[var3.size()];

                for (int var9 = 0; var9 < var3.size(); ++var9) {
                    var11[var9] = ((ItemOption) var3.get(var9)).b();
                }

                LangLa_kd var10 = new LangLa_kd(2000, var11);
                var7.f.a(var10, var3.size() > 5 ? 5 : var3.size());
            }

        } catch (Exception var5) {
            Utlis.println(var5);
        }
    }

    public void bt(Message var1) {
        try {
            Item var2;
            (var2 = new Item()).read(var1);
            var2.TYPE_TEMP = var1.reader.dis.readByte();
            if (var2.TYPE_TEMP == 2 || var2.TYPE_TEMP == 3) {
                var2.index = var2.getItemTemplate().type;
            }

            Char.gI().h(var2.TYPE_TEMP)[var2.index] = var2;
            Char.gI().arrItemBag[var1.reader.dis.readShort()] = null;
            LangLa_cx var5;
            if ((var5 = this.H()) instanceof LangLa_ag) {
                LangLa_ag var6;
                (var6 = (LangLa_ag) var5).d = true;

                for (int var3 = 0; var3 < var6.b.length; ++var3) {
                    var6.b[var3] = null;
                }

                var6.b[1] = var2;
            }

        } catch (Exception var4) {
            Utlis.println(var4);
        }
    }

    public void bu(Message var1) {
        try {
            this.a((LangLa_cx) (new LangLa_ay(this, var1)));
        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    public void bv(Message var1) {
        try {
            boolean var2 = var1.reader.dis.readBoolean();
            LangLa_ln[] var3 = new LangLa_ln[var1.reader.readUnsignedByte()];

            for (int var4 = 0; var4 < var3.length; ++var4) {
                var3[var4] = new LangLa_ln();
                var3[var4].a = var1.reader.dis.readByte();
                var3[var4].b = var1.reader.readUTF();
                var3[var4].c = var1.reader.dis.readShort();
                var3[var4].d = var1.reader.dis.readLong();
                var3[var4].e = var1.reader.dis.readByte();
                var3[var4].f = var1.reader.readUTF();
            }

            LangLa_cx var10;
            if ((var10 = this.H()) instanceof LangLa_ah) {
                LangLa_ah var7;
                (var7 = (LangLa_ah) var10).a = var2;
                var7.b = var3;
                var7.a();
            } else {
                if (!(var10 instanceof LangLa_ai)) {
                    if (var10 instanceof LangLa_ab) {
                        LangLa_ab var9;
                        (var9 = (LangLa_ab) var10).a = var3;
                        var9.a();
                    }

                    return;
                }

                LangLa_ai var8;
                (var8 = (LangLa_ai) var10).a = var3;
                var8.a();
            }
        } catch (Exception var6) {
            Utlis.println(var6);
        }

    }

    public void bw(Message var1) {
        try {
            var1.reader.dis.readBoolean();
            LangLa_ln[] var2 = new LangLa_ln[var1.reader.readUnsignedByte()];

            for (int var3 = 0; var3 < var2.length; ++var3) {
                var2[var3] = new LangLa_ln();
                var2[var3].a = var1.reader.dis.readByte();
                var2[var3].b = var1.reader.readUTF();
                var2[var3].c = var1.reader.dis.readShort();
                var2[var3].d = var1.reader.dis.readLong();
                var2[var3].e = var1.reader.dis.readByte();
                var2[var3].f = var1.reader.readUTF();
            }

            LangLa_ab var6;
            (var6 = new LangLa_ab(this)).a = var2;
            var6.a();
            this.a((LangLa_cx) var6);
        } catch (Exception var5) {
            Utlis.println(var5);
        }
    }

    public void bx(Message var1) {
        try {
            var1.reader.dis.readBoolean();
            LangLa_ln[] var2 = new LangLa_ln[var1.reader.readUnsignedByte()];

            for (int var3 = 0; var3 < var2.length; ++var3) {
                var2[var3] = new LangLa_ln();
                var2[var3].a = var1.reader.dis.readByte();
                var2[var3].b = var1.reader.readUTF();
                var2[var3].c = var1.reader.dis.readShort();
                var2[var3].d = var1.reader.dis.readLong();
                var2[var3].e = var1.reader.dis.readByte();
                var2[var3].f = var1.reader.readUTF();
            }

            LangLa_bx var6;
            (var6 = new LangLa_bx(this)).a = var2;
            var6.e();
            this.a((LangLa_cx) var6);
        } catch (Exception var5) {
            Utlis.println(var5);
        }
    }

    public void by(Message var1) {
        try {
            LangLa_cx var2;
            LangLa_ln[] var3;
            int var4;
            if (!((var2 = this.H()) instanceof LangLa_ah)) {
                if (var2 instanceof LangLa_z) {
                    LangLa_z var8 = (LangLa_z) var2;
                    var1.reader.dis.readBoolean();
                    var3 = new LangLa_ln[var1.reader.readUnsignedByte()];

                    for (var4 = 0; var4 < var3.length; ++var4) {
                        var3[var4] = new LangLa_ln();
                        var3[var4].a = var4 + 1;
                        var3[var4].b = var1.readUTF();
                        var3[var4].c = var1.reader.dis.readInt();
                        var3[var4].g = var1.reader.dis.readInt() + "%";
                        var3[var4].d = (long) var1.reader.dis.readInt();
                        var3[var4].e = var1.reader.dis.readInt();
                        var3[var4].f = var1.readUTF();
                    }

                    var8.a = var3;
                    var8.e();
                }

                return;
            }

            LangLa_ah var7;
            (var7 = (LangLa_ah) var2).a = var1.reader.dis.readBoolean();
            var3 = new LangLa_ln[var1.reader.readUnsignedByte()];

            for (var4 = 0; var4 < var3.length; ++var4) {
                var3[var4] = new LangLa_ln();
                var3[var4].a = var4 + 1;
                var3[var4].b = var1.reader.readUTF();
                var3[var4].c = var1.reader.dis.readInt();
                var3[var4].g = var1.reader.dis.readInt() + "%";
                var3[var4].d = (long) var1.reader.dis.readInt();
                var3[var4].e = var1.reader.dis.readInt();
                var3[var4].f = var1.readUTF();
            }

            var7.b = var3;
            var7.a();
        } catch (Exception var6) {
            Utlis.println(var6);
        }

    }

    public static void bz(Message var0) {
        try {
            int var1 = Char.gI().hoatLuc;
            Char.gI().hoatLuc = var0.reader.dis.readInt();
            if (var1 < Char.gI().hoatLuc) {
                String var4 = Caption.k + " " + Utlis.numberFormat(Char.gI().hoatLuc - var1) + " " + Caption.hD;
                LangLa_kw.a(7, Caption.bz, var4);
                DataCenter.gI().currentScreen.showMessage(var4, -1);
                LangLa_hy.a("+" + Utlis.numberFormat(Char.gI().hoatLuc - var1), Char.gI(), Char.gI().ak, 12);
            }

        } catch (Exception var3) {
            Utlis.println(var3);
        }
    }

    public void bA(Message var1) {
        try {
            Item var2 = Char.gI().arrItemBag[var1.reader.dis.readShort()];
            LangLa_cx var3;
            String[] var11;
            if (!((var3 = this.H()) instanceof LangLa_ge)) {
                if (var3 instanceof GameSrc) {
                    var11 = Utlis.split(var1.reader.readUTF(), ";");
                    this.a((LangLa_cx) (new LangLa_bk(this, "", var11, 30000)));
                }

                return;
            }

            LangLa_ge var9;
            LangLa_ge var10000 = var9 = (LangLa_ge) var3;
            String var10 = var1.reader.readUTF();
            LangLa_ge var7 = var10000;
            LangLa_kd var4 = new LangLa_kd(var2.index);
            var11 = Utlis.split(var10, ";");
            var4.c = new String[var11.length];
            var4.d = new short[var11.length];

            for (int var5 = 0; var5 < var11.length; ++var5) {
                var4.c[var5] = var11[var5];
                var4.d[var5] = (short) (30000 + var5);
            }

            LangLa_ij var13;
            (var13 = var7.j[0]).k = var2.index;
            if (var13.k >= 0 && var13.k < var13.i * var13.r) {
                var13.d();
                int var8 = var13.k % var13.r;
                int var12 = var13.k / var13.r - (var13.j >= 0 ? var13.j : 0);
                if (var13.n == 0) {
                    var8 = var13.k % var13.i - (var13.j >= 0 ? var13.j : 0);
                    var12 = var13.k / var13.i;
                }

                var8 = var8 * var13.h + var13.h + var13.cx;
                var12 = var12 * var13.h + var13.cy;
                var7.cL = LangLa_ge.a(var7, var8, var12, var4);
            }
        } catch (Exception var6) {
        }

    }

    public void bB(Message var1) {
        try {
            Char.gI().levelCheTao = var1.reader.dis.readInt();
            Char.gI().hoatLuc = var1.reader.dis.readInt();
            short var2 = var1.reader.dis.readShort();

            int var3;
            for (var3 = 0; var3 < var2; ++var3) {
                Item var4;
                (var4 = new Item()).read(var1);
                if (var4.expiry == 0L) {
                    Char.gI().arrItemBag[var4.index] = null;
                } else {
                    Char.gI().arrItemBag[var4.index] = var4;
                }
            }

            var3 = 0;

            while (true) {
                if (var3 >= this.cD.size()) {
                    return;
                }

                LangLa_cx var7;
                if ((var7 = (LangLa_cx) this.cD.get(var3)) instanceof LangLa_fd) {
                    LangLa_fd var6;
                    (var6 = (LangLa_fd) var7).e();
                    break;
                }

                ++var3;
            }
        } catch (Exception var5) {
            Utlis.println(var5);
        }

    }

    public static void bC(Message var0) {
        try {
            short var1 = var0.reader.dis.readShort();

            for (int var2 = 0; var2 < var1; ++var2) {
                Item var3;
                (var3 = new Item()).read(var0);
                if (var3.expiry == 0L) {
                    Char.gI().arrItemBag[var3.index] = null;
                } else {
                    Char.gI().arrItemBag[var3.index] = var3;
                }
            }

        } catch (Exception var4) {
            Utlis.println(var4);
        }
    }

    private void a(LangLa_gr[] var1) {
        Vector var2 = new Vector();

        int var3;
        int var4;
        XYEntity var5;
        for (var3 = 0; var3 < var1.length; ++var3) {
            for (var4 = 0; var4 < var1[var3].arrayXY.length - 1; ++var4) {
                var5 = var1[var3].arrayXY[var4];
                XYEntity var6 = var1[var3].arrayXY[var4 + 1];
                XYEntity[] var7 = new XYEntity[]{var5, var6};
                var2.add(var7);
            }
        }

        this.i.clear();

        for (var3 = 0; var3 < var2.size(); ++var3) {
            XYEntity var12 = ((XYEntity[]) var2.get(var3))[0];
            var5 = ((XYEntity[]) var2.get(var3))[1];
            this.a(var12, var5, var2, this.i);
        }

        Vector var11 = new Vector();

        BlockMap var13;
        for (var4 = this.i.size() - 1; var4 >= 0; --var4) {
            var13 = (BlockMap) this.i.get(var4);
            Vector var14 = new Vector();

            for (int var16 = 0; var16 < var13.arrayXY.length; ++var16) {
                var14.add(var13.arrayXY[var16]);
            }

            Collections.sort(var14, beatdz.XYEntity.$state_XYEntity().da);
            String var17 = "";

            for (int var8 = 0; var8 < var14.size(); ++var8) {
                XYEntity var10 = (XYEntity) var14.get(var8);
                var17 = var17 + var10.cx + "," + var10.cy + ";";
            }

            if (!var11.contains(var17)) {
                var11.add(var17);
            } else {
                this.i.remove(var4);
            }
        }

        this.k.clear();

        for (var4 = this.i.size() - 1; var4 >= 0; --var4) {
            var13 = (BlockMap) this.i.get(var4);

            for (int var15 = 0; var15 < var13.arrayXY.length - 1; ++var15) {
                XYEntity var18 = var13.arrayXY[var15];
                XYEntity var9 = var13.arrayXY[var15 + 1];
                this.k.add(new XYEntity[]{var18, var9});
            }
        }

    }

    private void a(XYEntity var1, XYEntity var2, Vector var3, Vector var4) {
        boolean var5 = false;
        boolean var6 = false;

        for (int var7 = 0; var7 < var3.size(); ++var7) {
            XYEntity var8 = ((XYEntity[]) var3.get(var7))[0];
            XYEntity var9 = ((XYEntity[]) var3.get(var7))[1];
            if ((!var8.equals(var1) || !var9.equals(var2)) && (!var9.equals(var1) || !var8.equals(var2))) {
                if (var8.equals(var1) || var9.equals(var1)) {
                    var5 = true;
                }

                if (var8.equals(var2) || var9.equals(var2)) {
                    var6 = true;
                }

                if (var5 && var6) {
                    return;
                }
            }
        }

        Vector var10 = new Vector();
        if (var5) {
            var10.add(var2);
            var10.add(var1);
        } else if (var6) {
            var10.add(var1);
            var10.add(var2);
        } else {
            BlockMap var11;
            (var11 = new BlockMap()).arrayXY = new XYEntity[2];
            var11.arrayXY[0] = var1;
            var11.arrayXY[1] = var2;
            var4.add(var11);
        }

        this.a(var3, var10, var4);
    }

    private void a(Vector var1, Vector var2, Vector var3) {
        if (var2.size() > 1) {
            XYEntity var4 = (XYEntity) var2.get(var2.size() - 2);
            XYEntity var5 = (XYEntity) var2.get(var2.size() - 1);
            Vector var6 = new Vector();

            int var7;
            for (var7 = 0; var7 < var1.size(); ++var7) {
                XYEntity var8 = ((XYEntity[]) var1.get(var7))[0];
                XYEntity var9 = ((XYEntity[]) var1.get(var7))[1];
                if ((!var8.equals(var4) || !var9.equals(var5)) && (!var9.equals(var4) || !var8.equals(var5)) && (var8.equals(var5) || var9.equals(var5))) {
                    if (var9.equals(var5)) {
                        var6.add(var8);
                    } else {
                        var6.add(var9);
                    }
                }
            }

            if (var6.size() == 0) {
                BlockMap var11;
                (var11 = new BlockMap()).arrayXY = new XYEntity[var2.size()];

                for (int var13 = 0; var13 < var2.size(); ++var13) {
                    var11.arrayXY[var13] = (XYEntity) var2.get(var13);
                }

                var3.add(var11);
                return;
            }

            try {
                for (var7 = 0; var7 < var6.size(); ++var7) {
                    Vector var12;
                    (var12 = new Vector()).addAll(var2);
                    var12.add(var6.get(var7));
                    this.a(var1, var12, var3);
                }

                return;
            } catch (Exception var10) {
            }
        }

    }

    public static void c(int var0, int var1) {
        try {
            Message var2;
            (var2 = new Message((byte) 53)).writeShort(var0);
            var2.writeByte(var1);
            var2.send();
        } catch (Exception var3) {
            Utlis.println(var3);
        }
    }

    public boolean a(XYEntity var1, XYEntity var2) {
        return this.b(var1, var2) != null;
    }

    public XYEntity b(XYEntity var1, XYEntity var2) {
        for (int var3 = 0; var3 < this.h.a.length; ++var3) {
            XYEntity var4;
            if ((var4 = this.h.a[var3].b(var1, var2)) != null) {
                return var4;
            }
        }

        return null;
    }

    public boolean a(XYEntity var1) {
        return false;
//        if (!gI().E()) {
//            return false;
//        } else if (var1 == null) {
//            return false;
//        } else if (var1 instanceof Char) {
//            return false;
//        } else {
//            XYEntity var2;
//            (var2 = new XYEntity()).setXY(var1.cx, var1.cy - 2);
//            return this.b((XYEntity) Char.gI(), (XYEntity) var2) != null;
//        }
    }

    public boolean E() {
        try {
            if (this.getMapTemplate().type == 4 || this.getMapTemplate().type == 14 || this.getMapTemplate().type == 15 || this.getMapTemplate().type == 5 || this.getMapTemplate().type == 7 || this.getMapTemplate().type == 8 || this.getMapTemplate().type == 6 || this.getMapTemplate().type == 9 || this.getMapTemplate().type == 10 || this.getMapTemplate().type == 12 || this.getMapTemplate().type == 13 || this.getMapTemplate().type == 16 || this.getMapTemplate().type == 17 || this.getMapTemplate().type == 18) {
                return true;
            }
        } catch (Exception var1) {
        }

        return false;
    }

    public void bD(Message var1) {
        try {
            Char var2;
            if ((var2 = this.f(var1.reader.dis.readInt())) != null) {
                int var3 = 0;
                if (var2.isMe() && this.H() instanceof LangLa_kl) {
                    var3 = var2.aG.length;
                }

                var2.readDanhHieu(var1);
                var2.selectDanhHieu = (byte) (var1.reader.dis.readByte() + 1);
                if (var2.isMe() && this.H() instanceof LangLa_kl && var3 != var2.aG.length) {
                    ((LangLa_kl) this.H()).e();
                }

            }
        } catch (Exception var5) {
        }
    }

    public void bE(Message var1) {
        try {
            Char var2;
            (var2 = this.f(var1.reader.dis.readInt())).rank = var1.reader.dis.readByte();
            if (var2.isMe()) {
                beatdz.LangLa_cj.$state_LangLa_cj().l.a();
                beatdz.LangLa_cj.$state_LangLa_cj().l = null;
                SettingsTab.a((SettingsTab) null);
            }

        } catch (Exception var4) {
        }
    }

    public static void bF(Message message) {
        try {
            LangLa_cx H2 = gI().H();
            if (H2 instanceof LangLa_bg) {
                short readShort = message.reader.dis.readShort();
                LangLa_bg langLa_bg = (LangLa_bg) H2;
                for (int i2 = 0; i2 < langLa_bg.b.length; i2++) {
                    for (int i3 = 0; i3 < langLa_bg.b[i2].length; i3++) {
                        for (int i4 = 0; i4 < langLa_bg.b[i2][i3].length; i4++) {
                            if (langLa_bg.b[i2][i3][i4].a == readShort) {
                                langLa_bg.b[i2][i3][i4].e = false;
                                langLa_bg.e();
                                return;
                            }
                        }
                    }
                }
            } else if (AutoPro.srcPL
                    != null) {
                H2 = AutoPro.srcPL;
                short readShort = message.reader.dis.readShort();
                LangLa_bg langLa_bg = (LangLa_bg) H2;
                for (int i2 = 0; i2 < langLa_bg.b.length; i2++) {
                    for (int i3 = 0; i3 < langLa_bg.b[i2].length; i3++) {
                        for (int i4 = 0; i4 < langLa_bg.b[i2][i3].length; i4++) {
                            if (langLa_bg.b[i2][i3][i4].a == readShort) {
                                langLa_bg.b[i2][i3][i4].e = false;
                                langLa_bg.e();
                                return;
                            }
                        }
                    }
                }
            }
        } catch (Exception e2) {
            Utlis.println(e2);
        }
    }

    public static void bG(Message var0) {
        try {
            LangLa_cx var1;
            if ((var1 = gI().H()) instanceof LangLa_bg) {
                LangLa_bg var3;
                (var3 = (LangLa_bg) var1).a(var0);
            } else if (AutoPro.srcPL != null) {
                LangLa_bg var3;
                (var3 = (LangLa_bg) AutoPro.srcPL).a(var0);
            }

        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    public static void bH(Message var0) {
        try {
            LangLa_cx var1;
            if ((var1 = gI().H()) instanceof LangLa_bg) {
                LangLa_bg var7;
                LangLa_bg var10000 = var7 = (LangLa_bg) var1;
                Message var2 = var0;
                LangLa_bg var6 = var10000;

                try {
                    var6.i = var2.reader.dis.readByte();
                    var6.e = var2.reader.dis.readByte();
                    var6.j = var2.reader.dis.readInt();
                } catch (Exception var4) {
                }

                var7.e();
            } else if (AutoPro.srcPL != null) {
                LangLa_bg var7;
                LangLa_bg var10000 = var7 = (LangLa_bg) AutoPro.srcPL;
                Message var2 = var0;
                LangLa_bg var6 = var10000;

                try {
                    var6.i = var2.reader.dis.readByte();
                    var6.e = var2.reader.dis.readByte();
                    var6.j = var2.reader.dis.readInt();
                } catch (Exception var4) {
                }

                var7.e();
            }

        } catch (Exception var5) {
            Utlis.println(var5);
        }
    }

    public void bI(Message var1) {
        try {
            this.as = var1.reader.dis.readBoolean();
        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    public static void F() {
        if (!(gI().H() instanceof GoldTopUpPanel)) gI().a((LangLa_cx)new GoldTopUpPanel(gI()));
    }

    public static void bJ(Message var0) {
        try {
            LangLa_cx var1;
            if ((var1 = gI().H()) instanceof LangLa_y) {
                LangLa_y var3;
                (var3 = (LangLa_y) var1).g = var0.reader.dis.readByte();
            }

        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    public static void c(LangLa_eo var0) {
        Vector var1 = null;

        for (int var2 = 0; var2 < DataCenter.gI().MapTemplate.length; ++var2) {
            if (DataCenter.gI().MapTemplate[var2].isMapLang() && (DataCenter.gI().MapTemplate[var2].id == 102 && Char.gI().level() >= 60 || DataCenter.gI().MapTemplate[var2].id == 68 && Char.gI().level() >= 50 || DataCenter.gI().MapTemplate[var2].id == 59 && Char.gI().level() >= 40 || DataCenter.gI().MapTemplate[var2].id == 85 && Char.gI().level() >= 30 || DataCenter.gI().MapTemplate[var2].id == 69 && Char.gI().level() >= 20 || DataCenter.gI().MapTemplate[var2].id == 60 && Char.gI().level() >= 10)) {
                Vector var3 = gI().a(DataCenter.h(), gI().mapID, DataCenter.gI().MapTemplate[var2].id, true);
                if (var1 == null || var3.size() > 0 && var3.size() < var1.size()) {
                    var0.d = DataCenter.gI().MapTemplate[var2].id;
                    var1 = var3;
                }
            }
        }

    }

    public static void bK(Message var0) {
        try {
            int var1 = var0.reader.dis.readInt();
            int var5 = var0.reader.dis.readInt();
            int var2 = 0;

            while (true) {
                if (var2 >= gI().l.size()) {
                    return;
                }

                Item var3;
                if ((var3 = (Item) gI().l.get(var2)).idBuy == var1) {
                    var3.amountBuy = var5;
                    break;
                }

                ++var2;
            }
        } catch (Exception var4) {
        }

    }

    public void bL(Message var1) {
        try {
            byte var2 = var1.reader.dis.readByte();
            Item var3 = null;

            for (int var4 = 0; var4 < var2; ++var4) {
                byte var5 = var1.reader.dis.readByte();
                if (var4 != 0) {
                    if (var5 == 2) {
                        Char.gI().arrItemBody[var1.reader.dis.readShort()] = null;
                    } else if (var5 == 3) {
                        Char.gI().arrItemBody2[var1.reader.dis.readShort()] = null;
                    } else {
                        Char.gI().arrItemBag[var1.reader.dis.readShort()] = null;
                    }
                } else {
                    (var3 = new Item()).read(var1);
                    var3.TYPE_TEMP = var5;
                    if (var5 == 2 || var5 == 3) {
                        var3.index = var3.getItemTemplate().type;
                    }

                    Char.gI().h(var3.TYPE_TEMP)[var3.index] = var3;
                }
            }

            LangLa_cx var8;
            if ((var8 = this.H()) instanceof LangLa_am) {
                LangLa_am var9;
                (var9 = (LangLa_am) var8).f = true;
                var9.d = new LangLa_jw(114, 0, 0);

                int var7;
                for (var7 = 0; var7 < var9.b.length; ++var7) {
                    var9.b[var7] = null;
                }

                for (var7 = 0; var7 < var9.a.length; ++var7) {
                    var9.a[var7] = null;
                }

                var9.a[0] = var3;
                var9.e = var3;
            }

        } catch (Exception var6) {
        }
    }

    public void bM(Message var1) {
        try {
            java.util.ArrayList<Item> restored = new java.util.ArrayList<Item>();
            byte sourceType = var1.reader.dis.readByte();
            short sourceIndex = var1.reader.dis.readShort();
            while (var1.reader.dis.available() > 0) {
                Item original = new Item();
                original.read(var1);
                if (original.index < 0 || original.index >= Char.gI().arrItemBag.length)
                    throw new java.io.IOException("Invalid restored costume slot");
                restored.add(original);
            }
            if (restored.size() < 2) throw new java.io.IOException("Incomplete costume split result");
            Char.gI().h(sourceType)[sourceIndex] = null;
            for (Item original : restored) Char.gI().arrItemBag[original.index] = original;
            if (this.H() instanceof LangLa_bt) {
                LangLa_bt screen = (LangLa_bt)this.H();
                screen.f = true;
                screen.e = new LangLa_jw(114, 0, 0);
                screen.a[0] = null;
                screen.c = restored.toArray(new Item[restored.size()]);
                java.util.Arrays.fill(screen.b, null);
                System.arraycopy(screen.c, 0, screen.b, 0, Math.min(screen.c.length, screen.b.length));
            }
        } catch (Exception error) {
            Utlis.println(error);
        }
    }

    public void bN(Message var1) {
        try {
            Item[] var2 = new Item[var1.reader.dis.readByte()];

            for (int var3 = 0; var3 < var2.length; ++var3) {
                var2[var3] = new Item();
                var2[var3].read(var1);
            }

            LangLa_cx var6;
            if ((var6 = this.H()) instanceof LangLa_bt) {
                LangLa_bt var5;
                (var5 = (LangLa_bt) var6).c = var2;
            }

        } catch (Exception var4) {
        }
    }

    public void bO(Message var1) {
        try {
            Hashtable var2 = new Hashtable();
            Vector var3 = new Vector();
            byte var4 = var1.reader.dis.readByte();

            for (int var5 = 0; var5 < var4; ++var5) {
                LangLa_go var6;
                (var6 = new LangLa_go()).a = var1.readUTF();
                var6.b = var1.reader.dis.readShort();
                var3.add(var6);
                LangLa_go var7;
                if ((var7 = (LangLa_go) var2.get(var6.a)) == null) {
                    (var7 = new LangLa_go()).a = var6.a;
                }

                ++var7.b;
                var2.put(var7.a, var7);
            }

            Vector var9 = new Vector(var2.values());
            this.b = var9;
            this.a = var3;
            if (beatdz.LangLa_u.$state_LangLa_u().f != null) {
                beatdz.LangLa_u.$state_LangLa_u().f.g();
            }

        } catch (Exception var8) {
        }
    }

    public void bP(Message var1) {
        try {
            this.cg = var1.reader.readUTF();
            this.ch = var1.reader.dis.readShort();
        } catch (Exception var3) {
        }
    }

    private static void b(Item var0) {
        try {
            Message var1;
            (var1 = new Message((byte) -3)).writeShort(var0.index);
            var1.send();
        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    private boolean t(int var1) {
        if (SettingsTab.gI().k() == 0) {
            return false;
        } else {
            Vector var2 = new Vector();

            int var3;
            for (var3 = 0; var3 < Char.gI().arrItemBag.length; ++var3) {
                if (Char.gI().arrItemBag[var3] != null && Char.gI().arrItemBag[var3].q() && Char.gI().arrItemBag[var3].id <= var1) {
                    var2.add(Char.gI().arrItemBag[var3]);
                }
            }

            Collections.sort(var2, beatdz.Item.$state_Item().a);
            var3 = var2.size() > 16 ? 16 : var2.size();
            int var4 = 0;
            Vector var6 = new Vector();

            for (int var7 = 0; var7 < var3; ++var7) {
                Item var5 = (Item) var2.get(var7);
                var6.add(var5);
                if ((float) ((long) ((var4 = (int) ((long) var4 + DataCenter.gI().pointGhepDa[var5.id])) * 100) / DataCenter.gI().pointGhepDa[var1 + 1]) >= (float) this.cm) {
                    if (DataCenter.gI().bacKhoaGhepDa[var1 + 1] > Char.gI().bacKhoa) {
                        SettingsTab var10000 = SettingsTab.gI();
                        boolean var10 = true;
                        var10 = true;
                        SettingsTab var11 = var10000;
                        var10000.a[7] = -1;
                        var11.z();
                        DataCenter.gI().currentScreen.showMessage(Caption.nX, -48128);
                        return false;
                    }

                    try {
                        this.dA = System.currentTimeMillis();
                        Message var9;
                        (var9 = new Message((byte) 108)).writeBoolean(true);
                        var9.writeByte(var6.size());

                        for (int var12 = 0; var12 < var6.size(); ++var12) {
                            var9.writeShort(((Item) var6.get(var12)).index);
                        }

                        var9.send();
                    } catch (IOException var8) {
                    }

                    return true;
                }
            }

            return false;
        }
    }

    private static void u(int var0) {
        try {
            Message var1;
            (var1 = new Message((byte) -15)).writeByte(var0);
            var1.send();
        } catch (Exception var2) {
        }
    }

    public void bQ(Message var1) {
        try {
            if (this.aI != null) {
                LangLa_lj var2;
                LangLa_ey var10000 = (var2 = this.aI).a.size() > 0 ? (LangLa_ey) var2.a.firstElement() : null;
                LangLa_ey var5 = var10000;
                var10000.e = var1.reader.dis.readShort();
                var5.f = var1.reader.dis.readShort();
                var5.g = var1.reader.dis.readShort();
                var5.h = var1.reader.dis.readShort();
            }

        } catch (Exception var4) {
        }
    }

    public void G() {
        if (Gdx.app.getType() == ApplicationType.Desktop && !this.ah.v && this.ah.cx != -200 && this.ah.cy != -200) {
            this.ah.setXY(-200, -200);
            this.ah.b(true);
        } else {
            this.a(Caption.mc, 20000, this);
        }
    }

    public static void a(Pixmap var0, LangLa_cz var1, int var2, int var3, int var4, int var5) {
        var0.setColor(Utlis.createColor(-1278446549L));
        var0.setBlending(Blending.SourceOver);
        var0.fillRectangle(1 * DataCenter.gI().zoomLevel, 1 * DataCenter.gI().zoomLevel, (var1.width - 2) * DataCenter.gI().zoomLevel, (var1.height - 2) * DataCenter.gI().zoomLevel);
        mImage var6;
        var3 = (var6 = LangLa_fq.a((int) 84)).c / DataCenter.gI().zoomLevel;
        Binary2.a(var0, var6.b, 0 * DataCenter.gI().zoomLevel, 0 * DataCenter.gI().zoomLevel, Blending.SourceOver);
        mImage var7 = mImage.b(var6, 0, 0, var6.c, var6.d, -360);
        Binary2.a(var0, var7.b, (0 + var1.width - var3) * DataCenter.gI().zoomLevel, 0 * DataCenter.gI().zoomLevel, Blending.SourceOver);
        var7.a();
        var7 = mImage.b(var6, 0, 0, var6.c, var6.d, -180);
        Binary2.a(var0, var7.b, 0 * DataCenter.gI().zoomLevel, (0 + var1.height + 0 - var3) * DataCenter.gI().zoomLevel, Blending.SourceOver);
        var7.a();
        var7 = mImage.b(var6, 0, 0, var6.c, var6.d, -270);
        Binary2.a(var0, var7.b, (0 + var1.width - var3) * DataCenter.gI().zoomLevel, (0 + var1.height + 0 - var3) * DataCenter.gI().zoomLevel, Blending.SourceOver);
        var7.a();
        var6 = LangLa_fq.a((int) 5);
        Binary2.a(var0, var6.b, (0 + var3) * DataCenter.gI().zoomLevel, 0 * DataCenter.gI().zoomLevel, (var1.width - var3 * 2) * DataCenter.gI().zoomLevel, 0, Blending.SourceOver);
        var7 = mImage.b(var6, 0, 0, var6.c, var6.d, 180);
        Binary2.a(var0, var7.b, (0 + var3) * DataCenter.gI().zoomLevel, (0 + var1.height + 0 - var6.c / DataCenter.gI().zoomLevel) * DataCenter.gI().zoomLevel, (var1.width - var3 * 2) * DataCenter.gI().zoomLevel, 0, Blending.SourceOver);
        var7.a();
        var7 = mImage.b(var6, 0, 0, var6.c, var6.d, 270);
        Binary2.a(var0, var7.b, 0 * DataCenter.gI().zoomLevel, (0 + var3) * DataCenter.gI().zoomLevel, 0, (var1.height + 0 - var3 * 2) * DataCenter.gI().zoomLevel, Blending.SourceOver);
        var7.a();
        var7 = mImage.b(var6, 0, 0, var6.c, var6.d, 90);
        Binary2.a(var0, var7.b, (0 + var1.width - var6.c / DataCenter.gI().zoomLevel) * DataCenter.gI().zoomLevel, (0 + var3) * DataCenter.gI().zoomLevel, 0, (var1.height + 0 - var3 * 2) * DataCenter.gI().zoomLevel, Blending.SourceOver);
        var7.a();
    }

    private void j(boolean var1) {
        mConfig.gI().writeBoolean(14, var1);
        this.S.a(!mConfig.gI().readBoolean(14));
        LangLa_dz var10000;
        if (var1) {
            this.S.f();
            var10000 = (LangLa_dz) this.S.a();
            byte var3 = 0;
            var10000.e = var3;
        } else {
            this.S.e();
            var10000 = (LangLa_dz) this.S.a();
            short var2 = 180;
            var10000.e = var2;
        }
    }

    private void k(boolean var1) {
        mConfig.gI().writeBoolean(23, var1);
        this.U.a(!mConfig.gI().readBoolean(23));
        LangLa_dz var10000;
        if (!var1) {
            this.U.a(this.U.a().cx, 0, false);
            this.U.e();
            var10000 = (LangLa_dz) this.U.a();
            byte var3 = 0;
            var10000.e = var3;
        } else {
            this.U.a(this.U.a().cx, 52, true);
            var10000 = (LangLa_dz) this.U.a();
            short var2 = 180;
            var10000.e = var2;
        }
    }

    public static void bR(Message var0) {
        try {
            byte[] var1 = var0.reader.readUTF().getBytes();
            byte[] var2 = var0.reader.read();
            byte[] var3 = new byte[var1.length + var2.length];
            System.arraycopy(var1, 0, var3, 0, var1.length);
            System.arraycopy(var2, 0, var3, var1.length, var2.length);
            if ((var3 = AppListener.gI().app.b(var3)) == null) {
                var3 = new byte[0];
            }

            (var0 = Message.c(var0.cmd)).write(var3);
            var0.send();
        } catch (Exception var4) {
        }
    }

    public static void i(int var0) {
        try {
            Message var1;
            (var1 = Message.c((byte) -19)).writeByte(var0);
            var1.send();
        } catch (Exception var2) {
        }
    }

    public static int a(GameSrc var0) {
        return var0.dK;
    }

    public static int b(GameSrc var0) {
        return var0.dK++;
    }

    public static int a(GameSrc var0, int var1) {
        return var0.dK = 0;
    }

    public void updateMove() {
        int var21;
        Item var5;
        boolean var4 = false;
        boolean var13 = true;
        int var2;
        Item var17;
        Char var23 = Char.gI();
        if (this.i()) {
            if (this.aR != null) {
                if (this.mapID == this.aR.d) {
                    if (this.aR.a >= 0) {
                        var13 = true;

                        for (var2 = 0; var2 < gI().vNpc.size(); ++var2) {
                            Npc var22;
                            if ((var22 = (Npc) gI().vNpc.elementAt(var2)).idd == this.aR.a) {
                                this.aR.e = var22.cx;
                                this.aR.f = var22.cy;
                                if (Utlis.getRange(Char.gI().cx, Char.gI().cy, var22.cx, var22.cy) <= this.au && Char.gI().cy >= var22.cy - 5 && Char.gI().cy <= var22.cy) {
                                    if (var22.status == 6) {
                                        Step var26;
                                        if ((var26 = gI().B()) != null && var26.id == 5 && var26.idNpc == var22.idd && Utlis.getRange((XYEntity) var22, (XYEntity) Char.gI()) < 100) {
                                            gI();
                                            c(var22.idEntity, 0);
                                        }
                                    } else {
                                        this.aA = var22;
                                        Char.gI().stopMove();
                                        if (Utlis.getRange(Char.gI().cx, var22.cx) < 20) {
                                            if (var22.cx >= Char.gI().cx) {
                                                Char.gI().cx = (short) (var22.cx - 20);
                                            } else {
                                                Char.gI().cx = (short) (var22.cx + 20);
                                            }
                                        }

                                        this.aa();
                                        if (this.aR.a == 101) {
                                            if (this.aR.h == 13) {
                                                c(this.aA.idEntity, 0);
                                            } else if (this.aR.h == 16) {
                                                c(this.aA.idEntity, 1);
                                            } else if (this.aR.h == 24) {
                                                c(this.aA.idEntity, 2);
                                            } else if (this.aR.h == 28) {
                                                c(this.aA.idEntity, 3);
                                            } else if (this.aR.h == 34) {
                                                c(this.aA.idEntity, 4);
                                            }
                                        } else if (this.aR.a == 45) {
                                            if (this.aR.h == 11) {
                                                c(this.aA.idEntity, 0);
                                            } else if (this.aR.h == 35) {
                                                c(this.aA.idEntity, 1);
                                            } else if (this.aR.h == 25) {
                                                c(this.aA.idEntity, 2);
                                            } else if (this.aR.h == 21) {
                                                c(this.aA.idEntity, 3);
                                            } else if (this.aR.h == 38) {
                                                c(this.aA.idEntity, 4);
                                            }
                                        }
                                    }

                                    this.aR = null;
                                }
                                break;
                            }

                            var13 = true;
                        }
                    }

                    if (this.aR != null) {
                        var13 = true;
                        if ((this.aR.e != 0 || this.aR.f != 0) && (Char.gI().cx != this.aR.e || Char.gI().cy != this.aR.f)) {
                            if (!Char.gI().P()) {
                                var13 = true;
                                if (Char.gI().pointMove == null && Char.gI().vPointMove.size() == 0 && MoveSmart.c().size() == 0) {
                                    var13 = true;
                                    Char.gI().b(this.aR.e, this.aR.f);
                                }
                            }
                        } else {
                            Step var20 = this.B();
                            Mob var25;
                            if (this.aR.j >= 0) {
                                for (var21 = 0; var21 < this.vMob.size(); ++var21) {
                                    if ((var25 = (Mob) this.vMob.get(var21)).idEntity == this.aR.j && var25.status == 0) {
                                        var4 = true;
                                        b(var25);
                                        this.a((LangLa_cx) (new LangLa_az(this, var25.getMobTemplate().timeThuHoach, var25.getMobTemplate().detail, 0)));
                                        break;
                                    }
                                }
                            } else if (var20 != null && (var20.id == 3 || var20.id == 12 || var20.id == 30 || var20.id == 10)) {
                                if ((var5 = Char.gI().d(var20.c())) != null) {
                                    a(var5);
                                }
                            } else if (this.aR.c >= 0) {
                                for (var21 = 0; var21 < this.vMob.size(); ++var21) {
                                    if ((var25 = (Mob) this.vMob.get(var21)).id == this.aR.c) {
                                        this.bZ = var25.id;
                                        this.l();
                                        if (var25.getMobTemplate().type >= 9 && var25.getMobTemplate().type <= 11) {
                                            break;
                                        }

                                        if (this.aR.b >= 0) {
                                            SettingsTab.gI().b(true);
                                        }

                                        SettingsTab.gI().a(true);
                                        break;
                                    }
                                }
                            }

                            var13 = true;
                            this.aR = null;
                            if (!var4 && var20 != null && var20.id == 2) {
                                for (var21 = 0; var21 < this.vMob.size(); ++var21) {
                                    if ((var25 = (Mob) this.vMob.get(var21)).id == var20.idMob && var25.status == 0) {
                                        this.aR = new LangLa_eo(this.mapID, var25.cx, var25.cy);
                                        this.aR.j = var25.idEntity;
                                        this.aA = var25;
                                        this.a(true);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                } else {
                    var13 = true;
                    if (this.E()) {
                        this.aR = null;
                    } else {
                        if (this.aR.g == null) {
                            var13 = true;
                            this.aR.g = this.a(DataCenter.h(), this.mapID, this.aR.d, true);
                            if (this.aR.g.size() == 0) {
                                var13 = true;
                                this.aR.g = null;
                                this.aR = null;
                            }
                        }

                        var13 = true;
                        if (this.aR != null && this.aR.g != null) {
                            var13 = true;
                            WayPoint var28;
                            if (!Char.gI().P() && !MoveSmart.e()) {
                                var13 = true;

                                for (var2 = 0; var2 < this.aR.g.size(); ++var2) {
                                    if ((var28 = (WayPoint) this.aR.g.elementAt(var2)).mapHere == this.mapID) {
                                        Char.gI().b(var28.cx, var28.cy);
                                        break;
                                    }
                                }

                                var13 = true;
                            } else {
                                for (var2 = 0; var2 < this.aR.g.size(); ++var2) {
                                    if ((var28 = (WayPoint) this.aR.g.elementAt(var2)).mapHere == this.mapID && (Char.gI().cx == var28.cx && Char.gI().cy == var28.cy || var28.getRe() < 40)) {
                                        this.a(var28.cx, var28.cy);
                                        break;
                                    }
                                }
                            }
                        }
                    }

                }
            }

            var13 = true;
            var23.t();
            int c = 100;
            while (var23.pointMove != null && var23.pointMove.getRe() >= 20 && AutoPro.isAuto(3) && c-- > 0) {
                var23.t();
            }
        }
    }

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public long delayDoiKhu;
public boolean an;
public boolean ao;
public GameSrc dk;
public String aJ;
public String aK;
public String aL;
public int bc;
public int bd;
public boolean bj;
public Hashtable bk;
public mImage bR;
public mImage dB;
public long dC;
public long cA;
public void initialize() {
this.dk = null;
this.aJ = "";
this.aK = "";
this.aL = "";
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.GameSrc");
public static SessionState $state_GameSrc() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }

    private void applyShopUpgradeTrailer(Message packet) throws java.io.IOException {
        java.io.DataInputStream input = packet.reader.dis;
        if (input.available() < 6) return;
        input.mark(input.available());
        if (input.readInt() != 0x55313901) { input.reset(); return; }
        int count = input.readUnsignedShort();
        if (count > this.l.size() || input.available() < count * 4) throw new java.io.IOException("Invalid shop upgrade metadata");
        java.util.HashMap<Integer, Item> rows = new java.util.HashMap<Integer, Item>();
        for (int n = 0; n < this.l.size(); n++) { Item item = (Item)this.l.get(n); rows.put(item.idBuy, item); }
        for (int n = 0; n < count; n++) {
            int id = input.readUnsignedShort(), grade = input.readUnsignedByte(); byte element = input.readByte();
            Item item = rows.get(id); if (item == null) continue;
            item.level = (byte)Math.min(19, grade); item.he = element;
        }
    }

}
