package Test.B_medium;

/**
 * 416. 分割等和子集
 * 已解答
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * https://leetcode.cn/problems/partition-equal-subset-sum/description/
 */
public class T416 {
    public boolean canPartition(int[] nums) {
        if(nums.length == 0) return false;
        int sum = 0;
        for(int i : nums){
            sum+=i;
        }
        if((sum & 1) == 1) return false; // 优于 sum % 2 == 1
        int target = sum / 2;
        // dp[i] 表示 容量为i的背包 最大价值为dp[i]
        int[] dp = new int[target+1];
        for (int i = 1; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-nums[i]] + nums[i]);
            }
        }
        return target == dp[target];
    }
}
