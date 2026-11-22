package beatdz;


import java.util.Vector;

public class mTextBox extends LangLa_cs {
   private String[] x = new String[]{" 0", ".,@?!_1\"/$-():*+<=>;%&~#%^&*{}[];'/1", "abc2áàảãạâấầẩẫậăắằẳẵặ2", "def3đéèẻẽẹêếềểễệ3", "ghi4íìỉĩị4", "jkl5", "mno6óòỏõọôốồổỗộơớờởỡợ6", "pqrs7", "tuv8úùủũụưứừửữự8", "wxyz9ýỳỷỹỵ9", "*", "#"};
   private String[] y = new String[]{"0", "1", "abc2", "def3", "ghi4", "jkl5", "mno6", "pqrs7", "tuv8", "wxyz9", "0", "0"};
   private int z = 11;
   public int a = 999;
   public int b;
   private int A;
   private String B = "";
   protected String c = "";
   protected int d = 0;
   public int e;
   public int f;
   private int C = 0;
   private int D = 0;
   protected int g = Integer.MIN_VALUE;
   private int E = 11;
   protected String h = "";
   protected String i = "";
   public LangLa_ii j;
   protected int k;
   protected boolean l = true;
   protected boolean m = false;
   private int F = 50;
   public int n = Integer.MIN_VALUE;
   public int o = Integer.MAX_VALUE;
   private int G;
   public boolean p;
   public boolean q;
   public boolean r;
   private String H = "";

   public mTextBox(int var1, int var2, int var3, String var4, LangLa_cx var5, int var6, int var7) {
      this.h = var4;
      this.s = var5;
      this.k = var6;
      this.b = var7;
      this.setXY(var1, var2);
      this.setSize(var3, 22);
      if (var7 == 1) {
         this.G = 22;
         this.m = true;
      }

      this.j = new LangLa_im((byte)0, 5, 2, this.width - 10 - this.G, this.height - 4, this.width, 0);
   }

   public void b(String var1) {
      this.h = var1;
   }

   public int a() {
      return 0;
   }

   public void d(boolean var1) {
      this.l = false;
   }

   protected void d() {
      int var1;
      if ((var1 = mFont.b(mFont.d, this.c)) < this.j.width) {
         var1 = this.j.width;
      }

      this.j.a(5, var1, 0);
      var1 = 0;
      if (this.i.length() > 0) {
         var1 = mFont.b(mFont.d, this.i.substring(0, this.e));
      }

      LangLa_ii var10002 = this.j;
      var10002.j = var1 - var10002.width / 2;
   }

   private boolean j() {
      return this.b == 1 && this.m;
   }

   private void k() {
      if (this.j()) {
         this.c = this.B;
      } else {
         this.c = this.i;
      }

      if (this.d < 0 && mFont.b(mFont.d, this.c) + this.d < this.width - this.G - 4 - 13) {
         this.d = this.width - this.G - 10 - mFont.b(mFont.d, this.c);
      }

      if (this.d + mFont.b(mFont.d, this.c.substring(0, this.e)) <= 0) {
         this.d = -mFont.b(mFont.d, this.c.substring(0, this.e));
         this.d += 40;
      } else if (this.d + mFont.b(mFont.d, this.c.substring(0, this.e)) >= this.width - this.G - 12) {
         this.d = this.width - this.G - 10 - mFont.b(mFont.d, this.c.substring(0, this.e)) - 8;
      }

      if (this.d > 0) {
         this.d = 0;
      }

   }

   private void l() {
      if (this.j()) {
         this.B = "";

         for(int var1 = 0; var1 < this.i.length(); ++var1) {
            this.B = this.B + "*";
         }

         if (this.C > 0 && this.e > 0) {
            this.B = this.B.substring(0, this.e - 1) + this.i.charAt(this.e - 1) + this.B.substring(this.e, this.B.length());
         }
      }

   }

   public void a(int var1) {
      this.a("" + var1);
   }

   public int e() {
      try {
         return Integer.parseInt(this.i);
      } catch (Exception var1) {
         return 0;
      }
   }

   public String f() {
      return this.i;
   }

   public void c(String var1) {
      this.a(this.i + var1);
   }

   public void a(String var1, int var2, int var3) {
      if ((var1 = this.i.substring(0, var2) + var1 + this.i.substring(this.e, this.i.length())).length() > this.a) {
         var1 = var1.substring(0, this.a);
      }

      this.i = this.c = var1;
      this.e = var3;
      this.g = Integer.MIN_VALUE;
      this.D = this.C = 0;
      this.l();
      this.k();
      this.d();
   }

   public void a(String var1) {
      if (var1 != null) {
         var1 = this.e(var1);
         this.e = var1.length();
         this.i = this.c = var1;
         this.g = Integer.MIN_VALUE;
         this.D = this.C = 0;
         this.l();
         this.k();
         this.d();
      }
   }

