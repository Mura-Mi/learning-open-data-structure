package yokohama.murataku.ods;

public interface List<T> extends HasCapacity , Queue<T> {
    int size();

    T get(int i);

    T set(int i, T t);

    void add(int i, T t);

    T remove(int i);

    @Override
    default void enqueue(T t) {
        this.add(size(), t);
    }

    @Override
    default T dequeue() {
        return this.remove(0);
    }
}
