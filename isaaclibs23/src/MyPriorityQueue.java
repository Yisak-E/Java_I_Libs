public class MyPriorityQueue<K extends MyComparable<K>> implements MyQueue<K>{
    private MyList<K> dataElements = new MyArrayList<K>();

    /**
     * java.util.PriorityQueue<E>
     * +PriorityQueue()
     * +PriorityQueue(initialCapacity: int)
     * +PriorityQueue(c: Collection<? extends E>)
     * +PriorityQueue(initialCapacity: int, comparator: Comparator<? super E>)
     */

    public MyPriorityQueue(){

    }
    public MyPriorityQueue(int initialCapacity){

    }
    public MyPriorityQueue(MyCollection<? extends K> collection){

    }
    public MyPriorityQueue(int initialCapacity, MyComparator<? super K>  comparator){

    }

    @Override
    public boolean offer(K element) {
        if()
    }

    @Override
    public K poll() {
        return null;
    }

    @Override
    public K peek() {
        return null;
    }

    @Override
    public K element() {
        return null;
    }

    @Override
    public K remove() {
        return null;
    }

}
