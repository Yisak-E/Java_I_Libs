/**
 * Demonstrates the usage of the MyPriorityQueue class using both
 * natural ordering (MyComparable) and custom ordering (MyComparator).
 */
public class MyPriorityQueueDemo {
    // A simple class to satisfy the MyComparable requirement for MyPriorityQueue
    static class MyString implements MyComparable<MyString> {
        String value;
        MyString(String v) { this.value = v; }
        @Override
        public int compareTo(MyString other) {
            return this.value.compareTo(other.value); // Natural (alphabetical) order
        }
        @Override
        public String toString() { return value; }
        // Needed for equals check if implemented in abstract classes
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MyString myString = (MyString) o;
            return value.equals(myString.value);
        }
    }

    public static void main(String[] args) {
        // --- Test 1: Natural Ordering (Min-Heap) ---
        MyPriorityQueue<MyString> queue1 = new MyPriorityQueue<>();
        queue1.offer(new MyString("Oklahoma"));
        queue1.offer(new MyString("Indiana"));
        queue1.offer(new MyString("Georgia"));
        queue1.offer(new MyString("Texas"));

        System.out.println("Priority queue using Comparable (Min-Heap):");
        while (!queue1.isEmpty()) {
            System.out.print(queue1.remove() + " ");
        }
        // Expected Output: Georgia Indiana Oklahoma Texas

        // --- Test 2: Custom Ordering (Max-Heap using reverseOrder comparator) ---
        MyPriorityQueue<MyString> queue2 = new MyPriorityQueue<>(
                4, (MyComparator<MyString>) (a, b) -> b.compareTo(a));

        queue2.offer(new MyString("Oklahoma"));
        queue2.offer(new MyString("Indiana"));
        queue2.offer(new MyString("Georgia"));
        queue2.offer(new MyString("Texas"));

        System.out.println("\n\nPriority queue using Comparator (Max-Heap):");
        while (!queue2.isEmpty()) {
            System.out.print(queue2.remove() + " ");
        }
        // Expected Output: Texas Oklahoma Indiana Georgia
        System.out.println();
    }
}
