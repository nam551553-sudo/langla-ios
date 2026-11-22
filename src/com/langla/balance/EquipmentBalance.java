package com.langla.balance;
/** Pure view/combat policy. Stored rolls and upgrade metadata are never rewritten. */
public final class EquipmentBalance {
 public static final int REVISION=4;
 private EquipmentBalance(){}
 public static boolean equipment(int type){return type>=0&&type<=9;}
 public static int tails(int itemId){return itemId>=476&&itemId<=484?itemId-475:0;}
 public static boolean combat(int id){switch(id){case 0:case 1:case 2:case 3:case 4:case 5:case 6:case 7:case 8:case 9:case 10:case 11:case 12:case 13:case 14:case 15:case 16:case 17:case 18:case 19:case 20:case 21:case 22:case 23:case 24:case 25:case 26:case 27:case 28:case 29:case 30:case 31:case 32:case 33:case 34:case 35:case 36:case 37:case 38:case 39:case 40:case 41:case 42:case 43:case 44:case 45:case 46:case 47:case 48:case 49:case 50:case 51:case 52:case 63:case 64:case 65:case 66:case 67:case 68:case 69:case 70:case 71:case 72:case 78:case 79:case 80:case 81:case 82:case 83:case 84:case 85:case 86:case 89:case 91:case 95:case 106:case 107:case 108:case 109:case 110:case 111:case 112:case 113:case 114:case 115:case 116:case 117:case 118:case 119:case 120:case 121:case 122:case 123:case 124:case 125:case 126:case 127:case 136:case 137:case 143:case 144:case 145:case 146:case 147:case 149:case 150:case 151:case 152:case 153:case 154:case 155:case 156:case 157:case 158:case 160:case 161:case 162:case 166:case 167:case 168:case 169:case 170:case 171:case 172:case 173:case 174:case 175:case 180:case 184:case 185:case 186:case 187:case 189:case 192:case 197:case 199:case 200:case 201:case 202:case 203:case 204:case 205:case 206:case 208:case 209:case 252:case 253:case 254:case 255:case 256:case 257:case 258:case 259:case 260:case 261:case 262:case 263:case 267:case 269:case 280:case 289:case 290:case 291:case 292:case 293:case 304:case 306:case 307:case 309:case 310:case 311:case 323:case 324:case 325:case 326:case 327:case 328:case 329:case 330:case 331:case 332:case 344:case 345:case 346:case 348:case 350:case 351:case 352:case 353:case 354:case 355:case 356:case 357:case 358:case 359:case 360:case 361:case 362:case 371:case 372:case 373:case 379:case 380:case 381:case 382:case 383:case 384: return true;default:return false;}}
 public static boolean criticalChance(int optionId){return optionId==5||optionId==15||optionId==28||optionId==63||optionId==144||optionId==166||optionId==203||optionId==362;}
 public static boolean basicAttackAmplification(int optionId){return optionId==34||optionId==47||optionId==122;}
 public static int value(int itemId,int itemType,int optionId,int raw,boolean percent){
  return value(itemId,itemType,optionId,raw,percent,REVISION);
 }
 public static int value(int itemId,int itemType,int optionId,int raw,boolean percent,int revision){
  return value(itemId,itemType,optionId,raw,percent,revision,false);
 }
 public static int value(int itemId,int itemType,int optionId,int raw,boolean percent,int revision,boolean atMax){
  if(revision<=0)return raw;
  if(revision>=3){
   if(tails(itemId)>0&&optionId==149)return tails(itemId);
   int restored=raw;
   boolean roundTens=atMax&&equipment(itemType)&&combat(optionId)&&raw>=10&&!percent;
   if(roundTens)restored=(int)Math.min(Integer.MAX_VALUE,((raw+5L)/10L)*10L);
   if(revision>=4&&criticalChance(optionId)&&restored>0){
    long unit=roundTens?10L:1L;
    return (int)Math.max(Math.min(restored,unit),((restored*90L+50L*unit)/(100L*unit))*unit);
   }
   return restored;
  }
  int baseline=previousValue(itemId,itemType,optionId,raw,percent);
  if(revision>=2&&basicAttackAmplification(optionId)&&baseline>0)
   return (int)Math.max(1L,(baseline*80L+50L)/100L);
  return baseline;
 }
 private static int previousValue(int itemId,int itemType,int optionId,int raw,boolean percent){
  if(tails(itemId)>0&&optionId==149)return tails(itemId);
  if(!equipment(itemType)||!combat(optionId)||raw<=0)return raw;
  long unit=optionId==98?100L:percent||raw<10?1L:10L;
  long rounded=((raw*90L+50L*unit)/(100L*unit))*unit;
  if(rounded==0)rounded=Math.min(raw,(int)unit);
  return (int)Math.min(Integer.MAX_VALUE,Math.min((raw/unit)*unit==0?raw:(raw/unit)*unit,rounded));
 }
}
