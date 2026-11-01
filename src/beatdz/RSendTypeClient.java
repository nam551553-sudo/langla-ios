package beatdz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Application.ApplicationType;

public class RSendTypeClient implements Runnable {

    public String a;

    public int b;

    public Session c;

    public RSendTypeClient(Session var1, String var2, int var3) {
        this.c = var1;
        this.a = var2;
        this.b = var3;
    }

    public void run() {
        try {
            Session var10000 = this.c;
            mSocket var2 = new mSocket(this.a, this.b);
            var10000.socket = var2;
            var10000 = this.c;
            Writer var6 = new Writer(this.c.socket.a());
            var10000.writer = var6;
            var10000 = this.c;
            Reader var7 = new Reader(this.c.socket.b());
            var10000.reader = var7;
            if (!this.c.isConnected) {
                this.c.close();
                return;
            }

            while (this.c.threadSendMessage == null || !this.c.threadSendMessage.isAlive() || this.c.threadRecvMessage == null || !this.c.threadRecvMessage.isAlive()) {
                Utlis.sleep(100L);
            }

            Utlis.sleep(100L);
            boolean var8 = false;
            this.c.isConnecting = false;
            synchronized (this.c.lockTimeOut) {
                this.c.lockTimeOut.notify();
            }

            if (Gdx.files.isExternalStorageAvailable()) {
                if (Gdx.app.getType() != ApplicationType.Desktop) {
                    Session.a(this.c, Gdx.files.getExternalStoragePath());
                } else {
                    String var1;
                    if ((var1 = Binary.readUTF("arr_binary")) == null || var1.length() == 0) {
                        var1 = Utlis.nextUTF(15);
                        Binary.writeUTF("arr_binary", var1);
                    }

                    Session.a(this.c, Gdx.files.getExternalStoragePath() + "C:\\LangLa\\" + var1);
                }
            } else {
                Session.a(this.c, Gdx.files.getLocalStoragePath());
            }

            var10000 = this.c;
            DataCenter var5 = DataCenter.gI();
            Message var9;
            (var9 = new Message((byte) -113)).writeByte(var5.n);
            if (var5.f) {
                var9.writeByte(5);
            } else {
                var9.writeByte(var5.typeOS);
            }

            var9.writeShort(var5.widthScreen);
            var9.writeShort(var5.heightScreen);
            var9.writeByte(var5.zoomLevelScreen);
            var9.writeByte(mConfig.gI().readByte(2));
            var9.writeShort(var5.VER1);
            var9.writeShort(var5.VER2);
            var9.writeByte(var5.typeArr);
            var9.writeInt(var5.A);
            var9.writeInt(var5.B);
            var9.writeInt(var5.D);
            var9.writeInt(var5.C);
            var9.writeShort(2);
            var10000.sendMessage(var9);
            this.c.handler.a();
        } catch (Exception var4) {
            this.c.close();
            Thread.currentThread().interrupt();
        }

    }
}
