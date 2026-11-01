package beatdz;import java.util.Hashtable;
import java.util.Vector;

public class LangLa_mi extends LangLa_cs {
   private LangLa_im b;
   
   public int a = -1;
   private int d;

   public LangLa_mi(int var1, int var2, int var3, int var4, LangLa_cx var5) {
      this.setXY(0, var2);
      this.setSize(84, 50);
      this.s = var5;
      this.d = GameSrc.gI().A * 2;
   }

   public void a(int var1) {
      this.a = var1;
      this.b = new LangLa_im((byte)2, 0, 0, this.width, this.height, GameSrc.gI().maxX / this.d, GameSrc.gI().maxY / this.d);
   }

   public void a(Graphics var1) {
      int var3;
      int var9;
      int var11;
      if (!mConfig.gI().readBoolean(18)) {
         if (this.a >= 0) {
            this.a = -1;
            Binary.cleanImage(beatdz.LangLa_mi.$state_LangLa_mi().c);

            try {
               String var4;
               if ((beatdz.LangLa_mi.$state_LangLa_mi().c = Binary.createImage(var4 = "mapscale_" + GameSrc.gI().mapID)) == null) {
                  LangLa_fb var5;
                  (var5 = new LangLa_fb()).g = new Hashtable();
                  var5.a = GameSrc.gI().mapID;
                  var5.d = "mapscale/" + GameSrc.gI().mapID + ".png";
                  var5.e = var4;
                  beatdz.LangLa_cz.$state_LangLa_cz().cW.add(var5);
                  LangLa_cz.S();
               }
            } catch (Exception var7) {
            }

            if (beatdz.LangLa_mi.$state_LangLa_mi().c != null) {
               Binary.disposeImage(beatdz.LangLa_mi.$state_LangLa_mi().c);
            }
         }

         this.a(var1, this.cx + this.b.cx, this.cy + this.b.cy);
         int var2 = this.b.f;
         var3 = this.b.p;
         if (var2 < 0) {
            var2 = 0;
         }

         if (var3 < 0) {
            var3 = 0;
         }

         var9 = var2 + this.b.width;
         var11 = var3 + this.b.height;
         if (var9 > LangLa_fq.a(beatdz.LangLa_mi.$state_LangLa_mi().c)) {
            var2 = (var9 = LangLa_fq.a(beatdz.LangLa_mi.$state_LangLa_mi().c)) - this.b.width;
         }

         if (var11 > LangLa_fq.b(beatdz.LangLa_mi.$state_LangLa_mi().c)) {
            var3 = (var11 = LangLa_fq.b(beatdz.LangLa_mi.$state_LangLa_mi().c)) - this.b.height;
         }

         var9 = (var9 - var2) * DataCenter.gI().zoomLevel;
         var11 = (var11 - var3) * DataCenter.gI().zoomLevel;
         if (beatdz.LangLa_mi.$state_LangLa_mi().c != null) {
            if (this.b.width * DataCenter.gI().zoomLevel > beatdz.LangLa_mi.$state_LangLa_mi().c.c) {
               var2 = 0;
               var9 = beatdz.LangLa_mi.$state_LangLa_mi().c.c;
            }

            if (this.b.height * DataCenter.gI().zoomLevel > beatdz.LangLa_mi.$state_LangLa_mi().c.d) {
               var3 = 0;
               var11 = beatdz.LangLa_mi.$state_LangLa_mi().c.d;
            }

            var1.a(beatdz.LangLa_mi.$state_LangLa_mi().c, var2, var3, var9, var11, 0, 0, 0, 0);
         }

         this.a(var1, this.cx, this.cy);
      }

      int var10000 = var1.a;
      var10000 = var1.b;
      this.a(var1, this.b_(), this.c_());
      this.a(var1, this.b);
      if (GameSrc.gI().aI != null) {
         for(var3 = 0; var3 < GameSrc.gI().aI.a.size(); ++var3) {
            LangLa_ey var8 = (LangLa_ey)GameSrc.gI().aI.a.elementAt(var3);
            Char var10;
            if ((var10 = GameSrc.gI().b(var8.a)) != null && !var10.name.equals(Char.gI().name)) {
               var9 = var10.cx / 8;
               var11 = var10.cy / 8;
               var1.f(-16711681);
               var1.c(var9 - 2, var11 - 2, 4, 4);
               mFont.b(mFont.b, var1, var10.name, var9, var11 - 7, 2, -16711681, -13553359);
            }
         }
      }

      var9 = Char.gI().cx / 8;
      var11 = Char.gI().cy / 8;
      if (DataCenter.gI().i % 30 < 10) {
         var1.f(-1);
      } else {
         var1.f(-16742145);
      }

      var1.c(var9 - 2, var11 - 2, 4, 4);
      this.b(var1);
   }

   public void b() {
      if (this.b != null) {
         this.b.j = Char.gI().cx / this.d - this.b.width / 2;
         this.b.s = Char.gI().cy / this.d - this.b.height / 2;
         this.b.a();
      }

   }

   public Vector c() {
      return null;
   }

   public void a(LangLa_jz var1, int var2, int var3) {
   }

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public mImage c;
public void initialize() {
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.LangLa_mi");
public static SessionState $state_LangLa_mi() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
