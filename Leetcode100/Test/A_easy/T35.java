package Test.A_easy;
/**
 * 35. 搜索插入位置
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * 提示:
 * * 1 <= nums.length <= 104
 * * -104 <= nums[i] <= 104
 * * nums 为 无重复元素 的 升序 排列数组
 * * -104 <= target <= 104
 *
 * 链接：https://leetcode.cn/problems/search-insert-position/
 */

public class T35 {
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums,0,nums.length-1,target);
    }

    public int binarySearch(int[] nums,int left,int right,int target){
        if (left > right) {
            return left; // 找不到时，left 就是插入位置
        }
        int mid = (left+right)/2;
        if (target>nums[mid]){
            return binarySearch(nums,mid+1,right,target);
        }
        if (target<nums[mid]){
            return binarySearch(nums,left,mid-1,target);
        }else{
            return mid;
        }
    }
}