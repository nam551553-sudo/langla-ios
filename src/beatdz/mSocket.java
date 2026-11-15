package beatdz;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class mSocket {
   private Socket b = new Socket();
  public InputStream a;

   public mSocket(String var1, int var2) throws IOException {
      InetSocketAddress var3 = new InetSocketAddress(var1, var2);
      try {
         this.b.connect(var3, beatdz.Utlis.$state_Utlis().timeOut);
         this.b.setTcpNoDelay(true);
         this.b.setKeepAlive(true);
      } catch (IOException failed) {
         this.b.close();
         throw failed;
      }
   }

   public DataOutputStream a() throws IOException {
      return new DataOutputStream(new java.io.BufferedOutputStream(this.b.getOutputStream(), 8192));
   }

   public DataInputStream b() throws IOException {
      this.a = new java.io.BufferedInputStream(this.b.getInputStream(), 8192);
      return new DataInputStream(this.a);
   }

   public void c() {
      try {
         if (this.a != null) {
            this.a.close();
         }

         if (this.b != null) {
            this.b.close();
         }

      } catch (Exception var1) {
      }
   }
}
