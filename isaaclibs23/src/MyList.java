interface MyList<K>{
    K get(int index);
    K set(int index, K element);
    void add(int index, K element);
    K remove(int index);
    int indexOf(K element);
    int lastIndexOf(K element);
    MyListIterator<K> listIterator();
    MyListIterator<K> listIterator(int index);
    MyList<K> subList(int fromIndex, int toIndex);
}