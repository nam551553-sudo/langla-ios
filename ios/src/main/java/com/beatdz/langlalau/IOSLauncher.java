package com.beatdz.langlalau;
import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.uikit.UIApplication;
import com.badlogic.gdx.backends.iosrobovm.*;
import com.boot.GameM;
import org.robovm.apple.uikit.*;
import com.boot.MobilePlatform;
public class IOSLauncher extends IOSApplication.Delegate {
    @Override protected IOSApplication createApplication() {
        Object bundleVersion = org.robovm.apple.foundation.NSBundle.getMainBundle().getInfoDictionaryObject("CFBundleVersion");
        if (bundleVersion != null) System.setProperty("langla.ios.build", bundleVersion.toString());
        MobilePlatform.install();
        IOSApplicationConfiguration config = new IOSApplicationConfiguration();
        config.preferredFramesPerSecond = 60;
        config.hdpiMode = com.badlogic.gdx.graphics.glutils.HdpiMode.Pixels;
        config.orientationPortrait = false;
        config.orientationLandscape = true;
        config.statusBarVisible = false;
        config.hideHomeIndicator = true;
        IOSApplication app = new IOSApplication(GameM.l(), config);
        checkForUpdate(app);
        return app;
    }
    private void checkForUpdate(IOSApplication application) {
        Thread worker = new Thread(() -> {
            java.net.HttpURLConnection connection = null;
            try (NSAutoreleasePool pool = new NSAutoreleasePool()) {
                String base = "http://103.77.172.222/langlaapp/langla-test/";
                connection = (java.net.HttpURLConnection) new java.net.URL(base + "version.json?t=" + System.currentTimeMillis()).openConnection();
                connection.setConnectTimeout(5000); connection.setReadTimeout(5000); connection.setUseCaches(false);
                if (connection.getResponseCode() != 200) return;
                com.badlogic.gdx.utils.JsonValue manifest;
                try (java.io.InputStream stream = connection.getInputStream()) {
                    manifest = new com.badlogic.gdx.utils.JsonReader().parse(stream);
                }
                com.badlogic.gdx.utils.JsonValue ios = manifest.get("ios");
                if (ios == null) return;
                int current = Integer.parseInt(org.robovm.apple.foundation.NSBundle.getMainBundle().getInfoDictionaryObject("CFBundleVersion").toString());
                if (ios.getInt("version", 0) <= current) return;
                final String link = new java.net.URL(new java.net.URL(base), ios.getString("updateUrl", "downloads/ios.html")).toString();
                org.robovm.apple.foundation.NSOperationQueue.getMainQueue().addOperation(() -> {
                    UIViewController controller = application.getUIViewController();
                    while (controller.getPresentedViewController() != null) controller = controller.getPresentedViewController();
                    UIAlertController dialog = new UIAlertController("Cập nhật game", "Đã có bản iOS mới. Mở trang tải để cập nhật bằng cách cài đặt bạn đang sử dụng.", UIAlertControllerStyle.Alert);
                    dialog.addAction(new UIAlertAction("Cập nhật", UIAlertActionStyle.Default, action -> UIApplication.getSharedApplication().openURL(new org.robovm.apple.foundation.NSURL(link))));
                    dialog.addAction(new UIAlertAction("Để sau", UIAlertActionStyle.Cancel, action -> { }));
                    controller.presentViewController(dialog, true, null);
                });
            } catch (Exception error) { System.err.println("iOS update check: " + error.getMessage()); }
            finally { if (connection != null) connection.disconnect(); }
        }, "ios-update-check");
        worker.setDaemon(true); worker.start();
    }
    public static void main(String[] args) {
        try (NSAutoreleasePool pool = new NSAutoreleasePool()) {
            UIApplication.main(args, null, IOSLauncher.class);
        }
    }
}
