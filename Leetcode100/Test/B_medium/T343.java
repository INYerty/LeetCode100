package Test.B_medium;

/**
 * 343. 整数拆分
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 *
 * 返回 你可以获得的最大乘积 。
 *
 * https://leetcode.cn/problems/integer-break/description/
 */
public class T343 {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        if (n < 2) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(Math.max(j*(i-j),j*dp[i-j]),dp[i]);
            }
        }
        return dp[n];
    }
}
