package beatdz;
public class LangLa_ga {
   public LangLa_jz[] a;
   public short b = -1;
   private int e;
   private int f;
   public XYEntity c;
   public XYEntity d;
   private int g = 5;

   public void cancel() {
      if (a != null && b >= 0 && b < a.length && a[b] != null) {
         a[b].i = 0L;
         if (a[b].j != null) a[b].j.c();
      }
      b = -1;
   }

   public void setRegions(LangLa_jz[] next) {
      // Keep the pressed action and its timer across layout refreshes, even if
      // the list changes order. Removed actions are cancelled, never retargeted.
      LangLa_jz pressed = a != null && b >= 0 && b < a.length ? a[b] : null;
      if (pressed != null) {
         int selected = -1;
         for (int index = 0; index < next.length; index++) {
            LangLa_jz candidate = next[index];
            if (candidate != null && candidate.a == pressed.a && candidate.b == pressed.b
                  && candidate.j == pressed.j && samePayload(candidate.k, pressed.k)) {
               selected = index; candidate.i = pressed.i; break;
            }
         }
         if (selected < 0) cancel();
         b = (short)selected;
      }
      a = next;
   }

   private static boolean samePayload(Object left, Object right) {
      if (left instanceof LangLa_lk && right instanceof LangLa_lk) {
         // Chat/quest links recreate their text payload every layout update.
         LangLa_lk a = (LangLa_lk)left, b = (LangLa_lk)right;
         return a.a == b.a && java.util.Objects.equals(a.b, b.b) && java.util.Objects.equals(a.c, b.c);
      }
      return java.util.Objects.equals(left, right);
   }

   public short a(int var1, int var2) {
      this.b = -1;
      this.e = var1;
      this.f = var2;

      for(short var3 = 0; var3 < this.a.length; ++var3) {
         if (this.a[var3] != null) {
            if (Utlis.inRange(this.a[var3].c, this.a[var3].d, this.a[var3].e, this.a[var3].f, var1, var2)) {
               this.b = var3;
               this.a[var3].i = Utlis.time();
               if (this.a[var3].j != null) {
                  if (this.a[var3].c() == this.a[var3].j.width && this.a[var3].d() == this.a[var3].j.height) {
                     this.a[var3].j.a(var1 - this.a[var3].c, var2 - this.a[var3].d);
                     this.a[var3].j.o = false;
                  } else {
                     this.a[var3].j.a(var1 - (this.a[var3].c - this.a[var3].g), var2 - (this.a[var3].d - this.a[var3].h));
                     this.a[var3].j.o = true;
                  }
               }
               break;
            }

            this.a[var3].i = 0L;
         }
      }

      return this.b;
   }

   public LangLa_jz b(int var1, int var2) {
      LangLa_jz var3 = null;

      try {
         if (this.a[this.b] != null) {
            if (this.a[this.b].j != null) {
               if (this.a[this.b].c() == this.a[this.b].j.width && this.a[this.b].d() == this.a[this.b].j.height) {
                  this.a[this.b].j.c(var1 - this.a[this.b].c, var2 - this.a[this.b].d);
               } else {
                  this.a[this.b].j.c(var1 - (this.a[this.b].c - this.a[this.b].g), var2 - (this.a[this.b].d - this.a[this.b].h));
               }
            }

            if (Utlis.inRange(this.a[this.b].c, this.a[this.b].d, this.a[this.b].e, this.a[this.b].f, var1, var2)) {
               var3 = this.a[this.b];
            }

            this.a[this.b].i = 0L;
         }

         this.b = -1;
      } catch (Exception var4) {
      }

      return var3;
   }

   public LangLa_jz c(int var1, int var2) {
      LangLa_jz var3 = null;

      try {
         if (this.a[this.b] != null) {
            if (Utlis.inRange(this.a[this.b].c, this.a[this.b].d, this.a[this.b].e, this.a[this.b].f, var1, var2)) {
               if (Utlis.positive(var1 - this.e) >= this.g || Utlis.positive(var2 - this.f) >= this.g) {
                  var3 = this.a[this.b];
                  if (this.a[this.b].j != null) {
                     this.a[this.b].j.b(var1 - this.e, var2 - this.f);
                  }
               }
            } else {
               if (this.a[this.b].j != null) {
                  this.a[this.b].j.c(var1 - this.a[this.b].c, var2 - this.a[this.b].d);
               }

               this.a[this.b].i = 0L;
               this.b = -1;
            }
         }
      } catch (Exception var4) {
      }

      return var3;
   }

   public void a(LangLa_ii var1, int var2, int var3) {
      try {
         if (var1 == null) {
            if (this.a[this.b] != null && this.a[this.b].j != null) {
               this.a[this.b].j.b(var2 - this.e, var3 - this.f);
            }

            return;
         }

         var1.b(var2 - this.e, var3 - this.f);
      } catch (Exception var4) {
      }

   }

   public boolean a(int var1) {
      return this.b == var1 && Utlis.time() - this.a[var1].i >= 100L;
   }
}
