import java.util.NoSuchElementException;

/**
 * Provides a skeletal implementation of the MyQueue interface.
 *
 * @param <K> the type of elements in this queue.
 */
public abstract class MyAbstractQueue<K> extends MyAbstractCollection<K> implements MyQueue<K> {

    /** Constructs a new abstract queue. */
    public MyAbstractQueue() {
        super();
    }

    /**
     * Inserts the specified element into this queue.
     * Delegates to offer(). Throws IllegalStateException if full.
     */
    @Override
    public boolean add(K element) {
        if (offer(element)) {
            return true;
        } else {
            throw new IllegalStateException("Queue full");
        }
    }

    /**
     * Retrieves and removes the head of this queue.
     * Delegates to poll(). Throws NoSuchElementException if empty.
     */
    @Override
    public K remove() {
        K element = poll();
        if (element != null) {
            return element;
        } else {
            throw new NoSuchElementException("Queue empty");
        }
    }

    /**
     * Retrieves, but does not remove, the head of this queue.
     * Delegates to peek(). Throws NoSuchElementException if empty.
     */
    @Override
    public K element() {
        K element = peek();
        if (element != null) {
            return element;
        } else {
            throw new NoSuchElementException("Queue empty");
        }
    }

    /** Removes all of the elements from this queue. */
    @Override
    public void clear() {
        while (poll() != null) {
            // Keep polling until empty
        }
        this.size = 0; // Ensure size is reset if not handled by poll
    }

    /** Adds all of the elements in the specified collection to this queue. */
    @Override
    public boolean addAll(MyCollection<? extends K> collection) {
        if (collection == null) {
            throw new NullPointerException("Collection cannot be null");
        }
        boolean modified = false;
        // The implementation relies on the fact that MyCollection has get(int i)
        for (int i = 0; i < collection.size(); i++) {
            K element = collection.get(i);
            if (add(element)) {
                modified = true;
            }
        }
        return modified;
    }

    // Implement abstract methods from MyAbstractCollection that are not MyQueue methods
    @Override
    public abstract String toString();
    @Override
    public abstract boolean contains(K element);
    @Override
    public abstract K get(int i);
    @Override
    public abstract Object[] toArray();
    @Override
    public abstract boolean remove(K element);
    @Override
    public abstract boolean containsAll(MyCollection<?> c);
    @Override
    public abstract boolean removeAll(MyCollection<?> collects);
    @Override
    public abstract boolean retainAll(MyCollection<?> collects);

    // Abstract methods from MyQueue that must be implemented by subclasses
    @Override
    public abstract boolean offer(K element);
    @Override
    public abstract K poll();
    @Override
    public abstract K peek();
}
