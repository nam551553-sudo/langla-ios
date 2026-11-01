package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_ci extends LangLa_fl {
   private byte d;
   public LangLa_cy a;
   public String b;
   public byte c;
   private String[] e;
   private LangLa_dz f;

   public LangLa_ci(String[] var1, MainScreen var2, int var3, int var4) {
      this.b = Caption.f;
      var2.b(var2.cL);
      if (var2.cE != null) {
         var2.cE.b((LangLa_cs)var2.cE.cL);
      }

      this.cF = 4;
      this.p = var2;
      this.e = var1;
      this.d = 0;
      this.a(200, 140);
      this.f = this.a(this.width / 2 - 37, this.height - 29, Caption.g, this, var4, -24);
      this.H();
   }

   public void a(String var1) {
      this.f.a = var1;
   }

   public void a(Graphics var1) {
      this.a(var1, 2, 19, this.width - 3, this.height - 29, -11, 55, 56);
      var1.f(-10275328);
      var1.b(6, 23, this.width - 12, this.height - 38);
      this.a(var1, this.cx + 4, this.cy + this.a_());

      for(int var2 = 0; var2 < this.e.length; ++var2) {
         mFont.a(var1, this.e[var2], this.width / 2, this.G() / 2 + var2 * 12 - this.e.length * 6, 2, -1);
      }

   }

   public void a(LangLa_jz var1, int var2, int var3) {
      if (var1.b >= 2000 && var1.b <= 3000) {
         this.J();
         this.a.a(var1, var2, var3);
      } else {
         switch(var1.b) {
         case 10000:
            this.J();
            return;
         case 10001:
            this.J();
            return;
         case 10002:
            LangLa_ci var7 = this;

            try {
               Message.d(var7.c).send();
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

   private mTextBox e() {
      mTextBox var1 = null;

      for(int var2 = 0; var2 < this.cG.size(); ++var2) {
         if (this.cG.get(var2) instanceof mTextBox) {
            var1 = (mTextBox)this.cG.get(var2);
            break;
         }
      }

      return var1;
   }

   private void a(byte var1) {
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

   public void b() {
   }
}
