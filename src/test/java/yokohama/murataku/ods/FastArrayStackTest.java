package yokohama.murataku.ods;

class FastArrayStackTest implements AbstractListTest {

    @Override
    public <T> AbstractArrayStack<T> newSut() {
        return new FastArrayStack<>();
    }

    @Override
    public <T> Queue<T> newSut(int capacity) {
        return new FastArrayStack<>(capacity);
    }
}