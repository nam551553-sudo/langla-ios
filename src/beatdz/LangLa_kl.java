package beatdz;import com.listener.IKeyboard;
import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_kl extends LangLa_ge implements IKeyboard {
   private int I;
   private int J;
   public int a;
   private LangLa_ij[][] K;
   private LangLa_ii[][] L;
   private LangLa_ii[] M;
   private LangLa_ii[] N;
   public LangLa_gx b;
   private LangLa_gx O;
   private LangLa_lf[] P;
   public mTextBox[] c;
   public boolean d;
   public int e;
   public int f;
   public int chakraBonus;
   public boolean hasBasePotential;
   public int g;
   public int h;
   public int i;
   public int u;
   public int v;
   public int[] w;
   public int[] x;
   private LangLa_dz Q;
   private LangLa_dz R;
   private LangLa_dz S;
   private LangLa_dz T;
   private LangLa_dz U;
   private LangLa_dz[] V;
   private LangLa_lk[] W;
   public Char y;
   public Skill[] z;
   private LangLa_dz X;
   private LangLa_dz Y;
   private LangLa_dz Z;
   private LangLa_dz aa;
   private LangLa_dz ab;
   private LangLa_cg ac;
   public LangLa_cg A;
   public LangLa_ce B;
   
   public Item C;
   private LangLa_ij ae;
   private boolean af;
   public String[] D;
   public int E;
   public int F;
   Vector G;
   public SkillClan H;

   public void e() {
      int var2 = this.a_() + 11;
      this.K = new LangLa_ij[Caption.rb.length][];
      this.K[0] = new LangLa_ij[6];
      this.K[0][0] = new LangLa_ij((byte)1, this.b.c() + 8, var2, this.I, this.I * 5, this.I, 5, 1);
      this.K[0][1] = new LangLa_ij((byte)1, this.b.c() + 8 + 160, var2, this.I, this.I * 5, this.I, 5, 1);
      this.K[0][2] = new LangLa_ij((byte)1, this.b.c() + 8 + this.I, var2 + this.I * 4, this.I * 4, this.I, this.I, 1, 4);
      this.K[0][3] = new LangLa_ij((byte)1, this.b.c() + 8 + this.I, var2 + this.I * 3, this.I, this.I, this.I, 1, 1);
      this.K[0][4] = new LangLa_ij((byte)1, this.b.c() + 8 + this.I * 4, var2 + this.I * 3, this.I, this.I, this.I, 1, 1);
      this.K[0][5] = new LangLa_ij((byte)1, this.b.c() + 8 + this.I * 4, var2 + this.I * 2, this.I, this.I, this.I, 1, 1);
      this.K[1] = new LangLa_ij[6];
      this.K[1][0] = new LangLa_ij((byte)1, this.b.c() + 8, var2, this.I, this.I * 5, this.I, 5, 1);
      this.K[1][1] = new LangLa_ij((byte)1, this.b.c() + 8 + 160, var2, this.I, this.I * 5, this.I, 5, 1);
      this.K[1][2] = new LangLa_ij((byte)1, this.b.c() + 8 + this.I, var2 + this.I * 4, this.I * 4, this.I, this.I, 1, 4);
      this.K[1][3] = new LangLa_ij((byte)1, this.b.c() + 8 + this.I, var2 + this.I * 3, this.I, this.I, this.I, 1, 1);
      this.K[1][4] = new LangLa_ij((byte)1, this.b.c() + 8 + this.I * 4, var2 + this.I * 3, this.I, this.I, this.I, 1, 1);
      this.K[1][5] = new LangLa_ij((byte)1, this.b.c() + 8 + this.I * 4, var2 + this.I * 2, this.I, this.I, this.I, 1, 1);
      this.L = new LangLa_ii[Caption.rb.length][];
      this.L[0] = new LangLa_ii[1];
      int var1 = this.b.c() + 40;
      this.L[0][0] = new LangLa_ii((byte)1, var1, var2, 128, 78, 13, Caption.rT.length);
      this.L[1] = new LangLa_ii[1];
      this.L[1][0] = new LangLa_ii((byte)1, this.b.c() + 40, this.a_() + 11, 128, 91, 13, Caption.rT.length);
      this.L[2] = new LangLa_ii[4];
      var1 = this.b.c() + 5;
      var2 = this.a_() + 34;
      this.L[2][0] = new LangLa_ii((byte)1, var1, var2 + 108, 40, 12, 24, 4);
      this.L[2][1] = new LangLa_ii((byte)1, var1, var2, super.width - 8 - 96, 120, 15, Caption.rd.length);
      this.L[2][2] = new LangLa_ii((byte)1, var1, var2, super.width - 8 - 96, 120, 15, this.x.length);
      this.L[2][3] = new LangLa_ii((byte)1, var1, var2, super.width - 8 - 96, 120, 15, Caption.rf.length);
      this.L[3] = new LangLa_ii[1];
      this.J = 26;
      var1 = this.b.c() + 8;
      int var10000 = this.b.cy + 7 + 6;
      DataCenter.gI();
      var2 = var10000 + 0;
      this.L[3][0] = new LangLa_ii((byte)1, var1, var2, 190, this.J * 5 + 1, this.J, this.z.length);
      this.L[4] = new LangLa_ii[2];
      var1 = this.b.c() + 5;
      var2 = this.a_() + 34;
      this.L[4][0] = new LangLa_ii((byte)1, var1, var2, super.width - 8 - 96, 119, 17, this.y.aG.length * 2);
      this.L[4][1] = new LangLa_ii((byte)1, var1, var2, super.width - 8 - 96, 75, 15, 6);
      this.K[4] = new LangLa_ij[2];
      var1 = this.b.c() + 8;
      var2 = this.a_() + 11 + this.I * 4;
      this.K[4][0] = new LangLa_ij((byte)1, var1, var2, this.I * 6, this.I, this.I, 1, 6);
      this.K[4][1] = new LangLa_ij((byte)1, var1, var2 - this.I, this.I, this.I, this.I, 1, 1);
      this.g();
   }

   public void g() {
      this.G = new Vector();

      for(int var2 = 0; var2 < this.y.aH.size(); ++var2) {
         SkillClan var1;
         if ((var1 = (SkillClan)this.y.aH.elementAt(var2)).id == 19) {
            this.H = var1;
         } else {
            this.G.add(var1);
         }
      }

   }

   public LangLa_kl(MainScreen var1, Char var2, Skill[] var3) {
      super(var1, new String[]{Caption.W});
      this.I = 32;
      this.J = 15;
      this.w = new int[17];
      this.x = new int[18];
      this.F = -1;

      try {
         beatdz.LangLa_kl.$state_LangLa_kl().ad = this;
         this.p = var1;
         this.y = var2;
         this.z = var3;
         this.r = false;
         this.a(299, 212);
         LangLa_kd var6 = new LangLa_kd(1001);
         DataCenter.gI();
         var6.c = Caption.rb;
         int var10000 = this.a_() - 3;
         DataCenter.gI();
         int var9 = var10000 - 0;
         this.b = new LangLa_gx(var6, this.width, 1, var9, 87, this.G() + 6, 33, this);
         this.e();
         var10000 = super.width - 8 - 162;
         DataCenter.gI();
         int var7 = var10000 + 0;
         var10000 = this.a_() + this.G() - 134;
         DataCenter.gI();
         var9 = var10000 + 0;
         this.V = new LangLa_dz[4];

         for(int var4 = 0; var4 < this.V.length; ++var4) {
            this.V[var4] = new LangLa_dz(var7, var9 + 20 * var4 - 20, 0, 0, Caption.tI[var4], this, 1100 + var4, -27);
            this.V[var4].setSize(30, 18);
            this.b.a((LangLa_cs)this.V[var4], 1);
         }

         Vector var10 = new Vector();
         var10000 = super.width - 8 - 45;
         DataCenter.gI();
         var7 = var10000 + 0;
         var10000 = this.height - 33;
         DataCenter.gI();
         var9 = var10000 + 0;
         LangLa_dz var8;
         (var8 = this.a(var7, var9, Caption.cP, this, 2010, 7)).setSize(40, 20);
         this.Q = var8;
         var10.addElement(this.Q);
         (var8 = this.a(this.Q.cx - 43, this.Q.cy, Caption.cQ, this, 2009, 7)).setSize(40, 20);
         var10.addElement(var8);
         this.R = var8;
         var10.addElement(this.R);
         var10000 = this.b.c() + 62;
         DataCenter.gI();
         var7 = var10000 + 0;
         var10000 = this.a_() + this.G() - 41;
         DataCenter.gI();
         var9 = var10000 + 0;
         this.B = this.a(var7, var9, Caption.cR, 1234);
         var10.addElement(this.B);
         this.P = new LangLa_lf[2];
         var10000 = this.b.c() + 5;
         DataCenter.gI();
         var7 = var10000 + 0;
         var10000 = this.a_() + 7;
         DataCenter.gI();
         var9 = var10000 + 0;
         this.P[0] = new LangLa_lf(new LangLa_kd(2000, Caption.sh), var7, var9, 196, 23, 64, this, false);
         this.P[1] = new LangLa_lf(new LangLa_kd(2011, Caption.sD), var7, var9, 196, 23, 64, this, false);
         this.c = new mTextBox[4];
         DataCenter.gI();
         DataCenter.gI();
         this.c[0] = this.a(this.b.c() + 62 + 0, this.a_() + 38, 72, "", this, 2);
         var10.addElement(this.c[0]);
         var8 = this.Z = this.a(this.b.c() + 145 - 5 + 0, this.a_() + 38 + 3, "", this, 2001, 58);
         var10.addElement(var8);
         var8 = this.aa = this.a(this.b.c() + 145 + 15 + 0, this.a_() + 38 + 3, "", this, 2002, 57);
         var10.addElement(var8);
         var8 = this.ab = this.a(this.b.c() + 145 + 35 + 0, this.a_() + 38 + 3, "", this, 2012, 244);
         var10.addElement(var8);
         this.c[1] = this.a(this.b.c() + 62 + 0, this.a_() + 38 + 25, 72, "", this, 2);
         var10.addElement(this.c[1]);
         var8 = this.a(this.b.c() + 145 - 5 + 0, this.a_() + 38 + 25 + 3, "", this, 2003, 58);
         var10.addElement(var8);
         var8 = this.a(this.b.c() + 145 + 15 + 0, this.a_() + 38 + 25 + 3, "", this, 2004, 57);
         var10.addElement(var8);
         var8 = this.a(this.b.c() + 145 + 35 + 0, this.a_() + 38 + 25 + 3, "", this, 2014, 244);
         var10.addElement(var8);
         this.c[2] = this.a(this.b.c() + 62 + 0, this.a_() + 38 + 50, 72, "", this, 2);
         var10.addElement(this.c[2]);
         var8 = this.a(this.b.c() + 145 - 5 + 0, this.a_() + 38 + 50 + 3, "", this, 2005, 58);
         var10.addElement(var8);
         var8 = this.a(this.b.c() + 145 + 15 + 0, this.a_() + 38 + 50 + 3, "", this, 2006, 57);
         var10.addElement(var8);
         var8 = this.a(this.b.c() + 145 + 35 + 0, this.a_() + 38 + 50 + 3, "", this, 2016, 244);
         var10.addElement(var8);
         this.c[3] = this.a(this.b.c() + 62 + 0, this.a_() + 38 + 75, 72, "", this, 2);
         var10.addElement(this.c[3]);
         var8 = this.a(this.b.c() + 145 - 5 + 0, this.a_() + 38 + 75 + 3, "", this, 2007, 58);
         var10.addElement(var8);
         var8 = this.a(this.b.c() + 145 + 15 + 0, this.a_() + 38 + 75 + 3, "", this, 2008, 57);
         var10.addElement(var8);
         var8 = this.a(this.b.c() + 145 + 35 + 0, this.a_() + 38 + 75 + 3, "", this, 2018, 244);
         var10.addElement(var8);
         this.b.a((Vector)var10, 2);
         this.P[0].a((Vector)var10, 0);
         var10 = new Vector();
         var10000 = super.width - 8 - 45;
         DataCenter.gI();
         var7 = var10000 + 0;
         var10000 = this.height - 33;
         DataCenter.gI();
         var9 = var10000 + 0;
         this.Y = this.a(var7, var9, Caption.cP, this, 3001, 7);
         this.Y.setSize(40, 20);
         var10.addElement(this.Y);
         this.X = this.a(this.Y.cx - 43, var9, Caption.bk, this, 3000, 7);
         this.X.setSize(40, 20);
         var10.addElement(this.X);
         this.b.a((Vector)var10, 3);
         LangLa_kd var11;
         (var11 = new LangLa_kd(1235)).c = Caption.tJ.clone();
         var10000 = this.b.c() + 71;
         DataCenter.gI();
         var7 = var10000 + 0;
         var10000 = this.a_() + this.G() - 61;
         DataCenter.gI();
         var9 = var10000 + 0;
         this.A = this.a(var7, var9, 64, Caption.tJ.length, var11, this, 1);
         this.syncAppearanceSelection(var2.selectCaiTrang);
         this.b.a((LangLa_cs)this.A, 0);
         (var8 = this.a(super.width - 8 - 55, this.height - 68, Caption.bj, this, 4001, 7)).setSize(50, 20);
         this.S = var8;
         this.b.a((LangLa_cs)this.S, 4);
         (var8 = this.a(super.width - 8 - 110, this.height - 68, Caption.qi, this, 4002, 7)).setSize(50, 20);
         this.T = var8;
         this.b.a((LangLa_cs)this.T, 4);
         (var8 = this.a(super.width - 8 - 165, this.height - 68, Caption.lQ, this, 4003, 7)).setSize(50, 20);
         this.U = var8;
         this.b.a((LangLa_cs)this.U, 4);
         this.b.a(!this.v());
         this.P[0].a(!this.v());
         this.b.a(0);
         this.b(0);
         if (var2.isMe()) {
            this.a(GameSrc.gI().aw);
         } else {
            this.a(0);
         }
      } catch (Exception var5) {
         Utlis.println(var5);
      }

      if (this.v()) {
         this.i = GameSrc.gI().diemTiemNang;
         this.v = GameSrc.gI().diemKyNang;
      }

   }

   /** Optional base points; retain compatibility with servers sending total chakra. */
   public void readPotentialTail(Message message) throws java.io.IOException {
      chakraBonus = 0; hasBasePotential = false;
      java.io.DataInputStream in = message.reader.dis;
      if (in.available() < 4) return;
      in.mark(in.available());
      try {
         int marker = in.readInt();
         if (marker != 0x504F5431) {
            in.reset();
            byte rank = message.readByte(), path = message.readByte();
            // Game strings have an extra compact-string discriminator. Plain
            // DataInputStream.readUTF consumes the wrong length and corrupts the panel.
            String name = message.readUTF(), pathName = message.readUTF();
            String next = message.readUTF(), title = message.readUTF(), detail = message.readUTF();
            y.professionRank = rank; y.professionPath = path;
            y.professionName = name; y.professionPathName = pathName;
            y.professionNextRequirement = next; y.professionTaskTitle = title; y.professionTaskDetail = detail;
            if (in.available() < 20) return;
            marker = in.readInt();
         }
         if (marker != 0x504F5431 || in.available() < 16) return;
         int strength = in.readInt(), chakra = in.readInt(), mp = in.readInt(), hp = in.readInt();
         if (strength < 0 || chakra < 0 || hp < 0 || mp < 0) return;
         chakraBonus = f - chakra; e = strength; f = chakra; g = hp; h = mp; hasBasePotential = true;
         if(in.available()>=144 && in.readInt()==0x434D4231){
            int[] full=new int[35];for(int index=0;index<full.length;index++)full[index]=in.readInt();
            System.arraycopy(full,0,w,0,17);System.arraycopy(full,17,x,0,18);
            y.speedMove=Char.movementSpeed(x[6]);
            DataCenter.gI().equipmentBalanceRevision=Math.max(1,DataCenter.gI().equipmentBalanceRevision);
         }
      } catch (java.io.IOException | IndexOutOfBoundsException optionalTailError) {
         // A malformed optional extension must not discard valid core stats.
         in.reset();
      }
   }

   public void writePotential(Message message) throws java.io.IOException {
      if (!d) throw new java.io.IOException("Chỉ số nhân vật chưa tải xong");
      message.writeShort(c[0].e());
      message.writeShort(c[1].e() + chakraBonus);
      message.writeShort(c[2].e());
      message.writeShort(c[3].e());
   }

   public static LangLa_kl l() {
      return beatdz.LangLa_kl.$state_LangLa_kl().ad;
   }

   private boolean t() {
      return this.y.idClass == 0 || this.y.idClass == 1 || this.y.idClass == 5;
   }

   public int m() {
      return this.k();
   }

   public int n() {
      return this.b.b.b;
   }

   private void a(LangLa_ii var1, int var2) {
      this.af = false;

      for(int var3 = 0; var3 < this.K.length; ++var3) {
         if (this.K[var3] != null) {
            for(int var4 = 0; var4 < this.K[var3].length; ++var4) {
               if (this.K[var3][var4] != null) {
                  this.K[var3][var4].k = -1;
               }
            }
         }
      }

      var1.k = var2;
   }

   public void d() {
      super.d();
      GameSrc.gI().aw = this.k();
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      boolean var13 = false;

      label826: {
         label827: {
            label828: {
               label829: {
                  label851: {
                     label852: {
                        label853: {
                           try {
                              var13 = true;
                              LangLa_kl var4;
                              Message var5;
                              if (!this.d) {
                                 var4 = this;

                                 try {
                                    (var5 = new Message((byte)63)).writeUTF(var4.y.name);
                                    var5.send();
                                 } catch (Exception var16) {
                                    Utlis.println(var16);
                                 }
                                 // Navigation is safe while the server fills the fields.
                                 // Keep allocation and other data-dependent actions blocked.
                                 if (var1.b != 1001 && var1.b != -9997 && var1.b != 2000 && var1.b != 2011) return;
                              }

                              super.a(var1, var2, var3);
                              Message var22;
                              label810:
                              switch(var1.b) {
                              case 200:
                                 var4 = this;

                                 try {
                                    (var5 = new Message((byte)-24)).writeByte(var4.ac.b.b);
                                    var5.send();
                                    var13 = false;
                                 } catch (Exception var15) {
                                    Utlis.println(var15);
                                    var13 = false;
                                 }
                                 break;
                              case 1001:
                                 if (var1.j.k >= 0) {
                                    this.b.a(var1.j.k);
                                    switch(this.b.b.b) {
                                    case 0:
                                    case 1:
                                       this.e(this.b.b.b);
                                       var13 = false;
                                       break label810;
                                    case 2:
                                       DataCenter.gI();
                                       this.P[0].a(this.P[0].b.b);
                                       var13 = false;
                                       break label810;
                                    case 3:
                                    default:
                                       var13 = false;
                                       break label810;
                                    case 4:
                                       DataCenter.gI();
                                       this.P[1].a(this.P[1].b.b);
                                       var13 = false;
                                    }
                                 } else {
                                    var13 = false;
                                 }
                                 break;
                              case 1002:
                                 if (var1.j.k >= 0) {
                                    this.O.a(var1.j.k);
                                    var13 = false;
                                 } else {
                                    var13 = false;
                                 }
                                 break;
                              case 1030:
                                 if (var1.j.k < 0) {
                                    var13 = false;
                                 } else {
                                    this.a = var1.j.k;
                                    if (var1.j.k < this.z.length) {
                                       if (var2 - var1.j.cx >= 56) {
                                          var13 = false;
                                          break;
                                       }

                                       String var24 = this.b(var1.j.k);
                                       this.w();
                                       boolean var25 = this.X.u;
                                       boolean var28 = this.Y.u;
                                       if (this.y.idClass == 0 || !this.v()) {
                                          var28 = true;
                                          var25 = true;
                                       }

                                       String var10001 = var24;
                                       int var10003 = var1.j.cx + 27;
                                       int var10004 = var1.j.cy + var1.j.k * var1.j.h - var1.j.f + 1;
                                       boolean var7 = this.y.isMe();
                                       boolean var6 = var28;
                                       boolean var20 = true;
                                       var2 = var10004;
                                       int var21 = var10003;
                                       String var30 = var10001;
                                       LangLa_ie var27;
                                       if ((var27 = new LangLa_ie(var21, var2, 220, this, var30, var25, var6, var7)).cx > DataCenter.gI().widthScreen - var27.width - super.cx) {
                                          var27.cx = (short)(DataCenter.gI().widthScreen - var27.width - super.cx);
                                       }

                                       if (var27.cx < var21) {
                                          var27.cx = (short)(var21 - (var27.width + 3));
                                       }

                                       if (var27.cx < -super.cx) {
                                          var27.cx = (short)(-super.cx);
                                       }

                                       if (var27.cy > DataCenter.gI().heightScreen - var27.height - super.cy) {
                                          var27.cy = (short)(DataCenter.gI().heightScreen - var27.height - super.cy);
                                       }

                                       this.a(var27);
                                       this.cL = var27;
                                       var13 = false;
                                       break;
                                    }

                                    var13 = false;
                                 }
                                 break;
                              case 1040:
                              case 1041:
                              case 1042:
                                 this.a(var1.j, var1.j.k);
                                 this.cL = a(var1, this, (Item)null);
                                 var13 = false;
                                 break;
                              case 1100:
                                 g(0);
                                 var13 = false;
                                 break;
                              case 1101:
                                 g(1);
                                 var13 = false;
                                 break;
                              case 1102:
                                 g(2);
                                 var13 = false;
                                 break;
                              case 1103:
                                 g(3);
                                 var13 = false;
                                 break;
                              case 1200:
                                 DataCenter.gI();
                                 if (this.P[0].b.b == 0) {
                                    if (var1.j.k >= 0) {
                                       LangLa_jz var29 = var1;
                                       String var19;
                                       if (this.t()) {
                                          var19 = Caption.rM[0];
                                       } else {
                                          var19 = Caption.rM[1];
                                       }

                                       this.w();
                                       this.cL = a(var19, this, var29.j.cx + 40, var29.j.cy, 205);
                                       var13 = false;
                                    } else {
                                       var13 = false;
                                    }
                                 } else {
                                    var13 = false;
                                 }
                                 break;
                              case 1201:
                                 if (var1.j.k >= 0) {
                                    if (var1.j.k % 2 == 0) {
                                       (var22 = Message.c((byte)-74)).writeByte(var1.j.k / 2 - 1);
                                       var22.send();
                                       var13 = false;
                                    } else {
                                       var13 = false;
                                    }
                                 } else {
                                    var13 = false;
                                 }
                                 break;
                              case 2000:
                                 if (var1.j.k >= 0) {
                                    this.P[0].a(var1.j.k);
                                    this.A();
                                    var13 = false;
                                 } else {
                                    var13 = false;
                                 }
                                 break;
                              case 2001:
                                 if (this.c[0].e() - 1 >= this.c[0].n) {
                                    this.c[0].a(this.c[0].e() - 1);
                                    ++this.i;
                                    var13 = false;
                                 } else {
                                    var13 = false;
                                 }
                                 break;
                              case 2002:
                                 if (this.i > 0) {
                                    this.c[0].a(this.c[0].e() + 1);
                                    --this.i;
                                    var13 = false;
                                 } else {
                                    var13 = false;
                                 }
                                 break;
                              case 2003:
                                 if (this.c[1].e() - 1 >= this.c[1].n) {
                                    this.c[1].a(this.c[1].e() - 1);
                                    ++this.i;
                                    var13 = false;
                                 } else {
                                    var13 = false;
                                 }
                                 break;
                              case 2004:
                                 if (this.i > 0) {
                                    this.c[1].a(this.c[1].e() + 1);
                                    --this.i;
                                    var13 = false;
                                 } else {
                                    var13 = false;
                                 }
                                 break;
                              case 2005:
                                 if (this.c[2].e() - 1 >= this.c[2].n) {
                                    this.c[2].a(this.c[2].e() - 1);
                                    ++this.i;
                                    var13 = false;
                                 } else {
                                    var13 = false;
                                 }
                                 break;
                              case 2006:
                                 if (this.i > 0) {
                                    this.c[2].a(this.c[2].e() + 1);
                                    --this.i;
                                    var13 = false;
                                 } else {
                                    var13 = false;
                                 }
                                 break;
                              case 2007:
                                 if (this.c[3].e() - 1 >= this.c[3].n) {
                                    this.c[3].a(this.c[3].e() - 1);
                                    ++this.i;
                                    var13 = false;
                                 } else {
                                    var13 = false;
                                 }
                                 break;
                              case 2008:
                                 if (this.i > 0) {
                                    this.c[3].a(this.c[3].e() + 1);
                                    --this.i;
                                    var13 = false;
                                 } else {
                                    var13 = false;
                                 }
                                 break;
                              case 2009:
                                 this.i += this.c[0].e() + this.c[1].e() + this.c[2].e() + this.c[3].e() - (this.e + this.f + this.h + this.g);
                                 this.c[0].a("" + this.e);
                                 this.c[1].a("" + this.f);
                                 this.c[2].a("" + this.h);
                                 this.c[3].a("" + this.g);
                                 var13 = false;
                                 break;
                              case 2010:
                                 var4 = this;

                                 try {
                                    var5 = new Message((byte)62);
                                    var4.writePotential(var5);
                                    var5.send();
                                    var13 = false;
                                 } catch (Exception var14) {
                                    Utlis.println(var14);
                                    var13 = false;
                                 }
                                 break;
                              case 2011:
                                 if (var1.j.k >= 0) {
                                    this.P[1].a(var1.j.k);
                                    this.B();
                                    var13 = false;
                                 } else {
                                    var13 = false;
                                 }
                                 break;
                              case 2012:
                                 if (this.i > 10) {
                                    this.c[0].a(this.c[0].e() + 10);
                                    this.i -= 10;
                                    var13 = false;
                                 } else if (this.i > 0) {
                                    this.c[0].a(this.c[0].e() + this.i);
                                    this.i = 0;
                                    var13 = false;
                                 } else {
                                    var13 = false;
                                 }
                                 break;
                              case 2014:
                                 if (this.i > 10) {
                                    this.c[1].a(this.c[1].e() + 10);
                                    this.i -= 10;
                                    var13 = false;
                                 } else if (this.i > 0) {
                                    this.c[1].a(this.c[1].e() + this.i);
                                    this.i = 0;
                                    var13 = false;
                                 } else {
                                    var13 = false;
                                 }
                                 break;
                              case 2016:
                                 if (this.i > 10) {
                                    this.c[2].a(this.c[2].e() + 10);
                                    this.i -= 10;
                                    var13 = false;
                                 } else if (this.i > 0) {
                                    this.c[2].a(this.c[2].e() + this.i);
                                    this.i = 0;
                                    var13 = false;
                                 } else {
                                    var13 = false;
                                 }
                                 break;
                              case 2018:
                                 if (this.i > 10) {
                                    this.c[3].a(this.c[3].e() + 10);
                                    this.i -= 10;
                                    var13 = false;
                                 } else if (this.i > 0) {
                                    this.c[3].a(this.c[3].e() + this.i);
                                    this.i = 0;
                                    var13 = false;
                                 } else {
                                    var13 = false;
                                 }
                                 break;
                              case 2050:
                                 var22 = Message.c((byte)-18);
                                 var3 = this.u();
                                 var22.writeByte(var3);
                                 var22.send();
                                 var13 = false;
                                 break;
                              case 3000:
                                 this.r();
                                 var13 = false;
                                 break;
                              case 3001:
                                 this.q();
                                 var13 = false;
                                 break;
                              case 4001:
                                 if (this.F >= 0) {
                                    var2 = this.u();
                                    SkillClan var23 = (SkillClan)this.y.aH.elementAt(var2);
                                    this.p.a((LangLa_cx)(new LangLa_aq(this.p, var2, var23)));
                                    var13 = false;
                                 } else {
                                    var13 = false;
                                 }
                                 break;
                              case 4002:
                                 if (this.F >= 0) {
                                    var2 = this.u();
                                    if (((SkillClan)this.y.aH.elementAt(var2)).id == 19) {
                                       Message var26;
                                       (var26 = Message.c((byte)-26)).writeByte(var2);
                                       var26.writeBoolean(true);
                                       var26.send();
                                       var13 = false;
                                    } else {
                                       this.p.a((LangLa_cx)(new LangLa_f(this.p, var2)));
                                       var13 = false;
                                    }
                                 } else {
                                    var13 = false;
                                 }
                                 break;
                              case 4003:
                                 if (this.F >= 0) {
                                    DataCenter.gI().currentScreen.a(Caption.qF, 2050, this);
                                    var13 = false;
                                 } else {
                                    var13 = false;
                                 }
                                 break;
                              default:
                                 if (this.k() == 0) {
                                    if (var1.b == 1010) {
                                       this.a(var1.j, var1.j.k);
                                       switch(var1.j.k) {
                                       case 0:
                                          this.cL = a(var1, this, this.y.arrItemBody[0]);
                                          var13 = false;
                                          break label852;
                                       case 1:
                                          this.cL = a(var1, this, this.y.arrItemBody[2]);
                                          var13 = false;
                                          break label852;
                                       case 2:
                                          this.cL = a(var1, this, this.y.arrItemBody[4]);
                                          var13 = false;
                                          break label852;
                                       case 3:
                                          this.cL = a(var1, this, this.y.arrItemBody[6]);
                                          var13 = false;
                                          break label852;
                                       case 4:
                                          this.cL = a(var1, this, this.y.arrItemBody[8]);
                                          var13 = false;
                                          break label852;
                                       default:
                                          var13 = false;
                                          break label852;
                                       }
                                    }

                                    if (var1.b == 1011) {
                                       this.a(var1.j, var1.j.k);
                                       switch(var1.j.k) {
                                       case 0:
                                          this.cL = a(var1, this, this.y.arrItemBody[1]);
                                          var13 = false;
                                          break label826;
                                       case 1:
                                          this.cL = a(var1, this, this.y.arrItemBody[3]);
                                          var13 = false;
                                          break label826;
                                       case 2:
                                          this.cL = a(var1, this, this.y.arrItemBody[5]);
                                          var13 = false;
                                          break label826;
                                       case 3:
                                          this.cL = a(var1, this, this.y.arrItemBody[7]);
                                          var13 = false;
                                          break label826;
                                       case 4:
                                          this.cL = a(var1, this, this.y.arrItemBody[9]);
                                          var13 = false;
                                          break label826;
                                       default:
                                          var13 = false;
                                          break label826;
                                       }
                                    }

                                    if (var1.b == 1012) {
                                       this.a(var1.j, var1.j.k);
                                       switch(var1.j.k) {
                                       case 0:
                                          this.cL = a(var1, this, this.y.arrItemBody[10]);
                                          var13 = false;
                                          break label827;
                                       case 1:
                                          this.cL = a(var1, this, this.y.arrItemBody[11]);
                                          var13 = false;
                                          break label827;
                                       case 2:
                                          this.cL = a(var1, this, this.y.arrItemBody[12]);
                                          var13 = false;
                                          break label827;
                                       case 3:
                                          this.cL = a(var1, this, this.y.arrItemBody[13]);
                                          var13 = false;
                                          break label827;
                                       default:
                                          var13 = false;
                                          break label827;
                                       }
                                    }

                                    if (var1.b == 1013) {
                                       this.a(var1.j, var1.j.k);
                                       this.cL = a(var1, this, this.y.arrItemBody[14]);
                                       var13 = false;
                                    } else if (var1.b == 1014) {
                                       this.a(var1.j, var1.j.k);
                                       this.cL = a(var1, this, this.y.arrItemBody[15]);
                                       var13 = false;
                                    } else if (var1.b == 1015) {
                                       this.a(var1.j, var1.j.k);
                                       this.cL = a(var1, this, this.y.arrItemBody[16]);
                                       var13 = false;
                                    } else {
                                       if (var1.b == 1020) {
                                          this.a(var1.j, var1.j.k);
                                          switch(var1.j.k) {
                                          case 0:
                                             this.cL = a(var1, this, this.y.arrItemBody2[0]);
                                             var13 = false;
                                             break label828;
                                          case 1:
                                             this.cL = a(var1, this, this.y.arrItemBody2[2]);
                                             var13 = false;
                                             break label828;
                                          case 2:
                                             this.cL = a(var1, this, this.y.arrItemBody2[4]);
                                             var13 = false;
                                             break label828;
                                          case 3:
                                             this.cL = a(var1, this, this.y.arrItemBody2[6]);
                                             var13 = false;
                                             break label828;
                                          case 4:
                                             this.cL = a(var1, this, this.y.arrItemBody2[8]);
                                             var13 = false;
                                             break label828;
                                          default:
                                             var13 = false;
                                             break label828;
                                          }
                                       }

                                       if (var1.b == 1021) {
                                          this.a(var1.j, var1.j.k);
                                          switch(var1.j.k) {
                                          case 0:
                                             this.cL = a(var1, this, this.y.arrItemBody2[1]);
                                             var13 = false;
                                             break label829;
                                          case 1:
                                             this.cL = a(var1, this, this.y.arrItemBody2[3]);
                                             var13 = false;
                                             break label829;
                                          case 2:
                                             this.cL = a(var1, this, this.y.arrItemBody2[5]);
                                             var13 = false;
                                             break label829;
                                          case 3:
                                             this.cL = a(var1, this, this.y.arrItemBody2[7]);
                                             var13 = false;
                                             break label829;
                                          case 4:
                                             this.cL = a(var1, this, this.y.arrItemBody2[9]);
                                             var13 = false;
                                             break label829;
                                          default:
                                             var13 = false;
                                             break label829;
                                          }
                                       }

                                       if (var1.b == 1022) {
                                          this.a(var1.j, var1.j.k);
                                          switch(var1.j.k) {
                                          case 0:
                                             this.cL = a(var1, this, this.y.arrItemBody2[10]);
                                             var13 = false;
                                             break label851;
                                          case 1:
                                             this.cL = a(var1, this, this.y.arrItemBody2[11]);
                                             var13 = false;
                                             break label851;
                                          case 2:
                                             this.cL = a(var1, this, this.y.arrItemBody2[12]);
                                             var13 = false;
                                             break label851;
                                          case 3:
                                             this.cL = a(var1, this, this.y.arrItemBody2[13]);
                                             var13 = false;
                                             break label851;
                                          default:
                                             var13 = false;
                                             break label851;
                                          }
                                       }

                                       if (var1.b == 1023) {
                                          this.a(var1.j, var1.j.k);
                                          this.cL = a(var1, this, this.y.arrItemBody2[14]);
                                          var13 = false;
                                       } else if (var1.b == 1024) {
                                          this.a(var1.j, var1.j.k);
                                          this.cL = a(var1, this, this.y.arrItemBody2[15]);
                                          var13 = false;
                                       } else if (var1.b == 1025) {
                                          this.a(var1.j, var1.j.k);
                                          this.cL = a(var1, this, this.y.arrItemBody2[16]);
                                          var13 = false;
                                       } else if (var1.b == 1026) {
                                          (var5 = Message.c((byte)-73)).writeUTF(this.y.name);
                                          var5.send();
                                          LangLa_dp.a().h();
                                          var13 = false;
                                       } else if (var1.b == 1090) {
                                          this.a(var1.j, var1.j.k);
                                          this.af = true;
                                          this.cL = a(var1, this, this.C);
                                          var13 = false;
                                       } else if (var1.b == 1401) {
                                          this.E = 0;
                                          this.D = null;
                                          if (var1.j.k >= 0 && var1.j.k < this.y.aH.size()) {
                                             this.F = var1.j.k;
                                             this.o();
                                             var13 = false;
                                          } else {
                                             this.F = -1;
                                             var13 = false;
                                          }
                                       } else if (var1.b == 1403) {
                                          this.E = 1;
                                          if (var1.j.k >= 0) {
                                             this.F = var1.j.k;
                                             this.o();
                                             var13 = false;
                                          } else {
                                             this.F = -1;
                                             var13 = false;
                                          }
                                       } else {
                                          var13 = false;
                                       }
                                    }
                                 } else {
                                    var13 = false;
                                 }
                              }
                           } catch (Exception var17) {
                              Utlis.println(var17);
                              var13 = false;
                              break label853;
                           } finally {
                              if (var13) {
                                 if (!this.v() && this.cL != null && this.cL instanceof LangLa_mk) {
                                    ((LangLa_mk)this.cL).a();
                                 }

                              }
                           }

                           if (!this.v() && this.cL != null && this.cL instanceof LangLa_mk) {
                              ((LangLa_mk)this.cL).a();
                              return;
                           }

                           return;
                        }

                        if (!this.v() && this.cL != null && this.cL instanceof LangLa_mk) {
                           ((LangLa_mk)this.cL).a();
                           return;
                        }

                        return;
                     }

                     if (!this.v() && this.cL != null && this.cL instanceof LangLa_mk) {
                        ((LangLa_mk)this.cL).a();
                     }

                     return;
                  }

                  if (!this.v() && this.cL != null && this.cL instanceof LangLa_mk) {
                     ((LangLa_mk)this.cL).a();
                  }

                  return;
               }

               if (!this.v() && this.cL != null && this.cL instanceof LangLa_mk) {
                  ((LangLa_mk)this.cL).a();
               }

               return;
            }

            if (!this.v() && this.cL != null && this.cL instanceof LangLa_mk) {
               ((LangLa_mk)this.cL).a();
            }

            return;
         }

         if (!this.v() && this.cL != null && this.cL instanceof LangLa_mk) {
            ((LangLa_mk)this.cL).a();
         }

         return;
      }

      if (!this.v() && this.cL != null && this.cL instanceof LangLa_mk) {
         ((LangLa_mk)this.cL).a();
      }

   }

   private int u() {
      boolean var2 = false;

      for(int var3 = 0; var3 < this.y.aH.size(); ++var3) {
         SkillClan var1 = (SkillClan)this.y.aH.get(var3);
         if (this.E == 0) {
            if (var1.id == 19) {
               var2 = true;
            }

            if (this.F == var3) {
               if (var2) {
                  return var3 + 1;
               }

               return var3;
            }
         } else {
            for(int var4 = 0; var4 < this.y.aH.size(); ++var4) {
               if (((SkillClan)this.y.aH.get(var4)).id == 19) {
                  return var4;
               }
            }
         }
      }

      return this.F;
   }

   public void o() {
      this.D = mFont.c(mFont.d, this.j(this.F), this.width - 20);
   }

   public void q() {
      h(this.z[this.a].idTemplate);
   }

   public void r() {
      i(this.z[this.a].idTemplate);
   }

   private boolean v() {
      return this.y.name.equals(Char.gI().name);
   }

   private static void a(Vector var0, SkillClan var1) {
      ItemOption[] var5;
      int var2 = (var5 = var1.b()).length;

      for(int var3 = 0; var3 < var2; ++var3) {
         String var4;
         if ((var4 = var5[var3].a(0)) != null && var4.length() > 0) {
            var0.addElement(var4);
         }
      }

   }

   private void a(Vector var1, Skill var2) {
      if (this.y.level() >= var2.levelNeed) {
         var1.addElement("c#white" + Caption.rH[3] + var2.levelNeed);
      } else {
         var1.addElement("c#red" + Caption.rH[3] + var2.levelNeed);
      }

      StringBuilder var10001;
      int var4;
      if (var2.idTemplate >= 15 && var2.idTemplate <= 17) {
         var10001 = (new StringBuilder()).append(Caption.cT);
         var4 = this.y.aU;
         var1.addElement(var10001.append((short)(var2.rangeNgang + var4)).toString());
      }

      if (var2.getSkillTemplate().type < 5) {
         var1.addElement(Caption.rH[7] + var2.mpUse);
         var1.addElement(Caption.rH[8] + (float)var2.coolDown / 1000.0F + Caption.cU);
         if (!var2.d()) {
            var10001 = (new StringBuilder()).append(Caption.rH[9]);
            var4 = this.y.aU;
            var1.addElement(var10001.append((short)(var2.rangeNgang + var4)).toString());
            var1.addElement(Caption.rH[10] + var2.maxTarget);
         }
      } else if (var2.idTemplate == 29) {
         var1.addElement(Caption.rH[8] + (float)var2.coolDown / 1000.0F + Caption.cU);
      }

      ItemOption[] var6;
      int var3 = (var6 = var2.g()).length;

      for(var4 = 0; var4 < var3; ++var4) {
         String var5;
         if ((var5 = var6[var4].a(this.y.idClass)) != null && var5.length() > 0) {
            var1.addElement(var5);
         }
      }

   }

   public String b(int var1) {
      this.a = var1;
      Skill var6;
      Skill var2 = b((var6 = this.z[var1]).idTemplate, var6.level + 1);
      Vector var3;
      (var3 = new Vector()).addElement("c#moc" + var6.getSkillTemplate().name);
      if (var6.getSkillTemplate().detail != null && var6.getSkillTemplate().detail.length() > 0) {
         var3.addElement(var6.getSkillTemplate().detail);
      }

      var3.addElement(Caption.rH[4] + var6.getSkillTemplate().levelMax);
      if (var6.getSkillTemplate().type >= 5) {
         var3.addElement("c#green" + Caption.cV);
      } else if (var6.d()) {
         var3.addElement("c#green" + Caption.lk);
      }

      if (var6.level == 0) {
         var3.addElement("c#red" + Caption.cW + var2.level + Caption.cX);
         this.a(var3, var2);
      } else if (var6.level == var6.getSkillTemplate().levelMax) {
         var3.addElement("c#yellow" + Caption.cY);
         this.a(var3, var6);
      } else {
         var3.addElement("c#yellow" + Caption.cZ + var6.level);
         this.a(var3, var6);
         if (var2 != null) {
            var3.addElement("c#red" + Caption.da + var2.level);
            this.a(var3, var2);
         }
      }

      Vector var7 = new Vector();

      int var4;
      String var8;
      for(var4 = 0; var4 < var3.size(); ++var4) {
         var8 = String.valueOf(var3.elementAt(var4));
         int var5;
         Vector var9;
         if (var4 == 0) {
            var9 = mFont.a(mFont.e, var8, 180);

            for(var5 = 0; var5 < var9.size(); ++var5) {
               var7.add(new LangLa_lk(0, (String)var9.elementAt(var5)));
            }
         } else {
            var9 = mFont.a(mFont.d, var8, 180);

            for(var5 = 0; var5 < var9.size(); ++var5) {
               var7.add(new LangLa_lk(1, (String)var9.elementAt(var5)));
            }
         }
      }

      var8 = "";
      this.W = new LangLa_lk[var7.size()];

      for(var4 = 0; var4 < var7.size(); ++var4) {
         this.W[var4] = (LangLa_lk)var7.elementAt(var4);
         var8 = var8 + this.W[var4].b;
         if (var4 < this.W.length - 1) {
            var8 = var8 + "\r\n";
         }
      }

      return var8;
   }

   private static void g(int var0) {
      try {
         Message var1;
         (var1 = new Message((byte)35)).writeByte(var0);
         var1.send();
      } catch (Exception var2) {
         Utlis.println(var2);
      }
   }

   private static void h(int var0) {
      try {
         Message var1;
         (var1 = new Message((byte)14)).writeShort(var0);
         var1.send();
      } catch (Exception var2) {
         Utlis.println(var2);
      }
   }

   private static void i(int var0) {
      try {
         Message var1;
         (var1 = new Message((byte)126)).writeShort(var0);
         var1.send();
      } catch (Exception var2) {
         Utlis.println(var2);
      }
   }

   public void a(int var1, Object var2) {
   }

   public void a(Graphics var1) {
      try {
         if (this.v()) {
            super.a(var1);
         } else {
            this.a(var1, this.cx, this.cy, this.width, this.height, Caption.db, (byte)2, this.r);
         }

         String var10002;
         int var3;
         int var10003;
         int var4;
         if (this.k() == 0) {
            this.b.a((Graphics)var1, 61);
            this.b.a(var1, this.cx, this.cy);
            mFont var10000;
            Graphics var2;
            LangLa_kl var8;
            Item var9;
            switch(this.b.b.b) {
            case 0:
               var2 = var1;
               var8 = this;

               try {
                  var9 = null;
                  if (var8.C != null) {
                     a(var2, var8.ae.cx, var8.ae.cy, var8.C, var8.af, "");
                  }

                  DataCenter.gI();

                  for(var4 = 0; var4 < var8.K[var8.b.b.b][0].i; ++var4) {
                     switch(var4) {
                     case 0:
                        var9 = var8.y.arrItemBody[0];
                        break;
                     case 1:
                        var9 = var8.y.arrItemBody[2];
                        break;
                     case 2:
                        var9 = var8.y.arrItemBody[4];
                        break;
                     case 3:
                        var9 = var8.y.arrItemBody[6];
                        break;
                     case 4:
                        var9 = var8.y.arrItemBody[8];
                     }

                     a(var2, var8.K[var8.b.b.b][0].cx, var8.K[var8.b.b.b][0].cy + var4 * var8.K[var8.b.b.b][0].h, var9, var4 == var8.K[var8.b.b.b][0].k, Caption.qT[var4]);
                  }

                  for(var4 = 0; var4 < var8.K[var8.b.b.b][1].i; ++var4) {
                     switch(var4) {
                     case 0:
                        var9 = var8.y.arrItemBody[1];
                        break;
                     case 1:
                        var9 = var8.y.arrItemBody[3];
                        break;
                     case 2:
                        var9 = var8.y.arrItemBody[5];
                        break;
                     case 3:
                        var9 = var8.y.arrItemBody[7];
                        break;
                     case 4:
                        var9 = var8.y.arrItemBody[9];
                     }

                     a(var2, var8.K[var8.b.b.b][1].cx, var8.K[var8.b.b.b][1].cy + var4 * var8.K[var8.b.b.b][1].h, var9, var4 == var8.K[var8.b.b.b][1].k, Caption.qU[var4]);
                  }

                  for(var4 = 0; var4 < var8.K[var8.b.b.b][2].r; ++var4) {
                     switch(var4) {
                     case 0:
                        var9 = var8.y.arrItemBody[10];
                        break;
                     case 1:
                        var9 = var8.y.arrItemBody[11];
                        break;
                     case 2:
                        var9 = var8.y.arrItemBody[12];
                        break;
                     case 3:
                        var9 = var8.y.arrItemBody[13];
                     }

                     a(var2, var8.K[var8.b.b.b][2].cx + var4 * var8.I, var8.K[var8.b.b.b][2].cy, var9, var4 == var8.K[var8.b.b.b][2].k, Caption.qV[var4]);
                  }

                  a(var2, var8.K[var8.b.b.b][3].cx, var8.K[var8.b.b.b][3].cy, var8.y.arrItemBody[14], var8.K[var8.b.b.b][3].k == 0, Caption.rS[0]);
                  a(var2, var8.K[var8.b.b.b][4].cx, var8.K[var8.b.b.b][4].cy, var8.y.arrItemBody[15], var8.K[var8.b.b.b][4].k == 0, Caption.rS[1]);
                  a(var2, var8.K[var8.b.b.b][5].cx, var8.K[var8.b.b.b][5].cy, var8.y.arrItemBody[16], var8.K[var8.b.b.b][5].k == 0, Caption.rS[2]);
                  DataCenter.gI();
                  var8.y.a(var2, 190, 123, var8.y.a(var8.y.arrItemBody, false), DataCenter.gI().i / 8 % 2, var8.y.m, false);
                  var8.y.b(var2, 190, 68);
                  var10000 = mFont.b;
                  var10002 = Caption.cj;
                  DataCenter.gI();
                  mFont.a((mFont)var10000, (Graphics)var2, var10002, 190, 140, 2, -1, -10275328);
                  var2.f(-1);
                  var2.a(170, 144, 210, 144);
                  return;
               } catch (Exception var6) {
                  Utlis.println(var6);
                  break;
               }
            case 1:
               var2 = var1;
               var8 = this;
               DataCenter.gI();
               var9 = null;

               for(var4 = 0; var4 < var8.K[var8.b.b.b][0].i; ++var4) {
                  switch(var4) {
                  case 0:
                     var9 = var8.y.arrItemBody2[0];
                     break;
                  case 1:
                     var9 = var8.y.arrItemBody2[2];
                     break;
                  case 2:
                     var9 = var8.y.arrItemBody2[4];
                     break;
                  case 3:
                     var9 = var8.y.arrItemBody2[6];
                     break;
                  case 4:
                     var9 = var8.y.arrItemBody2[8];
                  }

                  a(var2, var8.K[var8.b.b.b][0].cx, var8.K[var8.b.b.b][0].cy + var4 * var8.K[var8.b.b.b][0].h, var9, var4 == var8.K[var8.b.b.b][0].k, Caption.qT[var4]);
               }

               for(var4 = 0; var4 < var8.K[var8.b.b.b][1].i; ++var4) {
                  switch(var4) {
                  case 0:
                     var9 = var8.y.arrItemBody2[1];
                     break;
                  case 1:
                     var9 = var8.y.arrItemBody2[3];
                     break;
                  case 2:
                     var9 = var8.y.arrItemBody2[5];
                     break;
                  case 3:
                     var9 = var8.y.arrItemBody2[7];
                     break;
                  case 4:
                     var9 = var8.y.arrItemBody2[9];
                  }

                  a(var2, var8.K[var8.b.b.b][1].cx, var8.K[var8.b.b.b][1].cy + var4 * var8.K[var8.b.b.b][1].h, var9, var4 == var8.K[var8.b.b.b][1].k, Caption.qU[var4]);
               }

               for(var4 = 0; var4 < var8.K[var8.b.b.b][2].r; ++var4) {
                  switch(var4) {
                  case 0:
                     var9 = var8.y.arrItemBody2[10];
                     break;
                  case 1:
                     var9 = var8.y.arrItemBody2[11];
                     break;
                  case 2:
                     var9 = var8.y.arrItemBody2[12];
                     break;
                  case 3:
                     var9 = var8.y.arrItemBody2[13];
                  }

                  a(var2, var8.K[var8.b.b.b][2].cx + var4 * var8.I, var8.K[var8.b.b.b][2].cy, var9, var4 == var8.K[var8.b.b.b][2].k, Caption.qV[var4]);
               }

               a(var2, var8.K[var8.b.b.b][3].cx, var8.K[var8.b.b.b][3].cy, var8.y.arrItemBody2[14], var8.K[var8.b.b.b][3].k == 0, Caption.rS[0]);
               a(var2, var8.K[var8.b.b.b][4].cx, var8.K[var8.b.b.b][4].cy, var8.y.arrItemBody2[15], var8.K[var8.b.b.b][4].k == 0, Caption.rS[1]);
               a(var2, var8.K[var8.b.b.b][5].cx, var8.K[var8.b.b.b][5].cy, var8.y.arrItemBody2[16], var8.K[var8.b.b.b][5].k == 0, Caption.rS[2]);
               DataCenter.gI();
               var8.y.a(var2, 190, 123, var8.y.a(var8.y.arrItemBody2, false), DataCenter.gI().i / 8 % 2, var8.y.m, false);
               var8.y.b(var2, 190, 68);
               break;
            case 2:
               var2 = var1;
               var8 = this;
               DataCenter.gI();
               var3 = this.b.c() + 2;
               var4 = this.P[0].cy + this.P[0].height + 10;
               this.P[0].a(var1);
               switch(this.P[0].b.b) {
               case 0:
                  var10002 = Caption.rc[1];
                  var10003 = var3 + 6;
                  var4 += 10;
                  mFont.a((mFont)mFont.d, (Graphics)var1, var10002, var10003, var4, 0, -1, 0);
                  var10002 = (this.hasBasePotential ? Caption.rc[2] : "Chakra tổng:");
                  var10003 = var3 + 6;
                  var4 += 24;
                  mFont.a((mFont)mFont.d, (Graphics)var1, var10002, var10003, var4, 0, -1, 0);
                  var10002 = Caption.rc[3];
                  var10003 = var3 + 6;
                  var4 += 25;
                  mFont.a((mFont)mFont.d, (Graphics)var1, var10002, var10003, var4, 0, -1, 0);
                  var10002 = Caption.rc[4];
                  var10003 = var3 + 6;
                  var4 += 25;
                  mFont.a((mFont)mFont.d, (Graphics)var1, var10002, var10003, var4, 0, -1, 0);
                  if (this.v() && this.y.idClass > 0) {
                     var10000 = mFont.b;
                     var10002 = Caption.dd;
                     var10003 = var3 + 6;
                     DataCenter.gI();
                     mFont.a((mFont)var10000, (Graphics)var1, var10002, var10003, var4 += 21, 0, -1, -10275328);
                     var1.f(-1);
                     var1.a(var3 + 6, var4 + 4, var3 + 6 + mFont.b(mFont.b, Caption.dd), var4 + 4);
                  }

                  mFont.a((mFont)mFont.d, (Graphics)var1, Caption.rc[0] + " " + this.i + Caption.dc, var3 + 6, this.b.cy + 7 + 23 + 135, 0, -1, 0);
                  return;
               case 1:
                  this.a((Graphics)var1, (LangLa_ii)this.L[this.b.b.b][1]);

                  for(var3 = 0; var3 < Caption.rd.length; ++var3) {
                     var4 = var3 * var8.L[var8.b.b.b][1].h;
                     if (var8.L[var8.b.b.b][1].c(var4)) {
                        if (var8.L[var8.b.b.b][1].k == var3) {
                           var2.f(-6488);
                           var2.c(3, var4, var8.L[var8.b.b.b][1].width - 9, var8.L[var8.b.b.b][1].h);
                        }

                        if (var3 == 0) {
                           mFont.a((mFont)mFont.d, (Graphics)var2, Caption.rd[var3] + ": " + var8.w[var3] * 90 / 100 + " - " + var8.w[var3], 10, var4 + var8.L[var8.b.b.b][1].h / 2, 0, -1, 0);
                        } else {
                           mFont.a((mFont)mFont.d, (Graphics)var2, Caption.rd[var3] + ": " + var8.w[var3] + (var3 != 5 && var3 != 16 ? "" : "%"), 10, var4 + var8.L[var8.b.b.b][1].h / 2, 0, -1, 0);
                        }
                     }
                  }

                  var8.b(var2);
                  var8.L[var8.b.b.b][1].b(var2, -17, -13);
                  return;
               case 2:
                  this.a((Graphics)var1, (LangLa_ii)this.L[this.b.b.b][2]);

                  for(var3 = 0; var3 < var8.L[var8.b.b.b][2].i; ++var3) {
                     var4 = var3 * var8.L[var8.b.b.b][2].h;
                     if (var8.L[var8.b.b.b][2].c(var4)) {
                        if (var8.L[var8.b.b.b][2].k == var3) {
                           var2.f(-6488);
                           var2.c(3, var4, var8.L[var8.b.b.b][2].width - 9, var8.L[var8.b.b.b][2].h);
                        }

                        if (var3 == 10) {
                           if (var8.y.idhe > 0) {
                              mFont.a((mFont)mFont.d, (Graphics)var2, Caption.re[var3] + Caption.ro[var8.y.L() - 1] + ": " + var8.x[var3], 10, var4 + var8.L[var8.b.b.b][2].h / 2, 0, -1, 0);
                           } else {
                              mFont.a((mFont)mFont.d, (Graphics)var2, Caption.kl + ": " + var8.x[var3], 10, var4 + var8.L[var8.b.b.b][2].h / 2, 0, -1, 0);
                           }
                        } else if (var3 == 11) {
                           if (var8.y.idhe > 0) {
                              mFont.a((mFont)mFont.d, (Graphics)var2, Caption.re[var3] + Caption.ro[var8.y.M() - 1] + ": " + var8.x[var3], 10, var4 + var8.L[var8.b.b.b][2].h / 2, 0, -1, 0);
                           } else {
                              mFont.a((mFont)mFont.d, (Graphics)var2, Caption.km + ": " + var8.x[var3], 10, var4 + var8.L[var8.b.b.b][2].h / 2, 0, -1, 0);
                           }
                        } else {
                           mFont.a((mFont)mFont.d, (Graphics)var2, Caption.re[var3] + ": " + var8.x[var3] + (var3 != 8 && var3 != 9 ? "" : "%"), 10, var4 + var8.L[var8.b.b.b][2].h / 2, 0, -1, 0);
                        }
                     }
                  }

                  var8.b(var2);
                  var8.L[var8.b.b.b][2].b(var2, -17, -13);
                  return;
               default:
                  return;
               }
            case 3:
               this.h(var1);
               break;
            case 4:
               this.i(var1);
               break;
            case 5:
               this.d(var1);
               return;
            default:
               return;
            }
         } else if (this.k() == 2) {
            this.e(var1);
         }

      } catch (Exception var7) {
         Utlis.println(var7);
      }
   }
   /*
   else if (this.k() == 1) {
            this.O.a((Graphics)var1, 61);
            this.O.a(var1, this.cx, this.cy);
            switch(this.O.b.b) {
            case 0:
               var3 = this.O.c() + 8;
               var4 = this.O.cy + 7 + 30;
               var10002 = Caption.rc[1];
               var10003 = var3 + 6;
               var4 += 10;
               mFont.a((mFont)mFont.d, (Graphics)var1, var10002, var10003, var4, 0, -1, 0);
               var10002 = (this.hasBasePotential ? Caption.rc[2] : "Chakra tổng:");
               var10003 = var3 + 6;
               var4 += 27;
               mFont.a((mFont)mFont.d, (Graphics)var1, var10002, var10003, var4, 0, -1, 0);
               var10002 = Caption.rc[3];
               var10003 = var3 + 6;
               var4 += 28;
               mFont.a((mFont)mFont.d, (Graphics)var1, var10002, var10003, var4, 0, -1, 0);
               var10002 = Caption.rc[4];
               var10003 = var3 + 6;
               var4 += 28;
               mFont.a((mFont)mFont.d, (Graphics)var1, var10002, var10003, var4, 0, -1, 0);
               if (this.v() && this.y.idClass > 0) {
                  var10003 = var3 + 6;
                  var4 += 42;
                  mFont.a((mFont)mFont.b, (Graphics)var1, Caption.dd, var10003, var4, 0, -1, -10275328);
                  var1.f(-1);
                  var1.a(var3 + 6, var4 + 4, var3 + 6 + mFont.b(mFont.b, Caption.dd), var4 + 4);
               }

               mFont.a((mFont)mFont.d, (Graphics)var1, Caption.rc[0] + " " + this.i + Caption.dc, this.Q.cx, this.Q.cy - 9, 0, -1, 0);
               break;
            case 1:
               this.g(var1);
               break;
            case 2:
               this.f(var1);
               return;
            default:
               return;
            }
         } 
   */

   private void e(Graphics var1) {
      int var2 = this.b.c() + 15;
      int var3 = this.b.cy + 7 + 18;
      if (!this.y.isMe() && this.B.a) {
         mFont.a((mFont)mFont.d, (Graphics)var1, Caption.dg, var2, var3, 0, -6488, 0);
      } else {
         mFont.c(mFont.d, var1, Caption.rc[0] + " " + this.v + Caption.dc, var2, this.a_() + this.G() - 16, 0, -1, 0);
         this.a((Graphics)var1, (LangLa_ii)this.N[0]);

         for(var3 = 0; var3 < this.z.length; ++var3) {
            var2 = var3 * this.N[0].h;
            if (this.N[0].c(var2)) {
               if (this.a == var3) {
                  this.a(var1, 28, var2 + 1, this.N[0].width - 29, 25, -15, 84, 5, 1, 1);
               } else {
                  this.a(var1, 28, var2 + 1, this.N[0].width - 29, 25, -14, 84, 5, 1, 1);
               }

               mFont.a((mFont)mFont.e, (Graphics)var1, this.z[var3].getSkillTemplate().name, 35, var2 + 8, 0, -7812062, 0);
               if (this.z[var3].level == this.z[var3].getSkillTemplate().levelMax) {
                  mFont.a((mFont)mFont.d, (Graphics)var1, Caption.cY, 35, var2 + 18, 0, -2560, 0);
               } else {
                  mFont.a((mFont)mFont.d, (Graphics)var1, Caption.cZ + this.z[var3].level, 35, var2 + 18, 0, -1, 0);
               }

               LangLa_fq.a(var1, this.z[var3].getSkillTemplate().idIcon, 0, 1, var2 + 1, 20);
            }
         }

         if (this.cL != null && this.cL instanceof LangLa_ie) {
            var2 = this.a * this.N[0].h;
            var1.f(-1);
            var1.b(0, var2, 26, 26);
         }

         this.b(var1);
         this.N[0].b(var1, -7, -6);
      }
   }

   private void f(Graphics var1) {
      this.O.c();
      int var10000 = this.O.cy + 7;
      this.a((Graphics)var1, (LangLa_ii)this.M[2]);

      for(int var3 = 0; var3 < this.M[2].i; ++var3) {
         int var2 = var3 * this.M[2].h;
         if (this.M[2].c(var2)) {
            if (this.M[2].k == var3) {
               var1.f(-6488);
               var1.c(3, var2, this.M[2].width - 9, this.M[2].h);
            }

            if (var3 == 10) {
               if (this.y.idhe > 0) {
                  mFont.a((mFont)mFont.d, (Graphics)var1, Caption.re[var3] + Caption.ro[this.y.L() - 1] + ": " + this.x[var3], 10, var2 + this.M[2].h / 2, 0, -1, 0);
               } else {
                  mFont.a((mFont)mFont.d, (Graphics)var1, Caption.kl + ": " + this.x[var3], 10, var2 + this.M[2].h / 2, 0, -1, 0);
               }
            } else if (var3 == 11) {
               if (this.y.idhe > 0) {
                  mFont.a((mFont)mFont.d, (Graphics)var1, Caption.re[var3] + Caption.ro[this.y.M() - 1] + ": " + this.x[var3], 10, var2 + this.M[2].h / 2, 0, -1, 0);
               } else {
                  mFont.a((mFont)mFont.d, (Graphics)var1, Caption.km + ": " + this.x[var3], 10, var2 + this.M[2].h / 2, 0, -1, 0);
               }
            } else {
               mFont.a((mFont)mFont.d, (Graphics)var1, Caption.re[var3] + ": " + this.x[var3] + (var3 != 8 && var3 != 9 ? "" : "%"), 10, var2 + this.M[2].h / 2, 0, -1, 0);
            }
         }
      }

      this.b(var1);
      this.M[2].b(var1, -17, -13);
   }

   private void g(Graphics var1) {
      this.a((Graphics)var1, (LangLa_ii)this.M[1]);

      for(int var3 = 0; var3 < Caption.rd.length; ++var3) {
         int var2 = var3 * this.M[1].h;
         if (this.M[1].c(var2)) {
            if (this.M[1].k == var3) {
               var1.f(-6488);
               var1.c(3, var2, this.M[1].width - 9, this.M[1].h);
            }

            if (var3 == 0) {
               mFont.a((mFont)mFont.d, (Graphics)var1, Caption.rd[var3] + ": " + this.w[var3] * 90 / 100 + " - " + this.w[var3], 10, var2 + this.M[1].h / 2, 0, -1, 0);
            } else {
               mFont.a((mFont)mFont.d, (Graphics)var1, Caption.rd[var3] + ": " + this.w[var3] + (var3 != 5 && var3 != 16 ? "" : "%"), 10, var2 + this.M[1].h / 2, 0, -1, 0);
            }
         }
      }

      this.b(var1);
      this.M[1].b(var1, -17, -13);
   }

   private void h(Graphics var1) {
      DataCenter.gI();
      int var2 = this.b.c() + 15;
      int var3 = this.b.cy + 7 + 18;
      if (!this.y.isMe() && this.B.a) {
         mFont.a((mFont)mFont.d, (Graphics)var1, Caption.dg, var2, var3, 0, -6488, 0);
      } else {
         mFont.c(mFont.d, var1, Caption.rc[0] + " " + this.v + Caption.dc, var2 - 7, var3 + 5 + 135, 0, -6488, 0);
         this.a((Graphics)var1, (LangLa_ii)this.L[3][0]);

         for(var3 = 0; var3 < this.z.length; ++var3) {
            var2 = var3 * this.L[3][0].h;
            if (this.L[3][0].c(var2)) {
               if (this.a == var3) {
                  this.a(var1, 28, var2 + 1, this.L[3][0].width - 29, 25, -15, 84, 5, 1, 1);
               } else {
                  this.a(var1, 28, var2 + 1, this.L[3][0].width - 29, 25, -14, 84, 5, 1, 1);
               }

               mFont.a((mFont)mFont.e, (Graphics)var1, this.z[var3].getSkillTemplate().name, 35, var2 + 8, 0, -7812062, 0);
               if (this.z[var3].level == this.z[var3].getSkillTemplate().levelMax) {
                  mFont.a((mFont)mFont.d, (Graphics)var1, Caption.cY, 35, var2 + 18, 0, -2560, 0);
               } else {
                  mFont.a((mFont)mFont.d, (Graphics)var1, Caption.cZ + this.z[var3].level, 35, var2 + 18, 0, -1, 0);
               }

               LangLa_fq.a(var1, this.z[var3].getSkillTemplate().idIcon, 0, 1, var2 + 1, 20);
            }
         }

         if (this.cL != null && this.cL instanceof LangLa_ie) {
            var2 = this.a * this.L[3][0].h;
            var1.f(-1);
            var1.b(0, var2, 26, 26);
         }

         this.b(var1);
      }
   }

   private void i(Graphics var1) {
      DataCenter.gI();
      this.P[1].a(var1);
      int var2;
      switch(this.P[1].b.b) {
      case 0:
         this.a((Graphics)var1, (LangLa_ii)this.L[this.b.b.b][this.P[1].b.b]);

         for(int var5 = 0; var5 < this.L[this.b.b.b][this.P[1].b.b].i; var5 += 2) {
            if (this.L[this.b.b.b][this.P[1].b.b].b(var5)) {
               var2 = var5 * this.L[this.b.b.b][this.P[1].b.b].h + this.L[this.b.b.b][this.P[1].b.b].h / 2;
               LangLa_fq.a(var1, 10, 0, 15, var2, 3);
               if (var5 / 2 == this.y.selectDanhHieu) {
                  LangLa_fq.a(var1, 11, 0, 15, var2, 3);
               }

               mFont.a((mFont)mFont.d, (Graphics)var1, this.y.aG[var5 / 2].a, 28, var2, 0, -6488, 0);
               mFont.a((mFont)mFont.d, (Graphics)var1, Caption.fw + (this.y.aG[var5 / 2].b == -1 ? Caption.ln : Utlis.f((long)this.y.aG[var5 / 2].b * 1000L)), 28, var2 + this.L[this.b.b.b][this.P[1].b.b].h, 0, -1, 0);
            }
         }

         this.b(var1);
         return;
      case 1:
         int var10003;
         Item var3;
         if ((var3 = this.y.arrItemBody[10]) == null || !var3.aa()) {
            this.S.b(true);
            this.T.b(true);
            this.U.b(true);
            mFont var10000 = mFont.e;
            String var10002 = Caption.qd;
            var10003 = 49 + (super.width - 8) / 2;
            DataCenter.gI();
            mFont.a(var10000, var1, var10002, var10003 - 0, this.a_() + this.G() / 2, 2, -2560, 2, 1, 3);
            return;
         }

         if (this.F == -1 || this.F >= this.y.aH.size()) {
            this.F = -1;
            this.S.b(true);
            this.T.b(true);
            this.U.b(true);
         }

         if (this.D != null) {
            this.a((Graphics)var1, (LangLa_ii)this.L[4][1]);

            for(var2 = 0; var2 < this.D.length; ++var2) {
               mFont.c(mFont.d, var1, this.D[var2], 8, var2 * this.L[4][1].h + 5, 0, -1, -16777216);
            }

            this.b(var1);
         }

         for(var2 = 0; var2 < 6; ++var2) {
            a(var1, this.K[this.b.b.b][0].cx + var2 * this.I, this.K[this.b.b.b][0].cy, this.y.arrItemSkillViThu[var2], var2 == this.K[this.b.b.b][0].k && this.E == 0, Caption.tl[var2]);
            if (var2 < this.G.size()) {
               var10003 = this.K[this.b.b.b][0].cx + var2 * this.I + 2;
               LangLa_fq.a(var1, ((SkillClan)this.G.elementAt(var2)).idIcon, 0, var10003, this.K[this.b.b.b][0].cy + 2, 20);
            }
         }

         if (this.H != null) {
            for(var2 = 0; var2 < this.K[this.b.b.b][1].r; ++var2) {
               a(var1, this.K[this.b.b.b][1].cx + var2 * this.I, this.K[this.b.b.b][1].cy, this.y.arrItemSkillViThu[var2], var2 == this.K[this.b.b.b][1].k && this.E == 1, Caption.tl[var2]);
               LangLa_fq.a(var1, this.H.idIcon, 0, this.K[this.b.b.b][1].cx + var2 * this.I + 2, this.K[this.b.b.b][1].cy + 2, 20);
            }
         }
      }

   }

   public void b() {
      super.b();
      if (this.y.sachChienDau > 0) {
         if (this.C == null) {
            this.C = new Item(435);
            this.C.strOptions = "207,0,-1;208,0,-1";
            this.C.a(this.y.sachChienDau);
            StringBuilder var10000;
            Item var10002;
            if (this.y.sachChienDau > 17) {
               var10000 = new StringBuilder();
               var10002 = this.C;
               var10002.strOptions = var10000.append(var10002.strOptions).append(";311,300,-1").toString();
               var10000 = new StringBuilder();
               var10002 = this.C;
               var10002.strOptions = var10000.append(var10002.strOptions).append(";336,").append(this.y.aW).append(",").append(this.y.aX).toString();
               var10000 = new StringBuilder();
               var10002 = this.C;
               var10002.strOptions = var10000.append(var10002.strOptions).append(";337,").append(this.y.aY).append(",-1").toString();
            } else if (this.y.sachChienDau > 16) {
               var10000 = new StringBuilder();
               var10002 = this.C;
               var10002.strOptions = var10000.append(var10002.strOptions).append(";311,150,-1").toString();
            }

            int var10004 = this.b.c();
            DataCenter.gI();
            var10004 = var10004 + 8 + this.I;
            int var10005 = this.a_();
            DataCenter.gI();
            this.ae = new LangLa_ij((byte)1, var10004, var10005 + 11 + this.I * 2, this.I, this.I, this.I, 5, 1);
         }
      } else {
         this.C = null;
         this.ae = null;
      }

      boolean var1;
      if (this.v()) {
         var1 = false;
         this.B.v = var1;
      } else {
         var1 = true;
         this.B.v = var1;
      }

      if (this.v() && !this.t()) {
         this.Z.v = this.aa.v = this.ab.v = true;
         this.c[0].u = true;
      }

      int var3;
      if (this.k() == 0) {
         this.b.a();

         int var2;
         for(var3 = 0; var3 < this.K.length; ++var3) {
            if (this.K[var3] != null) {
               for(var2 = 0; var2 < this.K[var3].length; ++var2) {
                  if (this.K[var3][var2] != null) {
                     this.K[var3][var2].a();
                  }
               }
            }
         }

         for(var3 = 0; var3 < this.L.length; ++var3) {
            if (this.L[var3] != null) {
               for(var2 = 0; var2 < this.L[var3].length; ++var2) {
                  if (this.L[var3][var2] != null) {
                     this.L[var3][var2].a();
                  }
               }
            }
         }
      } else if (this.k() == 1 && this.O != null) {
         this.O.a();
         if (this.M != null) {
            for(var3 = 0; var3 < this.M.length; ++var3) {
               if (this.M[var3] != null) {
                  this.M[var3].a();
               }
            }
         }
      } else if (this.k() == 2 && this.N != null) {
         for(var3 = 0; var3 < this.N.length; ++var3) {
            if (this.N[var3] != null) {
               this.N[var3].a();
            }
         }
      }

      this.w();
      int var10001;
      Step var4;
      int[] var5;
      switch(GameSrc.gI().Task) {
      case 0:
         if (GameSrc.gI().idStep == 0) {
            if (this.k() != this.j()) {
               DataCenter.gI();
               var10001 = this.cx + 135;
               DataCenter.gI().aO.a(var10001, this.cy + 10);
               DataCenter.gI().aO.a = true;
            } else if (this.cL == null) {
               if ((var5 = this.y.c(28)) == null) {
                  var5 = this.y.c(188);
               }

               if (this.cL == null && this.y.arrItemBody[1] == null) {
                  var10001 = this.cx + var5[0] + 15;
                  DataCenter.gI().aO.a(var10001, this.cy + 25 + var5[1] + 15);
                  DataCenter.gI().aO.a = true;
               }
            }
         }
      case 1:
      case 2:
      case 4:
      case 5:
      case 7:
      case 9:
      case 10:
      case 12:
      case 13:
      case 14:
      default:
         break;
      case 3:
         if (GameSrc.gI().idStep == 1) {
            var4 = GameSrc.gI().B();
            if (this.k() != this.j()) {
               DataCenter.gI();
               var10001 = this.cx + 135;
               DataCenter.gI().aO.a(var10001, this.cy + 10);
               DataCenter.gI().aO.a = true;
            } else if (this.cL == null && var4 != null) {
               var5 = this.y.c(var4.b());
               var10001 = this.cx + var5[0] + 15;
               DataCenter.gI().aO.a(var10001, this.cy + 25 + var5[1] + 15);
               DataCenter.gI().aO.a = true;
            }
         } else if (GameSrc.gI().idStep == 2) {
            DataCenter.gI().aO.a(this.cx + this.width - 5, this.cy + 5);
            DataCenter.gI().aO.a = true;
         }
         break;
      case 6:
         var4 = GameSrc.gI().B();
         if (GameSrc.gI().idStep >= 0 && var4 != null && Char.gI().cx == var4.x && Char.gI().cy == var4.y) {
            if (this.k() != this.j()) {
               DataCenter.gI();
               var10001 = this.cx + 135;
               DataCenter.gI().aO.a(var10001, this.cy + 10);
               DataCenter.gI().aO.a = true;
            } else if (this.cL == null && var4 != null) {
               var5 = this.y.c(var4.b());
               var10001 = this.cx + var5[0] + 15;
               DataCenter.gI().aO.a(var10001, this.cy + 25 + var5[1] + 15);
               DataCenter.gI().aO.a = true;
            }
         }
         break;
      case 8:
         if (GameSrc.gI().idStep == 9) {
            if (this.k() != this.j()) {
               DataCenter.gI();
               var10001 = this.cx + 135;
               DataCenter.gI().aO.a(var10001, this.cy + 10);
               DataCenter.gI().aO.a = true;
            } else if (this.cL == null) {
               var5 = this.y.u();
               var10001 = this.cx + var5[0] + 20;
               DataCenter.gI().aO.a(var10001, this.cy + 30 + var5[1] + 15);
               DataCenter.gI().aO.a = true;
            }
         } else if (GameSrc.gI().idStep == 10) {
            DataCenter.gI();
            if (this.k() == 0) {
               if (this.b.b.b != 2) {
                  var10001 = this.cx + 70;
                  DataCenter.gI().aO.a(var10001, this.cy + 120);
                  DataCenter.gI().aO.a = true;
               } else if (this.Q.u) {
                  var10001 = this.cx + 255;
                  DataCenter.gI().aO.a(var10001, this.cy + 100);
                  DataCenter.gI().aO.a = true;
               } else {
                  var10001 = this.cx + 255;
                  DataCenter.gI().aO.a(var10001, this.cy + 190);
                  DataCenter.gI().aO.a = true;
               }
            } else {
               var10001 = this.cx + 60;
               DataCenter.gI().aO.a(var10001, this.cy + 10);
               DataCenter.gI().aO.a = true;
            }

            if (this.cL != null) {
               DataCenter.gI().aO.a = false;
            }
         } else if (GameSrc.gI().idStep == 11) {
            DataCenter.gI();
            if (this.k() == 0) {
               if (this.b.b.b != 3) {
                  var10001 = this.cx + 70;
                  DataCenter.gI().aO.a(var10001, this.cy + 150);
                  DataCenter.gI().aO.a = true;
               } else if (this.Y.u) {
                  var10001 = this.cx + 280;
                  DataCenter.gI().aO.a(var10001, this.cy + 80);
                  DataCenter.gI().aO.a = true;
               } else {
                  var10001 = this.cx + 280;
                  DataCenter.gI().aO.a(var10001, this.cy + 190);
                  DataCenter.gI().aO.a = true;
               }

               if (this.cL != null) {
                  DataCenter.gI().aO.a = false;
               }
            } else {
               var10001 = this.cx + 60;
               DataCenter.gI().aO.a(var10001, this.cy + 10);
               DataCenter.gI().aO.a = true;
            }
         }
         break;
      case 11:
         var4 = GameSrc.gI().B();
         if (GameSrc.gI().idStep >= 0 && GameSrc.gI().idStep <= 3 && var4 != null && Char.gI().cx == var4.x && Char.gI().cy == var4.y) {
            if (this.k() != this.j()) {
               DataCenter.gI();
               var10001 = this.cx + 135;
               DataCenter.gI().aO.a(var10001, this.cy + 10);
               DataCenter.gI().aO.a = true;
            } else if (this.cL == null) {
               var5 = this.y.c(383);
               if (this.cL == null && this.y.arrItemBody[1] == null) {
                  var10001 = this.cx + var5[0] + 15;
                  DataCenter.gI().aO.a(var10001, this.cy + 25 + var5[1] + 15);
                  DataCenter.gI().aO.a = true;
               }
            }
         }
         break;
      case 15:
         var4 = GameSrc.gI().B();
         if (GameSrc.gI().idStep >= 0 && GameSrc.gI().idStep <= 3 && var4 != null && Char.gI().cx == var4.x && Char.gI().cy == var4.y) {
            if (this.k() != this.j()) {
               DataCenter.gI();
               var10001 = this.cx + 135;
               DataCenter.gI().aO.a(var10001, this.cy + 10);
               DataCenter.gI().aO.a = true;
            } else if (this.cL == null) {
               var5 = this.y.c(205);
               if (this.cL == null && this.y.arrItemBody[1] == null) {
                  var10001 = this.cx + var5[0] + 15;
                  DataCenter.gI().aO.a(var10001, this.cy + 25 + var5[1] + 15);
                  DataCenter.gI().aO.a = true;
               }
            }
         }
      }

      if (this.v()) {
         DataCenter.gI();
         if (this.y.idClass != 0 && this.i > 0) {
            this.b.c[2] = true;
         } else {
            this.b.c[2] = false;
         }

         if (this.y.idClass != 0 && this.v > 0) {
            this.b.c[3] = true;
         } else {
            this.b.c[3] = false;
         }
      }

      for(var3 = 0; var3 < this.c.length; ++var3) {
         this.c[var3].a(true);
      }

   }

   private void w() {
      this.S.b(true);
      this.T.b(true);
      this.U.b(true);
      if (this.k() == 0) {
         switch(this.b.b.b) {
         case 2:
            DataCenter.gI();
            this.z();
            break;
         case 3:
            this.y();
            break;
         case 4:
            this.x();
         default:
            return;
         }
      } else {
         if (this.k() == 1 && this.O != null) {
            switch(this.O.b.b) {
            case 0:
               this.z();
            default:
               return;
            }
         }

         if (this.k() == 2) {
            this.y();
         }
      }

   }

   private void x() {
      if (this.P != null && this.P[1] != null) {
         this.P[1].b();
      }

      if (this.y.isMe()) {
         DataCenter.gI();
         if (this.P != null && this.P[1] != null && this.P[1].b.b == 1 && this.F >= 0) {
            this.S.b(false);
            this.T.b(false);
            this.U.b(false);
            return;
         }
      } else {
         this.S.b(true);
         this.T.b(true);
         this.U.b(true);
      }

   }

   private void y() {
      this.J = 15;
      if (this.y.idClass != 0 && this.v()) {
         this.X.b(false);
         this.Y.b(false);
         if (this.a >= 0 && this.a < GameSrc.gI().p.length) {
            Skill var1;
            if ((var1 = GameSrc.gI().p[this.a]) == null) {
               return;
            }

            if (var1.level != 0 && var1.c()) {
               this.X.a(false);
               if (this.y.ay.idTemplate == var1.idTemplate) {
                  this.X.a(true);
               } else {
                  this.X.a(false);
               }
            } else {
               this.X.a(true);
            }

            if (this.v <= 0 || var1.level >= var1.getSkillTemplate().levelMax || b(var1.idTemplate, var1.level + 1).levelNeed > this.y.level()) {
               this.Y.a(true);
               return;
            }

            this.Y.a(false);
         } else {
            this.X.a(true);
            this.Y.a(true);
         }

      } else {
         this.X.b(true);
         this.Y.b(true);
      }
   }

   private void z() {
      if (this.P != null && this.P[0] != null) {
         this.P[0].b();
      }

      this.Q.u = true;
      this.R.u = true;
      if (this.d && (this.c[0].e() != this.e || this.c[1].e() != this.f || this.c[2].e() != this.h || this.c[3].e() != this.g)) {
         this.Q.u = false;
         this.R.u = false;
      }

   }

   public void a(int var1) {
      super.a(var1);
      if (this.b != null) {
         this.b.d();
      }

      if (this.O != null) {
         this.O.d();
      }

      if (var1 == 0 && this.b != null) {
         this.b.a(this.b.b.b);
         switch(this.b.b.b) {
         case 0:
            this.A.b(!this.y.isMe());
         case 1:
            this.e(this.b.b.b);
            break;
         case 2:
            this.P[0].a();
            this.A();
            break;
         case 4:
            this.P[1].a();
            this.B();
         case 3:
         default:
            return;
         }
      } else if (var1 == 1 && this.O != null) {
         this.O.a(this.O.b.b);
         this.O.a(false);
      }

   }

   public void e(int var1) {
      int var2;
      Item var3;
      if (var1 == 0) {
         for(var2 = 0; var2 < this.y.arrItemBody.length; ++var2) {
            if ((var3 = this.y.arrItemBody[var2]) != null && (var3.isTypeTrangBi() && var3.a(var1, this.y) > 0 || var3.getItemTemplate().type == 15)) {
               var3.c();
            }
         }

      } else {
         for(var2 = 0; var2 < this.y.arrItemBody2.length; ++var2) {
            if ((var3 = this.y.arrItemBody2[var2]) != null && (var3.isTypeTrangBi() && var3.a(var1, this.y) > 0 || var3.getItemTemplate().type == 15)) {
               var3.c();
            }
         }

      }
   }

   private void A() {
      this.P[0].a(this.P[0].b.b);
      switch(this.P[0].b.b) {
      case 0:
         return;
      case 1:
         this.L[this.b.b.b][0].d();
         return;
      case 2:
         this.L[this.b.b.b][1].d();
         return;
      case 3:
         this.L[this.b.b.b][2].d();
      default:
      }
   }

   private void B() {
      this.P[1].a(this.P[1].b.b);
   }

   private String j(int var1) {
      SkillClan var5;
      if (this.E == 0) {
         var5 = (SkillClan)this.G.elementAt(var1);
      } else {
         var5 = this.H;
      }

      Vector var2;
      (var2 = new Vector()).addElement("c#moc" + var5.name);
      if (var5.detail != null && var5.detail.length() > 0) {
         var2.addElement(var5.detail);
      }

      var2.addElement("c#green" + Caption.cV);
      var2.addElement("c#yellow" + Caption.cW + (var5.levelNeed + 1));
      a(var2, var5);
      Vector var6 = new Vector();

      String var3;
      for(int var4 = 0; var4 < var2.size(); ++var4) {
         var3 = String.valueOf(var2.elementAt(var4));
         if (var4 == 0) {
            var6.add(new LangLa_lk(0, var3));
         } else {
            var6.add(new LangLa_lk(1, var3));
         }
      }

      var3 = "";
      LangLa_lk[] var8 = new LangLa_lk[var6.size()];

      for(int var7 = 0; var7 < var6.size(); ++var7) {
         var8[var7] = (LangLa_lk)var6.elementAt(var7);
         var3 = var3 + var8[var7].b;
         if (var7 < var8.length - 1) {
            var3 = var3 + "\r\n";
         }
      }

      return var3;
   }

   public Vector c() {
      Vector var1 = super.c();
      if (!this.v()) {
         var1.removeElementAt(0);
      }

      DataCenter.gI();
      if (this.k() == 0) {
         var1.addElement(this.b.b());
         int var4;
         switch(this.b.b.b) {
         case 0:
            if (this.ae != null) {
               var1.addElement(this.ae.a(1090, this));
            }

            for(var4 = 0; var4 < this.K[this.b.b.b].length; ++var4) {
               var1.addElement(this.K[this.b.b.b][var4].a(1010 + var4, this));
            }

            DataCenter.gI();
            DataCenter.gI();
            var1.addElement(new LangLa_jz(1026, 170, 135, 210, 145, (LangLa_ii)null, this));
            break;
         case 1:
            for(var4 = 0; var4 < this.K[this.b.b.b].length; ++var4) {
               var1.addElement(this.K[this.b.b.b][var4].a(1020 + var4, this));
            }

            return var1;
         case 2:
            var1.addElement(this.P[0].c());
            var1.addElement(this.L[this.b.b.b][this.P[0].b.b].a(1200, this));
            break;
         case 3:
            if (this.y.isMe() || !this.y.isMe() && !this.B.a) {
               var1.addElement(this.L[3][0].a(1030, this));
            }
            break;
         case 4:
            var1.addElement(this.P[1].c());
            if (this.P[1].b.b == 0) {
               var1.addElement(this.L[this.b.b.b][this.P[1].b.b].a(1201, this));
            } else if (this.P[1].b.b == 1) {
               Item var2;
               if ((var2 = this.y.arrItemBody[10]) != null && var2.aa()) {
                  var1.addElement(this.K[this.b.b.b][0].a(1401, this));
                  if (this.H != null) {
                     var1.addElement(this.K[this.b.b.b][1].a(1403, this));
                  }
               }

               if (this.L[4][1] != null) {
                  var1.addElement(this.L[4][1].a(1402, this));
               }
            }
         }
      }

      return var1;
   }

   public void a(mTextBox var1) {
      mTextBox var10000;
      int var2;
      if (var1.equals(this.c[0])) {
         var10000 = this.c[0];
         var2 = this.c[0].e() + this.i;
         var10000.o = var2;
      } else if (var1.equals(this.c[1])) {
         var10000 = this.c[1];
         var2 = this.c[1].e() + this.i;
         var10000.o = var2;
      } else if (var1.equals(this.c[2])) {
         var10000 = this.c[2];
         var2 = this.c[2].e() + this.i;
         var10000.o = var2;
      } else {
         if (var1.equals(this.c[3])) {
            var10000 = this.c[3];
            var2 = this.c[3].e() + this.i;
            var10000.o = var2;
         }

      }
   }

   public void a(int var1, Object var2, LangLa_cy var3) {
      super.a(var1, var2, var3);

      try {
         Message var5;
         switch(var1) {
         case 1234:
            (var5 = Message.c((byte)-109)).writeBoolean(this.B.a);
            var5.send();
            break;
         case 1235:
            int selection = appearanceSelection(Char.gI().selectCaiTrang, ((LangLa_kd) var2).b);
            (var5 = Message.c((byte)-58)).writeByte(selection);
            var5.send();
            Char.gI().selectCaiTrang = selection;
            this.syncAppearanceSelection(selection);
            return;
         default:
            return;
         }
      } catch (Exception var4) {
      }

   }

   static int appearanceSelection(int current, int requested) {
      return (requested == 4 || requested == 5) && requested == current ? 0 : requested;
   }

   void syncAppearanceSelection(int selection) {
      if (this.A == null) return;
      this.A.b.c[4] = selection == 4 ? "Hiện Tanto" : Caption.tJ[4];
      this.A.b.c[5] = selection == 5 ? "Hiện áo choàng" : Caption.tJ[5];
      this.A.a(selection);
   }

   public void b(mTextBox var1) {
      int var2;
      if ((var2 = var1.e()) > var1.o) {
         var1.a("" + var1.o);
      }

      if (var2 < var1.n) {
         var1.a("" + var1.n);
      }

      this.i = this.u - (this.c[0].e() - this.e + (this.c[1].e() - this.f) + (this.c[2].e() - this.h) + (this.c[3].e() - this.g));
   }

   private static Skill b(int var0, int var1) {
      for(int var2 = 0; var2 < DataCenter.gI().Skill.length; ++var2) {
         if (DataCenter.gI().Skill[var2].idTemplate == var0 && DataCenter.gI().Skill[var2].level == var1) {
            return DataCenter.gI().Skill[var2];
         }
      }

      return null;
   }

   public boolean f(int var1) {
      int var2 = 0;

      for(int var3 = 0; var3 < this.y.arrItemBody.length; ++var3) {
         if (this.y.arrItemBody[var3] != null && this.y.arrItemBody[var3].v() && this.y.arrItemBody[var3].level >= var1) {
            ++var2;
         }
      }

      if (var2 >= 10) {
         return true;
      } else {
         return false;
      }
   }

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public LangLa_kl ad;
public void initialize() {
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.LangLa_kl");
public static SessionState $state_LangLa_kl() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
