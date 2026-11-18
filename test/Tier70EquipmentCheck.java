package beatdz;

/** Client upgrade eligibility must agree with the level-70 server rule. */
public final class Tier70EquipmentCheck {
 public static void main(String[] args)throws Exception {
  DataCenter d=DataCenter.gI();d.ItemTemplate=new ItemTemplate[1200];d.DataTypeItemBody=new DataTypeItemBody[0];d.ItemOptionTemplate=new ItemOptionTemplate[0];int cases=0;
  for(int type=0;type<=9;type++)for(int required=70;required<=79;required++){
   ItemTemplate t=new ItemTemplate(1131);t.type=(byte)type;t.levelNeed=(short)required;t.name="Hac Long";d.ItemTemplate[1131]=t;
   Item item=new Item(1131);item.strOptions="";item.level=18;
   if(item.getMaxCuongHoaLevel()!=19)throw new AssertionError("Cannot preview +19: "+type+"/"+required);
   item.level=19;if(item.getMaxCuongHoaLevel()!=19)throw new AssertionError("Cap differs at +19");cases++;
  }
  ItemTemplate old=new ItemTemplate(900);old.type=1;old.levelNeed=60;d.ItemTemplate[900]=old;Item oldItem=new Item(900);oldItem.strOptions="";
  if(oldItem.getMaxCuongHoaLevel()!=16)throw new AssertionError("Changed existing 6x equipment cap");
  System.out.println("PASS "+cases+" Hac Long client upgrade previews at +19; existing 6x rule preserved.");
 }
}
