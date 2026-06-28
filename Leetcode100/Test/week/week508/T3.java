package Test.week.week508;

public class T3 {
    public long maxSubarraySum(int[] nums, int k) {
        //TODO：贪心做法但是通过717/718用例
        long max = Long.MIN_VALUE;
        long sum = 0;

        boolean allNegative = true;
        int mx = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] >= 0) {
                allNegative = false;
            }
            mx = Math.max(mx, nums[i]);

            if (sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }

            max = Math.max(max, sum);
        }

        // 全是负数
        if (allNegative) {
            return mx / k;
        }

        return max * k;
    }
}