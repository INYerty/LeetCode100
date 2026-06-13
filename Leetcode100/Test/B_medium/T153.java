package Test.B_medium;
/**
 * 153. 寻找旋转排序数组中的最小值
 *
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。
 * 例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 * * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2]
 * , ..., a[n-2]] 。
 * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 * 提示：
 * * n == nums.length
 * * 1 <= n <= 5000
 * * -5000 <= nums[i] <= 5000
 * * nums 中的所有整数 互不相同
 * * nums 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
 *
 * 链接：https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/
 */

public class T153 {
    public int findMin(int[] nums){
        int left = 0,right = nums.length-1;

        while(left<=right){
            int mid = (left+right)/2;
            //如果旋转了nums长度次，那么本事就是有序的  返回left即可
            if (nums[left]<=nums[mid] && nums[mid]<=nums[right]) return nums[left];
            if(nums[left]<=nums[mid]){
                // 第一个区间
                left = mid + 1;
            }else{
                // 为什么不是mid-1不是mid, 最小值一定是存在于第二个递增区间中的 mid在第二个递增区间 所以mid可能是最小值
                right = mid;
            }
        }
        return -1;
    }
}