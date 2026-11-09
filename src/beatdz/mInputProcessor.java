package beatdz;import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Application.ApplicationType;
import java.util.Hashtable;
import java.util.Vector;

public class mInputProcessor implements InputProcessor {
   
   
   Canvas a;
   int b = -1;
   private int e;
   private int f;
   private int g;
   private int androidMovePointer = -1;
   private LangLa_ea androidJoystick;

   public mInputProcessor(Canvas var1, int var2, int var3) {
      this.a = var1;
      this.f = var2;
      this.g = 0;
      Gdx.input.setCatchBackKey(true);
   }

   public static void a(short[] var0) {
      beatdz.mInputProcessor.$state_mInputProcessor().c.put(Integer.valueOf(var0[0]), 15);
      beatdz.mInputProcessor.$state_mInputProcessor().c.put(Integer.valueOf(var0[1]), 16);
      beatdz.mInputProcessor.$state_mInputProcessor().c.put(Integer.valueOf(var0[2]), 17);
      beatdz.mInputProcessor.$state_mInputProcessor().c.put(Integer.valueOf(var0[3]), 18);
      beatdz.mInputProcessor.$state_mInputProcessor().c.put(Integer.valueOf(var0[4]), 19);
      beatdz.mInputProcessor.$state_mInputProcessor().c.put(Integer.valueOf(var0[5]), -1);
      beatdz.mInputProcessor.$state_mInputProcessor().c.put(Integer.valueOf(var0[6]), -2);
      beatdz.mInputProcessor.$state_mInputProcessor().c.put(Integer.valueOf(var0[7]), -3);
      beatdz.mInputProcessor.$state_mInputProcessor().c.put(Integer.valueOf(var0[8]), -4);
      beatdz.mInputProcessor.$state_mInputProcessor().c.put(Integer.valueOf(var0[9]), 20);
   }

   public boolean keyDown(int var1) {
      if ((var1 != 4 || Gdx.app.getType() == ApplicationType.Android) && var1 != 67) {
         LangLa_cx var2;
         boolean var7;
         switch(var1) {
         case 4:
         case 131:
            if ((var2 = DataCenter.gI().currentScreen.cE) != null) {
               if (var2.cL != null) {
                  var2.b((LangLa_cs)var2.cL);
                  return true;
               }

               if (var2.cG.size() != 0) {
                  if (var2 instanceof LangLa_ch) {
                     ((LangLa_ch)var2).J();
                  } else if (var2 instanceof LangLa_fo) {
                     ((LangLa_fo)var2).J();
                  } else {
                     DataCenter.gI().currentScreen.G();
                  }

                  return true;
               }

               if (var2 instanceof LangLa_x) {
                  LangLa_x var11;
                  (var11 = (LangLa_x)var2).J();
                  LangLa_dp.a().h();
                  return true;
               }

               if (var2 instanceof LangLa_fl) {
                  ((LangLa_fl)var2).J();
                  return true;
               }
            }
            break;
         case 61:
            if (beatdz.Binary2.$state_Binary2().a != null) {
               beatdz.Binary2.$state_Binary2().a.J();
            }

            if ((var2 = DataCenter.gI().currentScreen.cE) != null) {
               Vector var10 = new Vector();
               mTextBox var12 = null;

               int var13;
               for(var13 = 0; var13 < var2.cG.size(); ++var13) {
                  LangLa_cs var6;
                  if ((var6 = (LangLa_cs)var2.cG.elementAt(var13)) instanceof mTextBox) {
                     mTextBox var14 = (mTextBox)var6;
                     var10.add(var14);
                     if (var14.t) {
                        var12 = var14;
                     }
                  }
               }

               if (var10.size() > 1) {
                  var13 = 0;
                  if (var12 != null) {
                     var7 = false;
                     var12.t = var7;
                     var13 = var10.indexOf(var12);
                     ++var13;
                     if (var13 >= var10.size()) {
                        var13 = 0;
                     }
                  }

                  mTextBox var10000 = (mTextBox)var10.get(var13);
                  var7 = true;
                  var10000.t = var7;
                  ((mTextBox)var10.get(var13)).a((LangLa_jz)(new LangLa_jz(-1001, 0, 0, 0, 0, new LangLa_ii((byte)0, 0, 0, 0, 0, 0, 0), var2)), 0, 0);
               }
            }
            break;
         case 66:
            if (beatdz.Binary2.$state_Binary2().a != null) {
               beatdz.Binary2.$state_Binary2().a.J();
            }

            if ((var2 = DataCenter.gI().currentScreen.cE) != null) {
               if (!(var2 instanceof LangLa_kq) && !(var2 instanceof GameSrc)) {
                  if (var2 instanceof LoginPCScreen) {
                     label127: {
                        LoginPCScreen var8;
                        if ((var8 = (LoginPCScreen)var2).a.t) {
                           if (var8.b.f().length() <= 0) {
                              var7 = false;
                              var8.a.t = var7;
                              var7 = true;
                              var8.b.t = var7;
                              break label127;
                           }

                           if (var8.a.f().length() != 0) {
                              var8.k();
                              break label127;
                           }
                        } else if (var8.a.f().length() > 0) {
                           if (var8.b.f().length() == 0) {
                              var7 = false;
                              var8.a.t = var7;
                              var7 = true;
                              var8.b.t = var7;
                           } else {
                              var8.k();
                           }
                           break label127;
                        }

                        var7 = true;
                        var8.a.t = var7;
                        var7 = false;
                        var8.b.t = var7;
                     }
                  } else if (var2 instanceof LangLa_ch) {
                     LangLa_ch var9;
                     if ((var9 = (LangLa_ch)var2).f != null) {
                        var9.a((byte)-128);
                     }
                  } else if (var2 instanceof SelectCharScreen) {
                     ((SelectCharScreen)var2).a();
                  }
               } else {
                  for(int var3 = 0; var3 < var2.cG.size(); ++var3) {
                     LangLa_cs var4;
                     if ((var4 = (LangLa_cs)var2.cG.elementAt(var3)) instanceof mTextBox) {
                        mTextBox var5 = (mTextBox)var4;
                        if (Gdx.app.getType() == ApplicationType.Desktop) {
                           var7 = false;
                           var5.t = var7;
                           if (GameSrc.gI().ah != null && GameSrc.gI().ah.equals(var5)) {
                              var5.setXY(-200, -200);
                              var5.b(true);
                           }
                        }

                        if (var5.p) {
                           GameSrc.gI().a(var5);

                           for(var1 = 0; var1 < DataCenter.gI().currentScreen.cG.size(); ++var1) {
                              ((LangLa_cs)DataCenter.gI().currentScreen.cG.elementAt(var1)).t = false;
                           }

                           return true;
                        }
                     }
                  }
               }
            }
         }

         this.e = var1;
         this.a.a(c(var1));
         return true;
      } else {
         return false;
      }
   }

