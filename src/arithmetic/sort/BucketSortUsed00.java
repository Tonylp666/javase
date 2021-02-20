package arithmetic.sort;

import java.io.*;

public class BucketSortUsed00 {
    public static void main(String[] args) throws IOException {

    }

    public static void bucketSort(String filePath, int bucketSize,String resultPath) throws IOException {

        // todo 这里仅仅获取一下最大最小值，但是却扫描了一遍大文件，需要优化了。
        // 数组最小值
        int minValue = Integer.MAX_VALUE;
        // 数组最大值
        int maxValue = Integer.MIN_VALUE;

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
        String line = null;
        while ((line = reader.readLine()) != null){
            int num = Integer.parseInt(line);
            if (num < minValue) {
                minValue = num;
            } else if (num > maxValue) {
                maxValue = num;
            }
        }

        // 桶数量
        int bucketCount = (maxValue - minValue) / bucketSize + 1;

        //各个桶路径，因为大数据量不能放在内存中，因此将其写道外存。
        String[] bucketsPath = new String[bucketCount];
        FileWriter[] fw = new FileWriter[bucketCount];
        for (int i = 0; i < bucketCount; i++) {
            bucketsPath[i] = resultPath+"-"+i;
            File f = new File(bucketsPath[i]);
            if(!f.exists())
                f.createNewFile();
             fw[i] = new FileWriter(f,true);
        }

        // 这个数组记录每个桶里有多少个元素
        int[] indexArr = new int[bucketCount];

        // 将数组中值分配到各个桶里
        reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
        line = null;
        while ((line = reader.readLine()) != null){
            int num = Integer.parseInt(line);
            int bucketIndex = (num - minValue) / bucketSize;

            fw[bucketIndex].write(line +"\r\n");

            indexArr[bucketIndex]++;
        }
        for (int i = 0; i < bucketCount; i++) {
            fw[i].flush();
            fw[i].close();
        }
        reader.close();


        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(resultPath)));
        // 对每个桶进行排序，这里使用了快速排序
        int k = 0;
        for (int i = 0; i < bucketsPath.length; i++) {
            if (indexArr[i] == 0) {
                continue;
            }
            // todo 这里使用多线程来做
            quickSort00(bucketsPath[i]);

            // 将 某个分桶中的元素使用快排排序, 因为这里需要保持顺序性，因此只能单线程。
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(bucketsPath[i])));

            while ((line = reader.readLine()) != null){
               int num = Integer.parseInt(line);
                writer.write(num+"\r\n");
            }
            reader.close();
        }
        writer.flush();
        writer.close();
    }

    // todo 同样，这里也是，为了获取最大最小值，扫描了一遍文件，需要优化 目前的优化方向是使用 Java api 获取总行数 @link{quickSort00}
    private static void quickSort(String path) throws IOException {
        // 数组最小值
        int minValue = Integer.MAX_VALUE;
        // 数组最大值
        int maxValue = Integer.MIN_VALUE;
        int count = 0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
        String line = null;
        while ((line = reader.readLine()) != null){
            count ++;
            int num = Integer.parseInt(line);
            if (num < minValue) {
                minValue = num;
            } else if (num > maxValue) {
                maxValue = num;
            }
        }
        reader.close();
        int[] arr = new int[count];
        reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
        line = null;
        int k = 0;
        while ((line = reader.readLine()) != null){
            int num = Integer.parseInt(line);
            arr[k++] = num;
        }
        quickSortC(arr, 0, count - 1);

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path)));
        // 对每个桶进行排序，这里使用了快速排序
        for (int i = 0; i < arr.length; i++) {
            writer.write(arr[i]+"\r\n");
        }
        writer.flush();
        writer.close();
    }

    private static void quickSort00(String path) throws IOException {
        FileReader fileReader = new FileReader(new File(path));
        LineNumberReader numberReader = new LineNumberReader(fileReader);
        numberReader.skip(Long.MAX_VALUE);
        int count = numberReader.getLineNumber();

        int[] arr = new int[count];
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
        String line = null;
        int k = 0;
        while ((line = reader.readLine()) != null){
            int num = Integer.parseInt(line);
            arr[k++] = num;
        }
        quickSortC(arr, 0, count - 1);

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path)));
        // 对每个桶进行排序，这里使用了快速排序
        for (int i = 0; i < arr.length; i++) {
            writer.write(arr[i]+"\r\n");
        }
        writer.flush();
        writer.close();
    }

    /**
     * 数组扩容, 这里需要注意，在 Java 语言中，二维数组中的不同一维数组长度可以不相同。
     *
     */
    private static void ensureCapacity(int[][] buckets, int bucketIndex) {
        int[] tempArr = buckets[bucketIndex];
        int[] newArr = new int[tempArr.length * 2];
        for (int j = 0; j < tempArr.length; j++) {
            newArr[j] = tempArr[j];
        }
        buckets[bucketIndex] = newArr;
    }

    private static void quickSortC(int[] arr, int p, int r) {
        if (p >= r) {
            return;
        }

        int q = partition(arr, p, r);
        quickSortC(arr, p, q - 1);
        quickSortC(arr, q + 1, r);
    }

    private static int partition(int[] arr, int p, int r) {
        int pivot = arr[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }

        swap(arr, i, r);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
