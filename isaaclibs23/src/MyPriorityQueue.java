import java.util.NoSuchElementException;

/**
 * An unbounded priority queue based on a min-heap, which uses the MyList (MyArrayList)
 * to store the elements. It orders elements according to their natural ordering (MyComparable),
 * or by a specified MyComparator.
 *
 * @param <K> the type of elements in this priority queue.
 */
public class MyPriorityQueue<K> extends MyAbstractQueue<K> implements MyQueue<K> {

    // Internal list to store heap elements
    private final MyArrayList<K> dataElements;
    // Comparator for custom ordering, null for natural ordering
    private final MyComparator<? super K> comparator;

    /**
     * Constructs a MyPriorityQueue with the default initial capacity and natural ordering.
     * Elements must implement MyComparable.
     */
    public MyPriorityQueue() {
        this(MyArrayList.DEFAULT_CAPACITY, null);
    }

    /**
     * Constructs a MyPriorityQueue with the specified initial capacity and natural ordering.
     */
    public MyPriorityQueue(int initialCapacity) {
        this(initialCapacity, null);
    }

    /**
     * Constructs a MyPriorityQueue containing the elements in the specified collection.
     */
    public MyPriorityQueue(MyCollection<? extends K> collection) {
        this(collection.size(), null);
        for (int i = 0; i < collection.size(); i++) {
            offer(collection.get(i));
        }
    }

    /**
     * Constructs a MyPriorityQueue with the specified initial capacity and comparator.
     */
    public MyPriorityQueue(int initialCapacity, MyComparator<? super K> comparator) {
        this.dataElements = new MyArrayList<>(initialCapacity);
        this.comparator = comparator;
        this.size = 0;
    }

    /**
     * Helper to compare two elements using the comparator or natural ordering.
     */
    @SuppressWarnings("unchecked")
    private int compare(K a, K b) {
        if (comparator != null) {
            return comparator.compare(a, b);
        } else {
            // Natural ordering
            if (!(a instanceof MyComparable)) {
                throw new ClassCastException("Elements must implement MyComparable if no comparator is provided.");
            }
            return ((MyComparable<K>) a).compareTo(b);
        }
    }

    /** Swaps the elements at the given indices. */
    private void swap(int i, int j) {
        K temp = dataElements.get(i);
        dataElements.set(i, dataElements.get(j));
        dataElements.set(j, temp);
    }

    /**
     * Moves the element at index k up the heap to restore the heap property.
     */
    private void siftUp(int k) {
        while (k > 0) {
            int parent = (k - 1) / 2;
            if (compare(dataElements.get(k), dataElements.get(parent)) < 0) {
                swap(k, parent);
                k = parent;
            } else {
                break;
            }
        }
    }

    /**
     * Moves the element at index k down the heap to restore the heap property.
     */
    private void siftDown(int k) {
        int half = size / 2; // Last non-leaf element
        while (k < half) {
            int left = 2 * k + 1;
            int right = 2 * k + 2;
            int smallest = left; // Assume left child is smallest

            // Check if right child exists and is smaller than left child
            if (right < size && compare(dataElements.get(right), dataElements.get(left)) < 0) {
                smallest = right;
            }

            // If current element is smaller than the smallest child, stop
            if (compare(dataElements.get(k), dataElements.get(smallest)) <= 0) {
                break;
            }

            // Swap with the smallest child
            swap(k, smallest);
            k = smallest; // Continue sifting down from the child's position
        }
    }

    // --- MyQueue Implementation ---

    /** Inserts the specified element into this priority queue. */
    @Override
    public boolean offer(K element) {
        if (element == null) {
            throw new NullPointerException("Priority queue cannot contain null elements.");
        }
        dataElements.add(element); // Add to the end of the list
        size++;
        siftUp(size - 1);         // Restore heap property
        modCount++;
        return true;
    }

    /** Retrieves and removes the head (smallest element) of this queue, or returns null if empty. */
    @Override
    public K poll() {
        if (isEmpty()) {
            return null;
        }

        K result = dataElements.get(0);
        int lastIndex = size - 1;

        // Move the last element to the root
        if (lastIndex > 0) {
            swap(0, lastIndex);
        }

        // Remove the old root (now at the end) and decrease size
        dataElements.remove(lastIndex);
        size--;
        modCount++;

        // Restore heap property by sifting down the new root
        if (size > 1) {
            siftDown(0);
        }

        return result;
    }

    /** Retrieves, but does not remove, the head (smallest element) of this queue, or returns null if empty. */
    @Override
    public K peek() {
        if (isEmpty()) {
            return null;
        }
        return dataElements.get(0);
    }

    // --- MyAbstractCollection Overrides ---

    @Override
    public String toString() {
        return dataElements.toString();
    }

    @Override
    public K get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size);
        }
        // NOTE: Returning elements by index is NOT standard for a PriorityQueue,
        // but required by MyCollection/MyAbstractCollection interface.
        return dataElements.get(i);
    }

    @Override
    public Object[] toArray() {
        return dataElements.toArray();
    }

    // Other non-standard operations for a PriorityQueue, but required by abstract classes
    @Override
    public boolean contains(K element) {
        return dataElements.indexOf(element) != -1;
    }

    @Override
    public boolean remove(K element) {
        throw new UnsupportedOperationException("Remove by element is not supported in this PriorityQueue implementation.");
    }

    @Override
    public boolean containsAll(MyCollection<?> c) {
        throw new UnsupportedOperationException("containsAll not yet implemented.");
    }

    @Override
    public boolean removeAll(MyCollection<?> collects) {
        throw new UnsupportedOperationException("removeAll not yet implemented.");
    }

    @Override
    public boolean retainAll(MyCollection<?> collects) {
        throw new UnsupportedOperationException("retainAll not yet implemented.");
    }
}
