package yokohama.murataku.ods;

import java.util.Arrays;

@SuppressWarnings({"unchecked", "ManualArrayCopy"})
public abstract class AbstractArrayStack<T> implements List<T>, Queue<T> {
    protected T[] array;
    protected int size;

    protected AbstractArrayStack() {
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
    public T set(int i, T t) {
        T prev = array[i];
        array[i] = t;
        if (prev == null) {
            size = size + 1;
        }
        return prev;
    }

    @Override
    public void add(int i, T t) {
        for (int j = size - 1; j >= i; j--) {
            array[j + 1] = array[j];
        }
        array[i] = t;
        this.size = size + 1;
        resizeIfNecessary();
    }

    @Override
    public T remove(int i) {
        T prev = array[i];
        for (int j = i; j < size; j++) {
            array[j] = array[j + 1];
        }
        array[size - 1] = null;
        size = size - 1;
        return prev;
    }

    @Override
    public String toString() {
        return "ArrayStack{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                '}';
    }

    @Override
    public void enqueue(T t) {
        this.add(size, t);
    }

    @Override
    public T dequeue() {
        return this.remove(0);
    }

    protected abstract void resizeIfNecessary();
}
