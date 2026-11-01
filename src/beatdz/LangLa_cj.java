package beatdz;import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Blending;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.tgame.model.Caption;
import java.math.BigDecimal;
import java.util.Vector;

public class LangLa_cj extends LangLa_cz {
   public Vector a = new Vector();
   public Vector b;
   public Vector c;
   public boolean d = true;
   private boolean m = false;
   public boolean e;
   public LangLa_jb f;
   public LangLa_jb g;
   private LangLa_jb n;
   private LangLa_jb o;
   public short h;
   public short i;
   private LangLa_cx p;
   private byte q;
   private byte r;
   public byte j;
   private int s;
   private int t;
   private int u;
   private int v;
   private int w;
   private int x;
   private int y;
   private int z;
   private int A;
   private int B;
   private int C;
   private boolean D;
   public boolean k;
   

   public LangLa_cj(LangLa_cx var1, byte var2, int var3) {
      this.f = new LangLa_jb(this, (byte)2, this.width);
      this.g = new LangLa_jb(this, (byte)3, this.height);
      this.p = var1;
      this.q = var2;
      this.r = (byte)var3;
   }

   public LangLa_cj(LangLa_cx var1, byte var2) {
      this.f = new LangLa_jb(this, (byte)2, this.width);
      this.g = new LangLa_jb(this, (byte)3, this.height);
      this.p = var1;
      this.q = 2;
   }

   public void a(int var1, int var2, boolean var3) {
      this.D = var3;
      LangLa_cs var4 = this.a();
      this.n = new LangLa_jb(var4, (byte)0, var1);
      this.o = new LangLa_jb(var4, (byte)1, var2);
   }

   public void a(LangLa_cs var1) {
      var1.w = this;
      this.a.remove(var1);
      this.g();
   }

   public void b(LangLa_cs var1) {
      var1.w = this;
      this.a.insertElementAt(var1, 0);
      this.g();
   }

   public void relayout(boolean expanded) {
      this.n = null;
      this.o = null;
      this.D = false;
      this.j = 0;
      this.m = false;
      this.d = expanded;
      this.g();
   }

   private void g() {
      this.cx = this.cy = this.width = this.height = 0;

      LangLa_cs var1;
      int var2;
      for(var2 = 0; var2 < this.a.size(); ++var2) {
         var1 = (LangLa_cs)this.a.elementAt(var2);
         if (var2 == 0) {
            this.cx = var1.cx;
            this.cy = var1.cy;
         } else {
            if (var1.cx < this.cx) {
               this.cx = var1.cx;
            }

            if (var1.cy < this.cy) {
               this.cy = var1.cy;
            }
         }
      }

      for(var2 = 0; var2 < this.a.size(); ++var2) {
         if ((var1 = (LangLa_cs)this.a.elementAt(var2)).cx + var1.width - this.cx > this.width) {
            this.width = (short)(var1.cx + var1.width - this.cx);
         }

         if (var1.cy + var1.height - this.cy > this.height) {
            this.height = (short)(var1.cy + var1.height - this.cy);
         }
      }

      this.f.a(this.width);
      this.g.a(this.height);
      this.h = this.width;
      this.i = this.height;
      if (this.j == 2) {
         this.a(false);
      } else if (this.j == 1) {
         this.a(true);
      } else if (this.d) {
         this.f.a(this.width);
         this.g.a(this.height);
      } else {
         this.width = this.height = 0;
         this.f.a(this.width);
         this.g.a(this.height);
      }
   }

   public LangLa_cs a() {
      return this.a.size() > 0 ? (LangLa_cs)this.a.lastElement() : null;
   }

   public void c(LangLa_cs var1) {
      Object var2 = this.a.lastElement();
      this.a.removeElement(var1);
      this.a.addElement(var1);
      if (!var1.equals(var2)) {
         this.a.removeElement(var2);
         this.a.addElement(var2);
      }

   }

   public void b() {
      boolean var1 = this.f.a();
      boolean var2 = this.g.a();
      if (var1 && !this.g.b() || var2 && !this.f.b()) {
         this.a(this.j == 1);
      }

      LangLa_cs var4;
      if (this.n != null && this.o != null && !this.c() && !this.d() && (var4 = this.a()) != null && !var4.n(0)) {
         short var5 = var4.cx;
         short var3 = var4.cy;
         this.n.a();
         this.o.a();
         int var6 = var4.cx - var5;
         int var7 = var4.cy - var3;
         this.a(var6, var7, var4);
         if (!this.n.b() && !this.o.b()) {
            this.n = null;
            this.o = null;
            if (this.D) {
               this.f();
            }
         }
      }

   }

