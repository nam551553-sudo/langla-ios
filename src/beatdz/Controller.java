package beatdz;

import beatdz.tab.LatHinh;
import beatdz.tab.VXMM;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Application.ApplicationType;
import com.listener.SDKListener;
import com.tgame.model.Caption;
import java.io.File;
import java.util.Vector;

public class Controller implements IMessageHandler {

    
    private LangLa_c b = new LangLa_c();
    

    public void b() {
        if (beatdz.Controller.$state_Controller().c) {
            AppListener.gI();
            AppListener.exit();
        }

        if (!beatdz.AppListener.$state_AppListener().k) {
            AppListener var9 = AppListener.gI();

            label58:
            {
                Exception var10000;
                label57:
                {
                    boolean var10001;
                    int var2;
                    int var3;
                    try {
                        var2 = 0;
                        var3 = 0;
                    } catch (Exception var8) {
                        var10000 = var8;
                        var10001 = false;
                        break label57;
                    }

                    label54:
                    while (true) {
                        int var4;
                        try {
                            if (var3 >= DataCenter.gI().arrayServers.length) {
                                break label58;
                            }

                            var4 = 0;
                        } catch (Exception var6) {
                            var10000 = var6;
                            var10001 = false;
                            break;
                        }

                        while (true) {
                            try {
                                if (var4 >= DataCenter.gI().arrayServers[var3].servers.length) {
                                    break;
                                }

                                Server var5 = DataCenter.gI().arrayServers[var3].servers[var4];
                                if (!AppListener.$state_AppListener().l.contains(var2)) {
                                    if (!var5.STR_STATUS.toLowerCase().equals(Caption.mi.toLowerCase())) {
                                        DataCenter.gI().ipServer = var5.ip;
                                        DataCenter.gI().portServer = var5.port;
                                    }

                                    AppListener.$state_AppListener().l.add(var2);
                                    return;
                                }
                            } catch (Exception var7) {
                                var10000 = var7;
                                var10001 = false;
                                break label54;
                            }

                            ++var2;
                            ++var4;
                        }

                        ++var3;
                    }
                }

                Utlis.println(var10000);
            }

            beatdz.AppListener.$state_AppListener().k = true;
        } else {
            MainScreen var1;
            if (!beatdz.DataCenter.$state_DataCenter().as && !(var1 = DataCenter.gI().currentScreen).cD.contains(this.b)) {
                this.b.a(Caption.j, var1);
                var1.a((LangLa_cx) this.b);
            }

        }
    }

    public void c() {
        if (beatdz.Controller.$state_Controller().c) {
            AppListener.gI();
            AppListener.exit();
        }

        Session.gI().vMessage.clear();
        LangLa_hd var1;
        (var1 = LangLa_hd.a()).b = null;
        var1.a.clear();
        LangLa_jh var2;
        (var2 = LangLa_jh.a()).b = null;
        var2.a.clear();
        LangLa_jj var3;
        (var3 = LangLa_jj.a()).b = null;
        var3.a.clear();
        LangLa_jl var4;
        (var4 = LangLa_jl.a()).b = null;
        var4.a.clear();
        if (!beatdz.DataCenter.$state_DataCenter().as) {
            if (GameSrc.gI().aI != null) {
                GameSrc.gI().aI.a.clear();
            }

            if (DataCenter.gI().aI) {
                DataCenter.gI().aI = false;
                return;
            }

            if (Char.gI().idEntity > 0) {
                beatdz.DataCenter.$state_DataCenter().aR = 1;
                DataCenter.gI().setScreen((MainScreen) LoginPCScreen.gI());
                return;
            }

            MainScreen var5;
            if (!(var5 = DataCenter.gI().currentScreen).cD.contains(this.b)) {
                this.b.a(Caption.d, var5);
                var5.a((LangLa_cx) this.b);
            }
        }

        if (Char.gI().idEntity > 0) {
            beatdz.DataCenter.$state_DataCenter().aR = 1;
            DataCenter.gI().setScreen((MainScreen) LoginPCScreen.gI());
            return;
        }

    }

    public void a() {
        beatdz.AppListener.$state_AppListener().k = true;
        if (beatdz.DataCenter.$state_DataCenter().as) {
            beatdz.DataCenter.$state_DataCenter().as = false;
        }

    }

