package yokohama.murataku.ods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"ManualArrayCopy", "unchecked"})
public class ArrayStack<T> extends AbstractArrayStack<T> {
    public static final Logger logger = LoggerFactory.getLogger(ArrayStack.class);

    public ArrayStack() {
        super();
    }

    public ArrayStack(int capacity) {
        super(capacity);
    }

    @Override
    protected void resizeIfNecessary() {
        int capacity = array.length;
        logger.debug("start resize: capacity:{} size: {}", capacity, this.size);

        if (size == 0) {
            logger.debug("size 0");
            return;
        }

        T[] newArray = null;
        if (size > capacity * 2 / 3) { // expand
            logger.debug("expand");
            newArray = (T[]) new Object[capacity * 2];
        } else if (size < capacity / 3) {
            logger.debug("shrink");
            newArray = (T[]) new Object[capacity / 2];
        }
        if (newArray != null) {
            for (int i = 0; i < size; i++) {
                newArray[i] = this.array[i];
            }
            this.array = newArray;
        } else {
            logger.debug("Hold");
        }

    }
}
