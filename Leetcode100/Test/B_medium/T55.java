package Test.B_medium;
/**
 * 55. 跳跃游戏
 *
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 * 提示：
 * * 1 <= nums.length <= 104
 * * 0 <= nums[i] <= 105
 *
 * 链接：https://leetcode.cn/problems/jump-game/
 */

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