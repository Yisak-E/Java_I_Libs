package final_exam_pre.sorting;

import java.util.Arrays;

public class BubbleSortDemo {
    public static void main(String[] args) {
        int[] arr = {21, 10, 15, 88, 95, 5};
        System.out.println("Before sorting : " + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("After sorting : " + Arrays.toString(arr));
    }
    /*21, 10, 15, 88, 95, 5
    * 10, 15, 21, 88, 5, 95
    * 10, 15, 21, 5, 88, 95
    * 10, 15, 5, 21, 88, 95
    * 10, 5, 15, 21, 88, 95
    * 5, 10, 15, 21, 88, 95
    * */


    public static void bubbleSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length - i-1 ; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

    }
}
