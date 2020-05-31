package yokohama.murataku.ods;

@SuppressWarnings("ManualArrayCopy")
public class ArrayStack<T> implements List<T> {
    private T[] array;
    private int size;

    public ArrayStack() {
        //noinspection unchecked
        this.array = (T[]) new Object[10];
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int i) {
        return array[i];
    }

    @Override
    public void set(int i, T t) {
        T prev = array[i];
        array[i] = t;
        if (prev != null) {
            size = size+1;
        }
    }

    @Override
    public void add(int i, T t) {
        for (int j = size; j > i; j--) {
            array[j + 1] = array[j];
        }
        array[i] = t;
        this.size = size + 1;
    }

    @Override
    public void remove(int i) {

    }
}
