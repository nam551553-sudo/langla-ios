package beatdz;

import com.tgame.model.Caption;
import java.io.IOException;
import java.util.Vector;

public class Mob extends Entity {

    public short id;
    public byte k;
    public byte he;
    public byte levelBoss;
    public byte speedMove;
    public byte o = -1;
    public short p;
    public short q;
    public short r;
    public short s;
    public short t;
    public short u = 0;
    public short v = 0;
    public short w = 100;
    public short x;
    public short y;
    public short z = 0;
    public boolean A;
    public boolean isPaintMiniMap;
    public int hp;
    public int hpFull;
    public int exp;
    public int level;
    public Vector G = new Vector();
    public Char H;
    public LangLa_hi I;
    public int J;
    public Vector vEffect = new Vector();
    public int L;
    public int M;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public String nameChar;
    public LangLa_ih S;
    public boolean T = true;
    public int U;
    public int V;
    public int W;
    public int X;
    public int Y;
    public boolean Z;
    public boolean aa;

    public void read(Message msg) throws IOException {
        if (Utlis.nextBoolean()) {
            this.y();
        }

        this.idEntity = msg.readShort();
        this.isPaintMiniMap = msg.readBoolean();
        this.nameChar = msg.reader.readUTF();
        this.id = msg.readShort();
        this.b(msg.readShort(), msg.readShort());
        this.setSize(this.getMobTemplate().width, this.getMobTemplate().height);
        this.level = msg.readShort();
        this.he = msg.readByte();
        this.status = msg.readByte();
        this.hp = msg.readInt();
        this.hpFull = msg.readInt();
        this.exp = msg.readInt();
        this.levelBoss = msg.readByte();
        byte var2 = msg.readByte();

        for (int var3 = 0; var3 < var2; ++var3) {
            Effect var4 = new Effect(msg.readShort(), msg.readInt(), msg.readLong(), msg.readInt(), this);
            this.vEffect.add(var4);
        }

        if (Utlis.nextBoolean()) {
            this.dir = 3;
        } else {
            this.dir = 2;
        }

        this.speedMove = this.getMobTemplate().speedMoveByte;
        if (this.status != 4) {
            this.status = 2;
            this.E();
        }

    }

    public void o() {
        XYEntity var1;
        if (this.getMobTemplate().type != 3 && (var1 = Char.c(this.cx, this.cy)) != null) {
            this.cy = var1.cy;
        }

        this.b(this.cx, this.cy);
    }

    public void b(int var1, int var2) {
        this.cx = this.p = this.r = this.x = (short) var1;
        this.cy = this.q = this.s = this.y = (short) var2;
    }

    private void y() {
        if (!this.z() && !this.A()) {
            this.status = 2;
        } else {
            this.status = 0;
        }
    }

    public boolean p() {
        return SettingsTab.gI().C() && this.levelBoss == 3 || GameSrc.gI().cl.c && this.levelBoss == 0 || GameSrc.gI().cl.d && this.levelBoss > 0;
    }

    public boolean q() {
        return this.getMobTemplate().type == 9 || this.getMobTemplate().type == 10 || this.getMobTemplate().type == 11 || SettingsTab.gI().C() && this.levelBoss == 3 || GameSrc.gI().cl.c && this.levelBoss == 0 || GameSrc.gI().cl.d && this.levelBoss > 0;
    }

    private boolean z() {
        return this.getMobTemplate().type == 2 || this.getMobTemplate().type == 10 || this.getMobTemplate().type == 8;
    }

    private boolean A() {
        return this.getMobTemplate().type == 11 || this.getMobTemplate().type == 9;
    }

    public MobTemplate getMobTemplate() {
        if (this.levelBoss == 8) {
            if (this.idEntity % 2 == 0) {
                return DataCenter.gI().MobTemplate[this.id].type == 3 ? DataCenter.gI().MobTemplate[292] : DataCenter.gI().MobTemplate[291];
            } else {
                return DataCenter.gI().MobTemplate[this.id].type == 3 ? DataCenter.gI().MobTemplate[284] : DataCenter.gI().MobTemplate[283];
            }
        } else {
            return DataCenter.gI().MobTemplate[this.id];
        }
    }