   private void a(int var1, int var2, LangLa_cs var3) {
      for(int var5 = 0; var5 < this.a.size(); ++var5) {
         LangLa_cs var4;
         if (!(var4 = (LangLa_cs)this.a.elementAt(var5)).equals(var3)) {
            var4.setXY(var4.cx + var1, var4.cy + var2);
         }
      }

      this.g();
   }

   public void a(Graphics var1) {
      int var3 = var1.a;
      int var4 = var1.b;
      if (this.f.b() || this.g.b()) {
         switch(this.q) {
         case 0:
            this.a(var1, this.cx, this.cy, this.width, this.height);
            break;
         case 1:
            this.a(var1, this.cx + this.h - this.width, this.cy, this.width, this.height);
            break;
         case 2:
            this.a(var1, this.cx, this.cy + this.i - this.height, this.width, this.height);
            break;
         case 3:
            this.a(var1, this.cx + this.h - this.width, this.cy + this.i - this.height, this.width, this.height);
            break;
         case 4:
            this.a(var1, this.cx, this.cy, this.h, this.height);
            break;
         case 5:
            this.a(var1, this.cx, this.cy + this.i - this.height, this.h, this.height);
            break;
         case 6:
            this.a(var1, this.cx + this.h - this.width, this.cy, this.width, this.i);
            break;
         case 7:
            this.a(var1, this.cx, this.cy, this.width, this.i);
         }
      }

      LangLa_cs var10;
      if (this.m && (this.width > 0 || this.cy > 0) || this.d) {
         this.a(var1, this.cx + DataCenter.gI().currentScreen.cx, this.cy + DataCenter.gI().currentScreen.cy);
         int var5;
         switch(this.r) {
         case 3:
            if (beatdz.LangLa_cj.$state_LangLa_cj().l == null) {
               DataCenter.gI();
               Pixmap var2;
               (var2 = (beatdz.LangLa_cj.$state_LangLa_cj().l = mImage.a(115 * DataCenter.gI().zoomLevel, 45 * DataCenter.gI().zoomLevel)).b).setColor(new Color(0.0F, 0.0F, 0.0F, 0.0F));
               var2.fill();
               mImage var6 = LangLa_fq.a((int)687);
               Binary2.a(var2, var6.b, 95 * DataCenter.gI().zoomLevel, 0 * DataCenter.gI().zoomLevel, Blending.None);
               var6 = LangLa_fq.a((int)82);
               Binary2.a(var2, var6.b, 95 * DataCenter.gI().zoomLevel, 25 * DataCenter.gI().zoomLevel, Blending.None);
               var6 = LangLa_fq.a((int)36);
               Binary2.a(var2, var6.b, 75 * DataCenter.gI().zoomLevel, 0 * DataCenter.gI().zoomLevel, Blending.None);
               var6 = LangLa_fq.a((int)648);
               Binary2.a(var2, var6.b, 75 * DataCenter.gI().zoomLevel, 25 * DataCenter.gI().zoomLevel, Blending.None);
               var6 = LangLa_fq.a((int)49);
               Binary2.a(var2, var6.b, 50 * DataCenter.gI().zoomLevel, 0 * DataCenter.gI().zoomLevel, Blending.None);
               var6 = LangLa_fq.a((int)647);
               Binary2.a(var2, var6.b, 50 * DataCenter.gI().zoomLevel, 25 * DataCenter.gI().zoomLevel, Blending.None);           
               if (!beatdz.DataCenter.$state_DataCenter().ar) {
                  var6 = LangLa_fq.a((int)81);
                  Binary2.a(var2, var6.b, 25 * DataCenter.gI().zoomLevel, 0 * DataCenter.gI().zoomLevel, Blending.None);
               }

               if (Char.gI().rank >= 0) {
                  var6 = LangLa_fq.a((int)660);
                  Binary2.a(var2, var6.b, 25 * DataCenter.gI().zoomLevel, 25 * DataCenter.gI().zoomLevel, Blending.None);
               }
                var6 = LangLa_fq.a((int)1171);
               Binary2.a(var2, var6.b, 0 * DataCenter.gI().zoomLevel, 25 * DataCenter.gI().zoomLevel, Blending.None);   
               var6 = LangLa_fq.a((int)1172);
               Binary2.a(var2, var6.b, 0 * DataCenter.gI().zoomLevel, 0 * DataCenter.gI().zoomLevel, Blending.None); 

               Binary.disposeImage(beatdz.LangLa_cj.$state_LangLa_cj().l);
            }

            var1.a(beatdz.LangLa_cj.$state_LangLa_cj().l, 0, 0);
         default:
            var5 = 0;
         }

         while(var5 < this.a.size() - 1) {
            var10 = (LangLa_cs)this.a.elementAt(var5);
            this.a(var1, var10.b_(), var10.c_());
            var10.a(var1);
            ++var5;
         }

         this.a(var1, this.cx + DataCenter.gI().currentScreen.cx, this.cy + DataCenter.gI().currentScreen.cy);
         switch(this.r) {
         case 2:
            short var13 = this.height;
            int var11 = this.width - 5;
            DataCenter.gI();
            String var10001 = "XY: " + Char.gI().cx + ", " + Char.gI().cy;
            var5 = var13 + 10;
            mFont.a(var1, var10001, var11, var5, 1, -1);
            int var15;
            if (GameSrc.gI().E() && GameSrc.gI().timeHoatDong != 0) {
               if (!GameSrc.gI().isHoatDongTime) {
                  var15 = (int)(((long)GameSrc.gI().timeHoatDong - (Utlis.time() - GameSrc.gI().timeStartHoatDong)) / 1000L);
                  if (GameSrc.gI().getMapTemplate().type != 5 && GameSrc.gI().getMapTemplate().type != 6 && GameSrc.gI().getMapTemplate().type != 8 && GameSrc.gI().getMapTemplate().type != 10) {
                     if (var15 > 0) {
                        var10001 = Caption.fq + Utlis.k(var15);
                        var5 += 10;
                        mFont.a(var1, var10001, var11, var5, 1, -1);
                     }
                  } else {
                     var10001 = Caption.fp + Utlis.k(var15);
                     var5 += 10;
                     mFont.a(var1, var10001, var11, var5, 1, -1);
                  }
               } else {
                  var10001 = Caption.fm + Utlis.j((int)((Utlis.time() - GameSrc.gI().timeStartHoatDong) / 1000L));
                  var5 += 10;
                  mFont.a(var1, var10001, var11, var5, 1, -1);
                  if (GameSrc.gI().getMapTemplate().type == 6) {
                     var10001 = Caption.fn + GameSrc.gI().bJ;
                     var5 += 10;
                     mFont.a(var1, var10001, var11, var5, 1, -1);
                  } else if (GameSrc.gI().getMapTemplate().type == 10 || GameSrc.gI().getMapTemplate().type == 16) {
                     var10001 = Caption.fo + GameSrc.gI().bL;
                     var5 += 10;
                     mFont.a(var1, var10001, var11, var5, 1, -1);
                  }

                  if (GameSrc.gI().getMapTemplate().type == 6 || GameSrc.gI().getMapTemplate().type == 17) {
                     var10001 = Caption.fn + GameSrc.gI().bL;
                     var5 += 10;
                     mFont.a(var1, var10001, var11, var5, 1, -1);
                  }
               }
            }

            LangLa_ek var7 = LangLa_cd.e();
            if (Char.gI().idClass > 0 && var7 != null) {
               String var14 = var7.d + Caption.kj + Utlis.j(Utlis.n(var7.c));
               if (DataCenter.gI().i % 16 >= 10) {
                  var15 = var5 + 10;
                  mFont.b(mFont.d, var1, var14, var11, var15, 1, -2560, -16777216);
               } else {
                  var15 = var5 + 10;
                  mFont.b(mFont.d, var1, var14, var11, var15, 1, -1, -16777216);
               }
            }
         case 3:
         case 4:
         default:
            break;
         case 5:
            this.b(var1);
            break;
         case 6:
            c(var1);
         }
      }

      if (this.r == 4 && this.q == 0) {
         this.a(var1, 0, 0);
         // Keep only the location title in the top-right corner.
         var1.f(0x4b2c20);
         var1.c(DataCenter.gI().widthScreen - 86, 0, 86, 16);
         DataCenter.gI();
         mFont.a((BitmapFont)Graphics.b(80), (Graphics)var1, GameSrc.gI().getMapTemplate().name, DataCenter.gI().widthScreen - 43, 7, 2, -6488, -10275328);
         Binary2.a(var1, -9, 0, 35, 12, 73, (int)7);
         Binary2.a(var1, 30, 0, 35, 12, Char.gI().a(73), (int)7);
         Binary2.a(var1, -9, 0, 39, 23, 66, (int)7);
         Binary2.a(var1, 31, 0, 39, 23, Char.gI().b(66), (int)7);
         LangLa_fq.a(var1, 45, 0, 35, 10, 0);
         if (Char.gI().idClass != 0 && (GameSrc.gI().diemTiemNang > 0 || GameSrc.gI().diemKyNang > 0)) {
            LangLa_fq.a(var1, 713, 0, 18, 37, 0);
         }

         mFont.a((BitmapFont)Graphics.b(78), (Graphics)var1, Char.gI().g(), 72, 15, 2, -1, -10275328);
         mFont.a((BitmapFont)Graphics.b(78), (Graphics)var1, Char.gI().h(), 72, 26, 2, -1, -10275328);
         if (beatdz.Session.$state_Session().r > 0) {
            mFont.a((mFont)mFont.e, (Graphics)var1, Caption.qg, DataCenter.gI().widthScreen / 2, DataCenter.gI().heightScreen / 2, 2, -16711681, -10275328);
         }

         Graphics var12 = var1;

         try {
            if (GameSrc.gI().aA != null) {
               if (GameSrc.gI().aA instanceof Char) {
                  drawLivingTarget(var12, GameSrc.gI().aA);
               } else if (GameSrc.gI().aA instanceof Npc) {
                  drawLivingTarget(var12, GameSrc.gI().aA);
               } else {
                  Mob var18;
                  if (GameSrc.gI().aA instanceof Mob && (var18 = (Mob)GameSrc.gI().aA).getMobTemplate().type != 10) {
                     drawMobTarget(var12, var18);
                  }
               }
            }
         } catch (Exception var9) {
         }
      }

      if (this.f.b() || this.g.b()) {
         this.a(var1, this.s, this.t);
         var1.setClip(this.u, this.v, this.w, this.x);
      }

      if ((var10 = this.a()) != null) {
         this.a(var1, var10.b_(), var10.c_());
         var10.a(var1);
      }

      this.a(var1, var3, var4);
   }

   

