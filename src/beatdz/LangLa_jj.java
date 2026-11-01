package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_jj extends LangLa_cz {
   public Vector a = new Vector();
   public LangLa_jk b;
   private String[] c;
   private boolean[] d;
   private int e;
   private int f;
   private int g;
   

   public static LangLa_jj a() {
      if (beatdz.LangLa_jj.$state_LangLa_jj().h == null) {
         beatdz.LangLa_jj.$state_LangLa_jj().h = new LangLa_jj();
      }

      return beatdz.LangLa_jj.$state_LangLa_jj().h;
   }

   public void a(Graphics var1) {
      int var2 = var1.a;
      int var3 = var1.b;
      if (GameSrc.gI().cE instanceof GameSrc) {
         this.a(var1, this.cx, this.cy);
      } else {
         this.a(var1, this.cx, this.cy - 42);
      }

      if (this.g != 0) {
         Binary2.a(var1, -3, -2, -2, 0, this.g, (int)(this.height + 4));
      }

      if (this.b != null && this.g == this.width) {
         var1.setClip(0, 0, this.width, this.height);

         for(int var5 = 0; var5 < this.c.length; ++var5) {
            int var4 = var5 * (mFont.a(this.b.b) + 2) + mFont.a(this.b.b) / 2 - this.f + 2;
            if (-20 <= var4 && var4 <= 20 + this.height) {
               mFont.c(this.b.b, var1, this.c[var5], this.width / 2, var4, 2, this.b.d, -16777216);
            }
         }

         this.a(var1, 0, 0);
         var1.setClip(0, 0, DataCenter.gI().widthScreen, DataCenter.gI().heightScreen);
      }

      this.a(var1, var2, var3);
   }

   private void c() {
      this.e = this.f = 0;
      this.b = (LangLa_jk)this.a.firstElement();
      this.width = (short)(DataCenter.gI().widthScreen - 230);
      Vector var1 = mFont.a(this.b.b, this.b.a, this.width - 40);
      this.c = new String[var1.size()];
      this.d = new boolean[var1.size()];

      for(int var2 = 0; var2 < var1.size(); ++var2) {
         this.c[var2] = (String)var1.elementAt(var2);
         if (LangLa_fw.e(this.c[var2]) != null) {
            this.d[var2] = true;
         }
      }

      this.b.c = this.c.length * 150;
      if (this.b.c < 80) {
         this.b.c = 80;
      }

      this.height = (short)mFont.a(this.b.b);
      this.height = (short)(this.height + 3);
      this.setXY((DataCenter.gI().widthScreen - this.width) / 2, 50);
   }

   public void b() {
      try {
         if (this.b == null && this.a.size() > 0) {
            this.c();
         }

         if (this.b != null && this.a.size() != 0) {
            this.g += 40;
            if (this.g < this.width) {
               return;
            }

            this.g = this.width;
         } else {
            this.g -= 40;
            if (this.g <= 0) {
               this.g = 0;
            }
         }

         if (this.b != null) {
            ++this.e;
            if (this.e % (this.b.c / this.c.length) == 0) {
               ++this.f;
            } else if (this.f % (mFont.a(this.b.b) + 2) != 0) {
               ++this.f;
            }

            if (this.f >= (this.c.length - 1) * (mFont.a(this.b.b) + 2)) {
               this.f = (this.c.length - 1) * (mFont.a(this.b.b) + 2);
            }

            if (this.e == this.b.c) {
               this.b = null;
               this.a.removeElementAt(0);
            }

         }
      } catch (Exception var1) {
      }
   }

   public void a(String var1, mFont var2, int var3) {
      if (this.a.size() == 0) {
         this.g = 10;
      }

      if (var2 == null) {
         var2 = mFont.d;
      }

      for(int var5 = 0; var5 < this.a.size(); ++var5) {
         LangLa_jk var4;
         String var8;
         if ((var4 = (LangLa_jk)this.a.elementAt(var5)).b.equals(var2) && var4.d == var3 && var4.a != null && var4.a.length() < 80 && var4.a.startsWith(Caption.k) && var1.startsWith(Caption.k)) {
            int var11 = Caption.k.length() + 1;
            int var12 = 0;
            int var13 = 0;
            var8 = var4.a + " ";
            var1 = var1 + " ";

            for(var3 = var11; var3 < var8.length(); ++var3) {
               try {
                  var12 = Integer.parseInt(a(var8.substring(var11, var3), ".", "").trim());
               } catch (Exception var10) {
               }

               if (var8.charAt(var3) == ' ') {
                  break;
               }
            }

            if (var12 <= 0) {
               var12 = 1;
            }

            var8 = var8.substring(var3).trim();

            for(var3 = var11; var3 < var1.length(); ++var3) {
               try {
                  var13 = Integer.parseInt(a(var1.substring(var11, var3), ".", "").trim());
               } catch (Exception var9) {
               }

               if (var1.charAt(var3) == ' ') {
                  break;
               }
            }

            if (var13 <= 0) {
               var13 = 1;
            }

            if ((var1 = var1.substring(var3).trim()).equals(var8)) {
               var4.a = Caption.k + " " + Utlis.numberFormat(var12 + var13) + " " + var1;
            } else {
               var4.a = var4.a + ", " + Utlis.numberFormat(var13) + " " + var1;
            }

            if (var5 == 0) {
               this.c();
            }

            return;
         }

         if (var4.b.equals(var2) && var4.d == var3 && var4.a != null && var4.a.length() < 80) {
            if (var4.a.equals(var1) || var4.a.indexOf(var1) >= 0) {
               if (var5 == 0) {
                  this.c();
               }

               return;
            }

            if (var4.a.length() >= 8) {
               String var6 = var1.substring(0, 8);
               String var7 = var4.a.substring(0, 8);
               if (var6.equals(var7)) {
                  for(var3 = 7; var3 < var1.length() && var3 < var4.a.length() && var1.charAt(var3) == var4.a.charAt(var3); ++var3) {
                  }

                  var8 = var1.substring(var3, var1.length());
                  var4.a = var4.a + ", " + var8;
                  if (var5 == 0) {
                     this.c();
                  }

                  return;
               }
            }
         }
      }

      if (this.a.size() > 15) {
         this.a.removeElementAt(0);
      }

      this.a.addElement(new LangLa_jk(this, var1, var2, var3));
   }

   private static String a(String var0, String var1, String var2) {
      StringBuffer var3;
      int var4;
      for(var3 = new StringBuffer(); (var4 = var0.indexOf(var1)) != -1; var0 = var0.substring(var4 + var1.length())) {
         var3.append(var0.substring(0, var4) + var2);
      }

      var3.append(var0);
      return var3.toString();
   }

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public LangLa_jj h;
public void initialize() {
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.LangLa_jj");
public static SessionState $state_LangLa_jj() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
