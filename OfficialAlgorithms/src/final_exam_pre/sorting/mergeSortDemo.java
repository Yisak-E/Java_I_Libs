package final_exam_pre.sorting;

import java.util.Arrays;

public class mergeSortDemo {
    public static void main(String[] args) {
        int[] arr = { 34, 20, 32, 12, 55, 32, 56, 77, 68, 23};
        System.out.println("Before sorting: " + Arrays.toString(arr));
        mergeSort(arr);
        System.out.println("After sorting: " + Arrays.toString(arr));

    }


    public static void mergeSort(int[] arr){
        mergeSort(arr,0,arr.length-1);
    }
    public static void mergeSort(int[] arr,int left,int right){
        if(left<right){
            int mid = (left+right)/2;
            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,right);
            merge(arr,left,mid,right);
        }

    }
    public static void merge(int[] arr,int left,int mid,int right){
        int i, j, k;
        int[] temp = new int[arr.length];

        for(i = left; i <= right; i++){
            temp[i] = arr[i];
        }

        i = left;
        j = mid+1;
        k = left;
        while(i <= mid && j <= right){
            if(temp[i] <= temp[j]){
                arr[k++] = temp[i++];
            }else{
                arr[k++] = temp[j++];
            }
        }
        while(i <= mid){
            arr[k++] = temp[i++];
        }
        while(j <= right){
            arr[k++] = temp[j++];
        }
    }
}