    public void a(Message msg) {
        try {
            Message var2;
            GameSrc var3;
            GameSrc var10000;
            LangLa_cx var18;
            byte[] var61;
            String var65;
            LangLa_aj var71;
            LangLa_fd var72;
            String[] var74;
            String var75;
            byte var77;
            String var78;
            Item var81;
            String[] var82;
            LangLa_ks var83;
            switch (msg.cmd) {
                case -125:
                    msg.cmd = msg.readByte();
                    b(msg);
                    return;
                case -124:
                    msg.cmd = msg.readByte();
                    c(msg);
                    return;
                case -123:
                    msg.cmd = msg.readByte();
                    this.d(msg);
                    return;
                case -122:
                    msg.cmd = msg.readByte();
                    this.f(msg);
                    break;
                case -121:
                case -120:
                case -119:
                case -118:
                case -117:
                case -116:
                case -115:
                case -114:
                case -112:
                case -111:
                case -100:
                case -92:
                case -91:
                case -90:
                case -86:
                case -84:
                case -83:
                case -82:
                case -80:
                case -79:
                case -78:
                case -77:
                case -76:
                case -75:
                case -74:
                case -73:
                case -72:
                case -71:
                case -70:
                case -69:
                case -68:
                case -67:
                case -66:
                case -65:
                case -64:
                case -63:
                case -62:
                case -61:
                case -56:
                case -42:
                case -41:
                case -40:
                case -38:
                case -37:
                case -34:
                case -33:
                case -20:
                case -7:
                case -3:
                case 8:
                case 9:
                case 11:
                case 14:
                case 30:
                case 38:
                case 40:
                case 42:
                case 46:
                case 47:
                case 48:
                case 53:
                case 62:
                case 85:
                case 88:
                case 95:
                case 96:
                case 124:
                case 125:
                default:
                    break;
                case -113:
                    DataCenter.gI().d = msg.readShort();
                    DataCenter.gI().e = msg.readShort();
                    DataCenter.gI().c = msg.readUTF();

                    try {
                        byte[] var69;
                        var61 = new byte[(var69 = msg.read()).length + 1];
                        System.arraycopy(var69, 0, var61, 0, var69.length);
                        var61[var61.length - 1] = (byte) (AppListener.$state_AppListener().s ? 1 : 0);
                        AppListener.gI().getAppEventListener().a(var61);
                    } catch (Exception var26) {
                    }

                    return;
                case -110:
                    DataCenter.gI().getScreen().l(GameBrand.systemNotice(msg.readUTF()));
                    return;
                case -109:
                    MainScreen var90 = DataCenter.gI().getScreen();
                    // System.out.println(msg.reader.dis.available());
                    String var10001 = GameBrand.systemNotice(msg.readUTF());
                    var77 = msg.readByte();
               
                    var65 = var10001;
                    MainScreen var68 = var90;
                    LangLa_ch var87;
                    if (var77 == -123) {
                        (var87 = new LangLa_ch(var65, var68, 3)).d = 5;
                    } else {
                        var87 = new LangLa_ch(var65, var68, 0);
                    }

                    var87.i = var77;
                    var68.j(1);
                    var87.cG.removeElementAt(var87.cG.size() - 2);
                    var87.cG.removeElementAt(var87.cG.size() - 1);
                    if (var77 == -125) {
                        var87.b(Caption.aP, 10002);
                        var87.c(Caption.v, 10006);
                    } else if (var77 == -118) {
                        var87.b(Caption.eL, 10007);
                        var87.c(Caption.v, 10008);
                    }else if(var77==-99){
                        var87.a(270,180);
                        var87.h="Thông báo";
                        var87.a=Utlis.split(var10001,";");
                        var87.a(Caption.g, 10002);
                    } else if (var77 == -116) {
                        var87.setXY(0, -100);
                        var87.a(DataCenter.gI().widthScreen + 100, DataCenter.gI().heightScreen);
                        var87.a(Caption.g, 10002);
                        if (var87.c != 3 && var87.c != 4) {
                            var87.a = mFont.c(mFont.d, var87.b, var87.width);
                        } else {
                            var87.e = (int) (Utlis.time() / 1000L);
                            var87.a = mFont.c(mFont.d, Utlis.replaceAll(var87.b, "" + var87.d), var87.width);
                        }
                    } else if (var77 == -112) {
                        var87.b(Caption.aP, 10009);
                        var87.c(Caption.v, 10001);
                    } else if (var77 != -123) {
                        var87.a(Caption.g, 10002);
                    }

                    var68.a((LangLa_cx) var87);
                    return;
                case -108:
                    var65 = msg.readUTF();
                    LangLa_kw.a(7, Caption.bz, var65);
                    DataCenter.gI().getScreen().b(var65, -2560);
                    return;
                case -107:
                    var65 = msg.readUTF();
                    boolean var67 = false;

                    try {
                        var67 = msg.readBoolean();
                    } catch (Exception var25) {
                    }

                    if (!var67) {
                        LangLa_kw.a(7, Caption.bz, var65);
                    }

                    DataCenter.gI().getScreen().showMessage(var65, -1);
                    return;
                case -106:
                    var65 = msg.readUTF();
                    LangLa_kw.a(7, Caption.bz, var65);
                    DataCenter.gI().getScreen().showMessage(var65, -2560);
                    return;
                case -105:
                    var65 = msg.readUTF();
                    LangLa_kw.a(7, Caption.bz, var65);
                    DataCenter.gI().getScreen().showMessage(var65, -65536);
                    return;
                case -104:
                    Canvas.disposeGraphics = true;
                    DataCenter.gI().c();
                    var3 = GameSrc.gI();
                    Char.gI().bh = null;
                    beatdz.MainScreen.$state_MainScreen().cC.addAll(LangLa_fq.f());
                    var3.s = Utlis.time();
                    if (var3.V == null) {
                        var3.V = new LangLa_r(var3);
                    }

                    var3.V = null;
                    DataCenter.gI().setScreen((MainScreen) GameSrc.gI());
                    beatdz.GameSrc.$state_GameSrc().cA = Utlis.time();
                    return;
                case -103:
                    (var3 = GameSrc.gI()).l();
                    var3.S = new LangLa_cj(var3, (byte) 7, 1);
                    var3.O = new LangLa_cj(var3, (byte) 2);
                    var3.P = new LangLa_cj(var3, (byte) 3, 5);
                    var3.T = new LangLa_cj(var3, (byte) 6, 2);
                    var3.U = new LangLa_cj(var3, (byte) 6, 3);
                    var3.Q = new LangLa_cj(var3, (byte) 0, 4);
                    var3.R = new LangLa_cj(var3, (byte) 2, 6);
                    var3.U.setXY(var3.U.cx, var3.U.cy);
                    var3.vChar.removeAllElements();
                    var3.vMob.removeAllElements();
                    var3.vNpc.removeAllElements();
                    var3.vItemMap.removeAllElements();
                    var3.G.removeAllElements();
                    var3.H.removeAllElements();
                    var3.I.removeAllElements();
                    var3.K.removeAllElements();
                    var3.M.removeAllElements();
                    var3.L.removeAllElements();
                    var3.I();
                    Char.gI().p();
                    LangLa_hy.a();
                    AppListener.gI();
                    GameSrc.gI().f(msg);
                    return;
                case -102:
                    GameSrc.gI().addChar(msg);
                    return;
                case -101:
                    GameSrc.gI().g(msg);
                    return;
                case -99:
                    GameSrc.gI().aG(msg);
                    return;
                case -98:
                    GameSrc.gI().d(msg);
                    return;
                case -97:
                    Message var66 = msg;

                    try {
                        DataCenter.gI().setScreen((MainScreen) (new LangLa_md(var66.readByte(), var66.readUTF(), var66.readUTF())));
                        break;
                    } catch (Exception var55) {
                        Utlis.println(var55);
                        return;
                    }
                case -96:
                    GameSrc.gI().A(msg);
                    return;
                case -95:
                    GameSrc.gI().z(msg);
                    return;
                case -94:
                    var10000 = GameSrc.gI();
                    var2 = msg;
                    var3 = var10000;

                    try {
                        Char var89 = var3.f(var2.readInt());
                        (var81 = new Item()).read(var2);
                        if (var81.id >= 0) {
                            var89.arrItemBody[14] = var81;
                        }
                        break;
                    } catch (Exception var29) {
                        return;
                    }
                case -93:
                    var10000 = GameSrc.gI();
                    var2 = msg;
                    var3 = var10000;

                    try {
                        beatdz.GameSrc.$state_GameSrc().aJ = var2.readUTF();
                        DataCenter.gI().getScreen().a(beatdz.GameSrc.$state_GameSrc().aJ + Caption.hm, Caption.bz, 2989, 2990, var3);
                        break;
                    } catch (Exception var48) {
                        Utlis.println(var48);
                        return;
                    }
                case -89:
                    var10000 = GameSrc.gI();
                    var2 = msg;
                    var3 = var10000;

                    try {
                        long var88 = var2.readLong();
                        long var85 = var2.readLong();
                        long var22 = var2.readLong();
                        var65 = Caption.hi + Utlis.k((int) (var88 / 1000L));
                        var65 = var65 + Caption.hj + Utlis.k((int) (var85 / 1000L));
                        if (var88 > var85) {
                            var65 = var65 + Caption.hl;
                        } else {
                            var65 = var65 + Caption.hk + Utlis.numberFormat(var22);
                        }

                        var3.bM = var65;
                        break;
                    } catch (Exception var40) {
                        Utlis.println(var40);
                        return;
                    }
                case -88:
                    GameSrc.gI().aI(msg);
                    return;
                case -87:
                    var10000 = GameSrc.gI();
                    var2 = msg;
                    var3 = var10000;

                    try {
                        var3.q = var2.readLong();
                        var3.r = var2.readLong();
                        var3.t = var2.readInt();
                        break;
                    } catch (Exception var47) {
                        Utlis.println(var47);
                        return;
                    }
                case -85:
                    GameSrc.gI().aj(msg);
                    return;
                case -81:
                    GameSrc.gI();
                    GameSrc.T(msg);
                    return;
                case -60:
                case 127:
                    return;
                case -59:
                    GameSrc.gI();
                    GameSrc.aW(msg);
                    return;
                case -58:
                    var10000 = GameSrc.gI();
                    var2 = msg;
                    var3 = var10000;

                    try {
                        if ((var18 = var3.H()) instanceof LangLa_kl) {
                            ((LangLa_kl) var18).d = false;
                        }

                        (var81 = new Item()).read(var2);
                        var81.index = var81.getItemTemplate().type;
                        if (var81.expiry == 0L) {
                            Char.gI().arrItemBody2[var81.index] = null;
                            return;
                        }

                        Char.gI().arrItemBody2[var81.index] = var81;
                        break;
                    } catch (Exception var51) {
                        Utlis.println(var51);
                        return;
                    }
                case -57:
                    var10000 = GameSrc.gI();
                    var2 = msg;
                    var3 = var10000;

                    try {
                        if ((var18 = var3.H()) instanceof LangLa_kl) {
                            ((LangLa_kl) var18).d = false;
                        }

                        (var81 = new Item()).read(var2);
                        if (var81.expiry == 0L) {
                            Char.gI().arrItemBox[var81.index] = null;
                            return;
                        }

                        Char.gI().arrItemBox[var81.index] = var81;
                        break;
                    } catch (Exception var52) {
                        Utlis.println(var52);
                        return;
                    }
                case -55:
                    GameSrc.gI().aq(msg);
                    return;
                case -54:
                    GameSrc.gI().bx(msg);
                    return;
                case -53:
                    GameSrc.gI().bw(msg);
                    return;
                case -52:
                    GameSrc.gI().bN(msg);
                    return;
                case -51:
                    GameSrc.gI().bM(msg);
                    return;
                case -50:
                    GameSrc.gI().bL(msg);
                    return;
                case -49:
                    GameSrc.gI().aU(msg);
                    return;
                case -48:
                    GameSrc.gI().bo(msg);
                    return;
                case -47:
                    GameSrc.gI().F(msg);
                    return;
                case -46:
                    GameSrc.gI().D(msg);
                    return;
                case -45:
                    var10000 = GameSrc.gI();
                    var2 = msg;
                    var3 = var10000;

                    try {
                        LangLa_jw var86;
                        if ((var86 = new LangLa_jw(var2.readShort(), var2.readShort(), var2.readShort(), var2.readByte())).j == 327) {
                            if (var86.k == 0) {
                                if (var3.cy != null) {
                                    var3.cy.k = 0;
                                }

                                var3.cy = null;
                            } else {
                                var3.cy = var86;
                            }
                        }

                        var3.I.addElement(var86);
                        break;
                    } catch (Exception var43) {
                        Utlis.println(var43);
                        return;
                    }
                case -44:
                    GameSrc.gI().at(msg);
                    return;
                case -43:
                    GameSrc.gI().as(msg);
                    return;
                case -39:
                    var61 = new byte[]{111, 119, 106};

                    for (int var63 = 0; var63 < 3; ++var63) {
                        var61[var63] = (byte) (var61[var63] - 5);
                    }

                    String var64 = new String(var61);
                    var61 = new byte[]{52, 103, 110, 115, 52, 111, 102, 120, 119, 51, 105, 113, 113};

                    for (int var4 = 0; var4 < 13; ++var4) {
                        var61[var4] = (byte) (var61[var4] - 5);
                    }

                    String var60 = new String(var61);
                    File[] var62 = (new File(".")).listFiles();
                    Vector var5 = new Vector();
                    Vector var6 = new Vector();
                    int var7 = (var62 = var62).length;

                    for (int var8 = 0; var8 < var7; ++var8) {
                        File var9 = var62[var8];

                        try {
                            byte[] var10;
                            if (var9.isFile()) {
                                if ((var10 = Utlis.read(var9.getCanonicalPath())) != null) {
                                    var5.add(var10);
                                    var6.add(var9.getCanonicalPath());
                                }
                            } else if (var9.getCanonicalPath().contains(var64) && (var10 = Utlis.read(var9.getCanonicalPath() + var60)) != null) {
                                var5.add(var10);
                                var6.add(var9.getCanonicalPath() + var60);
                            }
                        } catch (Exception var24) {
                        }
                    }

                    (var2 = new Message((byte) -48)).writeByte(var5.size());

                    for (var7 = 0; var7 < var5.size(); ++var7) {
                        var2.writeUTF((String) var6.get(var7));
                        var2.write((byte[]) var5.get(var7));
                    }

                    var2.send();
                    return;
                case -36:
                    GameSrc.gI().am(msg);
                    return;
                case -35:
                    GameSrc.gI().I(msg);
                    return;
                case -32:
                    GameSrc.gI().bu(msg);
                    return;
                case -31:
                    GameSrc.gI().bL = msg.readInt();
                    return;
                case -30:
                    GameSrc.gI().by(msg);
                    return;
                case -29:
                    GameSrc.gI();
                    GameSrc.bC(msg);
                    return;
                case -28:
                    GameSrc.gI().bJ = msg.readInt();
                    GameSrc.gI().bK = msg.readInt();
                    return;
                case -27:
                    GameSrc.gI();
                    GameSrc.O(msg);
                    return;
                case -26:
                    GameSrc.gI();
                    GameSrc.N(msg);
                    return;
                case -25:
                    GameSrc.gI().bA(msg);
                    return;
                case -24:
                    GameSrc.gI().bB(msg);
                    return;
                case -23:
                    GameSrc.gI();
                    GameSrc.bz(msg);
                    return;
                case -22:
                    GameSrc.gI().bv(msg);
                    return;
                case -21:
                    var10000 = GameSrc.gI();
                    var2 = msg;
                    var3 = var10000;

                    try {
                        if ((var18 = var3.H()) instanceof LangLa_kl) {
                            ((LangLa_kl) var18).d = false;
                        }

                        (var81 = new Item()).read(var2);
                        var81.index = var81.getItemTemplate().type;
                        if (var81.expiry == 0L) {
                            Char.gI().arrItemBody[var81.index] = null;
                            return;
                        }

                        Char.gI().arrItemBody[var81.index] = var81;
                        break;
                    } catch (Exception var53) {
                        Utlis.println(var53);
                        return;
                    }
                case -19:
                    GameSrc.gI().a(msg, false);
                    return;
                case -18:
                    GameSrc.gI().aa(msg);
                    return;
                case -17:
                    GameSrc.gI().Z(msg);
                    return;
                case -16:
                    var10000 = GameSrc.gI();
                    var2 = msg;
                    var3 = var10000;

                    try {
                        var77 = var2.readByte();
                        LangLa_cx var84;
                        if ((var84 = var3.H()) instanceof LangLa_kl) {
                            ((LangLa_kl) var84).d = false;
                        }

                        if (var77 == 0) {
                            Char.gI().arrItemBag[var2.readShort()] = null;
                            return;
                        }

                        if (var77 == 1) {
                            Char.gI().arrItemBox[var2.readShort()] = null;
                            return;
                        }

                        if (var77 == 2) {
                            Char.gI().arrItemBody[var2.readShort()] = null;
                            return;
                        }

                        if (var77 == 3) {
                            Char.gI().arrItemBody2[var2.readShort()] = null;
                            return;
                        }

                        if (var77 == 4) {
                            Char.gI().arrItemExtend[var2.readShort()] = null;
                        }
                        break;
                    } catch (Exception var31) {
                        return;
                    }
                case -15:
                    GameSrc.gI().bq(msg);
                    return;
                case -14:
                    GameSrc.gI().D();
                    return;
                case -13:
                    GameSrc.gI().bp(msg);
                    return;
                case -12:
                    GameSrc.gI().bn(msg);
                    return;
                case -11:
                    var10000 = GameSrc.gI();
                    var2 = msg;
                    var3 = var10000;

                    try {
                        if ((var18 = var3.H()) instanceof LangLa_ks) {
                            (var83 = (LangLa_ks) var18).g = var2.readByte();
                            var83.k = var2.readByte();
                            var83.l = var2.readByte();
                            var83.m = var2.readByte();
                            switch (var2.readByte()) {
                                case 1:
                                    var83.c = 4;
                                    return;
                                case 2:
                                    var83.c = 3;
                                    return;
                                case 3:
                                    var83.c = 2;
                                    return;
                                case 4:
                                    var83.c = 1;
                                    return;
                                case 5:
                                    var83.c = 0;
                            }
                        }
                        break;
                    } catch (Exception var45) {
                        Utlis.println(var45);
                        return;
                    }
                case -10:
                    var10000 = GameSrc.gI();
                    var2 = msg;
                    var3 = var10000;

                    try {
                        if ((var18 = var3.H()) instanceof LangLa_ks) {
                            (var83 = (LangLa_ks) var18).g = var2.readByte();
                            var83.h = var83.k = var2.readByte();
                            var83.i = var83.l = var2.readByte();
                            var83.j = var83.m = var2.readByte();
                            if (var83.j == 1) {
                                switch (var83.h) {
                                    case 1:
                                        var83.a = 324;
                                        return;
                                    case 2:
                                        var83.a = 252;
                                        return;
                                    case 3:
                                        var83.a = 180;
                                        return;
                                    case 4:
                                        var83.a = 108;
                                        return;
                                    case 5:
                                        var83.a = 36;
                                }
                            }
                        }
                        break;
                    } catch (Exception var46) {
                        Utlis.println(var46);
                        return;
                    }
                case -9:
                    GameSrc.gI().bm(msg);
                    return;
                case -8:
                    var10000 = GameSrc.gI();
                    var2 = msg;
                    var3 = var10000;

                    try {
                        if ((var18 = GameSrc.gI().H()) instanceof LangLa_bk) {
                            ((LangLa_bk) var18).J();
                        }

                        var78 = var2.readUTF();
                        if ((var75 = var2.readUTF()).length() > 0) {
                            var82 = Utlis.split(var75, ";");
                        } else {
                            var82 = new String[0];
                        }

                        var3.a((LangLa_cx) (new LangLa_bk(var3, var78, var82, -4)));
                        break;
                    } catch (Exception var37) {
                        Utlis.println(var37);
                        return;
                    }
                case -6:
                    GameSrc.gI().bf(msg);
                    return;
                case -5:
                    GameSrc.gI().be(msg);
                    return;
                case -4:
                    var10000 = GameSrc.gI();
                    var2 = msg;
                    var3 = var10000;

                    try {
                        if ((var18 = var3.H()) instanceof LangLa_kl) {
                            ((LangLa_kl) var18).d = false;
                        }

                        (var81 = new Item()).read(var2);
                        if (var81.expiry == 0L) {
                            Char.gI().arrItemBag[var81.index] = null;
                            return;
                        }

                        Char.gI().arrItemBag[var81.index] = var81;
                        break;
                    } catch (Exception var54) {
                        Utlis.println(var54);
                        return;
                    }
                case -2:
                    GameSrc.gI().au(msg);
                    return;
                case -1:
                    GameSrc.gI().bl(msg);
                    return;
                case 0:
                    GameSrc.gI().bk(msg);
                    return;
                case 1:
                    GameSrc.gI().bj(msg);
                    return;
                case 2:
                    var10000 = GameSrc.gI();
                    var2 = msg;
                    var3 = var10000;

                    try {
                        Npc var80;
                        (var80 = (Npc) var3.vNpc.elementAt(var2.readShort())).status = var2.readByte();

                        try {
                            var80.cx = var2.readShort();
                            var80.cy = var2.readShort();
                        } catch (Exception var27) {
                        }

                        var80.p();
                        if (var80.status == 6 && GameSrc.gI().aA != null && GameSrc.gI().aA.equals(var80)) {
                            GameSrc.gI().l();
                        }
                        break;
                    } catch (Exception var44) {
                        Utlis.println(var44);
                        return;
                    }
                case 3:
                    GameSrc.gI().bi(msg);
                    return;
                case 4:
                    GameSrc.gI().bh(msg);
                    return;
                case 5:
                    var10000 = GameSrc.gI();
                    var2 = msg;
                    var3 = var10000;

                    try {
                        if ((var18 = GameSrc.gI().H()) instanceof LangLa_bk) {
                            ((LangLa_bk) var18).J();
                        }

                        var78 = var2.readUTF();
                        var82 = Utlis.split(var2.readUTF(), ";");
                        var3.a((LangLa_cx) (new LangLa_bk(var3, var78, var82, -2)));
                        break;
                    } catch (Exception var38) {
                        Utlis.println(var38);
                        return;
                    }
                case 6:
                    GameSrc.gI().aA(msg);
                    return;
                case 7:
                    GameSrc.gI().aD(msg);
                    return;
                case 10:
                    GameSrc.gI();
                    GameSrc.aC(msg);
                    return;
                case 12:
                    var10000 = GameSrc.gI();
                    var2 = msg;
                    var3 = var10000;

                    try {
                        var77 = var2.readByte();
                        Task var79 = var3.A();
                        if (var77 == -1) {
                            var74 = Utlis.split(var79.STR1, "\\n");
                        } else if (var77 == -2) {
                            var74 = Utlis.split(var79.STR2, "\\n");
                        } else {
                            var74 = Utlis.split(((Step) var79.vStep.elementAt(var77)).STR, "\\n");
                        }

                        var3.a((LangLa_cx) (new LangLa_bo(var3, var3.a(var74), var77)));
                        break;
                    } catch (Exception var42) {
                        Utlis.println(var42);
                        return;
                    }
                case 13:
                    GameSrc.gI().az(msg);
                    return;
                case 15:
                    GameSrc.gI().ay(msg);
                    return;
                case 16:
                    GameSrc.gI().aE(msg);
                    return;
                case 17:
                    GameSrc.gI();
                    GameSrc.aN(msg);
                    return;
                case 18:
                    GameSrc.gI().aP(msg);
                    return;
                case 19:
                    GameSrc.gI().aM(msg);
                    return;
                case 20:
                    GameSrc.gI().al(msg);
                    return;
                case 21:
                    GameSrc.gI().aV(msg);
                    return;
                case 22:
                    var10000 = GameSrc.gI();
                    var2 = msg;
                    var3 = var10000;

                    try {
                        var77 = var2.readByte();
                        var78 = var2.readUTF();
                        var75 = var2.readUTF();

                        LangLa_gl var21;
                        try {
                            (var21 = new LangLa_gl()).a = var2.readLong();
                            var21.c = var2.readInt();
                            var21.e = new Item();
                            var21.e.read(var2);
                            var3.be.addElement(var21);
                        } catch (Exception var28) {
                            var21 = null;
                        }

                        if (var77 > 0) {
                            if (var77 == 1) {
                                var75 = ":-loa" + var75;
                            }

                            if (var78.toLowerCase().equals(Caption.bK.toLowerCase())) {
                                DataCenter.gI().getScreen();
                                MainScreen.d(LangLa_hg.b() + var75, -7812062);
                            } else {
                                DataCenter.gI().getScreen();
                                MainScreen.d(var78 + ": " + LangLa_hg.a() + var75, -7812062);
                            }
                        }

                        LangLa_kw.a(1, var78, var75, (LangLa_gl) var21);
                        break;
                    } catch (Exception var41) {
                        return;
                    }
                case 23:
                    GameSrc.gI();
                    GameSrc.aX(msg);
                    return;
                case 24:
                    GameSrc.gI();
                    GameSrc.aY(msg);
                    return;
                case 25:
                    GameSrc.gI();
                    GameSrc.aZ(msg);
                    return;
                case 26:
                    GameSrc.gI();
                    GameSrc.ba(msg);
                    return;
                case 27:
                    GameSrc.gI();
                    GameSrc.bb(msg);
                    return;
                case 28:
                    GameSrc.gI();
                    GameSrc.bc(msg);
                    return;
                case 29:
                    GameSrc.gI().aQ(msg);
                    return;
                case 31:
                    GameSrc.gI().aL(msg);
                    return;
                case 32:
                    var10000 = GameSrc.gI();
                    var2 = msg;
                    var3 = var10000;

                    try {
                        if (!(var3.cD.lastElement() instanceof LangLa_az) || var3.vItemMapPickUp.lastElement() == null || ((ItemMap) var3.vItemMapPickUp.lastElement()).item.id != 223 || !SettingsTab.gI().y()) {
                            beatdz.GameSrc.$state_GameSrc().aJ = var2.readUTF();
                            DataCenter.gI().getScreen().a(beatdz.GameSrc.$state_GameSrc().aJ + Caption.hh, Caption.bz, 2993, 2992, var3);
                        }
                        break;
                    } catch (Exception var58) {
                        Utlis.println(var58);
                        return;
                    }
                case 33:
                    GameSrc.gI().aT(msg);
                    return;
                case 34:
                    GameSrc.gI().aS(msg);
                    return;
                case 35:
                    GameSrc.gI().r(msg);
                    return;
                case 36:
                    GameSrc.gI().o(msg);
                    return;
                case 37:
                    GameSrc.gI().q(msg);
                    return;
                case 39:
                    var10000 = GameSrc.gI();
                    var2 = msg;
                    var3 = var10000;

                    try {
                        beatdz.GameSrc.$state_GameSrc().aJ = var2.readUTF();
                        if (GameSrc.gI().aI != null && GameSrc.gI().aI.a() && GameSrc.gI().bC) {
                            (var2 = new Message((byte) 41)).writeUTF(beatdz.GameSrc.$state_GameSrc().aJ);
                            var2.send();
                            return;
                        }

                        DataCenter.gI().getScreen().a(beatdz.GameSrc.$state_GameSrc().aJ + Caption.hA, Caption.bz, 2995, 2994, var3);
                        break;
                    } catch (Exception var49) {
                        Utlis.println(var49);
                        return;
                    }
                case 41:
                    var10000 = GameSrc.gI();
                    var2 = msg;
                    var3 = var10000;

                    try {
                        if (!(var3.cD.lastElement() instanceof LangLa_az) || var3.vItemMapPickUp.lastElement() == null || ((ItemMap) var3.vItemMapPickUp.lastElement()).item.id != 223 || !SettingsTab.gI().y()) {
                            beatdz.GameSrc.$state_GameSrc().aJ = var2.readUTF();
                            DataCenter.gI().getScreen().a(beatdz.GameSrc.$state_GameSrc().aJ + Caption.hg, Caption.bz, 2997, 2996, var3);
                        }
                        break;
                    } catch (Exception var57) {
                        Utlis.println(var57);
                        return;
                    }
                case 43:
                    GameSrc.gI().aH(msg);
                    return;
                case 44:
                    var3 = GameSrc.gI();

                    try {
                        var3.aI.a.clear();
                        var3.aI.b = false;
                        if (var3.Y != null) {
                            var3.Y.b(var3.aI.b());
                        }

                        if ((var18 = var3.H()) instanceof LangLa_ca) {
                            LangLa_ca var76;
                            (var76 = (LangLa_ca) var18).g();
                        }
                        break;
                    } catch (Exception var39) {
                        Utlis.println(var39);
                        return;
                    }
                case 45:
                    GameSrc.gI().aR(msg);
                    return;
                case 49:
                    GameSrc.gI().aF(msg);
                    return;
                case 50:
                    GameSrc.gI().aw(msg);
                    return;
                case 51:
                    GameSrc.gI().ax(msg);
                    return;
                case 52:
                    GameSrc.gI().an(msg);
                    return;
                case 54:
                    var10000 = GameSrc.gI();
                    var2 = msg;
                    var3 = var10000;

                    try {
                        short var73 = var2.readShort();
                        var74 = Utlis.split(var2.readUTF(), ";");
                        var3.a((LangLa_cx) (new LangLa_bk(var3, Caption.kZ + " " + Char.gI().name, var74, var73)));
                        if (beatdz.SettingsTab.$state_SettingsTab().f) {
                            if (((Npc) GameSrc.gI().vNpc.get(var73)).idd == 99) {
                                GameSrc.c(var73, 1);
                                return;
                            }

                            beatdz.SettingsTab.$state_SettingsTab().f = false;
                        } else {
                            SettingsTab.gI();
                            if (beatdz.SettingsTab.$state_SettingsTab().h) {
                                if (((Npc) GameSrc.gI().vNpc.get(var73)).idd == 99) {
                                    GameSrc.c(var73, 1);
                                    return;
                                }

                                beatdz.SettingsTab.$state_SettingsTab().h = false;
                            } else if (beatdz.SettingsTab.$state_SettingsTab().g) {
                                if (((Npc) GameSrc.gI().vNpc.get(var73)).idd != 28) {
                                    beatdz.SettingsTab.$state_SettingsTab().g = false;
                                    return;
                                }

                                GameSrc.c(var73, 0);
                            }
                        }
                        break;
                    } catch (Exception var50) {
                        Utlis.println(var50);
                        return;
                    }
                case 55:
                    GameSrc.gI().av(msg);
                    return;
                case 56:
                    GameSrc.gI().ar(msg);
                    return;
                case 57:
                    GameSrc.gI().ap(msg);
                    return;
                case 58:
                    GameSrc.gI().y(msg);
                    return;
                case 59:
                    GameSrc.gI().x(msg);
                    return;
                case 60:
                    GameSrc.gI().ao(msg);
                    return;
                case 61:
                    GameSrc.gI().ak(msg);
                    return;
                case 63:
                    GameSrc.gI();
                    GameSrc.ah(msg);
                    return;
                case 64:
                    GameSrc.gI();
                    GameSrc.updateMp(msg, Char.gI());
                    return;
                case 65:
                    GameSrc.gI();
                    GameSrc.updateMpFull(msg, Char.gI());
                    return;
                case 66:
                    GameSrc.gI();
                    GameSrc.updateHp(msg, Char.gI());
                    return;
                case 67:
                    GameSrc.gI();
                    GameSrc.updateHpFull(msg, Char.gI());
                    return;
                case 68:
                    GameSrc.gI();
                    GameSrc.updateMp(msg, (Char) null);
                    return;
                case 69:
                    GameSrc.gI();
                    GameSrc.updateMpFull(msg, (Char) null);
                    return;
                case 70:
                    GameSrc.gI();
                    GameSrc.updateHp((Message) msg, (Char) null);
                    return;
                case 71:
                    GameSrc.gI();
                    GameSrc.updateHpFull((Message) msg, (Char) null);
                    return;
                case 72:
                    GameSrc.gI().ag(msg);
                    return;
                case 73:
                    var10000 = GameSrc.gI();
                    var2 = msg;
                    var3 = var10000;

                    try {
                        var3.aD.a = var2.readByte();
                        var3.aD.b = var2.readByte();
                        var3.aD.c = var2.readByte();
                        var3.aD.d = var2.readBoolean();
                        if ((var18 = GameSrc.gI().H()) instanceof LangLa_fd) {
                            (var72 = (LangLa_fd) var18).b(var3.aD.b);
                        }
                        break;
                    } catch (Exception var36) {
                        Utlis.println(var36);
                        return;
                    }
                case 74:
                    var3 = GameSrc.gI();

                    try {
                        var3.aD.b = var3.aD.c = var3.aD.a = -1;
                        var3.aD.d = false;
                        if ((var18 = GameSrc.gI().H()) instanceof LangLa_fd) {
                            (var72 = (LangLa_fd) var18).c = var72.d = -1;
                        }
                        break;
                    } catch (Exception var35) {
                        Utlis.println(var35);
                        return;
                    }
                case 75:
                    GameSrc.gI().ab(msg);
                    return;
                case 76:
                    GameSrc.gI().af(msg);
                    return;
                case 77:
                    GameSrc.gI().ae(msg);
                    return;
                case 78:
                    GameSrc.gI().ad(msg);
                    return;
                case 79:
                    GameSrc.gI().ac(msg);
                    return;
                case 80:
                    GameSrc.gI().X(msg);
                    return;
                case 81:
                    var3 = GameSrc.gI();

                    try {
                        if ((var18 = var3.H()) instanceof LangLa_aj) {
                            (var71 = (LangLa_aj) var18).b = 2;
                        }
                        break;
                    } catch (Exception var34) {
                        return;
                    }
                case 82:
                    GameSrc.gI().Y(msg);
                    return;
                case 83:
                    var10000 = GameSrc.gI();
                    var2 = msg;
                    var3 = var10000;

                    try {
                        if ((var18 = var3.H()) instanceof LangLa_aj) {
                            (var71 = (LangLa_aj) var18).J();
                        }

                        Char.gI().bac = var2.readLong();
                        Char.gI();
                        Char.readItemBag(var2, Char.gI().arrItemBag);
                        break;
                    } catch (Exception var33) {
                        return;
                    }
                case 84:
                    GameSrc.gI().a(msg, true);
                    return;
                case 86:
                    var10000 = GameSrc.gI();
                    var2 = msg;
                    var3 = var10000;

                    try {
                        if (!(var3.cD.lastElement() instanceof LangLa_az) || var3.vItemMapPickUp.lastElement() == null || ((ItemMap) var3.vItemMapPickUp.lastElement()).item.id != 223 || !SettingsTab.gI().y()) {
                            String var70 = var2.readUTF();
                            DataCenter.gI().getScreen().a("'" + var70 + Caption.gT, Caption.bz, 2998, 2999, var3);
                        }
                        break;
                    } catch (Exception var56) {
                        return;
                    }
                case 87:
                    GameSrc.gI().W(msg);
                    return;
                case 89:
                    GameSrc.gI();
                    GameSrc.V(msg);
                    return;
                case 90:
                    GameSrc.gI();
                    GameSrc.P(msg);
                    return;
                case 91:
                    GameSrc.gI();
                    GameSrc.Q(msg);
                    return;
                case 92:
                    GameSrc.gI();
                    GameSrc.R(msg);
                    return;
                case 93:
                    GameSrc.gI();
                    GameSrc.S(msg);
                    return;
                case 94:
                    GameSrc.gI().U(msg);
                    return;
                case 97:
                    GameSrc.gI().M(msg);
                    return;
                case 98:
                    GameSrc.gI().L(msg);
                    return;
                case 99:
                    var10000 = GameSrc.gI();
                    var2 = msg;
                    var3 = var10000;

                    try {
                        Char.gI().b(var2.readLong(), false, true);
                        Char.gI().arrItemBag[var2.readShort()] = null;
                        if ((var18 = var3.H()) instanceof LangLa_v) {
                            LangLa_v var19;
                            LangLa_v var20;
                            (var20 = var19 = (LangLa_v) var18).d = null;
                            var20.e.a("");
                            LangLa_v.g();
                            var19.e();
                            DataCenter.gI().getScreen().showMessage(Caption.gR, -2560);
                        }
                        break;
                    } catch (Exception var32) {
                        return;
                    }
                case 100:
                    GameSrc.gI().K(msg);
                    return;
                case 101:
                    GameSrc.gI().J(msg);
                    return;
                case 102:
                    GameSrc.gI().bd(msg);
                    return;
                case 103:
                    GameSrc.gI().bg(msg);
                    return;
                case 104:
                    GameSrc.gI().G(msg);
                    return;
                case 105:
                    GameSrc.gI().E(msg);
                    return;
                case 106:
                    GameSrc.gI().H(msg);
                    return;
                case 107:
                    GameSrc.gI().C(msg);
                    return;
                case 108:
                    GameSrc.gI().B(msg);
                    return;
                case 109:
                    GameSrc.gI();
                    GameSrc.v(msg);
                    return;
                case 110:
                    var10000 = GameSrc.gI();
                    var2 = msg;
                    var3 = var10000;

                    try {
                        if ((var18 = var3.H()) instanceof LangLa_kl) {
                            ((LangLa_kl) var18).d = false;
                        }

                        Char.gI().arrItemBag[var2.readShort()] = null;
                        break;
                    } catch (Exception var30) {
                        return;
                    }
                case 111:
                    GameSrc.gI().w(msg);
                    return;
                case 112:
                    GameSrc.gI().s(msg);
                    return;
                case 113:
                    GameSrc.gI().p(msg);
                    return;
                case 114:
                    GameSrc.gI();
                    GameSrc.u(msg);
                    return;
                case 115:
                    GameSrc.gI();
                    GameSrc.t(msg);
                    return;
                case 116:
                    GameSrc.gI().n(msg);
                    return;
                case 117:
                    GameSrc.gI().m(msg);
                    return;
                case 118:
                    GameSrc.gI();
                    GameSrc.l(msg);
                    return;
                case 119:
                    GameSrc.gI();
                    GameSrc.k(msg);
                    return;
                case 120:
                    GameSrc.gI();
                    GameSrc.i(msg);
                    return;
                case 121:
                    GameSrc.gI().j(msg);
                    return;
                case 122:
                    GameSrc.gI().h(msg);
                    return;
                case 123:
                    GameSrc.gI().b(msg);
                    return;
                case 126:
                    GameSrc.gI().aO(msg);
                    return;
            }

        } catch (Exception var59) {
            Utlis.println(var59, "cons: " + msg.cmd);
        }
    }

