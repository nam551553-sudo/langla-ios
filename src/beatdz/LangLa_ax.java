package beatdz;
import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_ax extends LangLa_fo {
   public LangLa_lr[] a;
   private LangLa_ii b;

   public LangLa_ax(MainScreen var1, Message var2) {
      try {
         this.p = var1;
         this.a(310, 218);
         this.r = false;
         this.a = new LangLa_lr[var2.reader.dis.readShort()];

         for(int var5 = 0; var5 < this.a.length; ++var5) {
            this.a[var5] = new LangLa_lr();
            this.a[var5].a = var2.reader.dis.readShort();
            this.a[var5].b = var2.reader.readUTF();
            this.a[var5].c = var2.reader.readUTF();
            this.a[var5].d = var2.reader.dis.readInt();
         }

         this.b = new LangLa_ii((byte)1, 4, this.a_() + 28, super.width - 8, 154, 22, this.a.length);
      } catch (Exception var4) {
      }
   }

   public void b() {
      this.b.a();
   }

   public void a(int var1, Object var2, LangLa_cy var3) {
      switch(var1) {
      case 2002:
         LangLa_kd var7 = (LangLa_kd)var2;
         LangLa_ax var5 = this;

         try {
            LangLa_lr var6 = var5.a[var7.a];
            Message var8;
            (var8 = Message.c((byte)-40)).writeShort(var6.a);
            var8.send();
            return;
         } catch (Exception var4) {
         }
      default:
      }
   }

   public void a(int var1, Object var2) {
   }

   public Vector c() {
      Vector var1;
      (var1 = super.c()).addElement(this.b.a(1003, this));
      return var1;
   }

   public void a(Graphics var1) {
      this.a(var1, this.cx, this.cy, this.width, this.height, Caption.pv, (byte)2, this.r);
      this.b(var1, this.b);
      this.a(var1, 0, -28, this.b.width, 28, -11, 55, 56);
      mFont.b(mFont.e, var1, Caption.rF[0], 44, -15, 2, -6488, -10275328);
      mFont.b(mFont.e, var1, Caption.ce, 110, -15, 2, -6488, -10275328);
      mFont.b(mFont.e, var1, Caption.ce, this.width - 110, -15, 2, -6488, -10275328);
      mFont.b(mFont.e, var1, Caption.px, this.width - 44, -15, 2, -6488, -10275328);
      this.a(var1, this.b);

      for(int var2 = 0; var2 < this.b.i; ++var2) {
         if (this.b.b(var2)) {
            if (var2 == this.b.k) {
               var1.f(13136426);
               var1.c(5, var2 * this.b.h, this.b.width - 10, this.b.h);
            }

            LangLa_lr var3 = this.a[var2];
            mFont.b(mFont.d, var1, Utlis.numberFormat(var3.a), 44, 8 + var2 * this.b.h, 2, -3604601, -16777216);
            mFont.b(mFont.d, var1, var3.b, 110, 8 + var2 * this.b.h, 2, -3604601, -16777216);
            mFont.b(mFont.d, var1, "vs", 150, 8 + var2 * this.b.h, 2, -3604601, -16777216);
            mFont.b(mFont.d, var1, var3.c, this.width - 110, 8 + var2 * this.b.h, 2, -3604601, -16777216);
            mFont.b(mFont.d, var1, Utlis.numberFormat(var3.d), this.width - 44, 8 + var2 * this.b.h, 2, -3604601, -16777216);
         }
      }

      this.b(var1);
      this.b.b(var1, -15, -10);
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      super.a(var1, var2, var3);
      switch(var1.b) {
      case 1001:
         return;
      case 1003:
         if (var1.j.k >= 0) {
            int var4 = var3;
            var3 = var2;
            var2 = var1.j.k;
            Vector var5;
            (var5 = new Vector()).addElement(new LangLa_lk(2002, Caption.pw));
            if (var5.size() > 0) {
               String[] var6 = new String[var5.size()];
               short[] var7 = new short[var5.size()];

               for(int var8 = 0; var8 < var5.size(); ++var8) {
                  LangLa_lk var9 = (LangLa_lk)var5.elementAt(var8);
                  var6[var8] = var9.b;
                  var7[var8] = (short)var9.a;
               }

               this.cL = a(this, var3 + 25, var4, new LangLa_kd(var2, var7, var6));
            }
         }
      default:
      }
   }
}
