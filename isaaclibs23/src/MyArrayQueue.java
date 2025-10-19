import java.util.NoSuchElementException;

public class MyArrayQueue<K> implements MyQueue<K> {
    private MySingleLinkedList<K> elements;

    MyArrayQueue() {
      elements = new MySingleLinkedList<>();
    }

    @Override
    public boolean offer(K element) {
        elements.addLast(element);
        return true;
    }

    @Override
    public K poll() {
       return (K)elements.removeFirst();
    }

    @Override
    public K peek() {
        return (K)elements.getFirst();
    }

    @Override
    public K element() throws NoSuchElementException {
        return null;
    }

    @Override
    public K remove() throws NoSuchElementException {
        return (K)elements.removeFirst();
    }

    public int size() {
        return elements.size();
    }
    public boolean isEmpty() {
        return elements.isEmpty();
    }
    public String toString() {
        return elements.toString();
    }
}
