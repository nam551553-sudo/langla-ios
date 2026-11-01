package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_bx extends LangLa_fo {
   public LangLa_ln[] a = new LangLa_ln[0];
   public LangLa_ln[] b = new LangLa_ln[0];
   private LangLa_lf c;
   private LangLa_ii[][] d;
   
   private LangLa_ka f;
   private Item g;
   private Vector h = new Vector();
   private int i;

   public LangLa_bx(MainScreen var1) {
      this.p = var1;
      this.a(316, 213);
      this.r = false;
      this.c = new LangLa_lf(new LangLa_kd(1001, Caption.tc), 4, this.a_(), super.width - 8, 23, 76, this);
      this.e();
      this.a(beatdz.LangLa_bx.$state_LangLa_bx().e);
   }

   public void e() {
      this.b = this.a;
      this.d = new LangLa_ii[2][];
      this.d[0] = new LangLa_ii[1];
      this.d[0][0] = new LangLa_ii((byte)1, 4, this.c.d() + 28, super.width - 8, 126, 18, this.b.length);
   }

   private void f() {
      if (this.f == null) {
         try {
            Message.c((byte)-55).send();
         } catch (Exception var2) {
            Utlis.println(var2);
         }
      }
   }

   public void a(Message var1) {
      try {
         LangLa_ka var2;
         (var2 = new LangLa_ka()).a[0] = var1.reader.readUTF();
         var2.a[1] = var1.reader.readUTF();
         var2.b = var1.reader.dis.readLong();
         var2.c = var1.reader.dis.readLong();
         var2.d = new String[var1.reader.dis.readByte()];
         Vector var3 = new Vector();

         for(int var4 = 0; var4 < var2.d.length; ++var4) {
            var2.d[var4] = var1.readUTF().trim();
            Item var5;
            (var5 = new Item()).read(var1);
            if (var4 == 0) {
               var2.e.add(var2.d[var4]);
               var2.f.add(var3);
            } else if (!var2.e.contains(var2.d[var4])) {
               var2.e.add(var2.d[var4]);
               var3 = new Vector();
               var2.f.add(var3);
            }

            ((Vector)var2.f.get(var2.e.indexOf(var2.d[var4]))).add(var5);
         }

         this.f = var2;
         String[] var9 = Utlis.split(var2.a[1], "\\n");
         this.h.clear();
         String var10;
         if ((var10 = var2.a()).length() > 0) {
            this.h.add("c#yellow" + var10);
         }

         int var7;
         for(var7 = 0; var7 < var9.length; ++var7) {
            this.h.addAll(mFont.a(mFont.d, var9[var7], super.width - 8 - 40));
         }

         this.h.add("c#blue" + Caption.iZ);
         this.i = this.h.size();

         for(var7 = 0; var7 < var2.e.size(); ++var7) {
            this.h.add("c#cyan" + "- " + (String)var2.e.get(var7));
            this.h.add("");
            this.h.add("");
         }

         LangLa_ii[] var8;
         (var8 = new LangLa_ii[1])[0] = new LangLa_ii((byte)1, 13, this.a_() + 60, super.width - 8 - 18, 105, 15, this.h.size());
         this.d[1] = var8;
      } catch (Exception var6) {
      }
   }

   private void a(int var1) {
      this.c.a(var1);
      if (var1 == 0) {
         this.g();
      }

      this.f();
   }

   private void g() {
      try {
         Message var1;
         (var1 = new Message((byte)-54)).writeByte(this.c.b.b);
         var1.writeByte(0);
         var1.send();
      } catch (Exception var3) {
         Utlis.println(var3);
      }
   }

   public void b() {
      this.c.b();

      for(int var1 = 0; var1 < this.d.length; ++var1) {
         if (this.d[var1] != null) {
            for(int var2 = 0; var2 < this.d[var1].length; ++var2) {
               if (this.d[var1][var2] != null) {
                  this.d[var1][var2].a();
               }
            }
         }
      }

   }

   public void a(int var1, Object var2, LangLa_cy var3) {
      LangLa_bx var7;
      LangLa_kd var8;
      switch(var1) {
      case 1002:
         this.e();
         return;
      case 2002:
         var8 = (LangLa_kd)var2;
         var7 = this;

         try {
            GameSrc.gI();
            GameSrc.h(var7.b[var8.a].b);
            break;
         } catch (Exception var5) {
            return;
         }
      case 2003:
         var8 = (LangLa_kd)var2;
         var7 = this;

         try {
            GameSrc.gI();
            GameSrc.e(var7.b[var8.a].b);
            break;
         } catch (Exception var4) {
            return;
         }
      case 2004:
         var8 = (LangLa_kd)var2;
         var7 = this;

         try {
            beatdz.LangLa_kw.$state_LangLa_kw().d = var7.b[var8.a].b;
            LangLa_kq var9 = new LangLa_kq(GameSrc.gI(), 6);
            GameSrc.gI().a((String)var7.b[var8.a].b, (LangLa_ko)var9);
            return;
         } catch (Exception var6) {
         }
      }

   }

   public void a(int var1, Object var2) {
   }

   public Vector c() {
      Vector var1;
      (var1 = super.c()).addElement(this.c.c());
      switch(this.c.b.b) {
      case 0:
         var1.addElement(this.d[0][0].a(1003, this));
         break;
      case 1:
         for(int var2 = 0; var2 < this.f.f.size(); ++var2) {
            for(int var3 = 0; var3 < ((Vector)this.f.f.get(var2)).size(); ++var3) {
               Item var4 = (Item)((Vector)this.f.f.get(var2)).get(var3);
               int var5 = this.d[this.c.b.b][0].cx + 4 + var3 * 35;
               int var6 = this.d[this.c.b.b][0].cy - this.d[this.c.b.b][0].f + (this.i + var2 * 3) * this.d[this.c.b.b][0].h + 15;
               if (this.d[1][0].b(this.i + var2 * 3 + 3)) {
                  LangLa_jz var7 = new LangLa_jz(6000, var5, var6, var5 + 28, var6 + 28, this.d[this.c.b.b][0], this, var4);
                  var1.addElement(var7);
               }
            }
         }

         var1.addElement(this.d[1][0].a(1030, this));
      }

      return var1;
   }

   public void a(Graphics var1) {
      this.a(var1, this.cx, this.cy, this.width, this.height, Caption.cc, (byte)2, this.r);
      this.c.a(var1);
      switch(this.c.b.b) {
      case 0:
         Graphics var2 = var1;
         LangLa_bx var6 = this;
         this.b(var1, this.d[this.c.b.b][0]);
         this.a(var1, 0, -28, this.d[this.c.b.b][0].width, 28, -11, 55, 56);
         mFont.b(mFont.e, var1, Caption.cd, 20, -15, 2, -6488, -10275328);
         mFont.b(mFont.e, var1, Caption.ce, 70, -15, 2, -6488, -10275328);
         mFont.b(mFont.e, var1, Caption.nV, 130, -15, 2, -6488, -10275328);
         mFont.b(mFont.e, var1, Caption.jA, 195, -15, 2, -6488, -10275328);
         mFont.b(mFont.e, var1, Caption.jB, 260, -15, 2, -6488, -10275328);
         this.a(var1, this.d[this.c.b.b][0]);

         for(int var3 = 0; var3 < var6.d[var6.c.b.b][0].i; ++var3) {
            if (var6.d[var6.c.b.b][0].b(var3)) {
               if (var3 == var6.d[var6.c.b.b][0].k) {
                  var2.f(13136426);
                  var2.c(0, var3 * var6.d[var6.c.b.b][0].h, var6.d[var6.c.b.b][0].width, var6.d[var6.c.b.b][0].h);
               }

               LangLa_ln var4 = var6.b[var3];
               mFont.b(mFont.d, var2, "" + (var3 + 1), 20, 8 + var3 * var6.d[var6.c.b.b][0].h, 2, -3604601, -16777216);
               mFont.b(mFont.d, var2, var4.b, 70, 8 + var3 * var6.d[var6.c.b.b][0].h, 2, -3604601, -16777216);
               mFont.b(mFont.d, var2, Utlis.numberFormat(var4.d), 130, 8 + var3 * var6.d[var6.c.b.b][0].h, 2, -3604601, -16777216);
               int var10004 = 8 + var3 * var6.d[var6.c.b.b][0].h;
               mFont.b(mFont.d, var2, DataCenter.gI().DataNameChar[var4.e].name, 195, var10004, 2, -3604601, -16777216);
               mFont.b(mFont.d, var2, var4.f, 260, 8 + var3 * var6.d[var6.c.b.b][0].h, 2, -3604601, -16777216);
            }
         }

         var6.b(var2);
         var6.d[var6.c.b.b][0].b(var2, -16, -11);
         return;
      case 1:
         this.e(var1);
      default:
      }
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      switch(var1.b) {
      case 1001:
         if (var1.j.k >= 0) {
            beatdz.LangLa_bx.$state_LangLa_bx().e = var1.j.k;
            this.a(var1.j.k);
            return;
         }
         break;
      case 1003:
         if (var1.j.k >= 0) {
            int var4 = var3;
            var3 = var2;
            var2 = var1.j.k;
            Vector var5;
            (var5 = new Vector()).addElement(new LangLa_lk(2002, Caption.cj));
            var5.addElement(new LangLa_lk(2003, Caption.ck));
            var5.addElement(new LangLa_lk(2004, Caption.cl));
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

            return;
         }
         break;
      case 6000:
         this.g = (Item)var1.k;
         this.cL = a(this, var2, var3, 28, this.g);
      }

   }

   private void e(Graphics var1) {
      try {
         this.a(var1, 4, this.a_() + 23, super.width - 8, this.G() - 30, 4, 55, 56);
         this.a(var1, 9, this.a_() + 29, super.width - 8 - 10, 26, -17, 84, 5, 1, 1);
         mFont.a(var1, this.f.a[0], 19, this.a_() + 29 + 13, 0, -1);
         this.a(var1, this.d[this.c.b.b][0]);

         int var2;
         for(var2 = 0; var2 < this.d[this.c.b.b][0].i; ++var2) {
            mFont.c(mFont.d, var1, (String)this.h.get(var2), 2, 6 + var2 * this.d[this.c.b.b][0].h, 0, -1, 0);
         }

         for(var2 = 0; var2 < this.f.f.size(); ++var2) {
            for(int var3 = 0; var3 < ((Vector)this.f.f.get(var2)).size(); ++var3) {
               Item var4 = (Item)((Vector)this.f.f.get(var2)).get(var3);
               b(var1, 4 + var3 * 35, (this.i + var2 * 3) * this.d[this.c.b.b][0].h + 15, var4, this.g != null && this.g.equals(var4));
            }
         }

         this.b(var1);
         this.d[this.c.b.b][0].b(var1, -14, -11);
      } catch (Exception var6) {
      }
   }

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public int e;
public void initialize() {
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.LangLa_bx");
public static SessionState $state_LangLa_bx() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
