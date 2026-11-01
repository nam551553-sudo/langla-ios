package beatdz;

import beatdz.*;

import beatdz.DataCenter;
import com.badlogic.gdx.files.FileHandle;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Hashtable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Binary {

    public static String a = "LangLaZ/";
    private static byte[] b = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73, 72, 68, 82, 0, 0, 0, 2, 0, 0, 0, 2, 8, 6, 0, 0, 0, 114, -74, 13, 36, 0, 0, 0, 11, 73, 68, 65, 84, 120, 94, 99, 96, 64, 7, 0, 0, 18, 0, 1, 11, -69, 36, -100, 0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126};

    public static Reader createReader(String var0) {
        byte[] var1;
        return (var1 = read(var0)) != null ? new Reader(var1) : null;
    }

    public static short[] a() {
        Reader var0 = null;

        try {
            if ((var0 = createReader("arr_keys")) != null) {
                short[] var1 = new short[]{var0.dis.readShort(), var0.dis.readShort(), var0.dis.readShort(), var0.dis.readShort(), var0.dis.readShort(), var0.dis.readShort(), var0.dis.readShort(), var0.dis.readShort(), var0.dis.readShort(), var0.dis.readShort()};
                return var1;
            }
        } catch (Exception var4) {
            Utlis.println(var4);
        } finally {
            if (var0 != null) {
                var0.close();
            }

        }

        return new short[]{45, 51, 33, 46, 48, 19, 20, 21, 22, 34};
    }

    public static short[] b() {
        Reader var0 = null;

        short[] var1;
        try {
            if ((var0 = createReader("arr_screen")) == null) {
                return new short[]{1024, 600};
            }

            var1 = new short[]{var0.dis.readShort(), var0.dis.readShort()};
        } catch (Exception var4) {
            Utlis.println(var4);
            return new short[]{1024, 600};
        } finally {
            if (var0 != null) {
                var0.close();
            }

        }

        return var1;
    }

    public static byte[] b(String var0) {
        return a(var0, (ByteArrayOutputStream) null, (byte[]) null, new int[1], new int[1], 2);
    }

    public static byte[] c(String var0) {
        return a(var0, (ByteArrayOutputStream) null, (byte[]) null, new int[1], new int[1], 4);
    }

    private static byte[] a(String var0, ByteArrayOutputStream var1, byte[] var2, int[] var3, int[] var4, int var5) {
        while (true) {
            if (beatdz.DataCenter.$state_DataCenter().ar) {
                var5 = 1;
            }

            var0 = Utlis.i(var0);
            int var10002 = var4[0]++;
            HttpURLConnection var6 = null;
            BufferedInputStream var7 = null;
            byte[] var8 = null;
            boolean var19 = false;

            label274:
            {
                try {
                    var19 = true;
                    (var6 = (HttpURLConnection) (new URL(var0)).openConnection()).setConnectTimeout(beatdz.Utlis.$state_Utlis().timeOut);
                    var6.setReadTimeout(beatdz.Utlis.$state_Utlis().timeOut * 2);
                    var6.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.0.0 Safari/537.36");
                    if (var3[0] > 0) {
                        var6.setRequestProperty("Range", "bytes=" + var3[0] + "-");
                    }

                    var7 = new BufferedInputStream(var6.getInputStream());
                    if (var1 == null) {
                        var1 = new ByteArrayOutputStream();
                    }

                    byte[] var9 = new byte[524288];

                    int var10;
                    while ((var10 = var7.read(var9)) != -1) {
                        Session var10000 = Session.gI();
                        var10000.countRecv += var10;
                        var10000 = Session.gI();
                        var10000.k += var10;
                        var1.write(var9, 0, var10);
                        var3[0] += var10;

                    }

                    var1.flush();
                    if (var2 == null) {
                        var8 = var1.toByteArray();
                    } else {
                        var9 = var1.toByteArray();
                        var8 = new byte[var2.length + var9.length];
                        System.arraycopy(var2, 0, var8, 0, var2.length);
                        System.arraycopy(var9, 0, var8, var2.length, var9.length);
                    }

                    var1.close();
                    var19 = false;
                    break label274;
                } catch (Exception var26) {
                    var19 = false;
                } finally {
                    if (var19) {
                        try {
                            if (var7 != null) {
                                var7.close();
                            }
                        } catch (Exception var21) {
                            Utlis.println(var21);
                        }

                        try {
                            if (var1 != null) {
                                var1.close();
                            }
                        } catch (Exception var20) {
                            Utlis.println(var20);
                        }

                        if (var6 != null) {
                            var6.disconnect();
                        }

                        if (var1 == null) {
                            if (Utlis.haveNetwork() && var4[0] <= var5) {
                                var4 = var4;
                                var3 = var3;
                                var2 = var2;
                                var1 = var1;
                                var0 = var0;
                                continue;
                            }

                            return null;
                        }

                    }
                }

                try {
                    if (var7 != null) {
                        var7.close();
                    }
                } catch (Exception var23) {
                    Utlis.println(var23);
                }

                try {
                    if (var1 != null) {
                        var1.close();
                    }
                } catch (Exception var22) {
                    Utlis.println(var22);
                }

                if (var6 != null) {
                    var6.disconnect();
                }

                if (var1 == null) {
                    if (Utlis.haveNetwork() && var4[0] <= var5) {
                        var4 = var4;
                        var3 = var3;
                        var2 = var2;
                        var1 = var1;
                        var0 = var0;
                        continue;
                    }

                    return null;
                }

                return var8;
            }

            try {
                var7.close();
            } catch (Exception var25) {
                Utlis.println(var25);
            }

            try {
                if (var1 != null) {
                    var1.close();
                }
            } catch (Exception var24) {
                Utlis.println(var24);
            }

            if (var6 != null) {
                var6.disconnect();
            }

            if (var1 == null) {
                if (Utlis.haveNetwork() && var4[0] <= var5) {
                    var4 = var4;
                    var3 = var3;
                    var2 = var2;
                    var1 = var1;
                    var0 = var0;
                    continue;
                }

                return null;
            }

            String assetPath = var0.toLowerCase(java.util.Locale.ROOT);
            if (var8 != null && ((assetPath.endsWith(".png") && !isImageData(var8))
                    || (assetPath.endsWith(".zip") && (var8.length < 4 || var8[0] != 'P' || var8[1] != 'K')))) {
                com.badlogic.gdx.Gdx.app.error("Assets", "Rejected non-asset response: " + var0);
                return null;
            }
            return var8;
        }
    }

    public static boolean isImageData(byte[] data) {
        if (data == null || data.length < 8) return false;
        if ((data[0] == (byte)0x89 && data[1] == 80 && data[2] == 78 && data[3] == 71)
                || (data[0] == (byte)0xff && data[1] == (byte)0xd8)) return true;
        return data.length >= 51 && ((data[50] == (byte)0x89 && data[49] == 80 && data[48] == 78 && data[47] == 71)
                || (data[50] == (byte)0xff && data[49] == (byte)0xd8));
    }

    public static String d(String var0) {
        HttpURLConnection var1 = null;
        BufferedReader var2 = null;
        String var3 = "";
        boolean var9 = false;

        label131:
        {
            try {
                var9 = true;
                (var1 = (HttpURLConnection) (new URL(var0)).openConnection()).setConnectTimeout(3000);
                var1.setReadTimeout(3000);
                var1.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.0.0 Safari/537.36");

                for (var2 = new BufferedReader(new InputStreamReader(var1.getInputStream(), "UTF-8")); (var0 = var2.readLine()) != null; var3 = var3 + var0 + "\r\n") {
                }

                var9 = false;
                break label131;
            } catch (Exception var13) {
                var9 = false;
            } finally {
                if (var9) {
                    try {
                        if (var2 != null) {
                            var2.close();
                        }
                    } catch (Exception var10) {
                        Utlis.println(var10);
                    }

                    if (var1 != null) {
                        var1.disconnect();
                    }

                }
            }

            try {
                if (var2 != null) {
                    var2.close();
                }
            } catch (Exception var11) {
                Utlis.println(var11);
            }

            if (var1 != null) {
                var1.disconnect();
            }

            return var3;
        }

        try {
            var2.close();
        } catch (Exception var12) {
            Utlis.println(var12);
        }

        if (var1 != null) {
            var1.disconnect();
        }

        return var3;
    }

    /** Bounded text fetch: the old counter incremented toward integer overflow and retried forever. */
    public static String a(String url, int attempts) {
        int limit = Math.max(1, attempts);
        for (int attempt = 0; attempt < limit; attempt++) {
            HttpURLConnection connection = null;
            try {
                connection = (HttpURLConnection)new URL(url).openConnection();
                connection.setConnectTimeout(Math.min(10000, beatdz.Utlis.$state_Utlis().timeOut));
                connection.setReadTimeout(Math.min(15000, beatdz.Utlis.$state_Utlis().timeOut * 2));
                connection.setRequestProperty("User-Agent", "LangLaTest");
                if (connection.getResponseCode() != 200) throw new java.io.IOException("Text HTTP " + connection.getResponseCode());
                StringBuilder text = new StringBuilder();
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        if (text.length() + line.length() > 1024 * 1024) throw new java.io.IOException("Text response too large");
                        text.append(line).append("\r\n");
                    }
                }
                if (text.length() > 0) return text.toString();
            } catch (Exception error) {
                if (attempt + 1 == limit && com.badlogic.gdx.Gdx.app != null) com.badlogic.gdx.Gdx.app.error("Startup", "Text download failed after " + limit + " attempts", error);
            } finally { if (connection != null) connection.disconnect(); }
            if (attempt + 1 < limit) Utlis.sleep(250L);
        }
        return null;
    }

    public static synchronized byte[] read(String var0) {
        if (mConfig.isGDL() > 1) {
            if (var0.contains("tree_") || var0.contains("char_") || var0.contains("client_") || var0.contains("mapmini_") || var0.contains("mapsmall_")) {
                return b;
            }
        } else if (mConfig.isGDL() == 1 && (var0.contains("tree_") || var0.contains("char_") || var0.contains("mapsmall_"))) {
            return b;
        }

        mFileHandle var1 = null;
        byte[] var2 = null;
        boolean var10 = false;

        label275:
        {
            try {
                var10 = true;
                if ((var2 = (var1 = mFileHandle.a(Binary2.a(var0), false)).a(1)) == null) {
                    int var3 = DataCenter.gI().zoomLevel;
                    if (var0.contains("tree") && var3 >= 2) {
                        var3 = 2;
                    }

                    if (!var0.equals("arr_data_game") && !var0.equals("arr_check_0")) {
                        var1 = mFileHandle.b("data/" + var3 + "/" + var0 + ".beatdz", false);
                    } else {
                        var1 = mFileHandle.b("data/" + var0 + ".beatdz", false);
                    }

                    if ((var2 = var1.a(1)) != null && var0.equals("arr_check_0")) {
                        try {
                            var3 = Integer.parseInt(new String(var2, "UTF-8"));
                            writeInt(var0, var3);
                            DataCenter.gI().a(true);
                        } catch (Exception var14) {
                        }
                    }
                }

                if (var2 != null) {
                    if (var0.equals("arr_data_game")) {
                        var2 = Utlis.inflateByteArray(var2);
                        var10 = false;
                    } else if (!var0.contains("size")) {
                        if (!var0.contains("mapmini") && !var0.contains("mapsmall") && !var0.contains("mapscale") && !var0.contains("char_") && !var0.contains("client_") && !var0.contains("tree_") && !var0.contains("font_")) {
                            var10 = false;
                        } else {
                            if (!isImageData(var2)) return null;
                            Utlis.a(var2);
                            var10 = false;
                        }
                    } else {
                        var10 = false;
                    }
                } else {
                    var10 = false;
                }
                break label275;
            } catch (Exception var15) {
                Utlis.println(var15);
                var10 = false;
            } finally {
                if (var10) {
                    try {
                        if (var1 != null) {
                            var1.a = null;
                        }
                    } catch (Exception var11) {
                        Utlis.println(var11);
                    }

                }
            }

            try {
                if (var1 != null) {
                    var1.a = null;
                    return var2;
                }
            } catch (Exception var12) {
                Utlis.println(var12);
            }

            return var2;
        }

        try {
            if (var1 != null) {
                var1.a = null;
            }
        } catch (Exception var13) {
            Utlis.println(var13);
        }

        return var2;
    }

    public static int readInt(String var0) {
        try {
            return Integer.parseInt(readUTF(var0));
        } catch (Exception var1) {
            return Integer.MIN_VALUE;
        }
    }

    public static boolean readBoolan(String var0) {
        byte[] var1;
        if ((var1 = read(var0)) == null) {
            return false;
        } else {
            return var1[0] != 0;
        }
    }

    public static String readUTF(String var0) {
        Object var1 = null;

        try {
            byte[] var3;
            return (var3 = read(var0)) == null ? null : new String(var3, "UTF-8");
        } catch (Exception var2) {
            Utlis.println(var2);
            return new String((byte[]) var1);
        }
    }

    public static synchronized void write(String var0, byte[] var1) {
        if (var0.contains("arr_map_") || var0.contains("arr_data_game") || beatdz.LangLa_ep.$state_LangLa_ep().g <= 0 || mConfig.isGDL() <= 0) {
            mFileHandle var2 = null;
            boolean var8 = false;

            label103:
            {
                try {
                    var8 = true;
                    if ((var2 = mFileHandle.a(Binary2.a(var0), true)).a() > 0) {
                        var2.a(1, var1, 0, var1.length);
                        var8 = false;
                    } else {
                        var2.a(var1, 0, var1.length);
                        var8 = false;
                    }
                    break label103;
                } catch (Exception var12) {
                    var8 = false;
                } finally {
                    if (var8) {
                        try {
                            if (var2 != null) {
                                var2.a = null;
                            }
                        } catch (Exception var9) {
                            Utlis.println(var9);
                        }

                    }
                }

                try {
                    if (var2 != null) {
                        var2.a = null;
                    }

                    return;
                } catch (Exception var10) {
                    Utlis.println(var10);
                    return;
                }
            }

            try {
                if (var2 != null) {
                    var2.a = null;
                }

            } catch (Exception var11) {
                Utlis.println(var11);
            }
        }
    }

    public static void write(String var0, byte[] var1, String var2) {
        if (var0.contains("arr_map_") || var0.contains("arr_data_game") || beatdz.LangLa_ep.$state_LangLa_ep().g <= 0 || mConfig.isGDL() <= 0) {
            mFileHandle var3 = null;
            boolean var9 = false;

            label104:
            {
                try {
                    var9 = true;
                    if ((var3 = mFileHandle.a(Binary2.a(var0, var2), true)).a() > 0) {
                        var3.a(1, var1, 0, var1.length);
                        var9 = false;
                    } else {
                        var3.a(var1, 0, var1.length);
                        var9 = false;
                    }
                    break label104;
                } catch (Exception var13) {
                    Utlis.println(var13);
                    var9 = false;
                } finally {
                    if (var9) {
                        try {
                            if (var3 != null) {
                                var3.a = null;
                            }
                        } catch (Exception var11) {
                            Utlis.println(var11);
                        }

                    }
                }

                try {
                    if (var3 != null) {
                        var3.a = null;
                    }

                    return;
                } catch (Exception var10) {
                    Utlis.println(var10);
                    return;
                }
            }

            try {
                if (var3 != null) {
                    var3.a = null;
                }

            } catch (Exception var12) {
                Utlis.println(var12);
            }
        }
    }

    public static void writeUTF(String var0, String var1) {
        try {
            Binary.write(var0, var1.getBytes("UTF-8"));
        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    public static void writeInt(String var0, int var1) {
        try {
            Binary.write(var0, String.valueOf(var1).getBytes("UTF-8"));
        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    public static void writeBoolean(String var0, boolean var1) {
        try {
            Binary.write(var0, new byte[]{(byte) (var1 ? 1 : 0)});
        } catch (Exception var2) {
            Utlis.println(var2);
        }
    }

    public static mImage createImage(String var0) {
        try {
            byte[] var2;
            return mImage.a(var2 = read(var0), 0, var2.length);
        } catch (Exception var1) {
            return null;
        }
    }

    public static mImage createImage(byte[] var0) {
        try {
            return mImage.a(var0, 0, var0.length);
        } catch (Exception var1) {
            Utlis.println(var1);
            return null;
        }
    }

    public static mImage createImage(int var0, int var1) {
        try {
            return mImage.a(var0, var1);
        } catch (Exception var2) {
            Utlis.println(var2);
            return null;
        }
    }

    public static void disposeImage(mImage var0) {
        if (var0 != null) {
            var0.d();
        }

    }

    public static void cleanImage(mImage var0) {
        if (var0 != null) {
            var0 = var0;

            try {
                if (var0.equals(beatdz.LangLa_fq.$state_LangLa_fq().a)) {
                    return;
                }

                if (var0.b != null) {
                    var0.b.dispose();
                    var0.b = null;
                }

                if (var0.a != null) {
                    var0.a.dispose();
                    var0.a = null;
                }

                return;
            } catch (Exception var1) {
                Utlis.println(var1);
            }
        }

    }

    public static void delete(String var0) {
        try {
            // Classify cache keys before their suffix; arr_check_0.beatdz is core data,
            // not an image-archive marker under images-hd1/zN.
            boolean suffix = var0.endsWith(".beatdz");
            String key = suffix ? var0.substring(0, var0.length() - 7) : var0;
            Utlis.external(a + MobileAssets.cacheName(MultiSession.storageName(key)) + (suffix ? ".beatdz" : "")).delete();
        } catch (Exception var1) {
            Utlis.println(var1);
        }
    }

    public static void deleteStartsWith(String var0) {
        try {
            FileHandle prefix = Utlis.external(a + MobileAssets.cacheName(MultiSession.storageName(var0)));
            FileHandle[] var1;
            int var2 = (var1 = prefix.parent().list()).length;

            for (int var3 = 0; var3 < var2; ++var3) {
                FileHandle var4;
                if ((var4 = var1[var3]).name().startsWith(prefix.name())) {
                    var4.delete();
                }
            }

        } catch (Exception var5) {
            Utlis.println(var5);
        }
    }

    public static void deleteAll() {
        if (DataCenter.k()) {
            DataCenter.gI().aG = true;
        }

        try {
            FileHandle[] var0;
            int var1 = (var0 = Utlis.external(a).list()).length;

            for (int var2 = 0; var2 < var1; ++var2) {
                FileHandle var3 = var0[var2];

                try {
                    if (!var3.name().startsWith("arr_acc") && !var3.name().startsWith("arr_config") && !var3.name().startsWith("arr_screen") && !var3.name().startsWith("arr_server") && !var3.name().startsWith("arr_binary")) {
                        var3.delete();
                    }
                } catch (Exception var4) {
                }
            }

            DataCenter var6;
            DataCenter var10000 = var6 = DataCenter.gI();
            beatdz.DataCenter.$state_DataCenter().aQ = 0;
            var10000.typeArr = var6.A = var6.B = var6.D = var6.C = 0;
            beatdz.CheckVersionScreen.$state_CheckVersionScreen().b = false;
            beatdz.DataCenter.$state_DataCenter().bd = 0;
        } catch (Exception var5) {
            Utlis.println(var5);
        }

        DataCenter.gI().setScreen((MainScreen) (new LangLa_ff()));
    }

    public static void a(byte[] var0, boolean var1) {
        ZipInputStream var2 = null;
        boolean var13 = false;

        label152:
        {
            try {
                var13 = true;
                var2 = new ZipInputStream(new ByteArrayInputStream(var0));

                ZipEntry var20;
                while ((var20 = var2.getNextEntry()) != null) {
                    try {
                        ByteArrayOutputStream var3 = new ByteArrayOutputStream();
                        byte[] var4 = new byte[524288];

                        int var5;
                        while ((var5 = var2.read(var4)) != -1) {
                            var3.write(var4, 0, var5);
                        }

                        var3.flush();
                        String var21 = var20.getName().replaceAll("bitmapC", "c").replaceAll("iconTree", "tree").replaceAll("iconChar", "char_icon").replaceAll("iconClient", "client_icon").replaceAll("/", "_").replaceAll(".png", "").replaceAll(".beatdz", "");
                        byte[] var25;
                        if ((var25 = var3.toByteArray()).length > 0) {
                            Binary.write(var21, var25);
                            if (var1) {
                                String[] var23;
                                short var6 = Short.parseShort((var23 = var21.split("_"))[var23.length - 1]);
                                Hashtable var24;
                                if (var21.contains("char")) {
                                    var24 = beatdz.LangLa_fq.$state_LangLa_fq().g;
                                } else if (var21.contains("client")) {
                                    var24 = beatdz.LangLa_fq.$state_LangLa_fq().e;
                                } else {
                                    if (!var21.contains("tree")) {
                                        continue;
                                    }

                                    var24 = beatdz.LangLa_fq.$state_LangLa_fq().f;
                                }

                                if (var24.get(var6) != null) {
                                    mImage var22 = Binary.createImage(Utlis.a(var25));
                                    var24.put(var6, var22);
                                }
                            }
                        }

                        var3.close();
                    } catch (Exception var17) {
                    }
                }

                var13 = false;
                break label152;
            } catch (Exception var18) {
                var13 = false;
            } finally {
                if (var13) {
                    try {
                        if (var2 != null) {
                            var2.close();
                        }
                    } catch (Exception var14) {
                    }

                }
            }

            try {
                if (var2 != null) {
                    var2.close();
                }

                return;
            } catch (Exception var15) {
                return;
            }
        }

        try {
            var2.close();
        } catch (Exception var16) {
        }
    }
}
