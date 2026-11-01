package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_mq extends LangLa_fm {
   public LangLa_mk a;
   private int b;
   private int c;
   private int d = 157;
   private int e = 50;
   private boolean f;
   private LangLa_dz[] g = new LangLa_dz[5];
   private LangLa_ii[] h = new LangLa_ii[3];
   
   
   
   private boolean l;

   public LangLa_mq(int var1, int var2, LangLa_mk var3) {
      this.a = var3;
      this.a.c = this;
      this.setSize(var3.width, var3.height);
      this.s = var3.s;
      this.b = var1;
      this.c = var2;
      LangLa_mk var5 = var3;
      var2 = 0;

      LangLa_dz var10000;
      while(true) {
         if (var2 >= var5.a.length) {
            var10000 = null;
            break;
         }

         if (var5.a[var2].a.equals(Caption.bk) || var5.a[var2].a.equals(Caption.aR) && var5.a.length > 2 || var5.a[var2].a.equals(Caption.aS)) {
            var10000 = var5.a[var2];
            break;
         }

         ++var2;
      }

      LangLa_dz var6 = var10000;
      beatdz.LangLa_mq.$state_LangLa_mq().k = Utlis.time();
      if (var6 == null) {
         this.f = true;
      } else {
         Item var7 = var3.b;
         int var4 = mFont.b(mFont.f, var7.getItemTemplate().name + " (+" + var7.level + ")");
         if (this.d < var4 + 32) {
            this.d = var4 + 32;
         }

         while(this.b + this.d > this.s.width) {
            this.b -= 32;
         }

         if (this.c + this.e + 8 > DataCenter.gI().heightScreen) {
            this.c = DataCenter.gI().heightScreen - this.e - 8;
         }

         this.g[0] = new LangLa_dz(this.d - 17, 3, 0, 0, "", this.s, 100, 52);
         this.g[1] = new LangLa_dz(8, 23, 50, 0, var6.a, this.s, var6.b, 15);
         this.g[2] = new LangLa_dz(58, 23, 50, 0, Caption.ql, this.s, 101, 15);
         if ((var6 = var3.d()) != null) {
            this.g[3] = new LangLa_dz(108, 23, 50, 0, var6.a, this.s, var6.b, 15);
         }

         for(var1 = 1; var1 < this.g.length; ++var1) {
            if (this.g[var1] != null) {
               this.g[var1].setSize(45, 20);
            }
         }

         this.h = a(this.g);
         if (var7.equals(beatdz.LangLa_mq.$state_LangLa_mq().i) && beatdz.LangLa_mq.$state_LangLa_mq().k - beatdz.LangLa_mq.$state_LangLa_mq().j < 1000L) {
            this.l = true;
            this.s.cL = null;
            this.a(this.h[2].a(this.g[1].b, this), 0, 0);
         } else {
            beatdz.LangLa_mq.$state_LangLa_mq().i = var7;
            beatdz.LangLa_mq.$state_LangLa_mq().j = beatdz.LangLa_mq.$state_LangLa_mq().k;
         }
      }
   }

   public void a(Graphics var1) {
      if (this.l) {
         this.a();
         this.s.cL = null;
      } else if (Utlis.time() - beatdz.LangLa_mq.$state_LangLa_mq().k >= 100L) {
         int var2 = var1.a;
         int var3 = var1.b;
         if (this.f) {
            this.a.a(var1);
         } else {
            this.a(var1, 0, 0, this.d, this.e, -11, 55, 56, 1, 1);
            this.a.b(var1, 8, 10);
            this.a(var1, this.g, var2, var3);
         }
      }
   }

   public void b() {
      if (this.f) {
         this.setXY(this.a.cx, this.a.cy);
         this.a.b();
      } else {
         this.setXY(this.b, this.c);
         a(this.g, this.h);
      }

      int var10000 = GameSrc.gI().Task;
      DataCenter.gI();
      if (var10000 <= 12 && this.s.cL.equals(this)) {
         Step var2 = GameSrc.gI().B();
         int var3 = this.s.cx + this.cx + this.width;
         int var4 = this.s.cy + this.cy + this.height;
         switch(GameSrc.gI().Task) {
         case 0:
            if (GameSrc.gI().idStep == 0 && this.a.b.id == 28) {
               this.a(var3, var4);
               return;
            }
            break;
         case 1:
            if (GameSrc.gI().idStep == 1 && this.a.b.id == 378) {
               this.a(var3, var4);
               return;
            }
            break;
         case 2:
            if (GameSrc.gI().idStep == 1 && this.a.b.id == 194) {
               this.a(var3, var4);
               return;
            }
            break;
         case 3:
            if (GameSrc.gI().idStep == 1) {
               this.a(var3, var4);
               return;
            }

            if (GameSrc.gI().idStep == 4 && this.a.b.id == 379) {
               this.a(var3, var4);
               return;
            }
         case 4:
         case 5:
         case 7:
         default:
            break;
         case 6:
            if (GameSrc.gI().idStep >= 0 && this.a.b.id == 380 && var2 != null && Char.gI().cx == var2.x && Char.gI().cy == var2.y) {
               this.a(var3, var4);
               return;
            }
            break;
         case 8:
            Item var6 = Char.gI().v();
            if (GameSrc.gI().idStep == 9 && var6 != null && this.a.b.id == var6.id) {
               this.a(var3, var4);
               return;
            }
            break;
         case 9:
            var3 = this.s.cx + this.cx;
            var4 = this.s.cy + this.cy;
            if (GameSrc.gI().idStep == 10 && this.s instanceof LangLa_ar) {
               if (((LangLa_ar)this.s).k.b != ((LangLa_ar)this.s).j() || this.a.b.getItemTemplate().type == 1 || this.a.b.getItemTemplate().type == 21) {
                  this.a(var3, var4);
               }

               DataCenter.gI().aO.a = true;
               return;
            }
            break;
         case 10:
            if (GameSrc.gI().idStep == 5 && this.s instanceof LangLa_by) {
               DataCenter.gI().aO.a(var3 - 70, var4 - 12);
               DataCenter.gI().aO.a = true;
               return;
            }
            break;
         case 11:
            if (this.s instanceof LangLa_kl && this.a.b.id == 383 && var2 != null && Char.gI().cx == var2.x && Char.gI().cy == var2.y) {
               DataCenter.gI().aO.a(var3 - 35, var4 - 12);
               DataCenter.gI().aO.a = true;
            }
         }
      }

   }

   private void a(int var1, int var2) {
      if (!this.f) {
         DataCenter.gI().aO.a(var1 + 28, var2 + 35);
      } else {
         var1 = this.s.cx + this.cx + this.width;
         var2 = this.s.cy + this.cy + this.height;
         if (this.a.b.getAmount() >= 2) {
            DataCenter.gI().aO.a(var1 - 70, var2 - 12);
         } else {
            DataCenter.gI().aO.a(var1 - 35, var2 - 12);
         }
      }

      DataCenter.gI().aO.a = true;
   }

   public Vector c() {
      Vector var1 = new Vector();
      if (this.f) {
         return this.a.c();
      } else {
         for(int var2 = 0; var2 < this.h.length; ++var2) {
            if (this.g[var2] != null) {
               var1.addElement(this.h[var2].a(this.g[var2].b, this));
            }
         }

         var1.addElement(new LangLa_jz(1011, 0, 0, this.d, this.e, (LangLa_ii)null, this));
         return var1;
      }
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      if (this.f) {
         this.a.a(var1, var2, var3);
      } else {
         switch(var1.b) {
         case 100:
            this.a();
            return;
         case 101:
            this.f = true;
            return;
         case 1011:
            return;
         default:
            this.a();
            this.a.a(var1, var2, var3);
         }
      }
   }

   private void a() {
      this.s.b((LangLa_cs)this);
   }

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public Item i;
public long j;
public long k;
public void initialize() {
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.LangLa_mq");
public static SessionState $state_LangLa_mq() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
