package beatdz;
public class ItemMap extends Entity {
   public Item item;
   public short k;
   public short l;
   public short m;
   public short n;
   public boolean o;
   private byte r = 70;
   private int[] s = new int[]{41, 42, 43};
   private int t = 0;
   public int p = 0;
   public int idChar;

   public ItemMap() {
      this.setSize(25, 25);
      this.height = 17;
   }

   public void a(int var1, int var2, int var3, int var4) {
      this.k = (short)var1;
      this.l = (short)var2;
      this.setXY(var3, var4);
      var1 = Utlis.positive(var1 - var3);
      var2 = Utlis.positive(var2 - var4);
      this.m = (short)(var1 / 6);
      this.n = (short)(var2 / 6);
      if (this.m <= 0) {
         this.m = 1;
      }

      if (this.n <= 0) {
         this.n = 1;
      }

   }

   public int a() {
      return this.cx - this.width / 2;
   }

   public int b() {
      return this.cx + this.width / 2;
   }

   public int c() {
      return this.cy - this.height;
   }

   public int d() {
      return this.cy;
   }

   public void o() {
      if (this.p > 0) {
         --this.p;
         if (this.p == 1) {
            GameSrc.gI().vItemMap.remove(this);
         }
      }

      if (this.cx != this.k) {
         if (Utlis.positive(this.cx - this.k) < this.m) {
            this.cx = this.k;
         } else if (this.cx > this.k) {
            this.cx -= this.m;
         } else {
            this.cx += this.m;
         }
      }

      if (this.cy != this.l) {
         if (Utlis.positive(this.cy - this.l) < this.n) {
            this.cy = this.l;
         } else if (this.cy > this.l) {
            this.cy -= this.n;
         } else {
            this.cy += this.n;
         }
      }

      if (this.o) {
         if (this.cx == this.k && this.cy == this.l) {
            GameSrc.gI().vItemMap.remove(this);
         } else {
            this.r = (byte)(this.r + 5);
            if (this.r > 100) {
               this.r = 100;
            }
         }
      }

      if (this.item != null && this.item.getItemTemplate().id == 224 && DataCenter.gI().i % 3 == 0) {
         ++this.t;
         if (this.t >= this.s.length) {
            this.t = 0;
         }
      }

   }

   public void a(Graphics var1) {
      Binary2.a(var1, this.item.getItemTemplate().idIcon, 0, this.cx, this.cy, this.r, (byte)33);
      if (this.item.getItemTemplate().id == 224) {
         LangLa_fq.a(var1, this.s[this.t], 0, this.cx, this.cy, 33);
      }

   }

   public String f() {
      return this.item.getItemTemplate().name;
   }

   public String g() {
      return null;
   }

   public String h() {
      return null;
   }

   public void b(Graphics var1) {
      if (GameSrc.gI().aA != null && GameSrc.gI().aA.equals(this)) {
         mFont.b(mFont.d, var1, this.item.getItemTemplate().name, this.cx, this.cy - this.height - 8, 2, -16646423, -16777216);
         int var10002 = this.cy - this.height;
         GameSrc.gI().aF.setXY(this.cx, var10002 - 20);
         GameSrc.gI().aF.b(var1, 0, 0);
      }

   }

   public int e() {
      return 3;
   }
}
