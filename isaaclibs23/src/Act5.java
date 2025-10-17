public class Act5 <E> {
    public static final int INITIAL_CAPACITY = 16;
    private int front =-1, rear = -1 ;
    private E[] data =(E[]) new Object[INITIAL_CAPACITY];

    public void GenericCircularQueueV2 () {  } /** Create a default queue */

    public void GenericCircularQueueV2 (E[] objects) {
        /* Create a queue from an array of objects */
        for (int i = 0; i < objects.length; i++)
          enqueue(objects[i]);
    }

    public E Dequeue() {/** Remove an element from the head of the queue */
        if (front == -1 || rear == -1)
            return null;
        E firstElement =  data[front];
        if (front == rear)
            front= rear =-1;
	    else if (front == data.length - 1)
            front = 0;
	    else
            front++;
        return firstElement;
    }

    /** Add a new element at the end of the queue */
    public void enqueue(E e) {
        ensureCapacity();
        if (isEmpty()) {
            data[0] = e;
		  front =rear = 0;

        } else {
            rear = (rear + 1) % data.length;
            data[rear] = e;
            if (front == -1)
                front = 0;
        }
    }
    /** Create a new larger array, double the current size + 1 */
    private void ensureCapacity() {
        int size = size();
        if ( size >= data.length-1 ) {
            int newSize = 2 * size + 1;
            E[] newData = (E[])(new Object[newSize]);
            if (front <= rear)
                System.arraycopy(data, front, newData,0, size);
            else { // (rear < front)
                System.arraycopy(data,front, newData, 0, data.length - front);
                System.arraycopy(data,0, newData, data.length - front,rear +1);
                front = 0;
                rear = size - 1;
            }
            data = newData;
        }
    }

    public boolean isEmpty() { return front==-1; }

    public int size() {
        if (isEmpty()) return 0;
        if (front <= rear) return rear - front + 1;
        return data.length - front + rear + 1;
    }

    public void clear() {
        data = (E[]) new Object[INITIAL_CAPACITY];
        front =-1;
        rear =-1;
    }

    public String toString() {
        StringBuilder result = new StringBuilder("[");

        if (!isEmpty())
            for (int i = 0; i < size(); i++) {
                result.append(data[ (front + i)%data.length]);
                if( i < size() - 1){
                    result.append(", "); // Separate two elements with a comma
                }
            }
        result.append("]"); // Insert the closing ] in the string
        return "Queue: " + size() + "/" + data.length + " " + result.toString();
    }


    /** Trims the capacity to current size */
    public void trimToSize() {
        int size = size();
        if (data.length > size) {
            E[] newData =  (E[])(new Object[size+ 1]);
            if (front <= rear) {
                System.arraycopy(data, front, newData, 0, size);
                front = 0;
                rear = size -1;
            } else { // (rear < front)
                System.arraycopy(data, front, newData,0 ,data.length - front);
                System.arraycopy(data,0, newData, data.length - front, rear +1);
                front = 0;
                rear = size -1;
            }
            data = newData;
        } // If size == capacity, no need to trim
    }
}
