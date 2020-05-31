package yokohama.murataku.ods;

public class Pair<T> {
    private T one;
    private T two;

    public Pair(T one, T two) {
        this.one = one;
        this.two = two;
    }

    public static <T> Pair<Node<T>> of(Node<T> one, Node<T> two) {
        return new Pair<>(one,two);
    }

    public T one() {
        return one;
    }

    public T two() {
        return two;
    }
}
