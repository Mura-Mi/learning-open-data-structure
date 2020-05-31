package yokohama.murataku.ods;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public interface DequeTest {
    <T> List<T> newSut();

    @Test
    default void testDequeScenarioP36() {
        var sut = newSut();

        sut.enqueueTail('a');
        sut.enqueueTail('b');
        sut.enqueueTail('c');
        sut.enqueueTail('d');
        sut.enqueueTail('e');
        sut.enqueueTail('f');
        sut.enqueueTail('g');
        sut.enqueueTail('h');
        assertThat(sut.size()).isEqualTo(8);

        assertThat(sut.remove(2)).isEqualTo('c');
        assertThat(sut.size()).isEqualTo(7);

        sut.add(4, 'x');
        sut.add(3, 'y');
        sut.add(4, 'z');

        assertThat(sut.get(0)).isEqualTo('a');
        assertThat(sut.get(1)).isEqualTo('b');
        assertThat(sut.get(2)).isEqualTo('d');
        assertThat(sut.get(3)).isEqualTo('y');
        assertThat(sut.get(4)).isEqualTo('z');
        assertThat(sut.get(5)).isEqualTo('e');
        assertThat(sut.get(6)).isEqualTo('x');
        assertThat(sut.get(7)).isEqualTo('f');
        assertThat(sut.get(8)).isEqualTo('g');
        assertThat(sut.get(9)).isEqualTo('h');
    }
}
