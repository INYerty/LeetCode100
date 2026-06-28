package Test.week.week508;

import java.util.Arrays;

public class T1 {
    public long maxSum(int[] nums, int k, int mul) {
        long sum = 0;
        Arrays.sort(nums);

        int j = nums.length - 1;

        while (k > 0) {
            if (mul >= 2) {
                sum += 1L * nums[j] * mul;
            } else {
                sum += nums[j];
            }
            mul--;
            j--;
            k--;
        }
        return sum;
    }
}
