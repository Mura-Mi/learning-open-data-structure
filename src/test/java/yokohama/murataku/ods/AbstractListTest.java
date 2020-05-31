package yokohama.murataku.ods;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

interface AbstractListTest extends AbstractQueueTest {
     <T> List<T> newSut();

    @Test
    default void testSetWhenEmpty() {
        List<Character> stack = newSut();

        assertThat(stack.size()).isEqualTo(0);

        Character ret = stack.set(0, 'c');
        assertThat(ret).isNull();
        assertThat(stack.size()).isEqualTo(1);

        assertThat(stack.set(0, 'b')).isEqualTo('c');
        assertThat(stack.size()).isEqualTo(1);

        stack.set(1, 'a');
        assertThat(stack.size()).isEqualTo(2);
    }

    @Test
    default void testAdd() {
        List<Character> stack = newSut();
        stack.add(0, 'c');
        stack.add(0, 'b');
        stack.add(0, 'a');

        assertThat(stack.size()).isEqualTo(3);
        assertThat(stack.get(0)).isEqualTo('a');
        assertThat(stack.get(1)).isEqualTo('b');
        assertThat(stack.get(2)).isEqualTo('c');
    }

    @Test
    default void resizeOnAdd() {
        List<Character> stack = newSut();
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

    @Test
    default void testRemove() {
        List<Character> stack = newSut();
        stack.add(0, 'c');
        stack.add(0, 'b');
        stack.add(0, 'a');

        assertThat(stack.remove(1)).isEqualTo('b');
        assertThat(stack.size()).isEqualTo(2);
        assertThat(stack.get(1)).isEqualTo('c');
        assertThat(stack.get(0)).isEqualTo('a');
    }
}