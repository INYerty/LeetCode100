package Test.A_easy;

import java.util.Arrays;

public class T121 {
    public int maxProfit(int[] prices) {
        int min_price = Integer.MAX_VALUE;
        int i = 0;
        for (; i < prices.length; i++) {
            if(prices[i] < min_price) min_price = prices[i];
        }
        int profit = 0;
        for (int j = 0; j < prices.length; j++) {
            if(prices[j] < min_price) return profit;
            else if (prices[j] - min_price > profit) {
                profit = prices[j] - min_price;
            }
        }
        return profit;
    }
}
