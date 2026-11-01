package beatdz;import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.listener.IKeyboard;
import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_dl extends LangLa_fl {
   private boolean e;
   private boolean f;
   private boolean g;
   private boolean h;
   private mTextBox i;
   private int j;
   private int k;
   private LangLa_dz[] l;
   private int m = -1;
   private int n = -1;
   private int o = 0;
   private int s = 0;
   private int t = 0;
   private int u;
   private int v;
   private int w;
   private mFont x;
   public String a = "";
   private char[][] y = new char[2][];
   private char[][] z = new char[6][];
   private LangLa_cx A;
   private short B;
   private short C;
   private short D;
   private short E;
   public IKeyboard b;
   private mImage F;
   private int G;
   public boolean c;
   private long H;
   public boolean d;

   public LangLa_dl(MainScreen var1, mTextBox var2, boolean var3, boolean var4) {
      try {
         this.c = false;
         this.r = false;
         this.cF = 5;
         this.p = var1;
         this.f = DataCenter.gI().widthScreen > 400;
         this.i = var2;
         this.e();
         this.g = var2.b == 2;
         this.o = this.g ? 1 : 0;
         this.x = this.f ? mFont.f : mFont.e;
         if (var2.c_() + var2.height > this.cy) {
            this.j = this.cy - var2.c_() - var2.height - 1;
         }

         if (!var4) {
            this.j = 0;
         }

         this.a(this.j);
         this.B = var2.cx;
         this.C = var2.cy;
         this.D = (short)var2.b_();
         this.E = (short)var2.c_();
         this.A = var2.s;
         this.A.b((LangLa_cs)var2);
         this.i = var2;
         var2.s = this;
         var2.cx = (short)(this.v + this.D - this.v);
         if (this.C + var2.height > this.cy) {
            var2.cy = (short)(-var2.height);
         } else {
            var2.cy = (short)(-(DataCenter.gI().heightScreen - this.height - this.E));
         }

         this.a(var2);
         if (this.A instanceof IKeyboard) {
            IKeyboard var6 = (IKeyboard)this.A;
            this.b = var6;
            this.b.a(var2);
         }

         var2.s.cM = null;
      } catch (Exception var5) {
         Utlis.println(var5);
      }
   }

   private void e() {
      if (this.f) {
         this.setSize(DataCenter.gI().widthScreen, 145);
         this.setXY(0, DataCenter.gI().heightScreen - this.height);
         this.t = 25;
         if (this.F == null) {
            if (this.c) {
               this.F = mImage.a(1, 1);
            } else {
               this.F = mImage.a(DataCenter.gI().widthScreen * DataCenter.gI().zoomLevel, 145 * DataCenter.gI().zoomLevel);
            }
         }
      } else {
         this.setSize(DataCenter.gI().widthScreen, 120);
         this.setXY(0, DataCenter.gI().heightScreen - this.height);
         this.t = 20;
         if (this.F == null) {
            if (this.c) {
               this.F = mImage.a(1, 1);
            } else {
               this.F = mImage.a(DataCenter.gI().widthScreen * DataCenter.gI().zoomLevel, 120 * DataCenter.gI().zoomLevel);
            }
         }
      }

      this.s = (DataCenter.gI().widthScreen - 32) / 11;
      this.u = 2;
      this.v = DataCenter.gI().widthScreen / 2 - 6 * (this.s + this.u) + (this.s + this.u) / 2;
      this.w = 5;
      this.l = new LangLa_dz[46];

      int var1;
      for(var1 = 0; var1 < 10; ++var1) {
         this.l[var1] = this.a(this.v + (this.s + this.u) / 2 + var1 * (this.s + this.u), this.w, "", this, 1000 + var1, -1);
         this.l[var1].setSize(this.s, this.t);
      }

      for(var1 = 0; var1 < 11; ++var1) {
         this.l[10 + var1] = this.a(this.v + var1 * (this.s + this.u), this.w + this.t + this.u, "", this, 1010 + var1, -1);
         this.l[10 + var1].setSize(this.s, this.t);
      }

      for(var1 = 0; var1 < 10; ++var1) {
         this.l[21 + var1] = this.a(this.v + (this.s + this.u) / 2 + var1 * (this.s + this.u), this.w + 2 * (this.t + this.u), "", this, 1021 + var1, -1);
         this.l[21 + var1].setSize(this.s, this.t);
      }

      this.l[31] = this.a(this.v, this.w + 3 * (this.t + this.u), "", this, 1031, -1);
      this.l[31].setSize(this.l[22].cx + this.l[22].width / 2 - this.v - this.u, this.t);

      for(var1 = 0; var1 < 7; ++var1) {
         this.l[32 + var1] = this.a(this.v + this.l[31].width + this.u + var1 * (this.s + this.u), this.w + 3 * (this.t + this.u), "", this, 1032 + var1, -1);
         this.l[32 + var1].setSize(this.s, this.t);
      }

      this.l[39] = this.a(this.l[38].cx + this.l[38].width + this.u, this.w + 3 * (this.t + this.u), "", this, 1039, -1);
      this.l[39].setSize(this.l[22].cx + this.l[22].width / 2 - this.v, this.t);
      this.l[40] = this.a(this.v, this.w + 4 * (this.t + this.u), "", this, 1040, -1);
      this.l[40].setSize(this.l[22].cx + this.l[22].width / 2 - this.v - this.u, this.t);
      this.l[41] = this.a(this.l[40].cx + this.l[40].width + this.u, this.w + 4 * (this.t + this.u), "", this, 1041, -1);
      this.l[41].setSize(this.s, this.t);
      this.l[42] = this.a(this.l[41].cx + this.l[41].width + this.u, this.w + 4 * (this.t + this.u), "", this, 1042, -1);
      this.l[42].setSize(this.l[36].cx + this.l[36].width + this.s + this.u - this.l[34].cx, this.t);
      this.l[43] = this.a(this.l[42].cx + this.l[42].width + this.u, this.w + 4 * (this.t + this.u), "", this, 1043, -1);
      this.l[43].setSize(this.s, this.t);
      this.l[44] = this.a(this.l[43].cx + this.l[43].width + this.u, this.w + 4 * (this.t + this.u), "", this, 1044, -1);
      this.l[44].setSize(this.s, this.t);
      this.l[45] = this.a(this.l[44].cx + this.l[44].width + this.u, this.w + 4 * (this.t + this.u), "", this, 1045, -1);
      this.l[45].setSize(this.l[22].cx + this.l[22].width / 2 - this.v, this.t);
      this.y[0] = new char[]{'ă', 'â', 'ê', 'ô', 'ˋ', 'ˊ', '~', 'ˀ', '.', 'đ', 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'ư', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'ơ', ' ', 'z', 'x', 'c', 'v', 'b', 'n', 'm', ' ', ' ', '@', ' ', ',', '.', ' '};
      this.y[1] = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '@', '#', '$', '%', '&', '-', '+', '(', ')', '_', '*', '"', '\'', ':', ';', '!', '?', '\\', '/', '{', '}', ' ', '~', '[', ']', '=', '<', '>', '|', ' ', ' ', '_', ' ', ',', '.', ' '};
      this.z[0] = new char[]{'a', 'ă', 'â', 'o', 'ơ', 'ô', 'ê', 'e', 'ư', 'u', 'i', 'y', 'A', 'Ă', 'Â', 'O', 'Ơ', 'Ô', 'Ê', 'E', 'Ư', 'U', 'I', 'Y'};
      this.z[1] = new char[]{'á', 'ắ', 'ấ', 'ó', 'ớ', 'ố', 'ế', 'é', 'ứ', 'ú', 'í', 'ý', 'Á', 'Ắ', 'Ấ', 'Ó', 'Ớ', 'Ố', 'Ế', 'É', 'Ứ', 'Ú', 'Í', 'Ý'};
      this.z[2] = new char[]{'ả', 'ẳ', 'ẩ', 'ỏ', 'ở', 'ổ', 'ể', 'ẻ', 'ử', 'ủ', 'ỉ', 'ỷ', 'Ả', 'Ẳ', 'Ẩ', 'Ỏ', 'Ở', 'Ổ', 'Ể', 'Ẻ', 'Ử', 'Ủ', 'Ỉ', 'Ỷ'};
      this.z[3] = new char[]{'ã', 'ẵ', 'ẫ', 'õ', 'ỡ', 'ỗ', 'ễ', 'ẽ', 'ữ', 'ũ', 'ĩ', 'ỹ', 'Ã', 'Ẵ', 'Ẫ', 'Õ', 'Ỡ', 'Ỗ', 'Ễ', 'Ẽ', 'Ữ', 'Ũ', 'Ĩ', 'Ỹ'};
      this.z[4] = new char[]{'à', 'ằ', 'ầ', 'ò', 'ờ', 'ồ', 'ề', 'è', 'ừ', 'ù', 'ì', 'ỳ', 'À', 'Ằ', 'Ầ', 'Ò', 'Ờ', 'Ồ', 'Ề', 'È', 'Ừ', 'Ù', 'Ì', 'Ỳ'};
      this.z[5] = new char[]{'ạ', 'ặ', 'ậ', 'ọ', 'ợ', 'ộ', 'ệ', 'ẹ', 'ự', 'ụ', 'ị', 'ỵ', 'Ạ', 'Ặ', 'Ậ', 'Ọ', 'Ợ', 'Ộ', 'Ệ', 'Ẹ', 'Ự', 'Ụ', 'Ị', 'Ỵ'};
   }

   public void d() {
      if (this.m == -2) {
         GameSrc.gI().a(this.i);
      }

      this.a(-this.j);
      this.i.s = this.A;
      this.i.cx = this.B;
      this.i.cy = this.C;
      if (this.i.b == 2) {
         this.i.a(String.valueOf(this.i.e()));
      }

      this.b(this.i);
      this.A.a(this.i);
      if (this.b != null) {
         this.b.b(this.i);
      } else {
         if (this.i.n != Integer.MIN_VALUE && this.i.e() < this.i.n) {
            this.i.a("" + this.i.n);
         }

         if (this.i.o != Integer.MAX_VALUE && this.i.e() > this.i.o) {
            this.i.a("" + this.i.o);
         }
      }

      if (this.F != null) {
         this.F.a();
         this.F = null;
      }

      this.i.t = false;
      mTextBox var1 = this.i;
      if (GameSrc.gI().ah != null && GameSrc.gI().ah.equals(var1)) {
         var1.setXY(-200, -200);
         var1.b(true);
      }

      if (SettingsTab.gI().m != null && SettingsTab.gI().m.equals(var1)) {
         var1.setXY(-200, -200);
         var1.b(true);
      }

      beatdz.Binary2.$state_Binary2().a = null;
      if (this.c) {
         Gdx.input.setOnscreenKeyboardVisible(false);
      }

   }

   private void a(int var1) {
      for(int var3 = 0; var3 < this.p.cD.size(); ++var3) {
         LangLa_cx var2;
         if (!((var2 = (LangLa_cx)this.p.cD.elementAt(var3)) instanceof LangLa_dl) && !(var2 instanceof GameSrc)) {
            var2.setXY(var2.cx, var2.cy + var1);
         }
      }

   }

   public void a(LangLa_jz var1, int var2, int var3) {
      this.n = var1.b;
      if (this.n != 5000 && this.n != 1045) {
         if (this.c) {
            this.J();
         } else {
            this.n -= 1000;
            if (this.n == 39) {
               if (!this.d) {
                  this.m = 8;
               }

               this.d = false;
            } else {
               this.m = this.y[this.o][this.n];
               if (!this.g || this.m >= 48 && this.m <= 57) {
                  if (this.o == 0 && this.e) {
                     this.m = String.valueOf(this.y[0][this.n]).toUpperCase().charAt(0);
                  }

                  if (this.n == 31) {
                     if (this.o == 0) {
                        this.e = !this.e;
                        this.G = 0;
                     }

                     this.m = -1;
                  } else if (this.n == 40 && !this.g) {
                     this.o = this.o == 0 ? 1 : 0;
                     this.G = 0;
                     this.e();
                     this.m = -1;
                  } else if (this.n == 41) {
                     if (this.i.p && this.o == 0) {
                        this.cL = new LangLa_ac(var1.a.cx - 44, var1.a.cy - 88, 8001, this);
                        this.a(this.cL);
                     } else {
                        String var4 = this.i.f();
                        if ((var4 = var4 + ".com").length() <= this.i.a) {
                           this.i.a(var4);
                        }
                     }

                     this.m = -1;
                  }
               } else {
                  this.m = -1;
               }
            }
         }
      } else {
         this.m = -1;
         if (this.n == 1045 && this.i.p) {
            this.m = -2;
         }

         this.J();
      }
   }

   public void b(int var1, Object var2) {
      long var3 = Utlis.time();
      if (this.H == 0L) {
         this.H = var3;
      } else {
         if (var3 - this.H > 100L) {
            switch(var1) {
            case 1039:
               this.d = true;
               this.H = 0L;
               this.i.cO.a((int)8);
               return;
            default:
               this.H = 0L;
            }
         }

      }
   }

   public void a(int var1, Object var2, LangLa_cy var3) {
      if (!this.c) {
         if (var1 == 8001) {
            this.i.c(var2.toString());
            this.c(this.i);
         }

      }
   }

   public void a(int var1, Object var2) {
   }

   public void a(Graphics var1) {
      try {
         int var3;
         for(var3 = 0; var3 < this.cG.size(); ++var3) {
            LangLa_cs var2;
            if (!((var2 = (LangLa_cs)this.cG.elementAt(var3)) instanceof LangLa_ac)) {
               var2.c(var1);
            }
         }

         if (!this.c) {
            var1.f(-7319266);
            var1.c(0, 0, this.width, this.height);

            for(int var4 = 0; var4 < this.l.length; ++var4) {
               var3 = 0;
               var1.f(-7056866);
               var1.c(this.l[var4].cx, this.l[var4].cy, this.l[var4].width, this.l[var4].height);
               var1.f(-4489148);
               var1.b(this.l[var4].cx, this.l[var4].cy, this.l[var4].width, this.l[var4].height);
               String var7 = String.valueOf(this.y[this.o][var4]);
               if (var4 == 31) {
                  LangLa_fq.a(var1, 98, 0, this.l[var4].cx + this.l[var4].width / 2, this.l[var4].cy + this.l[var4].height / 2, 3);
               } else if (var4 == 39) {
                  LangLa_fq.a(var1, 99, 0, this.l[var4].cx + this.l[var4].width / 2, this.l[var4].cy + this.l[var4].height / 2, 3);
               } else {
                  if (var4 == 40) {
                     var7 = this.o == 0 ? "?123" : "ABC";
                  } else {
                     label118: {
                        String var10000;
                        if (var4 == 41) {
                           if (this.i.p && this.o == 0) {
                              LangLa_fq.a(var1, 38, 0, this.l[var4].cx + this.l[var4].width / 2 + 1, this.l[var4].cy + this.l[var4].height / 2, 3);
                              continue;
                           }

                           var10000 = ".com";
                        } else {
                           if (var4 != 45) {
                              break label118;
                           }

                           var10000 = this.i.p ? Caption.fV : Caption.fW;
                        }

                        var7 = var10000;
                     }
                  }

                  if (this.e) {
                     var7 = var7.toUpperCase();
                  }

                  if (this.l[var4].n(0)) {
                     ++var3;
                  }

                  int var5 = -1;
                  if (this.g && var4 >= 10 && var4 != 45) {
                     var5 = -11184811;
                  }

                  if (var7.equals("ˀ")) {
                     mFont.a((BitmapFont)Graphics.a(20.0F), (Graphics)var1, "?", this.l[var4].cx + this.l[var4].width / 2, this.l[var4].cy + this.l[var4].height / 2 + var3 + 1, 2, var5, 0);
                     var1.f(-7056866);
                     var1.c(this.l[var4].cx - 3 + this.l[var4].width / 2, this.l[var4].cy + this.l[var4].height / 2 + 1 + var3 - 5 + 5, 6, 3);
                  } else if (var7.equals("ˊ")) {
                     mFont.a((BitmapFont)Graphics.a(20.0F), (Graphics)var1, "/", this.l[var4].cx + this.l[var4].width / 2, this.l[var4].cy + this.l[var4].height / 2 + 1 + var3, 2, var5, 0);
                     var1.f(-7056866);
                     var1.c(this.l[var4].cx - 3 + this.l[var4].width / 2, this.l[var4].cy + this.l[var4].height / 2 + 1 + var3 - 3 + 3, 6, 5);
                  } else if (var7.equals("ˋ")) {
                     mFont.a((BitmapFont)Graphics.a(20.0F), (Graphics)var1, "\\", this.l[var4].cx + this.l[var4].width / 2, this.l[var4].cy + this.l[var4].height / 2 + 1 + var3, 2, var5, 0);
                     var1.f(-7056866);
                     var1.c(this.l[var4].cx - 3 + this.l[var4].width / 2, this.l[var4].cy + this.l[var4].height / 2 + 1 + var3 - 3 + 3, 6, 5);
                  } else {
                     mFont.a((mFont)this.x, (Graphics)var1, var7, this.l[var4].cx + this.l[var4].width / 2, this.l[var4].cy + this.l[var4].height / 2 + 1 + var3, 2, var5, 0);
                  }

                  if (this.l[var4].n(0) && this.l[var4].n(0) && (!this.g && var4 != 40 && var4 != 42 && var4 != 45 || this.g && var4 < 10)) {
                     var1.f(-7978471);
                     var1.c(this.l[var4].cx, this.l[var4].cy - this.l[var4].height - 2, this.l[var4].width, this.l[var4].height);
                     var1.f(-2789047);
                     var1.b(this.l[var4].cx, this.l[var4].cy - this.l[var4].height - 2, this.l[var4].width, this.l[var4].height);
                     if (var7.equals("ˀ")) {
                        mFont.a((BitmapFont)Graphics.a(20.0F), (Graphics)var1, "?", this.l[var4].cx + this.l[var4].width / 2, this.l[var4].cy + this.l[var4].height / 2 - this.l[var4].height - 2 + 1, 2, var5, 0);
                        var1.f(-7912675);
                        var1.c(this.l[var4].cx - 3 + this.l[var4].width / 2, this.l[var4].cy + this.l[var4].height / 2 - this.l[var4].height - 2 - 4 + 5, 6, 3);
                     } else if (var7.equals("ˊ")) {
                        mFont.a((BitmapFont)Graphics.a(20.0F), (Graphics)var1, "/", this.l[var4].cx + this.l[var4].width / 2, this.l[var4].cy + this.l[var4].height / 2 - this.l[var4].height - 2, 2, var5, 0);
                        var1.f(-7912675);
                        var1.c(this.l[var4].cx - 3 + this.l[var4].width / 2, this.l[var4].cy + this.l[var4].height / 2 - this.l[var4].height - 2 - 5 + 5, 6, 5);
                     } else if (var7.equals("ˋ")) {
                        mFont.a((BitmapFont)Graphics.a(20.0F), (Graphics)var1, "\\", this.l[var4].cx + this.l[var4].width / 2, this.l[var4].cy + this.l[var4].height / 2 - this.l[var4].height - 2, 2, var5, 0);
                        var1.f(-7912675);
                        var1.c(this.l[var4].cx - 3 + this.l[var4].width / 2, this.l[var4].cy + this.l[var4].height / 2 - this.l[var4].height - 2 - 5 + 5, 6, 5);
                     } else {
                        mFont.a((mFont)mFont.f, (Graphics)var1, var7, this.l[var4].cx + this.l[var4].width / 2, this.l[var4].cy + this.l[var4].height / 2 - this.l[var4].height - 2, 2, -1, 0);
                     }
                  }
               }
            }

            if (this.cL != null) {
               this.a(var1, this.cL.b_(), this.cL.c_());
               this.cL.a(var1);
            }

         }
      } catch (Exception var6) {
         Utlis.println(var6);
      }
   }

   public void b() {
      String var1;
      if ((var1 = this.i.f()).length() >= this.i.a) {
         if (!this.i.r || this.m == -1) {
            return;
         }

         this.i.a("");
         var1 = "";
      }

      if (this.m >= 0) {
         if (this.m >= 32) {
            mTextBox var3 = this.i;
            String var2 = var1;
            LangLa_dl var12 = this;
            if (this.m >= 0) {
               this.a = "";
               this.k = 0;
               int var5;
               if (var1.length() > 0) {
                  int var4;
                  for(var5 = (var4 = var3.a()) + var3.e - 1; var5 >= 0; --var5) {
                     if (var2.charAt(var5) == ' ') {
                        this.k = var5 + 1 - var4;
                        break;
                     }
                  }

                  this.a = var2.substring(var4 + this.k, var4 + var3.e);
               }

               if (this.o == 0 && this.a.length() > 0) {
                  boolean var14 = false;
                  var5 = 0;
                  int var6 = -1;
                  int var7 = 0;
                  boolean var8 = false;
                  int var9 = 0;

                  while(true) {
                     int var10;
                     int var11;
                     if (var9 >= var12.a.length()) {
                        if (var12.o != 0 || var12.m != var12.y[0][4] && var12.m != var12.y[0][5] && var12.m != var12.y[0][6] && var12.m != var12.y[0][7] && (var12.n == 44 || var12.m != var12.y[0][8])) {
                           if (var5 >= 2 && var12.m != 32 && var12.m != 46 && var12.m != 44 && var7 > 0) {
                              label268:
                              for(var9 = 0; var9 < var12.a.length(); ++var9) {
                                 for(var10 = 0; var10 < var12.z.length; ++var10) {
                                    for(var11 = 0; var11 < var12.z[var10].length; ++var11) {
                                       if (var12.a.charAt(var9) == var12.z[var10][var11]) {
                                          if (var9 == var6) {
                                             var12.a = var12.a.replace(var12.a.charAt(var9), var12.z[var7][var11]);
                                             break label268;
                                          }

                                          var12.a = var12.a.replace(var12.a.charAt(var9), var12.z[0][var11]);
                                          var14 = true;
                                       }
                                    }
                                 }
                              }
                           }

                           if (var14) {
                              var3.a(var12.a + (char)var12.m, var12.k, var3.e + 1);
                           } else {
                              if (var12.m == 32 && !var12.h && var2.endsWith(".")) {
                                 var12.h = true;
                                 var12.e = true;
                              } else if (var12.h && var12.m != 32) {
                                 var12.h = var12.e = false;
                              }

                              var12.a = var12.a + (char)var12.m;
                              var3.a("" + (char)var12.m, var3.e, var3.e + 1);
                           }
                        } else {
                           if (var5 == 1 || var5 == 2 && var6 == var12.a.length() - 1) {
                              label222:
                              for(var9 = 0; var9 < var12.a.length(); ++var9) {
                                 for(var10 = 0; var10 < var12.z.length; ++var10) {
                                    for(var11 = 0; var11 < var12.z[var10].length; ++var11) {
                                       if (var12.a.charAt(var9) == var12.z[var10][var11]) {
                                          if (var12.m == var12.y[0][4]) {
                                             var12.a = var12.a.replace(var12.a.charAt(var9), var12.z[4][var11]);
                                          } else if (var12.m == var12.y[0][5]) {
                                             var12.a = var12.a.replace(var12.a.charAt(var9), var12.z[1][var11]);
                                          } else if (var12.m == var12.y[0][6]) {
                                             var12.a = var12.a.replace(var12.a.charAt(var9), var12.z[3][var11]);
                                          } else if (var12.m == var12.y[0][7]) {
                                             var12.a = var12.a.replace(var12.a.charAt(var9), var12.z[2][var11]);
                                          } else if (var12.m == var12.y[0][8]) {
                                             var12.a = var12.a.replace(var12.a.charAt(var9), var12.z[5][var11]);
                                          }

                                          var14 = true;
                                          break label222;
                                       }
                                    }
                                 }
                              }
                           } else {
                              int var13 = 0;

                              label207:
                              for(var9 = 0; var9 < var12.a.length(); ++var9) {
                                 for(var10 = 0; var10 < var12.z.length; ++var10) {
                                    for(var11 = 0; var11 < var12.z[var10].length; ++var11) {
                                       if (var12.a.charAt(var9) == var12.z[var10][var11]) {
                                          if (var5 == 2 && var13 > var5 - 2 && var6 == var9 || var5 == 3 && var13 > 0 && !var8 || var5 == 3 && var13 > 1 && var8) {
                                             if (var12.m == var12.y[0][4]) {
                                                var12.a = var12.a.replace(var12.a.charAt(var9), var12.z[4][var11]);
                                             } else if (var12.m == var12.y[0][5]) {
                                                var12.a = var12.a.replace(var12.a.charAt(var9), var12.z[1][var11]);
                                             } else if (var12.m == var12.y[0][6]) {
                                                var12.a = var12.a.replace(var12.a.charAt(var9), var12.z[3][var11]);
                                             } else if (var12.m == var12.y[0][7]) {
                                                var12.a = var12.a.replace(var12.a.charAt(var9), var12.z[2][var11]);
                                             } else if (var12.m == var12.y[0][8]) {
                                                var12.a = var12.a.replace(var12.a.charAt(var9), var12.z[5][var11]);
                                             }

                                             var14 = true;
                                             break label207;
                                          }

                                          ++var13;
                                       }
                                    }
                                 }
                              }
                           }

                           if (!var14) {
                              break;
                           }

                           var3.a(var12.a, var12.k, var3.e);
                        }

                        var12.m = -1;
                        break;
                     }

                     for(var10 = 0; var10 < var12.z.length; ++var10) {
                        for(var11 = 0; var11 < var12.z[var10].length; ++var11) {
                           if (var12.a.charAt(var9) == var12.z[var10][var11]) {
                              ++var5;
                              if (var12.z[var10][var11] == 'y' || var12.z[var10][var11] == 'Y') {
                                 var8 = true;
                              }

                              if (var10 > 0) {
                                 var7 = var10;
                              }

                              var6 = var9;
                           }
                        }
                     }

                     ++var9;
                  }
               } else {
                  if (this.o == 0 && (this.n < 4 || this.n > 8) || this.o == 1) {
                     if (this.m == 32 && !this.h && var2.endsWith(".")) {
                        this.h = true;
                        this.e = true;
                     } else if (this.h && this.m != 32) {
                        this.h = this.e = false;
                     }

                     var3.a("" + (char)this.m, var3.e, var3.e + 1);
                  }

                  this.m = -1;
               }
            }
         } else {
            this.i.cO.a(this.m);
         }

         this.m = -1;
      }

      this.i.t = true;
      if (this.c) {
         Gdx.input.setOnscreenKeyboardVisible(true);
      }

   }

   public Vector c() {
      Vector var1 = new Vector();
      if (this.c) {
         var1.add(new LangLa_jz(5000, 0, -DataCenter.gI().heightScreen, DataCenter.gI().widthScreen, DataCenter.gI().heightScreen * 2, (LangLa_ii)null, this));
      } else {
         var1.add(new LangLa_jz(5000, 0, -this.cy, DataCenter.gI().widthScreen, DataCenter.gI().heightScreen - DataCenter.gI().heightScreen, (LangLa_ii)null, this));
      }

      return var1;
   }
}
