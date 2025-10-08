public class SingleDemo {
    public static void main(String[] args) {
        ILinkedList<Integer> kidyGameScore = new ILinkedList<>();
        kidyGameScore.add(98);
        kidyGameScore.add(99);
        kidyGameScore.add(89);
        kidyGameScore.add(88);
        kidyGameScore.add(89);
        kidyGameScore.add(90);
        kidyGameScore.add(91);
        kidyGameScore.add(92);
        kidyGameScore.add(93);
        kidyGameScore.add(94);
        kidyGameScore.add(95);
        kidyGameScore.add(96);

        System.out.println("Score bords");
            System.out.println(kidyGameScore.size());
            System.out.println(kidyGameScore.toString());
        System.out.println("Middle: "+ kidyGameScore.getMiddle());

        System.out.println("First: "+ kidyGameScore.getFirst());
        System.out.println("Last: "+ kidyGameScore.getLast());



        System.out.println("After adding the first and the last element");
        kidyGameScore.addFirst(100);
        kidyGameScore.addLast(106);
        System.out.println(kidyGameScore.toString());


    }
}
