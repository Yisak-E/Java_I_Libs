public class MyArrayList<K extends Comparable<K>> {
    public final int DEFAULT_CAPACITY  = 10;
    K[] elementData ;
    private int size = 0;
    public final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    @SuppressWarnings("unchecked")
    public  MyArrayList(){
        elementData = (K[]) new Object[DEFAULT_CAPACITY];
    }

    @SuppressWarnings("unchecked")
    public MyArrayList(int capacity){
        if (capacity < 0){
            throw new IllegalArgumentException("capacity must be a positive integer.");
        }
        elementData = (K[]) new Object[capacity];
    }
    public MyArrayList(MyCollection<? extends K> collections){
        if (collections == null){
            System.out.println("Empty Collection");
        }
        int collection_size = collections.size();
        elementData = (K[]) new Comparable[collection_size];
        for (int i = 0; i < collection_size; i++){
            elementData[i] = collections.get(i);
        }
        size = collection_size;
    }


    public void ensureCapacity(){
        if (size >= elementData.length){
            int growSize =  elementData.length * 2+1;
          grow(growSize);
        }
    }

    @SuppressWarnings("unchecked")
    public void trimToSize(){
        if(size < elementData.length()){
            K[] newList = (K[]) new Comparable[size];
           System.arraycopy(elementData, 0, newList, 0, size);
           elementData = newList;
        }
    };

    @SuppressWarnings("unchecked")
    public MyArrayList<K> clone(){
       MyArrayList<K> cloned = new MyArrayList<K>(elementData.length);
       System.arraycopy(elementData, 0, cloned.elementData, 0, size);
        return cloned;
    }

    @SuppressWarnings("unchecked")
    void grow(int growSize){
        K[] newArray = (K[]) new Comparable[growSize];
        System.arraycopy(elementData, 0, newArray, 0, size);
        elementData = newArray;
    }

    public void add(K element){
        ensureCapacity();
        elementData[size++] = element;
    }

    public int getSize(){
        return size;
    }

    public K get(int index){
        /**
         * check the index is valid
         */
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        return elementData[index];
    }

    public K getFirst(){
        if (size == 0){
            return null;
        }
        return elementData[0];
    }

    public K getLast(){
        if (size == 0){
            return null;
        }
        return elementData[size - 1];
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++){
            sb.append(elementData[i]);
            if (i != size - 1){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }


}