abstract class MyAbstractList<K>{
    int modCount;
    public abstract K get(int index);
    public abstract K set(int index, K element);
    public abstract void add(int index, K element);
    public abstract K remove(int index);
    public abstract int indexOf(K element);
    public abstract int lastIndexOf(K element);
    public abstract MyListIterator<K> listIterator();
    public abstract MyListIterator<K> listIterator(int index);
    public abstract MyList<K> subList(int fromIndex, int toIndex);
}