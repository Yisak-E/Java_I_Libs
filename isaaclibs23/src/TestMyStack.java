import java.util.Stack;

public class TestMyStack {
    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);

        System.out.println(myStack);
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack);

        System.out.println(isValidParentheses("()[]{}"));
        System.out.println(isValidParentheses("([)]"));
    }

    public static boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        if(s.charAt(0) == ')' ||  s.charAt(0) == ']' || s.charAt(0) == '}' || s.length()%2== 1) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                else {
                    if (stack.peek() == '(' && c == ')'
                    || stack.peek() == '[' && c == ']'
                    || stack.peek() == '{' && c == '}') {
                        stack.pop();
                    }
                    else {
                        return false;
                    }
                }
            }

        }
        if  (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
