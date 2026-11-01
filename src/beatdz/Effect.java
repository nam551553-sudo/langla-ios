package beatdz;import java.util.Vector;

public class Effect extends XYEntity {
   public int id;
   public int value;
   public long timeStart;
   public int maintain;
   public int e;
   public LangLa_jw f;
   public Vector g = new Vector();
   public Mob h;

   public Effect(int var1, int var2, long var3, int var5, Entity var6) {
      this.id = var1;
      this.value = var2;
      this.timeStart = var3;
      this.maintain = var5;
      if (this.getEffectTemplate().idMob > 0) {
         this.f = new LangLa_jw(this.getEffectTemplate().idMob, var6.cx, var6.cy, -1);
      }

   }

   public void a() {
      this.f.k = -2;
   }

   public void b() {
      if (this.f != null) {
         this.f.q();
      }

      for(int var1 = 0; var1 < this.g.size(); ++var1) {
         if (((Effect)this.g.get(var1)).f != null) {
            ((Effect)this.g.get(var1)).f.q();
         }
      }

   }

   public boolean c() {
      return this.id == 8 || this.id == 9 || this.id == 10 || this.id == 11 || this.id == 12 || this.id == 35 || this.id == 36 || this.id == 38 || this.id == 75 || this.id == 102 || this.id >= 93 && this.id <= 96;
   }

   public String d() {
      switch(this.id) {
      case 67:
         return Utlis.replaceAll(this.getEffectTemplate().detail, Utlis.k(this.value));
      case 70:
         return Utlis.replaceAll(this.getEffectTemplate().detail, Utlis.l(this.value));
      default:
         return Utlis.replaceAll(this.getEffectTemplate().detail, "" + this.value);
      }
   }

   public void a(Entity var1) {
      if (this.f != null && this.f.k != -2) {
         this.f.b(var1);
      }

      Char var2;
      if (var1 instanceof Char) {
         var2 = (Char)var1;
         if (this.getEffectTemplate().type == 91 && var2.arrItemBody[16] != null) {
            if (var2.arrItemBody[16].id != 812 && !var2.arrItemBody[16].strOptions.startsWith("340,812")) {
               if (var2.arrItemBody[16].id != 789 && !var2.arrItemBody[16].strOptions.startsWith("340,789")) {
                  if (var2.arrItemBody[16].id != 855 && !var2.arrItemBody[16].strOptions.startsWith("340,855")) {
                     if (var2.arrItemBody[16].id == 880 || var2.arrItemBody[16].strOptions.startsWith("340,880")) {
                        this.e = 1117;
                     }
                  } else {
                     this.e = 1094;
                  }
               } else {
                  this.e = 1031;
               }
            } else {
               this.e = 1056;
            }
         }
      }

      if (this.id == 57 || this.id == 62) {
         var2 = (Char)var1;
         if (this.h == null) {
            this.h = new Mob();
            switch(this.id) {
            case 57:
               this.h.id = 217;
               break;
            case 62:
               this.h.id = 219;
               break;
            case 64:
               this.h.id = 220;
            }

            this.h.hp = 1;
            this.h.b(this.cx, this.cy);
            this.h.speedMove = this.h.getMobTemplate().speedMoveByte;
            this.h.dir = var2.ag;
            this.h.cx = (short)(var2.cx + (var2.ag == 3 ? 35 : -35));
            this.h.cy = this.cy;
            this.h.M = 14;
         }

         short var3 = this.h.cx;
         this.h.t();
         this.h.p = (short)var1.m();
         this.h.q = (short)var1.n();
         Mob var10002 = this.h;
         var10002.dir = (byte)(var3 > var10002.cx ? 3 : 2);
         if (var2.z) {
            if (var2.isMe()) {
               this.h.U = 1;
            } else {
               this.h.U = 2;
            }
         } else {
            this.h.U = 0;
         }

         LangLa_lo var4 = new LangLa_lo(0);
         if (this.h.getMobTemplate().type == 4) {
            this.h.dir = var2.ag;
            this.h.cx = (short)(var2.cx + (var2.ag == 3 ? 35 : -35));
         }

         var4.setXY(this.h.cx, this.h.cy);
         var4.o = this.h;
         GameSrc.gI().a((Entity)var4);
      }

   }

   public EffectTemplate getEffectTemplate() {
      return DataCenter.gI().EffectTemplate[this.id];
   }

   public void a(Graphics var1, int var2, int var3, Char var4) {
      try {
         int var7 = this.getEffectTemplate().idIcon;
         if (this.getEffectTemplate().id == 42) {
            if (this.value >= 100) {
               var7 = 564;
            } else if (this.value >= 75) {
               var7 = 563;
            }
         } else if (this.getEffectTemplate().id == 47 && this.value >= 300) {
            var7 = 566;
         }

         if (this.e != 0) {
            var7 = this.e;
         }

         LangLa_fq.a(var1, var7, 0, var2, var3, 20);
         var7 = this.maintain - (int)(Utlis.time() - this.timeStart);
         int var5 = this.maintain / 4;
         if (this.maintain == -1) {
            return;
         }

         if (var7 > var5 * 3) {
            if ((var7 = (var7 - var5 * 3) * 14 / var5) > 14) {
               var7 = 14;
            }

            LangLa_fq.a(var1, 315, 0, var2, var3, 20);
            if (var7 > 0) {
               LangLa_fq.a(var1, 315, 90, var2 + (14 - var7), var3, var7 * DataCenter.gI().zoomLevel, 1 * DataCenter.gI().zoomLevel, 0, 0, 1, var7, 20);
            }

            LangLa_fq.a(var1, 315, -270, var2, var3 + 13, 20);
            LangLa_fq.a(var1, 315, -360, var2 + 13, var3, 20);
         } else {
            if (var7 > var5 * 2) {
               if ((var7 = (var7 - var5 * 2) * 14 / var5) > 14) {
                  var7 = 14;
               }

               LangLa_fq.a(var1, 315, 0, var2, var3, 20);
               LangLa_fq.a(var1, 315, -270, var2, var3 + 13, 20);
               if (var7 > 0) {
                  LangLa_fq.a(var1, 315, -360, var2 + 13, var3 + (14 - var7), 1 * DataCenter.gI().zoomLevel, var7 * DataCenter.gI().zoomLevel, 0, 14 - var7, 1, var7, 20);
                  return;
               }
            } else if (var7 > var5) {
               if ((var7 = (var7 - var5) * 14 / var5) > 14) {
                  var7 = 14;
               }

               LangLa_fq.a(var1, 315, 0, var2, var3, 20);
               if (var7 > 0) {
                  LangLa_fq.a(var1, 315, -270, var2, var3 + 13, var7 * DataCenter.gI().zoomLevel, 1 * DataCenter.gI().zoomLevel, 0, 14 - var7, 1, var7, 20);
                  return;
               }
            } else {
               if ((var7 = var7 * 14 / var5) > 14) {
                  var7 = 14;
               }

               if (var7 > 0) {
                  LangLa_fq.a(var1, 315, 0, var2, var3, 1 * DataCenter.gI().zoomLevel, var7 * DataCenter.gI().zoomLevel, 0, 0, 1, var7, 20);
               }
            }

            return;
         }
      } catch (Exception var6) {
         Utlis.println(var6);
      }

   }
}
