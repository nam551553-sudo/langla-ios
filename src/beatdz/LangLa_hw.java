package beatdz;
import java.util.Vector;

 class LangLa_hw implements Runnable {
   public void run() {
      boolean var1 = false;

      while(true) {
         while(true) {
            try {
               if (var1) {
                  var1 = false;
               } else {
                  synchronized(MoveSmart.f()) {
                     try {
                        MoveSmart.a(1);
                        MoveSmart.f().wait(1000000000L);
                     } catch (Exception var16) {
                        Utlis.println(var16);
                     }
                  }
               }

               if (MoveSmart.g()) {
                  MoveSmart.a(0);
                  XYEntity var2 = XYEntity.create(MoveSmart.h(), MoveSmart.i());
                  XYEntity var3 = XYEntity.create(MoveSmart.j(), MoveSmart.k());
                  XYEntity var4;
                  if (!Char.gI().a(MoveSmart.h(), MoveSmart.i()) && (var4 = Char.gI().a(var2, 10, true)) != null) {
                     MoveSmart.b(var4.cx);
                     MoveSmart.c(var4.cy);
                     var2 = var4;
                  }

                  if (!Char.gI().a(MoveSmart.j(), MoveSmart.k()) && (var4 = Char.gI().a(var3, 10, true)) != null) {
                     MoveSmart.d(var4.cx);
                     MoveSmart.e(var4.cy);
                     var3 = var4;
                  }

                  Vector var19;
                  if ((var19 = MoveSmart.a(var2, var3, false)) == null) {
                     int var7 = 0;
                     int var8 = 0;

                     for(int var9 = 0; var9 < GameSrc.gI().i.size() && MoveSmart.l() != 2; ++var9) {
                        XYEntity var6 = null;
                        XYEntity var5 = null;

                        int var10;
                        for(var10 = 0; var10 < ((BlockMap)GameSrc.gI().i.get(var9)).arrayXY.length - 1 && MoveSmart.l() != 2; ++var10) {
                           XYEntity var11 = ((BlockMap)GameSrc.gI().i.get(var9)).arrayXY[var10];
                           XYEntity var12 = ((BlockMap)GameSrc.gI().i.get(var9)).arrayXY[var10 + 1];
                           XYEntity var13 = Utlis.a(var2, var11, var12);
                           if (MoveSmart.l() == 2) {
                              break;
                           }

                           int var14;
                           if (var13 != null && !GameSrc.gI().a(var2, var13)) {
                              if (var5 == null) {
                                 var5 = var13;
                                 var7 = var10;
                              } else {
                                 var14 = Utlis.getRange2(var2.cx, var2.cy, var5.cx, var5.cy);
                                 if (Utlis.getRange2(var2.cx, var2.cy, var13.cx, var13.cy) < var14) {
                                    var5 = var13;
                                    var7 = var10;
                                 }
                              }
                           }

                           if (MoveSmart.l() == 2) {
                              break;
                           }

                           if (var11 != null && !GameSrc.gI().a(var2, var11)) {
                              if (var5 == null) {
                                 var5 = var11;
                                 var7 = var10;
                              } else {
                                 var14 = Utlis.getRange2(var2.cx, var2.cy, var5.cx, var5.cy);
                                 if (Utlis.getRange2(var2.cx, var2.cy, var11.cx, var11.cy) < var14) {
                                    var5 = var11;
                                    var7 = var10;
                                 }
                              }
                           }

                           if (MoveSmart.l() == 2) {
                              break;
                           }

                           if (var12 != null && !GameSrc.gI().a(var2, var12)) {
                              if (var5 == null) {
                                 var5 = var12;
                                 var7 = var10;
                              } else {
                                 var14 = Utlis.getRange2(var2.cx, var2.cy, var5.cx, var5.cy);
                                 if (Utlis.getRange2(var2.cx, var2.cy, var12.cx, var12.cy) < var14) {
                                    var5 = var12;
                                    var7 = var10;
                                 }
                              }
                           }

                           if (MoveSmart.l() == 2) {
                              break;
                           }

                           int var15;
                           XYEntity var20;
                           if ((var20 = Utlis.a(var3, var11, var12)) != null && !GameSrc.gI().a(var3, var20)) {
                              if (var6 == null) {
                                 var6 = var20;
                                 var8 = var10;
                              } else {
                                 var15 = Utlis.getRange2(var3.cx, var3.cy, var6.cx, var6.cy);
                                 if (Utlis.getRange2(var3.cx, var3.cy, var20.cx, var20.cy) < var15) {
                                    var6 = var20;
                                    var8 = var10;
                                 }
                              }
                           }

                           if (MoveSmart.l() == 2) {
                              break;
                           }

                           if (var11 != null && !GameSrc.gI().a(var3, var11)) {
                              if (var6 == null) {
                                 var6 = var11;
                                 var8 = var10;
                              } else {
                                 var15 = Utlis.getRange2(var3.cx, var3.cy, var6.cx, var6.cy);
                                 if (Utlis.getRange2(var3.cx, var3.cy, var11.cx, var11.cy) < var15) {
                                    var6 = var11;
                                    var8 = var10;
                                 }
                              }
                           }

                           if (MoveSmart.l() == 2) {
                              break;
                           }

                           if (var12 != null && !GameSrc.gI().a(var3, var12)) {
                              if (var6 == null) {
                                 var6 = var12;
                                 var8 = var10;
                              } else {
                                 var15 = Utlis.getRange2(var3.cx, var3.cy, var6.cx, var6.cy);
                                 if (Utlis.getRange2(var3.cx, var3.cy, var12.cx, var12.cy) < var15) {
                                    var6 = var12;
                                    var8 = var10;
                                 }
                              }
                           }
                        }

                        if (MoveSmart.l() == 2) {
                           var1 = true;
                        } else if (var5 != null && var6 != null) {
                           (var19 = new Vector()).addElement(var2);
                           var19.addElement(var5);
                           if (var7 < var8) {
                              for(var10 = var7 + 1; var10 <= var8 && MoveSmart.l() != 2; ++var10) {
                                 var19.addElement(((BlockMap)GameSrc.gI().i.get(var9)).arrayXY[var10]);
                              }
                           } else {
                              for(var10 = var7; var10 > var8 && MoveSmart.l() != 2; --var10) {
                                 var19.addElement(((BlockMap)GameSrc.gI().i.get(var9)).arrayXY[var10]);
                              }
                           }

                           var19.addElement(var6);
                           var19.addElement(var3);
                           break;
                        }
                     }
                  }

                  if (var19 != null) {
                     MoveSmart.m().addAll(var19);
                  }

                  if (!MoveSmart.g()) {
                     MoveSmart.m().clear();
                  }
               }
            } catch (Exception var18) {
            }
         }
      }
   }
}
