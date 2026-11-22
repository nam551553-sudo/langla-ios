package beatdz;import java.util.Vector;

public class LangLa_jw extends Entity {
   public short j;
   public byte k = -1;
   public byte l = -1;
   private Vector n = new Vector();
   private Vector o = new Vector();
   private int p = 0;
   public boolean m;
   private int q;

   private LangLa_jy s() {
      return DataCenter.gI().L[this.j];
   }

   public LangLa_jw(int var1, int var2, int var3) {
      this.a(var1, var2, var3, 1);
   }

   public LangLa_jw(int var1, int var2, int var3, int var4) {
      this.a(var1, var2, var3, var4);
   }

   private void a(int var1, int var2, int var3, int var4) {
      this.k = (byte)var4;
      this.j = (short)var1;
      this.setXY(var2, var3);
   }

   public int a() {
      return this.cx - this.width / 2;
   }

   public int b() {
      return this.cx + this.width / 2;
   }

   public int c() {
      return this.cy - this.height / 2;
   }

   public int d() {
      return this.cy + this.height / 2;
   }

   public void o() {
      if (this.j >= 273 && this.j <= 275 && DataCenter.gI().i % 20 == 0 && this.q == 0 && Utlis.nextBoolean()) {
         this.q = Utlis.nextInt(10, 100);
      }

      if (this.q > 0) {
         --this.q;
      } else {
         ++this.l;
         if (this.p > 0 && this.l >= this.p) {
            this.l = 0;
            if (this.k > 0) {
               --this.k;
            }
         }

         for(int var2 = 0; var2 < this.s().b.length; ++var2) {
            LangLa_hm var1;
            if (this.m) {
               var1 = new LangLa_hm(this.s().b[var2].a, this.cx - this.s().b[var2].d, this.cy + this.s().b[var2].e);
            } else {
               var1 = new LangLa_hm(this.s().b[var2].a, this.cx + this.s().b[var2].d, this.cy + this.s().b[var2].e);
            }

            var1.l = this.m;
            if (this.l == this.s().b[var2].b) {
               this.n.addElement(var1);
            }

            if (var2 + var1.o().b.length > this.p) {
               this.p = var2 + var1.o().b.length;
            }

            if (this.s().a > 2) {
               var1.k = (byte)(this.s().a - 2);
            }
         }

         if (this.k != 0) {
            GameSrc.gI().H.addAll(this.n);
         }

         this.n.clear();
      }
   }

   private boolean t() {
      return this.j == 72 || this.j == 112 || this.j == 113 || this.j == 182 || this.j == 133 || this.j == 134;
   }

   public void p() {
      ++this.l;
      if (this.p > 0 && this.k == -1 && this.l >= this.p) {
         this.l = 0;
      }

      LangLa_hm var1;
      int var2;
      for(var2 = 0; var2 < this.s().b.length; ++var2) {
         if (this.m) {
            var1 = new LangLa_hm(this.s().b[var2].a, this.cx - this.s().b[var2].d, this.cy + this.s().b[var2].e);
         } else {
            var1 = new LangLa_hm(this.s().b[var2].a, this.cx + this.s().b[var2].d, this.cy + this.s().b[var2].e);
         }

         var1.l = this.m;
         if (this.l == this.s().b[var2].b) {
            this.n.addElement(var1);
         }

         if (var2 + var1.o().b.length > this.p) {
            this.p = var2 + var1.o().b.length;
         }
      }

      for(var2 = this.n.size() - 1; var2 >= 0; --var2) {
         (var1 = (LangLa_hm)this.n.elementAt(var2)).q();
         if (var1.p()) {
            this.n.removeElement(var1);
         }
      }

      if (this.l >= this.p) {
         this.l = -1;
         if (this.k > 0) {
            --this.k;
         }
      }

   }

   public void q() {
      this.l = -1;
      this.n.clear();
      this.o.clear();
   }

