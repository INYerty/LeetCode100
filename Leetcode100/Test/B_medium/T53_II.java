package Test.B_medium;

// 贪心做法
public class T53_II {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max_num = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(sum > max_num){
                max_num = sum;
            }
            if(sum < 0){
                sum = 0;
            }
        }
        return max_num;
    }
}
