package yokohama.murataku.ods;

import java.util.Arrays;

@SuppressWarnings({"ManualArrayCopy", "unchecked"})
public class ArrayStack<T> implements List<T> {
    private T[] array;
    private int size;

    public ArrayStack() {
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

    private void resizeIfNecessary() {
        int capacity = array.length;
        System.out.printf("start resize: %s %s\n", capacity, this.size);

        if (size == 0) {
            System.out.println("size 0");
            return;
        }

        T[] newArray = null;
        if (size > capacity * 2 / 3) { // expand
            System.out.println("expand");
            newArray = (T[]) new Object[capacity * 2];
        } else if (size < capacity / 3) {
            System.out.println("shrink");
            newArray = (T[]) new Object[capacity / 2];
        }
        if (newArray != null) {
            for (int i = 0; i < size; i++) {
                newArray[i] = this.array[i];
            }
            this.array = newArray;
        } else {
            System.out.println("Hold");
        }

    }

    @Override
    public String toString() {
        return "ArrayStack{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                '}';
    }
}
