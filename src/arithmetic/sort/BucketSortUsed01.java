package arithmetic.sort;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * 优化点：在对每个文件排序时，之前需要扫描两边文件，太慢。这里改用 list 集合进行。
 */
public class BucketSortUsed01 {
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
            quickSort(bucketsPath[i]);

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

    private static void quickSort(String path) throws IOException {
        List<Integer> nums = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
        String line = null;

        while ((line = reader.readLine()) != null){
            int num = Integer.parseInt(line);
            nums.add(num);
        }

        Collections.sort(nums);

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path)));
        // 对每个桶进行排序，这里使用了快速排序
        for (int i = 0; i < nums.size(); i++) {
            writer.write(nums.get(i)+"\r\n");
        }
        writer.flush();
        writer.close();
    }

}
