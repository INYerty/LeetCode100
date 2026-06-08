package Test.B_medium;

public class T55 {
    public boolean canJump(int[] nums) {
        // 记录最右侧的跳跃范围
        int right_site = 0;
        if(nums.length == 1) return true;
        for (int i = 0; i < nums.length; i++) {
            if(i<=right_site) {
                if (nums[i] + i > right_site) {
                    right_site = nums[i] + i;
                }
            }
        }
        return right_site >= nums.length - 1;
    }
}
