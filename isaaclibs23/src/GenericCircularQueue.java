/**
 * An array-based implementation of a circular queue that implements the MyQueue interface.
 * Based on the structure provided in Act5.java.
 *
 * @param <E> the type of elements in this queue.
 */
public class GenericCircularQueue<E> extends MyAbstractQueue<E> implements MyQueue<E> {
    public static final int INITIAL_CAPACITY = 16;
    private int front = -1, rear = -1;
    // Suppress unchecked warning for generic array creation
    @SuppressWarnings("unchecked")
    private E[] data = (E[]) new Object[INITIAL_CAPACITY];

    /** Create a default queue */
    public GenericCircularQueue() {
        super();
    }

    /** Create a queue from an array of objects */
    public GenericCircularQueue(E[] objects) {
        super();
        for (E object : objects) {
            offer(object);
        }
    }

    /**
     * Inserts the specified element into this queue.
     * @param e the element to add.
     * @return true if the element was added to this queue.
     */
    @Override
    public boolean offer(E e) {
        ensureCapacity();
        if (isEmpty()) {
            data[0] = e;
            front = rear = 0;
        } else {
            // Circular increment
            rear = (rear + 1) % data.length;
            data[rear] = e;
        }
        size++;
        modCount++;
        return true;
    }

    /**
     * Retrieves and removes the head of this queue, or returns null if this queue is empty.
     * @return the head of this queue, or null if this queue is empty.
     */
    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }

        E firstElement = data[front];
        data[front] = null; // Clear reference for garbage collection

        if (front == rear) {
            // Last element removed
            front = rear = -1;
        } else {
            // Circular increment
            front = (front + 1) % data.length;
        }

        size--;
        modCount++;
        return firstElement;
    }

    /**
     * Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
     * @return the head of this queue, or null if this queue is empty.
     */
    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return data[front];
    }

    /** @deprecated Use offer(E e) instead for consistency with MyQueue. */
    @Deprecated
    public void enqueue(E e) {
        offer(e);
    }

    /** @deprecated Use poll() instead for consistency with MyQueue. */
    @Deprecated
    public E Dequeue() {
        return poll();
    }

    /** Create a new larger array, double the current size + 1, when capacity is full. */
    private void ensureCapacity() {
        // Queue is full if the next rear position is the front position
        if ((rear + 1) % data.length == front) {
            int newCapacity = data.length * 2;
            // Suppress unchecked warning for generic array creation
            @SuppressWarnings("unchecked")
            E[] newData = (E[]) new Object[newCapacity];
            int currentSize = size();

            // Copy elements preserving their logical order
            if (front <= rear) {
                // Not wrapped, simple copy
                System.arraycopy(data, front, newData, 0, currentSize);
            } else {
                // Wrapped: Copy from front to end, then from 0 to rear
                System.arraycopy(data, front, newData, 0, data.length - front);
                System.arraycopy(data, 0, newData, data.length - front, rear + 1);
            }

            data = newData;
            front = 0;
            rear = currentSize - 1;
            // Size and modCount are already updated by offer/poll, no need to touch here
        }
    }

    /** Returns true if this queue contains no elements. */
    @Override
    public boolean isEmpty() {
        return front == -1;
    }

    /**
     * Returns the number of elements in this queue.
     */
    @Override
    public int size() {
        if (isEmpty()) return 0;
        if (front <= rear) return rear - front + 1;
        return data.length - front + rear + 1;
    }

    /** Removes all of the elements from this queue. */
    @Override
    public void clear() {
        // Suppress unchecked warning for generic array creation
        @SuppressWarnings("unchecked")
        E[] newArray = (E[]) new Object[INITIAL_CAPACITY];
        data = newArray;
        front = -1;
        rear = -1;
        this.size = 0;
        modCount++;
    }

    /** Returns a string representation of the queue. */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        int currentSize = size();

        if (currentSize > 0) {
            for (int i = 0; i < currentSize; i++) {
                result.append(data[(front + i) % data.length]);
                if (i < currentSize - 1) {
                    result.append(", ");
                }
            }
        }
        result.append("]");
        return "Queue: " + currentSize + "/" + data.length + " " + result.toString();
    }


    /** Trims the capacity of this queue instance to be the queue's current size. */
    public void trimToSize() {
        int currentSize = size();
        if (data.length > currentSize) {
            // Suppress unchecked warning for generic array creation
            @SuppressWarnings("unchecked")
            E[] newData = (E[]) new Object[currentSize];

            if (front <= rear) {
                // Not wrapped, simple copy
                System.arraycopy(data, front, newData, 0, currentSize);
            } else {
                // Wrapped: Copy from front to end, then from 0 to rear
                System.arraycopy(data, front, newData, 0, data.length - front);
                System.arraycopy(data, 0, newData, data.length - front, rear + 1);
            }

            data = newData;
            front = 0;
            rear = currentSize - 1;
            modCount++;
        }
    }

    // --- Abstract methods from MyAbstractQueue/MyAbstractCollection ---

    @Override
    public boolean contains(E element) {
        if (isEmpty()) return false;
        int currentSize = size();
        for (int i = 0; i < currentSize; i++) {
            E current = data[(front + i) % data.length];
            if (element == null ? current == null : element.equals(current)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public E get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size);
        }
        return data[(front + i) % data.length];
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size()];
        int currentSize = size();
        for (int i = 0; i < currentSize; i++) {
            result[i] = data[(front + i) % data.length];
        }
        return result;
    }

    // Note: remove(E element) is intentionally not implemented in this simplified
    // circular queue, as queue implementations often restrict element removal.
    @Override
    public boolean remove(E element) {
        throw new UnsupportedOperationException("Remove by element is not supported in this queue implementation.");
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