    public int a() {
        return this.cx - this.width / 2;
    }

    public int b() {
        return this.cx + this.width / 2;
    }

    public int c() {
        return this.cy - this.height;
    }

    public int d() {
        return this.cy;
    }

    public int s() {
        return this.cy + this.height;
    }

    public void t() {
        if (this.Z) {
            this.Z = false;
            this.o();
        }

        if (this.M > 0) {
            --this.M;
        }

        if (this.V > 0) {
            --this.V;
        }

        if (this.status != 4 && this.status != 5 && this.getMobTemplate().type != 9 && this.getMobTemplate().type != 11) {
            if (this.cx < this.G() || this.r < this.G()) {
                this.cx = this.r = this.x = this.G();
            }

            if (this.cx > this.H() || this.r > this.H()) {
                this.cx = this.r = this.x = this.H();
            }

            if (this.cy < this.I() || this.s < this.I()) {
                this.cy = this.s = this.y = this.I();
            }

            if (this.cy > this.J() || this.s > this.J()) {
                this.cy = this.s = this.y = this.J();
            }
        }

        try {
            this.L = 1;
            this.N = this.O = this.P = this.Q = false;
            if (this.S != null && this.S.a(this.m(), this.cy - this.height + 2)) {
                this.S = null;
            }

            boolean var1 = false;

            for (int var2 = 0; var2 < this.vEffect.size(); ++var2) {
                Effect var3;
                switch ((var3 = (Effect) this.vEffect.elementAt(var2)).id) {
                    case 8:
                        this.N = true;
                        break;
                    case 9:
                        this.O = true;
                        break;
                    case 10:
                        this.P = true;
                        this.L = 3;
                    case 11:
                    default:
                        break;
                    case 12:
                    case 35:
                    case 36:
                    case 71:
                    case 75:
                    case 78:
                        var1 = true;
                        break;
                    case 38:
                        var1 = true;
                        this.Q = true;
                }

                var3.a(this);
            }

            if (this.hp <= 0 && this.status != 4 && this.status != 5) {
                this.status = 4;
            }

            if (this.J > 0) {
                --this.J;
                if (this.J == 1) {
                    this.status = 0;
                }
            }

            if (!AutoPro.isAuto(11) || this.id == 30 || !GameSrc.gI().vMob.contains(this) || status == 0 || this.j()) {
                switch (this.status) {
                    case 0:
                        if (Utlis.nextInt((int) 80) == 0 || this.T) {
                            this.T = false;
                            this.y();
                        }
                        break;
                    case 1:
                        short var5 = this.cx;
                        short var7 = this.cy;
                        if (this.getMobTemplate().a != null && this.e < this.getMobTemplate().a[1].length - 1) {
                            this.cx = (short) (this.cx + this.X);
                            if (this.getMobTemplate().type == 3) {
                                this.cy = (short) (this.cy + this.Y);
                            }
                        } else if (this.A()) {
                            this.status = 2;
                        } else {
                            this.y();
                        }

                        this.a(var5, var7);
                        break;
                    case 2:
                        if (!var1 && (this.L == 0 || DataCenter.gI().i % this.L == 0)) {
                            this.E();
                        }

                        this.x = this.cx;
                        this.y = this.cy;
                        if ((this.getMobTemplate().type == 9 || this.getMobTemplate().type == 11) && Char.c(this.cx, this.cy) != null) {
                            this.status = 7;
                        }
                        break;
                    case 3:
                        this.C();
                    case 4:
                    case 6:
                    default:
                        break;
                    case 5:
                        this.D();
                        break;
                    case 7:
                        if (!var1 && (this.L == 0 || DataCenter.gI().i % this.L == 0)) {
                            this.E();
                        }

                        this.x = this.cx;
                        this.y = this.cy;
                        if (Char.c(this.cx, this.cy) == null) {
                            this.status = 2;
                        }
                }
                if (this.getMobTemplate().type != 3 && this.getMobTemplate().type != 4 && this.getMobTemplate().type != 11 && this.getMobTemplate().type != 9 && this.status != 5 && this.status != 4) {
                    this.cy = this.q;
                    this.y = this.cy;
                }

                if (this.status == 5 || this.status == 4) {
                    for (int var8 = this.G.size() - 1; var8 >= 0; --var8) {
                        ItemMap var6;
                        (var6 = (ItemMap) this.G.elementAt(var8)).a(var6.k, var6.l, this.m(), this.n());
                        this.G.remove(var6);
                        GameSrc.gI().vItemMap.addElement(var6);
                    }
                }

                if (this.status != 5 && this.status != 1 && this.status != 3 && this.z()) {
                    this.cx = this.p;
                    this.cy = this.q;
                }

                if (!this.Q && (this.L == 0 || DataCenter.gI().i % this.L == 0)) {
                    this.a(var1);
                }
            } else {
                cx = p;

                cy = q;
            }

        } catch (Exception var4) {
            Utlis.println(var4);
        }
    }

