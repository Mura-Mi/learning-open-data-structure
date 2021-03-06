package yokohama.murataku.ods;

class SLListTest implements AbstractListTest, StackTest, HasReverseTest {

    @Override
    public <T> SLList<T> newSut() {
        return new SLList<>();
    }

    @Override
    public Stack<String> sut() {
        return newSut();
    }
}
