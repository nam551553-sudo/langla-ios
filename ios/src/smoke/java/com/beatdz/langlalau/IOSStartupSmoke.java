package com.beatdz.langlalau;

import beatdz.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.iosrobovm.IOSApplication;
import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.uikit.UIApplication;

/** CI-only entry point; excluded from the shipping app's source set. */
public class IOSStartupSmoke extends IOSLauncher {
    @Override protected IOSApplication createApplication() {
        IOSApplication application = super.createApplication();
        final long started = System.nanoTime();
        Thread monitor = new Thread(() -> {
            while (true) {
                try { Thread.sleep(1000); } catch (InterruptedException error) { return; }
                if (Gdx.app == null) continue;
                Gdx.app.postRunnable(() -> {
                    DataCenter data = DataCenter.gI();
                    System.out.println("IOS_SMOKE phase=" + data.startupPhase + " bytes=" + Session.gI().countRecv
                            + " screen=" + (data.currentScreen == null ? "null" : data.currentScreen.getClass().getSimpleName()));
                    if (data.currentScreen instanceof LoginPCScreen) {
                        if (!HttpDownloads.isNative() || !data.ba || !data.bb || data.MapTemplate == null
                                || data.aP == null || data.arrayServers == null || data.arrayServers.length == 0) {
                            System.err.println("FAIL IOS_NATIVE_STARTUP incomplete login data"); System.exit(3);
                        }
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
