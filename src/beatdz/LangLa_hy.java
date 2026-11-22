package beatdz;import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_hy {
   
   public byte a;
   public String b;
   public XYEntity c;
   public int d;
   public int e;

   public static void a() {
      beatdz.LangLa_hy.$state_LangLa_hy().f.clear();
   }

   public static void a(String var0, XYEntity var1, int var2, int var3) {
      var2 -= Utlis.nextInt((int)10);
      if (Utlis.getRange(var1.cx, var1.cy, Char.gI().cx, Char.gI().cy) <= 300) {
         Vector var4 = new Vector();

         LangLa_hy var5;
         int var6;
         for(var6 = 0; var6 < beatdz.LangLa_hy.$state_LangLa_hy().f.size(); ++var6) {
            if ((var5 = (LangLa_hy)beatdz.LangLa_hy.$state_LangLa_hy().f.elementAt(var6)).a == 0 || var5.a == 3) {
               var4.add(var5);
            }
         }

         if ((var6 = var4.size() - 10) > 0) {
            for(int var7 = 0; var7 < var6; ++var7) {
               var5 = (LangLa_hy)var4.elementAt(var7);
               beatdz.LangLa_hy.$state_LangLa_hy().f.remove(var5);
            }
         }

         if (beatdz.LangLa_hy.$state_LangLa_hy().f.size() > 80) {
            beatdz.LangLa_hy.$state_LangLa_hy().f.remove(0);
         }

         beatdz.LangLa_hy.$state_LangLa_hy().f.addElement(new LangLa_hy(var0, var1, var2, var3));
      }
   }

   public static void b() {
      for(int var0 = 0; var0 < beatdz.LangLa_hy.$state_LangLa_hy().f.size(); ++var0) {
         LangLa_hy var1;
         ++(var1 = (LangLa_hy)beatdz.LangLa_hy.$state_LangLa_hy().f.elementAt(var0)).e;
         if (var1.e > 20) {
            beatdz.LangLa_hy.$state_LangLa_hy().f.removeElement(var1);
         }
      }

   }

   public static void a(Graphics var0) {
      for(int var1 = 0; var1 < beatdz.LangLa_hy.$state_LangLa_hy().f.size(); ++var1) {
         LangLa_hy var2;
         switch((var2 = (LangLa_hy)beatdz.LangLa_hy.$state_LangLa_hy().f.elementAt(var1)).a) {
         case 0:
         case 5:
         case 2:
            mFont.a((BitmapFont)Graphics.b(24.0F), (Graphics)var0, var2.b, var2.c.cx, var2.c.cy - var2.d - var2.e, 2, -2560, 0);
            break;
         case 1:
            mFont.a((BitmapFont)Graphics.c(28.0F), (Graphics)var0, var2.b, var2.c.cx, var2.c.cy - var2.d - var2.e, 2, -1, 0);
            break;
         case 3:
            mFont.a((BitmapFont)Graphics.b(24.0F), (Graphics)var0, var2.b, var2.c.cx, var2.c.cy - var2.d - var2.e, 2, -48128, 0);
            break;
         case 4:
            mFont.a((BitmapFont)Graphics.c(28.0F), (Graphics)var0, var2.b, var2.c.cx, var2.c.cy - var2.d - var2.e, 2, -65536, 0);
         default:
            break;
         case 6:
            mFont.a((BitmapFont)Graphics.b(26.0F), (Graphics)var0, var2.b, var2.c.cx, var2.c.cy - var2.d - var2.e + 5, 2, -3407617, 0);
            break;
         case 7:
         case 8:
         case 9:
         case 10:
         case 12:
            int var4 = var0.a;
            int var5 = var0.b;
            a(var0, 0, 0);
            int var6 = 0;
            switch(var2.a) {
            case 7:
            case 8:
               mFont.a((BitmapFont)Graphics.b(28.0F), (Graphics)var0, var2.b, DataCenter.gI().widthScreen / 2, DataCenter.gI().heightScreen - 90 - var2.e, 2, -1, 0);
               a(var0, var4, var5);
               continue;
            case 9:
            case 10:
               var6 = -2560;
            case 11:
            default:
               break;
            case 12:
               var6 = -16711681;
            }

            mFont.a((BitmapFont)Graphics.c(25.0F), (Graphics)var0, var2.b, DataCenter.gI().widthScreen / 2, DataCenter.gI().heightScreen - 90 - var2.e, 2, var6, 0);
            a(var0, var4, var5);
            break;
         case 11:
            var0.c(-268370181);
            mFont.a((BitmapFont)Graphics.b(24.0F), (Graphics)var0, var2.b, var2.c.cx, var2.c.cy - var2.d - var2.e, 2, -65536, 0);
            var0.c();
            break;
         case 13:
            mFont.a((BitmapFont)Graphics.b(24.0F), (Graphics)var0, var2.b, var2.c.cx, var2.c.cy - var2.d - var2.e + 5, 2, -16742145, 0);
            break;
         case 14:
            mFont.a((BitmapFont)Graphics.b(24.0F), (Graphics)var0, var2.b, var2.c.cx, var2.c.cy - var2.d - var2.e + 5, 2, -7812062, 0);
         }
      }

   }

   private LangLa_hy(String var1, XYEntity var2, int var3, int var4) {
      switch(var4) {
      case 2:
      case 5:
         this.b = Caption.eS;
         break;
      case 3:
      case 4:
      case 11:
      case 13:
      default:
         this.b = var1;
         break;
      case 6:
         this.b = Caption.eT + var1;
         break;
      case 7:
         this.b = Caption.eU + var1;
         break;
      case 8:
         this.b = Caption.eV + var1;
         break;
      case 9:
         this.b = Caption.eW + var1;
         break;
      case 10:
         this.b = Caption.eX + var1;
         break;
      case 12:
         this.b = Caption.nz + var1;
         break;
      case 14:
         this.b = Caption.pt;
      }

      this.c = var2;
      this.d = var3;
      this.a = (byte)var4;
   }

   private static void a(Graphics var0, int var1, int var2) {
      var0.a(-var0.a, -var0.b);
      var0.a(var1, var2);
   }

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public Vector f;
public void initialize() {
this.f = new Vector();
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.LangLa_hy");
public static SessionState $state_LangLa_hy() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
