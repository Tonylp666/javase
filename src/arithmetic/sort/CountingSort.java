package arithmetic.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 计数排序：如果要排序的数据规模大，范围小，那么我们可以将这些数据中所有可能出现的元素进行计数，然后进行合并。
 * 该种算法不适合存在负数的数据，如果数据存在负数，需要预处理。
 */
public class CountingSort {
    public static void main(String[] args) {

    }
    // 计数排序，a是数组，n是数组大小。假设数组中存储的都是非负整数。
    public static void countingSort(int[] a, int n) {

        int max = a[0];
        for (int i = 1; i < n; i++) {
            if (a[i] > max){
                max = a[i];
            }
        }

        // 构建一个 [0,max] 的数组
        int[] temp = new int[max + 1];

        for (int i = 0; i < n; i++) {
            temp[a[i]] ++;
        }

        // 组装结果
        int k = 0;
        for (int i = 0; i < temp.length; i++) {
            while (temp[i] >0){
                a[k++] = i;
                temp[i]--;
            }
        }
    }

}
