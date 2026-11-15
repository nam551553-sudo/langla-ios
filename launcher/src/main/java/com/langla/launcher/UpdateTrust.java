package com.langla.launcher;

import com.badlogic.gdx.utils.JsonValue;
import java.io.*;
import java.net.URL;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;
import java.util.Locale;
import java.util.regex.*;

/** The verification key ships with the launcher, never with an untrusted manifest. */
final class UpdateTrust {
    static final String ALGORITHM = "rsa-sha256-v1";
    private static final PublicKey KEY = loadKey();

    static String payload(JsonValue pc) throws IOException {
        String id = pc.getString("buildId", ""), url = pc.getString("coreJarUrl", "");
        String md5 = pc.getString("coreJarMd5", "").toLowerCase(Locale.ROOT);
        String sha256 = pc.getString("coreJarSha256", "").toLowerCase(Locale.ROOT);
        long size = pc.getLong("coreJarSize", -1);
        int version = pc.getInt("version", -1);
        if (version < 0 || size <= 8 || size > 256L * 1024 * 1024
                || !id.matches("[A-Za-z0-9_.-]{1,128}") || url.isEmpty() || url.length() > 2048
                || url.indexOf('\n') >= 0 || url.indexOf('\r') >= 0
                || !md5.matches("[a-f0-9]{32}") || !sha256.matches("[a-f0-9]{64}"))
            throw new IOException("Invalid signed update metadata");
        return "LangLa-PC-update-v1\n" + version + "\n" + id + "\n" + url + "\n" + size + "\n" + md5 + "\n" + sha256 + "\n";
    }

    static void verify(JsonValue pc, URL manifest) throws IOException {
        String signature = pc.getString("signature", "");
        // Explicit local developer fixtures cannot be served over the network.
        if (signature.isEmpty() && "file".equalsIgnoreCase(manifest.getProtocol())) return;
        if (!ALGORITHM.equals(pc.getString("signatureAlgorithm", "")) || signature.length() > 2048)
            throw new IOException("Update manifest is not signed by the game publisher");
        try {
            Signature verifier = Signature.getInstance("SHA256withRSA");
            verifier.initVerify(KEY);
            verifier.update(payload(pc).getBytes(StandardCharsets.UTF_8));
            if (!verifier.verify(Base64.getDecoder().decode(signature))) throw new IOException("Update signature does not match");
        } catch (GeneralSecurityException | IllegalArgumentException invalid) {
            throw new IOException("Invalid update signature", invalid);
        }
    }

    private static PublicKey loadKey() {
        try (InputStream input = UpdateTrust.class.getResourceAsStream("/update-public-key.xml")) {
            if (input == null) throw new IOException("Missing update verification key");
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];int count;
            while ((count = input.read(buffer)) != -1) {
                if (bytes.size() + count > 8192) throw new IOException("Invalid update verification key");
                bytes.write(buffer, 0, count);
            }
            String xml = new String(bytes.toByteArray(), StandardCharsets.UTF_8);
            return KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(number(xml, "Modulus"), number(xml, "Exponent")));
        } catch (Exception invalid) { throw new ExceptionInInitializerError(invalid); }
    }

    private static BigInteger number(String xml, String name) throws IOException {
        Matcher match = Pattern.compile("<" + name + ">([A-Za-z0-9+/=]+)</" + name + ">").matcher(xml);
        if (!match.find()) throw new IOException("Invalid update verification key");
        return new BigInteger(1, Base64.getDecoder().decode(match.group(1)));
    }

    private UpdateTrust() { }
}
