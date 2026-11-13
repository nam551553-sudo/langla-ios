package beatdz;
import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_mg extends LangLa_cs {
   public LangLa_ii a;
   public LangLa_lk[] b;
   public Vector c = new Vector();
   private boolean e;
   private boolean f;
   
   private boolean h;
   private String i = "";
   private int j = -1;
   

   public LangLa_mg(int var1, int var2, int var3, int var4, LangLa_cx var5) {
      this.setXY(var1, var2);
      this.setSize(90, 31);
      this.s = var5;
      this.a = new LangLa_ii((byte)1, 0, 0, 90, 54, 9, 0);
      this.d();
   }

   public void a() {
      mConfig.gI().writeBoolean(13, !mConfig.gI().readBoolean(13));
      LangLa_dp.a().h();
      this.d();
   }

   public void c(boolean var1) {
      mConfig.gI().writeBoolean(13, var1);
      this.d();
   }

   public void d() {
      this.c.clear();
      this.j = -1;
      Vector var1 = new Vector();
      if (!mConfig.gI().readBoolean(13)) {
         this.i = Caption.iI;
         Task var2 = GameSrc.gI().A();
         if (var2 != null) {
            var1.addElement("c#cyan" + this.i + "c#white" + var2.name);
            NpcTemplate var3 = DataCenter.gI().NpcTemplate[var2.idNpc];
            if (GameSrc.gI().idStep < 0) {
               var1.addElement("c#white" + Caption.iJ + "c#task" + var3.name + "c#white" + Caption.iL);
               this.c.addElement(new LangLa_eo(var2.idNpc, -1, -1, var2.idMap, var2.x, var2.y));
            } else if (Char.gI().level() < var2.levelNeed) {
               var1.addElement("c#red" + Caption.iM + var2.levelNeed);
            } else if (GameSrc.gI().idStep >= var2.vStep.size()) {
               var1.addElement("c#white" + Caption.iJ + "c#task" + var3.name + "c#white" + Caption.iP);
               this.c.addElement(new LangLa_eo(var2.idNpc, -1, -1, var2.idMap, var2.x, var2.y));
            } else {
               Step var4 = (Step)var2.vStep.elementAt(GameSrc.gI().idStep);
               this.c.addElement(new LangLa_eo(var4.idNpc, var4.b(), var4.idMob, var4.idMap, var4.x, var4.y));
               if (var4.require <= 1) {
                  var1.addElement("c#blue" + "- c#task" + var4.name);
               } else {
                  var1.addElement("c#blue" + "- c#task" + var4.name + " " + GameSrc.gI().idRequire + "/" + var4.require);
               }
            }
         } else {
            var1.addElement("c#cyan" + this.i + "c#white" + Caption.iK);
         }
      } else {
         this.i = Caption.ll;
         if (beatdz.LangLa_mg.$state_LangLa_mg().d == 0) {
            if (!a(var1, this.c, this.i) && !b(var1, this.c, this.i) && !c(var1, this.c, this.i)) {
               var1.addElement("c#yellow" + this.i + "c#white" + Caption.iR);
            }
         } else if (beatdz.LangLa_mg.$state_LangLa_mg().d == 1) {
            if (!b(var1, this.c, this.i) && !a(var1, this.c, this.i) && !c(var1, this.c, this.i)) {
               var1.addElement("c#yellow" + this.i + "c#white" + Caption.iR);
            }
         } else if (beatdz.LangLa_mg.$state_LangLa_mg().d == 2) {
            if (!c(var1, this.c, this.i) && !a(var1, this.c, this.i) && !b(var1, this.c, this.i)) {
               var1.addElement("c#yellow" + this.i + "c#white" + Caption.iR);
            }
         } else if (beatdz.LangLa_mg.$state_LangLa_mg().d == 3) {
            if (!d(var1, this.c, this.i) && !e(var1, this.c, this.i) && !f(var1, this.c, this.i) && !a(var1, this.c, this.i) && !b(var1, this.c, this.i) && !c(var1, this.c, this.i)) {
               var1.addElement("c#yellow" + this.i + "c#white" + Caption.iR);
            }
         } else if (beatdz.LangLa_mg.$state_LangLa_mg().d == 4) {
            if (!e(var1, this.c, this.i) && !f(var1, this.c, this.i) && !d(var1, this.c, this.i) && !a(var1, this.c, this.i) && !b(var1, this.c, this.i) && !c(var1, this.c, this.i)) {
               var1.addElement("c#yellow" + this.i + "c#white" + Caption.iR);
            }
         } else if (beatdz.LangLa_mg.$state_LangLa_mg().d == 5 && !f(var1, this.c, this.i) && !e(var1, this.c, this.i) && !d(var1, this.c, this.i) && !a(var1, this.c, this.i) && !b(var1, this.c, this.i) && !c(var1, this.c, this.i)) {
            var1.addElement("c#yellow" + this.i + "c#white" + Caption.iR);
         }
      }

      Vector var9 = new Vector();
      int var12 = -1;

      int var5;
      int var7;
      for(var5 = 0; var5 < var1.size(); ++var5) {
         String var10;
         if ((var10 = String.valueOf(var1.elementAt(var5))).contains("c#task")) {
            ++var12;
         }

         Vector var6 = mFont.a(mFont.b, var10, this.a.width - 8);
         var7 = 0;

         for(int var8 = 0; var8 < var6.size(); ++var8) {
            if ((var10 = (String)var6.elementAt(var8)).contains("c#task")) {
               ++var7;
            }

            var9.add(new LangLa_lk(1, var10));
         }

         if (var7 > 1) {
            LangLa_eo var14 = (LangLa_eo)this.c.elementAt(var12);

            for(int var11 = 1; var11 < var7; ++var11) {
               this.c.insertElementAt(var14, var12);
               ++var12;
            }
         }
      }

      var5 = 0;
      this.b = new LangLa_lk[var9.size()];

      int var13;
      for(var13 = 0; var13 < var9.size(); ++var13) {
         this.b[var13] = (LangLa_lk)var9.elementAt(var13);
         if (this.b[var13].b.contains("c#red")) {
            this.j = var13;
         }

         mFont var10000 = mFont.b;
         if ((var7 = mFont.c(mFont.b, this.b[var13].b)) > var5) {
            var5 = var7;
         }
      }

      if ((var13 = this.b.length) < 3) {
         var13 = 3;
      }

      this.setSize(var5 + 10, var13 * 11);
      this.a.a(this.a.g, this.a.h, this.b.length);
      this.h = false;
   }

   public static boolean a(Vector var0, Vector var1, String var2) {
      if (Char.gI().I > 0) {
         var0.addElement("c#yellow" + var2 + "c#white" + Caption.iN + (10 - Char.gI().I) + "/10");
         if (GameSrc.gI().aS == null) {
            var0.addElement("c#white" + Caption.iJ + "c#task" + DataCenter.gI().NpcTemplate[102].name + "c#white" + Caption.iL);
            var1.addElement(new LangLa_eo(102, -1, -1, -1, 0, 0));
         } else {
            var2 = GameSrc.gI().aS.m;
            if (GameSrc.gI().aS.j > 1) {
               var2 = var2 + " " + GameSrc.gI().aS.c + "/" + GameSrc.gI().aS.j;
               if (GameSrc.gI().aS.b == 12) {
                  var2 = var2 + "c#white (" + DataCenter.gI().MapTemplate[GameSrc.gI().aS.g].name + ")";
               }
            }

            if (GameSrc.gI().aS.a()) {
               var0.addElement("c#white" + Caption.iJ + "c#task" + DataCenter.gI().NpcTemplate[102].name + "c#white" + Caption.iP);
               var1.addElement(new LangLa_eo(102, -1, -1, -1, 0, 0));
            } else {
               var0.addElement("c#blue" + "  - c#task" + var2);
               var1.addElement(new LangLa_eo(GameSrc.gI().aS.e, GameSrc.gI().aS.d, GameSrc.gI().aS.f, GameSrc.gI().aS.g, GameSrc.gI().aS.h, GameSrc.gI().aS.i));
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public static boolean b(Vector var0, Vector var1, String var2) {
      if (Char.gI().J > 0) {
         var0.addElement("c#yellow" + var2 + "c#white" + Caption.iQ + (Char.gI().K - Char.gI().J) + "/" + Char.gI().K);
         if (GameSrc.gI().aT == null) {
            var0.addElement("c#white" + Caption.iJ + "c#task" + DataCenter.gI().NpcTemplate[98].name + "c#white" + Caption.iL);
            var1.addElement(new LangLa_eo(98, -1, -1, -1, 0, 0));
         } else {
            var2 = GameSrc.gI().aT.m;
            if (GameSrc.gI().aT.a()) {
               var0.addElement("c#white" + Caption.iJ + "c#task" + DataCenter.gI().NpcTemplate[98].name + "c#white" + Caption.iP);
               var1.addElement(new LangLa_eo(98, -1, -1, -1, 0, 0));
            } else {
               var0.addElement("c#blue" + "- c#task" + var2);
               var1.addElement(new LangLa_eo(GameSrc.gI().aT.e, GameSrc.gI().aT.d, GameSrc.gI().aT.f, GameSrc.gI().aT.g, GameSrc.gI().aT.h, GameSrc.gI().aT.i));
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public static boolean c(Vector var0, Vector var1, String var2) {
      if (Char.gI().level() >= 20 && Char.gI().idClass > 0) {
         if (GameSrc.gI().aX == null) {
            var0.addElement("c#yellow" + var2 + "c#white" + Caption.lT);
            var0.addElement("c#white" + Caption.iJ + "c#task" + DataCenter.gI().NpcTemplate[100].name + "c#white" + Caption.iL);
            var1.addElement(new LangLa_eo(100, -1, -1, -1, 0, 0));
         } else if (!GameSrc.gI().aX.c) {
            var0.addElement("c#yellow" + var2 + "c#white" + Caption.lT);
            var2 = GameSrc.gI().aX.a().name;
            if (GameSrc.gI().aX.a().c > 1) {
               var2 = var2 + " " + GameSrc.gI().aX.b + "/" + GameSrc.gI().aX.a().c;
            }

            if (GameSrc.gI().aX.b()) {
               var0.addElement("c#white" + Caption.iJ + "c#task" + DataCenter.gI().NpcTemplate[100].name + "c#white" + Caption.iP);
               var1.addElement(new LangLa_eo(100, -1, -1, -1, 0, 0));
            } else {
               var0.addElement("c#green" + " - c#task" + var2);
               var1.addElement(new LangLa_eo(-1, -1, -1, -2, 0, 0));
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public static boolean d(Vector var0, Vector var1, String var2) {
      if (GameSrc.gI().aU != null) {
         var0.addElement("c#yellow" + var2 + "c#white" + Caption.oJ);
         if (GameSrc.gI().aU.a()) {
            var0.addElement("c#white" + Caption.iJ + "c#task" + DataCenter.gI().NpcTemplate[76].name + "c#white" + Caption.iP);
            var1.addElement(new LangLa_eo(76, -1, -1, GameSrc.gI().aU.g, 0, 0));
         } else {
            var0.addElement("c#green" + "- c#task" + Caption.oK + " " + DataCenter.gI().NpcTemplate[GameSrc.gI().aU.e].name);
            var1.addElement(new LangLa_eo(GameSrc.gI().aU.e, -1, -1, GameSrc.gI().aU.g, 0, 0));
         }

         return true;
      } else {
         return false;
      }
   }

   public static boolean e(Vector var0, Vector var1, String var2) {
      if (GameSrc.gI().aV != null) {
         var0.addElement("c#yellow" + var2 + "c#white" + Caption.oQ);
         if (GameSrc.gI().aV.a()) {
            var0.addElement("c#white" + Caption.iJ + "c#task" + DataCenter.gI().NpcTemplate[76].name + "c#white" + Caption.iP);
            var1.addElement(new LangLa_eo(76, -1, -1, GameSrc.gI().aV.g, 0, 0, 4));
         } else {
            var0.addElement("c#green" + "- c#task" + Utlis.replaceAll(Caption.oR, DataCenter.gI().NpcTemplate[GameSrc.gI().aV.e].name));
            var1.addElement(new LangLa_eo(-1, -1, -1, GameSrc.gI().aV.g, 0, 0, 4));
         }

         return true;
      } else {
         return false;
      }
   }

   public static boolean f(Vector var0, Vector var1, String var2) {
      if (GameSrc.gI().aW != null) {
         var0.addElement("c#yellow" + var2 + "c#white" + Caption.pT);
         if (GameSrc.gI().aW.a()) {
            var0.addElement("c#white" + Caption.iJ + "c#task" + DataCenter.gI().NpcTemplate[73].name + "c#white" + Caption.iL);
            var1.addElement(new LangLa_eo(73, -1, -1, 86, 0, 0, 5));
         } else {
            var0.addElement("c#green" + "- c#task" + Utlis.replaceAll(Caption.pU, DataCenter.gI().MobTemplate[GameSrc.gI().aW.f].name));
            var1.addElement(new LangLa_eo(-1, -1, -1, -1, 0, 0, 4));
         }

         return true;
      } else {
         return false;
      }
   }

   public void a(Graphics var1) {
      try {
         if (!this.h) {
            Binary.cleanImage(beatdz.LangLa_mg.$state_LangLa_mg().g);
            int zoom = DataCenter.gI().zoomLevel;
            mImage background = mImage.a(this.width * zoom, this.height * zoom);
            beatdz.LangLa_mg.$state_LangLa_mg().g = background;
            if (background != null) {
               GameSrc.drawHudPanel(background.b, 0, 0, this.width, this.height);
               Binary.disposeImage(background);
               this.h = true;
            }
         }

         var1.a(beatdz.LangLa_mg.$state_LangLa_mg().g, 0, 0);

         for(int var4 = 0; var4 < this.b.length; ++var4) {
            if (this.a.b(var4)) {
               mFont.d(mFont.b, var1, this.b[var4].b, 6, var4 * this.a.h + this.a.h / 2 + 2, 0, -1, -10275328);
            }
         }

      } catch (Exception var3) {
      }
   }

   public void b() {
      if (this.a != null) {
         this.a.a();
      }

      MainScreen var2;
      if (((var2 = (MainScreen)this.s).cD.size() > 0 && this.i.equals(Caption.iI) && var2.cD.lastElement().equals(GameSrc.gI()) || var2.cD.size() == 2 && var2.cD.lastElement() instanceof LangLa_dl) && (GameSrc.gI().Task <= 12 || GameSrc.gI().Task == 14)) {
         int var10001;
         if (GameSrc.gI().idStep == -1) {
            var10001 = this.cx + 60;
            DataCenter.gI().aO.a(var10001, this.cy + 15);
            DataCenter.gI().aO.a = true;
         }

         Step var5 = GameSrc.gI().B();
         Task var3 = GameSrc.gI().A();
         this.e = false;
         label322:
         switch(GameSrc.gI().Task) {
         case 0:
            DataCenter.gI().aO.a = false;
            switch(GameSrc.gI().idStep) {
            case -1:
               var10001 = this.cx + 60;
               DataCenter.gI().aO.a(var10001, this.cy + 15);
               DataCenter.gI().aO.a = true;
            case 0:
            case 1:
            default:
               break label322;
            case 2:
               var10001 = this.cx + 60;
               DataCenter.gI().aO.a(var10001, this.cy + 15);
               DataCenter.gI().aO.a = true;
               if ((var5 == null || Char.gI().cx != var5.x || Char.gI().cy != var5.y) && GameSrc.gI().idRequire <= 0) {
                  this.e = false;
                  break label322;
               }

               this.e = true;
               break label322;
            case 3:
               this.a(60);
               break label322;
            }
         case 1:
            switch(GameSrc.gI().idStep) {
            case -1:
               var10001 = this.cx + 60;
               DataCenter.gI().aO.a(var10001, this.cy + 15);
               DataCenter.gI().aO.a = true;
               break label322;
            case 0:
               if ((var5 == null || Char.gI().cx != var5.x || Char.gI().cy != var5.y) && GameSrc.gI().idRequire <= 0) {
                  var10001 = this.cx + 50;
                  DataCenter.gI().aO.a(var10001, this.cy + 15);
                  DataCenter.gI().aO.a = true;
                  break label322;
               }

               this.e = true;
               break label322;
            case 1:
               this.a(60);
               if ((var5 == null || Char.gI().cx != var5.x || Char.gI().cy != var5.y) && GameSrc.gI().idRequire <= 0) {
                  this.e = false;
                  break label322;
               }

               this.e = true;
               break label322;
            case 2:
               this.e = false;
            default:
               break label322;
            }
         case 2:
            if (GameSrc.gI().Task == 8) {
               var10001 = this.cx + 50;
               DataCenter.gI().aO.a(var10001, this.cy + 55);
               DataCenter.gI().aO.a = true;
            }

            if (GameSrc.gI().idStep == 0) {
               if (Char.gI().level() < var3.levelNeed) {
                  DataCenter.gI().aO.a = false;
               } else {
                  if ((var5 == null || Char.gI().cx != var5.x || Char.gI().cy != var5.y) && GameSrc.gI().idRequire <= 0) {
                     var10001 = this.cx + 40;
                     DataCenter.gI().aO.a(var10001, this.cy + 15);
                     DataCenter.gI().aO.a = true;
                     break;
                  }

                  this.e = true;
               }
            } else if (GameSrc.gI().idStep == 1) {
               this.a(40);
            }
            break;
         case 3:
            switch(GameSrc.gI().idStep) {
            case 0:
               if (Char.gI().level() < GameSrc.gI().A().levelNeed) {
                  DataCenter.gI().aO.a = false;
               } else {
                  if ((var5 == null || Char.gI().cx != var5.x || Char.gI().cy != var5.y) && GameSrc.gI().idRequire <= 0) {
                     this.a(40);
                     break label322;
                  }

                  this.e = true;
               }
               break label322;
            case 1:
               DataCenter.gI().aO.a = false;
               break label322;
            case 2:
            default:
               this.a(40);
               break label322;
            case 3:
               var10001 = this.cx + 50;
               DataCenter.gI().aO.a(var10001, this.cy + 15);
               DataCenter.gI().aO.a = true;
               if ((var5 == null || Char.gI().cx != var5.x || Char.gI().cy != var5.y) && GameSrc.gI().idRequire <= 0) {
                  this.a(40);
                  break label322;
               }

               this.e = true;
               break label322;
            }
         case 4:
            switch(GameSrc.gI().idStep) {
            case 0:
               var10001 = this.cx + 30;
               DataCenter.gI().aO.a(var10001, this.cy + 15);
               if (Char.gI().level() < var3.levelNeed) {
                  DataCenter.gI().aO.a = false;
               } else {
                  if ((var5 == null || Char.gI().cx != var5.x || Char.gI().cy != var5.y) && GameSrc.gI().idRequire <= 0) {
                     this.a(25);
                     break label322;
                  }

                  this.e = true;
               }
               break label322;
            case 1:
               if (GameSrc.gI().ar) {
                  this.e = true;
               } else {
                  this.a(25);
               }
               break label322;
            default:
               this.a(25);
               break label322;
            }
         case 5:
            if (GameSrc.gI().idStep == 0) {
               if (Char.gI().level() < var3.levelNeed) {
                  DataCenter.gI().aO.a = false;
               }

               if ((var5 == null || Char.gI().cx != var5.x || Char.gI().cy != var5.y) && GameSrc.gI().idRequire <= 0) {
                  this.a(40);
               } else {
                  this.e = true;
               }
            } else if (GameSrc.gI().idStep == 3) {
               DataCenter.gI().aO.a = false;
            } else {
               this.a(40);
            }
         case 6:
         case 7:
            if (GameSrc.gI().idStep < 0) {
               break;
            }

            var10001 = this.cx + 40;
            DataCenter.gI().aO.a(var10001, this.cy + 15);
            if (Char.gI().level() < var3.levelNeed) {
               DataCenter.gI().aO.a = false;
            } else {
               if ((var5 == null || Char.gI().cx != var5.x || Char.gI().cy != var5.y) && GameSrc.gI().idRequire <= 0) {
                  this.a(40);
                  break;
               }

               this.e = true;
            }
            break;
         case 8:
            switch(GameSrc.gI().idStep) {
            case 0:
            case 1:
               if (Char.gI().level() < var3.levelNeed) {
                  DataCenter.gI().aO.a = false;
               } else {
                  if ((var5 == null || Char.gI().cx != var5.x || Char.gI().cy != var5.y) && GameSrc.gI().idRequire <= 0) {
                     this.a(40);
                     break label322;
                  }

                  this.e = true;
               }
               break label322;
            case 9:
            case 10:
               DataCenter.gI().aO.a = false;
               break label322;
            default:
               this.a(40);
               break label322;
            }
         case 9:
            var10001 = this.cx + 50;
            DataCenter.gI().aO.a(var10001, this.cy + 15);
            DataCenter.gI().aO.a = true;
            if (GameSrc.gI().idStep != 0 && GameSrc.gI().idStep != 1 && GameSrc.gI().idStep != 2 && GameSrc.gI().idStep != 4) {
               this.a(40);
            } else if (Char.gI().level() < var3.levelNeed) {
               DataCenter.gI().aO.a = false;
            } else {
               if ((var5 == null || Char.gI().cx != var5.x || Char.gI().cy != var5.y) && GameSrc.gI().idRequire <= 0) {
                  this.a(40);
                  break;
               }

               this.e = true;
            }
            break;
         case 10:
            this.e = (GameSrc.gI().idStep == 2 || GameSrc.gI().idStep == 4) && GameSrc.gI().idRequire > 0;
            if (!this.e) {
               var10001 = this.cx + 40;
               DataCenter.gI().aO.a(var10001, this.cy + 22);
               DataCenter.gI().aO.a = true;
            }
            break;
         case 11:
            switch(GameSrc.gI().idStep) {
            case 0:
            case 1:
            case 2:
               this.e = var5 != null && Char.gI().cx == var5.x && Char.gI().cy == var5.y || GameSrc.gI().idRequire > 0;
               if (this.e) {
                  break;
               }
            default:
               var10001 = this.cx + 40;
               DataCenter.gI().aO.a(var10001, this.cy + 15);
               DataCenter.gI().aO.a = true;
            }

            DataCenter.gI().aO.a = true;
            break;
         case 12:
            switch(GameSrc.gI().idStep) {
            case -1:
               var10001 = this.cx + 35;
               DataCenter.gI().aO.a(var10001, this.cy + 15);
               DataCenter.gI().aO.a = true;
               break;
            case 1:
               DataCenter.gI().aO.a = false;
               break;
            default:
               var10001 = this.cx + 40;
               DataCenter.gI().aO.a(var10001, this.cy + 15);
               DataCenter.gI().aO.a = true;
            }
         case 13:
         default:
            break;
         case 14:
            switch(GameSrc.gI().idStep) {
            case 0:
               if (Char.gI().level() < var3.levelNeed) {
                  DataCenter.gI().aO.a = false;
               } else {
                  var10001 = this.cx + 50;
                  DataCenter.gI().aO.a(var10001, this.cy + 15);
                  DataCenter.gI().aO.a = true;
               }
               break;
            case 1:
               var10001 = this.cx + 25;
               DataCenter.gI().aO.a(var10001, this.cy + 15);
               DataCenter.gI().aO.a = true;
               break;
            case 2:
               DataCenter.gI().aO.a = false;
               break;
            default:
               var10001 = this.cx + 40;
               DataCenter.gI().aO.a(var10001, this.cy + 15);
               DataCenter.gI().aO.a = true;
            }
         }

         if (!this.f && GameSrc.gI().W == 1) {
            var10001 = this.cx + 30;
            DataCenter.gI().aO.a(var10001, this.cy + 10);
            DataCenter.gI().aO.a = true;
            return;
         }

         if (GameSrc.gI().W == 1 || this.e) {
            DataCenter.gI().aO.a = false;
         }
      }

   }

   private void a(int var1) {
      this.e = false;
      int var10001 = this.cx + var1;
      DataCenter.gI().aO.a(var10001, this.cy + 15);
      DataCenter.gI().aO.a = true;
   }

   public Vector c() {
      Vector var1 = new Vector();
      if (!GameSrc.gI().S.c()) {
         return var1;
      } else {
         if (this.c.size() != 0) {
            var1.addElement(new LangLa_jz(4000, 0, 0, this.width, this.height, this.a, this));
         } else if (this.j >= 0) {
            var1.addElement(new LangLa_jz(4002, 0, 0, this.width, this.height, this.a, this));
         }

         return var1;
      }
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      switch(var1.b) {
      case 4000:
         SettingsTab.gI().a(false);
         if (GameSrc.gI().Task == 22 && !mConfig.gI().readBoolean(13)) {
            Vector var4;
            if (GameSrc.gI().idStep == 0) {
               if (GameSrc.gI().aT != null) {
                  beatdz.LangLa_mg.$state_LangLa_mg().d = 1;
                  this.a();
                  var4 = new Vector();
                  b(new Vector(), var4, "");
                  if (var4.size() > 0) {
                     GameSrc.gI().aR = (LangLa_eo)var4.get(0);
                  }

                  return;
               }

               this.b(0);
               return;
            }

            if (GameSrc.gI().idStep == 1) {
               if (GameSrc.gI().aX != null) {
                  beatdz.LangLa_mg.$state_LangLa_mg().d = 0;
                  this.a();
                  var4 = new Vector();
                  a(new Vector(), var4, "");
                  if (var4.size() > 0) {
                     GameSrc.gI().aR = (LangLa_eo)var4.get(0);
                  }

                  return;
               }

               this.b(0);
               return;
            }

            this.b(0);
            return;
         }

         this.b(0);
         return;
      case 4001:
         this.a();
         return;
      case 4002:
         DataCenter.gI().currentScreen.a("Hiện tại bạn chưa đủ cấp để làm tiếp nhiệm vụ chính tuyến, bạn có muốn chuyển sang giao diện phụ tuyến để tiếp tục làm nhiệm vụ khác không?", 2100, GameSrc.gI());
      default:
      }
   }

   public void s() {
      super.s();
      this.cP.b = -1;
   }

   private LangLa_eo b(int var1) {
      LangLa_eo var5 = null;

      try {
         LangLa_eo var2;
         if ((var2 = (LangLa_eo)this.c.elementAt(0)).a >= 0) {
            if (GameSrc.gI().e(var2.a) != null) {
               var2.d = GameSrc.gI().mapID;
            }

            if (var2.d < 0) {
               GameSrc.gI();
               GameSrc.c(var2);
            }
         }

         var5 = var2.a();
         GameSrc.gI().b(var5);
      } catch (Exception var4) {
         Utlis.println(var4);
      }

      return var5;
   }

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public mImage g;
public int d;
public void initialize() {
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.LangLa_mg");
public static SessionState $state_LangLa_mg() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
