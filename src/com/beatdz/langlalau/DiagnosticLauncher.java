package com.beatdz.langlalau;

import beatdz.*;
import com.badlogic.gdx.Gdx;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

/** Writes rendering errors and HUD state locally, without recording account fields. */
public final class DiagnosticLauncher {
    public static void main(String[] args) throws Exception {
        File directory = new File("support/logs");
        directory.mkdirs();
        PrintStream log = new PrintStream(new FileOutputStream(new File(directory, "hud-diagnostic.log")), true, "UTF-8");
        System.setOut(log);
        System.setErr(log);
        System.setProperty("langla.diagnostics", "true");
        log.println("HUD diagnostics started " + new java.util.Date());
        DesktopLauncher.main(args);
        Thread observer = new Thread(() -> {
            for (int sample = 0; sample < 150; sample++) {
                try { Thread.sleep(2000L); } catch (InterruptedException error) { return; }
                if (Gdx.app == null) continue;
                Gdx.app.postRunnable(() -> {
                    DataCenter data = DataCenter.gI();
                    log.println("STATE screen=" + (data.currentScreen == null ? "null" : data.currentScreen.getClass().getSimpleName())
                            + " size=" + data.widthScreen + "x" + data.heightScreen
                            + " cN=" + beatdz.LangLa_cx.$state_LangLa_cx().cN + " dataReady=" + data.ba + "," + data.bb);
                    if (data.currentScreen instanceof GameSrc) {
                        GameSrc game = (GameSrc) data.currentScreen;
                        log.println("HUD map=" + game.mapID + " worldReady=" + game.ba + " hidden=" + game.bb
                                + " backgroundReady=" + data.aH + " skills=" + (game.p == null ? -1 : game.p.length)
                                + " controls=" + game.cG.size() + " panels=" + game.cD.size()
                                + " groups=" + count(game.O) + "," + count(game.P) + "," + count(game.Q)
                                + "," + count(game.R) + "," + count(game.S) + "," + count(game.T) + "," + count(game.U));
                        Graphics graphics = AppListener.gI().canvas.graphics;
                        log.println("DRAW offset=" + graphics.a + "," + graphics.b + " clip=" + graphics.i() + "," + graphics.j()
                                + "," + graphics.h + "," + graphics.i);
                    }
                });
            }
        }, "hud-diagnostic-observer");
        observer.setDaemon(true);
        observer.start();
    }

    private static String count(LangLa_cj group) {
        return group == null ? "null" : group.a.size() + ":" + group.width + "x" + group.height + ":" + group.d;
    }
}
