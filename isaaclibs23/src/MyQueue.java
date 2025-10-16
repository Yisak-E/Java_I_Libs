import java.util.NoSuchElementException;

public interface MyQueue<K> {
    /**
     * Inserts the specified element into this queue if it is possible to do so
     * immediately without violating capacity restrictions
     */
    boolean offer(K element);

    /**
     * Retrieves and removes the head of this queue, or returns null if this queue is empty
     */
    K poll();

    /**
     * Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty
     */
    K peek();

    /**
     * Retrieves, but does not remove, the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    K element();

    /**
     * Retrieves and removes the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    K remove();
}