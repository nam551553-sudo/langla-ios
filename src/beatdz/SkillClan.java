package beatdz;import beatdz.*;

public class SkillClan {
   public int id;
   public String name;
   public String detail;
   public int levelNeed;
   public String strOptions;
   public int idIcon;
   public int moneyBuy;

   public SkillClan a() {
      SkillClan var1;
      (var1 = new SkillClan()).id = this.id;
      var1.name = this.name;
      var1.detail = this.detail;
      var1.levelNeed = this.levelNeed;
      var1.strOptions = this.strOptions;
      var1.idIcon = this.idIcon;
      var1.moneyBuy = this.moneyBuy;
      return var1;
   }

   public ItemOption[] b() {
      if (this.strOptions != null && this.strOptions.length() > 0) {
         String[] var1;
         ItemOption[] var2 = new ItemOption[(var1 = Utlis.split(this.strOptions, ";")).length];

         for(int var3 = 0; var3 < var1.length; ++var3) {
            var2[var3] = new ItemOption(var1[var3]);
         }

         return var2;
      } else {
         return null;
      }
   }

   public void a(int var1) {
      this.levelNeed = var1;
      if (this.strOptions != null && this.strOptions.length() > 0) {
         String[] var2;
         ItemOption[] var3 = new ItemOption[(var2 = Utlis.split(this.strOptions, ";")).length];

         for(int var4 = 0; var4 < var2.length; ++var4) {
            var3[var4] = new ItemOption(var2[var4]);
            var3[var4].d(var3[var4].a[1] * var1);
         }

         this.strOptions = Item.a(var3);
      }

   }

   
   public Object clone() {
      return this.a();
   }
}
