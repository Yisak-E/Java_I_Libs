public interface MyListIterator<K> {
    boolean hasNext();
    K next();
    boolean hasPrevious();
    K previous();
    int nextIndex();
    int previousIndex();
    void remove();
    void set(K e);
    void add(K e);
}