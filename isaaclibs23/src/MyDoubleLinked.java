import java.util.NoSuchElementException;

public class MyDoubleLinked<K> extends MyAbstractList<K> implements MyDeque<K>{
    private int size = 0;
    public Node<K> head;
    public Node<K> tail;
    @Override
    public K get(int index) {
        return null;
    }

    @Override
    public K set(int index, K element) {
        return null;
    }

    @Override
    public void add(int index, K element) {

    }
    public boolean add(K element) {
        if(size == 0) addFirst(element);
        else addLast(element);
        return true;
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public int indexOf(K element) {
        return 0;
    }

    @Override
    public int lastIndexOf(K element) {
        return 0;
    }

    @Override
    public MyListIterator<K> listIterator() {
        return null;
    }

    @Override
    public MyListIterator<K> listIterator(int index) {
        return null;
    }

    @Override
    public MyList<K> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<K> node = head;
        while (node != null) {
            sb.append(node.data.toString());
            node = node.next;
            if (node != null) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public void addFirst(K element) throws IllegalStateException {
        if(size == 0) {
            head = tail = new Node<>(element);
        }else{
            Node<K> newHead = new Node<>(element);
            head.prev = newHead;
            newHead.next = head;
            head = newHead;
        }
        size++;
    }

    @Override
    public void addLast(K element) throws IllegalStateException {
        if(size == 0) {
            head = tail = new Node<>(element);
        }else{
            Node<K> newTail = new Node<>(element);
            tail.next = newTail;
            newTail.prev = tail;
            tail = newTail;
        }
    }

    @Override
    public boolean offerFirst(K element) {
        if(isEmpty()) {
            head = tail = new Node<>(element);
        }else{
            Node<K> newHead = new Node<>(element);
            head.prev = newHead;
            newHead.next = head;
            head = newHead;
        }
        size++;
        return true;
    }

    @Override
    public boolean offerLast(K element) {
        return false;
    }

    @Override
    public K removeFirst() throws NoSuchElementException {
        if(size == 0) {
            throw new NoSuchElementException();
        }
        Node<K> node = head;
        head = node.next;
        head.prev = null;
        node.next = null;
        size--;
        return node.data;
    }

    @Override
    public K removeLast() throws NoSuchElementException {
        if ( head == null ) return null;
        else if (size == 1 ) {
            K removed = head.data;
            head = tail = null;
            size = 0;
            return removed;
        }else{
            K removed =  tail.data;
            tail = tail.prev;
            tail.next = null;
            size--;
            return removed;
        }
    }

    @Override
    public K pollFirst() {
        return null;
    }

    @Override
    public K pollLast() {
        return null;
    }

    @Override
    public K getFirst() throws NoSuchElementException {
        return head.data;
    }

    @Override
    public K getLast() throws NoSuchElementException {
        return tail.data;
    }

    @Override
    public K peekFirst() {
        return null;
    }

    @Override
    public K peekLast() {
        return null;
    }

    public static class Node<K> {
        K data;
        Node<K> next;
        Node<K> prev;

        public Node(K data) {
            this.data = data;
            next = null;
            prev = null;
        }

        public Node(K data, Node<K> next, Node<K> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
}