   public void b(Entity var1) {
      short var2 = var1.cx;
      short var3 = var1.cy;
      if (this.j == 112 || this.j == 113) {
         var3 = (short)(var3 - (var1.height + 14));
         Npc var4;
         if (var1 instanceof Npc && (var4 = (Npc)var1).getNpcTemplate().detail.length() > 0) {
            var3 = (short)(var3 - 10);
         }
      }

      if (this.j == 109) {
         var3 -= var1.height;
      }

      if (this.j == 170) {
         if (var1 instanceof Char) {
            var3 = (short)(var3 - 17);
         } else {
            var3 = (short)(var3 - var1.height / 2);
         }
      }

      if (this.j == 98 && var1.status == 2) {
         switch(var1.dir) {
         case 0:
            var3 = (short)(var3 + 4);
            break;
         case 1:
            var3 = (short)(var3 - 12);
            break;
         case 2:
            var2 = (short)(var2 + 12);
            break;
         case 3:
            var2 = (short)(var2 - 12);
         }
      }

      int var7 = var2 - this.cx;
      int var5 = var3 - this.cy;
      if (!this.t()) {
         this.m = var1.i();
      }

      this.cx = var2;
      this.cy = var3;
      ++this.l;
      if (this.p > 0 && this.k == -1 && this.l >= this.p) {
         this.l = 0;
      }

      LangLa_hm var6;
      int var8;
      for(var8 = this.n.size() - 1; var8 >= 0; --var8) {
         LangLa_hm var10000 = var6 = (LangLa_hm)this.n.elementAt(var8);
         var10000.cx = (short)(var10000.cx + var7);
         var6.cy = (short)(var6.cy + var5);
         var6.q();
         if (var6.p()) {
            this.n.removeElement(var6);
         }
      }

      for(var8 = 0; var8 < this.s().b.length; ++var8) {
         if (this.m) {
            var6 = new LangLa_hm(this.s().b[var8].a, this.cx - this.s().b[var8].d, this.cy + this.s().b[var8].e);
         } else {
            var6 = new LangLa_hm(this.s().b[var8].a, this.cx + this.s().b[var8].d, this.cy + this.s().b[var8].e);
         }

         var6.l = this.m;
         if (this.s().a > 2) {
            var6.k = (byte)(this.s().a - 2);
         }

         if (this.l == this.s().b[var8].b) {
            this.n.addElement(var6);
         }

         if (var8 + var6.o().b.length > this.p) {
            this.p = var8 + var6.o().b.length;
         }
      }

      for(var8 = this.o.size() - 1; var8 >= 0; --var8) {
         var6 = (LangLa_hm)this.o.elementAt(var8);
         if (this.s().a > 2) {
            var6.k = (byte)(this.s().a - 2);
         }

         var6.l = this.m;
         if (var6.p()) {
            this.o.remove(var6);
         }
      }

      for(var8 = this.n.size() - 1; var8 >= 0; --var8) {
         var6 = (LangLa_hm)this.n.elementAt(var8);
         if (this.s().a > 2) {
            var6.k = (byte)(this.s().a - 2);
         }

         if (!var1.j()) {
            GameSrc.gI().a((Entity)this.n.elementAt(var8));
         }
      }

      if (this.l >= this.p) {
         this.l = -1;
         if (this.k > 0) {
            --this.k;
         }
      }

   }

   public boolean r() {
      return this.k == 0;
   }

   public void a(Graphics var1) {
      if (!this.r() && this.q <= 0) {
         for(int var3 = 0; var3 < this.n.size(); ++var3) {
            ((LangLa_hm)this.n.elementAt(var3)).b(var1, 0, 0);
         }

      }
   }

   public void b(Graphics var1, int var2, int var3) {
      if (!this.r()) {
         for(int var5 = 0; var5 < this.n.size(); ++var5) {
            ((LangLa_hm)this.n.elementAt(var5)).b(var1, var2, var3);
         }

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
      return 2;
   }
}
