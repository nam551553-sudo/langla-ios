package beatdz;import beatdz.*;

import beatdz.DataCenter;
import com.tgame.model.Caption;
import java.util.Comparator;

public class Skill implements Cloneable {
   
   
   public short id;
   public short idTemplate;
   public byte level;
   public short levelNeed;
   public short mpUse;
   public int coolDown;
   public short rangeNgang;
   public short rangeDoc;
   public byte maxTarget;
   public String strOptions;
   public long time;
   private int o = 0;
   public boolean myUse;

   public Skill cloneSkill() {
      try {
         return (Skill)super.clone();
      } catch (Exception var2) {
         Utlis.println(var2);
         return null;
      }
   }

   public SkillTemplate getSkillTemplate() {
      return DataCenter.gI().SkillTemplate[this.idTemplate];
   }

   public boolean c() {
      return this.getSkillTemplate().type < 5 || this.getSkillTemplate().type == 6;
   }

   public boolean d() {
      return this.getSkillTemplate().type == 1;
   }

   public boolean a(Char var1) {
      if (this.time < Utlis.time() && var1.mp >= this.mpUse) {
         this.o = 0;
         return true;
      } else {
         ++this.o;
         if (this.o >= 2) {
            this.o = 0;
         }

         if (var1.mpFull < this.mpUse && var1.isMe()) {
            DataCenter.gI().currentScreen.showMessage(Caption.lj + " " + this.getSkillTemplate().name, -65536);
         } else if (beatdz.SettingsTab.$state_SettingsTab().j && var1.mp < this.mpUse && var1.isMe()) {
            beatdz.SettingsTab.$state_SettingsTab().j = false;
            DataCenter.gI().currentScreen.showMessage(Caption.lj + " " + this.getSkillTemplate().name, -65536);
         }

         return false;
      }
   }

   public void e() {
      this.time = Utlis.time() + (long)this.coolDown;
   }

   public float f() {
      return (float)(this.time - Utlis.time());
   }

   public ItemOption[] g() {
      if (this.strOptions != null && this.strOptions.length() > 0) {
         String[] var1;
         ItemOption[] var2 = new ItemOption[(var1 = Utlis.split(this.strOptions, ";")).length];

         for(int var3 = 0; var3 < var1.length; ++var3) {
            var2[var3] = new ItemOption(var1[var3]);
         }

         return var2;
      } else {
         return null;
      }
   }

   public boolean h() {
      return this.idTemplate == 11 || this.idTemplate == 36;
   }

   
   public Object clone() {
      return this.cloneSkill();
   }

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public Comparator a;
public Comparator b;
public void initialize() {
this.a = new LangLa_it();
this.b = new LangLa_iu();
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.Skill");
public static SessionState $state_Skill() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
