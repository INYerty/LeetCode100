package Test.B_medium;
/**
 * 474. 一和零
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 *
 * 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
 *
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 *
 * https://leetcode.cn/problems/ones-and-zeroes/description/
 */
public class T474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] times = new int[strs.length][2];
        for(int i = 0;i<strs.length;i++){
            int one = 0;
            int zero = 0;
            char[] charArray = strs[i].toCharArray();
            for(char ch : charArray){
                if(ch == '0'){
                    zero++;
                } else if (ch == '1') {
                    one++;
                }
            }
            int[] index = {zero, one};
            times[i] = index;
        }
        /*for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(indexs[i][j]);
            }
            System.out.println();
        }*/

        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;
        for (int i = 0; i < times.length; i++) {
            int[] time = times[i];
            for (int j = m; j >= times[i][0]; j--) {
                for (int k = n; k >= times[i][1] ; k--) {
                    dp[j][k] = Math.max(dp[j-time[0]][k-time[1]] + 1,dp[j][k]);
                }
            }
        }

//        //打印dp
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(dp[i][j]);
//            }
//            System.out.println();
//        }


        return dp[m][n];
    }

    public static void main(String[] args) {
        T474 t474 = new T474();
        String[] str = {"10", "0001", "111001", "1", "0"};
        t474.findMaxForm(str,5,3);
    }
}
