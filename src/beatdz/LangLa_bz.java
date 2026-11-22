package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_bz extends LangLa_fo {
   private LangLa_gx d;
   private LangLa_ii[] e;
   private LangLa_lk[][] f;
   private Item g = null;
   private LangLa_dz h;
   public Vector a = new Vector();
   public Vector b = new Vector();
   public int[] c;

   public LangLa_bz(MainScreen var1, Message var2) {
      try {
         this.c = new int[DataCenter.gI().DataTemplateAchievement.length];

         for(int var3 = 0; var3 < this.c.length; ++var3) {
            this.c[var3] = var2.reader.dis.readUnsignedShort();
         }
      } catch (Exception var5) {
      }

      this.p = var1;
      this.r = false;
      this.a(280, 200);
      LangLa_kd var6;
      (var6 = new LangLa_kd(1001)).c = Caption.sm;
      this.d = new LangLa_gx(var6, this.width, 1, this.a_() - 3, 87, this.G() + 6, 33, this);
      this.e = new LangLa_ii[3];
      this.e[0] = new LangLa_ii((byte)1, this.d.c() + 5, this.a_() + 10, super.width - 8 - 96, this.height - 54, 15, 0);
      this.e[1] = new LangLa_ii((byte)1, this.d.c() + 5, this.a_() + 10, super.width - 8 - 96, this.height - 54, 15, 0);
      this.e[2] = new LangLa_ii((byte)1, this.d.c() + 5, this.a_() + 10, super.width - 8 - 96, this.height - 54, 15, 0);
      DataCenter.gI();
      this.h = this.a(this.width - 84, this.height - 36, Caption.iS, this, 1012, 15);
      this.f = new LangLa_lk[3][];
      this.d.a((LangLa_cs)this.h, 0);
      this.e();
      this.f();
      this.g();
      this.d.a(GameSrc.gI().bT);
   }

   public void e() {
      this.a.clear();
      this.h.v = true;
      Vector var1 = new Vector();
      Vector var2 = new Vector();
      int var5;
      if (GameSrc.gI().Task >= DataCenter.gI().Task.length) {
         var2.addElement("c#white" + Caption.iT);
      } else {
         Task var3 = DataCenter.gI().Task[GameSrc.gI().Task];
         var2.addElement("c#yellow" + Caption.iU + "c#white" + var3.name);
         NpcTemplate var4 = DataCenter.gI().NpcTemplate[var3.idNpc];
         if (GameSrc.gI().idStep < 0) {
            var2.addElement("c#white" + Caption.iV + "c#task" + var4.name + "c#white" + Caption.iL);
            this.a.addElement(new LangLa_eo(var3.idNpc, -1, -1, var3.idMap, var3.x, var3.y));
         } else {
            this.h.v = false;
            if (Char.gI().level() < var3.levelNeed) {
               var2.addElement("c#red" + Caption.iW + var3.levelNeed);
            } else {
               var2.addElement("c#white" + Caption.iW + var3.levelNeed);
            }

            for(var5 = 0; var5 < var3.vStep.size(); ++var5) {
               Step var6;
               String var7 = (var6 = (Step)var3.vStep.elementAt(var5)).name;
               if (var6.require <= 1) {
                  if (GameSrc.gI().idStep == var5) {
                     var2.addElement("c#green" + "  - c#task" + var7);
                     this.a.addElement(new LangLa_eo(var6.idNpc, var6.b(), var6.idMob, var6.idMap, var6.x, var6.y));
                  } else {
                     var2.addElement("c#white" + "  - " + var7);
                  }
               } else if (Char.gI().level() >= var3.levelNeed) {
                  if (GameSrc.gI().idStep == var5) {
                     var2.addElement("c#green" + "  - c#task" + var6.name + " " + GameSrc.gI().idRequire + "/" + var6.require);
                     this.a.addElement(new LangLa_eo(var6.idNpc, var6.b(), var6.idMob, var6.idMap, var6.x, var6.y));
                  } else if (GameSrc.gI().idStep > var5) {
                     var2.addElement("c#white" + "  - " + var6.name + " " + var6.require + "/" + var6.require);
                  } else {
                     var2.addElement("c#white" + "  - " + var6.name + " 0/" + var6.require);
                  }
               } else {
                  var2.addElement("c#white" + "  - " + var6.name + " 0/" + var6.require);
               }
            }

            if (GameSrc.gI().idStep >= var3.vStep.size()) {
               var2.addElement("c#white" + Caption.iX + "c#task" + var4.name + "c#white" + Caption.iP);
               this.a.addElement(new LangLa_eo(var3.idNpc, -1, -1, var3.idMap, var3.x, var3.y));
            } else if (var3.STR3.length() > 0) {
               var2.addElement("c#white" + var3.STR3);
            }

            if (GameSrc.gI().Task < DataCenter.gI().Task.length && GameSrc.gI().idStep >= 0) {
               Item var13;
               if (var3.amountExp > 0) {
                  (var13 = new Item(190)).setAmount(var3.amountExp);
                  var13.isLock = true;
                  var1.add(var13);
               }

               if (var3.amountVangKhoa > 0) {
                  (var13 = new Item(192)).setAmount(var3.amountVangKhoa);
                  var13.isLock = true;
                  var1.add(var13);
               }

               if (var3.amountBac > 0) {
                  (var13 = new Item(191)).setAmount(var3.amountBac);
                  var1.add(var13);
               }

               if (var3.amountBacKhoa > 0) {
                  (var13 = new Item(163)).setAmount(var3.amountBacKhoa);
                  var13.isLock = true;
                  var1.add(var13);
               }

               if ((var13 = var3.a()) != null) {
                  var1.add(var13);
               }

               if (var1.size() > 0) {
                  var2.addElement("c#blue" + Caption.iZ + "\n===\n");
               }
            }
         }
      }

      Vector var10 = new Vector();
      var5 = -1;

      int var14;
      for(var14 = 0; var14 < var2.size(); ++var14) {
         String var11;
         if ((var11 = String.valueOf(var2.elementAt(var14))).contains("c#task")) {
            ++var5;
         }

         Vector var15 = mFont.a(mFont.d, var11, this.e[0].width - 8);
         int var8 = 0;

         for(int var9 = 0; var9 < var15.size(); ++var9) {
            if ((var11 = (String)var15.elementAt(var9)).contains("c#task")) {
               ++var8;
            }

            if (var11.contains("===")) {
               var10.add(new LangLa_lk(1, "", var1));
            } else {
               var10.add(new LangLa_lk(1, var11));
            }
         }

         if (var8 > 1) {
            LangLa_eo var16 = (LangLa_eo)this.a.elementAt(var5);

            for(int var12 = 1; var12 < var8; ++var12) {
               this.a.insertElementAt(var16, var5);
               ++var5;
            }
         }
      }

      this.f[0] = new LangLa_lk[var10.size()];

      for(var14 = 0; var14 < var10.size(); ++var14) {
         this.f[0][var14] = (LangLa_lk)var10.elementAt(var14);
      }

      DataCenter.gI();
      this.e[0] = new LangLa_ii((byte)1, this.d.c() + 5, this.a_() + 10, super.width - 8 - 96, 120, 15, this.f[0].length + 3);
   }

   public void f() {
      this.b.clear();
      Vector var1;
      LangLa_mg.a(var1 = new Vector(), this.b, Caption.iU);
      var1.addElement("");
      LangLa_mg.b(var1, this.b, Caption.iU);
      var1.addElement("");
      LangLa_mg.c(var1, this.b, Caption.iU);
      var1.addElement("");
      if (LangLa_mg.d(var1, this.b, Caption.iU)) {
         var1.addElement("");
      }

      if (LangLa_mg.e(var1, this.b, Caption.iU)) {
         var1.addElement("");
      }

      if (LangLa_mg.f(var1, this.b, Caption.iU)) {
         var1.addElement("");
      }

      Vector var2 = new Vector();
      int var4 = -1;

      int var5;
      for(var5 = 0; var5 < var1.size(); ++var5) {
         String var3;
         if ((var3 = String.valueOf(var1.elementAt(var5))).contains("c#task")) {
            ++var4;
         }

         Vector var6 = mFont.a(mFont.d, var3, this.e[1].width - 8);
         int var7 = 0;

         for(int var8 = 0; var8 < var6.size(); ++var8) {
            if ((var3 = (String)var6.elementAt(var8)).contains("c#task")) {
               ++var7;
            }

            var2.add(new LangLa_lk(1, var3));
         }

         if (var7 > 1) {
            LangLa_eo var10 = (LangLa_eo)this.b.elementAt(var4);

            for(int var9 = 1; var9 < var7; ++var9) {
               this.b.insertElementAt(var10, var4);
               ++var4;
            }
         }
      }

      this.f[1] = new LangLa_lk[var2.size()];

      for(var5 = 0; var5 < var2.size(); ++var5) {
         this.f[1][var5] = (LangLa_lk)var2.elementAt(var5);
      }

      DataCenter.gI();
      this.e[1] = new LangLa_ii((byte)1, this.d.c() + 5, this.a_() + 10, super.width - 8 - 96, 135, 15, this.f[1].length);
   }

   private void g() {
      Vector var1 = new Vector();
      Vector var2 = new Vector();

      for(int var3 = 0; var3 < DataCenter.gI().DataTemplateAchievement.length; ++var3) {
         int var4 = this.c[var3];
         Vector var5 = new Vector();
         Item var6;
         if (DataCenter.gI().DataTemplateAchievement[var3].amountExp > 0) {
            (var6 = new Item(190)).setAmount(DataCenter.gI().DataTemplateAchievement[var3].amountExp);
            var6.isLock = true;
            var5.add(var6);
         }

         if (DataCenter.gI().DataTemplateAchievement[var3].amountVangKhoa > 0) {
            (var6 = new Item(192)).setAmount(DataCenter.gI().DataTemplateAchievement[var3].amountVangKhoa);
            var6.isLock = true;
            var5.add(var6);
         }

         if (DataCenter.gI().DataTemplateAchievement[var3].amountBac > 0) {
            (var6 = new Item(191)).setAmount(DataCenter.gI().DataTemplateAchievement[var3].amountBac);
            var5.add(var6);
         }

         if (DataCenter.gI().DataTemplateAchievement[var3].amountBacKhoa > 0) {
            (var6 = new Item(163)).setAmount(DataCenter.gI().DataTemplateAchievement[var3].amountBacKhoa);
            var6.isLock = true;
            var5.add(var6);
         }

         if ((var6 = DataCenter.gI().DataTemplateAchievement[var3].a()) != null) {
            var5.add(var6);
         }

         String var7 = "";
         if (var4 >= DataCenter.gI().DataTemplateAchievement[var3].c) {
            var4 = DataCenter.gI().DataTemplateAchievement[var3].c;
            var7 = var7 + "c#yellow- " + DataCenter.gI().DataTemplateAchievement[var3].name;
         } else {
            var7 = var7 + "c#white- " + DataCenter.gI().DataTemplateAchievement[var3].name;
         }

         if (DataCenter.gI().DataTemplateAchievement[var3].c > 1) {
            var7 = var7 + " " + var4 + "/" + DataCenter.gI().DataTemplateAchievement[var3].c;
         }

         if (var5.size() > 0) {
            var7 = var7 + "\nc#blue" + Caption.iZ + "\n===\n";
            var2.add(var5);
         }

         var1.add(var7);
      }

      Vector var8 = new Vector();

      int var11;
      for(var11 = 0; var11 < var1.size(); ++var11) {
         String var9 = String.valueOf(var1.elementAt(var11));
         Vector var12 = mFont.a(mFont.d, var9, this.e[1].width - 8);

         for(int var10 = 0; var10 < var12.size(); ++var10) {
            if ((var9 = (String)var12.elementAt(var10)).contains("===")) {
               var8.add(new LangLa_lk(1, "", (Vector)var2.remove(0)));
            } else {
               var8.add(new LangLa_lk(1, var9));
            }
         }
      }

      this.f[2] = new LangLa_lk[var8.size()];

      for(var11 = 0; var11 < var8.size(); ++var11) {
         this.f[2][var11] = (LangLa_lk)var8.elementAt(var11);
      }

      DataCenter.gI();
      this.e[2] = new LangLa_ii((byte)1, this.d.c() + 5, this.a_() + 10, super.width - 8 - 96, 135, 15, this.f[2].length);
   }

   public void a(int var1, Object var2, LangLa_cy var3) {
   }

   public void a(int var1, Object var2) {
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      super.a(var1, var2, var3);
      if (var1.b >= 3000 && var1.b < 3010) {
         var2 = var1.b - 3000;
         LangLa_bz var6 = this;

         try {
            Vector var8 = var6.a;
            LangLa_eo var7;
            if (var6.d.b.b == 1) {
               beatdz.LangLa_mg.$state_LangLa_mg().d = (var7 = (LangLa_eo)var6.b.elementAt(var2)).i;
            } else {
               var7 = (LangLa_eo)var8.elementAt(var2);
            }

            LangLa_dp.a().h();
            LangLa_gx var10001 = var6.d;
            GameSrc.gI().ak.c(var10001.b.b != 0);
            if (var7.a >= 0) {
               GameSrc.gI();
               GameSrc.a(var7);
               if (var7.d < 0) {
                  GameSrc.gI();
                  GameSrc.c(var7);
               }
            }

            if (var7.d != -2) {
               GameSrc.gI().b(var7.a());
               var6.J();
            }

         } catch (Exception var5) {
            Utlis.println(var5);
         }
      } else {
         this.g = null;
         switch(var1.b) {
         case 1001:
            if (var1.j.k >= 0) {
               this.d.a(var1.j.k);
               return;
            }
            break;
         case 1012:
            if (GameSrc.gI().Task == 11) {
               j();
               return;
            }

            DataCenter.gI().currentScreen.a(Caption.iY, 2001, this);
            return;
         case 2001:
            j();
            return;
         case 5000:
            this.g = (Item)var1.k;
            this.cL = a(this, var2, var3, 28, this.g);
         }

      }
   }

   public void a(Graphics var1) {
      this.a(var1, this.cx, this.cy, this.width, this.height, Caption.D, (byte)2, this.r);
      this.d.a((Graphics)var1, -11);
      GameSrc.gI().bT = (byte)this.d.b.b;
      LangLa_bz var2;
      Graphics var3;
      int var4;
      int var5;
      Item var6;
      switch(this.d.b.b) {
      case 0:
         var3 = var1;
         var2 = this;
         this.a(var1, this.e[this.d.b.b]);

         for(var4 = 0; var4 < var2.f[var2.d.b.b].length; ++var4) {
            if (var2.e[var2.d.b.b].b(var4)) {
               mFont.c(mFont.d, var3, var2.f[var2.d.b.b][var4].b, 6, var4 * var2.e[var2.d.b.b].h + var2.e[var2.d.b.b].h / 2, 0, -1, -16777216);
               if (var2.f[var2.d.b.b][var4].c != null) {
                  for(var5 = 0; var5 < var2.f[var2.d.b.b][var4].c.size(); ++var5) {
                     var6 = (Item)var2.f[var2.d.b.b][var4].c.get(var5);
                     b(var3, 4 + var5 * 35, var4 * var2.e[var2.d.b.b].h, var6, var2.g != null && var2.g.equals(var6));
                  }
               }
            }
         }

         var2.b(var3);
         var2.e[var2.d.b.b].b(var3, -12, -13);
         break;
      case 1:
         var3 = var1;
         var2 = this;
         this.a(var1, this.e[this.d.b.b]);

         for(var4 = 0; var4 < var2.f[var2.d.b.b].length; ++var4) {
            if (var2.e[var2.d.b.b].b(var4)) {
               mFont.c(mFont.d, var3, var2.f[var2.d.b.b][var4].b, 6, var4 * var2.e[var2.d.b.b].h + var2.e[var2.d.b.b].h / 2, 0, -1, -16777216);
            }
         }

         var2.b(var3);
         var2.e[var2.d.b.b].b(var3, -12, -13);
         break;
      case 2:
         var3 = var1;
         var2 = this;
         this.a(var1, this.e[this.d.b.b]);

         for(var4 = 0; var4 < var2.f[var2.d.b.b].length; ++var4) {
            if (var2.e[var2.d.b.b].b(var4)) {
               mFont.c(mFont.d, var3, var2.f[var2.d.b.b][var4].b, 6, var4 * var2.e[var2.d.b.b].h + var2.e[var2.d.b.b].h / 2, 0, -1, -16777216);
               if (var2.f[var2.d.b.b][var4].c != null) {
                  for(var5 = 0; var5 < var2.f[var2.d.b.b][var4].c.size(); ++var5) {
                     var6 = (Item)var2.f[var2.d.b.b][var4].c.get(var5);
                     b(var3, 4 + var5 * 35, var4 * var2.e[var2.d.b.b].h, var6, var2.g != null && var2.g.equals(var6));
                  }
               }
            }
         }

         var2.b(var3);
         var2.e[var2.d.b.b].b(var3, -12, -13);
      }

      this.a(var1, this.cx, this.cy);
      var1.clean();
   }

   public void b() {
      this.d.a();

      for(int var1 = 0; var1 < this.e.length; ++var1) {
         this.e[var1].a();
      }

      if (GameSrc.gI().Task == 0 && GameSrc.gI().idStep == -1 && GameSrc.gI().idRequire == 0 && this.d.b.b == 0) {
         int var10001 = this.cx + 190;
         DataCenter.gI().aO.a(var10001, this.cy + 70);
         DataCenter.gI().aO.a = true;
      }

   }

   public Vector c() {
      Vector var1;
      (var1 = super.c()).addElement(this.d.b());
      int var4 = -1;

      int var2;
      int var3;
      int var5;
      for(var5 = 0; var5 < this.f[this.d.b.b].length; ++var5) {
         String var6;
         if ((var6 = this.f[this.d.b.b][var5].b).contains("c#task")) {
            ++var4;
            String[] var7 = var6.split("c#task");
            var2 = this.e[this.d.b.b].cx + 5 + mFont.c(mFont.d, var7[0]);
            var3 = this.e[this.d.b.b].cy + var5 * this.e[this.d.b.b].h - this.e[this.d.b.b].f;
            LangLa_je var10;
            if ((var10 = LangLa_fw.e(var6 = var7[1])) != null) {
               var6 = var6.split(var10.d)[0];
            }

            LangLa_jz var9 = new LangLa_jz(3000 + var4, var2, var3, var2 + mFont.b(mFont.d, var6), var3 + this.e[this.d.b.b].h, this.e[this.d.b.b], this, new LangLa_lk(0, var6));
            if (this.e[this.d.b.b].b(var5) && Utlis.inRange(this.e[this.d.b.b].cx, this.e[this.d.b.b].cy, this.e[this.d.b.b].cx + this.e[this.d.b.b].width, this.e[this.d.b.b].cy + this.e[this.d.b.b].height, var9.a(), var9.b())) {
               var1.addElement(var9);
            }
         }
      }

      if (this.d.b.b == 0 && GameSrc.gI().Task < DataCenter.gI().Task.length && GameSrc.gI().idStep >= 0 || this.d.b.b == 2) {
         var1.addElement(new LangLa_jz(1100, this.e[this.d.b.b].cx, this.e[this.d.b.b].cy - 11, this.e[this.d.b.b].cx + this.e[this.d.b.b].width, this.e[this.d.b.b].cy, (LangLa_ii)null, this));
         var1.addElement(new LangLa_jz(1100, this.e[this.d.b.b].cx, this.e[this.d.b.b].cy + this.e[this.d.b.b].height, this.e[this.d.b.b].cx + this.e[this.d.b.b].width, this.e[this.d.b.b].cy + this.e[this.d.b.b].height + 50, (LangLa_ii)null, this));

         for(var5 = 0; var5 < this.f[this.d.b.b].length; ++var5) {
            if (this.f[this.d.b.b][var5].c != null && this.e[this.d.b.b].b(var5)) {
               var2 = this.e[this.d.b.b].cx + 4;
               var3 = this.e[this.d.b.b].cy + var5 * this.e[this.d.b.b].h - this.e[this.d.b.b].f;

               for(int var11 = 0; var11 < this.f[this.d.b.b][var5].c.size(); ++var11) {
                  Item var12 = (Item)this.f[this.d.b.b][var5].c.get(var11);
                  LangLa_jz var13 = new LangLa_jz(5000, var2, var3, var2 + 28, var3 + 28, this.e[this.d.b.b], this, var12);
                  var1.addElement(var13);
                  var2 += 35;
               }
            }
         }
      }

      var1.addElement(this.e[this.d.b.b].a(1100, this));
      return var1;
   }

   private static void j() {
      try {
         (new Message((byte)9)).send();
      } catch (Exception var1) {
         Utlis.println(var1);
      }
   }
}
