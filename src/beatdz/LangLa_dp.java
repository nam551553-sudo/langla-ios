package beatdz;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class LangLa_dp {
   public boolean a = false;
   public Sound[] b = new Sound[38];
   private Music d;
   private Music e;
   
   private int g = -2;
   boolean c;
   private boolean h;

   public static LangLa_dp a() {
      if (beatdz.LangLa_dp.$state_LangLa_dp().f == null) {
         beatdz.LangLa_dp.$state_LangLa_dp().f = new LangLa_dp();
      }

      return beatdz.LangLa_dp.$state_LangLa_dp().f;
   }

   public LangLa_dp() {
      this.a(mConfig.gI().readBoolean(0));
      this.b(mConfig.gI().readBoolean(1));
   }

   public void b() {
      try {
         this.h = false;

         for(int var1 = 0; var1 < this.b.length; ++var1) {
            if (this.b[var1] != null) {
               this.b[var1].pause();
            }
         }

         this.n();
         this.c();
      } catch (Exception var2) {
         Utlis.println(var2);
      }
   }

   private void n() {
      if (this.d != null) {
         this.d.pause();
      }

   }

   public void c() {
      if (this.e != null && !this.h) {
         this.e.pause();
         this.c = false;
         this.h = true;
      }

   }

   void d() {
      try {
         for(int var1 = 0; var1 < this.b.length; ++var1) {
            if (this.b[var1] != null) {
               this.b[var1].dispose();
               this.b[var1] = null;
            }
         }

      } catch (Exception var2) {
         Utlis.println(var2);
      }
   }

   void e() {
      try {
         if (this.d != null) {
            this.d.dispose();
            this.d = null;
         }

         if (this.e != null) {
            this.e.dispose();
            this.e = null;
         }

      } catch (Exception var2) {
         Utlis.println(var2);
      }
   }

   public void a(int var1) {
      try {
         if (!this.a) {
            boolean var2 = this.g != var1;
            this.g = var1;
            if (!var2) {
               this.f();
               this.c = this.h = false;
            } else {
               this.b(mConfig.gI().readBoolean(1));
            }
         }
      } catch (Exception var3) {
         Utlis.println(var3);
      }
   }

   public void a(boolean var1) {
      try {
         mConfig.gI().writeBoolean(0, var1);
         this.d();
         if (var1) {
            for(int var4 = 0; var4 < this.b.length; ++var4) {
               byte[] var2 = Utlis.b(Utlis.internal("sound/" + var4).readBytes());
               Binary.write("sound" + var4, var2, "mp3");
               this.b[var4] = Gdx.audio.newSound(Utlis.external(Binary.a + "sound" + var4 + ".mp3"));
            }

            Binary.deleteStartsWith("sound");
         }

      } catch (Exception var3) {
//         Utlis.println(var3);
      }
   }

   public void b(boolean var1) {
      try {
         mConfig.gI().writeBoolean(1, var1);
         this.e();
         if (var1) {
            byte var5 = -1;
            byte var2 = -1;
            switch(this.g) {
            case -1:
               var5 = 0;
               break;
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 58:
            case 67:
            case 84:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
            default:
               return;
            case 6:
            case 7:
            case 18:
            case 19:
               var5 = 25;
               break;
            case 56:
               var5 = 24;
               break;
            case 57:
               var5 = 17;
               break;
            case 59:
               var5 = 12;
               var2 = 15;
               break;
            case 60:
               var5 = 10;
               var2 = 4;
               break;
            case 61:
               var5 = 17;
               break;
            case 62:
               var2 = 13;
               break;
            case 63:
               var5 = 20;
               break;
            case 64:
               var5 = 21;
               break;
            case 65:
               var5 = 22;
               break;
            case 66:
               var5 = 23;
               break;
            case 68:
               var5 = 8;
               var2 = 2;
               break;
            case 69:
               var5 = 6;
               var2 = 14;
               break;
            case 70:
               var5 = 19;
               break;
            case 71:
               var5 = 18;
               break;
            case 72:
               var5 = 19;
               break;
            case 73:
               var5 = 20;
               break;
            case 74:
               var5 = 21;
               break;
            case 75:
               var5 = 5;
               var2 = 11;
               break;
            case 76:
               var5 = 22;
               break;
            case 77:
               var5 = 21;
               break;
            case 78:
               var5 = 24;
               break;
            case 79:
               var5 = 17;
               break;
            case 80:
               var5 = 23;
               break;
            case 81:
               var5 = 17;
               break;
            case 82:
               var5 = 18;
               break;
            case 83:
               var5 = 9;
               var2 = 2;
               break;
            case 85:
               var5 = 1;
               var2 = 3;
               break;
            case 86:
               var5 = 7;
               var2 = 2;
               break;
            case 87:
               var2 = 9;
               break;
            case 88:
               var5 = 20;
               break;
            case 102:
            case 105:
               var5 = 26;
               break;
            case 103:
            case 104:
               var5 = 27;
            }

            byte[] var3;
            if (var5 >= 0) {
               var3 = Utlis.b(Utlis.internal("music/" + var5).readBytes());
               Binary.write("music" + var5, var3, "mp3");
               this.d = Gdx.audio.newMusic(Utlis.external(Binary.a + "music" + var5 + ".mp3"));
            }

            if (var2 >= 0) {
               var3 = Utlis.b(Utlis.internal("music/" + var2).readBytes());
               Binary.write("music" + var2, var3, "mp3");
               this.e = Gdx.audio.newMusic(Utlis.external(Binary.a + "music" + var2 + ".mp3"));
            }

            Binary.deleteStartsWith("music");
            this.f();
         }

      } catch (Exception var4) {
//         Utlis.println(var4);
      }
   }

   public void f() {
      if (!this.a) {
         try {
            if (this.d != null) {
               if (this.g == 75) {
                  this.d.setVolume(1.0F);
               } else if (this.g == 59) {
                  this.d.setVolume(0.2F);
               } else {
                  this.d.setVolume(0.7F);
               }

               this.d.setLooping(true);
               this.d.play();
            }

         } catch (Exception var2) {
            Utlis.println(var2);
         }
      }
   }

   public void g() {
      if (!this.a) {
         try {
            if (this.e != null && !this.c) {
               if (this.g == 69) {
                  this.e.setVolume(1.0F);
               } else if (this.g == 60) {
                  this.e.setVolume(0.1F);
               } else {
                  this.e.setVolume(0.6F);
               }

               this.e.setLooping(true);
               this.e.play();
               this.c = true;
               this.h = false;
            }

         } catch (Exception var2) {
            Utlis.println(var2);
         }
      }
   }

   public void h() {
      if (!this.a) {
         try {
            if (this.b[0] != null) {
               this.b[0].play();
            }

         } catch (Exception var2) {
            Utlis.println(var2);
         }
      }
   }

   public void a(int var1, int var2, boolean var3) {
      if (!this.a) {
         Sound var5;
         switch(var2) {
         case 0:
            var5 = this.b[19];
            break;
         case 1:
         case 3:
         case 9:
         case 15:
         case 17:
         case 21:
         case 27:
         case 30:
         case 35:
         default:
            var5 = this.b[8];
            break;
         case 2:
            var5 = this.b[20];
            break;
         case 4:
         case 16:
            var5 = this.b[18];
            break;
         case 5:
         case 10:
         case 22:
         case 23:
         case 29:
            var5 = this.b[24];
            break;
         case 6:
         case 8:
            var5 = this.b[12];
            break;
         case 7:
            var5 = this.b[29];
            break;
         case 11:
            var5 = this.b[13];
            break;
         case 12:
            var5 = this.b[14];
            break;
         case 13:
         case 19:
            var5 = this.b[31];
            break;
         case 14:
         case 34:
            var5 = this.b[17];
            break;
         case 18:
            var5 = this.b[16];
            break;
         case 20:
            var5 = this.b[15];
            break;
         case 24:
            var5 = this.b[9];
            break;
         case 25:
            var5 = this.b[26];
            break;
         case 26:
            var5 = this.b[10];
            break;
         case 28:
            var5 = this.b[11];
            break;
         case 31:
            var5 = this.b[28];
            break;
         case 32:
            var5 = this.b[30];
            break;
         case 33:
            var5 = this.b[32];
            break;
         case 36:
            var5 = this.b[37];
            break;
         case 37:
            var5 = this.b[35];
            break;
         case 38:
            var5 = this.b[34];
            break;
         case 39:
            var5 = this.b[33];
            break;
         case 40:
            var5 = this.b[36];
         }

         try {
            if (var5 != null) {
               if (var3) {
                  var5.play(1.0F);
                  return;
               }

               var5.play(0.3F);
            }

         } catch (Exception var4) {
            Utlis.println(var4);
         }
      }
   }

   public void i() {
      if (!this.a) {
         try {
            if (this.b[7] != null) {
               this.b[7].play();
            }

         } catch (Exception var2) {
            Utlis.println(var2);
         }
      }
   }

   public void j() {
      if (!this.a) {
         try {
            if (this.b[2] != null) {
               this.b[2].play();
            }

         } catch (Exception var2) {
            Utlis.println(var2);
         }
      }
   }

   public void a(float var1) {
      if (!this.a) {
         try {
            if (this.b[3] != null) {
               this.b[3].play(0.7F);
            }

         } catch (Exception var2) {
            Utlis.println(var2);
         }
      }
   }

   public void b(float var1) {
      if (!this.a) {
         try {
            if (this.b[25] != null) {
               this.b[25].play(0.7F);
            }

         } catch (Exception var2) {
            Utlis.println(var2);
         }
      }
   }

   public void k() {
      try {
         if (this.b[25] != null) {
            this.b[25].stop();
         }

      } catch (Exception var2) {
         Utlis.println(var2);
      }
   }

   public void l() {
      if (!this.a) {
         try {
            if (this.b[27] != null) {
               this.b[27].play();
            }

         } catch (Exception var2) {
            Utlis.println(var2);
         }
      }
   }

   public void m() {
      if (!this.a) {
         try {
            if (this.b[5] != null) {
               this.b[5].play();
            }

         } catch (Exception var2) {
            Utlis.println(var2);
         }
      }
   }

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public LangLa_dp f;
public void initialize() {
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.LangLa_dp");
public static SessionState $state_LangLa_dp() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
