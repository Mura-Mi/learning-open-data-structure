package yokohama.murataku.ods;

import static org.junit.jupiter.api.Assertions.*;

class FastArrayStackTest extends AbstractArrayStackTest{

    @Override
    protected List<Character> newSut() {
        return new FastArrayStack<>();
    }
}