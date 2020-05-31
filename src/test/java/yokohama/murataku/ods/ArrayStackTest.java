package yokohama.murataku.ods;

class ArrayStackTest extends AbstractArrayStackTest {

    @Override
    protected <T> AbstractArrayStack<T> newSut() {
        return new ArrayStack<>();
    }
}