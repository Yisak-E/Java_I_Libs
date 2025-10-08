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

    @Override
    public K get(int index) {
        return null;
    }

    @Override
    public K set(int index, K element) {
        return null;
    }

    @Override
    public K remove(int index) {
        return null;
    }

    @Override
    public boolean remove(K element) {
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


//    @Override
//    public Iterator<K> iterator() {
//        return new ILinkedListIterator();
//    }

//    public class ILinkedListIterator implements Iterator<K> {
//        private Node<K> current = head;
//
//
//        @Override
//        public boolean hasNext() {
//            return head.next != null;
//        }
//
//        @Override
//        public K next() {
//            K k = current.next.element;
//            current = current.next;
//            return k;
//        }
//        @Override
//        public void remove() {
//            ILinkedListIterator.this.remove();
//        }
//    }


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
