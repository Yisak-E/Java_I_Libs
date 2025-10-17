public interface MyCollection<K> {

    // Static method returning a reverse order comparator for Strings
    static MyComparator<? super String> reverseOrder() {
        return new MyComparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a); // reverse lexicographic order
            }
        };
    }

    int size();
    boolean isEmpty();
    boolean add(K k);
    boolean remove(K k);
    boolean contains(K k);
    void clear();
    Object[] toArray();
    boolean containsAll(MyCollection<?> c);
    boolean addAll(MyCollection<? extends K> c);
    boolean removeAll(MyCollection<?> c);
    boolean retainAll(MyCollection<?> c);
    K get(int i);
}