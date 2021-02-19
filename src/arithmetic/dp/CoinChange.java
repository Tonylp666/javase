package arithmetic.dp;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int coinChange = coinChange(new int[]{ 5, 2,1}, 11);
        System.out.println(coinChange);
    }
    public static int coinChange(int[] coins,int amount){
        if (amount < 0){
            return -1;
        }
        if (amount == 0){
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0){
                    dp[i] = Math.min(dp[i],dp[i-coin]+1 );
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[amount] > amount ? -1: dp[amount];
    }
}
