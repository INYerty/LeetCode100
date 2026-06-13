package Test.B_medium;

import java.util.ArrayList;
import java.util.List;
/**
 * 78. 子集
 *
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 提示：
 * * 1 <= nums.length <= 10
 * * -10 <= nums[i] <= 10
 * * nums 中的所有元素 互不相同
 *
 * 链接：https://leetcode.cn/problems/subsets/
 */

public class T78 {
    public List<List<Integer>> subsets(int[] nums) {
        backTrace(nums,0);
        return result;
    }
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public void backTrace(int[] nums,int startIndex){
        result.add(new ArrayList<>(path));
        if (startIndex>=nums.length){
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backTrace(nums,i+1);
            path.removeLast();
        }

    }

}