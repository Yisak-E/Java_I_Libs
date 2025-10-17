public class TestAct5 {
    public static void main(String[] args) {
        Act5<Integer> a = new Act5<>();

        for (int i = 0; i < 20 ; i++) {
            a.enqueue(i*9);
        }

        System.out.println(a.toString());

        for  (int i = 0; i < 10; i++) {
            System.out.println("after dequeue: "+ a.Dequeue());
            System.out.println(a.toString());
        }
        a.trimToSize();
        System.out.println("after trim to size");
        System.out.println(a.toString());
    }
}
