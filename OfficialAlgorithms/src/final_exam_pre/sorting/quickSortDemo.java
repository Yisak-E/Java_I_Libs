package final_exam_pre.sorting;

import java.util.Arrays;

public class quickSortDemo {
    public static void main(String[] args) {
        int[] arr = new int[] {11,2,36,7,8, 34,4,95,56,9};
        System.out.println("Before sorting : " + Arrays.toString(arr));
        quickSort(arr);
        System.out.println("After sorting : " + Arrays.toString(arr));

    }

    public static void quickSort(int[] arr){
        quickSort(arr,0,arr.length-1);
    }
    public static void quickSort(int[] arr, int left, int right){
        if(left<right){
            int pivot = split(arr,left,right);
            quickSort(arr,left,pivot );
            quickSort(arr,pivot + 1,right);
        }
    }

    public static int split(int[] arr, int left, int right){
        int i = left -1;
        int j =  right + 1;
        do{
            do{
                j--;
            }while(arr[left]< arr[j]);

            do{
                i++;
            }while(arr[left]>arr[i]);

            if(i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }while(i < j);
        return j;
    }
}
