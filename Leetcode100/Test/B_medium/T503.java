package Test.B_medium;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class T503 {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> st = new LinkedList<>();
        int[] res = new int[nums.length];
        Arrays.fill(res,-1);
        int n = nums.length;

        for(int i = 0;i<2*n;i++){
            while (!st.isEmpty()&&nums[i%n]>nums[st.peek()]){
                res[st.peek()] = nums[i%n];
                st.pop();
            }
            st.push(i%n);
        }

        return res;
    }
}
