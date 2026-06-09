package Test.daily_question.B_medium;

import java.util.Arrays;

public class T3689 {
    public long maxTotalValue(int[] nums, int k) {
        Arrays.sort(nums);
        int max = nums[nums.length-1];
        int min = nums[0];
        return (long)(max-min) * k;
    }
}
