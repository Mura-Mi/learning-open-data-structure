package yokohama.murataku.ods;

import java.util.Random;

public final class SkipListUtils {
    private SkipListUtils() {
    }

    private static final Random random = new Random();

    public static int pickHeight() {
        byte a = 0b01;
        var rand = (byte) random.nextInt();
        var counter = 0;

        while ((rand & a) != 0b00) {
            counter++;
            a <<= 1;
        }
        return counter;
    }
}
