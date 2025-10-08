import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tester {
    public static void main(String[] args) {
        SubSet ss = new SubSet();
        List<Integer> set1 = Arrays.asList(1, 2, 3);
        List<Integer> set2 = Arrays.asList(1, 1);
        System.out.println(ss.isSubSet_using_two_sort(set1, set2));
        System.out.println("using set one sort and binary search: ");
        System.out.println(ss.IsSubSet_using_binarySearch(set1, set2));
        System.out.println("Using HashSet: "+ ss.isSubSet_using_Hash(set1, set2));
    }
}
