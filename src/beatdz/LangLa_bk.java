package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_bk extends LangLa_fo {
   private String[] d;
   private Vector e;
   private LangLa_ii f;
   private int g;
   private int[] h;
   public Entity a;
   public int b = -1;
   public int c = -1;
   private String[] i;
   private boolean j;

   private void a(MainScreen var1, String var2, String[] var3) {
      this.p = var1;
      this.r = false;
      this.i = new String[var3.length];

      int var7;
      for(var7 = 0; var7 < var3.length; ++var7) {
         this.i[var7] = "";
      }

      Vector var8 = new Vector();

      int var4;
      String var6;
      for(var4 = 0; var4 < var3.length; ++var4) {
         if (var3[var4].length() > 0) {
            String[] var5;
            var6 = (var5 = Utlis.split(var3[var4], "#"))[0];
            if (var5.length > 2) {
               var6 = var5[0] + var5[2];
               this.i[var4] = var5[1];
            }

            if (LangLa_fw.c(var6) == null) {
               var8.addElement(":-chat" + var6);
            } else {
               var8.addElement(var6);
            }
         }
      }

      this.d = new String[var8.size()];

      for(var4 = 0; var4 < var8.size(); ++var4) {
         this.d[var4] = (String)var8.elementAt(var4);
      }

      this.h = new int[this.d.length];

      for(var4 = 0; var4 < this.h.length; ++var4) {
         int[] var10002 = this.h;
         var10002[var4] = var10002[var4];
      }

      this.a(160, 200);

      int var10;
      for(var10 = 0; var10 < var3.length; ++var10) {
         if (!(var6 = Utlis.split(var3[var10], ",")[0]).contains("#") && (var4 = mFont.c(mFont.d, var6) + 50) > this.width) {
            this.a(var4, this.height);
         }
      }

      if (var2.length() > 0) {
         this.e = mFont.a(mFont.d, var2, this.width - 18);
      } else {
         this.e = new Vector();
      }

      if ((var10 = var3.length + this.e.size()) > 11) {
         var10 = 11;
      }

      int var11 = var10;
      if (var10 > 10) {
         var11 = 10;
         this.j = true;
      }

      var7 = var11 * 17 + 68;
      int var9 = var10 - this.e.size();
      if (var7 < 172) {
         var7 = 172;
      }

      this.a(this.width, var7);
      this.setXY(5 + AppListener.gI().o, DataCenter.gI().heightScreen - this.height - 5);
      if (this.j) {
         this.f = new LangLa_ii((byte)1, 15, this.a_() + this.e.size() * 14 - 8, this.width - 20, 17 * var9, 17, var3.length);
      } else {
         this.f = new LangLa_ii((byte)1, 15, this.a_() + this.e.size() * 14 + 8, this.width - 20, 17 * var9, 17, var3.length);
      }

      this.a(this.width - 67, this.height - 30, Caption.G, this, 1000, -8);
   }

   public LangLa_bk(MainScreen var1, String var2, String[] var3, int[] var4) {
      this.a(var1, var2, var3);
      this.h = new int[this.d.length];

      for(int var5 = 0; var5 < this.h.length; ++var5) {
         this.h[var5] = var4[var5];
      }

   }

   public LangLa_bk(MainScreen var1, String var2, String[] var3, int[] var4, Entity var5) {
      this.a(var1, var2, var3);
      this.a = var5;
      this.h = new int[this.d.length];

      for(int var6 = 0; var6 < this.h.length; ++var6) {
         this.h[var6] = var4[var6];
      }

   }

   public LangLa_bk(MainScreen var1, String var2, String[] var3, int var4) {
      this.a(var1, var2, var3);
      this.c = var4;
   }

   private LangLa_bk(MainScreen var1, String var2, String[] var3, int var4, int var5) {
      this.a(var1, var2, var3);
      this.b = var5;
      this.c = var4;
   }

   public void a(int var1, Object var2, LangLa_cy var3) {
   }

   public void a(int var1, Object var2) {
   }

   public void a(Graphics var1) {
      this.a(var1, this.cx, this.cy, this.width, this.height, "", (byte)2, this.r);
      int var2;
      if (this.j) {
         for(var2 = 0; var2 < this.e.size(); ++var2) {
            mFont.c(mFont.d, var1, (String)this.e.elementAt(var2), 10, this.a_() - 16 + var2 * 14, 0, -1, -16777216);
         }
      } else {
         for(var2 = 0; var2 < this.e.size(); ++var2) {
            mFont.c(mFont.d, var1, (String)this.e.elementAt(var2), 10, this.a_() + 10 + var2 * 14, 0, -1, -16777216);
         }
      }

      this.a(var1, this.f);

      for(var2 = 0; var2 < this.d.length; ++var2) {
         if (this.f.b(var2)) {
            if (var2 == this.f.k) {
               Binary2.a(var1, -7, 0, 20, var2 * this.f.h, this.f.width - 25, (int)this.f.h);
            }

            String var3 = Utlis.split(this.d[var2], ",")[0];
            if (var2 == this.f.l) {
               mFont.c(mFont.d, var1, var3, 1, 8 + var2 * this.f.h, 0, -1, -16777216);
            } else {
               mFont.c(mFont.d, var1, var3, 0, 7 + var2 * this.f.h, 0, -1, -16777216);
            }
         }
      }

      this.b(var1);
   }

   public void b() {
      try {
         this.f.a();
         LangLa_bk var1 = this;
         int var2 = 0;

         int var10000;
         while(true) {
            if (var2 >= var1.d.length) {
               if (GameSrc.gI().Task == 3 && GameSrc.gI().idStep == 0) {
                  var10000 = 1;
                  break;
               }

               if (GameSrc.gI().Task == 9) {
                  var10000 = 1;
                  break;
               }

               if (GameSrc.gI().Task == 10 && (GameSrc.gI().idStep == 0 || GameSrc.gI().idStep == 2)) {
                  var10000 = 1;
                  break;
               }

               var10000 = -1;
               break;
            }

            String var3;
            if ((var3 = Utlis.split(var1.d[var2], ",")[0]).startsWith(":-!") || var3.startsWith(":-?")) {
               var10000 = var2;
               break;
            }

            ++var2;
         }

         int var28 = var10000;
         var2 = -1;
         Step var29;
         if ((var29 = GameSrc.gI().B()) != null) {
            var2 = var29.idNpc;
         }

         Task var30;
         if (var2 == -1 && (var30 = GameSrc.gI().A()) != null) {
            var2 = var30.idNpc;
         }

         Npc var31 = GameSrc.gI().e(var2);
         if (this.p.cD.lastElement().equals(this) && var28 >= 0 && var31 != null && Utlis.getRange2(Char.gI().cx, Char.gI().cy, var31.cx, var31.cy) < 40) {
            if (this.j) {
               DataCenter.gI().aO.a(this.cx + 60, this.cy + this.a_() + 10 + var28 * 14);
            } else {
               DataCenter.gI().aO.a(this.cx + 60, this.cy + this.a_() + 26 + var28 * 14);
            }

            DataCenter.gI().aO.a = true;
         }

         if (this.g > 0) {
            --this.g;
            if (this.g == 0 && this.f.k >= 0 && this.f.k < this.d.length) {
               Message var39;
               if (this.c >= 0) {
                  this.J();
                  if (this.b >= 0) {
                     if (this.c == 30000) {
                        (var39 = new Message((byte)-25)).writeShort(GameSrc.gI().m());
                        var39.writeByte(this.b);
                        var39.writeByte(this.f.k);
                        var39.send();
                        return;
                     }

                     (var39 = new Message((byte)53)).writeShort(this.c);
                     var39.writeByte(this.b);
                     var39.writeByte(this.f.k);
                     var39.send();
                  } else {
                     String[] var40;
                     if ((var40 = Utlis.split(this.d[this.f.k], ",")).length < 2) {
                        Message var38;
                        if (this.c != 30000) {
                           (var38 = new Message((byte)53)).writeShort(this.c);
                           var38.writeByte(this.f.k);
                           var38.send();
                           return;
                        }

                        (var38 = new Message((byte)-25)).writeShort(GameSrc.gI().m());
                        var38.writeByte(this.f.k);
                        var38.send();
                     } else {
                        String[] var37 = new String[var40.length - 1];

                        for(int var35 = 0; var35 < var37.length; ++var35) {
                           var37[var35] = var40[var35 + 1];
                        }

                        GameSrc.gI().a((LangLa_cx)(new LangLa_bk(this.p, this.i[this.f.k], var37, this.c, this.f.k)));
                     }
                  }

                  return;
               }

               if (this.c == -2) {
                  (var39 = new Message((byte)5)).writeByte(this.f.k);
                  var39.send();
                  return;
               }

               if (this.c == -3 || this.c == -4) {
                  (var39 = new Message((byte)53)).writeShort(this.c);
                  var39.writeByte(this.f.k);
                  var39.send();
                  return;
               }

               this.J();
               Message var32;
               Char var33;
               switch(this.h[this.f.k]) {
               case 0:
                  var1 = this;

                  try {
                     if (Char.gI().rank < 2) {
                        DataCenter.gI().currentScreen.showMessage(Utlis.replaceAll(Caption.mx, "2"), -1);
                     } else {
                        var1.p.a((LangLa_cx)(new LangLa_bk(var1.p, "", Caption.rk, new int[]{100, 101})));
                     }
                     break;
                  } catch (Exception var4) {
                     Utlis.println(var4);
                     return;
                  }
               case 1:
                  var1 = this;

                  try {
                     if (Char.gI().rank <= 0) {
                        DataCenter.gI().currentScreen.showMessage(Utlis.replaceAll(Caption.mx, "1"), -1);
                     } else {
                        var1.p.a((LangLa_cx)(new LangLa_bk(var1.p, "", Caption.rl, new int[]{102, 103})));
                     }
                     break;
                  } catch (Exception var5) {
                     Utlis.println(var5);
                     return;
                  }
               case 2:
                  var1 = this;

                  try {
                     if (Char.gI().rank < 3) {
                        DataCenter.gI().currentScreen.showMessage(Utlis.replaceAll(Caption.mx, "3"), -1);
                     } else {
                        var1.p.a((LangLa_cx)(new LangLa_bk(var1.p, "", Caption.rm, new int[]{104, 105})));
                     }
                     break;
                  } catch (Exception var6) {
                     Utlis.println(var6);
                     return;
                  }
               case 3:
                  var1 = this;

                  try {
                     var1.p.a((LangLa_cx)(new LangLa_bk(var1.p, "", Caption.rn, new int[]{106, 107, 127})));
                     break;
                  } catch (Exception var26) {
                     Utlis.println(var26);
                     return;
                  }
               case 4:
                  var1 = this;

                  try {
                     var1.p.a((LangLa_cx)(new LangLa_bk(var1.p, Caption.am, Caption.ro, new int[]{108, 109, 110, 111, 112})));
                     break;
                  } catch (Exception var25) {
                     Utlis.println(var25);
                     return;
                  }
               case 5:
                  var1 = this;

                  try {
                     var1.p.a((LangLa_cx)(new LangLa_bk(var1.p, Caption.J, Caption.rt, new int[]{113, 114, 115, 116, 117})));
                     break;
                  } catch (Exception var24) {
                     Utlis.println(var24);
                     return;
                  }
               case 6:
                  var1 = this;

                  try {
                     var1.p.a((LangLa_cx)(new LangLa_bk(var1.p, Caption.aL, Caption.ru, new int[]{118, 119, 120, 121})));
                     break;
                  } catch (Exception var23) {
                     Utlis.println(var23);
                     return;
                  }
               case 7:
                  e();
                  return;
               case 8:
                  GameSrc.gI();
                  GameSrc.b(8, 0);
                  return;
               case 9:
                  e();
                  return;
               case 10:
                  this.f();
                  return;
               case 11:
                  try {
                     GameSrc.gI();
                     GameSrc.openFunc(86);
                     break;
                  } catch (Exception var22) {
                     Utlis.println(var22);
                     return;
                  }
               case 13:
                  var1 = this;

                  try {
                     var1.p.a((LangLa_cx)(new LangLa_kh(var1.p, Caption.sg, (byte)78)));
                     break;
                  } catch (Exception var21) {
                     Utlis.println(var21);
                     return;
                  }
               case 14:
                  var1 = this;

                  try {
                     var1.p.a((LangLa_cx)(new LangLa_ks(var1.p)));
                     break;
                  } catch (Exception var20) {
                     Utlis.println(var20);
                     return;
                  }
               case 15:
                  var1 = this;

                  try {
                     var1.p.a((LangLa_cx)(new LangLa_ah(var1.p)));
                     break;
                  } catch (Exception var19) {
                     Utlis.println(var19);
                     return;
                  }
               case 16:
                  for(var28 = 0; var28 < GameSrc.gI().vNpc.size(); ++var28) {
                     Npc var36;
                     if ((var36 = (Npc)GameSrc.gI().vNpc.get(var28)).idd == 59) {
                        GameSrc.gI();
                        GameSrc.a(var36);
                        return;
                     }
                  }

                  return;
               case 50:
                  var1 = this;

                  try {
                     var33 = (Char)var1.a;
                     GameSrc.gI();
                     GameSrc.c(var33.name);
                     break;
                  } catch (Exception var18) {
                     Utlis.println(var18);
                     return;
                  }
               case 51:
                  var33 = (Char)this.a;
                  GameSrc.gI();
                  GameSrc.e(var33.name);
                  return;
               case 52:
                  var1 = this;

                  try {
                     var33 = (Char)var1.a;
                     (var32 = new Message((byte)32)).writeUTF(var33.name);
                     var32.send();
                     break;
                  } catch (Exception var17) {
                     Utlis.println(var17);
                     return;
                  }
               case 53:
                  var1 = this;

                  try {
                     beatdz.LangLa_kw.$state_LangLa_kw().d = (var33 = (Char)var1.a).name;
                     LangLa_kq var34 = new LangLa_kq(GameSrc.gI(), 6);
                     GameSrc.gI().a((String)var33.name, (LangLa_ko)var34);
                     break;
                  } catch (Exception var16) {
                     Utlis.println(var16);
                     return;
                  }
               case 54:
                  var1 = this;

                  try {
                     var33 = (Char)var1.a;
                     GameSrc.gI().j(var33.name);
                     break;
                  } catch (Exception var15) {
                     Utlis.println(var15);
                     return;
                  }
               case 55:
                  var1 = this;

                  try {
                     var33 = (Char)var1.a;
                     GameSrc.gI();
                     GameSrc.h(var33.name);
                     break;
                  } catch (Exception var14) {
                     Utlis.println(var14);
                     return;
                  }
               case 58:
                  var1 = this;

                  try {
                     var33 = (Char)var1.a;
                     (var32 = new Message((byte)19)).writeUTF(var33.name);
                     var32.send();
                     break;
                  } catch (Exception var13) {
                     Utlis.println(var13);
                     return;
                  }
               case 59:
                  var1 = this;

                  try {
                     var33 = (Char)var1.a;
                     GameSrc.gI();
                     GameSrc.d(var33.name);
                     break;
                  } catch (Exception var12) {
                     Utlis.println(var12);
                     return;
                  }
               case 60:
                  var1 = this;

                  try {
                     var33 = (Char)var1.a;
                     (var32 = Message.c((byte)-104)).writeUTF(var33.name);
                     var32.send();
                     break;
                  } catch (Exception var11) {
                     Utlis.println(var11);
                     return;
                  }
               case 61:
                  var1 = this;

                  try {
                     var33 = (Char)var1.a;
                     (var32 = Message.c((byte)-105)).writeUTF(var33.name);
                     var32.send();
                     break;
                  } catch (Exception var10) {
                     Utlis.println(var10);
                     return;
                  }
               case 62:
                  var1 = this;

                  try {
                     var33 = (Char)var1.a;
                     GameSrc.gI();
                     GameSrc.f(var33.name);
                     break;
                  } catch (Exception var9) {
                     Utlis.println(var9);
                     return;
                  }
               case 100:
                  GameSrc.gI();
                  GameSrc.openFunc(0);
                  return;
               case 101:
                  GameSrc.gI();
                  GameSrc.openFunc(1);
                  return;
               case 102:
                  GameSrc.gI();
                  GameSrc.openFunc(2);
                  return;
               case 103:
                  GameSrc.gI();
                  GameSrc.openFunc(3);
                  return;
               case 104:
                  GameSrc.gI();
                  GameSrc.openFunc(4);
                  return;
               case 105:
                  GameSrc.gI();
                  GameSrc.openFunc(5);
                  return;
               case 106:
                  GameSrc.gI();
                  GameSrc.openFunc(18);
                  return;
               case 107:
                  GameSrc.gI();
                  GameSrc.openFunc(19);
                  return;
               case 108:
                  GameSrc.gI();
                  GameSrc.b(8, 1);
                  return;
               case 109:
                  GameSrc.gI();
                  GameSrc.b(8, 2);
                  return;
               case 110:
                  GameSrc.gI();
                  GameSrc.b(8, 3);
                  return;
               case 111:
                  GameSrc.gI();
                  GameSrc.b(8, 4);
                  return;
               case 112:
                  GameSrc.gI();
                  GameSrc.b(8, 5);
                  return;
               case 113:
                  GameSrc.gI();
                  GameSrc.b(9, Char.gI().idhe);
                  return;
               case 114:
                  GameSrc.gI();
                  GameSrc.b(10, Char.gI().idhe);
                  return;
               case 115:
                  GameSrc.gI();
                  GameSrc.b(11, Char.gI().idhe);
                  return;
               case 116:
                  GameSrc.gI();
                  GameSrc.b(12, Char.gI().idhe);
                  return;
               case 117:
                  GameSrc.gI();
                  GameSrc.b(13, Char.gI().idhe);
                  return;
               case 118:
                  GameSrc.gI();
                  GameSrc.b(14, Char.gI().idhe);
                  return;
               case 119:
                  GameSrc.gI();
                  GameSrc.b(15, Char.gI().idhe);
                  return;
               case 120:
                  GameSrc.gI();
                  GameSrc.b(16, Char.gI().idhe);
                  return;
               case 121:
                  GameSrc.gI();
                  GameSrc.b(17, Char.gI().idhe);
                  return;
               case 122:
                  GameSrc.gI();
                  GameSrc.openFunc(81);
                  return;
               case 123:
                  GameSrc.gI();
                  GameSrc.openFunc(82);
                  return;
               case 124:
                  GameSrc.gI();
                  GameSrc.openFunc(83);
                  return;
               case 125:
                  GameSrc.gI();
                  GameSrc.openFunc(84);
                  return;
               case 126:
                  GameSrc.gI();
                  GameSrc.openFunc(85);
                  return;
               case 127:
                  GameSrc.gI();
                  GameSrc.openFunc(30);
                  return;
               case 200:
                  GameSrc.gI().a((LangLa_cx)(new LangLa_jf(GameSrc.gI())));
                  return;
               case 201:
                  try {
                     if (Char.gI().rank < 4) {
                        DataCenter.gI().currentScreen.showMessage(Utlis.replaceAll(Caption.mx, "4"), -1);
                     } else {
                        GameSrc.gI();
                        GameSrc.openFunc(50);
                     }
                     break;
                  } catch (Exception var7) {
                     Utlis.println(var7);
                     return;
                  }
               case 202:
                  GameSrc.gI();
                  GameSrc.openFunc(87);
                  return;
               case 203:
                  GameSrc.gI();
                  GameSrc.openFunc(90);
                  return;
               case 204:
                  GameSrc.gI();
                  GameSrc.openFunc(94);
                  return;
               case 205:
                  GameSrc.gI();
                  GameSrc.openFunc(95);
                  return;
               case 206:
                  this.f();
                  return;
               case 207:
                  try {
                     if (Char.gI().rank <= 0) {
                        DataCenter.gI().currentScreen.showMessage(Utlis.replaceAll(Caption.mx, "2"), -1);
                     } else {
                        GameSrc.gI();
                        GameSrc.openFunc(49);
                     }
                     break;
                  } catch (Exception var8) {
                     Utlis.println(var8);
                     return;
                  }
               case 208:
                  GameSrc.gI();
                  GameSrc.openFunc(99);
                  return;
               case 900:
                  this.p.a((LangLa_cx)(new LangLa_w(this.p)));
                  return;
               case 901:
                  GameSrc.gI().l(Caption.iv).cG.clear();
                  beatdz.CheckVersionScreen.$state_CheckVersionScreen().b = true;
                  AppListener.$state_AppListener().h = 50;
                  return;
               case 902:
                  DataCenter.gI().currentScreen.a(Caption.iw, 2991, DataCenter.gI().currentScreen);
                  return;
               case 903:
                  GameSrc.gI();
                  GameSrc.openFunc(56);
                  return;
               case 904:
                  this.p.a((LangLa_cx)(new LangLa_i(this.p)));
                  return;
               case 905:
                  this.p.a((LangLa_cx)(new LangLa_m(this.p)));
               }
            }
         }

      } catch (Exception var27) {
         Utlis.println(var27);
      }
   }

   public Vector c() {
      Vector var1;
      (var1 = super.c()).addElement(this.f.a(1001, this));
      return var1;
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      switch(var1.b) {
      case 1000:
         this.J();
         return;
      case 1001:
         if (var1.j.k >= 0) {
            this.g = 3;
         }
      default:
      }
   }

   private static void e() {
      try {
         GameSrc.gI();
         GameSrc.openFunc(50);
      } catch (Exception var1) {
         Utlis.println(var1);
      }
   }

   private void f() {
      try {
         if (Char.gI().rank < 5) {
            DataCenter.gI().currentScreen.showMessage(Utlis.replaceAll(Caption.mx, "5"), -1);
         } else {
            this.p.a((LangLa_cx)(new LangLa_bk(this.p, "", Caption.rx, new int[]{122, 123, 124, 125, 126, 202, 203, 204, 205})));
         }
      } catch (Exception var2) {
         Utlis.println(var2);
      }
   }
}
