package arithmetic.sort;

import java.util.Random;

/**
 *  基数排序：将要排序的元素按 ”位“ 进行排序（排序算法必须是稳定的排序算法），适合数据规模大且数据范围大
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr00 = new int[50000000];
       // int[] arr01 = new int[50000000];

        for (int i = 0; i < arr00.length; i++) {
            int temp = new Random().nextInt(45000000);
            arr00[i] = temp;
          //  arr01[i] = temp;

        }
        long t1 = System.currentTimeMillis();
        radixSort(arr00);
        long t2 = System.currentTimeMillis();
        System.out.println("自己实现耗时：" +(t2-t1));
    }
    /**
     * 基数排序
     *
     * @param arr
     */
    public static void radixSort(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // 从个位开始，对数组arr按"指数"进行排序
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    /**
     * 计数排序-对数组按照"某个位数"进行排序
     *
     * @param arr
     * @param exp 指数
     */
    public static void countingSort(int[] arr, int exp) {
        if (arr.length <= 1) {
            return;
        }

        // 计算每个元素的个数
        int[] c = new int[10];
        for (int i = 0; i < arr.length; i++) {
            c[(arr[i] / exp) % 10]++;
        }

        // 计算排序后的位置
        for (int i = 1; i < c.length; i++) {
            c[i] += c[i - 1];
        }

        // 临时数组r，存储排序之后的结果
        int[] r = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            r[c[(arr[i] / exp) % 10] - 1] = arr[i];
            c[(arr[i] / exp) % 10]--;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = r[i];
        }
    }
}
