package yokohama.murataku.ods;

@SuppressWarnings("unchecked")
public class RootishArrayStack<T> implements List<T> {
    private FastArrayStack<T[]> blocks;
    private int size;

    public RootishArrayStack() {
        this.blocks = new FastArrayStack<>(5);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public T get(int i) {
        int blockIndex = blockIndexFor(i);
        int j = i - countFilled(blockIndex);

        return blocks.get(blockIndex)[j];
    }

    @Override
    public T set(int i, T t) {
        if (this.blocks.size == 0) {
            this.add(0, t);
            return null;
        }
        int blockIndex = blockIndexFor(i);
        int j = i - countFilled(blockIndex);

        var latestBlock = blocks.get(blockIndex);
        var retVal = latestBlock[j];
        latestBlock[j] = t;
        return retVal;
    }

    @Override
    public void add(int i, T t) {
        if (this.capacity() < this.size() + 1) {
            this.blocks.add(this.blocks.size(), (T[]) new Object[this.blocks.size() + 1]);
        }
        for (int j = this.size(); j > i; j--) {
            this.set(j, this.get(j - 1));
        }
        this.set(i, t);

        this.size++;
    }

    @Override
    public T remove(int i) {
        var ret = get(i);
        for (int j = i; j < this.size() - 1; j++) {
            this.set(j, get(j + 1));
        }
        if (size > 0) this.set(size - 1, null);
        this.size--;

        return ret;
    }

    @Override
    public int capacity() {
        return countFilled(blocks.size);
    }

    private int countFilled(int currentBlock) {
        return (currentBlock * (currentBlock + 1)) / 2;
    }

    private int blockIndexFor(int i) {
        double d = (-3.0 + Math.sqrt(9 + 8 * i)) / 2;
        return (int) Math.ceil(d);
    }
}
