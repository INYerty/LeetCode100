package Test;

import java.util.HashSet;
/**
 * 268. 丢失的数字
 *
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 * 提示：
 * * n == nums.length
 * * 1 <= n <= 104
 * * 0 <= nums[i] <= n
 * * nums 中的所有数字都 独一无二
 * 进阶：你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题?
 *
 * 链接：https://leetcode.cn/problems/missing-number/
 */

public class T268 {
    public int missingNumber(int[] nums) {
        HashSet<Integer> integers = new HashSet<>(nums.length);
        for (int i = 0; i < nums.length; i++){
            integers.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (integers.contains(i)){
                continue;
            }else{
                return i;
            }
        }
        return nums.length+1;
    }

    public static void main(String[] args) {
        T268 t = new T268();
        int[] nums = {0, 1, 3};
        System.out.println(t.missingNumber(nums));
    }
}