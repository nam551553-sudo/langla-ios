package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_mk extends LangLa_fm {
   private int d;
   LangLa_dz[] a;
   private LangLa_ii[] e;
   private LangLa_ii f;
   Item b;
   private LangLa_gl g;
   private Vector h = new Vector();
   private boolean i;
   private int j = -1;
   private LangLa_dz k;
   public LangLa_mq c;

   public LangLa_mk(int var1, int var2, int var3, LangLa_cx var4, Item var5) {
      this.a(var1, var2, 1044, var4, var5);
   }

   public LangLa_mk(int var1, int var2, int var3, LangLa_cx var4, LangLa_gl var5) {
      this.g = var5;
      this.a(var1, var2, 1044, var4, var5.e);
   }

   private void a(int var1, int var2, int var3, LangLa_cx var4, Item var5) {
      if (var5 != null) {
         try {
            this.d = var3;
            this.s = var4;
            this.b = var5;
            this.setXY(var1, var2);
            this.setSize(250, 142);
            Vector var9;
            (var9 = new Vector()).add(new LangLa_dz(0, 3, 0, 0, "", var4, 100, 52));
            LangLa_ge var12;
            if (var4 instanceof LangLa_ge && (var12 = (LangLa_ge)var4).k() == var12.j()) {
               this.a(var9, var4, var12);
            }

            if (var4 instanceof LangLa_fc) {
               var9.add(new LangLa_dz(this.width - 51, this.height - 26, 105, 0, Caption.aR, var4, 108, 15));
            }

            if (var4 instanceof LangLa_br) {
               LangLa_br var13;
               if ((var13 = (LangLa_br)var4).k() == 0) {
                  var9.add(new LangLa_dz(this.width - 51, this.height - 26, 0, 0, Caption.as, var4, 101, 15));
               } else if (var13.f() == 0) {
                  var9.add(new LangLa_dz(this.width - 51, this.height - 26, 0, 0, Caption.ar, var4, 103, 15));
               }
            } else if (var4 instanceof LangLa_bw) {
               var9.add(new LangLa_dz(this.width - 51, this.height - 26, 0, 0, Caption.as, var4, 101, 15));
            } else if (var4 instanceof LangLa_kl) {
               LangLa_kl var14;
               if ((var14 = (LangLa_kl)var4).m() == 0 && var14.y.isMe()) {
                  if (var14.n() != 0 || var5.id != 788 && (var5.strOptions == null || !var5.strOptions.contains(";333,0"))) {
                     if (var14.n() == 0 && (var5.id == 789 || var5.id == 812 || var5.id == 855 || var5.id == 880 || var5.strOptions != null && var5.strOptions.startsWith("340,789") || var5.strOptions != null && var5.strOptions.startsWith("340,812") || var5.strOptions != null && var5.strOptions.startsWith("340,855") || var5.strOptions != null && var5.strOptions.startsWith("340,880"))) {
                        var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.qB, var4, 170, 15));
                     }
                  } else {
                     var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.qD, var4, 170, 15));
                  }

                  if (var14.n() == 0 && var5.isTypeTrangBi()) {
                     var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.aR, var4, 105, 15));
                  } else if (var14.n() == 0 && var14.y.sachChienDau > 17) {
                     var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.qt, var4, 167, 15));
                     var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.qs, var4, 168, 15));
                  } else if (var14.n() == 1) {
                     var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.aR, var4, 128, 15));
                  }
               }
            } else if (var4 instanceof LangLa_lb) {
               LangLa_lb var15;
               if ((var15 = (LangLa_lb)var4).e() == 0) {
                  var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.aS, var4, 107, 15));
               } else if (var15.f() == 0) {
                  var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.aR, var4, 106, 15));
               }
            } else if (var4 instanceof LangLa_aj) {
               LangLa_aj var16;
               if ((var16 = (LangLa_aj)var4).a == 0) {
                  if (var16.e() == 0) {
                     if (var16.i == 1) {
                        var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.aS, var4, 126, 15));
                     }
                  } else if (var16.f() == 0 && !var5.isLock) {
                     var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.bk, var4, 125, 15));
                  }
               }
            } else if (var4 instanceof LangLa_au) {
               LangLa_au var17;
               if ((var17 = (LangLa_au)var4).k() == 0) {
                  var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.aS, var4, 111, 15));
               } else if (var17.f() == 0 && var5.q()) {
                  var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.bk, var4, 110, 15));
               }
            } else if (var4 instanceof LangLa_ar) {
               LangLa_ar var18;
               if ((var18 = (LangLa_ar)var4).k() == 0) {
                  if (var18.c == 1 || var18.c == 3 || var18.c == 4) {
                     var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.aS, var4, 113, 15));
                  }
               } else if (var18.f() == 0 && var5.t()) {
                  var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.bk, var4, 112, 15));
               }
            } else if (var4 instanceof LangLa_bv) {
               LangLa_bv var20;
               if ((var20 = (LangLa_bv)var4).k() == 0) {
                  if (var20.c == 1) {
                     var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.aS, var4, 115, 15));
                  }
               } else if (var20.f() == 0 && var5.x()) {
                  var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.bk, var4, 114, 15));
               }
            } else if (var4 instanceof LangLa_bu) {
               LangLa_bu var22;
               if ((var22 = (LangLa_bu)var4).k() == 0) {
                  if (var22.c == 1) {
                     var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.aS, var4, 148, 15));
                  }
               } else if (var22.f() == 0 && var5.y()) {
                  var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.bk, var4, 147, 15));
               }
            } else if (var4 instanceof LangLa_a) {
               LangLa_a var23;
               if ((var23 = (LangLa_a)var4).k() == 0) {
                  var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.aS, var4, 117, 15));
               } else if (var23.f() == 0 && var5.A()) {
                  var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.bk, var4, 116, 15));
               }
            } else if (var4 instanceof LangLa_ag) {
               LangLa_ag var24;
               if ((var24 = (LangLa_ag)var4).k() == 0) {
                  var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.aS, var4, 166, 15));
               } else if (var24.f() == 0 && var5.B()) {
                  var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.bk, var4, 165, 15));
               }
            } else if (var4 instanceof LangLa_as) {
               LangLa_as var25;
               if ((var25 = (LangLa_as)var4).k() == 0) {
                  if (var25.c == 1 || var25.c == 2) {
                     var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.aS, var4, 119, 15));
                  }
               } else if (var25.f() == 0 && var5.C()) {
                  var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.bk, var4, 118, 15));
               }
            } else if (var4 instanceof LangLa_y) {
               LangLa_y var26;
               if ((var26 = (LangLa_y)var4).k() == 0) {
                  if (var26.c == 1 || var26.c == 3) {
                     var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.aS, var4, 146, 15));
                  }
               } else if (var26.f() == 0 && var5.w()) {
                  var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.bk, var4, 145, 15));
               }
            } else if (var4 instanceof LangLa_al) {
               LangLa_al var27;
               if ((var27 = (LangLa_al)var4).k() == 0) {
                  if (var27.c == 1 || var27.c == 2) {
                     var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.aS, var4, 172, 15));
                  }
               } else if (var27.f() == 0 && var5.G()) {
                  var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.bk, var4, 171, 15));
               }
            } else if (var4 instanceof LangLa_an) {
               LangLa_an var28;
               if ((var28 = (LangLa_an)var4).k() == 0) {
                  if (var28.c == 1 || var28.c == 2) {
                     var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.aS, var4, 144, 15));
                  }
               } else if (var28.f() == 0 && var5.H()) {
                  var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.bk, var4, 143, 15));
               }
            } else if (var4 instanceof LangLa_ak) {
               LangLa_ak var29;
               if ((var29 = (LangLa_ak)var4).k() == 0) {
                  if (var29.c == 1 || var29.c == 2) {
                     var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.aS, var4, 158, 15));
                  }
               } else if (var29.f() == 0 && var5.I()) {
                  var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.bk, var4, 157, 15));
               }
            } else if (var4 instanceof LangLa_ap) {
               LangLa_ap var30;
               if ((var30 = (LangLa_ap)var4).k() == 0) {
                  if (var30.c == 1 || var30.c == 2) {
                     var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.aS, var4, 160, 15));
                  }
               } else if (var30.f() == 0 && var5.J()) {
                  var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.bk, var4, 159, 15));
               }
            } else if (var4 instanceof LangLa_ao) {
               LangLa_ao var31;
               if ((var31 = (LangLa_ao)var4).k() == 0) {
                  if (var31.c == 1 || var31.c == 2) {
                     var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.aS, var4, 162, 15));
                  }
               } else if (var31.f() == 0 && var5.K()) {
                  var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.bk, var4, 161, 15));
               }
            } else if (var4 instanceof LangLa_v) {
               LangLa_v var32;
               if ((var32 = (LangLa_v)var4).k() == 0) {
                  if (var32.g != 1 && var32.g != 2) {
                     if (var32.g == 3) {
                        var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.aS, var4, 121, 15));
                     }
                  } else {
                     var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.as, var4, 122, 15));
                     if (var32.l() == 1) {
                        var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.fu, var4, 132, 15));
                     }
                  }
               } else if (var32.f() == 0 && !var5.isLock && var5.expiry == -1L) {
                  var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.bk, var4, 120, 15));
               }
            } else if (var4 instanceof LangLa_t) {
               LangLa_t var33;
               if ((var33 = (LangLa_t)var4).k() == 1) {
                  var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.aS, var4, 124, 15));
               } else if (var33.k() == var33.j() && var33.f() == 0 && !var5.isLock) {
                  var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.bk, var4, 123, 15));
               }
            } else if (var4 instanceof LangLa_by) {
               LangLa_by var34;
               if ((var34 = (LangLa_by)var4).k() == 0) {
                  var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.aS, var4, 130, 15));
               } else if (var34.f() == 0) {
                  var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.bk, var4, 129, 15));
               }
            } else if (var4 instanceof LangLa_o) {
               LangLa_o var35;
               if ((var35 = (LangLa_o)var4).k() == 0) {
                  var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.aS, var4, 156, 15));
               } else if (var35.f() == 0) {
                  var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.bk, var4, 155, 15));
               }
            } else if (var4 instanceof LangLa_kh) {
               LangLa_kh var36;
               if ((var36 = (LangLa_kh)var4).k() == 0) {
                  var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.aS, var4, 136, 15));
               } else if (var36.b == 78 && var36.f() == 0 && var5.T() > 0) {
                  var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.bk, var4, 135, 15));
               } else if ((var36.b == 61 || var36.b == 69) && var36.f() == 0 && var5.P() || (var36.b == 60 || var36.b == 68) && var36.f() == 0 && var5.Q() || (var36.b == 62 || var36.b == 71) && var36.f() == 0 && var5.R() || (var36.b == 63 || var36.b == 70) && var36.f() == 0 && var5.S()) {
                  var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.bk, var4, 135, 15));
               }
            } else if (var4 instanceof LangLa_d) {
               LangLa_d var37;
               if ((var37 = (LangLa_d)var4).k() == 0) {
                  var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.aS, var4, 142, 15));
               } else if (var37.f() == 0 && var5.id == 310) {
                  var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.bk, var4, 141, 15));
               }
            } else if (var4 instanceof LangLa_e) {
               LangLa_e var38;
               if ((var38 = (LangLa_e)var4).k() == 0) {
                  var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.aS, var4, 164, 15));
               } else if (var38.f() == 0 && var5.p()) {
                  var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.bk, var4, 163, 15));
               }
            } else if (var4 instanceof LangLa_at) {
               LangLa_at var39;
               if ((var39 = (LangLa_at)var4).k() == 0) {
                  if (var39.c == 1) {
                     var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.aS, var4, 139, 15));
                  }
               } else if (var39.f() == 0 && var5.o()) {
                  var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.bk, var4, 138, 15));
               }
            } else if (var4 instanceof LangLa_am) {
               LangLa_am var40;
               if ((var40 = (LangLa_am)var4).k() == 0) {
                  if (var40.c == 0) {
                     var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.aS, var4, 151, 15));
                     var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.n, var4, 152, 15));
                  }
               } else if (var40.f() == 0 && var5.r()) {
                  var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.bk, var4, 150, 15));
               }
            } else if (var4 instanceof LangLa_bt) {
               LangLa_bt var41;
               if ((var41 = (LangLa_bt)var4).k() == 0) {
                  if (var41.d == 1) {
                     var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.aS, var4, 154, 15));
                  }
               } else if (var41.f() == 0 && var5.s()) {
                  var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.bk, var4, 153, 15));
               }
            } else {
               LangLa_ky var42;
               if (var4 instanceof LangLa_ky && (var42 = (LangLa_ky)var4).d == 5) {
                  var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.fv, var4, 140, 15));
               }
            }

            if (this.g != null) {
               var9.add(new LangLa_dz(this.width - 51, this.height - 26, 100, 0, Caption.as, var4, 134, 15));
            }

            if (var9.size() > 6 && this.k != null) {
               var9.remove(this.k);
            }

            this.a = new LangLa_dz[var9.size()];

            for(var2 = 0; var2 < var9.size(); ++var2) {
               this.a[var2] = (LangLa_dz)var9.elementAt(var2);
               if (var2 > 0) {
                  this.a[var2].setSize(42, 22);
                  this.a[var2].setXY(this.width - 3 - 47 * var2, this.height - 26);
               }
            }

            if (var4 instanceof LangLa_lv || this.a.length <= 1 && !var5.isTypeTrangBi() && var5.id != 435) {
               this.setSize(220, 120);
            }

            this.a[0].setXY(this.width - 17, 3);
            this.e = a(this.a);
            if (var5.isTypeTrangBi() || var5.level > 0) {
               this.h.addElement(new LangLa_gp("", -1, -16777216));
            }

            if (var5.expiry >= 0L) {
               if (var4 instanceof LangLa_br) {
                  if ((var12 = (LangLa_ge)var4).k() == 0) {
                     this.h.addElement(new LangLa_gp(Caption.fw + var5.N(), -2560, -16777216));
                  } else {
                     this.h.addElement(new LangLa_gp(Caption.fw + var5.O(), -2560, -16777216));
                  }
               } else if (!(var4 instanceof LangLa_lv) && !(var4 instanceof LangLa_bw) && !(var4 instanceof LangLa_bc) && !(var4 instanceof LangLa_bg) && !(var4 instanceof LangLa_ah) && !(var4 instanceof LangLa_bz) && !(var4 instanceof LangLa_ai) && !(var4 instanceof LangLa_bx)) {
                  if (var4 instanceof LangLa_ky) {
                     if (var5.expiry > 2592000000L) {
                        this.h.addElement(new LangLa_gp(Caption.fw + var5.O(), -2560, -16777216));
                     }
                  } else {
                     this.h.addElement(new LangLa_gp(Caption.fw + var5.O(), -2560, -16777216));
                  }
               } else {
                  this.h.addElement(new LangLa_gp(Caption.fw + var5.N(), -2560, -16777216));
               }
            }

            if (var5.getItemTemplate().idClass > 0 && var5.getItemTemplate().idClass != Char.gI().idClass) {
               this.h.addElement(new LangLa_gp(Caption.fx + DataCenter.gI().DataNameChar[var5.getItemTemplate().idClass].name, -65536, -16777216));
            }

            if (var5.getItemTemplate().levelNeed > 0) {
               if (Char.gI().level() < var5.getItemTemplate().levelNeed) {
                  this.h.addElement(new LangLa_gp(Caption.fy + var5.getItemTemplate().levelNeed, -65536, -16777216));
               } else {
                  this.h.addElement(new LangLa_gp(Caption.fy + var5.getItemTemplate().levelNeed, -1, -16777216));
               }
            }

            String var43;
            if (var5.moneyNew > 0) {
               var43 = "";
               if (var4 instanceof LangLa_lv) {
                  LangLa_lv var10;
                  if ((var10 = (LangLa_lv)var4).a == 32) {
                     var43 = Caption.kx;
                  } else if (var10.a == 34) {
                     var43 = Caption.ky;
                  } else if (var10.a == 33) {
                     var43 = Caption.kz;
                  } else if (var10.a == 35) {
                     var43 = Caption.kv;
                  } else {
                     switch(var5.getItemTemplate().type) {
                     case 0:
                        var43 = Caption.rO[0];
                        break;
                     case 1:
                        var43 = Caption.rO[1];
                        break;
                     case 2:
                        var43 = Caption.rO[2];
                        break;
                     case 3:
                        var43 = Caption.rO[3];
                        break;
                     case 4:
                        var43 = Caption.rO[4];
                        break;
                     case 5:
                        var43 = Caption.rO[5];
                        break;
                     case 6:
                        var43 = Caption.rO[6];
                        break;
                     case 7:
                        var43 = Caption.rO[7];
                        break;
                     case 8:
                        var43 = Caption.rO[8];
                        break;
                     case 9:
                        var43 = Caption.rO[9];
                     }
                  }

                  this.h.addElement(new LangLa_gp(Caption.fz + var43 + ": " + Utlis.numberFormat(var5.moneyNew), -16711681, -16777216));
               } else if (var4 instanceof LangLa_br) {
                  LangLa_br var11;
                  if ((var11 = (LangLa_br)var4).b == 32) {
                     var43 = Caption.kx;
                  } else if (var11.b == 34) {
                     var43 = Caption.ky;
                  } else if (var11.b == 33) {
                     var43 = Caption.kz;
                  } else if (var11.b == 35) {
                     var43 = Caption.kv;
                  } else {
                     switch(var5.getItemTemplate().type) {
                     case 0:
                        var43 = Caption.rO[0];
                        break;
                     case 1:
                        var43 = Caption.rO[1];
                        break;
                     case 2:
                        var43 = Caption.rO[2];
                        break;
                     case 3:
                        var43 = Caption.rO[3];
                        break;
                     case 4:
                        var43 = Caption.rO[4];
                        break;
                     case 5:
                        var43 = Caption.rO[5];
                        break;
                     case 6:
                        var43 = Caption.rO[6];
                        break;
                     case 7:
                        var43 = Caption.rO[7];
                        break;
                     case 8:
                        var43 = Caption.rO[8];
                        break;
                     case 9:
                        var43 = Caption.rO[9];
                     }
                  }

                  this.h.addElement(new LangLa_gp(Caption.fz + var43 + ": " + Utlis.numberFormat(var5.moneyNew), -16711681, -16777216));
               }
            }

            if (var5.getItemTemplate().taiPhuNeed > 0) {
               if (Char.gI().taiPhu < var5.getItemTemplate().taiPhuNeed) {
                  this.h.addElement(new LangLa_gp(Caption.fA + var5.getItemTemplate().taiPhuNeed, -65536, -16777216));
               } else {
                  this.h.addElement(new LangLa_gp(Caption.fA + var5.getItemTemplate().taiPhuNeed, -1, -16777216));
               }
            }

            if (var5.getItemTemplate().gioiTinh < 2 && var5.getItemTemplate().gioiTinh != Char.gI().gioiTinh) {
               this.h.addElement(new LangLa_gp(Caption.fB + Caption.rr[var5.getItemTemplate().gioiTinh], -65536, -16777216));
            }

            switch(var5.he) {
            case 1:
               this.h.addElement(new LangLa_gp(Caption.fC + LangLa_hg.d() + var5.b(), -1, -16777216));
               break;
            case 2:
               this.h.addElement(new LangLa_gp(Caption.fC + LangLa_hg.e() + var5.b(), -1, -16777216));
               break;
            case 3:
               this.h.addElement(new LangLa_gp(Caption.fC + LangLa_hg.f() + var5.b(), -1, -16777216));
               break;
            case 4:
               this.h.addElement(new LangLa_gp(Caption.fC + LangLa_hg.g() + var5.b(), -1, -16777216));
               break;
            case 5:
               this.h.addElement(new LangLa_gp(Caption.fC + LangLa_hg.h() + var5.b(), -1, -16777216));
            }

            if (var5.isLock) {
               this.h.addElement(new LangLa_gp(Caption.fD, -1, -16777216));
            } else {
               this.h.addElement(new LangLa_gp(Caption.fE, -1, -16777216));
            }

            if (var5.T() > 0) {
               var43 = Utlis.replaceAll(Caption.fF, Utlis.numberFormat(var5.T()));
               if (var5.W() || var5.X()) {
                  var1 = var5.getItemTemplate().levelNeed / 10 * 100 - 100;
                  if (var5.getItemTemplate().levelNeed / 10 == 6) {
                     var1 = 600;
                  }

                  if (var5.X()) {
                     var1 *= 2;
                  }

                  if (var5.k()) {
                     var43 = var43 + Utlis.replaceAll(Caption.ol, Utlis.numberFormat(var1)) + DataCenter.gI().ItemTemplate[353].name;
                  } else if (var5.D()) {
                     var43 = var43 + Utlis.replaceAll(Caption.ol, Utlis.numberFormat(var1)) + DataCenter.gI().ItemTemplate[565].name;
                  } else if (var5.E()) {
                     var43 = var43 + Utlis.replaceAll(Caption.ol, Utlis.numberFormat(var1)) + DataCenter.gI().ItemTemplate[563].name;
                  } else if (var5.F()) {
                     var43 = var43 + Utlis.replaceAll(Caption.ol, Utlis.numberFormat(var1)) + DataCenter.gI().ItemTemplate[567].name;
                  }
               }

               this.h.addElement(new LangLa_gp(var43 + Caption.fG, -4675551, -16777216));
            }

            if (var5.getItemTemplate().isXepChong) {
               this.h.addElement(new LangLa_gp(Caption.fH, -1, -16777216));
            }

            if (this.g != null) {
               this.h.addElement(new LangLa_gp(Caption.fI + Utlis.numberFormat(this.g.c), -2560, -16777216));
            } else if (var5.d() > 0) {
               this.h.addElement(new LangLa_gp(Caption.fI + Utlis.numberFormat(var5.f()), -1, -16777216));
            } else {
               this.h.addElement(new LangLa_gp(Caption.fJ + Utlis.numberFormat(var5.g()), -1, -16777216));
            }

            if (var5.getItemTemplate().detail.length() > 0 && var5.getItemTemplate().type != 10) {
               String[] var44;
               if (var5.getItemTemplate().type == 34) {
                  var44 = mFont.c(mFont.d, Caption.mp + " " + var5.getItemTemplate().name, this.width - 30);
               } else {
                  var44 = mFont.c(mFont.d, var5.getItemTemplate().detail, this.width - 30);
               }

               for(var1 = 0; var1 < var44.length; ++var1) {
                  this.h.addElement(new LangLa_gp(var44[var1], -1, -16777216));
               }
            }

            ItemOption[] var45 = var5.L();
            var1 = 1;
            if (var45 != null) {
               var3 = 0;
               LangLa_kl var19;
               if (this.s instanceof LangLa_kl && (var19 = (LangLa_kl)this.s).m() == 0) {
                  var3 = var5.a(var19.n(), var19.y);
               }

               boolean var21 = false;
               boolean var6 = false;

               for(int var7 = 0; var7 < var45.length; ++var7) {
                  if ((var45[var7].getItemOptionTemplate().type < 3 || var45[var7].getItemOptionTemplate().type > 7) && var45[var7].getItemOptionTemplate().type != 10 && var45[var7].getItemOptionTemplate().type != 11 && var45[var7].getItemOptionTemplate().type != 15 && var45[var7].getItemOptionTemplate().type != 16) {
                     if (var45[var7].getItemOptionTemplate().type == 2) {
                        if (!var6) {
                           var6 = true;
                           this.h.addElement(new LangLa_gp(Caption.fM + a(var5.getItemTemplate().type, var5.he), -1, -11184811));
                        }

                        if (var3 > 0) {
                           this.h.addElement(new LangLa_gp(var45[var7].b(), -7812062, -16777216));
                           --var3;
                        } else {
                           this.h.addElement(new LangLa_gp(var45[var7].b(), -7631732, -16777216));
                        }
                     } else if (var45[var7].getItemOptionTemplate().type == 8) {
                        this.h.addElement(new LangLa_gp("(" + DataCenter.gI().ItemTemplate[var45[var7].h()].name + " " + Caption.dn + " " + var45[var7].i() + ") " + var45[var7].b(), -7340813, -16777216));
                     } else if (var45[var7].getItemOptionTemplate().type == 14) {
                        this.h.addElement(new LangLa_gp(var1 + ". " + var45[var7].b(), -16742145, -16777216));
                        ++var1;
                     } else if (var45[var7].getItemOptionTemplate().id >= 53 && var45[var7].getItemOptionTemplate().id <= 62) {
                        this.h.addElement(new LangLa_gp(var45[var7].c(), -10831436, -16777216));
                     } else if (var45[var7].getItemOptionTemplate().id != 128 && var45[var7].getItemOptionTemplate().id != 305) {
                        if (var45[var7].getItemOptionTemplate().id == 336) {
                           this.h.addElement(new LangLa_gp(var45[var7].c(), -623877, -16777216));
                        } else if (var45[var7].getItemOptionTemplate().id == 337) {
                           this.h.addElement(new LangLa_gp(var45[var7].b() + Utlis.numberFormat((var45[var7 - 1].e() + 1) * 5000000), -2560, -16777216));
                        } else if (var45[var7].d() == 105) {
                           Vector var10000 = this.h;
                           StringBuilder var10003 = (new StringBuilder()).append(Caption.fN).append(LangLa_hg.b());
                           int[] var10005 = var45[var7].a;
                           var10000.addElement(new LangLa_gp(var10003.append(DataCenter.gI().MapTemplate[var10005[1]].name).toString(), -1, -16777216));
                           this.h.addElement(new LangLa_gp(Caption.fO, -1, -16777216));
                        } else if (var45[var7].d() == 148) {
                           this.h.addElement(new LangLa_gp(var45[var7].b(), -3407617, -16777216));
                        } else if (var45[var7].d() == 159) {
                           this.h.addElement(new LangLa_gp(var45[var7].b(), -196483, -16777216));
                        } else if (var45[var7].d() == 163) {
                           this.h.addElement(new LangLa_gp(var45[var7].b(), -48128, -16777216));
                        } else if (var45[var7].d() != 164 && var45[var7].getItemOptionTemplate().id != 340) {
                           if (var45[var7].d() == 165) {
                              this.h.addElement(new LangLa_gp(var45[var7].b(), -16712186, -16777216));
                           } else if (var45[var7].d() == 361) {
                              this.h.addElement(new LangLa_gp(var45[var7].b(), -13176412, -16777216));
                           } else {
                              this.h.addElement(new LangLa_gp(var45[var7].b(), -10831436, -16777216));
                           }
                        } else {
                           this.h.addElement(new LangLa_gp(var45[var7].b(), -4588032, -16777216));
                        }
                     } else {
                        this.h.addElement(new LangLa_gp(var45[var7].c(), -2560, -16777216));
                     }
                  } else {
                     if (!var21) {
                        var21 = true;
                        if (var5.getItemTemplate().type == 11) {
                           this.h.addElement(new LangLa_gp(Caption.fK, -1, -11184811));
                        } else {
                           this.h.addElement(new LangLa_gp(Caption.fL, -1, -11184811));
                        }
                     }

                     this.h.addElement(new LangLa_gp(var45[var7].b(), var5.isOptionActive(var45[var7]) ? -2560 : -7631732, -16777216));
                  }
               }
            }

            if (var5.getItemTemplate().type == 99 && var5.strOptions.length() > 0) {
               this.h.addElement(new LangLa_gp("", -10831436, -16777216));
               this.h.addElement(new LangLa_gp("", -10831436, -16777216));
            }

            this.f = new LangLa_ii((byte)1, 4, 4, this.width - 25, 105, 15, 1 + this.h.size());
         } catch (Exception var8) {
            Utlis.println(var8);
         }
      }
   }

   public void a() {
      this.i = true;
      if (this.b.getItemTemplate().type == 100) {
         this.setSize(220, 120);
      } else {
         this.setSize(250, 120);
      }

      this.f = new LangLa_ii((byte)1, 4, 4, this.width - 25, 105, 15, 1 + this.h.size());
   }

   public void a(Graphics var1) {
      int var2 = var1.a;
      int var3 = var1.b;
      this.a(var1, 0, 0, this.width, this.height, -11, 55, 56);
      this.a(var1, this.f);
      if (this.g != null) {
         b(var1, this.width - 58, 3, this.g.e, false);
      }

      this.b(var1, 5, 7);
      int var5;
      if (this.b.isTypeTrangBi() || this.b.level > 0) {
         int var4 = 8;
         if (this.b.level >= 17) {
            var4 = this.b.level - 8;
         }

         for(var5 = 0; var5 < var4; ++var5) {
            LangLa_fq.a(var1, 420, 0, 15 + var5 * 20, 22, 3);
            if (this.b.level >= 18) {
               if (var5 == this.j) {
                  LangLa_fq.a(var1, 827, 0, 15 + var5 * 20, 22, 3);
               } else {
                  if (this.b.level == 19) {
                     var1.d(10.0F);
                  }

                  LangLa_fq.a(var1, 545 + DataCenter.gI().i / 3 % 5, 0, 15 + var5 * 20, 22, 3);
                  if (this.b.level == 19) {
                     var1.h();
                  }
               }
            } else if (this.b.level >= 17) {
               if (var5 == this.j) {
                  LangLa_fq.a(var1, 827, 0, 15 + var5 * 20, 22, 3);
               } else {
                  LangLa_fq.a(var1, 822 + DataCenter.gI().i / 5 % 5, 0, 15 + var5 * 20, 22, 3);
               }
            } else if (this.b.level > 0) {
               if (this.b.level >= 2 && this.b.level / 2 > var5) {
                  if (this.b.level >= 16) {
                     if (var5 == this.j) {
                        var1.e(30);
                     }

                     LangLa_fq.a(var1, 430, 0, 15 + var5 * 20, 22, 3);
                     var1.d();
                  } else if (this.b.level >= 14) {
                     if (var5 == this.j) {
                        var1.e(30);
                     }

                     LangLa_fq.a(var1, 428, 0, 15 + var5 * 20, 22, 3);
                     var1.d();
                  } else if (this.b.level >= 12) {
                     if (var5 == this.j) {
                        var1.e(30);
                     }

                     LangLa_fq.a(var1, 424, 0, 15 + var5 * 20, 22, 3);
                     var1.d();
                  } else if (this.b.level >= 8) {
                     if (this.b.level >= 10) {
                        var1.c(-184786);
                     } else {
                        var1.c(-93738);
                     }

                     if (var5 == this.j) {
                        var1.e(30);
                     }

                     LangLa_fq.a(var1, 426, 0, 15 + var5 * 20, 22, 3);
                     var1.d();
                     var1.c();
                  } else if (this.b.level >= 4) {
                     LangLa_fq.a(var1, 422, 0, 15 + var5 * 20, 22, 3);
                  } else {
                     LangLa_fq.a(var1, 47, 0, 15 + var5 * 20, 22, 3);
                  }
               }

               if (this.b.level % 2 > 0 && this.b.level / 2 == var5) {
                  if (this.b.level >= 16) {
                     if (var5 == this.j) {
                        var1.e(30);
                     }

                     LangLa_fq.a(var1, 431, 0, 15 + var5 * 20, 22, 3);
                     var1.d();
                  } else if (this.b.level >= 14) {
                     if (var5 == this.j) {
                        var1.e(30);
                     }

                     LangLa_fq.a(var1, 429, 0, 15 + var5 * 20, 22, 3);
                     var1.d();
                  } else if (this.b.level >= 12) {
                     if (var5 == this.j) {
                        var1.e(30);
                     }

                     LangLa_fq.a(var1, 425, 0, 15 + var5 * 20, 22, 3);
                     var1.d();
                  } else if (this.b.level >= 8) {
                     if (this.b.level >= 10) {
                        var1.c(-184786);
                     } else {
                        var1.c(-93738);
                     }

                     if (var5 == this.j) {
                        var1.e(30);
                     }

                     LangLa_fq.a(var1, 427, 0, 15 + var5 * 20, 22, 3);
                     var1.d();
                     var1.c();
                  } else if (this.b.level >= 4) {
                     LangLa_fq.a(var1, 423, 0, 15 + var5 * 20, 22, 3);
                  } else {
                     LangLa_fq.a(var1, 48, 0, 15 + var5 * 20, 22, 3);
                  }
               }
            }
         }
      }

      for(var5 = 0; var5 < this.h.size(); ++var5) {
         if (this.f.b(var5)) {
            LangLa_gp var6;
            if ((var6 = (LangLa_gp)this.h.elementAt(var5)).b == -13176412) {
               mFont.a(mFont.d, var1, var6.a, 5, this.f.h + 9 + var5 * this.f.h, 0, -15106770, 2, 1);
               mFont.a(mFont.d, var1, var6.a, 5, this.f.h + 8 + var5 * this.f.h, 0, var6.b, 2, 1);
            } else {
               mFont.c(mFont.d, var1, var6.a, 5, this.f.h + 8 + var5 * this.f.h, 0, var6.b, var6.c);
            }
         }
      }

      ItemOption var7;
      if (this.b.getItemTemplate().type == 99 && this.b.strOptions != null && this.b.strOptions.length() > 0 && (var7 = this.b.L()[0]).a != null && var7.a.length > 4) {
         LangLa_fq.b(var1, var7.a[4], 0, 40, (this.h.size() - 2) * this.f.h, 0);
      }

      this.b(var1);
      this.a(var1, var2, var3);
      this.f.a(var1);
      this.a(var1, this.a, var2, var3);
   }

   public void b(Graphics var1, int var2, int var3) {
      if (this.b.level > 0) {
         String var4 = this.b.getItemTemplate().name + " (+" + this.b.level + ")";
         if (this.b.getItemTemplate().type == 11 || this.b.getItemTemplate().type == 12 || this.b.getItemTemplate().type == 13) {
            var4 = this.b.getItemTemplate().name;
         }

         if (this.b.level >= 19) {
            mFont.a(mFont.f, var1, var4, var2 + 1, var3 + 1, 0, -14915496, 1, 0);
         }

         if (this.b.level >= 18) {
            mFont.a(mFont.f, var1, var4, var2, var3, 0, a(this.b.level), 2, 0);
         } else if (this.b.level == 17) {
            mFont.a(mFont.f, var1, var4, var2, var3, 0, a(this.b.level), 2, 0);
         } else if (this.b.level >= 15) {
            mFont.a(mFont.f, var1, var4, var2, var3, 0, a(this.b.level), 2, 0);
         } else if (this.b.level >= 12) {
            mFont.a(mFont.f, var1, var4, var2, var3, 0, a(this.b.level), 3, 0);
         } else {
            if (this.b.level < 8) {
               mFont.b(mFont.f, var1, var4, var2, var3, 0, a(this.b.level), 0);
               return;
            }

            mFont.a(mFont.f, var1, var4, var2, var3, 0, a(this.b.level), 3, 0);
         }
      } else {
         mFont.b(mFont.f, var1, this.b.getItemTemplate().name, var2, var3, 0, -1, -16777216);
      }

   }

   private void a(Vector var1, LangLa_cx var2, LangLa_ge var3) {
      if (this.b.getItemTemplate().levelNeed <= Char.gI().level() && (this.b.getItemTemplate().gioiTinh == 2 || this.b.getItemTemplate().gioiTinh == Char.gI().gioiTinh)) {
         if (var3.f() == 0) {
            if (!this.b.n() || Char.gI().taiPhu >= this.b.getItemTemplate().taiPhuNeed) {
               if (this.b.U()) {
                  if (this.b.getItemTemplate().type == 99 && (this.b.strOptions == null || this.b.strOptions.length() == 0) && this.b.id != 791) {
                     var1.add(new LangLa_dz(this.width - 51, this.height - 26, 0, 0, Caption.fP, var2, 131, 15));
                  } else if (!this.b.isTypeTrangBi() || !(var2 instanceof LangLa_kj)) {
                     var1.add(new LangLa_dz(this.width - 51, this.height - 26, 0, 0, Caption.r, var2, 104, 15));
                     if (this.b.getItemTemplate().isXepChong && this.b.getItemTemplate().type != 24 && this.b.getAmount() > 1) {
                        if (this.b.id == 435) {
                           var1.add(new LangLa_dz(this.width - 51, this.height - 26, 0, 0, Caption.qv, var2, 169, 15));
                        } else if (this.b.id != 763 && this.b.id != 864 && this.b.id != 868) {
                           var1.add(new LangLa_dz(this.width - 51, this.height - 26, 0, 0, Caption.mg, var2, 149, 15));
                        }
                     }
                  }
               }

               if (this.b.isTypeTrangBi() && !(var2 instanceof LangLa_kj)) {
                  var1.add(new LangLa_dz(this.width - 51, this.height - 26, 0, 0, Caption.fQ, var2, 127, 15));
               }
            }
         } else if (var3.f() == 1) {
            var1.add(new LangLa_dz(this.width - 51, this.height - 26, 105, 0, Caption.aR, var2, 108, 15));
         }
      }

      if (!this.b.isLock) {
         var1.add(new LangLa_dz(this.width - 51, this.height - 26, 0, 0, Caption.s, var2, 109, 15));
      }

      if (this.b.getAmount() >= 2) {
         var1.add(new LangLa_dz(this.width - 51, this.height - 26, 0, 0, Caption.t, var2, 102, 15));
      }

      if (this.b.U() && this.b.id != GameSrc.gI().bz) {
         var1.add(this.k = new LangLa_dz(this.width - 51, this.height - 26, 0, 0, Caption.bR, var2, 137, 15));
      }

   }

   public void b() {
      if (this.i) {
         for(int var1 = 1; var1 < this.a.length; ++var1) {
            this.a[var1].b(true);
         }
      }

      a(this.a, this.e);
      this.f.a();
      if ((this.b.level < 8 || this.b.level > 11 || DataCenter.gI().i % 5 != 0) && (this.b.level < 12 || this.b.level > 16 || DataCenter.gI().i % 4 != 0)) {
         if (this.b.level >= 17 && DataCenter.gI().i % 3 == 0) {
            ++this.j;
            if (this.j > this.b.level - 8) {
               this.j = 0;
            }
         }
      } else {
         ++this.j;
         if (this.j > this.b.level / 2) {
            this.j = 0;
         }
      }

      int var10000 = GameSrc.gI().Task;
      DataCenter.gI();
      if (var10000 <= 12 && this.s.cL.equals(this)) {
         Step var2 = GameSrc.gI().B();
         int var3 = this.s.cx + this.cx + this.width;
         int var4 = this.s.cy + this.cy + this.height;
         switch(GameSrc.gI().Task) {
         case 0:
            if (GameSrc.gI().idStep == 0 && this.b.id == 28) {
               DataCenter.gI().aO.a(var3 - 35, var4 - 12);
               DataCenter.gI().aO.a = true;
               return;
            }
            break;
         case 1:
            if (GameSrc.gI().idStep == 1 && this.b.id == 378) {
               DataCenter.gI().aO.a(var3 - 70, var4 - 12);
               DataCenter.gI().aO.a = true;
               return;
            }
            break;
         case 2:
            if (GameSrc.gI().idStep == 1 && this.b.id == 194) {
               DataCenter.gI().aO.a(var3 - 70, var4 - 12);
               DataCenter.gI().aO.a = true;
               return;
            }
            break;
         case 3:
            if (GameSrc.gI().idStep == 1) {
               DataCenter.gI().aO.a(var3 - 35, var4 - 12);
               DataCenter.gI().aO.a = true;
               return;
            }

            if (GameSrc.gI().idStep == 4 && this.b.id == 379) {
               DataCenter.gI().aO.a(var3 - 70, var4 - 12);
               DataCenter.gI().aO.a = true;
               return;
            }
         case 4:
         case 5:
         case 7:
         default:
            break;
         case 6:
            if (GameSrc.gI().idStep >= 0 && this.b.id == 380 && var2 != null && Char.gI().cx == var2.x && Char.gI().cy == var2.y) {
               DataCenter.gI().aO.a(var3 - 35, var4 - 12);
               DataCenter.gI().aO.a = true;
               return;
            }
            break;
         case 8:
            Item var5 = Char.gI().v();
            if (GameSrc.gI().idStep == 9 && var5 != null && this.b.id == var5.id) {
               DataCenter.gI().aO.a(var3 - 35, var4 - 12);
               DataCenter.gI().aO.a = true;
               return;
            }
            break;
         case 9:
            if (GameSrc.gI().idStep == 10 && this.s instanceof LangLa_ar) {
               if (((LangLa_ar)this.s).k.b != ((LangLa_ar)this.s).j()) {
                  DataCenter.gI().aO.a(var3 - 35, var4 - 12);
               } else if (this.b.getItemTemplate().type == 1 || this.b.getItemTemplate().type == 21) {
                  if (this.b.isLock) {
                     DataCenter.gI().aO.a(var3 - 35, var4 - 12);
                  } else {
                     DataCenter.gI().aO.a(var3 - 70, var4 - 12);
                  }
               }

               DataCenter.gI().aO.a = true;
               return;
            }
            break;
         case 10:
            if (GameSrc.gI().idStep == 5 && this.s instanceof LangLa_by) {
               DataCenter.gI().aO.a(var3 - 70, var4 - 12);
               DataCenter.gI().aO.a = true;
               return;
            }
            break;
         case 11:
            if (this.s instanceof LangLa_kl && this.b.id == 383 && var2 != null && Char.gI().cx == var2.x && Char.gI().cy == var2.y) {
               DataCenter.gI().aO.a(var3 - 35, var4 - 12);
               DataCenter.gI().aO.a = true;
            }
         }
      }

   }

   public Vector c() {
      Vector var1 = new Vector();
      if (this.i) {
         var1.addElement(this.e[0].a(this.a[0].b, this));
      } else {
         for(int var2 = 0; var2 < this.e.length; ++var2) {
            var1.addElement(this.e[var2].a(this.a[var2].b, this));
         }
      }

      var1.addElement(new LangLa_jz(1010, this.f.cx, this.f.cy, this.f.cx + this.f.width, this.f.cy + this.f.height, this.f, this));
      var1.addElement(new LangLa_jz(1011, 0, 0, this.width, this.height, this.f, this));
      return var1;
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      LangLa_mk var26;
      Message var28;
      Item[] var32;
      LangLa_ge var34;
      LangLa_v var38;
      boolean var41;
      LangLa_t var42;
      switch(var1.b) {
      case 100:
         this.g();
         break;
      case 101:
         this.g();
         if (this.s instanceof LangLa_br) {
            (var34 = (LangLa_ge)this.s).p.a((LangLa_cx)(new LangLa_lv(var34.p, this.b, ((LangLa_br)this.s).b)));
         } else if (this.s instanceof LangLa_bw) {
            LangLa_bw var46;
            if ((var46 = (LangLa_bw)this.s).a.b.b == 3) {
               var46.p.a((LangLa_cx)(new LangLa_lv(var46.p, this.b, (byte)40)));
            } else {
               var46.p.a((LangLa_cx)(new LangLa_lv(var46.p, this.b, (byte)6)));
            }
         }
         break;
      case 102:
         this.g();
         (var34 = (LangLa_ge)this.s).p.a((LangLa_cx)(new LangLa_bs(var34.p, this.b)));
         break;
      case 103:
         this.g();
         if (this.b.level > 0 && (this.b.k() || this.b.m() || this.b.l())) {
            DataCenter.gI().currentScreen.showMessage(Caption.aN, -65536);
         } else {
            DataCenter.gI().currentScreen.a(Caption.aO, 2000, this);
         }
         break;
      case 104:
         this.g();
         if (this.b.id == 791) {
            DataCenter.gI().currentScreen.a(Caption.qE, 2001, this);
         } else if (this.b.isTypeTrangBi() && !this.b.isLock) {
            DataCenter.gI().currentScreen.a(Caption.aQ, 2001, this);
         } else {
            GameSrc.gI();
            GameSrc.a(this.b);
         }
         break;
      case 105:
         this.g();
         var26 = this;

         try {
            (var28 = new Message((byte)113)).writeByte(var26.b.getItemTemplate().type);
            var28.send();
         } catch (Exception var25) {
            Utlis.println(var25);
         }
         break;
      case 106:
         this.g();
         var26 = this;

         try {
            (var28 = new Message((byte)115)).writeShort(var26.b.index);
            var28.send();
         } catch (Exception var24) {
            Utlis.println(var24);
         }
         break;
      case 107:
         this.g();
         var26 = this;

         try {
            (var28 = new Message((byte)114)).writeShort(var26.b.index);
            var28.send();
         } catch (Exception var23) {
            Utlis.println(var23);
         }
         break;
      case 108:
         this.g();
         if (this.s instanceof LangLa_fc) {
            ((LangLa_fc)this.s).J();
         }

         var26 = this;

         try {
            (var28 = new Message((byte)112)).writeByte(var26.b.index);
            var28.send();
         } catch (Exception var22) {
            Utlis.println(var22);
         }
         break;
      case 109:
         this.g();
         Item var43;
         if ((var43 = this.b).id >= 5 && var43.id <= 11 || var43.id == 231 || var43.id == 176 || var43.id == 160 || var43.id == 161 || var43.id == 169 || var43.id == 170 || var43.id == 156 || var43.id == 157 || var43.id == 158 || var43.id == 159 || var43.id == 162 || var43.id == 166 || var43.id == 168 || var43.id == 182 || var43.id == 183 || var43.id == 184 || var43.id == 177) {
            DataCenter.gI().currentScreen.a(Caption.fR + this.b.getItemTemplate().name + Caption.dC, 2005, this);
         } else {
            this.f();
         }
         break;
      case 110:
         this.g();
         this.I();
         break;
      case 111:
         this.g();
         this.J();
         break;
      case 112:
         this.g();
         this.m();
         break;
      case 113:
         this.g();
         this.n();
         break;
      case 114:
         this.g();
         var26 = this;

         try {
            LangLa_bv var45;
            var32 = (var45 = (LangLa_bv)var26.s).b(var26.b);
            if (var45.a[0] != null) {
               var32[var45.a[0].index] = var45.a[0];
            }

            var45.a[0] = var26.b;
            var32[var26.b.index] = null;
         } catch (Exception var21) {
            Utlis.println(var21);
         }
         break;
      case 115:
         this.g();
         this.o();
         break;
      case 116:
         this.g();
         var26 = this;

         try {
            LangLa_a var44;
            var32 = (var44 = (LangLa_a)var26.s).b(var26.b);
            if (var26.b.getItemTemplate().type == 25) {
               if (var44.a[2] != null) {
                  var32[var44.a[2].index] = var44.a[2];
               }

               var44.a[2] = var26.b;
               var32[var26.b.index] = null;
            } else if (var26.b.level > 0) {
               if (var44.a[0] != null) {
                  var32[var44.a[0].index] = var44.a[0];
               }

               var44.a[0] = var26.b;
               var32[var26.b.index] = null;
            } else {
               if (var44.a[1] != null) {
                  var32[var44.a[1].index] = var44.a[1];
               }

               var44.a[1] = var26.b;
               var32[var26.b.index] = null;
            }
         } catch (Exception var20) {
            Utlis.println(var20);
         }
         break;
      case 117:
         this.g();
         this.r();
         break;
      case 118:
         this.g();
         this.w();
         break;
      case 119:
         this.g();
         this.x();
         break;
      case 120:
         this.g();
         var26 = this;

         try {
            if ((var38 = (LangLa_v)var26.s).d != null) {
               Char.gI().arrItemBag[var38.d.index] = var38.d;
            }

            var38.d = var26.b;
            Char.gI().arrItemBag[var26.b.index] = null;
            var41 = true;
            var38.a(0);
            var38.c.a(1);
            var38.o();
            var38.a(var38.j());
            var38.c.a(1);
            var38.a(0);
         } catch (Exception var19) {
            Utlis.println(var19);
         }
         break;
      case 121:
         this.g();
         var38 = (LangLa_v)this.s;
         Char.gI().arrItemBag[var38.d.index] = var38.d;
         var38.d = null;
         break;
      case 122:
         this.g();
         LangLa_v var47 = (LangLa_v)this.s;
         var41 = true;
         LangLa_v var40 = var47;
         var47.a(true, var40.a[var40.b]);
         break;
      case 123:
         this.g();
         var26 = this;

         try {
            if ((var42 = (LangLa_t)var26.s).e != null) {
               Char.gI().arrItemBag[var42.e.index] = var42.e;
            }

            var42.e = var26.b;
            Char.gI().arrItemBag[var26.b.index] = null;
         } catch (Exception var18) {
            Utlis.println(var18);
         }
         break;
      case 124:
         this.g();
         var42 = (LangLa_t)this.s;
         Char.gI().arrItemBag[var42.e.index] = var42.e;
         var42.e = null;
         break;
      case 125:
         this.g();
         this.K();
         break;
      case 126:
         this.g();
         this.L();
         break;
      case 127:
         this.g();
         if (this.b.isTypeTrangBi() && !this.b.isLock) {
            DataCenter.gI().currentScreen.a(Caption.bH, 2002, this);
         } else {
            this.M();
         }
         break;
      case 128:
         this.g();
         var26 = this;

         try {
            (var28 = new Message((byte)37)).writeByte(var26.b.getItemTemplate().type);
            var28.send();
         } catch (Exception var17) {
            Utlis.println(var17);
         }
         break;
      case 129:
         this.g();
         this.N();
         break;
      case 130:
         this.g();
         this.V();
         break;
      case 131:
         this.g();
         var26 = this;

         try {
            (var28 = new Message((byte)-3)).writeShort(var26.b.index);
            var28.send();
         } catch (Exception var16) {
            Utlis.println(var16);
         }
         break;
      case 132:
         this.g();
         var38 = (LangLa_v)this.s;
         if (Char.gI().L) {
            var38.a(false);
         } else {
            var38.a(true);
         }
         break;
      case 134:
         this.g();
         DataCenter.gI().currentScreen.a(Caption.fT + Utlis.numberFormat(this.g.c) + Caption.dC, Caption.bz, 2003, 2004, this);
         break;
      case 135:
         this.g();
         this.O();
         break;
      case 136:
         this.g();
         this.W();
         break;
      case 137:
         this.g();
         var26 = this;

         try {
            GameSrc var10000 = GameSrc.gI();
            var2 = var26.b.id;
            GameSrc var39 = var10000;
            var10000.bz = var2;
            var39.ab.b(false);
            var39.showMessage(DataCenter.gI().ItemTemplate[var2].name + Caption.gH, -1);
            Binary.writeInt("shortcutItem", var2);
         } catch (Exception var15) {
            Utlis.println(var15);
         }
         break;
      case 138:
         this.g();
         this.u();
         break;
      case 139:
         this.g();
         this.v();
         break;
      case 140:
         this.g();
         var26 = this;

         try {
            LangLa_ky var36 = (LangLa_ky)var26.s;
            Message var37;
            (var37 = Message.c((byte)-90)).writeShort(var36.g.indexOf(var26.b));
            var37.send();
         } catch (Exception var14) {
         }
         break;
      case 141:
         this.g();
         this.Q();
         break;
      case 142:
         this.g();
         this.U();
         break;
      case 143:
         this.g();
         this.A();
         break;
      case 144:
         this.g();
         this.B();
         break;
      case 145:
         this.g();
         this.X();
         break;
      case 146:
         this.g();
         this.Y();
         break;
      case 147:
         this.g();
         var26 = this;

         try {
            LangLa_bu var35;
            var32 = (var35 = (LangLa_bu)var26.s).b(var26.b);
            if (var35.a[0] != null) {
               var32[var35.a[0].index] = var35.a[0];
            }

            var35.a[0] = var26.b;
            var32[var26.b.index] = null;
            var35.e();
         } catch (Exception var13) {
            Utlis.println(var13);
         }
         break;
      case 148:
         this.g();
         this.q();
         break;
      case 149:
         this.g();
         (var34 = (LangLa_ge)this.s).p.a((LangLa_cx)(new LangLa_av(var34.p, this.b)));
         break;
      case 150:
         this.g();
         this.j();
         break;
      case 151:
         this.g();
         this.k();
         break;
      case 152:
         this.g();
         ((LangLa_am)this.s).a(this.b);
         break;
      case 153:
         this.g();
         var26 = this;

         try {
            LangLa_bt var33;
            var32 = (var33 = (LangLa_bt)var26.s).b(var26.b);
            if (var33.a[0] != null) {
               Char.gI().h(var33.a[0].TYPE_TEMP)[var33.a[0].index] = var33.a[0];
            }

            var33.a[0] = var26.b;
            var33.e();
            var32[var26.b.index] = null;
         } catch (Exception var12) {
            Utlis.println(var12);
         }
         break;
      case 154:
         this.g();
         this.l();
         break;
      case 155:
         this.g();
         this.Z();
         break;
      case 156:
         this.g();
         this.aa();
         break;
      case 157:
         this.g();
         this.C();
         break;
      case 158:
         this.g();
         this.D();
         break;
      case 159:
         this.g();
         this.E();
         break;
      case 160:
         this.g();
         this.F();
         break;
      case 161:
         this.g();
         this.G();
         break;
      case 162:
         this.g();
         this.H();
         break;
      case 163:
         this.g();
         var26 = this;

         try {
            LangLa_e var31;
            var32 = (var31 = (LangLa_e)var26.s).b(var26.b);
            if (var31.a[0] != null) {
               Char.gI().h(var31.a[0].TYPE_TEMP)[var31.a[0].index] = var31.a[0];
            }

            var31.a[0] = var26.b;
            var32[var26.b.index] = null;
         } catch (Exception var11) {
            Utlis.println(var11);
         }
         break;
      case 164:
         this.g();
         this.P();
         break;
      case 165:
         this.g();
         var26 = this;

         try {
            LangLa_ag var30;
            var32 = (var30 = (LangLa_ag)var26.s).b(var26.b);
            if (var26.b.id == 658) {
               if (var30.b[2] != null) {
                  var32[var30.b[2].index] = var30.b[2];
               }

               var30.b[2] = var26.b;
               var32[var26.b.index] = null;
            } else {
               if (var30.b[0] != null) {
                  var32[var30.b[0].index] = var30.b[0];
               }

               var30.b[0] = var26.b;
               var32[var26.b.index] = null;
               var30.e();
            }
         } catch (Exception var10) {
            Utlis.println(var10);
         }
         break;
      case 166:
         this.g();
         this.t();
         break;
      case 167:
         this.g();

         try {
            Message.c((byte)-20).send();
         } catch (Exception var9) {
         }
         break;
      case 168:
         this.g();
         var2 = 100 + (Char.gI().aX - 10) * 50;
         DataCenter.gI().currentScreen.a(Utlis.replaceAll(Caption.qu, Utlis.numberFormat(var2)), 2007, 2008, this);
         break;
      case 169:
         this.g();
         Vector var27;
         (var27 = new Vector()).addElement(new LangLa_lk(30000, Caption.qw));
         var27.addElement(new LangLa_lk(30001, Caption.qx));
         if (var27.size() > 0) {
            String[] var29 = new String[var27.size()];
            short[] var4 = new short[var27.size()];

            for(int var5 = 0; var5 < var27.size(); ++var5) {
               LangLa_lk var6 = (LangLa_lk)var27.elementAt(var5);
               var29[var5] = var6.b;
               var4[var5] = (short)var6.a;
            }

            this.s.cL = LangLa_cx.a(this.s, this.cx, this.cy, new LangLa_kd(this.b.index, var4, var29));
         }
         break;
      case 170:
         this.g();
         GameSrc.gI();
         GameSrc.i(this.b.getItemTemplate().type);
         break;
      case 171:
         this.g();
         this.y();
         break;
      case 172:
         this.g();
         this.z();
         break;
      case 2000:
         GameSrc.gI();
         GameSrc.a(this.b, false);
         break;
      case 2001:
         GameSrc.gI();
         GameSrc.a(this.b);
         break;
      case 2002:
         this.M();
         break;
      case 2003:
         var26 = this;

         try {
            (var28 = new Message((byte)98)).writeLong(var26.g.a);
            var28.send();
         } catch (Exception var8) {
            Utlis.println(var8);
         }
      case 2004:
      default:
         break;
      case 2005:
         this.f();
         break;
      case 2006:
         this.e();
         break;
      case 2007:
         this.g();

         try {
            Message.c((byte)-21).send();
         } catch (Exception var7) {
         }
         break;
      case 2008:
         this.g();
      }

      if (var1.b == 1010 || var1.b == 1011) {
         ;
      }
   }

   private void e() {
      SettingsTab.gI().b(false);

      try {
         Message var1;
         (var1 = new Message((byte)111)).writeShort(this.b.index);
         var1.send();
      } catch (Exception var2) {
         Utlis.println(var2);
      }
   }

   private static int a(int var0) {
      if (var0 >= 19) {
         return -13333639;
      } else if (var0 >= 18) {
         return -7995113;
      } else if (var0 >= 17) {
         return -720386;
      } else if (var0 >= 16) {
         return -2560;
      } else if (var0 >= 14) {
         return -10618832;
      } else if (var0 >= 12) {
         return -16551185;
      } else if (var0 >= 10) {
         return -65024;
      } else if (var0 >= 8) {
         return -391263;
      } else if (var0 >= 4) {
         return -1602278;
      } else {
         return var0 > 0 ? -16609665 : -1;
      }
   }

   private static String a(int var0, int var1) {
      try {
         switch(var0) {
         case 0:
            return Caption.rq[3] + " (" + Caption.ro[var1 - 1] + "), " + Caption.rq[4] + " (" + Caption.ro[var1 - 1] + ")";
         case 1:
            return Caption.aq + " (" + Caption.ro[var1 - 1] + ") " + Caption.aw + " (" + Caption.ro[var1 - 1] + ")";
         case 2:
            return Caption.rq[7] + " (" + Caption.ro[var1 - 1] + "), " + Caption.rq[8] + " (" + Caption.ro[var1 - 1] + ")";
         case 3:
            return Caption.rq[0] + " (" + Caption.ro[var1 - 1] + "), " + Caption.rq[4] + " (" + Caption.ro[var1 - 1] + ")";
         case 4:
            return Caption.rq[0] + " (" + Caption.ro[var1 - 1] + "), " + Caption.rq[3] + " (" + Caption.ro[var1 - 1] + ")";
         case 5:
            return Caption.rq[6] + " (" + Caption.ro[var1 - 1] + "), " + Caption.rq[9] + " (" + Caption.ro[var1 - 1] + ")";
         case 6:
            return Caption.rq[5] + " (" + Caption.ro[var1 - 1] + "), " + Caption.rq[9] + " (" + Caption.ro[var1 - 1] + ")";
         case 7:
            return Caption.rq[2] + " (" + Caption.ro[var1 - 1] + "), " + Caption.rq[8] + " (" + Caption.ro[var1 - 1] + ")";
         case 8:
            return Caption.rq[2] + " (" + Caption.ro[var1 - 1] + "), " + Caption.rq[7] + " (" + Caption.ro[var1 - 1] + ")";
         case 9:
            return Caption.rq[6] + " (" + Caption.ro[var1 - 1] + "), " + Caption.rq[5] + " (" + Caption.ro[var1 - 1] + ")";
         }
      } catch (Exception var2) {
         Utlis.println(var2);
      }

      return "";
   }

   private void f() {
      if (!SettingsTab.gI().t()) {
         this.e();
      } else {
         DataCenter.gI().currentScreen.a(Caption.lx, 2006, 2004, this);
      }
   }

   private void g() {
      this.s.b((LangLa_cs)this);
      if (this.c != null) {
         this.s.b((LangLa_cs)this.c);
      }

   }

   private void j() {
      try {
         LangLa_am var1;
         Item[] var2 = (var1 = (LangLa_am)this.s).b(this.b);
         int var3 = 0;

         for(int var4 = 0; var4 < var1.b.length; ++var4) {
            if (var1.b[var4] != null) {
               ++var3;
               if (var1.b[var4].id == this.b.id) {
                  DataCenter.gI().currentScreen.showMessage(this.b.getItemTemplate().name + " " + Caption.nO, -65536);
                  return;
               }
            }
         }

         boolean var7 = false;

         int var5;
         for(var5 = 0; var5 < var1.b.length; ++var5) {
            if (var1.b[var5] == null) {
               var7 = true;
               break;
            }
         }

         if (var7 && var3 < GameSrc.gI().cv) {
            for(var5 = 0; var5 < var1.b.length; ++var5) {
               if (var1.b[var5] == null) {
                  var1.b[var5] = this.b;
                  break;
               }
            }

            var1.a(var1.a[0]);
            var2[this.b.index] = null;
         } else {
            DataCenter.gI().currentScreen.showMessage(Caption.oG, -65536);
         }
      } catch (Exception var6) {
         Utlis.println(var6);
      }
   }

   private void k() {
      LangLa_am var1;
      Item[] var2 = (var1 = (LangLa_am)this.s).b;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         if (var2[var3] != null && var2[var3].equals(this.b)) {
            Char.gI().h(this.b.TYPE_TEMP)[this.b.index] = this.b;
            var2[var3] = null;
            break;
         }
      }

      var1.a(this.b == var1.a[0] ? null : var1.a[0]);
   }

   private void l() {
      Item[] var1 = ((LangLa_bt)this.s).a;

      for(int var2 = 0; var2 < var1.length; ++var2) {
         if (var1[var2] != null && var1[var2].equals(this.b)) {
            Char.gI().h(this.b.TYPE_TEMP)[this.b.index] = this.b;
            var1[var2] = null;
            return;
         }
      }

   }

   private void m() {
      try {
         LangLa_ar var1;
         Item[] var2 = (var1 = (LangLa_ar)this.s).b(this.b);
         boolean var3 = false;
         if (this.b.id == 162) {
            if (var1.a[2] != null) {
               var2[var1.a[2].index] = var1.a[2];
            }

            var1.a[2] = this.b;
         } else if (this.b.isTypeTrangBi()) {
            if (var1.a[0] != null) {
               Char.gI().h(var1.a[0].TYPE_TEMP)[var1.a[0].index] = var1.a[0];
            }

            var1.a[0] = this.b;
         } else {
            for(int var4 = 0; var4 < var1.b.length; ++var4) {
               if (var1.b[var4] == null) {
                  var1.b[var4] = this.b;
                  var3 = true;
                  break;
               }
            }

            if (!var3) {
               DataCenter.gI().currentScreen.showMessage(Caption.bl, -65536);
               return;
            }
         }

         var2[this.b.index] = null;
      } catch (Exception var5) {
         Utlis.println(var5);
      }
   }

   private void n() {
      LangLa_ar var1;
      Item[] var2 = (var1 = (LangLa_ar)this.s).a;

      int var3;
      for(var3 = 0; var3 < var2.length; ++var3) {
         if (var2[var3] != null && var2[var3].equals(this.b)) {
            Char.gI().h(this.b.TYPE_TEMP)[this.b.index] = this.b;
            var2[var3] = null;
            break;
         }
      }

      var2 = var1.b;

      for(var3 = 0; var3 < var2.length; ++var3) {
         if (var2[var3] != null && var2[var3].equals(this.b)) {
            Char.gI().arrItemBag[this.b.index] = this.b;
            var2[var3] = null;
            return;
         }
      }

   }

   private void o() {
      Item[] var1 = ((LangLa_bv)this.s).a;

      for(int var2 = 0; var2 < var1.length; ++var2) {
         if (var1[var2] != null && var1[var2].equals(this.b)) {
            Char.gI().h(this.b.TYPE_TEMP)[this.b.index] = this.b;
            var1[var2] = null;
            return;
         }
      }

   }

   private void q() {
      Item[] var1 = ((LangLa_bu)this.s).a;

      for(int var2 = 0; var2 < var1.length; ++var2) {
         if (var1[var2] != null && var1[var2].equals(this.b)) {
            Char.gI().h(this.b.TYPE_TEMP)[this.b.index] = this.b;
            var1[var2] = null;
            return;
         }
      }

   }

   private void r() {
      Item[] var1 = ((LangLa_a)this.s).a;

      for(int var2 = 0; var2 < var1.length; ++var2) {
         if (var1[var2] != null && var1[var2].equals(this.b)) {
            Char.gI().h(this.b.TYPE_TEMP)[this.b.index] = this.b;
            var1[var2] = null;
            return;
         }
      }

   }

   private void t() {
      Item[] var1 = ((LangLa_ag)this.s).b;

      for(int var2 = 0; var2 < var1.length; ++var2) {
         if (var1[var2] != null && var1[var2].equals(this.b)) {
            Char.gI().h(this.b.TYPE_TEMP)[this.b.index] = this.b;
            var1[var2] = null;
            return;
         }
      }

   }

   private void u() {
      try {
         boolean var1 = false;
         LangLa_at var2;
         Item[] var3 = (var2 = (LangLa_at)this.s).b(this.b);

         int var4;
         for(var4 = 0; var4 < var2.b.length; ++var4) {
            if (var2.b[var4] != null && var2.b[var4].id == this.b.id) {
               var3[var2.b[var4].index] = var2.b[var4];
               var2.b[var4] = this.b;
               var3[this.b.index] = null;
               return;
            }
         }

         for(var4 = 0; var4 < var2.b.length; ++var4) {
            if (var2.b[var4] == null) {
               var2.b[var4] = this.b;
               var1 = true;
               break;
            }
         }

         if (!var1) {
            DataCenter.gI().currentScreen.showMessage(Caption.fS, -65536);
         } else {
            var3[this.b.index] = null;
         }
      } catch (Exception var5) {
      }
   }

   private void v() {
      Item[] var1 = ((LangLa_at)this.s).b;

      for(int var2 = 0; var2 < var1.length; ++var2) {
         if (var1[var2] != null && var1[var2].equals(this.b)) {
            Char.gI().h(this.b.TYPE_TEMP)[this.b.index] = this.b;
            var1[var2] = null;
            return;
         }
      }

   }

   private void w() {
      try {
         LangLa_as var1;
         Item[] var2 = (var1 = (LangLa_as)this.s).b(this.b);
         if (this.b.getItemTemplate().type == 13) {
            if (var1.a[0] != null) {
               var2[var1.a[0].index] = var1.a[0];
            }

            var1.a[0] = this.b;
            var2[this.b.index] = null;
         } else {
            boolean var3 = false;

            for(int var4 = 0; var4 < var1.b.length; ++var4) {
               if (var1.b[var4] == null) {
                  var1.b[var4] = this.b;
                  var3 = true;
                  break;
               }
            }

            if (!var3) {
               DataCenter.gI().currentScreen.showMessage(Caption.bu, -65536);
               return;
            }
         }

         var2[this.b.index] = null;
      } catch (Exception var5) {
         Utlis.println(var5);
      }
   }

   private void x() {
      LangLa_as var1;
      Item[] var2 = (var1 = (LangLa_as)this.s).a;

      int var3;
      for(var3 = 0; var3 < var2.length; ++var3) {
         if (var2[var3] != null && var2[var3].equals(this.b)) {
            Char.gI().h(this.b.TYPE_TEMP)[this.b.index] = this.b;
            var2[var3] = null;
            break;
         }
      }

      var2 = var1.b;

      for(var3 = 0; var3 < var2.length; ++var3) {
         if (var2[var3] != null && var2[var3].equals(this.b)) {
            Char.gI().arrItemBag[this.b.index] = this.b;
            var2[var3] = null;
            return;
         }
      }

   }

   private void y() {
      try {
         LangLa_al var1;
         Item[] var2 = (var1 = (LangLa_al)this.s).b(this.b);
         if (this.b.isTypeTrangBi()) {
            if (var1.a[0] != null) {
               Char.gI().h(var1.a[0].TYPE_TEMP)[var1.a[0].index] = var1.a[0];
            }

            var1.a[0] = this.b;
         } else {
            boolean var3 = false;

            for(int var4 = 0; var4 < var1.b.length; ++var4) {
               if (var1.b[var4] == null) {
                  var1.b[var4] = this.b;
                  var3 = true;
                  break;
               }
            }

            if (!var3) {
               DataCenter.gI().currentScreen.showMessage(Caption.oz, -65536);
               return;
            }
         }

         var2[this.b.index] = null;
      } catch (Exception var5) {
         Utlis.println(var5);
      }
   }

   private void z() {
      LangLa_al var1;
      Item[] var2 = (var1 = (LangLa_al)this.s).a;

      int var3;
      for(var3 = 0; var3 < var2.length; ++var3) {
         if (var2[var3] != null && var2[var3].equals(this.b)) {
            Char.gI().h(this.b.TYPE_TEMP)[this.b.index] = this.b;
            var2[var3] = null;
            break;
         }
      }

      var2 = var1.b;

      for(var3 = 0; var3 < var2.length; ++var3) {
         if (var2[var3] != null && var2[var3].equals(this.b)) {
            Char.gI().arrItemBag[this.b.index] = this.b;
            var2[var3] = null;
            return;
         }
      }

   }

   private void A() {
      try {
         LangLa_an var1;
         Item[] var2 = (var1 = (LangLa_an)this.s).b(this.b);
         if (this.b.isTypeTrangBi()) {
            if (var1.a[0] != null) {
               Char.gI().h(var1.a[0].TYPE_TEMP)[var1.a[0].index] = var1.a[0];
            }

            var1.a[0] = this.b;
         } else {
            boolean var3 = false;

            for(int var4 = 0; var4 < var1.b.length; ++var4) {
               if (var1.b[var4] == null) {
                  var1.b[var4] = this.b;
                  var3 = true;
                  break;
               }
            }

            if (!var3) {
               DataCenter.gI().currentScreen.showMessage(Caption.oz, -65536);
               return;
            }
         }

         var2[this.b.index] = null;
      } catch (Exception var5) {
         Utlis.println(var5);
      }
   }

   private void B() {
      LangLa_an var1;
      Item[] var2 = (var1 = (LangLa_an)this.s).a;

      int var3;
      for(var3 = 0; var3 < var2.length; ++var3) {
         if (var2[var3] != null && var2[var3].equals(this.b)) {
            Char.gI().h(this.b.TYPE_TEMP)[this.b.index] = this.b;
            var2[var3] = null;
            break;
         }
      }

      var2 = var1.b;

      for(var3 = 0; var3 < var2.length; ++var3) {
         if (var2[var3] != null && var2[var3].equals(this.b)) {
            Char.gI().arrItemBag[this.b.index] = this.b;
            var2[var3] = null;
            return;
         }
      }

   }

   private void C() {
      try {
         LangLa_ak var1;
         Item[] var2 = (var1 = (LangLa_ak)this.s).b(this.b);
         if (this.b.isTypeTrangBi()) {
            if (var1.a[0] != null) {
               Char.gI().h(var1.a[0].TYPE_TEMP)[var1.a[0].index] = var1.a[0];
            }

            var1.a[0] = this.b;
         } else {
            boolean var3 = false;

            for(int var4 = 0; var4 < var1.b.length; ++var4) {
               if (var1.b[var4] == null) {
                  var1.b[var4] = this.b;
                  var3 = true;
                  break;
               }
            }

            if (!var3) {
               DataCenter.gI().currentScreen.showMessage(Caption.oz, -65536);
               return;
            }
         }

         var2[this.b.index] = null;
      } catch (Exception var5) {
         Utlis.println(var5);
      }
   }

   private void D() {
      LangLa_ak var1;
      Item[] var2 = (var1 = (LangLa_ak)this.s).a;

      int var3;
      for(var3 = 0; var3 < var2.length; ++var3) {
         if (var2[var3] != null && var2[var3].equals(this.b)) {
            Char.gI().h(this.b.TYPE_TEMP)[this.b.index] = this.b;
            var2[var3] = null;
            break;
         }
      }

      var2 = var1.b;

      for(var3 = 0; var3 < var2.length; ++var3) {
         if (var2[var3] != null && var2[var3].equals(this.b)) {
            Char.gI().arrItemBag[this.b.index] = this.b;
            var2[var3] = null;
            return;
         }
      }

   }

   private void E() {
      try {
         LangLa_ap var1;
         Item[] var2 = (var1 = (LangLa_ap)this.s).b(this.b);
         if (this.b.isTypeTrangBi()) {
            if (var1.a[0] != null) {
               Char.gI().h(var1.a[0].TYPE_TEMP)[var1.a[0].index] = var1.a[0];
            }

            var1.a[0] = this.b;
         } else {
            boolean var3 = false;

            for(int var4 = 0; var4 < var1.b.length; ++var4) {
               if (var1.b[var4] == null) {
                  var1.b[var4] = this.b;
                  var3 = true;
                  break;
               }
            }

            if (!var3) {
               DataCenter.gI().currentScreen.showMessage(Caption.oz, -65536);
               return;
            }
         }

         var2[this.b.index] = null;
      } catch (Exception var5) {
         Utlis.println(var5);
      }
   }

   private void F() {
      LangLa_ap var1;
      Item[] var2 = (var1 = (LangLa_ap)this.s).a;

      int var3;
      for(var3 = 0; var3 < var2.length; ++var3) {
         if (var2[var3] != null && var2[var3].equals(this.b)) {
            Char.gI().h(this.b.TYPE_TEMP)[this.b.index] = this.b;
            var2[var3] = null;
            break;
         }
      }

      var2 = var1.b;

      for(var3 = 0; var3 < var2.length; ++var3) {
         if (var2[var3] != null && var2[var3].equals(this.b)) {
            Char.gI().arrItemBag[this.b.index] = this.b;
            var2[var3] = null;
            return;
         }
      }

   }

   private void G() {
      try {
         LangLa_ao var1;
         Item[] var2 = (var1 = (LangLa_ao)this.s).b(this.b);
         if (this.b.isTypeTrangBi()) {
            if (var1.a[0] != null) {
               Char.gI().h(var1.a[0].TYPE_TEMP)[var1.a[0].index] = var1.a[0];
            }

            var1.a[0] = this.b;
         } else {
            boolean var3 = false;

            for(int var4 = 0; var4 < var1.b.length; ++var4) {
               if (var1.b[var4] == null) {
                  var1.b[var4] = this.b;
                  var3 = true;
                  break;
               }
            }

            if (!var3) {
               DataCenter.gI().currentScreen.showMessage(Caption.oz, -65536);
               return;
            }
         }

         var2[this.b.index] = null;
      } catch (Exception var5) {
         Utlis.println(var5);
      }
   }

   private void H() {
      LangLa_ao var1;
      Item[] var2 = (var1 = (LangLa_ao)this.s).a;

      int var3;
      for(var3 = 0; var3 < var2.length; ++var3) {
         if (var2[var3] != null && var2[var3].equals(this.b)) {
            Char.gI().h(this.b.TYPE_TEMP)[this.b.index] = this.b;
            var2[var3] = null;
            break;
         }
      }

      var2 = var1.b;

      for(var3 = 0; var3 < var2.length; ++var3) {
         if (var2[var3] != null && var2[var3].equals(this.b)) {
            Char.gI().arrItemBag[this.b.index] = this.b;
            var2[var3] = null;
            return;
         }
      }

   }

   private void I() {
      try {
         boolean var1 = false;
         LangLa_au var2 = (LangLa_au)this.s;

         for(int var3 = 0; var3 < var2.b.length; ++var3) {
            if (var2.b[var3] == null) {
               var2.b[var3] = this.b;
               var1 = true;
               break;
            }
         }

         if (!var1) {
            DataCenter.gI().currentScreen.showMessage(Caption.bl, -65536);
         } else {
            Char.gI().arrItemBag[this.b.index] = null;
         }
      } catch (Exception var4) {
         Utlis.println(var4);
      }
   }

   private void J() {
      LangLa_au var1;
      if ((var1 = (LangLa_au)this.s).a != null && this.b.equals(var1.a)) {
         var1.d(this.b.index);
         var1.a = null;
      } else {
         Item[] var3 = var1.b;

         for(int var2 = 0; var2 < var3.length; ++var2) {
            if (var3[var2] != null && var3[var2].equals(this.b)) {
               Char.gI().arrItemBag[this.b.index] = this.b;
               var3[var2] = null;
               return;
            }
         }

      }
   }

   private void K() {
      try {
         boolean var1 = false;
         LangLa_aj var2 = (LangLa_aj)this.s;

         for(int var3 = 0; var3 < var2.e.length; ++var3) {
            if (var2.e[var3] == null) {
               var2.e[var3] = this.b;
               var1 = true;
               break;
            }
         }

         if (!var1) {
            DataCenter.gI().currentScreen.showMessage(Caption.bD, -65536);
         } else {
            Char.gI().arrItemBag[this.b.index] = null;
         }
      } catch (Exception var4) {
         Utlis.println(var4);
      }
   }

   private void L() {
      Item[] var1 = ((LangLa_aj)this.s).e;

      for(int var2 = 0; var2 < var1.length; ++var2) {
         if (var1[var2] != null && var1[var2].equals(this.b)) {
            Char.gI().arrItemBag[this.b.index] = this.b;
            var1[var2] = null;
            return;
         }
      }

   }

   private void M() {
      try {
         Message var1;
         (var1 = new Message((byte)36)).writeShort(this.b.index);
         var1.send();
      } catch (Exception var2) {
         Utlis.println(var2);
      }
   }

   private void N() {
      try {
         boolean var1 = false;
         LangLa_by var2 = (LangLa_by)this.s;

         for(int var3 = 0; var3 < var2.a.length; ++var3) {
            if (var2.a[var3] == null) {
               var2.a[var3] = this.b;
               var1 = true;
               break;
            }
         }

         if (!var1) {
            DataCenter.gI().currentScreen.showMessage(Caption.fU, -65536);
         } else {
            Char.gI().arrItemBag[this.b.index] = null;
         }
      } catch (Exception var4) {
         Utlis.println(var4);
      }
   }

   private void O() {
      try {
         boolean var1 = false;
         LangLa_kh var2;
         Item[] var3 = (var2 = (LangLa_kh)this.s).b(this.b);
         if (var2.b != 68 && var2.b != 69 && var2.b != 70 && var2.b != 71) {
            for(int var4 = 0; var4 < var2.a.length; ++var4) {
               if (var2.a[var4] == null) {
                  var2.a[var4] = this.b;
                  var1 = true;
                  break;
               }
            }

            if (!var1) {
               DataCenter.gI().currentScreen.showMessage(Caption.fU, -65536);
               return;
            }
         } else {
            if (var2.a[0] != null) {
               Char.gI().h(var2.a[0].TYPE_TEMP)[var2.a[0].index] = var2.a[0];
            }

            var2.a[0] = this.b;
         }

         var3[this.b.index] = null;
      } catch (Exception var5) {
         Utlis.println(var5);
      }
   }

   private void P() {
      try {
         Item[] var1 = ((LangLa_e)this.s).a;
         int var2 = 0;

         while(true) {
            if (var2 >= var1.length) {
               return;
            }

            if (var1[var2] != null && var1[var2].equals(this.b)) {
               Char.gI().h(this.b.TYPE_TEMP)[this.b.index] = this.b;
               var1[var2] = null;
               break;
            }

            ++var2;
         }
      } catch (Exception var3) {
         Utlis.println(var3);
      }

   }

   private void Q() {
      try {
         boolean var1 = false;
         LangLa_d var2 = (LangLa_d)this.s;

         for(int var3 = 0; var3 < var2.a.length; ++var3) {
            if (var2.a[var3] == null) {
               var2.a[var3] = this.b;
               var1 = true;
               break;
            }
         }

         if (!var1) {
            DataCenter.gI().currentScreen.showMessage(Caption.fU, -65536);
         } else {
            Char.gI().arrItemBag[this.b.index] = null;
         }
      } catch (Exception var4) {
         Utlis.println(var4);
      }
   }

   private void U() {
      try {
         Item[] var1 = ((LangLa_d)this.s).a;
         int var2 = 0;

         while(true) {
            if (var2 >= var1.length) {
               return;
            }

            if (var1[var2] != null && var1[var2].equals(this.b)) {
               Char.gI().arrItemBag[this.b.index] = this.b;
               var1[var2] = null;
               break;
            }

            ++var2;
         }
      } catch (Exception var3) {
         Utlis.println(var3);
      }

   }

   private void V() {
      try {
         Item[] var1 = ((LangLa_by)this.s).a;
         int var2 = 0;

         while(true) {
            if (var2 >= var1.length) {
               return;
            }

            if (var1[var2] != null && var1[var2].equals(this.b)) {
               Char.gI().arrItemBag[this.b.index] = this.b;
               var1[var2] = null;
               break;
            }

            ++var2;
         }
      } catch (Exception var3) {
         Utlis.println(var3);
      }

   }

   private void W() {
      try {
         Item[] var1 = ((LangLa_kh)this.s).a;
         int var2 = 0;

         while(true) {
            if (var2 >= var1.length) {
               return;
            }

            if (var1[var2] != null && var1[var2].equals(this.b)) {
               Char.gI().h(this.b.TYPE_TEMP)[this.b.index] = this.b;
               var1[var2] = null;
               break;
            }

            ++var2;
         }
      } catch (Exception var3) {
         Utlis.println(var3);
      }

   }

   private void X() {
      try {
         LangLa_y var1;
         Item[] var2 = (var1 = (LangLa_y)this.s).b(this.b);
         boolean var3 = false;
         if (this.b.v()) {
            if (var1.a[0] != null) {
               Char.gI().h(var1.a[0].TYPE_TEMP)[var1.a[0].index] = var1.a[0];
            }

            var1.a[0] = this.b;
         } else {
            int var4;
            for(var4 = 0; var4 < var1.b.length; ++var4) {
               if (var1.b[var4] != null && var1.b[var4].id != this.b.id) {
                  var1.e();
                  break;
               }
            }

            for(var4 = 0; var4 < var1.b.length; ++var4) {
               if (var1.b[var4] == null) {
                  var1.b[var4] = this.b;
                  var3 = true;
                  break;
               }
            }

            if (!var3) {
               DataCenter.gI().currentScreen.showMessage(Caption.bl, -65536);
               return;
            }
         }

         var2[this.b.index] = null;
      } catch (Exception var5) {
         Utlis.println(var5);
      }
   }

   private void Y() {
      LangLa_y var1;
      Item[] var2 = (var1 = (LangLa_y)this.s).a;

      int var3;
      for(var3 = 0; var3 < var2.length; ++var3) {
         if (var2[var3] != null && var2[var3].equals(this.b)) {
            Char.gI().h(this.b.TYPE_TEMP)[this.b.index] = this.b;
            var2[var3] = null;
            break;
         }
      }

      var2 = var1.b;

      for(var3 = 0; var3 < var2.length; ++var3) {
         if (var2[var3] != null && var2[var3].equals(this.b)) {
            Char.gI().arrItemBag[this.b.index] = this.b;
            var2[var3] = null;
            return;
         }
      }

   }

   private void Z() {
      try {
         boolean var1 = false;
         LangLa_o var2 = (LangLa_o)this.s;

         for(int var3 = 0; var3 < var2.a.length; ++var3) {
            if (var2.a[var3] == null) {
               var2.a[var3] = this.b;
               var1 = true;
               break;
            }
         }

         if (!var1) {
            DataCenter.gI().currentScreen.showMessage(Caption.fU, -65536);
         } else {
            Char.gI().arrItemBag[this.b.index] = null;
         }
      } catch (Exception var4) {
         Utlis.println(var4);
      }
   }

   private void aa() {
      try {
         Item[] var1 = ((LangLa_o)this.s).a;
         int var2 = 0;

         while(true) {
            if (var2 >= var1.length) {
               return;
            }

            if (var1[var2] != null && var1[var2].equals(this.b)) {
               Char.gI().arrItemBag[this.b.index] = this.b;
               var1[var2] = null;
               break;
            }

            ++var2;
         }
      } catch (Exception var3) {
         Utlis.println(var3);
      }

   }

   public LangLa_dz d() {
      for(int var1 = 0; var1 < this.a.length; ++var1) {
         if (this.a[var1].a.equals(Caption.n) || this.a[var1].a.equals(Caption.t) || this.a[var1].a.equals(Caption.qB) || this.a[var1].a.equals(Caption.qD)) {
            return this.a[var1];
         }
      }

      return null;
   }
}
