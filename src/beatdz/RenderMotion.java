package beatdz;

/** Interpolation is confined to drawing. Collision, packets and UI use current simulation state. */
final class RenderMotion {
    static final float STEP = 1f / 30f;
    private static final float MAX_STEP = 128f;
    private final Sample camera = new Sample();
    private long tick;
    private int map = -1;
    private boolean valid;
    private boolean preciseCamera;
    private float cameraX, cameraY;

    static final class Sample {
        float x, y, beforeX, beforeY;
        long tick = -1;
        void before(float x, float y, long tick) { beforeX = x; beforeY = y; this.tick = tick; }
        void after(float x, float y) { this.x = x; this.y = y; }
        float exactX(float alpha) { return safe() ? (beforeX - x) * (1f - alpha) : 0f; }
        float exactY(float alpha) { return safe() ? (beforeY - y) * (1f - alpha) : 0f; }
        private boolean safe() { return Math.abs(beforeX - x) <= MAX_STEP && Math.abs(beforeY - y) <= MAX_STEP; }
    }

    void reset() { valid = false; preciseCamera = false; map = -1; ++tick; }

    void followCamera(DataCenter data, int targetX, int targetY) {
        cameraX = follow(currentCameraX(data.j), targetX);
        cameraY = follow(currentCameraY(data.k), targetY);
        preciseCamera = true;
        data.j = Math.round(cameraX);
        data.k = Math.round(cameraY);
    }

    private static float follow(float current, int target) {
        float distance = target - current;
        return Math.abs(distance) < 0.01f ? target : current + distance / 8f;
    }

    private float currentCameraX(int x) { return preciseCamera && Math.round(cameraX) == x ? cameraX : x; }
    private float currentCameraY(int y) { return preciseCamera && Math.round(cameraY) == y ? cameraY : y; }
    boolean usesPreciseCamera() { return preciseCamera; }

    void before(GameSrc game) {
        if (game.mapID != map) { reset(); map = game.mapID; }
        ++tick;
        DataCenter data = DataCenter.gI();
        camera.before(currentCameraX(data.j), currentCameraY(data.k), tick);
        for (Object value : game.K) if (value instanceof Entity) capture((Entity)value);
        capture(Char.gI());
    }
    private void capture(Entity entity) { entity.renderMotion.before(entity.cx, entity.cy, tick); }
    void after(GameSrc game) {
        if (game.mapID != map) { reset(); return; }
        DataCenter data = DataCenter.gI();
        camera.after(currentCameraX(data.j), currentCameraY(data.k));
        for (Object value : game.K) if (value instanceof Entity) finish((Entity)value);
        finish(Char.gI()); valid = true;
    }
    private void finish(Entity entity) { if (entity.renderMotion.tick == tick) entity.renderMotion.after(entity.cx, entity.cy); }

    float drawnCameraX(int x, float alpha) {
        float current = currentCameraX(x);
        return valid && camera.x == current ? current + camera.exactX(alpha) : current;
    }

    float drawnCameraY(int y, float alpha) {
        float current = currentCameraY(y);
        return valid && camera.y == current ? current + camera.exactY(alpha) : current;
    }

    int cameraPaddingX(int x) { return cameraPadding(camera.beforeX, currentCameraX(x)); }
    int cameraPaddingY(int y) { return cameraPadding(camera.beforeY, currentCameraY(y)); }

    private int cameraPadding(float previous, float current) {
        if (!preciseCamera) return 0;
        float distance = Math.abs(current - previous);
        // Keep scenery visible at both ends of the interpolated camera step.
        return 1 + (camera.tick == tick && distance <= MAX_STEP ? (int)Math.ceil(distance) : 0);
    }

    float exactX(Entity entity, float alpha) { return eligible(entity) ? entity.renderMotion.exactX(alpha) : 0f; }
    float exactY(Entity entity, float alpha) { return eligible(entity) ? entity.renderMotion.exactY(alpha) : 0f; }
    private boolean eligible(Entity entity) {
        return valid && entity.renderMotion.tick == tick && entity.cx == entity.renderMotion.x && entity.cy == entity.renderMotion.y;
    }
}
