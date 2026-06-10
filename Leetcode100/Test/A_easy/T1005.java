package Test.A_easy;

import java.util.Arrays;

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
