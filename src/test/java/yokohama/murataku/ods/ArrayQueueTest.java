package yokohama.murataku.ods;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ArrayQueueTest {
    @Test
    void testQuque() {
        var sut = new ArrayQueue<String>(3);

        sut.enqueue("Takuro");
        sut.enqueue("Haru");
        sut.enqueue("Takanori");
        sut.enqueue("Rose");
        sut.enqueue("Komada");
        sut.enqueue("Saeki");
        sut.enqueue("Shindo");
        sut.enqueue("Tanishige");

        assertThat(sut.dequeue()).isEqualTo("Takuro");
        assertThat(sut.dequeue()).isEqualTo("Haru");
        assertThat(sut.dequeue()).isEqualTo("Takanori");

        sut.enqueue("Nomura");
        sut.enqueue("Takashi");
        sut.enqueue("Miura");
        sut.enqueue("Kawamura");
        sut.enqueue("Awano");
        sut.enqueue("Shimada");
        sut.enqueue("Igarashi");

        assertThat(sut.dequeue()).isEqualTo("Rose");
        assertThat(sut.dequeue()).isEqualTo("Komada");
        assertThat(sut.dequeue()).isEqualTo("Saeki");
        assertThat(sut.dequeue()).isEqualTo("Shindo");

        sut.enqueue("Sasaki");

        assertThat(sut.dequeue()).isEqualTo("Tanishige");
        assertThat(sut.dequeue()).isEqualTo("Nomura");
        assertThat(sut.dequeue()).isEqualTo("Takashi");
        assertThat(sut.dequeue()).isEqualTo("Miura");
        assertThat(sut.dequeue()).isEqualTo("Kawamura");
        assertThat(sut.dequeue()).isEqualTo("Awano");
        assertThat(sut.dequeue()).isEqualTo("Shimada");
        assertThat(sut.dequeue()).isEqualTo("Igarashi");
        assertThat(sut.dequeue()).isEqualTo("Sasaki");
        assertThat(sut.dequeue()).isNull();
    }

}