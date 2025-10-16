

import java.util.NoSuchElementException;

public abstract class MyAbstractQueue<K> extends MyAbstractCollection<K> implements MyQueue<K> {

    public MyAbstractQueue() {
    }

    public boolean add(K element) {
        if (offer(element)) {
            return true;
        } else {
            throw new IllegalStateException("Queue full");
        }
    }

    public K remove() {
        K element = poll();
        if (element != null) {
            return element;
        } else {
            throw new NoSuchElementException("Queue empty");
        }
    }

    public K element() {
        K element = peek();
        if (element != null) {
            return element;
        } else {
            throw new NoSuchElementException("Queue empty");
        }
    }

    public void clear() {
        while (poll() != null) {
            // Keep polling until empty
        }
    }

    public boolean addAll(MyCollection<? extends K> collection) {
        if (collection == null) {
            throw new NullPointerException("Collection cannot be null");
        }
        boolean modified = false;
        for (int i = 0; i < collection.size(); i++) {
            K element = collection.get(i);
            if (add(element)) {
                modified = true;
            }
        }
        return modified;
    }

    // Abstract methods that must be implemented by subclasses
    public abstract boolean offer(K element);
    public abstract K poll();
    public abstract K peek();
}