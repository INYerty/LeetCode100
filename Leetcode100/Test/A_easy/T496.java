package Test.A_easy;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class T496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i],i);
        }
        Arrays.fill(res,-1);
        Deque<Integer> st = new LinkedList<>();
        for (int i = 0; i < nums2.length; i++) {
            while(!st.isEmpty()&&nums2[i]>nums2[st.peek()]) {
                Integer pop = st.pop();
                int n2Value = nums2[pop];
                if (map.containsKey(n2Value)){
                    Integer nums1Index = map.get(n2Value);
                    res[nums1Index] = nums2[i];
                }
            }
            st.push(i);
        }
        return res;
    }
}
