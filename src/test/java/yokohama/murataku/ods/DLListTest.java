package yokohama.murataku.ods;

class DLListTest implements AbstractListTest, StackTest, HasReverseTest {

    @Override
    public <T> DLList<T> newSut() {
        return new DLList<>();
    }

    @Override
    public DLList<String> sut() {
        return newSut();
    }
}