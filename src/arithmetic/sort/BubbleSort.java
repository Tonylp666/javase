package arithmetic.sort;

import java.util.Arrays;
import java.util.Random;

/**
 *  冒泡排序，稳定的排序算法，时间复杂度：O(n^2),空间复杂度：O(1)
 */
public class BubbleSort {
    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();

    }
    public void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length ; j++) {
                if (arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
