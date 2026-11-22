package beatdz;
public class LangLa_ik extends LangLa_ii {
   private LangLa_ea q;
   private short r;
   private short s;
   public int p;

   public LangLa_ik(byte var1, int var2, int var3, int var4, int var5, int var6, int var7, LangLa_ea var8) {
      super((byte)0, var2, var3, var4, var5, 1, 1);
      this.r = this.cx;
      this.s = this.cy;
      this.q = var8;
   }

   public void e() {
      this.cx = this.r;
      this.cy = this.s;
   }

   public void a(int var1, int var2) {
      this.b(var1 - this.q.width / 2, var2 - this.q.height / 2);
   }

   public void b(int var1, int var2) {
      this.cx = (short)(this.r + var1);
      this.cy = (short)(this.s + var2);
      if (this.cx < 10 - this.q.cx) {
         this.cx = (short)(10 - this.q.cx);
      }

      if (this.cx > DataCenter.gI().widthScreen - this.q.cx - 10) {
         this.cx = (short)(DataCenter.gI().widthScreen - this.q.cx - 10);
      }

      if (this.cy < 10 - this.q.cy) {
         this.cy = (short)(10 - this.q.cy);
      }

      if (this.cy > DataCenter.gI().heightScreen - this.q.cy - 10) {
         this.cy = (short)(DataCenter.gI().heightScreen - this.q.cy - 10);
      }

      XYEntity var4 = XYEntity.create(this.q.m + this.q.width / 2, this.q.n + this.q.height / 2);
      var2 = this.cx - var4.cx;
      int var3 = var4.cy - this.cy;
      if (Utlis.getRange2(this.cx, this.cy, var4.cx, var4.cy) > 33) {
         if ((var2 = LangLa_hi.b(var2, var3)) > 270) {
            var2 -= 270;
            var1 = beatdz.LangLa_hi.$state_LangLa_hi().o[90 - var2] * 33 / 1000;
            var2 = beatdz.LangLa_hi.$state_LangLa_hi().o[var2] * 33 / 1000;
            if (!mConfig.gI().readBoolean(12)) {
               this.cx = (short)(this.q.m + var1 + this.q.width / 2);
               this.cy = (short)(this.q.n + var2 + this.q.height / 2);
            } else {
               this.q.m = (short)(this.cx - var1 - this.q.width / 2);
               this.q.n = (short)(this.cy - var2 - this.q.height / 2);
            }
         } else if (var2 > 180) {
            var2 -= 180;
            var1 = beatdz.LangLa_hi.$state_LangLa_hi().o[var2] * 33 / 1000;
            var2 = beatdz.LangLa_hi.$state_LangLa_hi().o[90 - var2] * 33 / 1000;
            if (!mConfig.gI().readBoolean(12)) {
               this.cx = (short)(this.q.m - var1 + this.q.width / 2);
               this.cy = (short)(this.q.n + var2 + this.q.height / 2);
            } else {
               this.q.m = (short)(this.cx + var1 - this.q.width / 2);
               this.q.n = (short)(this.cy - var2 - this.q.height / 2);
            }
         } else if (var2 > 90) {
            var2 -= 90;
            var1 = beatdz.LangLa_hi.$state_LangLa_hi().o[90 - var2] * 33 / 1000;
            var2 = beatdz.LangLa_hi.$state_LangLa_hi().o[var2] * 33 / 1000;
            if (!mConfig.gI().readBoolean(12)) {
               this.cx = (short)(this.q.m - var1 + this.q.width / 2);
               this.cy = (short)(this.q.n - var2 + this.q.height / 2);
            } else {
               this.q.m = (short)(this.cx + var1 - this.q.width / 2);
               this.q.n = (short)(this.cy + var2 - this.q.height / 2);
            }
         } else {
            var1 = beatdz.LangLa_hi.$state_LangLa_hi().o[var2] * 33 / 1000;
            var2 = beatdz.LangLa_hi.$state_LangLa_hi().o[90 - var2] * 33 / 1000;
            if (!mConfig.gI().readBoolean(12)) {
               this.cx = (short)(this.q.m + var1 + this.q.width / 2);
               this.cy = (short)(this.q.n - var2 + this.q.height / 2);
            } else {
               this.q.m = (short)(this.cx - var1 - this.q.width / 2);
               this.q.n = (short)(this.cy + var2 - this.q.height / 2);
            }
         }

         this.q.p.setXY(this.q.m, this.q.n);
      }

      var4 = XYEntity.create(this.q.m + this.q.width / 2, this.q.n + this.q.height / 2);
      var2 = this.cx - var4.cx;
      var3 = var4.cy - this.cy;
      this.p = LangLa_hi.b(var2, var3);
   }

   public void c(int var1, int var2) {
      super.c(var1, var2);
      this.d();
      if (!Utlis.inRange(0, 0, this.width, this.height, var1, var2)) {
         this.k = -1;
         this.l = -1;
      } else if (this.m != this.j) {
         this.k = -1;
      } else if (this.n == 1 && this.h != 0 && this.l < this.i && this.l == (this.f + var2) / this.h || this.n == 0 && this.h != 0 && this.l < this.i && this.l == (this.f + var1) / this.h) {
         this.k = this.l;
      }

      if (this.k >= 0) {
         LangLa_dp.a().h();
      }

   }
}
