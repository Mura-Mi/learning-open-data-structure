package yokohama.murataku.ods;

/** Sorted Set */
public interface SSet<T extends Comparable<T>> {
    int size();
    boolean add(T t);
    T remove(T t);
    /** the minimum value greater than t */
    T find(T t);
}
