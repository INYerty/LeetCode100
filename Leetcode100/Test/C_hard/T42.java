package Test.C_hard;
/**
 * 42. 接雨水
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 提示：
 * * n == height.length
 * * 1 <= n <= 2 * 104
 * * 0 <= height[i] <= 105
 *
 * 链接：https://leetcode.cn/problems/trapping-rain-water/
 */

public class T42 {
    public static void main(String[] args) {
        int[] height = {2,1,0,2};
        T42 t = new T42();
        t.trap(height);
    }

    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int rainSum = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    rainSum += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    rainSum += rightMax - height[right];
                }
                right--;
            }
        }

//        System.out.println(rainSum);
        return rainSum;
    }
}