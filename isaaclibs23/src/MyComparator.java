/**
 * Defines the contract for a comparison function, which imposes a total ordering on some
 * collection of objects. This is similar to the standard Java `Comparator` interface.
 *
 * @param <K> The type of objects that may be compared by this comparator.
 */
public interface MyComparator<K> {
    /**
     * Compares its two arguments for order.
     * @param a the first object to be compared.
     * @param b the second object to be compared.
     * @return a negative integer, zero, or a positive integer as the first argument
     * is less than, equal to, or greater than the second.
     */
    int compare(K a, K b);
}
