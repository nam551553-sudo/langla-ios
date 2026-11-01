package com.beatdz.langlalau.handler;

import com.badlogic.gdx.utils.GdxRuntimeException;
import com.boot.GameM;
import com.beatdz.langlalau.DesktopLauncher;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread.UncaughtExceptionHandler;

public class MyCrashHandler implements UncaughtExceptionHandler {

    DesktopLauncher a;

    public MyCrashHandler(DesktopLauncher var1) {
        this.a = var1;
    }

    public void uncaughtException(Thread var1, Throwable var2) {
        if (!(var2 instanceof IncompatibleClassChangeError)) {
            StringWriter var16;
            (var16 = new StringWriter()).append("Max memory: ").append(String.valueOf(Runtime.getRuntime().maxMemory())).append("\n");
            var16.append("Total memory: ").append(String.valueOf(Runtime.getRuntime().totalMemory())).append("\n");
            var16.append("Free memory: ").append(String.valueOf(Runtime.getRuntime().freeMemory())).append("\n");
            var16.append("Used memory: ").append(String.valueOf(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory())).append("\n");
            var2.printStackTrace(new PrintWriter(var16));
//         String var10000 = "C:\\LangLa\\support\\crash" + System.currentTimeMillis() + ".log";
//         byte[] var3 = var16.toString().getBytes();
//         String var17 = var10000;
//         Object var4 = null;
//         Object var5 = null;
//
//         try {
//            FileOutputStream var18;
//            (var18 = new FileOutputStream(var17)).write(var3);
//            var18.close();
//         } catch (Exception var13) {
//         } finally {
//            try {
//               if (var5 != null) {
//                  ((BufferedWriter)var5).close();
//               }
//
//               if (var4 != null) {
//                  ((OutputStreamWriter)var4).close();
//               }
//            } catch (Exception var12) {
//            }
//
//         }

            if (var2 instanceof GdxRuntimeException) {
                if (var2.getMessage().contains("OpenGL")) {
                    try {
                        String var17 = System.getenv("PROCESSOR_ARCHITECTURE");
                        String var19 = System.getenv("PROCESSOR_ARCHITEW6432");
                        var17 = (var17 == null || !var17.endsWith("64")) && (var19 == null || !var19.endsWith("64")) ? "32" : "64";
                        File var20;
                        if (!(var20 = new File("jre\\bin\\opengl32.dll")).exists()) {
                            a(new File("support\\x" + var17 + "\\opengl32.dll"), var20);
                            this.a.a();
                            return;
                        }
                    } catch (IOException var15) {
                    }

                    this.a.a("Thông Báo", "Vui lòng cập nhật trình điều khiển (driver) cho máy tính của bạn và thử lại mở lại game.\nThân ái!");
                    return;
                }

                if (var2.getMessage().contains("java.lang.OutOfMemoryError")) {
                    GameM.m();
                    GameM.gI().k();
                    return;
                }

                this.a.a("Thông Báo", "Rất tiếc! Trò chơi đã dừng hoạt động trên thiết bị của bạn.\n Vui lòng liên hệ BQT để được hổ trợ. Thân ái!");
                System.exit(0);
            }

        }
    }

    private static void a(File var0, File var1) throws java.io.IOException {
        FileInputStream var2 = null;
        FileOutputStream var3 = null;

        try {
            var2 = new FileInputStream(var0);
            var3 = new FileOutputStream(var1);
            byte[] var6 = new byte[1024];

            int var7;
            while ((var7 = var2.read(var6)) > 0) {
                var3.write(var6, 0, var7);
            }
        } finally {
            var2.close();
            var3.close();
        }

    }
}