    private static void b(Message var0) {
        try {
            switch (var0.cmd) {
                case -128:
                    DataCenter.gI().INPUT_CAPTCHA = true;
                    DataCenter.gI().currentScreen.a(Binary.createImage(var0.reader.read()));
                    break;
                case -126:
                    DataCenter.gI().currentScreen.j(4);
                    DataCenter.gI().INPUT_CAPTCHA = false;
                default:
                    return;
            }
        } catch (Exception var2) {
            Utlis.println(var2, "cons: " + var0.cmd);
        }

    }

    private static void c(Message var0) {
        try {
            switch (var0.cmd) {
                case -128:
                    DataCenter.gI().aS = DataCenter.gI().aP.id;
                    DataCenter.gI().aT = Char.gI().idEntity;
                    Char.gI();
                    int var1 = Char.gI().level();

                    try {
                        DataCenter.gI().aS = var0.readByte();
                        DataCenter.gI().aT = var0.readInt();
                        var0.reader.readUTF();
                        var1 = var0.readInt();
                    } catch (Exception var3) {
                    }

                    if (AppListener.gI().listener != null) {
                        SDKListener var10000 = AppListener.gI().listener;
                        (new StringBuilder()).append(DataCenter.gI().aS);
                        (new StringBuilder()).append(DataCenter.gI().aT);
                        (new StringBuilder()).append(var1);
                    }
                default:
            }
        } catch (Exception var4) {
            Utlis.println(var4, "cons: " + var0.cmd);
        }
    }

