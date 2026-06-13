package Test.daily_question.B_medium;


import java.util.Deque;
import java.util.LinkedList;
/**
 * 2161. 根据给定数字划分数组
 *
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 pivot 。请你将 nums 重新排列，使得以下条件均成立：
 * * 所有小于 pivot 的元素都出现在所有大于 pivot 的元素 之前 。
 * * 所有等于 pivot 的元素都出现在小于和大于 pivot 的元素 中间 。
 * * 小于 pivot 的元素之间和大于 pivot 的元素之间的 相对顺序 不发生改变。
 * * 更正式的，考虑每一对 pi，pj ，pi 是初始时位置 i 元素的新位置，pj 是初始时位置 j 元素的新位置。
 * 如果 i < j 且两个元素 都 小于（或大于）pivot，那么 pi < pj 。
 * 请你返回重新排列 nums 数组后的结果数组。
 * 提示：
 * * 1 <= nums.length <= 105
 * * -106 <= nums[i] <= 106
 * * pivot 等于 nums 中的一个元素。
 *
 * 链接：https://leetcode.cn/problems/partition-array-according-to-given-pivot/
 */

public class T2161 {
    public int[] pivotArray(int[] nums, int pivot) {
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < pivot){
                dq.addFirst(nums[i]);
            } else if (nums[i] == pivot) {
                dq.add(nums[i]);
            } else if (nums[i] > pivot) {
                dq.add(nums[i]);
            }
        }
        return dq.stream().mapToInt(Integer::intValue).toArray();
    }
}