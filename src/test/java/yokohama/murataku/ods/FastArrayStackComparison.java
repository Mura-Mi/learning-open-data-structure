package yokohama.murataku.ods;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Random;

class FastArrayStackComparison {
    Random random = new Random();

    @Test
    void testComparison() {
        {
            long standardStart = System.nanoTime();
            List<Integer> list = new ArrayStack<>();
            for (int i = 0; i < 100_000; i++) {
                list.add(0, random.nextInt());
            }
            long standardEnd = System.nanoTime();
            System.out.printf("Standard: %,d(sec)\n", Duration.ofNanos(standardEnd - standardStart).toMillis());
        }

        {
            long fastStart = System.nanoTime();
            List<Integer> fastList = new FastArrayStack<>();
            for (int i = 0; i < 100_000; i++) {
                fastList.add(0, random.nextInt());
            }
            long fastEnd = System.nanoTime();
            System.out.printf("Fast: %,d(sec)\n", Duration.ofNanos(fastEnd - fastStart).toMillis());
        }
    }
}
