package Test.B_medium;
/**
 * 11. 盛最多水的容器
 *
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 * 提示：
 * * n == height.length
 * * 2 <= n <= 105
 * * 0 <= height[i] <= 104
 *
 * 链接：https://leetcode.cn/problems/container-with-most-water/
 */

public class T11 {
    public static void main(String[] args) {
        T11 t = new T11();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        t.maxArea(height);
    }

    public int maxArea(int[] height) {
        int length = height.length;
        int max = 0;
        int area = 0;
        int left = 0;
        int right = length - 1;
        while (left < right) {
            area = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, area);

            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;
    }
}