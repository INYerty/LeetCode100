package Test.A_easy;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
/**
 * 496. 下一个更大元素 I
 *
 * nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
 * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 n
 * ums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
 * 返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
 * 提示：
 * * 1 <= nums1.length <= nums2.length <= 1000
 * * 0 <= nums1[i], nums2[i] <= 104
 * * nums1和nums2中所有整数 互不相同
 * * nums1 中的所有整数同样出现在 nums2 中
 * 进阶：你可以设计一个时间复杂度为 O(nums1.length + nums2.length) 的解决方案吗？
 *
 * 链接：https://leetcode.cn/problems/next-greater-element-i/
 */

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