   private static void drawLivingTarget(Graphics graphics, Entity target) {
      Char character = target instanceof Char ? (Char)target : null;
      Npc npc = target instanceof Npc ? (Npc)target : null;
      int hp = character != null ? character.hp : npc.getNpcTemplate().hp;
      int hpFull = character != null ? character.hpFull : hp;
      int mp = character != null ? character.mp : npc.getNpcTemplate().mp;
      int mpFull = character != null ? character.mpFull : mp;
      ensureTargetFrame();
      graphics.f(0x3f1016); graphics.c(178, 23, 96, 9);
      graphics.f(0xdb1830); graphics.c(178, 23, barWidth(hp, hpFull), 9);
      graphics.f(0xff7777); graphics.c(178, 23, barWidth(hp, hpFull), 2);
      graphics.f(0x22163d); graphics.c(178, 37, 96, 8);
      graphics.f(0x8239b9); graphics.c(178, 37, barWidth(mp, mpFull), 8);
      if (character != null && character.idChar >= 0 && character.idChar < DataCenter.gI().DataIconChar.length) {
         mImage portrait = LangLa_fq.a((int)DataCenter.gI().DataIconChar[character.idChar].idIcon);
         if (portrait != null) graphics.a(portrait, 0, 0, portrait.c, portrait.d, 0, 143, 16,
            25 * DataCenter.gI().zoomLevel, 25 * DataCenter.gI().zoomLevel, 0);
      } else if (npc != null) {
         NpcTemplate template = npc.getNpcTemplate();
         int frameIndex = 0;
         if (template.a != null && template.a.length > 0 && template.a[0] != null && template.a[0].length > 0)
            frameIndex = template.a[0][0] & 255;
         if (template.b != null && frameIndex < template.b.length) drawPortraitFrame(graphics, template.b[frameIndex], 155, 43);
      }
      graphics.a(beatdz.LangLa_cj.$state_LangLa_cj().targetPortraitFrame, 0, 0, beatdz.LangLa_cj.$state_LangLa_cj().targetPortraitFrame.c, beatdz.LangLa_cj.$state_LangLa_cj().targetPortraitFrame.d, 0, 120, 0,
         174 * DataCenter.gI().zoomLevel, 58 * DataCenter.gI().zoomLevel, 0);
      String name = character != null ? character.name : npc.f();
      while (name.length() > 1 && mFont.a(mFont.d, name) > 101) name = name.substring(0, name.length() - 1);
      mFont.a(mFont.d, graphics, name, 227, 11, 2, -16646423, -11184811);
      mFont.a(mFont.d, graphics, character != null ? "Lv." + character.level() : "NPC", 155, 49, 2, -1, -10275328);
      mFont.a((BitmapFont)Graphics.b(78), graphics, targetNumber(hp) + "/" + targetNumber(hpFull), 226, 28, 2, -1, -10275328);
      mFont.a((BitmapFont)Graphics.b(78), graphics, "MP " + targetNumber(mp) + "/" + targetNumber(mpFull), 226, 41, 2, -1, -10275328);
   }

