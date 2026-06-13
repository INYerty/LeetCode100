package Test.B_medium;
/**
 * 122. 买卖股票的最佳时机 II
 *
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。
 * 然而，你可以在 同一天 多次买卖该股票，但要确保你持有的股票不超过一股。
 * 返回 你能获得的 最大 利润 。
 * 提示：
 * * 1 <= prices.length <= 3 * 104
 * * 0 <= prices[i] <= 104
 *
 * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
 */

public class T122 {
    public int maxProfit(int[] prices) {
        int[] res = new int[prices.length-1];
        for(int i = 0;i<prices.length-1;i++){
            res[i] = prices[i+1] - prices[i];
        }
        int sum = 0;
        for(int i = 0;i<res.length;i++){
            if(res[i] > 0) sum+=res[i];
        }
        return sum;
    }
}