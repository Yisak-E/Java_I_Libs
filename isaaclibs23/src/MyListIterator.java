/**
 * An iterator for lists that allows the programmer to traverse the list in either direction,
 * modify the list during iteration, and obtain the iterator's current position in the list.
 *
 * @param <K> the type of elements returned by this iterator.
 */
public interface MyListIterator<K> {
    /** Returns true if this list iterator has more elements when traversing the list in the forward direction. */
    boolean hasNext();

    /** Returns the next element in the list. */
    K next();

    /** Returns true if this list iterator has more elements when traversing the list in the reverse direction. */
    boolean hasPrevious();

    /** Returns the previous element in the list. */
    K previous();

    /** Returns the index of the element that would be returned by a subsequent call to next(). */
    int nextIndex();

    /** Returns the index of the element that would be returned by a subsequent call to previous(). */
    int previousIndex();

    /** Removes from the list the last element that was returned by next() or previous(). */
    void remove();

    /** Replaces the last element returned by next() or previous() with the specified element. */
    void set(K e);

    /** Inserts the specified element into the list immediately before the element that would be returned by next(). */
    void add(K e);
}
