package yokohama.murataku.ods;

class Node<T> {
    T ref;
    Node<T> next;

    public Node(T ref, Node<T> next) {
        this.ref = ref;
        this.next = next;
    }

    public Node(T ref) {
        this(ref, null);
    }
}

public class SLList<T> implements List<T>, Stack<T>, HasReverse<T> {
    private Node<T> head;
    private Node<T> tail;

    public SLList() {
        this.head = null;
    }

    @Override
    public int size() {
        var size = 0;
        var node = head;
        while (node != null) {
            size++;
            node = node.next;
        }
        return size;
    }

    @Override
    public T get(int i) {
        return getNode(i).ref;
    }

    private Node<T> getNode(int i) {
        var node = head;
        for (int j = 0; j < i; j++) {
            node = node.next;
        }
        return node;
    }

    private Pair<Node<T>> getNodeAndPrev(int i) {
        var node = head;
        Node<T> prev = null;
        for (int j = 0; j < i; j++) {
            prev = node;
            node = node.next;
        }
        return Pair.of(prev, node);
    }

    @Override
    public T set(int i, T t) {
        return getNode(i).ref = t;
    }

    @Override
    public void add(int i, T t) {
        var pair = getNodeAndPrev(i);
        var existing = pair.two();
        var newNode = new Node<>(t, existing);
        if (pair.one() != null) {
            pair.one().next = newNode;
        } else {
            this.head = newNode;
        }
        if (pair.two() == null) this.tail = newNode;
    }

    @Override
    public T remove(int i) {
        var pair = getNodeAndPrev(i);
        var toBeRemoved = pair.two();
        if (pair.one() == null && toBeRemoved == null) return null;
        if (pair.one() != null) {
            pair.one().next = toBeRemoved.next;
        } else {
            this.head = pair.two().next;
        }
        if (toBeRemoved.next == null) this.tail = pair.one();
        return toBeRemoved.ref;
    }

    @Override
    public int capacity() {
        return this.size();
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
    public void enqueueTail(T t) {
        var newNode = new Node<>(t);
        if (this.tail != null) {
            this.tail.next = newNode;
            this.tail = newNode;
        } else {
            this.head = newNode;
            this.tail = newNode;
        }
    }

    @Override
    public void reverse() {
        Node<T> zero = null;
        var actHead = this.head;
        var actTail = this.tail;

        var one = actHead;
        Node<T> two;
        while (one != null) {
            two = one.next;
            one.next = zero;
            //'
            zero = one;
            one = two;
        }

        this.head = actTail;
        this.tail = actHead;
    }
}
