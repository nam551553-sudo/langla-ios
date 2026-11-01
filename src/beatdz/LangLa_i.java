package beatdz;
import com.tgame.model.Caption;

public class LangLa_i extends LangLa_fo {
   private mTextBox a;
   private int b;
   private int c;

   public LangLa_i(MainScreen var1) {
      this.p = var1;
      this.a(210, 120);
      this.a = this.a(88, 44, 100, "", this, 0);
      byte var2 = 30;
      this.a.a = var2;
      this.a.a("");
      this.a(this.width / 2 - 35, this.height - 28, Caption.g, this, 1001, 15);
   }

   public void a(int var1, Object var2) {
   }

   public void a(int var1, Object var2, LangLa_cy var3) {
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      switch(var1.b) {
      case 1001:
         LangLa_i var5 = this;

         try {
            Message var6;
            (var6 = Message.c((byte)-110)).writeUTF(var5.a.f());
            var6.send();
            return;
         } catch (Exception var4) {
         }
      default:
      }
   }

   public void a(Graphics var1) {
      this.a(var1, this.cx, this.cy, this.width, this.height, Caption.fh, (byte)2, false);
      this.b = 68;
      this.c = 35;
      mFont.a(mFont.d, var1, Caption.fi, 15, this.c + 20, 0, -1);
   }

   public void b() {
   }
}
