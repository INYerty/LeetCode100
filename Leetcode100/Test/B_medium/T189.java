package Test.B_medium;

import java.util.ArrayDeque;
import java.util.Queue;
/**
 * 189. 轮转数组
 *
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * 提示：
 * * 1 <= nums.length <= 105
 * * -231 <= nums[i] <= 231 - 1
 * * 0 <= k <= 105
 * 进阶：
 * * 尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
 * * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 *
 * 链接：https://leetcode.cn/problems/rotate-array/
 */

public class T189 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = n - k; i < n; i++) {
            queue.add(nums[i]);
        }
        for (int i = 0; i < n - k; i++) {
            queue.add(nums[i]);
        }
        int i = 0;
        while (!queue.isEmpty()) {
            nums[i++] = queue.poll();
        }
    }

    public static void main(String[] args) {
        T189 t = new T189();
        int[] nums = {1,2,3,4,5,6,7};
        t.rotate(nums, 3);
    }

}
