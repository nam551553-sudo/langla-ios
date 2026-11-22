package beatdz;
public class WayPoint extends Entity {
   public short mapHere;
   public short mapNext;
   public short l;
   public short m;
   public short n;
   public short o;
   private String[] r = null;
   public int p = 0;
   public int q = 0;

   public WayPoint(int var1, int var2) {
      this.setXY(0, 0);
   }

   public void create(short var1, short var2, short var3, short var4, short var5, short var6, short var7, short var8) {
      this.mapHere = var1;
      this.mapNext = var2;
      this.l = (short)(var3 - 5);
      this.m = (short)(var4 - 5);
      this.n = (short)(var5 + 5);
      this.o = (short)(var6 + 5);
      this.setXY(var3 + (var5 - var3) / 2, var6);
      String var9;
      if ((var9 = DataCenter.gI().MapTemplate[var2].name).length() <= 13) {
         this.r = new String[]{var9};
      } else {
         this.r = mFont.a(var9, 2);
      }

      this.p = var7;
      this.q = var8;
   }

   public void a(short var1, short var2, short var3, short var4, short var5, short var6) {
      this.mapHere = var1;
      this.mapNext = var2;
      this.l = var3;
      this.m = var4;
      this.n = var5;
      this.o = var6;
      this.setXY(var3 + (var5 - var3) / 2, var4 + (var6 - var4) / 2);
   }

   public void a(Graphics var1) {
      XYEntity var2;
      if ((var2 = Char.c(this.cx, this.cy)) != null) {
         this.cy = var2.cy;
      }

      int var3 = this.cx - 5;
      if (this.cx < 300) {
         var3 = this.cx + 5;
         LangLa_fq.a(var1, 29, -360, this.cx, this.cy, 33);
      } else {
         LangLa_fq.a(var1, 29, 0, this.cx, this.cy, 33);
      }

      if (this.r.length > 1) {
         mFont.d(mFont.b, var1, this.r[0], var3, this.cy - 57, 2, -2560, -11184811);
         mFont.d(mFont.b, var1, this.r[1], var3, this.cy - 49, 2, -2560, -11184811);
      } else {
         mFont.d(mFont.b, var1, this.r[0], var3, this.cy - 54, 2, -2560, -11184811);
      }
   }

   public int a() {
      return this.cx - 28;
   }

   public int b() {
      return this.cx + 28;
   }

   public int c() {
      return this.cy - 61;
   }

   public int d() {
      return this.cy - 46;
   }

   public void b(Graphics var1) {
   }

   public String f() {
      return null;
   }

   public String g() {
      return null;
   }

   public String h() {
      return null;
   }

   public int e() {
      return 4;
   }
}
