package beatdz;import beatdz.*;

public class ItemTemplate {
   public short id;
   public String name;
   public String detail;
   public boolean isXepChong;
   public byte gioiTinh;
   public byte type;
   public byte idClass;
   public short idIcon;
   public short levelNeed;
   public int taiPhuNeed;
   public short idMob;
   public short idChar;

    @Override
    public String toString() {
        return "ItemTemplate{" + "id=" + id + ", name=" + name + ", detail=" + detail + ", isXepChong=" + isXepChong + ", gioiTinh=" + gioiTinh + ", type=" + type + ", idClass=" + idClass + ", idIcon=" + idIcon + ", levelNeed=" + levelNeed + ", taiPhuNeed=" + taiPhuNeed + ", idMob=" + idMob + ", idChar=" + idChar + '}';
    }

   public ItemTemplate(int var1) {
      this.id = (short)var1;
   }
}
