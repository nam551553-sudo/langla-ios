package beatdz;



public class LangLa_cm extends mTextBox {
   private int x;
   private int y;
   private String[] z;

   public LangLa_cm(int var1, int var2, int var3, String var4, LangLa_cx var5, int var6, int var7) {
      super(var1, var2, var3, var4, var5, -11, 0);
      this.h = var4;
      this.s = var5;
      this.k = -11;
      this.x = var7;
      this.y = var7 == 1 ? 18 : 14;
      this.setXY(var1, var2);
      this.setSize(var3, var7 * this.y + 4);
      this.j = new LangLa_ii((byte)1, 0, 2, this.width, this.y * var7, this.y, var7);
      this.z = mFont.c(mFont.d, var4, this.width - 10);
      this.a("");
   }

   public int a() {
      int var1 = 0;

      for(int var2 = 0; var2 < this.f; ++var2) {
         var1 += this.z[var2].length() + 1;
      }

      return var1;
   }

   public void a(String var1) {
      if (var1.equals("")) {
         this.e = 0;
         this.i = "";
         this.z = mFont.c(mFont.d, this.h, this.width - 10);
         this.j.j = 0;
         this.j.d();
      } else {
         this.i = var1;
         if (!var1.equals("")) {
            this.z = mFont.c(mFont.d, var1, this.width - 10);
            this.j.j = this.f;
            this.d();
            this.j.d();
         } else {
            this.z = mFont.c(mFont.d, this.h, this.width - 10);
            this.j.j = 0;
            this.j.d();
         }
      }
   }

   public void a(String var1, int var2, int var3) {
      if (var1.equals("")) {
         this.e = 0;
         this.i = "";
         this.z = mFont.c(mFont.d, this.h, this.width - 10);
         this.j.j = 0;
         this.j.d();
      } else {
         var1 = this.i.substring(0, this.a() + var2) + var1 + this.i.substring(this.a() + this.e, this.i.length());
         this.i = var1;
         if (!this.i.equals("")) {
            this.z = mFont.c(mFont.d, this.i, this.width - 10);
            this.e = var3;
            if (this.e > this.z[this.f].length()) {
               this.e = this.e - this.z[this.f].length() - 1;
               ++this.f;
            }

            this.j.j = this.f;
            this.d();
            this.j.d();
         } else {
            this.z = mFont.c(mFont.d, this.h, this.width - 10);
            this.j.j = 0;
            this.j.d();
         }
      }
   }

