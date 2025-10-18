import java.util.NoSuchElementException;

/**
 * Resizable-array implementation of the MyList interface.
 * Implements all optional list operations.
 *
 * NOTE: Refactored to extend MyAbstractList for a cleaner framework design.
 *
 * @param <K> the type of elements in this list.
 */
public class MyArrayList<K> extends MyAbstractList<K> implements MyList<K> {
    public static final int DEFAULT_CAPACITY = 10;
    private Object[] elementData;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    /** Constructs an empty list with an initial capacity of ten. */
    public MyArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    /** Constructs an empty list with the specified initial capacity. */
    public MyArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity must be a positive integer: " + capacity);
        }
        elementData = new Object[capacity];
    }

    /** Constructs a list containing the elements of the specified collection. */
    public MyArrayList(MyCollection<? extends K> collections) {
        if (collections == null) {
            throw new IllegalArgumentException("Collection cannot be null");
        }
        int collection_size = collections.size();
        elementData = new Object[collection_size];
        for (int i = 0; i < collection_size; i++) {
            elementData[i] = collections.get(i);
        }
        this.size = collection_size; // Use 'this.size' for clarity
    }

    /** Increases the capacity of this ArrayList instance, if necessary. */
    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elementData.length) {
            grow(minCapacity);
        }
    }

    /** Increases the capacity to ensure that it can hold at least the number of elements specified by the minimum capacity argument. */
    private void grow(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1); // Grow by 50%

        if (newCapacity < minCapacity) {
            newCapacity = minCapacity;
        }
        if (newCapacity > MAX_ARRAY_SIZE) {
            newCapacity = MAX_ARRAY_SIZE;
            if (newCapacity < minCapacity) {
                throw new OutOfMemoryError("Required capacity exceeds maximum array size.");
            }
        }

        Object[] newArray = new Object[newCapacity];
        System.arraycopy(elementData, 0, newArray, 0, size);
        elementData = newArray;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any subsequent
     * elements to the right (adds one to their indices).
     */
    @Override
    public void add(int index, K element) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        ensureCapacity(size + 1);
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        size++;
        modCount++;
    }

    // NOTE: The add(K element) method is correctly inherited from MyAbstractList and
    // delegates to add(size, element), so no override is needed here.

    @Override
    @SuppressWarnings("unchecked")
    public K get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (K) elementData[index];
    }

    @Override
    @SuppressWarnings("unchecked")
    public K set(int index, K element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        K oldValue = (K) elementData[index];
        elementData[index] = element;
        modCount++;
        return oldValue;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = null; // Clear to let GC do its work
        modCount++;
    }

    @Override
    public int indexOf(K element) {
        for (int i = 0; i < size; i++) {
            if (element == null ? elementData[i] == null : element.equals(elementData[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(K element) {
        for (int i = size - 1; i >= 0; i--) {
            if (element == null ? elementData[i] == null : element.equals(elementData[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
        modCount++;
        // NOTE: MyAbstractList's clear() is overridden to be more efficient here.
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        System.arraycopy(elementData, 0, result, 0, size);
        return result;
    }

    @Override
    public void addFirst(K element) throws IllegalStateException {

    }

    /** Trims the capacity to the current size. */
    public void trimToSize() {
        if (size < elementData.length) {
            Object[] newList = new Object[size];
            System.arraycopy(elementData, 0, newList, 0, size);
            elementData = newList;
            modCount++;
        }
    }

    /**
     * Sorts the list using the natural ordering of its elements (Bubble Sort).
     * Requires elements to implement MyComparable.
     */
    @SuppressWarnings("unchecked")
    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                // We cast to MyComparable to ensure the compareTo method exists
                MyComparable<K> current = (MyComparable<K>) elementData[j];
                K next = (K) elementData[j + 1];

                if (current.compareTo(next) > 0) {
                    Object temp = elementData[j];
                    elementData[j] = elementData[j + 1];
                    elementData[j + 1] = temp;
                    modCount++;
                }
            }
        }
    }

    /**
     * Sorts the list using the specified comparator (Bubble Sort).
     */
    public void sort(MyComparator<K> comparator) {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                @SuppressWarnings("unchecked")
                K current = (K) elementData[j];
                @SuppressWarnings("unchecked")
                K next = (K) elementData[j + 1];

                if (comparator.compare(current, next) > 0) {
                    Object temp = elementData[j];
                    elementData[j] = elementData[j + 1];
                    elementData[j + 1] = temp;
                    modCount++;
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elementData[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // LIST ITERATOR AND SUB-LIST NOT FULLY IMPLEMENTED/REQUIRED BY PROMPT
    @Override
    public MyListIterator<K> listIterator() {
        throw new UnsupportedOperationException("ListIterator not yet implemented.");
    }

    @Override
    public MyListIterator<K> listIterator(int index) {
        throw new UnsupportedOperationException("ListIterator not yet implemented.");
    }

    @Override
    public MyList<K> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("subList not yet implemented.");
    }
}
