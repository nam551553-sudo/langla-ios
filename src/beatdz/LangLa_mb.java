package beatdz;
import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_mb extends LangLa_fm {
   private LangLa_ii b;
   public String[] a;

   public LangLa_mb(int var1, int var2, int var3, LangLa_cx var4, int var5) {
      this.s = var4;
      this.setXY(var1, var2);
      StringBuilder var6 = new StringBuilder();
      switch(var5) {
      case 220:
         var6.append(Caption.bO);
         var6.append(Caption.he);
         break;
      case 289:
         var6.append(Caption.ic);
         var6.append(Caption.N);
         break;
      case 290:
         var6.append(Caption.hf);
         var6.append(Caption.S);
         break;
      case 291:
         var6.append(Caption.kq);
         var6.append(Caption.T);
         break;
      case 292:
         var6.append(Caption.kw);
         var6.append(Caption.N);
         break;
      case 293:
         var6.append(Caption.lo);
         var6.append(Caption.S);
         break;
      case 294:
         var6.append(Caption.ns);
         var6.append(Caption.T);
         break;
      case 295:
         var6.append(Caption.nt);
         var6.append(Caption.N);
         break;
      case 296:
         var6.append(Caption.nu);
         var6.append(Caption.S);
         break;
      case 297:
         var6.append(Caption.nv);
         var6.append(Caption.T);
         break;
      case 298:
         var6.append(Caption.nw);
         var6.append(Caption.N);
         break;
      case 299:
         var6.append(Caption.nx);
         var6.append(Caption.S);
         break;
      case 300:
         var6.append(Caption.ny);
         var6.append(Caption.T);
      }

      this.a = mFont.c(mFont.d, var6.toString(), var3 - 20);
      this.setSize(var3, 80);
      this.b = new LangLa_ii((byte)1, 0, 5, var3, 65, 13, this.a.length);
   }

   public void a(Graphics var1) {
      this.a(var1, 0, 0, this.width, this.height, -11, 55, 56);
      this.a(var1, this.b);

      for(int var2 = 0; var2 < this.a.length; ++var2) {
         if (var2 == 0) {
            mFont.b(mFont.f, var1, this.a[var2], 8, var2 * this.b.h + 5, 0, -1, -16777216);
         } else {
            mFont.b(mFont.d, var1, this.a[var2], 8, var2 * this.b.h + 5, 0, -1, -16777216);
         }
      }

      this.b(var1);
   }

   public void b() {
      this.b.a();
   }

   public Vector c() {
      Vector var1;
      (var1 = new Vector()).add(this.b.a(2000, this));
      var1.addElement(new LangLa_jz(1011, 0, 0, this.width, this.height, this.b, this));
      return var1;
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      switch(var1.b) {
      case 2000:
         return;
      case 2001:
         this.s.b((LangLa_cs)this);
      default:
      }
   }
}