    private void a(short var1, short var2) {
        if (this.cx < this.p - this.getMobTemplate().speedMove + 1) {
            this.cx = (short) (this.p - this.getMobTemplate().speedMove + 1);
        } else if (this.cy < this.q - this.getMobTemplate().speedMove) {
            this.cy = (short) (this.q - this.getMobTemplate().speedMove);
        } else if (this.cx > this.p + this.getMobTemplate().speedMove - 1) {
            this.cx = (short) (this.p + this.getMobTemplate().speedMove - 1);
        } else if (this.cy > this.q + this.getMobTemplate().speedMove) {
            this.cy = (short) (this.q + this.getMobTemplate().speedMove);
        }

        if (this.getMobTemplate().type != 3 && Char.c(this.cx, this.cy) != null) {
            this.cx = var1;
            this.cy = var2;
        }

        this.x = this.cx;
        this.y = this.cy;
    }

    private void B() {
        if (this.P) {
            ++this.f;
            if (this.f >= 20) {
                this.f = 0;
                LangLa_ls var1 = new LangLa_ls(this);
                this.h.addElement(var1);
            }
        }

    }

    private void C() {
        try {
            if (this.getMobTemplate().type != 2 && this.z != 3) {
                if (this.A) {
                    if (this.z == 0) {
                        this.v = (short) (this.v + 2);
                        this.cx += this.v;
                        if (this.v >= 4) {
                            this.z = 1;
                        }
                    } else if (this.z == 1) {
                        this.v = (short) (this.v - 2);
                        this.cx += this.v;
                        if (this.v < -3) {
                            this.z = 2;
                        }
                    } else if (this.z == 2) {
                        ++this.v;
                        if (this.cx + this.v < this.t) {
                            this.cx += this.v;
                        } else {
                            this.cx = this.t;
                            this.z = 3;
                        }
                    }
                } else if (this.z == 0) {
                    this.v = (short) (this.v - 2);
                    this.cx += this.v;
                    if (this.v <= -4) {
                        this.z = 1;
                    }
                } else if (this.z == 1) {
                    this.v = (short) (this.v + 2);
                    this.cx += this.v;
                    if (this.v > 4) {
                        this.z = 2;
                        this.v = 0;
                    }
                } else if (this.z == 2) {
                    ++this.v;
                    if (this.cx - this.v > this.t) {
                        this.cx -= this.v;
                    } else {
                        this.cx = this.t;
                        this.z = 3;
                    }
                }
            }

            if (this.e == this.getMobTemplate().a[this.status].length / 2 && this.I != null) {
                GameSrc.gI().G.add(this.I);
                if (this.id == 219 || this.id == 220) {
                    this.M = 30;
                }
            }

        } catch (Exception var1) {
        }
    }

