package Test.C_hard;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

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
