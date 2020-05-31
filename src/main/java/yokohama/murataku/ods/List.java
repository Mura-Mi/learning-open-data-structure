package yokohama.murataku.ods;

public interface List<T> extends HasCapacity {
    int size();

    T get(int i);

    T set(int i, T t);

    void add(int i, T t);

    T remove(int i);
}