   private static int barWidth(int current, int maximum) {
      return maximum <= 0 ? 0 : (int)(96L * Math.max(0, Math.min(current, maximum)) / maximum);
   }

   private static void ensureTargetFrame() {
      if (beatdz.LangLa_cj.$state_LangLa_cj().targetPortraitFrame == null || beatdz.LangLa_cj.$state_LangLa_cj().targetPortraitFrame.b == null)
         beatdz.LangLa_cj.$state_LangLa_cj().targetPortraitFrame = Binary.createImage(com.badlogic.gdx.Gdx.files.internal("resource/zzzzzz.png").readBytes());
   }

   private static void drawMobTarget(Graphics graphics, Mob mob) {
      ensureTargetFrame();
      int hpWidth = mob.hpFull <= 0 ? 0 : (int)(96L * Math.max(0, Math.min(mob.hp, mob.hpFull)) / mob.hpFull);
      graphics.f(0x3f1016); graphics.c(178, 23, 96, 9);
      graphics.f(0xdb1830); graphics.c(178, 23, hpWidth, 9);
      graphics.f(0xff7777); graphics.c(178, 23, hpWidth, 2);
      // EXP is the kill reward sent by the server, not a monster experience-progress ratio.
      graphics.f(mob.exp > 0 ? 0x8239b9 : 0x22163d); graphics.c(178, 37, 96, 8);
      if (mob.exp > 0) { graphics.f(0xd676f5); graphics.c(178, 37, 96, 2); }
      drawMobPortrait(graphics, mob, 155, 43);
      graphics.a(beatdz.LangLa_cj.$state_LangLa_cj().targetPortraitFrame, 0, 0, beatdz.LangLa_cj.$state_LangLa_cj().targetPortraitFrame.c, beatdz.LangLa_cj.$state_LangLa_cj().targetPortraitFrame.d, 0, 120, 0,
         174 * DataCenter.gI().zoomLevel, 58 * DataCenter.gI().zoomLevel, 0);
      String name = mob.f();
      while (name.length() > 1 && mFont.a(mFont.d, name) > 101) name = name.substring(0, name.length() - 1);
      mFont.a(mFont.d, graphics, name, 227, 11, 2, -16646423, -11184811);
      mFont.a(mFont.d, graphics, "Lv." + mob.level, 155, 49, 2, -1, -10275328);
      mFont.a((BitmapFont)Graphics.b(78), graphics, targetNumber(mob.hp) + "/" + targetNumber(mob.hpFull), 226, 28, 2, -1, -10275328);
      mFont.a((BitmapFont)Graphics.b(78), graphics, "EXP +" + targetNumber(mob.exp), 226, 41, 2, -1, -10275328);
   }
   private static void drawMobPortrait(Graphics graphics, Mob mob, int x, int baseline) {
      MobTemplate template = mob.getMobTemplate();
      if (template == null || template.b == null || template.b.length == 0) return;
      // Render the selected template's first frame without moving or updating the world mob.
      int frameIndex = 0;
      if (template.a != null && template.a.length > 1 && template.a[1] != null && template.a[1].length > 0)
         frameIndex = template.a[1][0] & 255;
      if (frameIndex >= template.b.length) frameIndex = 0;
      LangLa_hz frame = template.b[frameIndex];
      drawPortraitFrame(graphics, frame, x, baseline);
   }

