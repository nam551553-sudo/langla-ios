package com.beatdz.langlalau;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Optional bundled Mesa backend for Windows machines without a usable graphics driver. */
public final class SoftwareRenderer {
    private SoftwareRenderer() { }

    public static void install(String[] arguments) {
        boolean enabled = Boolean.getBoolean("langla.softwareRenderer");
        for (String argument : arguments) if ("--software".equals(argument)) enabled = true;
        if (!enabled) return;
        if (!System.getProperty("os.name", "").startsWith("Windows"))
            throw new IllegalStateException("Software renderer bundle is for Windows only");
        String architecture = System.getProperty("os.arch", "").contains("64") ? "x64" : "x32";
        FileHandle source = Gdx.files.internal("support/" + architecture + "/opengl32.dll");
        // The inherited support folders are mislabeled; inspect the PE machine instead.
        int expectedMachine = "x64".equals(architecture) ? 0x8664 : 0x014c;
        if (machine(source.readBytes()) != expectedMachine)
            source = Gdx.files.internal("support/" + ("x64".equals(architecture) ? "x32" : "x64") + "/opengl32.dll");
        if (machine(source.readBytes()) != expectedMachine)
            throw new IllegalStateException("Bundled Mesa architecture does not match Java");
        FileHandle target = Gdx.files.local("support/runtime-renderer/" + architecture + "/opengl32.dll");
        if (!target.exists() || target.length() != source.length()) source.copyTo(target);
        System.setProperty("org.lwjgl.opengl.Display.allowSoftwareOpenGL", "true");
        System.setProperty("langla.softwareRenderer", "true");
        System.load(target.file().getAbsolutePath());
        System.out.println("Bundled Mesa loaded: " + architecture);
    }

    /** A new JVM is required because LWJGL has already loaded the failing driver. */
    public static int relaunch(String[] arguments) throws IOException, InterruptedException {
        List<String> command = new ArrayList<>();
        command.add(new File(System.getProperty("java.home"), "bin/java.exe").getAbsolutePath());
        command.add("-Dfile.encoding=UTF-8");
        command.add("-Dlangla.softwareRenderer=true");
        command.add("-cp");
        command.add(System.getProperty("java.class.path"));
        command.add(DesktopLauncher.class.getName());
        Collections.addAll(command, arguments);
        File log = new File("support/logs/software-renderer.log");
        log.getParentFile().mkdirs();
        System.err.println("[Startup] Graphics driver unavailable; retrying with bundled Mesa. Log: " + log.getAbsolutePath());
        return new ProcessBuilder(command).redirectErrorStream(true)
                .redirectOutput(ProcessBuilder.Redirect.appendTo(log)).start().waitFor();
    }

    private static int machine(byte[] data) {
        int offset = (data[60] & 255) | (data[61] & 255) << 8 | (data[62] & 255) << 16 | (data[63] & 255) << 24;
        return (data[offset + 4] & 255) | (data[offset + 5] & 255) << 8;
    }
}
