package final_exam_pre.sorting;

import java.util.Arrays;

public class SelectionSortDemo {
    public static void main(String[] args) {
        //36, 24, 10, 6, 12
        int[] arr ={36, 24, 10, 6, 12};
        System.out.println("Before sorting: " + Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("After sorting: " + Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for(int j = i; j < arr.length ; j++){
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            if(minIndex != i){
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
}
