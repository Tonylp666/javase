package arithmetic.dp;

import java.util.Arrays;

public class MinPathSum {
    public static void main(String[] args) {
        int[][] grid = {
                {1,3,1},
                {1,5,2},
                {4,2,1}
        };

        int minPathSum01 = minPathSum01(grid);
        int minPathSum02 = minPathSum02(grid);
        int minPathSum03 = minPathSum02(grid);
        System.out.println(minPathSum01);
        System.out.println(minPathSum02);
        System.out.println(minPathSum03);
    }
    // 时间复杂度 O(m*n),原地修改，不需要额外空间
    public static int minPathSum03(int[][] grid){
        if (grid == null || grid.length==0 || grid[0].length == 0) return 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0){
                    grid[i][j] += grid[i][j-1] ;
                }else if (j == 0){
                    grid[i][j] += grid[i-1][j] ;
                }else{
                    grid[i][j] = Math.min(grid[i][j-1] + grid[i][j],grid[i-1][j] + grid[i][j]);
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
    // 时间复杂度 O(m*n),空间复杂度 O(n)
    public static int minPathSum02(int[][] grid){
        if (grid == null || grid.length==0 || grid[0].length == 0) return 0;
        int[] dp = new int[grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {  dp[0] = grid[0][0];}
                else if (i == 0){
                    dp[j] = dp[j-1] + grid[i][j];
                }else if (j == 0){
                    dp[j] = dp[j] + grid[i][j];
                }else{
                    dp[j] = Math.min(dp[j-1] + grid[i][j],dp[j] + grid[i][j]);
                }
            }
        }
        return dp[grid[0].length - 1];
    }
    // 时间复杂度 O(m*n),空间复杂度 O(m*n)
    public static int minPathSum01(int[][] grid){
        if (grid == null || grid.length==0 || grid[0].length == 0) return 0;
        int[][] dp = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {  dp[0][0] = grid[0][0];}
                else if (i == 0){
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                }else if (j == 0){
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                }else{
                    dp[i][j] = Math.min(dp[i][j-1] + grid[i][j],dp[i-1][j] + grid[i][j]);
                }
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
}
