package final_exam_pre.sorting;

import java.util.Arrays;

public class InsertionSortDemo {
    public static void main(String[] args) {
        int[] array = {21, 10, 15, 88, 95, 5};
        System.out.println("Before sorting : " + Arrays.toString(array));
        insertionSort(array);
        System.out.println("After sorting : " + Arrays.toString(array));

    }
    public static void insertionSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int key = arr[i];
            int j = i -1;
            while(j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
}
