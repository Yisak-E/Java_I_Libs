import java.util.*;

/**
 * Algorithm5.1: Given a queue Q, you are requested to reverse the order in Q using an additional data
 * structure object.
 * Algorithm5.2: Write a method that receive two stacks’ objects S1 and S2. The method returns true if the
 * two stacks are identical, false otherwise. The two stacks should be unchanged when the method
 * terminates.
 * Algorithm5.3: Re-do exercise 5.2 for a queue
 * Algorithm5.4: Update the third element in the queue with a new value VAL, leaving the queue
 * unchanged
 * Algorithm5.5: Update the third element in the queue with a new value VAL, leaving the queue
 * unchanged.?
 * Algorithm5.6: Given a stack of elements S1, you are requested to create an exact copy of S1 leaving S1
 * unchanged. Use only the stack predefined methods and an additional data structure object.
 */
public class Algo5 {
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {

       while(true){
           menu();
          int choice =  choice();
          switch(choice){
              case 1: reverser(); break;
              case 2: compareTwoStacks();break;

          }


       }

    }

    public boolean checkStacksEquality(Stack<Integer> s1, Stack<Integer> s2){
        Stack<Integer> bigStack = new Stack<>();
        if(s1.size() != s2.size())
            return false;
        for(int i=0;i<s1.size();i++){
            if(!s1.get(i).equals(s2.get(i)))
                return false;
        }
        return true;
    }

    public static void reverser(){
        Queue<String> q = new LinkedList<>();

        while(true){
            System.out.print("Enter queue id:(e -to end)");
             String input = scan.nextLine();
             if(input.equalsIgnoreCase("e")){
                 break;
             }
             q.add(input);
        }
        LinkedList<String> st = new LinkedList<>();

        //lines
        dashLine(40);

        while(q.size()-1>=0){
            st.addFirst(q.poll());
            System.out.println(st);
        }
        System.out.println("reversed number: "+ st);
        dashLine(40);
    }

    public static void menu(){
        System.out.println("Menu for Algorithm 5 ");
        System.out.println("1. Reverse the Queue: ");
        System.out.println("2. compare two stacks: ");
        System.out.println("3. compare two queues: ");
        System.out.println("4. update the third stack element value: ");
        System.out.println("5. update the third queue element value: ");
        System.out.println("6. create exact copy of the given stack: ");
        System.out.println("0. Exit the system: ");
    }

    public static int choice(){
        int choice = 0;
        try{
            System.out.print("Enter you selection: ");
            choice = scan.nextInt();

        }catch(InputMismatchException e){
            System.out.println("Please enter a valid choice");
        }finally{
            scan.nextLine();//consume line
        }
        return choice;
    }
    public static void dashLine(int num){
        for (int i = 0; i < num; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void compareTwoStacks(){
        System.out.println("Now on please Enter stack One elements ");
        System.out.println("To stop enter e");
        Stack<String> s1 = new Stack<>();
       while(true){
           String input = scan.nextLine();
           if(input.equalsIgnoreCase("e")){
               break;
           }else{
               s1.push(input);
           }
       }
        System.out.println("Now on please Enter stack Two elements ");
       System.out.println("To stop enter e");
       Stack<String> s2 = new Stack<>();
       while(true){
           String input = scan.nextLine();
           if(input.equalsIgnoreCase("e")){
               break;
           }
           s2.push(input);
       }

       Stack<String> bigStack = new Stack<>();
       if(s1.size() != s2.size()){
           System.out.println("Stacks are not equal");
       }else{
           for (int i = 0; i < s1.size(); i++) {
               if(!s1.peek().equals(s2.peek())){
                   System.out.println("Stacks are not equal");
                   break;
               }
               else{
                   bigStack.push(s1.pop());
                   bigStack.push(s2.pop());
                   if(i == s1.size()-1){
                       System.out.println("Stacks are  equal");
                   }
               }
           }
           for (int i = 0; i < bigStack.size(); i++) {
             if(i%2==0){
                 s1.push(bigStack.pop());
             }else{
                 s2.push(bigStack.pop());
             }
           }
       }
       dashLine(Math.max(s1.size(), s2.size())*2);
        System.out.println("Stack one: "+ s1);
       System.out.println("Stack two: "+ s2);
        dashLine(Math.max(s1.size(), s2.size())*2);

    }
}
