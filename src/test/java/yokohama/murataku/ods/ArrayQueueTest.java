package yokohama.murataku.ods;

class ArrayQueueTest implements AbstractQueueTest {

    @Override
    public <T> Queue<T> newSut() {
        return new ArrayQueue<T>(10);
    }

    @Override
    public <T> Queue<T> newSut(int capacity) {
        return new ArrayQueue<T>(capacity);
    }
}