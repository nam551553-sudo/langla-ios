package beatdz;
import java.util.Vector;

public class LangLa_ea extends LangLa_dz {
   public LangLa_ik l;
   private short q;
   public short m;
   public short n;
   public LangLa_jb o;
   public LangLa_cz p;

   public LangLa_ea(int var1, int var2, int var3, int var4, String var5, LangLa_cx var6, int var7, int var8, int var9) {
      super(var1, var2, 0, 0, var5, var6, var7, var8);
      this.q = (short)var9;
      this.l = new LangLa_ik((byte)0, this.width / 2, this.height / 2, this.width, this.height, 1, 1, this);
      this.p = new LangLa_cz();
      this.p.setSize(this.width, this.height);
   }

   public Vector c() {
      Vector var1;
      (var1 = new Vector()).addElement(new LangLa_jz(this.b, 0, 0, this.width, this.height, this.l, this));
      return var1;
   }

   public void s() {
      super.s();
      this.d();
   }

   public void d() {
      this.m = 0;
      this.n = 0;
      this.p.setXY(0, 0);
      if (this.l != null) {
         this.l.e();
      }

   }

   public void b() {
      super.b();
      if (this.o != null) {
         this.o.a();
      }

   }

   public void a(Graphics var1) {
      short var2 = this.d;
      short var3 = this.q;
      if (this.n(0)) {
         var1.e(30);
      }

      if (mConfig.gI().readBoolean(12) || this.n(0)) {
         Binary2.b(var1, var2, this.e, this.p.cx, this.p.cy, this.p.width, this.p.height);
      }

      byte var5 = 30;
      if (mConfig.gI().readBoolean(15)) {
         var5 = 40;
      }

      Binary2.b(var1, var3, this.e, this.l.cx - var5 / 2, this.l.cy - var5 / 2, var5, var5);
      var1.d();
      if (this.c > 0) {
         var1.m = 1.0F;
      }

   }
}
