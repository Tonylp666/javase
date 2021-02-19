package arithmetic.dp;

import java.util.Arrays;

public class Rob {
    public static void main(String[] args) {
        Rob rob = new Rob();
        System.out.println(rob.rob(new int[]{2,1}));
    }
    public int rob(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }
        if (nums.length <2){
            return nums[0];
        }
//        return Math.max(myRob02(Arrays.copyOfRange(nums,0,nums.length-1)),myRob02(Arrays.copyOfRange(nums,1,nums.length)));
        return myRob(nums);
    }
    private int myRob02(int[] nums) {
        int pre = 0;
        int cur = 0;
        int tmp;
        for (int item : nums) {
            tmp = cur;
            cur = Math.max(pre + item,cur);
            pre = tmp;
        }
        return cur;
    }

    private int myRob(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        if (nums.length <2){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] =  Math.max(dp[i - 2] + nums[i],dp[i - 1]);
        }
        //System.out.println(Arrays.toString(dp));
        return dp[dp.length-1];
    }
}
