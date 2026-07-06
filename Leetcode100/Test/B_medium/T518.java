package Test.B_medium;

/**
 * 518. 零钱兑换 II
 * 已解答
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 *
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 *
 * 假设每一种面额的硬币有无限个。
 *
 * 题目数据 保证 最终 结果符合 32 位 带符号整数。
 *
 * https://leetcode.cn/problems/coin-change-ii/description/
 */
public class T518 {
    public int change(int amount, int[] coins) {
        if(coins.length == 0) return 0;
        int[] dp = new int[amount+1];
        dp[0] = 1;
        // 先物后包是组合，先包后物是排列
        for(int i = 0;i<coins.length;i++){
            for(int j = coins[i];j<=amount;j++){
                dp[j] += dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
}
