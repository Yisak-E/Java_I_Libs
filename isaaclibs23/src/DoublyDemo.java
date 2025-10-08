public class DoublyDemo {
    public static void main(String[] args) {
        IDoubblyLinked<Integer> ans = new  IDoubblyLinked<>();
        ans.add(67);
        ans.add(65);
        ans.add(65);
      ans.removeLast();
        System.out.println(ans.toString());
    }
}
