/**
 * Provides a skeletal implementation of the MyList interface to minimize the effort
 * required to implement this interface backed by a sequential access data store.
 *
 * @param <K> the type of elements in this list.
 */
abstract class MyAbstractList<K> extends MyAbstractCollection<K> implements MyList<K> {

    /** Constructs a new abstract list. */
    protected MyAbstractList() {
        super();
    }

    // Abstract methods from MyList that must be implemented by subclasses
    @Override
    public abstract K get(int index);
    @Override
    public abstract K set(int index, K element);
    @Override
    public abstract void add(int index, K element);
    @Override
    public abstract void remove(int index);
    @Override
    public abstract int indexOf(K element);
    @Override
    public abstract int lastIndexOf(K element);
    @Override
    public abstract MyListIterator<K> listIterator();
    @Override
    public abstract MyListIterator<K> listIterator(int index);
    @Override
    public abstract MyList<K> subList(int fromIndex, int toIndex);

    /**
     * Appends the specified element to the end of this list.
     * Delegates to the abstract add(int index, K element) method.
     */
    @Override
    public boolean add(K element){
        add(size, element);
        // add(int index, K element) is void, so we assume it always succeeds.
        return true;
    }

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     * Delegates to the abstract indexOf(K element) and remove(int index) methods.
     */
    @Override
    public boolean remove(K element){
        int index = indexOf(element);
        if(index != -1){
            remove(index);
            return true;
        }
        return false;
    }

    /**
     * Returns true if this list contains the specified element.
     * Delegates to the abstract indexOf(K element) method.
     */
    @Override
    public boolean contains(K element){
        return indexOf(element) != -1;
    }

    // --- MyAbstractCollection Implementation of Bulk Operations ---

    @Override
    @SuppressWarnings("unchecked")
    public boolean containsAll(MyCollection<?> c) {
        for (int i = 0; i < c.size(); i++) {
            // Unchecked cast is necessary because c.get(i) returns an element of unknown type
            // but we need to pass K to the local contains(K) method.
            if (!contains((K) c.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(MyCollection<? extends K> collection) {
        boolean modified = false;
        for (int i = 0; i < collection.size(); i++) {
            if (add(collection.get(i))) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public boolean removeAll(MyCollection<?> collects) {
        boolean modified = false;
        for (int i = size - 1; i >= 0; i--) {
            // Suppressing the warning/error by using unchecked cast or raw type access,
            // as this is the standard pattern for wildcard collections.
            if (((MyCollection) collects).contains(get(i))) {
                remove(i);
                modified = true;
            }
        }
        return modified;
    }

    /**
     * Retains only the elements in this list that are contained in the specified collection.
     * The original issue was in this method.
     */
    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public boolean retainAll(MyCollection<?> collects) {
        boolean modified = false;
        for (int i = size - 1; i >= 0; i--) {
            // FIX: Using a raw type access with suppressed warnings to correctly call
            // the contains method of the wildcard collection, which is the best way
            // to resolve the "capture of ?" error in this context.
            if (!((MyCollection) collects).contains(get(i))) {
                remove(i);
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public void clear() {
        // Must be implemented by concrete subclass or delegate to remove(int index) repeatedly
        for (int i = size - 1; i >= 0; i--) {
            remove(i);
        }
    }

    @Override
    public abstract Object[] toArray();

    public abstract void addFirst(K element) throws IllegalStateException;
}
