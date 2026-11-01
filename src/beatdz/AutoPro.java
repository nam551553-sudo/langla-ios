/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beatdz;

import beatdz.libForBeatdz.WaitAuto;
import java.io.IOException;

/**
 *
 * @author admin
 */
public class AutoPro {

    
    
    static mImage iconTool = null;
    static mImage iconTool2 = null;
    static mImage iconTool3 = null;
    static String VER = "0.4";

    public static synchronized mImage getIconTool() {
        if (iconTool == null || iconTool.b == null) {
            iconTool = loadToolImage("arr_icon", "logo-main.png", "resource/4.png");
        }
        return iconTool;
    }

    public static mImage getIconTool2() {
//        try {
//            if (iconTool2 == null || iconTool2.b() == null) {
//                // if (Binary.read("arr_iconname") == null) {
//                Binary.write("arr_iconname", Binary.b("https://langlaanhhung.vn/logo-main.png"));
//                //  }
//                iconTool2 = mImage.a(Binary.read("arr_iconname"), 0, 0);
//            }
//            return iconTool2;
//        } catch (Exception ex) {
//        }
        return mImage.a(1, 1);
    }

    public static synchronized mImage getIconTool3() {
        if (iconTool3 == null || iconTool3.b == null) {
            iconTool3 = loadToolImage("arr_iconimage", "BG.jpg", "resource/background.jpg");
        }
        return iconTool3;
    }

    private static mImage decodeToolImage(byte[] data) {
        if (data == null || data.length < 8) return null;
        boolean png = data[0] == (byte) 0x89 && data[1] == 'P' && data[2] == 'N' && data[3] == 'G';
        boolean jpeg = data[0] == (byte) 0xff && data[1] == (byte) 0xd8;
        return png || jpeg ? mImage.a(data, 0, data.length) : null;
    }

    private static mImage loadToolImage(String cacheKey, String remotePath, String fallbackPath) {
        mImage image = decodeToolImage(Binary.read(cacheKey));
        if (image != null) return image;
        byte[] data = Binary.b(ClientConfig.DATA_URL + remotePath);
        image = decodeToolImage(data);
        if (image != null) {
            Binary.write(cacheKey, data);
            return image;
        }
        com.badlogic.gdx.Gdx.app.error("Assets", remotePath + " did not return a valid image; using bundled image");
        data = com.badlogic.gdx.Gdx.files.internal(fallbackPath).readBytes();
        image = decodeToolImage(data);
        if (image != null) {
            Binary.write(cacheKey, data);
            return image;
        }
        return mImage.a(1, 1);
    }
    private static long delayCheckPL;
    public static LangLa_bg srcPL;
    private static long delayNhanPhucLoi;
    private static boolean isTat = false;

    public static boolean isBuyHPMP = false;
    public static boolean isBuyTA = false;
    private static long delayMuaHPMP;

    

    public static void update() {
        long time = System.currentTimeMillis();
        try {
            if (DataCenter.gI().currentScreen != null && DataCenter.gI().currentScreen instanceof GameSrc) {
                if (isAuto(0)) {
                    if (srcPL == null || System.currentTimeMillis() - delayCheckPL >= 0) {
                        srcPL = null;
                        GameSrc.gI().openFunc(88);
                        WaitAuto.get("OpenFunc88").waitObject(5000L);
                        if (srcPL == null) {
                            delayCheckPL = System.currentTimeMillis() + 5000;
                        } else {
                            if (GameSrc.gI().as) {
                                isTat = true;
                            }
                            delayCheckPL = System.currentTimeMillis() + 10000;
                        }
                    } else {
                        if (srcPL != null) {
                            if (System.currentTimeMillis() - delayNhanPhucLoi >= 2000) {
                                srcPL.nhanPhucLoi();
                                delayNhanPhucLoi = System.currentTimeMillis() + 10000;
                            }
                            if (isTat && !GameSrc.gI().as) {
                                isTat = false;
                                srcPL = null;
                                GameSrc.gI().as = false;
                                delayCheckPL = System.currentTimeMillis() + 30000;
                            }

                        }
                    }
                }
//                if (isAuto(8)) {
//                    if (isBuyHPMP) {
//                        if (System.currentTimeMillis() - delayMuaHPMP >= 2000) {
//                            int idItemHP = findIdItemWithTypeAndLevel(22, 1);
//                            int idItemMP = findIdItemWithTypeAndLevel(23, 1);
//                            if (Char.gI().level() >= 60) {
//                                idItemHP = findIdItemWithTypeAndLevel(22, 60);
//                                idItemMP = findIdItemWithTypeAndLevel(23, 60);
//                            } else if (Char.gI().level() >= 55) {
//                                idItemHP = findIdItemWithTypeAndLevel(22, 55);
//                                idItemMP = findIdItemWithTypeAndLevel(23, 55);
//                            } else if (Char.gI().level() >= 50) {
//                                idItemHP = findIdItemWithTypeAndLevel(22, 50);
//                                idItemMP = findIdItemWithTypeAndLevel(23, 50);
//                            } else if (Char.gI().level() >= 40) {
//                                idItemHP = findIdItemWithTypeAndLevel(22, 40);
//                                idItemMP = findIdItemWithTypeAndLevel(23, 40);
//                            } else if (Char.gI().level() >= 30) {
//                                idItemHP = findIdItemWithTypeAndLevel(22, 30);
//                                idItemMP = findIdItemWithTypeAndLevel(23, 30);
//                            } else if (Char.gI().level() >= 20) {
//                                idItemHP = findIdItemWithTypeAndLevel(22, 20);
//                                idItemMP = findIdItemWithTypeAndLevel(23, 20);
//                            }
//                            if (idItemHP != -1 && GameSrc.gI().bu == 0) {
//                                autoBuyItem(1, idItemHP, 500);
//                            }
//                            if (idItemMP != -1 && GameSrc.gI().bw == 0) {
//                                autoBuyItem(1, idItemMP, 500);
//                            }
//                            delayMuaHPMP = System.currentTimeMillis();
//                        }
//
//                    }
//
//                }
//                if (isAuto(9)) {
//                    if (isBuyTA) {
//                        if (System.currentTimeMillis() - delayMuaHPMP >= 2000) {
//                            int level = Char.gI().level() / 5 * 5;
//                            if (level < 10) {
//                                level = 1;
//                            }
//                            autoBuyItem(5, findIdItemWithTypeAndLevel(24, level), 10);
//                            delayMuaHPMP = System.currentTimeMillis();
//                        }
//                    }
//                }
            }
        } catch (Exception ex) {

        } finally {
            long time2 = 100 - (System.currentTimeMillis() - time);
            if (time2 <= 0) {
                time2 = 1;
            }
            Utlis.sleep(time2);
        }
    }

