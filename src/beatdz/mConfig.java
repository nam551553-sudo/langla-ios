package beatdz;import beatdz.*;

import beatdz.DataCenter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Application.ApplicationType;

public class mConfig {
   private static final int QUEST_TRACKER_EXPANDED = 14;

   void copySettingsFrom(mConfig source) {
      byte questTracker = this.config[QUEST_TRACKER_EXPANDED];
      this.config = source.config.clone();
      this.config[QUEST_TRACKER_EXPANDED] = questTracker;
   }

   boolean isQuestTrackerExpanded() {
      return readBoolean(QUEST_TRACKER_EXPANDED);
   }

   void setQuestTrackerExpanded(boolean expanded) {
      writeBoolean(QUEST_TRACKER_EXPANDED, expanded);
   }
   
   private byte[] config = Binary.read("arr_config");
   private int length = 27;

   public mConfig() {
      if (this.config == null || this.config.length != this.length) {
         this.create();
      }

   }

   private void create() {
      byte[] cfg;
      (cfg = new byte[this.length])[0] = 1;
      cfg[1] = 1;
      if (DataCenter.gI().zoomLevelScreen == 2 && DataCenter.gI().typeOS != 2) {
         cfg[2] = 0;
      } else {
         cfg[2] = 1;
      }

      cfg[3] = 1;
      cfg[4] = 0;
      cfg[5] = 0;
      cfg[6] = 1;
      cfg[7] = 0;
      cfg[8] = 1;
      cfg[9] = (byte)(Gdx.app.getType() == ApplicationType.Desktop ? 2 : 1);
      cfg[10] = 0;
      cfg[11] = 0;
      cfg[12] = 0;
      cfg[13] = 0;
      cfg[QUEST_TRACKER_EXPANDED] = 1;
      cfg[15] = 0;
      cfg[16] = 0;
      cfg[17] = 0;
      cfg[18] = 0;
      cfg[19] = 0;
      cfg[20] = 1;
      cfg[21] = 0;
      cfg[22] = 0;
      cfg[23] = 1;
      cfg[24] = 1;
      cfg[25] = 2;
      if (this.config != null && this.config.length < cfg.length) {
         for(int var2 = 0; var2 < this.config.length; ++var2) {
            cfg[var2] = this.config[var2];
         }
      }

      this.config = cfg;
      Binary.write("arr_config", cfg);
   }

   private void save() {
      Binary.write("arr_config", this.config);
   }

   public static mConfig gI() {
      if (beatdz.mConfig.$state_mConfig().instance == null) {
         beatdz.mConfig.$state_mConfig().instance = new mConfig();
      }

      return beatdz.mConfig.$state_mConfig().instance;
   }

   public boolean readBoolean(int var1) {
      if ((var1 == 0 || var1 == 1) && !MultiSession.visible()) return false;
      try {
         if (this.config[var1] == 1) {
            return true;
         }
      } catch (Exception var2) {
         this.create();
      }

      return false;
   }

   public byte readByte(int var1) {
      try {
         if (var1 == 2 && (Gdx.app.getType() == ApplicationType.Android || Gdx.app.getType() == ApplicationType.iOS)) {
            int zoom = DataCenter.gI().zoomLevelScreen;
            return (byte)MobileAssets.quality(zoom);
         }
         return this.config[var1];
      } catch (Exception var2) {
         this.create();
         return 0;
      }
   }

   public void writeBoolean(int var1, boolean var2) {
      try {
         if (var2) {
            this.config[var1] = 1;
         } else {
            this.config[var1] = 0;
         }

         this.save();
      } catch (Exception var3) {
         this.create();
      }
   }

   public void writeByte(int var1, int var2) {
      try {
         if (this.config != null) {
            this.config[var1] = (byte)var2;
            this.save();
         }

      } catch (Exception var3) {
         this.create();
      }
   }

   public static byte isGDL() {
      try {
         if (beatdz.mConfig.$state_mConfig().instance != null) {
            return beatdz.mConfig.$state_mConfig().instance.config[18];
         }
      } catch (Exception var0) {
      }

      return 0;
   }

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public mConfig instance;
public void initialize() {
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.mConfig");
public static SessionState $state_mConfig() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
