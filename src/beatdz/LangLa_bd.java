package beatdz;import com.tgame.model.Caption;

public class LangLa_bd extends LangLa_fo {
   private LangLa_cl[] a;
   private LangLa_kc b;
   private LangLa_ce c;
   private LangLa_ce d;
   private int e;

   public LangLa_bd(MainScreen var1) {
      this.p = var1;
      byte var4 = 0;
      LangLa_ce var10000;
      boolean var3;
      if (mConfig.gI().readBoolean(15)||AppListener.gI().canvas.width >= 1120 && AppListener.gI().canvas.height >= 840) {
         var4 = 12;
         this.d = this.a(25, 68, Caption.sW[0], 102);
         var10000 = this.d;
         var3 = mConfig.gI().readBoolean(15);
         var10000.a = var3;
      }

      if (DataCenter.gI().zoomLevelScreen == 3) {
         this.a(230, 224 + var4);
      } else {
         this.a(230, 210 + var4);
      }

      this.b = new LangLa_kc(100);
      this.e = mConfig.gI().readByte(2);
      int var5 = this.e;
      this.b.b = var5;
      switch(DataCenter.gI().zoomLevelScreen) {
      case 1:
         this.a = new LangLa_cl[1];
         this.a[0] = this.a(25, 75 + var4, Caption.ij, this, this.b);
         break;
      case 2:
         this.a = new LangLa_cl[3];
         this.a[0] = this.a(25, 110 + var4, Caption.ik, this, this.b);
         this.a[1] = this.a(25, 145 + var4, Caption.ij, this, this.b);
         this.a[2] = this.a(25, 75 + var4, Caption.il, this, this.b);
         break;
      case 3:
         this.a = new LangLa_cl[4];
         this.a[0] = this.a(25, 105 + var4, Caption.il, this, this.b);
         this.a[1] = this.a(25, 135 + var4, Caption.ik, this, this.b);
         this.a[2] = this.a(25, 165 + var4, Caption.ij, this, this.b);
         this.a[3] = this.a(25, 75 + var4, Caption.im, this, this.b);
         break;
      case 4:
      case 5:
      case 6:
         this.a = new LangLa_cl[3];
         this.a[0] = this.a(25, 75 + var4, Caption.il, this, this.b);
         this.a[1] = this.a(25, 110 + var4, Caption.ik, this, this.b);
         this.a[2] = this.a(25, 145 + var4, Caption.ij, this, this.b);
      }

      if (this.b.b <= 0 || this.b.b >= this.a.length) {
         byte var6 = 0;
         this.b.b = var6;
         this.e = 0;
         mConfig.gI().writeByte(2, this.e);

         LangLa_cl var8;
         for(int var7 = 0; var7 < this.a.length; ++var7) {
            var8 = this.a[var7];
            var3 = false;
            var8.a = var3;
         }

         var8 = this.a[this.b.b];
         var3 = true;
         var8.a = var3;
      }

      this.c = this.a(25, this.height - 30, Caption.in, 101);
      var10000 = this.c;
      var3 = mConfig.gI().readBoolean(8);
      var10000.a = var3;
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      try {
         boolean var6;
         switch(var1.b) {
         case 2002:
            LangLa_cl var7;
            for(int var5 = 0; var5 < this.a.length; ++var5) {
               var7 = this.a[var5];
               var6 = false;
               var7.a = var6;
            }

            mConfig.gI().writeByte(2, this.e);
            var7 = this.a[mConfig.gI().readByte(2)];
            var6 = true;
            var7.a = var6;
            Binary.deleteAll();
            break;
         case 2003:
            this.e = this.b.b;
            break;
         case 2004:
            var6 = !this.d.a;
            this.d.a = var6;
            mConfig.gI().writeBoolean(15, this.d.a);
            Binary.deleteAll();
            GameSrc.gI().setSize(AppListener.gI().canvas.getWidth(), AppListener.gI().canvas.getHeight());
            break;
         case 2005:
            LangLa_ce var10000 = this.d;
            var6 = mConfig.gI().readBoolean(15);
            var10000.a = var6;
         default:
            return;
         }
      } catch (Exception var4) {
         Utlis.println(var4);
      }

   }

   public void a(int var1, Object var2, LangLa_cy var3) {
      boolean var4;
      switch(var1) {
      case 100:
         if (this.b.b != this.e) {
            var1 = this.e;
            this.e = this.b.b;

            LangLa_cl var6;
            for(int var5 = 0; var5 < this.a.length; ++var5) {
               var6 = this.a[var5];
               var4 = false;
               var6.a = var4;
            }

            var6 = this.a[mConfig.gI().readByte(2)];
            var4 = true;
            var6.a = var4;
            this.b.b = var1;
            DataCenter.gI().currentScreen.a(Caption.io, 2002, 2003, this);
            return;
         }
         break;
      case 101:
         mConfig.gI().writeBoolean(8, this.c.a);
         return;
      case 102:
         LangLa_ce var10000 = this.d;
         var4 = mConfig.gI().readBoolean(15);
         var10000.a = var4;
         if (this.d.a) {
            DataCenter.gI().currentScreen.a(Caption.sW[1], 2004, 2005, this);
            return;
         }

         DataCenter.gI().currentScreen.a(Caption.sW[2], 2004, 2005, this);
      }

   }

   public void a(int var1, Object var2) {
   }

   public void a(Graphics var1) {
      this.a(var1, this.cx, this.cy, this.width, this.height, Caption.ip, (byte)2);
      mFont.b(mFont.d, var1, Caption.iq, this.a[0].cx, 47, 0, -2560, -16777216);
      mFont.b(mFont.d, var1, Caption.ir, this.a[0].cx, 60, 0, -2560, -16777216);
      switch(DataCenter.gI().zoomLevelScreen) {
      case 1:
         mFont.b(mFont.d, var1, Caption.rU[0], this.a[0].cx + 18, this.a[0].cy + 21, 0, -6488, -10275328);
         return;
      case 2:
         mFont.b(mFont.d, var1, Caption.rU[2], this.a[0].cx + 18, this.a[0].cy + 21, 0, -6488, -10275328);
         mFont.b(mFont.d, var1, Caption.rU[3], this.a[1].cx + 18, this.a[1].cy + 21, 0, -6488, -10275328);
         mFont.b(mFont.d, var1, Caption.rU[1], this.a[2].cx + 18, this.a[2].cy + 21, 0, -6488, -10275328);
         return;
      case 3:
         mFont.b(mFont.d, var1, Caption.rU[3], this.a[0].cx + 18, this.a[0].cy + 21, 0, -6488, -10275328);
         mFont.b(mFont.d, var1, Caption.rU[4], this.a[1].cx + 18, this.a[1].cy + 21, 0, -6488, -10275328);
         mFont.b(mFont.d, var1, Caption.rU[5], this.a[2].cx + 18, this.a[2].cy + 21, 0, -6488, -10275328);
         mFont.b(mFont.d, var1, Caption.rU[1], this.a[3].cx + 18, this.a[3].cy + 21, 0, -6488, -10275328);
         return;
      case 4:
      case 5:
      case 6:
         mFont.b(mFont.d, var1, Caption.rU[5], this.a[0].cx + 18, this.a[0].cy + 21, 0, -6488, -10275328);
         mFont.b(mFont.d, var1, Caption.rU[6], this.a[1].cx + 18, this.a[1].cy + 21, 0, -6488, -10275328);
         mFont.b(mFont.d, var1, Caption.rU[7], this.a[2].cx + 18, this.a[2].cy + 21, 0, -6488, -10275328);
      default:
      }
   }

   public void b() {
   }
}