   private static void drawPortraitFrame(Graphics graphics, LangLa_hz frame, int x, int baseline) {
      if (frame == null || frame.a == null) return;
      int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
      int top = Integer.MAX_VALUE, bottom = Integer.MIN_VALUE;
      for (int index = 0; index < frame.a.length; index++) {
         LangLa_ia part = frame.a[index];
         Short key = Short.valueOf(part.a);
         LangLa_et size = (LangLa_et)DataCenter.gI().ak.get(key);
         if (size == null) size = (LangLa_et)DataCenter.gI().am.get(key);
         if (size == null) continue;
         left = Math.min(left, part.b - size.d / 2);
         right = Math.max(right, part.b + (size.d + 1) / 2);
         top = Math.min(top, part.c - size.e);
         bottom = Math.max(bottom, part.c);
      }
      if (left == Integer.MAX_VALUE) return;
      float scale = Math.min(1f, Math.min(25f / Math.max(1, right - left), 25f / Math.max(1, bottom - top)));
      float centerX = (left + right) / 2f;
      float centerY = (top + bottom) / 2f;
      for (int index = 0; index < frame.a.length; index++) {
         LangLa_ia part = frame.a[index];
         Short key = Short.valueOf(part.a);
         mImage image = (mImage)beatdz.LangLa_fq.$state_LangLa_fq().g.get(key);
         LangLa_et size = (LangLa_et)DataCenter.gI().ak.get(key);
         if (size == null) size = (LangLa_et)DataCenter.gI().am.get(key);
         if (image == null) {
            LangLa_fq.b(null, part.a, 0, 0, 0, 33);
         } else if (size != null) {
            graphics.a(image, 0, 0, image.c, image.d, Utlis.a(part.d),
               x + Math.round((part.b - centerX) * scale), baseline - 15 + Math.round((part.c - centerY) * scale),
               Math.max(1, Math.round(size.d * scale * DataCenter.gI().zoomLevel)),
               Math.max(1, Math.round(size.e * scale * DataCenter.gI().zoomLevel)), 33);
         }
      }
   }

