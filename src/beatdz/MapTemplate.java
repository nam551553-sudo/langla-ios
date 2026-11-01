package beatdz;import beatdz.*;

public class MapTemplate {
   public short id;
   public String name;
   public short typeBlockMap;
   public byte type;

   public MapTemplate(int var1) {
      this.id = (short)var1;
   }

   public boolean isMapLang() {
      return this.type == 2;
   }

   public boolean b() {
      return this.type == 3;
   }
}