   private void d(String var1) {
      var1 = this.e(var1);
      this.i = var1;
   }

   private String e(String var1) {
      if (var1 != null && var1.length() > this.a) {
         var1 = var1.substring(0, this.a);
      }

      if (this.b == 2) {
         try {
            var1 = "" + Integer.parseInt(var1);
         } catch (Exception var2) {
            var1 = "";
         }
      }

      return var1;
   }

   public void a(Graphics var1) {
      if (!this.v) {
         if (this.l) {
            if (this.t) {
               var1.c(-3089954);
            }

            LangLa_fq.b(var1, 14, 67, 0, 1, this.width, 20);
            var1.c();
         } else if (this.t) {
            Binary2.a(var1, 3, 0, 0, 0, this.width, (int)this.height);
         } else {
            Binary2.a(var1, 305, 0, 0, 1, this.width, (int)(this.height - 1));
         }

         if (this.j()) {
            this.c = this.B;
         } else {
            this.c = this.i;
         }

         if (this.b == 1) {
            if (this.n(0)) {
               var1.e(30);
            }

            LangLa_fq.a(var1, this.F, 0, this.width - this.G + this.G / 2 - 2, this.height / 2, 3);
            var1.d();
         }

         this.a(var1, this.j);
         if (this.c.equals("") && !this.t) {
            mFont.a((mFont)mFont.d, (Graphics)var1, this.h, 1, this.height / 2 - 3, 0, -4738643, 0);
         } else {
            if (this.b == 1 && this.m) {
               mFont.a((mFont)mFont.d, (Graphics)var1, this.c, 1, this.height / 2, 0, -1, -16777216);
            } else {
               mFont.a((mFont)mFont.d, (Graphics)var1, this.c, 1, this.height / 2 - 3, 0, -1, -16777216);
            }

            if (this.t && DataCenter.gI().i % 20 > 15) {
               var1.f(11382189);
               int var2 = 0;

               try {
                  if (this.c.length() > 0) {
                     var2 = mFont.a(mFont.d, this.c.substring(0, this.e));
                  }

                  if (var2 < 0) {
                     var2 = 0;
                  }
               } catch (Exception var3) {
               }

               var1.c(var2 + 1, (this.height - 16) / 2 - 2, 1, 16);
            }
         }

         this.b(var1);
      }
   }

   public void b() {
      try {
         if (this.C > 0) {
            --this.C;
            if (this.C == 0) {
               this.D = 0;
               if (this.A == 1 && this.g != this.E) {
                  this.A = 0;
               }

               this.g = Integer.MIN_VALUE;
               this.l();
            }
         }

         this.j.a();
         if (!this.H.equals(this.i)) {
            this.H = this.i;
            this.g();
         }

      } catch (Exception var2) {
         Utlis.println(var2);
      }
   }

