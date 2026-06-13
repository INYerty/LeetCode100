package Test.C_hard;

import java.util.Deque;
import java.util.LinkedList;
/**
 * 84. 柱状图中最大的矩形
 *
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 提示：
 * * 1 <= heights.length <=105
 * * 0 <= heights[i] <= 104
 *
 * 链接：https://leetcode.cn/problems/largest-rectangle-in-histogram/
 */

public class T84 {
    public int largestRectangleArea(int[] heights) {
        int[] newHeights = new int[heights.length+2];
        newHeights[0] = 0;
        for (int i = 0; i < heights.length; i++) {
            newHeights[i+1] = heights[i];
        }
        newHeights[newHeights.length-1] = 0;
        Deque<Integer> st = new LinkedList<>();
        int n = newHeights.length;
        int[] res = new int[n];
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            while(!st.isEmpty() && newHeights[i] < newHeights[st.peek()]){
                Integer cur = st.pop();
                if (!st.isEmpty()){
                    int left = st.peek();
                    int h = newHeights[cur];
                    int w = i - left - 1;
                    if(h>0){
                        maxArea = Math.max(maxArea,h*w);
                    }
                }
            }
            st.push(i);
        }
        return maxArea;
    }
}