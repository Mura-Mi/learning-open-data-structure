package yokohama.murataku.ods;

public interface Deque<T> extends Queue<T> {
    void enqueueHead(T t);

    void enqueueTail(T t);

    T dequeueHead();

    T dequeueTail();

    default void enqueue(T t) {
        enqueueTail(t);
    }

    default T dequeue() {
        return dequeueHead();
    }
}