   public void p() {
      byte var1 = 0;
      boolean var7 = false;

      label332: {
         label333: {
            label310: {
               label334: {
                  try {
                     var7 = true;
                     int var2;
                     String var11;
                     if ((var2 = this.cO.c()) != Integer.MIN_VALUE) {
                        var1 = 2;
                        char var12 = (char)var2;
                        if (var2 == 22) {
                           try {
                              com.badlogic.gdx.utils.Clipboard var15 = com.badlogic.gdx.Gdx.app.getClipboard();
                              
                              if (var15.hasContents()) {
                                 var11 = var15.getContents();
                                 String var14 = this.i.substring(0, this.e) + var11;
                                 if (this.e < this.i.length()) {
                                    var14 = var14 + this.i.substring(this.e, this.i.length());
                                 }

                                 this.d(var14);
                                 this.e += var11.length();
                                 var7 = false;
                              } else {
                                 var7 = false;
                              }
                           } catch (Exception var8) {
                              var7 = false;
                           }
                           break label334;
                        }

                        if (this.r) {
                           this.d(String.valueOf(var12));
                           var7 = false;
                           break label334;
                        }

                        if (var12 == 127) {
                           this.c(false);
                           var7 = false;
                           break label334;
                        }

                        if (var12 == '\b') {
                           this.c(true);
                           var7 = false;
                           break label334;
                        }

                        if (this.i.length() >= 0) {
                           if (this.i.length() < this.a) {
                              if (this.b == 2) {
                                 if (var12 < '0') {
                                    var7 = false;
                                    break label334;
                                 }

                                 if (var12 > '9') {
                                    var7 = false;
                                    break label334;
                                 }
                              }

                              var11 = this.i.substring(0, this.e) + var12;
                              if (this.e < this.i.length()) {
                                 var11 = var11 + this.i.substring(this.e, this.i.length());
                              }

                              this.d(var11);
                              ++this.e;
                              var7 = false;
                              break label334;
                           }

                           var7 = false;
                           break label334;
                        }

                        var7 = false;
                        break label334;
                     }

                     int var3;
                     if ((var3 = this.cO.d) != Integer.MIN_VALUE) {
                        var1 = 1;
                        if (var3 == 10) {
                           this.s.b(this.k, (Object)null, this);
                           this.cO.b();
                        } else if (var3 == 127) {
                           this.c(false);
                           var1 = 2;
                        } else {
                           if (var3 == 3) {
                              this.e = 0;
                              var7 = false;
                              break label332;
                           }

                           if (var3 == 132) {
                              this.e = this.i.length();
                              var7 = false;
                              break label333;
                           }
                        }

                        if (var3 == 8 || var3 == -8 || var3 == 204) {
                           this.c(true);
                           var1 = 2;
                        }

                        if (var3 >= 32) {
                           if (this.i.length() > 0 && this.i.length() < this.a) {
                              var11 = this.i.substring(0, this.e) + (char)var3;
                              if (this.e < this.i.length()) {
                                 var11 = var11 + this.i.substring(this.e, this.i.length());
                              }

                              this.d(var11);
                              ++this.e;
                           }

                           var1 = 2;
                        }

                        this.g = Integer.MIN_VALUE;
                        if (this.cO.b[4]) {
                           --this.e;
                           var7 = false;
                        } else if (this.cO.b[6]) {
                           ++this.e;
                           var7 = false;
                        } else if (var3 == 19) {
                           this.c(true);
                           var1 = 2;
                           var7 = false;
                        } else {
                           this.g = var3;
                           var7 = false;
                        }
                     } else {
                        var7 = false;
                     }
                  } catch (Exception var9) {
                     var7 = false;
                     break label310;
                  } finally {
                     if (var7) {
                        if (var1 == 2) {
                           this.l();
                           this.k();
                           this.d();
                           this.cO.b();
                        } else if (var1 == 1) {
                           this.l();
                           this.k();
                           this.d();
                        }

                     }
                  }

                  if (var1 == 2) {
                     this.l();
                     this.k();
                     this.d();
                     this.cO.b();
                     return;
                  }

                  if (var1 == 1) {
                     this.l();
                     this.k();
                     this.d();
                     return;
                  }

                  return;
               }

               this.l();
               this.k();
               this.d();
               this.cO.b();
               return;
            }

            if (var1 == 2) {
               this.l();
               this.k();
               this.d();
               this.cO.b();
               return;
            }

            if (var1 == 1) {
               this.l();
               this.k();
               this.d();
               return;
            }

            return;
         }

         this.l();
         this.k();
         this.d();
         return;
      }

      this.l();
      this.k();
      this.d();
   }

   protected void c(boolean var1) {
      if (var1) {
         if (this.e > 0 && this.i.length() > 0) {
            this.d(this.i.substring(0, this.e - 1) + this.i.substring(this.e, this.i.length()));
            --this.e;
            return;
         }
      } else if (this.e < this.i.length() && this.i.length() > 0) {
         this.d(this.i.substring(0, this.e) + this.i.substring(this.e + 1, this.i.length()));
      }

   }

   public Vector c() {
      if (this.u) {
         return null;
      } else {
         Vector var1 = new Vector();
         if (this.b == 1) {
            var1.addElement(new LangLa_jz(-1000, this.width - this.G, 0, this.width, this.height, (LangLa_ii)null, this));
         }

         var1.addElement(new LangLa_jz(-1001, 0, 0, this.width, this.height, this.j, this));
         return var1;
      }
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      if (!this.u && !this.v) {
         var3 = this.j.j + (var2 - this.j.cx);

         try {
            switch(var1.b) {
            case -1001:
               if (this.s instanceof LangLa_ko && ((LangLa_ko)this.s).o.e() == 6 && beatdz.LangLa_kw.$state_LangLa_kw().d.length() > 0 && !this.i.startsWith("/" + beatdz.LangLa_kw.$state_LangLa_kw().d + ": ")) {
                  this.a("/" + beatdz.LangLa_kw.$state_LangLa_kw().d + ": ");
               }

               if (var3 <= 1) {
                  this.e = 0;
               } else {
                  var2 = 0;

                  for(int var4 = 0; var4 < this.i.length(); ++var4) {
                     int var6 = var2;
                     var2 = mFont.b(mFont.d, this.i.substring(0, var4)) + mFont.b(mFont.d, "" + this.i.charAt(var4)) / 2;
                     if (var6 <= var3 && var3 <= var2) {
                        this.e = var4;
                        break;
                     }

                     if (var4 == this.i.length() - 1) {
                        this.e = this.i.length();
                     }
                  }
               }

               this.d();
               Binary2.a(this, this.i, this.h, this.a, this.b, false);
               break;
            case -1000:
               if (!this.i.equals("")) {
                  this.m = !this.m;
                  this.l();
                  this.k();
                  this.d();
                  return;
               }
            }

         } catch (Exception var5) {
            Utlis.println(var5);
         }
      }
   }

   public void g() {
   }
}
