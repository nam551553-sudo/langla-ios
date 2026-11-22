package beatdz;import com.tgame.model.Caption;
import java.util.Vector;

public class LangLa_bp extends LangLa_fo {
   private LangLa_gx a;
   private LangLa_ii[] b;
   private int c = 1005;
   private int d;
   private ArrayServer[] e;

   public LangLa_bp(Server var1, MainScreen var2, int var3) {
      this.p = var2;
      this.a(300, 215);
      var1 = DataCenter.gI().aP;
      this.e = new ArrayServer[DataCenter.gI().arrayServers.length + 1];
      this.e[0] = new ArrayServer();
      this.e[0].nameServers = Caption.lw;
      Vector var10 = new Vector();

      int var5;
      String[] var11;
      try {
         var11 = Binary.readUTF("arr_server").split(":");
         Vector var4 = new Vector();

         for(var5 = 0; var5 < DataCenter.gI().arrayServers.length; ++var5) {
            for(int var6 = 0; var6 < DataCenter.gI().arrayServers[var5].servers.length; ++var6) {
               Server var7;
               if ((var7 = DataCenter.gI().arrayServers[var5].servers[var6]).ip.toLowerCase().equals(var11[0].toLowerCase()) && var7.port == Integer.parseInt(var11[1])) {
                  Server var16;
                  (var16 = var7.cloneServer()).TEXT = var7.TEXT = Caption.sX[0];
                  a(var10, var16);
               } else {
                  for(int var8 = 0; var8 < Caption.sX.length; ++var8) {
                     if (var7.TEXT.toUpperCase().equals(Caption.sX[var8])) {
                        var7 = var7.cloneServer();
                        var4.add(var7);
                        break;
                     }
                  }
               }
            }
         }

         if (DataCenter.gI().selectServer != null) {
            var4.add(DataCenter.gI().selectServer);
         }

         for(var5 = 0; var5 < var4.size(); ++var5) {
            a(var10, (Server)var4.get(var5));
         }
      } catch (Exception var9) {
      }

      if (DataCenter.gI().aP != null) {
         Server var12 = DataCenter.gI().aP.cloneServer();
         a(var10, var12);
      }

      DataCenter.gI().aP = var1;
      this.e[0].servers = new Server[var10.size()];

      for(var3 = 0; var3 < var10.size(); ++var3) {
         this.e[0].servers[var3] = (Server)var10.get(var3);
      }

      for(var3 = 0; var3 < DataCenter.gI().arrayServers.length; ++var3) {
         ArrayServer var13 = DataCenter.gI().arrayServers[DataCenter.gI().arrayServers.length - 1 - var3];
         this.e[var3 + 1] = new ArrayServer();
         this.e[var3 + 1].nameServers = var13.nameServers;
         this.e[var3 + 1].servers = new Server[var13.servers.length];

         for(var5 = 0; var5 < var13.servers.length; ++var5) {
            this.e[var3 + 1].servers[var5] = var13.servers[var13.servers.length - 1 - var5];
         }
      }

      var11 = new String[this.e.length];

      for(int var14 = 0; var14 < this.e.length; ++var14) {
         var11[var14] = this.e[var14].nameServers;
      }

      LangLa_kd var15;
      (var15 = new LangLa_kd(1001)).c = var11;
      this.a = new LangLa_gx(var15, this.width, 1, this.a_() - 3, 87, this.G() + 6, 33, this);
      this.b = new LangLa_ii[this.a.b.c.length];

      for(var5 = 0; var5 < this.e.length; ++var5) {
         this.b[var5] = new LangLa_ii((byte)1, this.a.c() + 8, this.a_() + 10, this.width - 110, 162, 27, this.e[var5].servers.length);
      }

      this.e();
   }

   private static void a(Vector var0, Server var1) {
      for(int var2 = 0; var2 < var0.size(); ++var2) {
         if (((Server)var0.get(var2)).ip.equals(var1.ip) && ((Server)var0.get(var2)).port == var1.port) {
            return;
         }
      }

      var0.add(var1);
   }

   public void a(Graphics var1) {
      this.a(var1, this.cx, this.cy, this.width, this.height, Caption.e, (byte)2, this.r);
      this.a.a((Graphics)var1, -11);
      this.a.a(var1, this.cx, this.cy);
      this.a(var1, this.b[this.a.b.b]);

      for(int var2 = 0; var2 < this.b[this.a.b.b].i; ++var2) {
         if (var2 == this.b[this.a.b.b].k) {
            this.a(var1, 0, var2 * this.b[this.a.b.b].h, this.b[this.a.b.b].width, this.b[this.a.b.b].h - 1, -14, 84, 5, 1, 1);
         } else {
            this.a(var1, 0, var2 * this.b[this.a.b.b].h, this.b[this.a.b.b].width, this.b[this.a.b.b].h - 1, -13, 84, 5, 1, 1);
         }

         String var3 = this.e[this.a.b.b].servers[var2].getName();
         if (var2 == this.b[this.a.b.b].l) {
            mFont.a(mFont.d, var1, var3, 16, 1 + var2 * this.b[this.a.b.b].h + this.b[this.a.b.b].h / 2, 0, -1);
         } else {
            mFont.a(mFont.d, var1, var3, 15, var2 * this.b[this.a.b.b].h + this.b[this.a.b.b].h / 2, 0, -1);
         }

         for(int var6 = 0; var6 < Caption.sX.length; ++var6) {
            if (this.e[this.a.b.b].servers[var2].TEXT.toUpperCase().equals(Caption.sX[var6])) {
               int var4 = -1;
               switch(var6) {
               case 0:
                  var4 = -16711681;
                  break;
               case 1:
                  var4 = -2560;
                  break;
               case 2:
                  var4 = -3407617;
               }

               mFont.c(mFont.d, var1, this.e[this.a.b.b].servers[var2].TEXT, this.b[this.a.b.b].width - 10, var2 * this.b[this.a.b.b].h + this.b[this.a.b.b].h / 2, 1, var4, -10275328);
               break;
            }
         }
      }

      this.b(var1);
   }

   public void b() {
      this.a.a();
      this.b[this.a.b.b].a();
      if (this.d > 0) {
         --this.d;
         if (this.d == 0) {
            this.J();
            this.p.b(1005, this.e[this.a.b.b].servers[this.c], this);
         }
      }

   }

   public Vector c() {
      Vector var1;
      (var1 = super.c()).addElement(this.a.b());
      var1.addElement(this.b[this.a.b.b].a(1002, this));
      return var1;
   }

   public void a(LangLa_jz var1, int var2, int var3) {
      if (this.d <= 0) {
         super.a(var1, var2, var3);
         switch(var1.b) {
         case 1001:
            if (var1.j.k >= 0) {
               this.a.a(var1.j.k);
               this.e();
               return;
            }
            break;
         case 1002:
            if (var1.j.k >= 0) {
               this.d = 4;
               this.c = var1.j.k;

               for(int var4 = 0; var4 < DataCenter.gI().arrayServers.length; ++var4) {
                  ArrayServer var5 = DataCenter.gI().arrayServers[var4];

                  for(var3 = 0; var3 < var5.servers.length; ++var3) {
                     var5.servers[var3].TEXT = "";
                  }
               }
            }
         }

      }
   }

   public void a(int var1, Object var2, LangLa_cy var3) {
   }

   public void a(int var1, Object var2) {
   }

   private void e() {
      (new Thread(new LangLa_bq(this))).start();
   }

   
   static ArrayServer[] a(LangLa_bp var0) {
      return var0.e;
   }

   
   static LangLa_gx b(LangLa_bp var0) {
      return var0.a;
   }
}
