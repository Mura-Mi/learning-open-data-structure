package yokohama.murataku.ods;

class ArrayStackTest implements AbstractListTest {

    @Override
    public <T> AbstractArrayStack<T> newSut() {
        return new ArrayStack<>();
    }

    @Override
    public <T> Queue<T> newSut(int capacity) {
        return new ArrayStack<>(capacity);
    }
}