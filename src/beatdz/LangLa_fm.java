package beatdz;
public abstract class LangLa_fm extends LangLa_cs {
   public static LangLa_ii[] a(LangLa_dz[] var0) {
      LangLa_ii[] var1 = new LangLa_ii[var0.length];

      for(int var2 = 0; var2 < var1.length; ++var2) {
         if (var0[var2] != null) {
            var1[var2] = new LangLa_ii((byte)1, var0[var2].cx, var0[var2].cy, var0[var2].width, var0[var2].height, var0[var2].height, 1);
         }
      }

      return var1;
   }

   public void a(Graphics var1, LangLa_dz[] var2, int var3, int var4) {
      for(int var5 = 0; var5 < var2.length; ++var5) {
         if (var2[var5] != null) {
            this.a(var1, var3, var4);
            var1.a(var2[var5].cx, var2[var5].cy);
            var2[var5].a(var1);
         }
      }

   }

   public static void a(LangLa_dz[] var0, LangLa_ii[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         if (var0[var2] != null) {
            var1[var2].a();
            if (var1[var2].l != -1) {
               var0[var2].h = true;
            } else {
               var0[var2].h = false;
            }
         }
      }

   }
}
