package Test.B_medium;

import java.util.Arrays;

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
