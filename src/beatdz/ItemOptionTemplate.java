package beatdz;import beatdz.*;

public class ItemOptionTemplate {
   public transient int activationGrade = Integer.MIN_VALUE;
   public short id;
   public String name;
   public byte type;
   public byte level;
   public String strOption;

   public ItemOptionTemplate(int var1) {
      this.id = (short)var1;
   }

   public int[] a() {
      if (this.strOption.length() == 0) {
         return new int[0];
      } else {
         String[] var1;
         int var2 = (var1 = this.strOption.split(";")).length;
         int var3 = 19;
         if (this.id == 207 || this.id == 208) {
            var3 = 18;
         }

         if (this.type == 8 || this.type == 0) {
            var3 = var2;
         }

         if (var2 > var3) {
            var2 = var3;
         }

         int[] var4 = new int[var2];

         for(var3 = 0; var3 < var4.length; ++var3) {
            var4[var3] = Integer.parseInt(var1[var3]);
         }

         return var4;
      }
   }
}
