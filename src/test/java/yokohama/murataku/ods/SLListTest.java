package yokohama.murataku.ods;

class SLListTest implements AbstractListTest {

    @Override
    public <T> List<T> newSut() {
        return new SLList<>();
    }
}