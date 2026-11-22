package com.beatdz.langlalau;

import beatdz.*;
import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.TextInputListener;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.boot.GameM;
import com.beatdz.langlalau.handler.InputDialogHandler;
import com.beatdz.langlalau.handler.MyCrashHandler;
import com.listener.AppEventListener;
import com.listener.IDialogTextListener;
import com.listener.VoiceRecordPermissionCallback;
import com.tgame.model.Caption;
import org.lwjgl.opengl.Display;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Port.Info;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.lang.management.ManagementFactory;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Locale;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DesktopLauncher implements AppEventListener, IDialogTextListener {

    private static JDialog a;
    private static DesktopLauncher b;
    private static Vector c = new Vector();
    private static LwjglApplicationConfiguration config;

    public native int set(byte[] var1);

    public native byte[] jc(byte[] var1);

    public static void main(String[] var0) {
        b = new DesktopLauncher();
        MyCrashHandler crashHandler = new MyCrashHandler(b, var0);
        Thread.setDefaultUncaughtExceptionHandler(crashHandler);
        try {
            Gdx.files = new com.badlogic.gdx.backends.lwjgl.LwjglFiles();
            SoftwareRenderer.install(var0);
            Binary.a = "animesoft/1/";
            ClassLoader classLoader = DesktopLauncher.class.getClassLoader();
            try (InputStream inputStream = classLoader.getResourceAsStream("path.txt")) {
                if (inputStream != null) {
                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                        String line;
                        while ((line = reader.readLine()) != null) Binary.a = line;
                    }
                }
            } catch (IOException error) {
                error.printStackTrace();
            }
            AutoPro.update();
            // Initialize captions before the rendering thread can create a screen.
            Caption.loadVN();
            config = new LwjglApplicationConfiguration();
            config.foregroundFPS = 60;
            config.backgroundFPS = 15;
            config.vSyncEnabled = true;
            beatdz.FrameRate.install(fps -> {
                config.foregroundFPS = fps;
                Gdx.graphics.setVSync(fps == 60);
            });
            GameM.a((IDialogTextListener) b);
            short[] sc = Binary.b();
            config.width = sc[0];
            config.height = sc[1];
            config.addIcon("resource/icons/icon-128.png", FileType.Internal);
            config.addIcon("resource/icons/icon-32.png", FileType.Internal);
            config.addIcon("resource/icons/icon-16.png", FileType.Internal);
            config.title = "Làng Lá Blue";
            config.resizable = false;
            GameM.b(b);
            new LwjglApplication(GameM.l(), config);
            // Window creation and resizing belong to LWJGL's rendering thread.
            Gdx.app.postRunnable(() -> {
                crashHandler.graphicsReady();
                Gdx.app.log("Renderer", Gdx.gl.glGetString(7937));
            });
        } catch (Throwable error) {
            crashHandler.uncaughtException(Thread.currentThread(), error);
        }
    }

    public void a() {

    }

    public void a(VoiceRecordPermissionCallback var1) {
        var1.a();
    }

    public boolean b() {
        try {
            return AudioSystem.isLineSupported(Info.MICROPHONE);
        } catch (Exception var1) {
            return false;
        }
    }

    public void a(byte[] var1) {
        this.set(var1);
    }

    public byte[] b(byte[] var1) {
        return this.jc(var1);
    }

    public void a(TextInputListener var1, String var2, String var3, String var4) {
        if (a != null) {
            a.setVisible(false);
            a.setEnabled(true);
        }

        SwingUtilities.invokeLater(new InputDialogHandler(a, var1, var2, var3, var4));
    }

    public int a(String var1, String var2) {
        ImageIcon var3 = new ImageIcon("5.png");
        JOptionPane var5;
        (a = (var5 = new JOptionPane(var2, 0, -1, var3, (Object[]) null, (Object) null)).createDialog((Component) null, var1)).setAlwaysOnTop(true);
        a.setVisible(true);
        a.dispose();

        try {
            return Integer.parseInt(var5.getValue().toString());
        } catch (Exception var4) {
            return -1;
        }
    }

    public boolean c() {
        return Display.isCreated() && !Display.isVisible();
    }
}