    private void D() {
        if (this.u()) {
            --this.z;
            if (this.z == 0) {
                this.status = 4;
            }

        } else if (this.dir == 3) {
            if (this.cx + 3 < this.r) {
                if (this.cx - this.t < this.w / 2) {
                    --this.u;
                    if (this.u < -5) {
                        this.u = -5;
                    }

                    this.cy += this.u;
                } else {
                    this.u = (short) (this.u + 3);
                    if (this.u > 9) {
                        this.u = 9;
                    }

                    this.cy += this.u;
                    if (this.cy > this.s) {
                        this.cy = this.s;
                    }
                }

                this.cx = (short) (this.cx + 5);
                this.y = this.s;
                this.x = this.cx;
            } else {
                this.cx = this.x = this.r;
                this.cy = this.y = this.s;
                this.status = 4;
            }
        } else if (this.dir == 2) {
            if (this.cx - 3 > this.r) {
                if (this.t - this.cx < this.w / 2) {
                    this.u = (short) (this.u - 2);
                    if (this.u < -5) {
                        this.u = -5;
                    }

                    this.cy += this.u;
                } else {
                    this.u = (short) (this.u + 3);
                    if (this.u > 9) {
                        this.u = 9;
                    }

                    this.cy += this.u;
                    if (this.cy > this.s) {
                        this.cy = this.s;
                    }
                }

                this.cx = (short) (this.cx - 5);
                this.y = this.s;
                this.x = this.cx;
            } else {
                this.cx = this.x = this.r;
                this.cy = this.y = this.s;
                this.status = 4;
            }
        } else {
            if (this.dir == 1) {
                if (this.z == 0) {
                    this.cy += this.u;
                    this.y = (short) (this.y + 2);
                    --this.u;
                    if (this.u <= -12) {
                        this.z = 1;
                        this.u = 18;
                        return;
                    }
                } else if (this.z == 1) {
                    if (this.cy + this.u < this.s) {
                        this.cy += this.u;
                        this.y = (short) (this.y + this.u / 2);
                        --this.u;
                        if (this.u < 2) {
                            this.u = 2;
                        }

                        if (this.A) {
                            --this.v;
                            if (this.v < -2) {
                                this.v = -2;
                            }
                        } else {
                            ++this.v;
                            if (this.v > 2) {
                                this.v = 2;
                            }
                        }

                        this.cx += this.v;
                        this.x += this.v;
                        return;
                    }

                    this.cx = this.x = this.r;
                    this.cy = this.y = this.s;
                    this.status = 4;
                    return;
                }
            } else if (this.z == 0) {
                this.cy += this.u;
                this.y = (short) (this.y - 4);
                --this.u;
                if (this.u <= -8) {
                    this.z = 1;
                    this.u = -12;
                    return;
                }
            } else if (this.z == 1) {
                if (this.cy + this.u > this.s) {
                    this.cy += this.u;
                    if (this.u < -8) {
                        this.y = (short) (this.y + this.u / 2);
                    } else {
                        this.y = (short) (this.y + this.u * 2);
                    }

                    if (this.y < this.s) {
                        this.y = this.s;
                    }

                    ++this.u;
                    if (this.u > -2) {
                        this.u = -2;
                    }

                    if (this.A) {
                        --this.v;
                        if (this.v < -2) {
                            this.v = -2;
                        }
                    } else {
                        ++this.v;
                        if (this.v > 2) {
                            this.v = 2;
                        }
                    }

                    this.cx += this.v;
                    this.x += this.v;
                    return;
                }

                this.cx = this.x = this.r;
                this.cy = this.y = this.s;
                this.status = 4;
            }

        }
    }

    public boolean u() {
        return this.id == 240 || this.id == 241;
    }

