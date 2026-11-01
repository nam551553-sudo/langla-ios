package beatdz;import com.tgame.model.Caption;

public class DanhHieu {
   public String a;
   public int b = -1;
   public int c = -16711681;
   public boolean isNew;
   public Char.DanhHieuByBeatdz data;

   public void a() {
      this.a = this.a.trim();
      String var1 = (Caption.mq + " " + this.a).toLowerCase();

      for(int var2 = 0; var2 < DataCenter.gI().ItemTemplate.length; ++var2) {
         if (DataCenter.gI().ItemTemplate[var2].name.toLowerCase().equals(var1)) {
            try {
               this.c = Integer.parseInt(DataCenter.gI().ItemTemplate[var2].detail);
               return;
            } catch (Exception var3) {
               return;
            }
         }
      }

   }
}
