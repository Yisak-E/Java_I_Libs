import java.util.ArrayList;

public class MyQueueDemo {
    public static void main(String[] args) {

        MyArrayQueue<Integer> myArrayQueue = new MyArrayQueue<>();
        myArrayQueue.offer(1);
        myArrayQueue.offer(2);
        myArrayQueue.offer(3);
        myArrayQueue.offer(4);
        myArrayQueue.offer(5);
        System.out.println(myArrayQueue);
        System.out.println(myArrayQueue.poll());
        System.out.println(myArrayQueue.poll());
        System.out.println(myArrayQueue);
        System.out.println(myArrayQueue.offer(7));
        System.out.println(myArrayQueue);
    }
}
