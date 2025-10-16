abstract class MyAbstractCollection<K> implements MyCollection{
    int size;
    MyAbstractCollection(){

    }
    public abstract int size();
    public abstract boolean isEmpty();
    public abstract String toString();
    public abstract boolean contains(Object element);

    public abstract  Object[] toArray(K[] collection);
    public abstract  boolean add(K  element);
    boolean remove(K element);
    boolean containsAll(MyCollection<?>);
    boolean addAll(MyCollection< extends T>);
    boolean removeAll(MyCollection<K> collects);
    boolean retainAll(MyCollection<K> collects);
    void clear();
}