package Test.B_medium;

/**
 * 96. 不同的二叉搜索树
 * 已解答
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 *
 * https://leetcode.cn/problems/unique-binary-search-trees/description/
 */
public class T96 {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        dp[0] = 1;
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=i;j++){
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}
