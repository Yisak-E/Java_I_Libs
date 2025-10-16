//public class GenericCircularQueueV2 <E> {
//    public static final int INITIAL_CAPACITY = 16;
//    private int front = -1, rear = -1;
//    private E[] data = (E[]) new Object[INITIAL_CAPACITY];
//
//    public void GenericCircularQueueV2 () {  } /** Create a default queue */
//
//    public void GenericCircularQueueV2 (E[] objects) {
//        /* Create a queue from an array of objects */
//        for (int i = 0; i < objects.length; i++)
//          data[i] = objects[i];
//    }
//
//    public E Dequeue() {/** Remove an element from the head of the queue */
//        E firstElement = data[front];
//        if (front == rear)
//		  front = rear = -1;
//	 else if (front < rear)
//        front = ………………………………;
//	 else ………………………………;
//        return firstElement;
//    }
//
//    /** Add a new element at the end of the queue */
//    public void enqueue(E e) {
//        ensureCapacity();
//        if (………………………………………………………………………………………) {
//            data[0] = e;
//		 ………………………………;
//
//        } else {
//		………………………………;
//            data[rear] = ………………………………;
//            if (front == -1) ………………………………;
//        }
//    }
//    /** Create a new larger array, double the current size + 1 */
//    private void ensureCapacity() {
//        int size = size();
//        if (………………………………) {
//            int newSize = 2 * size;
//            E[] newData = (E[])(new Object[newSize]);
//            if (front <= rear)
//                System.arraycopy(data, …………, newData, …………, …………);
//            else { // (rear < front)
//                System.arraycopy(data, …………, newData, …………, …………);
//                System.arraycopy(data, …………, newData, …...…………, ……..………);
//                front ………………………………;
//            }
//            data = newData;
//        }
//    }
//
//    public boolean isEmpty() { return front == -1; }
//
//    public int size() {
//        if (isEmpty()) return 0;
//        if (front <= rear) return ………………………………;
//        return size();
//    }
//
//    public void clear() {
//        data = (E[]) new Object[INITIAL_CAPACITY];
//        front = -1;
//        rear = -1;
//    }
//
//    public String toString() {
//        StringBuilder result = new StringBuilder("[");
//
//        if (!isEmpty())
//            for (int i = 0; i < size(); i++) {
//                result.append(data[i].toString());
//                result.append(", "); // Separate two elements with a comma
//            }
//        result.append("]"); // Insert the closing ] in the string
//        return "Queue: " + size() + "/" + data.length + " " + result.toString();
//    }
//
//
//    /** Trims the capacity to current size */
//    public void trimToSize() {
//        int size = size();
//        if (………………………………) {
//            E[] newData = ………………………………………………………………;
//            if (………………………………) {
//                System.arraycopy(data, front, newData, 0, size);
//                front = ………………………………;
//                rear = ………………………………;
//            } else { // (rear < front)
//                System.arraycopy(data, …………, newData, …………, …………);
//                System.arraycopy(data, …………, newData, …………, …………………);
//                front = ………………………………;
//            }
//            data = ………………………………;
//        } // If size == capacity, no need to trim
//    }
//}