   private String d(String var1) {
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

   private void a(String var1, int var2) {
      var1 = this.d(var1);
      this.a(var1);

      for(int var4 = 0; var4 < this.z.length; ++var4) {
         String var3 = this.z[var4];
         if (var4 < this.z.length - 1 && !var3.endsWith(" ")) {
            var3 = var3 + " ";
         }

         if (var2 < var3.length()) {
            this.f = var4;
            this.e = var2;
            return;
         }

         var2 -= var3.length();
         this.f = var4;
         this.e = var3.length();
      }

   }

   protected void c(boolean var1) {
      try {
         if (this.i.equals("")) {
            return;
         }

         String var2;
         String[] var3;
         int var4;
         String var5;
         int var7;
         if (!var1) {
            var7 = 0;
            var2 = "";
            var3 = new String[]{""};
            if (this.i.length() > 0) {
               var3 = this.z;
            }

            for(var4 = 0; var4 < var3.length; ++var4) {
               var5 = var3[var4];
               if (var4 < var3.length - 1 && !var5.endsWith(" ")) {
                  var5 = var5 + " ";
               }

               if (this.f == var4) {
                  var5 = var5.substring(0, this.e) + var5.substring(this.e + 1, var5.length());
                  var7 += this.e;
               } else if (var4 < this.f) {
                  var7 += var5.length();
               }

               var2 = var2 + var5;
            }

            var2 = this.d(var2);
            this.a(var2, var7);
            return;
         }

         var7 = 0;
         var2 = "";
         var3 = new String[]{""};
         if (this.i.length() > 0) {
            var3 = this.z;
         }

         for(var4 = 0; var4 < var3.length; ++var4) {
            var5 = var3[var4];
            if (var4 < var3.length - 1 && !var5.endsWith(" ")) {
               var5 = var5 + " ";
            }

            if (this.f == var4) {
               if (this.e > 0) {
                  var5 = var5.substring(0, this.e - 1) + var5.substring(this.e, var5.length());
               }

               var7 += this.e - 1;
            } else if (var4 < this.f) {
               var7 += var5.length();
            }

            var2 = var2 + var5;
         }

         if (var7 < 0) {
            var7 = 0;
         }

         this.a(var2, var7);
      } catch (Exception var6) {
      }

   }

   private void e(String var1) {
      int var2 = 0;
      String var3 = "";
      String[] var4 = new String[]{""};
      if (this.i.length() > 0) {
         var4 = this.z;
      }

      for(int var5 = 0; var5 < var4.length; ++var5) {
         String var6 = var4[var5];
         if (var5 < var4.length - 1 && !var6.endsWith(" ")) {
            var6 = var6 + " ";
         }

         if (this.f == var5) {
            var6 = var6.substring(0, this.e) + var1 + var6.substring(this.e, var6.length());
            var2 += this.e + var1.length();
         } else if (var5 < this.f) {
            var2 += var6.length();
         }

         var3 = var3 + var6;
      }

      this.a(var3, var2);
   }

   public void p() {
      byte var1 = 0;
      boolean var6 = false;

      label280: {
         label297: {
            label298: {
               label277: {
                  try {
                     var6 = true;
                     int var2;
                     if ((var2 = this.cO.c()) == Integer.MIN_VALUE) {
                        int var11;
                        if ((var11 = this.cO.d) != Integer.MIN_VALUE) {
                           var1 = 1;
                           if (var11 == 10) {
                              this.s.b(this.k, (Object)null, this);
                              this.cO.b();
                           } else if (var11 == 127) {
                              this.c(false);
                              var1 = 2;
                           } else {
                              if (var11 == 3) {
                                 this.f = 0;
                                 this.e = 0;
                                 var6 = false;
                                 break label280;
                              }

                              if (var11 == 132) {
                                 this.f = this.z.length - 1;
                                 this.e = this.z[this.f].length();
                                 var6 = false;
                                 break label297;
                              }
                           }

                           if (var11 == 8 || var11 == -8 || var11 == 204) {
                              this.c(true);
                              var1 = 2;
                           }

                           if (var11 >= 32) {
                              if (this.i.length() > 0 && this.i.length() < this.a) {
                                 this.e(String.valueOf((char)var11));
                              }

                              var1 = 2;
                           }

                           this.g = Integer.MIN_VALUE;
                           if (this.cO.b[4]) {
                              if (this.e > 0) {
                                 --this.e;
                                 var6 = false;
                              } else if (this.f > 0) {
                                 --this.f;
                                 this.e = this.z[this.f].length();
                                 var6 = false;
                              } else {
                                 var6 = false;
                              }
                           } else if (this.cO.b[6]) {
                              if (this.e < this.z[this.f].length()) {
                                 ++this.e;
                                 var6 = false;
                              } else if (this.f < this.z.length - 1) {
                                 ++this.f;
                                 this.e = 0;
                                 var6 = false;
                              } else {
                                 var6 = false;
                              }
                           } else if (this.cO.b[2]) {
                              --this.f;
                              var6 = false;
                           } else if (this.cO.b[8]) {
                              ++this.f;
                              var6 = false;
                           } else if (var11 == 19) {
                              this.c(true);
                              var1 = 2;
                              var6 = false;
                           } else {
                              this.g = var11;
                              var6 = false;
                           }
                        } else {
                           var6 = false;
                        }
                        break label277;
                     }

                     var1 = 2;
                     char var3 = (char)var2;
                     if (var2 == 22) {
                        com.badlogic.gdx.utils.Clipboard var9 = com.badlogic.gdx.Gdx.app.getClipboard();
                        
                        if (var9.hasContents()) {
                           this.e(var9.getContents());
                           this.f = this.z.length - 1;
                           this.e = this.z[this.f].length();
                           var6 = false;
                        } else {
                           var6 = false;
                        }
                     } else if (var3 == 127) {
                        this.c(false);
                        var6 = false;
                     } else if (var3 == '\b') {
                        this.c(true);
                        var6 = false;
                     } else if (this.i.length() >= 0) {
                        if (this.i.length() < this.a) {
                           this.e(String.valueOf(var3));
                           var6 = false;
                        } else {
                           var6 = false;
                        }
                     } else {
                        var6 = false;
                     }
                  } catch (Exception var7) {
                     var6 = false;
                     break label298;
                  } finally {
                     if (var6) {
                        if (var1 == 2) {
                           this.a(this.i);
                           this.j();
                           this.cO.b();
                        } else if (var1 == 1) {
                           this.a(this.i);
                           this.j();
                        }

                     }
                  }

                  this.a(this.i);
                  this.j();
                  this.cO.b();
                  return;
               }

               if (var1 == 2) {
                  this.a(this.i);
                  this.j();
                  this.cO.b();
                  return;
               }

               if (var1 == 1) {
                  this.a(this.i);
                  this.j();
                  return;
               }

               return;
            }

            if (var1 == 2) {
               this.a(this.i);
               this.j();
               this.cO.b();
               return;
            }

            if (var1 == 1) {
               this.a(this.i);
               this.j();
               return;
            }

            return;
         }

         this.a(this.i);
         this.j();
         return;
      }

      this.a(this.i);
      this.j();
   }

   private void j() {
      if (this.f <= 0 || this.z == null) {
         this.f = 0;
      }

      if (this.f >= this.z.length) {
         this.f = this.z.length - 1;
      }

      if (this.e <= 0) {
         this.e = 0;
      }

      if (this.e >= this.z[this.f].length()) {
         this.e = this.z[this.f].length();
      }

   }

   protected void d() {
      this.j.a(this.j.g, this.y, this.z.length);
   }

   public void b() {
      this.j.a();
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      var2 -= 5;

      try {
         switch(var1.b) {
         case -1001:
            if (this.i.equals("")) {
               Binary2.a(this, this.i, this.h, this.a, this.b, false);
               return;
            } else if (var1.j.k >= 0) {
               this.f = var1.j.k;
               var3 = 0;
               String var4 = this.z[this.f];

               for(int var5 = 0; var5 < var4.length(); ++var5) {
                  int var7 = var3;
                  var3 = mFont.b(mFont.d, var4.substring(0, var5)) + mFont.b(mFont.d, "" + var4.charAt(var5)) / 2;
                  if (var7 <= var2 && var2 <= var3) {
                     this.e = var5;
                     break;
                  }

                  if (var5 == var4.length() - 1) {
                     this.e = var4.length();
                  }
               }

               Binary2.a(this, this.i, this.h, this.a, this.b, false);
            }
         default:
         }
      } catch (Exception var6) {
         Utlis.println(var6);
      }
   }

   public void a(Graphics var1) {
      if (this.t) {
         var1.c(-3089954);
      }

      this.a(var1, 0, 0, this.width, this.height, -14, 84, 5, 1, 1);
      var1.c();
      this.a(var1, this.j);
      int var2;
      if (!this.i.equals("")) {
         for(var2 = 0; var2 < this.z.length; ++var2) {
            if (this.j.b(var2)) {
               mFont.a((mFont)mFont.d, (Graphics)var1, this.z[var2], 6, this.y / 2 + var2 * this.y - 1, 0, -1, -16777216);
            }
         }
      } else if (!this.t) {
         for(var2 = 0; var2 < this.z.length; ++var2) {
            if (this.j.b(var2)) {
               mFont.a((mFont)mFont.d, (Graphics)var1, this.z[var2], 6, this.y / 2 + var2 * this.y - 1, 0, -4738643, 0);
            }
         }
      }

      if (this.t && DataCenter.gI().i % 20 > 15) {
         try {
            var1.f(11382189);
            String var4 = this.z[this.f];
            if ((var2 = mFont.a(mFont.d, var4.substring(0, this.e))) < 0) {
               var2 = 0;
            }

            var1.c(var2 + 1 + 5, this.f * this.y + this.y / 2 - 7 - 1, 1, 16);
         } catch (Exception var3) {
         }
      }

      this.b(var1);
   }
}
