public class MyArrayList<K extends Comparable<K>> {
    public final int DEFAULT_CAPACITY = 10;
    private Object[] elementData; // Use Object[] internally
    private int size = 0;
    public final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    public MyArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity must be a positive integer.");
        }
        elementData = new Object[capacity];
    }

    public MyArrayList(MyCollection<? extends K> collections) {
        if (collections == null) {
            throw new IllegalArgumentException("Collection cannot be null");
        }
        int collection_size = collections.size();
        elementData = new Object[collection_size];
        for (int i = 0; i < collection_size; i++) {
            elementData[i] = collections.get(i);
        }
        size = collection_size;
    }

    public void ensureCapacity() {
        if (size >= elementData.length) {
            int growSize = Math.min(elementData.length * 2 + 1, MAX_ARRAY_SIZE);
            grow(growSize);
        }
    }

    public void trimToSize() {
        if (size < elementData.length) {
            Object[] newList = new Object[size];
            System.arraycopy(elementData, 0, newList, 0, size);
            elementData = newList;
        }
    }

    private void grow(int growSize) {
        if (growSize > MAX_ARRAY_SIZE) {
            growSize = MAX_ARRAY_SIZE;
        }
        if (growSize <= elementData.length) {
            return;
        }
        Object[] newArray = new Object[growSize];
        System.arraycopy(elementData, 0, newArray, 0, size);
        elementData = newArray;
    }

    public void add(K element) {
        ensureCapacity();
        elementData[size++] = element;
    }

    public void add(int index, K element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        ensureCapacity();
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        size++;
    }

    public int getSize() {
        return size;
    }

    @SuppressWarnings("unchecked")
    public K get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (K) elementData[index];
    }

    public K getFirst() {
        if (size == 0) {
            return null;
        }
        return get(0);
    }

    public K getLast() {
        if (size == 0) {
            return null;
        }
        return get(size - 1);
    }

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

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public K set(int index, K element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        K oldValue = (K) elementData[index];
        elementData[index] = element;
        return oldValue;
    }

    @SuppressWarnings("unchecked")
    public K remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        K removed = (K) elementData[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = null;
        return removed;
    }

    public boolean remove(Object element) {
        for (int i = 0; i < size; i++) {
            if (element == null ? elementData[i] == null : element.equals(elementData[i])) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean contains(Object element) {
        return indexOf(element) >= 0;
    }

    public int indexOf(Object element) {
        for (int i = 0; i < size; i++) {
            if (element == null ? elementData[i] == null : element.equals(elementData[i])) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return size;
    }

    public void sort() {
        // Since K extends Comparable, we can sort
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                @SuppressWarnings("unchecked")
                K current = (K) elementData[j];
                @SuppressWarnings("unchecked")
                K next = (K) elementData[j + 1];
                if (current.compareTo(next) > 0) {
                    // Swap
                    Object temp = elementData[j];
                    elementData[j] = elementData[j + 1];
                    elementData[j + 1] = temp;
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    public MyArrayList<K> clone() {
        try {
            MyArrayList<K> cloned = new MyArrayList<K>(elementData.length);
            System.arraycopy(elementData, 0, cloned.elementData, 0, size);
            cloned.size = this.size;
            return cloned;
        } catch (Exception e) {
            throw new RuntimeException("Clone failed", e);
        }
    }
}