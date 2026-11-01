package beatdz;
public class LangLa_hm extends Entity {
   public short j;
   private byte m = -1;
   private byte n = -1;
   private byte o = 0;
   public byte k;
   public boolean l;

   public LangLa_hn o() {
      return DataCenter.gI().J != null && this.j < DataCenter.gI().J.length ? DataCenter.gI().J[this.j] : null;
   }

   public LangLa_hm(int var1, int var2, int var3) {
      this.m = 1;
      this.j = (short)var1;
      this.setXY(var2, var3);
   }

   public LangLa_hm(int var1, int var2, int var3, int var4) {
      this.m = (byte)var4;
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

   public boolean p() {
      return this.m == 0;
   }

   public void q() {
      this.o = (byte)(this.o + 30);
      if (this.o >= 90) {
         this.o = 0;
      }

      ++this.n;
      if (this.o() != null && this.n >= this.o().b.length) {
         this.n = 0;
         if (this.m > 0) {
            --this.m;
         }
      }

   }

   public void a(Graphics var1) {
      this.b(var1, 0, 0);
   }

   public void b(Graphics var1, int var2, int var3) {
      try {
         if (!mConfig.gI().readBoolean(11) || this.j == GameSrc.gI().aF.j) {
            if (!this.p() && this.o() != null && this.n >= 0 && this.n < this.o().b.length) {
               if (this.k > 0) {
                  switch(this.k) {
                  case 1:
                     var1.c(-2303742);
                     break;
                  case 2:
                     var1.c(-16663468);
                     break;
                  case 3:
                     var1.c(-16744706);
                     break;
                  case 4:
                     var1.c(-2031616);
                     break;
                  case 5:
                     var1.c(-9942667);
                  }
               }

               short[] var7;
               if (this.o().b[this.n].a == 5672) {
                  boolean var5 = true;
                  var1.k = var5;
                  var7 = LangLa_fq.b(var1, this.o().b[this.n].a, this.o, var2 + this.cx + this.o().b[this.n].c, var3 + this.cy + this.o().b[this.n].d, 3);
                  var5 = false;
                  var1.k = var5;
               } else if (this.l) {
                  var7 = LangLa_fq.b(var1, this.o().b[this.n].a, Utlis.b(this.o().b[this.n].b), var2 + this.cx - this.o().b[this.n].c, var3 + this.cy + this.o().b[this.n].d, 3);
               } else {
                  var7 = LangLa_fq.b(var1, this.o().b[this.n].a, Utlis.a(this.o().b[this.n].b), var2 + this.cx + this.o().b[this.n].c, var3 + this.cy + this.o().b[this.n].d, 3);
               }

               this.width = var7[0];
               this.height = var7[1];
               if (this.k > 0) {
                  var1.c();
               }

            }
         }
      } catch (Exception var6) {
         Utlis.println(var6);
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
      return this.o().a;
   }
}
