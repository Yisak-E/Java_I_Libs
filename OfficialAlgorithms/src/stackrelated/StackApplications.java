package stackrelated;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class StackApplications {
    public static void main(String[] args) {
        System.out.println("Stack Applications");
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(4);
        System.out.println(list);
        Stack<Integer> nums = NextGreaterElement(list);
        System.out.println(nums);

    }

    ///  with time complexity O(n^2)
    public static Stack<Integer> NextGreaterElement(List<Integer> list) {
        Stack<Integer> stack = new Stack<>();
        int first = 0;
        int second = 1;
        while (first < list.size()) {
            if (second < list.size() && list.get(first)< list.get(second)){
                stack.push(list.get(second));
                first++;
                second = first + 1;
            }
            else if (second < list.size()){
                second++;
            }
            else if (second == list.size()){
                stack.push(-1);
                first++;
            }

        }
        return stack;
    }

    ///  with time complexity O(n)
    public static List<Integer> NextGreaterElement2(List<Integer> list) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> list2 = new ArrayList<>(Collections.nCopies(list.size(),-1));

        for (int i = list.size() - 1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek() < list.get(i)){
                stack.pop();
            }
            if(!stack.isEmpty()){
                list2.set(i, stack.peek());
            }
            stack.push(list.get(i));
        }
        return list2;
    }

    //balanced parentheses checker
//  e

}
