package arithmetic.backtrack;

public class Queen_Test {
    //n皇后如何处理？n>=4
    public static int count=0;
    public static int n;
    static long checkCount = 0;
    public static void main(String[] args){
        n = 14;
        boolean[][] board=new boolean[n][n];
        //0就是空 1就是皇后
        long start = System.currentTimeMillis();
        eightQueen(board,0);
        long end = System.currentTimeMillis();
        System.out.println("耗时： " + (end - start));
        System.out.println(count);
        System.out.println(checkCount);
    }
    //解决board在第level层的八皇后问题 level 0~7
    public static void eightQueen(boolean[][] board,int level){
        if(level==n){   //如果递归到了第9行 则当前是一个解
            count++;
        }else{
            //2.遍历当前行 找到所有可能的解
            for(int col=0;col<n;col++){
                //3.判断当前位置是否可以放皇后
                //  3.1 如果可以 则继续往下一行去寻找
                //  3.2 如果不行 则继续判断一下个位置
                if(isNoDanger(board,level,col)){
                    //在赋值皇后之前 先当前行清空
                    board[level][col]=true; //当前给皇后
                    eightQueen(board,level+1);//接着下一行找
                    board[level][col]=false; //当前给皇后
                }
            }
        }
    }
    //判断board当中 x y的位置上是否可以放置一个皇后
    public static boolean isNoDanger(boolean[][] board,int x,int y){
        checkCount++;
        //正上
        for(int r = x-1;r >= 0;r--){
            if(board[r][y]){
                return false;
            }
        }
        //左上
        for(int r = x-1,c = y-1;r >= 0&&c >= 0;r--,c--){
            if(board[r][c]){
                return false;
            }
        }
        //右上
        for(int r=x-1,c=y+1;r>=0&&c<n;r--,c++){
            if(board[r][c]){
                return false;
            }
        }
        return true;
    }

    private static boolean canFill(int[][] queens, int i, int j) {

        for (int k = 0; k < i ; k++) {
            if (queens[k][j] == 1) return false;
        }

/*        for (int k = 0; k < j; k++) {
            if (queens[i][k] == 1) return false;
        }*/
        for (int k = i - 1, m = j - 1; k >= 0 && m >= 0; k--, m--) {
            if (queens[k][m] == 1){
                return false;
            }
        }
        for (int k = i - 1, m = j + 1; k >= 0 && m < queens.length; k--, m++) {
            if (queens[k][m] == 1){
                return false;
            }
        }
        return true;
    }

}
