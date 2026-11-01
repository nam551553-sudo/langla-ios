package beatdz;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class LangLa_en {
   private short b;
   private long c;
   public LangLa_em[] a;
   private long d;
   private Sound e;
   private int f;

   public LangLa_en(short var1, long var2, LangLa_em[] var4, int var5) {
      this.b = var1;
      this.c = var2;
      this.a = var4;
      this.d = 5000L;
      this.f = var5;
      this.a();
   }

   public void a() {
      try {
         if (mConfig.gI().readBoolean(0)) {
            byte var1 = 26;
            if (this.f == 7) {
               var1 = 28;
            }

            byte[] var2 = Utlis.b(Utlis.internal("music/" + var1).readBytes());
            Binary.write("music" + var1, var2, "mp3");
            this.e = Gdx.audio.newSound(Utlis.external(Binary.a + "music" + var1 + ".mp3"));
            Binary.deleteStartsWith("music");
            this.e.play();
         }

      } catch (Exception var3) {
         Utlis.println(var3);
      }
   }

   public short b() {
      return this.b;
   }

   public boolean c() {
      boolean var1;
      if (var1 = System.currentTimeMillis() - this.c >= this.d) {
         this.d();
      }

      return var1;
   }

   public void d() {
      if (this.e != null) {
         this.e.stop();
         this.e.dispose();
      }

   }
}
