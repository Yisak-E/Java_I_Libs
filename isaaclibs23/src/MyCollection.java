public interface MyCollection<K> {
    int size();
    boolean isEmpty();
    void add(K k);
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