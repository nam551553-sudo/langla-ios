package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_bi extends LangLa_fo {
   private mTextBox a;
   private boolean b;
   private boolean c;
   private int d;
   private LangLa_ce e;
   
   
   

   public static void e() {
      beatdz.LangLa_bi.$state_LangLa_bi().f = "";
      beatdz.LangLa_bi.$state_LangLa_bi().g = -1;
      String var0;
      if ((var0 = Binary.readUTF("aupro" + Char.gI().idEntity)) != null) {
         a(2, Utlis.decodeString(var0), beatdz.LangLa_bi.$state_LangLa_bi().h);
      }

   }

   public LangLa_bi(MainScreen var1, Message var2) {
      try {
         this.b = var2.reader.dis.readBoolean();
         this.c = var2.reader.dis.readBoolean();
         this.d = var2.reader.dis.readInt();
         this.cF = 2;
         this.p = var1;
         this.a(240, 160);
         if (this.c && beatdz.LangLa_bi.$state_LangLa_bi().g >= 0) {
            if (beatdz.LangLa_bi.$state_LangLa_bi().h) {
               Binary.writeUTF("aupro" + beatdz.LangLa_bi.$state_LangLa_bi().g, Utlis.encodeString(beatdz.LangLa_bi.$state_LangLa_bi().f));
            } else {
               Binary.delete("aupro" + beatdz.LangLa_bi.$state_LangLa_bi().g + ".beatdz");
            }
         }

         this.a = this.a(62, 5 + 75, 150, "", this, 1);
         LangLa_dz var6;
         if (this.b) {
            var6 = this.c(Caption.oX, 1002);
            if (this.c) {
               var6.a(true);
            }
         } else {
            var6 = this.c(Caption.oY, 1003);
         }

         var6.setXY(this.width / 2 - var6.width / 2, var6.cy);
         (var6 = this.b(Caption.oZ, 1004)).setXY(var6.cx - 30, var6.cy);
         var6.a(!this.b);
         if (this.c && this.b) {
            String var4 = Caption.pa;
            var6.a = var4;
            var6.a(true);
         }

         (var6 = this.c(Caption.pb, 1005)).setXY(var6.cx + 30, var6.cy);
         var6.a(!this.b);
         this.e = this.a(this.a.cx, this.a.cy + 24, Caption.pc, 1001);
         boolean var7 = beatdz.LangLa_bi.$state_LangLa_bi().h;
         this.e.a = var7;
      } catch (Exception var5) {
      }
   }

   public void b(int var1, Object var2) {
   }

   public void a(int var1, Object var2) {
   }

   public void a(int var1, Object var2, LangLa_cy var3) {
   }

   public int a_() {
      return 5;
   }

   public void a(Graphics var1) {
      this.a(var1, 0, 0, this.width, this.height, 80, 55, 56);
      if (this.d > 0) {
         mFont.b(mFont.d, var1, Caption.pd + Utlis.e((long)this.d * 1000L), 12, 5 + 16, 20, -2560, -10275328);
      }

      mFont.b(mFont.d, var1, Caption.oW, 12, 5 + 32, 20, -1, -10275328);
      mFont.b(mFont.d, var1, Caption.pe, 12, 5 + 48, 20, -1, -10275328);
      mFont.b(mFont.d, var1, Caption.pf, 12, 5 + 64, 20, -1, -10275328);
      mFont.b(mFont.d, var1, Caption.oV, 12, 5 + 86, 20, -1, -10275328);
   }

   public void b() {
   }

   public Vector c() {
      Vector var1;
      (var1 = super.c()).addElement(new LangLa_jz(0, 0, 0, this.width, this.height, this.q, this));
      return var1;
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      switch(var1.b) {
      case 1001:
         return;
      case 1002:
         DataCenter.gI().currentScreen.a(Caption.pg, 2012, this);
         return;
      case 1003:
         DataCenter.gI().currentScreen.a(Utlis.replaceAll(Caption.ph, this.a.f()), 2013, this);
         return;
      case 1004:
         a(2, this.a.f(), this.e.a);
         return;
      case 1005:
         DataCenter.gI().currentScreen.a(Caption.pi, 2015, this);
         return;
      case 2012:
         a(0, this.a.f(), this.e.a);
         return;
      case 2013:
         a(1, this.a.f(), this.e.a);
         return;
      case 2015:
         a(3, this.a.f(), this.e.a);
      default:
      }
   }

   private static void a(int var0, String var1, boolean var2) {
      try {
         beatdz.LangLa_bi.$state_LangLa_bi().g = Char.gI().idEntity;
         beatdz.LangLa_bi.$state_LangLa_bi().f = var1;
         beatdz.LangLa_bi.$state_LangLa_bi().h = var2;
         Message var4;
         (var4 = Message.c((byte)-47)).writeByte(var0);
         var4.writeUTF(var1);
         var4.send();
      } catch (Exception var3) {
      }
   }

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public String f;
public int g;
public boolean h;
public void initialize() {
this.f = "";
this.g = -1;
this.h = true;
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.LangLa_bi");
public static SessionState $state_LangLa_bi() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
