package Test.B_medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 47. 全排列 II
 *
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 提示：
 * * 1 <= nums.length <= 8
 * * -10 <= nums[i] <= 10
 *
 * 链接：https://leetcode.cn/problems/permutations-ii/
 */

public class T47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backTrace(nums,used);
        return result;
    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public void backTrace(int[] nums, boolean[] used){
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i>0 && nums[i] == nums[i-1] && used[i-1]) continue;
            if (!used[i]){
                path.add(nums[i]);
                used[i] = true;
                backTrace(nums,used);
                used[i] = false;
                path.removeLast();
            }
        }
    }
}