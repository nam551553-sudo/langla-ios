package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_ch extends LangLa_fl {
   public String[] a;
   public String b;
   public byte c;
   public int d;
   public int e;
   public mImage f;
   public LangLa_cy g;
   public String h;
   public byte i;
   private LangLa_dz j;

   public LangLa_ch(String var1, MainScreen var2, int var3) {
      this.h = Caption.f;
      var2.b(var2.cL);
      if (var2.cE != null) {
         var2.cE.b((LangLa_cs)var2.cE.cL);
      }

      this.cF = 4;
      this.p = var2;
      this.c = (byte)var3;
      this.b = var1;
      this.a(200, 140);
      if (var3 != 3 && var3 != 4) {
         this.a = mFont.c(mFont.d, var1, this.width - 30);
      } else {
         this.e = (int)(Utlis.time() / 1000L);
         this.a = mFont.c(mFont.d, Utlis.replaceAll(var1, "" + this.d), this.width - 30);
      }

      this.j = this.a(Caption.g, -7);
   }

   public void b() {
      if (this.c == 3 || this.c == 4) {
         int var1;
         if ((var1 = (int)((long)this.d - (Utlis.time() / 1000L - (long)this.e))) < 0) {
            var1 = 0;
         }

         if (this.c == 4 && var1 < 5) {
            this.j.b(true);
         }

         this.a = mFont.c(mFont.d, Utlis.replaceAll(this.b, "" + var1), this.width - 20);
      }

   }

   public void a(Graphics var1) {
      this.a(var1, this.cx, this.cy, this.width, this.height, this.h, (byte)2, this.r);
      this.a(var1, 6, 33, this.width - 12, this.height - 48, -11, 55, 56);
      this.a(var1, this.cx + 4, this.cy + this.a_());
      int var2;
      if (this.f != null) {
         var1.a(this.f, 0, 0, this.f.c, this.f.d, 0, this.width / 2, 23, 3);

         for(var2 = 0; var2 < this.a.length; ++var2) {
            mFont.c(mFont.d, var1, this.a[var2], 10, this.G() / 2 + 25 + var2 * 12 - this.a.length * 6, 0, -1, -16777216);
         }

      } else if (this.c == 1) {
         for(var2 = 0; var2 < this.a.length; ++var2) {
            mFont.a(mFont.d, var1, this.a[var2], (super.width - 8) / 2, this.G() / 2 - 4 + var2 * 12 - this.a.length * 6, 2, -7812062, 3, 0);
         }

      } else if (this.c == 2) {
         for(var2 = 0; var2 < this.a.length; ++var2) {
            mFont.c(mFont.d, var1, this.a[var2], 15, this.G() / 2 - 4 + var2 * 12 - this.a.length * 6, 0, -1, -16777216);
         }

      } else {
         for(var2 = 0; var2 < this.a.length; ++var2) {
            mFont.c(mFont.d, var1, this.a[var2], (super.width - 8) / 2, this.G() / 2 - 4 + var2 * 12 - this.a.length * 6, 2, -1, -16777216);
         }

      }
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      if (var1.b >= 2000 && var1.b <= 3000) {
         this.J();
         this.g.a(var1, var2, var3);
      } else {
         switch(var1.b) {
         case 10000:
            this.J();
            return;
         case 10001:
            this.J();
            return;
         case 10002:
            LangLa_ch var7 = this;

            try {
               Message.d(var7.i).send();
            } catch (Exception var6) {
               Utlis.println(var6);
            }

            this.J();
            return;
         case 10003:
            this.J();
            if (this.p.cE instanceof LangLa_fo) {
               ((LangLa_fo)this.p.cE).a(var1, var2, var3);
               return;
            }
            break;
         case 10004:
            this.a((byte)-128);
            return;
         case 10005:
            this.a((byte)-127);
            return;
         case 10006:
            try {
               Message.d((byte)-122).send();
               if (DataCenter.gI().currentScreen instanceof LoginPCScreen) {
                  ((LoginPCScreen)DataCenter.gI().currentScreen).k();
               }
            } catch (Exception var5) {
               Utlis.println(var5);
            }

            this.J();
            return;
         case 10007:
            if (this.p instanceof LoginPCScreen) {
               ((LoginPCScreen)this.p).k();
            } else if (this.p instanceof LangLa_kt) {
               ((LangLa_kt)this.p).a();
            }

            this.J();
            return;
         case 10008:
            this.J();
            if (Session.gI().isConnected()) {
               DataCenter.gI().aI = true;
               Session.gI().close();
               return;
            }
            break;
         case 10009:
            this.J();
            LangLa_cz.T();
            return;
         case 10010:
            this.J();
            beatdz.DataCenter.$state_DataCenter().aR = 0;
            return;
         case 20000:
            this.p.l(Caption.i).cG.clear();
            beatdz.CheckVersionScreen.$state_CheckVersionScreen().b = true;
            AppListener.$state_AppListener().h = 50;
            return;
         default:
            super.a(var1, var2, var3);
         }

      }
   }

   public Vector c() {
      return super.c();
   }

   public void a(int var1, Object var2, LangLa_cy var3) {
   }

   public void a(int var1, Object var2) {
   }

   public mTextBox e() {
      mTextBox var1 = null;

      for(int var2 = 0; var2 < this.cG.size(); ++var2) {
         if (this.cG.get(var2) instanceof mTextBox) {
            var1 = (mTextBox)this.cG.get(var2);
            break;
         }
      }

      return var1;
   }

   public void a(byte var1) {
      try {
         String var2 = "";
         mTextBox var3;
         if ((var3 = this.e()) != null) {
            var2 = var3.f();
            var3.a("");
         }

         Message var5;
         (var5 = Message.a(var1)).writeUTF(var2);
         var5.send();
      } catch (Exception var4) {
         Utlis.println(var4);
      }
   }
}
