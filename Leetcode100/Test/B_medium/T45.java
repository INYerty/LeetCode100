package Test.B_medium;
/**
 * 45. 跳跃游戏 II
 *
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置在下标 0。
 * 每个元素 nums[i] 表示从索引 i 向后跳转的最大长度。换句话说，如果你在索引 i 处，你可以跳转到任意 (i + j) 处：
 * * 0 <= j <= nums[i] 且
 * * i + j < n
 * 返回到达 n - 1 的最小跳跃次数。测试用例保证可以到达 n - 1。
 * 提示:
 * * 1 <= nums.length <= 104
 * * 0 <= nums[i] <= 1000
 * * 题目保证可以到达 n - 1
 *
 * 链接：https://leetcode.cn/problems/jump-game-ii/
 */

public class T45 {
    public int jump(int[] nums) {
        int right_site = 0;
        int cur = 0;
        int count = 0;
        if(nums.length == 1) return 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] + i > right_site){
                right_site = nums[i] + i;
            }

            if(right_site >= nums.length-1){
                count++;
                break;
            }

            if(i == cur){
                cur = right_site;
                count++;
            }
        }
        return count;
    }
}