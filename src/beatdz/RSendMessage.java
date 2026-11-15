package beatdz;

import java.io.IOException;

public class RSendMessage implements Runnable {
    public Session a;

    public RSendMessage(Session session) {
        this.a = session;
    }

    public void run() {
        try {
            while (a.isConnected && a.currentConnection()) {
                synchronized (a.lockSendMessage) {
                    a.waitThreadSend = false;
                    while (a.isConnected && a.currentConnection() && a.vMessage.isEmpty()) {
                        a.lockSendMessage.wait();
                    }
                }
                if (!a.isConnected || !a.currentConnection()) return;
                Writer output = a.writer;
                if (output == null) throw new IOException("Socket output is unavailable");
                int sent = 0;
                while (sent < 32 && a.currentConnection() && !a.vMessage.isEmpty()) {
                    byte[] packet = (byte[])a.vMessage.remove(0);
                    output.dos.write(packet);
                    a.countSend += packet.length;
                    sent++;
                }
                if (sent > 0) output.dos.flush();
            }
        } catch (InterruptedException stopped) {
            Thread.currentThread().interrupt();
        } catch (Exception failed) {
            a.close();
        }
    }
}