interface MyCollection<K> {
    int size();
    boolean isEmpty();
    boolean add(K k);
    boolean remove(K k);
    boolean contains(K k);
    void clear();
    Object[] toArray();
    boolean containsAll(MyCollection<K> c);
    boolean addAll(MyCollection<? extends K> c);
    boolean removeAll(MyCollection<K> c);
    boolean retainAll(MyCollection<K> c);
    K get(int i);

}