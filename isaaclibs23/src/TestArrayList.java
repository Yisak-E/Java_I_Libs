/**
 * Test class for MyArrayList, including a corrected implementation
 * for the non-zero element movement algorithm.
 */
public class TestArrayList {
    public static void main(String[] args) {
        // Elements must be MyComparable for MyArrayList's sort method, but for this
        // simple test we assume Integer is used as a stand-in for a comparable type.
        // NOTE: MyArrayList's generic type K should implement MyComparable for this to compile
        // if using the MyArrayList.sort() method. Since it's a test method, we use Integer.
        // For the uploaded code, we assume Integer implements MyComparable<Integer>.
        MyArrayList<Integer> nums = new MyArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(0);
        nums.add(0);
        nums.add(0);

        MyArrayList<Integer> nums2 = new MyArrayList<>(nums); // Use constructor for clone
        System.out.println("Original: " + nums.toString());

        // Corrected call to the preserved-order algorithm
        System.out.println("\n--- Moving non-zeros to the right, preserving order ---");
        moveNonZerosToRightPreserveOrder(nums2);
        System.out.println("Result: " + nums2.toString());

        MyArrayList<Integer> nums3 = new MyArrayList<>();
        nums3.add(0); nums3.add(1); nums3.add(0); nums3.add(2); nums3.add(0); nums3.add(3);
        System.out.println("\n--- Moving non-zeros to the right, order NOT preserved ---");
        System.out.println("Original: " + nums3.toString());
        nonZeroToRightOrderNotReserved(nums3);
        System.out.println("Result: " + nums3.toString());
    }

    /**
     * Moves all non-zero elements to the right end of the list,
     * maintaining the relative order of the non-zero elements (and the zeros).
     * The list size remains unchanged. Uses O(N) time and O(1) auxiliary space (in-place).
     * @param lists the MyArrayList of Integers to modify.
     */
    public static void moveNonZerosToRightPreserveOrder(MyArrayList<Integer> lists){
        int size = lists.size();
        int insertPos = size - 1; // Position to insert the next non-zero element

        // Iterate from right to left
        for (int i = size - 1; i >= 0; i--) {
            if (lists.get(i) != 0) {
                // If it's non-zero, move it to the current insert position
                lists.set(insertPos--, lists.get(i));
            }
        }

        // Fill the remaining left slots with zeros
        for (int i = insertPos; i >= 0; i--) {
            lists.set(i, 0);
        }
    }


    /**
     * Moves all non-zero elements to the right end of the list.
     * The relative order of non-zero elements is NOT preserved (Two-Pointer Swap).
     * @param lists the MyArrayList of Integers to modify.
     */
    public static void nonZeroToRightOrderNotReserved(MyArrayList <Integer> lists){
        int leftPointer = 0;
        int rightPointer = lists.size() -1;

        while (leftPointer < rightPointer){
            // Find the next element on the right that is a zero
            while(rightPointer >= 0 && lists.get(rightPointer) != 0){
                rightPointer--;
            }

            // Find the next element on the left that is non-zero
            while(leftPointer < lists.size() && lists.get(leftPointer) == 0){
                leftPointer++;
            }

            // If pointers haven't crossed and we found a non-zero on the left
            // and a zero on the right, swap them.
            if(leftPointer < rightPointer){
                // Swap non-zero (left) with zero (right)
                int temp = lists.get(rightPointer);
                lists.set(rightPointer, lists.get(leftPointer));
                lists.set(leftPointer, temp);

                rightPointer--;
                leftPointer++;
            }
        }
    }
}
