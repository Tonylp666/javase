package arithmetic.sort;

import java.util.Arrays;
import java.util.Random;

/**
 *  自己实现桶排序
 */
public class BucketSortMyself {
    public static void main(String[] args) {

    }

    public void bucketSort(int[] arr,int bucketSize){
        //获取数组中的最大值
        int maxValue = max(arr);
        //获取数组中的最小值
        int minValue = min(arr);
        //得到桶的数量
        int bucketCount = (maxValue - minValue)/bucketSize + 1;

        //定义一个存储各个桶中数据量的数组
        int[] bucketEleNums = new int[bucketCount];

        //定义一个二维数组，存储各个桶中的所有的元素
        int[][] elements = new int[bucketCount][bucketSize];

        //将原数组中的所有元素分桶存储
        for (int i = 0; i < arr.length; i++) {
            // 1、 确定该元素应该在那个桶，采用 hash 法
            int bucket_no = hash(arr[i],minValue,bucketSize);
            //2、 将元素存到对应的桶中,这里由于可能出现数据分布不规律，会导致每个桶数据规模不一致，故需要考虑到扩容；
            if (bucketEleNums[bucket_no] == elements[bucket_no].length){
                ensureCapacity(elements,bucket_no);
            }
            elements[bucket_no][bucketEleNums[bucket_no] ++] = arr[i];
        }

        //将各个桶内的数据进行排序，此时采用快排
        for (int i = 0; i < elements.length; i++) {
            quickSort(elements[i],0,bucketEleNums[i] - 1);
        }

        //将排好序的各个分桶里的元素重新拷贝到arr 中
        int k = 0;

        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < bucketEleNums[i]; j++) {
                arr[k++] = elements[i][j];
            }
        }

    }

    private void ensureCapacity(int[][] elements, int bucket_no) {
        int[] oldArr = elements[bucket_no];
        int[] newArr = new int[oldArr.length * 2];
        for (int i = 0; i < oldArr.length; i++) {
            newArr[i] = oldArr[i];
        }
        elements[bucket_no] = newArr;
    }

    private int hash(int element,int minValue,int bucketSize){
        return (element - minValue)/bucketSize;
    }

    private int max(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    private int min(int[] arr){
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }

    public  void quickSort(int[] a) {
        quickSort(a, 0, a.length-1);
    }

    private  void quickSort(int[] arr, int leftIndex, int rightIndex) {
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
