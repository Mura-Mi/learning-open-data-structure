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

public class SLList<T> implements List<T>, Stack<T> {
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
        var newNode = new Node<>(t, pair.two());
        if (pair.one() != null) {
            pair.one().next = newNode;
        } else {
            this.head = newNode;
        }
    }

    @Override
    public T remove(int i) {
        var pair = getNodeAndPrev(i);
        if (pair.one() == null && pair.two() == null) return null;
        if (pair.one() != null) {
            pair.one().next = pair.two().next;
        } else {
            this.head = pair.two().next;
        }
        return pair.two().ref;
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
}
