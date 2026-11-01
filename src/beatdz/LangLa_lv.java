package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_lv extends LangLa_fo {
   private mTextBox c;
   private Item d;
   private byte e;
   private LangLa_ij f;
   private long g;
   private boolean h = true;
   private String i = "";
   private int j = 0;
   public byte a;
   public boolean b;

   public LangLa_lv(MainScreen var1, Item var2, byte var3) {
      this.a = var3;
      this.cF = 2;
      this.p = var1;
      this.d = var2;
      this.r = false;
      if (var2.vangBuy > 0) {
         this.e = 2;
      } else if (var2.vangKhoaBuy > 0) {
         this.e = 3;
      } else if (var2.bacBuy > 0) {
         this.e = 0;
      } else if (var2.bacKhoaBuy > 0) {
         this.e = 1;
      } else if (var2.tinhThachBuy > 0) {
         this.e = 4;
      }

      this.a(220, 155);
      this.c = this.a(54, 5 + 38, 60, "", this, 2);
      byte var5 = 4;
      this.c.a = var5;
      var5 = 1;
      this.c.n = var5;
      short var6 = 9999;
      this.c.o = var6;
      this.c.a("1");
      this.a(this.c);
      LangLa_dz var7 = this.a(119, 5 + 41, "", this, 1001, 58);
      LangLa_dz var8 = this.a(140, 5 + 41, "", this, 1002, 57);
      LangLa_dz var4;
      (var4 = this.a(Caption.g, 1003)).a(-8);
      var4.setXY(var4.cx - 26, var4.cy);
      (var4 = this.a(Caption.v, -7)).a(-8);
      var4.setXY(var4.cx + 40, var4.cy);
      this.f = new LangLa_ij((byte)1, 9, 9, 30, 30, 30, 1, 1);
      if (var3 == 40) {
         var7.b(true);
         var8.b(true);
         this.c.a(true);
      }

   }

   public void b(int var1, Object var2) {
   }

   public void a(int var1, Object var2) {
   }

   public void a(int var1, Object var2, LangLa_cy var3) {
   }

   public int a_() {
      return 5;
   }

   public void a(Graphics var1) {
      this.a(var1, 0, 0, this.width, this.height, 80, 55, 56);
      b(var1, this.f.cx, this.f.cy, this.d, this.b);
      mFont.b(mFont.d, var1, this.d.getItemTemplate().name, 44, 5 + 10, 0, -1, -16777216);
      mFont.b(mFont.d, var1, Caption.ap, 44, 5 + 25, 0, -10831436, -16777216);
      mFont.b(mFont.d, var1, "" + this.d.d(), 64, 5 + 25, 0, -1, -16777216);
      a(var1, 64, 5 + 25, "" + this.d.d(), this.e);
      mFont.b(mFont.d, var1, Caption.at, 9, 5 + 50, 0, -10831436, -16777216);
      mFont.b(mFont.d, var1, Caption.au, 9, 5 + 70, 0, -10831436, -16777216);
      mFont.b(mFont.d, var1, "" + this.g, 54, 5 + 70, 0, -1, -16777216);
      a(var1, 54, 5 + 70, "" + this.g, this.e);
      mFont.b(mFont.d, var1, Caption.av, 9, 5 + 90, 0, -10831436, -16777216);
      mFont.b(mFont.d, var1, this.i, 54, 5 + 90, 0, -2560, -16777216);
      a(var1, 54, 5 + 90, this.i, this.e);
      if (!this.h && (this.j == 0 || this.j % 10 > 5)) {
         Item var3;
         mFont.b(mFont.d, var1, Caption.aM + " " + ((var3 = this.d).vangBuy > 0 ? Caption.rs[0] : (var3.vangKhoaBuy > 0 ? Caption.rs[1] : (var3.bacBuy > 0 ? Caption.rs[2] : (var3.bacKhoaBuy > 0 ? Caption.rs[3] : (var3.tinhThachBuy > 0 ? Caption.rs[4] : ""))))), 9, 5 + 108, 0, -65536, -16777216);
      }

   }

   public void b() {
      this.h = true;
      this.g = (long)this.c.e() * (long)this.d.d();
      if (this.d.vangBuy > 0) {
         this.i = "" + Char.gI().vang;
         if ((long)Char.gI().vang < this.g) {
            this.h = false;
         }
      } else if (this.d.vangKhoaBuy > 0) {
         this.i = "" + Char.gI().vangKhoa;
         if ((long)Char.gI().vangKhoa < this.g) {
            this.h = false;
         }
      } else if (this.d.bacBuy > 0) {
         this.i = "" + Char.gI().bac;
         if ((long)Char.gI().bac < this.g) {
            this.h = false;
         }
      } else if (this.d.bacKhoaBuy > 0) {
         this.i = "" + Char.gI().bacKhoa;
         if ((long)Char.gI().bacKhoa < this.g) {
            this.h = false;
         }
      } else if (this.d.tinhThachBuy > 0) {
         this.i = "" + GameSrc.gI().bv;
         if ((long)GameSrc.gI().bv < this.g) {
            this.h = false;
         }
      }

      if (this.j > 0) {
         --this.j;
      }

      if (GameSrc.gI().Task == 3 && GameSrc.gI().idStep == 0) {
         int var10001;
         if (this.g >= 3L) {
            var10001 = this.cx + 75;
            DataCenter.gI().aO.a(var10001, this.cy + 140);
         } else {
            var10001 = this.cx + 150;
            DataCenter.gI().aO.a(var10001, this.cy + 48);
         }

         DataCenter.gI().aO.a = true;
      }

   }

   public Vector c() {
      super.c();
      Vector var1;
      (var1 = new Vector()).addElement(this.f.a(1000, this));
      var1.addElement(new LangLa_jz(0, 0, 0, this.width, this.height, this.q, this));
      return var1;
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      this.b = false;
      switch(var1.b) {
      case 1000:
         this.b = true;
         this.cL = a(this, 39, 5 + 5, 30, this.d);
         return;
      case 1001:
         this.c.a(this.c.e() - 1);
         if (this.c.e() < this.c.n) {
            this.c.a(this.c.n);
            return;
         }
         break;
      case 1002:
         this.c.a(this.c.e() + 1);
         return;
      case 1003:
         if (this.g < 1L) {
            return;
         }

         if (!this.h) {
            this.j = 50;
            return;
         }

         LangLa_lv var5 = this;

         try {
            Message var6;
            (var6 = new Message((byte)121)).writeShort(var5.d.idBuy);
            var6.writeShort(var5.c.e());
            var6.send();
            return;
         } catch (Exception var4) {
            Utlis.println(var4);
         }
      }

   }
}
