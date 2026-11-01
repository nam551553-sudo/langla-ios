package beatdz;
public class LangLa_ir extends Entity {
   public boolean j;
   private Entity k;

   public Entity renderSubject() { return k; }

   public LangLa_ir(boolean var1, int var2, int var3, Entity var4) {
      this.setXY(var2, var3);
      this.j = var1;
      this.k = var4;
   }

   public int a() {
      return 0;
   }

   public int b() {
      return 0;
   }

   public int c() {
      return 0;
   }

   public int d() {
      return 0;
   }

   public void a(Graphics var1) {
      if (!Utlis.f()) {
         Char var2;
         if (!(this.k instanceof Char) || ((var2 = (Char)this.k).isMe() || !var2.z) && !var2.R()) {
            short var6 = 642;
            short var3 = 100;
            int var4 = 0;
            if (this.k instanceof Mob) {
               Mob var5;
               if ((var5 = (Mob)this.k).getMobTemplate().indexData == 255) {
                  var3 = 120;
               } else if (var5.getMobTemplate().indexData == 256) {
                  var6 = 21;
                  var3 = 75;
               } else if (var5.levelBoss != 8 && var5.id != 265 && var5.id != 266 && var5.id != 263 && var5.id != 276 && var5.id != 278) {
                  if (var5.id == 163) {
                     var6 = 21;
                     var3 = 62;
                     var4 -= 5;
                  } else if (var5.id == 188) {
                     var6 = 21;
                     var4 -= 2;
                  } else if (var5.id != 179 && var5.id != 173 && var5.id != 183 && var5.id != 273 && var5.id != 275 && var5.id != 277 && var5.id != 274) {
                     if (var5.id != 180 && var5.id != 120 && var5.id != 66 && var5.id != 176 && var5.id != 121 && var5.id != 182 && var5.id != 262) {
                        if (var5.id != 166 && var5.id != 178 && var5.id != 185 && var5.id != 97 && var5.id != 264) {
                           if (var5.id == 189) {
                              var6 = 21;
                              var3 = 88;
                           } else if (var5.id == 190) {
                              var6 = 21;
                              var3 = 130;
                           } else if (var5.id == 192) {
                              var6 = 21;
                              var3 = 110;
                           } else if (var5.id == 193) {
                              var6 = 21;
                              var3 = 115;
                           } else if (var5.id >= 285 && var5.id <= 289) {
                              var3 = 105;
                           } else if (var5.id == 172 || var5.id == 178 || var5.id == 236 || var5.levelBoss == 9 || var5.getMobTemplate().p == 3 && (!GameSrc.gI().E() || GameSrc.gI().getMapTemplate().type == 16)) {
                              var6 = 21;
                           }
                        } else {
                           var6 = 21;
                           var3 = 70;
                        }
                     } else {
                        var6 = 21;
                        var3 = 62;
                        var4 -= 2;
                     }
                  } else {
                     var6 = 21;
                     var3 = 52;
                  }
               } else {
                  var3 = 120;
               }
            }

            XYEntity var7;
            if ((var7 = Char.c(this.cx, this.cy)) != null) {
               this.cy = var7.cy;
            }

            Binary2.a(var1, var6, 0, this.cx, this.cy + var4, var3, (byte)3);
         }
      }
   }

   public String f() {
      return null;
   }

   public String g() {
      return null;
   }

   public String h() {
      return null;
   }

   public void b(Graphics var1) {
   }

   public int e() {
      return 4;
   }
}
