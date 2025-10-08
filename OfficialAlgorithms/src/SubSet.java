import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubSet{
    public SubSet() {}
    public boolean isSubSet_using_two_sort(List<Integer> s1, List<Integer>  s2) {
        Collections.sort(s1);
        Collections.sort(s2);
        int i = 0, j = 0;
        while (i < s1.size() && j < s2.size()) {
            if (s1.get(i).equals(s2.get(j))) {
                j++;
            }
            i++;
        }
        return j == s2.size();
    }

    public boolean IsSubSet_using_binarySearch(List<Integer> s1, List<Integer> s2) {
        Collections.sort(s1);
        boolean isFound = true;

        for(Integer i : s2){
            if(!BinarySearch(s1, i)){
                isFound = false;
            }
        }
        return isFound;
    }

    private boolean BinarySearch(List<Integer> s1, Integer i) {
        int left = 0;
        int right = s1.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(s1.get(mid).equals(i)){
                return true;
            }
            else if(s1.get(mid).compareTo(i) > 0){
                right = mid - 1;
            }
            else if(s1.get(mid).compareTo(i) < 0){
                left = mid + 1;
            }
        }
        return false;
    }

    public boolean isSubSet_using_Hash(List<Integer> s1, List<Integer> s2) {
        Set<Integer> set1 = new HashSet<>(s1);
        Set<Integer> set2 = new HashSet<>(s2);
        return set1.containsAll(set2);
    }

}
