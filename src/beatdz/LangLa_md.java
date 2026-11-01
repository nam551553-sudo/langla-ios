package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_md extends MainScreen {
   private int b = 625;
   private int c = 344;
   private int d;
   private int e;
   private float f = 1.0F;
   public int a;
   private int g;
   private mImage h;

   public LangLa_md(int var1, String var2, String var3) {
      this.a = var1;
      this.h = Binary2.a("a", (MainScreen)this);
      this.d = this.b;
      this.e = this.c;
      float var6 = (float)DataCenter.gI().widthScreen / (float)this.b;
      float var4 = (float)DataCenter.gI().heightScreen / (float)this.c;
      this.f = var6 > var4 ? var6 : var4;
      this.e = (int)((float)this.c * this.f * (float)DataCenter.gI().zoomLevel);
      this.d = (int)((float)this.b * this.f * (float)DataCenter.gI().zoomLevel);
      Vector var7 = new Vector();
      String[] var9 = Utlis.split(var3, "\\n");
      String var10 = "";
      var10 = "c#yellow" + var2 + "\nc#white" + var10;
      var7.addElement(new LangLa_ke(new Vector(), var10, (byte)2));

      for(int var8 = 0; var8 < var9.length; ++var8) {
         String[] var5;
         if ((var5 = var9[var8].split("@")).length == 1) {
            var10 = var9[var8].replaceAll("#", "c#green" + Char.gI().name + "c#white").replaceAll("\\$", "c#blue" + DataCenter.gI().DataNameChar[Char.gI().idClass].name + "c#white").replaceAll("\\*", Caption.sw[Char.gI().gioiTinh]).replaceAll("\\&", Caption.sx[Char.gI().gioiTinh]).replaceAll("\\^", Caption.sy[Char.gI().gioiTinh]).replaceAll("\\%", Caption.sz[Char.gI().gioiTinh]).replaceAll("\\~", Caption.sA[Char.gI().gioiTinh]).replaceAll("\\_", Caption.sB[Char.gI().gioiTinh]);
            var7.addElement(new LangLa_ke(Char.gI().aE, var10, (byte)2));
         } else {
            var10 = (var10 = var5[1]).replaceAll("#", "c#green" + Char.gI().name + "c#white").replaceAll("\\$", "c#blue" + DataCenter.gI().DataNameChar[Char.gI().idClass].name + "c#white").replaceAll("\\*", Caption.sw[Char.gI().gioiTinh]).replaceAll("\\&", Caption.sx[Char.gI().gioiTinh]).replaceAll("\\^", Caption.sy[Char.gI().gioiTinh]).replaceAll("\\%", Caption.sz[Char.gI().gioiTinh]).replaceAll("\\~", Caption.sA[Char.gI().gioiTinh]).replaceAll("\\_", Caption.sB[Char.gI().gioiTinh]);
            int var11;
            if ((var11 = Integer.parseInt(var5[0])) >= 0) {
               Npc var12 = new Npc((byte)0, var11, 0, 0);
               var7.addElement(new LangLa_ke(var12.getNpcTemplate().b[0], var10, (byte)0));
            } else {
               var7.addElement(new LangLa_ke(Char.gI().Q(), var10, (byte)1));
            }
         }
      }

      this.a(new LangLa_bo(this, var7, -3));
   }

   public void j() {
   }

   public void a(int var1, Object var2, LangLa_cy var3) {
   }

   public void a(int var1, Object var2) {
   }

   public void a(Graphics var1) {
      if (AppListener.$state_AppListener().h > 0) {
         --AppListener.$state_AppListener().h;
         if (AppListener.$state_AppListener().h == 0) {
            DataCenter.gI().g();
            return;
         }
      }

      if (this.h != null) {
         var1.a(this.h, 0, 0, this.h.c, this.h.d, 0, DataCenter.gI().widthScreen / 2, DataCenter.gI().heightScreen / 2, DataCenter.gI().q, DataCenter.gI().r, 3);
      }

      if (this.g > 0 && this.h != null) {
         this.h.a();
         this.h = null;
      }

   }

   public void b() {
      GameSrc.gI().b();
      if (this.g > 0) {
         --this.g;
         if (this.g == 0) {
            DataCenter.gI().setScreen((MainScreen)GameSrc.gI());

            try {
               if (this.a == 0) {
                  Message.c((byte)-123).send();
               }
            } catch (Exception var2) {
               Utlis.println(var2);
            }
         }
      } else if (!(this.H() instanceof LangLa_bo)) {
         this.g = 1;
      }

      DataCenter.gI().aO.a = false;
   }

   public void p() {
   }

   public void a(LangLa_jz var1, int var2, int var3) {
   }

   public void G() {
   }
}
