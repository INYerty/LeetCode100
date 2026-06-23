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
 *
 * ********************************************************************************
 *
 *  题解：当 n≤3 时，按照规则应不拆分，但由于题目要求必须拆分，因此必须拆出一个因子 1 ，即返回 n−1 。
 *  当 n>3 时，求 n 除以 3 的 整数部分 a 和 余数部分 b （即 n=3a+b ），并分为以下三种情况：
 *  当 b=0 时，直接返回 3^a
 *   ；
 *  当 b=1 时，要将一个 1+3 转换为 2+2，因此返回 3^a−1
 *   ×4；
 *  当 b=2 时，返回 3^a
 *   ×2。
 *
 *  作者：Krahets
 *  链接：https://leetcode.cn/problems/integer-break/solutions/29098/343-zheng-shu-chai-fen-tan-xin-by-jyd/
 *  来源：力扣（LeetCode）
 *  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */


public class T343 {
    public int integerBreak(int n) {
        /*int[] dp = new int[n+1];
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
        return dp[n];*/


        int a = n/3,b = n%3;
        if(n<=3) return n-1;
        if(b == 0) return (int)Math.pow(3,a);
        if(b == 1) return (int)Math.pow(3,a-1)*4;
        if(b == 2) return (int)Math.pow(3,a)*2;
        return 0;
    }
}
