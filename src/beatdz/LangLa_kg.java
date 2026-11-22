package beatdz;import com.tgame.model.Caption;

public class LangLa_kg extends LangLa_fo {
   private mTextBox c;
   private mTextBox d;
   private mTextBox e;
   private int f;
   private int g;
   public String a;
   public String b;
   

   public LangLa_kg(MainScreen var1) {
      this.p = var1;
      beatdz.LangLa_kg.$state_LangLa_kg().h = this;
      this.a(210, 147);
      this.f = 68;
      this.g = 35;
      this.c = this.a(74, 34, 124, "", this, 0);
      byte var2 = 16;
      this.c.a = var2;
      this.d = this.a(74, 60, 124, "", this, 1);
      this.e = this.a(74, 86, 124, "", this, 1);
      this.a(Caption.g, 1002);
   }

   public static LangLa_kg e() {
      return beatdz.LangLa_kg.$state_LangLa_kg().h;
   }

   public void a(int var1, Object var2) {
   }

   public void a(int var1, Object var2, LangLa_cy var3) {
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      switch(var1.b) {
      case 1002:
         this.p.L();
         LangLa_kg var8 = this;
         this.p.L();
         this.a = this.c.f();
         this.b = this.e.f();
         LoginPCScreen.g();
         Message var9 = null;

         try {
            (var9 = var8.f()).send();
         } catch (Exception var6) {
            Utlis.println(var6);
         } finally {
            if (var9 != null) {
               var9.close();
            }

         }
      default:
      }
   }

   public void a(Graphics var1) {
      this.a(var1, this.cx, this.cy, this.width, this.height, Caption.aj, (byte)2, true);
      mFont.a(mFont.d, var1, Caption.qR[0], 15, this.g + 10, 0, -1);
      mFont.a(mFont.d, var1, Caption.ak, 15, this.g + 25 + 10, 0, -1);
      mFont.a(mFont.d, var1, Caption.al, 15, this.g + 50 + 10, 0, -1);
   }

   public void b() {
   }

   private Message f() {
      Message var1 = null;

      try {
         (var1 = Message.c((byte)-124)).writeUTF(this.a);
         var1.writeUTF(this.d.f());
         var1.writeUTF(this.b);
         var1.writeInt(DataCenter.gI().VER1);
         var1.writeInt(DataCenter.gI().VER2);
      } catch (Exception var3) {
         Utlis.println(var3);
      }

      return var1;
   }

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public LangLa_kg h;
public void initialize() {
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.LangLa_kg");
public static SessionState $state_LangLa_kg() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
