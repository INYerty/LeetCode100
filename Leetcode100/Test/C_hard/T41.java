package Test.C_hard;

import java.util.HashSet;
/**
 * 41. 缺失的第一个正数
 *
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * 提示：
 * * 1 <= nums.length <= 105
 * * -231 <= nums[i] <= 231 - 1
 *
 * 链接：https://leetcode.cn/problems/first-missing-positive/
 */

public class T41 {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int j = 0; j < nums.length; j++) {
            if(set.contains(j+1)){
                continue;
            }else{
                return j+1;
            }
        }
        return nums.length+1;
    }

    public static void main(String[] args) {
        T41 t = new T41();
        int[] nums = {100000, 3, 4000, 2, 15, 1, 99999};
        System.out.println(t.firstMissingPositive(nums));
    }
}