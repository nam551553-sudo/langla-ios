package beatdz;

import beatdz.*;

public class Server {

    public ArrayServer array;
    public short id;
    public String name;
    public String ip;
    public short port;
    public short portCheck;
    public String STR_STATUS = "";
    public String TEXT = "";
    public boolean SELECT;

    public int version1 = -1;
    public int version2 = -1;
    public int typeServer = -1;
   public String[] arrayData;

    public Server() {

//        try {
//            ((String) null).charAt(0);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
    }

    public Server cloneServer() {
        Server var1;
        (var1 = new Server()).id = this.id;
        var1.name = this.name;
        var1.ip = this.ip;
        var1.port = this.port;
        var1.portCheck = this.portCheck;
        var1.STR_STATUS = this.STR_STATUS;
        var1.TEXT = this.TEXT;
        var1.version1 = this.version1;
        var1.array = this.array;
        var1.version2 = this.version2;
        var1.arrayData = this.arrayData;
        var1.typeServer = this.typeServer;
        return var1;
    }

    public String getName() {
        String var1 = this.name.trim();
        if (this.STR_STATUS.length() > 0) {
            var1 = var1 + " (" + this.STR_STATUS + ")";
        }

        return var1;
    }

    public Object clone() {
        return this.cloneServer();
    }
}
