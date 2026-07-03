package Test.B_medium;

public class T494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(((target + sum) & 1) == 1){return 0;}
        if(Math.abs(target) > sum) return 0;
        int postive = (target + sum)/2; // target 背包
        int negative = target - postive;
        int[] dp = new int[postive+1];
        dp[0] = 1;
        for(int i = 0;i < nums.length;i++){
            for(int j = postive;j>=nums[i];j--){
                dp[j] = dp[j] + dp[j-nums[i]];
            }
        }
        return dp[postive];
    }
}
