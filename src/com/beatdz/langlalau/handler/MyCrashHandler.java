package com.beatdz.langlalau.handler;

import com.beatdz.langlalau.DesktopLauncher;
import com.beatdz.langlalau.SoftwareRenderer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.Thread.UncaughtExceptionHandler;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

public final class MyCrashHandler implements UncaughtExceptionHandler {
    private final DesktopLauncher launcher;
    private final String[] arguments;
    private final Thread startupThread;
    private final AtomicBoolean handling = new AtomicBoolean();
    private volatile boolean graphicsReady;

    public MyCrashHandler(DesktopLauncher launcher, String[] arguments) {
        this.launcher = launcher;
        this.arguments = arguments.clone();
        this.startupThread = Thread.currentThread();
    }

    public void graphicsReady() {
        graphicsReady = true;
    }

    @Override
    public void uncaughtException(Thread thread, Throwable error) {
        error.printStackTrace(System.err);
        File log = new File("support/logs/last-crash.log");
        try {
            log.getParentFile().mkdirs();
            try (PrintWriter writer = new PrintWriter(new OutputStreamWriter(
                    new FileOutputStream(log), StandardCharsets.UTF_8))) {
                writer.println("Thread: " + thread.getName());
                error.printStackTrace(writer);
            }
        } catch (Exception logError) {
            logError.printStackTrace(System.err);
        }
        // A failed download worker must not close the entire game.
        if (thread != startupThread && !"LWJGL Application".equals(thread.getName())) return;
        if (!handling.compareAndSet(false, true)) return;
        if (!graphicsReady && !Boolean.getBoolean("langla.softwareRenderer")
                && System.getProperty("os.name", "").startsWith("Windows")
                && isGraphicsFailure(error)) {
            try {
                System.exit(SoftwareRenderer.relaunch(arguments));
                return;
            } catch (InterruptedException interrupted) {
                Thread.currentThread().interrupt();
                interrupted.printStackTrace(System.err);
            } catch (Exception retryError) {
                retryError.printStackTrace(System.err);
            }
        }
        try {
            launcher.a("Thông báo", "Không thể tiếp tục chạy game.\n"
                    + "Chi tiết lỗi: " + log.getAbsolutePath() + "\n"
                    + error.getClass().getSimpleName() + ": " + String.valueOf(error.getMessage()));
        } catch (Throwable dialogError) {
            dialogError.printStackTrace(System.err);
        }
        System.exit(1);
    }

    static boolean isGraphicsFailure(Throwable error) {
        for (Throwable cause = error; cause != null; cause = cause.getCause()) {
            String message = String.valueOf(cause.getMessage()).toLowerCase(Locale.ROOT);
            if (message.contains("opengl") || message.contains("pixel format")
                    || message.contains("could not create context")) return true;
        }
        return false;
    }
}