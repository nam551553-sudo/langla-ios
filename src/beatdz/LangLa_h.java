package beatdz;
import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_h extends LangLa_fo {
   private LangLa_ii a;
   private Vector b = new Vector();
   private LangLa_dz c;
   private LangLa_dz d;

   public LangLa_h(MainScreen var1, Message var2) {
      this.cF = 1;
      this.p = var1;
      this.r = false;
      this.a(300, 220);
      this.c = this.a(8, this.a_() + this.G() - 27, Caption.eY, this, 100, 15);
      this.c.setSize(60, this.c.height);
      LangLa_dz var4;
      (var4 = this.a(71, this.a_() + this.G() - 27, Caption.eZ, this, 101, 15)).setSize(60, var4.height);
      this.d = this.a(4 + (super.width - 8) - 70, this.a_() + this.G() - 27, Caption.fa, this, 102, 15);
      this.d.setSize(64, var4.height);
      this.a(var2);
   }

   public void a(Message var1) {
      try {
         this.b.clear();
         boolean var2 = var1.reader.dis.readBoolean();
         this.c.u = var2;
         this.d.u = !var2;
         byte var7 = var1.reader.dis.readByte();

         for(int var3 = 0; var3 < var7; ++var3) {
            LangLa_es var4;
            (var4 = new LangLa_es()).a = var1.reader.readUTF();
            var4.b = var1.reader.dis.readInt();
            var4.c = var1.reader.dis.readInt();
            var4.d = var1.reader.dis.readInt();
            this.b.add(var4);
         }
      } catch (Exception var6) {
      }

      this.a = new LangLa_ii((byte)1, 4, this.a_() + 30, super.width - 8, 126, 18, this.b.size());
   }

   public void a(int var1, Object var2, LangLa_cy var3) {
   }

   public void a(int var1, Object var2) {
   }

   public void a(Graphics var1) {
      this.a(var1, this.cx, this.cy, this.width, this.height, Caption.fb, (byte)2, this.r);
      this.a(var1, 4, this.a_(), super.width - 8, 28, 4, 55, 56);
      mFont.b(mFont.e, var1, Caption.fc, 19, this.a_() + 13, 0, -10831436, -16777216);
      mFont.b(mFont.e, var1, Caption.fd, 59, this.a_() + 13, 0, -10831436, -16777216);
      mFont.b(mFont.e, var1, Caption.fe, 129, this.a_() + 13, 0, -10831436, -16777216);
      mFont.b(mFont.e, var1, Caption.ff, 209, this.a_() + 13, 0, -10831436, -16777216);
      this.a(var1, this.a);

      for(int var2 = 0; var2 < this.b.size(); ++var2) {
         LangLa_es var3 = (LangLa_es)this.b.get(var2);
         mFont.c(mFont.d, var1, "" + (var2 + 1), 24, 7 + var2 * 18, 2, -1, -16777216);
         mFont.c(mFont.d, var1, var3.a, 74, 7 + var2 * 18, 2, -1, -16777216);
         mFont.c(mFont.d, var1, Utlis.numberFormat(var3.b), 154, 7 + var2 * 18, 2, -1, -16777216);
         mFont.c(mFont.d, var1, Utlis.numberFormat(var3.c) + Caption.fg, 229, 7 + var2 * 18, 2, -1, -16777216);
      }

      this.b(var1);
   }

   public void b() {
      this.a.a();
   }

   public Vector c() {
      super.c();
      Vector var1;
      (var1 = new Vector()).addElement(this.a.a(1003, this));
      return var1;
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      switch(var1.b) {
      case 100:
         this.p.a((LangLa_cx)(new LangLa_if(this.p)));
         return;
      case 101:
         this.p.a((LangLa_cx)(new LangLa_bb(this.p)));
         return;
      case 102:
         try {
            Message.c((byte)-87).send();
            return;
         } catch (Exception var4) {
         }
      default:
      }
   }
}
