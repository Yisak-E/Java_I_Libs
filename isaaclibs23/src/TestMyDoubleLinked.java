public class TestMyDoubleLinked {
    public static void main(String[] args) {
        MyDoubleLinked<Integer> myLinked = new MyDoubleLinked<>();
        myLinked.add(1);
        myLinked.add(2);
        myLinked.add(3);
        myLinked.add(4);
        myLinked.add(5);
        myLinked.add(6);
        myLinked.add(7);
        myLinked.add(8);
        myLinked.add(9);

        System.out.println(myLinked);
        myLinked.removeAllEvens();
        System.out.println(myLinked);



    }
}
