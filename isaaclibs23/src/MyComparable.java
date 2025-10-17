/**
 * Defines the contract for objects that can be compared to establish an ordering.
 * This is similar to the standard Java `Comparable` interface.
 *
 * @param <K> The type of objects that this object can be compared to.
 */
public interface MyComparable<K> {
    /**
     * Compares this object with the specified object for order.
     * @param other the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     */
    int compareTo(K other);
}