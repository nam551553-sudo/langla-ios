package beatdz;import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Application.ApplicationType;
import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_kt extends ScreenLogin {
   private LangLa_dz a;
   private LangLa_dz b;
   private int c;
   private int d;
   private int e = 0;
   private int f;
   private int g;
   private boolean h;
   private Vector i;
   
   private LangLa_dz k;
   private long l;

   public LangLa_kt() {
      beatdz.LangLa_kt.$state_LangLa_kt().j = this;
      this.c = this.width / 2;
      this.d = this.height / 2;
      this.f = this.c - 25;
      this.g = this.d;
      this.a(AppListener.gI().o, this.d, "", this, 1002, 59);
      this.a = this.a(this.c - 60, this.g + 10, "", this, 1004, -10);
      this.b = this.a(this.a.cx + this.a.width + 5, this.a.cy + 2, "", this, 1004, 12);
      this.a(this.c - 50, this.g + 60, Caption.P, this, 1001, 13);
      this.i = new Vector();
   }

   public void j() {
   }

   public void b() {
      super.b();
      LangLa_kt var1 = this;
      LangLa_dz var2;
      int var3;
      if (this.e == 1) {
         for(var3 = 0; var3 < var1.i.size(); ++var3) {
            if ((var2 = (LangLa_dz)var1.i.elementAt(var3)).v) {
               var2.b(false);
            }

            if (var2.cy > var1.k.cy - (var3 + 1) * 22) {
               var2.cy = (short)(var2.cy - 4 * (var3 + 1));
            } else {
               var2.cy = (short)(var1.k.cy - (var3 + 1) * 22);
               if (var3 == var1.i.size() - 1) {
                  var1.e = 2;
               }
            }
         }
      } else if (this.e == -1) {
         for(var3 = 0; var3 < var1.i.size(); ++var3) {
            if ((var2 = (LangLa_dz)var1.i.elementAt(var3)).cy + 4 * (var3 + 1) < var1.k.cy) {
               var2.cy = (short)(var2.cy + 4 * (var3 + 1));
            } else {
               var2.cy = var1.k.cy;
               var2.b(true);
               if (var3 == var1.i.size() - 1) {
                  var1.e = -2;
               }
            }
         }
      }

      LangLa_dz var10000 = this.a;
      String var5 = DataCenter.gI().aP.getName();
      var10000.a = var5;
      if (!this.h) {
         this.h = true;
         DataCenter.gI();
         DataCenter.i();
      }

      if (beatdz.DataCenter.$state_DataCenter().ar) {
         this.b.b(true);
         this.a.a(true);
         this.a.setXY(this.c - this.a.width / 2, this.a.cy);
      }

      long var4 = System.currentTimeMillis();
      if (beatdz.DataCenter.$state_DataCenter().aR > 0) {
         if (var4 - this.l > 30000L) {
            this.l = var4;
            this.a();
            return;
         }

         if (((var4 - this.l) / 1000L + 2L) % 5L == 0L) {
            this.a(Caption.oU, (int)(31L - (var4 - this.l) / 1000L));
         }
      }

   }

   public void p() {
   }

   public void a(Graphics var1) {
      if (AppListener.$state_AppListener().h > 0) {
         --AppListener.$state_AppListener().h;
         if (AppListener.$state_AppListener().h == 0) {
            DataCenter.gI().g();
            return;
         }
      }

      super.a(var1);
      if (!beatdz.DataCenter.$state_DataCenter().ar && Gdx.app.getType() != ApplicationType.iOS) {
         LangLa_fq.a(var1, 37, 0, this.c, this.g - 25, 33);
      }

      if (beatdz.DataCenter.$state_DataCenter().ar) {
         mFont.b(mFont.e, var1, Caption.e, this.c, this.a.cy - 12, 2, -2560, -16742145);
      } else {
         mFont.b(mFont.e, var1, Caption.lz, this.c, this.a.cy - 12, 2, -2560, -16742145);
      }

      if (this.e == 2) {
         for(int var2 = 0; var2 < this.i.size(); ++var2) {
            LangLa_dz var3;
            if ((var3 = (LangLa_dz)this.i.elementAt(var2)).a()) {
               mFont.b(mFont.d, var1, Caption.rV[var2], var3.cx - 4, var3.cy + 9, 1, -1, -16777216);
            } else {
               mFont.b(mFont.d, var1, Caption.rV[var2], var3.cx - 5, var3.cy + 8, 1, -1, -16777216);
            }
         }
      }

      if (beatdz.LangLa_cz.$state_LangLa_cz().cZ) {
         mFont.a(mFont.d, var1, Caption.qG, DataCenter.gI().widthScreen / 2, DataCenter.gI().heightScreen - 45, 2, -2560, 2, 1);
      }

      LangLa_dp.a().a(-1);
   }

   public Vector c() {
      Vector var1;
      (var1 = super.c()).add(new LangLa_jz(2000, 0, 0, this.width, this.height, (LangLa_ii)null, this));
      return var1;
   }

   public void a(int var1, Object var2, LangLa_cy var3) {
      if (var1 != 1010) {
         this.e = -1;
      }

      switch(var1) {
      case 1001:
         if (!Utlis.haveNetwork()) {
            this.l(Caption.j);
         } else {
            if (AppListener.$state_AppListener().j != null) {
               try {
                  for(int var7 = 0; var7 < 10; ++var7) {
                     if (Session.gI().isConnected()) {
                        Utlis.sleep(100L);
                     }
                  }

                  if (!Session.gI().isConnected()) {
                     DataCenter.gI().ipServer = DataCenter.gI().aP.ip;
                     DataCenter.gI().portServer = DataCenter.gI().aP.port;
                     Session.gI();
                  }
               } catch (Exception var4) {
               }

               this.a();
               return;
            }

            AppListener.gI().j();
         }
         break;
      case 1002:
         short[] var5;
         if (Gdx.app.getType() != ApplicationType.iOS && !beatdz.DataCenter.$state_DataCenter().ar) {
            var5 = new short[]{0, 1, 2, 3, 4, 15, 5, 6};
         } else {
            var5 = new short[]{1, 2, 15, 5, 6};
         }

         String[] var6 = new String[var5.length];

         for(int var8 = 0; var8 < var6.length; ++var8) {
            var6[var8] = Caption.sC[var5[var8]];
         }

         this.a(new LangLa_x(this, new LangLa_kd(0, var5, var6), 0));
         return;
      case 1003:
      case 1009:
      default:
         break;
      case 1004:
         this.a(new LangLa_bp(DataCenter.gI().aP, this, 1005));
         return;
      case 1005:
         if (Session.gI().isConnected()) {
            DataCenter.gI().aI = true;
            Session.gI().close();
         }

         DataCenter.gI().setServer((Server)var2);
         return;
      case 1006:
         this.a(new LangLa_kg(this));
         return;
      case 1007:
         this.a(new LangLa_w(this));
         return;
      case 1008:
         this.a(new LangLa_bd(this));
         return;
      case 1010:
         if (this.e > 0) {
            this.e = -1;
            return;
         }

         this.e = 1;
         return;
      case 1011:
         DataCenter.gI().currentScreen.a(Caption.bP, 2001, this);
         return;
      case 1012:
         this.a(new LangLa_m(this));
      }

   }

   public void a(int var1, Object var2) {
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      if (var1.b == 2000) {
         this.e = -1;
      }

   }

   public void a() {
      if (!Utlis.g()) {
         this.l(Caption.j);
      } else {
         this.L();
         (new Thread(new LangLa_cc(this))).start();
      }
   }

   public static Message d() {
      Message var0 = null;

      try {
         (var0 = Message.c((byte)-76)).writeUTF(AppListener.$state_AppListener().j);
         var0.writeInt(DataCenter.gI().VER1);
         var0.writeInt(DataCenter.gI().VER2);
      } catch (Exception var2) {
         Utlis.println(var2);
      }

      return var0;
   }

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public LangLa_kt j;
public void initialize() {
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.LangLa_kt");
public static SessionState $state_LangLa_kt() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
