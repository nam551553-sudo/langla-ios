package beatdz;
import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_l extends LangLa_fo {
   private mTextBox b;
   private mTextBox c;
   private String[] d;
   public int a;

   public LangLa_l(MainScreen var1, String var2, int var3, int var4) {
      this.cF = 2;
      this.p = var1;
      this.r = false;
      this.a(180, 130);
      this.c = this.a(70, 76, 70, "", this, 2);
      byte var5 = 1;
      this.c.n = var5;
      this.c.a("1");
      this.c.b(true);
      this.a(this.c);
      this.b = this.a(20, 52, 120, "", this, 0, var3);
      this.a(this.b);
      this.d = mFont.c(mFont.d, var2, this.width - 20);
      this.a(Caption.aP, var4);
   }

   public void a(int var1, Object var2, LangLa_cy var3) {
   }

   public void a(int var1, Object var2) {
   }

   public void a(Graphics var1) {
      this.a(var1, 0, 0, this.width, this.height, 80, 55, 56);

      for(int var2 = 0; var2 < this.d.length; ++var2) {
         mFont.c(mFont.d, var1, this.d[var2], (super.width - 8) / 2, this.G() / 2 + var2 * 12 - this.d.length * 6, 2, -1, -16777216);
      }

      if (!this.c.v) {
         mFont.c(mFont.d, var1, Caption.ob, this.b.cx, this.c.cy + 10, 0, -1, -16777216);
      }

   }

   public void b() {
      if (this.a == 828 || this.a == 835) {
         this.c.b(false);
      }

   }

   public Vector c() {
      Vector var1;
      (var1 = super.c()).addElement(new LangLa_jz(0, 0, 0, this.width, this.height, this.q, this));
      return var1;
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      LangLa_l var8;
      Message var9;
      switch(var1.b) {
      case 100:
         var8 = this;

         try {
            (var9 = new Message((byte)-93)).writeUTF(var8.b.f());
            var9.send();
            var8.J();
            break;
         } catch (Exception var6) {
            return;
         }
      case 101:
         var8 = this;

         try {
            (var9 = new Message((byte)-92)).writeInt(var8.b.e());
            var9.send();
            var8.J();
            break;
         } catch (Exception var5) {
            return;
         }
      case 102:
         var8 = this;

         try {
            (var9 = Message.c((byte)-92)).writeUTF(var8.b.f());
            var9.send();
            var8.J();
            break;
         } catch (Exception var4) {
            return;
         }
      case 300:
         var8 = this;

         try {
            (var9 = new Message((byte)-33)).writeUTF(var8.b.f());
            var9.writeShort(var8.a);
            var9.writeInt(var8.c.e());
            var9.send();
            return;
         } catch (Exception var7) {
         }
      }

   }
}
