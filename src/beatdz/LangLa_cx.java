package beatdz;
import com.tgame.model.Caption;
import java.util.Vector;

public abstract class LangLa_cx extends LangLa_cy {
   public byte cF;
   public Vector cG = new Vector();
   public LangLa_cy cH;
   public LangLa_cy cI;
   public LangLa_cy cJ;
   public LangLa_ii cK;
   public LangLa_fm cL;
   public LangLa_jb cM;
   

   public void a(int var1, byte var2) {
      switch(var2) {
      case 0:
         this.cM = new LangLa_jb(this, (byte)0, this.cx);
         this.cx = (short)var1;
         return;
      case 1:
         this.cM = new LangLa_jb(this, (byte)0, this.cx);
         this.cx = (short)(-var1);
         return;
      case 2:
         this.cM = new LangLa_jb(this, (byte)1, this.cy);
         this.cy = (short)var1;
         return;
      case 3:
         this.cM = new LangLa_jb(this, (byte)1, this.cy);
         this.cy = (short)(-var1);
      default:
      }
   }

   public void k(int var1) {
      this.cM = new LangLa_jb(this, (byte)1, this.cy);
      this.cy = 1000;
   }

   public void setSize(int var1, int var2) {
      super.setSize(var1, var2);
   }

   public boolean a(char c) {
        for (int i = 0; i < this.cG.size(); i++) {
            try {
                try {
                    LangLa_cs langLa_cs = (LangLa_cs) this.cG.elementAt(i);
                    if (langLa_cs.t && (langLa_cs instanceof mTextBox)) {
                        langLa_cs.cO.a(c);
                        return true;
                    }
                } catch (Exception e) {
                }
            } catch (Exception e2) {
            }
        }
        return false;
    }

     public boolean l(int i) {
        for (int i2 = 0; i2 < this.cG.size(); i2++) {
            try {
                try {
                    LangLa_cs langLa_cs = (LangLa_cs) this.cG.elementAt(i2);
                    if (langLa_cs.t && (langLa_cs instanceof mTextBox)) {
                        langLa_cs.cO.a(i);
                        return true;
                    }
                } catch (Exception e) {
                }
            } catch (Exception e2) {
            }
        }
        return false;
    }

    public boolean m(int i) {
        for (int i2 = 0; i2 < this.cG.size(); i2++) {
            try {
                try {
                    LangLa_cs langLa_cs = (LangLa_cs) this.cG.elementAt(i2);
                    if (langLa_cs.t && (langLa_cs instanceof mTextBox)) {
                        langLa_cs.cO.b(i);
                        return true;
                    }
                } catch (Exception e) {
                }
            } catch (Exception e2) {
            }
        }
        return false;
    }
   public void M() {
      try {
         for(int var1 = 0; var1 < this.cG.size(); ++var1) {
            try {
               ((LangLa_cs)this.cG.elementAt(var1)).R();
            } catch (Exception var2) {
            }
         }

         this.R();
      } catch (Exception var3) {
      }
   }

   private long lastUpdateErrorLog;

   public void N() {
      try {
         if (this.cM != null && this.cM.a()) {
            this.cM = null;
         }

         for(int var1 = 0; var1 < this.cG.size(); ++var1) {
            try {
               ((LangLa_cs)this.cG.elementAt(var1)).b();
            } catch (Exception var2) {
            }
         }

         this.b();
      } catch (Exception var3) {
         long now = System.currentTimeMillis();
         if (now - lastUpdateErrorLog >= 5000L) {
            lastUpdateErrorLog = now;
            Utlis.println(var3);
         }
      }
   }

   protected boolean O() {
      return this.cM != null && this.cM.b();
   }

   public void P() {
      try {
         for(int var2 = 0; var2 < this.cG.size(); ++var2) {
            try {
               LangLa_cs var1;
               (var1 = (LangLa_cs)this.cG.elementAt(var2)).p();
               var1.cO.a();
            } catch (Exception var3) {
            }
         }

         this.p();
         this.cO.a();
      } catch (Exception var4) {
      }
   }

   public static LangLa_ki a(int var0, int var1, int var2, LangLa_cx var3, int var4) {
      LangLa_kd var6;
      (var6 = new LangLa_kd(var4)).c = Caption.qZ;
      var6.d = new short[var6.c.length];

      for(int var5 = 0; var5 < var6.d.length; ++var5) {
         if (var5 == 7) {
            var6.d[var5] = 881;
         }

         if (var5 == 8) {
            var6.d[var5] = 497;
         } else {
            var6.d[var5] = (short)(496 + var5);
         }
      }

      return new LangLa_ki(var0, var1, 100, 20, var2, var6, var3, true);
   }

   public LangLa_dz a(int var1, int var2, String var3, LangLa_cx var4, int var5, int var6) {
      LangLa_dz var7 = new LangLa_dz(var1, var2, 0, 0, var3, var4, var5, var6);
      this.a(var7);
      return var7;
   }

   public mTextBox a(int var1, int var2, int var3, String var4, LangLa_cx var5, int var6, int var7) {
      mTextBox var8 = new mTextBox(var1, var2, var3, var4, var5, var6, var7);
      this.a(var8);
      return var8;
   }

