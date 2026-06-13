package Test.B_medium;
/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * 提示：
 * * 0 <= nums.length <= 105
 * * -109 <= nums[i] <= 109
 * * nums 是一个非递减数组
 * * -109 <= target <= 109
 *
 * 链接：https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
 */

public class T34 {
    public int[] searchRange(int[] nums, int target) {
        int leftSite = binarySearch(nums,target,true);
        int rightSite = binarySearch(nums,target,false);
        return new int[] {leftSite,rightSite};
    }

    // 寻找左边界
    public int binarySearch(int[] nums,int target,boolean isLeft){
        int left = 0,right = nums.length-1;
        int index = -1;
        while(left<=right){
            int mid = (left+right)/2;
            if (target>nums[mid]){
                left = mid+1;
            } else if (target<nums[mid]) {
                right = mid-1;
            }else{
                index = mid;
                if(isLeft){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
        }
        return index;
    }

}