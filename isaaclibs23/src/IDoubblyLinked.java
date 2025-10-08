import java.util.Iterator;

public class IDoubblyLinked<K> extends IAbstractIList<K> {
    Node<K> head;
    Node<K> tail;
    public IDoubblyLinked(K[] objects) {
        super(objects);
    }

    public IDoubblyLinked() {}

    @Override
    public void add(K k) {
        if(k == null){
            return;
        }
        if (head == null) {
            head = tail = new Node<>(k);
        }else{
            Node<K> temp = new Node<>(k);
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
        }
        size++;
    }

    @Override
    public void add(int index, K k) {
        checkIndex(index);
        if(index == 0) addFirst(k);
        else if(index == size-1) addLast(k);
        else{

            Node<K> current = head;
            for(int i = 1; i < index; i++){
                current = current.next;
            }
            Node<K> newNode = new Node<>(k);
            newNode.next = current.next;
            newNode.prev = current;

            current.next.prev = newNode;
            current.next = newNode;

            size++;
        }

    }

    public void addFirst(K k) {
//        if(k == null){
//            return;
//        }
        if(head == null){
            head = tail = new Node<>(k);

        }
        else{
            Node<K> newNode = new Node<>(k);
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }
    public void addLast(K k) {
        if(k == null) return;
        if(tail == null){
            tail = new Node<>(k);
        }else{
            Node<K> newNode = new Node<>(k);
            tail.next = newNode;
            tail = newNode;
        }
        size++;

    }

    public void checkIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public K get(int index) {
        checkIndex(index);
        Node<K> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }

    @Override
    public K set(int index, K k) {
        checkIndex(index);
        Node<K> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        K previous = current.element;
        current.element = k;
        return previous;
    }

    @Override
    public K remove(int index) {
        checkIndex(index);
        if(index == 0) return null;
        if(index ==1) return removeFirst();
        if(index == size-1) return removeLast();
        Node<K> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        K previous = current.element;
        Node<K> nextNode = current.next;
        size--;
        return previous;
    }

    public K removeFirst() {
        if(head == null) return null;

        K toRemove = head.element;
        Node<K> newHead = head.next;
        head.next.prev = null;
        head = newHead;
        size--;

        if(size == 0){
            head = tail = null;
        }

        return toRemove;
    }

    /**
     *  tail =tail.prev;
     *         if(tail != null){
     *             tail.next = null;
     *         }
     *         if(tail == null){
     *             head = null;
     *         }
     */
    public K removeLast() {

        if(tail == null) return null;
        K toRemove = tail.element;
        if(head == tail){
            tail = head = null;
        }else{
            tail = tail.prev;
            tail.next = null;
        }

        size--;
        return toRemove;
    }

    @Override
    public boolean remove(K k) {
       Node<K> current = head;
//       for (int i = 0; i < size; i++) {
//           if(current.element.equals(k)){
//
//           }
//       }
       return true;
    }

    @Override
    public K getFirst() {
        if(head == null) return null;
        return head.element;
    }

    @Override
    public K getLast() {
        if(size == 0) return null;
       return tail.element;
    }

    @Override
    public K getMiddle() {
        if(size == 0) return null;
        Node<K> slow = head;
        Node<K> fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

        }
        return slow.element;
    }

    @Override
    public void clear() {

    }

    @Override
    public int indexOf(K k) {
        return 0;
    }

    @Override
    public int lastIndexOf(K k) {
        return 0;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        IDoubblyLinked.Node<K> current = head;
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

    @Override
    public Iterator<K> iterator() {
        return new IsaacsDoublyIterator();
    }

    private class IsaacsDoublyIterator implements java.util.Iterator<K> {
        private int index = 0;
        @Override
        public boolean hasNext() {
            return false;
        }
        @Override
        public K next() {
            return null;
        }
        @Override
        public void remove() {

        }
    }

    private static class Node<K> {
         K element;
         Node<K> next;
         Node<K> prev;
        public Node(K element) {
            this.element = element;
            this.next = null;
            this.prev = null;
        }
        public Node(K element, Node<K> next, Node<K> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }




}
