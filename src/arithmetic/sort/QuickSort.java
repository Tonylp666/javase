package arithmetic.sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();

    }

    // 快速排序，a是数组，n表示数组的大小
    public static void quickSort(int[] a) {
        quickSort(a, 0, a.length-1);
    }

    private static void quickSort(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex)return;
        int left = leftIndex;
        int right = rightIndex;
        int target = arr[right];

        while (left < right){

            while (left < right && arr[left] <= target){
                left++;
            }
            arr[right] = arr[left];

            while (left < right && arr[right] >= target){
                right--;
            }
            arr[left] = arr[right];

            arr[right] = target;
        }
        quickSort(arr, leftIndex, right-1);
        quickSort(arr, right+1, rightIndex);
    }

}
