abstract class MyAbstractList<K> extends MyAbstractCollection<K> implements MyList<K> {

    protected MyAbstractList() {
       super();
   }

    public abstract K get(int index);
    public abstract K set(int index, K element);
    public abstract void add(int index, K element);
    public abstract void remove(int index);
    public abstract int indexOf(K element);
    public abstract int lastIndexOf(K element);
    public abstract MyListIterator<K> listIterator();
    public abstract MyListIterator<K> listIterator(int index);
    public abstract MyList<K> subList(int fromIndex, int toIndex);

    public void add(K element){
        add(size, element);
    }

    public boolean remove(K element){
        int index = indexOf(element);
        if(index != -1){
            remove(index);
            return true;
        }
        return false;
    }

    public boolean contains(K element){
        return indexOf(element) != -1;
    }
}