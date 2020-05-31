package yokohama.murataku.ods;

import static org.junit.jupiter.api.Assertions.*;

class DualArrayDequeTest implements AbstractListTest {

    @Override
    public <T> List<T> newSut() {
        return new DualArrayDeque<>();
    }

    @Override
    public <T> Queue<T> newSut(int capacity) {
        return new DualArrayDeque<>(capacity);
    }
}