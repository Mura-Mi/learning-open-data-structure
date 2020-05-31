package yokohama.murataku.ods;

public interface Queue<T> extends HasCapacity {
    void enqueue(T t);

    T dequeue();
}
