package beatdz;import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Blending;
import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_mm extends LangLa_cs {
   
   private boolean c;
   public int b;

   public LangLa_mm(int var1, int var2, int var3, int var4, LangLa_cx var5) {
      this.setXY(var1, var2);
      if (DataCenter.gI().zoomLevel == 1) {
         var3 = 100;
      }

      this.setSize(var3, 32);
      this.s = var5;
      this.c = false;
   }

   public void a(Graphics var1) {
      try {
         if (!this.c) {
            this.c = true;
            Binary.cleanImage(beatdz.LangLa_mm.$state_LangLa_mm().a);
            Pixmap var2 = (beatdz.LangLa_mm.$state_LangLa_mm().a = mImage.a(this.width * DataCenter.gI().zoomLevel, this.height * DataCenter.gI().zoomLevel)).b;
            GameSrc.drawHudPanel(var2, 0, 0, this.width, this.height);

            try {
               if (GameSrc.gI().aI != null && GameSrc.gI().aI.a.size() != 0) {
                  for(int var4 = 0; var4 < GameSrc.gI().aI.a.size() && var4 < 6; ++var4) {
                     mImage var3 = LangLa_fq.a(((LangLa_ey)GameSrc.gI().aI.a.get(var4)).a());
                     Binary2.a(var2, var3.b, 0, 0, var3.c, var3.d, 5 * DataCenter.gI().zoomLevel, 3 + var4 * 15 * DataCenter.gI().zoomLevel, 14 * DataCenter.gI().zoomLevel, 14 * DataCenter.gI().zoomLevel, Blending.SourceOver);
                  }
               }
            } catch (Exception var6) {
               Utlis.println(var6);
            }

            LangLa_cj var10000 = GameSrc.gI().S;
            short var13 = (short)(this.height + 14);
            short var11 = this.width;
            LangLa_cj var9 = var10000;
            var10000.width = var11;
            var9.height = var13;
            var9.f.a(var11);
            var9.g.a(var13);
            var9.h = var11;
            var9.i = var13;
            if (var9.j == 2) {
               var9.a(false);
            } else if (var9.j == 1) {
               var9.a(true);
            } else if (var9.d) {
               var9.f.a(var11);
               var9.g.a(var13);
            } else {
               var9.f.a(0);
               var9.g.a(0);
            }

            DataCenter.gI().aH = false;
         }

         var1.a(beatdz.LangLa_mm.$state_LangLa_mm().a, 0, 0);
         if (GameSrc.gI().S.c()) {
            try {
               if (GameSrc.gI().aI != null && GameSrc.gI().aI.a.size() != 0) {
                  for(int var12 = 0; var12 < GameSrc.gI().aI.a.size() && var12 < 6; ++var12) {
                     LangLa_ey var10 = (LangLa_ey)GameSrc.gI().aI.a.get(var12);
                     if (var12 == 0) {
                        mFont.d(mFont.b, var1, "c#yellow" + var10.a + " (" + var10.d + ")", 22, 9 + var12 * 15, 0, -1, -10275328);
                     } else {
                        mFont.d(mFont.b, var1, var10.a + " (" + var10.d + ")", 22, 9 + var12 * 15, 0, -1, -10275328);
                     }
                  }

                  return;
               }

               mFont.d(mFont.c, var1, Caption.qk + " (0)", this.cx + 4, 8, 0, -7812062, 0);
            } catch (Exception var7) {
            }

         }
      } catch (Exception var8) {
      }
   }

   public void b() {
      int var1 = 0;
      if (GameSrc.gI().aI != null) {
         var1 = GameSrc.gI().aI.a.size();
      }

      if (var1 > 6) {
         var1 = 6;
      }

      if (var1 != this.b) {
         this.b = var1;
         if ((var1 = this.b * 16) < 32) {
            var1 = 32;
         }

         this.setSize(this.width, var1);
         this.c = false;
      }

   }

   public Vector c() {
      Vector var1 = new Vector();
      if (!GameSrc.gI().S.c()) {
         return var1;
      } else {
         var1.addElement(new LangLa_jz(4000, 0, 0, this.width, this.height, (LangLa_ii)null, this));
         return var1;
      }
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      switch(var1.b) {
      case 4000:
         GameSrc.gI().a((LangLa_cx)(new LangLa_ca(GameSrc.gI())));
      default:
      }
   }

   public void s() {
      super.s();
   }

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public mImage a;
public void initialize() {
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.LangLa_mm");
public static SessionState $state_LangLa_mm() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
