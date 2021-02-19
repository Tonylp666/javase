package test;

public class TestDemo02 {
    static int n ;
    public static void main(String[] args) {
        System.out.println((int)Math.pow(2,10));
    }


    // array表示一个长度为n的数组
    // 代码中的array.length就等于n
    int[] array = new int[n];
    int count = 0;

    void insert(int val) {
        if (count == array.length) {
            int sum = 0;
            for (int i = 0; i < array.length; ++i) {
                sum = sum + array[i];
            }
            array[0] = sum;
            count = 1;
        }

        array[count] = val;
        ++count;
    }
}
