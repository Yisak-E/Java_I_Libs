abstract class MyAbstractCollection<K> implements MyCollection<K>{
    protected int size;
    protected int modCount;
    MyAbstractCollection(){
        this.size = 0;
        this.modCount = 0;
    }
    public  int size(){
        return this.size;
    };
    public boolean isEmpty(){
        return this.size == 0;
    };
    public abstract String toString();
    public abstract boolean contains(K element);

    public abstract  Object[] toArray(K[] collection);
    public abstract boolean add(K element);
    public abstract boolean remove(K element);
    public abstract boolean containsAll(MyCollection<?> c);
    public abstract boolean addAll(MyCollection<? extends K> collection);
    public abstract boolean removeAll(MyCollection<?> collects);
    public abstract boolean retainAll(MyCollection<?> collects);
    public abstract void clear();
}