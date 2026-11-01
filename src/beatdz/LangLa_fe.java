package beatdz;import java.util.Vector;

public class LangLa_fe extends LangLa_fm {
   private LangLa_ii a;
   private LangLa_ii b;
   private Vector c;
   private LangLa_dz d;
   private String e;

   public LangLa_fe(int var1, int var2, LangLa_cx var3, String var4, String var5) {
      this.e = var5;
      this.setSize(240, 155);
      this.setXY(DataCenter.gI().widthScreen / 2 - this.width / 2 - var3.cx, DataCenter.gI().heightScreen / 2 - this.height / 2 - var3.cy);
      this.s = var3;
      this.d = new LangLa_dz(this.width - 19, 5, 0, 0, "", var3, 1001, 52);
      this.c = new Vector();
      this.a = new LangLa_ii((byte)1, 5, 30, this.width - 10, 120, 12, this.c.size());
      this.b = new LangLa_ii((byte)1, this.d.cx, this.d.cy, this.d.width, this.d.height, this.d.height, 1);
      this.a(var4);
   }

   private void a(String var1) {
      try {
         String[] var4 = var1.split("\r\n");
         this.c.clear();

         for(int var2 = 0; var2 < var4.length; ++var2) {
            this.c.addElement(var4[var2]);
         }

         this.a = new LangLa_ii((byte)1, 5, 30, this.width - 10, 120, 12, this.c.size());
         this.b = new LangLa_ii((byte)1, this.d.cx, this.d.cy, this.d.width, this.d.height, this.d.height, 1);
      } catch (Exception var3) {
         Utlis.println(var3);
      }
   }

   public Vector c() {
      Vector var1;
      (var1 = new Vector()).addElement(new LangLa_jz(1000, this.a.cx, this.a.cy, this.a.cx + this.a.width, this.a.cy + this.a.height, this.a, this));
      var1.addElement(new LangLa_jz(1001, this.b.cx, this.b.cy, this.b.cx + this.b.width, this.b.cy + this.b.height, this.b, this));
      var1.addElement(new LangLa_jz(1000, 0, 0, this.width, this.height, (LangLa_ii)null, this));
      return var1;
   }

   public void a(Graphics var1) {
      int var2 = var1.a;
      int var3 = var1.b;
      this.a(var1, 0, 0, this.width, this.height, -11, 55, 56);
      var1.f(16577687);
      var1.a(3, 25, this.width - 3, 1);
      mFont.b(mFont.f, var1, this.e, this.width / 2, 13, 2, -2560, -16777216);
      this.a(var1, this.a);

      for(int var4 = 0; var4 < this.c.size(); ++var4) {
         if (this.a.b(var4)) {
            mFont.a(mFont.d, var1, this.c.elementAt(var4).toString(), 5, 6 + var4 * 12, 0, -1);
         }
      }

      this.b(var1);
      this.a(var1, var2, var3);
      var1.a(this.d.cx, this.d.cy);
      this.d.a(var1);
      this.a(var1, var2, var3);
   }

   public void b() {
      this.a.a();
      this.b.a();
      if (this.b.l != -1) {
         this.d.h = true;
      } else {
         this.d.h = false;
      }
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      switch(var1.b) {
      case 1000:
         return;
      case 1001:
         this.s.b((LangLa_cs)this);
      default:
      }
   }
}