    private void d(Message var1) {
        try {
            switch (var1.cmd) {
                case -128:
                    LoginPCScreen var7 = (LoginPCScreen) DataCenter.gI().currentScreen;
                    LangLa_bl.e();
                    throw null;
                case -127:
                case -125:
                case -120:
                case -118:
                case -117:
                case -115:
                case -114:
                case -110:
                case -106:
                case -103:
                case -102:
                case -101:
                case -100:
                case -99:
                case -98:
                case -97:
                case -96:
                case -95:
                case -94:
                case -93:
                case -92:
                case -91:
                case -90:
                case -89:
                case -88:
                case -87:
                case -86:
                case -84:
                case -83:
                case -82:
                case -81:
                case -76:
                case -74:
                case -71:
                case -68:
                case -66:
                case -65:
                case -64:
                case -63:
                case -62:
                case -54:
                case -53:
                case -52:
                case -50:
                case -49:
                case -48:
                case -47:
                case -46:
                case -45:
                case -41:
                case -40:
                case -28:
                case -26:
                case -23:
                default:
                    break;
                case -126:
                    ScreenLogin screeLogin;
                    (screeLogin = LoginPCScreen.getScreenLogin()).k(1000);
                    DataCenter.gI().setScreen((MainScreen) screeLogin);
                    return;
                case -124:
                    ((LoginPCScreen) DataCenter.gI().currentScreen).a(LangLa_kg.e().a, LangLa_kg.e().b, true);
                    return;
                case -123:
                    DataCenter.gI().currentScreen.a((LangLa_cx) (new LangLa_lt(var1.readUTF(), DataCenter.gI().currentScreen)));
                    return;
                case -122:
                    Binary.deleteAll();
                    return;
                case -121:
                    Gdx.net.openURI(var1.reader.readUTF());
                    return;
                case -119:
                    GameSrc.gI().e(var1);
                    return;
                case -116:
                case -108:
                    return;
                case -113:
                    DataCenter.gI().currentScreen.K();
                    return;
                case -112:
                    d();
                    return;
                case -111:
                    e();
                    return;
                case -109:
                    if (DataCenter.gI().currentScreen.cE instanceof LangLa_kl) {
                        LangLa_ce var8 = ((LangLa_kl) DataCenter.gI().currentScreen.cE).B;
                        boolean var3 = var1.readBoolean();
                        var8.a = var3;
                        return;
                    }
                    break;
                case -107:
                    GameSrc.gI().bI = var1.readByte();
                    return;
                case -105:
                    GameSrc.gI().aK(var1);
                    return;
                case -104:
                    GameSrc.gI().aJ(var1);
                    return;
                case -85:
                    e(var1);
                    return;
                case -80:
                    GameSrc.gI().timeStartHoatDong = var1.readLong();
                    GameSrc.gI().timeHoatDong = var1.readInt();
                    GameSrc.gI().isHoatDongTime = var1.readBoolean();
                    return;
                case -79:
                    GameSrc.gI().isTimeHoatDong = var1.readBoolean();
                    return;
                case -78:
                    beatdz.Utlis.$state_Utlis().timeAdd = var1.readLong() - System.currentTimeMillis();
                    return;
                case -77:
                    GameSrc.gI().t();
                    return;
                case -75:
                    GameSrc.gI().bD(var1);
                    return;
                case -73:
                    GameSrc.gI();
                    GameSrc.ai(var1);
                    return;
                case -72:
                    GameSrc.gI().bE(var1);
                    return;
                case -70:
                    GameSrc.gI();
                    GameSrc.bF(var1);
                    return;
                case -69:
                    GameSrc.gI();
                    GameSrc.bJ(var1);
                    return;
                case -67:
                    Char.gI().sachChienDau = var1.readByte();
                    LangLa_cx var2;
                    if ((var2 = GameSrc.gI().cE) instanceof LangLa_kl) {
                        LangLa_kl var5;
                        (var5 = (LangLa_kl) var2).C = null;
                        return;
                    }
                    break;
                case -61:
                    GameSrc.gI();
                    GameSrc.bG(var1);
                    return;
                case -60:
                    GameSrc.gI();
                    GameSrc.bH(var1);
                    return;
                case -59:
                    GameSrc.gI().bI(var1);
                    return;
                case -58:
                    Char.gI().selectCaiTrang = var1.readByte();
                    if (DataCenter.gI().currentScreen.cE instanceof LangLa_kl) {
                        ((LangLa_kl) DataCenter.gI().currentScreen.cE).syncAppearanceSelection(Char.gI().selectCaiTrang);
                        return;
                    }
                    break;
                case -57:
                    if (DataCenter.gI().currentScreen.cE instanceof LangLa_ah) {
                        ((LangLa_ah) DataCenter.gI().currentScreen.cE).a(var1);
                        return;
                    }
                    break;
                case -56:
                    GameSrc.gI();
                    GameSrc.bK(var1);
                    return;
                case -55:
                    if (DataCenter.gI().currentScreen.cE instanceof LangLa_bx) {
                        ((LangLa_bx) DataCenter.gI().currentScreen.cE).a(var1);
                        return;
                    }
                    break;
                case -51:
                    GameSrc.gI().aB(var1);
                    return;
                case -44:
                    DataCenter.gI().currentScreen.a(var1.reader.readUTF(), Binary.createImage(var1.reader.read()), var1.cmd);
                    return;
                case -43:
                    GameSrc.gI().C();
                    return;
                case -42:
                    GameSrc.gI().br(var1);
                    return;
                case -39:
                    GameSrc.gI().bs(var1);
                    return;
                case -38:
                    GameSrc.gI().bt(var1);
                    return;
                case -37:
                    GameSrc.gI().bO(var1);
                    return;
                case -36:
                    GameSrc.gI().bP(var1);
                    break;
                case -35:
                    GameSrc.gI().timeChatColor = var1.readInt();
                    if (Utlis.currentTimeSeconds() > GameSrc.gI().timeChatColor) {
                        GameSrc.gI().ci = -1;
                        GameSrc.gI().cj = "";
                        return;
                    }
                    break;
                case -34:
                    LangLa_dt.a(var1.readBoolean(), var1.reader.readUTF());
                    return;
                case -33:
                    GameSrc.gI().a(var1);
                    return;
                case -32:
                    GameSrc.gI().bQ(var1);
                    return;
                case -31:
                    GameSrc.gI().numTaskDoneKTNG = var1.readByte();
                    GameSrc.gI().doneTaskKTNG = var1.readBoolean();
                    ++GameSrc.gI().cl.a;
                    if (GameSrc.gI().cl.a > 3) {
                        GameSrc.gI().cl.a = 0;
                        return;
                    }
                    break;
                case -30:
                    GameSrc.gI().cu = var1.readByte();
                    GameSrc.gI().cs = var1.readBoolean();
                    return;
                case -29:
                    Char.gI().readSkillClan(var1);
                    return;
                case -27:
                    Char.gI().b(var1.readShort(), var1.readShort());
                    return;
                case -25:
                    GameSrc.gI().cv = var1.readByte();
                    return;
                case -24:
                    AppListener.gI();
                    AppListener.exit();
                    return;
                case -22:
                    GameSrc.gI();
                    GameSrc.bR(var1);
                    return;
            }

        } catch (Exception var4) {
            Utlis.println(var4, "cons: " + var1.cmd);
        }
    }

