package yokohama.murataku.ods;

import static org.junit.jupiter.api.Assertions.*;

class FastArrayStackTest extends AbstractArrayStackTest {

    @Override
    protected <T> AbstractArrayStack<T> newSut() {
        return new FastArrayStack<>();
    }
}