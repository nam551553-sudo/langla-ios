package beatdz;
public class PointMove extends XYEntity {
   public short a;
   public short b;
   public byte c = 1;
   public int d;
   public int e;
   public int f;
   public int g;
   public int h;
   public int i;
   public int j;
   public boolean k;
   public boolean l;
   int m;
   private int n = 8;

   public PointMove(short var1, short var2, short var3, short var4) {
      this.cx = var1;
      this.cy = var2;
      this.a = var3;
      this.b = var4;
      this.c = (byte)Char.gI().speedMove;
      this.d = GameSrc.gI().mapID;
   }

   public PointMove(short var1, short var2, int var3) {
      this.cx = var1;
      this.cy = var2;
      this.a = (short)var3;
      this.b = (short)var3;
      this.c = (byte)var3;
      this.d = GameSrc.gI().mapID;
   }

   public void a(int var1, int var2) {
      this.e = this.cy;
      this.f = this.g = 0;
      this.f = 0;
      ++this.h;
      this.i = var1;
      this.j = var2;
   }

   public boolean a() {
      return this.h == 1;
   }

   public boolean b() {
      return this.h == 3;
   }

   public boolean c() {
      return this.h == 2;
   }
}
