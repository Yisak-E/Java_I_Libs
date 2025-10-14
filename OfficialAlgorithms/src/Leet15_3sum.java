import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet15_3sum {
    public static void main(String[] args) {
        Solution solution = new Solution();
         int[] testOne ={-1,0,1,2,-1,-4};
        System.out.println(Arrays.toString(testOne));


        List<List<Integer>> list = solution.threeSum(testOne);
        System.out.println("answer part");
        System.out.println( Arrays.toString(list.toArray()));

        int[] testTwo = {0,0,0,0};
        System.out.println(Arrays.toString(testTwo));
        List<List<Integer>> list2 = solution.threeSum(testTwo);
        System.out.println("answer part");
        System.out.println( Arrays.toString(list2.toArray()));

        int[]  testThree = {-100,-70,-60,110,120,130,160};
        System.out.println(Arrays.toString(testThree));
        List<List<Integer>> list3 = solution.threeSum(testThree);
        System.out.println("answer part");
        System.out.println( Arrays.toString(list3.toArray()));

        int[] testFour = {-2,0,1,1,2};
        System.out.println(Arrays.toString(testFour));
        List<List<Integer>> list4 = solution.threeSum(testFour);
        System.out.println("answer part");
        System.out.println( Arrays.toString(list4.toArray()));

        int[] testFive = {2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10};
        System.out.println(Arrays.toString(testFive));
        List<List<Integer>> list5 = solution.threeSum(testFive);
        System.out.println("sorted"+ Arrays.toString(testFive));
        System.out.println("answer part");
        System.out.println( Arrays.toString(list5.toArray()));

    }
}



class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int left = 0;
        int right = 2;
        int pointer = 1;
        while(left < nums.length-2){

            int sum = nums[left] + nums[right] +nums[pointer];
            List<Integer>  temp = Arrays.asList(nums[left],nums[pointer],nums[right]);

            if(sum == 0 && !previouslyExist(list, temp)){
                list.add(temp);
            }

            if(pointer == nums.length-2){
                left++;
                pointer = left+1;
            }

            right++;

            if(right == nums.length){
                if(pointer < nums.length-2){
                    pointer++;
                }
                right = pointer;
            }

        }


        return list;
    }



    public boolean  previouslyExist(List<List<Integer>> mainlist, List<Integer> list) {
        for(List<Integer> l : mainlist){
            if(l.getFirst().equals(list.getFirst())
                    && l.getLast().equals(list.getLast()) && l.get(1).equals(list.get(1))){
                return true;
            }
        }
        return false;
    }
}