package final_exam_pre.sorting;

import java.util.Arrays;

public class HeapSortDemo {
    public static void main(String[] args) {
        int[] arr = {21, 10, 15, 88, 95, 5};
        System.out.println("Before sorting : " + Arrays.toString(arr));
        heapSort(arr, arr.length);
        System.out.println("After sorting : " + Arrays.toString(arr));


    }
    /*
    * 21, 10, 15, 88, 95, 5
    * reheap(arr, root=2, len=5)
    * lft = 5, rgt = 6, max
    * if (lft(5) <= len(5)) -> if (5 = 5)?  max = lft :
    *   { if(lft_val <= rgt_val ? max = rgt : max = lft}
    * if ( root_val(15) < max_val(5)-> no swap and reheap
    *
    * reheap(arr, root=2, len=5)
    * */


    public static void heapSort(int[] arr, int size) {
        int index;
        // first heaping
        for (index = size/2 - 1; index >= 0; index--) {
            reHeapDown(arr, index, size-1);
        }

        // sort the array
        for (int i = size-1; i > 0; i--) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            reHeapDown(arr, 0, i-1);
        }

    }

    public static void reHeapDown(int[] arr, int root, int bottom) {
        int maxChild;
        int leftChild = root *2+1;
        int rightChild = root *2+2;

        if (leftChild <= bottom){
            if (leftChild == bottom){
                maxChild = leftChild;
            }else{
                if (arr[leftChild] > arr[rightChild]){
                    maxChild = leftChild;
                }else{
                    maxChild = rightChild;
                }
            }

            if(arr[root] <  arr[maxChild]){
                int temp = arr[root];
                arr[root] = arr[maxChild];
                arr[maxChild] = temp;
                reHeapDown(arr, maxChild, bottom);
            }
        }


    }
}
