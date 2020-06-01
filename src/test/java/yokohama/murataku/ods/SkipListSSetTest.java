package yokohama.murataku.ods;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SkipListSSetTest {
    SkipListSSet<Integer> sut() {
        return new SkipListSSet<>();
    }

    @Test
    void testSSet() {
        var sut = sut();
        assertThat(sut.size()).isEqualTo(0);

        sut.add(0);
        sut.add(3);
        sut.add(1);
        sut.add(2);
        sut.add(5);
        sut.add(5);
        assertThat(sut.size()).isEqualTo(5);


    }


}