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

public class T53 {
    int maxSubArray(int[] nums) {
        return function(nums, 0, nums.length - 1);
    }

    int function(int[] nums, int left, int right){
        if (left == right) return nums[left];
        int mid = (left+right) / 2;
        int leftMax = function(nums, left, mid);
        int rightMax = function(nums, mid+1, right);
        //中间跨越最大值
        // 从 mid 往左扫，求最大前缀和
        int leftSum = Integer.MIN_VALUE, sum = 0;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            leftSum = Math.max(leftSum, sum);
        }
        // 从 mid+1 往右扫，求最大后缀和
        int rightSum = Integer.MIN_VALUE, sum2 = 0;
        for (int i = mid+1; i <= right; i++) {
            sum2 += nums[i];
            rightSum = Math.max(rightSum, sum2);
        }
        return Math.max(Math.max(leftMax, rightMax),leftSum + rightSum);
    }


    public static void main(String[] args) {
        T53 t = new T53();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(t.maxSubArray(nums));
    }
}


/*
package Test.medium;

public class T53 {
    int maxSubArray(int[] nums) {
        int mid = nums.length / 2,left=0, right = nums.length - 1;
        int leftMax = maxLeftArray(nums, left, mid - 1);
        int rightMax = maxRightArray(nums, mid, right);
        //中间跨越最大值
        // 从 mid 往左扫，求最大前缀和
        int leftSum = Integer.MIN_VALUE, sum = 0;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            leftSum = Math.max(leftSum, sum);
        }
        // 从 mid+1 往右扫，求最大后缀和
        int rightSum = Integer.MIN_VALUE, sum2 = 0;
        for (int i = mid; i <= right; i++) {
            sum2 += nums[i];
            rightSum = Math.max(rightSum, sum2);
        }
        return Math.max(Math.max(leftMax, rightMax),(leftSum + rightSum));
    }

    private int maxRightArray(int[] nums, int mid, int right) {
        int sum = 0;
        int rightSum = Integer.MIN_VALUE;
        for (int i = mid; i < right; i++) {
            sum += nums[i];
            rightSum = Math.max(rightSum, sum);
        }
        return rightSum;
    }

    private int maxLeftArray(int[] nums, int left, int mid) {
        int sum2 = 0;
        int leftSum = Integer.MIN_VALUE;
        for (int i = left; i < mid; i++) {
            sum2 += nums[i];
            leftSum = Math.max(leftSum, sum2);
        }
        return leftSum;
    }


    public static void main(String[] args) {
        T53 t = new T53();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(t.maxSubArray(nums));
    }
}*/