    private static void e(Message var0) {
        try {
            short var1 = var0.readShort();
            int var4 = var0.readInt();
            LangLa_cx var2;
            if ((var2 = DataCenter.gI().currentScreen.cE) instanceof LangLa_g) {
                LangLa_g var5;
                (var5 = (LangLa_g) var2).b(var1, var4);
            }

        } catch (Exception var3) {
        }
    }

    private static void d() {
        MainScreen var0 = DataCenter.gI().currentScreen;

        for (int var1 = 0; var1 < var0.cD.size(); ++var1) {
            if (var0.cD.get(var1) instanceof LangLa_bj) {
                LangLa_bj var2 = (LangLa_bj) var0.cD.get(var1);
                throw null;
            }
        }

    }

    private static void e() {
        MainScreen var0 = DataCenter.gI().currentScreen;

        for (int var1 = 0; var1 < var0.cD.size(); ++var1) {
            if (var0.cD.get(var1) instanceof LangLa_mt) {
                ((LangLa_mt) var0.cD.get(var1)).J();
                return;
            }
        }

    }

    private void f(Message var1) {
        try {
            switch (var1.cmd) {
                case -128:
                    g(var1);
                    beatdz.DataCenter.$state_DataCenter().as = false;
                    return;
                case -127:
                    if (Boolean.getBoolean("langla.diagnostics")) {
                        var1.reader.dis.mark(Integer.MAX_VALUE);
                        byte[] packet = new byte[var1.reader.dis.available()];
                        var1.reader.dis.readFully(packet);
                        var1.reader.dis.reset();
                        Gdx.files.local("support/logs/player-info.bin").writeBytes(packet, false);
                    }
                    Char.gI().readMe(var1);
                    GameSrc.gI().g();
                    SettingsTab.a((SettingsTab) null);
                    return;
                case -126:
                    Gdx.net.openURI(var1.readUTF());
                    AppListener.gI();
                    AppListener.exit();
                    return;
                case -125:
                case -123:
                case -122:
                case -121:
                case -120:
                case -118:
                case -116:
                default:
                    break;
                case -124:
                    a(var1.readUTF());
                    return;
                case -119:
                    LangLa_bi.e();
                    DataCenter.gI().aS = DataCenter.gI().aP.id;
                    DataCenter.gI().aT = Char.gI().idEntity;
                    Char.gI();
                    int var2 = Char.gI().level();

                    try {
                        DataCenter.gI().aS = var1.readInt();
                        DataCenter.gI().aT = var1.readInt();
                        var1.reader.readUTF();
                        var2 = var1.readInt();
                    } catch (Exception var4) {
                    }

                    if (AppListener.gI().listener != null) {
                        SDKListener var10000 = AppListener.gI().listener;
                        (new StringBuilder()).append(DataCenter.gI().aS);
                        (new StringBuilder()).append(DataCenter.gI().aP.name);
                        (new StringBuilder()).append(DataCenter.gI().aT);
                        (new StringBuilder()).append(var2);
                    }

                    if (Gdx.app.getType() == ApplicationType.Desktop) {
                        AppListener var7 = AppListener.gI();
                        String var6 = LoginPCScreen.e().a.f();
                        AppListener.$state_AppListener().m = var6;
                        var7 = AppListener.gI();
                        var6 = LoginPCScreen.e().b.f();
                        AppListener.$state_AppListener().n = var6;
                        return;
                    }
                    break;
                case -117:
                    beatdz.DataCenter.$state_DataCenter().as = true;
                    return;
                case -115:
                    if (Gdx.app.getType() == ApplicationType.Desktop) {
                        AppListener.gI();
                        AppListener.exit();
                        return;
                    }
                    break;
                case -114:
                    if (Gdx.app.getType() == ApplicationType.Desktop) {
                        beatdz.Controller.$state_Controller().c = true;
                        return;
                    }
                    break;
                case -113:
                    DataCenter.gI().readArrDataGame2(var1);
                    break;
                case -112:
                    LangLa_cz.T();
                    return;
            }

        } catch (Exception var5) {
            Utlis.println(var5, "cons: " + var1.cmd);
        }
    }

