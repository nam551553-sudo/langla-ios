package beatdz;
import java.io.IOException;

public class Thu {
   public int a;
   public String b = "";
   public String c = "";
   public String d = "";
   public Item e;
   public int f;
   public int g;
   public int h;
   public int i;
   public long j;
   public boolean k;
   public int l;

   public void a(Message var1) throws IOException {
      this.a = var1.readShort();
      this.k = var1.readBoolean();
      this.b = var1.reader.readUTF();
      this.c = var1.reader.readUTF();
      this.d = var1.reader.readUTF();
      this.f = var1.readInt();
      this.g = var1.readInt();
      this.h = var1.readInt();
      this.i = var1.readInt();
      this.j = var1.readLong();
      this.l = var1.readInt();
      Item var2;
      (var2 = new Item()).read(var1);
      if (var2.id >= 0) {
         this.e = var2;
      }

   }

   private long b() {
      if (this.f > 0) {
         return (long)this.f;
      } else if (this.g > 0) {
         return (long)this.g;
      } else if (this.h > 0) {
         return (long)this.h;
      } else if (this.i > 0) {
         return (long)this.i;
      } else {
         return this.j > 0L ? this.j : 0L;
      }
   }

   public boolean a() {
      return this.e != null || this.b() > 0L;
   }
}
