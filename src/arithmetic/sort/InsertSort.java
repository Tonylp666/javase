package arithmetic.sort;

import java.util.Arrays;
import java.util.Random;

/**
 *  插入排序，稳定的排序算法，时间复杂度：O(n^2),空间复杂度：O(1)
 */
public class InsertSort {
    public static void main(String[] args) {
        InsertSort sort = new InsertSort();

    }

    public void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int index = i;
            int temp = arr[i];
            for (int j = i-1; j >= 0; j--) {
                if (arr[j] > temp){
                    arr[index] = arr[j];
                }else {
                    break;
                }
                index = j;
            }
            arr[index] = temp;
        }
    }

}