   private static String targetNumber(int value) {
      if (value >= 1000000000) return value / 1000000000 + "." + value / 100000000 % 10 + "B";
      if (value >= 1000000) return value / 1000000 + "." + value / 100000 % 10 + "M";
      return Utlis.numberFormat(Math.max(0, value));
   }

   public void a(Vector var1, int var2, int var3, int var4, int var5, int var6) {
      this.b = var1;
      this.y = var2;
      this.z = var3;
      this.A = var4;
      this.B = 78;
      this.C = 38;
      this.h();
   }

   public boolean c() {
      if (this.j > 0) {
         return this.j == 1;
      } else {
         return this.d;
      }
   }

   public boolean d() {
      return this.f.b() || this.g.b() || this.j > 0;
   }

   public void e() {
      this.m = true;
      if (!this.f.b() && !this.g.b()) {
         this.h = this.width;
         this.i = this.height;
         this.j = 2;
         this.f.a(0);
         this.g.a(0);
      } else {
         this.a(false);
         this.width = this.height = 0;
         this.f.a(this.width);
         this.g.a(this.height);
      }
   }

   public void f() {
      this.m = true;
      if (!this.f.b() && !this.g.b()) {
         this.j = 1;
         this.f.a(this.h);
         this.g.a(this.i);
      } else {
         this.a(true);
         this.width = this.h;
         this.height = this.i;
         this.f.a(this.h);
         this.g.a(this.i);
      }
   }

   public void a(boolean var1) {
      this.d = var1;
      this.j = 0;
      this.m = false;
      if (var1) {
         this.width = this.h;
         this.height = this.i;
         this.f.a(this.width);
         this.g.a(this.height);
      } else {
         this.width = this.height = 0;
         this.f.a(this.width);
         this.g.a(this.height);
      }
   }

   private void a(Graphics var1, int var2, int var3, int var4, int var5) {
      this.s = var1.a;
      this.t = var1.b;
      this.u = var1.i();
      this.v = var1.j();
      this.w = var1.h;
      this.x = var1.i;
      if (var4 > this.w) {
         var4 = this.w;
      }

      if (var5 > this.x) {
         var5 = this.x;
      }

      this.a(var1, var2, var3);
      var1.setClip(0, 0, var4, var5);
   }

