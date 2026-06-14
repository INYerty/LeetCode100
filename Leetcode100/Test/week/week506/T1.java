package Test.week.week506;

/**
 * Q1. 判定好整数
 * 已解答
 * 简单
 * 3 分
 * 给你一个正整数 n。
 *
 * 令 digitSum 表示 n 的各位数字之和，令 squareSum 表示 n 的各位数字平方之和。
 *
 * 如果一个整数满足 squareSum - digitSum >= 50，则称它是 好整数 。
 *
 * 如果 n 是好整数，返回 true；否则，返回 false。
 *
 * https://leetcode.cn/contest/weekly-contest-506/problems/check-good-integer/
 */
public class T1 {
    public boolean checkGoodInteger(int n) {
        String num = String.valueOf(n);
        char[] charArray = num.toCharArray();
        int sum = 0;
        int muti = 0;
        for(char ch:charArray){
            sum += ch-'0';
            muti += (ch-'0')*(ch-'0');
        }
        return muti-sum>=50;
    }
}