    public void b(Entity var1) {
        this.status = 3;
        this.e = 0;
        this.v = this.u = this.z = 0;
        this.t = this.cx;
        this.setDir((Entity) var1);
        this.I = new LangLa_hi(this.getMobTemplate().k[Utlis.nextInt(this.getMobTemplate().k.length)], this.m(), this.n(), var1, this.getMobTemplate().l[Utlis.nextInt(this.getMobTemplate().l.length)], 1);
        this.A = this.cx > var1.cx;
    }

    private void a(boolean var1) {
        try {
            if (this.status != 4 && this.status != 6) {
                ++this.e;
                if (this.status == 1 || this.status == 5) {
                    if (this.e >= this.getMobTemplate().a[1].length) {
                        this.e = 0;
                    }

                    this.k = this.getMobTemplate().a[1][this.e];
                    return;
                }

                if (var1 && this.status == 2) {
                    this.e = 0;
                    this.status = 0;
                }

                if (this.o > 0) {
                    if (this.e >= this.getMobTemplate().a[this.o].length) {
                        this.e = 0;
                        this.o = -1;
                        if (this.status == 3) {
                            this.y();
                        }
                    }
                } else if (this.e >= this.getMobTemplate().a[this.status].length) {
                    this.e = 0;
                    if (this.status == 3) {
                        this.y();
                    }
                }

                if (this.status == 3 && this.getMobTemplate().a.length > 4) {
                    if (this.o == -1) {
                        this.o = (byte) (this.status + Utlis.nextInt(this.getMobTemplate().a.length - this.status));
                    }

                    this.k = this.getMobTemplate().a[this.o][this.e];
                    return;
                }

                this.k = this.getMobTemplate().a[this.status][this.e];
            }

        } catch (Exception var2) {
        }
    }

    private void E() {
        if (this.V <= 0) {
            if (this.z()) {
                this.status = 0;
            } else {
                if (this.cx == this.r && this.cy == this.s) {
                    int var1 = Utlis.nextInt((int) 10);
                    if (this.A()) {
                        var1 = 9;
                    }

                    short var2 = this.s;
                    switch (var1) {
                        case 0:
                            this.r = (short) (this.p - this.getMobTemplate().speedMove);
                            this.s = (short) (this.q - this.getMobTemplate().speedMove);
                            break;
                        case 1:
                            this.r = this.p;
                            this.s = (short) (this.q - this.getMobTemplate().speedMove);
                            break;
                        case 2:
                            this.r = (short) (this.p + this.getMobTemplate().speedMove);
                            this.s = (short) (this.q - this.getMobTemplate().speedMove);
                            break;
                        case 3:
                            this.r = (short) (this.p - this.getMobTemplate().speedMove);
                            this.s = this.q;
                            break;
                        case 4:
                            this.r = this.p;
                            this.s = this.q;
                            break;
                        case 5:
                            this.r = (short) (this.p + this.getMobTemplate().speedMove);
                            this.s = this.q;
                            break;
                        case 6:
                            this.r = (short) (this.p - this.getMobTemplate().speedMove);
                            this.s = (short) (this.q + this.getMobTemplate().speedMove);
                            break;
                        case 7:
                            this.r = this.p;
                            this.s = (short) (this.q + this.getMobTemplate().speedMove);
                            break;
                        case 8:
                            this.r = (short) (this.p + this.getMobTemplate().speedMove);
                            this.s = (short) (this.q + this.getMobTemplate().speedMove);
                            break;
                        case 9:
                            this.status = 0;
                    }

                    if (this.getMobTemplate().type != 3) {
                        this.s = (short) var2;
                        short var3 = this.cx;
                        if (this.r < this.cx) {
                            do {
                                var3 = (short) (var3 - 5);
                                if (this.id == 208) {
                                    var3 = (short) (var3 - 5);
                                    break;
                                }

                                if (Char.c(var3, this.s) != null) {
                                    var3 = (short) (var3 + 5);
                                    break;
                                }
                            } while (var3 > this.r);
                        } else {
                            do {
                                var3 = (short) (var3 + 5);
                                if (this.id == 208) {
                                    var3 = (short) (var3 + 5);
                                    break;
                                }

                                if (Char.c(var3, this.s) != null) {
                                    var3 = (short) (var3 - 5);
                                    break;
                                }
                            } while (var3 < this.r);
                        }

                        this.r = var3;
                    }
                } else {
                    label101:
                    {
                        if (this.id == 207) {
                            if (DataCenter.gI().i % 5 != 0) {
                                break label101;
                            }
                        } else if ((this.getMobTemplate().type != 1 || DataCenter.gI().i % 2 != 0) && this.getMobTemplate().type == 1) {
                            break label101;
                        }

                        this.F();
                    }
                }

                this.B();
            }
        }
    }

