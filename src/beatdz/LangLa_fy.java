package beatdz;import beatdz.*;

import beatdz.DataCenter;

public class LangLa_fy implements Runnable {

    boolean a;

    DataCenter b;

    public LangLa_fy(DataCenter var1, boolean var2) {
        this.b = var1;
        this.a = var2;
    }

    public void run() {
        boolean ios = com.badlogic.gdx.Gdx.app.getType() == com.badlogic.gdx.Application.ApplicationType.iOS;
        try {
            this.b.startupPhase = "Chuẩn bị phông chữ";
            mFont.a();
            this.b.startupPhase = "Đọc dữ liệu đã lưu";
            try {
                if (ios) this.b.readCachedGameData(this.a);
                else this.b.readArrDataGame(this.a);
            } catch (RuntimeException badCache) {
                if (!ios) throw badCache;
                // Invalidate only game-table data, never accounts or other user settings.
                Binary.delete("arr_data_game.beatdz");
                Binary.delete("arr_check_0.beatdz");
                this.b.startupFailure = "Cache dữ liệu lỗi; sẽ tải lại";
                com.badlogic.gdx.Gdx.app.error("Startup", "Discarded invalid iOS game-data cache", badCache);
            }
            this.b.startupPhase = "Chuẩn bị ảnh giao diện";
            LangLa_fq.c();
            LangLa_fq.a(false);
        } catch (Throwable error) {
            this.b.startupFailure = error.getClass().getSimpleName() + ": " + String.valueOf(error.getMessage());
            com.badlogic.gdx.Gdx.app.error("Startup", "Cache initialization failed at " + this.b.startupPhase, error);
        } finally {
            // Reaching the manifest must not depend on successful cache warmup.
            this.b.startupPhase = "Kiểm tra phiên bản";
            this.b.startupWarmupDone = true;
        }
    }
}
