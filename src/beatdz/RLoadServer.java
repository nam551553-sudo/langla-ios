package beatdz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Application.ApplicationType;
import com.tgame.model.Caption;
import java.util.Vector;

public class RLoadServer implements Runnable {

    AppListener a;

    public RLoadServer(AppListener var1) {
        this.a = var1;
    }

    public void run() {
        boolean var24 = false;

        String[] var36;
        int var37;
        int var41;
        Server var42;
        boolean var10001;
        label481:
        {
            try {
                var24 = true;
                Vector var1 = new Vector();
                String var2;

                var2 = Binary.a(Utlis.ipsv, 2);
                if (var2 == null || var2.trim().isEmpty()) {
                    var2 = ClientConfig.DEFAULT_SERVER_LIST;
                }
                //   var2 = Binary.a("http://dl.langla.me/serverlist.txt", 2);

                DataCenter.gI().aP = null;
                String[] var3 = var2.replaceAll(" =", "=").replaceAll("= ", "=").split("id=");
                boolean var38 = true;

                ArrayServer var4;
                int var5;
                for (var5 = 0; var5 < var3.length; ++var5) {
                    if (var3[var5].trim().length() > 0) {
                        String[] var6 = var3[var5].trim().split("\r?\n");
                        (var4 = new ArrayServer()).nameServers = var6[0];
                        Vector var7 = new Vector();

                        int var8;
                        for (var8 = 1; var8 < var6.length; ++var8) {
                            if (var6[var8].trim().length() > 0) {
                                String[] array = Utlis.split(var6[var8], "|");
                                String[] var9;
                                String[] var10 = (var9 = array[0].split("="))[0].split(":");
                                String[] var11 = var9[1].split(":");
                                DataCenter.gI().ipServer = var11[1];
                                DataCenter.gI().portServer = Integer.parseInt(var11[2]);
                                Server var12 = new Server();
                                var12.array = var4;
                                if (var10.length <= 1) {
                                    var12.name = var9[0];
                                } else {
                                    var12.TEXT = var10[0];
                                    var12.name = var10[1];
                                }

                                if (!var12.TEXT.toUpperCase().equals(Caption.nB)) {
                                    var12.id = Short.parseShort(var11[0]);
                                    var12.ip = var11[1];
                                    var12.port = Short.parseShort(var11[2]);
                                    var12.portCheck = Short.parseShort(var11[3]);
                                    if (var11.length > 4) {
                                        var12.STR_STATUS = var11[4];
                                    }

                                    if (var11.length > 5) {
                                        var12.SELECT = Boolean.parseBoolean(var11[5]);
                                    }

                                    if (var12.id == 101) {
                                        var38 = false;
                                        DataCenter.gI().selectServer = var12;
                                    } else {
                                        try {
                                            var12.version1 = Integer.parseInt(array[1]);
                                        } catch (Exception ex) {

                                        }
                                        try {
                                            var12.version2 = Integer.parseInt(array[2]);
                                        } catch (Exception ex) {

                                        }
                                        try {
                                            var12.typeServer = Integer.parseInt(array[3]);
                                        } catch (Exception ex) {

                                        }
                                        try {
                                            var12.arrayData = Utlis.split(array[4],"@");
                                        } catch (Exception ex) {

                                        }
                                        var38 = true;
                                        var7.add(var12);
                                    }
                                }
                            }
                        }

                        if (var38) {
                            var4.servers = new Server[var7.size()];

                            for (var8 = 0; var8 < var7.size(); ++var8) {
                                var4.servers[var8] = (Server) var7.get(var8);
                                if (var4.servers[var8].SELECT) {
                                    DataCenter.gI().aP = var4.servers[var8];
                                }
                            }

                            var1.add(var4);
                        }
                    }
                }

                DataCenter.gI().arrayServers = new ArrayServer[var1.size()];

                for (var5 = 0; var5 < var1.size(); ++var5) {
                    DataCenter.gI().arrayServers[var5] = (ArrayServer) var1.get(var5);
                }

                if (DataCenter.gI().aP == null) {
                    var4 = DataCenter.gI().arrayServers[DataCenter.gI().arrayServers.length - 1];
                    DataCenter.gI().aP = var4.servers[var4.servers.length - 1];
                    var24 = false;
                } else {
                    var24 = false;
                }
                break label481;
            } catch (Exception var34) {
                var34.printStackTrace();
                var24 = false;
            } finally {
                if (var24) {
                    label371:
                    {
                        String[] var40;
                        try {
                            var40 = Binary.readUTF("arr_server").split(":");
                            var37 = 0;
                        } catch (Exception var27) {
                            var10001 = false;
                            break label371;
                        }

                        label368:
                        while (true) {
                            int var39;
                            try {
                                if (var37 >= DataCenter.gI().arrayServers.length) {
                                    break;
                                }

                                var39 = 0;
                            } catch (Exception var25) {
                                var10001 = false;
                                break;
                            }

                            while (true) {
                                try {
                                    if (var39 >= DataCenter.gI().arrayServers[var37].servers.length) {
                                        break;
                                    }

                                    Server var43;
                                    if ((var43 = DataCenter.gI().arrayServers[var37].servers[var39]).ip.toLowerCase().equals(var40[0].toLowerCase()) && var43.port == Integer.parseInt(var40[1])) {
                                        DataCenter.gI().setServer(var43);
                                        return;
                                    }
                                } catch (Exception var26) {
                                    var10001 = false;
                                    break label368;
                                }

                                ++var39;
                            }

                            ++var37;
                        }
                    }

                    DataCenter.gI().setServer(DataCenter.gI().aP);
                }
            }

            label394:
            {
                try {
                    var36 = Binary.readUTF("arr_server").split(":");
                    var41 = 0;
                } catch (Exception var30) {
                    var10001 = false;
                    break label394;
                }

                label391:
                while (true) {
                    try {
                        if (var41 >= DataCenter.gI().arrayServers.length) {
                            break;
                        }

                        var37 = 0;
                    } catch (Exception var28) {
                        var10001 = false;
                        break;
                    }

                    while (true) {
                        try {
                            if (var37 >= DataCenter.gI().arrayServers[var41].servers.length) {
                                break;
                            }

                            if ((var42 = DataCenter.gI().arrayServers[var41].servers[var37]).ip.toLowerCase().equals(var36[0].toLowerCase()) && var42.port == Integer.parseInt(var36[1])) {
                                DataCenter.gI().setServer(var42);
                                return;
                            }
                        } catch (Exception var29) {
                            var10001 = false;
                            break label391;
                        }

                        ++var37;
                    }

                    ++var41;
                }
            }

            DataCenter.gI().setServer(DataCenter.gI().aP);
            return;
        }

        label416:
        {
            try {
                var36 = Binary.readUTF("arr_server").split(":");
                var41 = 0;
            } catch (Exception var33) {
                var10001 = false;
                break label416;
            }

            label413:
            while (true) {
                try {
                    if (var41 >= DataCenter.gI().arrayServers.length) {
                        break;
                    }

                    var37 = 0;
                } catch (Exception var31) {
                    var10001 = false;
                    break;
                }

                while (true) {
                    try {
                        if (var37 >= DataCenter.gI().arrayServers[var41].servers.length) {
                            break;
                        }

                        if ((var42 = DataCenter.gI().arrayServers[var41].servers[var37]).ip.toLowerCase().equals(var36[0].toLowerCase()) && var42.port == Integer.parseInt(var36[1])) {
                            DataCenter.gI().setServer(var42);
                            return;
                        }
                    } catch (Exception var32) {
                        var10001 = false;
                        break label413;
                    }

                    ++var37;
                }

                ++var41;
            }
        }

        DataCenter.gI().setServer(DataCenter.gI().aP);
    }
}