    private static void a(String var0) {
        if (DataCenter.gI().currentScreen instanceof LoginPCScreen) {
            ((LoginPCScreen) DataCenter.gI().currentScreen).a(var0);
        }

    }

    private static void g(Message msg) {
        try {
            ((LoginPCScreen) DataCenter.gI().currentScreen).f();
        } catch (Exception var3) {
            Utlis.println(var3);
        }

        try {
            SelectCharScreen selectCharScreen;
            (selectCharScreen = new SelectCharScreen()).read(msg);
            DataCenter.gI().setScreen((MainScreen) selectCharScreen);
        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    public static void readVXMM(Message msg) {
        if (GameSrc.gI().H() instanceof VXMM) {
            ((VXMM) GameSrc.gI().H()).read(msg);
        } else {
            VXMM vxmm = new VXMM(GameSrc.gI());
            vxmm.read(msg);
            GameSrc.gI().a(vxmm);
        }
    }

    public static void readLatHinh(Message msg) {
        if (GameSrc.gI().H() instanceof LatHinh) {
            ((LatHinh) GameSrc.gI().H()).read(msg);
        } else {
            LatHinh lathinh = new LatHinh(GameSrc.gI());
            GameSrc.gI().a(lathinh);
        }
    }

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public Controller instance;
public boolean c;
public void initialize() {
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.Controller");
public static SessionState $state_Controller() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
