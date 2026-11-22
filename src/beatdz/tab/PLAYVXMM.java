/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beatdz.tab;

import beatdz.Char;
import beatdz.DataCenter;
import beatdz.GameSrc;
import beatdz.Graphics;
import beatdz.LangLa_ca;
import beatdz.LangLa_cy;
import beatdz.LangLa_fo;
import beatdz.LangLa_jz;
import beatdz.LangLa_ms;
import beatdz.MainScreen;
import beatdz.Message;
import beatdz.Utlis;
import beatdz.mFont;
import beatdz.mTextBox;
import com.tgame.model.Caption;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class PLAYVXMM extends LangLa_fo {

    private mTextBox b;
    private int TYPE = 0;

    public PLAYVXMM(MainScreen var1, int TYPE) {
        this.TYPE = TYPE;
        this.cF = 2;
        this.p = var1;
        this.r = false;
        this.a(180, 112);
        this.b = this.a((this.width / 2) - (((this.width / 2) + 40) / 2), (height / 2) - 24, 100, "", this, 2);
        this.b.setSize(this.b.width + 30, this.b.height);
        this.b.a = 9;
        this.a(26, this.height - 35, "Đặt Cược", this, 2907, -8);
        this.a(this.width - 86, this.height - 35, Caption.v, this, 2908, -8);
    }

    public void a(int var1, Object var2, LangLa_cy var3) {
    }

    public void a(int var1, Object var2) {
    }

    public void a(Graphics var1) {
        this.a(var1, 0, 0, this.width, this.height, 80, 55, 56);
        mFont.b(mFont.d, var1, "Nhập số bạc muốn đặt cược:", this.width / 2, (this.height / 2) - 30, 2, -1, -16777216);
    }

    public void b() {
    }

    public Vector c() {
        super.c();
        Vector var1;
        (var1 = new Vector()).addElement(new LangLa_jz(0, 0, 0, this.width, this.height, this.q, this));
        return var1;
    }

    public void a(LangLa_jz var1, int var2, int var3) {
        switch (var1.b) {
            case 2907:
                if (this.b.e() <= 0) {
                    DataCenter.gI().currentScreen.showMessage(Caption.fs, -65536);
                } else if (this.b.e() > Char.gI().bac) {
                    DataCenter.gI().currentScreen.showMessage("Bạn không đủ bạc để đặt cược", -65536);
                } else {
                    try {
                        Message msg = new Message((byte) 122);
                        msg.writeByte(101);
                        msg.writeByte(TYPE);
                        msg.writeInt(this.b.e());
                        msg.send();
                    } catch (Exception ex) {

                    }
                }
                this.J();

                break;
            case 2908:
                this.J();
                break;
        }

    }

}