   public boolean keyUp(int var1) {
      this.a.b(c(var1));
      return false;
   }

   public boolean keyTyped(char var1) {
      if (beatdz.mInputProcessor.$state_mInputProcessor().d.get(Integer.valueOf(var1)) != null) {
         this.a.a(var1);
      }

      return false;
   }

   private int a(int var1) {
      return DisplayZoom.inputCoordinate(var1, this.f, DataCenter.gI().zoomLevelScreen, this.a.getInputUiScale());
   }

   private int b(int var1) {
      return DisplayZoom.inputCoordinate(var1, this.g - MultiSession.barHeight(), DataCenter.gI().zoomLevelScreen, this.a.getInputUiScale());
   }

   public boolean touchDown(int var1, int var2, int var3, int var4) {
      if (var2 < MultiSession.barHeight()) return true;
      if (Gdx.app.getType() == ApplicationType.Android) {
         MainScreen screen = DataCenter.gI().currentScreen;
         if (screen instanceof GameSrc && screen.cE == screen && screen.cL == null) {
            LangLa_ea joystick = ((GameSrc)screen).X;
            int x = this.a(var1), y = this.b(var2);
            if (joystick != null && joystick.containsAndroidTouch(x, y)) {
               if (androidJoystick == null && joystick.beginAndroidTouch(x, y)) {
                  androidMovePointer = var3;
                  androidJoystick = joystick;
               }
               return true;
            }
         }
         if (this.b >= 0) return true;
      }
      this.a.preparePointerInput();
      this.b = var3;
      LangLa_gg var6;
      if (DataCenter.gI().aO != null && DataCenter.gI().aO.f && Utlis.inRange((var6 = DataCenter.gI().aO).b - 10, var6.c - 10, var6.b + 70, var6.c + 70, var1 / DataCenter.gI().zoomLevel + 25, var2 / DataCenter.gI().zoomLevel + 25)) {
         var6.f = false;
      }

      this.a.b(this.a(var1), this.b(var2));
      return true;
   }

   public boolean touchUp(int var1, int var2, int var3, int var4) {
      if (var3 == androidMovePointer) {
         cancelAndroidMovement();
         return true;
      }
      if (this.b != var3) return false;
      this.b = -1;
      if (var2 < MultiSession.barHeight()) {
         this.a.cancelPointer();
         return true;
      } else {
         this.a.c(this.a(var1), this.b(var2));
         return true;
      }
   }

   public boolean touchDragged(int var1, int var2, int var3) {
      if (var3 == androidMovePointer) {
         MainScreen screen = DataCenter.gI().currentScreen;
         if (screen == null || screen != androidJoystick.s || screen.cE != screen
               || !androidJoystick.moveAndroidTouch(this.a(var1), this.b(var2))) {
            cancelAndroidMovement();
         }
         return true;
      }
      if (var2 < MultiSession.barHeight()) return true;
      if (this.b != var3) {
         return false;
      } else {
         this.a.a(this.a(var1), this.b(var2));
         return true;
      }
   }

   public boolean mouseMoved(int var1, int var2) {
      return false;
   }

   public boolean scrolled(int var1) {
      return false;
   }

   public boolean scrolled(float amountX, float amountY) {
      return scrolled((int)amountY);
   }

   public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
      if (pointer == androidMovePointer) {
         cancelAndroidMovement();
         return true;
      }
      if (pointer != this.b) return false;
      this.b = -1;
      this.a.cancelPointer();
      return true;
   }

   void cancelAndroidMovement() {
      if (androidJoystick != null) androidJoystick.d();
      androidJoystick = null;
      androidMovePointer = -1;
   }

   private static int c(int var0) {
      Integer var1;
      return (var1 = (Integer)beatdz.mInputProcessor.$state_mInputProcessor().c.get(var0)) == null ? Integer.MIN_VALUE : var1;
   }

   

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public Hashtable c;
public Hashtable d;
public void initialize() {
this.c = new Hashtable();
this.d = new Hashtable();
{
      this.c.put(61, -15);
      this.c.put(66, -16);
      this.c.put(67, 8);
      this.c.put(62, 32);
      this.c.put(3, 3);
      this.c.put(132, 132);
      a(Binary.a());
      this.d.put(8, 8);
      this.d.put(22, 22);
      this.d.put(127, 127);

      for(int var0 = 0; var0 < mFont.k.length(); ++var0) {
         char var1 = mFont.k.charAt(var0);
         this.d.put(Integer.valueOf(var1), Integer.valueOf(var1));
      }

   }
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.mInputProcessor");
public static SessionState $state_mInputProcessor() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