   public mTextBox a(int var1, int var2, int var3, String var4, LangLa_cx var5, int var6) {
      mTextBox var7 = new mTextBox(var1, var2, var3, var4, var5, -11, var6);
      this.a(var7);
      return var7;
   }

   public LangLa_cm b(int var1, int var2, int var3, String var4, LangLa_cx var5, int var6) {
      LangLa_cm var7 = new LangLa_cm(var1, var2, var3, var4, var5, -11, var6);
      this.a(var7);
      return var7;
   }

   public LangLa_ce a(int var1, int var2, String var3, LangLa_cx var4, int var5) {
      LangLa_ce var6 = new LangLa_ce(var1, var2, var3, var4, var5);
      this.a(var6);
      return var6;
   }

   public LangLa_cl a(int var1, int var2, String var3, LangLa_cx var4, LangLa_kc var5) {
      LangLa_cl var6 = new LangLa_cl(var1, var2, var3, var4, var5);
      this.a(var6);
      return var6;
   }

   public LangLa_cg a(int var1, int var2, int var3, int var4, LangLa_kd var5, LangLa_cx var6, int var7) {
      LangLa_cg var8 = new LangLa_cg(var1, var2, var3, var4, var5, var6, var7, true);
      this.a(var8);
      return var8;
   }

   private void a() {
      if (this.cI != null) {
         ((LangLa_cg)this.cI).a();
         this.cI = null;
      }

   }

   public void f(int var1, int var2) {
      if (this.cP != null) {
         this.cP.c = XYEntity.create(var1, var2);
      }

      LangLa_cs var3 = null;
      boolean var7 = false;

      label373: {
         label374: {
            label375: {
               try {
                  var7 = true;

                  int var4;
                  for(var4 = this.cG.size() - 1; var4 >= 0; --var4) {
                     (var3 = (LangLa_cs)this.cG.elementAt(var4)).t = false;
                  }

                  for(var4 = this.cG.size() - 1; var4 >= 0; --var4) {
                     if ((var3 = (LangLa_cs)this.cG.elementAt(var4)).cP != null && var3.cP.a(var1 - var3.cx, var2 - var3.cy) >= 0) {
                        this.c(var3);
                        var7 = false;
                        break label375;
                     }
                  }

                  if (this.cP == null) {
                     var7 = false;
                     break label373;
                  }

                  if (this.cP.a(var1 - this.cx, var2 - this.cy) < 0) {
                     var7 = false;
                     break label373;
                  }

                  var7 = false;
                  break label374;
               } catch (Exception var8) {
                  var7 = false;
               } finally {
                  if (var7) {
                     if (this.cL != null && (var3 == null || !this.cL.equals(var3))) {
                        this.b((LangLa_cs)this.cL);
                     }

                     if (this.cI != null && (var3 == null || !this.cI.equals(var3))) {
                        this.a();
                     }

                     if (this.cK != null) {
                        this.cK.c();
                     }

                     this.cI = null;
                     this.cJ = null;
                     this.cH = null;
                     this.cK = null;
                  }
               }

               if (this.cL != null && (var3 == null || !this.cL.equals(var3))) {
                  this.b((LangLa_cs)this.cL);
               }

               if (this.cI != null && (var3 == null || !this.cI.equals(var3))) {
                  this.a();
               }

               if (this.cK != null) {
                  this.cK.c();
               }

               this.cI = null;
               this.cJ = null;
               this.cH = null;
               this.cK = null;
               return;
            }

            if (this.cL != null && (var3 == null || !this.cL.equals(var3))) {
               this.b((LangLa_cs)this.cL);
            }

            if (this.cI != null && (var3 == null || !this.cI.equals(var3))) {
               this.a();
            }

            if (this.cK != null) {
               this.cK.c();
            }

            this.cI = null;
            this.cJ = null;
            this.cH = null;
            this.cK = null;
            return;
         }

         if (this.cL != null && (var3 == null || !this.cL.equals(var3))) {
            this.b((LangLa_cs)this.cL);
         }

         if (this.cI != null && (var3 == null || !this.cI.equals(var3))) {
            this.a();
         }

         if (this.cK != null) {
            this.cK.c();
         }

         this.cI = null;
         this.cJ = null;
         this.cH = null;
         this.cK = null;
         return;
      }

      var3 = null;
      if (this.cL != null && (var3 == null || !this.cL.equals(var3))) {
         this.b((LangLa_cs)this.cL);
      }

      if (this.cI != null && (var3 == null || !this.cI.equals(var3))) {
         this.a();
      }

      if (this.cK != null) {
         this.cK.c();
      }

      this.cI = null;
      this.cJ = null;
      this.cH = null;
      this.cK = null;
   }

