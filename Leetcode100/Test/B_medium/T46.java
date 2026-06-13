package Test.B_medium;

import java.util.ArrayList;
import java.util.List;
/**
 * 46. 全排列
 *
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 提示：
 * * 1 <= nums.length <= 6
 * * -10 <= nums[i] <= 10
 * * nums 中的所有整数 互不相同
 *
 * 链接：https://leetcode.cn/problems/permutations/
 */

public class T46 {

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backTrace(nums,used);
        return result;
    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public void backTrace(int[] nums,boolean[] used){
        if(path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
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