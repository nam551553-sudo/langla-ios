package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_ge extends LangLa_fn {
   private LangLa_ii[] a = new LangLa_ii[4];
   public LangLa_ij[] j = new LangLa_ij[2];
   private int b;
   public LangLa_dz o;
   public LangLa_dz s;
   public Item[] t;

   public LangLa_ge(MainScreen var1, String[] var2) {
      super(var1);
      this.t = Char.gI().arrItemBag;
      this.r = false;
      this.a(299, 212);
      LangLa_kd var5 = new LangLa_kd(-1000);
      int var3;
      if (var2 == null) {
         var5.c = new String[]{Caption.q};
      } else {
         var5.c = new String[var2.length + 1];

         for(var3 = 0; var3 < var2.length; ++var3) {
            var5.c[var3] = var2[var3];
         }

         var5.c[var2.length] = Caption.q;
      }

      int var7;
      if ((var3 = var5.c.length) > 3) {
         var7 = (this.width - 36) / var3;
         this.a(var5, 170, var7, 4);
         this.l = 4;
      } else {
         this.a(var5, 170, 80, 4);
         this.l = 5;
      }

      DataCenter.gI();
      this.o = this.a(this.width - 70, this.height - 33, Caption.u, this, 0, -8);
      this.s = this.a(this.width - 132, this.height - 33, Caption.pj, this, 5000, -8);
      this.a(this.o, this.j());
      this.a(this.s, this.j());
      this.a();
      this.e();
      DataCenter.gI();
      this.a[0] = new LangLa_ii((byte)0, 103, this.a_() + 99, 92, 20, 92, 1);
      this.a[1] = new LangLa_ii((byte)0, 103, this.a_() + 123, 92, 20, 92, 1);
      this.a[2] = new LangLa_ii((byte)0, 199, this.a_() + 99, 92, 20, 92, 1);
      this.a[3] = new LangLa_ii((byte)0, 199, this.a_() + 123, 92, 20, 92, 1);
      this.a(var5.b);

      try {
         int var6 = 0;

         for(var7 = 0; var7 < Char.gI().arrItemBag.length; ++var7) {
            if (Char.gI().arrItemBag[var7] != null) {
               ++var6;
               if (Char.gI().arrItemBag[var7].index >= Char.gI().arrItemBag.length) {
                  GameSrc.gI();
                  GameSrc.g(0);
               }
            }
         }

         Message var8;
         (var8 = new Message((byte)-56)).writeShort(var6);
         var8.send();
      } catch (Exception var4) {
      }
   }

   public int f() {
      return this.b;
   }

   public void a() {
      this.t = Char.gI().arrItemBag;
   }

   private void e() {
      DataCenter.gI();
      this.j[0] = new LangLa_ij((byte)1, 7, this.a_() + 3, 288, 96, 32, Utlis.c(this.t.length, 9), 9);
      this.j[1] = new LangLa_ij((byte)0, 7, this.a_() + 115, 96, 32, 32, Utlis.c(Char.gI().arrItemExtend.length, 1), 1);
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      super.a(var1, var2, var3);
      if (this.k() == this.j()) {
         switch(var1.b) {
         case 0:
            GameSrc.gI();
            GameSrc.g(0);
            return;
         case 5000:
            GameSrc.gI();
            GameSrc.openFunc(98);
            return;
         case 5001:
            this.b = 0;
            this.a(var1.j, var1.j.k);
            if (var1.j.k >= 0) {
               this.cL = a(var1, this, this.t[var1.j.k]);
               return;
            }
            break;
         case 5002:
            this.b = 1;
            this.a(var1.j, var1.j.k);
            DataCenter.gI();
            if (var1.j.k >= 0) {
               this.cL = a(var1, this, Char.gI().arrItemExtend[var1.j.k]);
               return;
            }
            break;
         case 5003:
            this.a(var1.j, var1.j.k);
            if (var1.j.k >= 0) {
               if (this instanceof LangLa_lb) {
                  this.a(10000, (String)(Caption.pk + " " + Caption.rp[0]), (LangLa_ii)var1.j);
                  return;
               }

               this.cL = b(Caption.rp[0], this, var1.j.cx + 30, var1.j.cy, 30);
               this.cL.width = 60;
               return;
            }
            break;
         case 5004:
            this.a(var1.j, var1.j.k);
            if (var1.j.k >= 0) {
               if (this instanceof LangLa_lb) {
                  this.a(10001, (String)(Caption.pk + " " + Caption.rv[0]), (LangLa_ii)var1.j);
                  return;
               }

               this.cL = b(Caption.rv[0], this, var1.j.cx + 30, var1.j.cy, 30);
               this.cL.width = 60;
               return;
            }
            break;
         case 5005:
            this.a(var1.j, var1.j.k);
            if (var1.j.k >= 0) {
               if (this instanceof LangLa_lb) {
                  this.a(10002, (String)(Caption.pk + " " + Caption.rp[1]), (LangLa_ii)var1.j);
                  return;
               }

               this.cL = b(Caption.rp[1], this, var1.j.cx + 30, var1.j.cy, 30);
               this.cL.width = 60;
               return;
            }
            break;
         case 5006:
            this.a(var1.j, var1.j.k);
            if (var1.j.k >= 0) {
               if (this instanceof LangLa_lb) {
                  this.a(10003, (String)(Caption.pk + " " + Caption.rv[1]), (LangLa_ii)var1.j);
                  return;
               }

               this.cL = b(Caption.rv[1], this, var1.j.cx + 30, var1.j.cy, 30);
               this.cL.width = 60;
            }
         }
      }

   }

   public void a(int var1, String var2, LangLa_ii var3) {
      String[] var6 = new String[]{var2};
      short[] var4 = new short[]{(short)var1};
      LangLa_kn var5;
      (var5 = a(this, var3.cx + 30, var3.cy, new LangLa_kd(0, var4, var6))).a(70);
      this.cL = var5;
   }

   public void a(int var1, Object var2, LangLa_cy var3) {
      try {
         if (var1 >= 30000) {
            LangLa_kd var5 = (LangLa_kd)var2;
            var1 -= 30000;
            Message var6;
            (var6 = new Message((byte)-25)).writeShort(var5.a);
            var6.writeByte(var1);
            var6.writeByte(var5.e);
            var6.send();
         } else {
            switch(var1) {
            case 10000:
               GameSrc.gI().a((LangLa_cx)(new LangLa_ly(this.p, (byte)0)));
               break;
            case 10001:
               GameSrc.gI().a((LangLa_cx)(new LangLa_ly(this.p, (byte)2)));
               break;
            case 10002:
               GameSrc.gI().a((LangLa_cx)(new LangLa_ly(this.p, (byte)1)));
               break;
            case 10003:
               GameSrc.gI().a((LangLa_cx)(new LangLa_ly(this.p, (byte)3)));
            default:
               return;
            }
         }
      } catch (Exception var4) {
         Utlis.println(var4);
      }

   }

   public void a(int var1, Object var2) {
   }

   public void a(Graphics var1) {
      if (this.j() <= 0) {
         this.a(var1, this.cx, this.cy, this.width, this.height, Caption.q, (byte)2, this.r);
      } else {
         super.a(var1);
      }

      if (this.k() == this.j()) {
         this.a(var1, this.j[0]);
         Vector var2 = new Vector();
         Vector var3 = new Vector();

         int var4;
         int var5;
         int var6;
         Item var7;
         for(var5 = 0; var5 < this.j[0].i; ++var5) {
            for(var6 = 0; var6 < this.j[0].r; ++var6) {
               var4 = var5 * this.j[0].r + var6;
               if ((var7 = this.t[var4]) != null) {
                  var2.add(var7);
               }

               Item var8;
               if ((var8 = Char.gI().arrItemBag[var4]) != null) {
                  var3.add(var8);
               }

               if (this.j[0].b(var5)) {
                  b(var1, var6 * this.j[0].h, var5 * this.j[0].h, var7, var4 == this.j[0].k);
               }
            }
         }

         var3.removeAll(var2);

         for(var5 = 0; var5 < this.j[0].i; ++var5) {
            for(var6 = 0; var6 < this.j[0].r; ++var6) {
               var4 = var5 * this.j[0].r + var6;
               if (this.t[var4] == null && var3.size() > 0) {
                  var7 = (Item)var3.remove(0);
                  if (this.j[0].b(var5)) {
                     b(var1, var6 * this.j[0].h, var5 * this.j[0].h, var7, var4 == this.j[0].k);
                     Binary2.a(var1, -23, 0, var6 * this.j[0].h + 2, var5 * this.j[0].h + 2, 25, (int)25);
                  }
               }
            }
         }

         this.a(var1, this.j[1]);
         DataCenter.gI();

         for(var5 = 0; var5 < this.j[1].r; ++var5) {
            for(var6 = 0; var6 < this.j[1].i; ++var6) {
               if (this.j[1].b(var6)) {
                  int var10001 = var6 * this.j[1].h;
                  int var10002 = var5 * this.j[1].h;
                  int var10004 = var5 * this.j[1].i;
                  a(var1, var10001, var10002, Char.gI().arrItemExtend[var10004 + var6], var5 * this.j[1].i + var6 == this.j[1].k, 54);
               }
            }
         }

         this.b(var1);
         this.a(var1, this.cx + 4, this.cy + this.a_());
         var1.f(5014425);
         var5 = 0;

         for(var6 = 0; var6 < Char.gI().arrItemBag.length; ++var6) {
            if (Char.gI().arrItemBag[var6] != null) {
               ++var5;
            }
         }

         DataCenter.gI();
         mFont.b(mFont.d, var1, Caption.aV + " " + var5 + "/" + Char.gI().arrItemBag.length, 5, 105, 0, -1, -16777216);
         LangLa_fq.b(var1, 26, 27, 99, 99, 93, 21);
         LangLa_fq.b(var1, 26, 27, 99, 123, 93, 21);
         LangLa_fq.b(var1, 26, 27, 195, 99, 93, 21);
         LangLa_fq.b(var1, 26, 27, 195, 123, 93, 21);
         a(var1, 99, 109, "", (byte)0);
         a(var1, 99, 133, "", (byte)2);
         a(var1, 195, 109, "", (byte)1);
         a(var1, 195, 134, "", (byte)3);
         mFont.b(mFont.d, var1, Utlis.numberFormat(Char.gI().bac), 129, 109, 20, -3089954, -16777216);
         mFont.b(mFont.d, var1, Utlis.numberFormat(Char.gI().bacKhoa), 225, 109, 20, -3089954, -16777216);
         mFont.b(mFont.d, var1, Utlis.numberFormat(Char.gI().vang), 129, 133, 20, -2560, -16777216);
         mFont.b(mFont.d, var1, Utlis.numberFormat(Char.gI().vangKhoa), 225, 133, 20, -2560, -16777216);
      }

   }

   public void b() {
      super.b();
      if (this.j[0].i * this.j[0].r != Char.gI().arrItemBag.length || this.j[1].i * this.j[1].r != Char.gI().arrItemExtend.length) {
         this.a();
         this.e();
      }

      if (this.k() == this.j()) {
         for(int var1 = 0; var1 < this.j.length; ++var1) {
            this.j[var1].a();
         }
      }

   }

   public Vector c() {
      Vector var1 = super.c();
      if (this.j() <= 0) {
         var1.removeElementAt(0);
      }

      if (this.k() == this.j()) {
         var1.addElement(this.j[0].a(5001, this));
         var1.addElement(this.j[1].a(5002, this));

         for(int var2 = 0; var2 < this.a.length; ++var2) {
            var1.addElement(this.a[var2].a(5003 + var2, this));
         }
      }

      return var1;
   }

   private void a(LangLa_ii var1, int var2) {
      for(int var3 = 0; var3 < this.j.length; ++var3) {
         this.j[var3].k = -1;
      }

      var1.k = var2;
   }

   public void d(int var1) {
      this.a(this.j[0], var1);
   }
}
