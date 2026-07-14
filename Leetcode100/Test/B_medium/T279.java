package Test.B_medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 279. 完全平方数
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 *
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。
 * 例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 * https://leetcode.cn/problems/perfect-squares/description/
 */
public class T279 {
    public int numSquares(int n) {
        double sqrt = Math.sqrt((double) n);
        int x = (int) sqrt + 1;
        List<Integer> integers = new ArrayList<>();
        for(int i = 1;i<=x;i++){
            integers.add(i*i);
        }
        int[] ps = integers.stream().mapToInt(Integer::intValue).toArray();
        int[] dp = new int[n+1];
        int max = Integer.MAX_VALUE;
        Arrays.fill(dp, max);
        dp[0] = 0;
        for(int i = 0;i<ps.length;i++){
            for(int j = ps[i];j<=n;j++){
                if(dp[j-ps[i]] != max){
                    dp[j] = Math.min(dp[j], dp[j-ps[i]] + 1);
                }
            }
        }

        // 打印dp数组
        System.out.println("---------------------dp数组--------------------------");
        for(int i : dp){
            System.out.print(i + " ");
        }
        System.out.println();
        return dp[n] == max ? -1 : dp[n];
    }

    public static void main(String[] args) {
        T279 t279 = new T279();
        int res = t279.numSquares(12);
        System.out.println("Result: " + res);
    }
}
