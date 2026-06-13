package Test.B_medium;
/**
 * 560. 和为 K 的子数组
 *
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 * 提示：
 * * 1 <= nums.length <= 2 * 104
 * * -1000 <= nums[i] <= 1000
 * * -107 <= k <= 107
 *
 * 链接：https://leetcode.cn/problems/subarray-sum-equals-k/
 */

//TODO: 560. 和为 K 的子数组
public class T560 {

    public int subarraySum(int[] nums, int k) {
        int p = 0;
        int sum = 0;
        int count = 0;
        while(p<nums.length){
            sum += nums[p];
            if(sum<k){
                p++;
            }else if(sum>k){
                sum -= nums[p-1];
                if(nums[p]==k){
                    count++;
                }
            }else{
                count++;
                sum-= nums[p-1];
                p++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        T560 t = new T560();
        int[] nums = {1, 2,3};
        int k = 3;
        System.out.println(t.subarraySum(nums, k));
    }
}