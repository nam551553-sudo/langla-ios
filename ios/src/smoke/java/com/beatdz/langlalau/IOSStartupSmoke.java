package com.beatdz.langlalau;

import beatdz.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.iosrobovm.IOSApplication;
import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.uikit.UIApplication;

/** CI-only entry point; excluded from the shipping app's source set. */
public class IOSStartupSmoke extends IOSLauncher {
    private long loginObserved;
    private long optionalIconRequested;
    private long baseIconRequested;
    private static volatile boolean finished;

    private static void finish(int code, String summary, Throwable failure) {
        if (finished) return;
        finished = true;
        java.io.StringWriter result = new java.io.StringWriter();
        java.io.PrintWriter writer = new java.io.PrintWriter(result);
        writer.println(summary);
        writer.println("IOS_NATIVE_EXIT_CODE=" + code);
        if (failure != null) failure.printStackTrace(writer);
        writer.flush();
        try {
            Gdx.files.local("ios-native-result.txt").writeString(result.toString(), false, "UTF-8");
        } catch (Throwable error) {
            System.out.println("FAIL IOS_NATIVE_STARTUP could not save test result");
            error.printStackTrace(System.out);
            code = 14;
        }
        System.out.print(result.toString());
        System.out.flush();
        // RoboVM's NSLog stream is asynchronous; a clean exit can discard its last messages.
        try { Thread.sleep(1500); } catch (InterruptedException ignored) { }
        System.exit(code);
    }
    @Override protected IOSApplication createApplication() {
        Thread.setDefaultUncaughtExceptionHandler((thread, failure) -> {
            finish(15, "FAIL IOS_NATIVE_STARTUP uncaught on " + thread.getName(), failure);
        });
        IOSApplication application = super.createApplication();
        final long started = System.nanoTime();
        Thread monitor = new Thread(() -> {
            while (true) {
                try { Thread.sleep(1000); } catch (InterruptedException error) { return; }
                if (finished) return;
                // Gdx.app is assigned before IOSApplication finishes creating its graphics backend.
                if (Gdx.app == null || Gdx.graphics == null) continue;
                Gdx.app.postRunnable(() -> {
                    if (finished) return;
                    DataCenter data = DataCenter.gI();
                    System.out.println("IOS_SMOKE phase=" + data.startupPhase + " bytes=" + Session.gI().countRecv
                            + " screen=" + (data.currentScreen == null ? "null" : data.currentScreen.getClass().getSimpleName()));
                    if (data.currentScreen instanceof LoginPCScreen) {
                        if (loginObserved == 0) {
                            // Reproduce the mobile-only hiding condition from the reported bug.
                            DataCenter.$state_DataCenter().ar = true;
                            loginObserved = System.nanoTime();
                            return;
                        }
                        if (System.nanoTime() - loginObserved < 2000000000L) return;
                        if (!HttpDownloads.isNative() || !data.ba || !data.bb || data.MapTemplate == null
                                || data.aP == null || data.arrayServers == null || data.arrayServers.length == 0) {
                            finish(3, "FAIL IOS_NATIVE_STARTUP incomplete login data", null); return;
                        }
                        if (LangLa_fq.a(643).c <= 1) {
                            if (baseIconRequested == 0) baseIconRequested = System.nanoTime();
                            if (System.nanoTime() - baseIconRequested < 45_000_000_000L) return;
                            finish(11, "FAIL IOS_NATIVE_STARTUP missing base UI icon after wait", null); return;
                        }
                        if (data.zoomLevel >= 3 && LangLa_fq.a(21137).c <= 1) {
                            if (optionalIconRequested == 0) optionalIconRequested = System.nanoTime();
                            if (System.nanoTime() - optionalIconRequested < 45_000_000_000L) return;
                            finish(12, "FAIL IOS_NATIVE_STARTUP deferred icon did not load", null); return;
                        }
                        Gdx.audio.newMusic(Gdx.files.internal("music/0.mp3")).dispose();
                        Gdx.audio.newSound(Gdx.files.internal("sound/0.mp3")).dispose();
                        System.out.println("PASS IOS_NATIVE_ASSETS base UI, deferred HD icon and bundled MP3s");
                        LoginPCScreen login = (LoginPCScreen) data.currentScreen;
                        int selectors = 0;
                        boolean selectedNameVisible = false;
                        for (Object value : login.cG) {
                            if (value instanceof LangLa_dz) {
                                LangLa_dz button = (LangLa_dz) value;
                                if (button.b == 1004 && !button.v) {
                                    selectors++;
                                    selectedNameVisible |= data.aP.getName().equals(button.a);
                                }
                            }
                        }
                        if (selectors != 2 || !selectedNameVisible) {
                            finish(5, "FAIL IOS_NATIVE_STARTUP server selector hidden or unnamed", null); return;
                        }
                        login.a(1004, null, null);
                        boolean opened = false;
                        for (Object dialog : login.cD) opened |= dialog instanceof LangLa_bp;
                        if (!opened) {
                            finish(6, "FAIL IOS_NATIVE_STARTUP server picker did not open", null); return;
                        }
                        System.out.println("PASS IOS_NATIVE_SERVER_PICKER visible selected server=" + data.aP.getName()
                                + "; picker opened with newer-client flag enabled");
                        if (MultiSession.barHeight() <= 0) {
                            finish(7, "FAIL IOS_NATIVE_STARTUP x6 tab bar disabled", null); return;
                        }
                        java.util.Set<Session> sessions = new java.util.HashSet<>();
                        java.util.Set<DataCenter> centers = new java.util.HashSet<>();
                        java.util.Set<String> profiles = new java.util.HashSet<>();
                        for (int slot = 0; slot < MultiSession.LIMIT; slot++) {
                            if (slot > 0 && !MultiSession.add()) {
                                finish(8, "FAIL IOS_NATIVE_STARTUP cannot add x6 tab " + slot, null); return;
                            }
                            sessions.add(Session.gI()); centers.add(DataCenter.gI());
                            profiles.add(MultiSession.storageName("arr_acc"));
                            beatdz.Char.gI().hp = 100 + slot;
                        }
                        if (MultiSession.add() || sessions.size() != 6 || centers.size() != 6 || profiles.size() != 6) {
                            finish(9, "FAIL IOS_NATIVE_STARTUP x6 account isolation or limit", null); return;
                        }
                        for (int slot = 0; slot < MultiSession.LIMIT; slot++) {
                            MultiSession.select(slot);
                            if (beatdz.Char.gI().hp != 100 + slot) {
                                finish(10, "FAIL IOS_NATIVE_STARTUP x6 switch lost account state", null); return;
                            }
                        }
                        MultiSession.select(0);
                        System.out.println("PASS IOS_NATIVE_X6 six independent tabs, profile paths and account switching");
                        try {
                            QuestTrackerTabScenario.verify();
                            System.out.println("PASS IOS_NATIVE_QUEST_TRACKER rendered on tab 2 and restored across six tabs");
                            System.out.println("PASS IOS_NATIVE_TAP_MOVEMENT correct targets across six tabs");
                            CapeAttachmentScenario.verify();
                            System.out.println("PASS IOS_NATIVE_CAPES fourteen capes leave all four measured costume necks clear");
                        } catch (Throwable error) {
                            finish(13, "FAIL IOS_NATIVE_STARTUP quest tracker", error); return;
                        }
                        finish(0, "PASS IOS_NATIVE_QUEST_TRACKER rendered on tab 2 and restored across six tabs\n"
                                + "PASS IOS_NATIVE_TAP_MOVEMENT correct targets across six tabs\n"
                                + "PASS IOS_NATIVE_CAPES fourteen capes leave all four measured costume necks clear\n"
                                + "PASS IOS_NATIVE_STARTUP downloaded data via NSURLSession and reached login", null);
                    }
                    if (System.nanoTime() - started > 300000000000L) {
                        finish(4, "FAIL IOS_NATIVE_STARTUP timeout: " + data.startupFailure, null);
                    }
                });
            }
        }, "ios-smoke-monitor");
        monitor.setDaemon(true); monitor.start();
        return application;
    }
    public static void main(String[] args) {
        try (NSAutoreleasePool pool = new NSAutoreleasePool()) {
            UIApplication.main(args, null, IOSStartupSmoke.class);
        }
    }
}
