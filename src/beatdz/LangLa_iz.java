package beatdz;

public class LangLa_iz {

    public int a = -1;
    public int b;
    public LangLa_iw c;
    public Skill d;
    public Char e;
    public Entity f;
    public boolean g;

    public LangLa_iz(Skill var1, int var2, Char var3, Entity var4) {
        this.d = var1;
        this.c = (LangLa_iw) DataCenter.gI().K.get(var1.idTemplate);
        this.e = var3;
        this.f = var4;
        if (var3.I() != null) {
            this.b = 1;
        } else {
            this.b = 0;
        }
        //System.out.println("startskill: " + System.currentTimeMillis() + " " + this.c.d[this.b].length);

        try {
            if (var3.equals(Char.gI())) {
                Char var10000 = var3;
                Skill var10 = var1;
                Entity var9 = var4;
                Char var7 = var10000;

                try {
                    if (!var7.isMe()) {
                        return;
                    }

                    var7.K();
                    Message var8;
                    if (var9 == null || !(var9 instanceof Char)) {
                        (var8 = new Message((byte) 61)).writeShort(var10.idTemplate);
                        if (var9 != null) {
                            var8.writeShort(var9.idEntity);
                        }

                        var8.send();
                        return;
                    }

                    (var8 = new Message((byte) 20)).writeShort(var10.idTemplate);
                    var8.writeInt(var9.idEntity);
                    var8.send();
                } catch (Exception var5) {
                    Utlis.println(var5);
                }
            }

        } catch (Exception var6) {
        }
    }

    public void a() {
        try {
            ++this.a;
            LangLa_jw var1;
            if (this.a >= this.c.d[this.b].length) {
                //System.out.println("endskill: " + System.currentTimeMillis());
                if (this.d.idTemplate == 39) {
                    GameSrc.gI().q();
                }

                this.e.av = null;
                if (this.e.isMe()) {
                    this.e.l();
                } else {
                    this.e.status = 0;
                }

                if (!this.g && this.f != null && this.c.b > 0) {
                    var1 = new LangLa_jw(this.c.b, this.f.cx, this.f.cy);
                    if (this.c.c == 1) {
                        var1 = new LangLa_jw(this.c.b, this.f.m(), this.f.n());
                    }

                    GameSrc.gI().I.add(var1);
                }

                if (this.f != null && this.f instanceof Mob) {
                    Mob var5 = (Mob) this.f;
                    this.f.setDir((Entity) this.e);
                    if (this.f.cx < this.e.cx) {
                        var5.X = -2;
                    } else {
                        var5.X = 2;
                    }

                    if (this.f.cy < this.e.cy) {
                        var5.Y = -1;
                    } else {
                        var5.Y = 1;
                    }

                    if (this.f.status != 3) {
                        this.f.k();
                    }

                    return;
                }
            } else {
                this.e.l = this.c.d[this.b][this.a].a;
                if (this.c.d[this.b][this.a].c > 0) {
                    if (this.e.ag == 3) {
                        (var1 = new LangLa_jw(this.c.d[this.b][this.a].c, this.e.cx - this.c.d[this.b][this.a].d, this.e.cy + this.c.d[this.b][this.a].e)).m = true;
                    } else {
                        var1 = new LangLa_jw(this.c.d[this.b][this.a].c, this.e.cx + this.c.d[this.b][this.a].d, this.e.cy + this.c.d[this.b][this.a].e);
                    }

                    GameSrc.gI().I.add(var1);
                }

                if (this.c.d[this.b][this.a].f > 0 && this.f != null) {
                    this.g = true;
                    int var2;
                    int var6;
                    if (this.e.ag == 3) {
                        var6 = this.e.cx + this.c.d[this.b][this.a].g;
                        var2 = this.e.cy + this.c.d[this.b][this.a].h;
                    } else {
                        var6 = this.e.cx - this.c.d[this.b][this.a].g;
                        var2 = this.e.cy + this.c.d[this.b][this.a].h;
                    }

                    int var3 = DataCenter.gI().widthScreen / 2;
                    GameSrc.gI().G.add(new LangLa_hi(this.c.d[this.b][this.a].f, var6, var2, this.f, this.c.b, this.c.c));
                    if ((new LangLa_hi(this.c.d[this.b][this.a].f, var6, var2, this.f, this.c.b, this.c.c)).o().a == 5) {
                        int var10004 = this.f.cx + var3;
                        GameSrc.gI().G.add(new LangLa_hi(this.c.d[this.b][this.a].f, var10004, this.f.cy, new LangLa_hs(this.f.cx, this.f.cy), this.c.b, this.c.c));
                        var10004 = this.f.cx + var3;
                        GameSrc.gI().G.add(new LangLa_hi(this.c.d[this.b][this.a].f, var10004, this.f.cy + var3, new LangLa_hs(this.f.cx, this.f.cy), this.c.b, this.c.c));
                        var10004 = this.f.cx + var3;
                        GameSrc.gI().G.add(new LangLa_hi(this.c.d[this.b][this.a].f, var10004, this.f.cy - var3, new LangLa_hs(this.f.cx, this.f.cy), this.c.b, this.c.c));
                        var10004 = this.f.cx - var3;
                        GameSrc.gI().G.add(new LangLa_hi(this.c.d[this.b][this.a].f, var10004, this.f.cy, new LangLa_hs(this.f.cx, this.f.cy), this.c.b, this.c.c));
                        var10004 = this.f.cx - var3;
                        GameSrc.gI().G.add(new LangLa_hi(this.c.d[this.b][this.a].f, var10004, this.f.cy + var3, new LangLa_hs(this.f.cx, this.f.cy), this.c.b, this.c.c));
                        var10004 = this.f.cx - var3;
                        GameSrc.gI().G.add(new LangLa_hi(this.c.d[this.b][this.a].f, var10004, this.f.cy - var3, new LangLa_hs(this.f.cx, this.f.cy), this.c.b, this.c.c));
                        GameSrc.gI().G.add(new LangLa_hi(this.c.d[this.b][this.a].f, this.f.cx, this.f.cy + var3, new LangLa_hs(this.f.cx, this.f.cy), this.c.b, this.c.c));
                        GameSrc.gI().G.add(new LangLa_hi(this.c.d[this.b][this.a].f, this.f.cx, this.f.cy - var3, new LangLa_hs(this.f.cx, this.f.cy), this.c.b, this.c.c));
                    }
                }
            }

        } catch (Exception var4) {
            this.e.av = null;
            this.e.l();
        }
    }
}
