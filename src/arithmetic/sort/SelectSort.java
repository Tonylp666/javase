package arithmetic.sort;

import java.util.Arrays;

/**
 * 选择排序，不稳定，排序分为已排序区间和未排序区间，每次从未排序区间选择最小的元素插入到已排序区间的后面。
 */
public class SelectSort {
    public static void main(String[] args) {
        SelectSort selectSort = new SelectSort();

        int[] arr = {9,3,5,4,1,8,6};
        System.out.println(Arrays.toString(arr));
        selectSort.selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public void selectSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            int temp = arr[i];
            int temp0 = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < temp){
                    temp = arr[j];
                    temp0 = j;
                }
            }
            arr[temp0] = arr[i];
            arr[i] = temp;
            System.out.println(Arrays.toString(arr));
        }
    }

}
