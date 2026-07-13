package Test.B_medium;
/**
 * 322. 零钱兑换
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 * https://leetcode.cn/problems/coin-change/description/
 */
public class T322 {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int[] dp = new int[amount+1];


        int max = Integer.MAX_VALUE;
        //初始化dp数组为最大值
        for (int j = 0; j < dp.length; j++) {
            dp[j] = max;
        }
        dp[0] = 0;
        for(int i = 0;i<=coins.length-1;i++){
            for(int j = coins[i];j<=amount;j++){
                if (dp[j - coins[i]] != max) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }

        // 打印dp
        System.out.println("-----------------打印dp-----------------");
        for(int dpi:dp){
            System.out.print(dpi+" ");
        }
        return dp[amount] == max ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        T322 t = new T322();
        int res = t.coinChange(coins, 11);
        System.out.println(res);
    }
}
