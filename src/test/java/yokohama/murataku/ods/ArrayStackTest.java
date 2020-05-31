package yokohama.murataku.ods;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ArrayStackTest {
    @Test
    void testAdd() {
        List<Character> stack = new ArrayStack<>();
        stack.add(0, 'a');

        assertThat(stack.size()).isEqualTo(1);
        assertThat(stack.get(0)).isEqualTo('a');
        assertThat(stack.get(1)).isNull();
    }

    @Test
    void resizeOnAdd() {
        List<Character> stack = new ArrayStack<>();
        stack.add(0, 'a');
        stack.add(0, 'b');
        stack.add(0, 'c');
        stack.add(0, 'd');
        stack.add(0, 'e');
        stack.add(0, 'f');
        stack.add(0, 'g');
        stack.add(0, 'h');
        stack.add(0, 'i');
        stack.add(0, 'j');
        stack.add(0, 'k'); // occurs array index out of bounds

        assertThat(stack.size()).isEqualTo(11);
    }
}