package yokohama.murataku.ods;

@SuppressWarnings("unchecked")
public class ArrayQueue<T> implements Queue<T> {
    T[] array;
    int head;
    int tail;

    ArrayQueue(T[] array, int head, int tail) {
        this.array = array;
        this.head = head;
        this.tail = tail;
    }

    public ArrayQueue(int initCap) {
        this.array = (T[]) new Object[initCap];
        resetHeadTail();
    }

    int size() {
        if (head == tail) return 0;
        else if (head < tail) return tail - head;
        else {
            var latter = capacity() - head;
            var former = tail + 1;
            return latter + former;
        }
    }

    private void resetHeadTail() {
        head = 0;
        tail = 0;
    }

    @Override
    public void enqueue(T t) {
        array[tail] = t;
        tail = tail + 1;
        expandIfNecessary();
    }

    @Override
    public T dequeue() {
        if (head == tail) return null;
        T ret = array[head];
        array[head] = null;
        head = head + 1;
        if (head == tail) resetHeadTail();
        return ret;
    }

    @Override
    public int capacity() {
        return this.array.length;
    }

    void expandIfNecessary() {
        if (capacity() * 2 / 3 < size()) {
            var newArray = (T[]) new Object[capacity() * 2];
            if (tail < head) {
                var headLen = capacity() - head;
                System.arraycopy(this.array, head, newArray, 0, headLen);
                var tailLen = size() - tail;
                System.arraycopy(this.array, 0, newArray, capacity() - head, tailLen);
                this.tail = headLen + tailLen;
            } else {
                System.arraycopy(this.array, head, newArray, 0, tail - head);
                this.tail = tail - head;
            }
            this.array = newArray;
            this.head = 0;
        }
    }
}
