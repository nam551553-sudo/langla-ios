package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_ky extends LangLa_ko {
   private LangLa_gx v;
   public LangLa_ii[] a;
   private LangLa_ij w;
   private int x;
   private String y;
   private String z;
   public int b;
   private int A;
   private int B;
   public int c;
   private int C;
   private long D;
   private String[] E;
   private int F;
   public int d;
   public Vector e;
   public Vector f;
   private Vector G;
   public Vector g;
   public Vector h;
   private LangLa_ce H;
   private LangLa_ce I;
   private int J;
   private int K;
   private int L;
   private String M;
   private int N;
   private int O;
   public String u;

   private int e() {
      return 500 + this.b * 100;
   }

   public LangLa_ky(MainScreen var1, Message var2) {
      super(var1, 4, new String[]{Caption.dM});
      this.y = Caption.kO;
      this.z = "";
      this.E = new String[0];
      this.e = new Vector();
      this.f = new Vector();
      this.G = new Vector();
      this.g = new Vector();
      this.h = new Vector();
      this.p = var1;
      this.r = false;
      this.a(300, 220);
      LangLa_kd var5;
      (var5 = new LangLa_kd(1001)).c = Caption.rJ;
      this.v = new LangLa_gx(var5, this.width, 1, this.a_() - 3, 87, this.G() + 6, 33, this);
      this.H = this.a(this.v.c() + 7, this.a_() + this.G() - 25, Caption.fZ, 100);
      LangLa_ce var10000 = this.H;
      boolean var4 = Binary.readBoolan("clan" + Char.gI().idEntity);
      var10000.a = var4;
      this.v.a((LangLa_cs)this.H, 1);
      this.a(this.H, 0);
      this.I = this.a(this.v.c() + 87, this.a_() + this.G() - 25, Caption.qn, 101);
      var10000 = this.I;
      var4 = mConfig.gI().readBoolean(24);
      var10000.a = var4;
      this.v.a((LangLa_cs)this.I, 1);
      DataCenter.gI();
      this.a = new LangLa_ii[var5.c.length];
      this.a(var2);
      this.v.a(GameSrc.gI().bW);
      this.a(GameSrc.gI().bU);
   }

   public void a(Message var1) {
      int var3;
      try {
         this.e.clear();
         this.G.clear();
         this.g.clear();
         this.h.clear();
         this.y = var1.reader.readUTF();
         this.z = var1.reader.readUTF();
         this.D = var1.reader.dis.readLong();
         this.b = var1.reader.dis.readShort();
         this.A = var1.reader.dis.readInt();
         this.B = var1.reader.dis.readInt();
         this.C = var1.reader.dis.readInt();
         this.c = var1.reader.dis.readInt();
         this.E = mFont.c(mFont.d, var1.reader.readUTF(), 190);
         this.F = var1.reader.dis.readByte();
         short var2 = var1.reader.dis.readShort();

         for(var3 = 0; var3 < var2; ++var3) {
            LangLa_ey var4;
            (var4 = new LangLa_ey()).i = var1.reader.dis.readByte();
            var4.b = var1.reader.dis.readByte();
            byte var6 = var1.reader.dis.readByte();
            var4.c = var6;
            var4.d = var1.reader.dis.readShort();
            var4.a = var1.reader.readUTF();
            var4.j = var1.reader.dis.readInt();
            var4.k = var1.reader.dis.readInt();
            var4.l = var1.reader.dis.readBoolean();
            var4.m = var1.reader.dis.readBoolean();
            this.e.addElement(var4);
            if (var4.a.toLowerCase().equals(Char.gI().name.toLowerCase())) {
               this.d = var4.i;
            }
         }

         var2 = var1.reader.dis.readShort();
         DataCenter.gI();
         var3 = super.width - 8 - 110;

         int var8;
         for(var8 = 0; var8 < var2; ++var8) {
            String var5 = "- " + var1.readUTF();
            this.G.addAll(mFont.b(mFont.d, var5, var3));
         }

         var2 = var1.reader.dis.readShort();

         for(var8 = 0; var8 < var2; ++var8) {
            Item var9;
            (var9 = new Item()).read(var1);
            this.g.add(var9);
         }

         var2 = var1.reader.readUnsignedByte();

         for(var8 = 0; var8 < var2; ++var8) {
            this.h.add(Integer.valueOf(var1.reader.dis.readByte()));
         }

         var1.reader.dis.readLong();
         this.L = var1.reader.dis.readShort();
      } catch (Exception var7) {
      }

      int var10001 = this.v.cy + 7;
      DataCenter.gI();
      this.N = var10001 + 0;
      this.x = 15;
      LangLa_ii[] var10000 = this.a;
      int var10005 = this.v.c() + 7;
      int var10006 = this.N + 10;
      int var10007 = super.width - 8 - 100;
      int var10008 = this.x;
      DataCenter.gI();
      var10000[0] = new LangLa_ii((byte)1, var10005, var10006, var10007, var10008 * 11, this.x, 9 + this.E.length);
      this.f();
      this.x = 26;
      var10000 = this.a;
      var10005 = this.v.c() + 8;
      var10006 = this.N + 6;
      DataCenter.gI();
      var10000[2] = new LangLa_ii((byte)1, var10005, var10006, 190, this.x * 6 + 1, this.x, DataCenter.gI().SkillClan.length);
      this.x = 15;
      var10000 = this.a;
      var10005 = this.v.c() + 7;
      var10006 = this.N + 10;
      DataCenter.gI();
      var10007 = super.width - 8 - 100;
      var10008 = this.x;
      DataCenter.gI();
      var10000[3] = new LangLa_ii((byte)1, var10005, var10006, var10007, var10008 * 11, this.x, this.G.size());
      DataCenter.gI();
      int var10 = this.v.c();
      DataCenter.gI();
      var3 = var10 + 9;
      DataCenter.gI();
      DataCenter.gI();
      this.w = new LangLa_ij((byte)1, var3, this.N + 5, 192, 160, 32, Utlis.c(this.g.size() < 30 ? 30 : this.g.size(), 6), 6);
      this.M = Caption.dr;
      this.J = -7812062;
      if (this.d == 5) {
         this.M = Caption.ds;
         this.J = -2560;
      } else if (this.d == 4) {
         this.M = Caption.dt;
         this.J = -3407617;
      } else if (this.d == 4) {
         this.M = Caption.du;
         this.J = -48128;
      }

      this.K = mFont.b(mFont.d, this.M);
   }

   private void f() {
      this.f.clear();
      int var1;
      if (this.H.a) {
         for(var1 = 0; var1 < this.e.size(); ++var1) {
            LangLa_ey var2;
            if ((var2 = (LangLa_ey)this.e.elementAt(var1)).l) {
               this.f.add(var2);
            }
         }
      } else {
         this.f.addAll(this.e);
      }

      Binary.writeBoolean("clan" + Char.gI().idEntity, this.H.a);
      int var10000 = super.width - 8;
      DataCenter.gI();
      var1 = var10000 - 100;
      DataCenter.gI();
      var10000 = this.N;
      DataCenter.gI();
      int var4 = var10000 - 0;
      if (this.I.a) {
         this.x = 25;
         this.a[1] = new LangLa_ii((byte)1, this.v.c() + 7 + 0, var4 + 6, var1, this.x * 6, this.x, this.f.size());
      } else {
         this.x = 50;
         this.a[1] = new LangLa_ii((byte)1, this.v.c() + 7 + 0, var4 + 6, var1, this.x * 3, this.x, this.f.size());
      }
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      super.a(var1, var2, var3);
      if (this.k() == 0) {
         int var4;
         LangLa_ky var14;
         Message var19;
         switch(var1.b) {
         case 1001:
            if (var1.j.k >= 0) {
               GameSrc.gI().bW = (byte)var1.j.k;
               this.v.a(var1.j.k);
               return;
            }
            break;
         case 1004:
            var4 = var3 - 72;
            Vector var13 = new Vector();
            if (this.d == 5) {
               var13.addElement(new LangLa_lk(60, Caption.dY));
               var13.addElement(new LangLa_lk(61, Caption.dZ));
               var13.addElement(new LangLa_lk(62, Caption.ea));
            } else if (this.d == 4) {
               var13.addElement(new LangLa_lk(60, Caption.dY));
               var13.addElement(new LangLa_lk(62, Caption.ea));
               var13.addElement(new LangLa_lk(63, Caption.eb));
            } else {
               var13.addElement(new LangLa_lk(62, Caption.ea));
               var13.addElement(new LangLa_lk(63, Caption.eb));
            }

            if (var13.size() > 0) {
               String[] var22 = new String[var13.size()];
               short[] var6 = new short[var13.size()];

               for(int var23 = 0; var23 < var13.size(); ++var23) {
                  LangLa_lk var8 = (LangLa_lk)var13.elementAt(var23);
                  var22[var23] = var8.b;
                  var6[var23] = (short)var8.a;
               }

               if (var13.size() == 2) {
                  var4 += 15;
               }

               this.cL = a(this, var2 + 5, var4, new LangLa_kd(0, var6, var22));
            }

            return;
         case 1010:
            if (var1.j.k >= 0) {
               this.a(var1.j.k, var2, var3);
               return;
            }
            break;
         case 1011:
            if (var1.j.k >= 0) {
               boolean var16 = this.h.contains(DataCenter.gI().SkillClan[var1.j.k].id);
               if (this.d != 5) {
                  var16 = true;
               }

               String var21 = this.a(var1.j.k, var16);
               int var10003 = var1.j.cx + 27;
               int var10004 = var1.j.cy + var1.j.k * var1.j.h - var1.j.f + 1;
               boolean var5 = true;
               int var12 = var10004;
               var4 = var10003;
               LangLa_mo var7;
               if ((var7 = new LangLa_mo(var4, var12, 220, this, var21, var16)).cx > DataCenter.gI().widthScreen - var7.width - super.cx) {
                  var7.cx = (short)(DataCenter.gI().widthScreen - var7.width - super.cx);
               }

               if (var7.cx < var4) {
                  var7.cx = (short)(var4 - (var7.width + 3));
               }

               if (var7.cx < -super.cx) {
                  var7.cx = (short)(-super.cx);
               }

               if (var7.cy > DataCenter.gI().heightScreen - var7.height - super.cy) {
                  var7.cy = (short)(DataCenter.gI().heightScreen - var7.height - super.cy);
               }

               this.a(var7);
               this.cL = var7;
               return;
            }
            break;
         case 2001:
            var14 = this;

            try {
               if (var14.u != null) {
                  Message var20;
                  (var20 = Message.c((byte)-97)).writeUTF(var14.u);
                  var20.send();
               }
               break;
            } catch (Exception var11) {
               return;
            }
         case 2002:
            this.a(false);
            return;
         case 2003:
            var14 = this;

            try {
               SkillClan var18 = DataCenter.gI().SkillClan[var14.a[2].k];
               (var19 = Message.c((byte)-68)).writeByte(var18.id);
               var19.send();
               break;
            } catch (Exception var10) {
               return;
            }
         case 2004:
            boolean var17 = true;
            var14 = this;

            try {
               (var19 = Message.c((byte)-99)).writeUTF(var14.u);
               var19.writeByte(5);
               var19.send();
               break;
            } catch (Exception var9) {
               return;
            }
         case 5001:
            var4 = var1.j.k;
            LangLa_ii var15 = var1.j;
            this.w.k = -1;
            var15.k = var4;
            if (var1.j.k >= 0) {
               this.cL = a(var1, this, (Item)this.g.get(var1.j.k));
            }
         }
      }

   }

   public void a(int var1, Object var2, LangLa_cy var3) {
      super.a(var1, var2, var3);
      if (this.k() == 0) {
         LangLa_ky var12;
         LangLa_kd var14;
         LangLa_ey var15;
         switch(var1) {
         case 51:
            var14 = (LangLa_kd)var2;
            var12 = this;

            try {
               var15 = var12.b(var14.a);
               GameSrc.gI();
               GameSrc.e(var15.a);
               break;
            } catch (Exception var11) {
               Utlis.println(var11);
               return;
            }
         case 52:
            var14 = (LangLa_kd)var2;
            var12 = this;

            try {
               var15 = var12.b(var14.a);
               GameSrc.gI();
               GameSrc.d(var15.a);
               break;
            } catch (Exception var10) {
               Utlis.println(var10);
               return;
            }
         case 53:
            var14 = (LangLa_kd)var2;
            var12 = this;

            try {
               var12.m();
               var12.a(var12.j());
               var15 = var12.b(var14.a);
               GameSrc.gI().a((String)var15.a, (LangLa_ko)var12);
               break;
            } catch (Exception var9) {
               Utlis.println(var9);
               return;
            }
         case 54:
            var14 = (LangLa_kd)var2;
            var12 = this;

            try {
               var15 = var12.b(var14.a);
               GameSrc.gI();
               GameSrc.h(var15.a);
               break;
            } catch (Exception var8) {
               Utlis.println(var8);
               return;
            }
         case 55:
            this.a((LangLa_kd)var2, 0);
            return;
         case 56:
            this.a((LangLa_kd)var2, 4);
            return;
         case 57:
            this.a((LangLa_kd)var2, 3);
            return;
         case 58:
            var14 = (LangLa_kd)var2;
            var12 = this;

            try {
               var15 = var12.b(var14.a);
               var12.u = var15.a;
               DataCenter.gI().currentScreen.a(Caption.dO + var12.u + Caption.dP, 2001, var12);
               break;
            } catch (Exception var7) {
               return;
            }
         case 59:
            var14 = (LangLa_kd)var2;
            var12 = this;

            try {
               var15 = var12.b(var14.a);
               GameSrc.gI().a((LangLa_cx)(new LangLa_bf(var12.p, var15.a)));
               break;
            } catch (Exception var6) {
               return;
            }
         case 60:
            GameSrc.gI().a((LangLa_cx)(new LangLa_af(this.p)));
            return;
         case 61:
            GameSrc.gI().a((LangLa_cx)(new LangLa_bn(this.p, this.c)));
            return;
         case 62:
            GameSrc.gI().a((LangLa_cx)(new LangLa_j(this.p)));
            return;
         case 63:
            this.a(true);
            return;
         case 64:
            var14 = (LangLa_kd)var2;
            var12 = this;

            try {
               var15 = var12.b(var14.a);
               Message var13;
               (var13 = Message.c((byte)-91)).writeUTF(var15.a);
               var13.send();
               break;
            } catch (Exception var5) {
               return;
            }
         case 65:
            var14 = (LangLa_kd)var2;
            var12 = this;

            try {
               var15 = var12.b(var14.a);
               var12.u = var15.a;
               DataCenter.gI().currentScreen.a(Utlis.replaceAll(Caption.oE, var12.u), 2004, var12);
            } catch (Exception var4) {
               return;
            }
         case 66:
         case 67:
         case 68:
         case 69:
         case 70:
         case 71:
         case 72:
         case 73:
         case 74:
         case 75:
         case 76:
         case 77:
         case 78:
         case 79:
         case 80:
         case 81:
         case 82:
         case 83:
         case 84:
         case 85:
         case 86:
         case 87:
         case 88:
         case 89:
         case 90:
         case 91:
         case 92:
         case 93:
         case 94:
         case 95:
         case 96:
         case 97:
         case 98:
         case 99:
         default:
            break;
         case 100:
            this.f();
            return;
         case 101:
            mConfig.gI().writeBoolean(24, this.I.a);
            this.f();
         }
      }

   }

   private void a(boolean var1) {
      try {
         if (var1) {
            DataCenter.gI().currentScreen.a(Caption.dN, 2002, this);
         } else {
            Message.c((byte)-96).send();
         }
      } catch (Exception var2) {
      }
   }

   private void a(LangLa_kd var1, int var2) {
      try {
         LangLa_ey var5 = this.b(var1.a);
         Message var3;
         (var3 = Message.c((byte)-99)).writeUTF(var5.a);
         var3.writeByte(var2);
         var3.send();
      } catch (Exception var4) {
      }
   }

   private void a(int var1, int var2, int var3) {
      Vector var4 = new Vector();
      LangLa_ey var5;
      if (!(var5 = this.b(var1)).a.equals(Char.gI().name)) {
         if (this.d == 5) {
            if (var5.i > 0) {
               var4.addElement(new LangLa_lk(55, Caption.dQ));
            } else {
               var4.addElement(new LangLa_lk(65, Caption.oD));
               var4.addElement(new LangLa_lk(56, Caption.dR));
               var4.addElement(new LangLa_lk(57, Caption.dS));
            }

            var4.addElement(new LangLa_lk(58, Caption.dT));
            var4.addElement(new LangLa_lk(59, Caption.dU));
         } else if (this.d == 4 && var5.i <= 3) {
            if (var5.i > 0) {
               var4.addElement(new LangLa_lk(55, Caption.dQ));
            } else {
               var4.addElement(new LangLa_lk(57, Caption.dS));
            }

            var4.addElement(new LangLa_lk(58, Caption.dT));
         }

         if (this.d > 0 && this.d > var5.i) {
            if (var5.m) {
               var4.addElement(new LangLa_lk(64, Caption.dV));
            } else {
               var4.addElement(new LangLa_lk(64, Caption.dW));
            }
         }

         if (!GameSrc.gI().k(var5.a)) {
            var4.addElement(new LangLa_lk(51, Caption.ck));
         }

         var4.addElement(new LangLa_lk(52, Caption.dX));
         var4.addElement(new LangLa_lk(53, Caption.cl));
         var4.addElement(new LangLa_lk(54, Caption.db));
      }

      if (var4.size() > 0) {
         String[] var9 = new String[var4.size()];
         short[] var6 = new short[var4.size()];

         for(int var7 = 0; var7 < var4.size(); ++var7) {
            LangLa_lk var8 = (LangLa_lk)var4.elementAt(var7);
            var9[var7] = var8.b;
            var6[var7] = (short)var8.a;
         }

         this.cL = a(this, var2 + 25, var3, new LangLa_kd(var1, var6, var9));
      }

   }

   public void a(int var1, Object var2) {
   }

   public Vector c() {
      Vector var1 = super.c();
      if (this.k() == 0) {
         var1.addElement(this.v.b());
         switch(this.v.b.b) {
         case 0:
            var1.addElement(this.a[this.v.b.b].a(1003, this));
            break;
         case 1:
            var1.addElement(this.a[this.v.b.b].a(1010, this));
            break;
         case 2:
            var1.addElement(this.w.a(5001, this));
            break;
         case 3:
            var1.addElement(this.a[2].a(1011, this));
            break;
         case 4:
            var1.addElement(this.a[3].a(1003, this));
         }

         if (Char.gI().aI != null) {
            DataCenter.gI();
            var1.addElement(new LangLa_jz(1004, this.O - 2, this.a_() + this.G() - 14, this.O + this.K + 2, this.a_() + this.G(), (LangLa_ii)null, this));
         }
      }

      return var1;
   }

   public void a(Graphics var1) {
      super.a(var1);
      if (this.k() == 0) {
         switch(this.v.b.b) {
         case 0:
            this.v.a((Graphics)var1, 61);
            this.a(var1, this.cx, this.cy);
            Graphics var3 = var1;
            LangLa_ky var2 = this;
            this.a(var1, this.a[0]);
            mFont.a((mFont)mFont.d, (Graphics)var1, Caption.ee + this.y, 6, 7 + 0 * this.a[0].h, 0, -1, 0);
            int var4;
            if ((var4 = this.B) == 0) {
               var4 = 1;
            }

            mFont.a((mFont)mFont.d, (Graphics)var1, Caption.ef + this.b + " + " + this.A * 100 / var4 + "%", 6, 7 + 1 * this.a[0].h, 0, -1, 0);
            mFont.a((mFont)mFont.d, (Graphics)var1, Caption.eg + Utlis.numberFormat(this.A) + "/" + Utlis.numberFormat(this.B), 6, 7 + 2 * this.a[0].h, 0, -1, 0);
            String var7 = Caption.ec + Utlis.numberFormat(this.C) + "/" + Utlis.numberFormat(this.e());
            mFont.a((mFont)mFont.d, (Graphics)var1, var7, 6, 7 + 3 * this.a[0].h, 0, -1, 0);
            if (Char.gI().aI != null) {
               int var6 = this.e();
               if (this.C >= var6) {
                  mFont.a((mFont)mFont.d, (Graphics)var1, "(" + Caption.ei + ")", mFont.b(mFont.d, var7) + 10, 6 + 3 * this.a[0].h, 0, -16742145, 0);
               } else {
                  mFont.a((mFont)mFont.d, (Graphics)var1, "(" + Caption.eh + ")", mFont.b(mFont.d, var7) + 10, 6 + 3 * this.a[0].h, 0, -3089954, 0);
               }
            }

            mFont.a((mFont)mFont.d, (Graphics)var1, Caption.ej + this.e.size() + "/" + (15 + this.b * 5) + Utlis.replaceAll(Caption.qr, "" + this.L), 6, 7 + 4 * this.a[0].h, 0, -1, 0);
            mFont.a((mFont)mFont.d, (Graphics)var1, Caption.ek + Utlis.numberFormat(this.c) + Caption.en, 6, 7 + 5 * this.a[0].h, 0, -1, 0);
            mFont.a((mFont)mFont.d, (Graphics)var1, Caption.el + this.F, 6, 7 + 6 * this.a[0].h, 0, -1, 0);
            if (Char.gI().aI != null) {
               mFont.a((mFont)mFont.d, (Graphics)var1, Caption.em + Utlis.e(this.D), 6, 7 + 7 * this.a[0].h, 0, -1, 0);
            } else {
               mFont.a((mFont)mFont.d, (Graphics)var1, Caption.em, 6, 7 + 7 * this.a[0].h, 0, -1, 0);
            }

            for(var4 = 0; var4 < var2.E.length; ++var4) {
               mFont.a((mFont)mFont.d, (Graphics)var3, var2.E[var4], 6, 7 + (8 + var4) * var2.a[0].h, 0, -2560, 0);
            }

            var2.b(var3);
            break;
         case 1:
            this.v.a((Graphics)var1, 61);
            this.e(var1);
            break;
         case 2:
            this.v.a((Graphics)var1, 61);
            this.f(var1);
            break;
         case 3:
            this.v.a((Graphics)var1, -11);
            this.g(var1);
            break;
         case 4:
            this.v.a((Graphics)var1, -11);
            this.h(var1);
         }

         if (Char.gI().aI != null) {
            DataCenter.gI();
            this.O = 18;
            DataCenter.gI();
            mFont.a((mFont)mFont.d, (Graphics)var1, this.M, this.O, this.a_() + this.G() - 10, 0, this.J, -10275328);
            var1.f(this.J);
            var1.a(this.O, this.a_() + this.G() - 5, this.O + this.K, this.a_() + this.G() - 9);
         }
      }

   }

   private void e(Graphics var1) {
      this.a(var1, this.a[1]);

      for(int var2 = 0; var2 < this.f.size(); ++var2) {
         LangLa_ey var3 = (LangLa_ey)this.f.get(var2);
         if (var2 == this.a[this.v.b.b].k) {
            this.a(var1, 0, var2 * this.a[this.v.b.b].h, this.a[this.v.b.b].width, this.a[this.v.b.b].h - 2, 4, 84, 5, 1, 1);
         } else {
            this.a(var1, 0, var2 * this.a[this.v.b.b].h, this.a[this.v.b.b].width, this.a[this.v.b.b].h - 2, -17, 84, 5, 1, 1);
         }

         int var4;
         int var5;
         String var6;
         if (!this.I.a) {
            Binary2.a(var1, 92, 0, 22, var2 * this.a[this.v.b.b].h + 24, 86, (byte)3);
            Binary2.a(var1, var3.a(), 0, 22, var2 * this.a[this.v.b.b].h + 24, 83, (byte)3);
            if (var3.l) {
               LangLa_fq.a(var1, 302, 0, 5, var2 * this.a[this.v.b.b].h + 32, 20);
            } else {
               LangLa_fq.a(var1, 304, 0, 5, var2 * this.a[this.v.b.b].h + 32, 20);
            }

            if (var3.m) {
               LangLa_fq.a(var1, 584, 0, this.a[this.v.b.b].width - 10, var2 * this.a[this.v.b.b].h + 36, 3);
            }

            var4 = 46;
            var5 = var2 * this.a[this.v.b.b].h + 8;
            if (var2 == this.a[this.v.b.b].l && !var3.a.equals(Char.gI().name)) {
               ++var4;
               ++var5;
            }

            var6 = "";
            if (var3.i == 5) {
               var6 = " (" + Caption.ds + ")";
            } else if (var3.i == 4) {
               var6 = " (" + Caption.dt + ")";
            } else if (var3.i == 3) {
               var6 = " (" + Caption.du + ")";
            }

            mFont.a(mFont.d, var1, Caption.rG[3] + " " + var3.a + var6, var4, var5, 0, -1);
            mFont.a(mFont.d, var1, Caption.rG[4] + " " + DataCenter.gI().DataNameChar[var3.b].name + ", " + Caption.rG[5] + " " + var3.d, var4, var5 + 10, 0, -1);
            mFont.a(mFont.d, var1, Caption.ec + " " + Utlis.numberFormat(var3.k), var4, var5 + 20, 0, -1);
            mFont.a(mFont.d, var1, Caption.ed + " " + Utlis.numberFormat(var3.j), var4, var5 + 30, 0, -1);
         } else {
            Binary2.a(var1, 92, 0, 11, var2 * this.a[this.v.b.b].h + 11, 42, (byte)3);
            Binary2.a(var1, var3.a(), 0, 11, var2 * this.a[this.v.b.b].h + 11, 40, (byte)3);
            if (var3.l) {
               Binary2.a(var1, 302, 0, 3, var2 * this.a[this.v.b.b].h + 14, 60, (byte)20);
            } else {
               Binary2.a(var1, 304, 0, 3, var2 * this.a[this.v.b.b].h + 14, 60, (byte)20);
            }

            if (var3.m) {
               Binary2.a(var1, 584, 0, this.a[this.v.b.b].width - 6, var2 * this.a[this.v.b.b].h + 15, 60, (byte)3);
            }

            var4 = 24;
            var5 = var2 * this.a[this.v.b.b].h + 7;
            if (var2 == this.a[this.v.b.b].l && !var3.a.equals(Char.gI().name)) {
               ++var4;
               ++var5;
            }

            var6 = "";
            if (var3.i == 5) {
               var6 = " (" + Caption.ds + ")";
            } else if (var3.i == 4) {
               var6 = " (" + Caption.dt + ")";
            } else if (var3.i == 3) {
               var6 = " (" + Caption.du + ")";
            }

            mFont.a(mFont.b, var1, Caption.rG[3] + " " + var3.a + var6 + ", " + Caption.rG[4] + " " + DataCenter.gI().DataNameChar[var3.b].name + ", " + Caption.rG[5] + " " + var3.d, var4, var5, 0, -1);
            mFont.a(mFont.b, var1, Caption.ec + " " + Utlis.numberFormat(var3.k) + ", " + Caption.ed + " " + Utlis.numberFormat(var3.j), var4, var5 + 10, 0, -1);
         }
      }

      this.b(var1);
   }

   private void f(Graphics var1) {
      this.a(var1, this.w);

      for(int var2 = 0; var2 < this.w.i; ++var2) {
         for(int var3 = 0; var3 < this.w.r; ++var3) {
            if (this.w.b(var2)) {
               if (var2 * this.w.r + var3 < this.g.size()) {
                  b(var1, var3 * this.w.h, var2 * this.w.h, (Item)this.g.get(var2 * this.w.r + var3), var2 * this.w.r + var3 == this.w.k);
               } else {
                  b(var1, var3 * this.w.h, var2 * this.w.h, (Item)null, var2 * this.w.r + var3 == this.w.k);
               }
            }
         }
      }

      this.b(var1);
   }

   private void g(Graphics var1) {
      if (Char.gI().aI != null) {
         this.v.c();
         this.a(var1, this.a[2]);

         int var2;
         for(int var3 = 0; var3 < DataCenter.gI().SkillClan.length; ++var3) {
            var2 = var3 * this.a[2].h;
            if (this.a[2].c(var2)) {
               if (this.a[2].k == var3) {
                  this.a(var1, 28, var2 + 1, this.a[2].width - 29, 25, -15, 84, 5, 1, 1);
               } else {
                  this.a(var1, 28, var2 + 1, this.a[2].width - 29, 25, -14, 84, 5, 1, 1);
               }

               mFont.a((mFont)mFont.e, (Graphics)var1, DataCenter.gI().SkillClan[var3].name, 35, var2 + 8, 0, -7812062, 0);
               if (this.h.contains(DataCenter.gI().SkillClan[var3].id)) {
                  mFont.a((mFont)mFont.d, (Graphics)var1, Caption.hd, 35, var2 + 18, 0, -2560, 0);
               } else {
                  mFont.a((mFont)mFont.d, (Graphics)var1, Caption.ap + " " + Utlis.numberFormat(DataCenter.gI().SkillClan[var3].moneyBuy) + " " + Caption.ba, 35, var2 + 18, 0, -1, 0);
               }

               LangLa_fq.a(var1, DataCenter.gI().SkillClan[var3].idIcon, 0, 1, var2 + 1, 20);
            }
         }

         if (this.a[2].k >= 0) {
            var2 = this.a[2].k * this.a[2].h;
            var1.f(-1);
            var1.b(0, var2, 26, 26);
         }

         this.b(var1);
         DataCenter.gI();
      }
   }

   private void h(Graphics var1) {
      this.a(var1, this.a[3]);

      for(int var2 = 0; var2 < this.G.size(); ++var2) {
         mFont.a(var1, (String)this.G.get(var2), 6, 5 + var2 * this.a[3].h, 0, -6488);
      }

      this.b(var1);
      this.a[3].b(var1, -10, -16);
   }

   public void b() {
      super.b();
      if (this.k() == 0) {
         this.v.a();
         this.w.a();

         for(int var1 = 0; var1 < this.a.length; ++var1) {
            if (this.a[var1] != null) {
               this.a[var1].a();
            }
         }
      }

   }

   private LangLa_ey b(int var1) {
      LangLa_ey var2 = null;
      if (var1 >= 0) {
         if (this.v.b.b == 1) {
            var2 = (LangLa_ey)this.f.elementAt(var1);
         } else {
            var2 = (LangLa_ey)this.e.elementAt(var1);
         }
      }

      return var2;
   }

   public void a(int var1) {
      super.a(var1);
      if (this.j != null && this.k() == this.j()) {
         this.j.a(2);
         this.l();
      }

      if (this.v != null) {
         this.v.d();
         if (var1 == 0) {
            this.v.a(this.v.b.b);
         }
      }

   }

   private String a(int var1, boolean var2) {
      SkillClan var3 = DataCenter.gI().SkillClan[var1];
      Vector var4;
      (var4 = new Vector()).addElement("c#moc" + var3.name);
      if (var3.detail != null && var3.detail.length() > 0) {
         var4.addElement(var3.detail);
      }

      if (!var2) {
         var4.addElement("c#yellow" + Caption.ap + " " + Utlis.numberFormat(DataCenter.gI().SkillClan[var1].moneyBuy) + " " + Caption.ba);
      }

      var4.addElement("c#green" + Caption.cV);
      this.a(var4, var3);
      Vector var6 = new Vector();

      String var7;
      for(int var9 = 0; var9 < var4.size(); ++var9) {
         var7 = String.valueOf(var4.elementAt(var9));
         Vector var5;
         int var8;
         if (var9 == 0) {
            var5 = mFont.a(mFont.e, var7, 180);

            for(var8 = 0; var8 < var5.size(); ++var8) {
               var6.add(new LangLa_lk(0, (String)var5.elementAt(var8)));
            }
         } else {
            var5 = mFont.a(mFont.d, var7, 180);

            for(var8 = 0; var8 < var5.size(); ++var8) {
               var6.add(new LangLa_lk(1, (String)var5.elementAt(var8)));
            }
         }
      }

      var7 = "";
      LangLa_lk[] var10 = new LangLa_lk[var6.size()];

      for(int var11 = 0; var11 < var6.size(); ++var11) {
         var10[var11] = (LangLa_lk)var6.elementAt(var11);
         var7 = var7 + var10[var11].b;
         if (var11 < var10.length - 1) {
            var7 = var7 + "\r\n";
         }
      }

      return var7;
   }

   private void a(Vector var1, SkillClan var2) {
      if (this.b >= var2.levelNeed) {
         var1.addElement("c#white" + Caption.rH[3] + var2.levelNeed);
      } else {
         var1.addElement("c#red" + Caption.rH[3] + var2.levelNeed);
      }

      ItemOption[] var6;
      int var3 = (var6 = var2.b()).length;

      for(int var4 = 0; var4 < var3; ++var4) {
         String var5;
         if ((var5 = var6[var4].a(0)) != null && var5.length() > 0) {
            var1.addElement(var5);
         }
      }

   }

   public void d() {
      try {
         if (GameSrc.gI().B() != null && GameSrc.gI().B().id == 44) {
            GameSrc.gI();
            GameSrc.openFunc(93);
         }
      } catch (Exception var1) {
      }

      super.d();
   }
}
