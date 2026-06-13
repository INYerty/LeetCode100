package Test.B_medium;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
/**
 * 503. 下一个更大元素 II
 *
 * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更
 * 大元素 。
 * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。
 * 如果不存在，则输出 -1 。
 * 提示:
 * * 1 <= nums.length <= 104
 * * -109 <= nums[i] <= 109
 *
 * 链接：https://leetcode.cn/problems/next-greater-element-ii/
 */

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