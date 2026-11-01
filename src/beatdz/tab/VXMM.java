/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beatdz.tab;

import beatdz.*;
import com.tgame.model.Caption;

/**
 *
 * @author admin
 */
public class VXMM extends LangLa_fo {

    private String TITLE = "Vòng Xoay May Mắn";
    private int GIAY = 100;
    private String TOTAL_BAC = "";
    private int PERCENT_WIN = 0;

    private boolean isRead = true;
    private short TOTAL_PLAY;
    private String PERCENT_WIN_STR;
    private String WINNER_INFO = "";
    private String myMoney = "1.555.555 Bạc";
    private LangLa_dz BOX_TITLE;
    private long timeCount = System.currentTimeMillis();
    private byte TYPE = 0;

    private int tick = 0;
    private boolean isRefresh;
    private String timeC;

    /*
    Message m = new Message((byte) -109);
                    m.writeUTF(" ");
                    m.writeByte(99);
                    m.writeUTF("Vòng xoay vip");
                    m.writeShort(120);
                    m.writeUTF(String.format("%sBạc", Utlis.getCurrency(10000000)));//BẠC TỔNG
                    m.writeShort(p1);//tỉ lệ win
                    if (p2 > 0 && p2 < 10) {
                        m.writeUTF(splits[1]);
                    } else {
                        m.writeUTF(String.valueOf(p2));
                    }
                    m.writeShort(10);//số người tham gia
                    m.writeUTF("Người vừa chiến thắng:"  + Info.name
                            + ";Số bạc thắng: " + Utlis.getCurrency(320000) + "bạc ;Số bạc tham gia: "
                            + Utlis.getCurrency(10000000) + "bạc");
                    m.writeUTF(String.format("%s", Utlis.getCurrency(1000000)));
     */
    public VXMM(MainScreen var1) {
        try {
            this.a(200, 240);
            this.p = var1;
            this.BOX_TITLE = this.a((this.width / 2) - (((this.width / 2) + 30) / 2), getZ(this.height, 5), "", this, 1004, -10);
            this.BOX_TITLE.setSize(this.BOX_TITLE.width + 30, this.BOX_TITLE.height);
            this.BOX_TITLE.a(2907);
            this.BOX_TITLE.a(true);
            //    this.c(Caption.od, 100);
            //this.a(this.width / 2 + 5, this.height - 29, var1, this, var2, -8);
            this.a((this.width / 2) - 30, getZ(this.height, 85), "Tham Gia", this, 2907, -8);
        } catch (Exception ex) {

        }
    }

    @Override
    public String toString() {
        return "VXMM{" + "TITLE=" + TITLE + ", GIAY=" + GIAY + ", TOTAL_BAC=" + TOTAL_BAC + ", PERCENT_WIN=" + PERCENT_WIN + ", isRead=" + isRead + ", TOTAL_PLAY=" + TOTAL_PLAY + ", PERCENT_WIN_STR=" + PERCENT_WIN_STR + ", WINNER_INFO=" + WINNER_INFO + ", myMoney=" + myMoney + '}';
    }
    //VXMM{TITLE=, GIAY=120, TOTAL_BAC=10.000.000Bạc, PERCENT_WIN=0, isRead=true, TOTAL_PLAY=10, PERCENT_WIN_STR=10, WINNER_INFO=Người vừa chiến thắng:gamevip;Số bạc thắng: 320.000bạc ;Số bạc tham gia: 10.000.000bạc, myMoney=1.000.000}

    public void read(Message msg) {
        try {
            isRead = true;
            timeCount = System.currentTimeMillis();
            // this.TITLE = msg.readUTF();
            GIAY = msg.readShort();
            TOTAL_BAC = msg.readUTF();
            PERCENT_WIN = msg.readShort();
            PERCENT_WIN_STR = msg.readUTF();
            TOTAL_PLAY = msg.readShort();
            WINNER_INFO = msg.readUTF();
            myMoney = msg.readUTF();
            try {
                TYPE = msg.readByte();
            } catch (Exception ex) {
                TYPE = 0;
            }
            isRefresh = false;
        } catch (Exception ex) {
            ex.printStackTrace();
            isRead = false;
        }
    }

    @Override
    public void a(int var1, Object var2,
            LangLa_cy var3
    ) {
    }

    @Override
    public void a(int var1, Object var2
    ) {
    }

    @Override
    public void a(LangLa_jz var1, int var2, int var3) {
        switch (var1.b) {
            case 2907:
                this.p.a((LangLa_cx) (new PLAYVXMM(this.p, TYPE)));
                break;
        }
    }

