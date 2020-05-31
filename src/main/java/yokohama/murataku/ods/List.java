package yokohama.murataku.ods;

public interface List<T> extends HasCapacity , Deque<T> {
    int size();

    T get(int i);

    T set(int i, T t);

    void add(int i, T t);

    T remove(int i);

    default void enqueueHead(T t){
        add(0,t);
    }

    default void enqueueTail(T t){
        add(size(), t);
    }

    default T dequeueHead(){
        return remove(0);
    }

    default T dequeueTail(){
        return remove(size() -1);
    }
}
