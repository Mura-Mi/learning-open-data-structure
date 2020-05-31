package yokohama.murataku.ods;

public interface List<T> {
    int size();
    T get(int i);
    void set(int i, T t);
    void add(int i, T t);
    void remove(int i);
}
