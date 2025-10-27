package stackrelated;

import java.util.ArrayList;
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

}
