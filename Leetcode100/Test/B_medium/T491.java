package Test.B_medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
/**
 * 491. 非递减子序列
 *
 * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 * 提示：
 * * 1 <= nums.length <= 15
 * * -100 <= nums[i] <= 100
 *
 * 链接：https://leetcode.cn/problems/non-decreasing-subsequences/
 */

public class T491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        backTrace(nums,0);
        return result;
    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public void backTrace(int[] nums,int startIndex){
        if (path.size()>=2) result.add(new ArrayList<>(path));
        if (startIndex>nums.length) return;
        // 单层去重逻辑
        HashSet<Integer> used = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
//            if (startIndex<i && nums[i] == nums[i-1]) continue;
            // 单层去重逻辑path  相等于是set 进行自动的去重
            if (used.contains(nums[i])) continue;
            if (!path.isEmpty() && nums[i] < path.get(path.size()-1)) continue;

            used.add(nums[i]);
            path.add(nums[i]);
            backTrace(nums,i+1);
            path.removeLast();
        }
    }
}