package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_ah extends LangLa_fn {
   
   
   public boolean a = true;
   public LangLa_ln[] b = new LangLa_ln[0];
   private LangLa_lf e;
   private LangLa_ii f;
   private LangLa_cg g;
   private Vector h = new Vector();
   private LangLa_ka[] i;
   private boolean j;
   private int o;
   private LangLa_ii[] s = new LangLa_ii[3];
   private int t;
   private Item u = null;

   public LangLa_ah(MainScreen var1) {
      super(var1);
      this.s[0] = new LangLa_ii((byte)1, 13, this.a_() + 11, super.width - 8 - 18, 162, 27, 0);
      this.s[1] = new LangLa_ii((byte)1, 13, this.a_() + 45, super.width - 8 - 18, 120, 15, 0);
      this.s[2] = new LangLa_ii((byte)1, 13, this.a_() + 11, super.width - 8 - 18, 27, 27, 1);
      LangLa_kd var2;
      (var2 = new LangLa_kd(5000)).c = Caption.sK;
      this.a(var2, 170, 72, 4);
      this.l = 4;
      this.a(315, 213);
      this.r = false;
      this.g = this.a(173, 56, 80, 6, new LangLa_kd(1002, Caption.qW), this, 0);
      this.a(beatdz.LangLa_ah.$state_LangLa_ah().d);
   }

   public void a() {
      this.f = new LangLa_ii((byte)1, 4, this.e.d() + 28, super.width - 8, 126, 18, this.b.length);
   }

   public void a(Message var1) {
      try {
         if (this.i == null) {
            this.i = new LangLa_ka[var1.reader.dis.readByte()];

            for(int var2 = 0; var2 < this.i.length; ++var2) {
               this.i[var2] = new LangLa_ka();
               this.i[var2].a[0] = var1.reader.readUTF();
               this.i[var2].a[1] = var1.reader.readUTF();
               this.i[var2].b = var1.reader.dis.readLong();
               this.i[var2].c = var1.reader.dis.readLong();
               this.i[var2].d = new String[var1.reader.dis.readByte()];
               Vector var3 = new Vector();

               for(int var4 = 0; var4 < this.i[var2].d.length; ++var4) {
                  this.i[var2].d[var4] = var1.readUTF().trim();
                  Item var5;
                  (var5 = new Item()).read(var1);
                  if (var4 == 0) {
                     this.i[var2].e.add(this.i[var2].d[var4]);
                     this.i[var2].f.add(var3);
                  } else if (!this.i[var2].e.contains(this.i[var2].d[var4])) {
                     this.i[var2].e.add(this.i[var2].d[var4]);
                     var3 = new Vector();
                     this.i[var2].f.add(var3);
                  }

                  ((Vector)this.i[var2].f.get(this.i[var2].e.indexOf(this.i[var2].d[var4]))).add(var5);
               }
            }

            LangLa_ii[] var7;
            (var7 = new LangLa_ii[3])[0] = new LangLa_ii((byte)1, 13, this.a_() + 11, super.width - 8 - 18, 162, 27, this.i.length);
            var7[1] = new LangLa_ii((byte)1, 13, this.a_() + 45, super.width - 8 - 18, 120, 15, 0);
            var7[2] = new LangLa_ii((byte)1, 13, this.a_() + 11, super.width - 8 - 18, 27, 27, 1);
            this.s = var7;
         }

      } catch (Exception var6) {
      }
   }

   public void a(int var1) {
      super.a(var1);
      if (this.k() == 3) {
         if (this.i != null) {
            return;
         }

         try {
            Message.c((byte)-57).send();
         } catch (Exception var3) {
            Utlis.println(var3);
            return;
         }
      } else {
         beatdz.LangLa_ah.$state_LangLa_ah().d = var1;
         switch(var1) {
         case 0:
            this.e = new LangLa_lf(new LangLa_kd(1001, Caption.qY), 3, this.a_(), super.width - 8 + 2, 23, 61, this);
            break;
         case 1:
            this.e = new LangLa_lf(new LangLa_kd(1001, Caption.rQ), 3, this.a_(), super.width - 8 + 2, 23, 61, this);
            break;
         case 2:
            this.e = new LangLa_lf(new LangLa_kd(1001, Caption.rR), 3, this.a_(), super.width - 8 + 2, 23, 61, this);
         }

         this.b(beatdz.LangLa_ah.$state_LangLa_ah().c[var1]);
      }

   }

   private void b(int var1) {
      this.b = new LangLa_ln[0];
      this.a();
      this.e.a(var1);
      this.e();
      if (var1 > 3) {
         this.e.a.a(this.e.b.c.length);
      } else {
         this.e.a.a(0);
      }
   }

   private void e() {
      try {
         Message var1 = new Message((byte)-22);
         switch(this.k()) {
         case 0:
            var1.writeByte(this.e.b.b);
            break;
         case 1:
            var1.writeByte(this.e.b.b + 6);
            break;
         case 2:
            var1.writeByte(this.e.b.b + 20);
         }

         var1.writeByte(this.g.b.b);
         var1.send();
      } catch (Exception var3) {
         Utlis.println(var3);
      }
   }

   public void b() {
      this.e.b();
      this.f.a();

      for(int var1 = 0; var1 < this.s.length; ++var1) {
         if (this.s[var1] != null) {
            this.s[var1].a();
         }
      }

      if (!this.a) {
         this.g.b(true);
      } else if (this.k() == 0 && this.e.b.b == 0) {
         this.g.v = false;
      } else {
         this.g.v = true;
      }
   }

   public void a(int var1, Object var2, LangLa_cy var3) {
      LangLa_ah var7;
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
      Vector var1 = super.c();
      if (this.k() == 3) {
         if (!this.j) {
            var1.addElement(this.s[0].a(9980, this));
         } else {
            var1.addElement(this.s[2].a(9981, this));
            var1.addElement(new LangLa_jz(1030, this.s[2].cx, this.s[2].cy - 12, this.s[2].cx + this.s[2].width, this.s[1].cy, (LangLa_ii)null, this));
            var1.addElement(new LangLa_jz(1030, this.s[1].cx, this.s[1].cy + this.s[1].height, this.s[1].cx + this.s[1].width, this.s[1].cy + this.s[1].height + 50, (LangLa_ii)null, this));

            for(int var2 = 0; var2 < this.i[this.o].f.size(); ++var2) {
               for(int var3 = 0; var3 < ((Vector)this.i[this.o].f.get(var2)).size(); ++var3) {
                  Item var4 = (Item)((Vector)this.i[this.o].f.get(var2)).get(var3);
                  int var5 = this.s[1].cx + 4 + var3 * 35;
                  int var6 = this.s[1].cy - this.s[1].f + (this.t + var2 * 3) * this.s[1].h + 15;
                  if (this.s[1].b(this.t + var2 * 3 + 3)) {
                     LangLa_jz var7 = new LangLa_jz(6000, var5, var6, var5 + 28, var6 + 28, this.s[1], this, var4);
                     var1.addElement(var7);
                  }
               }
            }

            var1.addElement(this.s[1].a(1030, this));
         }
      } else {
         var1.addElement(this.e.c());
         if (this.a) {
            var1.addElement(this.f.a(1003, this));
         }

         int var10000 = this.e.b.b;
      }

      return var1;
   }

   public void a(Graphics var1) {
      super.a(var1);
      Graphics var2;
      int var3;
      LangLa_ah var11;
      if (this.k() == 3) {
         var2 = var1;
         var11 = this;

         try {
            var11.a(var2, 7, var11.a_() + 5, var11.width - 8 - 6, var11.G() - 10, 4, 55, 56);
            int var12;
            if (!var11.j) {
               var11.a(var2, var11.s[0]);

               for(var3 = 0; var3 < var11.s[0].i; ++var3) {
                  if (var11.s[0].b(var3)) {
                     var11.a(var2, 0, var3 * var11.s[0].h, var11.s[0].width, 26, -17, 84, 5, 1, 1);
                     LangLa_fq.a(var2, 395, 0, 6, var3 * var11.s[0].h + 8, 20);
                     var12 = var11.s[0].l == var3 ? 13 + var3 * var11.s[0].h : 12 + var3 * var11.s[0].h;
                     mFont.a(var2, var11.i[var3].a[0], 22, var12, 0, -1);
                     mFont var10000 = mFont.d;
                     LangLa_ka var13 = var11.i[var3];
                     long var8 = Utlis.time();
                     mFont.c(var10000, var2, var13.b != -1L && var8 < var13.b ? Caption.nk : (var13.c != -1L && var8 >= var13.c ? Caption.nl : (var13.b != -1L && var13.b <= var8 && var13.c != -1L && var8 < var13.c ? Caption.nm : "")), var11.width - 35, var12, 1, -1, -16777216);
                  }
               }

               var11.b(var2);
               return;
            }

            var11.a(var2, var11.s[2]);
            var11.a(var2, 0, 0 * var11.s[2].h, var11.s[2].width, 26, -17, 84, 5, 1, 1);
            if (var11.s[2].l == 0) {
               mFont.a(var2, var11.i[var11.o].a[0], 22, 13, 0, -1);
               var2.e(30);
               LangLa_fq.a(var2, 398, 0, var11.s[2].width - 21, 5, 20);
               var2.d();
            } else {
               mFont.a(var2, var11.i[var11.o].a[0], 22, 12, 0, -1);
               LangLa_fq.a(var2, 398, 0, var11.s[2].width - 22, 4, 20);
            }

            LangLa_fq.a(var2, 396, 0, 6, 0 * var11.s[2].h + 8, 20);
            var11.b(var2);
            var11.a(var2, var11.s[1]);

            for(var3 = 0; var3 < var11.s[1].i; ++var3) {
               mFont.c(mFont.d, var2, (String)var11.h.get(var3), 2, 6 + var3 * var11.s[1].h, 0, -1, 0);
            }

            var3 = 0;

            while(true) {
               if (var3 >= var11.i[var11.o].f.size()) {
                  var11.b(var2);
                  var11.s[1].b(var2, -14, -11);
                  break;
               }

               for(var12 = 0; var12 < ((Vector)var11.i[var11.o].f.get(var3)).size(); ++var12) {
                  Item var5 = (Item)((Vector)var11.i[var11.o].f.get(var3)).get(var12);
                  b(var2, 4 + var12 * 35, (var11.t + var3 * 3) * var11.s[1].h + 15, var5, var11.u != null && var11.u.equals(var5));
               }

               ++var3;
            }
         } catch (Exception var10) {
            return;
         }
      } else {
         this.e.a(var1);
         if (!this.a) {
            mFont.a(mFont.e, var1, Caption.mw, this.width / 2, this.height / 2 + 10, 2, -2560, 2, 1, 3);
            return;
         }

         this.b(var1, this.f);
         this.a(var1, 0, -28, this.f.width, 28, -11, 55, 56);
         mFont.b(mFont.e, var1, Caption.cd, 20, -15, 2, -6488, -10275328);
         switch(this.k()) {
         case 0:
            var2 = var1;
            var11 = this;
            LangLa_ln var4;
            if (this.e.b.b != 4) {
               mFont.b(mFont.e, var1, Caption.jv, 70, -15, 2, -6488, -10275328);
               if (this.e.b.b == 0) {
                  mFont.b(mFont.e, var1, Caption.ju, 140, -15, 2, -6488, -10275328);
               } else if (this.e.b.b == 1) {
                  mFont.b(mFont.e, var1, Caption.qY[1], 140, -15, 2, -6488, -10275328);
               } else if (this.e.b.b == 2) {
                  mFont.b(mFont.e, var1, Caption.jx, 140, -15, 2, -6488, -10275328);
               } else if (this.e.b.b == 3) {
                  mFont.b(mFont.e, var1, Caption.jy, 140, -15, 2, -6488, -10275328);
               }

               mFont.b(mFont.e, var1, Caption.jA, 208, -15, 2, -6488, -10275328);
               mFont.b(mFont.e, var1, Caption.jB, 274, -15, 2, -6488, -10275328);
               this.a(var1, this.f);

               for(var3 = 0; var3 < var11.f.i; ++var3) {
                  if (var11.f.b(var3)) {
                     if (var3 == var11.f.k) {
                        var2.f(13136426);
                        var2.c(0, var3 * var11.f.h, var11.f.width, var11.f.h);
                     }

                     var4 = var11.b[var3];
                     mFont.b(mFont.d, var2, "" + (var3 + 1), 20, 8 + var3 * var11.f.h, 2, -3604601, -16777216);
                     mFont.b(mFont.d, var2, var4.b, 70, 8 + var3 * var11.f.h, 2, -3604601, -16777216);
                     if (var11.e.b.b == 0) {
                        mFont.b(mFont.d, var2, "" + var4.c, 140, 8 + var3 * var11.f.h, 2, -3604601, -16777216);
                     } else {
                        mFont.b(mFont.d, var2, Utlis.numberFormat(var4.d), 140, 8 + var3 * var11.f.h, 2, -3604601, -16777216);
                     }

                     int var10004 = 8 + var3 * var11.f.h;
                     mFont.b(mFont.d, var2, DataCenter.gI().DataNameChar[var4.e].name, 208, var10004, 2, -3604601, -16777216);
                     mFont.b(mFont.d, var2, var4.f, 274, 8 + var3 * var11.f.h, 2, -3604601, -16777216);
                  }
               }

               var11.b(var2);
               var11.f.b(var2, -14, -11);
               return;
            }

            mFont.b(mFont.e, var1, Caption.ce, 70, -15, 2, -6488, -10275328);
            mFont.b(mFont.e, var1, Caption.ju, 140, -15, 2, -6488, -10275328);
            mFont.b(mFont.e, var1, Caption.dr, 208, -15, 2, -6488, -10275328);
            mFont.b(mFont.e, var1, Caption.ds, 274, -15, 2, -6488, -10275328);
            this.a(var1, this.f);

            for(var3 = 0; var3 < var11.f.i; ++var3) {
               if (var11.f.b(var3)) {
                  if (var3 == var11.f.k) {
                     var2.f(13136426);
                     var2.c(0, var3 * var11.f.h, var11.f.width, var11.f.h);
                  }

                  var4 = var11.b[var3];
                  mFont.b(mFont.d, var2, "" + (var3 + 1), 20, 8 + var3 * var11.f.h, 2, -3604601, -16777216);
                  mFont.b(mFont.d, var2, var4.f, 70, 8 + var3 * var11.f.h, 2, -3604601, -16777216);
                  mFont.b(mFont.d, var2, var4.c + "+" + var4.g, 140, 8 + var3 * var11.f.h, 2, -3604601, -16777216);
                  mFont.b(mFont.d, var2, var4.d + "/" + var4.e, 208, 8 + var3 * var11.f.h, 2, -3604601, -16777216);
                  mFont.b(mFont.d, var2, var4.b, 274, 8 + var3 * var11.f.h, 2, -3604601, -16777216);
               }
            }

            var11.b(var2);
            break;
         case 1:
            this.e(var1);
            return;
         case 2:
            this.f(var1);
         }
      }

   }

   private void e(Graphics var1) {
      mFont.b(mFont.e, var1, Caption.jv, 70, -15, 2, -6488, -10275328);
      switch(this.e.b.b) {
      case 0:
         mFont.b(mFont.e, var1, Caption.ju, 140, -15, 2, -6488, -10275328);
         break;
      case 1:
         mFont.b(mFont.e, var1, Caption.jz, 140, -15, 2, -6488, -10275328);
         break;
      case 2:
         mFont.b(mFont.e, var1, Caption.rQ[2], 140, -15, 2, -6488, -10275328);
         break;
      case 3:
         mFont.b(mFont.e, var1, Caption.rQ[3], 140, -15, 2, -6488, -10275328);
      }

      mFont.b(mFont.e, var1, Caption.jA, 208, -15, 2, -6488, -10275328);
      mFont.b(mFont.e, var1, Caption.jB, 274, -15, 2, -6488, -10275328);
      this.a(var1, this.f);

      for(int var2 = 0; var2 < this.f.i; ++var2) {
         if (this.f.b(var2)) {
            if (var2 == this.f.k) {
               var1.f(13136426);
               var1.c(0, var2 * this.f.h, this.f.width, this.f.h);
            }

            LangLa_ln var3 = this.b[var2];
            mFont.b(mFont.d, var1, "" + (var2 + 1), 20, 8 + var2 * this.f.h, 2, -3604601, -16777216);
            mFont.b(mFont.d, var1, var3.b, 70, 8 + var2 * this.f.h, 2, -3604601, -16777216);
            if (this.e.b.b == 0) {
               mFont.b(mFont.d, var1, "" + var3.c, 140, 8 + var2 * this.f.h, 2, -3604601, -16777216);
            } else {
               mFont.b(mFont.d, var1, Utlis.numberFormat(var3.d), 140, 8 + var2 * this.f.h, 2, -3604601, -16777216);
            }

            int var10004 = 8 + var2 * this.f.h;
            mFont.b(mFont.d, var1, DataCenter.gI().DataNameChar[var3.e].name, 208, var10004, 2, -3604601, -16777216);
            mFont.b(mFont.d, var1, var3.f, 274, 8 + var2 * this.f.h, 2, -3604601, -16777216);
         }
      }

      this.b(var1);
      this.f.b(var1, -14, -11);
   }

   private void f(Graphics var1) {
      mFont.b(mFont.e, var1, Caption.sR[this.e.b.b], 140, -15, 2, -6488, -10275328);
      int var2;
      LangLa_ln var3;
      if (this.e.b.b == 3) {
         mFont.b(mFont.e, var1, Caption.dM, 70, -15, 2, -6488, -10275328);
         mFont.b(mFont.e, var1, Caption.ju, 208, -15, 2, -6488, -10275328);
         mFont.b(mFont.e, var1, Caption.ds, 274, -15, 2, -6488, -10275328);
         this.a(var1, this.f);

         for(var2 = 0; var2 < this.f.i; ++var2) {
            if (this.f.b(var2)) {
               if (var2 == this.f.k) {
                  var1.f(13136426);
                  var1.c(0, var2 * this.f.h, this.f.width, this.f.h);
               }

               var3 = this.b[var2];
               mFont.b(mFont.d, var1, "" + (var2 + 1), 20, 8 + var2 * this.f.h, 2, -3604601, -16777216);
               mFont.b(mFont.d, var1, var3.f, 70, 8 + var2 * this.f.h, 2, -3604601, -16777216);
               mFont.b(mFont.d, var1, Utlis.numberFormat(var3.d), 140, 8 + var2 * this.f.h, 2, -3604601, -16777216);
               mFont.b(mFont.d, var1, Utlis.numberFormat(var3.c), 208, 8 + var2 * this.f.h, 2, -3604601, -16777216);
               mFont.b(mFont.d, var1, var3.b, 274, 8 + var2 * this.f.h, 2, -3604601, -16777216);
            }
         }

         this.b(var1);
         this.f.b(var1, -14, -11);
      } else {
         mFont.b(mFont.e, var1, Caption.jv, 70, -15, 2, -6488, -10275328);
         mFont.b(mFont.e, var1, Caption.jA, 208, -15, 2, -6488, -10275328);
         mFont.b(mFont.e, var1, Caption.jB, 274, -15, 2, -6488, -10275328);
         this.a(var1, this.f);

         for(var2 = 0; var2 < this.f.i; ++var2) {
            if (this.f.b(var2)) {
               if (var2 == this.f.k) {
                  var1.f(13136426);
                  var1.c(0, var2 * this.f.h, this.f.width, this.f.h);
               }

               var3 = this.b[var2];
               mFont.b(mFont.d, var1, "" + (var2 + 1), 20, 8 + var2 * this.f.h, 2, -3604601, -16777216);
               mFont.b(mFont.d, var1, var3.b, 70, 8 + var2 * this.f.h, 2, -3604601, -16777216);
               mFont.b(mFont.d, var1, Utlis.numberFormat(var3.d), 140, 8 + var2 * this.f.h, 2, -3604601, -16777216);
               int var10004 = 8 + var2 * this.f.h;
               mFont.b(mFont.d, var1, DataCenter.gI().DataNameChar[var3.e].name, 208, var10004, 2, -3604601, -16777216);
               mFont.b(mFont.d, var1, var3.f, 274, 8 + var2 * this.f.h, 2, -3604601, -16777216);
            }
         }

         this.b(var1);
         this.f.b(var1, -14, -11);
      }
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      super.a(var1, var2, var3);
      this.u = null;
      switch(var1.b) {
      case 1001:
         if (var1.j.k >= 0) {
            beatdz.LangLa_ah.$state_LangLa_ah().c[this.k()] = var1.j.k;
            this.b(var1.j.k);
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
         this.u = (Item)var1.k;
         this.cL = a(this, var2, var3, 28, this.u);
         break;
      case 9980:
         if (var1.j.k >= 0) {
            this.o = var1.j.k;
            String[] var10 = Utlis.split(this.i[this.o].a[1], "\\n");
            this.h.clear();
            String var11;
            if ((var11 = this.i[this.o].a()).length() > 0) {
               this.h.add("c#yellow" + var11);
            }

            for(var2 = 0; var2 < var10.length; ++var2) {
               this.h.addAll(mFont.a(mFont.d, var10[var2], super.width - 8 - 40));
            }

            this.h.add("c#blue" + Caption.iZ);
            this.t = this.h.size();

            for(var2 = 0; var2 < this.i[this.o].e.size(); ++var2) {
               this.h.add("c#cyan" + "- " + (String)this.i[this.o].e.get(var2));
               this.h.add("");
               this.h.add("");
            }

            this.s[1] = new LangLa_ii((byte)1, 13, this.a_() + 45, super.width - 8 - 18, 120, 15, this.h.size());
            this.j = true;
            return;
         }
         break;
      case 9981:
         this.j = false;
         return;
      }

   }

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public int[] c;
public int d;
public void initialize() {
this.c = new int[3];
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.LangLa_ah");
public static SessionState $state_LangLa_ah() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
