package yokohama.murataku.ods;

public class DualArrayDeque<T> implements List<T> {
    private ArrayStack<T> head;
    private ArrayStack<T> tail;

    public DualArrayDeque() {
        this(5);
    }

    public DualArrayDeque(int capacity) {
        this.head = new ArrayStack<>(capacity);
        this.tail = new ArrayStack<>(capacity);
    }

    @Override
    public int size() {
        return head.size() + tail.size();
    }

    @Override
    public T get(int i) {
        if (i < head.size()) {
            return head.get(i);
        } else {
            return tail.get(i - head.size());
        }
    }

    @Override
    public T set(int i, T t) {
        var headSize = head.size();
        if (i < headSize) {
            return head.set(i, t);
        } else {
            return tail.set(i - headSize, t);
        }
    }

    @Override
    public void add(int i, T t) {
        var headSize = head.size();
        if (i < headSize) {
            head.add(i, t);
        } else {
            tail.add(i - headSize, t);
        }
    }

    @Override
    public T remove(int i) {
        var headSize = head.size();
        if (i < headSize) {
            return head.remove(i);
        } else {
            return tail.remove(i - headSize);
        }
    }

    @Override
    public int capacity() {
        return head.capacity() + tail.capacity();
    }
}
