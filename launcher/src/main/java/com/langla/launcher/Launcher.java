package com.langla.launcher;

import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.security.MessageDigest;
import java.util.*;
import java.util.jar.JarFile;

/** Installs a verified update or recovers the game core supplied in the launcher. */
public final class Launcher {
    public static final String BASE = com.langla.config.Endpoints.UPDATE_BASE;
    private static final long MAX_CORE_BYTES = 256L * 1024 * 1024;
    private static final String MAIN = "com.beatdz.langlalau.DesktopLauncher";

    public static InputStream open(URL url) throws IOException {
        URLConnection connection = url.openConnection();
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(15000);
        connection.setUseCaches(false);
        return connection.getInputStream();
    }

    public static String md5(Path file) throws Exception { return hash(file, "MD5"); }

    static String hash(Path file, String algorithm) throws Exception {
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        try (InputStream input = Files.newInputStream(file)) {
            byte[] buffer = new byte[65536];
            int count;
            while ((count = input.read(buffer)) != -1) digest.update(buffer, 0, count);
        }
        StringBuilder result = new StringBuilder();
        for (byte value : digest.digest()) result.append(String.format("%02x", value & 255));
        return result.toString();
    }

    static boolean usableCore(Path file) {
        if (!Files.isRegularFile(file)) return false;
        try {
            if (Files.size(file) <= 8 || Files.size(file) > MAX_CORE_BYTES) return false;
            try (JarFile jar = new JarFile(file.toFile())) {
                java.util.jar.JarEntry entry = jar.getJarEntry(MAIN.replace('.', '/') + ".class");
                if (entry == null || entry.isDirectory()) return false;
                try (DataInputStream input = new DataInputStream(jar.getInputStream(entry))) {
                    if (input.readInt() != 0xcafebabe) return false;
                    input.readUnsignedShort();
                    int major = input.readUnsignedShort();
                    String javaVersion = System.getProperty("java.specification.version");
                    int runtime = Integer.parseInt(javaVersion.startsWith("1.") ? javaVersion.substring(2) : javaVersion);
                    return major >= 45 && major <= runtime + 44;
                }
            }
        } catch (Exception invalid) { return false; }
    }

    static void replace(Path source, Path target) throws IOException {
        try { Files.move(source, target, StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING); }
        catch (AtomicMoveNotSupportedException unsupported) { Files.move(source, target, StandardCopyOption.REPLACE_EXISTING); }
    }

    static void marker(Path target, String value) throws IOException {
        Path temporary = Files.createTempFile(target.getParent(), "marker-", ".tmp");
        try { Files.write(temporary, value.getBytes(StandardCharsets.UTF_8)); replace(temporary, target); }
        finally { Files.deleteIfExists(temporary); }
    }

    public static void update(Path home, String manifestUrl) throws Exception {
        JsonValue pc;
        try (InputStream input = open(new URL(manifestUrl))) { pc = new JsonReader().parse(input).get("pc"); }
        if (pc == null) return;
        UpdateTrust.verify(pc, new URL(manifestUrl));
        int version = pc.getInt("version", 0), installed = com.langla.config.Endpoints.BUILD;
        Path versionFile = home.resolve("client-version.txt");
        if (Files.isRegularFile(versionFile)) {
            try { installed = Math.max(installed, Integer.parseInt(new String(Files.readAllBytes(versionFile), StandardCharsets.UTF_8).trim())); }
            catch (NumberFormatException ignored) { }
        }
        if (version < installed) return;
        String expected = pc.getString("coreJarMd5"), buildId = pc.getString("buildId");
        String strong = pc.getString("coreJarSha256", "");
        long size = pc.getLong("coreJarSize");
        if (!expected.matches("[a-fA-F0-9]{32}") || size <= 8 || size > MAX_CORE_BYTES)
            throw new IOException("Invalid update metadata");
        Path game = home.resolve("game.jar");
        if (usableCore(game) && expected.equalsIgnoreCase(md5(game))
                && (strong.isEmpty() || strong.equalsIgnoreCase(hash(game, "SHA-256")))) {
            marker(home.resolve("client-build-id.txt"), buildId);
            marker(versionFile, Integer.toString(version));
            return;
        }
        Path temporary = home.resolve("game.jar.downloading");
        try {
            try (InputStream input = open(new URL(new URL(manifestUrl), pc.getString("coreJarUrl")));
                 OutputStream output = Files.newOutputStream(temporary)) {
                byte[] buffer = new byte[65536];
                long received = 0;
                int count;
                while ((count = input.read(buffer)) != -1) {
                    if ((received += count) > size) throw new IOException("Core download exceeds declared size");
                    output.write(buffer, 0, count);
                }
                if (received != size) throw new EOFException("Incomplete core download");
            }
            if (!expected.equalsIgnoreCase(md5(temporary)) || !usableCore(temporary)
                    || (!strong.isEmpty() && !strong.equalsIgnoreCase(hash(temporary, "SHA-256"))))
                throw new IOException("Core integrity check failed");
            if (usableCore(game)) Files.copy(game, home.resolve("game.jar.previous"), StandardCopyOption.REPLACE_EXISTING);
            replace(temporary, game);
            marker(home.resolve("client-build-id.txt"), buildId);
            marker(versionFile, Integer.toString(version));
        } finally { Files.deleteIfExists(temporary); }
    }

