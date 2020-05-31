package yokohama.murataku.ods;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public interface HasReverseTest {

    <T> HasReverse<T> newSut();

    @Test
    default void testReverse() {
        var sut = newSut();
        sut.add(0, "Love");
        sut.add(1, "Lone");
        sut.add(2, "Star");

        sut.reverse();

        assertThat(sut.size()).isEqualTo(3);
        assertThat(sut.get(0)).isEqualTo("Star");
        assertThat(sut.get(1)).isEqualTo("Lone");
        assertThat(sut.get(2)).isEqualTo("Love");
    }
}
