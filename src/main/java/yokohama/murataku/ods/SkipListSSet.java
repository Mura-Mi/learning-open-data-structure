package yokohama.murataku.ods;


@SuppressWarnings("unchecked")
public class SkipListSSet<T extends Comparable<T>> implements SSet<T> {
    private static class Node<T> {
        T ref;
        int height;
        Node<T>[] next;

        public Node() {
            this.height = 0;
            this.next = new Node[10];
        }

        public Node(T t, int height) {
            this.ref = t;
            this.height = height;
            this.next = new Node[10];
        }
    }

    private Node<T> sentinel;
    private int height;
    private int size;
    private Node<T>[] stack;

    public SkipListSSet() {
        this.height = 0;
        this.sentinel = new Node<>();
        this.stack = new Node[10];
    }

    @Override
    public int size() {
        return size;
    }


    @Override
    public T find(T t) {
        Node<T> node = sentinel;
        int r = height;
        int comp = 0;

        while (r >= 0) {
            while (node.next[r] != null && node.next[r].ref.compareTo(t) < 0) // shift right
                node = node.next[r];
            r--;
        }
        return node.next[0] == null ? null : node.next[0].ref;
    }

    @Override
    public boolean add(T t) {
        Node<T> node = sentinel;
        int r = height;
        int comp = 0;
        while (r >= 0) {
            while (node.next[r] != null && (comp = node.next[r].ref.compareTo(t)) < 0)
                node = node.next[r]; // shift right if node <t is found
            if (node.next[r] != null && comp == 0) return false; // same element is already exists
            stack[r--] = node; // mark the node at right end on level r
        }

        Node<T> newNode = new Node<>(t, SkipListUtils.pickHeight());
        while (height < newNode.height) { // if new node is the highest node
            stack[++height] = sentinel; // sentinel is at the left edge on brand new level height
        }

        for (int i = 0; i <= newNode.height; i++) {
            newNode.next[i] = stack[i].next[i];
            stack[i].next[i] = newNode;
        }
        this.size++;
        return true;
    }

    @Override
    public T remove(T t) {
        this.size--;
        return null;
    }
}
