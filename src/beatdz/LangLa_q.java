package beatdz;import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Application.ApplicationType;
import java.util.Vector;

public class LangLa_q extends LangLa_fl {
   public LangLa_r a;
   public boolean b;
   public long c;
   public int d;
   

   public LangLa_q(MainScreen var1) {
      this.p = var1;
      this.setSize((DataCenter.gI().widthScreen - 240) / 14 * 14 + 192, 26);
      this.setXY(DataCenter.gI().widthScreen / 2 - this.width / 2, DataCenter.gI().heightScreen - 30);
      this.a = new LangLa_r(var1);
      this.a.setSize(this.width, this.height);
      this.a.b = 200;
      this.d = this.a.f();
      this.c = Utlis.time();
   }

   public void a(boolean var1) {
      this.a.c = true;
   }

   public void a(Graphics var1) {
      this.a.b(var1, this.cx, this.cy);
   }

   public void b() {
      this.a.b();
      if (this.b) {
         beatdz.DataCenter.$state_DataCenter().as = true;
         ScreenLogin var1 = LoginPCScreen.getScreenLogin();
         DataCenter.gI().setScreen((MainScreen)var1);
         mConfig.gI().writeBoolean(17, true);
         if (!mConfig.gI().readBoolean(8)) {
            var1.a(new LangLa_bd(var1));
         }

         if (beatdz.LangLa_q.$state_LangLa_q().e) {
            beatdz.LangLa_q.$state_LangLa_q().e = false;
         } else if (AppListener.$state_AppListener().j != null) {
            AppListener.gI();
            AppListener.i();
            AppListener var10000 = AppListener.gI();
            Object var2 = null;
            AppListener.$state_AppListener().j = (String)var2;
         } else {
            AppListener.gI().j();
         }
      } else {
         if (this.a.a >= this.a.b) {
            this.b = true;
         }

         if (this.a.f() != this.d) {
            this.d = this.a.f();
            this.c = Utlis.time();
         }

      }
   }

   public Vector c() {
      return new Vector();
   }

   public void a(LangLa_jz var1, int var2, int var3) {
   }

   public void a(int var1, Object var2, LangLa_cy var3) {
   }

   public void a(int var1, Object var2) {
   }

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public boolean e;
public void initialize() {
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.LangLa_q");
public static SessionState $state_LangLa_q() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
