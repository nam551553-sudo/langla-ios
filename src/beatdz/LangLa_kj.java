package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_kj extends LangLa_ge {
   private int a = 32;
   private LangLa_ij[][] b;
   private LangLa_gx c;

   public LangLa_kj(MainScreen var1, String[] var2) {
      super(var1, var2);
      LangLa_kd var3;
      (var3 = new LangLa_kd(500)).c = Caption.sF;
      this.c = new LangLa_gx(var3, this.width, 1, this.a_() - 3, 87, this.G() + 6, 33, this);
      int var10000 = this.c.c() + 8;
      DataCenter.gI();
      int var4 = var10000 + 0;
      var10000 = this.a_() + 11;
      DataCenter.gI();
      int var5 = var10000 + 0;
      this.b = new LangLa_ij[Caption.rb.length][];
      this.b[0] = new LangLa_ij[5];
      this.b[0][0] = new LangLa_ij((byte)1, var4, var5, this.a, this.a * 5, this.a, 5, 1);
      this.b[0][1] = new LangLa_ij((byte)1, var4 + 160, var5, this.a, this.a * 5, this.a, 5, 1);
      this.b[0][2] = new LangLa_ij((byte)1, var4 + this.a, var5 + this.a * 4, this.a * 4, this.a, this.a, 1, 4);
      this.b[0][3] = new LangLa_ij((byte)1, var4 + this.a, var5 + this.a * 3, this.a, this.a, this.a, 1, 1);
      this.b[0][4] = new LangLa_ij((byte)1, var4 + this.a * 4, var5 + this.a * 3, this.a, this.a, this.a, 1, 1);
      this.b[1] = new LangLa_ij[5];
      this.b[1][0] = new LangLa_ij((byte)1, var4, var5, this.a, this.a * 5, this.a, 5, 1);
      this.b[1][1] = new LangLa_ij((byte)1, var4 + 160, var5, this.a, this.a * 5, this.a, 5, 1);
      this.b[1][2] = new LangLa_ij((byte)1, var4 + this.a, var5 + this.a * 4, this.a * 4, this.a, this.a, 1, 4);
      this.b[1][3] = new LangLa_ij((byte)1, var4 + this.a, var5 + this.a * 3, this.a, this.a, this.a, 1, 1);
      this.b[1][4] = new LangLa_ij((byte)1, var4 + this.a * 4, var5 + this.a * 3, this.a, this.a, this.a, 1, 1);
   }

   public void a(Graphics var1) {
      try {
         super.a(var1);
         if (this.k() == 1) {
            this.c.a((Graphics)var1, 61);
            this.c.a(var1, this.cx, this.cy);
            switch(this.c.b.b) {
            case 0:
               this.a(var1, Char.gI().arrItemBody);
               return;
            case 1:
               this.a(var1, Char.gI().arrItemBody2);
            }
         }

      } catch (Exception var3) {
         Utlis.println(var3);
      }
   }

   public Vector c() {
      Vector var1 = super.c();
      if (this.k() == 1) {
         var1.addElement(this.c.b());
         switch(this.c.b.b) {
         case 0:
         case 1:
            for(int var2 = 0; var2 < this.b[this.c.b.b].length; ++var2) {
               var1.addElement(this.b[this.c.b.b][var2].a(1010 + var2, this));
            }
         }
      }

      return var1;
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      try {
         super.a(var1, var2, var3);
         if (this.k() == 1) {
            Item[] var5 = Char.gI().arrItemBody;
            if (this.c.b.b == 1) {
               var5 = Char.gI().arrItemBody2;
            }

            switch(var1.b) {
            case 500:
               if (var1.j.k >= 0) {
                  this.c.a(var1.j.k);
               }
               break;
            case 1010:
               this.a(var1.j, var1.j.k);
               switch(var1.j.k) {
               case 0:
                  this.cL = a(var1, this, var5[0]);
                  return;
               case 1:
                  this.cL = a(var1, this, var5[2]);
                  return;
               case 2:
                  this.cL = a(var1, this, var5[4]);
                  return;
               case 3:
                  this.cL = a(var1, this, var5[6]);
                  return;
               case 4:
                  this.cL = a(var1, this, var5[8]);
                  return;
               default:
                  return;
               }
            case 1011:
               this.a(var1.j, var1.j.k);
               switch(var1.j.k) {
               case 0:
                  this.cL = a(var1, this, var5[1]);
                  return;
               case 1:
                  this.cL = a(var1, this, var5[3]);
                  return;
               case 2:
                  this.cL = a(var1, this, var5[5]);
                  return;
               case 3:
                  this.cL = a(var1, this, var5[7]);
                  return;
               case 4:
                  this.cL = a(var1, this, var5[9]);
                  return;
               default:
                  return;
               }
            case 1012:
               this.a(var1.j, var1.j.k);
               switch(var1.j.k) {
               case 0:
                  this.cL = a(var1, this, var5[10]);
                  return;
               case 1:
                  this.cL = a(var1, this, var5[11]);
                  return;
               case 2:
                  this.cL = a(var1, this, var5[12]);
                  return;
               case 3:
                  this.cL = a(var1, this, var5[13]);
                  return;
               default:
                  return;
               }
            case 1013:
               this.a(var1.j, var1.j.k);
               this.cL = a(var1, this, var5[14]);
               return;
            case 1014:
               this.a(var1.j, var1.j.k);
               this.cL = a(var1, this, var5[15]);
               return;
            }
         }

      } catch (Exception var4) {
         Utlis.println(var4);
      }
   }

   private void a(Graphics var1, Item[] var2) {
      try {
         Item var3 = null;

         int var4;
         for(var4 = 0; var4 < this.b[this.c.b.b][0].i; ++var4) {
            switch(var4) {
            case 0:
               var3 = var2[0];
               break;
            case 1:
               var3 = var2[2];
               break;
            case 2:
               var3 = var2[4];
               break;
            case 3:
               var3 = var2[6];
               break;
            case 4:
               var3 = var2[8];
            }

            a(var1, this.b[this.c.b.b][0].cx, this.b[this.c.b.b][0].cy + var4 * this.b[this.c.b.b][0].h, var3, var4 == this.b[this.c.b.b][0].k, Caption.qT[var4]);
         }

         for(var4 = 0; var4 < this.b[this.c.b.b][1].i; ++var4) {
            switch(var4) {
            case 0:
               var3 = var2[1];
               break;
            case 1:
               var3 = var2[3];
               break;
            case 2:
               var3 = var2[5];
               break;
            case 3:
               var3 = var2[7];
               break;
            case 4:
               var3 = var2[9];
            }

            a(var1, this.b[this.c.b.b][1].cx, this.b[this.c.b.b][1].cy + var4 * this.b[this.c.b.b][1].h, var3, var4 == this.b[this.c.b.b][1].k, Caption.qU[var4]);
         }

         for(var4 = 0; var4 < this.b[this.c.b.b][2].r; ++var4) {
            switch(var4) {
            case 0:
               var3 = var2[10];
               break;
            case 1:
               var3 = var2[11];
               break;
            case 2:
               var3 = var2[12];
               break;
            case 3:
               var3 = var2[13];
            }

            a(var1, this.b[this.c.b.b][2].cx + var4 * this.a, this.b[this.c.b.b][2].cy, var3, var4 == this.b[this.c.b.b][2].k, Caption.qV[var4]);
         }

         a(var1, this.b[this.c.b.b][3].cx, this.b[this.c.b.b][3].cy, var2[14], this.b[this.c.b.b][3].k == 0, Caption.rS[0]);
         a(var1, this.b[this.c.b.b][4].cx, this.b[this.c.b.b][4].cy, var2[15], this.b[this.c.b.b][4].k == 0, Caption.rS[1]);
         Char var10000 = Char.gI();
         DataCenter.gI();
         DataCenter.gI();
         var10000.a(var1, 190, 120, Char.gI().a(var2, false), DataCenter.gI().i / 8 % 2, Char.gI().m, false);
         var10000 = Char.gI();
         DataCenter.gI();
         DataCenter.gI();
         var10000.a((Graphics)var1, 190, 68, 2);
      } catch (Exception var6) {
         Utlis.println(var6);
      }
   }

   private void a(LangLa_ii var1, int var2) {
      for(int var3 = 0; var3 < this.b.length; ++var3) {
         if (this.b[var3] != null) {
            for(int var4 = 0; var4 < this.b[var3].length; ++var4) {
               if (this.b[var3][var4] != null) {
                  this.b[var3][var4].k = -1;
               }
            }
         }
      }

      var1.k = var2;
   }

   private int e() {
      return this.c.b.b;
   }

   public Item[] b(Item var1) {
      Item[] var2 = Char.gI().arrItemBag;
      if (this.k() == 1) {
         if (this.e() == 0) {
            var2 = Char.gI().arrItemBody;
            var1.TYPE_TEMP = 2;
         } else {
            var2 = Char.gI().arrItemBody2;
            var1.TYPE_TEMP = 3;
         }

         for(int var3 = 0; var3 < var2.length; ++var3) {
            if (var2[var3] != null) {
               var2[var3].index = var1.getItemTemplate().type;
            }
         }
      } else if (this.k() == this.j()) {
         var1.TYPE_TEMP = 0;
      }

      return var2;
   }

   public int f() {
      return this.k() == 1 ? 0 : super.f();
   }
}
