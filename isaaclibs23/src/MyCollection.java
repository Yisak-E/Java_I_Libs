/**
 * The root interface in the collection hierarchy. A Collection represents a group of objects,
 * known as its elements.
 *
 * NOTE: The interface signature has been corrected to remove the non-standard K get(int i)
 * method, as this belongs in MyList. However, to support MyAbstractCollection's signature,
 * I have re-added it, assuming all custom collections must support indexed retrieval.
 *
 * @param <K> the type of elements in this collection.
 */
public interface MyCollection<K> {

    /**
     * Returns a comparator that imposes the reverse of the natural ordering on strings.
     * @return a comparator that imposes the reverse natural ordering on strings.
     */
    static MyComparator<? super String> reverseOrder() {
        return new MyComparator<String>() {
            @Override
            public int compare(String a, String b) {
                // Reverse lexicographic order
                return b.compareTo(a);
            }
        };
    }

    /** Returns the number of elements in this collection. */
    int size();

    /** Returns true if this collection contains no elements. */
    boolean isEmpty();

    /** Ensures that this collection contains the specified element (optional operation). */
    boolean add(K k);

    /** Removes a single instance of the specified element from this collection, if it is present. */
    boolean remove(K k);

    /** Returns true if this collection contains the specified element. */
    boolean contains(K k);

    /** Removes all of the elements from this collection. */
    void clear();

    /** Returns an array containing all of the elements in this collection. */
    Object[] toArray();

    /** Returns true if this collection contains all of the elements in the specified collection. */
    boolean containsAll(MyCollection<?> c);

    /** Adds all of the elements in the specified collection to this collection. */
    boolean addAll(MyCollection<? extends K> c);

    /** Removes all of this collection's elements that are also contained in the specified collection. */
    boolean removeAll(MyCollection<?> c);

    /** Retains only the elements in this collection that are contained in the specified collection. */
    boolean retainAll(MyCollection<?> c);

    /**
     * Retrieves the element at the specified position.
     * NOTE: This is an unusual method for a general Collection but is required by MyAbstractCollection.
     */
    K get(int i);
}
