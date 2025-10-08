import java.util.Arrays;
import java.util.Iterator;

public class IArrayList<K> extends IAbstractIList<K> {
    private static final int  DEFAULT_CAPACITY  = 7;
    private K[]  elements = (K[])new Object[DEFAULT_CAPACITY ];

    public IArrayList() {}
    public IArrayList(K[] objects) {
       super(objects);
    }

    @Override
    public void add(K element) {
        ensureCapacity();
        elements[size++] = element;
    }

    @Override
    public void add(int index, K element) {
        ensureCapacity();
        checkIndex(index);
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
    }

    public void checkIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public K get(int index) {
       return elements[index];
    }

    @Override
    public K set(int index, K element) {
        checkIndex(index);
        elements[index] = element;
        return element;
    }

    /** removing item from the arraylist
     *  swap (current = next) from deletion index to size -2
     *  then set null to last element
     *  then decrease the size by 1
     *  return the removed item
     */
    @Override
    public K remove(int index) {
        checkIndex(index);
        K removed = elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
        return removed;
    }

    @Override
    public boolean remove(K element) {
        int index = indexOf(element);
        if (index == 0) {
            removeFirst();
            return true;
        }
       else if(index == size - 1) {
            removeLast();
            return true;
        }
       else if(index == -1){
           return false;
        }
       else {
            for (int i =index ; i < size - 1; i++) {
                elements[i] = elements[i + 1];
            }
            elements[size - 1] = null;
            size--;
            return true;
        }

    }

    public void removeFirst(){
        System.arraycopy(elements, 1, elements, 0, size - 1);
    }

    public void removeLast(){
        elements[size - 1] = null;
        size--;
    }
    public boolean removeAll(K element) {
        int counter = 0;
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i].equals(element)) {
               counter++;
            }
        }
        if (counter == 0) {
            return false;
        }
        else if(counter == size) {
            clear();
        }else{
            int writeIndex = 0;

            for(int readIndex = 0 ; readIndex < size; readIndex++){
                if(elements[writeIndex].equals(element)){
                    elements[writeIndex] = elements[readIndex];
                    writeIndex++;
                }
            }
            for(int i = writeIndex; i < size; i++){
                elements[i] = null;
            }
            size = writeIndex;
        }
        return true;
    }

    @Override
    public K getFirst() {
        if (size == 0) {
            return null;
        }
        return elements[0];
    }

    @Override
    public K getLast() {
        if (size == 0) {
            return null;
        }
        return elements[size - 1];
    }

    @Override
    public K getMiddle() {
        if (size == 0) {
            return null;
        }
        return elements[size / 2];
    }

    @Override
    public void clear() {
        if (size == 0) {
        }else{
            elements = (K[])new Object[DEFAULT_CAPACITY];
        }
    }

    @Override
    public int indexOf(K element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(K element) {
       for (int i = size - 1; i >= 0; i--) {
           if (elements[i].equals(element)) {
               return i;
           }
       }
       return -1;
    }

    private void  ensureCapacity() {
        if (elements.length == size+1) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(K k) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Iterator<K> iterator() {
        return null;
    }
}
