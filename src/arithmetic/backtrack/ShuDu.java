package arithmetic.backtrack;

import scala.collection.immutable.$colon$colon;

import java.util.Arrays;

public class ShuDu {
    static long count = 0;
    static long cal_count = 0;
    public static void main(String[] args) {
//        int[][] shudu= new int[9][9];
        int[][] shudu = {
                {8, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 3, 6, 0, 0, 0, 0, 0},
                {0, 7, 0, 0, 9, 0, 2, 0, 0},
                {0, 5, 0, 0, 0, 7, 0, 0, 0},
                {0, 0, 0, 0, 4, 5, 7, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 3, 0},
                {0, 0, 1, 0, 0, 0, 0, 6, 8},
                {0, 0, 8, 5, 0, 0, 0, 1, 0},
                {0, 9, 0, 0, 0, 0, 4, 0, 0}
        };
        printShudu(shudu);

        solveShuDu(shudu,0,0);
        if (count <1){
            printShudu(shudu);
        }
        System.out.println("======== count: "+count+" ========");
    }

    static boolean solveShuDu(int[][] chess,int row,int col){

        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess.length; j++) {
                cal_count ++;
                if (chess[i][j] == 0){
                    for (int k = 1; k < 10; k++) {
                        if (canFill(chess,i,j,k)){
                            chess[i][j] = k;
                            if (solveShuDu(chess,i,j)) {
                                printShudu(chess);
                                System.out.println("======== cal_count: "+cal_count+" ========");
                                cal_count = 0;
                                count ++;
                                /**
                                 *  return true : 找到一个满足条件的结，直接返回。
                                 *  如果注释的话，即可以找到所有的满足条件的解。
                                 */
//                                 return true;
                            }
                            chess[i][j] = 0;
                        }
                    }
                    // 1 ~~ 9 都不行，说明此数独无效。
                    return false;
                }
            }
        }
        return true;
    }


    private static boolean canFill(int[][] chess, int row, int col, int k) {

        //判断该行该列是否有重复数字
        for (int l = 0; l < 9 ; l++) {
            if (chess[l][col] == k || chess[row][l] == k){
                return false;
            }
        }
/*        //左上
        for(int r = row - 1,c = col - 1;r >= 0 && c >= 0;r--,c--){
            if(chess[r][c] == k){
                return false;
            }
        }
//        右上
        for(int r = row + 1,c = col + 1;r < 9 && c < 9;r++,c++){
            if(chess[r][c] == k){
                return false;
            }
        }
        //右下
        for(int r = row-1,c = col+1;r >= 0 && c<9 ;r--,c++){
            if(chess[r][c] == k){
                return false;
            }
        }

        //左下
        for(int r = row + 1,c = col - 1;c >= 0 && r < 9 ;r++,c--){
            if(chess[r][c] == k){
                return false;
            }
        }*/

        //判断小九宫格是否有重复
        int tempRow = row / 3;
        int tempLine = col / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (chess[tempRow * 3 + i][tempLine * 3 + j] == k) {
                    return false;
                }
            }
        }
        return true;
    }

    static void printShudu(int[][] shudu){
        System.out.println("===========================");
        for (int i = 0; i < shudu.length; i++) {
            System.out.println(Arrays.toString(shudu[i]));
        }
    }
}
