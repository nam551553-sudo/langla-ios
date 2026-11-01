package beatdz;import java.util.Vector;

public abstract class LangLa_fl extends LangLa_cx {
   public MainScreen p;
   public LangLa_il q;
   private LangLa_dz a;
   public boolean r = false;

   public LangLa_fl() {
      this.cF = 3;
   }

   public int a_() {
      return 29;
   }

   public int G() {
      return !this.r ? this.height - 33 : this.height - 64;
   }

   public void a(int var1, int var2) {
      this.setSize(var1, var2);
      this.setXY(DataCenter.gI().widthScreen / 2 - var1 / 2, DataCenter.gI().heightScreen / 2 - var2 / 2);
      if (this.a == null) {
         this.a = this.I();
      } else {
         this.a.setXY(this.width - 14, -7);
      }
   }

   public void H() {
      this.b(this.a);
   }

   public LangLa_dz I() {
      return this.a(this.width - 14, -7, "", this, -7, 6);
   }

   public LangLa_dz a(String var1, int var2) {
      return this.a(this.width / 2 - 37, this.height - 29, var1, this, var2, 7);
   }

   public LangLa_dz b(String var1, int var2) {
      return this.a(this.width / 2 - 65, this.height - 29, var1, this, var2, -8);
   }

   public LangLa_dz c(String var1, int var2) {
      return this.a(this.width / 2 + 5, this.height - 29, var1, this, var2, -8);
   }

   public mTextBox a(int var1, int var2, int var3, String var4, int var5) {
      return this.a(var1, 75, 50, var4, this, 0);
   }

   public LangLa_ce a(int var1, int var2, String var3, int var4) {
      return this.a(var1, var2, var3, this, var4);
   }

   public void p() {
   }

   public void a(LangLa_jz var1, int var2, int var3) {
   }

   public Vector c() {
      if (this.q == null) {
         this.q = new LangLa_il((byte)0, 0, 0, this.width, 28, 1, 1);
         this.q.p = this;
      }

      Vector var1;
      (var1 = new Vector()).addElement(new LangLa_jz(-9999, 0, 0, this.q.width, this.q.height, this.q, this));
      if (this.r) {
         var1.addElement(new LangLa_jz(-9999, 0, this.height - 32, this.q.width, this.height, this.q, this));
      }

      return var1;
   }

   public void b(Vector var1) {
      if (this.q == null) {
         this.q = new LangLa_il((byte)0, 0, 0, this.width, 28, 1, 1);
         this.q.p = this;
      }

      var1.addElement(new LangLa_jz(-9999, 0, 0, this.q.width, this.q.height, this.q, this));
      if (this.r) {
         var1.addElement(new LangLa_jz(-9999, 0, this.height - 32, this.q.width, this.height, this.q, this));
      }

   }

   public void b(int var1, Object var2, LangLa_cy var3) {
      if (var3 instanceof LangLa_cs) {
         LangLa_cs var4 = (LangLa_cs)var3;
         switch(var1) {
         case -11:
            this.Q();
            return;
         case -10:
            AppListener.gI();
            AppListener.exit();
            return;
         case -9:
            if (DataCenter.gI().currentScreen instanceof LoginPCScreen) {
               this.J();
               return;
            }

            ScreenLogin var5;
            (var5 = LoginPCScreen.getScreenLogin()).k(1000);
            DataCenter.gI().setScreen((MainScreen)var5);
            return;
         case -8:
         case -6:
         case -5:
         case -4:
         case -3:
         case -1:
            this.p.b(var1, var2, var3);
            return;
         case -7:
            this.J();
            return;
         case -2:
         default:
            if (var2 == null) {
               var4.s.a(new LangLa_jz(var1, 0, 0, 0, 0, (LangLa_ii)null, var3), 0, 0);
               return;
            }

            var4.s.a(var1, var2, var3);
         }
      }

   }

   public void b(int var1, Object var2) {
   }

   public void J() {
      this.d();
      this.p.j(this.cF);
      if (DataCenter.gI().currentScreen.cE.cF == 0) {
         DataCenter.gI().aH = false;
      }

   }

   public void d() {
   }
}
