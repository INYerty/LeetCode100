package Test.B_medium;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 213. 打家劫舍 II
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 *
 * https://leetcode.cn/problems/house-robber-ii/description/
 */
public class T213 {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2;i<nums.length-1;i++){
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }
        int max1 = dp[nums.length-2];

        int[] dp2 = new int[nums.length];
        dp2[1] = nums[1];
        dp2[2] = Math.max(nums[0], nums[1]);
        for(int i = 2;i<nums.length;i++){
            dp2[i] = Math.max(dp2[i-1], nums[i] + dp2[i-2]);
        }
        int max2 = dp2[nums.length-1];

        return Math.max(max2,max1);
    }
}
