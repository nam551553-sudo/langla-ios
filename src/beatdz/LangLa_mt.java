package beatdz;
import com.tgame.model.Caption;

public class LangLa_mt extends LangLa_fo {
   private mTextBox a;
   private mTextBox b;
   private int c;
   private LangLa_cg d;
   private int[] e;

   public void a(int var1, Object var2) {
   }

   public void a(int var1, Object var2, LangLa_cy var3) {
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      switch(var1.b) {
      case 1002:
         try {
            Message var5;
            (var5 = Message.c((byte)-111)).writeShort(this.e[this.d.b.b]);
            var5.writeUTF(this.a.f());
            var5.writeUTF(this.b.f());
            var5.send();
            return;
         } catch (Exception var4) {
         }
      default:
      }
   }

   public void a(Graphics var1) {
      this.a(var1, this.cx, this.cy, this.width, this.height, Caption.bU, (byte)2, true);
      mFont.a(mFont.d, var1, Caption.eq, 15, this.c + 10, 0, -1);
      mFont.a(mFont.d, var1, Caption.bV, 15, this.c + 35 + 20, 0, -1);
      if (this.d.b.b == 0) {
         mFont.a(mFont.d, var1, Caption.er, 15, this.c + 35, 0, -1);
      } else {
         mFont.a(mFont.d, var1, Caption.sa[2], 15, this.c + 35, 0, -1);
      }
   }

   public void b() {
   }
}
