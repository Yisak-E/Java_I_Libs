/**
 * An ordered collection (also known as a sequence). List implementations generally permit
 * duplicate elements.
 *
 * @param <K> the type of elements in this list.
 */
public interface MyList<K> {
    /** Returns the element at the specified position in this list. */
    K get(int index);

    /** Replaces the element at the specified position with the specified element. */
    K set(int index, K element);

    /** Inserts the specified element at the specified position in this list. */
    void add(int index, K element);

    /** Appends the specified element to the end of this list. */
    boolean add(K element);

    /** Removes the element at the specified position in this list. */
    void remove(int index);

    /** Returns the index of the first occurrence of the specified element, or -1 if not found. */
    int indexOf(K element);

    /** Returns the index of the last occurrence of the specified element, or -1 if not found. */
    int lastIndexOf(K element);

    /** Returns a list iterator over the elements in this list (in proper sequence). */
    MyListIterator<K> listIterator();

    /** Returns a list iterator over the elements in this list, starting at the specified position. */
    MyListIterator<K> listIterator(int index);

    /** Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive. */
    MyList<K> subList(int fromIndex, int toIndex);

    /** Returns the number of elements in this list. */
    int size();
}
