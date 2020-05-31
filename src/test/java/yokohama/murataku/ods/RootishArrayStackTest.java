package yokohama.murataku.ods;

class RootishArrayStackTest implements AbstractListTest {

    @Override
    public <T> List<T> newSut() {
        return new RootishArrayStack<>();
    }

    @Override
    public <T> Queue<T> newSut(int capacity) {
        return newSut();
    }
}