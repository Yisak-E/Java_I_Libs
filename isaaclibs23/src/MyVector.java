import java.util.Random;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;
// Marker interfaces
interface MyRandomAccess {}
interface MyCloneable {}

public class MyVector<K> extends MyAbstractList<K>
        implements MyRandomAccess, MyCloneable {

    private static final int DEFAULT_CAPACITY = 10;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    private Object[] elementData;
    private int size;
    private int capacityIncrement;

    // Synchronization object
    private final Object lock = new Object();

    public MyVector() {
        this(DEFAULT_CAPACITY);
    }

    public MyVector(int initialCapacity) {
        this(initialCapacity, 0);
    }

    public MyVector(int initialCapacity, int capacityIncrement) {
        super();
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        this.elementData = new Object[initialCapacity];
        this.capacityIncrement = capacityIncrement;
        this.size = 0;
    }

    public MyVector(MyCollection<? extends K> c) {
        synchronized (lock) {
            elementData = c.toArray();
            size = elementData.length;
            if (elementData.getClass() != Object[].class) {
                elementData = java.util.Arrays.copyOf(elementData, size, Object[].class);
            }
        }
    }

    // Thread-safe methods
    @Override
    public synchronized boolean add(K element) {
        ensureCapacity(size + 1);
        elementData[size++] = element;
        modCount++;
        return true;
    }

    @Override
    public synchronized void add(int index, K element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        ensureCapacity(size + 1);
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        size++;
        modCount++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public synchronized K get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (K) elementData[index];
    }

    @Override
    @SuppressWarnings("unchecked")
    public synchronized K set(int index, K element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        K oldValue = (K) elementData[index];
        elementData[index] = element;
        return oldValue;
    }

    @Override
    @SuppressWarnings("unchecked")
    public synchronized void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        K oldValue = (K) elementData[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = null;
        modCount++;
        System.out.println("Removed element: " + oldValue);
    }

    @Override
    public synchronized boolean remove(Object element) {
        int index = indexOf(element);
        if (index >= 0) {
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public synchronized int indexOf(Object element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elementData[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public synchronized int lastIndexOf(Object element) {
        if (element == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (element.equals(elementData[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public synchronized boolean contains(Object element) {
        return indexOf(element) >= 0;
    }

    @Override
    public synchronized int size() {
        return size;
    }

    @Override
    public synchronized boolean isEmpty() {
        return size == 0;
    }

    @Override
    public synchronized void clear() {
        modCount++;
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    @Override
    public synchronized Object[] toArray() {
        return java.util.Arrays.copyOf(elementData, size);
    }

    @Override
    public void addFirst(K element) throws IllegalStateException {

    }

    @SuppressWarnings("unchecked")
    public synchronized <T> T[] toArray(T[] a) {
        if (a.length < size) {
            return (T[]) java.util.Arrays.copyOf(elementData, size, a.getClass());
        }
        System.arraycopy(elementData, 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    // Vector-specific methods
    public synchronized int capacity() {
        return elementData.length;
    }

    public synchronized void ensureCapacity(int minCapacity) {
        if (minCapacity > elementData.length) {
            int newCapacity = calculateNewCapacity(minCapacity);
            grow(newCapacity);
        }
    }

    private int calculateNewCapacity(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + ((capacityIncrement > 0) ? capacityIncrement : oldCapacity);
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            newCapacity = hugeCapacity(minCapacity);
        }
        return newCapacity;
    }

    private void grow(int newCapacity) {
        elementData = java.util.Arrays.copyOf(elementData, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) {
            throw new OutOfMemoryError();
        }
        return (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
    }

    public synchronized void trimToSize() {
        modCount++;
        int oldCapacity = elementData.length;
        if (size < oldCapacity) {
            elementData = java.util.Arrays.copyOf(elementData, size);
        }
    }

    // Cloneable implementation
    @SuppressWarnings("unchecked")
    public synchronized MyVector<K> clone() {
        try {
            MyVector<K> cloned = (MyVector<K>) super.clone();
            cloned.elementData = java.util.Arrays.copyOf(elementData, size);
            cloned.modCount = 0;
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }

    // Additional Vector-specific methods
    public synchronized void setSize(int newSize) {
        if (newSize < 0) {
            throw new ArrayIndexOutOfBoundsException(newSize);
        }
        modCount++;
        if (newSize > elementData.length) {
            ensureCapacity(newSize);
        }
        if (newSize > size) {
            for (int i = size; i < newSize; i++) {
                elementData[i] = null;
            }
        } else {
            for (int i = newSize; i < size; i++) {
                elementData[i] = null;
            }
        }
        size = newSize;
    }

    @SuppressWarnings("unchecked")
    public synchronized K elementAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (K) elementData[index];
    }

    public synchronized void setElementAt(K element, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        elementData[index] = element;
        modCount++;
    }

    public synchronized void removeElementAt(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = null;
        modCount++;
    }

    public synchronized void insertElementAt(K element, int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        ensureCapacity(size + 1);
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        size++;
        modCount++;
    }

    public synchronized void addElement(K element) {
        ensureCapacity(size + 1);
        elementData[size++] = element;
        modCount++;
    }

    public synchronized boolean removeElement(Object element) {
        int index = indexOf(element);
        if (index >= 0) {
            removeElementAt(index);
            return true;
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public synchronized K firstElement() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return (K) elementData[0];
    }

    @SuppressWarnings("unchecked")
    public synchronized K lastElement() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return (K) elementData[size - 1];
    }

    // ListIterator methods (simplified)
    @Override
    public synchronized MyListIterator<K> listIterator() {
        return new MyVectorIterator();
    }

    @Override
    public synchronized MyListIterator<K> listIterator(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        return new MyVectorIterator(index);
    }

    @Override
    public synchronized MyList<K> subList(int fromIndex, int toIndex) {
        // Simplified implementation
        throw new UnsupportedOperationException("subList not implemented");
    }

    // Iterator implementation
    private class MyVectorIterator implements MyListIterator<K> {
        private int cursor;
        private int lastRet = -1;
        private int expectedModCount = modCount;

        MyVectorIterator() {
            this.cursor = 0;
        }

        MyVectorIterator(int index) {
            this.cursor = index;
        }

        public synchronized boolean hasNext() {
            return cursor != size;
        }

        @SuppressWarnings("unchecked")
        public synchronized K next() {
            checkForComodification();
            if (cursor >= size) {
                throw new NoSuchElementException();
            }
            lastRet = cursor;
            return (K) elementData[cursor++];
        }

        public synchronized boolean hasPrevious() {
            return cursor != 0;
        }

        @SuppressWarnings("unchecked")
        public synchronized K previous() {
            checkForComodification();
            if (cursor <= 0) {
                throw new NoSuchElementException();
            }
            lastRet = --cursor;
            return (K) elementData[cursor];
        }

        public synchronized int nextIndex() {
            return cursor;
        }

        public synchronized int previousIndex() {
            return cursor - 1;
        }

        public synchronized void remove() {
            if (lastRet == -1) {
                throw new IllegalStateException();
            }
            checkForComodification();
            MyVector.this.remove(lastRet);
            cursor = lastRet;
            lastRet = -1;
            expectedModCount = modCount;
        }

        public synchronized void set(K e) {
            if (lastRet == -1) {
                throw new IllegalStateException();
            }
            checkForComodification();
            MyVector.this.set(lastRet, e);
        }

        public synchronized void add(K e) {
            checkForComodification();
            MyVector.this.add(cursor++, e);
            lastRet = -1;
            expectedModCount = modCount;
        }

        final void checkForComodification() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }

    @Override
    public synchronized String toString() {
        if (size == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < size; i++) {
            sb.append(elementData[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }
}