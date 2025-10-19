public class MyStack<K> extends MyVector<K>{
    private long serialVersionUID ;
    private int size = 0;
    private Object[] elements;
    public MyStack() {
        super();
        elements = new Object[16];
    }

    public K push(K element){
        ensureCapacity(size + 1);
        elements[size++] = element;
        return element;
    }
    public K pop(){
        K element = null;
        if (size > 0) {
            element = (K) elements[size-1];
            elements[size] = null;
        }
        size--;
        return element;
    }
    public K peek(){
        K element = null;
        if (size > 0) {
            element = (K) elements[size-1];
        }
        return element;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public boolean isFull(){
        return size == elements.length;
    }
    public int size(){
        return size;
    }
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }


}
