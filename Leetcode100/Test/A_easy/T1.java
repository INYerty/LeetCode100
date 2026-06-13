package Test.A_easy;

import java.util.Arrays;
/**
 * 1. 两数之和
 *
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 * 你可以按任意顺序返回答案。
 * 提示：
 * * 2 <= nums.length <= 104
 * * -109 <= nums[i] <= 109
 * * -109 <= target <= 109
 * * 只会存在一个有效答案
 * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
 *
 * 链接：https://leetcode.cn/problems/two-sum/
 */

public class T1 {
    public int[] twoSum(int[] nums, int target) {
       for(int i = 0; i < nums.length; i++){
        for(int j = i + 1; j < nums.length; j++){
          if(nums[i] + nums[j] == target){
            return new int [] {i, j};
          }
        }
       }
      return null;
    }
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        T1 t1 = new T1();
        System.out.println(Arrays.toString(t1.twoSum(nums, target)));
    }
}