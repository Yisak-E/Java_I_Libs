public class DoublyDemo {
    public static void main(String[] args) {
        IDoubblyLinked<Integer> ans = new  IDoubblyLinked<>();
        ans.add(67);
        ans.add(60);
        ans.add(61);
        ans.add(62);
        ans.add(63);
        ans.add(3, 65);
        System.out.println(ans.toString());
    }
}
