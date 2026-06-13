package Test.C_hard;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
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

public class T42_II {
    public int trap(int[] height) {
        int n = height.length;
        int sum = 0;
        Deque<Integer> st = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            while(!st.isEmpty() && height[i] > height[st.peek()]){
                int cur = st.pop();
                if (!st.isEmpty()){
                    int h = Math.min(height[i],height[st.peek()]) - height[cur];
                    int w = i - st.peek() - 1;
                    sum += h*w;
                }
            }
            st.push(i);
        }
        return sum;
    }
}