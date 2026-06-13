package Test.B_medium;
/**
 * 53. 最大子数组和
 *
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 * 提示：
 * * 1 <= nums.length <= 105
 * * -104 <= nums[i] <= 104
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 *
 * 链接：https://leetcode.cn/problems/maximum-subarray/
 */

// 贪心做法
public class T53_II {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max_num = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(sum > max_num){
                max_num = sum;
            }
            if(sum < 0){
                sum = 0;
            }
        }
        return max_num;
    }
}