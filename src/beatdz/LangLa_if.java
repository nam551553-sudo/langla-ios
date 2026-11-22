package beatdz;
import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_if extends LangLa_fo {
   private LangLa_gd a;
   private LangLa_cg b;

   public LangLa_if(MainScreen var1) {
      this.cF = 2;
      this.p = var1;
      this.r = false;
      this.a(260, 200);
      String[] var2 = Caption.sf;
      LangLa_kd var3 = new LangLa_kd(0, var2);
      this.a = new LangLa_gd(90, 25, 100, "", this, 0, 2, 1);
      this.a(this.a);
      this.b = this.a(90, 70, 100, 5, var3, this, 0);
      this.a(Caption.aP, 100);
   }

   public void a(int var1, Object var2, LangLa_cy var3) {
   }

   public void a(int var1, Object var2) {
   }

   public void a(Graphics var1) {
      this.a(var1, 0, 0, this.width, this.height, 80, 55, 56);
      mFont.c(mFont.d, var1, Caption.cn, 9, this.a_() - 15, 0, -1, -16777216);
      mFont.c(mFont.d, var1, Caption.co, 84, this.a_() + 5, 1, -1, -16777216);
      mFont.c(mFont.d, var1, Caption.cp, 84, this.a_() + 50, 1, -1, -16777216);
      mFont.c(mFont.d, var1, Caption.cq, 84, this.a_() + 70, 1, -1, -16777216);
      mFont.c(mFont.d, var1, "50%", 94, this.a_() + 70, 0, -1, -16777216);
      mFont.c(mFont.d, var1, Caption.cr, 84, this.a_() + 90, 1, -1, -16777216);
      mFont.c(mFont.d, var1, Utlis.numberFormat(Char.gI().bacKhoa) + Caption.cs, 94, this.a_() + 90, 0, -1, -16777216);
      mFont.c(mFont.d, var1, Caption.ct, 84, this.a_() + 110, 1, -1, -16777216);
      mFont.c(mFont.d, var1, Caption.cu + Utlis.numberFormat(this.a.e() * (this.b.b.b + 1) * 100) + Caption.cs, 94, this.a_() + 110, 0, -1, -16777216);
      mFont.c(mFont.d, var1, Caption.cv + Utlis.numberFormat((this.b.b.b + 1) * 50) + Caption.cw, 94, this.a_() + 125, 0, -1, -16777216);
   }

   public void b() {
   }

   public Vector c() {
      super.c();
      Vector var1;
      (var1 = new Vector()).addElement(new LangLa_jz(0, 0, 0, this.width, this.height, this.q, this));
      return var1;
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      switch(var1.b) {
      case 100:
         LangLa_if var5 = this;

         try {
            Message var6;
            (var6 = Message.c((byte)-89)).writeInt(var5.a.e());
            var6.writeInt((var5.b.b.b + 1) * 100);
            var6.send();
            return;
         } catch (Exception var4) {
         }
      default:
      }
   }
}
