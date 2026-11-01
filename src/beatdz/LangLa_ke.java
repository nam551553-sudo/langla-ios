package beatdz;import java.util.Vector;

public class LangLa_ke {
   public Vector a;
   public LangLa_hz b;
   public Vector c;
   public byte d;

   public LangLa_ke(Vector var1, String var2, byte var3) {
      this.a = var1;
      this.c = mFont.a(mFont.d, var2, DataCenter.gI().widthScreen - 120);
      this.d = var3;
   }

   public LangLa_ke(LangLa_hz var1, String var2, byte var3) {
      this.b = var1;
      this.c = mFont.a(mFont.d, var2, DataCenter.gI().widthScreen - 120);
      this.d = 0;
   }
}
