package Test.B_medium;
/**
 * 377. 组合总和 Ⅳ
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 *
 * 题目数据保证答案符合 32 位整数范围。
 *
 * https://leetcode.cn/problems/combination-sum-iv/description/
 */
public class T377 {
    public int combinationSum4(int[] nums, int target) {
        if(target == 0) return 1;
        if(nums.length == 0) return 0;
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i = 1;i<=target;i++){
            for(int j = 0;j<nums.length;j++){
                if(i>=nums[j]){
                    dp[i] += dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }
}
