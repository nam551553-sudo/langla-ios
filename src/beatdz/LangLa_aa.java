package beatdz;
public class LangLa_aa implements Runnable {
   
  public GameSrc a;

  public LangLa_aa(GameSrc var1) {
      this.a = var1;
   }

   public void run() {
      if (beatdz.GameSrc.$state_GameSrc().bR != null) {
         beatdz.MainScreen.$state_MainScreen().cC.add(beatdz.GameSrc.$state_GameSrc().bR);
      }

      beatdz.GameSrc.$state_GameSrc().bR = Binary2.a((new String[]{"f"})[GameSrc.a(this.a)], (MainScreen)null);
      GameSrc.b(this.a);
      if (GameSrc.a(this.a) > 0) {
         GameSrc.a(this.a, 0);
      }

   }
}
