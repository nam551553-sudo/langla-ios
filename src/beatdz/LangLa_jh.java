package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_jh extends LangLa_cz {
   public Vector a = new Vector();
   public LangLa_ji b;
   private String[] d;
   private int e;
   
   public boolean c = false;

   public static LangLa_jh a() {
      if (beatdz.LangLa_jh.$state_LangLa_jh().f == null) {
         beatdz.LangLa_jh.$state_LangLa_jh().f = new LangLa_jh();
      }

      return beatdz.LangLa_jh.$state_LangLa_jh().f;
   }

   public void a(Graphics var1) {
      try {
         int var2 = var1.a;
         int var3 = var1.b;
         if (GameSrc.gI().cE instanceof LangLa_fo) {
            this.a(var1, this.cx, this.cy + 42);
         } else {
            this.a(var1, this.cx, this.cy);
         }

         if (this.b != null) {
            this.a(var1, -10, -8, this.width + 20, this.height + 16, -18, 55, 56);

            for(int var4 = 0; var4 < this.d.length; ++var4) {
               mFont.a(this.b.b, var1, this.d[var4], this.width / 2, -1 + this.height / 2 + mFont.a(this.b.b) / 2 + var4 * mFont.a(this.b.b) - this.d.length * mFont.a(this.b.b) / 2, 2, this.b.d);
            }
         }

         this.a(var1, var2, var3);
      } catch (Exception var5) {
         Utlis.println(var5);
      }
   }

   private void c() {
      this.e = 0;
      this.b = (LangLa_ji)this.a.firstElement();
      this.width = (short)mFont.b(this.b.b, this.b.a);
      if (this.width > DataCenter.gI().widthScreen - 200) {
         this.width = (short)(DataCenter.gI().widthScreen - 200);
      }

      this.d = mFont.c(this.b.b, this.b.a, this.width);
      this.b.c = this.d.length * 50;
      if (this.b.c < 80) {
         this.b.c = 80;
      }

      this.height = (short)(this.d.length * mFont.a(this.b.b));
      this.setXY(DataCenter.gI().widthScreen / 2 - this.width / 2, DataCenter.gI().heightScreen - this.height - 68);
   }

   public void b() {
      try {
         if (this.c) {
            this.c = false;
            this.a.clear();
            this.b = null;
         } else {
            if (this.b == null && this.a.size() > 0) {
               this.c();
            }

            if (this.b != null) {
               ++this.e;
               if (this.e == this.b.c) {
                  this.b = null;
                  this.a.removeElementAt(0);
               }

            }
         }
      } catch (Exception var1) {
      }
   }

   public void a(String var1, mFont var2, int var3) {
      if (var1.contains(Caption.qf)) {
         GameSrc.gI().cl.e = GameSrc.gI().cl.f = true;
      }

      if (var2 == null) {
         var2 = mFont.d;
      }

      if (var1.toLowerCase().contains(Caption.pr.toLowerCase()) && this.b != null && this.b.a.toLowerCase().contains(Caption.pr.toLowerCase())) {
         this.b.a = var1;
         this.e = 0;
         this.width = (short)mFont.b(this.b.b, this.b.a);
         if (this.width > DataCenter.gI().widthScreen - 200) {
            this.width = (short)(DataCenter.gI().widthScreen - 200);
         }

         this.d = mFont.c(this.b.b, this.b.a, this.width);
         this.b.c = this.d.length * 50;
         if (this.b.c < 80) {
            this.b.c = 80;
         }

         this.height = (short)(this.d.length * mFont.a(this.b.b));
         this.setXY(DataCenter.gI().widthScreen / 2 - this.width / 2, DataCenter.gI().heightScreen - this.height - 68);
      } else {
         for(int var5 = 0; var5 < this.a.size(); ++var5) {
            LangLa_ji var4;
            String var8;
            if ((var4 = (LangLa_ji)this.a.elementAt(var5)).b.equals(var2) && var4.d == var3 && var4.a != null && var4.a.length() < 80 && var4.a.startsWith(Caption.k) && var1.startsWith(Caption.k)) {
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

         this.a.addElement(new LangLa_ji(this, var1, var2, var3));
      }
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
public LangLa_jh f;
public void initialize() {
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.LangLa_jh");
public static SessionState $state_LangLa_jh() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
