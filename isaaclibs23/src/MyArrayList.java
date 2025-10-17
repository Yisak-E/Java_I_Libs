public class MyArrayList<K extends MyComparable<K>> implements MyCollection<K> {
    public final int DEFAULT_CAPACITY = 10;
    private Object[] elementData;
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

    @Override
    public boolean add(K element) {
        ensureCapacity();
        elementData[size++] = element;
        return true;
    }

    @Override
    public boolean addAll(MyCollection<? extends K> c) {
        boolean changed = false;
        for (int i = 0; i < c.size(); i++) {
            changed |= add(c.get(i));
        }
        return changed;
    }

    @Override
    public boolean remove(K element) {
        return remove((Object) element);
    }

    @Override
    public boolean removeAll(MyCollection<?> c) {
        boolean changed = false;
        for (int i = 0; i < c.size(); i++) {
            changed |= remove(c.get(i));
        }
        return changed;
    }

    @Override
    public boolean retainAll(MyCollection<?> c) {
        boolean changed = false;
        for (int i = 0; i < size; i++) {
            if (!c.contains(elementData[i])) {
                remove(i--);
                changed = true;
            }
        }
        return changed;
    }

    @Override
    public boolean contains(K element) {
        return indexOf(element) >= 0;
    }

    @Override
    public boolean containsAll(MyCollection<?> c) {
        for (int i = 0; i < c.size(); i++) {
            if (!contains((K) c.get(i))) return false;
        }
        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        System.arraycopy(elementData, 0, result, 0, size);
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    public int getSize() {
        return size;
    }

    @Override
    @SuppressWarnings("unchecked")
    public K get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (K) elementData[index];
    }

    public K getFirst() {
        return isEmpty() ? null : get(0);
    }

    public K getLast() {
        return isEmpty() ? null : get(size - 1);
    }

    public boolean isEmpty() {
        return size == 0;
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

    public int indexOf(Object element) {
        for (int i = 0; i < size; i++) {
            if (element == null ? elementData[i] == null : element.equals(elementData[i])) {
                return i;
            }
        }
        return -1;
    }

    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                @SuppressWarnings("unchecked")
                K current = (K) elementData[j];
                @SuppressWarnings("unchecked")
                K next = (K) elementData[j + 1];
                if (current.compareTo(next) > 0) {
                    Object temp = elementData[j];
                    elementData[j] = elementData[j + 1];
                    elementData[j + 1] = temp;
                }
            }
        }
    }

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
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    public MyArrayList<K> clone() {
        try {
            MyArrayList<K> cloned = new MyArrayList<>(elementData.length);
            System.arraycopy(elementData, 0, cloned.elementData, 0, size);
            cloned.size = this.size;
            return cloned;
        } catch (Exception e) {
            throw new RuntimeException("Clone failed", e);
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
}