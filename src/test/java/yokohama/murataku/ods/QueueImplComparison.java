package yokohama.murataku.ods;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("Performance")
class QueueImplComparison {
    void scenario(Queue<Integer> sut) {
        for (int i = 0; i < 300_000; i++) {
            sut.enqueue(i);
        }
        for (int i = 0; i < 70_000; i++) {
            sut.dequeue();
        }
        for (int i = 0; i < 200_000; i++) {
            sut.enqueue(i);
        }
        for (int i = 0; i < 200_000; i++) {
            sut.dequeue();
        }
        for (int i = 0; i < 100_000; i++) {
            sut.enqueue(i);
        }
        for (int i = 0; i < 330_001; i++) {
            sut.dequeue();
        }
    }

    @Test
    void compare() {
        {
            var arrayStack = new FastArrayStack<Integer>(3);
            StopwatchUtil.measure("Stack: ", () ->
                    scenario(arrayStack)
            );
            System.out.printf("Stack capacity: %,d\n", arrayStack.capacity());
        }

        {
            var arrayQueue = new ArrayQueue<Integer>(3);
            StopwatchUtil.measure("Queue: ", () ->
                    scenario(arrayQueue)
            );
            System.out.printf("Queue capacity: %,d\n", arrayQueue.capacity());
        }

        {
            var linkedListQueue = new SLList<Integer>();
            StopwatchUtil.measure("LinkedList: ", () ->
                    scenario(linkedListQueue)
            );
            System.out.printf("LinkedList capacity: %,d\n", linkedListQueue.capacity());
        }
    }
}