   private void h() {
      int var3 = this.B;
      int var4 = this.A;

      for(int var6 = 0; var6 < this.b.size(); ++var6) {
         LangLa_cs var5 = (LangLa_cs)this.b.elementAt(var6);
         int var1;
         int var2;
         if (var3 > 270) {
            var2 = var3 - 270;
            var1 = beatdz.LangLa_hi.$state_LangLa_hi().o[90 - var2] * var4 / 1000;
            var2 = beatdz.LangLa_hi.$state_LangLa_hi().o[var2] * var4 / 1000;
            var5.cx = (short)(0 + var1 + this.y);
            var5.cy = (short)(0 + var2 + this.z);
         } else if (var3 > 180) {
            var2 = var3 - 180;
            var1 = beatdz.LangLa_hi.$state_LangLa_hi().o[var2] * var4 / 1000;
            var2 = beatdz.LangLa_hi.$state_LangLa_hi().o[90 - var2] * var4 / 1000;
            var5.cx = (short)(0 - var1 + this.y);
            var5.cy = (short)(0 + var2 + this.z);
         } else if (var3 > 90) {
            var2 = var3 - 90;
            var1 = beatdz.LangLa_hi.$state_LangLa_hi().o[90 - var2] * var4 / 1000;
            var2 = beatdz.LangLa_hi.$state_LangLa_hi().o[var2] * var4 / 1000;
            var5.cx = (short)(0 - var1 + this.y);
            var5.cy = (short)(0 - var2 + this.z);
         } else {
            var1 = beatdz.LangLa_hi.$state_LangLa_hi().o[var3] * var4 / 1000;
            var2 = beatdz.LangLa_hi.$state_LangLa_hi().o[90 - var3] * var4 / 1000;
            var5.cx = (short)(0 + var1 + this.y);
            var5.cy = (short)(0 - var2 + this.z);
         }

         var5.setXY(var5.cx - var5.width / 2, var5.cy - var5.height / 2);
         var3 += this.C;
      }

      this.g();
   }

   private void b(Graphics var1) {
      var1.clean();
      Vector var2;
      if ((var2 = this.c) != null) {
         for(int var4 = 0; var4 < var2.size(); ++var4) {
            LangLa_cs var3 = (LangLa_cs)var2.elementAt(var4);
            this.a(var1, var3.b_(), var3.c_());
            if (var4 < GameSrc.gI().aE.size() && !var3.v) {
               Skill var5;
               Skill var7;
               float var6 = (float)((int)((var5 = var7 = (Skill)GameSrc.gI().aE.elementAt(var4)).time - Utlis.time()));
               float var8 = (float)(var5.coolDown / 25);
               if ((var8 = !(var6 <= 0.0F) && var8 != 0.0F ? var6 / var8 : 26.0F) <= 25.0F && var8 > 0.0F) {
                  LangLa_fq.a(var1, 102, 0, 0, 25, 25 * DataCenter.gI().zoomLevel, (int)var8 * DataCenter.gI().zoomLevel, 0, 25 - (int)var8, 25, (int)var8, 36);
               }

               if (var7.f() > 0.0F) {
                  mFont var10000 = mFont.b;
                  float var10002 = var7.f() / 1000.0F;
                  boolean var9 = true;
                  var8 = var10002;
                  mFont.b(var10000, var1, String.valueOf((new BigDecimal(Float.toString(var8))).setScale(2, 4)), 12, 12, 2, -1, -16777216);
               }
            }
         }
      }

      this.a(var1, this.cx + DataCenter.gI().currentScreen.cx, this.cy + DataCenter.gI().currentScreen.cy);
   }

   private static void c(Graphics var0) {
      int var1 = 5 + AppListener.gI().o;
      int var2 = 47 + AppListener.gI().o / 2;

      for(int var4 = 0; var4 < Char.gI().vEffect.size(); ++var4) {
         Effect var3;
         (var3 = (Effect)Char.gI().vEffect.elementAt(var4)).a(var0, var1, var2, Char.gI());
         var3.setXY(var1, var2);
         var1 += 18;
      }

   }

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public mImage l;
public mImage targetPortraitFrame;
public void initialize() {
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.LangLa_cj");
public static SessionState $state_LangLa_cj() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
