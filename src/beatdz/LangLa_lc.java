package beatdz;
import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_lc extends LangLa_fm {
   private LangLa_ii b;
   private LangLa_lk[] c;
   public int[] a = new int[26];
   private long d;

   public LangLa_lc(int var1, int var2, LangLa_cx var3, Mob var4) {
      this.s = var3;
      this.setXY(var1, var2);
      this.d = Utlis.time();
      this.a(var4);

      try {
         Message var6;
         (var6 = new Message((byte)13)).writeShort(var4.idEntity);
         var6.send();
      } catch (Exception var5) {
         Utlis.println(var5);
      }
   }

   public void a(Mob var1) {
      Vector var2;
      (var2 = new Vector()).addElement("c#yellow" + var1.getMobTemplate().name);
      var2.addElement("c#white" + Caption.if_ + " : " + var1.level);
      var2.addElement("c#white" + Caption.aT + " : " + Utlis.i(var1.he) + Caption.ro[var1.he - 1]);
      if (var1.getMobTemplate().type != 10 && var1.getMobTemplate().type != 9) {
         if (this.a[0] != 0) {
            var2.addElement("c#white" + Caption.rd[0] + ": " + this.a[0] * 90 / 100 + " - " + this.a[0]);
         }

         if (this.a[2] != 0) {
            var2.addElement("c#white" + Caption.rd[2] + ": " + this.a[1]);
         }

         if (this.a[2] != 0) {
            var2.addElement("c#white" + Caption.rd[3] + ": " + this.a[2]);
         }

         if (this.a[4] != 0) {
            var2.addElement("c#white" + Caption.rd[4] + ": " + this.a[3]);
         }

         if (this.a[4] != 0) {
            var2.addElement("c#white" + Caption.rd[5] + ": " + this.a[4] + "%");
         }

         if (this.a[5] != 0) {
            var2.addElement("c#white" + Caption.rd[6] + ": " + this.a[5]);
         }

         if (this.a[6] != 0) {
            var2.addElement("c#white" + Caption.rd[7] + ": " + this.a[6]);
         }

         if (this.a[7] != 0) {
            var2.addElement("c#white" + Caption.rd[8] + ": " + this.a[7]);
         }

         if (this.a[8] != 0) {
            var2.addElement("c#white" + Caption.rd[9] + ": " + this.a[8]);
         }

         if (this.a[9] != 0) {
            var2.addElement("c#white" + Caption.rd[10] + ": " + this.a[9]);
         }

         if (this.a[10] != 0) {
            var2.addElement("c#white" + Caption.rd[11] + ": " + this.a[10]);
         }

         if (this.a[11] != 0) {
            var2.addElement("c#white" + Caption.rd[12] + ": " + this.a[11]);
         }

         if (this.a[12] != 0) {
            var2.addElement("c#white" + Caption.rd[13] + ": " + this.a[12]);
         }

         if (this.a[13] != 0) {
            var2.addElement("c#white" + Caption.rd[14] + ": " + this.a[13]);
         }

         if (this.a[14] != 0) {
            var2.addElement("c#white" + Caption.rd[15] + ": " + this.a[14]);
         }

         if (this.a[15] != 0) {
            var2.addElement("c#white" + Caption.re[0] + ": " + this.a[15]);
         }

         if (this.a[16] != 0) {
            var2.addElement("c#white" + Caption.re[1] + ": " + this.a[16]);
         }

         if (this.a[17] != 0) {
            var2.addElement("c#white" + Caption.re[2] + ": " + this.a[17]);
         }

         if (this.a[18] != 0) {
            var2.addElement("c#white" + Caption.re[3] + ": " + this.a[18]);
         }

         if (this.a[19] != 0) {
            var2.addElement("c#white" + Caption.re[4] + ": " + this.a[19]);
         }

         if (this.a[20] != 0) {
            var2.addElement("c#white" + Caption.re[5] + ": " + this.a[20]);
         }

         if (this.a[21] != 0) {
            var2.addElement("c#white" + Caption.re[7] + ": " + this.a[21]);
         }

         if (this.a[22] != 0) {
            var2.addElement("c#white" + Caption.re[8] + ": " + this.a[22] + "%");
         }

         if (this.a[23] != 0) {
            var2.addElement("c#white" + Caption.re[9] + ": " + this.a[23] + "%");
         }

         if (this.a[24] != 0) {
            var2.addElement("c#white" + Caption.re[10] + Caption.ro[var1.v() - 1] + ": " + this.a[24]);
         }

         if (this.a[25] != 0) {
            var2.addElement("c#white" + Caption.re[11] + Caption.ro[var1.w() - 1] + ": " + this.a[25]);
         }
      }

      this.setSize(160, 75);
      Vector var6 = new Vector();

      int var4;
      for(var4 = 0; var4 < var2.size(); ++var4) {
         String var3 = String.valueOf(var2.elementAt(var4));
         int var5;
         Vector var7;
         if (var4 == 0) {
            var7 = mFont.a(mFont.e, var3, this.width - 10);

            for(var5 = 0; var5 < var7.size(); ++var5) {
               var6.add(new LangLa_lk(0, (String)var7.elementAt(var5)));
            }
         } else {
            var7 = mFont.a(mFont.d, var3, this.width - 10);

            for(var5 = 0; var5 < var7.size(); ++var5) {
               var6.add(new LangLa_lk(1, (String)var7.elementAt(var5)));
            }
         }
      }

      this.c = new LangLa_lk[var6.size()];

      for(var4 = 0; var4 < var6.size(); ++var4) {
         this.c[var4] = (LangLa_lk)var6.elementAt(var4);
      }

      this.b = new LangLa_ii((byte)1, 0, 5, this.width, this.height - 10, 13, this.c.length);
   }

   public void a(Graphics var1) {
      this.b(var1, 0, 0, this.width, this.height, 314, -11657441, -9490898);
      LangLa_fq.a(var1, 366, 0, 19, 0, 36);
      this.a(var1, this.b);

      for(int var2 = 0; var2 < this.c.length; ++var2) {
         if (this.c[var2].a == 0) {
            mFont.c(mFont.e, var1, this.c[var2].b, 6, 5 + var2 * this.b.h, 0, -1, -16777216);
         } else {
            mFont.c(mFont.d, var1, this.c[var2].b, 6, 5 + var2 * this.b.h, 0, -1, -16777216);
         }
      }

      this.b(var1);
   }

   public void b() {
      this.b.a();
      if (Utlis.time() - this.d >= 5000L) {
         this.s.b((LangLa_cs)this);
      }

   }

   public Vector c() {
      Vector var1;
      (var1 = new Vector()).addElement(new LangLa_jz(1001, this.b.cx, this.b.cy, this.b.cx + this.b.width, this.b.cy + this.b.height, this.b, this));
      var1.addElement(new LangLa_jz(1002, this.b.cx, this.b.cy - 5, this.b.cx + this.b.width, this.b.cy + this.b.height + 5, this.b, this));
      return var1;
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      this.d = Utlis.time();
   }
}
