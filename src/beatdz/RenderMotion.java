package beatdz;

/** Interpolation is confined to drawing. Collision, packets and UI use current simulation state. */
final class RenderMotion {
    static final float STEP = 1f / 30f;
    private final Sample camera = new Sample();
    private long tick;
    private int map = -1;
    private boolean valid;

    static final class Sample {
        int x, y, beforeX, beforeY;
        long tick = -1;
        void before(int x, int y, long tick) { beforeX = x; beforeY = y; this.tick = tick; }
        void after(int x, int y) { this.x = x; this.y = y; }
        int offsetX(float alpha) { return safe() ? Math.round((beforeX - x) * (1f - alpha)) : 0; }
        int offsetY(float alpha) { return safe() ? Math.round((beforeY - y) * (1f - alpha)) : 0; }
        float exactX(float alpha) { return safe() ? (beforeX - x) * (1f - alpha) : 0f; }
        float exactY(float alpha) { return safe() ? (beforeY - y) * (1f - alpha) : 0f; }
        private boolean safe() { return Math.abs(beforeX - x) <= 128 && Math.abs(beforeY - y) <= 128; }
    }

    void reset() { valid = false; map = -1; ++tick; }
    void before(GameSrc game) {
        if (game.mapID != map) { reset(); map = game.mapID; }
        ++tick;
        camera.before(DataCenter.gI().j, DataCenter.gI().k, tick);
        for (Object value : game.K) if (value instanceof Entity) capture((Entity)value);
        capture(Char.gI());
    }
    private void capture(Entity entity) { entity.renderMotion.before(entity.cx, entity.cy, tick); }
    void after(GameSrc game) {
        if (game.mapID != map) { reset(); return; }
        camera.after(DataCenter.gI().j, DataCenter.gI().k);
        for (Object value : game.K) if (value instanceof Entity) finish((Entity)value);
        finish(Char.gI()); valid = true;
    }
    private void finish(Entity entity) { if (entity.renderMotion.tick == tick) entity.renderMotion.after(entity.cx, entity.cy); }
    int cameraX(float alpha) { return DataCenter.gI().j + (valid ? camera.offsetX(alpha) : 0); }
    int cameraY(float alpha) { return DataCenter.gI().k + (valid ? camera.offsetY(alpha) : 0); }
    int x(Entity entity, float alpha) { return eligible(entity) ? entity.renderMotion.offsetX(alpha) : 0; }
    int y(Entity entity, float alpha) { return eligible(entity) ? entity.renderMotion.offsetY(alpha) : 0; }
    float cameraOffsetX(float alpha) { return valid ? camera.exactX(alpha) : 0f; }
    float cameraOffsetY(float alpha) { return valid ? camera.exactY(alpha) : 0f; }
    float exactX(Entity entity, float alpha) { return eligible(entity) ? entity.renderMotion.exactX(alpha) : 0f; }
    float exactY(Entity entity, float alpha) { return eligible(entity) ? entity.renderMotion.exactY(alpha) : 0f; }
    private boolean eligible(Entity entity) {
        return valid && entity.renderMotion.tick == tick && entity.cx == entity.renderMotion.x && entity.cy == entity.renderMotion.y;
    }
}
