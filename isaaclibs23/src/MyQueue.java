import java.util.NoSuchElementException;

/**
 * A collection designed for holding elements prior to processing.
 * Besides basic Collection operations, queues provide additional insertion,
 * extraction, and inspection operations.
 *
 * @param <K> the type of elements in this queue.
 */
public interface MyQueue<K> {
    /** Inserts the specified element into this queue. Returns true on success. */
    boolean offer(K element);

    /** Retrieves and removes the head of this queue, or returns null if this queue is empty. */
    K poll();

    /** Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty. */
    K peek();

    /** Retrieves, but does not remove, the head of this queue. */
    K element() throws NoSuchElementException;

    /** Retrieves and removes the head of this queue. */
    K remove() throws NoSuchElementException;
}
