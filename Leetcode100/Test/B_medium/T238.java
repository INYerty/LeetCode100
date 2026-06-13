package Test.B_medium;
/**
 * 238. 除了自身以外数组的乘积
 *
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除了 nums[i] 之外其余各元素的乘积 。
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内。
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * 提示：
 * * 2 <= nums.length <= 105
 * * -30 <= nums[i] <= 30
 * * 输入 保证 数组 answer[i] 在 32 位 整数范围内
 * 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组 不被视为 额外空间。）
 *
 * 链接：https://leetcode.cn/problems/product-of-array-except-self/
 */

public class T238 {
    public int[] productExceptSelf(int[] nums) {
        int left = 1;
        int right = 1;
        int[] res = new int[nums.length];
         //计算左区间的积
        for (int i = 0; i < nums.length; i++) {
            //这里计算的是每一个nums[i]所对应的左区间的积
            if (i > 0) {
                left *= nums[i - 1];
            }
            //这里直接记录到结果res数组中
            res[i] = left;
        }
        //下面开始计算右面区间的积
        for (int i = nums.length - 1; i >= 0; i--) {
            //这里计算的是每一个nums[i]所对应的右区间的积
            if (i < nums.length - 1) {
                right *= nums[i + 1];
            }
            //这里直接乘到结果res数组中
            res[i] *= right;
        }
        return res;
    }


    public static void main(String[] args) {
        T238 t = new T238();
        int[] nums = {1, 2, 3, 4};
        for (int i : t.productExceptSelf(nums))
            System.out.print(i + " ");
        t.productExceptSelf(nums);

    }
}