package yokohama.murataku.ods;

class DLNode<T> {
    T ref;
    DLNode<T> prev;
    DLNode<T> next;

    public DLNode(T ref) {
        this.ref = ref;
    }

    public DLNode(T ref, DLNode<T> prev, DLNode<T> next) {
        this.ref = ref;
        this.prev = prev;
        this.next = next;
    }

    void swap() {
        var tmp = next;
        this.next = prev;
        this.prev = tmp;
    }
}

public class DLList<T> implements List<T>, Stack<T>, HasReverse<T> {
    private final DLNode<T> dummy;

    private static <T> DLNode<T> buildDummy() {
        var dummy = new DLNode<T>(null);
        dummy.prev = dummy;
        dummy.next = dummy;

        return dummy;
    }


    private int size;
    private DLNode<T> head;
    private DLNode<T> tail;

    public DLList() {
        this.size = 0;
        this.dummy = buildDummy();
        this.head = dummy;
        this.tail = dummy;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void add(int i, T t) {
        var node = getNode(i);
        var newNode = new DLNode<>(t, node.prev, node);
        node.prev.next = newNode;
        node.prev = newNode;
        this.size++;
        if (newNode.prev == dummy) {
            this.head = newNode;
        }
        if (newNode.next == dummy) {
            this.tail = newNode;
        }
    }

    private DLNode<T> getNode(int i) {
        DLNode<T> node;
        if (i < this.size() / 2) {
            node = dummy.next;
            for (int j = 0; j < i; j++) {
                node = node.next;
            }
        } else {
            node = this.dummy;
            for (int j = size; j > i; j--) {
                node = node.prev;
            }
        }
        return node;
    }

    @Override
    public T get(int i) {
        return getNode(i).ref;
    }

    @Override
    public T set(int i, T t) {
        return getNode(i).ref = t;
    }

    @Override
    public T remove(int i) {
        var toBeRemoved = getNode(i);
        if (toBeRemoved != dummy) size--;
        if (toBeRemoved.prev == dummy) this.head = toBeRemoved.next;
        if (toBeRemoved.next == dummy) this.tail = toBeRemoved.prev;
        toBeRemoved.prev.next = toBeRemoved.next;
        toBeRemoved.next.prev = toBeRemoved.prev;
        return toBeRemoved.ref;
    }

    @Override
    public int capacity() {
        return 0;
    }

    @Override
    public void push(T t) {
        this.enqueueHead(t);
    }

    @Override
    public T pop() {
        return this.dequeueHead();
    }

    @Override
    public void reverse() {
        var node = this.head;
        while (true) {
            node.swap();
            if (node == dummy) break;
            node = node.prev;
        }
        this.head = dummy.next;
        this.tail = dummy.prev;
    }
}
