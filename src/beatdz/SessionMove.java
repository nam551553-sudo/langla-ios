package beatdz;
public class SessionMove {
   
   
   

   public static void update(boolean var0) {
      try {
         if (Char.gI().cy < 30) {
            Char.gI().cy = 30;
         }

         if (Char.gI().aw != null || GameSrc.gI().bN || beatdz.GameSrc.$state_GameSrc().an) {
            return;
         }

         int xNew = Char.gI().cx - beatdz.SessionMove.$state_SessionMove().x;
         int yNew = Char.gI().cy - beatdz.SessionMove.$state_SessionMove().y;
         if ((xNew == 0 || yNew == 0) && xNew <= 127 && xNew >= -128 && yNew <= 127 && yNew >= -128) {
            if (xNew != 0) {
               beatdz.SessionMove.$state_SessionMove().x = Char.gI().cx;
               beatdz.SessionMove.$state_SessionMove().y = Char.gI().cy;
               if (Char.gI().status != 2 && Char.gI().status != 7) {
                  Session.gI().sendCharX(xNew);
               } else {
                  Session.gI().sendCharXWhenMove(xNew);
               }
            } else {
               if (yNew != 0) {
                  beatdz.SessionMove.$state_SessionMove().x = Char.gI().cx;
                  beatdz.SessionMove.$state_SessionMove().y = Char.gI().cy;
                  if (Char.gI().status != 2 && Char.gI().status != 7) {
                     Session.gI().sendCharY(yNew);
                     return;
                  }

                  Session.gI().sendCharYWhenMove(yNew);
               }

               return;
            }
         } else {
            beatdz.SessionMove.$state_SessionMove().x = Char.gI().cx;
            beatdz.SessionMove.$state_SessionMove().y = Char.gI().cy;
            if (Char.gI().status != 2 && Char.gI().status != 7) {
               Session.gI().sendCharXY(beatdz.SessionMove.$state_SessionMove().x, beatdz.SessionMove.$state_SessionMove().y);
            } else {
               Session.gI().sendCharXYWhenMove(beatdz.SessionMove.$state_SessionMove().x, beatdz.SessionMove.$state_SessionMove().y);
            }
         }
      } catch (Exception var2) {
         Utlis.println(var2);
      }

   }

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public short x;
public short y;
public Message c;
public void initialize() {
this.c = null;
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.SessionMove");
public static SessionState $state_SessionMove() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
