package arithmetic.sort;

import java.util.Arrays;

/**
 * 归并排序，分治思想
 */
public class MergeSort {

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();

        int[] arr = {9,3,5,4,1,8,6};
        System.out.println(Arrays.toString(arr));
        mergeSort.mergeSort(arr);
        System.out.println(Arrays.toString(arr));

    }
    public void mergeSort(int[] arr){
        int length = arr.length;
        mergeSort(arr,0,length - 1);
    }

    private void mergeSort(int[] arr, int start, int end) {
        if (end <= start) return;
        int middle = start + (end - start)/2;
        mergeSort(arr, start, middle);
        mergeSort(arr, middle + 1, end);
        merge(arr,start,middle,end);
        System.out.println(Arrays.toString(arr));
    }

    private void merge(int[] arr, int start, int middle, int end) {
        int i = start,j = middle+1,k = 0;
        int[] temp = new int[end - start + 1];
        while (i <= middle && j <= end){
            // 这里的 == 是为了稳定性。
            if (arr[i] <= arr[j] ){
                temp[k++] = arr[i++];
            }else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= middle){
            temp[k++] = arr[i++];
        }

        while ( j <= end){
            temp[k++] = arr[j++];
        }

        for (int l = 0; l < temp.length; l++) {
            arr[start+l] = temp[l];
        }

    }

}
