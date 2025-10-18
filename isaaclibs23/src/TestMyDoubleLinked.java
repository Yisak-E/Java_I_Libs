public class TestMyDoubleLinked {
    public static void main(String[] args) {
        MyDoubleLinked<Integer> myLinked = new MyDoubleLinked<>();
        myLinked.add(1);
        myLinked.add(2);
        myLinked.add(3);
        myLinked.add(4);

        System.out.println(myLinked);
        MyDoubleLinked.Node<Integer> lastNode = myLinked.tail;
        while(lastNode != null){
            System.out.println(lastNode.data);
            lastNode = lastNode.prev;
        }
    }
}