    private static int findIdItemWithTypeAndLevel(int type, int level) {

        for (int i = 0; i < DataCenter.gI().ItemTemplate.length; i++) {
            if (DataCenter.gI().ItemTemplate[i].type == type && DataCenter.gI().ItemTemplate[i].levelNeed == level) {
                return DataCenter.gI().ItemTemplate[i].id;
            }
        }
        return -1;
    }

    public static boolean isAuto(int i) {
        return SettingsTab.gI().a[i + 100] == 0;
    }

    public static void autoBuyItem(int func, int id, int amount) {
        GameSrc.gI().l.clear();
        GameSrc.gI().openFunc(func);
        if (WaitAuto.get("openFunc" + func).waitObject(2000L) && GameSrc.gI().l.size() > 0) {
            for (int i = 0; i < GameSrc.gI().l.size(); i++) {
                Item item = (Item) GameSrc.gI().l.get(i);
                if (item.id == id) {
                    try {
                        Message var46;
                        (var46 = new Message((byte) 121)).writeShort(item.idBuy);
                        var46.writeShort(amount);
                        var46.send();
                    } catch (IOException ex) {
                    }
                    WaitAuto.get("BuyItem").waitObject(2000L);
                    return;
                }
            }
            for (int i = 0; i < GameSrc.gI().l.size(); i++) {
                Item item = (Item) GameSrc.gI().l.get(i);
                if (item.idBuy == id) {
                    try {
                        Message var46;
                        (var46 = new Message((byte) 121)).writeShort(item.idBuy);
                        var46.writeShort(amount);
                        var46.send();
                    } catch (IOException ex) {
                    }
                    WaitAuto.get("BuyItem").waitObject(2000L);
                    return;
                }
            }
        }

    }

// Mutable legacy globals belong to the current account, including background callbacks.
public static final class SessionState implements beatdz.MultiSession.State {
public String tk;
public String mk;
public void initialize() {
this.tk = "";
this.mk = "";
{
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    update();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                boolean b = false;
                while (true) {
                    long var2 = System.currentTimeMillis();

                    try {
                        if (Session.gI().isConnected() && DataCenter.gI().currentScreen instanceof GameSrc) {
                            if (Graphics.m()) {
                                GameSrc.gI().updateMove();
                                GameSrc.gI().Char_O();
                            }
//                            if (b || (System.currentTimeMillis() / 1000) % 600 == 0) {
//                                b = false;
//                                GameSrc.a("From Beatdz With Love");
//                            }
                        } else {
                            b = true;
                        }

//                            if (Char.gI().aU != null) {
//                                long l = System.currentTimeMillis() - Char.gI().aU.timeOut;
//                                if (l > 0L) {
//                                    Char.gI().aU.action();
//                                    Char.gI().aU = null;
//                                    GameSrc.gI().skillHoTro();
//                                }
//                            }
//                            if (Char.gI().aY.useTime && Char.gI().aY.a(Char.gI(), false)) {
//                                Char.gI().aY.useTime = false;
//                                if (GameSrc.gI().selectEntity != null && GameSrc.gI().selectEntity instanceof Mob) {
//                                    Char.gI().a2(GameSrc.gI().selectEntity, Char.gI().aY);
//                                    Char.gI().aY.f();
//                                }
//                            }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    } finally {
                        int var15;
                        if ((var15 = 28 - (int) (System.currentTimeMillis() - var2)) <= 0) {
                            var15 = 1;
                        }
                        Utlis.sleep((long) var15);
                    }
                }
            }
        }).start();
    }
}
}
private static final int $SESSION_STATE_ID = beatdz.MultiSession.register("beatdz.AutoPro");
public static SessionState $state_AutoPro() { return beatdz.MultiSession.state($SESSION_STATE_ID, SessionState::new); }
}
