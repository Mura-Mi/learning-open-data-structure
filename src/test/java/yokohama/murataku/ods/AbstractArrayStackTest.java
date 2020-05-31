package yokohama.murataku.ods;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("SpellCheckingInspection")
abstract class AbstractArrayStackTest {
    protected abstract <T> AbstractArrayStack<T> newSut();

    @Test
    void testSetWhenEmpty() {
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
    void testAdd() {
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
    void resizeOnAdd() {
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
    void testRemove() {
        List<Character> stack = newSut();
        stack.add(0, 'c');
        stack.add(0, 'b');
        stack.add(0, 'a');

        assertThat(stack.remove(1)).isEqualTo('b');
        assertThat(stack.size()).isEqualTo(2);
        assertThat(stack.get(1)).isEqualTo('c');
        assertThat(stack.get(0)).isEqualTo('a');
    }

    @Test
    void testAsQueue() {
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
}