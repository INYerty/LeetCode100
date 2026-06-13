package Test.B_medium;

import java.util.Arrays;
/**
 * 135. 分发糖果
 *
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 * 你需要按照以下要求，给这些孩子分发糖果：
 * * 每个孩子至少分配到 1 个糖果。
 * * 相邻两个孩子中，评分更高的那个会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 * 提示：
 * * n == ratings.length
 * * 1 <= n <= 2 * 104
 * * 0 <= ratings[i] <= 2 * 104
 *
 * 链接：https://leetcode.cn/problems/candy/
 */

public class T135 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        for (int i = 0; i < ratings.length-1; i++) {
            int j = i+1;
            if(ratings[j] > ratings[i]){
                candies[j] = candies[i] + 1;
            }
        }
        for (int i = ratings.length-1; i > 0 ; i--) {
            int j = i-1;
            if(ratings[j] > ratings[i]){
                // 防止覆盖之前从左向右遍历的最大值
                candies[j] = Math.max(candies[j], candies[i] + 1);
            }
        }
        int sum = 0;
        for(int i : candies){
            sum += i;
        }
        return sum;
    }
}