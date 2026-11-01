package beatdz;
import com.tgame.model.Caption;

 class LangLa_bq implements Runnable {
   
   LangLa_bp a;

   LangLa_bq(LangLa_bp var1) {
      this.a = var1;
   }

   public void run() {
      ArrayServer var1 = LangLa_bp.a(this.a)[LangLa_bp.b(this.a).b.b];

      for(int var2 = 0; var2 < var1.servers.length; ++var2) {
         Server var3;
         if (Utlis.b((var3 = var1.servers[var2]).ip, var3.port)) {
            var3.STR_STATUS = Caption.mj;
         } else {
            var3.STR_STATUS = Caption.mi;
         }
      }

   }
}
