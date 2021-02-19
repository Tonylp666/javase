package arithmetic.backtrack;

import java.util.Arrays;

public class EightQueens02 {
    public static void main(String[] args) {
        EightQueens02 eightQueens02 = new EightQueens02();
        long start = System.currentTimeMillis();

        int i = eightQueens02.eightQueens(n);
        //long end = System.currentTimeMillis();
        System.out.println("n = " + n + "\t 耗时： " + (System.currentTimeMillis() - start));
        System.out.println(i);
    }
    static int sum = 0;
    static int n = 18;
    public int eightQueens(int n){

        int[]  queens = new int[n];
        Arrays.fill(queens,-1);
        backTrace(queens,0);

        return sum;
    }

    private void backTrace(int[] queens, int no) {
        if (no == n){
            sum ++;
            System.out.println(Arrays.toString(queens));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (canFill(queens,i,no)){
                queens[no] = i;
                backTrace(queens,no+1);
            }
        }
    }

    private boolean canFill(int[] queens,int col,int no) {
        for (int i = 0; i < no; i++) {
            if (queens[i] == col || Math.abs(no - i) == Math.abs(col - queens[i])){
                return false;
            }
        }
        return true;
    }
}
