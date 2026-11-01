package beatdz;
import com.badlogic.gdx.files.FileHandle;

public class mFileHandle {
   public FileHandle a;

   public byte[] a(int var1) {
      return this.a != null && this.a.exists() ? this.a.readBytes() : null;
   }

   public int a() {
      return this.a != null && this.a.exists() ? (int)this.a.length() : 0;
   }

   public void a(int var1, byte[] var2, int var3, int var4) {
      this.a.writeBytes(var2, false);
   }

   public void a(byte[] var1, int var2, int var3) {
      this.a.writeBytes(var1, false);
   }

   public static mFileHandle a(String var0, boolean var1) {
      try {
         mFileHandle var3;
         (var3 = new mFileHandle()).a = Utlis.external(var0);
         return var3;
      } catch (Exception var2) {
         return null;
      }
   }

   public static mFileHandle b(String var0, boolean var1) {
      try {
         mFileHandle var3;
         (var3 = new mFileHandle()).a = Utlis.internal(var0);
         return var3;
      } catch (Exception var2) {
         return null;
      }
   }
}
