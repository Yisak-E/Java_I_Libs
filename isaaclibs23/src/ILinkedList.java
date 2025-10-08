import java.util.Iterator;

public class ILinkedList<K> extends IAbstractIList<K> {
    private Node<K> head;
    private Node<K> tail;

    public ILinkedList(){}

    public ILinkedList(K[] objects){
       super(objects);
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
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
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public void add(K element) {
        Node<K> newNode = new Node<>(element);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;

    }

    @Override
    public void add(int index, K element) {
        checkIndex(index);

        Node<K> newNode = new Node<>(element);
        if(head == null) addFirst(element);
        else if(index == size) addLast(element);
        else {
            Node<K> current = head;
            for(int i = 0; i < index; i++){
                current = current.next;
            }
            current.next = newNode;
            size++;

        }

    }

    public void addLast(K element) {

        if(head == null) addFirst(element);
        else{
            Node<K> newNode = new Node<>(element);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void addFirst(K element) {
        Node<K> newNode = new Node<>(element);
        newNode.next = head;
        head = newNode;
        size++;

        if(tail == null){
            tail = newNode;
        }
    }

    public K removeFirst() {
        if(head == null) return null;
        K element = head.element;
        head = head.next;
        size--;

        if(head == null){
            tail = null;
        }
        return element;

    }

    /** the size-1 should be removed size-2-1+1 ,
     *  but we have to access items before it
     *  */
    public K removeLast() {
        if(isEmpty()) return null;
        K element = tail.element;
        if(tail == head) {
            tail = null;
            head = null;
            size = 0;
        }else{
            Node<K> current = head;
            for(int i = 1; i < size-1; i++){
                current = current.next;
            }
            current.next = null;
            tail = current;
            size--;
        }
        return element;
    }

    @Override
    public K get(int index) {
        checkIndex(index);
        Node<K> current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current.element;
    }

    @Override
    public K set(int index, K element) {
        checkIndex(index);
        Node<K> current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        K oldElement = current.element;
        current.element = element;
        return oldElement;
    }

    @Override
    public K remove(int index) {
        checkIndex(index);

        if(index == 0) return removeFirst();
        else if(index == size-1) return removeLast();
        else{
            Node<K> previous = head;
            for(int i = 1; i < index; i++){
                previous = previous.next;

            }
            Node<K> current = previous.next;
            previous.next = current.next;
            size--;
            return current.element;
        }
    }

    @Override
    public boolean remove(K element) {
        Node<K> previous = head;
        Node<K> current = head;
        while(current != null){
            if(current.element.equals(element)){
                previous.next = current.next;
                size--;
                return true;
            }else{
                previous = current;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public K getFirst() {
        if(isEmpty()) return null;
        return head.element;
    }

    @Override
    public K getLast() {
        if(isEmpty())return null;
        return tail.element;
    }

    @Override
    public K getMiddle() {
        if(isEmpty())return null;
        if(size == 1)return head.element;

        Node<K> slow = head;
        Node<K> fast = head;
        while(fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.element;
    }

    public int size(){
        return size;
    }

    @Override /** Override iterator() defined in Iterable */
    public Iterator<K> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements java.util.Iterator<K> {
        private Node<K> current = head; // Current index

        @Override
        public boolean hasNext() {
            return (current!=null);
        }

        @Override
        public K next() {
            K e = current.element;
            current =current.next;
            return e;
        }

        @Override
        public void remove() {
            ILinkedList.this.remove(indexOf(current.element));
        }
    }

    // This class is only used in LinkedList, so it is private.
    // This class does not need to access any
    // instance members of LinkedList, so it is defined static.
    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
        }
        public Node(){
            this.element = null;
        }
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder("[");
       Node<K> current = head;
       while(current!=null){
           sb.append(current.element);
           current=current.next;
           if(current!=null){
               sb.append(",");
           }
       }
       sb.append("]");
       return sb.toString();

    }
}
