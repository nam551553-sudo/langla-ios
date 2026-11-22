package beatdz;
 class LangLa_me {
   Char a;
   LangLa_hm b;
   boolean c;
   
   SelectCharScreen d;

   private LangLa_me(SelectCharScreen var1) {
      this.d = var1;
   }

   void a() {
      this.b = new LangLa_hm(206, this.a.cx, this.a.cy, 1);
      LangLa_dp var1;
      if (!(var1 = LangLa_dp.a()).a) {
         try {
            if (var1.b[26] != null) {
               var1.b[26].play();
            }

            return;
         } catch (Exception var2) {
            Utlis.println(var2);
         }
      }

   }

   void a(int var1) {
      if (this.a != null && DataCenter.gI().i % 3 == var1 % 3) {
         this.a.af = 0;
         this.a.y();
         this.a.aE.clear();
         this.a.aE.addAll(this.a.Q());
      }

      if (this.b != null) {
         this.b.q();
      }

   }

   
   LangLa_me(SelectCharScreen var1, LangLa_ml var2) {
      this(var1);
   }
}
