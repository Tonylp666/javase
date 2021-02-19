package arithmetic.Backpack;

import java.util.Arrays;
import java.util.Random;

/**
 * @author liping
 * @date 2021.01.28
 * @decription 背包问题01：0 1 背包
 *              有 N 件物品和一个容量为 V 的背包。放入第 i 件物品耗费的费用是 Ci1，得到的
 *               价值是 Wi。求解将哪些物品装入背包可使价值总和最大。
 */
public class Zero_One_Backpack {

    private int[] weight ;
    private int[] value ;
    private int totalLoad;

    public Zero_One_Backpack(int[] weight, int[] value,int totalLoad) {
        this.weight = weight;
        this.totalLoad = totalLoad;
        this.value = value;
    }

    /**
     *  0 1 背包，每件物品仅一件，可以选择放或者不放。第 i 件物品放进去时背包恰好已满， 状态转移方程：f(i，W) = max(f(i-1，W)，f(i-1，W-wi)+vi);
     *  它表示：将 第 i 件物品放入 背包总负载为 W 时背包已满 获得的最大价值是：不放这个物品背包满与放这个物品背包满 ，两者最大的收益
     * */

    // 时间复杂度 0(n*m), 空间复杂度 0(n*m)
    public int getMaxValue(){
        int[][] dp = new int[weight.length][totalLoad + 1];
        // 初始化 dp 数组
        for (int j = totalLoad ; j >= weight[0] ; j--) {
            dp[0][j] = dp[0][j - weight[0]] + value[0];
        }
        for (int i = 1; i < weight.length; i++) {
            for (int j = 0; j <= totalLoad; j++) {
                if (j < weight[i]){
                    dp[i][j] = dp[i-1][j];
                }else if (j >= weight[i]){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weight[i]]+value[i]);
               }
            }
            //System.out.println(Arrays.toString(dp[i]));
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    // 二维数组降为一维，时间复杂度 0(n*m), 空间复杂度 0(m)
    public int getMaxValue0(){

        int[] dp = new int[totalLoad + 1];
        for (int i = 0; i < weight.length; i++) {
            int w = weight[i]; int v = value[i];
            for(int j = totalLoad; j >= w; j--){
                dp[j] = Math.max(dp[j], dp[j-w] + v);
            }
            //System.out.println(Arrays.toString(dp));
        }
        return dp[totalLoad];
    }

    public static void main(String[] args) {
        int capacity = 100;
        int[] weights = new int[capacity];
        int[] value = new int[capacity];
        for (int i = 1; i < capacity; i++) {
            weights[i] = i;
            value[i] = new Random().nextInt(100);
        }
        int sum = Arrays.stream(weights).sum();
        System.out.println(sum+"+++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(Arrays.toString(weights));
        System.out.println(Arrays.toString(value));

        for (int i = 0; i < 200; i++) {
            Zero_One_Backpack zero_one_backpack = new Zero_One_Backpack(weights, value, i);
            boolean isEqual = zero_one_backpack.getMaxValue() == zero_one_backpack.getMaxValue0();
            if (isEqual){
                System.out.println("i = "+i+"\t"+zero_one_backpack.getMaxValue());
            }else {break;}
            //System.out.println("==================================");
        }
    }

}