    private void F() {
        if (this.cx > this.r) {
            this.cx = (short) (this.cx - this.speedMove);
            if (this.cx < this.r) {
                this.cx = this.r;
            }

            this.dir = 3;
        } else if (this.cx < this.r) {
            this.cx = (short) (this.cx + this.speedMove);
            if (this.cx > this.r) {
                this.cx = this.r;
            }

            this.dir = 2;
        }

        if (this.cy > this.s) {
            this.cy = (short) (this.cy - this.speedMove);
            if (this.cy < this.s) {
                this.cy = this.s;
                return;
            }
        } else if (this.cy < this.s) {
            this.cy = (short) (this.cy + this.speedMove);
            if (this.cy > this.s) {
                this.cy = this.s;
            }
        }

    }

    public void a(Graphics var1) {
        if (!Utlis.f() && this.U != 2 && this.M <= 0) {
            if (this.levelBoss == 8) {
                this.width = this.getMobTemplate().width;
                this.height = this.getMobTemplate().height;
            }
            if (this.status != 4 && this.status != 6 && this.getMobTemplate().b != null) {
                if (this.U == 1) {
                    var1.d(40);
                }

                LangLa_hz var2 = this.getMobTemplate().b[this.k];
                if (this.N) {
                    var1.c(-1090781674);
                } else if (this.O) {
                    var1.c(-592300170);
                } else if (this.P || this.Q) {
                    var1.c(-263996674);
                }

                for (int var3 = 0; var3 < var2.a.length; ++var3) {
                    short var4 = var2.a[var3].a;
                    if (this.V > 0) {
                        short var6;
                        if (DataCenter.gI().i % 12 > 6) {
                            var6 = 5088;
                        } else {
                            var6 = 3920;
                        }

                        LangLa_fq.b(var1, var6, 0, this.p, this.q, 33);
                    } else if (this.u() && this.status == 5) {
                        int var5;
                        if ((var5 = this.z / 4 * 15) > 48) {
                            var5 = 48;
                        }

                        if (this.i()) {
                            LangLa_fq.b(var1, var4, Utlis.b(var2.a[var3].d), this.cx - var2.a[var3].b, this.cy + var2.a[var3].c, 51, var5, 33);
                        } else {
                            LangLa_fq.b(var1, var4, Utlis.a(var2.a[var3].d), this.cx + var2.a[var3].b, this.cy + var2.a[var3].c, 51, var5, 33);
                        }
                    } else if (this.i()) {
                        LangLa_fq.b(var1, var4, Utlis.b(var2.a[var3].d), this.cx - var2.a[var3].b, this.cy + var2.a[var3].c, 33);
                    } else {
                        LangLa_fq.b(var1, var4, Utlis.a(var2.a[var3].d), this.cx + var2.a[var3].b, this.cy + var2.a[var3].c, 33);
                    }
                }

                var1.m = 1.0F;
                var1.c();
            }

        }
    }

    private short G() {
        return (short) (this.p - this.getMobTemplate().speedMove);
    }

    private short H() {
        return (short) (this.p + this.getMobTemplate().speedMove);
    }

    private short I() {
        return (short) (this.q - this.getMobTemplate().speedMove);
    }

