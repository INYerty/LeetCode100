package Test.daily_question.A_easy;

import java.util.Arrays;
/**
 * 2574. 左右元素和的差值
 *
 * 给你一个下标从 0 开始的长度为 n 的整数数组 nums。
 * 定义两个数组 leftSum 和 rightSum，其中：
 * * leftSum[i] 是数组 nums 中下标 i 左侧元素之和。如果不存在对应的元素，leftSum[i] = 0 。
 * * rightSum[i] 是数组 nums 中下标 i 右侧元素之和。如果不存在对应的元素，rightSum[i] = 0 。
 * 返回长度为 n 数组 answer，其中 answer[i] = |leftSum[i] - rightSum[i]|。
 * 提示：
 * * 1 <= nums.length <= 1000
 * * 1 <= nums[i] <= 105
 *
 * 链接：https://leetcode.cn/problems/left-and-right-sum-differences/
 */

public class T2574 {
    public int[] leftRightDifference(int[] nums) {
        int left_sum = 0;
        int[] left_array = new int[nums.length];
        left_array[0] = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            left_array[i + 1] = left_sum + nums[i];
            left_sum += nums[i];
        }
        System.out.println(Arrays.toString(left_array));

        int right_sum = 0;
        int[] right_array = new int[nums.length];
        right_array[nums.length - 1] = 0;
        for (int i = nums.length - 1; i >= 1; i--) {
            right_array[i - 1] = right_sum + nums[i];
            right_sum += nums[i];
        }
        System.out.println(Arrays.toString(right_array));

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = Math.abs(left_array[i] - right_array[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        T2574 t2574 = new T2574();
        int[] arr = {10, 4, 8, 3};
        int[] ints = t2574.leftRightDifference(arr);
        for(int i:ints){
            System.out.print(i+" ");
        }
    }
}