   public void g(int var1, int var2) {
      try {
         if (this.cP != null) {
            this.cP.d = XYEntity.create(var1, var2);
         }

         boolean var4 = false;
         this.cO.e = var4;

         LangLa_jz var10;
         for(int var9 = this.cG.size() - 1; var9 >= 0; --var9) {
            LangLa_cs var3;
            if ((var3 = (LangLa_cs)this.cG.elementAt(var9)).cP != null && var3.cP.b >= 0) {
               var10 = var3.cP.b(var1 - var3.cx, var2 - var3.cy);
               if (var3 instanceof LangLa_cb) {
                  this.a(var10, var1 - this.cx, var2 - this.cy);
                  return;
               }

               if (var10 != null && (var10.j == null || !var10.j.b())) {
                  var3.a(var10, var1 - var3.b_(), var2 - var3.c_());
               }

               if (var3 instanceof LangLa_cg && ((LangLa_cg)var3).j) {
                  this.cI = var3;
               } else if (var3 instanceof mTextBox) {
                  this.cJ = var3;
               }

               var3.s();
               return;
            }
         }

         if (this.cP != null && this.cP.b >= 0) {
            if ((var10 = this.cP.b(var1 - this.cx, var2 - this.cy)) != null && (var10.j == null || !var10.j.b())) {
               this.a(var10, var1 - this.cx, var2 - this.cy);
            }

         } else {
            this.s();
         }
      } catch (Exception var7) {
         Utlis.println(var7);
      } finally {
         if (this.cK != null) {
            this.cK.c();
         }

         this.cH = null;
         this.cK = null;
      }
   }

   public void h(int var1, int var2) {
      try {
         if (this.cH != null) {
            this.cH.cP.a(this.cK, var1 - this.cH.cx, var2 - this.cH.cy);
         } else {
            LangLa_jz var6;
            for(int var4 = this.cG.size() - 1; var4 >= 0; --var4) {
               LangLa_cy var3;
               if ((var3 = (LangLa_cy)this.cG.elementAt(var4)).cP != null && var3.cP.b >= 0) {
                  if ((var6 = var3.cP.c(var1 - var3.cx, var2 - var3.cy)) != null && var6.j != null) {
                     this.cH = var3;
                     this.cK = var6.j;
                  }

                  return;
               }
            }

            if (this.cP != null && this.cP.b >= 0) {
               if ((var6 = this.cP.c(var1 - this.cx, var2 - this.cy)) != null && var6.j != null) {
                  this.cH = this;
                  this.cK = var6.j;
               }

            }
         }
      } catch (Exception var5) {
         Utlis.println(var5);
      }
   }

   public void a(LangLa_cs var1) {
      if (var1 != null && !this.cG.contains(var1)) {
         this.cG.addElement(var1);
      }
   }

   public void b(LangLa_cs var1) {
      if (var1 != null) {
         this.cG.removeElement(var1);
         if (this.cL != null && var1.equals(this.cL)) {
            this.cL = null;
         }

      }
   }

   public void c(LangLa_cs var1) {
      if (var1 != null) {
         this.cG.removeElement(var1);
         this.cG.addElement(var1);
         var1.t = true;
         if (var1.w != null) {
            var1.w.c(var1);
            var1 = var1.w.a();
            this.cG.removeElement(var1);
            this.cG.addElement(var1);
         }

      }
   }

   public void Q() {
      LangLa_cs var1 = null;

      label29:
      for(int var2 = 0; var2 < this.cG.size(); ++var2) {
         if ((var1 = (LangLa_cs)this.cG.elementAt(var2)).t) {
            var1.t = false;
            b(this.cG);
            var2 = this.cG.indexOf(var1);

            do {
               ++var2;
               if (var2 >= this.cG.size()) {
                  var2 = 0;
               }

               if (this.cG.elementAt(var2).equals(var1)) {
                  var1 = null;
                  break label29;
               }
            } while(!(this.cG.elementAt(var2) instanceof mTextBox));

            var1 = (LangLa_cs)this.cG.elementAt(var2);
            break;
         }
      }

      this.c(var1);
   }

   private static void b(Vector var0) {
      try {
         for(int var4 = 0; var4 < var0.size() - 1; ++var4) {
            LangLa_cs var1 = (LangLa_cs)var0.elementAt(var4);

            for(int var5 = var4 + 1; var5 < var0.size(); ++var5) {
               LangLa_cs var2;
               LangLa_cs var3;
               if ((var2 = (LangLa_cs)var0.elementAt(var5)).cy < var1.cy) {
                  var3 = var2;
                  var2 = var1;
                  var1 = var3;
                  var0.setElementAt(var3, var4);
                  var0.setElementAt(var2, var5);
               } else if (var2.cy == var1.cy && var2.cx < var1.cx) {
                  var3 = var2;
                  var2 = var1;
                  var1 = var3;
                  var0.setElementAt(var3, var4);
                  var0.setElementAt(var2, var5);
               }
            }
         }

      } catch (Exception var6) {
      }
   }

   public abstract void b(int var1, Object var2, LangLa_cy var3);

   public abstract void b(int var1, Object var2);

   public abstract void a(int var1, Object var2, LangLa_cy var3);

   public abstract void a(int var1, Object var2);

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public boolean cN;
public void initialize() {
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.LangLa_cx");
public static SessionState $state_LangLa_cx() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
