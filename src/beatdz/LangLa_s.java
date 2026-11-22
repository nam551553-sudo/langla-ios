package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_s extends LangLa_ge {
   public mTextBox a;
   public mTextBox b;
   public mTextBox c;
   public LangLa_gd d;
   private LangLa_ii h;
   public Item e;
   private boolean i;
   public Vector f;
   public LangLa_dz g;

   public LangLa_s(MainScreen var1, String[] var2) {
      super(var1, var2);
      this.r = false;
      this.a(299, 212);
      LangLa_kd var9;
      (var9 = new LangLa_kd(-1000)).c = new String[3];

      for(int var3 = 0; var3 <= 0; ++var3) {
         var9.c[0] = var2[0];
      }

      var9.c[1] = Caption.B;
      var9.c[2] = Caption.q;
      this.a(var9, 210, 88, 3);
      this.b = this.a(65, this.a_() + 5, 175, "", this, 0);
      byte var10 = 26;
      this.b.a = var10;
      this.b.b(Caption.gF);
      this.b.setSize(175, 21);
      this.a(this.b, this.j() - 1);
      this.c = this.a(65, this.a_() + 30, 175, "", this, 0);
      var10 = 26;
      this.c.a = var10;
      this.c.a("");
      this.c.b(Caption.gs);
      this.c.setSize(175, 21);
      this.a(this.c, this.j() - 1);
      this.g = this.a(this.c.cx + this.c.width + 5, this.c.cy + 3, "", this, 1003, 12);
      this.a(this.g, this.j() - 1);
      this.a = this.b(65, this.a_() + 55, 174, Caption.gm, this, 3);
      this.a(this.a, this.j() - 1);
      this.a(this.s, this.j());
      this.a(this.o, this.j());
      this.d = new LangLa_gd(65, this.height - 77, 92, "", this, 0, 2, 0);
      this.d.a("");
      this.a(this.d, this.j() - 1);
      LangLa_dz var13 = this.a(this.width - 70, this.height - 33, Caption.v, this, 0, -8);
      this.a(var13, this.j() - 1);
      var13 = this.a(this.width - 136, this.height - 33, Caption.gn, this, 1, -8);
      this.a(var13, this.j() - 1);
      this.h = new LangLa_ii((byte)1, 210, this.height - 77, 28, 28, 28, 1);
      LangLa_s var11 = this;
      this.f = new Vector();
      Reader var12 = null;

      try {
         if ((var12 = Binary.createReader("arr_mail_receiver" + Char.gI().idEntity)) != null) {
            short var14 = var12.dis.readShort();

            for(int var4 = 0; var4 < var14; ++var4) {
               var11.f.add(Utlis.decodeString(var12.readUTF()));
            }
         }
      } catch (Exception var7) {
         Utlis.println(var7);
      } finally {
         if (var12 != null) {
            var12.close();
         }

      }

      this.g.b(this.f.isEmpty());
   }

   public void e() {
      Writer var1 = null;
      boolean var5 = false;

      label76: {
         try {
            var5 = true;
            (var1 = new Writer()).writeShort(this.f.size());

            for(int var2 = 0; var2 < this.f.size(); ++var2) {
               var1.writeUTF(Utlis.encodeString((String)this.f.elementAt(var2)));
            }

            var1.close("arr_mail_receiver" + Char.gI().idEntity);
            var5 = false;
            break label76;
         } catch (Exception var6) {
            Utlis.println(var6);
            var5 = false;
         } finally {
            if (var5) {
               if (var1 != null) {
                  var1.close();
               }

            }
         }

         if (var1 != null) {
            var1.close();
            return;
         }

         return;
      }

      var1.close();
   }

   public void a(int var1, Object var2) {
   }

   public void b() {
      super.b();
      if (this.k() == this.j() - 1) {
         this.h.a();
      }

   }

   public void a(Graphics var1) {
      if (this.j() <= 0) {
         this.a(var1, this.cx, this.cy, this.width, this.height, Caption.q, (byte)2, this.r);
      } else {
         super.a(var1);
      }

      if (this.k() == this.j() - 1) {
         mFont.b(mFont.d, var1, Caption.gg, 60, this.a_() + 14, 1, -6488, -10275328);
         mFont.b(mFont.d, var1, Caption.go, 60, this.a_() + 39, 1, -6488, -10275328);
         mFont.b(mFont.d, var1, Caption.bV, 60, this.a_() + 63, 1, -6488, -10275328);
         mFont.b(mFont.d, var1, Caption.gi, 60, this.height - 68, 1, -6488, -10275328);
         mFont.b(mFont.d, var1, Caption.gp, 204, this.height - 68, 1, -6488, -10275328);
         mFont.b(mFont.d, var1, Caption.gq, 60, this.height - 28, 1, -6488, -10275328);
         mFont.b(mFont.d, var1, "10", 65, this.height - 28, 0, -3089954, -16777216);
         a(var1, 65, this.height - 28, "1.000", (byte)0);
         if (this.d.e() > 0) {
            mFont.b(mFont.d, var1, "1%", 65, this.height - 11, 0, -3089954, -16777216);
            a(var1, 65, this.height - 11, "1%", (byte)0);
         }

         a(var1, this.h.cx, this.h.cy, this.e, this.i);
      }

   }

   public Vector c() {
      Vector var1 = super.c();
      if (this.j() <= 0) {
         var1.removeElementAt(0);
      }

      if (this.k() == this.j() - 1) {
         var1.add(this.h.a(2000, this));
         var1.add(new LangLa_jz(2001, -this.cx, -this.cy, DataCenter.gI().widthScreen * 2, DataCenter.gI().heightScreen + this.cy * 2, (LangLa_ii)null, this));
      }

      return var1;
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      this.i = false;
      if (this.k() == this.j() && var1.b == 0) {
         this.d();
      }

      super.a(var1, var2, var3);
      if (this.k() == this.j() - 1) {
         Utlis.println("" + var1.b);
         switch(var1.b) {
         case 0:
            this.J();
            return;
         case 1:
            LangLa_s var8 = this;

            try {
               var2 = var8.d.e();
               if (Char.gI().bac < var2 + 10) {
                  DataCenter.gI().currentScreen.showMessage(Utlis.replaceAll(Caption.gt, Utlis.numberFormat(Char.gI().bac - 10)), -65536);
               } else {
                  String var9;
                  if ((var9 = var8.b.f().trim()) == null || var9.equals("")) {
                     var9 = Caption.gl;
                  }

                  String var10 = var8.c.f().trim();
                  String var11 = var8.a.f().trim();
                  if (var9.length() <= 0) {
                     DataCenter.gI().currentScreen.showMessage(Caption.gu, -65536);
                  } else if (var10.length() <= 0) {
                     DataCenter.gI().currentScreen.showMessage(Caption.gv, -65536);
                  } else {
                     Message var12;
                     (var12 = new Message((byte)87)).writeUTF(var10);
                     var12.writeUTF(var9);
                     var12.writeUTF(var11);
                     var12.writeInt(var2);
                     if (var8.e == null) {
                        var12.writeShort(-1);
                     } else {
                        var12.writeShort(var8.e.index);
                     }

                     var12.send();
                  }
               }
               break;
            } catch (Exception var7) {
               Utlis.println(var7);
               return;
            }
         case 1003:
            int var10002 = var2 + this.g.cx;
            int var10003 = var3 + this.g.cy + 22;
            Vector var5 = this.f;
            boolean var4 = true;
            var3 = var10003;
            var2 = var10002;
            LangLa_he var6 = new LangLa_he(var2, var3, 120, this, var5);
            this.a(var6);
            this.cL = var6;
            return;
         case 2000:
            this.i = true;
            if (this.e == null) {
               this.cL = b(Caption.gr, this, this.h.cx + 30, this.h.cy, 30);
               return;
            }

            this.cL = a(this, var1.j.cx + 32, var1.j.cy, 28, this.e);
         }
      }

   }

   public void d() {
      super.d();
      if (this.e != null) {
         Char.gI().arrItemBag[this.e.index] = this.e;
         this.e = null;
      }

   }
}
