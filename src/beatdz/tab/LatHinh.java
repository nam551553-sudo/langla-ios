package beatdz.tab;

import beatdz.Binary2;
import beatdz.Char;
import beatdz.DataCenter;
import beatdz.Graphics;
import beatdz.Item;
import beatdz.LangLa_cy;
import beatdz.LangLa_dz;
import beatdz.LangLa_fo;
import beatdz.LangLa_fq;
import beatdz.LangLa_ii;
import beatdz.LangLa_ij;
import beatdz.LangLa_jz;
import beatdz.MainScreen;
import beatdz.Message;
import beatdz.Utlis;
import beatdz.mFont;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LatHinh extends LangLa_fo {

    public Item[] arrayI = new Item[40];
    public BoxItem[] arrayBoxItem = new BoxItem[40];
    public int c2 = 0;
    private long delayOpen = System.currentTimeMillis() * 2;
    private int tick;
    private BoxItem selectItem;
    private boolean ran;
    public LangLa_dz btn_TuLat;
    public LangLa_dz btn_ThuLai;
    public LangLa_dz btn_ThayDoi;
    private long delayOpen2;
    public Short[] idItem = new Short[40];
    private boolean isReadItem;

    public LatHinh(MainScreen var1) {
        this.a(320, 240);
        this.p = var1;
        this.r = false;
        this.cF = 2;
        btn_TuLat = this.a((this.width / 2) - 30 - 90, getZ(this.height, 87), "Tự Lật", this, 9999, -8);
        btn_ThayDoi = this.a((this.width / 2) - 30, getZ(this.height, 87), "Thay Đổi", this, 10000, -8);
        btn_ThuLai = this.a((this.width / 2) - 30 + 90, getZ(this.height, 87), "Thử Lại", this, 10001, -8);
        btn_ThuLai.a(true);
    }

    public void read(Message msg) {
        try {
            for (int i = 0; i < 40; i++) {
                short id = msg.readShort();
                idItem[i] = id;
            }
            isReadItem = true;
        } catch (IOException ex) {
            Logger.getLogger(LatHinh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void a(int var1, Object var2, LangLa_cy var3) {
    }

    @Override
    public void a(int var1, Object var2) {
    }

    @Override
    public void a(Graphics var1) {
        this.a(var1, this.cx, this.cy, this.width, this.height, "Lật hình", (byte) 2, this.r);

        for (int i = 0; i < arrayI.length; i++) {
            arrayI[i] = new Item(774);
            arrayI[i].level = 0;
            arrayI[i].rangeNE = true;
        }
        int count = 90;
        int size = 35;
        int z = getZ(this.width, count) / size;
        for (int i = 0; i < arrayBoxItem.length; i++) {
            if (arrayBoxItem[i] == null) {
                arrayBoxItem[i] = new BoxItem();
                arrayBoxItem[i].item = arrayI[i];
                int x = 6 + ((i % z) * size) + (getZ(this.width, 100 - count) / 2);
                int y = ((i / z) * size) + 35;
                arrayBoxItem[i].x = x;
                arrayBoxItem[i].y = y;
                arrayBoxItem[i].xMain = x;
                arrayBoxItem[i].yMain = y;
            }
        }
        tick++;
        int delay = 50;
        long time = 300;
        if (time < 200) {
            time = 200;
        }
        BoxItem boxMain = selectItem;
        for (int i = 0; i < arrayBoxItem.length;
                i++) {
            BoxItem box = arrayBoxItem[i];
            if (box.x2 > 0 || box.y2 > 0) {
                box.range = 0;
            } else {
                if (tick % 40 <= 5) {
                    box.range = new Random().nextBoolean() ? -1 : 1;
                } else {
                    box.range = 0;
                }
            }
            if (box.move) {
                b(var1, box.x, box.y, null, false);
                Binary2.a(var1, -5, 0, box.x + 2, box.y + 2, 25, (int) 25);
            } else {
                b(var1, box.xMain, box.yMain, null, false);
                Binary2.a(var1, -5, 0, box.xMain + 2, box.yMain + 2, 25, (int) 25);
            }
        }
        if (boxMain != null && ran) {

            b(var1, boxMain.x + boxMain.range, boxMain.y + boxMain.range, null, true);
            Binary2.a(var1, -5, 0, boxMain.x + boxMain.range + 2, boxMain.y + boxMain.range + 2, 25, (int) 25);

        }
        boolean c = false;
        for (int i = 0; i < arrayBoxItem.length;
                i++) {
            BoxItem box = arrayBoxItem[i];
            if (box.isChange) {
                var1.a((float) 1.2F, (float) 0.1F);
                box.range2++;
                box.tick++;
                box.range2 = (box.range2) % 11;
                if (box.tick < 10) {
                    if (box.idTemp != -1) {
                        LangLa_fq.a(var1, DataCenter.gI().ItemTemplate[box.idTemp].idIcon, Utlis.c((byte) (box.range2)), box.x + 14, box.y + 15, 3);
                    } else {
                        LangLa_fq.a(var1, box.item.getItemTemplate().idIcon, Utlis.c((byte) (box.range2)), box.x + 14, box.y + 15, 3);
                    }
                } else {
                    LangLa_fq.a(var1, DataCenter.gI().ItemTemplate[774].idIcon, Utlis.c((byte) (box.range2)), box.x + 14, box.y + 15, 3);

                }
                var1.h();
            } else if (box != boxMain) {

                if (selectItem != null) {
                    box.range2++;
                    box.range2 = (box.range2) % 11;
                }

                if (box.idTemp != -1) {

                    LangLa_fq.a(var1, DataCenter.gI().ItemTemplate[box.idTemp].idIcon, 0, box.x + 14, box.y + 15, 3);

                } else {

                    if (selectItem == null) {
                        if (tick % 40 <= 5) {
                            var1.a((float) 1.2F, (float) 0.1F);
                        }
                        LangLa_fq.a(var1, box.item.getItemTemplate().idIcon, Utlis.c((byte) (box.range2)), box.x + box.range + 14, box.y + 15, 3);
                        if (tick % 40 <= 5) {
                            var1.h();
                        }
                    } else {
                        LangLa_fq.a(var1, box.item.getItemTemplate().idIcon, Utlis.c((byte) (box.range2)), box.x + 14, box.y + 15, 3);
                    }

                }

            } else {

                box.item.level = (byte) (selectItem != null && selectItem == box ? 4 : 0);
            }

            if (System.currentTimeMillis() - delayOpen >= 200L || box.move) {
                if (box.idTemp != -1) {
                    time = 50;
                }
                if (box.move) {

                    time = 200;
                }
                if (box.x2 > 0) {
                    if (box.x != box.x2) {
                        c = true;
                        if (box.countX == -1) {
                            box.countX = (box.x2 - box.x);
                        }
                        delay = (int) (Utlis.positive(box.countX) / (time / 25));
                        if (delay == 0) {
                            delay = 1;
                        }
                        if (box.x > box.x2) {
                            box.x -= delay;
                            if (box.x < box.x2) {
                                box.x = box.x2;
                            }
                        } else {

                            box.x += delay;
                            if (box.x > box.x2) {
                                box.x = box.x2;
                            }
                        }

                    } else {
                        box.x2 = 0;
                    }
                }
                if (box.y2 > 0) {
                    if (box.y != box.y2) {
                        c = true;
                        if (box.countY == -1) {
                            box.countY = box.y2 - box.y;
                        }
                        delay = (int) (Utlis.positive(box.countY) / (time / 25));
                        if (delay == 0) {
                            delay = 1;
                        }
                        if (box.y > box.y2) {
                            box.y -= delay;
                            if (box.y < box.y2) {
                                box.y = box.y2;
                            }
                        } else {
                            box.y += delay;
                            if (box.y > box.y2) {
                                box.y = box.y2;
                            }
                        }
                    } else {
                        box.y2 = 0;
                    }
                }
                if (!c) {
                    box.move = false;
                }
            }
        }
        if (selectItem == null) {
            if (!c) {

                btn_ThayDoi.a(false);
            }
        }
        if (selectItem != null && System.currentTimeMillis() - delayOpen >= 200L) {
            if (!c && ran && isReadItem) {
                ran = false;
                isReadItem = false;
                btn_ThuLai.a(false);
                for (int i = 0; i < arrayBoxItem.length; i++) {
                    if (arrayBoxItem[i] != boxMain) {
                        arrayBoxItem[i].x2 = arrayBoxItem[i].xMain;
                        arrayBoxItem[i].y2 = arrayBoxItem[i].yMain;
                        arrayBoxItem[i].countX = -1;
                        arrayBoxItem[i].countY = -1;
                        arrayBoxItem[i].idTemp = idItem[i];
                    }else{
                        boxMain.item = new Item(idItem[i]);
                    }
                }

            }
        }
        if (boxMain != null && !ran && !boxMain.isChange) {
            if (tick % 40 <= 5) {
                var1.a((float) 1.2F, (float) 0.5F);
            }
            b(var1, boxMain.x + boxMain.range, boxMain.y + boxMain.range, boxMain.item, true);
            if (tick % 40 <= 5) {
                var1.h();
            }
        } else {
        }
        if (delayOpen2 != 0 && System.currentTimeMillis() - delayOpen2 >= 0) {
            delayOpen2 = 0L;
            btn_ThayDoi.a(false);
            btn_TuLat.a(false);
            btn_ThuLai.a(true);
            delayOpen = System.currentTimeMillis() * 2;
            selectItem = null;
            arrayBoxItem = new BoxItem[arrayBoxItem.length];
        }

        this.b(var1);
    }

    public void a(LangLa_jz var1, int var2, int var3) {
        if (var1.b >= 2907 && var1.b < 9999) {
            if(!checkVeMayMan()){
                    DataCenter.gI().currentScreen.showMessage("Bạn không có vé may mắn để tham gia", -65536);
                    return;
            }
            if (selectItem == null) {
                btn_ThayDoi.a(true);
                btn_TuLat.a(true);
                int var1z = var1.b - 2907;
                selectCard((byte) var1z);
                selectItem = arrayBoxItem[var1z];
                c2 = var1z;
                ran = true;
                delayOpen = System.currentTimeMillis();
                for (int i = 0; i < arrayBoxItem.length; i++) {
                    arrayBoxItem[i].countX = -1;
                    arrayBoxItem[i].countY = -1;

                    arrayBoxItem[i].x2 = selectItem.xMain;
                    arrayBoxItem[i].y2 = selectItem.yMain;
                }
            }
        } else if (var1.b == 9999) {
             if(!checkVeMayMan()){
                    DataCenter.gI().currentScreen.showMessage("Bạn không có vé may mắn để tham gia", -65536);
                    return;
            }
            if (selectItem == null&&checkVeMayMan()) {
                btn_ThayDoi.a(true);
                btn_TuLat.a(true);
                int var1z = Utlis.nextInt(arrayBoxItem.length);
                selectCard((byte) var1z);
                selectItem = arrayBoxItem[var1z];
                c2 = var1z;
                ran = true;
                delayOpen = System.currentTimeMillis();
                for (int i = 0; i < arrayBoxItem.length; i++) {
                    arrayBoxItem[i].countX = -1;
                    arrayBoxItem[i].countY = -1;
                    arrayBoxItem[i].x2 = selectItem.xMain;
                    arrayBoxItem[i].y2 = selectItem.yMain;
                }
            }
        } else if (var1.b == 10000) {
            btn_ThayDoi.a(true);
            ArrayList<BoxItem> list = new ArrayList(Arrays.asList(arrayBoxItem));
            ArrayList<BoxItem> list2 = new ArrayList(Arrays.asList(arrayBoxItem.clone()));
            while (list.size() > 0 && list2.size() > 0) {
                int random = Utlis.nextInt(list.size());
                int random2 = Utlis.nextInt(list2.size());
                BoxItem b1 = list.remove(random);
                BoxItem b2 = list2.remove(random2);
                b1.countX = -1;
                b1.countY = -1;
                b1.x2 = b2.x;
                b1.y2 = b2.y;
                b1.xMain = b2.x;
                b1.yMain = b2.y;
                b1.move = true;

            }
        } else if (var1.b == 10001) {
            delayOpen2 = System.currentTimeMillis() + 100;
            for (int i = 0; i < arrayBoxItem.length; i++) {
                arrayBoxItem[i].tick = 0;
                arrayBoxItem[i].isChange = true;

            }
        }
    }
    public boolean checkVeMayMan(){
        for(Item item: Char.gI().arrItemBag){
            if(item!= null &&item.id==932){
                return true;
            }
        }
        return false;
    }

    public Vector c() {
        Vector vec = super.c();
        for (int i = 0; i < arrayBoxItem.length; i++) {
            if (arrayBoxItem[i] != null) {
                vec.add(new LangLa_jz(2907 + i, arrayBoxItem[i].xMain, arrayBoxItem[i].yMain, arrayBoxItem[i].xMain + 35, arrayBoxItem[i].yMain + 35, null, this));
            }
        }
        return vec;
    }

    public void selectCard(byte index) {
        try {
            Message msg = new Message((byte) 122);
            msg.writeByte(102);
            msg.writeByte(index);
            msg.send();
        } catch (Exception ex) {

        }
    }

    @Override
    public void b() {
    }

    public int getZ(int total, int p) {
        return total * p / 100;
    }

    public static class BoxItem {

        public int range;
        public int range2;
        public int x;
        public int y;
        public int x2;
        public int y2;

        public int tickX1;
        public int tickX2;
        public int tickY1;
        public int tickY2;
        public int countX = -1;
        public int countY = -1;
        public Item item;
        private int xMain;
        private int yMain;
        private boolean move;
        private int idTemp = -1;
        private boolean isChange;
        public int tick;
    }
}
