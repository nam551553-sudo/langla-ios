package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_kw extends LangLa_cs {
   
   
   private Vector g = new Vector();
   public Vector c = new Vector();
   private Vector h = new Vector();
   private LangLa_ii i;
   private LangLa_ii j;
   private byte k;
   private int l;
   private int m;
   
   
   private byte n;
   private boolean o;
   public int f = 16;
   

   public LangLa_kw(int var1, int var2, int var3, int var4, LangLa_cx var5, byte var6, int var7, int var8) {
      this.s = var5;
      this.k = var6;
      this.l = var7;
      this.f = var8;
      this.setXY(var1, var2);
      this.setSize(var3, var4);
      if (var6 == 1) {
         this.j = new LangLa_ii((byte)1, var3 - 92, 0, 92, var4, var8, this.c.size());
      } else {
         this.j = new LangLa_ii((byte)1, 0, 0, 0, var4, var8, this.c.size());
      }

      this.i = new LangLa_ii((byte)1, 0, 0, var3 - this.j.width, var4, var8, this.g.size());
      LangLa_km.e();
   }

   public static void a(int var0, String var1, String var2, LangLa_gl var3) {
      boolean var6 = var2.equals(beatdz.LangLa_kw.$state_LangLa_kw().p);

      try {
         for(int var4 = 0; var4 < beatdz.LangLa_kw.$state_LangLa_kw().b.length; ++var4) {
            if (beatdz.LangLa_kw.$state_LangLa_kw().b[var4] == 1) {
               LangLa_fa var7;
               (var7 = new LangLa_fa(beatdz.LangLa_kw.$state_LangLa_kw().b[1], var1, var2)).f = var3;
               beatdz.LangLa_kw.$state_LangLa_kw().a[0].a(var7);
               break;
            }
         }
      } catch (Exception var5) {
         Utlis.println(var5);
      }

      beatdz.LangLa_kw.$state_LangLa_kw().p = var2;
      if (!var6) {
         GameSrc.gI().y();
      }

   }

   public static void a(int var0, String var1, String var2) {
      boolean var3 = var2.equals(beatdz.LangLa_kw.$state_LangLa_kw().p);

      try {
         for(int var4 = 0; var4 < beatdz.LangLa_kw.$state_LangLa_kw().b.length; ++var4) {
            if (beatdz.LangLa_kw.$state_LangLa_kw().b[var4] == var0) {
               beatdz.LangLa_kw.$state_LangLa_kw().a[0].a(new LangLa_fa(beatdz.LangLa_kw.$state_LangLa_kw().b[var0], var1, var2));
               break;
            }
         }

         switch(var0) {
         case 3:
            beatdz.LangLa_kw.$state_LangLa_kw().a[4].a(new LangLa_fa(3, var1, var2));
            break;
         case 4:
            beatdz.LangLa_kw.$state_LangLa_kw().a[2].a(new LangLa_fa(4, var1, var2));
            break;
         case 5:
            beatdz.LangLa_kw.$state_LangLa_kw().a[3].a(new LangLa_fa(5, var1, var2));
         }
      } catch (Exception var5) {
         Utlis.println(var5);
      }

      beatdz.LangLa_kw.$state_LangLa_kw().p = var2;
      if (!var3) {
         GameSrc.gI().y();
      }

   }

   public static void a(int var0, String var1, String var2, String var3) {
      boolean var6 = var2.equals(beatdz.LangLa_kw.$state_LangLa_kw().p);

      try {
         for(int var4 = 0; var4 < beatdz.LangLa_kw.$state_LangLa_kw().b.length; ++var4) {
            if (beatdz.LangLa_kw.$state_LangLa_kw().b[var4] == 6) {
               beatdz.LangLa_kw.$state_LangLa_kw().a[0].a.addElement(new LangLa_fa(beatdz.LangLa_kw.$state_LangLa_kw().b[6], var1, var2, var3));
               break;
            }
         }

         beatdz.LangLa_kw.$state_LangLa_kw().a[1].a.addElement(new LangLa_fa(6, var1, var2, var3));
      } catch (Exception var5) {
         Utlis.println(var5);
      }

      beatdz.LangLa_kw.$state_LangLa_kw().p = var2;
      if (!var6) {
         GameSrc.gI().y();
      }

   }

   public void a() {
      this.c.clear();
      this.g.clear();
      this.h.clear();
      Vector var3 = new Vector();

      LangLa_fa var1;
      int var4;
      int var6;
      for(var4 = 0; var4 < beatdz.LangLa_kw.$state_LangLa_kw().a[this.k].a.size(); ++var4) {
         String var2 = "";
         switch((var1 = (LangLa_fa)beatdz.LangLa_kw.$state_LangLa_kw().a[this.k].a.elementAt(var4)).a) {
         case 0:
            if (var1.b.equals(Char.gI().name)) {
               var2 = var2 + ":-lc c#ME" + var1.b + ": c#white";
            } else {
               var2 = var2 + ":-lc c#LC" + var1.b + ": c#white";
            }
            break;
         case 1:
            if (var1.b.equals(Char.gI().name)) {
               var2 = var2 + ":-tg c#ME" + var1.b + ": c#white";
            } else if (var1.b.equals(Caption.dx)) {
               var2 = var2 + ":-tg c#yellow" + var1.b + ": c#white";
            } else {
               var2 = var2 + ":-tg c#TG" + var1.b + ": c#white";
            }
            break;
         case 2:
            if (var1.b.equals(Char.gI().name)) {
               var2 = var2 + ":-tt c#ME" + var1.b + ": c#white";
            } else {
               var2 = var2 + ":-tt c#TT" + var1.b + ": c#white";
            }
            break;
         case 3:
            if (var1.b.equals(Char.gI().name)) {
               var2 = var2 + ":-mp c#ME" + var1.b + ": c#white";
            } else {
               var2 = var2 + ":-mp c#MP" + var1.b + ": c#white";
            }
            break;
         case 4:
            if (var1.b.equals(Char.gI().name)) {
               var2 = var2 + ":-b c#ME" + var1.b + ": c#white";
            } else {
               var2 = var2 + ":-b c#BG" + var1.b + ": c#white";
            }
            break;
         case 5:
            if (var1.b.equals(Char.gI().name)) {
               var2 = var2 + ":-n c#ME" + var1.b + ": c#white";
            } else {
               var2 = var2 + ":-n c#NM" + var1.b + ": c#white";
            }
            break;
         case 6:
            if (var1.b.equals(Char.gI().name)) {
               var2 = var2 + ":-r c#ME" + var1.b + ": c#white";
            } else {
               var2 = var2 + ":-r c#RG" + var1.b + ": c#white";
            }
            break;
         case 7:
            if (var1.b.equals(Char.gI().name)) {
               var2 = var2 + ":-ht c#ME" + var1.b + ": c#white";
            } else {
               var2 = var2 + ":-ht c#HT" + var1.b + ": c#white";
            }
            break;
         case 8:
            if (var1.b.equals(Char.gI().name)) {
               var2 = var2 + ":-sv c#ME" + var1.b + ": c#white";
            } else if (var1.b.equals(Caption.dx)) {
               var2 = var2 + ":-sv c#yellow" + var1.b + ": c#white";
            } else {
               var2 = var2 + ":-sv c#SV" + var1.b + ": c#white";
            }
         }

         var2 = var2 + var1.d;
         if (this.k != 1 || beatdz.LangLa_kw.$state_LangLa_kw().d.length() <= 0 || beatdz.LangLa_kw.$state_LangLa_kw().d.equals(var1.c) || beatdz.LangLa_kw.$state_LangLa_kw().d.equals(var1.b)) {
            Vector var5 = mFont.a(mFont.c, var2, this.i.width - 19);
            Utlis.addAll(this.g, var5);

            for(var6 = 0; var6 < var5.size(); ++var6) {
               if (((String)var5.elementAt(var6)).contains("c#item")) {
                  this.h.addElement(var1.f);
               }
            }
         }

         if (this.k == 1) {
            if (beatdz.LangLa_kw.$state_LangLa_kw().d.equals(Caption.dy) || var1.c.equals(beatdz.LangLa_kw.$state_LangLa_kw().d) || var1.b.equals(beatdz.LangLa_kw.$state_LangLa_kw().d)) {
               var1.e = true;
            }
         } else {
            var1.e = true;
         }

         if (var1.c.length() > 0) {
            if (!var3.contains(var1.c) && !var1.c.equals(Char.gI().name)) {
               var3.addElement(var1.c);
               this.c.addElement(new LangLa_lk(0, var1.c));
            }

            if (!var3.contains(var1.b) && !var1.b.equals(Char.gI().name)) {
               var3.addElement(var1.b);
               this.c.addElement(new LangLa_lk(0, var1.b));
            }
         }
      }

      this.j.a(this.j.g, this.j.h, this.c.size());
      this.i.a(this.i.g, this.i.h, this.g.size());

      for(var4 = 0; var4 < this.c.size(); ++var4) {
         LangLa_lk var8 = (LangLa_lk)this.c.elementAt(var4);
         int var7 = 0;

         for(var6 = 0; var6 < beatdz.LangLa_kw.$state_LangLa_kw().a[this.k].a.size(); ++var6) {
            if (!(var1 = (LangLa_fa)beatdz.LangLa_kw.$state_LangLa_kw().a[this.k].a.elementAt(var6)).e && (var6 == 0 && var1.c.length() == 0 || var1.b.equals(var8.b) || var1.c.equals(var8.b))) {
               ++var7;
            }
         }

         var8.a = var7;
      }

   }

   public short d() {
      short var1 = 0;

      for(int var3 = 0; var3 < beatdz.LangLa_kw.$state_LangLa_kw().a[this.k].a.size(); ++var3) {
         if (!((LangLa_fa)beatdz.LangLa_kw.$state_LangLa_kw().a[this.k].a.elementAt(var3)).e) {
            ++var1;
         }
      }

      return var1;
   }

   public void a(Graphics var1) {
      try {
         if (!this.v) {
            int var2 = var1.a;
            int var3 = var1.b;
            int var4 = -1;
            if (this.m > 0) {
               --this.m;
            }

            String var5;
            int var6;
            int var11;
            if (!(this.s instanceof LangLa_ko)) {
               for(var6 = 0; var6 < this.g.size(); ++var6) {
                  var5 = (String)this.g.elementAt(var6);
                  if (this.m == 0 && var5.contains("c#select")) {
                     var5 = var5.replaceAll("c#select", "");
                     this.g.set(var6, var5);
                  }
               }

               var11 = 1;

               boolean var10000;
               label146:
               while(true) {
                  if (var11 >= beatdz.LangLa_kw.$state_LangLa_kw().a.length) {
                     var10000 = false;
                     break;
                  }

                  for(var6 = 0; var6 < beatdz.LangLa_kw.$state_LangLa_kw().a[var11].a.size(); ++var6) {
                     if (!((LangLa_fa)beatdz.LangLa_kw.$state_LangLa_kw().a[var11].a.elementAt(var6)).e) {
                        var10000 = true;
                        break label146;
                     }
                  }

                  ++var11;
               }

               if (var10000) {
                  LangLa_fq.a(var1, 713, 0, -2, -4, 3);
               }

               if (this.i.f != this.i.c || this.cP != null && this.cP.b != -1 || this.n < 3 || this.o) {
                  this.a(var1, this.i);
                  if ((var6 = this.g.size() - 2) < 0) {
                     var6 = 0;
                  }

                  for(int var7 = this.g.size() - 1; var7 >= var6; --var7) {
                     var5 = (String)this.g.elementAt(var7);
                     if (this.i.b(var7)) {
                        var4 = mFont.c(mFont.c, var1, var5, 5, this.f / 2 + var7 * this.f, 20, var4, -16777216);
                     }
                  }

                  this.b(var1);
               }
            } else {
               this.a(var1, 0, -3, this.width, this.height + 6, -22, 84, 5, 1, 1);
               this.a(var1, this.i);

               for(var6 = 0; var6 < this.g.size(); ++var6) {
                  var5 = (String)this.g.elementAt(var6);
                  if (this.i.b(var6)) {
                     var4 = mFont.c(mFont.c, var1, var5, 5, 8 + var6 * 16, 20, var4, -16777216);
                  }

                  if (this.m == 0 && var5.contains("c#select")) {
                     var5 = var5.replaceAll("c#select", "");
                     this.g.set(var6, var5);
                  }
               }

               this.b(var1);
               this.i.b(var1, -var2 - 15, -var3 - 8);
            }

            if (this.k == 1) {
               this.a(var1, var2, var3);
               Binary2.a(var1, 646, -90, this.j.cx - 2, this.j.cy - 2, 20, (int)(this.height + 4));
               var1.f(13136426);
               var1.c(this.j.cx + 1, this.j.cy - 2, this.j.width - 3, this.j.height + 3);
               this.a(var1, this.j);

               for(var6 = 0; var6 < this.c.size(); ++var6) {
                  if (this.j.b(var6)) {
                     LangLa_lk var12;
                     String var10 = (var12 = (LangLa_lk)this.c.elementAt(var6)).b;
                     var11 = 5;
                     int var8 = 8 + var6 * 16;
                     if (var6 == this.j.l && !this.j.o) {
                        ++var11;
                        ++var8;
                     }

                     if (var10.equals(beatdz.LangLa_kw.$state_LangLa_kw().d)) {
                        mFont.c(mFont.e, var1, var10 + (var12.a > 0 ? " (" + var12.a + ")" : ""), var11, var8, 20, -2560, -10275328);
                     } else {
                        mFont.c(mFont.e, var1, var10 + (var12.a > 0 ? " (" + var12.a + ")" : ""), var11, var8, 20, -6488, -10275328);
                     }

                     if (var6 == this.j.l && this.j.o) {
                        var1.e(30);
                        LangLa_fq.a(var1, 288, 0, this.j.width - 5 + 1, 8 + var6 * 16 + 1, 10);
                        var1.d();
                     } else {
                        LangLa_fq.a(var1, 288, 0, this.j.width - 5, 8 + var6 * 16, 10);
                     }
                  }
               }

               this.b(var1);
               this.a(var1, var2, var3);
            }

         }
      } catch (Exception var9) {
         Utlis.println(var9);
      }
   }

   public void b() {
      this.j.a();
      this.i.a();
   }

   public Vector c() {
      Vector var1 = new Vector();
      if (this.v) {
         return var1;
      } else if (!(this.s instanceof LangLa_ko)) {
         var1.add(new LangLa_jz(5011, 0, 0, this.width, this.height, (LangLa_ii)null, this));
         return var1;
      } else {
         int var2;
         for(var2 = 0; var2 < this.c.size(); ++var2) {
            if (this.j.b(var2)) {
               LangLa_lk var3 = (LangLa_lk)this.c.elementAt(var2);
               LangLa_jz var4 = new LangLa_jz(5009, this.j.cx + this.j.width - 18, var2 * 16 - this.j.f, this.j.cx + this.j.width, var2 * 16 + 16 - this.j.f, this.j, this, new LangLa_lk(0, var3.b));
               if (Utlis.inRange(this.j.cx, this.j.cy, this.j.cx + this.j.width, this.j.cy + this.j.height, var4.a(), var4.b())) {
                  var1.addElement(var4);
               }
            }
         }

         var2 = -1;

         for(int var5 = 0; var5 < this.g.size(); ++var5) {
            String var6;
            LangLa_je var7;
            if ((var6 = (String)this.g.elementAt(var5)).contains(":-")) {
               var6 = var6.split(": ")[0];
               var7 = LangLa_fw.c(var6 = "c#" + var6.split(" c#")[1]);
               if (!(var6 = var6.substring(var7.d.length(), var6.length())).equals(Caption.dz) && !var6.equals(Caption.dx) && !var6.equals(Caption.dA) && !var6.equals(Char.gI().name)) {
                  LangLa_jz var11 = new LangLa_jz(5008, 20, var5 * 16 - this.i.f, 23 + mFont.b(mFont.d, var6), var5 * 16 + 16 - this.i.f, this.i, this, new LangLa_lk(0, var6));
                  if (this.i.b(var5) && Utlis.inRange(this.i.cx, this.i.cy, this.i.cx + this.i.width, this.i.cy + this.i.height, var11.a(), var11.b())) {
                     var1.addElement(var11);
                  }
               }
            }

            if ((var6 = (String)this.g.elementAt(var5)).contains("c#item")) {
               ++var2;
               String[] var12 = var6.split("c#item");
               int var8 = this.i.cx + 3 + mFont.c(mFont.d, var12[0]);
               int var10 = this.i.cy + var5 * this.i.h - this.i.f;
               if ((var7 = LangLa_fw.e(var6 = var12[1])) != null) {
                  var6 = var6.split(var7.d)[0].trim();
               }

               LangLa_jz var9 = new LangLa_jz(5010, var8, var10, var8 + mFont.c(mFont.d, var6) + 2, var10 + this.i.h, this.i, this, new LangLa_lk(var2, var6));
               if (this.i.b(var5) && Utlis.inRange(this.i.cx, this.i.cy, this.i.cx + this.i.width, this.i.cy + this.i.height, var9.a(), var9.b())) {
                  var1.addElement(var9);
               }
            }
         }

         var1.addElement(this.j.a(5007, this));
         var1.addElement(this.i.a(this.l, this));
         return var1;
      }
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      if (!this.v) {
         int var4;
         switch(var1.b) {
         case 2001:
            String var11 = beatdz.LangLa_kw.$state_LangLa_kw().d;
            LangLa_kw var10 = this;

            for(var3 = 0; var3 < var10.c.size() && !((LangLa_lk)var10.c.elementAt(var3)).b.equals(var11); ++var3) {
            }

            --var3;
            if (var3 < 0) {
               var3 = 0;
            }

            for(var4 = beatdz.LangLa_kw.$state_LangLa_kw().a[var10.k].a.size() - 1; var4 >= 0; --var4) {
               LangLa_fa var14;
               if ((var14 = (LangLa_fa)beatdz.LangLa_kw.$state_LangLa_kw().a[var10.k].a.elementAt(var4)).b.equals(var11) || var14.c.equals(var11)) {
                  beatdz.LangLa_kw.$state_LangLa_kw().a[var10.k].a.remove(var14);
               }
            }

            var10.a(var3);
            return;
         case 5007:
            if (var1.j.k >= 0) {
               this.a(var1.j.k);
               return;
            }
            break;
         case 5008:
            if (var1.j.k >= 0) {
               int var10001 = this.cx + var2;
               int var10002 = this.cy + var3;
               LangLa_lk var5 = (LangLa_lk)var1.k;
               var4 = var1.j.k;
               var3 = var10002;
               var2 = var10001;
               String var6 = ((String)this.g.elementAt(var4)).replaceAll(var5.b, "c#select" + var5.b);
               this.g.set(var4, var6);
               this.m = 6;
               beatdz.LangLa_kw.$state_LangLa_kw().e = var5;
               Vector var12 = new Vector();
               if (!GameSrc.gI().k(var5.b)) {
                  var12.addElement(new LangLa_lk(6004, Caption.dD));
               }

               if (GameSrc.gI().aI != null && !GameSrc.gI().aI.b()) {
                  if (GameSrc.gI().aI.a() && !GameSrc.gI().aI.a(var5.b)) {
                     var12.addElement(new LangLa_lk(6008, Caption.dF));
                  }
               } else {
                  var12.addElement(new LangLa_lk(6008, Caption.dE));
               }

               var12.addElement(new LangLa_lk(6005, Caption.dG));
               var12.addElement(new LangLa_lk(6006, Caption.cl));
               var12.addElement(new LangLa_lk(6007, Caption.db));
               if (var12.size() > 0) {
                  String[] var13 = new String[var12.size()];
                  short[] var15 = new short[var12.size()];

                  for(int var7 = 0; var7 < var12.size(); ++var7) {
                     LangLa_lk var8 = (LangLa_lk)var12.elementAt(var7);
                     var13[var7] = var8.b;
                     var15[var7] = (short)var8.a;
                  }

                  this.s.cL = a(this.s, var2 + 25, var3, new LangLa_kd(0, var15, var13));
               }

               return;
            }
            break;
         case 5009:
            this.a(((LangLa_lk)var1.k).b);
            DataCenter.gI().currentScreen.a(Caption.dB + ((LangLa_lk)var1.k).b + Caption.dC, 2001, this);
            return;
         case 5010:
            if (var1.j.k >= 0) {
               this.a(this.cx + var2, this.cy + var3, var1.j.k, (LangLa_lk)var1.k);
               return;
            }
            break;
         case 5011:
            LangLa_dp.a().h();
            GameSrc var9;
            (var9 = GameSrc.gI()).a((LangLa_cx)(new LangLa_kq(var9, var9.ai.e())));
         }

      }
   }

   private void a(int var1, int var2, int var3, LangLa_lk var4) {
      try {
         LangLa_gl var5;
         if ((var5 = (LangLa_gl)this.h.elementAt(var4.a)) != null) {
            LangLa_cx var10000 = this.s;
            boolean var7 = false;
            LangLa_cx var8 = this.s;
            LangLa_mq var10001;
            if (var5 == null) {
               var10001 = null;
            } else {
               LangLa_mk var11;
               if ((var11 = new LangLa_mk(var1, var2, 1044, var8, var5)).cx > DataCenter.gI().widthScreen - var11.width - var8.cx) {
                  var11.cx = (short)(DataCenter.gI().widthScreen - var11.width - var8.cx);
               }

               if (var11.cx < var1 - 0) {
                  var11.cx = (short)(var1 - (var11.width + 3));
               }

               if (var11.cx < -var8.cx) {
                  var11.cx = (short)(-var8.cx);
               }

               if (var11.cy > DataCenter.gI().heightScreen - var11.height - var8.cy) {
                  var11.cy = (short)(DataCenter.gI().heightScreen - var11.height - var8.cy);
               }

               LangLa_mq var10 = new LangLa_mq(var1 - 32, var2 + 32, var11);
               var8.a(var10);
               var10001 = var10;
            }

            var10000.cL = var10001;
            var2 = -1;
            var3 = 0;

            while(true) {
               if (var3 >= this.g.size()) {
                  return;
               }

               String var9;
               if ((var9 = (String)this.g.elementAt(var3)).contains("c#item")) {
                  ++var2;
                  if (var2 == var4.a) {
                     this.m = 6;
                     var9 = var9.replaceAll(var4.b, "c#select" + var4.b);
                     this.g.set(var3, var9);
                     break;
                  }
               }

               ++var3;
            }
         } else if (!var4.b.trim().equalsIgnoreCase(Char.gI().name.trim())) {
            this.b(var1, var2, var3, var4);
         }

      } catch (Exception var6) {
         Utlis.println(var6);
      }
   }

   private void b(int var1, int var2, int var3, LangLa_lk var4) {
      String var5 = ((String)this.g.elementAt(var3)).replaceAll(var4.b, "c#select" + var4.b);
      this.g.set(var3, var5);
      this.m = 6;
      beatdz.LangLa_kw.$state_LangLa_kw().e = var4;
      Vector var8;
      (var8 = new Vector()).addElement(new LangLa_lk(6007, Caption.db));
      if (var8.size() > 0) {
         String[] var9 = new String[var8.size()];
         short[] var10 = new short[var8.size()];

         for(int var6 = 0; var6 < var8.size(); ++var6) {
            LangLa_lk var7 = (LangLa_lk)var8.elementAt(var6);
            var9[var6] = var7.b;
            var10[var6] = (short)var7.a;
         }

         this.s.cL = a(this.s, var1 + 25, var2, new LangLa_kd(0, var10, var9));
      }

   }

   public void e() {
      this.i.j = this.i.i;
      this.i.d();
      LangLa_ii var1;
      (var1 = this.i).c = var1.j * var1.h;
      if (var1.c < var1.d) {
         var1.c = var1.d;
      }

      if (var1.c > var1.e) {
         var1.c = var1.e;
      }

      var1.f = var1.c;
   }

   private void a(int var1) {
      try {
         beatdz.LangLa_kw.$state_LangLa_kw().d = ((LangLa_lk)this.c.elementAt(var1)).b;
      } catch (Exception var3) {
         beatdz.LangLa_kw.$state_LangLa_kw().d = "";
      }

      this.a();
      if (this.s instanceof LangLa_ko) {
         LangLa_ko var4;
         (var4 = (LangLa_ko)this.s).j.b.d[var4.j.b.b] = this.d();
         if (var4.s.a) {
            this.e();
         }
      }

   }

   public void a(String var1) {
      beatdz.LangLa_kw.$state_LangLa_kw().d = var1;
      this.a();
      if (this.s instanceof LangLa_ko) {
         LangLa_ko var3;
         (var3 = (LangLa_ko)this.s).j.b.d[var3.j.b.b] = this.d();
         if (var3.s.a) {
            this.e();
         }
      }

   }

   

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public LangLa_ew[] a;
public byte[] b;
public String d;
public LangLa_lk e;
public String p;
public void initialize() {
this.a = new LangLa_ew[5];
this.b = new byte[9];
this.d = "";
{
      for(int var0 = 0; var0 < this.a.length; ++var0) {
         this.a[var0] = new LangLa_ew();
      }

      this.p = "";
   }
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.LangLa_kw");
public static SessionState $state_LangLa_kw() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
