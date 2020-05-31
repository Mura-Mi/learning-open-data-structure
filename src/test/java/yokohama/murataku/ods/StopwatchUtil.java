package yokohama.murataku.ods;

import java.time.Duration;

public class StopwatchUtil {
    static void measure(String prefix, Runnable routine) {
        long start = System.nanoTime();
        try {
            routine.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.nanoTime();
        System.out.printf("%s %,d(msec)\n", prefix, Duration.ofNanos(end - start).toMillis());
    }
}
