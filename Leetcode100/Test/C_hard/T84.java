package Test.C_hard;

import java.util.Deque;
import java.util.LinkedList;

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
