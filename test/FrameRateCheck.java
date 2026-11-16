package beatdz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class FrameRateCheck {
    public static void main(String[] args) {
        List<Integer> calls = new ArrayList<>();
        FrameRate.install(calls::add);
        FrameRate.select(0);
        FrameRate.apply();
        FrameRate.select(1);
        FrameRate.select(2);
        FrameRate.select(0);
        require(calls.equals(Arrays.asList(60, 70, 90, 60)), "all FPS options reach the platform once");
        FrameRate.install(calls::add);
        FrameRate.apply();
        require(calls.size() == 5 && calls.get(4) == 60, "new platform receives the saved setting");
        FrameRate.select(255);
        require(FrameRate.target() == 60 && FrameRate.selection() == 0, "invalid selections recover to 60 FPS");
        System.out.println("PASS 60/70/90 FPS selection, platform callbacks, saved setting reapplication and invalid option recovery.");
    }

    private static void require(boolean value, String message) {
        if (!value) throw new AssertionError(message);
    }
}