    private short J() {
        return (short) (this.q + this.getMobTemplate().speedMove);
    }

    public String f() {
        return this.getMobTemplate() != null ? this.getMobTemplate().name : "";
    }

    public String g() {
        if (this.hpFull > 0) {
            String var1 = "" + this.hpFull;
            if (this.hpFull > 1000000) {
                var1 = this.hpFull / 1000 + "k";
            }

            return this.hp + "/" + var1;
        } else {
            return "";
        }
    }

    public String h() {
        if (this.exp > 0) {
            String var1 = "" + this.exp;
            if (this.exp > 1000000) {
                var1 = this.exp / 1000 + "k";
            }

            return "Lv: " + this.level + " + " + var1 + " Exp";
        } else {
            return "Lv: " + this.level;
        }
    }

    public int a(int var1) {
        if (this.hpFull == 0) {
            return var1;
        } else {
            long var2 = 0L;

            try {
                if ((var2 = (long) this.hp * (long) var1 / (long) this.hpFull) > (long) var1) {
                    var2 = (long) var1;
                }
            } catch (Exception var4) {
            }

            if (var2 < 0L) {
                var2 = 0L;
            }

            return (int) var2;
        }
    }

    public int v() {
        switch (this.he) {
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

    public int w() {
        switch (this.he) {
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

    private boolean K() {
        return this.id == 94 || this.id == 95 || this.id == 98 || this.id == 100 || this.id == 240;
    }

    private boolean L() {
        return this.id == 99 || this.id == 101 || this.id == 102 || this.id == 103 || this.id == 241;
    }

    public boolean x() {
        return !this.j() && (GameSrc.gI().getMapTemplate().type != 6 || GameSrc.gI().bI != 1 || !this.K()) && (GameSrc.gI().getMapTemplate().type != 6 || GameSrc.gI().bI != 2 || !this.L());
    }

    public void b(Graphics var1) {
        if (!this.aa) {
            int var3 = 25;
            short var4 = this.height;
            if (this.levelBoss == 8) {
                var4 = this.getMobTemplate().height;
            }

            if (this.status != 4 && this.status != 6) {
                int var10004;
                if (this.getMobTemplate().type == 9) {
                    var10004 = this.cy - var4 - 10;
                    mFont.b(mFont.d, var1, this.getMobTemplate().name, this.cx, var10004, 2, -1, -16777216);
                } else if (this.getMobTemplate().type == 10) {
                    var3 = 15;
                    if (GameSrc.gI().aA != null && GameSrc.gI().aA.equals(this)) {
                        var10004 = this.cy - var4 - 8;
                        mFont.b(mFont.d, var1, this.getMobTemplate().name, this.cx, var10004, 2, -16646423, -16777216);
                        var3 = 23;
                    }
                } else if (this.levelBoss == 1) {
                    var3 = 35;
                    mFont.b(mFont.d, var1, Caption.ia, this.cx, this.cy - var4 - 18, 2, -16742145, -16777216);
                    var1.f(-16777216);
                    var1.c(this.cx - 23, this.cy - var4 - 9, 46, 6);
                    var1.f(-65536);
                    var1.c(this.cx - 22, this.cy - var4 - 8, this.a(44), 4);
                } else if (this.levelBoss == 2) {
                    var3 = 35;
                    mFont.b(mFont.d, var1, Caption.ib, this.cx, this.cy - var4 - 18, 2, -3407617, -16777216);
                    var1.f(-16777216);
                    var1.c(this.cx - 27, this.cy - var4 - 10, 54, 7);
                    var1.f(-65536);
                    var1.c(this.cx - 26, this.cy - var4 - 9, this.a(52), 5);
                } else if (this.levelBoss == 8) {
                    var3 = 35;
                    var10004 = this.cy - var4 - 18;
                    mFont.b(mFont.d, var1, this.getMobTemplate().name, this.cx, var10004, 2, -5113342, -16777216);
                    var1.f(-16777216);
                    var1.c(this.cx - 27, this.cy - var4 - 10, 54, 7);
                    var1.f(-65536);
                    var1.c(this.cx - 26, this.cy - var4 - 9, this.a(52), 5);
                } else if (this.levelBoss == 7) {
                    var3 = 35;
                    var10004 = this.cy - var4 - 19;
                    mFont.b(mFont.d, var1, this.getMobTemplate().detail, this.cx, var10004, 2, -5113342, -16777216);
                    var1.f(-16777216);
                    var1.c(this.cx - 23, this.cy - var4 - 12, 46, 6);
                    var1.f(-65536);
                    var1.c(this.cx - 22, this.cy - var4 - 11, this.a(44), 4);
                } else {
                    label137:
                    {
                        if (this.levelBoss != 3 && this.levelBoss != 9) {
                            if (this.levelBoss > 0) {
                                var3 = 20;
                                var1.f(-16777216);
                                var1.c(this.cx - 23, this.cy - var4 - 9, 46, 6);
                                var1.f(-65536);
                                var1.c(this.cx - 22, this.cy - var4 - 8, this.a(44), 4);
                                break label137;
                            }
                        } else {
                            var3 = 40;
                            var10004 = this.cy - var4 - 25;
                            mFont.b(mFont.d, var1, this.getMobTemplate().detail, this.cx, var10004, 2, -16712436, -16777216);
                            var10004 = this.cy - var4 - 15;
                            mFont.b(mFont.d, var1, this.getMobTemplate().name, this.cx, var10004, 2, -1, -16777216);
                        }

                        var1.f(-16777216);
                        var1.c(this.cx - 15, this.cy - var4 - 8, 30, 4);
                        var1.f(-65536);
                        var1.c(this.cx - 14, this.cy - var4 - 7, this.a(28), 2);
                    }
                }
                var10004 = this.cy - var4 - 15;
                // mFont.b(mFont.maintain, var1, this.getMobTemplate().name + "("+this.idEntity+")", this.cx, var10004, 2, -1, -16777216);

                if (this.nameChar != null && this.nameChar.length() > 0) {
                    var3 = 35;
                    GameSrc.gI().ar = true;
                    if (this.id != 293 && this.id != 294) {
                        if (this.id == 221) {
                            mFont.b(mFont.d, var1, this.nameChar + Caption.id, this.cx, this.cy - var4 - 18, 2, -2560, -16777216);
                        } else {
                            mFont.b(mFont.d, var1, this.nameChar + Caption.ie, this.cx, this.cy - var4 - 18, 2, -2560, -16777216);
                        }
                    } else {
                        mFont.b(mFont.d, var1, this.getMobTemplate().name + " " + this.nameChar, this.cx, this.cy - var4 - 18, 2, -2560, -16777216);
                    }
                }

                Vector var5 = new Vector();

                int var6;
                Effect var7;
                for (var6 = 0; var6 < this.vEffect.size(); ++var6) {
                    if ((var7 = (Effect) this.vEffect.elementAt(var6)).c()) {
                        var5.add(var7);
                    }
                }

                if (var5.size() > 0) {
                    int var2 = -(var5.size() - 1) * 17 / 2;

                    for (var6 = 0; var6 < var5.size(); ++var6) {
                        if ((var7 = (Effect) var5.elementAt(var6)).c()) {
                            var7.a(var1, this.cx + var2 - 7 + var6 * 17, this.cy - var4 - var3 - 5, Char.gI());
                        }
                    }

                    var3 += 16;
                }

                if (GameSrc.gI().aA != null && GameSrc.gI().aA.equals(this)) {
                    int var10002 = this.cy - var4 - var3;
                    GameSrc.gI().aF.setXY(this.cx, var10002 + 6);
                    GameSrc.gI().aF.a(var1);
                }

                if (this.S != null) {
                    this.S.a(var1);
                }
            }

        }
    }

    public int e() {
        return 3;
    }
}
