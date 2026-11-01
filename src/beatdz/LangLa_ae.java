package beatdz;
import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_ae extends LangLa_fo {
   public int a = 0;
   public String[] b;
   private LangLa_ii c;

   public LangLa_ae(MainScreen var1, Message var2) {
      try {
         this.cF = 2;
         this.p = var1;
         this.a(280, 160);
         this.a(Caption.dI, 1000);
         this.a = var2.reader.dis.readInt();
         this.b = mFont.c(mFont.d, Caption.ko, this.width - 35);
         this.c = new LangLa_ii((byte)1, 15, 14, this.width - 35, 112, 14, this.b.length);
      } catch (Exception var3) {
      }
   }

   public void a(int var1, Object var2, LangLa_cy var3) {
   }

   public void a(int var1, Object var2) {
   }

   public void a(Graphics var1) {
      this.a(var1, 0, 0, this.width, this.height, 80, 55, 56);
      this.a(var1, this.c);

      for(int var2 = 0; var2 < this.b.length; ++var2) {
         if (this.c.b(var2)) {
            if (var2 == 0) {
               mFont.a(mFont.d, var1, Utlis.replaceAll(this.b[var2], Utlis.numberFormat(this.a)), 0, 5 + var2 * 14, 0, -1);
            } else {
               mFont.a(mFont.d, var1, this.b[var2], 0, 5 + var2 * 14, 0, -1);
            }
         }
      }

      this.b(var1);
   }

   public void b() {
      this.c.a();
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      super.a(var1, var2, var3);
      switch(var1.b) {
      case 1000:
         try {
            Message.c((byte)-83).send();
            return;
         } catch (Exception var4) {
            Utlis.println(var4);
         }
      default:
      }
   }

   public Vector c() {
      Vector var1;
      (var1 = new Vector()).addElement(this.c.a(1010, this));
      return var1;
   }
}
