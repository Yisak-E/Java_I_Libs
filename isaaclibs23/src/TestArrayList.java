public class TestArrayList {
    public static void main(String[] args) {
        MyArrayList<Integer> nums = new MyArrayList<>();
        nums.add(3);
        nums.add(0);
        nums.add(-5);
        nums.add(0);
        nums.add(1);
        nums.add(0);
        nums.add(0);
        nums.add(8);
        MyArrayList<Integer> nums2 = nums.clone();
        System.out.println(nums.toString());

        System.out.println("Without reserving the order");
        nonZeroToRightOrderNotReserved(nums);
        System.out.println(nums.toString());

        System.out.println("after reserving order");
        nonZeroToRightReserveOrder(nums);
        System.out.println(nums.toString());
    }

    public static void nonZeroToRightReserveOrder(MyArrayList <Integer> lists){
        int leftPointer = lists.size()-2;
        int rightPointer = lists.size() - 1;


        //if both are pointing within the array
        while (leftPointer >= 0 && rightPointer >=0){

            /** @parram leftPointer
             * the left pointer is pointing zero
             * until it point non-zero digit
             */
            while (leftPointer >= 0 && lists.get(leftPointer) == 0  ){
                leftPointer--;
            }
            while (rightPointer >= 0 && lists.get(rightPointer) != 0 ){
                rightPointer--;
            }

            /** @parram rightPointer
             * the roght pointer is pointing non-zero
             * until it point zero digit
             */
            if(rightPointer >=0 && leftPointer >= 0 && lists.get(leftPointer) != 0 && lists.get(rightPointer) == 0 ) {
                lists.set(rightPointer, lists.get(leftPointer));
                lists.set(leftPointer, 0);
                System.out.println(lists.toString());
                leftPointer--;
                rightPointer--;
            }
            else{
                break;
            }
        }
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