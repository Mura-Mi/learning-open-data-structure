package yokohama.murataku.ods;

public interface List<T> {
    int size();

    T get(int i);

    T set(int i, T t);

    void add(int i, T t);

    T remove(int i);
}
