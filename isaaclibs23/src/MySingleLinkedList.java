import java.util.NoSuchElementException;

public class MySingleLinkedList<K> extends MyAbstractList<K>  implements MyDeque{
    public Node<K> head;
    public Node<K> tail;
    private int size = 0;
    public MySingleLinkedList() {
        head = null;
        tail = null;
    }

    @Override
    public K get(int index) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        Node<K> current = head;
        for(int i = 0; i < index; i++)
            current = current.next;
        return current.data;
    }

    @Override
    public K set(int index, K element) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        Node<K> current = head;
        K previous = null;

        for(int i = 0; i < index; i++)
            current = current.next;
        previous = current.data;
        current.data = element;
        return previous;
    }

    @Override
    public void add(int index, K element) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        Node<K> current = head;
        if(index == 0) addFirst(element);
        else if (index == size) addLast(element);
        else {
            for(int i = 0; i < index; i++)
                current = current.next;
            Node<K> newNode = new Node(element);
            newNode.next = current.next;
           current.next = newNode;
            System.out.println("new Node: " + newNode.data);
            size++;
        }

    }
    public boolean add(K element) {
        if(size == 0) {
            addFirst(element);
        }
        else {
            addLast(element);
        }
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
        Node<K> current = head;
        while(current != null){
            sb.append(current.data);
            current = current.next;
            if(current != null)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public boolean isEmpty() {
        return head == null;
    }
    public int size() {
        return size;
    }

    @Override
    public void addFirst(Object element) throws IllegalStateException {
        if(head == null){
            head = tail = new Node(element);
        }
        else {
            Node newNode = new Node(element);
            newNode.next = head;
            head = newNode;
        }
        size++;
    }


    public void addLast(Object element) throws IllegalStateException {
       if (head == null) {
           head = tail = new Node(element);
           size++;
       }
       Node newNode = new Node(element);
       tail.next = newNode;
       tail = newNode;
       size++;
    }

    @Override
    public boolean offerFirst(Object element) {
        return false;
    }

    @Override
    public boolean offerLast(Object element) {
        return false;
    }

    @Override
    public Object removeFirst() throws NoSuchElementException {
        return null;
    }

    @Override
    public Object removeLast() throws NoSuchElementException {
        return null;
    }

    @Override
    public Object pollFirst() {
        return null;
    }

    @Override
    public Object pollLast() {
        return null;
    }

    @Override
    public Object getFirst() throws NoSuchElementException {
        return null;
    }

    @Override
    public Object getLast() throws NoSuchElementException {
        return null;
    }

    @Override
    public Object peekFirst() {
        return null;
    }

    @Override
    public Object peekLast() {
        return null;
    }


    private static class Node<K> {
        K data;
        Node<K> next;
        public Node(K data) {
            this.data = data;
            this.next = null;
        }
    }
}
