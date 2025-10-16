public class TestArrayList {
    public static void main(String[] args) {
        MyArrayList<Integer> nums = new MyArrayList<>();
        nums.add(3);
        nums.add(5);
        nums.add(7);
        System.out.println(nums.toString());
    }
}