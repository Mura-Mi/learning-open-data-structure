package yokohama.murataku.ods;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public interface StackTest {
    Stack<String> sut();

    @Test
    default void testStack() {
        var sut = sut();
        assertThat(sut.pop()).isNull();

        sut.push("google");
        sut.push("amazon");
        assertThat(sut.pop()).isEqualTo("amazon");
        sut.push("facebook");
        sut.push("apple");
        assertThat(sut.pop()).isEqualTo("apple");
        assertThat(sut.pop()).isEqualTo("facebook");
        assertThat(sut.pop()).isEqualTo("google");
        assertThat(sut.pop()).isNull();

    }
}
