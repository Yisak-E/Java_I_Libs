public abstract class IAbstractIList<K> implements IList<K> {
    protected int size;

    public IAbstractIList() {
        this.size = 0;
    }

    public IAbstractIList(K[] objects) {
        for (K object : objects) {
            this.add(object);
        }

    }

    @Override
    public int size() {
        return this.size;
    }
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
    @Override
    public boolean contains(K key) {
        return indexOf(key) != -1;
    }

    protected void checkIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
        }
    }

    protected void checkPosition(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
        }
    }

}
