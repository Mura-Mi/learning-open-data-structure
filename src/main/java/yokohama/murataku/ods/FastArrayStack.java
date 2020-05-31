package yokohama.murataku.ods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("unchecked")
public class FastArrayStack<T> extends AbstractArrayStack<T> {
    public static final Logger logger = LoggerFactory.getLogger(FastArrayStack.class);

    public FastArrayStack() {
    }

    public FastArrayStack(int initCap) {
        super(initCap);
    }

    @Override
    public void add(int i, T t) {
        if (size - i >= 0) System.arraycopy(array, i, array, i + 1, size - i);
        array[i] = t;
        this.size = size + 1;
        resizeIfNecessary();
    }

    @Override
    public T remove(int i) {
        if (size() == 0) return null;
        T prev = array[i];
        if (size - i >= 0) System.arraycopy(array, i + 1, array, i, size - i);
        array[size - 1] = null;
        size = size - 1;
        return prev;
    }

    @Override
    protected void resizeIfNecessary() {
        int capacity = array.length;
        logger.debug("start resize: capacity:{} size:{}", capacity, this.size);

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
            if (size >= 0) System.arraycopy(this.array, 0, newArray, 0, size);
            this.array = newArray;
        } else {
            logger.debug("Hold");
        }

    }

}
