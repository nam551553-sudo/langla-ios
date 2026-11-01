package beatdz;
import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_ay extends LangLa_fo {
   public Vector a = new Vector();
   private LangLa_lf b;
   private LangLa_ii c;
   private int d;
   private long e;
   private String f;
   private int g;

   public LangLa_ay(MainScreen var1, Message var2) {
      try {
         this.p = var1;
         this.a(316, 213);
         this.r = false;
         this.e = Utlis.time();
         this.d = var2.reader.dis.readInt();
         this.f = var2.readUTF();
         byte var7 = var2.reader.dis.readByte();

         for(int var3 = 0; var3 < var7; ++var3) {
            LangLa_gt var4;
            (var4 = new LangLa_gt()).a = var2.readUTF();
            var4.b = var2.readUTF();
            var4.c = var2.reader.dis.readByte();
            this.a.add(var4);
         }

         this.b = new LangLa_lf(new LangLa_kd(1001, new String[]{this.f}), 4, this.a_(), super.width - 8, 23, 76, this);
         this.c = new LangLa_ii((byte)1, 4, this.b.d() + 28, super.width - 8, 108, 18, this.a.size());
         boolean var8 = false;
         this.b.a(0);
      } catch (Exception var6) {
      }
   }

   public void b() {
      this.b.b();
      this.c.a();
   }

   public void a(int var1, Object var2, LangLa_cy var3) {
      LangLa_ay var8;
      LangLa_kd var11;
      LangLa_gt var12;
      String var13;
      switch(var1) {
      case 1002:
         return;
      case 2002:
         var11 = (LangLa_kd)var2;
         var8 = this;

         try {
            var12 = (LangLa_gt)var8.a.get(var11.a);
            var13 = "";
            if (var8.g >= 70 && var8.g <= 150) {
               var13 = var12.a;
            } else if (var8.g >= 180 && var8.g <= 260) {
               var13 = var12.b;
            }

            GameSrc.gI();
            GameSrc.h(var13);
            break;
         } catch (Exception var6) {
            return;
         }
      case 2003:
         var11 = (LangLa_kd)var2;
         var8 = this;

         try {
            var12 = (LangLa_gt)var8.a.get(var11.a);
            var13 = "";
            if (var8.g >= 70 && var8.g <= 150) {
               var13 = var12.a;
            } else if (var8.g >= 180 && var8.g <= 260) {
               var13 = var12.b;
            }

            GameSrc.gI();
            GameSrc.e(var13);
            break;
         } catch (Exception var5) {
            return;
         }
      case 2004:
         var11 = (LangLa_kd)var2;
         var8 = this;

         try {
            var12 = (LangLa_gt)var8.a.get(var11.a);
            var13 = "";
            if (var8.g >= 70 && var8.g <= 150) {
               var13 = var12.a;
            } else if (var8.g >= 180 && var8.g <= 260) {
               var13 = var12.b;
            }

            beatdz.LangLa_kw.$state_LangLa_kw().d = var13;
            LangLa_kq var9 = new LangLa_kq(GameSrc.gI(), 6);
            GameSrc.gI().a((String)var13, (LangLa_ko)var9);
            break;
         } catch (Exception var4) {
            return;
         }
      case 2005:
         var1 = ((LangLa_kd)var2).a;

         try {
            if (var1 == GameSrc.gI().zoneID) {
               return;
            }

            beatdz.GameSrc.$state_GameSrc().an = true;
            Message var10;
            (var10 = new Message((byte)-7)).writeByte(var1);
            var10.send();
            return;
         } catch (Exception var7) {
            Utlis.println(var7);
         }
      }

   }

   public void a(int var1, Object var2) {
   }

   public Vector c() {
      Vector var1;
      (var1 = super.c()).addElement(this.b.c());
      var1.addElement(this.c.a(1003, this));
      int var10000 = this.b.b.b;
      return var1;
   }

   public void a(Graphics var1) {
      this.a(var1, this.cx, this.cy, this.width, this.height, Caption.cc, (byte)2, this.r);
      this.b.a(var1);
      this.b(var1, this.c);
      this.a(var1, 0, -28, this.c.width, 28, 4, 55, 56);
      mFont.b(mFont.e, var1, Caption.kf, 40, -15, 2, -10831436, -16777216);
      mFont.b(mFont.e, var1, Caption.jv, 110, -15, 2, -10831436, -16777216);
      mFont.b(mFont.e, var1, Caption.jv, 210, -15, 2, -10831436, -16777216);
      this.a(var1, this.c);

      int var2;
      for(var2 = 0; var2 < this.c.i; ++var2) {
         if (this.c.b(var2)) {
            LangLa_gt var3 = (LangLa_gt)this.a.get(var2);
            if (var2 == this.c.k) {
               var1.f(13136426);
               var1.c(0, var2 * this.c.h, this.c.width, this.c.h);
            }

            mFont.b(mFont.d, var1, "" + (var2 + 1), 40, 8 + var2 * this.c.h, 2, -3604601, -16777216);
            mFont.b(mFont.d, var1, var3.a, 110, 8 + var2 * this.c.h, 2, -3604601, -16777216);
            mFont.b(mFont.d, var1, var3.b, 210, 8 + var2 * this.c.h, 2, -3604601, -16777216);
            if (var3.c == 1) {
               mFont.b(mFont.d, var1, Caption.kg, 160, 8 + var2 * this.c.h, 2, -3604601, -16777216);
            } else if (var3.c == 2) {
               mFont.b(mFont.d, var1, Caption.kh, 160, 8 + var2 * this.c.h, 2, -3604601, -16777216);
            } else {
               mFont.b(mFont.d, var1, "VS", 160, 8 + var2 * this.c.h, 2, -3604601, -16777216);
            }
         }
      }

      this.b(var1);
      var2 = this.d - (int)((Utlis.time() - this.e) / 1000L);
      mFont.b(mFont.d, var1, Caption.ki + this.f + Caption.kj + Utlis.getTextTimeFormSeconds(var2), this.width / 2, this.height - 18, 2, -1, -16777216);
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      switch(var1.b) {
      case 1001:
         return;
      case 1003:
         if (var1.j.k >= 0) {
            int var4 = var3;
            var3 = var2;
            var2 = var1.j.k;
            this.g = var3;
            if (var3 >= 70 && var3 <= 150 || var3 >= 180 && var3 <= 260) {
               Vector var5;
               (var5 = new Vector()).addElement(new LangLa_lk(2002, Caption.cj));
               var5.addElement(new LangLa_lk(2003, Caption.ck));
               var5.addElement(new LangLa_lk(2004, Caption.cl));
               var5.addElement(new LangLa_lk(2005, Caption.of));
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
         }
      default:
      }
   }
}
