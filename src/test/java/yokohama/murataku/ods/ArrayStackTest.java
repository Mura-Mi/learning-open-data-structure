package yokohama.murataku.ods;

class ArrayStackTest extends AbstractArrayStackTest {

    @Override
    protected List<Character> newSut() {
        return new ArrayStack<>();
    }
}