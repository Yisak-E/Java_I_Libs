public class TestArrayList {
    public static void main(String[] args) {
        MyArrayList<Integer> nums = new MyArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(0);
        nums.add(0);
        nums.add(0);

        System.out.println(nums.toString());

        System.out.println("after reserving order");
        nonZeroToRightReserveOrder(nums);
        System.out.println(nums.toString());
    }

    public static void nonZeroToRightReserveOrder(MyArrayList <Integer> lists){
        int leftPointer = lists.size()-2;
        int rightPointer = lists.size() - 1;


        //if both are pointing within the array
        while (leftPointer >= 0 && rightPointer >=0){//
            while (leftPointer >= 0 && lists.get(leftPointer) == 0  ){

                leftPointer--;
            }
            while (rightPointer >= 0 && lists.get(rightPointer) != 0 ){
                rightPointer--;
            }
            while(rightPointer >=0 && leftPointer >= 0 && lists.get(leftPointer) != 0 && lists.get(rightPointer) == 0 ) {
                lists.set(rightPointer, lists.get(leftPointer));
                lists.set(leftPointer, 0);
                System.out.println(lists.toString());
            }
        }
    }


    public static void moveNonZerosToRightPreserveOrder(MyArrayList<Integer> lists) {
        int size = lists.size();
        int insertPos = size - 1;

        // First pass: copy non-zero elements to the end in reverse
        for (int i = size - 1; i >= 0; i--) {
            if (lists.get(i) != 0) {
                lists.set(insertPos--, lists.get(i));
            }
        }

        // Second pass: fill the rest with zeros
        for (int i = insertPos; i >= 0; i--) {
            lists.set(i, 0);
        }

        System.out.println(lists.toString());
    }




    public static void nonZeroToRightOrderNotReserved(MyArrayList <Integer> lists){
        int leftPointer = 0;
        int rightPointer = lists.size() -1;
        while (leftPointer < rightPointer){
            while(lists.get(rightPointer) != 0 && rightPointer >= 0){
                rightPointer--;
            }
            while(lists.get(leftPointer) == 0 && leftPointer < rightPointer){
                leftPointer++;
            }
            if(lists.get(rightPointer) == 0 && lists.get(leftPointer) != 0){
                lists.set(rightPointer, lists.get(leftPointer));
                lists.set(leftPointer, 0);
                rightPointer--;
                leftPointer++;
            }
        }
    }
}