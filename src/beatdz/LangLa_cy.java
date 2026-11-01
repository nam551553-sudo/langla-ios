package beatdz;import java.util.Vector;

public abstract class LangLa_cy extends LangLa_cz {
   public LangLa_fz cO = new LangLa_fz();
   public LangLa_ga cP;

   public abstract void a(Graphics var1);

   public abstract void b();

   public abstract void p();

   public abstract Vector c();

   public abstract void a(LangLa_jz var1, int var2, int var3);

   public void s() {
   }

   public int b_() {
      return this.cx;
   }

   public int c_() {
      return this.cy;
   }

   public void R() {
      try {
         if (this.cP == null) this.cP = new LangLa_ga();
         Vector regions = this.c();
         LangLa_jz[] next = new LangLa_jz[regions == null ? 0 : regions.size()];
         for (int index = 0; index < next.length; index++) {
            LangLa_jz region = (LangLa_jz)regions.elementAt(index);
            next[index] = region;
            if (region != null && this instanceof LangLa_cs) {
               LangLa_cs control = (LangLa_cs)this;
               region.c += control.s.cx; region.e += control.s.cx;
               region.d += control.s.cy; region.f += control.s.cy;
            }
         }
         this.cP.setRegions(next);
      } catch (Exception error) { Utlis.println(error); }
   }

   public boolean n(int var1) {
      return this.cP != null && this.cP.a(0);
   }

   public void c(Graphics var1) {
      int var2 = var1.a;
      int var3 = var1.b;
      this.a(var1, this.b_(), this.c_());
      this.a(var1);
      this.a(var1, var2, var3);
   }

   public void d(Graphics var1) {
      int var2 = var1.a;
      int var3 = var1.b;
      this.a((Graphics)var1, this.cx, this.cy);
      var1.f(-65536);
      if (this.cP != null) {
         for(int var4 = 0; var4 < this.cP.a.length; ++var4) {
            if (this.cP.a[var4] != null) {
               var1.b(this.cP.a[var4].c, this.cP.a[var4].d, this.cP.a[var4].e - this.cP.a[var4].c, this.cP.a[var4].f - this.cP.a[var4].d);
            }
         }
      }

      this.a(var1, var2, var3);
   }

   public void a(Graphics var1, int var2, int var3) {
      var1.a(-var1.a, -var1.b);
      var1.a(var2, var3);
   }

   public void b(Graphics var1) {
      this.a((Graphics)var1, 0, 0);
      var1.setClip(0, 0, DataCenter.gI().widthScreen, DataCenter.gI().heightScreen);
      var1.a(this.b_(), this.c_());
   }

   public void a(Graphics var1, LangLa_ii var2) {
      var2.a(var1, this.b_(), this.c_(), var2.width, var2.height);
   }

   public void b(Graphics var1, LangLa_ii var2) {
      var2.b(var1, this.b_(), this.c_(), var2.width, var2.height);
   }

   public static void a(Vector var0) {
      try {
         for(int var4 = 0; var4 < var0.size() - 1; ++var4) {
            LangLa_cx var1 = (LangLa_cx)var0.elementAt(var4);

            for(int var5 = var4 + 1; var5 < var0.size(); ++var5) {
               LangLa_cx var2;
               if ((var2 = (LangLa_cx)var0.elementAt(var5)).cF < var1.cF) {
                  LangLa_cx var3 = var2;
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
}
