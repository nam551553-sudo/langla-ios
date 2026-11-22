package beatdz;
import java.util.Comparator;
import java.util.Vector;

public abstract class Entity extends LangLa_cz {
   final RenderMotion.Sample renderMotion = new RenderMotion.Sample();
   private LangLa_ir shadow;
   public int a = 10;
   public int idEntity;
   public byte dir;
   public byte status;
   public byte e;
   public byte f;
   public boolean g;
   public Vector h = new Vector();

   final LangLa_ir shadow(boolean facingRight, int x, int y) {
      if (shadow == null) shadow = new LangLa_ir(facingRight, x, y, this);
      else shadow.position(facingRight, x, y);
      return shadow;
   }

   public abstract int a();

   public abstract int b();

   public abstract int c();

   public abstract int d();

   public abstract void a(Graphics var1);

   public abstract void b(Graphics var1);

   public abstract int e();

   public abstract String f();

   public abstract String g();

   public abstract String h();

   public boolean i() {
      return this.dir == 2;
   }

   public boolean j() {
      return this.status == 4 || this.status == 5 || this.status == 6;
   }

   public void setDir(Entity var1) {
      if (var1 != null) {
         if (this.cx < var1.cx) {
            this.dir = 2;
         } else {
            this.dir = 3;
         }
      }
   }

   public void k() {
      if (this.status != 4 && this.status != 5 && this.status != 6) {
         this.e = 0;
         this.status = 1;
      }

   }

   public void l() {
   }

   public int m() {
      return this.a() + (this.b() - this.a()) / 2;
   }

   public int n() {
      return this.c() + (this.d() - this.c()) / 2;
   }

   public boolean a(int var1, int var2) {
      Char var3;
      if (!(this instanceof Char) || (var3 = (Char)this).aw == null && var3.isMe() && (!SettingsTab.gI().autoTrain || GameSrc.gI().aA == null)) {
         if (var1 >= 10 && var2 >= 30 && var1 <= GameSrc.gI().maxX - 10 && var2 <= GameSrc.gI().maxY - 10) {
            if ((var1 >= 125 || var2 >= 70) && (var1 <= GameSrc.gI().maxX - 100 || var2 >= 100)) {
               return !GameSrc.gI().h.a(var1, var2);
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return true;
      }
   }

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public Comparator i;
public void initialize() {
this.i = new LangLa_cu();
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.Entity");
public static SessionState $state_Entity() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
