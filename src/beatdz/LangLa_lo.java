package beatdz;
public class LangLa_lo extends Entity {
   private static final int FIRST_PARALLAX_TYPE = 7;
   private static final int[] PARALLAX_NUMERATOR = {20, 10, 20, 10};
   private static final int[] PARALLAX_DENOMINATOR = {23, 13, 22, 12};
   public byte j;
   public short k;
   public short l;
   public short m;
   public LangLa_jw n;
   public Mob o;
   public int p;

   public DataBlockMap o() {
      try {
         return GameSrc.gI().f == null ? null : GameSrc.gI().f[this.k];
      } catch (Exception var1) {
         return null;
      }
   }

   public LangLa_lo(int var1) {
      this.k = (short)var1;
      this.p = this.o().type;
   }

   void updateParallax(int cameraX) {
      int layer = this.p - FIRST_PARALLAX_TYPE;
      if (layer < 0 || layer >= PARALLAX_NUMERATOR.length) return;
      this.cx = (short)(this.l + cameraX * PARALLAX_NUMERATOR[layer] / PARALLAX_DENOMINATOR[layer]);
   }

   float parallaxRatio() {
      int layer = this.p - FIRST_PARALLAX_TYPE;
      if (layer < 0 || layer >= PARALLAX_NUMERATOR.length || this.o != null || this.n != null) return 0f;
      return (float)PARALLAX_NUMERATOR[layer] / PARALLAX_DENOMINATOR[layer];
   }

   public int a() {
      return this.cx - this.o().width / 2;
   }

   public int b() {
      return this.cx + this.o().width / 2;
   }

   public int c() {
      return this.cy - this.o().height;
   }

   public int d() {
      return this.cy;
   }

   public void a(Graphics var1) {
      if (this.o != null) {
         this.o.a(var1);
      } else if (this.n != null) {
         this.n.a(var1);
      } else if (this.k == 302) {
         boolean var3 = true;
         var1.k = var3;
         LangLa_fq.a(var1, this.k, DataCenter.gI().i / 50, this.cx, this.cy, this.o().width, this.o().height, 33);
         var3 = false;
         var1.k = var3;
      } else {
         LangLa_fq.a(var1, this.k, Utlis.a(this.j), this.cx, this.cy, this.o().width, this.o().height, 33);
      }
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

   public void b(Graphics var1) {
   }

   public int e() {
      return this.p;
   }
}
