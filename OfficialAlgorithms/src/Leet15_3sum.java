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


    }
}
/**
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int j = 2;
        int i=0;
        while(i < nums.length-2) {
            if( j < nums.length && nums[i]+ nums[j-1] + nums[j] == 0){
                List<Integer> part = Arrays.asList(nums[i], nums[j-1], nums[j] );
                if(!previouslyExist(ans, part)){
                    ans.add(part);
                }

            }
            if(j == nums.length-1){
                i++;
                j=i+1;
            }
            j++;
        }

        return ans;

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
*/


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int left = 0;
        int right = nums.length-1;
        int pointer = 0;
        //[-1,0,1,2,2,-1,-4]
        while(right> left +1){
           if(pointer < right){
               int sum = nums[left] + nums[pointer] + nums[right];
               if(sum == 0){
                   if( !previouslyExist(list, Arrays.asList(nums[left], nums[pointer], nums[right]))){
                       list.add(Arrays.asList(nums[left],nums[pointer],nums[right]));
                   }

               }
           }
          if(pointer == right-1){
               pointer = left;
               right--;
           }
           pointer++;

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