package yokohama.murataku.ods;

public interface Queue<T> {
    void enqueue(T t);
    T dequeue();
}
