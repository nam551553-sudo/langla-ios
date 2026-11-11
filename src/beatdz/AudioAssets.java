package beatdz;

import com.badlogic.gdx.files.FileHandle;

final class AudioAssets {
    private AudioAssets() { }

    static FileHandle open(String group, int id) {
        FileHandle bundled = Utlis.internal(group + "/" + id + ".mp3");
        if (bundled.exists()) return bundled;

        // The NetBeans distribution can still contain the original extensionless files.
        String name = group + id;
        byte[] mp3 = Utlis.b(Utlis.internal(group + "/" + id).readBytes());
        Binary.write(name, mp3, "mp3");
        return Utlis.external(Binary.a + name + ".mp3");
    }

    static void cleanLegacyFiles(String group) {
        if (!Utlis.internal(group + "/0.mp3").exists()) Binary.deleteStartsWith(group);
    }
}
