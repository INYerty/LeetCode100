package Test.B_medium;

import java.util.Arrays;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 *
 *https://leetcode.cn/problems/unique-paths/description/
 */

public class T62 {
    public int uniquePaths(int m, int n) {
        /*if(m==0||n==0) return 0;
        if(m==1||n==1) return 1;
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n ; j++) {
                for(int k = 0;k<=j;k++){
                    dp[i][j] += dp[i-1][k];
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[m-1][n-1];*/

        // way2:
        int[][] dp = new int[m][n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 1;
                }
            }
        }
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                int sum = 0;
                for(int k = 0;k<=j;k++){
                    sum += dp[i-1][k];
                }
                dp[i][j] = sum;
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int m = 3,n=7;
        T62 t62 = new T62();
        System.out.println(t62.uniquePaths(m, n));
    }
}
