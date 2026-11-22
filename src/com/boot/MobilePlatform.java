package com.boot;

import beatdz.Binary;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.TextInputListener;
import com.listener.*;

/** Platform services shared by Android and iOS. */
public final class MobilePlatform implements AppEventListener, IDialogTextListener {
    public static void install() {
        Binary.a = "animesoft/1/";
        MobilePlatform platform = new MobilePlatform();
        GameM.b(platform);
        GameM.a(platform);
    }
    public void a() { }
    public void a(VoiceRecordPermissionCallback callback) {
        // Recording is unavailable until a native recording implementation is supplied.
    }
    public boolean b() { return false; }
    public void a(byte[] data) { throw new UnsupportedOperationException("Native codec is not supplied"); }
    public byte[] b(byte[] data) { throw new UnsupportedOperationException("Native codec is not supplied"); }
    public boolean c() { return false; }
    public void a(TextInputListener listener, String title, String text, String hint) {
        Gdx.input.getTextInput(listener, title, text, hint);
    }
    public int a(String title, String message) {
        Gdx.app.log(title, message);
        return -1;
    }
}
