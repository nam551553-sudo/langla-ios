package beatdz;
import com.tgame.model.Caption;

public class LangLa_lw extends LangLa_ch {
   public byte j;
   public String k;
   public mTextBox l;

   public LangLa_lw(String var1, MainScreen var2, int var3) {
      super(var1, var2, 0);
      this.a(240, 160);
   }

   public void a(Graphics var1) {
      this.a(var1, this.cx, this.cy, this.width, this.height, this.h, (byte)2, this.r);
      this.a(var1, 6, 33, this.width - 12, this.height - 48, -11, 55, 56);
      mImage var10001 = this.f;
      int var10002 = this.width / 2;
      int var10003 = this.a_() + 25;
      boolean var2 = true;
      int var5 = var10003;
      int var4 = var10002;
      mImage var3 = var10001;
      if (var3 != null) {
         var1.a(var3, 0, 0, var3.c, var3.d, 0, var4, var5, 3);
      }

      this.a(var1, this.cx + 4, this.cy + this.a_());
      mFont.c(mFont.d, var1, this.b, this.l.cx - 10, this.l.cy - 16, 1, -1, -16777216);
      mFont.c(mFont.d, var1, Utlis.replaceAll(Caption.pn, this.k), this.width / 2 - 5, this.l.cy + 5, 2, -2560, -16777216);
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      if (var1.b == 190) {
         LangLa_lw var5 = this;

         try {
            String var7 = "";
            mTextBox var8;
            if ((var8 = var5.e()) != null) {
               var7 = var8.f();
               var8.a("");
            }

            Message var6;
            (var6 = Message.c(var5.j)).writeUTF(var7);
            var6.send();
            return;
         } catch (Exception var4) {
            Utlis.println(var4);
         }
      }

   }
}
