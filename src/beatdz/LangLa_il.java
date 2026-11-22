package beatdz;
public class LangLa_il extends LangLa_ii {
   public LangLa_fl p;

   public LangLa_il(byte var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      super((byte)0, 0, 0, var4, var5, 1, 1);
   }

   public void b(int var1, int var2) {
      var1 += this.p.cx;
      var2 += this.p.cy;
      if (var1 < 50 - this.p.width) {
         var1 = 50 - this.p.width;
      }

      if (var1 > DataCenter.gI().widthScreen - 50) {
         var1 = DataCenter.gI().widthScreen - 50;
      }

      if (var2 < 50 - this.p.height) {
         var2 = 50 - this.p.height;
      }

      if (var2 > DataCenter.gI().heightScreen - 50) {
         var2 = DataCenter.gI().heightScreen - 50;
      }

      this.p.setXY(var1, var2);
      if (!this.p.r && this.p.cy < -10) {
         this.p.cy = -10;
      }

   }
}