    @Override
    public void a(Graphics var1
    ) {
        //   this.a(var1, this.cx, this.cy, this.width, this.height, this.TITLE, (byte) 2, this.r);
            this.a(var1, 0, 0, this.width, this.height, 80, 55, 56);
        this.BOX_TITLE.a = this.TITLE;
        //  System.out.println(      this.BOX_TITLE .d);
        if (isRead) {
            long num = (timeCount + GIAY * 1000 - System.currentTimeMillis()) / 1000;
            if (num < 10) {
                mFont.b(mFont.d, var1, timeC, this.width / 2, getZ(this.height, 20), 2, System.currentTimeMillis() / 250 % 2 == 0 ? -65536 : -16777216, -10275328);
            } else {
                mFont.b(mFont.d, var1, timeC, this.width / 2, getZ(this.height, 20), 2, -14336, -10275328);
            }
            mFont.b(mFont.c, var1, "Tỉ lệ thắng", this.width / 2, getZ(this.height, 30), 2, -256, -10275328);
            paint_ball(var1);
            mFont.b(mFont.c, var1, TOTAL_BAC, this.width / 2, getZ(this.height, 45), 2, -256, -10275328);
            mFont.b(mFont.c, var1, "Số người tham gia: " + TOTAL_PLAY, this.width / 2, getZ(this.height, 50), 2, -256, -10275328);
            mFont.b(mFont.c, var1, "Bạn đã tham gia: " + myMoney, this.width / 2, getZ(this.height, 55), 2, -256, -10275328);

            String[] array = Utlis.split(WINNER_INFO, ";");
            for (int i = 0; i < array.length; i++) {

                mFont.b(mFont.c, var1, array[i], this.width / 2, getZ(this.height, 70 + (i * 5)), 2, -1, -10275328);
            }
        } else {
            mFont.b(mFont.d, var1, "Đang lấy dữ liệu" + getDot((System.currentTimeMillis() / 250) % 5), this.width / 2, this.height / 2, 2, -1, -10275328);
        }
        this.b(var1);
    }

    @Override
    public void b() {
        if (!isRefresh) {
            if (TOTAL_PLAY > 1) {
                timeC = getTimeCountDown(timeCount, GIAY);
            }
            if (timeC == "") {
                 tick++;
            if (tick % 5 == 0) {
                getInfo();
            }  
            }
            long num = (timeCount + GIAY * 1000 - System.currentTimeMillis()) / 1000;
            if (num > 8 && num % 5 == 0) {
                getInfo();
            }
        }
//        if (System.currentTimeMillis() - timeCount >= 1000) {
//            if (GIAY > 0) {
//                if(TOTAL_PLAY > 1)
//                GIAY -= (System.currentTimeMillis() - timeCount) / 1000;
//            } else {
//                GIAY = 0;
//            }
//            timeCount = System.currentTimeMillis();
//            tick++;
//            if (tick % 5 == 0) {
//                getInfo();
//            }
//        }
    }

    public String getTimeCountDown(long timeStart, int secondCount) {
        String empty = "";
        long num = (timeStart + secondCount * 1000 - System.currentTimeMillis()) / 1000;
        if (num <= 0) {
            return "";
        }
        long num2 = num / 60;
        long num3 = num;
        if (num2 > 0) {
            if (num2 < 10) {
                if (num % 60 >= 0 && num % 60 < 10) {
                    return "0" + num2 + ":0" + num % 60;
                }
                return "0" + num2 + ":" + num % 60;
            }
            if (num % 60 >= 0 && num % 60 < 10) {
                return num2 + ":0" + num % 60;
            }
            return num2 + ":" + num % 60;
        }
        return (num3 >= 10) ? (num3 + "s") : ("0" + num3 + "s");
    }

    public void paint_ball(Graphics var1) {
        this.a(var1, this.cx, this.cy);
        int var3 = getZ(this.width, 50);
        int var4 = 16;
        int var5 = PERCENT_WIN * var3 / 100;
        var1.f(-16777216);
        var1.c((this.width / 2) - (var3 / 2), (getZ(this.height, 40)) - 16, var3, var4);
        Binary2.a(var1, 93, 0, (this.width / 2) - (var3 / 2), (getZ(this.height, 40)) - 16, var5, (int) var4);
        mFont.a(var1, PERCENT_WIN + "." + PERCENT_WIN_STR + "%", this.width / 2, (getZ(this.height, 40)) - 8, 2, -7079423);
    }

    private String getDot(long l) {
        String s = "";

        while (l-- > 0) {
            s += ".";
        }
        return s;
    }

    public int getZ(int total, int p) {
        return total * p / 100;
    }

    public void getInfo() {
        isRefresh = true;
        try {
            Message msg = new Message((byte) 122);
            msg.writeByte(101);
            msg.writeByte(TYPE);
            msg.writeInt(0);
            msg.send();
        } catch (Exception ex) {

        }
    }

}
