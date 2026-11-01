package beatdz;

public class LangLa_ig implements Runnable {

    public void run() {
        try {
            AppListener.d = Binary2.a("b", (MainScreen) null);
            AppListener.e = Binary2.a("c", (MainScreen) null);

            while (!beatdz.DataCenter.$state_DataCenter().at) {
                Utlis.sleep(500L);
            }

            AppListener.c();
            beatdz.AppListener.$state_AppListener().g = true;
        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }
}
