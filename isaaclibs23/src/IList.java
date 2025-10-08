public interface IList<K>  extends Iterable<K>{
    //basic operations
    void add (K k);
    void add (int index, K k);
    K get (int index);
    K set (int index, K k);
    K remove (int index);
    boolean remove (K k);
    K getFirst ();
    K getLast ();
    K getMiddle ();

    // utility methods
    int size ();
    boolean isEmpty ();
    boolean contains (K k);
    void clear ();

    // search methods
    int indexOf (K k);
    int lastIndexOf (K k);

    // conversion
    Object[] toArray ();



}
