package Test.A_easy;

import java.util.Arrays;
/**
 * 1005. K 次取反后最大化的数组和
 *
 * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 * * 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
 * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 * 以这种方式修改数组后，返回数组 可能的最大和 。
 * 提示：
 * * 1 <= nums.length <= 104
 * * -100 <= nums[i] <= 100
 * * 1 <= k <= 104
 *
 * 链接：https://leetcode.cn/problems/maximize-sum-of-array-after-k-negations/
 */

public class T1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < 0 && k>0){
                nums[i] = -nums[i];
                k--;
            }
            // 负数都是正数了 但是k还没用完  如果剩余的k是偶数就不用管 如果是奇数 那就将最小的正数转成负数 再计算和
        }

        if(k%2 == 1){
            Arrays.sort(nums);
            nums[0] = -nums[0];
        }
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        return sum;
    }
}