package yokohama.murataku.ods;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("SpellCheckingInspection")
interface AbstractQueueTest {
    <T> Queue<T> newSut();

    /**
     * Ensure given capacity IF POSSIBLE
     */
    default <T> Queue<T> newSut(int capacity) {
        return newSut();
    }

    @Test
    default void testQueueSimple() {
        Queue<String> queue = newSut();
        queue.enqueue("Takuro");
        queue.enqueue("Haru");
        queue.enqueue("Takanori");
        queue.enqueue("Rose");
        queue.enqueue("Komada");
        queue.enqueue("Saeki");
        queue.enqueue("Shindo");
        queue.enqueue("Tanishige");
        queue.enqueue("Nomura");
        queue.enqueue("Takashi");
        queue.enqueue("Miura");
        queue.enqueue("Kawamura");
        queue.enqueue("Awano");
        queue.enqueue("Sasaki");
       
        assertThat(queue.dequeue()).isEqualTo("Takuro");
        assertThat(queue.dequeue()).isEqualTo("Haru");
        assertThat(queue.dequeue()).isEqualTo("Takanori");
        assertThat(queue.dequeue()).isEqualTo("Rose");
        assertThat(queue.dequeue()).isEqualTo("Komada");
        assertThat(queue.dequeue()).isEqualTo("Saeki");
        assertThat(queue.dequeue()).isEqualTo("Shindo");
        assertThat(queue.dequeue()).isEqualTo("Tanishige");
        assertThat(queue.dequeue()).isEqualTo("Nomura");
        assertThat(queue.dequeue()).isEqualTo("Takashi");
        assertThat(queue.dequeue()).isEqualTo("Miura");
        assertThat(queue.dequeue()).isEqualTo("Kawamura");
        assertThat(queue.dequeue()).isEqualTo("Awano");
        assertThat(queue.dequeue()).isEqualTo("Sasaki");
    }

    @Test
    default void testQuqueRepeated() {
        var sut = newSut(3);

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