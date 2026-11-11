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
    @Override protected IOSApplication createApplication() {
        IOSApplication application = super.createApplication();
        final long started = System.nanoTime();
        Thread monitor = new Thread(() -> {
            while (true) {
                try { Thread.sleep(1000); } catch (InterruptedException error) { return; }
                // Gdx.app is assigned before IOSApplication finishes creating its graphics backend.
                if (Gdx.app == null || Gdx.graphics == null) continue;
                Gdx.app.postRunnable(() -> {
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
                            System.err.println("FAIL IOS_NATIVE_STARTUP incomplete login data"); System.exit(3);
                        }
                        if (LangLa_fq.a(643).c <= 1) {
                            System.err.println("FAIL IOS_NATIVE_STARTUP missing base UI icon"); System.exit(11);
                        }
                        if (data.zoomLevel >= 3 && LangLa_fq.a(21137).c <= 1) {
                            if (optionalIconRequested == 0) optionalIconRequested = System.nanoTime();
                            if (System.nanoTime() - optionalIconRequested < 45_000_000_000L) return;
                            System.err.println("FAIL IOS_NATIVE_STARTUP deferred icon did not load"); System.exit(12);
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
                            System.err.println("FAIL IOS_NATIVE_STARTUP server selector hidden or unnamed"); System.exit(5);
                        }
                        login.a(1004, null, null);
                        boolean opened = false;
                        for (Object dialog : login.cD) opened |= dialog instanceof LangLa_bp;
                        if (!opened) {
                            System.err.println("FAIL IOS_NATIVE_STARTUP server picker did not open"); System.exit(6);
                        }
                        System.out.println("PASS IOS_NATIVE_SERVER_PICKER visible selected server=" + data.aP.getName()
                                + "; picker opened with newer-client flag enabled");
                        if (MultiSession.barHeight() <= 0) {
                            System.err.println("FAIL IOS_NATIVE_STARTUP x6 tab bar disabled"); System.exit(7);
                        }
                        java.util.Set<Session> sessions = new java.util.HashSet<>();
                        java.util.Set<DataCenter> centers = new java.util.HashSet<>();
                        java.util.Set<String> profiles = new java.util.HashSet<>();
                        for (int slot = 0; slot < MultiSession.LIMIT; slot++) {
                            if (slot > 0 && !MultiSession.add()) {
                                System.err.println("FAIL IOS_NATIVE_STARTUP cannot add x6 tab " + slot); System.exit(8);
                            }
                            sessions.add(Session.gI()); centers.add(DataCenter.gI());
                            profiles.add(MultiSession.storageName("arr_acc"));
                            beatdz.Char.gI().hp = 100 + slot;
                        }
                        if (MultiSession.add() || sessions.size() != 6 || centers.size() != 6 || profiles.size() != 6) {
                            System.err.println("FAIL IOS_NATIVE_STARTUP x6 account isolation or limit"); System.exit(9);
                        }
                        for (int slot = 0; slot < MultiSession.LIMIT; slot++) {
                            MultiSession.select(slot);
                            if (beatdz.Char.gI().hp != 100 + slot) {
                                System.err.println("FAIL IOS_NATIVE_STARTUP x6 switch lost account state"); System.exit(10);
                            }
                        }
                        MultiSession.select(0);
                        System.out.println("PASS IOS_NATIVE_X6 six independent tabs, profile paths and account switching");
                        System.out.println("PASS IOS_NATIVE_STARTUP downloaded data via NSURLSession and reached login");
                        System.out.flush(); System.exit(0);
                    }
                    if (System.nanoTime() - started > 300000000000L) {
                        System.err.println("FAIL IOS_NATIVE_STARTUP timeout: " + data.startupFailure); System.exit(4);
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
