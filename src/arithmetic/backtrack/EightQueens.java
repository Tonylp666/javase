package arithmetic.backtrack;

import java.util.Arrays;

/**
 * 在8×8格的国际象棋上摆放八个皇后，使其不能互相攻击，即任意两个皇后都不能处于同一行、同一列或同一斜线上，问有多少种摆法
 */
public class EightQueens {
    int sum = 0;
    long aaa = 0;
    long bbb = 0;
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int n = 14;
        int count = new EightQueens().eightQueens(n);
        System.out.println("n = " + n + "\t 耗时： " + (System.currentTimeMillis() - start));
        System.out.println(count  );
    }


    public int eightQueens(int n){

        boolean[][]  queens = new boolean[n][n];
        backTrace00(queens,0);
        System.out.println("aaa: " + aaa);
        System.out.println("bbb: " +bbb);
        return sum;
    }

    private void backTrace00(boolean[][] queens,int NO_Queen) {
        if (NO_Queen == queens.length){
            sum ++;

            return;
        }
        for (int i = 0; i < queens.length; i++) {
            if (preAllFalse(queens,i)){continue;}
            for (int j = 0; j < queens[0].length; j++) {
                if (!queens[i][j] && canFill(queens,i,j)){
                    queens[i][j] = true;
                    backTrace00(queens, NO_Queen+1);
                    queens[i][j] = false;
                    continue;
                }
            }
        }
    }

    private void backTrace01(boolean[][] queens,int NO_Queen) {
        if (NO_Queen == queens.length){
            sum ++;
            //printQueens(queens);
            return;
        }

        for (int i = 0; i < queens.length; i++) {
            if (canFill(queens,NO_Queen,i)){
                queens[NO_Queen][i] = true;
                backTrace01(queens, NO_Queen+1);
                queens[NO_Queen][i] = false;
            }
        }

    }
    public boolean preAllFalse(boolean[][] queens,int i){
        bbb++;
        boolean isfalse = false;
        for (int k = 0; k < queens.length && i > 0; k++) {
            isfalse |= queens[i-1][k];
        }
        if (i > 0 && !isfalse) return true;
        return false;
    }

    private boolean canFill(boolean[][] queens, int i, int j) {
        aaa++;

        for (int k = 0; k < queens.length; k++) {
            if (queens[i][k]) return false;
            if (queens[k][j]) return false;
        }

        for (int k = i - 1, m = j - 1; k >= 0 && m >= 0; k--, m--) {
            if (queens[k][m] ){
                return false;
            }
        }
        for (int k = i - 1, m = j + 1; k >= 0 && m < queens.length; k--, m++) {
            if (queens[k][m]){
                return false;
            }
        }
        return true;
    }


}
