package Test.B_medium;

/**
 * 738. 单调递增的数字
 * 已解答
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。
 *
 * 给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。
 *
 * https://leetcode.cn/problems/monotone-increasing-digits/description/
 */

public class T738 {
    public int monotoneIncreasingDigits(int n) {
        String num = String.valueOf(n);
        char[] numsArray = num.toCharArray();
        int right = numsArray.length - 1;
        int left = right - 1;
        while (left >= 0) {
            if (numsArray[right] >= numsArray[left]) {
                right--;
                left--;
            } else {
                numsArray[left]--;
                for (int i = right; i < numsArray.length; i++) {
                    numsArray[i] = '9';
                }
            }
        }
        return Integer.parseInt(String.valueOf(numsArray));
    }
}
