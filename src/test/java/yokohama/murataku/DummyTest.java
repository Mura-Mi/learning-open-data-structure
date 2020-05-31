package yokohama.murataku;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DummyTest {
    @Test
    void testAdd() {
        assertThat(new Dummy().add(1,2)).isEqualTo(3);
    }
}