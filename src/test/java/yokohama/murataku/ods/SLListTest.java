package yokohama.murataku.ods;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SLListTest implements AbstractListTest, StackTest {

    @Override
    public <T> SLList<T> newSut() {
        return new SLList<>();
    }

    @Override
    public Stack<String> sut() {
        return newSut();
    }

    @Test
    void testReverse(){
        SLList<String> sut = newSut();
        sut.add(0,"Love");
        sut.add(1,"Lone");
        sut.add(2,"Star");

        sut.reverse();

        assertThat(sut.size()).isEqualTo(3);
        assertThat(sut.get(0)).isEqualTo("Star");
        assertThat(sut.get(1)).isEqualTo("Lone");
        assertThat(sut.get(2)).isEqualTo("Love");
    }
}
