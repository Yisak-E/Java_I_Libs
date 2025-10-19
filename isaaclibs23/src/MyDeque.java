import java.util.Deque;
import java.util.NoSuchElementException;

/**
 * A linear collection that supports element insertion and removal at both ends.
 * This interface defines methods to access the elements at both ends of a deque.
 *
 * @param <K> the type of elements held in this deque.
 */
public interface MyDeque<K>  extends MyQueue<K> {
    /** Inserts the specified element at the front of this deque. */
    void addFirst(K element) throws IllegalStateException;

    /** Inserts the specified element at the end of this deque. */
    void addLast(K element) throws IllegalStateException;

    /** Inserts the specified element at the front of this deque. */
    boolean offerFirst(K element);

    /** Inserts the specified element at the end of this deque. */
    boolean offerLast(K element);

    /** Retrieves and removes the first element of this deque. */
    K removeFirst() throws NoSuchElementException;

    /** Retrieves and removes the last element of this deque. */
    K removeLast() throws NoSuchElementException;

    /** Retrieves and removes the first element of this deque, or returns null if this deque is empty. */
    K pollFirst();

    /** Retrieves and removes the last element of this deque, or returns null if this deque is empty. */
    K pollLast();

    /** Retrieves, but does not remove, the first element of this deque. */
    K getFirst() throws NoSuchElementException;

    /** Retrieves, but does not remove, the last element of this deque. */
    K getLast() throws NoSuchElementException;

    /** Retrieves, but does not remove, the first element of this deque, or returns null if this deque is empty. */
    K peekFirst();

    /** Retrieves, but does not remove, the last element of this deque, or returns null if this deque is empty. */
    K peekLast();
}
