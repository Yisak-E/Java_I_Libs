import java.util.NoSuchElementException;

public interface MyDeque<K> {
    /**
     * Inserts the specified element at the front of this deque
     * @throws IllegalStateException if the element cannot be added at this time due to capacity restrictions
     */
    void addFirst(K element);

    /**
     * Inserts the specified element at the end of this deque
     * @throws IllegalStateException if the element cannot be added at this time due to capacity restrictions
     */
    void addLast(K element);

    /**
     * Inserts the specified element at the front of this deque unless it would violate capacity restrictions
     */
    boolean offerFirst(K element);

    /**
     * Inserts the specified element at the end of this deque unless it would violate capacity restrictions
     */
    boolean offerLast(K element);

    /**
     * Retrieves and removes the first element of this deque
     * @throws NoSuchElementException if this deque is empty
     */
    K removeFirst();

    /**
     * Retrieves and removes the last element of this deque
     * @throws NoSuchElementException if this deque is empty
     */
    K removeLast();

    /**
     * Retrieves and removes the first element of this deque, or returns null if this deque is empty
     */
    K pollFirst();

    /**
     * Retrieves and removes the last element of this deque, or returns null if this deque is empty
     */
    K pollLast();

    /**
     * Retrieves, but does not remove, the first element of this deque
     * @throws NoSuchElementException if this deque is empty
     */
    K getFirst();

    /**
     * Retrieves, but does not remove, the last element of this deque
     * @throws NoSuchElementException if this deque is empty
     */
    K getLast();

    /**
     * Retrieves, but does not remove, the first element of this deque, or returns null if this deque is empty
     */
    K peekFirst();

    /**
     * Retrieves, but does not remove, the last element of this deque, or returns null if this deque is empty
     */
    K peekLast();
}