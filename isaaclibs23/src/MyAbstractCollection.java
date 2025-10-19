/**
 * Provides a skeletal implementation of the MyCollection interface.
 *
 * @param <K> the type of elements in this collection.
 */
public abstract class MyAbstractCollection<K> implements MyCollection<K>{
    // Protected fields for common collection state
    protected int size;
    protected int modCount; // Used to detect concurrent modifications, though not fully implemented here.

    /** Constructs a new abstract collection. */
    public MyAbstractCollection(){
        this.size = 0;
        this.modCount = 0;
    }

    /**
     * Returns the number of elements in this collection.
     */
    @Override
    public int size(){
        return this.size;
    }

    /** Returns true if this collection contains no elements. */
    @Override
    public boolean isEmpty(){
        return this.size == 0;
    }

    /**
     * Returns an array containing all of the elements in this collection.
     * This method must be implemented by concrete subclasses.
     */
    @Override
    public abstract Object[] toArray();

    // The following abstract methods must be implemented by concrete subclasses.
    @Override
    public abstract String toString();
    @Override
    public abstract boolean contains(K element);
    @Override
    public abstract boolean add(K element);
    @Override
    public abstract boolean remove(K element);
    @Override
    public abstract boolean containsAll(MyCollection<?> c);
    @Override
    public abstract boolean addAll(MyCollection<? extends K> collection);
    @Override
    public abstract boolean removeAll(MyCollection<?> collects);
    @Override
    public abstract boolean retainAll(MyCollection<?> collects);
    @Override
    public abstract void clear();

    /**
     * Retrieves the element at the specified position.
     * NOTE: This is defined here because it is in the MyCollection interface.
     */
    @Override
    public abstract K get(int i);
}