    static void installBundledCore(Path home) throws IOException {
        Path game = home.resolve("game.jar"), versionFile = home.resolve("client-version.txt");
        int bundled = com.langla.config.Endpoints.BUILD;
        boolean usable = usableCore(game);
        if (usable && Files.isRegularFile(versionFile)) {
            try {
                if (Integer.parseInt(new String(Files.readAllBytes(versionFile), StandardCharsets.UTF_8).trim()) >= bundled) return;
            } catch (NumberFormatException ignored) { }
        }
        Path temporary = Files.createTempFile(home, "bundled-game-", ".jar");
        try {
            try (InputStream input = Launcher.class.getResourceAsStream("/bootstrap/game.jar")) {
                if (input == null) throw new IOException("Missing bundled game core");
                Files.copy(input, temporary, StandardCopyOption.REPLACE_EXISTING);
            }
            if (!usableCore(temporary)) throw new IOException("Bundled game core is invalid or requires a newer Java runtime");
            if (usable) Files.copy(game, home.resolve("game.jar.previous"), StandardCopyOption.REPLACE_EXISTING);
            replace(temporary, game);
            Files.deleteIfExists(home.resolve("client-build-id.txt"));
            marker(versionFile, Integer.toString(bundled));
        } finally { Files.deleteIfExists(temporary); }
    }

    private static void launch(String[] args) throws Exception {
        Path home = Paths.get(".langla-test").toAbsolutePath();
        Files.createDirectories(home);
        Path game = home.resolve("game.jar");
        try (java.nio.channels.FileChannel channel = java.nio.channels.FileChannel.open(home.resolve("launch.lock"),
                StandardOpenOption.CREATE, StandardOpenOption.WRITE);
             java.nio.channels.FileLock lock = channel.lock()) {
            installBundledCore(home);
            String url = BASE + "version.json";
            Path override = Paths.get("update_url.txt");
            if (Files.isRegularFile(override)) url = new String(Files.readAllBytes(override), StandardCharsets.UTF_8).trim();
            try { update(home, url); }
            catch (Exception failure) { Files.write(home.resolve("update-error.log"), (failure.toString() + "\n").getBytes(StandardCharsets.UTF_8)); }
            if (!usableCore(game)) installBundledCore(home);
        }
        String executable = System.getProperty("os.name").toLowerCase(Locale.ROOT).contains("win") ? "java.exe" : "java";
        Path java = Paths.get(System.getProperty("java.home"), "bin", executable);
        if (!Files.isRegularFile(java)) throw new IOException("Thiếu runtime/bin/" + executable + ". Cần giải nén đầy đủ bộ game.");
        List<String> command = new ArrayList<>();
        command.add(java.toString());
        if (Boolean.getBoolean("langla.softwareRenderer")) command.add("-Dlangla.softwareRenderer=true");
        command.add("-cp");command.add(game.toString());command.add(MAIN);Collections.addAll(command, args);
        ProcessBuilder process = new ProcessBuilder(command).redirectErrorStream(true)
                .redirectOutput(ProcessBuilder.Redirect.appendTo(home.resolve("game.log").toFile()));
        System.exit(process.start().waitFor());
    }

    public static void main(String[] args) {
        try { launch(args); }
        catch (Throwable failure) {
            try {
                Path log = Paths.get("launcher-error.log").toAbsolutePath();
                try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(log))) { failure.printStackTrace(writer); }
                javax.swing.JOptionPane.showMessageDialog(null, "Không mở được game: " + failure.getMessage() + "\nChi tiết: " + log,
                        "Làng Lá Blue", javax.swing.JOptionPane.ERROR_MESSAGE);
            } catch (Throwable unavailable) { failure.printStackTrace(); }
            System.exit(1);
        }
    }
}
